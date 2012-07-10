package de.uka.ipd.sdq.simucomframework;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorListener;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;
import de.uka.ipd.sdq.statistics.IBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;
import de.uka.ipd.sdq.statistics.estimation.IConfidenceEstimator;

/**
 * Provides a stop condition which determines when to stop based on the
 * confidence interval around a point estimation (e.g. mean).
 *
 * @author Philipp Merkle
 *
 */
public class ConfidenceStopCondition implements SimCondition, ICalculatorListener {

	private static final Logger logger = Logger.getLogger(ConfidenceStopCondition.class);

	private SimuComModel model;

	private String usageScenarioName;

	/** mean of the observations and the corresponding confidence interval */
	private ConfidenceInterval confidence;

	private boolean confidenceReached = false;

	private IBatchAlgorithm batchAlgorithm;

	private IConfidenceEstimator estimator;

	private double confidenceLevel;

	private double halfWidth;

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
	protected ConfidenceStopCondition(SimuComModel model,
			IBatchAlgorithm batchAlgorithm, IConfidenceEstimator estimator,
			double confidenceLevel, double halfWidth) {
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
		Calculator c = obtainUsageScenarioResponseTimeCalculator(usageScenarioName);
		c.addCalculatorListener(this);
		minBatches = 0;
	}

	@Override
	public boolean check() {
		return confidenceReached;
	}

	public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple) {
		Measure<Double, Duration> responseTimeMeasure = (Measure<Double, Duration>) resultTuple.get(0);
		double responseTime = responseTimeMeasure.doubleValue(SI.SECOND);

		batchAlgorithm.offerSample(responseTime);
		if (batchAlgorithm.hasValidBatches()
				&& batchAlgorithm.getBatchMeans().size() >= minBatches) {
			// estimate actual confidence interval
			ConfidenceInterval ci = estimator.estimateConfidence(
					batchAlgorithm.getBatchMeans(), confidenceLevel);

			if (ci != null){
				// construct target confidence interval
				ConfidenceInterval targetCI = new ConfidenceInterval(ci
						.getMean(), halfWidth, confidenceLevel);

				if (targetCI.contains(ci)) {
					if(logger.isEnabledFor(Level.INFO))
						logger.info("Requested confidence reached.");
					confidenceReached = true;
					this.confidence = ci;

					// request another batch in order to proceed with improving
					// confidence interval's half-width until the simulation
					// actually stops.
					minBatches = batchAlgorithm.getBatchMeans().size() + 1;
				} else {
					if(logger.isEnabledFor(Level.INFO))
						logger.info("Requested confidence not yet reached.");

					// request another batch in order to reduce the confidence
					// interval's half-width
					minBatches = batchAlgorithm.getBatchMeans().size() + 1;
				}
				if(logger.isEnabledFor(Level.INFO))
					logger.info("Current confidence interval: Mean " + ci.getMean()
						+ ", " + confidenceLevel * 100
						+ "% Confidence Interval " + "[" + ci.getLowerBound()
						+ "," + ci.getUpperBound() + "]");
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
			String usageScenarioName) {
		String calculatorId = usageScenarioName;
        return this.model.getProbeSpecContext().getCalculatorRegistry().getCalculatorForId(calculatorId);		
	}

}
