/**
 *
 */
package de.fzi.se.validation.effort.workflow;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.fzi.se.validation.effort.estimation.EffortEstimationResult;
import de.fzi.se.validation.effort.estimation.EstimationFactory;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**Validation effort estimation using QVT Operational.
 * Subclass for own estimation algorithm.
 *
 * @author groenda
 *
 */
public abstract class AbstractEstimateQVTO implements IBlackboardInteractingJob<MDSDBlackboard>{
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(AbstractEstimateQVTO.class);
	/** Name of this estimation job. */
	private static final String NAME = "Estimation using QVT Operational";

	/** Blackboard with models used by the job. */
	protected MDSDBlackboard blackboard;
	/** Model location of the target behaviour, e.g. an RD-SEFF. */
	protected ModelLocation targetBehaviour = null;
	/** Model location of the (intermediate) configuration model for JJn-Path calculations. */
	protected ModelLocation resultModelLocation = null;

	/** Estimation result. */
	private EffortEstimationResult estimation = null;
	/** Generic configuration for this estimator. */
	protected EstimatorConfiguration estimatorConfiguration = null;

	/**
	 * @return The estimation
	 */
	public EffortEstimationResult getEstimation() {
		return estimation;
	}

	/**Creates the configuration model used in the transformations and stores it in the blackboard.
	 * Overwrite without call to this method if own configuration is used instead of the default.
	 * @return Location of the configuration.
	 */
	protected ModelLocation createConfiguration() {
		EffortEstimationResult modelConfiguration = EstimationFactory.eINSTANCE.createEffortEstimationResult();
		modelConfiguration.setTargetUri(estimatorConfiguration.getBehaviourURI().toString());
		modelConfiguration.setTargetId(estimatorConfiguration.getBehaviourURI().substring(estimatorConfiguration.getBehaviourURI().lastIndexOf('#') + 1, estimatorConfiguration.getBehaviourURI().length()));
		modelConfiguration.setAlpha(estimatorConfiguration.getConfidence());
		return createTempLocation(PrepareEstimatorPartitions.ESTIMATION_RESULT_PARTITION_ID, "estimation", modelConfiguration);
	}

	/**Creates a temporary file, stores the content in the file and returns the model location.
	 * @param partitionId Identifier for the partition of the model.
	 * @param fileExtension Used file extension.
	 * @param content Content to add.
	 * @return Model location.
	 */
	protected ModelLocation createTempLocation(String partitionId, String fileExtension, EObject content) {
		File tempFile;
		URI descUri = null;
		try {
			tempFile = File.createTempFile("TempModel_", "." + fileExtension);
			tempFile.delete();
			descUri = URI.createFileURI(tempFile.getAbsolutePath());
		} catch (IOException e) {
			logger.error("Could not create temporary file for storing control-flow description. Cannot proceed.", e);
		}
		Resource r = this.blackboard.getPartition(partitionId).getResourceSet().createResource(descUri);
		r.getContents().add(content);
		return new ModelLocation(partitionId, descUri);
	}

	/**Build location objects from blackboard. */
	protected void buildLocationObjects() {
		targetBehaviour = new ModelLocation(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, URI.createURI(estimatorConfiguration.getBehaviourURI()));
		resultModelLocation = createConfiguration();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		prepareBlackboard();
		buildLocationObjects();
		executeScript(monitor);
		EffortEstimationResult result = this.blackboard.getPartition(resultModelLocation.getPartitionID()).getElement(EstimationFactory.eINSTANCE.createEffortEstimationResult()).get(0);
		assert (result != null);
		this.estimation = result;
	}

	/** Workflow step for the final bound estimation script. */
	protected abstract void executeScript(IProgressMonitor monitor) throws JobFailedException, UserCanceledException;

	/**Prepares the blackboard for Operation QVT execution.
	 */
	private void prepareBlackboard() {
	}

	/**Execute an operational QVT transformation step.
	 * @param monitor Progress monitor.
	 * @param modelLocation Location of the models.
	 * @param scriptURI Representation of the URI of the script.
	 * @throws JobFailedException Forwarded from {@link QVTOTransformationJob#execute(IProgressMonitor)}.
	 * @throws UserCanceledException Forwarded from {@link QVTOTransformationJob#execute(IProgressMonitor)}.
	 */
	public void executeStep(IProgressMonitor monitor, ModelLocation[] modelLocation, String scriptURI) throws JobFailedException, UserCanceledException {
		QVTOTransformationJobConfiguration qvtoConfig = new QVTOTransformationJobConfiguration();
		qvtoConfig.setInoutModels(modelLocation);
		qvtoConfig.setTraceFileURI(null);
		qvtoConfig.setScriptFileURI(URI.createURI(scriptURI));
		qvtoConfig.setOptions(new HashMap<String,Object>());
		QVTOTransformationJob step = new QVTOTransformationJob(qvtoConfig);
		step.setBlackboard(blackboard);
		step.execute(monitor);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka.ipd.sdq.workflow.Blackboard)
	 */
	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#buildAndSetCustomConfiguration(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public abstract void buildAndSetCustomConfiguration(ILaunchConfiguration configuration);

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#setConfiguration(de.fzi.se.validation.effort.workflow.EstimatorConfiguration)
	 */
	public void setConfiguration(EstimatorConfiguration estimatorConfiguration) {
		this.estimatorConfiguration = estimatorConfiguration;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return NAME;
	}
}
