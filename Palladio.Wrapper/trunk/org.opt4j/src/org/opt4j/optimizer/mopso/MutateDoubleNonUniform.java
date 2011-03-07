package org.opt4j.optimizer.mopso;

import org.opt4j.common.random.Rand;
import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.operator.mutate.MutationRate;
import org.opt4j.operator.normalize.NormalizeDouble;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code MutateDoubleNonUniform} non-uniformly mutates a {@code
 * DoubleGenotype} elementwise.
 * 
 * @author lukasiewycz
 * 
 */
public class MutateDoubleNonUniform extends MutateDoubleUniform {

	protected final Optimizer optimizer;
	protected final int maxIterations;

	/**
	 * Constructs a {@code MutateDoubleNonUniform}.
	 * 
	 * @param mutationRate
	 *            the mutation rate
	 * @param random
	 *            the random number generator
	 * @param normalize
	 *            the normalize operator
	 * @param optimizer
	 *            the optimizer
	 * @param perturbation
	 *            the perturbation index
	 * @param maxIterations
	 *            the number of maximal iteration of the optimizer
	 */
	@Inject
	public MutateDoubleNonUniform(
			MutationRate mutationRate,
			Rand random,
			NormalizeDouble normalize,
			Optimizer optimizer,
			@Constant(value = "perturbation", namespace = MutateDoubleNonUniform.class) double perturbation,
			@Iterations int maxIterations) {
		super(mutationRate, random, normalize, perturbation);
		this.optimizer = optimizer;
		this.maxIterations = maxIterations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.optimizer.mopso.MutateDoubleUniform#mutateElement(double)
	 */
	@Override
	protected double mutateElement(double x) {
		if (random.nextDouble() < mutationRate.get()) {
			double tau = random.nextBoolean() ? 1 : -1;
			x += tau * delta(perturbation);
		}
		return x;
	}

	/**
	 * Calculates the delta value for the non-uniform mutation.
	 * 
	 * @param perturbation
	 *            the perturbation value
	 * @return the delta value
	 */
	protected double delta(double perturbation) {
		final double diff = 1.0 - 0.0;
		double r = random.nextDouble();

		double actIter = optimizer.getIteration();
		double maxIter = maxIterations;
		double ratio = actIter / maxIter;
		ratio = Math.min(ratio, 1.0);

		double y = Math.pow(1.0 - ratio, perturbation);
		return diff * (1.0 - Math.pow(r, y));
	}

}
