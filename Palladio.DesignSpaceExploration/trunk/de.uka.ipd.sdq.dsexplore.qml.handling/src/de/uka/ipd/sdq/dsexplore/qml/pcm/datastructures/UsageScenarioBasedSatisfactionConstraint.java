/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures;

import org.opt4j.core.Objective;
import org.opt4j.core.SatisfactionConstraint;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * Criterion tied to an UsageScenario.
 * 
 * @author noorshams
 *
 */
public class UsageScenarioBasedSatisfactionConstraint extends SatisfactionConstraint
		implements UsageScenarioBasedCriterion {

	private UsageScenario usageScenario;
	
	public UsageScenarioBasedSatisfactionConstraint(String name, Direction direction, double limit, Objective objective, UsageScenario usageScenario) {
		super(name, direction, limit, objective);
		this.usageScenario = usageScenario;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.UsageScenarioBasedCriterion#getUsageScenario()
	 */
	@Override
	public UsageScenario getUsageScenario() {
		return this.usageScenario;
	}
}
