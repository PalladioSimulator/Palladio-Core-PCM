package de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder;

import org.opt4j.core.Objective;
import org.opt4j.core.Objective.Sign;

public class ObjectiveBuilder {

	public Objective createObjective(String name, Sign sign) {
		return new Objective(name, sign);
	}

}
