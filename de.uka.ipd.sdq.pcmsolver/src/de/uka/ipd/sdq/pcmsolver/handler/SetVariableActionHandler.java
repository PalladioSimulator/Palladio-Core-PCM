package de.uka.ipd.sdq.pcmsolver.handler;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.VariableUsageHelper;

public class SetVariableActionHandler {

	private SeffVisitor visitor;

	public SetVariableActionHandler(SeffVisitor seffVisitor) {
		visitor = seffVisitor;
	}

	public void handle(SetVariableAction sva) {
		EList<VariableUsage> vuList = sva
				.getLocalVariableUsages_SetVariableAction();
		for (VariableUsage vu : vuList) {
			VariableUsageHelper.copySolvedVariableUsageToOutput(visitor
					.getContextWrapper(), vu);
		}
	}

}
