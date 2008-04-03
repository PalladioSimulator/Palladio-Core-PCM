package de.uka.ipd.sdq.capra.simulator.processes;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;

/**
 * @author  jens.happe
 */
public class SimProcessGroup {
	private SimCapraProcess[] processes;

	private String name;
	
	private String id;

	public SimProcessGroup(SimCapraExpression behaviour, String name, String id, int numReplicas){
		super();
		this.name = name;
		this.id = id;
		processes = new SimCapraProcess[numReplicas];
		for (int i = 0; i < processes.length; i++) {
			SimCapraExpression myBehaviour = behaviour.clone();
			processes[i] = new SimCapraProcess(myBehaviour, name, id,null);
			processes[i].setAncestor(processes[i]);
		}
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
	
	public String getId(){
		return id;
	}
}
