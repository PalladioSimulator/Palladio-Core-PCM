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

/**
 * A job to be used in the SDQ workflow engine which fully loads a PCM model instance into two MDSDBlackboard partitions.
 * The first partition contains the plain PCM model instance, the second one contains parametric middleware completion
 * components.
 *  
 * @author Steffen Becker
 */
public class LoadPCMModelsIntoBlackboardJob 
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	private Logger logger = Logger.getLogger(LoadPCMModelsIntoBlackboardJob.class);
	
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

	private MDSDBlackboard blackboard = null;
	private AbstractPCMWorkflowRunConfiguration configuration = null;

	/**
	 * Constructor of the PCM loader job
	 * @param config A PCM workflow configuration containing the list of URIs where to find the PCM model files
	 */
	public LoadPCMModelsIntoBlackboardJob(AbstractPCMWorkflowRunConfiguration config) {
		super();
		
		this.configuration  = config;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		// Create and add the PCM and middleware model partition
		logger.debug("Creating PCM Model Partition");
		PCMResourceSetPartition myPartion = new PCMResourceSetPartition();
		this.blackboard.addPartition(PCM_MODELS_PARTITION_ID, myPartion);
		
		ResourceSetPartition middlewareRepositoryPartition = new ResourceSetPartition();
		this.blackboard.addPartition(MIDDLEWARE_PARTITION_ID, middlewareRepositoryPartition);
		
		logger.debug("Initialising PCM EPackages");
		myPartion.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		middlewareRepositoryPartition.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		
		// Load the PCM model and its middleware completions
		logger.info("Loading PCM Model Files");
		for (String modelFile : configuration.getPCMModelFiles()) {
			myPartion.loadModel(modelFile);
		}
		middlewareRepositoryPartition.loadModel(configuration.getMiddlewareFile());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return "Load PCM Models into Blackboard";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		this.blackboard.removePartition(PCM_MODELS_PARTITION_ID);
		this.blackboard.removePartition(MIDDLEWARE_PARTITION_ID);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka.ipd.sdq.workflow.Blackboard)
	 */
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}
}
