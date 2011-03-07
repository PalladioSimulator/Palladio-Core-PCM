
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getSystemProvidedRole_SystemProvidedDelegationConnector <em>System Provided Role System Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getAssemblyContext_SystemProvidedDelegationConnector <em>Assembly Context System Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getComponentProvidedRole_SystemProvidedDelegationConnector <em>Component Provided Role System Provided Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedDelegationConnector()
 * @model
 * @generated
 */
public interface SystemProvidedDelegationConnector extends EObject {
	/**
	 * Returns the value of the '<em><b>System Provided Role System Provided Delegation Connector</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getProvidedDelegationConnector_SystemProvidedRole <em>Provided Delegation Connector System Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Provided Role System Provided Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Provided Role System Provided Delegation Connector</em>' reference.
	 * @see #setSystemProvidedRole_SystemProvidedDelegationConnector(SystemProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedDelegationConnector_SystemProvidedRole_SystemProvidedDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getProvidedDelegationConnector_SystemProvidedRole
	 * @model opposite="providedDelegationConnector_SystemProvidedRole" required="true" ordered="false"
	 * @generated
	 */
	SystemProvidedRole getSystemProvidedRole_SystemProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getSystemProvidedRole_SystemProvidedDelegationConnector <em>System Provided Role System Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Provided Role System Provided Delegation Connector</em>' reference.
	 * @see #getSystemProvidedRole_SystemProvidedDelegationConnector()
	 * @generated
	 */
	void setSystemProvidedRole_SystemProvidedDelegationConnector(SystemProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context System Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context System Provided Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context System Provided Delegation Connector</em>' reference.
	 * @see #setAssemblyContext_SystemProvidedDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedDelegationConnector_AssemblyContext_SystemProvidedDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_SystemProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getAssemblyContext_SystemProvidedDelegationConnector <em>Assembly Context System Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context System Provided Delegation Connector</em>' reference.
	 * @see #getAssemblyContext_SystemProvidedDelegationConnector()
	 * @generated
	 */
	void setAssemblyContext_SystemProvidedDelegationConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Component Provided Role System Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Provided Role System Provided Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Provided Role System Provided Delegation Connector</em>' reference.
	 * @see #setComponentProvidedRole_SystemProvidedDelegationConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystemProvidedDelegationConnector_ComponentProvidedRole_SystemProvidedDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getComponentProvidedRole_SystemProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getComponentProvidedRole_SystemProvidedDelegationConnector <em>Component Provided Role System Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Provided Role System Provided Delegation Connector</em>' reference.
	 * @see #getComponentProvidedRole_SystemProvidedDelegationConnector()
	 * @generated
	 */
	void setComponentProvidedRole_SystemProvidedDelegationConnector(ProvidedRole value);

} // SystemProvidedDelegationConnector