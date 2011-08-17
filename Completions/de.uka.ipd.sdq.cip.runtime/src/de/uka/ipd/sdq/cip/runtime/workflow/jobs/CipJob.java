package de.uka.ipd.sdq.cip.runtime.workflow.jobs;

import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.cip.runtime.runconfig.CipConfiguration;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * 
 */

/**
 * @author thomass
 *
 */
public class CipJob extends
		OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	public CipJob(CipConfiguration config, ILaunch launch) {
		super();
		
	}

}
