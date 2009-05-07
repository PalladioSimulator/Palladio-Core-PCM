/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Counting Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.CountingRecorder#getCountingSensor <em>Counting Sensor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getCountingRecorder()
 * @model abstract="true"
 * @generated
 */
public interface CountingRecorder extends Recorder {
	/**
	 * Returns the value of the '<em><b>Counting Sensor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountingRecorders <em>Counting Recorders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Counting Sensor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Counting Sensor</em>' container reference.
	 * @see #setCountingSensor(CountingSensor)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getCountingRecorder_CountingSensor()
	 * @see de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountingRecorders
	 * @model opposite="countingRecorders" required="true" transient="false" ordered="false"
	 * @generated
	 */
	CountingSensor getCountingSensor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.CountingRecorder#getCountingSensor <em>Counting Sensor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Counting Sensor</em>' container reference.
	 * @see #getCountingSensor()
	 * @generated
	 */
	void setCountingSensor(CountingSensor value);

} // CountingRecorder
