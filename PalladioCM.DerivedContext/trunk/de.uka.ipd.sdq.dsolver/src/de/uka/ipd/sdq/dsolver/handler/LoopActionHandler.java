/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.context.usage.LoopIteration;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.visitors.ExpressionSolveVisitor;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.stochasticexpressions.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;

/**
 * @author Koziolek
 *
 */
public class LoopActionHandler extends AbstractHandler {
	
	private static Logger logger = Logger.getLogger(LoopActionHandler.class.getName());

	private UsageFactory usageFactory;

	private StochasticsFactory stochasticsFactory;
	
	private SeffVisitor visitor;

	private Context myContext;
	
	/**
	 * @param context
	 * @param _visitor
	 * @param nextHandler
	 */
	public LoopActionHandler(Context context, SeffVisitor _visitor,
			AbstractHandler nextHandler) {
		myContext = context;
		visitor = _visitor;
		successor = nextHandler;
		usageFactory = UsageFactory.eINSTANCE;
		stochasticsFactory = StochasticsFactory.eINSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.dsolver.handler.AbstractHandler#handle(org.eclipse.emf.ecore.EObject)
	 */
	public void handle(EObject object) {
		if (object instanceof LoopAction) {
			handle((LoopAction) object);
		} else {
			if (successor != null)
				successor.handle(object);
		}
	}
	
	/**
	 * @param loop
	 */
	private void handle(LoopAction loop) {
		Expression solvedIterationCountExpr = solveDependenciesIterationCount(loop);
		
		storeToUsageContext(loop, solvedIterationCountExpr);
		
		visitLoopBody(loop, solvedIterationCountExpr);
	}

	/**
	 * @param loop
	 * @param solvedIterationCountExpr
	 */
	private void visitLoopBody(LoopAction loop, Expression solvedIterationCountExpr) {
		int lowerBound = 0;
		int upperBound = getUpperBound(solvedIterationCountExpr);
		
		myContext.getCurrentLoopIterationNumber().add(lowerBound);
		
		ResourceDemandingBehaviour loopBody = loop.getBodyBehaviour_Loop();
		for (int i=lowerBound; i<upperBound; i++){
			logger.debug("Loop Execution Number "+i);
			ArrayList curLoop = myContext.getCurrentLoopIterationNumber();
			curLoop.remove(curLoop.size()-1); // delete last element
			curLoop.add(i); // add current loop iteration number to scope
			
			visitor.doSwitch(loopBody); // is this really necessary? (TODO)
			// The loop body gets visited as many times as the loop count specifies.
			// This implies that a usage context will be created for each number
			// of loop iteration (if there's an external call within the loop), 
			// which might lead to a huge number of contexts 
			// for large iteration numbers and thus memory problems.
		}
		ArrayList curLoop = myContext.getCurrentLoopIterationNumber();
		curLoop.remove(curLoop.size()-1);
	}

	/**
	 * @param loop
	 * @param solvedIterationCountExpr
	 */
	private void storeToUsageContext(LoopAction loop, Expression solvedIterationCountExpr) {
		RandomVariable rv = stochasticsFactory.createRandomVariable();
		ProbFunctionPrettyPrint printer = new ProbFunctionPrettyPrint();
		ProbabilityFunctionLiteral solvedLiteral = (ProbabilityFunctionLiteral) solvedIterationCountExpr;
		ProbabilityFunction solvedFunction = solvedLiteral
				.getFunction_ProbabilityFunctionLiteral();
		String loopSpecification = (String) printer.doSwitch(solvedFunction);
		rv.setSpecification(loopSpecification);
		
		LoopIteration loopIteration = usageFactory.createLoopIteration();
		loopIteration.setLoopaction_LoopIteration(loop);
		loopIteration.setIterations_LoopIteration(rv);
		myContext.getUsageContext().getLoopiterations_UsageContext().add(loopIteration);
	}

	/**
	 * @param loop
	 * @return
	 */
	private Expression solveDependenciesIterationCount(LoopAction loop) {
		Expression loopCountExpr = loop.getIterations_LoopAction()
				.getSpecification_RandomVariable();
		ExpressionSolveVisitor loopCountVisitor = new ExpressionSolveVisitor(
				loopCountExpr);
		Expression solvedLoopCountExpr = (Expression) loopCountVisitor
				.doSwitch(loopCountExpr);
		return solvedLoopCountExpr;
	}

	/**
	 * @param solvedLoopCountExpr
	 * @param upperBound
	 * @return
	 */
	private int getUpperBound(Expression solvedLoopCountExpr) {
		int upperBound = 0;
		if (solvedLoopCountExpr instanceof IntLiteral) {
			IntLiteral loopInt = (IntLiteral) solvedLoopCountExpr;
			upperBound = loopInt.getValue();
		} else if (solvedLoopCountExpr instanceof ProbabilityFunctionLiteral) {
			ProbabilityFunctionLiteral loopProbLiteral = (ProbabilityFunctionLiteral) solvedLoopCountExpr;
			if (loopProbLiteral.getFunction_ProbabilityFunctionLiteral() instanceof ProbabilityMassFunction){
				ProbabilityMassFunction loopPMF = (ProbabilityMassFunction) loopProbLiteral
						.getFunction_ProbabilityFunctionLiteral();
				EList sampleList = loopPMF.getSamples();
				Sample lastSample = (Sample) sampleList.get(sampleList.size() - 1);
				if (lastSample.getValue() instanceof Integer){
					upperBound = ((Integer) lastSample.getValue()).intValue();
				} else {
					logger.error("Could not determine upper bound for executing loop " +
							"(PMF for loop count does not contain integer values). " +
					"Skipping execution of loop body.");
				}
			} else {
				logger.error("Could not determine upper bound for executing loop " +
						"(loop count is prob function, but not PMF)." +
				"Skipping execution of loop body.");
			}
		} else {
			logger.error("Could not determine upper bound for executing loop " +
					"(loop count neither Integer nor PMF). " +
					"Skipping execution of loop body.");
		}
		return upperBound;
	}

	/**
	 * @param iterations
	 * @return
	 */
	private Expression parseLoopIterations(String iterations) {
		EObject value = null;

		try {
			StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
					new StringBufferInputStream(iterations));
			StochasticExpressionsParser parser = new StochasticExpressionsParser(
					lexer);
			value = parser.expression();
		} catch (RecognitionException e) {
			logger.error("ParserError: " + e.getMessage());
			return null;
		} catch (TokenStreamException e) {
			logger.error("ParserError: " + e.getMessage());
			return null;
		}
		return (Expression) value;
	}
}
