package de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

public class DockAddedEvent extends DockEvent {

    public DockAddedEvent(DockModel dock) {
        super(dock);
    }
}
