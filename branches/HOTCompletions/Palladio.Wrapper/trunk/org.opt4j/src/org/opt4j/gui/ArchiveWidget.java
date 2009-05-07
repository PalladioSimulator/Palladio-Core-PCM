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
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.opt4j.config.Icons;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.IndividualCollectionListener;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;
import org.opt4j.core.problem.Evaluator;

import com.google.inject.Inject;

/**
 * A widget that monitors the archive.
 * 
 * @author lukasiewycz
 * 
 */
@WidgetParameters(title = "Archive Monitor", icon = Icons.ARCHIVE)
public class ArchiveWidget implements OptimizerIterationListener, IndividualCollectionListener, Widget {

	private static final long serialVersionUID = 1L;

	protected final static int OFFSET = 1;

	protected final Archive archive;

	protected final Optimizer optimizer;

	protected final Evaluator<?> evaluator;

	protected final List<Objective> objectives = new ArrayList<Objective>();

	protected final List<Objective> order = new ArrayList<Objective>();

	protected JPanel panel = new JPanel();

	protected JTable table;

	protected JCheckBox autoUpdate;

	protected JLabel sizeLabel;

	protected boolean isInit = false;

	protected boolean changed = true;

	protected List<Individual> individuals = new ArrayList<Individual>();

	protected List<IndividualMouseListener> individualMouseListeners = new CopyOnWriteArrayList<IndividualMouseListener>();

	protected DelayTask task = new DelayTask(40);

	protected static final String INDEX = "Index";

	/**
	 * The {@code TableMouseListener} that listens to right and double click of
	 * the table item.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	class TableMouseListener extends MouseAdapter {
		private void reservTableShow(MouseEvent e, boolean released) {
			if (table.isEnabled()) {
				Point p = new Point(e.getX(), e.getY());
				int row = table.rowAtPoint(p);

				if (row >= 0 && row < table.getRowCount()) {
					Individual individual = individuals.get(row);

					if (e.isPopupTrigger()) {
						table.getSelectionModel().setSelectionInterval(row, row);
						JPopupMenu menu = new JPopupMenu();
						for (IndividualMouseListener listener : individualMouseListeners) {
							listener.onPopup(individual, table, p, menu);
						}
						if (menu.getComponentCount() > 0) {
							menu.show(table, p.x, p.y);
						}
					} else if (e.getClickCount() == 2 && released) {
						for (IndividualMouseListener listener : individualMouseListeners) {
							listener.onDoubleClick(individual, table, p);
						}
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			reservTableShow(e, true);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			reservTableShow(e, false);
		}
	}

	/**
	 * The model of the table.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class Model extends AbstractTableModel {
		private static final long serialVersionUID = 1L;

		@Override
		public String getColumnName(int col) {
			if (col == 0) {
				return INDEX;
			}
			final int index = col - OFFSET;
			final Objective objective = objectives.get(index);

			return objective.getName() + " (" + objective.getSign() + ")";
		}

		public int getColumnCount() {
			return OFFSET + objectives.size();
		}

		public int getRowCount() {
			return individuals.size();
		}

		public Object getValueAt(final int row, final int col) {

			try {
				final Individual individual = individuals.get(row);

				if (individual != null) {
					if (col == 0) {
						return row + 1;
					}
					if (individual.getState() == Individual.State.EVALUATED) {

						final int index = col - OFFSET;
						final Objectives o = individual.getObjectives();
						final Objective objective = objectives.get(index);

						return o.get(objective).getValue();
					}
				}
			} catch (IndexOutOfBoundsException e) {
			}
			return null;
		}
	}

	/**
	 * Constructs an {@code ArchiveWidget}.
	 * 
	 * @param archive
	 *            the archive
	 * @param optimizer
	 *            the optimizer
	 * @param evaluator
	 *            the evaluator
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public ArchiveWidget(final Archive archive, final Optimizer optimizer, final Evaluator evaluator,
			Set<IndividualMouseListener> mouseListeners) {
		this.archive = archive;
		this.optimizer = optimizer;
		this.evaluator = evaluator;
		this.individualMouseListeners.addAll(mouseListeners);
		sortIndividiualMouseListeners();
	}

	protected void sortIndividiualMouseListeners(){
		List<IndividualMouseListener> list = new ArrayList<IndividualMouseListener>();
		list.addAll(individualMouseListeners);
		Collections.sort(list, new OrderComparator<IndividualMouseListener>());
		individualMouseListeners.clear();
		individualMouseListeners.addAll(list);
	}
	
	/**
	 * Registers the listeners at the {@code Archive}.
	 */
	protected void registerListeners() {
		archive.addListener(this);
		optimizer.addOptimizerIterationListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.gui.Widget#init(org.opt4j.gui.Viewport)
	 */
	public synchronized void init(Viewport viewport) {
		if (!isInit) {
			objectives.addAll(evaluator.getObjectives());
			Collections.sort(objectives);
			order.addAll(objectives);

			Model model = new Model();
			table = new JTable(model);
			table.addMouseListener(new TableMouseListener());

			registerListeners();

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					JScrollPane scrollpane = new JScrollPane(table);

					/*
					 * configure the autoupdate checkbox
					 */
					autoUpdate = new JCheckBox();
					autoUpdate.setSelected(true);
					autoUpdate.setText("Auto Update");
					autoUpdate.setHorizontalTextPosition(SwingConstants.LEADING);
					autoUpdate.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							if (autoUpdate.isSelected()) {
								paint();
							}
						}
					});
					sizeLabel = new JLabel(Integer.toString(archive.size()));

