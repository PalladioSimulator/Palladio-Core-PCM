package de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl;

import java.util.Hashtable;
import java.util.Map;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * @author  jens.happe
 */
public class SimLocalTimeSpanSensor extends AbstractSensor implements SimTimeSpanSensor {
	
	private Map<ISchedulableProcess, Double> processStorage = new Hashtable<ISchedulableProcess, Double>();
	
	public SimLocalTimeSpanSensor(String name) {
		super(name);
	}
	
	@Override
	public void addTimeSpan(double timeSpan, double time){
		for (SimRecorder recorder : recorderList) {
			((SimTimeSpanRecorder)recorder).addTimeSpan(timeSpan, time);
		}
	}

	@Override
	public void finishMeasurements() {
		double time = simulator.time();
		for (ISchedulableProcess p : processStorage.keySet()) {
			addTimeSpan(time - processStorage.get(p), time);
		}
	}
	
	@Override
	public void notifyStart(double time, ISchedulableProcess p){
		assert (processStorage.get(p) == null);
		processStorage.put(p, time);
	}
	
	@Override
	public void notifyStop(double time, ISchedulableProcess p){
		assert (processStorage.get(p) != null) : "No start time set for sensor: " + name +" Process: " + p + " Started Measurements: " + this.processStorage;	
		addTimeSpan(time - processStorage.get(p), time);
		processStorage.remove(p);
	}

	@Override
	public void start() {
		
	}

}
