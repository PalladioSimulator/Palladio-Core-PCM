package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

public class BusSimulationExample implements IApplication {

	// run simulation for 10 simulated hour
	private static final Duration MAX_SIMULATION_TIME = Duration.hours(10);

	private BusSimConfig config;
	private BusModel model;
	private ISimulationControl simControl;

	public BusSimulationExample() {
		this.config = new BusSimConfig();
		this.model = BusModel.create(config);
		this.simControl = model.getSimulationControl();
		this.simControl.setMaxSimTime((long) MAX_SIMULATION_TIME.toSeconds().value());
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		// configure Logger
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);

		// run the simulation
		model.getSimulationControl().start();

		return EXIT_OK;
	}

	@Override
	public void stop() {
		// nothing to do
	}

}
