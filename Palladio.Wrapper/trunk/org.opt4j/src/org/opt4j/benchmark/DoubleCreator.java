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

package org.opt4j.benchmark;

import java.util.Random;

import org.opt4j.core.problem.Creator;

import com.google.inject.Inject;

/**
 * The {@code DoubleCreator} creates {@code DoubleString}s with the length
 * {@code n}.
 * 
 * @author lukasiewycz
 * 
 */
public class DoubleCreator implements Creator<DoubleString> {

	protected final int n;

	protected final Random random;

	/**
	 * Constructs a {@code DoubleCreator}.
	 * 
	 * @param random
	 *            the random number generator
	 * @param n
	 *            the n value
	 */
	@Inject
	public DoubleCreator(Random random, @N int n) {
		super();
		this.random = random;
		this.n = n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.problem.Creator#create()
	 */
	public DoubleString create() {
		DoubleString string = new DoubleString();
		for (int i = 0; i < n; i++) {
			double lb = string.getLowerBound(i);
			double ub = string.getUpperBound(i);
			string.add(lb+random.nextDouble()*(ub-lb));
		}
		return string;
	}
}
