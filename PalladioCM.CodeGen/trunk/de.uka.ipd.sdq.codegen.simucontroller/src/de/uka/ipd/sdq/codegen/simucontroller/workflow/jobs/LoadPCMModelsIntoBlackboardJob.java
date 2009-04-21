package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

public class LoadPCMModelsIntoBlackboardJob 
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	private Logger logger = Logger.getLogger(LoadPCMModelsIntoBlackboardJob.class);
	
	public static final String PCM_MODELS_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition";
	public static final String MIDDLEWARE_PARTITION_ID = "de.uka.ipd.sdq.pcmmodels.partition.middleware";

	private MDSDBlackboard blackboard = null;
	private AbstractPCMWorkflowRunConfiguration configuration = null;

	public LoadPCMModelsIntoBlackboardJob(SimuComWorkflowConfiguration config) {
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

	public void setBlackbard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
