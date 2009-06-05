/**
 * 
 */
package de.uka.ipd.sdq.pcmsolver.handler;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;

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
		logger.info("BranchProb:" + branchProb);
		storeToUsageContext(bt, branchProb);
		visitChildBehaviour(bt);
	}

}
