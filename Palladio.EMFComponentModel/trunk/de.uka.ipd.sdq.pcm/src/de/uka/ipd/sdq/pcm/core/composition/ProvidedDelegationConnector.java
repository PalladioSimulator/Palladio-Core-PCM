/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.repository.DelegationConnector;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getAssemblyContext_ProvidedDelegationConnector <em>Assembly Context Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getParentStructure_ProvidedDelegationConnector <em>Parent Structure Provided Delegation Connector</em>}</li>
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
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * Returns the value of the '<em><b>Assembly Context Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Provided Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Provided Delegation Connector</em>' reference.
	 * @see #setAssemblyContext_ProvidedDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getProvidedDelegationConnector_AssemblyContext_ProvidedDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_ProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getAssemblyContext_ProvidedDelegationConnector <em>Assembly Context Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Provided Delegation Connector</em>' reference.
	 * @see #getAssemblyContext_ProvidedDelegationConnector()
	 * @generated
	 */
	void setAssemblyContext_ProvidedDelegationConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Provided Delegation Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Provided Delegation Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Provided Delegation Connector</em>' container reference.
	 * @see #setParentStructure_ProvidedDelegationConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getProvidedDelegationConnector_ParentStructure_ProvidedDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getProvidedDelegationConnectors_ComposedStructure
	 * @model opposite="providedDelegationConnectors_ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure_ProvidedDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getParentStructure_ProvidedDelegationConnector <em>Parent Structure Provided Delegation Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Provided Delegation Connector</em>' container reference.
	 * @see #getParentStructure_ProvidedDelegationConnector()
	 * @generated
	 */
	void setParentStructure_ProvidedDelegationConnector(ComposedStructure value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.parentStructure_ProvidedDelegationConnector = self.assemblyContext_ProvidedDelegationConnector.parentStructure_AssemblyContext
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.innerProvidedRole_ProvidedDelegationConnector.providingEntity_ProvidedRole = self.assemblyContext_ProvidedDelegationConnector.encapsulatedComponent_AssemblyContext
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ProvidedDelegationConnector
