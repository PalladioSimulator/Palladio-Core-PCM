package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

import cern.colt.list.DoubleArrayList;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;

public class SimFullTimeSpanRecorder implements SimTimeSpanRecorder {
	
	private DoubleArrayList durationList = new DoubleArrayList();
	private DoubleArrayList timeList = new DoubleArrayList();
	private String name;
	
	public SimFullTimeSpanRecorder(String name) {
		super();
		this.name = name;
	}

	@Override
	public void addTimeSpan(double timeSpan, double time) {
		durationList.add(timeSpan);
		timeList.add(time);
	}
	

	@Override
	public void storeData(CapraExperimentManager expManager) {
		expManager.storeTimeSpans(name, durationList.elements(), timeList.elements(), durationList.size());		
	}
	
	@Override
	public SimFullTimeSpanRecorder clone(){
		return new SimFullTimeSpanRecorder(name);
	}
}
