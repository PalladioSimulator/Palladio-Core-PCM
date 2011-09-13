package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder;

import org.opt4j.core.InfeasibilityConstraint;
import org.opt4j.core.Constraint.Direction;

public class InfeasibilityConstraintBuilder {

	public InfeasibilityConstraint createInfeasibilityConstraint(String name,
			Direction direction, double limit) {
		return new InfeasibilityConstraint(name, direction, limit);
	}
	
	

}
