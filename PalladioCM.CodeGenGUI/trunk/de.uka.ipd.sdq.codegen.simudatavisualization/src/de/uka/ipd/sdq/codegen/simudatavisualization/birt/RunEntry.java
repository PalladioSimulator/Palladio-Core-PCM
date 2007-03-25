package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

public class RunEntry {
	private List<Sensor> sensors;
	private ExperimentRun experimentRun;
	
	RunEntry(ExperimentRun experimentRun){
		this.experimentRun = experimentRun;
		this.sensors = new ArrayList<Sensor>();
	}
	
	public List<Sensor> getSensors() {
		return sensors;
	}
	
	public void addSensor(Sensor sensor) {
		sensors.add(sensor);
	}
	
	public void removeSensor(Sensor sensor){
		sensors.remove(sensor);
	}
	
	public ExperimentRun getExperimentRun() {
		return experimentRun;
	}
}
