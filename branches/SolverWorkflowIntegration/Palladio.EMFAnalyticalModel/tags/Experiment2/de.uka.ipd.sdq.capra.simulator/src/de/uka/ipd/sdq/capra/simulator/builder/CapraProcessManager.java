package de.uka.ipd.sdq.capra.simulator.builder;

import java.util.Collection;
import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.expressions.SimReplicatedProcess;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;

/**
 * Manages the processes in a system. Following the builder pattern.
 * @author jens
 *
 */
public class CapraProcessManager {
	private Hashtable<String,SimReplicatedProcess> simProcesses = new Hashtable<String, SimReplicatedProcess>();
	private Collection<SimSensor> sensorColl;
	
	public CapraProcessManager(Collection<SimSensor> sensorColl) {
		super();
		this.sensorColl = sensorColl;
	}

	public void addProcess(SimReplicatedProcess replicatedProcess){
		simProcesses.put(replicatedProcess.getName(), replicatedProcess);
	}
	
	public void addNewProcess(SimCapraExpression behaviour, String name, int numReplicas){
		SimReplicatedProcess replicatedProcess = new SimReplicatedProcess(behaviour,name,numReplicas, sensorColl);
		addProcess(replicatedProcess);
	}
	
	public SimReplicatedProcess getProcess(String name){
		return simProcesses.get(name);
	}
	
	public void initialSchedule(){
		for (SimReplicatedProcess rp : simProcesses.values()) {
			rp.schedule(0);
		}
	}
}
