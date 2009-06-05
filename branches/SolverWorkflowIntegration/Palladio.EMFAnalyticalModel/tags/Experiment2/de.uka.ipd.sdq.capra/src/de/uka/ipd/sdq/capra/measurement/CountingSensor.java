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
 * A representation of the model object '<em><b>Counting Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountingRecorders <em>Counting Recorders</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountVisits <em>Count Visits</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getCountingSensor()
 * @model
 * @generated
 */
public interface CountingSensor extends Sensor {
	/**
	 * Returns the value of the '<em><b>Counting Recorders</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.measurement.CountingRecorder}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.CountingRecorder#getCountingSensor <em>Counting Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Counting Recorders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Counting Recorders</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getCountingSensor_CountingRecorders()
	 * @see de.uka.ipd.sdq.capra.measurement.CountingRecorder#getCountingSensor
	 * @model type="de.uka.ipd.sdq.capra.measurement.CountingRecorder" opposite="countingSensor" containment="true"
	 * @generated
	 */
	EList<CountingRecorder> getCountingRecorders();

	/**
	 * Returns the value of the '<em><b>Count Visits</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Visits</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Visits</em>' reference.
	 * @see #setCountVisits(VisitProbe)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getCountingSensor_CountVisits()
	 * @model required="true"
	 * @generated
	 */
	VisitProbe getCountVisits();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountVisits <em>Count Visits</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Visits</em>' reference.
	 * @see #getCountVisits()
	 * @generated
	 */
	void setCountVisits(VisitProbe value);

} // CountingSensor
