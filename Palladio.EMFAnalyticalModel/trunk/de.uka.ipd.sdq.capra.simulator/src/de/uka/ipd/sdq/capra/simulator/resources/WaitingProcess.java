package de.uka.ipd.sdq.capra.simulator.resources;


public class WaitingProcess {

	/**
	 * @uml.property   name="process"
	 * @uml.associationEnd   aggregation="shared" inverse="waitingProcess:de.uka.ipd.sdq.capra.simulator.resources.ActiveProcess"
	 */
	private ActiveProcess process;

	/**
	 * Getter of the property <tt>process</tt>
	 * @return  Returns the process.
	 * @uml.property  name="process"
	 */
	public ActiveProcess getProcess() {
		return process;
	}

	/**
	 * Setter of the property <tt>process</tt>
	 * @param process  The process to set.
	 * @uml.property  name="process"
	 */
	public void setProcess(ActiveProcess process) {
		this.process = process;
	}

	/**
	 * @uml.property  name="num_requested"
	 */
	private int num_requested;

	/**
	 * Getter of the property <tt>num_requested</tt>
	 * @return  Returns the num_requested.
	 * @uml.property  name="num_requested"
	 */
	public int getNum_requested() {
		return num_requested;
	}

	/**
	 * Setter of the property <tt>num_requested</tt>
	 * @param num_requested  The num_requested to set.
	 * @uml.property  name="num_requested"
	 */
	public void setNum_requested(int num_requested) {
		this.num_requested = num_requested;
	}

}
