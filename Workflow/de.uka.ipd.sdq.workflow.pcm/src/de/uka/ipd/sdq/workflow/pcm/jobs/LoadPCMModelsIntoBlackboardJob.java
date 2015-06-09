package de.uka.ipd.sdq.workflow.pcm.jobs;

import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * A job to be used in the SDQ workflow engine which fully loads a PCM model instance into different
 * MDSDBlackboard partitions. The first partition contains the plain PCM model instance, the second
 * one contains parametric middleware completion components, etc.
 * 
 * @author Steffen Becker, Sebastian Lehrig
 */
public class LoadPCMModelsIntoBlackboardJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> implements IJob,
        IBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * ID of the blackboard partition containing the fully loaded PCM instance. The blackboard
     * partition is ensured to be of type {@link PCMResourceSetPartition}
     */
    public static final String PCM_MODELS_PARTITION_ID = "org.palladiosimulator.pcmmodels.partition";

    /**
     * Constructor of the PCM loader job
     * 
     * @param config
     *            A PCM workflow configuration containing the list of URIs where to find the PCM
     *            model files
     */
    public LoadPCMModelsIntoBlackboardJob(final AbstractPCMWorkflowRunConfiguration config) {
        super(false);
        this.add(new PreparePCMBlackboardPartitionJob());
        this.add(new LoadPCMModelsJob(config));
    }
}
