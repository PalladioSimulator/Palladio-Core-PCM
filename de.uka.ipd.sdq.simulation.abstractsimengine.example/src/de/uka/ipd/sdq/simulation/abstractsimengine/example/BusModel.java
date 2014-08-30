package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.Bus;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.BusStop;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.events.LoadPassengersEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.events.PassengerArrivalEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.processes.BusProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.processes.PassengerArrivalProcess;
import de.uka.ipd.sdq.simulation.preferences.SimulationPreferencesHelper;

public class BusModel extends AbstractSimulationModel {

    private boolean PROCESS_ORIENTED = true;

    private BusStop stop1;
    private BusStop stop2;
    private BusStop stop3;

    public BusModel(BusSimConfig config, ISimEngineFactory factory) {
        super(config, factory);
    }

    @Override
    public void init() {
        // define bus stops
        stop1 = new BusStop(this, "Stop1");
        stop2 = new BusStop(this, "Stop2");
        stop3 = new BusStop(this, "Stop3");

        // define route
        Route lineOne = new Route();
        lineOne.addSegment(stop1, stop2, 10, 35);
        lineOne.addSegment(stop2, stop3, 20, 50);
        lineOne.addSegment(stop3, stop1, 30, 50);

        // define buses
        Bus bus = new Bus(40, stop1, lineOne, this, "Bus 1");

        if (PROCESS_ORIENTED) {
            // schedule a process for each bus
            new BusProcess(bus).scheduleAt(0);

            // schedule a process for each bus stop
            new PassengerArrivalProcess(stop1, Duration.minutes(2)).scheduleAt(0);
            new PassengerArrivalProcess(stop2, Duration.minutes(4)).scheduleAt(0);
            new PassengerArrivalProcess(stop3, Duration.minutes(5)).scheduleAt(0);
        } else { // event-oriented
            // schedule intitial event for the bus
            new LoadPassengersEvent(this, "Load Passengers").schedule(bus, 0);

            // schedule events for the arrival at each bus stop
            new PassengerArrivalEvent(Duration.minutes(2), this, "Passenger Arrival 1").schedule(stop1, 0);
            new PassengerArrivalEvent(Duration.minutes(4), this, "Passenger Arrival 2").schedule(stop2, 0);
            new PassengerArrivalEvent(Duration.minutes(5), this, "Passenger Arrival 3").schedule(stop3, 0);
        }
    }

    @Override
    public void finalise() {
        System.out.println("-----------------------------");
        System.out.println("Waiting passengers at " + stop1.getName() + ":" + stop1.getWaitingPassengers());
        System.out.println("Waiting passengers at " + stop2.getName() + ":" + stop2.getWaitingPassengers());
        System.out.println("Waiting passengers at " + stop3.getName() + ":" + stop3.getWaitingPassengers());
        System.out.println("-----------------------------");
    }

    /**
     * Creates the simulation model for the specified configuration.
     * 
     * @param config
     *            the simulation configuration
     * @return the created simulation model
     */
    public static BusModel create(final BusSimConfig config) {
        // load factory for the preferred simulation engine
        ISimEngineFactory factory = SimulationPreferencesHelper.getPreferredSimulationEngine();
        if (factory == null) {
            throw new RuntimeException("There is no simulation engine available. Install at least one engine.");
        }

        // create and return simulation model
        final BusModel model = new BusModel(config, factory);

        return model;
    }

}
