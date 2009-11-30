package de.uka.ipd.sdq.simucomframework;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.SensorHelper;
import de.uka.ipd.sdq.simucomframework.sensors.SimuComExperimentRunDecorator;
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
public class ConfidenceStopCondition extends Condition implements Observer {

	private static Logger logger;

	private SimuComModel model;

	private String usageScenarioName;

	/** usage scenario response time sensor */
	private Sensor sensor;

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
		super(model, "Confidence Stop Condition");

		this.model = model;
		this.batchAlgorithm = batchAlgorithm;
		this.estimator = estimator;
		this.confidenceLevel = confidenceLevel;
		this.halfWidth = halfWidth;
		
		if (model.getConfig()
				.getConfidenceModelElementName() == null){
			throw new RuntimeException("SimuCom tried to set up a ConfidenceStopCondition, but no usage scenario name was given to measure the confidence for.");
		}
		this.usageScenarioName = model.getConfig()
				.getConfidenceModelElementName();

		initialize();
	}

	private void initialize() {
		// TODO Remove log4j initialization --------
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
		// ------------------------------------------
		logger = Logger.getLogger(ConfidenceStopCondition.class.getName());

		// observe run in order to obtain measurements
		if (model.getCurrentExperimentRun() instanceof SimuComExperimentRunDecorator) {
			((SimuComExperimentRunDecorator) model.getCurrentExperimentRun())
					.addObserver(this);
		} else {
			// TODO Use "own" exception!?
			throw new RuntimeException(
					"Could not register as observer. ExperimentRun is of type "
							+ model.getCurrentExperimentRun().getClass()
							+ " but SimuComExperimentRunDecorator is expected.");
		}

		this.sensor = obtainUsageScenarioSensor(usageScenarioName);
		logger.info("Using Sensor: " + sensor.getSensorID() + "(ID) "
				+ sensor.getSensorName());

		minBatches = 0;
	}

	@Override
	public boolean check() {
		return confidenceReached;
	}

	@Override
	public void update(Observable obs, Object obj) {
		// process only time spans
		if (containsTimeSpanSensor(obj, sensor)) {
			SimuComExperimentRunDecorator.DecoratorTimeSpanMeasurement m = (SimuComExperimentRunDecorator.DecoratorTimeSpanMeasurement) obj;

			batchAlgorithm.offerSample(m.getTimeSpan());
			if (batchAlgorithm.hasValidBatches()
					&& batchAlgorithm.getBatchMeans().size() >= minBatches) {
				// estimate actual confidence interval
				ConfidenceInterval ci = estimator.estimateConfidence(
						batchAlgorithm.getBatchMeans(), confidenceLevel);

				// construct target confidence interval
				ConfidenceInterval targetCI = new ConfidenceInterval(ci
						.getMean(), halfWidth, confidenceLevel);

				if (targetCI.contains(ci)) {
					logger.info("Requested confidence reached.");
					confidenceReached = true;
					this.confidence = ci;
					
					// request another batch in order to proceed with improving
					// confidence interval's half-width until the simulation
					// actually stops.
					minBatches = batchAlgorithm.getBatchMeans().size() + 1;
				} else {
					logger.info("Requested confidence not yet reached.");
					
					// request another batch in order to reduce the confidence
					// interval's half-width
					minBatches = batchAlgorithm.getBatchMeans().size() + 1;
				}
				logger.info("Current confidence Inerval: Mean " + ci.getMean()
						+ ", " + confidenceLevel * 100
						+ "% Confidence Interval " + "[" + ci.getLowerBound()
						+ "," + ci.getUpperBound() + "]");
			}
		}
	}

	/**
	 * Checks whether the specified time span sensors are equal. (TOD extend)
	 * 
	 * @param obj
	 * @param sensor
	 * @return
	 */
	private boolean containsTimeSpanSensor(Object obj, Sensor sensor) {
		if (obj instanceof SimuComExperimentRunDecorator.DecoratorTimeSpanMeasurement) {
			SimuComExperimentRunDecorator.DecoratorTimeSpanMeasurement m = (SimuComExperimentRunDecorator.DecoratorTimeSpanMeasurement) obj;
			Sensor s = m.getSensor();

			if (s == sensor) {
				return true;
			}
		}
		return false;
	}

	public ConfidenceInterval getConfidence() {
		return confidence;
	}

	/**
	 * Returns the sensor for the specified usage scenario's response time.
	 * 
	 * @param usageScenarioName
	 *            the name of the usage scenario
	 * @return
	 */
	private Sensor obtainUsageScenarioSensor(String usageScenarioName) {
		return SensorHelper.createOrReuseTimeSensor(model.getDAOFactory(),
				model.getExperimentDatastore(), "Response Time of "
						+ usageScenarioName);
	}

}
