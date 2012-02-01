/**
 *
 */
package de.fzi.se.validation.effort.workflow;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsJob;


/**Load all PCM-Models which are necessary for the validation of individual behaviours within a {@link Repository}.
 * Please note that the necessary information differs from a prediction. Use {@link LoadPCMModelsJob} for predictions.
 *
 * @author groenda
 *
 */
public class LoadPCMModelForValidationJob extends
		OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements IJob, IBlackboardInteractingJob<MDSDBlackboard>{
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(LoadPCMModelForValidationJob.class);

	/** Name of this job. */
	public static final String NAME = "Load PCM Model(s) for behaviour validation job";

	/** Blackboard used to store the PCM model(s). */
	private MDSDBlackboard blackboard;
	/** Configuration. */
	private EstimatorConfiguration configuration = null;

	/**Constructor.
	 * @param configuration The configuration.
	 */
	public LoadPCMModelForValidationJob(EstimatorConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka.ipd.sdq.workflow.Blackboard)
	 */
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("deprecation")
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		ResourceSetPartition pcmPartition = this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

		// Load the PCM model itself
		logger.info("Loading PCM models");
		pcmPartition.loadModel(configuration.getBehaviourURI());
		pcmPartition.resolveAllProxies();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.AbstractCompositeJob#getName()
	 */
	@Override
	public String getName() {
		return LoadPCMModelForValidationJob.NAME;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.AbstractCompositeJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// nothing to do
	}
}
