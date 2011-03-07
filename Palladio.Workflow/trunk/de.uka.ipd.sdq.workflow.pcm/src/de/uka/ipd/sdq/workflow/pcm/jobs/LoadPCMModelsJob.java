package de.uka.ipd.sdq.workflow.pcm.jobs;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public class LoadPCMModelsJob
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
		
		// Load the PCM model and its middleware completions
		logger.info("Loading PCM Model Files");
		for (String modelFile : configuration.getPCMModelFiles()) {
			pcmPartition.loadModel(modelFile);
		}
		pcmPartition.resolveAllProxies();
		middlewarePartition.loadModel(configuration.getMiddlewareFile());
		middlewarePartition.resolveAllProxies();
		
		// load the event middleware repository
		eventMiddlewarePartition.loadModel(configuration.getEventMiddlewareFile());
		eventMiddlewarePartition.resolveAllProxies();
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
