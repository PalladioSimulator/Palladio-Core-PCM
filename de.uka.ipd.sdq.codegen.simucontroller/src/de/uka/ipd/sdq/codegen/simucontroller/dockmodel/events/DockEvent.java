package de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

public abstract class DockEvent {
    protected DockModel myDock;

    public DockEvent(DockModel dock) {
        this.myDock = dock;
    }

    public boolean comesFrom(DockModel dock) {
        return myDock == dock;
    }

    public DockModel getDock() {
        return myDock;
    }
}
