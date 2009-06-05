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
package org.opt4j.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.opt4j.config.Icons;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;
import org.opt4j.core.problem.Evaluator;

import ptolemy.plot.Plot;

import com.google.inject.Inject;

/**
 * A widget that displays the {@code Population} and {@code Archive} in two
 * dimensional diagram.
 * 
 * @author lukasiewycz
 * 
 */
@WidgetParameters(title = "Plot", icon = Icons.PARETO)
public class PlotWidget implements OptimizerIterationListener, Widget {

	private static final long serialVersionUID = 1L;

	protected final Population population;

	protected final Archive archive;

	protected final DelayTask task = new DelayTask(40);

	protected final Evaluator<?> evaluator;

	protected final Optimizer optimizer;

	protected Plot plot;

	protected List<Objective> objectives = new ArrayList<Objective>();

	protected CriterionPicker picker;

	protected JPanel panel = new JPanel();

	protected boolean isInit = false;

	/**
	 * A two dimensional point.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class Point {
		protected final double x;

		protected final double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		@Override
		public int hashCode() {
			return 31 * (int) Double.doubleToLongBits(x)
					+ (int) Double.doubleToLongBits(y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			} else if (obj == null || getClass() != obj.getClass()) {
				return false;
			}

			final Point other = (Point) obj;
			if (x == other.x && y == other.y) {
				return true;
			}
			return false;
		}
	}

	/**
	 * A criterion picker for exactly two criterions.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class CriterionPicker extends JToolBar implements ActionListener {

		private static final long serialVersionUID = 1L;

		protected final Map<Objective, Integer> indices = new HashMap<Objective, Integer>();

		protected JComboBox firstComboBox = new JComboBox();

		protected JComboBox secondComboBox = new JComboBox();

		protected Objective first;

		protected Objective second;

		protected PlotWidget widget;

		public CriterionPicker(PlotWidget widget) {
			super();
			this.widget = widget;

			List<String> strings = new ArrayList<String>();

			int i = 0;

			for (Objective objective : objectives) {
				String s = "objective: " + objective.getName();
				strings.add(s);
				indices.put(objective, i);
				i++;
			}

			String[] e = new String[strings.size()];
			final String[] elements = strings.toArray(e);

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					firstComboBox = new JComboBox(elements);
					secondComboBox = new JComboBox(elements);

					firstComboBox.addActionListener(CriterionPicker.this);
					firstComboBox.setMaximumSize(firstComboBox
							.getPreferredSize());
					secondComboBox.addActionListener(CriterionPicker.this);
					secondComboBox.setMaximumSize(secondComboBox
							.getPreferredSize());

					add(new JLabel("x-Axis: "));
					add(firstComboBox);
					addSeparator();
					add(new JLabel("y-Axis: "));
					add(secondComboBox);
					setFloatable(false);
				}
			});

			initSelection();
		}

		private void initSelection() {
			if (objectives.size() > 0) {
				Objective objective = objectives.get(0);
				final int index = indices.get(objective);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						firstComboBox.setSelectedIndex(index);
					}
				});
				setFirst(objective);
			}

			if (objectives.size() > 1) {
				Objective objective = objectives.get(1);
				final int index = indices.get(objective);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						secondComboBox.setSelectedIndex(index);
					}
				});
				setSecond(objective);
			} else {
				Objective objective = objectives.get(0);
				final int index = indices.get(objective);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						firstComboBox.setSelectedIndex(index);
					}
				});
				setSecond(objective);
			}
		}

		public Objective getFirst() {
			return first;
		}

		public void setFirst(Objective first) {
			this.first = first;
		}

		public Objective getSecond() {
			return second;
		}

		public void setSecond(Objective second) {
			this.second = second;
		}

		public void actionPerformed(ActionEvent e) {
			JComboBox box = (JComboBox) e.getSource();

			boolean changed = false;
			if (box == firstComboBox) {
				Objective objective = objectives.get(firstComboBox
						.getSelectedIndex());
				if (first != objective) {
					first = objective;
					changed = true;
				}
			} else if (box == secondComboBox) {
				Objective objective = objectives.get(secondComboBox
						.getSelectedIndex());
				if (second != objective) {
					second = objective;
					changed = true;
				}
			}

			if (changed) {
				widget.setLabels(first.getName(), second.getName());

				final Collection<Individual> a = new HashSet<Individual>();
				try {
					a.addAll(archive);
				} catch (ConcurrentModificationException cme) {
				}
				final Collection<Individual> p = new HashSet<Individual>();
				try {
					p.addAll(population);
				} catch (ConcurrentModificationException cme) {
				}

				task.execute(new Thread() {
					@Override
					public void run() {
						widget.paint(a, p);
					}
				});
			}
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
	public PlotWidget(Population population, Archive archive,
			Evaluator evaluator, Optimizer optimizer) {
		this.population = population;
		this.archive = archive;
		this.optimizer = optimizer;
		this.evaluator = evaluator;
	}

	/**
	 * Registers all listeners.
	 */
	private void registerListeners() {
		optimizer.addOptimizerIterationListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.gui.Widget#init(org.opt4j.gui.Viewport)
	 */
	public synchronized void init(Viewport viewport) {
		if (!isInit) {
			registerListeners();

			objectives.addAll(evaluator.getObjectives());
			Collections.sort(objectives);

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					picker = new CriterionPicker(PlotWidget.this);

					plot = new Plot();

					plot.addLegend(0, "Archive");
					plot.addLegend(1, "Population");
					plot.setMarksStyle("dots");

					Color[] colors = new Color[3];
					colors[0] = Color.RED;
					colors[1] = Color.LIGHT_GRAY;
					plot.setColors(colors);

					panel.setLayout(new BorderLayout());
					panel.add(picker, BorderLayout.NORTH);
					panel.add(plot, BorderLayout.CENTER);

					setLabels(picker.getFirst().getName(), picker.getSecond()
							.getName());

					final Collection<Individual> a = new HashSet<Individual>();
					try {
						a.addAll(archive);
					} catch (ConcurrentModificationException e) {
					}
					final Collection<Individual> p = new HashSet<Individual>();
					try {
						p.addAll(population);
					} catch (ConcurrentModificationException e) {
					}
					task.execute(new Thread() {
						@Override
						public void run() {
							paint(a, p);
						}
					});

					isInit = true;
				}
			});
			panel.revalidate();
			panel.repaint();
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
		if (isInit) {
			final Collection<Individual> a = new HashSet<Individual>();
			a.addAll(archive);
			final Collection<Individual> p = new HashSet<Individual>();
			p.addAll(population);
			task.execute(new Thread() {
				@Override
				public void run() {
					paint(a, p);
				}
			});

		}
	}

	/**
	 * Updates the labels of the plot. The plot must be painted afterwards.
	 * 
	 * @param xLabel
	 *            the new label for the x axis
	 * @param yLabel
	 *            the new label for the y axis
	 */
	protected void setLabels(final String xLabel, final String yLabel) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				plot.setXLabel(xLabel);
				plot.setYLabel(yLabel);
			}
		});
	}

	/**
	 * Returns the two dimensional representation of the given {@code
	 * IndividualCollection}.
	 * 
	 * @param indivualCollection
	 *            the {IndividualCollection
	 * @return a set of points
	 */
	protected Set<Point> getPoints(Collection<Individual> indivualCollection) {
		final Objective one = picker.getFirst();
		final Objective two = picker.getSecond();

		Set<Point> points = new HashSet<Point>();
		for (Individual individual : indivualCollection) {
			if (individual.isEvaluated()) {
				Objectives objectives = individual.getObjectives();

				if (objectives.get(one).getValue() == Objective.INFEASIBLE
						|| objectives.get(two).getValue() == Objective.INFEASIBLE) {
					continue;
				}

				double x = objectives.get(one).getDouble();
				double y = objectives.get(two).getDouble();
				Point point = new Point(x, y);
				points.add(point);
			}
		}

		return points;
	}

	/**
	 * Repaints the diagram.
	 */
	protected void paint(Collection<Individual> archive,
			Collection<Individual> population) {
		if (!isInit) {
			return;
		}
		population.removeAll(archive);
		final Set<Point> archivePoints = getPoints(archive);
		final Set<Point> populationPoints = getPoints(population);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				plot.clear(false);

				for (Point point : archivePoints) {
					plot.addPoint(0, point.getX(), point.getY(), false);
				}

				for (Point point : populationPoints) {
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
	 * @see org.opt4j.gui.Widget#getPanel()
	 */
	public JPanel getPanel() {
		return panel;
	}
}
