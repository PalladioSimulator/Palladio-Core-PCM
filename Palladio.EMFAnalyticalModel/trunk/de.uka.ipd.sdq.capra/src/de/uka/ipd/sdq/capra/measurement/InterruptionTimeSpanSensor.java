/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import de.uka.ipd.sdq.capra.resources.ActiveResource;

import scheduler.configuration.TimeValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interruption Time Span Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor#getObservedResource <em>Observed Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getInterruptionTimeSpanSensor()
 * @model
 * @generated
 */
public interface InterruptionTimeSpanSensor extends LocalTimeSpanSensor {
	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold</em>' containment reference.
	 * @see #setThreshold(TimeValue)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getInterruptionTimeSpanSensor_Threshold()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimeValue getThreshold();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor#getThreshold <em>Threshold</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' containment reference.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(TimeValue value);

	/**
	 * Returns the value of the '<em><b>Observed Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed Resource</em>' reference.
	 * @see #setObservedResource(ActiveResource)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getInterruptionTimeSpanSensor_ObservedResource()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ActiveResource getObservedResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor#getObservedResource <em>Observed Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observed Resource</em>' reference.
	 * @see #getObservedResource()
	 * @generated
	 */
	void setObservedResource(ActiveResource value);

} // InterruptionTimeSpanSensor
