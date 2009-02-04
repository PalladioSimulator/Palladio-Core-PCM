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
 * A representation of the model object '<em><b>Raw XValues</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawXValues#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getRawXValues()
 * @model abstract="true"
 * @generated
 */
public interface RawXValues extends EObject {
	/**
	 * Returns the value of the '<em><b>Raw Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawXValues <em>Raw XValues</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Measurements</em>' container reference.
	 * @see #setRawMeasurements(RawMeasurements)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getRawXValues_RawMeasurements()
	 * @see de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawXValues
	 * @model opposite="rawXValues" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RawMeasurements getRawMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawXValues#getRawMeasurements <em>Raw Measurements</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Measurements</em>' container reference.
	 * @see #getRawMeasurements()
	 * @generated
	 */
	void setRawMeasurements(RawMeasurements value);

} // RawXValues
