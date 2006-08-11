
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getSystemRequiredRole_SystemRequiredDelegationConnector <em>System Required Role System Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getAssemblyContext_SystemRequiredDelegationConnector <em>Assembly Context System Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getRequiredRole_SystemRequiredDelegationConnector <em>Required Role System Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredDelegationConnector()
 * @model
 * @generated
 */
public interface SystemRequiredDelegationConnector extends EObject {
	/**
	 * Returns the value of the '<em><b>System Required Role System Required Delegation Connector</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getRequiredDelegationConnector_SystemRequiredRole <em>Required Delegation Connector System Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Required Role System Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Required Role System Required Delegation Connector</em>' reference.
	 * @see #setSystemRequiredRole_SystemRequiredDelegationConnector(SystemRequiredRole)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredDelegationConnector_SystemRequiredRole_SystemRequiredDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getRequiredDelegationConnector_SystemRequiredRole
	 * @model opposite="requiredDelegationConnector_SystemRequiredRole" required="true" ordered="false"
	 * @generated
	 */
	SystemRequiredRole getSystemRequiredRole_SystemRequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getSystemRequiredRole_SystemRequiredDelegationConnector <em>System Required Role System Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Required Role System Required Delegation Connector</em>' reference.
	 * @see #getSystemRequiredRole_SystemRequiredDelegationConnector()
	 * @generated
	 */
	void setSystemRequiredRole_SystemRequiredDelegationConnector(SystemRequiredRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context System Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context System Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context System Required Delegation Connector</em>' reference.
	 * @see #setAssemblyContext_SystemRequiredDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredDelegationConnector_AssemblyContext_SystemRequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_SystemRequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getAssemblyContext_SystemRequiredDelegationConnector <em>Assembly Context System Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context System Required Delegation Connector</em>' reference.
	 * @see #getAssemblyContext_SystemRequiredDelegationConnector()
	 * @generated
	 */
	void setAssemblyContext_SystemRequiredDelegationConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Required Role System Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Role System Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Role System Required Delegation Connector</em>' reference.
	 * @see #setRequiredRole_SystemRequiredDelegationConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemRequiredDelegationConnector_RequiredRole_SystemRequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getRequiredRole_SystemRequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getRequiredRole_SystemRequiredDelegationConnector <em>Required Role System Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Role System Required Delegation Connector</em>' reference.
	 * @see #getRequiredRole_SystemRequiredDelegationConnector()
	 * @generated
	 */
	void setRequiredRole_SystemRequiredDelegationConnector(RequiredRole value);

} // SystemRequiredDelegationConnector