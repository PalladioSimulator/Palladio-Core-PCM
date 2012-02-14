package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.startingPopulation.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.TerminationException;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.operator.CopyDesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.startingPopulation.AbstractStartingPopulationHeuristic;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * Class implements a basic strategy to implement a heuristic that generates a starting
 * population. The user specifies minNumerOfResourceContainers and maxNumberOfResourceContainers. Then
 * the algorithm will generate numberOfCandidatesPerAllocationLevel individuals for each resource container
 * number ("allocation level") between minNumberOfResourceContainers and maxNumberOfResourceContainers using a random allocation
 * of components (resp. allocation contexts) to resource containers and the default processing rate (as used
 * by firstIndividual. For each allocation level all individuals are evaluated and the Pareto optimal
 * candidates are put into the population. Then four new individuals are generated for each Pareto optimal 
 * individual in the population. These new individuals use four different processing rates: minimum processing
 * rate, maximum processing rate, lower processing rate (mean between default and minimum) and higher processing rate 
 * (mean between default and maximum). All of them are put into the population as well.
 * @author Tom Beyer
 *
 */
public class StartingPopulationHeuristicImpl extends AbstractStartingPopulationHeuristic {
	private int minNumberOfResourceContainers;
	private int maxNumberOfResourceContainers;
	private final static int MAX_TRIES = 50;
//	private final double thresholdMaxUtilisation = 0.70;
	private int numberOfCandidatesPerAllocationLevel;
	public enum PROCESSING_RATE_LEVEL {MIN, LESS, DEFAULT, MORE, MAX};
	
	/**
	 * 
	 * @param configuration As defined by the user in the GUI.
	 */
	public StartingPopulationHeuristicImpl(DSEWorkflowConfiguration configuration) {
		super(configuration);
		minNumberOfResourceContainers = configuration.getMinNumberOfResourceContainers();
		maxNumberOfResourceContainers = configuration.getMaxNumberOfResourceContainers();
		numberOfCandidatesPerAllocationLevel = configuration.getNumberOfCandidatesPerAllocationLevel();
	}
	
	/**
	 * 
	 * @param numberOfComponents
	 * @param numberOfResourceContainers
	 * @return Calculates the number of components on each resource container when using numberOfComponents allocation
	 * contexts and numberOfResourceContainers resource containers. Integer represents number of components/allocation 
	 * contexts and each resource container. Size of array will be numberOfResourceContainers.
	 */
	public static ArrayList<Integer> getNumberOfComponentsPerResourceContainer(int numberOfComponents, int numberOfResourceContainers) {
		if (numberOfResourceContainers <= 0 || numberOfComponents < 0) {
			throw new IllegalArgumentException();
		}
		// calculate number of resource containers with floor(numberOfComponents/numberOfResourceContainers) components
		int numberOfServersWithLessComponents = (int) ((numberOfComponents - Math.ceil(((double)numberOfComponents)/((double)numberOfResourceContainers))*numberOfResourceContainers)/
				(Math.floor(((double)numberOfComponents)/((double)numberOfResourceContainers))-Math.ceil(((double)numberOfComponents)/((double)numberOfResourceContainers))));
		ArrayList<Integer> numberOfComponentsPerResourceContainer = new ArrayList<Integer>(numberOfResourceContainers);
		for (int i = 1; i <= numberOfResourceContainers; i++) {
			if (i <= numberOfServersWithLessComponents) {
				numberOfComponentsPerResourceContainer.add((int)Math.floor(((double)numberOfComponents)/((double)numberOfResourceContainers)));
			} else {
				numberOfComponentsPerResourceContainer.add((int)Math.ceil(((double)numberOfComponents)/((double)numberOfResourceContainers)));
			}
		}
		return numberOfComponentsPerResourceContainer;
	}
	
	/**
	 * Used to generate starting population as described in class documentation.
	 * 
	 * FIXME: Must only use those servers that are allowed in designdecisions. 
	 */
	public Collection<DSEIndividual> getStartingPopulation(IndividualCompleter completer, IndividualFactory individualFactory, DSEIndividual baseIndividual) {
		Collection<DSEIndividual> result = new LinkedList<DSEIndividual>();
		// default processing rate
		Collection<DSEIndividual> population = getStartingPopulationWithDefaultProcessingRate(completer, individualFactory, baseIndividual);
		// max processing rate
		result.addAll(getAdjustedProcessingRatePopulation(population, individualFactory, PROCESSING_RATE_LEVEL.MAX));
		// min processing rate
		result.addAll(getAdjustedProcessingRatePopulation(population, individualFactory, PROCESSING_RATE_LEVEL.MIN));
		// less processing rate
		result.addAll(getAdjustedProcessingRatePopulation(population, individualFactory, PROCESSING_RATE_LEVEL.LESS));
		// more processing rate
		result.addAll(getAdjustedProcessingRatePopulation(population, individualFactory, PROCESSING_RATE_LEVEL.MORE));
		result.addAll(population);
		return result;
	}

	
	private Collection<DSEIndividual> getAdjustedProcessingRatePopulation(Collection<DSEIndividual> population, IndividualFactory individualFactory, PROCESSING_RATE_LEVEL processingRateLevel) {
		CopyDesignDecisionGenotype copy = new CopyDesignDecisionGenotype();
		Collection<DSEIndividual> result = new LinkedList<DSEIndividual>();
		for (DSEIndividual individual : population) {
			DSEIndividual newIndividual = (DSEIndividual)individualFactory.create(copy.copy((DesignDecisionGenotype)individual.getGenotype()));
			result.add(newIndividual);
		}
		for (DSEIndividual individual : result) {
			for (Choice choice : individual.getGenotype()) {
				if (choice instanceof ContinousRangeChoice) {
					ContinousRangeChoice continousRangeChoice = (ContinousRangeChoice) choice;
					DegreeOfFreedomInstance DegreeOfFreedomInstance = choice.getDegreeOfFreedomInstance();
					if (DegreeOfFreedomInstance instanceof ContinuousProcessingRateDegree) {
						ContinuousProcessingRateDegree processingRateDegree = (ContinuousProcessingRateDegree) DegreeOfFreedomInstance;
						// actually adjust processing rate. Respect
						// maximum and minimum allowed value of processing rate
						double newProcessingRate = continousRangeChoice.getChosenValue();
						switch (processingRateLevel) {
						case MIN:
							newProcessingRate = processingRateDegree.getFrom();
							break;
						case LESS:
							newProcessingRate = (processingRateDegree.getFrom() + continousRangeChoice.getChosenValue())/2;
							break;
						case DEFAULT:
							newProcessingRate = continousRangeChoice.getChosenValue();
							break;
						case MORE:
							newProcessingRate = (processingRateDegree.getTo() + continousRangeChoice.getChosenValue())/2;
							break;
						case MAX:
							newProcessingRate = processingRateDegree.getTo();
							break;
						}
						continousRangeChoice.setChosenValue(newProcessingRate);
					}
				}
			}
		}
		return result;
	}

//	public Collection<DSEIndividual> getStartingPopulation(IndividualCompleter completer, IndividualFactory individualFactory, int populationSize, DSEIndividual firstIndividual) {
//		Collection<DSEIndividual> population = new LinkedList<DSEIndividual>();
//		CopyDesignDecisionGenotype copy = new CopyDesignDecisionGenotype();
//		if (minNumberOfResourceContainers > maxNumberOfResourceContainers) {
//			throw new IllegalArgumentException("Minimum number of resource containers cannot be larger than maximum number of containers.");
//		}
//		if (maxNumberOfResourceContainers > getResourceContainers().size()) {
//			throw new IllegalArgumentException("There are not enough resource containers available.");
//		}
//		int tries = 0;
//		while (population.size() < populationSize && tries < populationSize + MAX_TRIES) {
//			int randomNumberOfResourceContainers = getRandomInt(minNumberOfResourceContainers, maxNumberOfResourceContainers);
//			ArrayList<Integer> allocation = getNumberOfComponentsPerResourceContainer(getAllocationContexts().size(), randomNumberOfResourceContainers);
//			DSEIndividual newIndividual = (DSEIndividual)individualFactory.build(copy.copy((DesignDecisionGenotype)firstIndividual.getGenotype()));
//			newIndividual = (DSEIndividual) getRandomIndividual(allocation, newIndividual);
//			if (!population.contains(newIndividual)) {
//				try {
//					completer.complete(newIndividual);
//					if(UtilisationHelper.getMaxUtilisation((DSEIndividual) newIndividual) <= thresholdMaxUtilisation) {
//						population.add(newIndividual);
//					}
//				} catch (TerminationException e) {
//					// nothing to do here. we don't add the individual to the population
//				} catch (NullPointerException e) {
//					// nothing to do here. we don't add the individual to the population
//				}
//				
//			}
//			tries++;
//		}
//		return population;
//	}
	
	private Collection<DSEIndividual> getStartingPopulationWithDefaultProcessingRate(IndividualCompleter completer, IndividualFactory individualFactory,
			DSEIndividual firstIndividual) {
		Collection<DSEIndividual> population = new LinkedList<DSEIndividual>();
		CopyDesignDecisionGenotype copy = new CopyDesignDecisionGenotype();
		if (minNumberOfResourceContainers > maxNumberOfResourceContainers) {
			throw new IllegalArgumentException(
					"Minimum number of resource containers cannot be larger than maximum number of containers. Check your starting population heuristic settings.");
		}
		if (maxNumberOfResourceContainers > getResourceContainers().size()) {
			throw new IllegalArgumentException("There are not enough resource containers available. Decrease the \"maximum number of resource containers\" setting in the starting population heuristic configuration in your launch configuration.");
		}
		for (int numberOfResourceContainers = minNumberOfResourceContainers; numberOfResourceContainers <= maxNumberOfResourceContainers; numberOfResourceContainers++) {
			List<DSEIndividual> individualsForAllocation = new ArrayList<DSEIndividual>();
			int tries = 0;
			while (individualsForAllocation.size() < numberOfCandidatesPerAllocationLevel && tries <= numberOfCandidatesPerAllocationLevel + MAX_TRIES) {
				ArrayList<Integer> allocation = getNumberOfComponentsPerResourceContainer(getAllocationContexts()
						.size(), numberOfResourceContainers);
				DSEIndividual newIndividual = (DSEIndividual) individualFactory.create(copy
						.copy((DesignDecisionGenotype) firstIndividual.getGenotype()));
				newIndividual = (DSEIndividual) getRandomIndividual(allocation, newIndividual);
				if (!individualsForAllocation.contains(newIndividual)) {
					try {
						completer.complete(newIndividual);
						individualsForAllocation.add(newIndividual);
					} catch (TerminationException e) {
						// nothing to do here. we don't add the individual to
						// the population
					} catch (NullPointerException e) {
						// nothing to do here. we don't add the individual to
						// the population
					}
				}
				tries++;
			}
			population.addAll(getParetoOptimalIndividuals(individualsForAllocation));
		}
		return population;
	}
	
	
	private List<DSEIndividual> getParetoOptimalIndividuals(List<DSEIndividual> individuals) {
		if (individuals.isEmpty()) {
			return null;
		}
		List<DSEIndividual> toBeRemoved = new ArrayList<DSEIndividual>(individuals.size());
		List<DSEIndividual> result = new ArrayList<DSEIndividual>(individuals.size());
		
		result.addAll(individuals);
		
		for (int i = 0; i < individuals.size(); i++) {
			DSEIndividual indiv1 = individuals.get(i);
			for (int j = i + 1; j < individuals.size(); j++){
				DSEIndividual indiv2 = individuals.get(j);
				if (indiv1.getObjectives().dominates(indiv2.getObjectives())){
					toBeRemoved.add(indiv2);
				} else if (indiv2.getObjectives().dominates(indiv1.getObjectives())){
					toBeRemoved.add(indiv1);
				}
			}
			
		}
		
		result.removeAll(toBeRemoved);
		return result;
	}
	
	private Individual getRandomIndividual(ArrayList<Integer> allocation, Individual individual) {
		ArrayList<Integer> contexts = new ArrayList<Integer>();
		for (int i = 0; i < getAllocationContexts().size(); i++) {
			contexts.add(new Integer(i));
		}
		for (int i = 0; i < allocation.size(); i++) {
			allocateRandomlyToContainer(individual, getResourceContainers().get(i), allocation.get(i), contexts);
		}
		return individual;
	}
	
	private void allocateRandomlyToContainer(Individual individual, ResourceContainer container, int numberOfAllocationContexts,
			ArrayList<Integer> contexts) {
		
		for (int i = 1; i <= numberOfAllocationContexts; i++) {
			int randomIndex = getRandomInt(0, contexts.size()-1);
			int randomContext = contexts.get(randomIndex);
			allocateContextToContainer(container, randomContext, (DSEIndividual)individual);
			contexts.remove(randomIndex);
		}
	}
	
	private void allocateContextToContainer(ResourceContainer container, int allocationContext,
			DSEIndividual individual) {
		int iterationCounter = 0;
		for (Choice choice : individual.getGenotype()) {
			if (choice instanceof ClassChoice) {
				ClassChoice ClassChoice = (ClassChoice)choice;
				if (ClassChoice.getDegreeOfFreedomInstance() instanceof AllocationDegree) {
					if (iterationCounter == allocationContext) {
						boolean foundMatchingServer = false;
						DegreeOfFreedomInstance dof = ClassChoice.getDegreeOfFreedomInstance();
						if (dof instanceof AllocationDegree){
							List<EObject> domain = ((AllocationDegree) dof).getClassDesignOptions();
							for (EObject entity : domain) {
								if (entity instanceof Entity && ((Entity)entity).getId().equals(container.getId())){
									ClassChoice.setChosenValue(container);
									foundMatchingServer = true;
									break;
								}
							}
						}
						if (!foundMatchingServer){
							throw new RuntimeException("Start Population Heuristic only supports design decision files that allow all components to be allocated to all servers. Sorry! Please disable the Starting population heuristic for this model.");
						}
						
					}
				}
				iterationCounter++;
			}
		}
	}

	/**
	 * Generates random int between from (inclusive) and to (inclusive) based on uniform distribution
	 * @param from
	 * @param to
	 * @return Random int with from <= return value <= to
	 */
	private static int getRandomInt(int from, int to) {
		Random random = new Random();
		return random.nextInt(to - from + 1) + from;
	}

}
