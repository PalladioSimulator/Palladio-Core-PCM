package de.uka.ipd.sdq.scheduler.sensors.impl;

import cern.colt.list.DoubleArrayList;
import de.uka.ipd.sdq.scheduler.sensors.IDataRecorder;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class TimeSpanRecorder implements IDataRecorder {
	private DoubleArrayList durationList = new DoubleArrayList();
	private DoubleArrayList timeList = new DoubleArrayList();
	private String name;
	
	public TimeSpanRecorder(String name) {
		this.name = name;
	}

	public void addTimeSpan(double timeSpan, double time) {
		durationList.add(timeSpan);
		timeList.add(time);
	}
	

	public void storeData(ExperimentManager expManager) {
		expManager.storeTimeSpans(name, durationList.elements(), timeList.elements(), durationList.size());		
	}
}
