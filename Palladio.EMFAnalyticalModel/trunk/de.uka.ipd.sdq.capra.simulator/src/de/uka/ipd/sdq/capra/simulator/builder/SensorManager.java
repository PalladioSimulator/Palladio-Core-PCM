package de.uka.ipd.sdq.capra.simulator.builder;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.capra.measurement.Sensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimProcessSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;

public class SensorManager {
	
	private SensorFactory factory = new SensorFactory();
	private SensorTransformer transformer = null;
	private SensorVisitor visitor = null;
	private Map<String, SimSensor> sensor_map = new Hashtable<String, SimSensor>();
	
	

	public SensorManager(ResourceManager resourceManager) {
		super();
		transformer = new SensorTransformer(factory, resourceManager);
		visitor = new SensorVisitor(transformer,resourceManager);
		
	}

	public void loadSensors(EList<Sensor> sensors) {
		for (Sensor sensor : sensors) {
			SimSensor s =  visitor.visitSensor(sensor);
			addSensor(s);
		}
	}

	private void addSensor(SimSensor s) {
		sensor_map.put(s.getName(),s);
	}

	public SimTimeSpanSensor getTimeSpanSensor(Sensor s) {
		return (SimTimeSpanSensor)sensor_map.get(s.getName());
	}

	public Collection<SimSensor> getSensors() {
		return sensor_map.values();
	}

	public void finishMeasurements() {
		for (SimSensor sensor : this.sensor_map.values()) {
			sensor.finishMeasurements();
		}
		
	}

	public void initialiseProcesses() {
		for( SimSensor s : this.sensor_map.values()){
			if (s instanceof SimProcessSensor) {
				SimProcessSensor ps = (SimProcessSensor) s;
				ps.initialiseProcess();
			}
		}
	}

	public void start() {
		for( SimSensor s : this.sensor_map.values()){
			s.start();
		}
	}
}
