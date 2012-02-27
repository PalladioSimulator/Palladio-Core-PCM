package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsListDegree;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * This class implements an IHeuristic which decreases the processing rate of
 * hardly utilized processing resources.
 * 
 * XXX increase or decrease processing rate by a randomized demand, e.g. 
 * normally distributed around the given parameter value?
 * 
 * @author martens, Tom Beyer
 */
public class DecreaseProcessingRateImpl extends AbstractProcessingRateTactic {
	
	/**
	 * Processing rate will be decreased by this factor if preconditions are
	 * fulfilled
	 */
	private double decreaseProcessingRateFactor;
	
	/**
	 * If utilisation is smaller than this double it will be considered a low
	 * utilisation
	 */
	private double thresholdLowUtilisation;
	
	public DecreaseProcessingRateImpl(Copy<Genotype> copy,
			DSEIndividualFactory individualFactory,
			DSEWorkflowConfiguration configuration) {
		super(copy, individualFactory, configuration, new String[] {QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_TOTAL_COST_DEFINITION_PATH});
		setHeuristicWeight(configuration.getProcessingRateWeight());
		
		decreaseProcessingRateFactor = configuration.getProcessingRateDecreaseFactor();
		thresholdLowUtilisation = configuration.getProcessingRateThresholdLowUtilisation();
	}

	public boolean doesMatchPrecondition(DSEIndividual i, UtilisationResultCacheAndHelper resultsCache) {
		Set<ResourceType> resourceTypes = resultsCache.getResourceTypes(i); 

		for (ResourceType resourceType : resourceTypes) {
			boolean matches = doesMatchLowUtilisation(i, resultsCache, resourceType);
			if (matches){
				return true;
			}
		}
		return false; 
	}

	/**
	 * Generates candidates based on given individual
	 * 
	 * @param Indivdual
	 *            used to apply heuristic
	 * @return Collection of generated candidates.
	 */
	@Override
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual individual, UtilisationResultCacheAndHelper resultCache) {
		List<TacticsResultCandidate> candidates = new ArrayList<TacticsResultCandidate>(); // return value
		/*
		 * 1. Get minimum utilisation 2. Copy current genotype 3. Find
		 * processing resource by iterating through genotype and change
		 * processing rate 4. Add candidate to result collection
		 */
		Set<ResourceType> resourceTypes = resultCache.getResourceTypes(individual); 

		for (ResourceType resourceType : resourceTypes) {
			
			if (resourceType.getEntityName().equals("DELAY")){
				continue;
			}

			if (doesMatchLowUtilisation(individual, resultCache, resourceType)) {
				addNewCandidateWithDecreasedProcessingRate(individual, candidates, resultCache, resourceType);
			}
		}
		return candidates;
	}
	
	/**
	 * Returns true if maximum utilisation is below or equals
	 * thresholdLowUtilisation and not null
	 * 
	 * @param individual
	 * @param resourceType 
	 * @return
	 */
	private boolean doesMatchLowUtilisation(DSEIndividual individual, UtilisationResultCacheAndHelper resultsCache, ResourceType resourceType) {
		UtilisationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual, resourceType);
		return minUtilisationResult != null
				&& minUtilisationResult.getResourceUtilisation() <= thresholdLowUtilisation;
	}
	
	/**
	 * @param continousRangeChoice
	 * @param processingRateDegree
	 * @return
	 */
	private double getDecreasedProcessingRate(ContinousRangeChoice continousRangeChoice,
			ContinuousProcessingRateDegree processingRateDegree) {
		return Math.max(continousRangeChoice.getChosenValue()
				* (1 - decreaseProcessingRateFactor), processingRateDegree.getFrom());
	}
	
	/**
	 * @param continousRangeChoice
	 * @param processingRateDegree
	 * @return
	 */
	@Override
	protected double getUpdatedProcessingRate(ContinousRangeChoice continousRangeChoice,
			ContinuousProcessingRateDegree processingRateDegree) {
		return getDecreasedProcessingRate(continousRangeChoice, processingRateDegree);
	}

	/**
	 * This first checks for the highest result, and then tries to find the 
	 * respective degree of freedom. However, if the resource with the highest utilisation is not changeable, 
	 * this method fails to provide a candidate.
	 * TODO: Find the highest utilisation among those resources that can be modified.  
	 * @param individual
	 * @param candidates
	 * @param resourceType 
	 */
	private void addNewCandidateWithDecreasedProcessingRate(DSEIndividual individual,
			Collection<TacticsResultCandidate> candidates,
			UtilisationResultCacheAndHelper resultsCache, ResourceType resourceType) {
		// 1. Get minimum utilisation
		ProcessingResourceSpecificationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual, resourceType);
		ProcessingResourceSpecification minUtilProcessingResource = minUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
		addNewProcRateCandidate(individual, candidates, minUtilisationResult,
				minUtilProcessingResource);
	}
	
	@Override
	public double getCandidateWeight(UtilisationResult utilisationResult){
		return getCandidateWeightForLowUtilisation(utilisationResult);
	}
	
	/**
	 * Calculates weight based on the following scheme: if utilisation higher than or equal to
	 * THRESHOLD_LOW_UTLISATION then it will return 0, if utilisation equals 0
	 * it will return 1. Values in between are linearly extrapolated. Return
	 * values will always be >= 0.
	 * 
	 * @param utilisationResult
	 * @return Weight based on utilisationResult's utilisation
	 */
	private double getCandidateWeightForLowUtilisation(UtilisationResult utilisationResult) {
		if (thresholdLowUtilisation <= 0){
			// makes no sense, but capture anyways
			return 0;
		}
		return Math.min(1, Math.max(thresholdLowUtilisation - utilisationResult.getResourceUtilisation() / thresholdLowUtilisation, 0.0));
	}
	
	

	@Override
	protected int getUpdatedNumberOfCores(DiscreteRangeChoice discreteChoice,
			NumberOfCoresDegree numberOfCoresDegree) {
		if (numberOfCoresDegree instanceof NumberOfCoresAsRangeDegree){
			NumberOfCoresAsRangeDegree asRangeDegree = (NumberOfCoresAsRangeDegree)numberOfCoresDegree;
			return Math.max(discreteChoice.getChosenValue() -1 ,
					asRangeDegree.isLowerBoundIncluded() ? asRangeDegree.getFrom() : asRangeDegree.getFrom() + 1);
		} else if (numberOfCoresDegree instanceof NumberOfCoresAsListDegree){
			NumberOfCoresAsListDegree asListDegree = (NumberOfCoresAsListDegree)numberOfCoresDegree;
			// find next smallest integer after the current one. Do not assume that the list is ordered, although it should be
			int nextSmallestInteger = Integer.MIN_VALUE;
			int currentValue = discreteChoice.getChosenValue();
			for (Integer value : asListDegree.getListOfIntegers()) {
				if (value < currentValue && value >= nextSmallestInteger){
					nextSmallestInteger = value;
				}
			}
			if (nextSmallestInteger != Integer.MIN_VALUE){
				return nextSmallestInteger;
			} else {
				// no smaller value available (assuming min-int is not in the set of values...) 
				return currentValue;
			}
		} else throw new RuntimeException("Unknown degree of freedom "+numberOfCoresDegree.getClass().getName()+", please adjust "+this.getClass().getName());
		
	}

}
