package de.uka.ipd.sdq.cip.workflow.jobs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.QVTConfigurationHelper;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.jobs.QVTRTransformationJobConfiguration;

public class SplitTransformationResultJob implements IBlackboardInteractingJob<MDSDBlackboard> {
	
	/** The logger for this class */
	private Logger logger = Logger.getLogger(SplitTransformationResultJob.class);
	
	/** The blackboard to interact with */
	private MDSDBlackboard blackboard = null;
	
	/** The blackboard partition for this Job */
	private String modelPartitionID;
	
	/** The project id where to create folders */
	private String projectID;

	/** The transformation id where to copy models */
	private String transformationID;

	/** The configuration for a qvtr completion job */
	private QVTRTransformationJobConfiguration qvtrTransformationJobConfiguration;

	public SplitTransformationResultJob(
			QVTRTransformationJobConfiguration qvtrTransformationJobConfiguration, 
			CompletionConfiguration completionConfiguration, 
			Transformation transformation) {
		
		this.modelPartitionID = completionConfiguration.getInputPartitionName();
		this.qvtrTransformationJobConfiguration = qvtrTransformationJobConfiguration;
		this.projectID = completionConfiguration.getProjectID();
		
		
		this.transformationID = QVTConfigurationHelper.createTransformationID(completionConfiguration, transformation);
	}
	
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		IFolder modelFolder = PrepareTransformationsJob.createFolder(
				PrepareTransformationsJob.getModelFolder(projectID).getFolder(
						transformationID),
				logger);
		
		ResourceSetPartition partition = this.blackboard.getPartition(modelPartitionID);
		ResourceSet resourceSet = partition.getResourceSet();
		
		// Collect Resources to delete
		ArrayList<Resource> resourcesToDelete = new ArrayList<Resource>();
		for (Resource resource : resourceSet.getResources()) {
			// we only need to delete the file models
			if (resource.getURI().isFile()) {		
				resourcesToDelete.add(resource);
			}
		}
		
		// Split output models
		Iterator<ModelLocation[]> iterator  = qvtrTransformationJobConfiguration.getModelLocationSets().iterator();
		iterator.next(); // go to second element
		for (ModelLocation modelLocation : iterator.next()) {
				
			ResourceSetPartition modelPartition = this.blackboard.getPartition(modelLocation.getPartitionID());
				
			EList<EObject> topLevelObjects = (EList<EObject>) modelPartition.getContents(modelLocation.getModelID());
			while (topLevelObjects.size() > 0)
				createResource(topLevelObjects.get(0), partition, modelFolder);
			
			// Delete all temporary resources
			Resource resource = modelPartition.getResourceSet().getResource(modelLocation.getModelID(), false);
			if(resource.isLoaded())
				try {
					resource.delete(new HashMap<String, String>());
				} catch (IOException e) {
					logger.error("Unable to delete resource " + resource.getURI(),e);
				}
		}
		
		// remove all marked resources from partition
		for (Resource resource : resourcesToDelete) {
				partition.getResourceSet().getResources().remove(resource);
		}
		

	}

	private void createResource(EObject eobject, ResourceSetPartition partition, IFolder modelFolder) {

		URI baseURI = URI.createFileURI(modelFolder.getFullPath().toString());
		String eobjectName = eobject.eClass().getName();
		URI modelURI = baseURI.appendSegment(eobjectName + ".xmi");
		Resource resource = partition.getResourceSet().getResource(modelURI, false);
		
		// find unused name
		long num = 1;
		while(resource != null)
		{
			
			modelURI = baseURI.appendSegment(eobjectName + "_" + String.valueOf(num) + ".xmi");
			resource = partition.getResourceSet().getResource(modelURI, false);
			num++;
		}
		
		resource = partition.getResourceSet().createResource(modelURI);	
		
		resource.getContents().add(eobject);
		
		try {
			resource.save(new HashMap<String, String>());
			//partition.setContents(resource.getURI(), resource.getContents());
		} catch (IOException e) {
			logger.error("Unable to store resource "+resource.getURI(),e);
		}
	}

	@Override
	public String getName() {
		return "Clean up qvtr completion transformation result";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {} // not needed

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
