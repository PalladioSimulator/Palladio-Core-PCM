package de.uka.ipd.sdq.capra.simulator;

import scheduler.SystemConfiguration;
import scheduler.configuration.ActiveResourceConfiguration;
import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import umontreal.iro.lecuyer.simprocs.SimProcess;
import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.experiment.Experiment;
import de.uka.ipd.sdq.capra.simulator.builder.CapraProcessManager;
import de.uka.ipd.sdq.capra.simulator.builder.ResourceManager;
import de.uka.ipd.sdq.capra.simulator.builder.SensorManager;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

/**
 * @author     jens.happe
 */
public class SimulationModel {
	private ResourceManager resourceManager;
	private CapraProcessManager processManager;
	private SensorManager sensorManager;
	private Simulator simulator;
	
	public SimulationModel(ISchedulingFactory schedulingFactory, Experiment exp){
		super();
		resourceManager = new ResourceManager(schedulingFactory);
		sensorManager = new SensorManager(resourceManager);
		processManager = new CapraProcessManager(resourceManager, sensorManager, exp ,schedulingFactory);
		simulator = SchedulingFactory.getUsedSimulator();
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
		simulator.init();
	}
	
	public void simulate(double timeHorizon){
		new EndOfSimEvent().schedule(timeHorizon);
		processManager.start();
		resourceManager.start();
		sensorManager.start();
		simulator.start();
	}
	
	public void storeData(CapraExperimentManager expManager){
		for (SimSensor s : sensorManager.getSensors()) {
			s.storeData(expManager);
		}
	}
	
	private class EndOfSimEvent extends Event {
		
		public EndOfSimEvent(){
			super(SchedulingFactory.getUsedSimulator());
		}
		
		@Override
		public void actions() {
			resourceManager.stop();
			sensorManager.finishMeasurements();
			
			simulator.stop();
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
		this.processManager.loadProcesses( capraModel.getProcesses());
		registerProcesses();
		sensorManager.initialiseProcesses();
	}

	private void registerProcesses() {
		for (ActiveResourceConfiguration resource_config : resourceManager.getActiveResourceConfigurations()) {
			IActiveResource resource = resourceManager.getResourceFor(resource_config);
			processManager.registerTo(resource, resource_config);
		}

	}

}
