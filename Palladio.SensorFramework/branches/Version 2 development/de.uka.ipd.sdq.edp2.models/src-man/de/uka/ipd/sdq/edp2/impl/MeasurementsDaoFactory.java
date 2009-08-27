/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import javax.measure.Measure;

/**
 * @author groenda
 *
 */
public abstract class MeasurementsDaoFactory implements de.uka.ipd.sdq.edp2.MeasurementsDaoFactory {
	/** Determines if this DAO is active (connection to data store available) or not. */
	private boolean active = true;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMeasurementsDaoFactory#createDoubleMeasurementsDao(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BinaryMeasurementsDaoImpl<Measure> createDoubleMeasurementsDao(
			String uuid) {
		if (!active) {
			throw new IllegalStateException("Must be in active state to create DAOs.");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMeasurementsDaoFactory#createJScienceXmlMeasurementsDao(java.lang.String)
	 */
	@Override
	public JScienceXmlMeasurementsDao createJScienceXmlMeasurementsDao(
			String uuid) {
		if (!active) {
			throw new IllegalStateException("Must be in active state to create DAOs.");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMeasurementsDaoFactory#createLongMeasurementsDao(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BinaryMeasurementsDaoImpl<Measure> createLongMeasurementsDao(String uuid) {
		if (!active) {
			throw new IllegalStateException("Must be in active state to create DAOs.");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMeasurementsDaoFactory#createNominalMeasurementsDao(java.lang.String)
	 */
	@Override
	public NominalMeasurementsDaoImpl createNominalMeasurementsDao(String uuid) {
		if (!active) {
			throw new IllegalStateException("Must be in active state to create DAOs.");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMeasurementsDaoFactory#isActive()
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMeasurementsDaoFactory#setActive(boolean)
	 */
	@Override
	public void setActive(boolean newValue) {
		if ((active && newValue) || (!active && !newValue)) {
			throw new IllegalStateException("Can not change state to current state.");
		}
		active = newValue;
	}

}
