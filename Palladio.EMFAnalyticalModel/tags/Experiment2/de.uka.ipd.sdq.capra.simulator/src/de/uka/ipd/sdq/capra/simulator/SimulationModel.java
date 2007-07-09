package de.uka.ipd.sdq.capra.simulator;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Sim;
import umontreal.iro.lecuyer.simprocs.SimProcess;
import de.uka.ipd.sdq.capra.simulator.builder.CapraProcessManager;
import de.uka.ipd.sdq.capra.simulator.builder.ResourceManager;
import de.uka.ipd.sdq.capra.simulator.builder.SensorManager;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class SimulationModel {
	private ResourceManager resources;
	private CapraProcessManager processes;
	private SensorManager sensors;
	
	public SimulationModel(){
		super();
		resources = new ResourceManager();
		sensors = new SensorManager();
		processes = new CapraProcessManager(sensors.getSensors());
	}

	public ResourceManager getResources() {
		return resources;
	}

	public CapraProcessManager getProcesses() {
		return processes;
	}
	
	public SensorManager getSensors(){
		return sensors;
	}
	
	public void init(){
		SimProcess.init();
		resources.init();
		processes.initialSchedule();
		sensors.init();
	}
	
	public void simulate(double timeHorizon){
		new EndOfSimEvent().schedule(timeHorizon);
		Sim.start();
	}
	
	public void storeData(ExperimentManager expManager){
		for (SimSensor s : sensors.getSensors()) {
			s.storeData(expManager);
		}
	}
	
	private class EndOfSimEvent extends Event {
		@Override
		public void actions() {
			Sim.stop();
		}
	};
}
