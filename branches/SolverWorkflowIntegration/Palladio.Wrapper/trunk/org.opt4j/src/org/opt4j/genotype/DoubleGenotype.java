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

package org.opt4j.genotype;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.opt4j.core.Genotype;

/**
 * The {@code DoubleGenotype} consists of double values that can be used as a
 * {@code Genotype}.
 * 
 * @author lukasiewycz
 * 
 */
@SuppressWarnings("serial")
public class DoubleGenotype extends ArrayList<Double> implements ListGenotype {

	static class DefaultBounds implements Bounds<Double> {

		@Override
		public Double getLowerBound(int index) {
			return 0.0;
		}

		@Override
		public Double getUpperBound(int index) {
			return 1.0;
		}

	}

	protected final Bounds<Double> bounds;

	/**
	 * Constructs a {@code DoubleGenotype} with lower bounds {@code 0.0} and
	 * upper bounds {@code 1.0}.
	 */
	public DoubleGenotype() {
		this(new DefaultBounds());
	}

	/**
	 * Constructs a {@code DoubleGenotype} with the given {@code Bounds}.
	 * 
	 * @param bounds
	 *            the bounds
	 */
	public DoubleGenotype(Bounds<Double> bounds) {
		this.bounds = bounds;
	}

	/**
	 * Returns the lower bound for the {@code i}-th element.
	 * 
	 * @param index
	 *            the {@code i}-th element
	 * @return the lower bound of the {@code i}-th element
	 */
	public double getLowerBound(int index) {
		return bounds.getLowerBound(index);
	}

	/**
	 * Returns the upper bound for the {@code i}-th element.
	 * 
	 * @param index
	 *            the {@code i}-th element
	 * @return the upper bound of the {@code i}-th element
	 */
	public double getUpperBound(int index) {
		return bounds.getUpperBound(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.Genotype#newInstance()
	 */
	@SuppressWarnings("unchecked")
	public <G extends Genotype> G newInstance() {
		try {
			Constructor<? extends DoubleGenotype> cstr = this.getClass()
					.getConstructor(Bounds.class);
			return (G) cstr.newInstance(bounds);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
