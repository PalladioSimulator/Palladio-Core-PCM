/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyEventConnector__ComposedStructure <em>Assembly Event Connector Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSinkDelegationConnectors__ComposedStructure <em>Sink Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getSourceDelegationConnectors__ComposedStructure <em>Source Delegation Connectors Composed Structure</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Assembly Event Connector Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getParentStructure__AssemblyEventConnector <em>Parent Structure Assembly Event Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Event Connector Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Event Connector Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_AssemblyEventConnector__ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getParentStructure__AssemblyEventConnector
	 * @model opposite="parentStructure__AssemblyEventConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList<AssemblyEventConnector> getAssemblyEventConnector__ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Sink Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getParentStructure_SinkDelegationConnector <em>Parent Structure Sink Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sink Delegation Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink Delegation Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_SinkDelegationConnectors__ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector#getParentStructure_SinkDelegationConnector
	 * @model opposite="parentStructure_SinkDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList<SinkDelegationConnector> getSinkDelegationConnectors__ComposedStructure();

	/**
	 * Returns the value of the '<em><b>Source Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure_SourceDelegationConnector <em>Parent Structure Source Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Delegation Connectors Composed Structure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Delegation Connectors Composed Structure</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getComposedStructure_SourceDelegationConnectors__ComposedStructure()
	 * @see de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector#getParentStructure_SourceDelegationConnector
	 * @model opposite="parentStructure_SourceDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList<SourceDelegationConnector> getSourceDelegationConnectors__ComposedStructure();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.providedDelegationConnectors_ComposedStructure->forAll( c1, c2 | c1 <> c2 implies c1.outerProvidedRole_ProvidedDelegationConnector <> c2.outerProvidedRole_ProvidedDelegationConnector)
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.providedDelegationConnectors_ComposedStructure->forAll( c1, c2 | c1 <> c2 implies c1.outerProvidedRole_ProvidedDelegationConnector <> c2.outerProvidedRole_ProvidedDelegationConnector)\r\n'"
	 * @generated
	 */
	boolean MultipleConnectorsConstraint(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.assemblyConnectors_ComposedStructure->forAll( c1, c2 | c1 <> c2 implies c1.requiredRole__AssemblyConnector <> c2.requiredRole__AssemblyConnector) 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.assemblyConnectors_ComposedStructure->forAll( c1, c2 | c1 <> c2 implies c1.requiredRole__AssemblyConnector <> c2.requiredRole__AssemblyConnector) '"
	 * @generated
	 */
	boolean MultipleConnectorConstraintForAssembyConnectors(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ComposedStructure
