/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composed Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO/FIXME: The distinction between ComposedStructure and ComposedProvidingRequiringStructure does not make sense at the moment, because the ComposedStructure already talks about inner provided / required delegation connectors, which only make sense if there are outer roles for interfaces -> ComposedProvidingRequiringStructure. IDEA: Move the delegation connector attributes to ComposedProvidingRequiringStructure. I'm not sure about the assembly connectors. SEE ALSO: ComposedProvidingRequiringStructure 
 * However, as AssemblyContexts of ComposedStructure always contain InterfaceProvidingRequiringEntities at the moment, the above might not help... -- Anne
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyContexts_ComposedStructure <em>Assembly Contexts Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyConnectors_ComposedStructure <em>Assembly Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getResourceRequiredDelegationConnectors_ComposedStructure <em>Resource Required Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure()
 * @model abstract="true"
 * @generated
 */
public interface ComposedStructure extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Assembly Contexts Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getParentStructure_AssemblyContext <em>Parent Structure Assembly Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Contexts Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Contexts Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_AssemblyContexts_ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyContext#getParentStructure_AssemblyContext
	 * @model opposite="parentStructure_AssemblyContext" containment="true" ordered="false"
	 * @generated
	 */
	EList<AssemblyContext> getAssemblyContexts_ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getParentStructure_ProvidedDelegationConnector <em>Parent Structure Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Delegation Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Delegation Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_ProvidedDelegationConnectors_ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector#getParentStructure_ProvidedDelegationConnector
	 * @model opposite="parentStructure_ProvidedDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList<ProvidedDelegationConnector> getProvidedDelegationConnectors_ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getParentStructure_RequiredDelegationConnector <em>Parent Structure Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Delegation Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Delegation Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_RequiredDelegationConnectors_ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getParentStructure_RequiredDelegationConnector
	 * @model opposite="parentStructure_RequiredDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList<RequiredDelegationConnector> getRequiredDelegationConnectors_ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getParentStructure_AssemblyConnector <em>Parent Structure Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_AssemblyConnectors_ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getParentStructure_AssemblyConnector
	 * @model opposite="parentStructure_AssemblyConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList<AssemblyConnector> getAssemblyConnectors_ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Resource Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getParentStructure_ResourceRequiredDelegationConnector <em>Parent Structure Resource Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Required Delegation Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Required Delegation Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_ResourceRequiredDelegationConnectors_ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getParentStructure_ResourceRequiredDelegationConnector
	 * @model opposite="parentStructure_ResourceRequiredDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceRequiredDelegationConnector> getResourceRequiredDelegationConnectors_ComposedStructure();

} // ComposedStructure
