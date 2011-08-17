package de.uka.ipd.sdq.dsexplore.analysis;

import org.opt4j.core.Objective;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

public class UsageScenarioBasedObjective extends Objective {

	private UsageScenario usageScenario;

	public UsageScenarioBasedObjective(String qualityAttribute, Sign sign, UsageScenario usageScenario) {
		super(qualityAttribute+":"+usageScenario.getEntityName(), sign);
		this.usageScenario = usageScenario;
	}
	
	public UsageScenario getUsageScenario(){
		return this.usageScenario;
	}
	

}
