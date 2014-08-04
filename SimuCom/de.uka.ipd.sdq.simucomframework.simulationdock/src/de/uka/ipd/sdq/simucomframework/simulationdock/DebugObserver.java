package de.uka.ipd.sdq.simucomframework.simulationdock;

import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import de.uka.ipd.sdq.simulation.IStatusObserver;

public class DebugObserver implements IStatusObserver {

    protected static Logger logger = Logger.getLogger(DebugObserver.class.getName());

    private boolean isStepping;
    private EventAdmin eventAdmin;
    private SimulationDockService myDock;

    private Object suspendedBarrier = new Object();
    private boolean suspended;

    public DebugObserver(EventAdmin eventAdmin, SimulationDockService myDock) {
        super();
        this.eventAdmin = eventAdmin;
        this.myDock = myDock;
        this.suspended = true;
    }

    public void suspend() {
        this.suspended = true;
        synchronized (this.suspendedBarrier) {
            this.suspendedBarrier.notifyAll();
        }
    }

    public void resume() {
        this.suspended = false;
        postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/SIM_RESUMED");

        if (this.isStepping) {
            isStepping = false;
            postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/PERFORMED_STEP");
        }

        synchronized (this.suspendedBarrier) {
            this.suspendedBarrier.notifyAll();
        }
    }

    public void step() {
        if (suspended && !isStepping) {
            this.isStepping = true;
            postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/STARTED_STEP");
            synchronized (this.suspendedBarrier) {
                this.suspendedBarrier.notifyAll();
            }
        }
    }

    public void updateStatus(int percentDone, double currentSimTime, long measurementsTaken) {

        if (this.isStepping) {
            isStepping = false;
            postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/PERFORMED_STEP");
        }

        synchronized (this.suspendedBarrier) {
            while (this.suspended && !isStepping) {
                try {
                    postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/SIM_SUSPENDED");
                    this.suspendedBarrier.wait();
                } catch (InterruptedException e) {
                }
            }
        }

        if (this.suspended) {
            postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/SIM_RESUMED");
            if (logger.isDebugEnabled())
                logger.debug("------------------------- Simulation Resumed ----------------------------------");
        }
    }

    private void postEvent(String topic) {
        postEvent(topic, new Hashtable<String, Object>());
    }

    private void postEvent(String topic, Hashtable<String, Object> newProperties) {
        Hashtable<String, Object> properties = new Hashtable<String, Object>();
        properties.put("DOCK_ID", myDock.getDockId());
        properties.putAll(newProperties);
        Event event = new Event(topic, (Map) properties);
        eventAdmin.sendEvent(event);
    }

}
