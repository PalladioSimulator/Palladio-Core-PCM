/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.repository.DelegationConnector;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A SourceDelegationConnector delegates outgoing events of encapsulated assembly contexts to an external souce role of the enclosing assembly context.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getInnerSourceRole__SourceRole <em>Inner Source Role Source Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getOuterSourceRole__SourceRole <em>Outer Source Role Source Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getAssemblyContext__SourceDelegationConnector <em>Assembly Context Source Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure__SourceDelegationConnector <em>Parent Structure Source Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector()
 * @model
 * @generated
 */
public interface SourceDelegationConnector extends DelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Inner Source Role Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Source Role Source Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Source Role Source Role</em>' reference.
	 * @see #setInnerSourceRole__SourceRole(SourceRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector_InnerSourceRole__SourceRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SourceRole getInnerSourceRole__SourceRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getInnerSourceRole__SourceRole <em>Inner Source Role Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Source Role Source Role</em>' reference.
	 * @see #getInnerSourceRole__SourceRole()
	 * @generated
	 */
	void setInnerSourceRole__SourceRole(SourceRole value);

	/**
	 * Returns the value of the '<em><b>Outer Source Role Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Source Role Source Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Source Role Source Role</em>' reference.
	 * @see #setOuterSourceRole__SourceRole(SourceRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector_OuterSourceRole__SourceRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SourceRole getOuterSourceRole__SourceRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getOuterSourceRole__SourceRole <em>Outer Source Role Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Source Role Source Role</em>' reference.
	 * @see #getOuterSourceRole__SourceRole()
	 * @generated
	 */
	void setOuterSourceRole__SourceRole(SourceRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Source Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Source Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Source Delegation Connector</em>' reference.
	 * @see #setAssemblyContext__SourceDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector_AssemblyContext__SourceDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext__SourceDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getAssemblyContext__SourceDelegationConnector <em>Assembly Context Source Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Source Delegation Connector</em>' reference.
	 * @see #getAssemblyContext__SourceDelegationConnector()
	 * @generated
	 */
	void setAssemblyContext__SourceDelegationConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Source Delegation Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSourceDelegationConnectors__ComposedStructure <em>Source Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Source Delegation Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Source Delegation Connector</em>' container reference.
	 * @see #setParentStructure__SourceDelegationConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector_ParentStructure__SourceDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSourceDelegationConnectors__ComposedStructure
	 * @model opposite="sourceDelegationConnectors__ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure__SourceDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure__SourceDelegationConnector <em>Parent Structure Source Delegation Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Source Delegation Connector</em>' container reference.
	 * @see #getParentStructure__SourceDelegationConnector()
	 * @generated
	 */
	void setParentStructure__SourceDelegationConnector(ComposedStructure value);

} // SourceDelegationConnector
