package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures;

import org.opt4j.core.InfeasibilityConstraint;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

public class EntryLevelSystemCallInfeasibilityConstraint extends
		InfeasibilityConstraint implements EntryLevelSystemCallCriterion {

	private EntryLevelSystemCall entryLevelSystemCall;

	public EntryLevelSystemCallInfeasibilityConstraint(String name,
			Direction direction, double limit, EntryLevelSystemCall entryLevelSystemCall) {
		super(name, direction, limit);
		this.entryLevelSystemCall = entryLevelSystemCall;
	}

	@Override
	public EntryLevelSystemCall getEntryLevelSystemCall() {
		return this.entryLevelSystemCall;
	}

}
