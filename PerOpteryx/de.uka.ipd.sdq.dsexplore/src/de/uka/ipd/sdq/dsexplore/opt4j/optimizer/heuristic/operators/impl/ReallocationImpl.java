package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
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
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl;

/**
 * Implements a reallocation heuristic which allocates a component from
 * a highly utilised resource container to a lowly utilised container
 * 
 * TODO: Only works for a single resource type so far. 
 * 
 * @author martens, Tom Beyer
 *
 */
public class ReallocationImpl extends AbstractTactic {

	/**
	 * If utilisation is larger than this double it will be considered
	 * a high utilisation
	 */
	private double thresholdUtilisationDifference;

	
	private Random generator = new Random();

	private UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper();
	
	/**
	 * 
	 * @param copy Used to copy genotype
	 * @param individualBuilder Used to build individual
	 */
	public ReallocationImpl(Copy<Genotype> copy, DSEIndividualBuilder individualBuilder, DSEWorkflowConfiguration configuration) {
		super(copy, individualBuilder, configuration, new String[] {QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH});
		// set config
		setHeuristicWeight(configuration.getReallocationWeight());
		thresholdUtilisationDifference = configuration.getReallocationThresholdUtilisationDifference();
	}
	

	/**
	 * Check whether there is one server with high utilization
	 * and one with low utilization which are both not null
	 * @param individual Individual to check
	 */
	public boolean doesMatchPrecondition(DSEIndividual individual) {
		UtilisationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual);
		UtilisationResult maxUtilisationResult = resultsCache.getMaxProcUtilisationResult(individual);
		return minUtilisationResult != null && maxUtilisationResult != null && 
				maxUtilisationResult.getResourceUtilisation() - minUtilisationResult.getResourceUtilisation() 
				>= thresholdUtilisationDifference ;
	}

	/**
	 * Generates collection of candidates by applying the reallocation heuristic
	 * @param individual Individual which the heuristic should be applied to
	 */
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual individual, UtilisationResultCacheAndHelper resultCache) {
		this.resultsCache = resultCache;
		
		// return value
		List<TacticsResultCandidate> candidates = new ArrayList<TacticsResultCandidate>();
		if (doesMatchPrecondition(individual)){
			// create new candidate (find servers), set priority and add to list candidates
			UtilisationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual);
			UtilisationResult maxUtilisationResult = resultCache.getMaxProcUtilisationResult(individual);
			// create candidate
			TacticsResultCandidate candidate = individualBuilder.buildCandidate(copy.copy(individual.getGenotype()), individual);
			ProcessingResourceSpecification minProcessingResourceSpec = ((ProcessingResourceSpecificationResultImpl)minUtilisationResult).getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
			ProcessingResourceSpecification maxProcessingResourceSpec = ((ProcessingResourceSpecificationResultImpl)maxUtilisationResult).getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
			ResourceContainer targetResourceContainer = ((ResourceContainer)minProcessingResourceSpec.eContainer());
			ResourceContainer sourceResourceContainer = ((ResourceContainer)maxProcessingResourceSpec.eContainer());
			if (targetResourceContainer == sourceResourceContainer) {
				return candidates;
			}

			List<EnumerationChoice> potentiallyReallocatedComponents = new LinkedList<EnumerationChoice>();
			// iterate through choices and change AllocationDegree
			for (Choice choice : candidate.getGenotype()) {
				if (choice instanceof EnumerationChoice) {
					EnumerationChoice enumerationChoice = (EnumerationChoice)choice;
					if (enumerationChoice.getDegreeOfFreedom() instanceof AllocationDegree) {
						if (enumerationChoice.getEntity() == sourceResourceContainer) {
							potentiallyReallocatedComponents.add(enumerationChoice);
						}
					}
				}
			}
			
			// if the size is one or smaller, there are no components to reallocate.
			// we do not want to reallocate a single component (as that s server consolidation). 
			if (potentiallyReallocatedComponents.size() > 1){	
				//reallocate just one component, choose it randomly. TODO: choose it more wisely, e.g. based on its demand. 
				int chosenComponentIndex = generator.nextInt(potentiallyReallocatedComponents.size());
				EnumerationChoice componentToReallocate = potentiallyReallocatedComponents.get(chosenComponentIndex);
				componentToReallocate.setEntity(targetResourceContainer);
	 			
				candidate.setCandidateWeight(getCandidateWeight(minUtilisationResult, maxUtilisationResult));
				candidate.setHeuristic(this);
				candidates.add(candidate);
				increaseCounterOfGeneratedCandidates();
			} 

		}
		return candidates;
	}
	
	/**
	 * Calculates weight of the candidate using maxUtil-minUtil
	 * @param minUtilisationResult UtilisationResult with minimum utilisation
	 * @param maxUtilisationResult UtilisationResult with maximum utilisation
	 * @return Weight of candidate
	 */
	private double getCandidateWeight(UtilisationResult minUtilisationResult,
			UtilisationResult maxUtilisationResult) {
		return maxUtilisationResult.getResourceUtilisation() - minUtilisationResult.getResourceUtilisation();
	}

}
