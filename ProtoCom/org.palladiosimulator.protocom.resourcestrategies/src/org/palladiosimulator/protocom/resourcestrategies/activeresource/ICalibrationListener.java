package org.palladiosimulator.protocom.resourcestrategies.activeresource;

/**
 * Classes implementing the ICalibrationListener interface can receive progress updates
 * during the calibration of resource strategies.
 * 
 * @author Christian Klaussner
 */
public interface ICalibrationListener {
	/**
	 * Called when the progress of the calibration changed.
	 * @param strategy the strategy that is currently claibrated and whose progress changed
	 * @param progress the new calibration progress in the range of 0.0 to 1.0
	 */
	void progressChanged(IDemandStrategy strategy, float progress);
}
