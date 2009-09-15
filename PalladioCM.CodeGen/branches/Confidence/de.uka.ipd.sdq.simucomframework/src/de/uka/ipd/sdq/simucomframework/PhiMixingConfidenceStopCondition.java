package de.uka.ipd.sdq.simucomframework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import umontreal.iro.lecuyer.probdist.StudentDist;

import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.SensorHelper;
import de.uka.ipd.sdq.simucomframework.sensors.SimuComExperimentRunDecorator;

/**
 * Provides a stop condition which determines when to stop based on confidence intervals.
 * 
 * TODO Short description of the algorithm
 * TODO Consider warm up phase.
 * 
 * @author Philipp Merkle
 * 
 */
public class PhiMixingConfidenceStopCondition extends Condition implements
		Observer {

	private SimuComModel model;

	private AIndependenceVerifier<Double> verifier;
	
	private double alpha;

	/**
	 * buffer to store the quasi independent samples (i.e. a subset of the
	 * observation sequence)
	 */
	private List<Double> buffer;

	/** iteration number k */
	private int k = 0;

	/**
	 * indicates the sub iteration of k. Switched between 0 and 1 representing
	 * sub iterations "A" and "B".
	 */
	private int kSub = 0;

	/** number of samples needed until the algorithm can proceed */
	private int demandedSamples;

	/** number of forthcoming observations to ignore until a sample is taken */
	private int ignoreObs;

	/** number of observations ignored */
	private int ignoredObs;

	/** number of observations seen */
	private int totalObs;

	private int lag;

	// TODO set the usage scenario name via launch configuration
	// private String usageScenarioName = "BRS_usage_scenario";
	private String usageScenarioName = "defaultUsageScenario";

	/** usage scenario response time sensor */
	private Sensor sensor;

	/** mean of the observations and the corresponding confidence interval */
	private ConfidenceInterval confidence;

	private boolean confidenceReached = false;

	/**
	 * batch means, represented by pairs of sum and count. The mean can then be
	 * obtained by calculate sum / count.
	 */
	private List<Pair<Double, Integer>> batchMeans;

	protected PhiMixingConfidenceStopCondition(SimuComModel model,
			AIndependenceVerifier<Double> verifier, double alpha) {
		super(model, "Phi Mixing Confidence Stop Condition");

		this.model = model;
		this.verifier = verifier;
		this.alpha = alpha;

		initialize();
	}

	private void initialize() {
		buffer = new LinkedList<Double>();
		batchMeans = new ArrayList<Pair<Double, Integer>>();

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
		// TODO: Use Log4J
		System.out.println("Using Sensor: " + sensor.getSensorID() + "(ID) "
				+ sensor.getSensorName());
	}

	@Override
	public boolean check() {
		return confidenceReached;
	}

	@Override
	public void update(Observable obs, Object obj) {
		if (containsTimeSpanSensor(obj, sensor)) {
			SimuComExperimentRunDecorator.DecoratorTimeSpanMeasurement m = (SimuComExperimentRunDecorator.DecoratorTimeSpanMeasurement) obj;
			totalObs++;

			// batch means for iterations 0, 1(a) and 1(b) are calculated
			// directly from the buffer. For iterations k > 2 we do no longer
			// store every observation in buffer because of a given lag. Hence
			// we need to adjust the current batch mean every observation.
			if (k > 2 || (k == 2 && kSub == 1)) {
//				if (batchMeans.isEmpty()) {
//					computeBatches(3);
//					// prepare 4th batch mean [Step 7.3]
//					batchMeans.add(new Pair<Double, Integer>(0.0, 0));
//				}
				
				// add observation to the last batch mean.
				Pair<Double, Integer> batchMean = batchMeans.get(batchMeans
						.size()-1);
				batchMean.setFirst(batchMean.getFirst() + m.getTimeSpan());
				batchMean.setSecond(batchMean.getSecond() + 1);
			}

			if (ignoredObs == ignoreObs) {
				// add observation to buffer
				buffer.add(m.getTimeSpan());

				--demandedSamples;
				ignoredObs = 0;
			} else {
				++ignoredObs;
				assert (ignoredObs <= ignoredObs);
			}

			if (demandedSamples <= 0) {
				// Check, whether the buffered samples seems to be statistically
				// independent. For sub iteration "A" (resp. 0) use every 2nd
				// sample (=> lag 2), and for "B" (resp. 1) use every 3rd sample
				// (=> lag 3).
				if (k > 0 && verifier.verifyIndependence(buffer, lag)) {
					// TODO Use Log4J
					System.out.println("Independence test passed.");
					if (totalObs <= 12000) { // [Step 10]
						computeBatches(4);
					}
					// [Step 11]
					double grandMean = computePointMeanEstimator();
					// [Step 12]
					ConfidenceInterval ci = computeConfidenceInterval(
							grandMean, alpha);
					// [Step 13]
					if (checkHalfWidth()) { // TODO
						confidenceReached = true;
						System.out.println("Confidence reached. Stop "
								+ "Simulation. (Mean: " + ci.getMean() + ", "
								+ (1 - alpha) * 100 + "% Confidence Interval: "
								+ "[" + ci.getLowerBound() + ","
								+ ci.getUpperBound() + "])");
					}
				}
				else {
					// for k == 0 we intentionally do not run a independence test
					if (k > 0) {
						// TODO Use Log4J
						System.out.println("Independence test not passed.");
					}
				}
				
				if (k == 0) { // begin 0-th iteration?
					demandedSamples += 4000;
					lag = 1;
					++k;
				} else if (k == 1) {
					if (kSub == 0) { // begin 1st (a) iteration?
						// obtain 4000 samples [Step 6]
						demandedSamples += 4000;
						lag = 2;
						// adjust iteration counter
						kSub = 1;
					} else { // begin 1st (b) iteration?
						// obtain 4000 samples [Step 6]
						demandedSamples += 4000;
						lag = 3;
						// adjust iteration counter
						kSub = 0;
						++k;
					}
				} else if (k >= 2) {
					if (kSub == 0) { // begin kth (a) iteration?
						if (batchMeans.isEmpty()) {	// TODO Check, whether obsolete
							computeBatches(3);
						} else {
							assert (batchMeans.size() == 3);
						}
						// prepare 4th batch mean [Step 7.3]
						batchMeans.add(new Pair<Double, Integer>(0.0, 0));
						// discard every 2nd sample [Step 7.1]
						discardAndRearrange(buffer);
						// obtain 2000 samples having lag 2^(k-1) [Step 7.2]
						demandedSamples = 2000;
						ignoreObs = (int) Math.pow(2.0, k - 1) - 1;
						ignoredObs = 0;
						
						// adjust iteration counter
						kSub = 1;

					} else { // begin kth (b) iteration?
						assert (batchMeans.size() == 4);
						// reduce the number of batches from 4 to 2 by
						// taking average of adjacent batch means [Step 8.1]
						mergeAdjacentMeans(batchMeans);
						// obtain 4000 samples having lag 2^(k-1) [Step 8.2]
						demandedSamples = 4000;
						ignoreObs = (int) Math.pow(2.0, k - 1) - 1;
						ignoredObs = 0;
						// prepare 3rd batch mean [Step 8.3]
						batchMeans.add(new Pair<Double, Integer>(0.0, 0));
						// adjust iteration counter
						kSub = 0;
						++k;
					}
				}
			}
		}
	}

	public ConfidenceInterval getConfidence() {
		return confidence;
	}

	/**
	 * Merges adjacent means by taking their averages.
	 * 
	 * @param means
	 */
	private void mergeAdjacentMeans(List<Pair<Double, Integer>> means) {
		assert(means.size() % 2 == 0);
		for (int i = 0; i < means.size() / 2; i++) {
			Pair<Double, Integer> mergedMean = null;
			Double mergedSum = means.get(2 * i).getFirst()
					+ means.get(2 * i + 1).getFirst();
			Integer mergedCount = means.get(2 * i).getSecond()
					+ means.get(2 * i + 1).getSecond();
			mergedMean = new Pair<Double, Integer>(mergedSum, mergedCount);
			means.set(i, mergedMean);
		}
		means.subList(means.size() / 2, means.size()).clear();
	}

	/**
	 * Discards every 2nd sample and rearranges the remaining samples in the
	 * first half of the buffer.
	 * 
	 * @param buffer
	 */
	private void discardAndRearrange(List<Double> buffer) {
		for (int i = 0; i < buffer.size() / 2; i++) {
			buffer.set(i, buffer.get(2 * i));
		}
		buffer.subList(buffer.size() / 2, buffer.size()).clear();
	}

	/**
	 * Computes batch means from the buffered data.
	 * 
	 * @param batches
	 *            the number of batches to compute
	 */
	private void computeBatches(int batches) {
		// TODO Ensure buffer.size() / batches is integer
		assert(buffer.size() % batches == 0);
		int batchSize = buffer.size() / batches;

		for (int i = 0; i < batches; i++) {
			double batchSum = 0.0;
			int batchCount = 0;
			for (int j = 0; j < batchSize; j++) {
				int idx = i * batchSize + j;
				batchSum += buffer.get(idx);
				++batchCount;
			}
			batchMeans.add(new Pair<Double, Integer>(batchSum, batchCount));
		}
	}

	/**
	 * TODO comment
	 * 
	 * @return
	 */
	private double computePointMeanEstimator() {
		double grandMeanSum = 0.0;
		for (Pair<Double, Integer> mean : batchMeans) {
			grandMeanSum += mean.getFirst() / mean.getSecond();
		}
		return grandMeanSum / batchMeans.size();
	}

	/**
	 * Computes the 100*(1-alpha)% confidence interval for the specified mean.
	 * 
	 * @param alpha
	 * @return
	 */
	private ConfidenceInterval computeConfidenceInterval(double grandMean,
			double alpha) {

		int degreesOfFreedom = batchMeans.size() - 1;
		StudentDist dist = new StudentDist(degreesOfFreedom);
		double upperQuantile = dist.inverseF(1 - alpha);

		// calculate sample variance
		double sum = 0.0;
		for (Pair<Double, Integer> mean : batchMeans) {
			double batchMean = mean.getFirst() / mean.getSecond();
			sum += Math.pow(batchMean - grandMean, 2.0);
		}
		double sampleVariance = 1.0 / (batchMeans.size() - 1) * sum;

		// calculate sample standard deviation
		double sampleStdDev = Math.sqrt(sampleVariance);

		// calculate and return confidence interval
		double lowerBound = grandMean - upperQuantile * sampleStdDev
				/ Math.sqrt(batchMeans.size());
		double upperBound = grandMean + upperQuantile * sampleStdDev
				/ Math.sqrt(batchMeans.size());
		return new ConfidenceInterval(grandMean, lowerBound, upperBound);
	}

	// Schritt 13
	private boolean checkHalfWidth() {
		// TODO
		return true;
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

	private class Pair<T, S> {

		private T first;

		private S second;

		public Pair(T first, S second) {
			super();
			this.first = first;
			this.second = second;
		}

		public T getFirst() {
			return first;
		}

		public void setFirst(T first) {
			this.first = first;
		}

		public S getSecond() {
			return second;
		}

		public void setSecond(S second) {
			this.second = second;
		}

	}

}
