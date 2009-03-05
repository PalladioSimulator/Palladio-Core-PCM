package org.opt4j.operator.crossover;

import java.util.Random;

import com.google.inject.Inject;

/**
 * The {@code CrossoverIntegerDefault} is the {@link CrossoverIntegerRate} with
 * the {@code rate=0.5}.
 * 
 * @author lukasiewycz
 * 
 */
public class CrossoverIntegerDefault extends CrossoverIntegerRate {

	/**
	 * Constructs a {@code CrossoverIntegerDefault}.
	 * 
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public CrossoverIntegerDefault(Random random) {
		super(0.5, random);
	}

}
