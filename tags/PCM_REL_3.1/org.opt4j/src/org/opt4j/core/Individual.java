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

package org.opt4j.core;

import java.util.Set;

import com.google.inject.Inject;

/**
 * The {@code Individual} class forms a single solution for the given
 * optimization problem.
 * 
 * @author glass, lukasiewycz
 */
public class Individual {

	/*
	 * protected final Creator<Genotype> creator;
	 * 
	 * protected final Decoder<Genotype, Phenotype> decoder;
	 * 
	 * protected final Evaluator<Phenotype> evaluator;
	 */

	protected Genotype genotype;

	protected Phenotype phenotype;

	protected Objectives objectives;

	protected Set<IndividualStateListener> individualStateListeners;

	protected State state = State.EMPTY;

	/**
	 * The possible states of an {@code Individual}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum State {
		/**
		 * Initial state.
		 */
		EMPTY("empty", false, false, false),
		/**
		 * Individual has a {@code Genotype}.
		 */
		GENOTYPED("genotyped", false, false, false),
		/**
		 * Individual is currently being decoded.
		 */
		DECODING("decoding", false, false, true),
		/**
		 * Individual has a Phenotype, i.e. it is decoded.
		 */
		PHENOTYPED("phenotyped", true, false, false),
		/**
		 * Individual is currently being evaluated.
		 */
		EVALUATING("evaluating", true, false, true),
		/**
		 * Individual is evaluated.
		 */
		EVALUATED("evaluated", true, true, false);

		private final String name;

		private final boolean decoded;

		private final boolean evaluated;

		private final boolean processing;

		/**
		 * Defines a new State
		 * 
		 * @param name
		 *            the full name of the state
		 * @param decoded
		 *            {@code true} if the individual is decoded in this state
		 * @param evaluated
		 *            {@code true} if the individual is evaluated in this state
		 * @param processing
		 *            {@code true} if the individual is processing in this state
		 */
		State(String name, boolean decoded, boolean evaluated,
				boolean processing) {
			this.name = name;
			this.decoded = decoded;
			this.evaluated = evaluated;
			this.processing = processing;
		}

		/**
		 * Returns the specific name of the state.
		 * 
		 * @return the specific name of the state
		 */
		@Override
		public String toString() {
			return name;
		}

		/**
		 * Returns {@code true} if the individual is decoded in the current
		 * state.
		 * 
		 * @return {@code true} if the individual is decoded in the current
		 *         state
		 */
		public boolean isDecoded() {
			return decoded;
		}

		/**
		 * Returns {@code true} if the individual is evaluated in the current
		 * state.
		 * 
		 * @return {@code true} if the individual is evaluated in the current
		 *         state
		 */
		public boolean isEvaluated() {
			return evaluated;
		}

		/**
		 * Returns {@code true} if the individual is processing in the current
		 * state.
		 * 
		 * @return {@code true} if the individual is processing in the current
		 *         state
		 */
		public boolean isProcessing() {
			return processing;
		}

	}

	/**
	 * Constructs an {@code Individual}.
	 */
	@Inject
	protected Individual() {
		super();
	}

	/**
	 * Returns the phenotype.
	 * 
	 * @return the phenotype
	 */
	public Phenotype getPhenotype() {
		return phenotype;
	}

	/**
	 * Returns the objectives.
	 * 
	 * @return the objectives
	 */
	public Objectives getObjectives() {
		return objectives;
	}

	/**
	 * Returns the genotype.
	 * 
	 * @return the genotype
	 */
	public Genotype getGenotype() {
		return genotype;
	}

	/**
	 * Sets the genotype.
	 * 
	 * @param genotype
	 *            the genotype to be set
	 */
	public void setGenotype(Genotype genotype) {
		this.genotype = genotype;
		setState(State.GENOTYPED);
	}

	/**
	 * Sets the phenotype.
	 * 
	 * @param phenotype
	 *            the phenotype to be set
	 */
	public void setPhenotype(Phenotype phenotype) {
		this.phenotype = phenotype;
		setState(State.PHENOTYPED);
	}

	/**
	 * Sets the objectives.
	 * 
	 * @param objectives
	 *            the objectives to be set
	 */
	public void setObjectives(Objectives objectives) {
		this.objectives = objectives;
		setState(State.EVALUATED);
	}

	/**
	 * Indicates whether this {@code Individual} is already decoded.
	 * 
	 * @return {@code true} if this individual is decoded
	 */
	public boolean isDecoded() {
		return state.isDecoded();
	}

	/**
	 * Indicates whether this {@code Individual} is already evaluated.
	 * 
	 * @return {@code true} if this inividual is evaluated
	 */
	public boolean isEvaluated() {
		return state.isEvaluated();
	}

	/**
	 * Sets the state of the {@code Individual}.
	 * 
	 * @param state
	 *            the new status
	 */
	public void setState(State state) {
		if (this.state != state) {
			this.state = state;

			for (IndividualStateListener listener : individualStateListeners) {
				listener.inidividualStateChanged(this);
			}
		}
	}

	/**
	 * Returns the state of the {@code Individual}.
	 * 
	 * @return the current state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Sets the list of {@code IndividualStateListener}s that are called if the
	 * {@code Status} of this individual changes.
	 * 
	 * @param individualStateListeners
	 *            the listener for a changing status.
	 */
	protected void setIndividualStatusListeners(
			Set<IndividualStateListener> individualStateListeners) {
		this.individualStateListeners = individualStateListeners;
	}
}
