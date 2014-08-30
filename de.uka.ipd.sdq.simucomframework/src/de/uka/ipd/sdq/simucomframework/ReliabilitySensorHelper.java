package de.uka.ipd.sdq.simucomframework;

import org.palladiosimulator.probeframework.measurement.RequestContext;

import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * This class provides auxiliary functionality for capturing reliability-relevant sensor data during
 * the simulation.
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
     *            the ID of the PCM model element representing the usage scenario
     * @return the corresponding ProbeSet ID
     */
    public static String getScenarioProbeSetId(final String usageScenarioId) {
        return SCENARIO_RESULT_PROBESET_ID + "/" + usageScenarioId;
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
     *            the simulation control object, keeping the current simulated time
     * @param requestContext
     *            the identification of the request context
     */
    public static synchronized void recordExternalCallResult(final String callName, final String externalCallId,
            final FailureException exception, final SimuComModel model, final RequestContext requestContext) {
        // TODO FIXME
        // IProbeStrategy takeTimeStrategy = model.getProbeFrameworkContext()
        // .getProbeStrategyRegistry().getProbeStrategy(
        // ProbeType.CURRENT_TIME, null);
        // IProbeStrategy takeResultStrategy = model.getProbeFrameworkContext()
        // .getProbeStrategyRegistry().getProbeStrategy(
        // ProbeType.EXECUTION_RESULT, null);
        // MarkovFailureType failureType = (exception == null) ? null : exception
        // .getFailureType();
        // int stateId = FailureStatistics.getInstance().getExecutionResultId(
        // failureType);
        // int probeSetId = model.getProbeFrameworkContext().obtainProbeSetId(callName);
        // BasicMeasurement<?, ? extends Quantity> timeSample = takeTimeStrategy
        // .takeSample(EXTERNAL_CALL_RESULT_TIME_PROBE_ID + "/"
        // + probeSetId, model.getSimulationControl());
        // BasicMeasurement<?, ? extends Quantity> stateSample = takeResultStrategy
        // .takeSample(EXTERNAL_CALL_RESULT_STATE_PROBE_ID + "/"
        // + probeSetId, stateId);
        // MeasurementSet sample = ProbeFrameworkUtils.buildProbeSetSample(timeSample,
        // stateSample, requestContext, externalCallId, probeSetId);
        // model.getProbeFrameworkContext().getSampleBlackboard().addSample(sample);
    }
}
