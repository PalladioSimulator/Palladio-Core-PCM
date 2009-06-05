/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import scheduler.configuration.TimeValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval State Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#getTimeInterval <em>Time Interval</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#isPercent <em>Percent</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getIntervalStateRecorder()
 * @model
 * @generated
 */
public interface IntervalStateRecorder extends StateRecorder {
	/**
	 * Returns the value of the '<em><b>Time Interval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Interval</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Interval</em>' containment reference.
	 * @see #setTimeInterval(TimeValue)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getIntervalStateRecorder_TimeInterval()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimeValue getTimeInterval();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#getTimeInterval <em>Time Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Interval</em>' containment reference.
	 * @see #getTimeInterval()
	 * @generated
	 */
	void setTimeInterval(TimeValue value);

	/**
	 * Returns the value of the '<em><b>Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percent</em>' attribute.
	 * @see #setPercent(boolean)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getIntervalStateRecorder_Percent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isPercent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#isPercent <em>Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percent</em>' attribute.
	 * @see #isPercent()
	 * @generated
	 */
	void setPercent(boolean value);

} // IntervalStateRecorder
