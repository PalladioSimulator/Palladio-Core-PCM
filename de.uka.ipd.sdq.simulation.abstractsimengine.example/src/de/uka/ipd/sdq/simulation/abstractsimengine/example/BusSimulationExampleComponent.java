package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import org.osgi.service.component.ComponentContext;

import de.uka.ipd.sdq.simulation.abstractsimengine.ds.ISimulationControlComponent;

/**
 * The BusSimulationExampleComponent represents the declarative service consumer component.
 * 
 * @author Christoph Foehrdes
 */
public class BusSimulationExampleComponent {

    private ISimulationControlComponent simulationControlComponent;

    /**
     * Called when the service component is activated. Binds the component to the bundle.
     * 
     * @param context
     *            A component context instance
     */
    protected void activate(ComponentContext context) {
        Activator.getDefault().bindBusSimulationExampleComponent(this);
    }

    /**
     * Called when the service component is deactivated. Unbinds the component from the bundle.
     * 
     * @param context
     *            A component context instance
     */
    protected void deactivate(ComponentContext context) {
        Activator.getDefault().unbindBusSimulationExampleComponent(this);
    }

    /**
     * Called when the required simulation control component is available.
     * 
     * @param simulationControlComponent
     *            A simulation control component instance
     */
    public void bindSimulationControlComponent(ISimulationControlComponent simulationControlComponent) {
        this.simulationControlComponent = simulationControlComponent;
    }

    /**
     * Called when the required simulation control component is not longer available.
     * 
     * @param simulationControlComponent
     *            A simulation control component
     */
    public void unbindSimulationControlComponent(ISimulationControlComponent simulationControlComponent) {
        this.simulationControlComponent = null;
    }

    /**
     * Gives access to the simulation control component.
     * 
     * @return A simulation control component
     */
    public ISimulationControlComponent getSimulationControlComponent() {
        return simulationControlComponent;
    }

}
