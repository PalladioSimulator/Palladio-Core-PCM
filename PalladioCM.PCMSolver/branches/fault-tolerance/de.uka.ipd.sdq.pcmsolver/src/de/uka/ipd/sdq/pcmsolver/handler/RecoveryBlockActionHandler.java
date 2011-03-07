package de.uka.ipd.sdq.pcmsolver.handler;

import java.util.List;

import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;
import de.uka.ipd.sdq.pcm.seff.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;

public class RecoveryBlockActionHandler {
	private SeffVisitor visitor;

	public RecoveryBlockActionHandler(SeffVisitor seffVisitor) {
		visitor = seffVisitor;
	}

	public void handle(RecoveryBlockAction recoveryBlock) {
		List<ExternalCallInput> input=visitor.getContextWrapper().getCompUsgCtx().getExternalCallInput_ComputedUsageContext();
		for (RecoveryBlockAlternativeBehaviour behaviour : recoveryBlock.getRecoveryBlockalternativeBehaviours()) {
			visitor.doSwitch(behaviour);
		}
	}
}
