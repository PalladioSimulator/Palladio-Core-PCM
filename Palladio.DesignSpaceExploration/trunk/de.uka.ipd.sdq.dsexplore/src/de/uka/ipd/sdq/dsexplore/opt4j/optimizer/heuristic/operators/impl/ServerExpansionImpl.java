package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl;

/**
 * Implements a server expansion heuristic. This heuristic finds a
 * highly utilised resource container, creates a new resource container and reallocates 
 * components to this new resource container
 * @author martens, Tom Beyer
 */
public class ServerExpansionImpl extends AbstractTactic {
	/**
	 * Maximum number of components reallocated from selected resource container
	 * to a new resource container
	 */
	private int maxNumberOfReplacements;
	/**
	 * If utilisation is larger than this double it will be considered
	 * a high utilisation
	 */
	private double thresholdHighUtilisation;
	
	private Random generator = new Random();
	
	
	private UtilisationResultCacheAndHelper resultInterpretationHelper = new UtilisationResultCacheAndHelper();
	
	/**
	 * @param copy Used to copy genotype
	 * @param individualBuilder Used to build individual
	 */
	public ServerExpansionImpl(Copy<Genotype> copy,
			DSEIndividualBuilder individualBuilder, DSEWorkflowConfiguration configuration) {
		super(copy, individualBuilder, configuration, new String[] {QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH});
		// set config
		setHeuristicWeight(configuration.getServerExpansionWeight());
		maxNumberOfReplacements = configuration.getServerExpansionMaxNumberOfReplacements();
		thresholdHighUtilisation = configuration.getServerExpansionThresholdHighUtilisation();
	}
	
	/**
	 * Check whether there is a resource container that has a 
	 * utilisation >= THRESHOLD_HIGH_UTILISATION and is not null
	 * @param individual
	 * @return
	 */
	private boolean doesMatchHighUtilisation(DSEIndividual individual) {
		ProcessingResourceSpecificationResult maxUtilisationResult = this.resultInterpretationHelper
			.getMaxProcUtilisationResult(individual);
		return maxUtilisationResult != null && 
			maxUtilisationResult.getResourceUtilisation() >= thresholdHighUtilisation;
	}
	
	/**
	 * Check whether there is a resource container that has a 
	 * utilisation >= THRESHOLD_HIGH_UTILISATION and there is a least one
	 * unused resource container (unused means no allocated components)
	 * @param individual
	 * @return
	 */
	public boolean doesMatchPrecondition(DSEIndividual individual) {
		return doesMatchHighUtilisation(individual) && !resultInterpretationHelper.getUnusedAvailableResourceContainers(individual).isEmpty();
	}
	
	/**
	 * Generates collection of candidates by applying the server consolidation heuristic
	 * @param individual Individual which the heuristic should be applied to
	 */
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual individual, UtilisationResultCacheAndHelper resultsHelper) {
		this.resultInterpretationHelper = resultsHelper;
		
		List<TacticsResultCandidate> candidates = new ArrayList<TacticsResultCandidate>();
		if (doesMatchPrecondition(individual)) {
			/*
			 * 1. Find max utilised resource
			 * 2. copy genotype
			 * 3. Get a new (unused) target resource container
			 * 4. Reallocate components to target resource container
			 */
			// 1. Find max utilised resource
			ProcessingResourceSpecificationResult maxUtilisationResult = this.resultInterpretationHelper.getMaxProcUtilisationResult(individual);
			// 2. copy genotype
			TacticsResultCandidate candidate = individualBuilder.buildCandidate(copy.copy(individual.getGenotype()), individual);
			ProcessingResourceSpecification maxProcessingResourceSpec = ((ProcessingResourceSpecificationResultImpl) maxUtilisationResult)
					.getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
			ResourceContainer resourceContainer = ((ResourceContainer) maxProcessingResourceSpec.eContainer());

			// 3. Get a new (unused) target resource container
			ResourceContainer targetResourceContainer = getRandomUnusedResourceContainer(individual);
			
			// 4. reallocate components
			// 4a Iterate through AllocationDegrees and find the choices for this container
			List<EnumerationChoice> componentsAllocatedHere = new LinkedList<EnumerationChoice>();
			for (Choice choice : candidate.getGenotype()) {
				if (choice instanceof EnumerationChoice) {
					EnumerationChoice enumerationChoice = (EnumerationChoice)choice;
					if (enumerationChoice.getDegreeOfFreedom() instanceof AllocationDegree) {
						if (enumerationChoice.getEntity() == resourceContainer) {
							componentsAllocatedHere.add(enumerationChoice);

						}
					}
				}
			}
			
			// 4b reallocate half of the found components, but not more than this.maxNumberOfReplacements
			int halfOfFoundComponents = componentsAllocatedHere.size() / 2;
			int reallocateAtMost = halfOfFoundComponents > maxNumberOfReplacements ? maxNumberOfReplacements : halfOfFoundComponents;
			for (int i = 0; i < reallocateAtMost; i++){ 
				EnumerationChoice enumerationChoice = componentsAllocatedHere.get(this.generator.nextInt(componentsAllocatedHere.size()));
				// Reallocate this component to target resource container
				enumerationChoice.setEntity(targetResourceContainer);
				componentsAllocatedHere.remove(enumerationChoice);
			}
			
			candidate.setCandidateWeight(getCandidateWeight(maxUtilisationResult));
			candidate.setHeuristic(this);
			candidates.add(candidate);
			increaseCounterOfGeneratedCandidates();
		}
		return candidates;
	}
	

	/**
	 * Calculates weight based on the following scheme: if utilisation equals THRESHOLD_HIGH_UTLISATION
	 * then it will return 0, if utilisation equals 1 it will return 1. Values in between are linearly 
	 * extrapolated. Return values will always be >= 0.
	 * @param utilisationResult
	 * @return Weight based on utilisationResult's utilisation
	 */
	private double getCandidateWeight(UtilisationResult utilisationResult) {
		return Math.min(1, Math.max(utilisationResult.getResourceUtilisation()/(1.0 - thresholdHighUtilisation) - thresholdHighUtilisation/(1.0 - thresholdHighUtilisation),
				0));
	}
	
	/**
	 * Get a random resource containers that has no allocated components
	 * @param individual
	 * @return
	 */
	private ResourceContainer getRandomUnusedResourceContainer(DSEIndividual individual) {
		Random random = new Random();
		Collection<ResourceContainer> resourceContainers = resultInterpretationHelper.getUnusedAvailableResourceContainers(individual);
		int randomInt = random.nextInt(resourceContainers.size());
		int n = 0;
		for (ResourceContainer container : resourceContainers ) {
			if (n == randomInt) {
				return container;
			}
			n++;
		}
		// wont be executed unless resourceContainers is empty
		return null;
	}
	


}
