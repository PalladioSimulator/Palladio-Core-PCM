package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder;

import org.opt4j.core.Objective;
import org.opt4j.core.SatisfactionConstraint;
import org.opt4j.core.Constraint.Direction;

import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EntryLevelSystemCallSatisfactionConstraint;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

public class EntryLevelSystemCallSatisfactionConstraintBuilder extends SatisfactionConstraintBuilder {

	private EntryLevelSystemCall entryLevelSystemCall;

	public EntryLevelSystemCallSatisfactionConstraintBuilder(
			EntryLevelSystemCall entryLevelSystemCall) {
		this.entryLevelSystemCall = entryLevelSystemCall;
	}

	@Override
	public SatisfactionConstraint createSatisfactionConstraint(String id,
			Direction direction, double limit, Objective objective) {
		return new EntryLevelSystemCallSatisfactionConstraint(id+"_"+this.entryLevelSystemCall.getId(), direction, limit, objective, this.entryLevelSystemCall);
	}

}
