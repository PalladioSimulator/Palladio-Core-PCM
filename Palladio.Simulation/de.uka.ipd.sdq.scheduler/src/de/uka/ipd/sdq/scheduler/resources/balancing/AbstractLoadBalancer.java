package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.resources.queueing.MultipleRunQueues;


public abstract class AbstractLoadBalancer implements ILoadBalancer {

	/** 
	 * @uml.property name="balance_interval"
	 */
	private double balance_interval;

	/** 
	 * Getter of the property <tt>balance_interval</tt>
	 * @return  Returns the balance_interval.
	 * @uml.property  name="balance_interval"
	 */
	public double getBalance_interval() {
		return balance_interval;
	}

	/**
	 * @uml.property  name="last_balanced"
	 */
	private double last_balanced;

	/**
	 * Getter of the property <tt>last_balanced</tt>
	 * @return  Returns the last_balanced.
	 * @uml.property  name="last_balanced"
	 */
	public double getLast_balanced() {
		return last_balanced;
	}

	/**
	 * Setter of the property <tt>last_balanced</tt>
	 * @param last_balanced  The last_balanced to set.
	 * @uml.property  name="last_balanced"
	 */
	public void setLast_balanced(double last_balanced) {
		this.last_balanced = last_balanced;
	}

	/** 
	 * Setter of the property <tt>balance_interval</tt>
	 * @param balance_interval  The balance_interval to set.
	 * @uml.property  name="balance_interval"
	 */
	public void setBalance_interval(double balance_interval) {
		this.balance_interval = balance_interval;
	}
	
	@Override
	public MultipleRunQueues getScheduler() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setScheduler(MultipleRunQueues scheduler) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public abstract void balance();
}
