package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.core.AbstractIndividualFactory;
import org.opt4j.core.Genotype;
import org.opt4j.core.problem.Creator;


import com.google.inject.Inject;
import com.google.inject.Provider;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;

public class DSEIndividualFactory extends AbstractIndividualFactory<DSEIndividual> {

	private DecisionSpace problem;

	@Inject
	public DSEIndividualFactory(Provider<DSEIndividual> individualProvider,
			Creator<DesignDecisionGenotype> creator) {
		super(individualProvider, creator);
		this.problem = Opt4JStarter.getProblem().getEMFProblem();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.IndividualFactory#build()
	 */
	@Override
	public DSEIndividual create() {
		DSEIndividual individual = new DSEIndividual(problem);
		individual.setIndividualStatusListeners(individualStateListeners);
		Genotype genotype = creator.create();
		individual.setGenotype(genotype);

		return individual;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.IndividualFactory#build(org.opt4j.core.Genotype)
	 */
	@Override
	public DSEIndividual create(Genotype genotype) {
		DSEIndividual individual = new DSEIndividual(problem);
		individual.setIndividualStatusListeners(individualStateListeners);
		individual.setGenotype(genotype);
		return individual;
	}
	
	public TacticsResultCandidate buildCandidate(Genotype genotype, DSEIndividual parent) {
		TacticsResultCandidate individual = new TacticsResultCandidate(problem, parent);
		individual.setIndividualStatusListeners(individualStateListeners);
		individual.setGenotype(genotype);
		return individual;
	}

}
