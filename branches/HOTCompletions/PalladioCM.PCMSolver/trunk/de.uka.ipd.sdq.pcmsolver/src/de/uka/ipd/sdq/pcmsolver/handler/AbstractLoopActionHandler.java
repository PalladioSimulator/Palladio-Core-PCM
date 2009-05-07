package de.uka.ipd.sdq.pcmsolver.handler;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;

public abstract class AbstractLoopActionHandler {

	private static Logger logger = Logger.getLogger(AbstractLoopActionHandler.class.getName());

	protected ComputedUsageFactory usageFactory = ComputedUsageFactory.eINSTANCE;

	protected SeffVisitor visitor;

	/**
	 * @param context
	 * @param _visitor
	 * @param nextHandler
	 */
	public AbstractLoopActionHandler(SeffVisitor seffVisitor) {
		visitor = seffVisitor;
	}

	/**
	 * @param loop
	 * @param solvedIterationCountExpr
	 */
	protected void visitLoopBody(AbstractLoopAction loop, String iterationCountSpecification) {
		Expression solvedIterationCountExpr = ExpressionHelper
				.parseToExpression(iterationCountSpecification);
		
//		int lowerBound = 0;
//		int upperBound = getUpperBound(solvedIterationCountExpr);
		
		ResourceDemandingBehaviour loopBody = loop.getBodyBehaviour_Loop();
		if (loopBody!=null){
			visitor.doSwitch(loopBody);
			
// TODO: loops adequately modelled?
//			visitor.getMyContext().getCurrentLoopIterationNumber().add(lowerBound);
//
//			for (int i=lowerBound; i<upperBound; i++){
//				//logger.debug("Loop Execution Number "+i);
//				ArrayList curLoop = visitor.getMyContext().getCurrentLoopIterationNumber();
//				curLoop.remove(curLoop.size()-1); // delete last element
//				curLoop.add(i); // add current loop iteration number to scope
//				
//				visitor.doSwitch(loopBody); // is this really necessary? (TODO)
//				// The loop body gets visited as many times as the loop count specifies.
//				// This implies that a usage context will be created for each number
//				// of loop iteration (if there's an external call within the loop), 
//				// which might lead to a huge number of contexts 
//				// for large iteration numbers and thus memory problems.
//			}
//			ArrayList curLoop = visitor.getMyContext().getCurrentLoopIterationNumber();
//			curLoop.remove(curLoop.size()-1);
		}
	}

	/**
	 * @param solvedLoopCountExpr
	 * @param upperBound
	 * @return
	 */
	public int getUpperBound(Expression solvedLoopCountExpr) {
		int upperBound = 0;
		if (solvedLoopCountExpr instanceof IntLiteral) {
			IntLiteral loopInt = (IntLiteral) solvedLoopCountExpr;
			upperBound = loopInt.getValue();
		} else if (solvedLoopCountExpr instanceof ProbabilityFunctionLiteral) {
			ProbabilityFunctionLiteral loopProbLiteral = (ProbabilityFunctionLiteral) solvedLoopCountExpr;
			if (loopProbLiteral.getFunction_ProbabilityFunctionLiteral() instanceof ProbabilityMassFunction){
				ProbabilityMassFunction loopPMF = (ProbabilityMassFunction) loopProbLiteral
						.getFunction_ProbabilityFunctionLiteral();
				EList<Sample> sampleList = loopPMF.getSamples();
				Sample lastSample = sampleList.get(sampleList.size() - 1);
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
	 * @param loop
	 * @param solvedSpecification
	 */
	protected void storeToUsageContext(AbstractLoopAction loop, String solvedSpecification) {
		LoopIteration loopIteration = usageFactory.createLoopIteration();
		loopIteration.setLoopaction_LoopIteration(loop);
		PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
		rv.setSpecification(solvedSpecification);
		loopIteration.setSpecification_LoopIteration(rv);
		
		visitor.getContextWrapper().getCompUsgCtx().getLoopiterations_ComputedUsageContext().add(loopIteration);
	}

	
}
