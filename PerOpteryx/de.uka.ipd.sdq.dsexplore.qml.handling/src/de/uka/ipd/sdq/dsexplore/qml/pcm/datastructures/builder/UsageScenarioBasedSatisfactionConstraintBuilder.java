package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder;

import org.opt4j.core.Objective;
import org.opt4j.core.Constraint.Direction;

import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedSatisfactionConstraint;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

public class UsageScenarioBasedSatisfactionConstraintBuilder extends SatisfactionConstraintBuilder{

	private UsageScenario usageScenario;

	public UsageScenarioBasedSatisfactionConstraintBuilder(
			UsageScenario usageScenario) {
		this.usageScenario = usageScenario;
	}
	
	public UsageScenarioBasedSatisfactionConstraint createSatisfactionConstraint(String id,
			Direction direction, double limit, Objective objective) {
		
		return new UsageScenarioBasedSatisfactionConstraint(id+"_"+this.usageScenario.getId(), direction, limit, objective, this.usageScenario);
	}

}
