package org.opt4j.tutorial;

import java.util.Collection;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Population;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;
import org.opt4j.operator.mutate.Mutate;
import org.opt4j.optimizer.ea.Selector;

import com.google.inject.Inject;

public class MutateOptimizer extends AbstractOptimizer {

	protected final Mutate<Genotype> mutate;

	protected final Copy<Genotype> copy;

	protected final Selector selector;

	protected final int iterations;

	public static final int POPSIZE = 100;

	public static final int OFFSIZE = 25;

	@Inject
	public MutateOptimizer(Population population, Archive archive,
			IndividualBuilder individualBuilder, Completer completer,
			Control control, Selector selector, Mutate<Genotype> mutate,
			Copy<Genotype> copy, @Iterations int iterations) {
		super(population, archive, individualBuilder, completer, control);
		this.mutate = mutate;
		this.copy = copy;
		this.selector = selector;
		this.iterations = iterations;
	}

	public void optimize() throws TerminationException, StopException {
		selector.init(OFFSIZE + POPSIZE);

		for (int i = 0; i < 100; i++) {
			population.add(individualBuilder.build());
		}

		nextIteration();

		for (int i = 0; i < iterations; i++) {

			Collection<Individual> parents = selector.getParents(OFFSIZE,
					population);

			for (Individual parent : parents) {
				Genotype genotype = copy.copy(parent.getGenotype());
				mutate.mutate(genotype);

				Individual child = individualBuilder.build(genotype);
				population.add(child);
			}

			completer.complete(population);

			Collection<Individual> lames = selector.getLames(OFFSIZE,
					population);
			population.removeAll(lames);

			nextIteration();

		}

	}

}
