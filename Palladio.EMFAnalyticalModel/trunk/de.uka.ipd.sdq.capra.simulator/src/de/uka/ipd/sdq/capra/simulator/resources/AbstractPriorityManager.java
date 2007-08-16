package de.uka.ipd.sdq.capra.simulator.resources;


public abstract class AbstractPriorityManager implements IPriorityManager {

	private int max;
	private int min;
	
	@Override
	public int getHighestPriority() {
		return max;
	}

	@Override
	public int getMin() {
		return min;
	}
	
	@Override
	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public int getNumPriorities() {
		return Math.abs(max - min) + 1;
	}

	@Override
	public boolean isSame(int prio_a, int prio_b) {
		return prio_a == prio_b;
	}

	public abstract int getPosition(int prio);

	public abstract int increase(int prio, int by);
	
	public abstract int decrease(int prio, int by);

	public abstract boolean isHigher(int prio_a, int prio_b);

	public abstract boolean isLower(int prio_a, int prio_b);
	
	public abstract int nextHigher(int prio, int by);

	public abstract int nextLower(int prio);

	public abstract boolean outOfBounds(int prio);
}
