package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

public abstract class AbstractProcessingRateTactic extends AbstractTactic {

	/** Logger for log4j. */
	protected static Logger logger = Logger.getLogger("de.uka.ipd.sdq.opt4j.optimizer.heuristic.operators.impl.ProcessingRateImpl");

	public AbstractProcessingRateTactic(Copy<Genotype> copy,
			DSEIndividualFactory individualFactory,
			DSEWorkflowConfiguration configuration,
			String[] improvesDimensionPath) {
		super(copy, individualFactory, configuration, improvesDimensionPath);
	}

	protected void addNewProcRateCandidate(DSEIndividual individual, Collection<TacticsResultCandidate> candidates,
			ProcessingResourceSpecificationResult utilisationResultToBeChanged, ProcessingResourceSpecification utilProcessingResourceToBeChanged) {
		// 2. Copy current genotype
		TacticsResultCandidate candidate = individualFactory.buildCandidate(copy.copy(individual.getGenotype()), individual);
		// 3. Iterate through choices and find processing rate degree to change
		boolean hasAppliedChange = false;
		for (Choice choice : candidate.getGenotype()) {
			if (choice instanceof ContinousRangeChoice) {
				ContinousRangeChoice continousRangeChoice = (ContinousRangeChoice) choice;
				DegreeOfFreedomInstance DegreeOfFreedomInstance = choice.getDegreeOfFreedomInstance();
				if (DegreeOfFreedomInstance instanceof ContinuousProcessingRateDegree) {
					ContinuousProcessingRateDegree processingRateDegree = (ContinuousProcessingRateDegree) DegreeOfFreedomInstance;
					if (EMFHelper.checkIdentity(processingRateDegree.getPrimaryChanged(), utilProcessingResourceToBeChanged.getResourceContainer_ProcessingResourceSpecification())
							&& EMFHelper.checkIdentity(processingRateDegree.getProcessingresourcetype(), utilProcessingResourceToBeChanged.getActiveResourceType_ActiveResourceSpecification())) {
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
			finalizeAndAddCandidate(candidates, utilisationResultToBeChanged,
					candidate);
		} else {
			logger.warn("Tried to apply Processing Rate Increase / Decrease Tactic, but the resource with the highest / lowest utilisation "+
					utilProcessingResourceToBeChanged.getActiveResourceType_ActiveResourceSpecification().getEntityName()+" of "+
					utilProcessingResourceToBeChanged.getResourceContainer_ProcessingResourceSpecification().getEntityName()+
			" is not in the degrees of freedom.");
		}
	}

	private void finalizeAndAddCandidate(
			Collection<TacticsResultCandidate> candidates,
			ProcessingResourceSpecificationResult utilisationResultToBeChanged,
			TacticsResultCandidate candidate) {
		candidate.setCandidateWeight(getCandidateWeight(utilisationResultToBeChanged));
		candidate.setHeuristic(this);
		candidates.add(candidate);
		increaseCounterOfGeneratedCandidates();
	}
	
	protected void addNewNumberOfCoresCandidate(DSEIndividual individual,
			Collection<TacticsResultCandidate> candidates,
			ProcessingResourceSpecificationResult maxUtilisationResult,
			ProcessingResourceSpecification maxUtilProcessingResource) {
		// 2. Copy current genotype
		TacticsResultCandidate candidate = individualFactory.buildCandidate(copy.copy(individual.getGenotype()), individual);
		// 3. Iterate through choices and find number of cores degree to change
		for (Choice choice : candidate.getGenotype()) {
			if (choice instanceof DiscreteRangeChoice && choice.getDegreeOfFreedomInstance() instanceof NumberOfCoresDegree) {
				DiscreteRangeChoice discreteChoice = (DiscreteRangeChoice)choice;
				NumberOfCoresDegree numberOfCoresDegree = (NumberOfCoresDegree)choice.getDegreeOfFreedomInstance();
				
				// check if degree handles the resource to update
				if (EMFHelper.checkIdentity(numberOfCoresDegree.getProcessingresourcetype(),maxUtilProcessingResource.getActiveResourceType_ActiveResourceSpecification())
						&& EMFHelper.checkIdentity(numberOfCoresDegree.getPrimaryChanged(), maxUtilProcessingResource.getResourceContainer_ProcessingResourceSpecification())){
					int newNumberOfCores = getUpdatedNumberOfCores(discreteChoice, numberOfCoresDegree);
					// check whether number of cores can be increased
					if (newNumberOfCores != discreteChoice.getChosenValue()){
						finalizeAndAddCandidate(candidates, maxUtilisationResult,
								candidate);
						break;
					}
				}
				
			}
		}	
		
		
	}

	protected abstract double getCandidateWeight(
			UtilisationResult utilisationResultToBeChanged);

	protected abstract double getUpdatedProcessingRate(
			ContinousRangeChoice continousRangeChoice,
			ContinuousProcessingRateDegree processingRateDegree) ;
	
	protected abstract int getUpdatedNumberOfCores(
			DiscreteRangeChoice discreteChoice,
			NumberOfCoresDegree numberOfCoresDegree) ;
	

}