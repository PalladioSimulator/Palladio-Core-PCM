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
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorders <em>State Recorders</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getStateSensor()
 * @model
 * @generated
 */
public interface StateSensor extends Sensor {
	/**
	 * Returns the value of the '<em><b>State Recorders</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.measurement.StateRecorder}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor <em>State Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Recorders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Recorders</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getStateSensor_StateRecorders()
	 * @see de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor
	 * @model type="de.uka.ipd.sdq.capra.measurement.StateRecorder" opposite="stateSensor" containment="true"
	 * @generated
	 */
	EList<StateRecorder> getStateRecorders();

} // StateSensor
