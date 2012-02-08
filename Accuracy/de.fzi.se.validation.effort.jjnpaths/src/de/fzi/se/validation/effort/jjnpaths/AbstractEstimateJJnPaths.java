/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.controlflowdescription.ControlFlowDescriptionFactory;
import de.fzi.se.controlflowdescription.graph.Graph;
import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsEffortEstimationResult;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsFactory;
import de.fzi.se.validation.effort.workflow.AbstractEstimateQVTO;
import de.fzi.se.validation.effort.workflow.PrepareEstimatorPartitions;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

/**Validation effort estimation algorithm basic structure for JJn-Paths.
 * See subclasses for real implementation.
 *
 * @author groenda
 *
 */
public abstract class AbstractEstimateJJnPaths extends AbstractEstimateQVTO {
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(EstimateJJnPathsLowerBound.class);
	/** Name of this estimation job. */
	private static final String NAME = "Estimate JJnPaths Lower Bound Job";

	/** Operational QVT transformation script URI which transforms {@link ResourceDemandingBehaviour} to {@link Graph}. */
	protected static final String BEHAVIOUR_2_GRAPH_TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.jjnpaths.qvtoscripts/transforms/behaviour2ControlFlowGraph.qvto";
	/** Operational QVT transformation script URI which transforms {@link Graph} to {@link JJPath}. */
	protected static final String GRAPH_2_JJPATHS_TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.jjnpaths.qvtoscripts/transforms/controlFlowGraph2JJPaths.qvto";
	/** Operational QVT transformation script URI which transforms {@link JJPath} to {@link JJnPath}. */
	protected static final String JJPATHS_2_JJNPATHS_TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.jjnpaths.qvtoscripts/transforms/JJPaths2JJnPathSet.qvto";

	/** Model location containing the estimation result. */
	protected ModelLocation cfdModelLocation = null;
	/** Custom configuration for JJnPathsEstimation jobs. */
	protected JJnPathsEstimatorConfiguration configuration = null;

	/**Creates the configuration model used in the transformations and stores it in the blackboard.
	 * @return Location of the configuration.
	 */
	protected ModelLocation createConfiguration() {
		JJnPathsEffortEstimationResult modelConfiguration = JJnPathsFactory.eINSTANCE.createJJnPathsEffortEstimationResult();
		modelConfiguration.setN(configuration.getN());
		modelConfiguration.setTargetUri(estimatorConfiguration.getBehaviourURI().toString());
		modelConfiguration.setTargetId(estimatorConfiguration.getBehaviourURI().substring(estimatorConfiguration.getBehaviourURI().lastIndexOf('#') + 1, estimatorConfiguration.getBehaviourURI().length()));
		modelConfiguration.setAlpha(estimatorConfiguration.getConfidence());

		return createTempLocation(PrepareEstimatorPartitions.ESTIMATION_RESULT_PARTITION_ID, "jjnpaths", modelConfiguration);
	}

	/**Build location objects from blackboard. */
	protected void buildLocationObjects() {
		super.buildLocationObjects();
		cfdModelLocation = createTempLocation(PrepareJJnPathsEstimatorPartitions.CFG_PARTITION_ID, "controlflowdescription", ControlFlowDescriptionFactory.eINSTANCE.createControlFlowDescriptions());
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.jjnpaths.AbstractEstimateQVTO#executeScript(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void executeScript(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		executeStep(monitor, new ModelLocation[] {targetBehaviour, cfdModelLocation, resultModelLocation}, BEHAVIOUR_2_GRAPH_TRANSFORMATION_SCRIPT);
		executeStep(monitor, new ModelLocation[] {cfdModelLocation}, GRAPH_2_JJPATHS_TRANSFORMATION_SCRIPT);
		executeStep(monitor, new ModelLocation[] {cfdModelLocation, resultModelLocation}, JJPATHS_2_JJNPATHS_TRANSFORMATION_SCRIPT);
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
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return NAME;
	}
}
