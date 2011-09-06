package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder;

import org.opt4j.core.InfeasibilityConstraint;
import org.opt4j.core.Constraint.Direction;

import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EntryLevelSystemCallInfeasibilityConstraint;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

public class EntryLevelSystemCallInfeasibilityConstraintBuilder extends InfeasibilityConstraintBuilder {

	private EntryLevelSystemCall entryLevelSystemCall;

	public EntryLevelSystemCallInfeasibilityConstraintBuilder(
			EntryLevelSystemCall entryLevelSystemCall) {
		this.entryLevelSystemCall = entryLevelSystemCall;
	}

	@Override
	public InfeasibilityConstraint createInfeasibilityConstraint(String name,
			Direction direction, double limit) {
		return new EntryLevelSystemCallInfeasibilityConstraint(name+"_"+this.entryLevelSystemCall.getId(), direction, limit, this.entryLevelSystemCall);
	}

}
