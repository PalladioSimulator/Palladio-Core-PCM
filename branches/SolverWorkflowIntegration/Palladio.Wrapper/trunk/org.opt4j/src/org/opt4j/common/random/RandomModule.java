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

package org.opt4j.common.random;

import java.util.Random;

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Required;
import org.opt4j.start.Opt4JModule;

/**
 * The {@code RandomModule} is used to configure the used random number
 * generator.
 * 
 * @author helwig, lukasiewycz
 */
@Icon(Icons.PUZZLE_BLUE)
@Info("Global random number generator for the optimization process.")
public class RandomModule extends Opt4JModule {

	@Info("Seed of the random number generator")
	@Required(property = "useSeed", elements = { "true" })
	protected long seed = 0;

	@Info("Use a specific seed")
	protected boolean useSeed = true;

	@Info("Type of the random number generator")
	protected RandType type = RandType.MERSENNE_TWISTER;

	/**
	 * The {@code RandType}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum RandType {
		@Info("Use the standard java Random")
		JAVA, @Info("Use the mersenne twister random number generator")
		MERSENNE_TWISTER;
	}

	/**
	 * Constructs a new {@code RandModule}.
	 */
	public RandomModule() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		Class<? extends Random> randomClass;
		switch (type) {
		case JAVA:
			randomClass = RandomJava.class;
			break;
		default: // MERSENNE TWISTER
			randomClass = RandomMersenneTwister.class;
			break;
		}

		long seed = this.seed;
		if (!useSeed) {
			seed = System.currentTimeMillis();
		}

		bindConstant("seed", Random.class).to(seed);
		bind(Random.class).to(randomClass).in(SINGLETON);
	}

	/**
	 * Sets the seed that is used by the random number generator.
	 * 
	 * @param seed
	 *            the seed that is used by the random number generator
	 */
	public void setSeed(long seed) {
		this.seed = seed;
	}

	/**
	 * Returns the seed the is used by the random number generator.
	 * 
	 * @return the seed the is used by the random number generator
	 */
	public long getSeed() {
		return seed;
	}

	/**
	 * Sets the type of the random number generator to the specified value.
	 * 
	 * @param type
	 *            the type of the random number generator
	 */
	public void setType(RandType type) {
		this.type = type;
	}

	/**
	 * Returns the type of the random number generator.
	 * 
	 * @return the type of the random number generator
	 */
	public RandType getType() {
		return type;
	}

	/**
	 * Returns {@code true} if a specific seed is given.
	 * 
	 * @return the useSeed
	 */
	public boolean isUseSeed() {
		return useSeed;
	}

	/**
	 * Sets the value for a specific seed usage.
	 * 
	 * @param useSeed
	 *            the useSeed to set
	 */
	public void setUseSeed(boolean useSeed) {
		this.useSeed = useSeed;
	}

}
