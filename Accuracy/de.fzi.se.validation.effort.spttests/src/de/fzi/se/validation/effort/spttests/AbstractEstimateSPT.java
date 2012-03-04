package de.fzi.se.validation.effort.spttests;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult;
import de.fzi.se.validation.effort.estimation.spt.SPTFactory;
import de.fzi.se.validation.effort.workflow.AbstractEstimateQVTO;
import de.fzi.se.validation.effort.workflow.PrepareEstimatorPartitions;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

public abstract class AbstractEstimateSPT extends AbstractEstimateQVTO {

	/** Custom configuration for SPTTestsEstimation jobs. */
	protected SPTEstimatorConfiguration configuration = null;
	
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(AbstractEstimateSPT.class);
	
	/**Creates the configuration model used in the transformations and stores it in the blackboard.
	 * @return Location of the configuration.
	 */
	@Override
	protected ModelLocation createConfiguration() {
		SPTEffortEstimationResult modelConfiguration = SPTFactory.eINSTANCE.createSPTEffortEstimationResult();
		modelConfiguration.setN(configuration.getN());
		modelConfiguration.setTargetUri(estimatorConfiguration.getBehaviourURI().toString());
		modelConfiguration.setTargetId(estimatorConfiguration.getBehaviourURI().substring(estimatorConfiguration.getBehaviourURI().lastIndexOf('#') + 1, estimatorConfiguration.getBehaviourURI().length()));
		modelConfiguration.setAlpha(estimatorConfiguration.getConfidence());

		return createTempLocation(PrepareEstimatorPartitions.ESTIMATION_RESULT_PARTITION_ID, "jjnpaths", modelConfiguration);
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#buildAndSetCustomConfiguration(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void buildAndSetCustomConfiguration(ILaunchConfiguration configuration) {
		this.configuration = null;
		// build custom configuration
		SPTEstimatorConfiguration estimatorConfig = new SPTEstimatorConfiguration();
		int n = Integer.parseInt(SPTTestsEstimatorConstantsContainer.DEFAULT_N);
		try {
			 n = Integer.parseInt(configuration.getAttribute(SPTTestsEstimatorConstantsContainer.N, SPTTestsEstimatorConstantsContainer.DEFAULT_N));
		} catch (NumberFormatException e) {
			logger.info("Parameter n was not stored correctly in launch configuration.", e);
		} catch (CoreException e) {
			logger.error("Error accessing the launch configuration attributes.", e);
		}
		estimatorConfig.setN(n);
		// set
		this.configuration = estimatorConfig;
	}
}
