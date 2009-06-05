/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.IUnit;

/**
 * @author Ihssane
 * 
 */
public class UnitImpl implements IUnit {
	
	private String unitName;
	
	protected UnitImpl(String unitName) {
		this.unitName = unitName;  
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.math.probfunction.impl.IUnit#getUnit()
	 */
	public String getUnitName() {
		return unitName;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.math.probfunction.impl.IUnit#setUnit(java.lang.String)
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof IUnit) {
			IUnit other = (IUnit)obj;
			result = unitName.equals(other.getUnitName());
		}
		return result;
	}

	@Override
	public int hashCode() {
		return unitName.hashCode();
	}

	@Override
	public String toString() {
		return unitName;
	}
	
	
	
	
}
