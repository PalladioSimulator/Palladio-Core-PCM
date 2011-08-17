/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.repository.DelegationConnector;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity is used to specify how the required resource interfaces of encapsulated components are being conneced to required resource interfaces of an outer component, which is a CompositeComponent.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getParentStructure_ResourceRequiredDelegationConnector <em>Parent Structure Resource Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getInnerResourceRequiredRole_ResourceRequiredDelegationConnector <em>Inner Resource Required Role Resource Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getOuterResourceRequiredRole_ResourceRequiredDelegationConnector <em>Outer Resource Required Role Resource Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getAssemblyContext_ResourceRequiredDelegationConnector <em>Assembly Context Resource Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getResourceRequiredDelegationConnector()
 * @model
 * @generated
 */
public interface ResourceRequiredDelegationConnector extends DelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Parent Structure Resource Required Delegation Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getResourceRequiredDelegationConnectors_ComposedStructure <em>Resource Required Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Resource Required Delegation Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Resource Required Delegation Connector</em>' container reference.
	 * @see #setParentStructure_ResourceRequiredDelegationConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getResourceRequiredDelegationConnector_ParentStructure_ResourceRequiredDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getResourceRequiredDelegationConnectors_ComposedStructure
	 * @model opposite="resourceRequiredDelegationConnectors_ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure_ResourceRequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getParentStructure_ResourceRequiredDelegationConnector <em>Parent Structure Resource Required Delegation Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Resource Required Delegation Connector</em>' container reference.
	 * @see #getParentStructure_ResourceRequiredDelegationConnector()
	 * @generated
	 */
	void setParentStructure_ResourceRequiredDelegationConnector(ComposedStructure value);

	/**
	 * Returns the value of the '<em><b>Inner Resource Required Role Resource Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Resource Required Role Resource Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Resource Required Role Resource Required Delegation Connector</em>' reference.
	 * @see #setInnerResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getResourceRequiredDelegationConnector_InnerResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceRequiredRole getInnerResourceRequiredRole_ResourceRequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getInnerResourceRequiredRole_ResourceRequiredDelegationConnector <em>Inner Resource Required Role Resource Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Resource Required Role Resource Required Delegation Connector</em>' reference.
	 * @see #getInnerResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @generated
	 */
	void setInnerResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole value);

	/**
	 * Returns the value of the '<em><b>Outer Resource Required Role Resource Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Resource Required Role Resource Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Resource Required Role Resource Required Delegation Connector</em>' reference.
	 * @see #setOuterResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getResourceRequiredDelegationConnector_OuterResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceRequiredRole getOuterResourceRequiredRole_ResourceRequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getOuterResourceRequiredRole_ResourceRequiredDelegationConnector <em>Outer Resource Required Role Resource Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Resource Required Role Resource Required Delegation Connector</em>' reference.
	 * @see #getOuterResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @generated
	 */
	void setOuterResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Resource Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Resource Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Resource Required Delegation Connector</em>' reference.
	 * @see #setAssemblyContext_ResourceRequiredDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getResourceRequiredDelegationConnector_AssemblyContext_ResourceRequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_ResourceRequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector#getAssemblyContext_ResourceRequiredDelegationConnector <em>Assembly Context Resource Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Resource Required Delegation Connector</em>' reference.
	 * @see #getAssemblyContext_ResourceRequiredDelegationConnector()
	 * @generated
	 */
	void setAssemblyContext_ResourceRequiredDelegationConnector(AssemblyContext value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.parentStructure_ResourceRequiredDelegationConnector = self.assemblyContext_ResourceRequiredDelegationConnector.parentStructure_AssemblyContext
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.innerResourceRequiredRole_ResourceRequiredDelegationConnector.resourceRequiringEntity_ResourceRequiredRole = self.assemblyContext_ResourceRequiredDelegationConnector.encapsulatedComponent_AssemblyContext
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceRequiredDelegationConnector