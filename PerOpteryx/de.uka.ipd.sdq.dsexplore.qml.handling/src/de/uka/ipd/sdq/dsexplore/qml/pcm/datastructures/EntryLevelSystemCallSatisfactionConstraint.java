package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures;

import org.opt4j.core.Objective;
import org.opt4j.core.SatisfactionConstraint;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

public class EntryLevelSystemCallSatisfactionConstraint extends
		SatisfactionConstraint implements EntryLevelSystemCallCriterion {

	private EntryLevelSystemCall entryLevelSystemCall;

	public EntryLevelSystemCallSatisfactionConstraint(String id,
			Direction direction, double limit, Objective objective,
			EntryLevelSystemCall entryLevelSystemCall) {
		super(id, direction, limit, objective);
		this.entryLevelSystemCall = entryLevelSystemCall;
	}

	@Override
	public EntryLevelSystemCall getEntryLevelSystemCall() {
		return this.entryLevelSystemCall;
	}

}
