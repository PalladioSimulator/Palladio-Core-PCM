package de.uka.ipd.sdq.pcmsolver.handler;

import de.uka.ipd.sdq.pcm.seff.reliability.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.reliability.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;

public class RecoveryBlockActionHandler {
	private SeffVisitor visitor;

	public RecoveryBlockActionHandler(SeffVisitor seffVisitor) {
		visitor = seffVisitor;
	}

	public void handle(RecoveryBlockAction recoveryBlock) {
		for (RecoveryBlockAlternativeBehaviour behaviour : recoveryBlock.getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction()) {
			// Direct invocation as a workaround for the missing
			// case for RecoveryBlockAlternativeBehaviours:
			visitor.caseResourceDemandingBehaviour(behaviour);
		}
	}
}
