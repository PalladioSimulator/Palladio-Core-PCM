package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.impl;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriority;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityManager;

public class PriorityImpl implements IPriority {
	
	protected PriorityManagerImpl manager;
	protected int value;
	protected int absolute_value;
	

	protected PriorityImpl(int value, PriorityManagerImpl manager) {
		this.manager = manager;
		this.setValue(value);
	}
	

	
	public int absoluteValue() {
		return absolute_value;
	}

	
	public IPriorityManager getManager() {
		return manager;
	}

	
	public boolean greaterThan(IPriority prio) {
		return manager.direction > 0 ? this.getValue() > prio.getValue() : this.getValue() < prio.getValue();
	}

	
	public boolean lessOrEqual(IPriority prio) {
		return manager.direction > 0 ? this.getValue() <= prio.getValue() : this.getValue() >= prio.getValue();
	}

	
	public IPriority increase() {
		return new PriorityImpl(value + manager.direction, manager);
	}
	
	
	public IPriority decrease() {
		return new PriorityImpl(value - manager.direction, manager);	}


	
	public int distance(IPriority prio) {
		return Math.abs(this.getValue() - prio.getValue());
	}
	
	
	public int getValue() {
		return value;
	}
	
	
	public void setValue(int value) {
		this.value = value;
		this.absolute_value = Math.abs(value - manager.lowest_value);
	}

	
	public void setTo(IPriority priority) {
		this.setValue(priority.getValue());
	}

	
	public IPriority addBonus(int bonus) {
		bonus *= manager.direction;
		int new_value = this.getValue() + bonus;
		if (manager.direction > 0){
			new_value = Math.max(new_value, manager.lowest_value);
			new_value = Math.min(new_value, manager.highest_value);
		} else {
			new_value = Math.min(new_value, manager.lowest_value);
			new_value = Math.max(new_value, manager.highest_value);
		}
		return new PriorityImpl(new_value,manager);
	}

	@Override	
	public int hashCode() {
		return absolute_value;
	}
	
	@Override	
	public boolean equals(Object obj) {
		if (obj instanceof PriorityImpl) {
			PriorityImpl prio = (PriorityImpl) obj;
			return prio.value == this.value;
		}
		return false;
	}
	
	@Override	
	public IPriority clone() {
		return new PriorityImpl(this.value,this.manager);
	}
	
	@Override
	public String toString() {
		return ""+value;
	}
}
