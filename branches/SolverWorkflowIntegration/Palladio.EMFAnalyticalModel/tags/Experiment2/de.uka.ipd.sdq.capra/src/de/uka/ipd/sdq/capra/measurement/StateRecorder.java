/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor <em>State Sensor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getStateRecorder()
 * @model abstract="true"
 * @generated
 */
public interface StateRecorder extends Recorder {
	/**
	 * Returns the value of the '<em><b>State Sensor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorders <em>State Recorders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Sensor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Sensor</em>' container reference.
	 * @see #setStateSensor(StateSensor)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getStateRecorder_StateSensor()
	 * @see de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorders
	 * @model opposite="stateRecorders" required="true"
	 * @generated
	 */
	StateSensor getStateSensor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor <em>State Sensor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Sensor</em>' container reference.
	 * @see #getStateSensor()
	 * @generated
	 */
	void setStateSensor(StateSensor value);

} // StateRecorder
