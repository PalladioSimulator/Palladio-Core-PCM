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
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getInnerSourceRole__SourceDelegationConnector <em>Inner Source Role Source Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getOuterSourceRole__SourceDelegationConnector <em>Outer Source Role Source Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getAssemblyContext__SourceDelegationConnector <em>Assembly Context Source Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure_SourceDelegationConnector <em>Parent Structure Source Delegation Connector</em>}</li>
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
	 * Returns the value of the '<em><b>Inner Source Role Source Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Source Role Source Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Source Role Source Delegation Connector</em>' reference.
	 * @see #setInnerSourceRole__SourceDelegationConnector(SourceRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector_InnerSourceRole__SourceDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SourceRole getInnerSourceRole__SourceDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getInnerSourceRole__SourceDelegationConnector <em>Inner Source Role Source Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Source Role Source Delegation Connector</em>' reference.
	 * @see #getInnerSourceRole__SourceDelegationConnector()
	 * @generated
	 */
	void setInnerSourceRole__SourceDelegationConnector(SourceRole value);

	/**
	 * Returns the value of the '<em><b>Outer Source Role Source Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Source Role Source Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Source Role Source Delegation Connector</em>' reference.
	 * @see #setOuterSourceRole__SourceDelegationConnector(SourceRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector_OuterSourceRole__SourceDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SourceRole getOuterSourceRole__SourceDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getOuterSourceRole__SourceDelegationConnector <em>Outer Source Role Source Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Source Role Source Delegation Connector</em>' reference.
	 * @see #getOuterSourceRole__SourceDelegationConnector()
	 * @generated
	 */
	void setOuterSourceRole__SourceDelegationConnector(SourceRole value);

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
	 * @see #setParentStructure_SourceDelegationConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSourceDelegationConnector_ParentStructure_SourceDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSourceDelegationConnectors__ComposedStructure
	 * @model opposite="sourceDelegationConnectors__ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure_SourceDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure_SourceDelegationConnector <em>Parent Structure Source Delegation Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Source Delegation Connector</em>' container reference.
	 * @see #getParentStructure_SourceDelegationConnector()
	 * @generated
	 */
	void setParentStructure_SourceDelegationConnector(ComposedStructure value);

} // SourceDelegationConnector
