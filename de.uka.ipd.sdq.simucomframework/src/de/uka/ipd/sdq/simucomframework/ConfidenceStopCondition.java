package de.uka.ipd.sdq.simucomframework;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorListener;
import de.uka.ipd.sdq.probespec.framework.measurements.BasicMeasurement;
import de.uka.ipd.sdq.probespec.framework.measurements.Measurement;
import de.uka.ipd.sdq.probespec.framework.measurements.MeasurementSet;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;
import de.uka.ipd.sdq.statistics.IBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;
import de.uka.ipd.sdq.statistics.estimation.IConfidenceEstimator;

/**
 * Provides a stop condition which determines when to stop based on the
 * confidence interval around a point estimation (e.g. mean).
 *
 * @author Philipp Merkle, Sebastian Lehrig
 *
 */
public class ConfidenceStopCondition implements SimCondition, ICalculatorListener {

    private static final Logger logger = Logger.getLogger(ConfidenceStopCondition.class);

    private final SimuComModel model;

    private final String usageScenarioName;

    /** mean of the observations and the corresponding confidence interval */
    private ConfidenceInterval confidence;

    private boolean confidenceReached = false;

    private final IBatchAlgorithm batchAlgorithm;

    private final IConfidenceEstimator estimator;

    private final double confidenceLevel;

    private final double halfWidth;

    private int minBatches;

    /**
     *
     * @param model
     * @param batchAlgorithm
     * @param confidenceLevel
     *            the confidence level. Use values between 0 and 1.
     * @param halfWidth
     *            the relative half width of the target confidence interval. Use
     *            values between 0 and 1.
     */
    protected ConfidenceStopCondition(final SimuComModel model,
            final IBatchAlgorithm batchAlgorithm, final IConfidenceEstimator estimator,
            final double confidenceLevel, final double halfWidth) {
        this.model = model;
        this.batchAlgorithm = batchAlgorithm;
        this.estimator = estimator;
        this.confidenceLevel = confidenceLevel;
        this.halfWidth = halfWidth;

        if (model.getConfiguration()
                .getConfidenceModelElementName() == null){
            throw new RuntimeException("SimuCom tried to set up a ConfidenceStopCondition, but no usage scenario name was given to measure the confidence for.");
        }
        this.usageScenarioName = model.getConfiguration()
                .getConfidenceModelElementName();

        initialize();
    }

    private void initialize() {
        final Calculator c = obtainUsageScenarioResponseTimeCalculator(usageScenarioName);
        c.registerCalculatorListener(this);
        minBatches = 0;
    }

    @Override
    public boolean check() {
        return confidenceReached;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void measurementTaken(final Measurement resultTuple) {
        final MeasurementSet resultSet = (MeasurementSet) resultTuple;
        final BasicMeasurement<Double, Duration> basicMeasurement = (BasicMeasurement<Double, Duration>) resultSet.getSubsumedMeasurements().get(0);
        final Measure<Double, Duration> responseTimeMeasure = basicMeasurement.getMeasure();
        final double responseTime = responseTimeMeasure.doubleValue(SI.SECOND);

        batchAlgorithm.offerSample(responseTime);
        if (batchAlgorithm.hasValidBatches()
                && batchAlgorithm.getBatchMeans().size() >= minBatches) {
            // estimate actual confidence interval
            final ConfidenceInterval ci = estimator.estimateConfidence(
                    batchAlgorithm.getBatchMeans(), confidenceLevel);

            if (ci != null){
                // construct target confidence interval
                final ConfidenceInterval targetCI = new ConfidenceInterval(ci
                        .getMean(), halfWidth, confidenceLevel);

                if (targetCI.contains(ci)) {
                    if(logger.isEnabledFor(Level.INFO)) {
                        logger.info("Requested confidence reached.");
                    }
                    confidenceReached = true;
                    this.confidence = ci;

                    // request another batch in order to proceed with improving
                    // confidence interval's half-width until the simulation
                    // actually stops.
                    minBatches = batchAlgorithm.getBatchMeans().size() + 1;
                } else {
                    if(logger.isEnabledFor(Level.INFO)) {
                        logger.info("Requested confidence not yet reached.");
                    }

                    // request another batch in order to reduce the confidence
                    // interval's half-width
                    minBatches = batchAlgorithm.getBatchMeans().size() + 1;
                }
                if(logger.isEnabledFor(Level.INFO)) {
                    logger.info("Current confidence interval: Mean " + ci.getMean()
                            + ", " + confidenceLevel * 100
                            + "% Confidence Interval " + "[" + ci.getLowerBound()
                            + "," + ci.getUpperBound() + "]");
                }
            }
        }
    }

    public ConfidenceInterval getConfidence() {
        return confidence;
    }

    /**
     * Returns the calculator for the specified usage scenario's response time.
     *
     * @param usageScenarioName
     *            the name of the usage scenario
     * @return
     */
    private Calculator obtainUsageScenarioResponseTimeCalculator(
            final String usageScenarioName) {
        final String calculatorId = usageScenarioName;
        return this.model.getProbeSpecContext().getCalculatorByName(calculatorId);
    }

    @Override
    public void preUnregister() {
        // TODO Auto-generated method stub
    }

}
