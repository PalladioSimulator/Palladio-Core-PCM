package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * Implements a server consolidation heuristic. This heuristic finds two
 * hardly utilised resource containers and reallocates all components of these
 * two resource containers to one resource container
 * @author martens, Tom Beyer
 */
public class ServerConsolidationImpl extends AbstractTactic {
	/**
	 * If utilisation is smaller than this double it will be considered
	 * a low utilisation
	 */
	private double thresholdLowUtilisation;	
	
	private double maxUtilisationForOtherServers = 0.9;
	
	private Random generator = new Random();

	private UtilisationResultCacheAndHelper resultCache = new UtilisationResultCacheAndHelper();
	
	protected static Logger logger = Logger.getLogger(ServerConsolidationImpl.class
			.getName());

	/**
	 * 
	 * @param copy Used to copy genotype
	 * @param individualBuilder Used to build individual
	 */
	public ServerConsolidationImpl(Copy<Genotype> copy,
			DSEIndividualBuilder individualBuilder, DSEWorkflowConfiguration configuration) {
		super(copy, individualBuilder, configuration, 
				new String[] {
					QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_COST_DEFINITION_PATH,
					QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_POFOD_DEFINITION_PATH});
		// set config
		setHeuristicWeight(configuration.getServerConsolidationWeight());
		thresholdLowUtilisation = configuration.getServerConsolidationThresholdLowUtilisation();
	}
	
	
	/**
	 * Checks the precondition by trying to generate candidates and see whether 
	 * the list is larger than 0.  
	 * @param individual
	 * @return
	 */
	public boolean doesMatchPrecondition(DSEIndividual individual) {
		return getHeuristicCandidates(individual, this.resultCache).size() > 0;
	}

