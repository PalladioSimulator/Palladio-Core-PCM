package de.uka.ipd.sdq.workflow.pcm.jobs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Loads the PCM models given in the configuration into a MDSD blackboard and store the models in a
 * temporary eclipse project. The temporary storage allows to transform and modify input PCM models
 * without a modification of the source models and can be accessed after the analysis to check the
 * model used in the analysis.
 * 
 * @author groenda
 *
 */
public class LoadPCMModelsJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> implements IJob,
        IBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(LoadPCMModelsJob.class);
    private MDSDBlackboard blackboard;
    private AbstractPCMWorkflowRunConfiguration configuration = null;

    public LoadPCMModelsJob(final AbstractPCMWorkflowRunConfiguration configuration) {
        super(false);
        this.configuration = configuration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka.ipd.sdq.workflow.
     * Blackboard)
     */
    @Override
    public void setBlackboard(final MDSDBlackboard blackboard) {
        this.blackboard = blackboard;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        final ResourceSetPartition pcmPartition = this.blackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

        // Load the PCM model itself
        if (LOGGER.isEnabledFor(Level.INFO))
            LOGGER.info("Loading PCM models");
        for (final String modelFile : this.configuration.getPCMModelFiles()) {
            pcmPartition.loadModel(modelFile);
        }
        pcmPartition.loadModel(this.configuration.getRMIMiddlewareFile());
        pcmPartition.loadModel(this.configuration.getEventMiddlewareFile());
        pcmPartition.resolveAllProxies();
    }

    @Override
    public String getName() {
        return "Perform PCM Model Load";
    }

    @Override
    public void cleanup(final IProgressMonitor monitor) throws CleanupFailedException {
    }
}
