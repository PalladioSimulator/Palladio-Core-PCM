/*
 * 
 */
package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;

/**
 * This class can build PCM solver specific configuration objects out of a given
 * Eclipse Launch Configuration.
 * 
 * @author brosch
 * 
 */
public class PCMSolverConfigurationBasedConfigBuilder extends
		AbstractWorkflowConfigurationBuilder {

	/**
	 * Configuration details constant.
	 */
	private static final int DOMAINSIZEDEFAULT = 32;

	/**
	 * Configuration details constant.
	 */
	private static final double DISTANCEDEFAULT = 1.0;

	/**
	 * The constructor takes an Eclipse Launch Configuration object.
	 * 
	 * @param configuration
	 *            the Eclipse Launch Configuration object
	 * @param mode
	 *            distinguishes between debug mode and normal mode
	 * @throws CoreException
	 *             the access of attributes of the Eclipse Launch Configuration
	 *             object might lead to a CoreException
	 */
	public PCMSolverConfigurationBasedConfigBuilder(
			final ILaunchConfiguration configuration, final String mode)
			throws CoreException {
		super(configuration, mode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder
	 * #fillConfiguration(de.uka.ipd.sdq.workflow.launchconfig.
	 * AbstractWorkflowBasedRunConfiguration)
	 */
	@Override
	public void fillConfiguration(
			final AbstractWorkflowBasedRunConfiguration configuration)
	throws CoreException {

		// We assume that we got a PCMSolverWorkflowRunConfiguration object:
		PCMSolverWorkflowRunConfiguration config = (PCMSolverWorkflowRunConfiguration) configuration;

		// Per default, we assume that this is not a reliability analysis:
		config.setReliabilityAnalysis(false);

		// We also assume that we are in interactive mode (so that dialogs in
		// case of model validation errors or exceptions during analysis are NOT
		// suppressed):
		config.setInteractive(true);

		// Set some general properties from the Eclipse Launch Configuration:
		config.setDomainSize(hasAttribute(MessageStrings.MAX_DOMAIN) ? getIntegerAttribute(MessageStrings.MAX_DOMAIN)
				: DOMAINSIZEDEFAULT);
		config.setDistance(hasAttribute(MessageStrings.SAMPLING_DIST) ? getDoubleAttribute(MessageStrings.SAMPLING_DIST)
				: DISTANCEDEFAULT);
		config.setSolver(hasAttribute(MessageStrings.SOLVER) ? getStringAttribute(MessageStrings.SOLVER)
				: MessageStrings.SRE_SOLVER);

		// Set further properties which are specific for the LQN Solver and the performance engine:
		config.setLqnsOutput(hasAttribute(MessageStrings.LQNS_OUTPUT) ? getStringAttribute(MessageStrings.LQNS_OUTPUT)
				: MessageStrings.LQN_OUTPUT_HUMAN);
		config.setLqnsOutputDir(hasAttribute(MessageStrings.LQNS_OUTPUT_DIR) ? getStringAttribute(MessageStrings.LQNS_OUTPUT_DIR)
				: System.getProperty("user.dir"));
		config.setPerfEngOutputDir(hasAttribute(MessageStrings.PERF_ENG_OUT_DIR) ? getStringAttribute(MessageStrings.PERF_ENG_OUT_DIR)
				: System.getProperty("user.dir"));
		config.setPerfEngPropFile(hasAttribute(MessageStrings.PERF_ENG_PROP_FILE) ? getStringAttribute(MessageStrings.PERF_ENG_PROP_FILE)
				: System.getProperty("user.dir")+System.getProperty("file.separator")+"LINE.properties");
		config.setLqsimOutput(hasAttribute(MessageStrings.LQSIM_OUTPUT) ? getStringAttribute(MessageStrings.LQSIM_OUTPUT)
				: MessageStrings.LQN_OUTPUT_HUMAN);
		config.setLqsimOutputDir(hasAttribute(MessageStrings.LQSIM_OUTPUT_DIR) ? getStringAttribute(MessageStrings.LQSIM_OUTPUT_DIR)
				: System.getProperty("user.dir"));

		config.setSREOutputFile(hasAttribute(MessageStrings.SRE_OUTPUT_FILE) ? getStringAttribute(MessageStrings.SRE_OUTPUT_FILE)
				: System.getProperty("user.dir"));

		config.setIsUseSREInputModel(hasAttribute(MessageStrings.SRE_IS_USE_INPUT_MODEL) ? getBooleanAttribute(MessageStrings.SRE_IS_USE_INPUT_MODEL)
				: false);

		config.setDebugLevel(hasAttribute(DebugEnabledCommonTab.WORKFLOW_ENGINE_DEBUG_LEVEL) ? getIntegerAttribute(DebugEnabledCommonTab.WORKFLOW_ENGINE_DEBUG_LEVEL)
				: 0);
		config.setPsQuantum(hasAttribute(MessageStrings.PS_QUANTUM) ? getStringAttribute(MessageStrings.PS_QUANTUM)
				: "0.001");
		
		config.setPragmas(hasAttribute(MessageStrings.PRAGMAS) ? getStringAttribute(MessageStrings.PRAGMAS)
				: "");

		config.setLQSimRuntime(hasAttribute(MessageStrings.RUN_TIME) ? getStringAttribute(MessageStrings.RUN_TIME)
				: "");

		config.setLQSimBlocks(hasAttribute(MessageStrings.BLOCKS) ? getStringAttribute(MessageStrings.BLOCKS)
				: "");

		config.setConvValue(hasAttribute(MessageStrings.CONV_VALUE) ? getStringAttribute(MessageStrings.CONV_VALUE)
				: "0.001");
		config.setItLimit(hasAttribute(MessageStrings.IT_LIMIT) ? getStringAttribute(MessageStrings.IT_LIMIT)
				: "50");
		config.setPrintInt(hasAttribute(MessageStrings.PRINT_INT) ? getStringAttribute(MessageStrings.PRINT_INT)
				: "10");
		config.setUnderCoeff(hasAttribute(MessageStrings.UNDER_COEFF) ? getStringAttribute(MessageStrings.UNDER_COEFF)
				: "0.5");
		
		config.setStopOnMessageLossLQNS(hasAttribute(MessageStrings.STOP_ON_MESSAGE_LOSS_LQNS) 
				? getBooleanAttribute(MessageStrings.STOP_ON_MESSAGE_LOSS_LQNS)
				: true);
		
		
		
		config.setDebugPerfEngine(hasAttribute(MessageStrings.DEBUG_PERF_ENG) 
				? getBooleanAttribute(MessageStrings.DEBUG_PERF_ENG)
				: false);
		
		config.setStopOnMessageLossLQSim(hasAttribute(MessageStrings.STOP_ON_MESSAGE_LOSS_LQSIM) 
				? getBooleanAttribute(MessageStrings.STOP_ON_MESSAGE_LOSS_LQSIM)
				: true);
		
		config.setInfiniteTaskMultiplicity(hasAttribute(MessageStrings.INFINITE_TASK_MULTIPLICITY) 
				? getBooleanAttribute(MessageStrings.INFINITE_TASK_MULTIPLICITY)
				: true);
				
		config.setShowHtmlResults(hasAttribute(MessageStrings.SHOW_HTML_RESULT)? 
				getBooleanAttribute(MessageStrings.SHOW_HTML_RESULT):
				true);
	}
}
