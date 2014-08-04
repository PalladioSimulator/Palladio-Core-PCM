package de.uka.ipd.sdq.simulation.abstractsimengine.example.entities;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Duration;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Route;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Route.RouteSegment;

/**
 * This entity represents a bus which transports passengers between different bus stations.
 * 
 * @author J�rg Hen�, Philipp Merkle
 * 
 */
public class Bus extends AbstractSimEntityDelegator {

    private Route route;

    public enum BusState {
        LOADING_PASSENGERS, TRAVELLING, ARRIVED, UNLOADING_PASSENGERS;
    }

    private int totalSeats;

    private int occupiedSeats;

    private BusState state;

    private BusStop position;

    private BusStop destination;

    public static final Duration UNLOADING_TIME_PER_PASSENGER = Duration.seconds(4);

    public static final Duration LOADING_TIME_PER_PASSENGER = Duration.seconds(3);

    public Bus(int totalSeats, BusStop initialPosition, Route route, ISimulationModel model, String name) {
        super(model, name);
        this.totalSeats = totalSeats;
        this.route = route;

        // start in unloading state
        this.position = initialPosition;
        this.state = BusState.UNLOADING_PASSENGERS;
    }

    public BusStop arrive() {
        if (isTravelling()) {
            this.state = BusState.ARRIVED;
            this.position = this.destination;
            this.destination = null;
        } else {
            throw new IllegalStateException("Can not arrive without being in TRAVELLING state.");
        }

        return this.position;
    }

    public void load(int numberOfPassengers) {
        if (!isTravelling()) {
            this.occupiedSeats = numberOfPassengers;
            this.state = BusState.LOADING_PASSENGERS;
        } else {
            throw new IllegalStateException("Can not load passengers while TRAVELLING.");
        }
    }

    public void unload() {
        if (!isTravelling()) {
            this.state = BusState.UNLOADING_PASSENGERS;
        } else {
            throw new IllegalStateException("Unloading passengers while TRAVELLING seems not very wise.");
        }
    }

    public RouteSegment travel() {
        RouteSegment s = route.getRouteSegment(this.position);

        this.state = BusState.TRAVELLING;
        this.destination = route.getRouteSegment(this.position).getTo();
        this.position = null;

        return s;
    }

    public boolean isTravelling() {
        return state.equals(BusState.TRAVELLING);
    }

    public BusStop getPosition() {
        return this.position;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

}
