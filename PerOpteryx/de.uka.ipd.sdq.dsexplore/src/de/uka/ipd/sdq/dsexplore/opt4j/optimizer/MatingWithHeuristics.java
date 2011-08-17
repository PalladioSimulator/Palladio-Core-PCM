package de.uka.ipd.sdq.dsexplore.opt4j.optimizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.opt4j.common.random.Rand;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;
import org.opt4j.operator.crossover.Crossover;
import org.opt4j.operator.mutate.Mutate;
import org.opt4j.optimizer.ea.Coupler;
import org.opt4j.optimizer.ea.CrossoverRate;
import org.opt4j.optimizer.ea.Mating;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticOperatorsManager;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.*;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.dsexplore.analysis.*;

/**
 * 
 * @author martens, beyer
 *
 */
public class MatingWithHeuristics extends Mating {
	
	private TacticOperatorsManager heuristicManager;
	
	public TacticOperatorsManager getHeuristicManager() {
		return this.heuristicManager;
	}
	
	@Inject
	public MatingWithHeuristics(Crossover<Genotype> crossover, Mutate<Genotype> mutate, Copy<Genotype> copy,
			Coupler coupler, CrossoverRate crossoverRate, Rand random,
			IndividualBuilder individualBuilder) {
		super(crossover, mutate, copy, coupler, crossoverRate, random,
				individualBuilder);
		if (Opt4JStarter.getDSEWorkflowConfig().isUseHeuristics()){
			heuristicManager = new TacticOperatorsManager(copy, (DSEIndividualBuilder)individualBuilder);
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
	private Pair<Individual> mate(Individual parent1, Individual parent2,
			boolean doCrossover) {

		Genotype p1 = parent1.getGenotype();
		Genotype p2 = parent2.getGenotype();
		Genotype o1, o2;
		
		Individual i1 = null;
		Individual i2 = null;

		if (doCrossover) {
			Pair<Genotype> offspring = crossover.crossover(p1, p2);
			o1 = offspring.getFirst();
			o2 = offspring.getSecond();
			// do mutate but don't use heuristics
			mutate.mutate(o1);
			mutate.mutate(o2);

			i1 = individualBuilder.build(o1);
			i2 = individualBuilder.build(o2);
		} else {
			o1 = copy.copy(p1);
			o2 = copy.copy(p2);
			// try to apply heuristics
			// if not applicable: mutate
			
			boolean useHeuristics = Opt4JStarter.getDSEWorkflowConfig().isUseHeuristics();
			//TODO: also get the threshold and the increase factor from the config
			//Possibly add more parameters to launch configuration.
			if (useHeuristics){
				i1 = heuristicManager.getCandidate((DSEIndividual)parent1);
				i2 = heuristicManager.getCandidate((DSEIndividual)parent2);
			} 
			if (i1 == null) {
				mutate.mutate(o1);
				i1 = individualBuilder.build(o1);
			}
			if (i2 == null) {
				mutate.mutate(o2);
				i2 = individualBuilder.build(o2);
			}
		}





		Pair<Individual> individuals = new Pair<Individual>(i1, i2);
		return individuals;
	}

}
