package de.uka.ipd.sdq.probfunction.math;

/**
 * A unit describes the scale unit of the Y and X axis of a function. For example, the domain (X-axis) of 
 * a probability function can be time measured in milliseconds. In this case, Unit would contain a string "ms".
 * 
 * For now, Unit is only a container of a string. For the future, we plan to exend it with capabilities of
 * computing one one scale unit into another (e.g. from milliseconds ("ms") to seconds ("s") automatically. 
 * 
 * @author ihssane, jens
 *
 */
public interface IUnit {
	
	/**
	 * 
	 * @return Returns a string describing the unit.
	 */
	String getUnitName();

	/**
	 * Sets the string describing the unit.
	 * @param unit
	 */
	void setUnitName(String unit);
}
