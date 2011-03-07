package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.jobs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.AbstractQVTREngine;

/**
 * A Job that executes a QVT-R transformation.
 * It is configured through a {@link QVTRTransformationJobConfiguration}.
 * 
 * @author Thomas Schuischel
 *
 */
public class QVTRTransformationJob implements
		IBlackboardInteractingJob<MDSDBlackboard> {
	
	/**
	 * log4j logger for this class.
	 */
	private final Logger logger = Logger.getLogger(QVTRTransformationJob.class);
	/**
	 * Configuration for this job.
	 */
	protected QVTRTransformationJobConfiguration configuration;
	/**
	 * Blackboard this job is interacting.
	 */
	protected MDSDBlackboard blackboard;

	/**
	 * Creates a new {@link QVTRTransformationJob} for a given {@link QVTRTransformationJobConfiguration}.
	 * 
	 * @param configuration a {@link QVTRTransformationJobConfiguration}
	 */
	public QVTRTransformationJob(final QVTRTransformationJobConfiguration configuration) {
		super();
		this.configuration = configuration;
	}
	
	@Override
	public void execute(final IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		logger.info("Executing QVTR Transformation...");
		logger.debug("Script: " + configuration.getQVTRScript());
		
		// request the QVT-R engine we want to execute
		AbstractQVTREngine qvtrEngine = AbstractQVTREngine.getInstance(configuration.getQvtEngineID());
		if (qvtrEngine == null) {
			throw new JobFailedException("No QVT-R Engine available.");
		}
		
		// enable debug 
		qvtrEngine.setDebug(configuration.isDebug());
		
		// if a trace partition name is provided we create the partition
		if (configuration.getTracesPartitionName() != null) {
			ResourceSetPartition tracesPartition = this.blackboard.getPartition(configuration.getTracesPartitionName());
			if (tracesPartition == null)	{
				tracesPartition = new ResourceSetPartition();
				this.blackboard.addPartition(configuration.getTracesPartitionName(), tracesPartition);
			}
			qvtrEngine.setTracesResourceSet(tracesPartition.getResourceSet());
		}
		
		// if a old trace partition name is provided we sets the partition
		if (configuration.getOldTracesPartitionName() != null) {
			ResourceSetPartition oldTracesPartition = 
				this.blackboard.getPartition(configuration.getOldTracesPartitionName());
			if (oldTracesPartition != null)	{
				qvtrEngine.setOldTracesResourceSet(oldTracesPartition.getResourceSet());
			}
		}
		
		// set the working directory for traces
		qvtrEngine.setWorkingDirectory(configuration.getTraceFileURI());
		
		// add all model sets to the engine
		Iterator<ModelLocation[]> iterator = configuration.getModelLocationSets().iterator();
		while (iterator.hasNext()) {
			ModelLocation[] modelLocation = iterator.next();
			qvtrEngine.addModels(getResources(modelLocation));
		}
		
		// sets the script to execute to the engine
		qvtrEngine.setQVTRScript(configuration.getQVTRScript());
		
		// enables extended logging 
		qvtrEngine.setExtendedDebugingLog(configuration.getExtendedDebuggingLog());
		
		// execute transformation
		try {
			qvtrEngine.transform();
		} catch (Throwable e) {
			throw new JobFailedException("Error in mediniQVT Transformation", e);
		}
		
		logger.info("Transformation executed successfully");
	}
	
	/**
	 * Returns a {@link Collection} of {@link Resource}s for a array of {@link ModelLocation}s.
	 *
	 * @param modelLocations 	an array of {@link ModelLocation}
	 * @return a {@link Collection} of {@link Resource}
	 */
	protected Collection<Resource> getResources(final ModelLocation[] modelLocations) {
		Collection<Resource> resources = new ArrayList<Resource>(modelLocations.length);
		
		for (int i = 0; i < modelLocations.length; i++) {
			resources.add(getResource(modelLocations[i]));
		}
		
		return resources;
	}
	
	/**
	 * Returns a {@link Resource} for a {@link ModelLocation}.
	 * 
	 * @param 	modelLocation	{@link ModelLocation}
	 * @return 	a {@link Resource} for a {@link ModelLocation}
	 */
	protected Resource getResource(final ModelLocation modelLocation) {
		
		ResourceSetPartition partition = this.blackboard.getPartition(modelLocation.getPartitionID());
		ResourceSet rSet = partition.getResourceSet();
		
		Resource r = rSet.getResource(modelLocation.getModelID(), false);
		if (r == null) {
			new IllegalArgumentException("Model with URI " + modelLocation.getModelID() + " must be loaded first");
		}
		return r;
	}

	@Override
	public String getName() {
		return "Run a relational mediniQVT transformation";
	}

	@Override
	public void rollback(final IProgressMonitor monitor)
			throws RollbackFailedException { } // Not needed
	
	@Override
	public void setBlackboard(final MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
