package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.Collection;
import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;



public class SimReplicatedProcess {
	private SimCapraProcess[] processes;
	private String name;

	public SimReplicatedProcess(SimCapraExpression behaviour, String name, int numReplicas, Collection<SimSensor> sensorColl){
		super();
		processes = new SimCapraProcess[numReplicas];
		for (int i = 0; i < processes.length; i++) {
			SimCapraExpression myBehaviour = behaviour.clone();
			Hashtable<String, SimSensorInstance> sensorInstanceTable = createSensorInstances(sensorColl);
			myBehaviour.useSensorInstances(sensorInstanceTable);
			processes[i] = new SimCapraProcess(myBehaviour, name + "_" + i);
		}
		this.name = name;
	}
	

	private Hashtable<String, SimSensorInstance> createSensorInstances(
			Collection<SimSensor> sensorColl) {
		Hashtable<String, SimSensorInstance> sensorInstanceTable = new Hashtable<String, SimSensorInstance>();
		for (SimSensor simSensor : sensorColl) {
			sensorInstanceTable.put(simSensor.getName(), simSensor.createInstance());
		}
		return sensorInstanceTable;
	}


	public void schedule(double simTime) {
		for (int i = 0; i < processes.length; i++) {
			processes[i].start(simTime);
		}
	}

	public SimCapraProcess[] getProcesses(){
		return processes;
	}

	public String getName() {
		return name;
	}
}
