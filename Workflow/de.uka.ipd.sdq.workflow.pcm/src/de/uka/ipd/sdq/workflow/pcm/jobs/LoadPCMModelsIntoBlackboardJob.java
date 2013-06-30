package de.uka.ipd.sdq.workflow.pcm.jobs;

import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * A job to be used in the SDQ workflow engine which fully loads a PCM model instance into two MDSDBlackboard partitions.
 * The first partition contains the plain PCM model instance, the second one contains parametric middleware completion
 * components.
 *
 * @author Steffen Becker
 */
public class LoadPCMModelsIntoBlackboardJob
extends SequentialBlackboardInteractingJob<MDSDBlackboard>
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	/**
	 * ID of the blackboard partition containing the fully loaded PCM instance. The blackboard partition is
	 * ensured to be of type {@link PCMResourceSetPartition}
	 */
	public static final String PCM_MODELS_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition";

	/**
	 * ID of the blackboard partition containing the fully loaded parametric middleware completions. The blackboard partition is
	 * ensured to be of type {@link PCMResourceSetPartition}
	 */
	public static final String MIDDLEWARE_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition.middleware";

	/**
	 * ID of the blackboard partition containing the fully loaded parametric event middleware completions.
	 * The blackboard partition is ensured to be of type {@link PCMResourceSetPartition}
	 */
	public static final String EVENT_MIDDLEWARE_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition.eventmiddleware";

	/**
	 * Constructor of the PCM loader job
	 * @param config A PCM workflow configuration containing the list of URIs where to find the PCM model files
	 */
	public LoadPCMModelsIntoBlackboardJob(AbstractPCMWorkflowRunConfiguration config) {
		super(false);
		this.add(new PreparePCMBlackboardPartionJob());
		this.add(new LoadPCMModelsJob(config));
		// store models in temporary eclipse plug-in
		this.add(new CreatePluginProjectJob(config));
		this.add(new CreateWorkingCopyOfModelsJob(config));
	}
}
