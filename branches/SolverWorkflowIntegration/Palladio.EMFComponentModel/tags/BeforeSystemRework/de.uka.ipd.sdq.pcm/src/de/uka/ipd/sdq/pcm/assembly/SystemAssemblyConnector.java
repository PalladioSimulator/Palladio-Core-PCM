
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidingContext_SystemAssemblyConnector <em>Providing Context System Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiringContext_SystemAssemblyConnector <em>Requiring Context System Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidedRole_SystemAssemblyConnector <em>Provided Role System Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiredRole_SystemAssemblyConnector <em>Required Role System Assembly Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getSystemAssemblyConnector()
 * @model
 * @generated
 */
public interface SystemAssemblyConnector extends Connector {
	/**
	 * Returns the value of the '<em><b>Providing Context System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Context System Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Context System Assembly Connector</em>' reference.
	 * @see #setProvidingContext_SystemAssemblyConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getSystemAssemblyConnector_ProvidingContext_SystemAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getProvidingContext_SystemAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidingContext_SystemAssemblyConnector <em>Providing Context System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Context System Assembly Connector</em>' reference.
	 * @see #getProvidingContext_SystemAssemblyConnector()
	 * @generated
	 */
	void setProvidingContext_SystemAssemblyConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Requiring Context System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Context System Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Context System Assembly Connector</em>' reference.
	 * @see #setRequiringContext_SystemAssemblyConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getSystemAssemblyConnector_RequiringContext_SystemAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getRequiringContext_SystemAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiringContext_SystemAssemblyConnector <em>Requiring Context System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Context System Assembly Connector</em>' reference.
	 * @see #getRequiringContext_SystemAssemblyConnector()
	 * @generated
	 */
	void setRequiringContext_SystemAssemblyConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Provided Role System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Role System Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Role System Assembly Connector</em>' reference.
	 * @see #setProvidedRole_SystemAssemblyConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getSystemAssemblyConnector_ProvidedRole_SystemAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getProvidedRole_SystemAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getProvidedRole_SystemAssemblyConnector <em>Provided Role System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Role System Assembly Connector</em>' reference.
	 * @see #getProvidedRole_SystemAssemblyConnector()
	 * @generated
	 */
	void setProvidedRole_SystemAssemblyConnector(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Required Role System Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Role System Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Role System Assembly Connector</em>' reference.
	 * @see #setRequiredRole_SystemAssemblyConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getSystemAssemblyConnector_RequiredRole_SystemAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getRequiredRole_SystemAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector#getRequiredRole_SystemAssemblyConnector <em>Required Role System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Role System Assembly Connector</em>' reference.
	 * @see #getRequiredRole_SystemAssemblyConnector()
	 * @generated
	 */
	void setRequiredRole_SystemAssemblyConnector(RequiredRole value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- Context-IDs of providingRole and requiringRole have to differ #
	 * self.providingRole.parentContext.identifier.id<>self.requiringRole.parentContext.identifier.id
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean contextIDsOfProvidesRoleNotEqualRequiresRole(DiagnosticChain diagnostics, Map context);

} // SystemAssemblyConnector