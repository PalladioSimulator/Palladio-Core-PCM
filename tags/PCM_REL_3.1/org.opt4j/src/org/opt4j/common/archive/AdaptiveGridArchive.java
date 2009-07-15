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

package org.opt4j.common.archive;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.opt4j.core.Individual;
import org.opt4j.start.Constant;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.inject.Inject;

/**
 * The {@code AdaptiveGridArchive} uses an adaptive grid in order to restrict
 * its size. Based on Knowles and Corne, Properties of an Adaptive Archiving
 * Algorithm for Storing Nondominated Vectors, in Transactions of Evolutionary
 * Computation, Vol. 7, No. 2, April 2003.
 * 
 * @author helwig
 */
public class AdaptiveGridArchive extends BoundedArchive {

	/** Indicates whether grid division number has already been initialized */
	private boolean initialized;

	/** Grid division number */
	protected int div;

	/** Lower bound of each objective space dimension */
	protected double[] lbs;

	/** Upper bound of each objective space dimension */
	protected double[] ubs;

	/** Extremal individuals */
	protected List<Individual> ext;

	/** Cells of this adaptive grid archive */
	protected List<Cell> cells;

	/** Random number generator */
	protected final Random random;

	/**
	 * Adaptive grid region
	 */
	protected class Cell extends ArrayList<Individual> {

		private static final long serialVersionUID = 1L;

		/** Indices of this region */
		private final int[] indices;

		/**
		 * Constructs a new cell with the specified indices.
		 * 
		 * @param ind
		 *            indices
		 */
		public Cell(int[] ind) {
			indices = new int[ind.length];
			System.arraycopy(ind, 0, indices, 0, ind.length);
		}

		/**
		 * Returns the number of nonextremal solutions in this cell.
		 * 
		 * @return number of nonextremal solutions in this cell
		 */
		public int getSizeOfNonextremalIndividuals() {
			int size = this.size();
			for (Individual ind : this) {
				if (ext.contains(ind)) {
					size--;
				}
			}
			assert (size >= 0);
			return size;
		}

		/**
		 * Returns this cell's index in the specified dimension.
		 * 
		 * @param i
		 *            objective space dimension
		 * @return this cell's index at the specified dimension. If i is out of
		 *         range, -1 is returned.
		 */
		public int getIndex(int i) {
			if (i >= 0 && i < indices.length) {
				return indices[i];
			}
			return -1;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			} else if (o == null || o.getClass() != this.getClass()) {
				return false;
			}

			Cell oCell = (Cell) o;
			for (int i = 0; i < indices.length; i++) {
				if (indices[i] != oCell.getIndex(i)) {
					return false;
				}
			}
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			// this method has to be overriden whenever equals is overriden, so
			// that
			// equal elements return equal hashcodes

