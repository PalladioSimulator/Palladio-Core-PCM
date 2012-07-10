package de.uka.ipd.sdq.simucomframework;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * This class provides auxiliary functionality for capturing
 * reliability-relevant sensor data during the simulation.
 * 
 * @author brosch
 * 
 */
public class ReliabilitySensorHelper {

	/**
	 * A ProbeSet ID for capturing the execution result of a usage scenario.
	 */
	private static final String SCENARIO_RESULT_PROBESET_ID = "scenarioRunProbeSet";

	/**
	 * A Probe ID for the value of a usage scenario execution result.
	 */
	private static final String SCENARIO_RESULT_STATE_PROBE_ID = "scenarioRunResultStateProbe";

	/**
	 * A Probe ID for the measurement time of a usage scenario execution result.
	 */
	private static final String SCENARIO_RESULT_TIME_PROBE_ID = "scenarioRunResultTimeProbe";

	/**
	 * A Probe ID for the value of an external call execution result.
	 */
	private static final String EXTERNAL_CALL_RESULT_STATE_PROBE_ID = "callResultStateProbe";

	/**
	 * A Probe ID for the measurement time of an external call execution result.
	 */
	private static final String EXTERNAL_CALL_RESULT_TIME_PROBE_ID = "callResultTimeProbe";

	/**
	 * Retrieves a usage-scenario-specific execution result ProbeSet ID.
	 * 
	 * @param usageScenarioId
	 *            the ID of the PCM model element representing the usage
	 *            scenario
	 * @return the corresponding ProbeSet ID
	 */
	public static String getScenarioProbeSetId(final String usageScenarioId) {
		return SCENARIO_RESULT_PROBESET_ID + "/" + usageScenarioId;
	}

	/**
	 * Records the execution result of a failed usage scenario run.
	 * 
     * @param model
     *            the simulation model providing access to the current 
     *            simulated time
	 * @param failureType
	 *            the type of failure-on-demand occurrence (NULL for success)
	 * @param requestContext
	 *            the identification of the request context
	 * @param usageScenarioId
	 *            the ID of the PCM model element representing the usage
	 *            scenario
	 */
	public static void recordScenarioRunResultFailure(
			final SimuComModel model,
			final MarkovFailureType failureType,
			final RequestContext requestContext, final String usageScenarioId) {
		recordScenarioResult(model, failureType, requestContext,
				usageScenarioId);
	}

	/**
	 * Records a successfully completed execution scenario run.
	 * 
     * @param model
     *            the simulation model providing access to the current 
     *            simulated time
	 * @param requestContext
	 *            the identification of the request context
	 * @param usageScenarioId
	 *            the ID of the PCM model element representing the usage
	 *            scenario
	 */
	public static synchronized void recordScenarioRunResultSuccess(
			final SimuComModel model,
			final RequestContext requestContext, final String usageScenarioId) {
		recordScenarioResult(model, null, requestContext, usageScenarioId);
	}

    /**
     * Records the execution result of a usage scenario run.
     * 
     * @param model
     *            the simulation model providing access to the current 
     *            simulated time
     * @param failureType
     *            the type of failure-on-demand occurrence (NULL for success)
     * @param requestContext
     *            the identification of the request context
     * @param usageScenarioId
     *            the ID of the PCM model element representing the usage scenario
     */
	private static void recordScenarioResult(
			final SimuComModel model,
			final MarkovFailureType failureType,
			final RequestContext requestContext, final String usageScenarioId) {
		IProbeStrategy takeTimeStrategy = model.getProbeSpecContext()
		        .getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.CURRENT_TIME, null);
		IProbeStrategy takeResultStrategy = model.getProbeSpecContext()
        .getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.EXECUTION_RESULT, null);
		int stateId = FailureStatistics.getInstance().getExecutionResultId(
				failureType);
		int probeSetId = model.getProbeSpecContext().obtainProbeSetId(
				getScenarioProbeSetId(usageScenarioId));
		ProbeSample<?, ? extends Quantity> timeSample = takeTimeStrategy
				.takeSample(SCENARIO_RESULT_TIME_PROBE_ID + "/"
						+ usageScenarioId, model.getSimulationControl());
		ProbeSample<?, ? extends Quantity> stateSample = takeResultStrategy
				.takeSample(SCENARIO_RESULT_STATE_PROBE_ID + "/"
						+ usageScenarioId, stateId);
		ProbeSetSample sample = ProbeSpecUtils.buildProbeSetSample(timeSample,
				stateSample, requestContext, usageScenarioId, probeSetId);
		model.getProbeSpecContext().getSampleBlackboard().addSample(sample);
	}

	/**
	 * Records the execution results of an external call action.
	 * 
	 * @param callName
	 *            the call name of the external call action
	 * @param externalCallId
	 *            the probe set id of the external call action
	 * @param exception
	 *            the occurred failure exception (if any)
	 * @param simControl
	 *            the simulation control object, keeping the current simulated
	 *            time
	 * @param requestContext
	 *            the identification of the request context
	 */
	public static synchronized void recordExternalCallResult(
			final String callName, final String externalCallId,
			final FailureException exception,
			final SimuComModel model,
			final RequestContext requestContext) {
		IProbeStrategy takeTimeStrategy = model.getProbeSpecContext()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.CURRENT_TIME, null);
		IProbeStrategy takeResultStrategy = model.getProbeSpecContext()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.EXECUTION_RESULT, null);
		MarkovFailureType failureType = (exception == null) ? null : exception
				.getFailureType();
		int stateId = FailureStatistics.getInstance().getExecutionResultId(
				failureType);
		int probeSetId = model.getProbeSpecContext().obtainProbeSetId(callName);
		ProbeSample<?, ? extends Quantity> timeSample = takeTimeStrategy
				.takeSample(EXTERNAL_CALL_RESULT_TIME_PROBE_ID + "/"
						+ probeSetId, model.getSimulationControl());
		ProbeSample<?, ? extends Quantity> stateSample = takeResultStrategy
				.takeSample(EXTERNAL_CALL_RESULT_STATE_PROBE_ID + "/"
						+ probeSetId, stateId);
		ProbeSetSample sample = ProbeSpecUtils.buildProbeSetSample(timeSample,
				stateSample, requestContext, externalCallId, probeSetId);
		model.getProbeSpecContext().getSampleBlackboard().addSample(sample);
	}
}
