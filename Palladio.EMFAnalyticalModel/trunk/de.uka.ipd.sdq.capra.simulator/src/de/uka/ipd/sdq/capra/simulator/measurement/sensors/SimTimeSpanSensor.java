package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class SimTimeSpanSensor implements SimSensor {
	
	private List<SimTimeSpanRecorder> recorderList = new ArrayList<SimTimeSpanRecorder>();
	
	private String name;
	

	
	public SimTimeSpanSensor(String name) {
		super();
		this.name = name;
	}
	
	public void addTimeSpanRecorder(SimTimeSpanRecorder recorder){
		recorderList.add(recorder);
	}
	

	
	public void addTimeSpan(double timeSpan){
		for (SimTimeSpanRecorder recorder : recorderList) {
			recorder.addTimeSpan(timeSpan);
		}
	}

	@Override
	public void storeData(ExperimentManager expManager) {
		for (SimTimeSpanRecorder recorder : recorderList) {
			recorder.storeData(expManager);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public SimSensorInstance createInstance() {
		return new SimTimeSpanSensorInstance(this);
	}
}
