package de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

public class DockDeletedEvent extends DockEvent {

	public DockDeletedEvent(DockModel dock) {
		super(dock);
	}

}