	/**
	 * Generates collection of candidates by applying the server consolidation heuristic
	 * 
	 * Checks whether there is one resource container r with a 
	 * utilisation_r <= THRESHOLD_LOW_UTILISATION and whether 
	 * there are another n used resource containers x_1 to x_n with 
	 * enough free capacity (keeping the utilisation under 0.9) so that 
	 * the the load of r could be distributed: 
	 * Sum_{i=1}^{n} utilisation_x_i + utilisation_r < 0.9*n
	 * The number of free resource container n must not exceed the number of components
	 * deployed to r.
	 * 
	 * TODO: take resource demand of deployed components into account.
	 * TODO: take utilisation of other resources into account.
	 * TODO: The counting of deployed components does not take into account that some
	 * allocation degrees are inactive if subsystems are exchanged. Thus, only genomes where all 
	 * allocation options are active are supported. 
	 * 
	 * 
	 * @param individual Individual which the heuristic should be applied to
	 * @param resultsHelper 
	 */
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual individual, UtilisationResultCacheAndHelper resultsHelper) {
		this.resultCache = resultsHelper;
		
		List<TacticsResultCandidate> candidates = new ArrayList<TacticsResultCandidate>();
		
		Set<ResourceType> resourceTypes = this.resultCache.getResourceTypes(individual);
		
		for (ResourceType resourceType : resourceTypes) {
			candidates.addAll(getHeuristicCandidateForResourceType(individual, resourceType));
		}
		return candidates;
	}


	private List<TacticsResultCandidate> getHeuristicCandidateForResourceType(
			DSEIndividual individual, ResourceType cpu) {
		List<TacticsResultCandidate> candidates = new ArrayList<TacticsResultCandidate>();
		
		// FIXME: This should actually look for a server that is below the threshold for all its resources. 
		ProcessingResourceSpecificationResult minUtilisationResult = this.resultCache
			.getMinProcUtilisationResult(individual, cpu);
		
		if (minUtilisationResult == null 
				|| minUtilisationResult.getResourceUtilisation() > thresholdLowUtilisation
				|| cpu == null ){
			return candidates;
		}
		
		double utilisation = minUtilisationResult.getResourceUtilisation();
		ResourceContainer identifiedContainer = minUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification();		

		addMultiplicityDecreaseServerConsolidationCandidates(candidates, individual, identifiedContainer, minUtilisationResult);
		
		addClassicServerConsolidationCandidates(individual, candidates,
				minUtilisationResult, utilisation, identifiedContainer);
		
		return candidates;
	}


	private void addMultiplicityDecreaseServerConsolidationCandidates(List<TacticsResultCandidate> candidates, DSEIndividual individual, EObject resourceContainer, UtilisationResult minUtilisationResult) {
		TacticsResultCandidate candidate = individualBuilder.buildCandidate(copy.copy(individual.getGenotype()), individual);
		
		
		// check whether changing the multiplicity is allowed
		for (Choice choice : candidate.getGenotype()){
			if (choice instanceof DiscreteRangeChoice && choice.getDegreeOfFreedomInstance() instanceof ResourceContainerReplicationDegree){
				ResourceContainerReplicationDegree replDegree = (ResourceContainerReplicationDegree)choice.getDegreeOfFreedomInstance();
				if (EMFHelper.checkIdentity(replDegree.getPrimaryChanged(), resourceContainer)){
					// replChoice is the choice of the server multiplicity for this resourceContainer
					
					DiscreteRangeChoice discreteChoice = (DiscreteRangeChoice)choice; 
					// check whether more replicas are allowed
					if (discreteChoice.getChosenValue() > (replDegree.isLowerBoundIncluded() ? replDegree.getTo() : replDegree.getTo() + 1)){
						
						discreteChoice.setChosenValue(discreteChoice.getChosenValue() - 1);
						
						candidate.setCandidateWeight(getCandidateWeight(minUtilisationResult));
						candidate.setHeuristic(this);
						candidates.add(candidate);
						increaseCounterOfGeneratedCandidates();
						
					}
				}
			}
		}
		
	}


	private void addClassicServerConsolidationCandidates(DSEIndividual individual,
			List<TacticsResultCandidate> candidates,
			ProcessingResourceSpecificationResult minUtilisationResult,
			double utilisation, ResourceContainer identifiedContainer) {
		
		// if not all components of this server can be redeployed, then abort
		// TODO: take the second smallest utilized candidate in that case, if it fulfills the requirements
		if (!isAllComponentsCanBeReallocated(minUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification(), individual)){
			return;
		}
		
		TacticsResultCandidate candidate = individualBuilder.buildCandidate(copy.copy(individual.getGenotype()), individual);
		
		//Get components deployed to that resource container
		DesignDecisionGenotype genotype = candidate.getGenotype();
		List<ClassChoice> componentAllocationToRChoices = new ArrayList<ClassChoice>(genotype.size());
		for (Choice choice : genotype) {
			if (choice instanceof ClassChoice){
				ClassChoice enumChoice = (ClassChoice) choice;
				DegreeOfFreedomInstance degree = enumChoice.getDegreeOfFreedomInstance();
				if (degree instanceof AllocationDegree){
					if (EMFHelper.checkIdentity(enumChoice.getChosenValue(), identifiedContainer)){
						componentAllocationToRChoices.add(enumChoice);
						logger.debug("Found component allocated to underutilised container "+identifiedContainer.getEntityName());
					}
				}
			}
		}
		int numberOfComponentDeployedToR = componentAllocationToRChoices.size();
		
		// There should be at least one component to redeploy.
		if (numberOfComponentDeployedToR > 0){

			//Get n servers with lowest utilisation
			List<ProcessingResourceSpecificationResult> procUtils = UtilisationResultCacheAndHelper.getProcessingResourceUtilisationResults(individual);
			Collections.sort(procUtils, new UtilisationResultCacheAndHelper.UtilisationComparator());

			//assume that the load of the server to be removed is caused in equal shares by each deployed component
			//then, calculate each components utilisation share 
			//TODO: use real share here. 
			double utilSharePerComponent = utilisation / numberOfComponentDeployedToR;

			allocateComponentsToOtherServers(individual, minUtilisationResult,
					identifiedContainer, componentAllocationToRChoices,
					procUtils, utilSharePerComponent);
			
			if (componentAllocationToRChoices.size() == 0){
				finalizeCandidate(candidates, minUtilisationResult, candidate);
			} else {
				// try once again with only half the util share
				allocateComponentsToOtherServers(individual, minUtilisationResult,
						identifiedContainer, componentAllocationToRChoices,
						procUtils, utilSharePerComponent / 2);
				
				if (componentAllocationToRChoices.size() == 0){
					finalizeCandidate(candidates, minUtilisationResult,	candidate);
				}
				
			}
		}
		// else: some components could not be redeployed, return empty list. 

		/*	if (doesMatchPrecondition(individual)) {
			/*
		 * 1. Find lowest and 2nd lowest utilised resource containers
		 * 2. Copy individual
		 * 3. Reallocate all components from one resource container
		 *    to the other
		 *
			// 1. Find lowest and 2nd lowest utilised resource containers
			UtilisationResult minUtilisationResult = UtilisationHelper.getMinProcUtilisationResult(individual);
			UtilisationResult minUtilisationResult2 = UtilisationHelper.get2ndMinUtilisationResult(individual);
			// 2. Copy individual
			TacticsResultCandidate candidate = individualBuilder.buildCandidate(copy.copy(individual.getGenotype()), individual);
			ProcessingResourceSpecification minProcessingResourceSpec = ((ProcessingResourceSpecificationResultImpl) minUtilisationResult)
					.getProcessingresourcespecification();
			ProcessingResourceSpecification minProcessingResourceSpec2 = ((ProcessingResourceSpecificationResultImpl) minUtilisationResult2)
					.getProcessingresourcespecification();
			ResourceContainer resourceContainer = ((ResourceContainer) minProcessingResourceSpec.eContainer());
			ResourceContainer resourceContainer2 = ((ResourceContainer) minProcessingResourceSpec2.eContainer());
			// 3. Reallocate all components from one resource container to the other
			for (Choice choice : candidate.getGenotype()) {
				if (choice instanceof ClassChoice) {
					ClassChoice ClassChoice = (ClassChoice)choice;
					if (ClassChoice.getDegreeOfFreedomInstance() instanceof AllocationDegree) {
						if (EMFHelper.checkIdentity(ClassChoice.getEntity(),resourceContainer)) {
							// deploy all the components you can find to resourceContainer2
							ClassChoice.setEntity(resourceContainer2);
						}
					}
				}
			}
			candidate.setCandidateWeight(getCandidateWeight(minUtilisationResult, minUtilisationResult2));
			candidate.setHeuristic(this);
			candidates.add(candidate);
			increaseCounterOfGeneratedCandidates();
		} */
	}

	/**
	 * Check whether all components of the resourceContainer can be moved in the
	 * current design space, i.e. whether there is an {@link AllocationDegree} for 
	 * all of them. 
	 * This can be checked on any version of the PCM model (can be the initial candidate)
	 * as the components that cannot be moved have the same allocation in all candidates (obviously). 
	 * 
	 * @param resourceContainer
	 * @param individual
	 * @return
	 */
	private boolean isAllComponentsCanBeReallocated(
			ResourceContainer resourceContainer,
			DSEIndividual individual) {
		
		List<AllocationContext> allocationContexts = ((PCMPhenotype)individual.getPhenotype()).getPCMInstance().getAllocation().getAllocationContexts_Allocation();
		for (AllocationContext allocationContext : allocationContexts) {
			if (EMFHelper.checkIdentity(
					allocationContext.getResourceContainer_AllocationContext(),
					resourceContainer)){
				
				// check whether there is an AllocationDegree for this AllocationContext
				boolean dofExists = false;
				for (DegreeOfFreedomInstance dof : individual.getProblem().getDegreesOfFreedom()) {
					if (dof instanceof AllocationDegree 
							&& EMFHelper.checkIdentity(
									dof.getPrimaryChanged(),
									allocationContext)){
						dofExists = true;
						break;
					}
				}
				if (!dofExists){
					// found an AllocationContext that cannot be reallocated, so return false. 
					return false;
				}
			}
		}
		// All AllocationContexts can be reallocated, so return true. 
		return true;
	}


	private void finalizeCandidate(List<TacticsResultCandidate> candidates,
			ProcessingResourceSpecificationResult minUtilisationResult,
			TacticsResultCandidate candidate) {
		//successfully redeployed all components
		candidates.add(candidate);
		candidate.setCandidateWeight(getCandidateWeight(minUtilisationResult));
		candidate.setHeuristic(this);
		increaseCounterOfGeneratedCandidates();
		//XXX: consider to create several possible reallocations?
	}

	/**
	 * Iterates through all servers (represented by the procUtils list) and 
	 * try to spread the components to several servers based on the utilSharePerComponent. 
	 * Each component is assume to have a load of utilSharePerComponent. Then, for each servers
	 * the remaining capacity is determined as 
	 * (maxUtil - currentUtil) /  utilSharePerComponent = number of additional components that this server can host.
	 * As a result, the  method directly modifies the {@link ClassChoice}s contained in the 
	 * componentAllocationToRChoices and sets the new resource container as chosen value.
	 *  
	 * @param individual
	 * @param minUtilisationResult
	 * @param identifiedContainer Container to remove by allocating all its components someplace else
	 * @param componentAllocationToRChoices Components to reallocate
	 * @param procUtils Representation of the available servers
	 * @param utilSharePerComponent 
	 */
	private void allocateComponentsToOtherServers(DSEIndividual individual,
			ProcessingResourceSpecificationResult minUtilisationResult,
			ResourceContainer identifiedContainer,
			List<ClassChoice> componentAllocationToRChoices,
			List<ProcessingResourceSpecificationResult> procUtils,
			double utilSharePerComponent) {
		
		//Choose numberOfServersToSpreadTheLoadTo servers to put the components to. 
		//can choose a server twice if it has a much lower utilisation that the latter
		//tries sort of greedy bin packing. 
		for (ProcessingResourceSpecificationResult processingResourceSpecificationResult : procUtils) {
			ResourceContainer targetContainer = processingResourceSpecificationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification();
			
			if (targetContainer != identifiedContainer
					&& EMFHelper.contains(resultCache.getAvailableResourceContainers(individual), targetContainer) // only deploy to allowed containers
					&& !EMFHelper.contains(resultCache.getUnusedResourceContainers(individual), targetContainer)// new container must be used already 
					&& EMFHelper.checkIdentity( // and the PR result must be about the same resource type. 
							processingResourceSpecificationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getActiveResourceType_ActiveResourceSpecification(),
							minUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getActiveResourceType_ActiveResourceSpecification())){
				
				double util = processingResourceSpecificationResult.getResourceUtilisation();
				int numberOfComponentsToDeployHere =  (int) Math.ceil((this.maxUtilisationForOtherServers - util) / utilSharePerComponent);
				
				// copy the choice list to keep track of the components allocated to this resource container
				// then later at the end of the iteration remove the allocated components from the componentAllocationToRChoices list and move to the next resource container
				List<ClassChoice> componentsToPotentiallyAllocateHereChoices = new ArrayList<ClassChoice>(componentAllocationToRChoices.size());
				List<ClassChoice> componentsSucessfullyAssignedToHereChoices = new ArrayList<ClassChoice>(componentAllocationToRChoices.size());
				componentsToPotentiallyAllocateHereChoices.addAll(componentAllocationToRChoices);
				
				for (int i = 0; i < numberOfComponentsToDeployHere && componentsToPotentiallyAllocateHereChoices.size() > 0; i++) {
					ClassChoice reallocateChoice = componentsToPotentiallyAllocateHereChoices.get(generator.nextInt(componentsToPotentiallyAllocateHereChoices.size()));
					
					// do not try this one again
					componentsToPotentiallyAllocateHereChoices.remove(reallocateChoice);
					
					// check whether this choice allows to allocate to the targetContainer, the call returns null if not or the container if yes. 
					EObject newContainer = EMFHelper.retrieveEntityByID(
							((ClassDegree)reallocateChoice.getDegreeOfFreedomInstance()).getClassDesignOptions(),
							targetContainer);
					
					if (newContainer != null){
						reallocateChoice.setChosenValue(newContainer);
						componentsSucessfullyAssignedToHereChoices.add(reallocateChoice);
						
					} else {
						// this component cannot be put to the chosen container...
						// TODO: then put this component to another server instead of just giving up...
						i--; // will terminate at some point because list componentAllocationToRChoices is also reduced.
					}
					logger.debug("Reallocate component "+reallocateChoice.getDegreeOfFreedomInstance().getPrimaryChanged()+" to server "+targetContainer);
					
				}
				
				// remove the allocated components from the componentAllocationToRChoices list and move to the next resource container
				componentAllocationToRChoices.removeAll(componentsSucessfullyAssignedToHereChoices);
				
				if (componentAllocationToRChoices.size() == 0 )
					break;
			}
		}
	}
	
	/**
	 * Set weight to 1 at this point.
	 * @param u1 Lowest utilised resource container
	 * @return Weight of candidate
	 */
	private double getCandidateWeight(UtilisationResult u1) {
		 return ((thresholdLowUtilisation - u1.getResourceUtilisation())/thresholdLowUtilisation);
	}


	
}
