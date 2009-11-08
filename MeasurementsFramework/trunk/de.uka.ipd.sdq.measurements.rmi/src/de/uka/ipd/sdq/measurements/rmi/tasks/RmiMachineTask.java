package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;

public abstract class RmiMachineTask extends RmiAbstractTask implements Serializable {

	private static final long serialVersionUID = -5098686142442634106L;
	
	private String machineIp = "";
	private int machinePort = 0;
	private String machineName = "";
	
	protected RmiMachineTask(int id) {
		super(id);
	}
	
	public void setMachineIp(String machineIp) {
		this.machineIp = machineIp;
	}
	
	public String getMachineIp() {
		return machineIp;
	}
	
	public void setMachinePort(int machinePort) {
		this.machinePort = machinePort;
	}
	
	public int getMachinePort() {
		return machinePort;
	}
	
	public void setMachineName(String machineName) {
		if (machineName != null) {
			this.machineName = machineName;
		}
	}
	
	public String getMachineName() {
		return machineName;
	}


}
