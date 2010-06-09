/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.repository.DelegationConnector;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sink Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A SinkDelegationConnector delegates an incoming event to the encapsulated assembly contexts to inner sink roles.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getInnerSinkRole__SinkDelegationConnector <em>Inner Sink Role Sink Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getOuterSinkRole__SinkDelegationConnector <em>Outer Sink Role Sink Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getAssemblyContext__SinkDelegationConnector <em>Assembly Context Sink Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getParentStructure_SinkDelegationConnector <em>Parent Structure Sink Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSinkDelegationConnector()
 * @model
 * @generated
 */
public interface SinkDelegationConnector extends DelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Inner Sink Role Sink Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Sink Role Sink Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Sink Role Sink Delegation Connector</em>' reference.
	 * @see #setInnerSinkRole__SinkDelegationConnector(SinkRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSinkDelegationConnector_InnerSinkRole__SinkDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SinkRole getInnerSinkRole__SinkDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getInnerSinkRole__SinkDelegationConnector <em>Inner Sink Role Sink Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Sink Role Sink Delegation Connector</em>' reference.
	 * @see #getInnerSinkRole__SinkDelegationConnector()
	 * @generated
	 */
	void setInnerSinkRole__SinkDelegationConnector(SinkRole value);

	/**
	 * Returns the value of the '<em><b>Outer Sink Role Sink Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Sink Role Sink Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Sink Role Sink Delegation Connector</em>' reference.
	 * @see #setOuterSinkRole__SinkDelegationConnector(SinkRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSinkDelegationConnector_OuterSinkRole__SinkDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SinkRole getOuterSinkRole__SinkDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getOuterSinkRole__SinkDelegationConnector <em>Outer Sink Role Sink Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Sink Role Sink Delegation Connector</em>' reference.
	 * @see #getOuterSinkRole__SinkDelegationConnector()
	 * @generated
	 */
	void setOuterSinkRole__SinkDelegationConnector(SinkRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Sink Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Sink Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Sink Delegation Connector</em>' reference.
	 * @see #setAssemblyContext__SinkDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSinkDelegationConnector_AssemblyContext__SinkDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext__SinkDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getAssemblyContext__SinkDelegationConnector <em>Assembly Context Sink Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Sink Delegation Connector</em>' reference.
	 * @see #getAssemblyContext__SinkDelegationConnector()
	 * @generated
	 */
	void setAssemblyContext__SinkDelegationConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Sink Delegation Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSinkDelegationConnectors__ComposedStructure <em>Sink Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Sink Delegation Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Sink Delegation Connector</em>' container reference.
	 * @see #setParentStructure_SinkDelegationConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getSinkDelegationConnector_ParentStructure_SinkDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSinkDelegationConnectors__ComposedStructure
	 * @model opposite="sinkDelegationConnectors__ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure_SinkDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getParentStructure_SinkDelegationConnector <em>Parent Structure Sink Delegation Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Sink Delegation Connector</em>' container reference.
	 * @see #getParentStructure_SinkDelegationConnector()
	 * @generated
	 */
	void setParentStructure_SinkDelegationConnector(ComposedStructure value);

} // SinkDelegationConnector
