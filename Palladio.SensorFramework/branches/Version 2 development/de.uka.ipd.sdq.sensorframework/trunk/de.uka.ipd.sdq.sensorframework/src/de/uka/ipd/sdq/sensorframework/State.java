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
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.State#getStateLiteral <em>State Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>State Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Literal</em>' attribute.
	 * @see #setStateLiteral(String)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getState_StateLiteral()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getStateLiteral();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.State#getStateLiteral <em>State Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Literal</em>' attribute.
	 * @see #getStateLiteral()
	 * @generated
	 */
	void setStateLiteral(String value);

} // State
