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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import org.opt4j.config.Icons;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.Value;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;
import org.opt4j.core.problem.Evaluator;
import org.opt4j.viewer.ConvergencePlotWidget.ObjectiveDropDown;

import ptolemy.plot.Plot;

import com.google.inject.Inject;

/**
 * The {@code ParetoPlotWidget} is a widget that displays the {@code Population}
 * and {@code Archive} in two dimensional plot.
 * 
 * @author lukasiewycz
 * 
 */
@WidgetParameters(title = "Pareto Plot", icon = Icons.PARETO)
public class ParetoPlotWidget implements OptimizerIterationListener, Widget {

	private static final long serialVersionUID = 1L;

	protected final Population population;

	protected final Archive archive;

	protected final DelayTask task = new DelayTask(40);

	protected Plot plot;

	protected List<Objective> objectives = new ArrayList<Objective>();

	protected Selection selection;

	protected JPanel panel = new JPanel();

	protected boolean isInit = false;

	/**
	 * The selection box for the current two objectives.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class Selection extends JToolBar implements ActionListener {

		private static final long serialVersionUID = 1L;

		protected ObjectiveDropDown firstComboBox;

		protected ObjectiveDropDown secondComboBox;

		public Selection(Collection<Objective> objectives) {
			firstComboBox = new ObjectiveDropDown(objectives);
			secondComboBox = new ObjectiveDropDown(objectives);

			firstComboBox.addActionListener(this);
			secondComboBox.addActionListener(this);

			add(new JLabel("x-Axis: "));
			add(firstComboBox);
			addSeparator();
			add(new JLabel("y-Axis: "));
			add(secondComboBox);
			setFloatable(false);

			initSelection();
		}

		private void initSelection() {
			if (objectives.size() <= 0) {
				return;
			}

			final Objective objective1 = objectives.get(0);
			final Objective objective2;
			if (objectives.size() > 1) {
				objective2 = objectives.get(1);
			} else {
				objective2 = objectives.get(0);
			}
			firstComboBox.setSelected(objective1);
			secondComboBox.setSelected(objective2);
		}

		public Objective getFirst() {
			return firstComboBox.getSelected();
		}

		public Objective getSecond() {
			return secondComboBox.getSelected();
		}

		public void actionPerformed(ActionEvent e) {
			ParetoPlotWidget.this.doPaint();
		}
	}

	/**
	 * Constructs a ParetoPanel.
	 * 
	 * @param population
	 *            the {@code Population}
	 * @param archive
	 *            the {@code Archive}
	 * @param evaluator
	 *            the {@code Evaluator}
	 * @param optimizer
	 *            the {@code Optimizer}
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public ParetoPlotWidget(Population population, Archive archive,
			Evaluator evaluator, Optimizer optimizer) {
		this.population = population;
		this.archive = archive;

		optimizer.addOptimizerIterationListener(this);

		Collection<Objective> objectiveCollection = evaluator.getObjectives();
		if (objectiveCollection != null) {
			objectives.addAll(objectiveCollection);
		}
		Collections.sort(objectives);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.viewer.Widget#init(org.opt4j.viewer.Viewport)
	 */
	public synchronized void init(Viewport viewport) {
		if (!isInit) {

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					JPanel northPanel = new JPanel(new FlowLayout());
					selection = new Selection(objectives);
					northPanel.add(selection);
					Border border = BorderFactory.createMatteBorder(0, 0, 1, 0,
							selection.getBackground().darker());
					northPanel.setBorder(border);

					plot = new Plot();

					plot.addLegend(0, "Archive");
					plot.addLegend(1, "Population");
					plot.setMarksStyle("dots");

					Color[] colors = new Color[3];
					colors[0] = Color.RED;
					colors[1] = Color.LIGHT_GRAY;
					colors[2] = Color.BLUE;
					plot.setColors(colors);

					panel.setLayout(new BorderLayout());
					panel.add(northPanel, BorderLayout.NORTH);
					panel.add(plot, BorderLayout.CENTER);

					isInit = true;
					doPaint();
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerIterationListener#iterationComplete
	 * (org.opt4j.core.optimizer.Optimizer, int)
	 */
	public void iterationComplete(Optimizer optimizer, int iteration) {
		doPaint();
	}

	/**
	 * Returns the two dimensional representation of the given {@code
	 * IndividualCollection}.
	 * 
	 * @param indivualCollection
	 *            the {IndividualCollection
	 * @return a set of points
	 */
	protected Set<Point2D.Double> getPoints(
			Collection<Individual> indivualCollection, Objective one,
			Objective two) {

		Set<Point2D.Double> points = new HashSet<Point2D.Double>();
		for (Individual individual : indivualCollection) {
			if (individual != null && individual.isEvaluated()) {
				Objectives objectives = individual.getObjectives();

				Value<?> onev = objectives.get(one);
				Value<?> twov = objectives.get(two);

				if (one == null || two == null || onev == null || twov == null
						|| onev.getValue() == Objective.INFEASIBLE
						|| twov.getValue() == Objective.INFEASIBLE) {
					continue;
				}

				double x = objectives.get(one).getDouble();
				double y = objectives.get(two).getDouble();
				Point2D.Double point = new Point2D.Double(x, y);
				points.add(point);
			}
		}

		return points;
	}

	/**
	 * Repaints the diagram.
	 */
	protected void doPaint() {
		if (isInit) {
			task.execute(new Runnable() {
				@Override
				public void run() {
					final Collection<Individual> a = new HashSet<Individual>();
					try {
						a.addAll(archive);
					} catch (Exception e) {
					}
					final Collection<Individual> p = new HashSet<Individual>();
					try {
						p.addAll(population);
					} catch (Exception e) {
					}

					paint(a, p);
				}
			});
		}
	}

	/**
	 * Repaints the diagram.
	 */
	protected void paint(Collection<Individual> archive,
			Collection<Individual> population) {
		if (!isInit) {
			return;
		}

		final Objective one = selection.getFirst();
		final Objective two = selection.getSecond();

		population.removeAll(archive);
		final Set<Point2D.Double> archivePoints = getPoints(archive, one, two);
		final Set<Point2D.Double> populationPoints = getPoints(population, one,
				two);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				plot.clear(false);
				plot.setXLabel(one.getName());
				plot.setYLabel(two.getName());

				for (Point2D.Double point : archivePoints) {
					plot.addPoint(0, point.getX(), point.getY(), false);
				}

				for (Point2D.Double point : populationPoints) {
					plot.addPoint(1, point.getX(), point.getY(), false);
				}

				plot.revalidate();
				plot.repaint();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.viewer.Widget#getPanel()
	 */
	public JPanel getPanel() {
		return panel;
	}
}
