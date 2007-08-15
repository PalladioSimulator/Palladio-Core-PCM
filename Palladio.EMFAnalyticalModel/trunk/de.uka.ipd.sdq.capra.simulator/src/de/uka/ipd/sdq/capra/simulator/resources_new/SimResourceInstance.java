package de.uka.ipd.sdq.capra.simulator.resources_new;

public class SimResourceInstance {

	/**
	 * @uml.property name="id"
	 */
	private int id;

	/**
	 * Getter of the property <tt>id</tt>
	 * 
	 * @return Returns the id.
	 * @uml.property name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 * 
	 * @param id
	 *            The id to set.
	 * @uml.property name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @uml.property name="runningProcess"
	 */
	private ActiveProcess runningProcess;

	/**
	 * Getter of the property <tt>runningProcess</tt>
	 * 
	 * @return Returns the runningProcess.
	 * @uml.property name="runningProcess"
	 */
	public ActiveProcess getRunningProcess() {
		return runningProcess;
	}

	/**
	 * Setter of the property <tt>runningProcess</tt>
	 * 
	 * @param runningProcess
	 *            The runningProcess to set.
	 * @uml.property name="runningProcess"
	 */
	public void setRunningProcess(ActiveProcess runningProcess) {
		this.runningProcess = runningProcess;
	}
	
	/**
	 * Removes the currently running process from this instance and returns it.
	 * @return The currently running process.
	 */
	public ActiveProcess pollRunningProcess(){
		ActiveProcess process = this.runningProcess;
		this.runningProcess = null;
		return process;
	}

	/**
	 * True, if there is no process executing on this resource instance, false otherwise.
	 */
	public boolean isIdle() {
		return runningProcess == null;
	}

	/**
	 * Assigns a new process to this instance. Note that the resource has to be idle to do so.
	 * @param process
	 */
	public void assign(ActiveProcess process) {
		assert this.isIdle() : "There is already a process executing on resource instance "
			+ this;
		runningProcess = process;
	}
	
	@Override
	public String toString() {
		return "" + id;
	}

}
