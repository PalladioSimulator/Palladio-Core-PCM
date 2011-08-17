package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

public abstract class AbstractProcessingRateTactic extends AbstractTactic {

	/** Logger for log4j. */
	protected static Logger logger = Logger.getLogger("de.uka.ipd.sdq.opt4j.optimizer.heuristic.operators.impl.ProcessingRateImpl");

	public AbstractProcessingRateTactic(Copy<Genotype> copy,
			DSEIndividualBuilder individualBuilder,
			DSEWorkflowConfiguration configuration,
			String[] improvesDimensionPath) {
		super(copy, individualBuilder, configuration, improvesDimensionPath);
	}

	protected void addNewProcRateCandidate(DSEIndividual individual, Collection<TacticsResultCandidate> candidates,
			ProcessingResourceSpecificationResult utilisationResultToBeChanged, ProcessingResourceSpecification utilProcessingResourceToBeChanged) {
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
								double newProcessingRate = getUpdatedProcessingRate(continousRangeChoice, processingRateDegree);
								continousRangeChoice.setChosenValue(newProcessingRate);
								hasAppliedChange = true;
							}
						}
					}
				}
				if (hasAppliedChange){
					candidate.setCandidateWeight(getCandidateWeight(utilisationResultToBeChanged));
					candidate.setHeuristic(this);
					candidates.add(candidate);
					increaseCounterOfGeneratedCandidates();
				} else {
					logger.warn("Tried to apply Processing Rate Increase / Decrease Tactic, but the resource with the highest / lowest utilisation "+
							utilProcessingResourceToBeChanged.getActiveResourceType_ActiveResourceSpecification().getEntityName()+" of "+
							utilProcessingResourceToBeChanged.getResourceContainer_ProcessingResourceSpecification().getEntityName()+
							" is not in the degrees of freedom.");
				}
			}

	protected abstract double getCandidateWeight(
			UtilisationResult utilisationResultToBeChanged);

	protected abstract double getUpdatedProcessingRate(
			ContinousRangeChoice continousRangeChoice,
			ContinuousProcessingRateDegree processingRateDegree) ;
	

}