package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import org.opt4j.core.Constraint;
import org.opt4j.core.Criterion;
import org.opt4j.core.Objective;
import org.opt4j.core.Constraint.Direction;
import org.opt4j.core.Objective.Sign;

import de.uka.ipd.sdq.dsexplore.analysis.AbstractPerformanceAnalysisResult;
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
		public double getMeanValue() {
			return Double.POSITIVE_INFINITY;
		}
		
		@Override
		public double getValueFor(Criterion criterion) {
			if (criterion instanceof Objective){
				if (((Objective)criterion).getSign() == Sign.MIN){
					return Double.POSITIVE_INFINITY;
				} else {
					return Double.NEGATIVE_INFINITY;
				}
			} else if (criterion instanceof Constraint){
				if (((Constraint)criterion).getDirection() == Direction.less
					|| ((Constraint)criterion).getDirection() == Direction.lessOrEqual
					|| ((Constraint)criterion).getDirection() == Direction.equal){
					return Double.POSITIVE_INFINITY;
				} else {
					return Double.NEGATIVE_INFINITY;
				}
			}
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
