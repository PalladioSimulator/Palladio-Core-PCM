/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionFactory;
import de.fzi.se.controlflowdescription.graph.Graph;
import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsFactory;
import de.fzi.se.validation.effort.IEstimator;
import de.fzi.se.validation.effort.workflow.EstimatorConfiguration;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**Validation effort estimation algorithm for JJn-Paths.
 *
 * @author groenda
 *
 */
public class JJnPathsEstimator implements IEstimator, IBlackboardInteractingJob<MDSDBlackboard> {
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(PrepareEstimatorPartitions.class);

	/** Name of the workflow job. */
	public static final String NAME = "JJn-Paths Validation Effort Estimator Job";
	/** Name of the criterion which is estimated by this class. */
	public static final String CRITERION_NAME = "JJn-Paths";

	/** Operational QVT transformation script URI which transforms {@link ResourceDemandingBehaviour} to {@link Graph}. */
	protected static final String BEHAVIOUR_2_GRAPH_TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.jjnpaths.qvtoscripts/transforms/behaviour2ControlFlowGraph.qvto";
	/** Operational QVT transformation script URI which transforms {@link Graph} to {@link JJPath}. */
	protected static final String GRAPH_2_JJPATHS_TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.jjnpaths.qvtoscripts/transforms/controlFlowGraph2JJPaths.qvto";
	/** Operational QVT transformation script URI which transforms {@link JJPath} to {@link JJnPath}. */
	protected static final String JJPATHS_2_JJNPATHS_TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.jjnpaths.qvtoscripts/transforms/JJPaths2JJnPathSet.qvto";
	/** Operational QVT transformation script URI which transforms {@link JJnPath} to {@link JJnPathTestSuite}. */
	protected static final String JJNPATHS_2_TESTSUITE_TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.jjnpaths.qvtoscripts/transforms/JJnPathSet2JJnPathTestSet.qvto";

	/** Blackboard with models used by the job. */
	private MDSDBlackboard blackboard;
	/** Model location of the target behaviour, e.g. an RD-SEFF. */
	private ModelLocation targetBehaviour = null;
	/** Model location of the (intermediate) control-flow description. */
	private ModelLocation cfdModelLocation = null;
	/** Model location of the (intermediate) configuration model for JJn-Path calculations. */
	private ModelLocation cfdConfigurationModelLocation = null;
	/** Number of necessary test cases. {@code null} if there is no estimation available yet. */
	private Long numberTestcases = null;

	/** Custom configuration for this estimator. */
	private JJnPathsEstimatorConfiguration configuration = null;
	/** Generic configuration for this estimator. */
	private EstimatorConfiguration estimatorConfiguration = null;

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#getNumberTestcases()
	 */
	public Long getNumberTestcases() {
		assert (numberTestcases != null);
		return numberTestcases.longValue();
	}

	/**Creates the configuration model used in the transformations and stores it in the blackboard.
	 * @return URI of the configuration.
	 */
	private URI createConfiguration() {
		JJnPathsCreationParameter modelConfiguration = JJnPathsFactory.eINSTANCE.createJJnPathsCreationParameter();
		modelConfiguration.setN(configuration.getN());
		modelConfiguration.setTargetId(estimatorConfiguration.getBehaviourURI().substring(estimatorConfiguration.getBehaviourURI().lastIndexOf('#') + 1, estimatorConfiguration.getBehaviourURI().length()));

		ResourceSetPartition partition = blackboard.getPartition(PrepareEstimatorPartitions.CFG_CONFIGURATION_PARTITION_ID);
		File tempFile;
		URI cfgUri = null;
		try {
			tempFile = File.createTempFile("CFG_", ".controlflowdescription");
			tempFile.delete();
			cfgUri = URI.createFileURI(tempFile.getAbsolutePath());
			Resource r = partition.getResourceSet().createResource(cfgUri);
			r.getContents().add(modelConfiguration);
		} catch (IOException e) {
			logger.error("Could not create temporary file for storing the configuration. Cannot proceed.", e);
		}
		return cfgUri;
	}

