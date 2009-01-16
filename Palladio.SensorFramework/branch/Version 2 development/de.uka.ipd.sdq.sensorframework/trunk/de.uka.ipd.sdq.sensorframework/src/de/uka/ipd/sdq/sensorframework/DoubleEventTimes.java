/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Event Times</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Event times are stored as double values with the implicit unit 'second'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.DoubleEventTimes#getMeasurementTime <em>Measurement Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getDoubleEventTimes()
 * @model
 * @generated
 */
public interface DoubleEventTimes extends RawXValues {
	/**
	 * Returns the value of the '<em><b>Measurement Time</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement Time</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement Time</em>' attribute list.
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getDoubleEventTimes_MeasurementTime()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Double> getMeasurementTime();

} // DoubleEventTimes
