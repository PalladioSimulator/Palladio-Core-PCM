package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import de.uka.ipd.sdq.simulation.abstractsimengine.ds.ISimulationControlComponent;

public class Activator implements BundleActivator {

    private static Activator plugin;

    private ServiceTracker<ISimulationControlComponent, ISimulationControlComponent> serviceTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        plugin = this;
        serviceTracker = new ServiceTracker<ISimulationControlComponent, ISimulationControlComponent>(context, ISimulationControlComponent.class, null);
        serviceTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        serviceTracker.close();
        serviceTracker = null;
    }

    /**
     * Gives static access to the bundle activator.
     * 
     * @return The shared activator instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Fetches an instance of the simulation control declarative service.
     * 
     * @return A simulation control service instance
     */
    public ISimulationControlComponent getSimulationControlService() {
        ISimulationControlComponent service = serviceTracker.getService();
        if (service == null) {
            throw new RuntimeException("Could not find a ISimulationControlComponent service");
        }

        return service;
    }

}
