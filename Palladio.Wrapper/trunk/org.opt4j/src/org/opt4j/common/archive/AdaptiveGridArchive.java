package org.opt4j.common.archive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opt4j.common.random.Rand;
import org.opt4j.core.Individual;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code AdaptiveGridArchive} uses an adaptive grid in order to bound the
 * archive size.
 * 
 * @author lukasiewycz, helwig
 * 
 * @see "Properties of an Adaptive Archiving Algorithm for Storing Nondominated
 *      Vectors, J. Knowles, D. Corne, Transactions of Evolutionary Computation,
 *      Vol. 7, No. 2, April 2003"
 */
public class AdaptiveGridArchive extends BoundedArchive {

	protected boolean isInit = false;

	protected final int div;

	protected final Rand random;

	protected final Map<Long, Cell> cells = new HashMap<Long, Cell>();

	protected final List<Individual> extrema = new ArrayList<Individual>();

	protected double[] lb;

	protected double[] ub;

	protected int dim;

	/**
	 * A single {@code Cell} of the grid.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class Cell extends HashSet<Individual> {

		private static final long serialVersionUID = 1L;

		protected final long identifier;

		/**
		 * Constructs the {@code Cell} with the identifier.
		 * 
		 * @param identifier
		 *            the indentifier
		 */
		public Cell(long identifier) {
			super();
			this.identifier = identifier;
		}

		/**
		 * Returns the identifier.
		 * 
		 * @return the identifier
		 */
		public long getIdentifier() {
			return identifier;
		}
	}

	/**
	 * Constructs an {@code AdaptiveGridArchive}.
	 * 
	 * @param capacity
	 *            the capacity
	 * @param div
	 *            the divisions
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public AdaptiveGridArchive(
			@Constant(value = "capacity", namespace = BoundedArchive.class) int capacity,
			@Constant(value = "div", namespace = AdaptiveGridArchive.class) int div,
			Rand random) {
		super(capacity);
		this.random = random;
		this.div = div;

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

		if (!isInit && candidates.size() > 0) {
			init(candidates.iterator().next());
		}

		if (determineBounds(candidates)) {
			cells.clear();
			addToCell(this);
		}
		addToCell(candidates);

		if (this.size() + candidates.size() <= capacity) {
			this.addAll(candidates);
		} else {
			candidates.addAll(this);

			while (candidates.size() > capacity) {
				Cell cell = getMostCrowdedCell();

				List<Individual> list = new ArrayList<Individual>(cell);
				list.removeAll(extrema);

				Individual individual = list.get(random.nextInt(list.size()));
				candidates.remove(individual);
				removeFromCell(individual);
			}

			this.retainAll(candidates);
			for (Individual i : candidates) {
				if (!this.contains(i)) {
					add(i);
				}
			}
		}
	}

	/**
	 * Initialize the archive.
	 * 
	 * @param individual
	 *            one random individual
	 */
	protected void init(Individual individual) {
		if (!isInit) {
			dim = individual.getObjectives().size();

			lb = new double[dim];
			ub = new double[dim];

			for (int i = 0; i < dim; i++) {
				lb[i] = Double.MAX_VALUE;
				ub[i] = Double.MIN_VALUE;
				extrema.add(null);
				extrema.add(null);
			}

			isInit = true;
		}
	}

	/**
	 * Returns the appropriate {@code Cell} for the given {@code Individual}.
	 * 
	 * @param individual
	 *            the individual
	 * @return the cell
	 */
	public Cell getCell(Individual individual) {
		final double[] obj = individual.getObjectives().array();

		int scale = 1;
		long identifier = 0;
		for (int i = 0; i < obj.length; i++) {
			double half = (1.0 / (2.0 * div)) * (ub[i] - lb[i]);
			double lbi = lb[i] - half;
			double ubi = ub[i] + half;

			double step = (ubi - lbi) / div;
			int position = (int) Math.floor((obj[i] - lbi) / step);

			identifier += position * scale;
			scale *= div;
		}

		Cell cell = cells.get(identifier);
		if (cell != null) {
			return cell;
		} else {
			return new Cell(identifier);
		}
	}

	/**
	 * Returns the most crowded {@code Cell}.
	 * 
	 * @return the most crowded cell
	 */
	public Cell getMostCrowdedCell() {
		Cell mc = null;
		int size = 0;

		Set<Individual> extrema = new HashSet<Individual>(this.extrema);

		for (Cell cell : cells.values()) {
			int s = 0;
			assert (!cell.isEmpty());
			for (Individual individual : cell) {
				if (!extrema.contains(individual)) {
					s++;
				}
			}
			if (s > size) {
				size = s;
				mc = cell;
			}
		}

		return mc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.IndividualCollection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		Individual individual = (Individual) o;

		removeFromCell(individual);

		if (extrema.contains(individual)) {
			for (int i = 0; i < extrema.size(); i++) {
				if (individual.equals(extrema.get(i))) {
					extrema.set(i, null);
					int j = (int) Math.floor((double) i / 2.0);
					if (i % 2 == 0) {
						lb[j] = Double.MAX_VALUE;
					} else {
						ub[j] = Double.MIN_VALUE;
					}
				}
			}
		}

		return super.remove(individual);
	}

	/**
	 * Adds all individuals to theirs cells and the cells to the archive.
	 * 
	 * @param individuals
	 *            the individuals to be added
	 */
	protected void addToCell(Iterable<Individual> individuals) {
		for (Individual individual : individuals) {
			Cell cell = getCell(individual);
			cell.add(individual);
			cells.put(cell.identifier, cell);
		}
	}

	/**
	 * Removes this {@code Individual} from its {@code Cell} and removes the
	 * {@code Cell} from the archive if it is empty.
	 * 
	 * @param individual
	 *            the individual to be removed
	 */
	protected void removeFromCell(Individual individual) {
		Cell cell = getCell(individual);
		cell.remove(individual);
		if (cell.isEmpty()) {
			cells.remove(cell.getIdentifier());
		}
	}

	/**
	 * Determines the new bounds for the individuals and returns {@code true} if
	 * the bounds have changed.
	 * 
	 * @param individuals
	 *            the individuals
	 * @return {@code true} if the bounds have changed
	 */
	protected boolean determineBounds(Collection<Individual> individuals) {
		boolean boundsChanged = false;

		for (Individual individual : individuals) {
			final double[] obj = individual.getObjectives().array();

			for (int i = 0; i < dim; i++) {
				double value = obj[i];

				if (value < lb[i]) {
					boundsChanged = true;
					extrema.set(2 * i, individual);
					lb[i] = obj[i];
				} else if (value > ub[i]) {
					boundsChanged = true;
					extrema.set(2 * i + 1, individual);
					ub[i] = obj[i];
				}
			}
		}

		return boundsChanged;
	}
}
