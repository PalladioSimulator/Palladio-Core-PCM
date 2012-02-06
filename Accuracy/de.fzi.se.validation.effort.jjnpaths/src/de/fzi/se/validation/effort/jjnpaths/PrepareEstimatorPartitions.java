/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**Workflow job for handling the partitions responsible to store control-flow graphs, configuration information, and estimation results for JJn-Paths estimations.
 * @author groenda
 *
 */
public class PrepareEstimatorPartitions implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {
	/** Name of the workflow job. */
	public static final String NAME = "Prepare blackboard partitions for JJn-Paths effort estimation job";

	/** Blackboard partition ID for the control-flow graph descriptions. */
	public static final String CFG_PARTITION_ID = "de.fzi.se.validation.effort.jjnpaths.partition";
	/** Blackboard partition ID for the configuration of control-flow graph JJn-Paths generation. */
	public static final String CFG_CONFIGURATION_PARTITION_ID = "de.fzi.se.validation.effort.jjnpaths.partition.configuration";
	/** Blackboard partition ID for estimation results. */
	public static final String ESTIMATION_RESULT_PARTITION_ID = "de.fzi.se.validation.effort.estimation";

	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(PrepareEstimatorPartitions.class);

	/** Blackboard used by this class. */
	private MDSDBlackboard blackboard;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		logger.debug("Creating PCM Model Partition");
		ResourceSetPartition cfdPartition = new ResourceSetPartition();
		this.blackboard.addPartition(CFG_PARTITION_ID, cfdPartition);
		ResourceSetPartition cfdConfigurationPartition = new ResourceSetPartition();
		this.blackboard.addPartition(CFG_CONFIGURATION_PARTITION_ID, cfdConfigurationPartition);
		ResourceSetPartition resultPartition = new ResourceSetPartition();
		this.blackboard.addPartition(ESTIMATION_RESULT_PARTITION_ID, resultPartition);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	@Override
	public String getName() {
		return PrepareEstimatorPartitions.NAME;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		this.blackboard.removePartition(CFG_PARTITION_ID);
		this.blackboard.removePartition(CFG_CONFIGURATION_PARTITION_ID);
		this.blackboard.removePartition(ESTIMATION_RESULT_PARTITION_ID);

	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
