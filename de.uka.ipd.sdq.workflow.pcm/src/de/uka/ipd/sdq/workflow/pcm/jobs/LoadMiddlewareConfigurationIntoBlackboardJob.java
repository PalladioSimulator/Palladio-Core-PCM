package de.uka.ipd.sdq.workflow.pcm.jobs;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public class LoadMiddlewareConfigurationIntoBlackboardJob 
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	private Logger logger = Logger.getLogger(LoadPCMModelsIntoBlackboardJob.class);
	
	public static final String MIDDLEWARE_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition.middleware";
	public static final String EVENT_MIDDLEWARE_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition.eventmiddleware";

	private MDSDBlackboard blackboard = null;
	private AbstractPCMWorkflowRunConfiguration configuration = null;

	public LoadMiddlewareConfigurationIntoBlackboardJob(AbstractCodeGenerationWorkflowRunConfiguration config) {
		super();
		
		this.configuration  = config;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		ResourceSetPartition middlewareRepositoryPartition = null;
		if (!this.blackboard.hasPartition(MIDDLEWARE_PARTITION_ID)) {
			if(logger.isDebugEnabled())
				logger.debug("Creating Middleware Repository Partition");
			
			middlewareRepositoryPartition = new ResourceSetPartition();
			this.blackboard.addPartition(MIDDLEWARE_PARTITION_ID, middlewareRepositoryPartition);
			
			if(logger.isDebugEnabled())
				logger.debug("Initialising Middleware EPackages");
			middlewareRepositoryPartition.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		} else {
			middlewareRepositoryPartition = this.blackboard.getPartition(MIDDLEWARE_PARTITION_ID);
		}
		middlewareRepositoryPartition.loadModel(configuration.getMiddlewareFile());
		
		// load event middleware 
		ResourceSetPartition eventMiddlewareRepositoryPartition = null;
		if (!this.blackboard.hasPartition(EVENT_MIDDLEWARE_PARTITION_ID)) {
			if(logger.isDebugEnabled())
				logger.debug("Creating Event Middleware Repository Partition");
			
			eventMiddlewareRepositoryPartition = new ResourceSetPartition();
			this.blackboard.addPartition(EVENT_MIDDLEWARE_PARTITION_ID, eventMiddlewareRepositoryPartition);
			
			if(logger.isDebugEnabled())
				logger.debug("Initialising Event Middleware EPackages");
			eventMiddlewareRepositoryPartition.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		} else {
			eventMiddlewareRepositoryPartition = this.blackboard.getPartition(EVENT_MIDDLEWARE_PARTITION_ID);
		}
		if (configuration.getEventMiddlewareFile() != null) {
			eventMiddlewareRepositoryPartition.loadModel(configuration.getEventMiddlewareFile());
		}
	}

	public String getName() {
		return "Load Middleware Configuration into Blackboard";
	}

	public void cleanup(IProgressMonitor monitor)
			throws CleanupFailedException {
		this.blackboard.removePartition(MIDDLEWARE_PARTITION_ID);
	}

	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
