package de.uka.ipd.sdq.cip.workflow.jobs;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.cip.ConstantsContainer;
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
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTRScript;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.jobs.QVTRTransformationJobConfiguration;

public class QVTRHotConfigurationJob implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	private CompletionConfiguration completionConfiguration = null;
	private Transformation transformation = null;
	private QVTRTransformationJobConfiguration jobConfiguration = null;
	private MDSDBlackboard blackboard = null;
	
	public QVTRHotConfigurationJob(QVTRTransformationJobConfiguration jobConfiguration, 
			CompletionConfiguration completionConfiguration, Transformation transformation) {
		
		this.jobConfiguration = jobConfiguration;
		this.transformation = transformation;
		this.completionConfiguration = completionConfiguration;
		
	}
	
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		assert (completionConfiguration != null);
		assert (transformation != null);
		assert (jobConfiguration != null);
		
		String modelPartitionID = completionConfiguration.getInputPartitionName();
		
		// check if hot partition exists and remove
		if( blackboard.hasPartition(ConstantsContainer.HOT_PARTITION_ID)){
			blackboard.removePartition(ConstantsContainer.HOT_PARTITION_ID);
		}
		
		// create new empty hot partition
		ResourceSetPartition hotPartition = new ResourceSetPartition();
		blackboard.addPartition(ConstantsContainer.HOT_PARTITION_ID, hotPartition);
		
		hotPartition.initialiseResourceSetEPackages(ConstantsContainer.HOT_METAMODELS);
		
		ModelLocation[] featureConfigLocation = new ModelLocation[] { 
					QVTConfigurationHelper.loadResourceToInputPartition(
							blackboard, 
							ConstantsContainer.HOT_PARTITION_ID, 
							URI.createURI(transformation.getFeatureFileURI()))};
		
		
	
		ModelLocation[] outputModelLocations = new ModelLocation[] {
			QVTConfigurationHelper.createResourceToInputPartition(
					blackboard, 
					modelPartitionID,
					URI.createURI(PrepareTransformationsJob.
							getModelFolder(completionConfiguration.getProjectID()).
							getFile("qvt.xmi").getFullPath().toPortableString()))};
		
		// get meta models needed for qvt script
		Collection<Object> metamodels = QVTConfigurationHelper.getMetaModelsFromBlackboard(blackboard, ConstantsContainer.HOT_PARTITION_ID);
		
		QVTRScript qvtrScript = QVTConfigurationHelper.createQVTScript(ConstantsContainer.FEATURECONFIG2QVT_FILE, metamodels, null, null);
	
		URI traceFileURI = QVTConfigurationHelper.getTraceFileURI(completionConfiguration.getProjectID());
	
		Boolean isDebug = completionConfiguration.getDebug();
	
		// set the job configuration
		jobConfiguration.setDebug(isDebug);
		jobConfiguration.addModelLocationSets(featureConfigLocation);
		jobConfiguration.addModelLocationSets(outputModelLocations);
		jobConfiguration.setTraceFileURI(traceFileURI);
		jobConfiguration.setQVTRScript(qvtrScript);
	}
	
	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}

	@Override
	public String getName() {
		return "Configure QVTR HOT transformation";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {} // nothing to roll back

}
