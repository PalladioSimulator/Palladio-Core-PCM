package de.uka.ipd.sdq.cip.workflow.jobs;

import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.QVTConfigurationHelper;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;

/**
 * @author Thomas Schuischel
 *
 */
public class QVTOConfigurationJob implements
		IBlackboardInteractingJob<MDSDBlackboard> {
	
	private CompletionConfiguration completionConfiguration = null;
	private Transformation transformation = null;
	private QVTOTransformationJobConfiguration jobConfiguration = null;
	private MDSDBlackboard blackboard = null;
	
	public QVTOConfigurationJob(QVTOTransformationJobConfiguration jobConfiguration, 
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
		
		// get the models to work with
		ModelLocation[] modelLocations = QVTConfigurationHelper.
			getModelsFromBlackboard(blackboard, completionConfiguration.getInputPartitionName());
		
		// if an optional model is configured, add this to the model location list
		if(transformation.getOptionalModelFileURI() != null &&
				!transformation.getOptionalModelFileURI().equals("")){
			
			// build the location for the optional model
			URI optionalModelURI = URI.createURI(transformation.getOptionalModelFileURI());
			//ModelLocation optionalModel = new ModelLocation(configuration.getInputPartitionName(), optionalModelURI);
			ModelLocation optionalModel = QVTConfigurationHelper.loadResourceToInputPartition(blackboard, completionConfiguration.getInputPartitionName(), optionalModelURI);
			
			// build the new location array with an additional entry
			ModelLocation[] tempModelLocations = new ModelLocation[modelLocations.length + 1];
			for(int i = 0; i < modelLocations.length; i++ ){
				tempModelLocations[i] = modelLocations[i];
			}
			tempModelLocations[modelLocations.length] = optionalModel;
			modelLocations = tempModelLocations;
		}
		
		// build file paths
		URI traceFileURI = QVTConfigurationHelper.getTraceFileURI(completionConfiguration.getProjectID());
		URI scriptFileURI = URI.createURI(transformation.getQVTFileURI());
		
		// set the job configuration
		jobConfiguration.setInoutModels(modelLocations);
		jobConfiguration.setTraceFileURI(traceFileURI);
		jobConfiguration.setScriptFileURI(scriptFileURI);
		jobConfiguration.setOptions(new HashMap<String,Object>());
		
	}
	
	public QVTOTransformationJobConfiguration getJobConfiguration() {
		return jobConfiguration;
	}
	
	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	@Override
	public String getName() {
		return "Configure QVTO transformation";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {} // nothing to roll back

}
