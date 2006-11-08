
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.repository.DelegationConnector;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getInnerProvidedRole_ProvidedDelegationConnector <em>Inner Provided Role Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getOuterProvidedRole_ProvidedDelegationConnector <em>Outer Provided Role Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getChildComponentContext_ProvidedDelegationConnector <em>Child Component Context Provided Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getProvidedDelegationConnector()
 * @model
 * @generated
 */
public interface ProvidedDelegationConnector extends DelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Inner Provided Role Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Provided Role Provided Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Provided Role Provided Delegation Connector</em>' reference.
	 * @see #setInnerProvidedRole_ProvidedDelegationConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getInnerProvidedRole_ProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getInnerProvidedRole_ProvidedDelegationConnector <em>Inner Provided Role Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Provided Role Provided Delegation Connector</em>' reference.
	 * @see #getInnerProvidedRole_ProvidedDelegationConnector()
	 * @generated
	 */
	void setInnerProvidedRole_ProvidedDelegationConnector(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Outer Provided Role Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Provided Role Provided Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Provided Role Provided Delegation Connector</em>' reference.
	 * @see #setOuterProvidedRole_ProvidedDelegationConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getOuterProvidedRole_ProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getOuterProvidedRole_ProvidedDelegationConnector <em>Outer Provided Role Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Provided Role Provided Delegation Connector</em>' reference.
	 * @see #getOuterProvidedRole_ProvidedDelegationConnector()
	 * @generated
	 */
	void setOuterProvidedRole_ProvidedDelegationConnector(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Child Component Context Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Component Context Provided Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Component Context Provided Delegation Connector</em>' reference.
	 * @see #setChildComponentContext_ProvidedDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getProvidedDelegationConnector_ChildComponentContext_ProvidedDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getChildComponentContext_ProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getChildComponentContext_ProvidedDelegationConnector <em>Child Component Context Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Component Context Provided Delegation Connector</em>' reference.
	 * @see #getChildComponentContext_ProvidedDelegationConnector()
	 * @generated
	 */
	void setChildComponentContext_ProvidedDelegationConnector(AssemblyContext value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self->forAll(p1, p2 |
	 * p1.innerProvidingRole.parentContext.identifier.id <> p2.outerProvidingRole.parentContext.identifier.id)
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
	 * self.outerProvidingRole.encapsulatedRole.providingComponent.identifier.id
	 * 
	 * and
	 * 
	 * self.parentCompositeComponent.identifier.id
	 * =
	 * self.innerProvidingRole.encapsulatedRole.providingComponent.identifier.id
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean InnerContainingComponentEqualOuterProvidingComponent(DiagnosticChain diagnostics, Map context);

} // ProvidedDelegationConnector