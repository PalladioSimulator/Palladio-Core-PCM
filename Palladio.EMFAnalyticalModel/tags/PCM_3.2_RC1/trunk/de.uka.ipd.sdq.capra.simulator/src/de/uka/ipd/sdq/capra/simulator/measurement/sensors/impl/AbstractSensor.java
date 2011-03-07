package de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl;

import java.util.ArrayList;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

public abstract class AbstractSensor implements SimSensor {

	protected Simulator simulator;
	protected String name;
	protected List<SimRecorder> recorderList = new ArrayList<SimRecorder>();

	public AbstractSensor() {
		super();
	}

	public AbstractSensor(String name) {
		this.name = name;
		this.simulator = SchedulingFactory.getUsedSimulator();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void storeData(CapraExperimentManager expManager) {
		for (SimRecorder recorder : recorderList) {
			recorder.storeData(expManager);
		}
	}
	
	@Override
	public void addRecorder(SimRecorder recorder) {
		recorderList.add(recorder);
	}
	

}