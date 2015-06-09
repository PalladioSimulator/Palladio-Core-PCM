package de.uka.ipd.sdq.workflow.pcm.jobs;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Creates and fills the PCM model partition.
 * 
 * @author Sebastian Lehrig
 */
public class PreparePCMBlackboardPartitionJob implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

    private static final Logger LOGGER = Logger.getLogger(PreparePCMBlackboardPartitionJob.class);
    private MDSDBlackboard blackboard;

    public static final URI PCM_PALLADIO_RESOURCE_TYPE_URI = URI
            .createURI("pathmap://PCM_MODELS/Palladio.resourcetype");
    public static final URI PCM_PALLADIO_PRIMITIVE_TYPE_REPOSITORY_URI = URI
            .createURI("pathmap://PCM_MODELS/PrimitiveTypes.repository");

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating PCM Model Partition");
        }
        final PCMResourceSetPartition pcmPartition = new PCMResourceSetPartition();
        this.blackboard.addPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, pcmPartition);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initializing PCM EPackages");
        }
        pcmPartition.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);

        pcmPartition.loadModel(PCM_PALLADIO_PRIMITIVE_TYPE_REPOSITORY_URI);
        pcmPartition.loadModel(PCM_PALLADIO_RESOURCE_TYPE_URI);
    }

    @Override
    public String getName() {
        return "Prepare PCM Blackboard Partions";
    }

    @Override
    public void cleanup(final IProgressMonitor monitor) throws CleanupFailedException {
        this.blackboard.removePartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
    }

    @Override
    public void setBlackboard(final MDSDBlackboard blackboard) {
        this.blackboard = blackboard;
    }

}
