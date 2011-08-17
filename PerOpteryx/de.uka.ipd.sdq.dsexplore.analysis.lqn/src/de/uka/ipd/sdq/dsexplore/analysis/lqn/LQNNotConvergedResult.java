package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import de.uka.ipd.sdq.dsexplore.analysis.AbstractPerformanceAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

public class LQNNotConvergedResult extends AbstractPerformanceAnalysisResult implements ILQNResult{

		public LQNNotConvergedResult(PCMInstance model) {
		super(model);
	}

		@Override
		public double getCoefficientOfVariance() {
			return 0;
		}

		@Override
		public ConfidenceInterval getConfidenceInterval() {
			return null;
		}

		@Override
		public double getMedianValue() {
			return Double.POSITIVE_INFINITY;
		}

		@Override
		public long getNumberOfObservations() {
			return 0;
		}

		@Override
		public double getStandardDeviation() {
			return 0;
		}

		@Override
		public int compareTo(IAnalysisResult other) {
			if (other.getMeanValue() == Double.POSITIVE_INFINITY)
				return 0;
			return Integer.MAX_VALUE;
		}

		@Override
		public double getMeanValue() {
			return Double.POSITIVE_INFINITY;
		}

		@Override
		public ResultDecoratorRepository getResults() {
			return null;
		}

		@Override
		public double getSquaredCoefficientOfVariance() {
			return 0;
		}

		@Override
		public double getVariance() {
			return 0;
		}


		
	
}
