/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.extension;

import de.uka.ipd.sdq.capra.core.InstantaneousAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.extension.ReleaseAction#getNumber <em>Number</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.extension.ReleaseAction#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.extension.ExtensionPackage#getReleaseAction()
 * @model
 * @generated
 */
public interface ReleaseAction extends InstantaneousAction {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see de.uka.ipd.sdq.capra.extension.ExtensionPackage#getReleaseAction_Number()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.extension.ReleaseAction#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(PassiveResource)
	 * @see de.uka.ipd.sdq.capra.extension.ExtensionPackage#getReleaseAction_Resource()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PassiveResource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.extension.ReleaseAction#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(PassiveResource value);

} // ReleaseAction
