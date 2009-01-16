/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raw Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Raw measurements contains an orderered list of measurements for a sensor. For each measurement at least the time when the measurement was taken is stored. Hence, n measurements lead to an array size of event time of n. I.e. inheriting classes have to ensure the same number and ordering for additionally stored measurements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawXValues <em>Raw XValues</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawYValues <em>Raw YValues</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getMeasurementRange <em>Measurement Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getRawMeasurements()
 * @model abstract="true"
 * @generated
 */
public interface RawMeasurements extends EObject {
	/**
	 * Returns the value of the '<em><b>Raw XValues</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw XValues</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw XValues</em>' containment reference.
	 * @see #setRawXValues(RawXValues)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getRawMeasurements_RawXValues()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	RawXValues getRawXValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawXValues <em>Raw XValues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw XValues</em>' containment reference.
	 * @see #getRawXValues()
	 * @generated
	 */
	void setRawXValues(RawXValues value);

	/**
	 * Returns the value of the '<em><b>Raw YValues</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw YValues</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw YValues</em>' containment reference.
	 * @see #setRawYValues(RawYValues)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getRawMeasurements_RawYValues()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	RawYValues getRawYValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawYValues <em>Raw YValues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw YValues</em>' containment reference.
	 * @see #getRawYValues()
	 * @generated
	 */
	void setRawYValues(RawYValues value);

	/**
	 * Returns the value of the '<em><b>Measurement Range</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.MeasurementRange#getRawMeasurements <em>Raw Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement Range</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement Range</em>' container reference.
	 * @see #setMeasurementRange(MeasurementRange)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getRawMeasurements_MeasurementRange()
	 * @see de.uka.ipd.sdq.sensorframework.MeasurementRange#getRawMeasurements
	 * @model opposite="rawMeasurements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MeasurementRange getMeasurementRange();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getMeasurementRange <em>Measurement Range</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement Range</em>' container reference.
	 * @see #getMeasurementRange()
	 * @generated
	 */
	void setMeasurementRange(MeasurementRange value);

} // RawMeasurements
