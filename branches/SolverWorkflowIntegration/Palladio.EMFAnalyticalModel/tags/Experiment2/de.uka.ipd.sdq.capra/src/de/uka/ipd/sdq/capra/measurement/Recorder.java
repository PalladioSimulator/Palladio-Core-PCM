/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.Recorder#getStartCondition <em>Start Condition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.Recorder#getStopCondition <em>Stop Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getRecorder()
 * @model abstract="true"
 * @generated
 */
public interface Recorder extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Condition</em>' containment reference.
	 * @see #setStartCondition(Condition)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getRecorder_StartCondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Condition getStartCondition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.Recorder#getStartCondition <em>Start Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Condition</em>' containment reference.
	 * @see #getStartCondition()
	 * @generated
	 */
	void setStartCondition(Condition value);

	/**
	 * Returns the value of the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Condition</em>' containment reference.
	 * @see #setStopCondition(Condition)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getRecorder_StopCondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Condition getStopCondition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.Recorder#getStopCondition <em>Stop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Condition</em>' containment reference.
	 * @see #getStopCondition()
	 * @generated
	 */
	void setStopCondition(Condition value);

} // Recorder
