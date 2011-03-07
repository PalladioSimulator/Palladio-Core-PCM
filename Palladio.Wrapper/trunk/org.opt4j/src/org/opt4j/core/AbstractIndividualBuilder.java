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
import java.util.concurrent.CopyOnWriteArraySet;

import org.opt4j.core.problem.Creator;
import org.opt4j.core.problem.Genotype;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * The {@code AbstractIndividualBuilder}.
 * 
 * @author lukasiewycz
 * 
 * @param <I>
 *            the type of Individual
 */
public class AbstractIndividualBuilder<I extends Individual> implements
		IndividualBuilder {

	protected final Creator<Genotype> creator;
	protected final Provider<I> individualProvider;

	protected Set<IndividualStateListener> individualStateListeners = new CopyOnWriteArraySet<IndividualStateListener>();

	/**
	 * Constructs an {@code AbstractIndividualBuilder} with a {@code Provider}
	 * for {@code Individuals}.
	 * 
	 * @param individualProvider
	 *            the provider that creates new Individuals
	 * @param creator
	 *            the creator that creates random Genotypes
	 */
	@SuppressWarnings("unchecked")
	public AbstractIndividualBuilder(Provider<I> individualProvider,
			Creator creator) {
		this.individualProvider = individualProvider;
		this.creator = creator;
	}
	
	@Inject
	protected void injectListeners(Set<IndividualStateListener> listeners){
		individualStateListeners.addAll(listeners);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualBuilder#addIndividualStateListener(org.opt4j
	 * .core.IndividualStateListener)
	 */
	public void addIndividualStateListener(IndividualStateListener listener) {
		individualStateListeners.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.IndividualBuilder#build()
	 */
	public Individual build() {
		Individual individual = individualProvider.get();
		individual.setIndividualStatusListeners(individualStateListeners);
		Genotype genotype = creator.create();
		individual.setGenotype(genotype);

		return individual;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.IndividualBuilder#build(org.opt4j.core.Genotype)
	 */
	public Individual build(Genotype genotype) {
		Individual individual = individualProvider.get();
		individual.setIndividualStatusListeners(individualStateListeners);
		individual.setGenotype(genotype);
		return individual;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualBuilder#removeIndividualStateListener(org.opt4j
	 * .core.IndividualStateListener)
	 */
	public void removeIndividualStateListener(IndividualStateListener listener) {
		individualStateListeners.remove(listener);
	}
}
