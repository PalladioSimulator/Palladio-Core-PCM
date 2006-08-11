
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getRequiringChildComponentContext_CompositeAssemblyConnector <em>Requiring Child Component Context Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getProvidingChildComponentContext_CompositeAssemblyConnector <em>Providing Child Component Context Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getProvidedRole_CompositeAssemblyConnector <em>Provided Role Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getRequiredRole_CompositeAssemblyConnector <em>Required Role Composite Assembly Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeAssemblyConnector()
 * @model
 * @generated
 */
public interface CompositeAssemblyConnector extends Connector, Entity {
	/**
	 * Returns the value of the '<em><b>Requiring Child Component Context Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Child Component Context Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #setRequiringChildComponentContext_CompositeAssemblyConnector(ChildComponentContext)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeAssemblyConnector_RequiringChildComponentContext_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ChildComponentContext getRequiringChildComponentContext_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getRequiringChildComponentContext_CompositeAssemblyConnector <em>Requiring Child Component Context Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #getRequiringChildComponentContext_CompositeAssemblyConnector()
	 * @generated
	 */
	void setRequiringChildComponentContext_CompositeAssemblyConnector(ChildComponentContext value);

	/**
	 * Returns the value of the '<em><b>Providing Child Component Context Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Child Component Context Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #setProvidingChildComponentContext_CompositeAssemblyConnector(ChildComponentContext)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeAssemblyConnector_ProvidingChildComponentContext_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ChildComponentContext getProvidingChildComponentContext_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getProvidingChildComponentContext_CompositeAssemblyConnector <em>Providing Child Component Context Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #getProvidingChildComponentContext_CompositeAssemblyConnector()
	 * @generated
	 */
	void setProvidingChildComponentContext_CompositeAssemblyConnector(ChildComponentContext value);

	/**
	 * Returns the value of the '<em><b>Provided Role Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Role Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Role Composite Assembly Connector</em>' reference.
	 * @see #setProvidedRole_CompositeAssemblyConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeAssemblyConnector_ProvidedRole_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getProvidedRole_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getProvidedRole_CompositeAssemblyConnector <em>Provided Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Role Composite Assembly Connector</em>' reference.
	 * @see #getProvidedRole_CompositeAssemblyConnector()
	 * @generated
	 */
	void setProvidedRole_CompositeAssemblyConnector(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Required Role Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Role Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Role Composite Assembly Connector</em>' reference.
	 * @see #setRequiredRole_CompositeAssemblyConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeAssemblyConnector_RequiredRole_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getRequiredRole_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector#getRequiredRole_CompositeAssemblyConnector <em>Required Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Role Composite Assembly Connector</em>' reference.
	 * @see #getRequiredRole_CompositeAssemblyConnector()
	 * @generated
	 */
	void setRequiredRole_CompositeAssemblyConnector(RequiredRole value);

} // CompositeAssemblyConnector