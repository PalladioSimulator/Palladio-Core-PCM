package de.uka.ipd.sdq.capra.simulator;

import scheduler.SystemConfiguration;
import scheduler.configuration.ActiveResourceConfiguration;
import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Sim;
import umontreal.iro.lecuyer.simprocs.SimProcess;
import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.simulator.builder.CapraProcessManager;
import de.uka.ipd.sdq.capra.simulator.builder.ResourceManager;
import de.uka.ipd.sdq.capra.simulator.builder.SensorManager;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

/**
 * @author     jens.happe
 */
public class SimulationModel {
	private ResourceManager resourceManager;
	private CapraProcessManager processManager;
	private SensorManager sensorManager;
	
	public SimulationModel(){
		super();
		resourceManager = new ResourceManager();
		sensorManager = new SensorManager();
		processManager = new CapraProcessManager(resourceManager, sensorManager);
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	public CapraProcessManager getProcessManager() {
		return processManager;
	}
	
	public SensorManager getSensorManager(){
		return sensorManager;
	}
	
	public void init(){
		SimProcess.init();
	}
	
	public void simulate(double timeHorizon){
		new EndOfSimEvent().schedule(timeHorizon);
		processManager.start();
		resourceManager.start();
		Sim.start();
	}
	
	public void storeData(ExperimentManager expManager){
		for (SimSensor s : sensorManager.getSensors()) {
			s.storeData(expManager);
		}
	}
	
	private class EndOfSimEvent extends Event {
		@Override
		public void actions() {
			sensorManager.finishMeasurements();
			Sim.stop();
		}
	}

	public String getDescription() {
		int number = getProcessManager().numberOfProcesses();
		return "#Threads=" + number;
	}

	public void loadSystemConfiguration(SystemConfiguration systemConfiguration) {
		this.resourceManager.loadActiveResourceConfigurations(systemConfiguration.getActiveResourceConfiguration());
		this.resourceManager.loadPassiveResourceConfigurations(systemConfiguration.getPassiveResourceConfiguration());
		this.processManager.loadProcessConfigurations(systemConfiguration.getProcessConfiguration());
	}

	public void loadCapraModel(CapraModel capraModel) {
		this.resourceManager.loadResources( capraModel.getResources() );
		this.sensorManager.loadSensors(capraModel.getSensors());
		this.processManager.loadProcesses( capraModel.getProcesses() );
		registerProcesses();
	}

	private void registerProcesses() {
		for (ActiveResourceConfiguration resource_config : resourceManager.getActiveResourceConfigurations()) {
			IActiveResource resource = resourceManager.getResourceFor(resource_config);
			processManager.registerTo(resource, resource_config);
		}

	}

}
