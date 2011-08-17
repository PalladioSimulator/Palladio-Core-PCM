package de.uka.ipd.sdq.cip.configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uka.ipd.sdq.cip.workflow.jobs.PrepareTransformationsJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTRScript;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTRScriptInfo;

public class QVTConfigurationHelper {

	public static Collection<Object> getMetaModelsFromBlackboard(MDSDBlackboard blackboard, String modelPartitionID) {
		ResourceSetPartition partition = blackboard.getPartition(modelPartitionID);
		Registry registry = partition.getResourceSet().getPackageRegistry();
		return registry.values();
	}
	
	public static Collection<Object> getMetaModelsFromFile(URI metamodelURI) {
		ArrayList<Object> list = new ArrayList<Object>();
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(metamodelURI,true);
		TreeIterator<EObject> iterator = resource.getAllContents();
		for(EObject object = null; iterator.hasNext(); object = iterator.next() ) {
			if(object instanceof EPackage)
				list.add(object);
		}
		
		return list;
	}
	
	/**
	 * Build the location objects out of the blackboards PCM model partition.
	 * 
	 * @return	The prepared model locations for the PCM models.
	 */
	public static ModelLocation[] getModelsFromBlackboard(MDSDBlackboard blackboard, String modelPartitionID) {
		
		ArrayList<ModelLocation> modelLocations = new ArrayList<ModelLocation>();
		ResourceSetPartition partition = blackboard.getPartition(modelPartitionID);
		partition.resolveAllProxies();
		for (Resource r : partition.getResourceSet().getResources()) {
			ModelLocation location = new ModelLocation(modelPartitionID, r.getURI());
			modelLocations.add(location);
		}
		
		return modelLocations.toArray(new ModelLocation[]{});
	}
	
	public static URI getTraceFileURI (String projectID) {
		String tracesFolder = PrepareTransformationsJob.getTracesFolder(
				projectID).getFullPath().toString();
		URI tracesURI = URI.createPlatformResourceURI(tracesFolder, false);
		return tracesURI;
	}
	
	public static URI getHotTraceFileURI (String projectID) {
		String tracesFolder = PrepareTransformationsJob.getHOTTracesFolder(
				projectID).getFullPath().toString();
		URI tracesURI = URI.createPlatformResourceURI(tracesFolder, false);
		return tracesURI;
	}
	
	public static ModelLocation createResourceToInputPartition(MDSDBlackboard blackboard, String modelPartitionID, URI modelURI) {
		ResourceSetPartition resourceSetPartition = blackboard.getPartition(modelPartitionID);
		Resource r = resourceSetPartition.getResourceSet().createResource(modelURI);			
		return new ModelLocation(modelPartitionID, r.getURI());
	}
	
	public static ModelLocation loadResourceToInputPartition(MDSDBlackboard blackboard, String modelPartitionID, URI modelURI) {
		ResourceSetPartition resourceSetPartition = blackboard.getPartition(modelPartitionID);
		Resource r = resourceSetPartition.loadModel(modelURI);			
		return new ModelLocation(modelPartitionID, r.getURI());
	}
	
	public static String createTransformationID(CompletionConfiguration completionConfiguration, Transformation transformation) {
		
		URI qvtFileURI = URI.createURI(transformation.getQVTFileURI());
		int index = qvtFileURI.lastSegment().indexOf('.');
		
		return qvtFileURI.lastSegment().substring(0, index) + "_" +
			completionConfiguration.getTransformations().indexOf(transformation);
	}
	
	public static QVTRScript createQVTScript(String script, Collection<Object> metaModels, String transformation, String direction) {
		QVTRScript qvtrScript = new QVTRScript();
		qvtrScript.setQVTFile(script);
		qvtrScript.setMetaModels(metaModels);
		
		QVTRScriptInfo scriptinfo = new QVTRScriptInfo(qvtrScript);
		if(transformation == null)
			transformation = scriptinfo.getTransformations()[0];
		if(direction == null)
			direction = scriptinfo.getDirections(transformation)[1];
		
		qvtrScript.setTransformationName(transformation);
		qvtrScript.setTransformationDirection(direction);
		
		return qvtrScript;
	}
}