			int code = 0;
			final int HASH_PRIME = 31;
			for (int i = 0; i < indices.length; i++) {
				code = HASH_PRIME * code + indices[i];
			}
			return code;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.AbstractCollection#toString()
		 */
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder("Cell indices: ");
			for (int i = 0; i < indices.length; i++) {
				s.append(indices[i]);
				s.append("\t");
			}
			return s.toString();
		}
	}

	/**
	 * Updates this {@code Archive} with the specified individuals. First, all
	 * non-dominanted individuals are extracted, then {@code update(Individual)}
	 * is called for each of these non-dominated individuals in the specified
	 * order.
	 * 
	 * @param individuals
	 *            some individuals
	 */
	@Override
	public void update(Collection<Individual> individuals) {

		ArrayList<Individual> doms = new ArrayList<Individual>();

		for (Individual individual : individuals) {
			boolean isDom = true;

			for (int i = 0; i < doms.size(); i++) {
				Individual ndIndividual = doms.get(i);
				if (ndIndividual.getObjectives().weaklyDominates(
						individual.getObjectives())
						|| ndIndividual.getObjectives().isEqual(
								individual.getObjectives())) {
					isDom = false;
					break;
				} else if (individual.getObjectives().weaklyDominates(
						ndIndividual.getObjectives())) {
					doms.remove(i);
					i--;
				}
			}

			if (isDom) {
				doms.add(individual);
			}
		}

		for (Individual individual : doms) {
			updateSingle(individual);
		}

	}

	/**
	 * A handler for extracting the number of grid divisions from an xml data
	 * file. The xml data file should contain the number of grid divisions per
	 * dimension and archive capacity.
	 * 
	 * @author helwig
	 */
	protected class MyDefaultHandler extends DefaultHandler {
		protected final int dim;
		protected final int capacity;

		protected boolean correctDim = false;
		protected int div = 2;
		protected int minDiff = Integer.MAX_VALUE;

		/**
		 * Constructs a new handler for extracting the number of grid divisions
		 * from an xml data file for the specified archive capacity and the
		 * specified number of objective space dimensions.
		 * 
		 * @param capacity
		 *            capacity of this archive
		 * @param dim
		 *            number of objective space dimensions
		 */
		public MyDefaultHandler(int capacity, int dim) {
			this.dim = dim;
			this.capacity = capacity;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
		 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) {
			if (qName.equals("dimension")) {
				int k = Integer.parseInt(attributes.getValue("k"));
				if (k == dim) {
					correctDim = true;
				} else {
					correctDim = false;
				}
			} else if (correctDim && qName.equals("split")) {
				int attrCap = Integer.parseInt(attributes.getValue("capacity"));
				if (capacity > attrCap && capacity - attrCap < minDiff) {
					minDiff = capacity - attrCap;
					div = Integer.parseInt(attributes.getValue("divisions"));
				}
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
		 * java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement(String uri, String localName, String qName) {
			if (qName.equals("dimension")) {
				correctDim = false;
			}
		}

		/**
		 * Returns the number of divisions this handler has extracted from the
		 * xml file.
		 * 
		 * @return the number of divisions this handler has extracted from the
		 *         xml file. Returns {@code 2} if the file was not parsed yet.
		 */
		public int getDivisions() {
			return div;
		}
	}

	/**
	 * Constructs a new adaptive grid archive.
	 * 
	 * @param capacity
	 *            capacity of this archive (using namespace {@code
	 *            BoundedArchive})
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public AdaptiveGridArchive(
			@Constant(value = "capapcity", namespace = BoundedArchive.class) int capacity,
			Random random) {
		super(capacity);

		this.random = random;
		cells = new ArrayList<Cell>();
		initialized = false;
		div = 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.common.archive.BoundedArchive#add(org.opt4j.core.Individual)
	 */
	@Override
	public boolean add(Individual ind) {
		Cell indCell = calculateCell(ind);
		if (cells.contains(indCell)) {
			indCell = cells.get(cells.indexOf(indCell));
		} else {
			cells.add(indCell);
		}
		indCell.add(ind);
		return super.add(ind);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.IndividualCollection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object ind) {
		Cell indCell = calculateCell((Individual) ind);
		if (cells.contains(indCell)) {
			indCell = cells.get(cells.indexOf(indCell));
			indCell.remove(ind);
			if (indCell.size() <= 0) {
				cells.remove(indCell);
			}
		}

		return super.remove(ind);
	}

	/**
	 * Initializes the number of grid divisions (div) so that div^dim -
	 * (div-1)^dim + 2*K <= capacity
	 * 
	 * @param dim
	 *            Number of objective space dimensions
	 */
	protected void initializeDivisions(int dim) {
		int cap = capacity;
		if (dim == 2) {
			div = (int) Math.floor(-1.5 + .5 * cap);
		} else if (dim == 3) {
			div = (int) Math.floor(.5 + (1.0 / 6.0)
					* Math.sqrt(-75.0 + 12.0 * cap));
		} else {
			String filename = new String("resources"
					+ System.getProperty("file.separator") + "data"
					+ System.getProperty("file.separator") + "adaptiveGrid.xml");
			try {
				BufferedReader input = new BufferedReader(
						new InputStreamReader(new FileInputStream(filename)));
				SAXParser saxParser = SAXParserFactory.newInstance()
						.newSAXParser();
				MyDefaultHandler myHandler = new MyDefaultHandler(capacity, dim);
				saxParser.parse(new InputSource(input), myHandler);
				div = myHandler.getDivisions();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		initialized = true;
	}

	/**
	 * Initializes the grid.
	 * 
	 * @param individual
	 *            the first added individual to use for initialization
	 */
	protected void initalize(Individual individual) {
		int dim = individual.getObjectives().array().length;
		if (capacity < 2 * dim) {
			this.setCapacity(2 * dim);
			System.err
					.println("*** warning: Capacity of adaptive grid has been set to minimal required size "
							+ 2 * dim);
		}
		initializeDivisions(dim);
		lbs = new double[dim];
		ubs = new double[dim];
		ext = new ArrayList<Individual>(2 * dim);
		for (int i = 0; i < 2 * dim; i++) {
			ext.add(i, individual);
		}

		for (int i = 0; i < dim; i++) {
			lbs[i] = (individual.getObjectives().array())[i];
			ubs[i] = lbs[i];
		}
		int[] indices = { 0, 0 };
		Cell c = new Cell(indices);
		c.add(individual);
		cells.add(c);
		super.add(individual);
	}

	protected void updateSingle(Individual individual) {
		if (!initialized) {
			initalize(individual);
		} else if (!contains(individual)) {

			boolean add = false;

			for (Individual ndIndividual : this) {
				if (ndIndividual.getObjectives().weaklyDominates(
						individual.getObjectives())
						|| ndIndividual.getObjectives().isEqual(
								individual.getObjectives())) {
					return;
				}
			}

			List<Individual> remove = new ArrayList<Individual>();
			for (Individual ndIndividual : this) {
				if (individual.getObjectives().weaklyDominates(
						ndIndividual.getObjectives())) {
					add = true;
					remove.add(ndIndividual);
				}
			}
			this.removeAll(remove);

			if (this.size() < capacity) {
				add = true;
			}

			Cell indCell = calculateCell(individual);

			if (!add) {
				Cell maxCell = getMostCrowdedCell();
				int indCellSize = 0;
				boolean deleteFromMaxCell = false;

				if (cells.contains(indCell)) {
					indCellSize = cells.get(cells.indexOf(indCell)).size();
				}

				if (isNewExtremal(individual)
						|| (maxCell.size() > indCellSize && maxCell.size() > 1)) {

					deleteFromMaxCell = true;
					add = true;

				}

				if (deleteFromMaxCell) {
					int index = -1;
					boolean found = false;
					while (!found) {
						index = random.nextInt(maxCell.size());
						if (!ext.contains(maxCell.get(index))) {
							found = true;
						}
					}

					Individual loser = maxCell.get(index);
					remove(loser);
				}
			}

			if (add) {
				updateGrid(individual);
				this.add(individual);
			}
		}
	}

	/**
	 * Decides whether the specified individual is a new extremal solution.
	 * 
	 * @param a
	 *            the specified individual
	 * @return true if the specified individual is a new extremal solution, else
	 *         false
	 */
	protected boolean isNewExtremal(Individual a) {
		boolean ret = false;
		double[] obj = a.getObjectives().array();
		int dim = obj.length;
		for (int i = 0; i < dim; i++) {
			if (obj[i] < lbs[i] + 1.0 / (2.0 * div) * (ubs[i] - lbs[i])
					|| obj[i] > ubs[i] - 1.0 / (2.0 * div) * (ubs[i] - lbs[i])) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Updates the grid if necessary assuming that individual a is added.
	 * 
	 * @param a
	 *            an indidividual
	 */
	protected void updateGrid(Individual a) {

		double[] obj = a.getObjectives().array();
		int dim = obj.length;
		boolean changed = false;

		for (int i = 0; i < dim; i++) {
			if (obj[i] < lbs[i] + 1.0 / (2.0 * div) * (ubs[i] - lbs[i])
					|| a.getObjectives().dominates(
							ext.get(2 * i).getObjectives())) {
				lbs[i] = obj[i] - 1.0 / (2.0 * div) * (ubs[i] - obj[i]);
				ext.set(2 * i, a);
				changed = true;
			} else if (obj[i] > ubs[i] - 1.0 / (2.0 * div) * (ubs[i] - lbs[i])
					|| a.getObjectives().dominates(
							ext.get(2 * i + 1).getObjectives())) {
				ubs[i] = obj[i] + 1.0 / (2.0 * div) * (obj[i] - lbs[i]);
				ext.set(2 * i + 1, a);
				changed = true;
			}

		}

		if (changed) {
			recalculateCells();
		}
	}

	/**
	 * Calculates the cell of the specified individual.
	 * 
	 * @param ind
	 *            The specified individual
	 * @return Cell of the specified individual
	 */
	private Cell calculateCell(Individual ind) {
		final double[] obj = ind.getObjectives().array();
		int[] indices = new int[obj.length];
		for (int i = 0; i < obj.length; i++) {
			double range = (ubs[i] - lbs[i]) / div;
			indices[i] = (int) Math.floor((obj[i] - lbs[i]) / range);
		}
		return new Cell(indices);
	}

	/**
	 * Recalculates all cells (necessary, if extremal solutions have changed)
	 */
	private void recalculateCells() {
		ArrayList<Cell> newCells = new ArrayList<Cell>();
		for (Cell c : cells) {
			for (Individual ind : c) {
				Cell indCell = calculateCell(ind);
				if (newCells.contains(indCell)) {
					indCell = newCells.get(newCells.indexOf(indCell));
				} else {
					newCells.add(indCell);
				}
				indCell.add(ind);
			}
		}
		cells = newCells;
	}

	/**
	 * Returns one of the most crowded cells (not counting extremal solutions)
	 * 
	 * @return One of the most crowded cells (not counting extremal solutions)
	 */
	private Cell getMostCrowdedCell() {
		int max = -1;
		Cell maxCell = null;
		for (Cell c : cells) {
			int size = c.getSizeOfNonextremalIndividuals();
			if (size > max) {
				max = size;
				maxCell = c;
			}
		}
		return maxCell;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.common.archive.AbstractArchive#toString()
	 */
	@Override
	public String toString() {
		return "Adaptive grid with number of divisions: " + div + "\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.common.archive.AbstractArchive#updateWithNondominated(java.
	 * util.Collection)
	 */
	@Override
	protected void updateWithNondominated(Collection<Individual> candidates) {
		// do nothing
	}
}
