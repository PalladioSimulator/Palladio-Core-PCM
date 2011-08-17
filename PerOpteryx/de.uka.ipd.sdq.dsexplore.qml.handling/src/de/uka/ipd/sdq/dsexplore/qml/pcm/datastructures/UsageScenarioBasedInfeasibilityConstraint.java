/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures;

import org.opt4j.core.InfeasibilityConstraint;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * Criterion tied to an UsageScenario.
 * 
 * @author noorshams
 *
 */
public class UsageScenarioBasedInfeasibilityConstraint extends InfeasibilityConstraint implements UsageScenarioBasedCriterion{
	private UsageScenario usageScenario;
	
	public UsageScenarioBasedInfeasibilityConstraint(String name, Direction direction, double limit, UsageScenario usageScenario) {
		super(name, direction, limit);
		this.usageScenario = usageScenario;
	}
	
	@Override
	public UsageScenario getUsageScenario(){
		return this.usageScenario;
	}
}
