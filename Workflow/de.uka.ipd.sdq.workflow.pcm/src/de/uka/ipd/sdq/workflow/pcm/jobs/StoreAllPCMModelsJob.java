package de.uka.ipd.sdq.workflow.pcm.jobs;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Job to store the loaded PCM models.
 *
 * Prerequisite of this job:
 * The working copy must have been created. E.g. by {@link CreateWorkingCopyOfModelsJob}.
 *
 * @author groenda
 *
 */
public class StoreAllPCMModelsJob implements IJob,
	IBlackboardInteractingJob<MDSDBlackboard> {

	/** The logger for this class */
	private static final Logger LOGGER = Logger.getLogger(StoreAllPCMModelsJob.class);

	/** The blackboard to interact with */
	private MDSDBlackboard blackboard = null;

	/**
	 * Constructor requiring the necessary configuration object.
	 *
	 * @param configuration The configuration for this job.
	 */
	public StoreAllPCMModelsJob(AbstractPCMWorkflowRunConfiguration configuration) {
	}

	/**
	 * Execute this job and create the model copy.
	 */
	@Override
    public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {

		PCMResourceSetPartition partition = (PCMResourceSetPartition) this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		try {
			partition.storeAllResources();
		} catch (IOException e) {
			if(LOGGER.isEnabledFor(Level.ERROR)) {
                LOGGER.error("unable to store all resources",e);
            }
			throw new JobFailedException("Unable to store all Resources",e);
		}
	}

	@Override
    public String getName() {
		return "Update working copy of models";
	}

	@Override
    public void cleanup(IProgressMonitor monitor)
			throws CleanupFailedException {
		// nothing to clean up
	}

	@Override
    public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
