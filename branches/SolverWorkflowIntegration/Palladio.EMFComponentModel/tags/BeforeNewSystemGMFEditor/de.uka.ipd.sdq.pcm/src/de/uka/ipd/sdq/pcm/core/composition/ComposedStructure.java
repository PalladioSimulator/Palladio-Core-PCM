
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composed Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getChildComponentContexts_ComposedStructure <em>Child Component Contexts Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getCompositeAssemblyConnectors_ComposedStructure <em>Composite Assembly Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure()
 * @model abstract="true"
 * @generated
 */
public interface ComposedStructure extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Child Component Contexts Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Component Contexts Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Component Contexts Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_ChildComponentContexts_ComposedStructure()
	 * @model type="de.uka.ipd.sdq.pcm.core.composition.AssemblyContext" containment="true" ordered="false"
	 * @generated
	 */
	EList getChildComponentContexts_ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Composite Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Assembly Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Assembly Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_CompositeAssemblyConnectors_ComposedStructure()
	 * @model type="de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList getCompositeAssemblyConnectors_ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Delegation Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Delegation Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_ProvidedDelegationConnectors_ComposedStructure()
	 * @model type="de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList getProvidedDelegationConnectors_ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Delegation Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Delegation Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_RequiredDelegationConnectors_ComposedStructure()
	 * @model type="de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList getRequiredDelegationConnectors_ComposedStructure();

} // ComposedStructure