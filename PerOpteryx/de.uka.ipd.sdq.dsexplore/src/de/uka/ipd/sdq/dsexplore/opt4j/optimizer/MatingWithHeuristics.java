package de.uka.ipd.sdq.dsexplore.opt4j.optimizer;

import java.util.ArrayList;
import java.util.Collection;
import org.opt4j.common.random.Rand;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;
import org.opt4j.operator.crossover.Crossover;
import org.opt4j.operator.mutate.Mutate;
import org.opt4j.operator.mutate.MutationRate;
import org.opt4j.optimizer.ea.Coupler;
import org.opt4j.optimizer.ea.CrossoverRate;
import org.opt4j.optimizer.ea.MatingCrossoverMutate;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.QMLBoundDependentTacticOperatorsManager;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticOperatorsManager;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.*;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

/**
 * 
 * @author martens, beyer, noorshams
 *
 */
public class MatingWithHeuristics extends MatingCrossoverMutate {
	
	private TacticOperatorsManager heuristicManager;
	
	public TacticOperatorsManager getHeuristicManager() {
		return this.heuristicManager;
	}
	
	@Inject
	public MatingWithHeuristics(Crossover<Genotype> crossover, Mutate<Genotype> mutate, Copy<Genotype> copy,
			Coupler coupler, CrossoverRate crossoverRate, MutationRate mutationRate, Rand random,
			IndividualFactory individualFactory, 
			/*noorshams: inject this, I don't want to break the "injection chain"*/
			QMLBoundDependentTacticOperatorsManager qmlTacticManager) {
		super(crossover, mutate, copy, coupler, crossoverRate, mutationRate, random,
				individualFactory);
		if (Opt4JStarter.getDSEWorkflowConfig().isConsiderQMLBoundsWhenApplyingHeuristics()) {
			heuristicManager = qmlTacticManager;
		} else if (Opt4JStarter.getDSEWorkflowConfig().isUseHeuristics()){
			heuristicManager = new TacticOperatorsManager(copy, (DSEIndividualFactory)individualFactory);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mating.Mating#getOffspring(int,
	 * java.util.Collection)
	 */
	@Override
	public Collection<Individual> getOffspring(int size,
			Collection<Individual> parents) {
		Collection<Individual> offspring = new ArrayList<Individual>();
		Collection<Pair<Individual>> couples = coupler.getCouples((int) Math
				.ceil(((double) size / 2)), new ArrayList<Individual>(parents));

		for (Pair<Individual> couple : couples) {
			boolean crossover = random.nextDouble() <= crossoverRate.get();
			Individual parent1 = couple.getFirst();
			Individual parent2 = couple.getSecond();
			Pair<Individual> i = mate(parent1, parent2, crossover);
			Individual i1 = i.getFirst();
			Individual i2 = i.getSecond();
			
			offspring.add(i1);
			if (offspring.size() < size) {
				offspring.add(i2);
			}
		}

		return offspring;
	}
	
	/**
	 * Performs the actual coupler process of two parents using
	 * heuristics
	 * 
	 * @param parent1
	 *            parent one
	 * @param parent2
	 *            parent two
	 * @param doCrossover
	 *            indicates whether the coupler shall take place
	 * @return the two offspring individuals
	 */
	protected Pair<Individual> mate(Individual parent1, Individual parent2,
			boolean doCrossover) {

		Genotype p1 = parent1.getGenotype();
		Genotype p2 = parent2.getGenotype();
		Genotype o1, o2;
		
		Individual i1 = null;
		Individual i2 = null;

		// try to apply heuristics
		// if not applicable: mutate
		boolean useHeuristics = Opt4JStarter.getDSEWorkflowConfig().isUseHeuristics();
		double tacticsProbability = Opt4JStarter.getDSEWorkflowConfig().getTacticsProbability();

		if (useHeuristics && Math.random() < tacticsProbability){ 
			i1 = heuristicManager.getCandidate((DSEIndividual)parent1);
			i2 = heuristicManager.getCandidate((DSEIndividual)parent2);
		} 

		if (i1 == null && i2 == null){

			if (doCrossover) {
				Pair<Genotype> offspring = crossover.crossover(p1, p2);
				o1 = offspring.getFirst();
				o2 = offspring.getSecond();
				// do mutate but don't use heuristics
				mutate.mutate(o1, mutationRate.get());
				mutate.mutate(o2, mutationRate.get());

				i1 = individualFactory.create(o1);
				i2 = individualFactory.create(o2);
			} // else go into mutation code below as i1 and i2 are null.
		}

		if (i1 == null) {
			o1 = copy.copy(p1);
			mutate.mutate(o1, mutationRate.get());
			i1 = individualFactory.create(o1);
		}
		if (i2 == null) {
			o2 = copy.copy(p2);
			mutate.mutate(o2, mutationRate.get());
			i2 = individualFactory.create(o2);
		}

		Pair<Individual> individuals = new Pair<Individual>(i1, i2);
		return individuals;
	}

}
