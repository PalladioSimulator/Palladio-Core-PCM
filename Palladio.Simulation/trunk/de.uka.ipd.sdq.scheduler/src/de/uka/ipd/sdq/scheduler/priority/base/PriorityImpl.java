package de.uka.ipd.sdq.scheduler.priority.base;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;

public class PriorityImpl implements IPriority {
	
	protected PriorityManagerImpl manager;
	protected int value;
	protected int absolute_value;
	

	protected PriorityImpl(int value, PriorityManagerImpl manager) {
		this.manager = manager;
		this.setValue(value);
	}
	

	@Override
	public int absoluteValue() {
		return absolute_value;
	}

	@Override
	public IPriorityManager getManager() {
		return manager;
	}

	@Override
	public boolean greaterThan(IPriority prio) {
		return this.absolute_value > prio.absoluteValue(); 
	}

	@Override
	public IPriority increase() {
		return new PriorityImpl(value += manager.direction, manager);
	}
	
	@Override
	public IPriority decrease() {
		return new PriorityImpl(value -= manager.direction, manager);	}


	@Override
	public boolean lessOrEqual(IPriority prio) {
		return this.absoluteValue() <= prio.absoluteValue();
	}

	@Override
	public int distance(IPriority prio) {
		return Math.abs(this.getValue() - prio.getValue());
	}
	
	@Override
	public int getValue() {
		return value;
	}
	
	@Override
	public void setValue(int value) {
		this.value = value;
		this.absolute_value = Math.abs(value - manager.lowest_value);
	}

	@Override
	public void setTo(IPriority priority) {
		this.setValue(priority.getValue());
	}

	@Override
	public IPriority addBonus(IPriority priority, int bonus) {
		bonus *= manager.direction;
		int new_value = priority.getValue() + bonus;
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
}
