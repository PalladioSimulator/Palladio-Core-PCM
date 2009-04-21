package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;

public abstract class AbstractActionDescriptor {

	public AbstractActionDescriptor() {
		super();
	}

	public abstract AbstractAction createAction();
}