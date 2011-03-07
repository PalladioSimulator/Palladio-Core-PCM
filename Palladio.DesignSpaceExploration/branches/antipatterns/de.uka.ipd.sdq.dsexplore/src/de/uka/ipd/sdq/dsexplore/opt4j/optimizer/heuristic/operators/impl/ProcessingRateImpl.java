package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * This class implements an IHeuristic which increases the processing rate of
 * highly utilized processing resources and decreases the processing rate of
 * hardly utilized processing resources.
 * 
 * XXX increase or decrease processing rate by a randomized demand, e.g. 
 * normally distributed around the given parameter value?
 * 
 * @author martens, Tom Beyer
 */
public class ProcessingRateImpl extends AbstractTactic {
	/**
	 * Processing rate will be decreased by this factor if preconditions are
	 * fulfilled
	 */
	private double decreaseProcessingRateFactor;

	/**
	 * Processing rate will be increased by this factor if preconditions are
	 * fulfilled
	 */
	private double increaseProcessingRateFactor;

	/**
	 * If utilisation is larger than this double it will be considered a high
	 * utilisation
	 */
	private double thresholdHighUtilisation;
	/**
	 * If utilisation is smaller than this double it will be considered a low
	 * utilisation
	 */
	private double thresholdLowUtilisation;

	private UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper();
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.opt4j.optimizer.heuristic.operators.impl.ProcessingRateImpl");

	/**
	 * @param copy
	 *            Creates copy of genotypes
	 * @param individualBuilder
	 *            Builds individual
	 */
	public ProcessingRateImpl(Copy<Genotype> copy, DSEIndividualBuilder individualBuilder, DSEWorkflowConfiguration configuration) {
		super(copy, individualBuilder, configuration);
		// set config
		decreaseProcessingRateFactor = configuration.getProcessingRateDecreaseFactor();
		setHeuristicWeight(configuration.getProcessingRateWeight());
		increaseProcessingRateFactor = configuration.getProcessingRateIncreaseFactor();
		thresholdHighUtilisation = configuration.getProcessingRateThresholdHighUtilisation();
		thresholdLowUtilisation = configuration.getProcessingRateThresholdLowUtilisation();
	}

	/**
	 * Returns true if maximum utilisation is above or equals
	 * thresholdHighUtilisation and not null
	 * 
	 * @param individual
	 * @return
	 */
	private boolean doesMatchHighUtilisation(DSEIndividual individual) {
		UtilisationResult maxUtilisationResult = this.resultsCache.getMaxProcUtilisationResult(individual);
		return maxUtilisationResult != null
				&& maxUtilisationResult.getResourceUtilisation() >= thresholdHighUtilisation;
	}

