package de.uka.ipd.sdq.ByCounter.measurement;

/**
 * An interface for a specific measurement. Allows initilization
 * and a call for the measurement itself.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public interface IMeasurable {
	
	/**
	 * This is called to be measured repeatedly.
	 */
	public void callForMeasuring();
	
	/**
	 * Initialize before the actual measurement happens.
	 * @return Returns true if the initilisation was successfull. False otherwise.
	 *
	 */
	public boolean prepareMeasuring();
}
