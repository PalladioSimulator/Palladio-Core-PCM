package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

public class BusSimulationExample implements IApplication {

    private static final int MAX_SIMULATION_TIME = 1000;
    
    private BusSimConfig config;
    private BusModel model;
    private ISimulationControl simControl;

    public BusSimulationExample() {
        this.config = new BusSimConfig();
        this.model = BusModel.create(config);
        this.simControl = model.getSimulationControl();
        this.simControl.setMaxSimTime(MAX_SIMULATION_TIME);
    }

    @Override
    public Object start(IApplicationContext context) throws Exception {
        prepareSimulation();
        
        // run the simulation
        model.getSimulationControl().start();
        
        return EXIT_OK;
    }

    @Override
    public void stop() {
        // nothing to do
    }
    
    private void prepareSimulation() {
        Bus transitBusYellowLine = new Bus(60, model, "Transit Bus (Yellow Line)");
        Bus transitBusBlueLine = new Bus(60, model, "Transit Bus (Blue Line)");
        Bus tourBus = new Bus(40, model, "Tour Bus");
        
        transitBusYellowLine.scheduleAt(0);
        transitBusBlueLine.scheduleAt(10);
        tourBus.scheduleAt(100);   
    }
    
}
