package de.uka.ipd.sdq.statistics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.statistics.independence.IIndependenceTest;
import de.uka.ipd.sdq.statistics.independence.RunUpTest;

/**
 * Implements a batch means procedure based on phi-mixing conditions as
 * described in [1]. Appropriate batch sizes and the number of batches are
 * determined automatically.
 * <p>
 * The procedure utilizes an independence test in order to build a so-called
 * "quasi independent" (QI) sample sequence. By default the {@link RunUpTest}
 * will be used. "The aim of the QI method is to continue the simulation run
 * until we have obtained a pre-specified number of essentially independent
 * random samples by skipping highly correlated observations." [1] As soon as
 * the QI sequence appears to be independent, the computed batches can be
 * considered as valid. Samples in the QI sequence are only used to determine
 * appropriate batch sizes. They are not used to compute the batch means!
 * Instead, the batch means consist of all samples, regardless of statistical
 * dependence.
 * <p>
 * [1] E. Chen, W. Kelton: A Stopping Procedure based on Phi-Mixing Conditions.
 * Proceedings of the 2000 Winter Simulation Conference.
 * 
 * @author Philipp Merkle
 * 
 */
public class PhiMixingBatchAlgorithm extends ABatchAlgorithm {

	private Logger logger;

	private IIndependenceTest independenceTest;

	private QuasiIndependentSampleSequence qiSamples;

	/** iteration number k */
	private int k = 0;

	/**
	 * number of quasi independent samples needed until the next iteration can
	 * start
	 */
	private int demandedQiSamples;

	/** total number of samples observed */
	private int totalSamples;

	private State state;

	public PhiMixingBatchAlgorithm() {
		this(new RunUpTest());
	}

	public PhiMixingBatchAlgorithm(IIndependenceTest test) {
		this.independenceTest = test;

		initialize();
	}

	private void initialize() {
		logger = Logger.getLogger("de.uka.ipd.sdq.statistics.PhiMixingBatchAlgorithm.log");

		qiSamples = new QuasiIndependentSampleSequence();

		state = new Iteration0();
	}

	@Override
	public void offerSample(double value) {
		state.offerSample(value);
	}

	private void setState(State state) {
		this.state = state;
	}

	/**
	 * Merges adjacent batches by taking their averages.
	 * 
	 * @param batches
	 */
	private void mergeAdjacentBatches(List<Batch> batches) {
		assert (batches.size() % 2 == 0);
		for (int i = 0; i < batches.size() / 2; i++) {
			Double mergedSum = batches.get(2 * i).getSum()
					+ batches.get(2 * i + 1).getSum();
			Integer mergedCount = batches.get(2 * i).getSize()
					+ batches.get(2 * i + 1).getSize();
			batches.set(i, new Batch(mergedSum, mergedCount));
		}
		batches.subList(batches.size() / 2, batches.size()).clear();
	}

	/**
	 * Computes batch means from the buffered data. Only applicable if the quasi
	 * independent sample sequence has lag 1 since otherwise the sequence does
	 * not represent all seen samples but a subset.
	 * 
	 * @param number
	 *            the number of batches to compute
	 */
	private void computeBatches(int number) {
		// TODO Ensure buffer.size() / batches is integer
		assert (qiSamples.size() % number == 0);
		int batchSize = qiSamples.size() / number;

		for (int i = 0; i < number; i++) {
			double batchSum = 0.0;
			int batchCount = 0;
			for (int j = 0; j < batchSize; j++) {
				int idx = i * batchSize + j;
				batchSum += qiSamples.get(idx);
				++batchCount;
			}

			batches.add(new Batch(batchSum, batchCount));
		}
	}

	private abstract class State {

		private static final int INITIALIZE = 1;

		private static final int READY = 2;

		private static final int FINISH = 1;

		private int internalState = INITIALIZE;

		abstract void start();

		public void offerSample(double sample) {
			if (internalState == INITIALIZE) {
				start();
				internalState = READY;
			}
			totalSamples++;
		}

		abstract void end();

		protected void changeState(State state) {
			internalState = FINISH;
			end();
			setState(state);
		}

		protected void independenceConditionalStateChange(int lag,
				State independent, State notIndependent) {
			if (independenceTest.testIndependence(qiSamples.lagSublist(lag))) {
				logger.info("Independence test passed. Batch means are valid.");
				if (batches.isEmpty())
					computeBatches(4);
				setValid(true);
				changeState(independent);
			} else {
				logger.info("Independence test not passed. Need more samples.");
				changeState(notIndependent);
			}
		}

		protected void logBatchStatus() {
			if (batches.isEmpty()) {
				logger.info("No batches determinined so far. Total samples "
						+ "seen: " + totalSamples);
			} else {
				logger.info("There are " + batches.size() + " batches of size "
						+ batches.get(0).getSize() + ". Total samples seen: "
						+ totalSamples);
			}
		}

	}

	private class Iteration0 extends State {

		public void start() {
			k = 0;
			logger.info("Start of iteration 0.");
			demandedQiSamples += 4000;
		}

		@Override
		public void offerSample(double sample) {
			super.offerSample(sample);
			qiSamples.offerSample(sample);
			if (demandedQiSamples == 0) {
				super.independenceConditionalStateChange(1,
						new IncreaseBatches(), new Iteration1a());
			}
		}

		public void end() {
			logger.info("End of iteration 0.");
			super.logBatchStatus();
		}

	}

	private class Iteration1a extends State {

		public void start() {
			logger.info("Start of iteration 1a");
			k = 1;
			demandedQiSamples += 4000;
		}

