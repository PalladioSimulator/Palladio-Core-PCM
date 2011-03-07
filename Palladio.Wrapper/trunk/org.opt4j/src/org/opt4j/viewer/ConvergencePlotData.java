/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */
package org.opt4j.viewer;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.opt4j.core.Individual;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;
import org.opt4j.core.problem.Evaluator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The {@code ConvergencePlotData} contains information about the convergence of
 * the current optimization.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
public class ConvergencePlotData implements IndividualStateListener,
		OptimizerIterationListener {

	protected Map<Objective, PlotDataObjective> map = new HashMap<Objective, PlotDataObjective>();

	protected int iteration = 0;

	/**
	 * The {@code PlotDataObjective} contains the convergence information of a
	 * single {@code Objective}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class PlotDataObjective {
		protected final Objective objective;
		protected final List<Point2D.Double> values = new CopyOnWriteArrayList<Point2D.Double>();
		protected double lastValue;
		protected final int MAXVALUES = 130;

		PlotDataObjective(Objective objective) {
			this.objective = objective;
			if (objective.getSign() == Sign.MIN) {
				lastValue = Double.MAX_VALUE;
			} else {
				lastValue = Double.MIN_VALUE;
			}

		}

		public void update(Objectives objectives) {
			Value<?> value = objectives.get(objective);
			Object v = value.getValue();

			if (v != null && v instanceof Number) {
				Number n = (Number) v;
				double nextValue = n.doubleValue();
				if (objective.getSign() == Sign.MIN && nextValue < lastValue) {
					lastValue = nextValue;
				} else if (objective.getSign() == Sign.MAX
						&& nextValue > lastValue) {
					lastValue = nextValue;
				}
			}

		}

		protected synchronized void simplify() {
			if (values.size() > MAXVALUES) {
				List<Point2D.Double> copy = new ArrayList<Point2D.Double>(
						values);

				final Map<Point2D.Double, Double> dist = new HashMap<Point2D.Double, Double>();
				for (int i = 1; i < copy.size() - 1; i += 2) {
					Point2D.Double p0 = copy.get(i - 1);
					Point2D.Double p1 = copy.get(i);
					Point2D.Double p2 = copy.get(i + 1);

					double slope = (p2.y - p0.y) / (p2.x - p0.x);

					double y = p0.y + slope * (p1.x - p0.x);

					double v = Math.abs(y - p1.y);
					dist.put(p1, v);
				}

				copy.clear();
				copy.addAll(dist.keySet());

				Collections.sort(copy, new Comparator<Point2D.Double>() {
					@Override
					public int compare(Point2D.Double p1, Point2D.Double p2) {
						Double v1 = dist.get(p1);
						Double v2 = dist.get(p2);
						return v1.compareTo(v2);
					}

				});
				values.removeAll(copy.subList(0, copy.size() / 2));
			}
		}

		public void complete(int iteration) {
			if (lastValue != Double.MIN_VALUE && lastValue != Double.MAX_VALUE) {
				if (values.isEmpty()
						|| values.get(values.size() - 1).getY() != lastValue) {

					Point2D.Double point = new Point2D.Double(iteration,
							lastValue);
					values.add(point);

					if (values.size() > MAXVALUES) {
						simplify();
					}
				}
			}
		}
	}

	/**
	 * Constructs a {@code ConvergencePlotData}.
	 * 
	 * @param evaluator
	 *            the evaluator
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public ConvergencePlotData(Evaluator evaluator) {
		Evaluator<?> eval = evaluator;
		for (Objective obj : eval.getObjectives()) {
			map.put(obj, new PlotDataObjective(obj));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualStateListener#inidividualStateChanged(org.opt4j
	 * .core.Individual)
	 */
	@Override
	public void inidividualStateChanged(Individual individual) {
		if (individual.isEvaluated()) {
			for (PlotDataObjective data : map.values()) {
				data.update(individual.getObjectives());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerIterationListener#iterationComplete
	 * (org.opt4j.core.optimizer.Optimizer, int)
	 */
	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		this.iteration = iteration;
		for (PlotDataObjective data : map.values()) {
			data.complete(iteration);
		}
	}

	/**
	 * Returns the points for a given objective.
	 * 
	 * @param objective
	 *            the objective
	 * @return the convergence points
	 */
	public List<Point2D.Double> getPoints(Objective objective) {
		return map.get(objective).values;
	}

	/**
	 * Returns the current iteration.
	 * 
	 * @return the current iteration
	 */
	public int getIteration() {
		return iteration;
	}

}