	/**
	 * Returns true if maximum utilisation is below or equals
	 * thresholdLowUtilisation and not null
	 * 
	 * @param individual
	 * @return
	 */
	private boolean doesMatchLowUtilisation(DSEIndividual individual) {
		UtilisationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual);
		return minUtilisationResult != null
				&& minUtilisationResult.getResourceUtilisation() <= thresholdLowUtilisation;
	}

	/**
	 * Check whether individual matches precondition. Precondition: Does a
	 * resource exists which is either highly or hardly utilised
	 * 
	 * @param individual
	 *            Individual to check
	 */
	public boolean doesMatchPrecondition(DSEIndividual individual) {
		// Check whether there is one server with high or low utilization
		return doesMatchLowUtilisation(individual) || doesMatchHighUtilisation(individual);
	}

	/**
	 * Generates candidates based on given individual
	 * 
	 * @param Indivdual
	 *            used to apply heuristic
	 * @return Collection of generated candidates.
	 */
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual individual, UtilisationResultCacheAndHelper resultCache) {
		this.resultsCache = resultCache;
		
		List<TacticsResultCandidate> candidates = new ArrayList<TacticsResultCandidate>(); // return value
		/*
		 * 1. Get maximum utilisation 2. Copy current genotype 3. Find
		 * processing resource by iterating through genotype and change
		 * processing rate 4. Add candidate to result collection
		 */
		if (doesMatchHighUtilisation(individual)) {
			addNewCandidateWithIncreasedProcessingRate(individual, candidates);
		}
		/*
		 * 1. Get minimum utilisation 2. Copy current genotype 3. Find
		 * processing resource by iterating through genotype and change
		 * processing rate 4. Add candidate to result collection
		 */
		if (doesMatchLowUtilisation(individual)) {
			addNewCandidateWithDecreasedProcessingRate(individual, candidates);
		}
		return candidates;
	}

	/**
	 * @param individual
	 * @param candidates
	 */
	private void addNewCandidateWithIncreasedProcessingRate(DSEIndividual individual,
			Collection<TacticsResultCandidate> candidates) {
		// 1. Get maximum utilisation
		ProcessingResourceSpecificationResult maxUtilisationResult = this.resultsCache.getMaxProcUtilisationResult(individual);
		ProcessingResourceSpecification maxUtilProcessingResource = maxUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
		addNewProcRateCandidate(individual, candidates, maxUtilisationResult,
				maxUtilProcessingResource, false);
	}

	/**
	 * This first checks for the highest result, and then tries to find the 
	 * respective degree of freedom. However, if the resource with the highest utilisation is not changeable, 
	 * this method fails to provide a candidate.
	 * TODO: Find the highest utilisation among those resources that can be modified.  
	 * @param individual
	 * @param candidates
	 */
	private void addNewCandidateWithDecreasedProcessingRate(DSEIndividual individual,
			Collection<TacticsResultCandidate> candidates) {
		// 1. Get minimum utilisation
		ProcessingResourceSpecificationResult minUtilisationResult = resultsCache.getMinProcUtilisationResult(individual);
		ProcessingResourceSpecification minUtilProcessingResource = minUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
		addNewProcRateCandidate(individual, candidates, minUtilisationResult,
				minUtilProcessingResource, true);
	}

	private void addNewProcRateCandidate(DSEIndividual individual,
			Collection<TacticsResultCandidate> candidates,
			ProcessingResourceSpecificationResult utilisationResultToBeChanged,
			ProcessingResourceSpecification utilProcessingResourceToBeChanged,
			boolean isDecrease) {
		// 2. Copy current genotype
		TacticsResultCandidate candidate = individualBuilder.buildCandidate(copy.copy(individual.getGenotype()), individual);
		// 3. Iterate through choices and find processing rate degree to change
		boolean hasAppliedChange = false;
		for (Choice choice : candidate.getGenotype()) {
			if (choice instanceof ContinousRangeChoice) {
				ContinousRangeChoice continousRangeChoice = (ContinousRangeChoice) choice;
				DegreeOfFreedom degreeOfFreedom = choice.getDegreeOfFreedom();
				if (degreeOfFreedom instanceof ContinuousProcessingRateDegree) {
					ContinuousProcessingRateDegree processingRateDegree = (ContinuousProcessingRateDegree) degreeOfFreedom;
					if (processingRateDegree.getChangeableEntity() == utilProcessingResourceToBeChanged.getResourceContainer_ProcessingResourceSpecification()
							&& processingRateDegree.getProcessingresourcetype().getId().equals(utilProcessingResourceToBeChanged.getActiveResourceType_ActiveResourceSpecification().getId())) {
						// apply change (either increase or decrease. Respect
						// minimum allowed value of processing rate
						double newProcessingRate = getUpdatedProcessingRate(continousRangeChoice, processingRateDegree, isDecrease);
						continousRangeChoice.setChosenValue(newProcessingRate);
						hasAppliedChange = true;
					}
				}
			}
		}
		if (hasAppliedChange){
			candidate.setCandidateWeight(getCandidateWeight(utilisationResultToBeChanged, isDecrease));
			candidate.setHeuristic(this);
			candidates.add(candidate);
			increaseCounterOfGeneratedCandidates();
		} else {
			logger.warn("Tried to apply Processing Rate Decrease Tactic, but the resource with the lowest utilisation "+
					utilProcessingResourceToBeChanged.getActiveResourceType_ActiveResourceSpecification().getEntityName()+" of "+
					utilProcessingResourceToBeChanged.getResourceContainer_ProcessingResourceSpecification().getEntityName()+
					" is not in the degrees of freedom.");
		}
	}
	
	public double getCandidateWeight(UtilisationResult utilisationResult, boolean isDecrease){
		if (isDecrease){
			return getCandidateWeightForLowUtilisation(utilisationResult);
		} else {
			return getCandidateWeightForHighUtilisation(utilisationResult);
		}
	}
	
	/**
	 * @param continousRangeChoice
	 * @param processingRateDegree
	 * @return
	 */
	private double getUpdatedProcessingRate(ContinousRangeChoice continousRangeChoice,
			ContinuousProcessingRateDegree processingRateDegree, boolean isDecrease) {
		if (isDecrease){
			return getDecreasedProcessingRate(continousRangeChoice, processingRateDegree);
		} else {
			return getIncreasedProcessingRate(continousRangeChoice, processingRateDegree);
		}
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
	private double getIncreasedProcessingRate(ContinousRangeChoice continousRangeChoice,
			ContinuousProcessingRateDegree processingRateDegree) {
		return Math.min(continousRangeChoice.getChosenValue() * (1 + increaseProcessingRateFactor),
				processingRateDegree.getTo());
	}

	/**
	 * Calculates priority based on the following scheme: if utilisation equals
	 * THRESHOLD_HIGH_UTLISATION then it will return 0, if utilisation equals 1
	 * it will return 1. Values in between are linearly extrapolated. Return
	 * values will always be >= 0.
	 * 
	 * @param utilisationResult
	 * @return Priority based on utilisationResult's utilisation
	 */
	private double getCandidateWeightForHighUtilisation(UtilisationResult utilisationResult) {
		return Math.max(utilisationResult.getResourceUtilisation() / (1.0 - thresholdHighUtilisation)
				- thresholdHighUtilisation / (1.0 - thresholdHighUtilisation), 0);
	}

	/**
	 * Calculates weight based on the following scheme: if utilisation equals
	 * THRESHOLD_LOW_UTLISATION then it will return 0, if utilisation equals 0
	 * it will return 1. Values in between are linearly extrapolated. Return
	 * values will always be >= 0.
	 * 
	 * @param utilisationResult
	 * @return Weight based on utilisationResult's utilisation
	 */
	private double getCandidateWeightForLowUtilisation(UtilisationResult utilisationResult) {
		return Math.max(1.0 - utilisationResult.getResourceUtilisation() / thresholdHighUtilisation, 0);
	}

}
