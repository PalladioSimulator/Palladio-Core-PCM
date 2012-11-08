package de.uka.ipd.sdq.workflow.pcm.jobs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**Loads the PCM models given in the configuration into a MDSD blackboard and store the models in a temporary eclipse project.
 * The temporary storage allows to transform and modify input PCM models without a modification of the source models and
 * can be accessed after the analysis to check the model used in the analysis.
 * @author groenda
 *
 */
public class LoadPCMModelsJob extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard>
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {
	private static final Logger logger = Logger.getLogger(LoadPCMModelsJob.class);
	private MDSDBlackboard blackboard;
	private AbstractPCMWorkflowRunConfiguration configuration = null;

	public LoadPCMModelsJob(AbstractPCMWorkflowRunConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka.ipd.sdq.workflow.Blackboard)
	 */
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		ResourceSetPartition pcmPartition = this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		ResourceSetPartition middlewarePartition = this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.MIDDLEWARE_PARTITION_ID);
		ResourceSetPartition eventMiddlewarePartition = this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.EVENT_MIDDLEWARE_PARTITION_ID);

		// Load the PCM model itself
		if(logger.isEnabledFor(Level.INFO))
			logger.info("Loading PCM models");
		for (String modelFile : configuration.getPCMModelFiles()) {
			pcmPartition.loadModel(modelFile);
		}
		pcmPartition.resolveAllProxies();

		// load the middleware completion
		if(logger.isEnabledFor(Level.INFO))
			logger.info("Loading middleware completion models");
//		middlewarePartition.loadModel(configuration.getMiddlewareFile());
//		middlewarePartition.resolveAllProxies();

		// load the event middleware repository
		if(logger.isEnabledFor(Level.INFO))
			logger.info("Loading event middleware models");
//		eventMiddlewarePartition.loadModel(configuration.getEventMiddlewareFile());
//		eventMiddlewarePartition.resolveAllProxies();
	}

	@Override
	public String getName() {
		return "Perform PCM Model Load";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
	}
}