					/*
					 * configure the panel
					 */

					JPanel north = new JPanel();
					north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
					Dimension dim = new Dimension(10, 10);
					north.add(new Box.Filler(dim, dim, dim));
					north.add(new JLabel("Size: "));
					north.add(sizeLabel);
					north.add(Box.createHorizontalGlue());
					north.add(autoUpdate);

					panel.setLayout(new BorderLayout());
					panel.add(north, BorderLayout.NORTH);
					panel.add(scrollpane, BorderLayout.CENTER);

					table.getColumnModel().addColumnModelListener(new TableColumnModelListener() {

						@Override
						public void columnAdded(TableColumnModelEvent arg0) {
						}

						@Override
						public void columnMarginChanged(ChangeEvent arg0) {
						}

						@Override
						public void columnMoved(TableColumnModelEvent arg0) {
						}

						@Override
						public void columnRemoved(TableColumnModelEvent arg0) {
						}

						@Override
						public void columnSelectionChanged(ListSelectionEvent arg0) {
							if (updateOrder()) {
								paint();
							}
						}
					});

					paint();

					isInit = true;
				}
			});
		}
	}

	protected boolean updateOrder() {
		if (table.getColumnCount() != objectives.size() + 1) {
			return false;
		}

		List<Objective> list = new ArrayList<Objective>();

		TableColumnModel model = table.getColumnModel();

		int p = 0;
		for (int i = 0; i < model.getColumnCount(); i++) {
			TableColumn c = model.getColumn(i);
			if (c.getModelIndex() == 0) {
				p = i;
				break;
			}
		}

		for (int i = 0; i < objectives.size(); i++) {
			int k = i;
			if (i >= p) {
				k++;
			}

			int j = model.getColumn(k).getModelIndex() - 1;
			Objective o = objectives.get(j);
			list.add(o);
		}

		if (!list.equals(order)) {
			order.clear();
			order.addAll(list);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Repaints the table.
	 */
	protected void paint() {
		changed = false;
		individuals.clear();

		List<Individual> temp = new ArrayList<Individual>();
		temp.addAll(archive);
		Collections.sort(temp, new Comp());

		individuals = temp;

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				sizeLabel.setText(Integer.toString(individuals.size()));
				table.revalidate();
				table.repaint();
			}
		});

	}

	protected class Comp implements Comparator<Individual> {

		@SuppressWarnings("unchecked")
		@Override
		public int compare(Individual arg0, Individual arg1) {
			if (arg0 == null) {
				if (arg1 == null) {
					return 0;
				} else {
					return 1;
				}
			} else if (arg1 == null) {
				return -1;
			}

			Objectives obj0 = arg0.getObjectives();
			Objectives obj1 = arg1.getObjectives();

			for (Objective o : order) {

				Value<Object> v0 = (Value<Object>) obj0.get(o);
				Value<Object> v1 = (Value<Object>) obj1.get(o);

				int c = v0.compareTo(v1);
				if (c != 0) {
					if (o.getSign() == Sign.MIN) {
						return c;
					} else {
						return -c;
					}
				}
			}
			return 0;
		}

	}

	/**
	 * Adds a {@code IndividualMouseListener}.
	 * 
	 * @param listener
	 *            the {@code IndividualMouseListener} to be added
	 */
	public void addIndividualMouseListener(IndividualMouseListener listener) {
		individualMouseListeners.add(listener);
		sortIndividiualMouseListeners();
	}

	/**
	 * Removes a {@code IndividualMouseListener}.
	 * 
	 * @param listener
	 *            the {@code IndividualMouseListener} to be removed
	 */
	public void removeIndivdiualMouseListener(IndividualMouseListener listener) {
		individualMouseListeners.remove(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerIterationListener#iterationComplete
	 * (org.opt4j.core.optimizer.Optimizer, int)
	 */
	public void iterationComplete(Optimizer optimizer, int iteration) {
		if (isInit && changed && autoUpdate.isSelected()) {
			task.execute(new Thread() {
				@Override
				public void run() {
					paint();
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualCollectionListener#individualAdded(org.opt4j
	 * .core.IndividualCollection, org.opt4j.core.Individual)
	 */
	public synchronized void individualAdded(IndividualCollection collection, Individual individual) {
		changed = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualCollectionListener#individualRemoved(org.opt4j
	 * .core.IndividualCollection, org.opt4j.core.Individual)
	 */
	public synchronized void individualRemoved(IndividualCollection collection, Individual individual) {
		changed = true;
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
