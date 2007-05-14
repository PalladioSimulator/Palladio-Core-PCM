/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.context.usage.BranchProbability;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;

/**
 * @author Koziolek
 * 
 */
public class ProbabilisticBranchTransitionHandler extends AbstractBranchTransitionHandler {

	private static Logger logger = Logger.getLogger(ProbabilisticBranchTransitionHandler.class.getName());

	public ProbabilisticBranchTransitionHandler(SeffVisitor seffVisitor) {
		super(seffVisitor);
	}

	public void handle(ProbabilisticBranchTransition bt){
		double branchProb = bt.getBranchProbability();
		logger.debug("BranchProb:" + branchProb);
		storeToUsageContext(bt, branchProb);
		visitChildBehaviour(bt);
	}

}
