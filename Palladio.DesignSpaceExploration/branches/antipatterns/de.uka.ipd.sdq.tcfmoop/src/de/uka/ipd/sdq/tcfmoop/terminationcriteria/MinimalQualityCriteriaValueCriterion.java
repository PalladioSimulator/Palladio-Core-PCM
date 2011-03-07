/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.HashMap;
import java.util.Map;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.Value;
import org.opt4j.core.Objective.Sign;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.MinimalQualityCriteriaValueConfig;

/**
 * @author Atanas Dimitrov
 *
 */
public class MinimalQualityCriteriaValueCriterion extends
		AbstractTerminationCriterion {
	
	//Already configured Objectives with their minimum required values.
	private Map<Objective, Value<?>> configuredObjectives = new HashMap<Objective, Value<?>>();
	//The required number of candidates to have quality criteria higher then the one supplied.
	private int numberOfCandidatesToConform;
	//The current number of candidates to have quality criteria higher then the one supplied.
	private int currentlyConformingCandidates;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(IConfiguration conf, Population population,
			Archive archive) {
		if((conf instanceof MinimalQualityCriteriaValueConfig) && conf.validateConfiguration()){
			this.numberOfCandidatesToConform = ((MinimalQualityCriteriaValueConfig)(conf)).getNumberOfCandidatesToConform();
			this.configuredObjectives = ((MinimalQualityCriteriaValueConfig)(conf)).getObjectiveMinimalValues();
			
		}else{
			throw new RuntimeException("MinimalQualityCriteriaValueCriterion.initialize: " +
			"wrong or invalid configuration object");
		}
		super.initialize(conf, population, archive);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Minimal Quality Criteria Value Criterion: This criterion ensures that a subset of x pareto optimal
	 * candidates have quality criteria values higher than the previously supplied ones, before suggesting termination.
	 */
	@Override
	public void evaluate(int iteration, long currentTime) {
		
		this.currentlyConformingCandidates = 0;
		
		for(Individual indi : this.archive){
			if(this.doesConformToMinimalValues(indi)){
				currentlyConformingCandidates++;
			}
		}
		
		if(this.currentlyConformingCandidates >= this.numberOfCandidatesToConform){
			this.evaluationResult = true;
		}else{
			this.evaluationResult = false;
		}
		
	}
	
	/**
	 * Checks whether a specific individual conforms to the minimum quality criteria values set before.
	 * @param indi the Individual to be checked.
	 * @return true - if the candidate conforms, else - false.
	 */
	private boolean doesConformToMinimalValues(Individual indi){
		Objectives currentCandidatesObjectives = indi.getObjectives();
		
		if(!currentCandidatesObjectives.getKeys().containsAll(this.configuredObjectives.keySet())){
			throw new RuntimeException("MinimalQualityCriteriaValueCriterion.doesConformToMinimalValues: Individual does not contain all configured Objectives");
		}
		
		for(Map.Entry<Objective, Value<?>> keyValuePair : this.configuredObjectives.entrySet()){
			if(keyValuePair.getKey().getSign() == Sign.MAX){
				if(!(currentCandidatesObjectives.get(keyValuePair.getKey()).getDouble() >= keyValuePair.getValue().getDouble())){
					return false;
				}
			}else if(keyValuePair.getKey().getSign() == Sign.MIN){
				if(!(currentCandidatesObjectives.get(keyValuePair.getKey()).getDouble() <= keyValuePair.getValue().getDouble())){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringBuilder getOutputInformation() {
		this.outputInformation = new StringBuilder();
		this.outputInformation.append("Criterion Name: Minimal Quality Criteria Value" + '\n');
		this.outputInformation.append("Conforming Candidates: " + this.currentlyConformingCandidates + "/" + this.numberOfCandidatesToConform + '\n');
		return super.getOutputInformation();
	}

}
