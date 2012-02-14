package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.core.Genotype;
import org.opt4j.core.IndividualFactory;
import org.opt4j.operator.copy.Copy;
import org.opt4j.operator.crossover.Crossover;
import org.opt4j.operator.mutate.Mutate;
import org.opt4j.optimizer.ea.ConstantCrossoverRate;
import org.opt4j.optimizer.ea.CrossoverRate;
import org.opt4j.optimizer.ea.EvolutionaryAlgorithmModule;
import org.opt4j.optimizer.ea.Mating;

import com.google.inject.TypeLiteral;

import de.uka.ipd.sdq.dsexplore.opt4j.operator.CopyDesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.operator.MutateDesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.operator.UniformDesignDecisionGenotypeCrossover;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.MatingWithHeuristics;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.NoDuplicatesEvolutionaryAlgorithm;
import de.uka.ipd.sdq.tcfmoop.tcmanager.TerminationCriteriaManager;

public class DSEEvolutionaryAlgorithmModule extends EvolutionaryAlgorithmModule {
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {

		bindOptimizer(NoDuplicatesEvolutionaryAlgorithm.class);
		bind(Mating.class).to(MatingWithHeuristics.class).in(SINGLETON);

		bind(CrossoverRate.class).to(ConstantCrossoverRate.class).in(SINGLETON);
		
		bind(IndividualFactory.class).to(DSEIndividualFactory.class);
		
		//CrossoverModule.addOperator
		bind(new TypeLiteral<Crossover<Genotype>>() {}).to((Class<? extends Crossover<Genotype>>) UniformDesignDecisionGenotypeCrossover.class);
		//CrossoverModule.addCrossover(binder(),UniformDesignDecisionGenotypeCrossover.class);
		//CrossoverModule.addCrossover(binder(),DesignDecisionCrossover.class);
		
		bind(new TypeLiteral<Mutate<Genotype>>() {}).to((Class<? extends Mutate<Genotype>>) MutateDesignDecisionGenotype.class);
		//MutateModule.addMutate(binder(),MutateDesignDecisionGenotype.class);
		
		bind(new TypeLiteral<Copy<Genotype>>() {}).to((Class<? extends Copy<Genotype>>) CopyDesignDecisionGenotype.class);
		//CopyModule.addCopy(binder(), CopyDesignDecisionGenotype.class);

		addOptimizerIterationListener(TerminationCriteriaManager.class);

		// To exchange the selector, we cannot do the following because then the binding will be attempted twice and an exception is thrown. Thus, reimplement the selector module. 
		//bind(Selector.class).to(Nsga2.class).in(SINGLETON);
		//bind(Selector.class).to(Spea2.class).in(SINGLETON);
	}
	
}
