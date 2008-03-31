package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import java.util.ArrayList;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

public abstract class SimTimeSpanSensor implements SimSensor {

	protected List<SimTimeSpanRecorder> recorderList = new ArrayList<SimTimeSpanRecorder>();
	protected Simulator simulator;
	/**
	 * @uml.property  name="name"
	 */
	protected String name;
	
	

	public SimTimeSpanSensor(String name) {
		super();
		this.name = name;
		this.simulator = SchedulingFactory.getUsedSimulator();
	}
	
	
	public abstract void addTimeSpan(double timeSpan, double time);

	public abstract void notifyStart(double time, ISchedulableProcess p);
	
	public abstract void notifyStop(double time, ISchedulableProcess p);
	

	public SimTimeSpanSensor() {
		super();
	}

	public void addTimeSpanRecorder(SimTimeSpanRecorder recorder) {
		recorderList.add(recorder);
	}

	@Override
	public void storeData(CapraExperimentManager expManager) {
		for (SimTimeSpanRecorder recorder : recorderList) {
			recorder.storeData(expManager);
		}
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}
}