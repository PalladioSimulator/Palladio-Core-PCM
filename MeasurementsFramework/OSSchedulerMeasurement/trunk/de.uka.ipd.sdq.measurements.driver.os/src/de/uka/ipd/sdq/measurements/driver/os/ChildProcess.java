package de.uka.ipd.sdq.measurements.driver.os;

/**
 * This class encapsulates the structure for managing a child process.
 * @author hauck
 *
 */
public class ChildProcess {
	
	public ChildProcess(Process process, String rmiIp, int rmiPort) {
		super();
		this.process = process;
		this.rmiIp = rmiIp;
		this.rmiPort = rmiPort;
	}
	
	private Process process = null;
	public Process getProcess() {
		return process;
	}
	public String getRmiIp() {
		return rmiIp;
	}
	public int getRmiPort() {
		return rmiPort;
	}
	private String rmiIp = null;
	private int rmiPort = 0;
	
	public boolean isProcessRunning() {
		if (process == null) {
			return false;
		}
		try {
			process.exitValue();
		} catch (IllegalThreadStateException e) {
			return true;
		}
		return false;
	}

}
