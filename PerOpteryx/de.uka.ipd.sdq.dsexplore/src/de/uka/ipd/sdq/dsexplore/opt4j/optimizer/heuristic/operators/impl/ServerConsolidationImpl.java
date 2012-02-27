package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
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
	 * @param individualFactory Used to build individual
	 */
	public ServerConsolidationImpl(Copy<Genotype> copy,
			DSEIndividualFactory individualFactory, DSEWorkflowConfiguration configuration) {
		super(copy, individualFactory, configuration, 
				new String[] {
					QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_TOTAL_COST_DEFINITION_PATH,
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

		TacticsResultCandidate candidate = individualFactory.buildCandidate(copy.copy(individual.getGenotype()), individual);
		
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

			//Choose numberOfServersToSpreadTheLoadTo servers to put the components to. 
			//can choose a server twice if it has a much lower utilisation that the latter
			//tries sort of greedy bin packing. 
			for (ProcessingResourceSpecificationResult processingResourceSpecificationResult : procUtils) {
				ResourceContainer targetContainer = processingResourceSpecificationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getResourceContainer_ProcessingResourceSpecification();
				if (targetContainer != identifiedContainer
						&& EMFHelper.contains(resultCache.getAvailableResourceContainers(individual), targetContainer) // only deploy to allowed containers
						&& !EMFHelper.contains(resultCache.getUnusedAvailableResourceContainers(individual), targetContainer)// new container must be used already 
						&& EMFHelper.checkIdentity( // and the PR result must be about the same resource type. 
								processingResourceSpecificationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getActiveResourceType_ActiveResourceSpecification(),
								minUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getActiveResourceType_ActiveResourceSpecification())){
					
					double util = processingResourceSpecificationResult.getResourceUtilisation();
					int numberOfComponentsToDeployHere =  (int)( (this.maxUtilisationForOtherServers - util) / utilSharePerComponent);

					for (int i = 0; i < numberOfComponentsToDeployHere && componentAllocationToRChoices.size() > 0; i++) {
						ClassChoice reallocateChoice = componentAllocationToRChoices.get(generator.nextInt(componentAllocationToRChoices.size()));
						componentAllocationToRChoices.remove(reallocateChoice);
						EObject newContainer = EMFHelper.retrieveEntityByID(
								((ClassDegree)reallocateChoice.getDegreeOfFreedomInstance()).getClassDesignOptions(),
								targetContainer);
						if (newContainer != null){
							reallocateChoice.setChosenValue(newContainer);
						} else {
							// this component cannot be put to the chosen container...
							// TODO: then put this component to another server instead of just giving up...
							i--; // will terminate at some point because list componentAllocationToRChoices is also reduced. 
						}
						logger.debug("Reallocate component "+reallocateChoice.getDegreeOfFreedomInstance().getPrimaryChanged()+" to server "+targetContainer);
					}
					if (componentAllocationToRChoices.size() == 0 )
						break;
				}
			}
			if (componentAllocationToRChoices.size() == 0){
				//successfully redeployed all components
				candidates.add(candidate);
				candidate.setCandidateWeight(getCandidateWeight(minUtilisationResult));
				candidate.setHeuristic(this);
				increaseCounterOfGeneratedCandidates();
				//XXX: consider to create several possible reallocations?
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
			TacticsResultCandidate candidate = individualFactory.buildCandidate(copy.copy(individual.getGenotype()), individual);
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
		return candidates;
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
