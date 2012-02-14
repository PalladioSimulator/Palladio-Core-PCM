/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.HashMap;
import java.util.Map;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.Value;
import org.opt4j.core.Objective.Sign;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.MinimalQualityCriteriaValueConfig;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

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
	
	//OutputNodes
	//dynamic
	private Node conformingCandidatesNode;

	public MinimalQualityCriteriaValueCriterion(IConfiguration conf, Population population,
			Archive archive) {
		super(conf, population, archive);
		if((conf instanceof MinimalQualityCriteriaValueConfig) && conf.validateConfiguration()){
			this.numberOfCandidatesToConform = ((MinimalQualityCriteriaValueConfig)(conf)).getNumberOfCandidatesToConform();
			this.configuredObjectives = ((MinimalQualityCriteriaValueConfig)(conf)).getObjectiveMinimalValues();
			
		}else{
			throw new RuntimeException("MinimalQualityCriteriaValueCriterion.initialize: " +
			"wrong or invalid configuration object");
		}
		
		this.initializeOutputTree();
	}
	
	private void initializeOutputTree(){
		this.outputInformation.updateValue("Minimal Quality Criteria Value");
		this.outputInformation.getChildren().clear();
		
		this.conformingCandidatesNode = this.outputInformation.addChild("Conforming Candidates: " + this.currentlyConformingCandidates + "/" + this.numberOfCandidatesToConform, NodeType.PARAMETER);
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Minimal Quality Criteria Value Criterion: This criterion ensures that a subset of x pareto optimal
	 * candidates have quality criteria values higher than the previously supplied ones, before suggesting termination.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime) {
		
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
	public void updateOutputInformation() {
		this.conformingCandidatesNode.updateValue("Conforming Candidates: " + this.currentlyConformingCandidates + "/" + this.numberOfCandidatesToConform);
	}

}
