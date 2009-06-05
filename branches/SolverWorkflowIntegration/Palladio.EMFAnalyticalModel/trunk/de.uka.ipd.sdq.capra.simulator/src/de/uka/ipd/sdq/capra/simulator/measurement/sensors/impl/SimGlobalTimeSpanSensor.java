package de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * @author  jens.happe
 */
public class SimGlobalTimeSpanSensor extends AbstractSensor implements SimTimeSpanSensor {
	
	private double startTime = -1;
	
	public SimGlobalTimeSpanSensor(String name) {
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
		if(startTime > 0)
			addTimeSpan(time - startTime, time);
	}
	
	@Override
	public void notifyStart(double time, ISchedulableProcess p){
		assert startTime < 0;
		startTime = time;
	}
	
	@Override
	public void notifyStop(double time, ISchedulableProcess p){
		assert (startTime >= 0) : "No start time set for sensor: " + name +" Process: " + p ;	
		addTimeSpan(time - startTime, time);
		startTime = -1;
	}

	@Override
	public void start() {
		
	}

}
