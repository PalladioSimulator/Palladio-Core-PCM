package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.simulation.abstractsimengine.ds.ISimulationControlComponent;

public class Activator implements BundleActivator {

    private static Activator plugin;

    private BusSimulationExampleComponent component;

    @Override
    public void start(BundleContext context) throws Exception {
        plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // nothing to do
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
     * Binds the declarative service component to the bundle. This method is called when the
     * component is activated.
     * 
     * @param component
     *            A BusSimulationExampleComponent instance
     */
    public void bindBusSimulationExampleComponent(BusSimulationExampleComponent component) {
        this.component = component;
    }

    /**
     * Removes the declarative service component from the bundle when not longer available.
     * 
     * @param component
     *            A BusSimulationExampleComponent instance
     */
    public void unbindBusSimulationExampleComponent(BusSimulationExampleComponent component) {
        this.component = null;
    }

    /**
     * Provides access to the required simulation control service component.
     * 
     * @return A simulation control service instance
     */
    public ISimulationControlComponent getSimulationControlService() {
        ISimulationControlComponent service = this.component.getSimulationControlComponent();
        if (service == null) {
            throw new RuntimeException("Could not find a ISimulationControlComponent service");
        }

        return service;
    }

}
