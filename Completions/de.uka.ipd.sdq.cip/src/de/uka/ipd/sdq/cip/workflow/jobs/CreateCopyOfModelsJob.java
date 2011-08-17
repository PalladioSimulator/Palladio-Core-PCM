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
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class CreateCopyOfModelsJob implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	/** The logger for this class */
	private Logger logger = Logger.getLogger(CreateCopyOfModelsJob.class);
	
	/** The blackboard to interact with */
	private MDSDBlackboard blackboard = null;
	
	/** The blackboard partition for this Job */
	private String modelPartition;
	
	/** The project id where to create folders */
	private String projectID;

	/** The transformation id where to copy models */
	private String transformationID;
	
	public CreateCopyOfModelsJob(
			CompletionConfiguration completionConfiguration,
			Transformation transformation) {
		
		this.projectID = completionConfiguration.getProjectID();
		this.modelPartition = completionConfiguration.getInputPartitionName();
		
		URI qvtFileURI = URI.createURI(transformation.getQVTFileURI());
		this.transformationID = qvtFileURI.lastSegment().replace(qvtFileURI.fileExtension(), "") + 
			completionConfiguration.getTransformations().indexOf(transformation);
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		IFolder modelFolder = PrepareTransformationsJob.createFolder(
				PrepareTransformationsJob.getModelFolder(projectID).getFolder(
						transformationID),
				logger);
		
		// Copy models
		copyModelsFromBlackboard(modelFolder);
		
	}
	
	private void copyModelsFromBlackboard(IFolder modelFolder) throws JobFailedException {
	

		URI baseURI = URI.createURI("file:/"+modelFolder.getLocation().toOSString());
		
		// access the resources
		ResourceSetPartition partition = (ResourceSetPartition) this.blackboard.getPartition(modelPartition);
		ResourceSet resourceSet = partition.getResourceSet();
		for (Resource resource : resourceSet.getResources()) {
			
			// we only need to copy the file models
			if (resource.getURI().isFile()) {
				
				// get old resource path
				URI oldURI = resource.getURI();
				String[] oldURISegments = oldURI.segments();
				// set the new resource path
				URI newURI = baseURI;
				if(oldURISegments.length > 1)
					newURI = newURI.appendSegment(oldURISegments[oldURISegments.length - 2]);
				newURI = newURI.appendSegment(oldURISegments[oldURISegments.length - 1]);
				resource.setURI(newURI);
				
				try {
					resource.save(new HashMap<String ,String>());
					partition.setContents(resource.getURI(), resource.getContents());
				} catch (IOException e) {
					logger.error("Unable to store resource "+resource.getURI(),e);
				}
			}
		}
		
		try {
			partition.storeAllResources();
		} catch (IOException e) {
			logger.error("unable to store all resources",e);
			throw new JobFailedException("Unable to store all Resources");
		}
	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;	
	}


	@Override
	public String getName() {
		return null;
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {}  // nothing to roll back
}