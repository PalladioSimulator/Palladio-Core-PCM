package de.uka.ipd.sdq.simucomframework.simulationdock;

import java.util.ArrayList;

import de.uka.ipd.sdq.simulation.IStatusObserver;

public class DispatchingSimulationObserver implements IStatusObserver {

    private ArrayList<IStatusObserver> observers = new ArrayList<IStatusObserver>();

    public void addObserver(IStatusObserver client) {
        this.observers.add(client);
    }

    public void removeObserver(IStatusObserver client) {
        this.observers.remove(client);
    }

    public void removeAll() {
        this.observers.clear();
    }

    public void updateStatus(int percentDone, double currentSimTime, long measurementsTaken) {
        for (IStatusObserver observer : observers) {
            observer.updateStatus(percentDone, currentSimTime, measurementsTaken);
        }
    }

}
