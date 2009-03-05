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

package org.opt4j.common.completer;

import java.util.Arrays;
import java.util.List;

import org.opt4j.core.Genotype;
import org.opt4j.core.IncompatibilityException;
import org.opt4j.core.Individual;
import org.opt4j.core.Objectives;
import org.opt4j.core.Phenotype;
import org.opt4j.core.Individual.State;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.core.problem.Decoder;
import org.opt4j.core.problem.Evaluator;

import com.google.inject.Inject;

/**
 * The {@code SequentialCompleter} completes the {@code Individuals}
 * sequentially.
 * 
 * @author lukasiewycz
 * 
 */
public class SequentialCompleter implements Completer {

	protected final Decoder<Genotype, Phenotype> decoder;
	protected final Evaluator<Phenotype> evaluator;
	protected final Control control;

	/**
	 * Constructs a {@code SequentialCompleter}.
	 * 
	 * @param control
	 *            the optimization control
	 * @param decoder
	 *            the decoder
	 * @param evaluator
	 *            the evaluator
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public SequentialCompleter(Control control, Decoder decoder,
			Evaluator evaluator) {
		super();
		this.control = control;
		this.decoder = decoder;
		this.evaluator = evaluator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Completer#complete(java.lang.Iterable)
	 */
	public void complete(Iterable<? extends Individual> iterable)
			throws TerminationException {
		for (Individual individual : iterable) {
			if (!individual.isEvaluated()) {
				control.checkpoint();
				decode(individual);
				control.checkpoint();
				evaluate(individual);
				control.checkpoint();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.Completer#complete(org.opt4j.core.Individual[])
	 */
	public void complete(Individual... individuals) throws TerminationException {
		List<Individual> list = Arrays.asList(individuals);
		complete(list);
	}

	protected void evaluate(Individual individual) {
		State state = individual.getState();

		if (state == State.PHENOTYPED) {

			individual.setState(State.EVALUATING);
			Phenotype phenotype = individual.getPhenotype();
			Objectives objectives = evaluator.evaluate(phenotype);
			if (objectives.size() != evaluator.getObjectives().size()
					|| !objectives.getKeys().containsAll(
							evaluator.getObjectives())) {
				throw new IncompatibilityException(
						"Incompatible objectives: Evaluator should set following objectives: "
								+ evaluator.getObjectives() + ". But actually "
								+ objectives.getKeys() + " are set.");
			}
			objectives.submit();
			individual.setObjectives(objectives);

		} else {
			throw new IllegalStateException(
					"Cannot evaluate Individual, current state: " + state);
		}
	}

	protected void decode(Individual individual) {
		State state = individual.getState();

		if (state == State.GENOTYPED) {
			individual.setState(State.DECODING);
			Genotype genotype = individual.getGenotype();
			Phenotype phenotype = decoder.decode(genotype);
			individual.setPhenotype(phenotype);
		} else {
			throw new IllegalStateException(
					"Cannot decode Individual, current state: " + state);
		}
	}

}
