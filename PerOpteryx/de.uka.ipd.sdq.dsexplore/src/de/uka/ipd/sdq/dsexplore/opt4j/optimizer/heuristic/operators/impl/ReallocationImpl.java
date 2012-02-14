package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
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
	 * @param individualFactory Used to build individual
	 */
	public ReallocationImpl(Copy<Genotype> copy, DSEIndividualFactory individualFactory, DSEWorkflowConfiguration configuration) {
		super(copy, individualFactory, configuration, new String[] {QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH,
				QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH});
		// set config
		setHeuristicWeight(configuration.getReallocationWeight());
		thresholdUtilisationDifference = configuration.getReallocationThresholdUtilisationDifference();
	}
	

	/**
	 * Check whether there is one server with high utilization
	 * and one with low utilization which are both not null
	 * @param individual Individual to check
	 * @param resourceType 
	 */
	public boolean doesMatchPrecondition(DSEIndividual individual, ResourceType resourceType) {
		UtilisationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual, resourceType);
		UtilisationResult maxUtilisationResult = resultsCache.getMaxProcUtilisationResult(individual, resourceType);
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
		
		// for all used resource types
		Set<ResourceType> resourceTypes = this.resultsCache.getResourceTypes(individual); 
		
		for (ResourceType resourceType : resourceTypes) {
			
		if (doesMatchPrecondition(individual, resourceType)){
			// create new candidate (find servers), set priority and add to list candidates
			UtilisationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual, resourceType);
			UtilisationResult maxUtilisationResult = resultCache.getMaxProcUtilisationResult(individual, resourceType);
			// create candidate
			TacticsResultCandidate candidate = individualFactory.buildCandidate(copy.copy(individual.getGenotype()), individual);
			ProcessingResourceSpecification minProcessingResourceSpec = ((ProcessingResourceSpecificationResultImpl)minUtilisationResult).getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
			ProcessingResourceSpecification maxProcessingResourceSpec = ((ProcessingResourceSpecificationResultImpl)maxUtilisationResult).getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
			ResourceContainer targetResourceContainer = ((ResourceContainer)minProcessingResourceSpec.eContainer());
			ResourceContainer sourceResourceContainer = ((ResourceContainer)maxProcessingResourceSpec.eContainer());
			if (EMFHelper.checkIdentity(targetResourceContainer, sourceResourceContainer)) {
				return candidates;
			}

			List<ClassChoice> potentiallyReallocatedComponents = new LinkedList<ClassChoice>();
			// iterate through choices and change AllocationDegree
			for (Choice choice : candidate.getGenotype()) {
				if (choice instanceof ClassChoice) {
					ClassChoice classChoice = (ClassChoice)choice;
					if (classChoice.getDegreeOfFreedomInstance() instanceof AllocationDegree) {
						AllocationDegree allocationDegree = (AllocationDegree)classChoice.getDegreeOfFreedomInstance();
						if (EMFHelper.checkIdentity(classChoice.getChosenValue(), sourceResourceContainer)) {
							// check whether this component may be allocated to the minimum one
							// XXX: Consider several servers with high or low utilization, as there is not necessarily a component that may be allocated from the highest to the lowest. Also consider second highest / lowest if none for the highest can be found. 
							for (EObject designOption : allocationDegree.getClassDesignOptions()) {
								if (EMFHelper.checkIdentity(targetResourceContainer, designOption)) {
									// this degree of freedom allows to allocate to the target container, 
									// so its component is a possible one to reallocate.  
									potentiallyReallocatedComponents.add(classChoice);
									break;
								}
							}
						}
					}
				}
			}
			
			// if the size is one or smaller, there are no components to reallocate.
			// we do not want to reallocate a single component (as that s server consolidation). 
			if (potentiallyReallocatedComponents.size() > 1){	
				//reallocate just one component, choose it randomly. TODO: choose it more wisely, e.g. based on its demand. 
				int chosenComponentIndex = generator.nextInt(potentiallyReallocatedComponents.size());
				ClassChoice componentToReallocate = potentiallyReallocatedComponents.get(chosenComponentIndex);
				componentToReallocate.setChosenValue(
						EMFHelper.retrieveEntityByID(
								((ClassDegree)componentToReallocate.getDegreeOfFreedomInstance()).getClassDesignOptions(), 
								targetResourceContainer));
	 			
				candidate.setCandidateWeight(getCandidateWeight(minUtilisationResult, maxUtilisationResult));
				candidate.setHeuristic(this);
				candidates.add(candidate);
				increaseCounterOfGeneratedCandidates();
			} 

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
		return Math.min(1, maxUtilisationResult.getResourceUtilisation() - minUtilisationResult.getResourceUtilisation());
	}

}
