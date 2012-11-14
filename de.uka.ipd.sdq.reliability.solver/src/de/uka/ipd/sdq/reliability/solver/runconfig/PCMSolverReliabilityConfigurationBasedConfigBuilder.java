package de.uka.ipd.sdq.reliability.solver.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.reliability.core.MarkovEvaluationType;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * This class can build PCM reliability solver specific configuration objects out of a given Eclipse
 * Launch Configuration.
 * 
 * @author brosch
 * 
 */
public class PCMSolverReliabilityConfigurationBasedConfigBuilder extends AbstractWorkflowConfigurationBuilder {

    /**
     * The constructor takes an Eclipse Launch Configuration object.
     * 
     * @param configuration
     *            the Eclipse Launch Configuration object
     * @param mode
     *            distinguishes between debug mode and normal mode
     * @throws CoreException
     *             the access of attributes of the Eclipse Launch Configuration object might lead to
     *             a CoreException
     */
    public PCMSolverReliabilityConfigurationBasedConfigBuilder(final ILaunchConfiguration configuration,
            final String mode) throws CoreException {
        super(configuration, mode);
    }

    @Override
    public void fillConfiguration(final AbstractWorkflowBasedRunConfiguration configuration) throws CoreException {

        // We assume that we got a PCMSolverWorkflowRunConfiguration object:
        PCMSolverWorkflowRunConfiguration config = (PCMSolverWorkflowRunConfiguration) configuration;

        // This is a reliability analysis:
        config.setReliabilityAnalysis(true);

        // Set further properties of the reliability analysis:
        config.setPrintMarkovStatistics(hasAttribute(MessageStrings.MARKOV_STATISTICS) ? getBooleanAttribute(MessageStrings.MARKOV_STATISTICS)
                : false);
        config.setPrintMarkovSingleResults(hasAttribute(MessageStrings.SINGLE_RESULTS) ? getBooleanAttribute(MessageStrings.SINGLE_RESULTS)
                : false);
        config.setSensitivityModelEnabled(hasAttribute(ConstantsContainer.DO_SENSITIVITY_ANALYSIS) ? getBooleanAttribute(ConstantsContainer.DO_SENSITIVITY_ANALYSIS)
                : ConstantsContainer.DEFAULT_DO_SENSITIVITY_ANALYSIS);
        config.setSensitivityModelFileName(hasAttribute(ConstantsContainer.SENSITIVITY_MODEL_FILE) ? getStringAttribute(ConstantsContainer.SENSITIVITY_MODEL_FILE)
                : ConstantsContainer.DEFAULT_SENSITIVITY_MODEL_FILE);
        config.setSensitivityLogFileName(hasAttribute(ConstantsContainer.SENSITIVITY_LOG_FILE) ? getStringAttribute(ConstantsContainer.SENSITIVITY_LOG_FILE)
                : ConstantsContainer.DEFAULT_SENSITIVITY_LOG_FILE);
        config.setLogFile(hasAttribute(MessageStrings.LOG_FILE) ? getStringAttribute(MessageStrings.LOG_FILE) : null);
        config.setNumberOfEvaluatedSystemStatesEnabled(hasAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED) ? getBooleanAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES_ENABLED)
                : false);
        config.setNumberOfEvaluatedSystemStates(hasAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES) ? getLongAttribute(MessageStrings.NUMBER_OF_EVALUATED_SYSTEM_STATES)
                : 0);
        config.setNumberOfExactDecimalPlacesEnabled(hasAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED) ? getBooleanAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES_ENABLED)
                : false);
        config.setNumberOfExactDecimalPlaces(hasAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES) ? getIntegerAttribute(MessageStrings.NUMBER_OF_EXACT_DECIMAL_PLACES)
                : 0);
        config.setSolvingTimeLimitEnabled(hasAttribute(MessageStrings.SOLVING_TIME_LIMIT_ENABLED) ? getBooleanAttribute(MessageStrings.SOLVING_TIME_LIMIT_ENABLED)
                : false);
        config.setSolvingTimeLimit(hasAttribute(MessageStrings.SOLVING_TIME_LIMIT) ? getIntegerAttribute(MessageStrings.SOLVING_TIME_LIMIT)
                : 0);
        config.setMarkovModelReductionEnabled(hasAttribute(MessageStrings.MARKOV_MODEL_REDUCTION_ENABLED) ? getBooleanAttribute(MessageStrings.MARKOV_MODEL_REDUCTION_ENABLED)
                : true);
        config.setMarkovModelTracesEnabled(hasAttribute(MessageStrings.MARKOV_MODEL_TRACES_ENABLED) ? getBooleanAttribute(MessageStrings.MARKOV_MODEL_TRACES_ENABLED)
                : false);
        config.setMarkovModelStorageEnabled(hasAttribute(MessageStrings.MARKOV_MODEL_STORAGE_ENABLED) ? getBooleanAttribute(MessageStrings.MARKOV_MODEL_STORAGE_ENABLED)
                : false);
        config.setIterationOverPhysicalSystemStatesEnabled(hasAttribute(MessageStrings.ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED) ? getBooleanAttribute(MessageStrings.ITERATION_OVER_PHYSICAL_SYSTEM_STATES_ENABLED)
                : true);
        config.setMarkovModelFile(hasAttribute(MessageStrings.MARKOV_MODEL_FILE) ? getStringAttribute(MessageStrings.MARKOV_MODEL_FILE)
                : null);
        config.setMarkovEvaluationMode(hasAttribute(MessageStrings.MARKOV_EVALUATION_MODE) ? getStringAttribute(MessageStrings.MARKOV_EVALUATION_MODE)
                : MarkovEvaluationType.POINTSOFFAILURE.toString()); // POINTSOFFAILURE
        // will
        // be
        // default
        // evaluation
        // mode
        // if
        // attribute
        // cannot
        // be
        // found
        config.setSaveResultsToFileEnabled(hasAttribute(MessageStrings.SAVE_RESULTS_TO_FILE_ENABLED) ? getBooleanAttribute(MessageStrings.SAVE_RESULTS_TO_FILE_ENABLED)
                : true);
        config.setSaveFile(hasAttribute(MessageStrings.SAVE_FILE_DEFAULT) ? getStringAttribute(MessageStrings.SAVE_FILE_DEFAULT)
                : null);
    }

}
