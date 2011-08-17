package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.core.AbstractIndividualBuilder;
import org.opt4j.core.problem.Genotype;
import org.opt4j.core.problem.Creator;


import com.google.inject.Inject;
import com.google.inject.Provider;

import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;

public class DSEIndividualBuilder extends AbstractIndividualBuilder<DSEIndividual> {

	@SuppressWarnings("unchecked")
	@Inject
	public DSEIndividualBuilder(Provider<DSEIndividual> individualProvider,
			Creator creator) {
		super(individualProvider, creator);
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.IndividualBuilder#build()
	 */
	@Override
	public DSEIndividual build() {
		DSEIndividual individual = new DSEIndividual();
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
	@Override
	public DSEIndividual build(Genotype genotype) {
		DSEIndividual individual = new DSEIndividual();
		individual.setIndividualStatusListeners(individualStateListeners);
		individual.setGenotype(genotype);
		return individual;
	}
	
	public TacticsResultCandidate buildCandidate(Genotype genotype, DSEIndividual parent) {
		TacticsResultCandidate individual = new TacticsResultCandidate(parent);
		individual.setIndividualStatusListeners(individualStateListeners);
		individual.setGenotype(genotype);
		return individual;
	}

}
