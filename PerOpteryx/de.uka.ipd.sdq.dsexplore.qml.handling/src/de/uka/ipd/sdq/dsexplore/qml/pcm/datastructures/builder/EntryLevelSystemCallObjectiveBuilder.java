package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder;

import org.opt4j.core.Objective;
import org.opt4j.core.Objective.Sign;

import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EntryLevelSystemCallObjective;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

public class EntryLevelSystemCallObjectiveBuilder extends ObjectiveBuilder{

	private EntryLevelSystemCall entryLevelSystemCall;

	public EntryLevelSystemCallObjectiveBuilder(
			EntryLevelSystemCall entryLevelSystemCall) {
		this.entryLevelSystemCall = entryLevelSystemCall;
	}

	@Override
	public Objective createObjective(String name, Sign sign) {
		return new EntryLevelSystemCallObjective(name+"_"+this.entryLevelSystemCall.getId(), sign, this.entryLevelSystemCall);
	}

}
