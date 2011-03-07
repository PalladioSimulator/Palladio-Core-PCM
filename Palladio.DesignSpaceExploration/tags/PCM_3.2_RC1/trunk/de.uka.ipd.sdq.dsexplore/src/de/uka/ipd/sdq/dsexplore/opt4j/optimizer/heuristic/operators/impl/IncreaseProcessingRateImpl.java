package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * This class implements an IHeuristic which increases the processing rate of
 * highly utilized processing resources.
 * 
 * XXX increase or decrease processing rate by a randomized demand, e.g. 
 * normally distributed around the given parameter value?
 * 
 * @author martens, Tom Beyer
 */
public class IncreaseProcessingRateImpl extends AbstractProcessingRateTactic {


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
	 * @param copy
	 *            Creates copy of genotypes
	 * @param individualBuilder
	 *            Builds individual
	 */
	public IncreaseProcessingRateImpl(Copy<Genotype> copy, DSEIndividualBuilder individualBuilder, DSEWorkflowConfiguration configuration) {
		super(copy, individualBuilder, configuration, new String[] {QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH});
		// set config
		setHeuristicWeight(configuration.getProcessingRateWeight());
		increaseProcessingRateFactor = configuration.getProcessingRateIncreaseFactor();
		thresholdHighUtilisation = configuration.getProcessingRateThresholdHighUtilisation();
		
	}

	/**
	 * Returns true if maximum utilisation is above or equals
	 * thresholdHighUtilisation and not null
	 * 
	 * @param individual
	 * @return
	 */
	private boolean doesMatchHighUtilisation(DSEIndividual individual, UtilisationResultCacheAndHelper resultsCache) {
		UtilisationResult maxUtilisationResult = resultsCache.getMaxProcUtilisationResult(individual);
		return maxUtilisationResult != null
				&& maxUtilisationResult.getResourceUtilisation() >= thresholdHighUtilisation;
	}



	/**
	 * Check whether individual matches precondition. Precondition: Does a
	 * resource exists which is either highly or hardly utilised
	 * 
	 * @param individual
	 *            Individual to check
	 */
	public boolean doesMatchPrecondition(DSEIndividual individual, UtilisationResultCacheAndHelper resultsCache) {
		// Check whether there is one server with high or low utilization
		return doesMatchHighUtilisation(individual, resultsCache);
	}

	/**
	 * Generates candidates based on given individual
	 * 
	 * @param Indivdual
	 *            used to apply heuristic
	 * @return Collection of generated candidates.
	 */
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual individual, UtilisationResultCacheAndHelper resultCache) {
		List<TacticsResultCandidate> candidates = new ArrayList<TacticsResultCandidate>(); // return value
		/*
		 * 1. Get maximum utilisation 2. Copy current genotype 3. Find
		 * processing resource by iterating through genotype and change
		 * processing rate 4. Add candidate to result collection
		 */
		if (doesMatchHighUtilisation(individual, resultCache)) {
			addNewCandidateWithIncreasedProcessingRate(individual, candidates, resultCache);
		}
		return candidates;
	}

	/**
	 * @param individual
	 * @param candidates
	 */
	private void addNewCandidateWithIncreasedProcessingRate(DSEIndividual individual,
			Collection<TacticsResultCandidate> candidates,
			UtilisationResultCacheAndHelper resultsCache) {
		// 1. Get maximum utilisation
		ProcessingResourceSpecificationResult maxUtilisationResult = resultsCache.getMaxProcUtilisationResult(individual);
		ProcessingResourceSpecification maxUtilProcessingResource = maxUtilisationResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
		addNewProcRateCandidate(individual, candidates, maxUtilisationResult,
				maxUtilProcessingResource);
	}



	@Override
	public double getCandidateWeight(UtilisationResult utilisationResult){
		return getCandidateWeightForHighUtilisation(utilisationResult);
	}
	
	/**
	 * @param continousRangeChoice
	 * @param processingRateDegree
	 * @return
	 */
	@Override
	protected double getUpdatedProcessingRate(ContinousRangeChoice continousRangeChoice,
			ContinuousProcessingRateDegree processingRateDegree) {
		return getIncreasedProcessingRate(continousRangeChoice, processingRateDegree);
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
	 * Calculates priority based on the following scheme: if utilisation lower than or equal to
	 * THRESHOLD_HIGH_UTLISATION then it will return 0, if utilisation equals 1
	 * it will return 1. Values in between are linearly extrapolated. Return
	 * values will always be >= 0.
	 * 
	 * @param utilisationResult
	 * @return Priority based on utilisationResult's utilisation
	 */
	private double getCandidateWeightForHighUtilisation(UtilisationResult utilisationResult) {
		if (thresholdHighUtilisation >= 1)
			//this case makes no sense, but capture anyway.
			return 0;
		
		return Math.max((utilisationResult.getResourceUtilisation() - thresholdHighUtilisation) / (1.0 - thresholdHighUtilisation), 0);
	}


}
