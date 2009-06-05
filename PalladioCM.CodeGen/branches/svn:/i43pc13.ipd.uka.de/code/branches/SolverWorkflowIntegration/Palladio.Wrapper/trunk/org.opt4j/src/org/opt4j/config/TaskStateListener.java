package org.opt4j.config;

/**
 * The {@code TaskStateListener}.
 * 
 * @author lukasiewycz
 * 
 */
public interface TaskStateListener {

	/**
	 * Invoked if a {@code Task} changes its state.
	 * 
	 * @param task
	 *            the {@code Task} that changed its state
	 */
	public void stateChanged(Task task);

}
