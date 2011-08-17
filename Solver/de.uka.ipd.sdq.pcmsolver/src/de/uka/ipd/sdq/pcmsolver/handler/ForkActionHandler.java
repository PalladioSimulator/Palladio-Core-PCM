package de.uka.ipd.sdq.pcmsolver.handler;

import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;

public class ForkActionHandler {
	private SeffVisitor visitor;

	public ForkActionHandler(SeffVisitor seffVisitor) {
		visitor = seffVisitor;
	}

	public void handle(ForkAction fork) {
		for (ForkedBehaviour behaviour : fork
				.getAsynchronousForkedBehaviours_ForkAction()) {
			visitor.doSwitch(behaviour);
		}
		SynchronisationPoint synch = fork
				.getSynchronisingBehaviours_ForkAction();
		if (synch != null) {
			for (ForkedBehaviour behaviour : synch
					.getSynchronousForkedBehaviours_SynchronisationPoint()) {
				visitor.doSwitch(behaviour);
			}
		}
	}
}
