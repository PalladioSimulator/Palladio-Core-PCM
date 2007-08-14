package de.uka.ipd.sdq.capra.simulator.resources_new;



public class StaticPriorityBoost extends AbstractPriorityBoost {

	@Override
	public void boost(ProcessWithPriority process) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @uml.property  name="priorityDecayStrategy"
	 * @uml.associationEnd  aggregation="composite" inverse="staticPriorityBoost:de.uka.ipd.sdq.capra.simulator.resources_new.IPriorityUpdateStrategy"
	 */
	private IPriorityUpdateStrategy priorityDecayStrategy;

	/**
	 * Getter of the property <tt>priorityDecayStrategy</tt>
	 * @return  Returns the priorityDecayStrategy.
	 * @uml.property  name="priorityDecayStrategy"
	 */
	public IPriorityUpdateStrategy getPriorityDecayStrategy() {
		return priorityDecayStrategy;
	}

	/**
	 * Setter of the property <tt>priorityDecayStrategy</tt>
	 * @param priorityDecayStrategy  The priorityDecayStrategy to set.
	 * @uml.property  name="priorityDecayStrategy"
	 */
	public void setPriorityDecayStrategy(
			IPriorityUpdateStrategy priorityDecayStrategy) {
				this.priorityDecayStrategy = priorityDecayStrategy;
			}

	/**
	 * @uml.property  name="boostValue"
	 */
	private int boostValue;

	/**
	 * Getter of the property <tt>boostValue</tt>
	 * @return  Returns the boostValue.
	 * @uml.property  name="boostValue"
	 */
	public int getBoostValue() {
		return boostValue;
	}

	/**
	 * Setter of the property <tt>boostValue</tt>
	 * @param boostValue  The boostValue to set.
	 * @uml.property  name="boostValue"
	 */
	public void setBoostValue(int boostValue) {
		this.boostValue = boostValue;
	}
}
