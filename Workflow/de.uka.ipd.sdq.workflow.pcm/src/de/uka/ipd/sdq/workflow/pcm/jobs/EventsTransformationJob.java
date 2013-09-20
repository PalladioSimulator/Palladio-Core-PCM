package de.uka.ipd.sdq.workflow.pcm.jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.SavePartitionToDiskJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Workflow job to transform the event related model elements to classic 
 * pcm model elements
 * 
 * @author Benjamin Klatt <klatt@fzi.de>
 */
public class EventsTransformationJob 
	implements IBlackboardInteractingJob<MDSDBlackboard> {

	/** Logger for this class. */
	private Logger logger = Logger.getLogger(EventsTransformationJob.class);
	
	/** Path to the qvto transformation script */
	protected static final String TRANSFORMATION_SCRIPT = "platform:/plugin/de.uka.ipd.sdq.pcm.resources/transformations/events/transformation-psm.qvto";

	private static final String TRACESFOLDER = "traces";
	
	/** Reference to the blackboard to access it in the complete job */
	private MDSDBlackboard blackboard;
	
	/** SimuCom configuration to be used in this job */
	private AbstractPCMWorkflowRunConfiguration configuration;
		
	/**
	 * Constructor providing access to the SimuCom workflow specific configuration.. 
	 * 
	 * @param configuration The configuration object to work with.
	 */
	public EventsTransformationJob(AbstractPCMWorkflowRunConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		// get the models to work with
		ModelLocation[] modelLocations = getRequiredModels(blackboard);
		
		if(checkEventGroups(modelLocations))
		{
			logger.info("Skipping Event Transformation: No EventGroup was found");
			return;
		}
		
		configuration.getEventMiddlewareFile();
		
		// build file paths
		URI traceFileURI = URI.createURI(getProject(configuration.getStoragePluginID())
				.getFolder(TRACESFOLDER)
				.getFullPath().toOSString());
		URI scriptFileURI = URI.createURI(TRANSFORMATION_SCRIPT);
		
		// configure the QVTO Job
		QVTOTransformationJobConfiguration qvtoConfig = new QVTOTransformationJobConfiguration();
		qvtoConfig.setInoutModels(modelLocations);
		qvtoConfig.setTraceFileURI(traceFileURI);
		qvtoConfig.setScriptFileURI(scriptFileURI);
		qvtoConfig.setOptions(new HashMap<String,Object>());
		
		// create and add the qvto job
		QVTOTransformationJob job = new QVTOTransformationJob(qvtoConfig);
		job.setBlackboard(blackboard);
		
		try {
			job.execute(monitor);
		} catch(JobFailedException e) {
			if(logger.isEnabledFor(Level.ERROR))
				logger.error("Failed to perform Event Transformation: "+e.getMessage());
			if(logger.isEnabledFor(Level.INFO))
				logger.info("Trying to continue processing");
		}
		
		// add the event middleware model to the blackboard
		ResourceSetPartition partition = blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		partition.loadModel(configuration.getEventMiddlewareFile());
		
		// save the modified model
		SavePartitionToDiskJob savePartitionJob = new SavePartitionToDiskJob(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		savePartitionJob.setBlackboard(blackboard);
		savePartitionJob.execute(monitor);
		
	}

	/**
	 * Search for an EventGroup in the repository
	 * @param modelLocations the model locations 
	 * @return true when no EventGroup is found
	 */
	private boolean checkEventGroups(ModelLocation[] modelLocations) {
		boolean skipQVTO = true;
		for(ModelLocation loc : modelLocations)
		{
			URI modelId = loc.getModelID();
			String fileExtension = modelId.fileExtension();
			if(fileExtension.equals("repository") )
			{
				ResourceSetPartition partition = blackboard.getPartition(loc.getPartitionID());
				List<EObject> contents = partition.getContents(modelId);
				Repository repo = (Repository) EcoreUtil.getObjectByType(contents, RepositoryPackage.eINSTANCE.getRepository());
				if(repo == null)
					continue;
				
				Object eventgroup = EcoreUtil.getObjectByType(repo.getInterfaces__Repository(), RepositoryPackage.eINSTANCE.getEventGroup());
				if(eventgroup != null)
					skipQVTO = false;
			}
			
		}
		return skipQVTO;
	}

	/**
	 * Build the location objects out of the blackboards PCM model partition.
	 * 
	 * @param blackboard	The blackboard to work with.
	 * @return	The prepared model locations for the PCM models.
	 */
	private ModelLocation[] getRequiredModels(MDSDBlackboard blackboard) {
		
		// prepare the models required for the transformation
		ModelLocation allocationModelLocation = null;
		ModelLocation systemModelLocation = null;
		ModelLocation repositoryModelLocation = null;
		
		// find the models in the blackboard
		String pcmModelPartitionId = LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID;
		ResourceSetPartition partition = blackboard.getPartition(pcmModelPartitionId);
		partition.resolveAllProxies();
		for (Resource r : partition.getResourceSet().getResources()) {
			URI modelURI = r.getURI();
			String fileExtension = modelURI.fileExtension();
			
			if(fileExtension.equals("allocation")){
				allocationModelLocation = new ModelLocation(pcmModelPartitionId, modelURI);
			}
			
			if(fileExtension.equals("system")){
				systemModelLocation = new ModelLocation(pcmModelPartitionId, modelURI);
			}
			
			if(fileExtension.equals("repository") 
					&& repositoryModelLocation == null
					&& !modelURI.toString().startsWith("pathmap://")
					&& !modelURI.toString().contains("PrimitiveTypes.repository")){
				repositoryModelLocation = new ModelLocation(pcmModelPartitionId, modelURI);
			}
		}
		
		// Build the model location list
		ArrayList<ModelLocation> modelLocations = new ArrayList<ModelLocation>();
		modelLocations.add(allocationModelLocation);
		modelLocations.add(systemModelLocation);
		modelLocations.add(repositoryModelLocation);

		// add the additional event middleware model
		modelLocations.add(getEventMiddlewareModel(blackboard));
		
		
		return modelLocations.toArray(new ModelLocation[]{});
	}

	/**
	 * Get the middleware repository from the appropriate blackboard partition
	 * 
	 * @param blackboard The blackboard to get the model from
	 * @return The event middleware model
	 */
	private ModelLocation getEventMiddlewareModel(MDSDBlackboard blackboard) {
		
		ResourceSetPartition eventMiddlewarePartition = blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.EVENT_MIDDLEWARE_PARTITION_ID);
		eventMiddlewarePartition.resolveAllProxies();
		
		// Only the first resource is necessary. 
		// All the others are eventually referenced models like the PrimitiveTypes repository we do not need here
		Resource r = eventMiddlewarePartition.getResourceSet().getResources().get(0);
		return new ModelLocation(LoadPCMModelsIntoBlackboardJob.EVENT_MIDDLEWARE_PARTITION_ID, r.getURI());
	}

	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	public String getName() {
		return "Add event transformation job";
	}

	public void cleanup(IProgressMonitor monitor)
			throws CleanupFailedException {
		// Nothing to do for the roll back
	}	
	
	/**
	 * returns a new project to be used for the simulation
	 * 
	 * @return a handle to the project to be used for the simulation
	 */
	public static IProject getProject(String projectId) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(
				projectId);
	}

}
