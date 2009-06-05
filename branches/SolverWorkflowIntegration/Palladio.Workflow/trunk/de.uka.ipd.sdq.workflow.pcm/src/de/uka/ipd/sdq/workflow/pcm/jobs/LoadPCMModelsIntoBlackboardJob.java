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
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public class LoadPCMModelsIntoBlackboardJob 
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	private Logger logger = Logger.getLogger(LoadPCMModelsIntoBlackboardJob.class);
	
	public static final String PCM_MODELS_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition";
	public static final String MIDDLEWARE_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition.middleware";

	private MDSDBlackboard blackboard = null;
	private AbstractPCMWorkflowRunConfiguration configuration = null;

	public LoadPCMModelsIntoBlackboardJob(AbstractPCMWorkflowRunConfiguration config) {
		super();
		
		this.configuration  = config;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		logger.debug("Creating PCM Model Partition");
		PCMResourceSetPartition myPartion = new PCMResourceSetPartition();
		this.blackboard.addPartition(PCM_MODELS_PARTITION_ID, myPartion);
		
		ResourceSetPartition middlewareRepositoryPartition = new ResourceSetPartition();
		this.blackboard.addPartition(MIDDLEWARE_PARTITION_ID, middlewareRepositoryPartition);
		
		logger.debug("Initialising PCM EPackages");
		myPartion.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		middlewareRepositoryPartition.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		
		logger.info("Loading PCM Model Files");
		for (String modelFile : configuration.getPCMModelFiles()) {
			myPartion.loadModel(modelFile);
		}
		middlewareRepositoryPartition.loadModel(configuration.getMiddlewareFile());
	}

	public String getName() {
		return "Load PCM Models into Blackboard";
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		this.blackboard.removePartition(PCM_MODELS_PARTITION_ID);
	}

	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
