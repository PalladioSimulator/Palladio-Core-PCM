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

package org.opt4j.sat;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code PooledSolver} is a decorator that enables pooling for
 * {@code Instances} of a {@code Problem}.
 * 
 * @author lukasiewycz
 * 
 */
public class PooledSolver implements Solver {

	protected List<Constraint> constraints = new ArrayList<Constraint>();

	protected int nVars = 0;

	protected int nInstances = 0;

	protected List<Instance> instances = new ArrayList<Instance>();

	protected Pool pool = new Pool();

	protected Solver solver;

	/**
	 * Simple pool for problem instances.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected static class Pool {

		protected List<Instance> list = new ArrayList<Instance>();

		/**
		 * Returns one free {@code Instance}.
		 * 
		 * @return one free {@code Instance}
		 */
		public synchronized Instance get() {
			while (list.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			return list.remove(0);
		}

		/**
		 * Removes an {@code Instance} if it is in the pool.
		 * 
		 * @param instance
		 *            the {@code Instance} to be removed
		 */
		public synchronized void remove(Instance instance) {
			list.remove(instance);
		}

		/**
		 * Adds an {@code Instance} to the pool.
		 * 
		 * @param instance
		 *            the {@code Instance} to be added
		 */
		public synchronized void add(Instance instance) {
			list.add(instance);
			notifyAll();
		}

	}

	/**
	 * Constructs a {@code PooledSolver} with a {@code Solver}. The initial
	 * pooling size is 1.
	 * 
	 * @param solver
	 *            the decorated solver
	 * 
	 */
	public PooledSolver(Solver solver) {
		this(solver, 1);
	}

	/**
	 * Constructs a {@code PooledSolver} with a {@code Solver} and a specified
	 * size.
	 * 
	 * @param solver
	 *            the decorated Solver
	 * @param size
	 *            the pool size
	 */
	public PooledSolver(Solver solver, int size) {
		this.solver = solver;

		if (size < 1) {
			throw new IllegalArgumentException("Invalid pool size: " + size);
		}
		setPoolSize(size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#addConstraint(org.opt4j.sat.Constraint)
	 */
	public void addConstraint(Constraint constraint) {
		constraints.add(constraint);

		for (Instance instance : instances) {
			instance.addConstraint(constraint);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#getInstance()
	 */
	public Instance getInstance() {
		return pool.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#returnInstance(org.opt4j.sat.Instance)
	 */
	public void returnInstance(Instance instance) {
		pool.add(instance);
	}

	/**
	 * Sets the pool size.
	 * 
	 * @param n
	 *            the new pool size to set
	 */
	public void setPoolSize(int n) {

		if (n > nInstances) {
			while (n > nInstances) {
				nInstances++;

				Instance instance = solver.getInstance();

				instance.addVars(nVars);

				for (Constraint constraint : constraints) {
					instance.addConstraint(constraint);
				}

				instances.add(instance);
				pool.add(instance);

			}
		} else if (n < nInstances) {

			while (n < nInstances) {
				nInstances--;

				Instance instance = instances.remove(0);
				pool.remove(instance);

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#addVars(int)
	 */
	public void addVars(int newVars) {
		nVars += newVars;

		for (Instance instance : instances) {
			instance.addVars(newVars);
		}
	}
}
