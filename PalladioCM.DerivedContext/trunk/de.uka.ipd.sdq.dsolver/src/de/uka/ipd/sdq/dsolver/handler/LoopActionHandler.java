/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

import antlr.RecognitionException;
import antlr.TokenStreamException;

import de.uka.ipd.sdq.context.usage.LoopIteration;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.visitors.SeffSwitchDSolver;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;

/**
 * @author Koziolek
 *
 */
public class LoopActionHandler extends AbstractHandler {
	
	private static Logger logger = Logger.getLogger(LoopActionHandler.class.getName());

	private UsageFactory usageFactory;

	private StochasticsFactory stochasticsFactory;
	
	private SeffSwitchDSolver visitor;

	private Context myContext;

	/**
	 * @param context
	 * @param _visitor
	 * @param nextHandler
	 */
	public LoopActionHandler(Context context, SeffSwitchDSolver _visitor,
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
		ResourceDemandingBehaviour loopBody = loop.getBodyBehaviour_Loop();
		// TODO: solve dependencies
		String iterations = loop.getIterations();
		RandomVariable rv = stochasticsFactory.createRandomVariable();
		
		//Expression expr = parseLoopIterations(iterations);
		//ProbabilityDistributionFunction pdf = convert(expr);
		
		rv.setSpecification(iterations); // TODO: fix here
		
		LoopIteration loopIteration = usageFactory.createLoopIteration();
		loopIteration.setLoopaction_LoopIteration(loop);
		loopIteration.setIterations_LoopIteration(rv);
		myContext.getUsageContext().getLoopiterations_UsageContext().add(loopIteration);
		
		// TODO: read out random variable and execute loop
		int lowerBound = 0;
		//int upperBound = Integer.parseInt(iterations);
		int upperBound = 10;
		myContext.getCurrentLoopIterationNumber().add(lowerBound);
		
		for (int i=lowerBound; i<upperBound; i++){
			ArrayList curLoop = myContext.getCurrentLoopIterationNumber();
			curLoop.remove(curLoop.size()-1); // delete last element
			curLoop.add(i); // add current loop iteration number
			
			visitor.doSwitch(loopBody); // is this really necessary?
		}
		ArrayList curLoop = myContext.getCurrentLoopIterationNumber();
		curLoop.remove(curLoop.size()-1);
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
