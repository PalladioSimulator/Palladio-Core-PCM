package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

/**
 * @author  jens.happe
 */
public class SimTimeSpanSensor implements SimSensor {
	
	private List<SimTimeSpanRecorder> recorderList = new ArrayList<SimTimeSpanRecorder>();
	
	private Map<ISchedulableProcess, Double> processStorage = new Hashtable<ISchedulableProcess, Double>();
	
	Simulator simulator;
	
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	

	
	public SimTimeSpanSensor(String name) {
		super();
		this.name = name;
		this.simulator = SchedulingFactory.getUsedSimulator();
	}
	
	public void addTimeSpanRecorder(SimTimeSpanRecorder recorder){
		recorderList.add(recorder);
	}
	
	

	
	public void addTimeSpan(double timeSpan, double time){
		for (SimTimeSpanRecorder recorder : recorderList) {
			recorder.addTimeSpan(timeSpan, time);
		}
	}

	@Override
	public void storeData(CapraExperimentManager expManager) {
		for (SimTimeSpanRecorder recorder : recorderList) {
			recorder.storeData(expManager);
		}
	}
	
	@Override
	public void finishMeasurements() {
		double time = simulator.time();
		for (ISchedulableProcess p : processStorage.keySet()) {
			addTimeSpan(time - processStorage.get(p), time);
		}
	}
	
	public void notifyStart(double time, ISchedulableProcess p){
		assert (processStorage.get(p) == null);
		processStorage.put(p, time);
	}
	
	public void notifyStop(double time, ISchedulableProcess p){
		assert (processStorage.get(p) != null) : "No start time set for sensor: " + name +" Process: " + p + " Started Measurements: " + this.processStorage;
		addTimeSpan(time - processStorage.get(p), time);
		processStorage.remove(p);
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
