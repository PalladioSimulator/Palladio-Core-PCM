package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcessDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * This entity represents a bus which transports passengers between different bus stations.
 * 
 * @author Jörg Henß, Philipp Merkle
 * 
 */
public class Bus extends AbstractSimProcessDelegator {

    private int currentStation;

    public double averageSpeed;

    public static final int MAX_LOADING_TIME = 200;

    public static final int MAX_UNLOADING_TIME = 100;

    // distances between station 0 and 1, between station 1 and 2, and so on.
    public int[] distances = { 30, 20, 50 };

    public Bus(double averageSpeed, ISimulationModel model, String name) {
        super(model, name);
        this.averageSpeed = averageSpeed;
    }

    @Override
    public void lifeCycle() {
        // let the (empty) bus travel to the first station
        this.currentStation = 0;

        // transport passengers between the different stations
        while (getModel().getSimulationControl().isRunning()) {
            loadPassengers();
            travelToNextStation();
            unloadPassengers();
        }
    }

    private void loadPassengers() {
        log("Loading Passengers at station " + currentStation);
        double loadingTime = Math.random() * MAX_LOADING_TIME;

        // wait until all passengers have entered the bus
        passivate(loadingTime);

        log("Loading took " + loadingTime + " time units");
    }

    private void travelToNextStation() {
        log("Travelling to station " + getNextStation());

        int nextStation = getNextStation();
        double drivingTime = getDistanceToNextStation(currentStation) / averageSpeed;

        // wait for the bus to arrive at the next station
        passivate(drivingTime);

        // arrive at the target station
        this.currentStation = nextStation;
        log("Arrived at station " + this.currentStation + ". Travelling took " + drivingTime + " time units");
    }

    private void unloadPassengers() {
        log("Unloading Passengers at station " + currentStation);
        double unloadingTime = Math.random() * MAX_UNLOADING_TIME;

        // wait for the passengers to leave the bus
        passivate(unloadingTime);

        log("Unloading took " + unloadingTime + " time units");
    }

    private int getNextStation() {
        return (this.currentStation + 1) % getNumberOfStations();
    }

    private int getDistanceToNextStation(int currentStation) {
        return this.distances[currentStation];
    }

    private int getNumberOfStations() {
        return distances.length;
    }

    private void log(String msg) {
        StringBuilder s = new StringBuilder();
        s.append("[" + getName() + "] ");
        s.append("(t=" + getModel().getSimulationControl().getCurrentSimulationTime() + ") ");
        s.append(msg);
        System.out.println(s.toString());
    }

}
