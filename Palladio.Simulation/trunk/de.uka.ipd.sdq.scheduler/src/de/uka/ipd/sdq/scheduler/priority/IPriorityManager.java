package de.uka.ipd.sdq.scheduler.priority;


public interface IPriorityManager {

	/**
	 * From the highest priority to the lowest.
	 * @return
	 */
	Iterable<IPriority> decreasing();
	
	
	/**
	 * Form the lowest priority to the highest.
	 * @return
	 */
	Iterable<IPriority> increasing();

	IPriority getHighestPriority();
	
	IPriority getHighPriority();
	
	IPriority getAveragePriority();

	IPriority getLowPriority();

	IPriority getLowestPriority();

	IPriority getDefaultPriority();
}
