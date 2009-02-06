/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Sensor which allows to store predescribed state(s).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.StateSensor#getDefinedSensorStates <em>Defined Sensor States</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.StateSensor#getInitialState <em>Initial State</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStateSensor()
 * @model
 * @generated
 */
public interface StateSensor extends SensorDeclaration {
	/**
	 * Returns the value of the '<em><b>Defined Sensor States</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.sensorframework.models.emfmodel.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Sensor States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Sensor States</em>' containment reference list.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStateSensor_DefinedSensorStates()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<State> getDefinedSensorStates();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStateSensor_InitialState()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.StateSensor#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.persistencyKind = PersistenceKindOptions::Emf
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean PersistenceKindOnlyEmfAllowed(DiagnosticChain diagnostics, Map context);

} // StateSensor
