package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority;


/**
 * Manages the priorities. Hides the actual possible values and direction from
 * the processes. It only offers semantic access to the values.
 * 
 * @author jens
 * 
 */
public interface IPriorityManager {

	/**
	 * Iterating from the highest priority to the lowest.
	 * 
	 * @return
	 */
	Iterable<IPriority> decreasing();

	/**
	 * Iterating form the lowest priority to the highest.
	 * 
	 * @return
	 */
	Iterable<IPriority> increasing();

	/**
	 * Returns the highest possible priority.
	 * @return
	 */
	IPriority getHighestPriority();

	/**
	 * Returns a default priority that is considered as high.
	 * @return
	 */
	IPriority getHighPriority();

	/**
	 * Returns a default priority that is considered as average.
	 * @return
	 */
	IPriority getAveragePriority();

	
	/**
	 * Returns a default priority that is considered as low.
	 * @return
	 */
	IPriority getLowPriority();

	
	/**
	 * Returns the lowest possible priority.
	 * @return
	 */
	IPriority getLowestPriority();

	/**
	 * Returns the default priority for processes.
	 * @return
	 */
	IPriority getDefaultPriority();
}
