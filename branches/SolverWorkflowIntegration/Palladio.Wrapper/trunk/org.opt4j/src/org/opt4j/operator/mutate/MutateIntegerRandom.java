package org.opt4j.operator.mutate;

import java.util.Random;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.IntegerGenotype;

import com.google.inject.Inject;

/**
 * The {@code MutateIntegerRandom} mutates each element of the
 * {@link IntegerGenotype} with the mutation rate. Here, a new value is created
 * randomly between the lower and upper bounds.
 * 
 * @author lukasiewycz
 * 
 */
public class MutateIntegerRandom implements MutateInteger {

	protected final Random random;

	protected final MutationRate mutationRate;

	/**
	 * Constructs a {@code MutateIntegerRandom}.
	 * 
	 * @param random
	 *            the random number generator
	 * @param mutationRate
	 *            the mutation rate
	 */
	@Inject
	public MutateIntegerRandom(Random random, MutationRate mutationRate) {
		this.random = random;
		this.mutationRate = mutationRate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mutate.Mutate#mutate(org.opt4j.core.Genotype)
	 */
	@Override
	public void mutate(Genotype genotype) {
		IntegerGenotype list = (IntegerGenotype) genotype;

		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (random.nextDouble() < mutationRate.get()) {
				int lb = list.getLowerBound(i);
				int ub = list.getUpperBound(i);
				int value = random.nextInt(ub - lb + 1) + lb;
				list.set(i, value);
			}
		}
	}

}
