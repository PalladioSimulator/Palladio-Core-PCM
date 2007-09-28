package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

/**
 * @author  jens.happe
 */
public class SimTimeSpanSensor implements SimSensor {
	
	private List<SimTimeSpanRecorder> recorderList = new ArrayList<SimTimeSpanRecorder>();
	private List<SimTimeSpanSensorInstance> instanceList = new ArrayList<SimTimeSpanSensorInstance>();
	
	/**
	 * @uml.property  name="name"
	 */
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
	
	@Override
	public void finishMeasurements() {
		for (SimSensorInstance instance : instanceList) {
			instance.finishMeasurements();
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

	@Override
	public SimSensorInstance createInstance() {
		SimTimeSpanSensorInstance instance =  new SimTimeSpanSensorInstance(this);
		instanceList.add(instance);
		return instance;
	}

}
