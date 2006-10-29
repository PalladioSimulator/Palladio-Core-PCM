
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.repository.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getSystem_SystemProvidedRole <em>System System Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getProvidedDelegationConnector_SystemProvidedRole <em>Provided Delegation Connector System Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getInterface_SystemProvidedRole <em>Interface System Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedRole()
 * @model
 * @generated
 */
public interface SystemProvidedRole extends Entity {
	/**
	 * Returns the value of the '<em><b>System System Provided Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.System#getSystemProvidedRole_System <em>System Provided Role System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System System Provided Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System System Provided Role</em>' container reference.
	 * @see #setSystem_SystemProvidedRole(de.uka.ipd.sdq.pcm.system.System)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedRole_System_SystemProvidedRole()
	 * @see de.uka.ipd.sdq.pcm.system.System#getSystemProvidedRole_System
	 * @model opposite="systemProvidedRole_System" required="true" ordered="false"
	 * @generated
	 */
	de.uka.ipd.sdq.pcm.system.System getSystem_SystemProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getSystem_SystemProvidedRole <em>System System Provided Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System System Provided Role</em>' container reference.
	 * @see #getSystem_SystemProvidedRole()
	 * @generated
	 */
	void setSystem_SystemProvidedRole(de.uka.ipd.sdq.pcm.system.System value);

	/**
	 * Returns the value of the '<em><b>Provided Delegation Connector System Provided Role</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getSystemProvidedRole_SystemProvidedDelegationConnector <em>System Provided Role System Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Delegation Connector System Provided Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Delegation Connector System Provided Role</em>' reference.
	 * @see #setProvidedDelegationConnector_SystemProvidedRole(SystemProvidedDelegationConnector)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedRole_ProvidedDelegationConnector_SystemProvidedRole()
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getSystemProvidedRole_SystemProvidedDelegationConnector
	 * @model opposite="systemProvidedRole_SystemProvidedDelegationConnector" required="true" ordered="false"
	 * @generated
	 */
	SystemProvidedDelegationConnector getProvidedDelegationConnector_SystemProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getProvidedDelegationConnector_SystemProvidedRole <em>Provided Delegation Connector System Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Delegation Connector System Provided Role</em>' reference.
	 * @see #getProvidedDelegationConnector_SystemProvidedRole()
	 * @generated
	 */
	void setProvidedDelegationConnector_SystemProvidedRole(SystemProvidedDelegationConnector value);

	/**
	 * Returns the value of the '<em><b>Interface System Provided Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface System Provided Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface System Provided Role</em>' reference.
	 * @see #setInterface_SystemProvidedRole(Interface)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedRole_Interface_SystemProvidedRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getInterface_SystemProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getInterface_SystemProvidedRole <em>Interface System Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface System Provided Role</em>' reference.
	 * @see #getInterface_SystemProvidedRole()
	 * @generated
	 */
	void setInterface_SystemProvidedRole(Interface value);

} // SystemProvidedRole