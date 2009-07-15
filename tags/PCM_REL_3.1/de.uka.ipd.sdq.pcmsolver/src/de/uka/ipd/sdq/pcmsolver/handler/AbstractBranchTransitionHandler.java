package de.uka.ipd.sdq.pcmsolver.handler;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;

public abstract class AbstractBranchTransitionHandler {

	private static Logger logger = Logger.getLogger(AbstractBranchTransitionHandler.class.getName());

	protected ComputedUsageFactory usageFactory = ComputedUsageFactory.eINSTANCE;

	
	protected SeffVisitor visitor;

	/**
	 * @param context
	 * @param _visitor
	 * @param nextHandler
	 */
	public AbstractBranchTransitionHandler(SeffVisitor seffVisitor) {
		visitor = seffVisitor;
	}
	
	/**
	 * @param bt
	 */
	protected void visitChildBehaviour(AbstractBranchTransition bt) {
		ResourceDemandingBehaviour rdb = bt
				.getBranchBehaviour_BranchTransition();
		if (rdb != null){
			visitor.doSwitch(rdb);
		}
	}

	/**
	 * @param bt
	 * @param solvedBranchProb
	 */
	protected void storeToUsageContext(AbstractBranchTransition bt, double solvedBranchProb) {
		BranchProbability prob = usageFactory.createBranchProbability();
		prob.setBranchtransition_BranchProbability(bt);
		prob.setProbability(solvedBranchProb);

		visitor.getContextWrapper().getCompUsgCtx().getBranchProbabilities_ComputedUsageContext().add(prob);
	}
}
