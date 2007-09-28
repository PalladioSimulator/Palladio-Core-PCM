package de.uka.ipd.sdq.scheduler.priority.impl;

import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;


public class PriorityManagerImpl implements IPriorityManager {

	protected IPriority highestPriority;
	protected IPriority highPriority;
	protected IPriority averagePriority;
	protected IPriority lowPriority;
	protected IPriority lowestPriority;
	protected IPriority defaultPriority;
	protected int direction;
	protected int highest_value;
	protected int lowest_value;
	
	public PriorityManagerImpl(int highest_value, int high_value, int average_value, int low_value, int lowest_value, int default_value){
		assert (highest_value >= high_value && 
		        high_value >= average_value && 
		        average_value >= low_value && 
		        low_value >= lowest_value) || 
		        (highest_value <= high_value && 
		        high_value <= average_value && 
		        average_value <= low_value && 
		        low_value <= lowest_value) : "Priorities must be ordered!";
		
		direction = highest_value > lowest_value ? 1 : -1;
		this.highest_value = highest_value;
		this.lowest_value = lowest_value;
		
		this.highestPriority = new PriorityImpl(highest_value, this);
		this.highPriority = new PriorityImpl(high_value, this);
		this.averagePriority = new PriorityImpl(average_value, this);
		this.lowPriority = new PriorityImpl(low_value, this);
		this.lowestPriority = new PriorityImpl(lowest_value, this);
		this.defaultPriority = new PriorityImpl(default_value, this);
	}
	
	
	@Override
	public Iterable<IPriority> decreasing() {
		return new Iterable<IPriority>(){
			@Override
			public Iterator<IPriority> iterator() {
				return new Iterator<IPriority>(){
					IPriority current = highestPriority.clone();
					@Override
					public boolean hasNext() {
						return lowestPriority.lessOrEqual(current);
					}
					@Override
					public IPriority next() {
						IPriority result = current;
						current = current.decrease();
						return result;
					}
					@Override
					public void remove() {
					}
				};
			}
		};
	}
	
	@Override
	public Iterable<IPriority> increasing() {
		return new Iterable<IPriority>(){
			@Override
			public Iterator<IPriority> iterator() {
				return new Iterator<IPriority>(){
					IPriority current = lowestPriority.clone(); 
					@Override
					public boolean hasNext() {
						return current.lessOrEqual(highestPriority);
					}
					@Override
					public IPriority next() {
						IPriority result = current;
						current = current.increase();
						return result;
					}
					@Override
					public void remove() {
					}
				};
			}
		};
	}
	
	@Override
	public IPriority getDefaultPriority() {
		return defaultPriority.clone();
	}
	
	@Override
	public IPriority getHighestPriority() {
		return highestPriority.clone();
	}
	
	@Override
	public IPriority getLowestPriority() {
		return lowestPriority.clone();
	}


	@Override
	public IPriority getAveragePriority() {
		return averagePriority.clone();
	}


	@Override
	public IPriority getHighPriority() {
		return highPriority.clone();
	}


	@Override
	public IPriority getLowPriority() {
		return lowPriority.clone();
	}
}
