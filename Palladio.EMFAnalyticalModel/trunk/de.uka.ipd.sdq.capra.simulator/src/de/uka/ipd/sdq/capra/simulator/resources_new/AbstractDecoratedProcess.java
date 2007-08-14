package de.uka.ipd.sdq.capra.simulator.resources_new;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;


public abstract class AbstractDecoratedProcess {

	/**
	 * @uml.property  name="capraProcess"
	 * @uml.associationEnd  aggregation="shared" inverse="abstractDecoratedProcess:de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess"
	 */
	private SimCapraProcess capraProcess;

	/**
	 * Getter of the property <tt>capraProcess</tt>
	 * @return  Returns the capraProcess.
	 * @uml.property  name="capraProcess"
	 */
	public SimCapraProcess getCapraProcess() {
		return capraProcess;
	}

	/**
	 * Setter of the property <tt>capraProcess</tt>
	 * @param capraProcess  The capraProcess to set.
	 * @uml.property  name="capraProcess"
	 */
	public void setCapraProcess(SimCapraProcess capraProcess) {
		this.capraProcess = capraProcess;
	}

}
