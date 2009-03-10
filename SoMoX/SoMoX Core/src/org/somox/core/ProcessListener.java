package org.somox.core;

/**
 * A process listener will be informed about status and progess changes
 *
 * @author Benjamin Klatt
 *
 */
public interface ProcessListener {

	/**
	 * Notify the listener that something has changed
	 */
	public void notifyListener();

	/**
	 * Set the progress of the process
	 * @param	The percentage value of the progress to finish
	 */
	public void setProgress(int progress);
}
