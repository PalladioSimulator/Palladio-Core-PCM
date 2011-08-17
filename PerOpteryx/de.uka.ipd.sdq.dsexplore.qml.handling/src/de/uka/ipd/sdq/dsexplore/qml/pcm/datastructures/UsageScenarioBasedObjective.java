package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures;

import org.opt4j.core.Objective;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * Criterion tied to an UsageScenario.
 * 
 */
public class UsageScenarioBasedObjective extends Objective implements UsageScenarioBasedCriterion{

	private UsageScenario usageScenario;

	public UsageScenarioBasedObjective(String qualityAttribute, Sign sign, UsageScenario usageScenario) {
		
		super(qualityAttribute, sign);
		this.usageScenario = usageScenario;
	}
	
	@Override
	public UsageScenario getUsageScenario(){
		return this.usageScenario;
	}
	

}
