
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.repository.Interface;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSystem_SystemRequiredRole <em>System System Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getRequiredDelegationConnector_SystemRequiredRole <em>Required Delegation Connector System Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getInterface_SystemRequiredRole <em>Interface System Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSpecifiedTimeConsumption_SystemRequiredRole <em>Specified Time Consumption System Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredRole()
 * @model
 * @generated
 */
public interface SystemRequiredRole extends Entity {
	/**
	 * Returns the value of the '<em><b>System System Required Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.System#getSystemRequiredRole_System <em>System Required Role System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System System Required Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System System Required Role</em>' container reference.
	 * @see #setSystem_SystemRequiredRole(de.uka.ipd.sdq.pcm.system.System)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredRole_System_SystemRequiredRole()
	 * @see de.uka.ipd.sdq.pcm.system.System#getSystemRequiredRole_System
	 * @model opposite="systemRequiredRole_System" required="true" ordered="false"
	 * @generated
	 */
	de.uka.ipd.sdq.pcm.system.System getSystem_SystemRequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSystem_SystemRequiredRole <em>System System Required Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System System Required Role</em>' container reference.
	 * @see #getSystem_SystemRequiredRole()
	 * @generated
	 */
	void setSystem_SystemRequiredRole(de.uka.ipd.sdq.pcm.system.System value);

	/**
	 * Returns the value of the '<em><b>Required Delegation Connector System Required Role</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getSystemRequiredRole_SystemRequiredDelegationConnector <em>System Required Role System Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Delegation Connector System Required Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Delegation Connector System Required Role</em>' reference.
	 * @see #setRequiredDelegationConnector_SystemRequiredRole(SystemRequiredDelegationConnector)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredRole_RequiredDelegationConnector_SystemRequiredRole()
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getSystemRequiredRole_SystemRequiredDelegationConnector
	 * @model opposite="systemRequiredRole_SystemRequiredDelegationConnector" required="true" ordered="false"
	 * @generated
	 */
	SystemRequiredDelegationConnector getRequiredDelegationConnector_SystemRequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getRequiredDelegationConnector_SystemRequiredRole <em>Required Delegation Connector System Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Delegation Connector System Required Role</em>' reference.
	 * @see #getRequiredDelegationConnector_SystemRequiredRole()
	 * @generated
	 */
	void setRequiredDelegationConnector_SystemRequiredRole(SystemRequiredDelegationConnector value);

	/**
	 * Returns the value of the '<em><b>Interface System Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface System Required Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface System Required Role</em>' reference.
	 * @see #setInterface_SystemRequiredRole(Interface)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredRole_Interface_SystemRequiredRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getInterface_SystemRequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getInterface_SystemRequiredRole <em>Interface System Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface System Required Role</em>' reference.
	 * @see #getInterface_SystemRequiredRole()
	 * @generated
	 */
	void setInterface_SystemRequiredRole(Interface value);

	/**
	 * Returns the value of the '<em><b>Specified Time Consumption System Required Role</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Time Consumption System Required Role</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Time Consumption System Required Role</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredRole_SpecifiedTimeConsumption_SystemRequiredRole()
	 * @model type="de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption" containment="true" ordered="false"
	 * @generated
	 */
	EList getSpecifiedTimeConsumption_SystemRequiredRole();

} // SystemRequiredRole