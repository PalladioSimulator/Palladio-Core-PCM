
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector#getInnerRequiredRole_RequiredDelegationConnector <em>Inner Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector#getOuterRequiredRole_RequiredDelegationConnector <em>Outer Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector#getChildComponentContext_RequiredDelegationConnector <em>Child Component Context Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredDelegationConnector()
 * @model
 * @generated
 */
public interface RequiredDelegationConnector extends DelegationConnector {
	/**
	 * Returns the value of the '<em><b>Inner Required Role Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Required Role Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Required Role Required Delegation Connector</em>' reference.
	 * @see #setInnerRequiredRole_RequiredDelegationConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getInnerRequiredRole_RequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector#getInnerRequiredRole_RequiredDelegationConnector <em>Inner Required Role Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Required Role Required Delegation Connector</em>' reference.
	 * @see #getInnerRequiredRole_RequiredDelegationConnector()
	 * @generated
	 */
	void setInnerRequiredRole_RequiredDelegationConnector(RequiredRole value);

	/**
	 * Returns the value of the '<em><b>Outer Required Role Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Required Role Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Required Role Required Delegation Connector</em>' reference.
	 * @see #setOuterRequiredRole_RequiredDelegationConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getOuterRequiredRole_RequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector#getOuterRequiredRole_RequiredDelegationConnector <em>Outer Required Role Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Required Role Required Delegation Connector</em>' reference.
	 * @see #getOuterRequiredRole_RequiredDelegationConnector()
	 * @generated
	 */
	void setOuterRequiredRole_RequiredDelegationConnector(RequiredRole value);

	/**
	 * Returns the value of the '<em><b>Child Component Context Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Component Context Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Component Context Required Delegation Connector</em>' reference.
	 * @see #setChildComponentContext_RequiredDelegationConnector(ChildComponentContext)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredDelegationConnector_ChildComponentContext_RequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ChildComponentContext getChildComponentContext_RequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector#getChildComponentContext_RequiredDelegationConnector <em>Child Component Context Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Component Context Required Delegation Connector</em>' reference.
	 * @see #getChildComponentContext_RequiredDelegationConnector()
	 * @generated
	 */
	void setChildComponentContext_RequiredDelegationConnector(ChildComponentContext value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self->forAll(p1, p2 |
	 * p1.innerRequiringRole.parentContext.identifier.id <> p2.outerRequiringRole.parentContext.identifier.id)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean innerAndOuterRoleNeedToHaveDifferentContextIDs(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.parentCompositeComponent.identifier.id
	 * =
	 * self.outerRequiringRole.encapsulatedRole.requiringComponent.identifier.id
	 * 
	 * and
	 * 
	 * self.parentCompositeComponent.identifier.id
	 * =
	 * self.innerRequiringRole.encapsulatedRole.requiringComponent.identifier.id
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean InnerContainingComponentEqualOuterRequiringComponent(DiagnosticChain diagnostics, Map context);

} // RequiredDelegationConnector