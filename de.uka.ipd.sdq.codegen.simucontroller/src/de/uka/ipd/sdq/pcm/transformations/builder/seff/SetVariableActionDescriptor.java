package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;

public class SetVariableActionDescriptor extends AbstractActionDescriptor {
	private Collection<VariableSetter> vus;
	
	public SetVariableActionDescriptor(Collection<VariableSetter> vus) {
		super();
		this.vus = vus;
	}

	public SetVariableActionDescriptor(VariableSetter vu) {
		vus = new ArrayList<VariableSetter>();
		vus.add(vu);
	}

	@Override
	public AbstractAction createAction() {
		SetVariableAction action = SeffFactory.eINSTANCE.createSetVariableAction();
		action.setEntityName("ResultSetter");
		action.getLocalVariableUsages_SetVariableAction().addAll(vus);
		return action;
	}
}
