/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Component Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An InfrastructureComponentAllocationConnector is a special AllocationConnector which connects a component ("fromAssemblyContext_AllocationConnector") with an InfrastructureComponentScope.
 * The "from" component can be a business component or a component which is encapsulated into another InfrastructureComponentScope.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getProvidedRole_AllocationConnector <em>Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentAllocationConnector()
 * @model
 * @generated
 */
public interface InfrastructureComponentAllocationConnector extends Connector, AllocationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Provided Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Role Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Role Allocation Connector</em>' reference.
	 * @see #setProvidedRole_AllocationConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentAllocationConnector_ProvidedRole_AllocationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getProvidedRole_AllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getProvidedRole_AllocationConnector <em>Provided Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Role Allocation Connector</em>' reference.
	 * @see #getProvidedRole_AllocationConnector()
	 * @generated
	 */
	void setProvidedRole_AllocationConnector(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>To Infrastructure Component Scope Infrastructure Component Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>' reference.
	 * @see #setToInfrastructureComponentScope_InfrastructureComponentAllocationConnector(InfrastructureComponentScope)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentAllocationConnector_ToInfrastructureComponentScope_InfrastructureComponentAllocationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InfrastructureComponentScope getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Infrastructure Component Scope Infrastructure Component Allocation Connector</em>' reference.
	 * @see #getToInfrastructureComponentScope_InfrastructureComponentAllocationConnector()
	 * @generated
	 */
	void setToInfrastructureComponentScope_InfrastructureComponentAllocationConnector(InfrastructureComponentScope value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.fromAssemblyContext_AllocationConnector.encapsulatedComponent_AssemblyContext.resourceRequiredRoles_ResourceInterfaceRequiringEntity->exists(role|role.requiredResourceInterface_ResourceRequiredRole = self.resourceRequiredRole_AllocationConnector.requiredResourceInterface_ResourceRequiredRole)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ChildContextContainsRoleWithReferencedInterface(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.fromAssemblyContext_AllocationConnector->size() = 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean FromAssemblyContextHasToBeSet(DiagnosticChain diagnostics, Map<Object, Object> context);

} // InfrastructureComponentAllocationConnector