		@Override
		public void offerSample(double sample) {
			super.offerSample(sample);
			qiSamples.offerSample(sample);
			if (demandedQiSamples == 0) {
				super.independenceConditionalStateChange(2,
						new IncreaseBatches(), new Iteration1b());
			}
		}

		public void end() {
			logger.info("End of iteration 1a.");
			super.logBatchStatus();
		}

	}

	private class Iteration1b extends State {

		public void start() {
			logger.info("Start of iteration 1b");
			demandedQiSamples += 4000;
		}

		@Override
		public void offerSample(double sample) {
			super.offerSample(sample);
			qiSamples.offerSample(sample);
			if (demandedQiSamples == 0) {
				super.independenceConditionalStateChange(3,
						new IncreaseBatches(), new IterationKa());
			}
		}

		public void end() {
			logger.info("End of iteration 1b");
			super.logBatchStatus();
		}

	}

	private class IterationKa extends State {

		public void start() {
			++k;
			logger.info("Start of iteration " + k + "a.");
			if (batches.isEmpty()) {
				computeBatches(3);
			} else {
				assert (batches.size() == 3);
			}
			// prepare 4th batch mean
			batches.add(new Batch());
			// discard every 2nd sample
			qiSamples.discardAndRearrange();
			// obtain 2000 quasi independent samples...
			demandedQiSamples = 2000;
			// ...having lag 2^(k-1)
			qiSamples.setLag((int) Math.pow(2.0, k - 1));
		}

		@Override
		public void offerSample(double sample) {
			super.offerSample(sample);
			qiSamples.offerSample(sample);

			// batch means for iterations 0, 1(a) and 1(b) are calculated
			// directly from the buffer. For iterations k >= 2 we do no longer
			// store every observation in buffer because of a given lag. Hence
			// we need to adjust the current batch mean every observation.
			batches.get(batches.size() - 1).addSample(sample);

			if (demandedQiSamples == 0) {
				super.independenceConditionalStateChange(2,
						new IncreaseBatches(), new IterationKb());
			}
		}

		public void end() {
			logger.info("End of iteration " + k + "a.");
			super.logBatchStatus();
		}

	}

	private class IterationKb extends State {

		public void start() {
			logger.info("Start of iteration " + k + "b.");
			assert (batches.size() == 4);
			// reduce the number of batches from 4 to 2 by
			// taking average of adjacent batch means
			mergeAdjacentBatches(batches);
			// obtain 4000 quasi independent samples...
			demandedQiSamples = 4000;
			// ...having lag 2^(k-1)
			qiSamples.setLag((int) Math.pow(2.0, k - 1));
			// prepare 3rd batch mean
			batches.add(new Batch());
		}

		@Override
		public void offerSample(double sample) {
			super.offerSample(sample);
			qiSamples.offerSample(sample);

			// batch means for iterations 0, 1(a) and 1(b) are calculated
			// directly from the buffer. For iterations k >= 2 we do no longer
			// store every observation in buffer because of a given lag. Hence
			// we need to adjust the current batch mean every observation.
			batches.get(batches.size() - 1).addSample(sample);

			if (demandedQiSamples == 0) {
				super.independenceConditionalStateChange(3,
						new IncreaseBatches(), new IterationKa());
			}
		}

		public void end() {
			logger.info("End of iteration " + k + "b.");
			super.logBatchStatus();
		}

	}

	private class IncreaseBatches extends State {

		private int demandedSamples;

		public void start() {
			logger.info("Start increasing batches.");

			if (batches.size() == 30) {
				mergeAdjacentBatches(batches);
			}

			batches.add(new Batch());
			int batchSize = batches.get(0).getSize();
			demandedSamples = batchSize;
		}

		@Override
		public void offerSample(double sample) {
			super.offerSample(sample);
			batches.get(batches.size() - 1).addSample(sample);
			--demandedSamples;

			if (demandedSamples == 0) {
				changeState(new IncreaseBatches());
			}
		}

		public void end() {
			logger.info("Stop increasing batches.");
			super.logBatchStatus();
		}

	}

	private class QuasiIndependentSampleSequence {

		/**
		 * buffer to store the quasi independent samples (i.e. a subset of the
		 * observation sequence)
		 */
		private List<Double> buffer;

		/** number of forthcoming observations to ignore until a sample is taken */
		private int lag;

		/** number of observations ignored */
		private int ignoredSamples;

		public QuasiIndependentSampleSequence() {
			buffer = new LinkedList<Double>();
			lag = 1;
		}

		public void setLag(int lag) {
			assert (lag >= 1);
			this.lag = lag;
		}

		public void offerSample(double sample) {
			if (ignoredSamples == lag - 1) {
				buffer.add(sample);

				--demandedQiSamples;
				ignoredSamples = 0;
			} else {
				++ignoredSamples;
				assert (ignoredSamples <= ignoredSamples);
			}
		}

		public double get(int index) {
			return buffer.get(index);
		}

		public int size() {
			return buffer.size();
		}

		public List<Double> lagSublist(int lag) {
			ArrayList<Double> res = new ArrayList<Double>();
			for (int i = 0; i < buffer.size(); i += lag) {
				res.add(buffer.get(i));
			}
			return res;
		}

		/**
		 * Discards every 2nd sample and rearranges the remaining samples in the
		 * first half of the buffer.
		 * 
		 * @param buffer
		 */
		public void discardAndRearrange() {
			for (int i = 0; i < buffer.size() / 2; i++) {
				buffer.set(i, buffer.get(2 * i));
			}
			buffer.subList(buffer.size() / 2, buffer.size()).clear();
		}

	}

}
