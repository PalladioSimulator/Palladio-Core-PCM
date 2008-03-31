package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * @author  jens.happe
 */
public class SimGlobalTimeSpanSensor extends SimTimeSpanSensor {
	
	private double startTime = -1;
	
	public SimGlobalTimeSpanSensor(String name) {
		super(name);
	}
	
	@Override
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

}
