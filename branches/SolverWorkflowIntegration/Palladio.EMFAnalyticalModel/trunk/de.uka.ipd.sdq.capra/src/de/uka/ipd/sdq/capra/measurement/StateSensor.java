/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorder <em>State Recorder</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getStateSensor()
 * @model abstract="true"
 * @generated
 */
public interface StateSensor extends Sensor {

	/**
	 * Returns the value of the '<em><b>State Recorder</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.measurement.StateRecorder}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor <em>State Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Recorder</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Recorder</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getStateSensor_StateRecorder()
	 * @see de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor
	 * @model opposite="stateSensor" containment="true" ordered="false"
	 * @generated
	 */
	EList<StateRecorder> getStateRecorder();
} // StateSensor
