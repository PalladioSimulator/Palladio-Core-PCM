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
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.opt4j.config.Icons;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.IndividualCollectionListener;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.Individual.State;
import org.opt4j.core.problem.Evaluator;

import com.google.inject.Inject;

/**
 * A widget that monitors the {@code Population}.
 * 
 * @author lukasiewycz
 * 
 */
@WidgetParameters(title = "Population Monitor", icon = Icons.POPULATION)
public class PopulationWidget implements IndividualStateListener,
		IndividualCollectionListener, Widget {

	private static final long serialVersionUID = 1L;

	protected final static int OFFSET = 3;

	protected final Archive archive;

	protected final Population population;

	protected final List<Individual> individuals = Collections
			.synchronizedList(new ArrayList<Individual>());

	protected final List<Objective> objectives = new ArrayList<Objective>();

	protected JPanel panel = new JPanel();

	protected JTable table;

	protected int size = 0;

	protected boolean isInit = false;

	protected DelayTask task = new DelayTask(40);

	/**
	 * The table.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class Table extends QTable {
		private static final long serialVersionUID = 1L;

		public Table(TableModel tableModel) {
			super(tableModel);
		}

		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row,
				int column) {
			Component c = super.prepareRenderer(renderer, row, column);

			String family = c.getFont().getFamily();
			int size = c.getFont().getSize();

			try {
				int model = row;

				Individual individual = individuals.get(model);

				if (individual != null) {

					if (archive.contains(individual)) {
						c.setFont(new Font(family, Font.BOLD, size));
					}
					if (individual.getState().isProcessing()) {
						c.setForeground(Color.RED);
					} else {
						c.setForeground(Color.BLACK);
					}

				}
			} catch (IndexOutOfBoundsException e) {
			}
			return c;
		}
	}

	/**
	 * The model.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class Model extends AbstractTableModel {
		private static final long serialVersionUID = 1L;

		public int getColumnCount() {
			return OFFSET + objectives.size();
		}

		public int getRowCount() {
			size = Math.max(size, individuals.size());

			return size;
		}

		@Override
		public String getColumnName(int col) {
			if (col == 0) {
				return "#";
			} else if (col == 1) {
				return "Individual";
			} else if (col == 2) {
				return "State";
			} else {
				final int index = col - OFFSET;
				final Objective objective = objectives.get(index);

				return objective.getName() + " (" + objective.getSign() + ")";
			}
		}

		public Object getValueAt(final int row, final int col) {

			try {
				final Individual individual = individuals.get(row);
				final State state = individual.getState();

				if (individual != null) {
					if (col == 0) {
						return row + 1;
					} else if (col == 1) {
						return individual.getPhenotype();
					} else if (col == 2) {
						return state;
					} else {
						if (state == Individual.State.EVALUATED) {

							final int index = col - OFFSET;
							final Objectives o = individual.getObjectives();
							final Objective objective = objectives.get(index);

							return o.get(objective).getValue();
						}
					}
				}
			} catch (IndexOutOfBoundsException e) {
			} catch (NullPointerException e) {
			}

			return null;
		}
	}

	/**
	 * Constructs a {@code PopulationWidget}.
	 * 
	 * @param population
	 *            the {@code Population}
	 * @param archive
	 *            the {@code Archive}
	 * @param individualBuilder
	 *            the {@code IndividualBuilder}
	 * @param evaluator
	 *            the {@code Evaluator}
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public PopulationWidget(Population population, Archive archive,
			IndividualBuilder individualBuilder, Evaluator evaluator) {
		this.archive = archive;
		this.population = population;

		objectives.addAll(evaluator.getObjectives());
		Collections.sort(objectives);

		for (int i = 0; i < 3; i++) {
			try {
				individuals.clear();
				individuals.addAll(population);
				break;
			} catch (Exception e) {
			}
		}

		population.addListener(this);
		individualBuilder.addIndividualStateListener(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.viewer.Widget#init(org.opt4j.viewer.Viewport)
	 */
	public synchronized void init(Viewport viewport) {

		if (!isInit) {
			Model model = new Model();
			table = new Table(model);

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					final TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(25);
					columnModel.getColumn(1).setPreferredWidth(140);

					JScrollPane scrollpane = new JScrollPane(table);

					panel.setLayout(new BorderLayout());
					panel.add(scrollpane, BorderLayout.CENTER);

					isInit = true;
					paint();
				}
			});
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualStateListener#inidividualStateChanged(org.opt4j
	 * .core.Individual)
	 */
	public void inidividualStateChanged(Individual individual) {
		paint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualCollectionListener#individualAdded(org.opt4j
	 * .core.IndividualCollection, org.opt4j.core.Individual)
	 */
	public synchronized void individualAdded(IndividualCollection collection,
			Individual individual) {
		individuals.add(individual);
		paint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualCollectionListener#individualRemoved(org.opt4j
	 * .core.IndividualCollection, org.opt4j.core.Individual)
	 */
	public synchronized void individualRemoved(IndividualCollection collection,
			Individual individual) {
		individuals.remove(individual);
		paint();
	}

	protected void paint() {
		if (isInit) {
			task.execute(new Runnable() {
				@Override
				public void run() {
					table.revalidate();
					table.repaint();
				}
			});
		}
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
