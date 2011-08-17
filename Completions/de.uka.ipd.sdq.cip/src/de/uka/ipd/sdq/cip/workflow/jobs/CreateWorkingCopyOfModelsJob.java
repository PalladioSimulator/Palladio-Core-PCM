package de.uka.ipd.sdq.cip.workflow.jobs;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**
 * Job to create a working copy of the models to simulate.
 * This ensures that any downstream job changing the models 
 * does not modify the original models.
 * 
 * Prerequisite of this job:
 * This job copies the models to the configured project created in
 * the workflow. It has to exist to be able to store the model copy
 * into it.
 * 
 * @author Benjamin Klatt
 *
 */
public class CreateWorkingCopyOfModelsJob implements IJob,
	IBlackboardInteractingJob<MDSDBlackboard> {

	/** The logger for this class */
	private static final Logger logger = Logger.getLogger(CreateWorkingCopyOfModelsJob.class);
	
	/** The blackboard to interact with */
	private MDSDBlackboard blackboard = null;

	/** The work flow configuration to get the required information from */
	//private SimuComWorkflowConfiguration configuration;

	private String projectID;

	private String modelPartitionID;

	private String transformationID;

	/**
	 * Constructor requiring the necessary configuration object.
	 * 
	 * @param configuration The configuration for this job.
	 */
	public CreateWorkingCopyOfModelsJob(CompletionConfiguration completionConfiguration,
			Transformation transformation) {
		this.projectID = completionConfiguration.getProjectID();
		this.modelPartitionID = completionConfiguration.getInputPartitionName();
		
		URI qvtFileURI = URI.createURI(transformation.getQVTFileURI());
		this.transformationID = qvtFileURI.lastSegment().replace(qvtFileURI.fileExtension(), "") + 
			completionConfiguration.getTransformations().indexOf(transformation);
	}
	
	/**
	 * Execute this job and create the model copy.
	 */
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {

		IFolder modelFolder = PrepareTransformationsJob.createFolder(
				PrepareTransformationsJob.getModelFolder(projectID).getFolder(
						transformationID),
				logger);
		
		String modelBasePath = "file:/"+modelFolder.getLocation().toOSString();
		
		// access the resources
		ResourceSetPartition partition = (ResourceSetPartition) this.blackboard.getPartition(modelPartitionID);
		ResourceSet resourceSet = partition.getResourceSet();
		for (Resource ressource : resourceSet.getResources()) {
			
			// we only need to copy the file models
			if (ressource.getURI().isFile()) {

				URI uri = ressource.getURI();
				String relativePath = uri.lastSegment();
				URI newURI = URI.createURI(modelBasePath +"/"+ relativePath);
				ressource.setURI(newURI);
				
				try {
					ressource.save(new HashMap());
					partition.setContents(ressource.getURI(), ressource.getContents());
				} catch (IOException e) {
					logger.error("Unable to store resource "+ressource.getURI(),e);
				}
			}
		}
		try {
			partition.storeAllResources();
		} catch (IOException e) {
			logger.error("unable to store all resources",e);
			throw new JobFailedException("Unable to store all Resources",e);
		}
//		partition.resolveAllProxies();
//		this.blackboard.removePartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
//		this.blackboard.addPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, partition);
	}

	@Override
	public String getName() {
		return "Create working copy of models";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		logger.warn("Unable to perform rollback for this job");

	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
