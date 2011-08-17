package de.uka.ipd.sdq.cip.workflow.jobs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
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
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTRScript;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.jobs.QVTRTransformationJobConfiguration;

public class QVTRConfigurationJob implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	private CompletionConfiguration completionConfiguration = null;
	private Transformation transformation = null;
	private QVTRTransformationJobConfiguration jobConfiguration = null;
	private MDSDBlackboard blackboard = null;
	
	public QVTRConfigurationJob(QVTRTransformationJobConfiguration jobConfiguration, 
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
		
		// get the models to work with
		ModelLocation[] inputModelLocations = QVTConfigurationHelper.getModelsFromBlackboard(blackboard, modelPartitionID);
		
		// get meta models needed for qvt script
		Collection<Object> metamodels = QVTConfigurationHelper.getMetaModelsFromBlackboard(blackboard, modelPartitionID);
		
		ModelLocation[] outputModelLocations = new ModelLocation[] {
				QVTConfigurationHelper.createResourceToInputPartition(
						blackboard, 
						modelPartitionID,
						URI.createURI(PrepareTransformationsJob.
								getModelFolder(completionConfiguration.getProjectID()).
								getFile("output.xmi").getFullPath().toPortableString()))};
		
		ModelLocation[] configModelLocations = null;
		if(transformation.getConfigFileURI() != null && !transformation.getConfigFileURI().isEmpty()) {
			
			configModelLocations = new ModelLocation[] { 
					QVTConfigurationHelper.loadResourceToInputPartition(
							blackboard, 
							modelPartitionID, 
							URI.createURI(transformation.getConfigFileURI()))};
			
			metamodels.addAll(QVTConfigurationHelper.getMetaModelsFromFile(
					URI.createURI(transformation.getMetamodelFileURI())));
		}
		
		QVTRScript qvtrScript = QVTConfigurationHelper.createQVTScript(transformation.getQVTFileURI(), metamodels, null, null);
		
		URI traceFileURI = QVTConfigurationHelper.getTraceFileURI(completionConfiguration.getProjectID());
		
		Boolean isDebug = completionConfiguration.getDebug();
		
		PrintStream extendedDebuggingLog = null;
		if(isDebug) {
			try {
				extendedDebuggingLog = new PrintStream(
						new FileOutputStream (
						PrepareTransformationsJob.
						getLogFolder(completionConfiguration.getProjectID()).
						getFile(QVTConfigurationHelper.
								createTransformationID(completionConfiguration, transformation) + 
								".log").
						getRawLocation().toOSString()),true);
				
			} catch (FileNotFoundException e) {
				throw new JobFailedException("Could not create extended logging output", e);
			}
		}
		
		
		// set the job configuration
		jobConfiguration.setDebug(isDebug);
		jobConfiguration.addModelLocationSets(inputModelLocations);
		jobConfiguration.addModelLocationSets(outputModelLocations);
		if(configModelLocations != null)
			jobConfiguration.addModelLocationSets(configModelLocations);
		jobConfiguration.setTraceFileURI(traceFileURI);
		jobConfiguration.setExtendedDebuggingLog(extendedDebuggingLog);
		jobConfiguration.setQVTRScript(qvtrScript);
		
		
	}
	
	public QVTRTransformationJobConfiguration getJobConfiguration() {
		return jobConfiguration;
	}
	
	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	@Override
	public String getName() {
		return "Configure QVTR transformation";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		if(jobConfiguration.getExtendedDebuggingLog() != null)
			jobConfiguration.getExtendedDebuggingLog().close();
		
		try {
			PrepareTransformationsJob.
			getLogFolder(completionConfiguration.getProjectID()).refreshLocal(1, monitor);
		} catch (CoreException e) {
			throw new RollbackFailedException("Could not refresh workspace", e);
		}
	}

}
