package org.opt4j.optimizer.mopso;

import java.util.Random;

import org.opt4j.operator.mutate.MutateDoubleElementwise;
import org.opt4j.operator.mutate.MutationRate;
import org.opt4j.operator.normalize.NormalizeDouble;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code MutateDoubleUniform} uniformly mutates a {@code DoubleGenotype}
 * elementwise.
 * 
 * @author lukasiewycz
 * 
 */
public class MutateDoubleUniform extends MutateDoubleElementwise {

	protected final double perturbation;

	/**
	 * Constructs a {@code MutateDoubleUniform}.
	 * 
	 * @param mutationRate
	 *            the mutation rate
	 * @param random
	 *            the random number generator
	 * @param normalize
	 *            the normalize operator
	 * @param perturbation
	 *            the perturbation index
	 */
	@Inject
	public MutateDoubleUniform(
			MutationRate mutationRate,
			Random random,
			NormalizeDouble normalize,
			@Constant(value = "perturbation", namespace = MutateDoubleNonUniform.class) double perturbation) {
		super(mutationRate, random, normalize);
		this.perturbation = perturbation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.mutate.MutateDoubleElementwise#mutateElement(double)
	 */
	@Override
	protected double mutateElement(double x) {
		if (random.nextDouble() < mutationRate.get()) {
			double v = (random.nextDouble() - 0.5) * perturbation;
			x += v;
		}
		return x;
	}

}
