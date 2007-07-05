package de.uka.ipd.sdq.capra.simulator.measurement.probes;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.expressions.SimAction;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensorInstance;


public class SimTimeProbe implements SimAction {
	
	List<SimTimeSpanSensor> sensorsToStart = new ArrayList<SimTimeSpanSensor>();
	List<SimTimeSpanSensor> sensorsToStop = new ArrayList<SimTimeSpanSensor>();
	
	List<SimTimeSpanSensorInstance> sensorInstancesToStart = new ArrayList<SimTimeSpanSensorInstance>();
	List<SimTimeSpanSensorInstance> sensorInstancesToStop = new ArrayList<SimTimeSpanSensorInstance>();
	
	
	@Override
	public void execute(SimCapraProcess capraProcess) {
		double time = Sim.time();
		for (SimTimeSpanSensorInstance sensorInstance : sensorInstancesToStart) {
			sensorInstance.notifyStart(time);
		}
		for (SimTimeSpanSensorInstance sensorInstance : sensorInstancesToStop) {
			sensorInstance.notifyStop(time);
		}
		capraProcess.proceed();
	}
	
	public void addSensorToStart(SimTimeSpanSensor sensor){
		sensorsToStart.add(sensor);
	}
	
	public void addSensorToStop(SimTimeSpanSensor sensor){
		sensorsToStop.add(sensor);
	}	
	
	public SimTimeProbe clone(){
		SimTimeProbe probe = new SimTimeProbe();
		probe.sensorsToStart = this.sensorsToStart;
		probe.sensorsToStop = this.sensorsToStop;
		return probe;
	}

	@Override
	public void useSensorInstances(Hashtable<String,SimSensorInstance> sensorInstanceTable) {
		sensorInstancesToStart = selectSensorInstances(sensorInstanceTable, sensorsToStart);
		sensorInstancesToStop = selectSensorInstances(sensorInstanceTable, sensorsToStop);
	}

	private List<SimTimeSpanSensorInstance> selectSensorInstances(
			Hashtable<String, SimSensorInstance> sensorInstanceTable,
			List<SimTimeSpanSensor> sensorList) {
		List<SimTimeSpanSensorInstance> newSensorInstanceList = new ArrayList<SimTimeSpanSensorInstance>();
		for (SimSensor sensor : sensorList) {
			newSensorInstanceList.add( (SimTimeSpanSensorInstance) sensorInstanceTable.get(sensor.getName()));
		}
		return newSensorInstanceList;
	}

	@Override
	public void reset() {
	}

	@Override
	public SimCapraExpression getNext() {
		return null;
	}

	@Override
	public boolean isAction() {
		return true;
	}

}
