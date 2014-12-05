package de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

public class DockSimTimeChangedEvent extends DockEvent {

    private double newSimTime;

    public DockSimTimeChangedEvent(DockModel dock, double simTime) {
        super(dock);
        this.newSimTime = simTime;
    }

    public double getNewSimTime() {
        return newSimTime;
    }

}
