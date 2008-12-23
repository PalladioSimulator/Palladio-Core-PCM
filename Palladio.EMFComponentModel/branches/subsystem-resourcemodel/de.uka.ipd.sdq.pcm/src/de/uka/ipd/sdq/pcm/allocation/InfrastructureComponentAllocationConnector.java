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
 * An AllocationConnector is being used to explicitly connect the ResourceRequiredRole of an allocated component to another allocated component, which serves as an infrastructure component, such as middleware.
 * If no AllocationConnector is specified for an ResourceRequiredRole, before analysis the connectors have to be created automatically. This means that deployed infrastructure components or controllers are being checked if a corresponding ResourceInterface is provided.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getProvidedRole_AllocationConnector <em>Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}</li>
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
	 * @model required="true" volatile="true" derived="true" ordered="false"
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
	 * Returns the value of the '<em><b>Infrastructure Component Scope Infrastructure Component Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>' reference.
	 * @see #setInfrastructureComponentScope_InfrastructureComponentAllocationConnector(InfrastructureComponentScope)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentAllocationConnector_InfrastructureComponentScope_InfrastructureComponentAllocationConnector()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	InfrastructureComponentScope getInfrastructureComponentScope_InfrastructureComponentAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector#getInfrastructureComponentScope_InfrastructureComponentAllocationConnector <em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infrastructure Component Scope Infrastructure Component Allocation Connector</em>' reference.
	 * @see #getInfrastructureComponentScope_InfrastructureComponentAllocationConnector()
	 * @generated
	 */
	void setInfrastructureComponentScope_InfrastructureComponentAllocationConnector(InfrastructureComponentScope value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.assemblyContext_AllocationConnector.encapsulatedComponent_AssemblyContext.providedRoles_InterfaceProvidingEntity->includes(self.providedRole_AllocationConnector)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context);

} // InfrastructureComponentAllocationConnector