	/**Build location objects from blackboard. */
	private void buildLocationObjects(URI cfgUri) {
		targetBehaviour = new ModelLocation(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, URI.createURI(estimatorConfiguration.getBehaviourURI()));
		File tempFile;
		URI descUri = null;
		try {
			tempFile = File.createTempFile("CFG_", ".controlflowdescription");
			tempFile.delete();
			descUri = URI.createFileURI(tempFile.getAbsolutePath());
		} catch (IOException e) {
			logger.error("Could not create temporary file for storing control-flow description. Cannot proceed.", e);
		}
		Resource r = this.blackboard.getPartition(PrepareEstimatorPartitions.CFG_PARTITION_ID).getResourceSet().createResource(descUri);
		r.getContents().add(ControlFlowDescriptionFactory.eINSTANCE.createControlFlowDescriptions());
		cfdModelLocation = new ModelLocation(PrepareEstimatorPartitions.CFG_PARTITION_ID, descUri);
		cfdConfigurationModelLocation = new ModelLocation(PrepareEstimatorPartitions.CFG_CONFIGURATION_PARTITION_ID, cfgUri);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		prepareBlackboard();
		buildLocationObjects(createConfiguration());
		executeStep(monitor, new ModelLocation[] {targetBehaviour, cfdModelLocation, cfdConfigurationModelLocation}, BEHAVIOUR_2_GRAPH_TRANSFORMATION_SCRIPT);
		executeStep(monitor, new ModelLocation[] {cfdModelLocation}, GRAPH_2_JJPATHS_TRANSFORMATION_SCRIPT);
		executeStep(monitor, new ModelLocation[] {cfdModelLocation, cfdConfigurationModelLocation}, JJPATHS_2_JJNPATHS_TRANSFORMATION_SCRIPT);
		ControlFlowDescription result = ((CFDResourceSetPartition) this.blackboard.getPartition(cfdModelLocation.getPartitionID())).getControlFlowDescription();
		assert (result != null);
		for (JJnPathSet jjnpathset : result.getJjnpathsets()) {
			if (jjnpathset.getN() == (configuration.getN())) {
				JJnPathsTestSuiteSizeEstimator estimator = new JJnPathsTestSuiteSizeEstimator(jjnpathset);
				numberTestcases = estimator.estimate(estimatorConfiguration.getConfidence());
				break;
			}
		}
	}

	/**Prepares the blackboard for Operation QVT execution.
	 */
	private void prepareBlackboard() {
		logger.debug("Creating CFD Partitions");
		// Description
		CFDResourceSetPartition cfdRepositoryPartition = new CFDResourceSetPartition();
		this.blackboard.addPartition(PrepareEstimatorPartitions.CFG_PARTITION_ID, cfdRepositoryPartition);
		cfdRepositoryPartition.initialiseResourceSetEPackages(JJnPathsEstimatorConstantsContainer.CFD_EPACKAGES);
		// configuration
		CFDResourceSetPartition cfgConfigurationPartition = new CFDResourceSetPartition();
		this.blackboard.addPartition(PrepareEstimatorPartitions.CFG_CONFIGURATION_PARTITION_ID, cfgConfigurationPartition);
		cfgConfigurationPartition.initialiseResourceSetEPackages(JJnPathsEstimatorConstantsContainer.CFD_EPACKAGES);
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
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return JJnPathsEstimator.NAME;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		this.blackboard.removePartition(PrepareEstimatorPartitions.CFG_PARTITION_ID);
		this.blackboard.removePartition(PrepareEstimatorPartitions.CFG_CONFIGURATION_PARTITION_ID);
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka.ipd.sdq.workflow.Blackboard)
	 */
	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#getCriterionName()
	 */
	public String getCriterionName() {
		if (configuration.isValid()) {
			return JJnPathsEstimator.CRITERION_NAME.replace("n", Integer.toString(configuration.getN()));
		} else {
			return JJnPathsEstimator.CRITERION_NAME;
		}
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#buildAndSetCustomConfiguration(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void buildAndSetCustomConfiguration(ILaunchConfiguration configuration) {
		this.configuration = null;
		// build custom configuration
		JJnPathsEstimatorConfiguration estimatorConfig = new JJnPathsEstimatorConfiguration();
		int n = Integer.parseInt(JJnPathsEstimatorConstantsContainer.DEFAULT_N);
		try {
			 n = Integer.parseInt(configuration.getAttribute(JJnPathsEstimatorConstantsContainer.N, JJnPathsEstimatorConstantsContainer.DEFAULT_N));
		} catch (NumberFormatException e) {
			logger.info("Parameter n was not stored correctly in launch configuration.", e);
		} catch (CoreException e) {
			logger.error("Error accessing the launch configuration attributes.", e);
		}
		estimatorConfig.setN(n);
		// set
		this.configuration = estimatorConfig;
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#setConfiguration(de.fzi.se.validation.effort.workflow.EstimatorConfiguration)
	 */
	public void setConfiguration(EstimatorConfiguration estimatorConfiguration) {
		this.estimatorConfiguration = estimatorConfiguration;
	}
}
