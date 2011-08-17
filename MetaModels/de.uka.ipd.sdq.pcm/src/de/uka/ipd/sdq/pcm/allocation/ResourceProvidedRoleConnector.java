/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Provided Role Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This abstract class represents all AllocationConnectors that are connected with an entity that provides a ResourceInterface. i. e. a Controller or a Resource. Either it connects from a component (business component or infrastructure component), then the "fromAssemblyContext_AllocationConnector" assocatiation is used, or it connects from a controller, then the "fromControllerInstance_ControllerAllocationConnector" association is used.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getFromControllerInstance_ControllerAllocationConnector <em>From Controller Instance Controller Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getResourceProvidedRoleConnector()
 * @model abstract="true"
 * @generated
 */
public interface ResourceProvidedRoleConnector extends AllocationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Provided Role Resource Provided Role Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Provided Role Resource Provided Role Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Provided Role Resource Provided Role Allocation Connector</em>' reference.
	 * @see #setResourceProvidedRole_ResourceProvidedRoleAllocationConnector(ResourceProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getResourceProvidedRoleConnector_ResourceProvidedRole_ResourceProvidedRoleAllocationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceProvidedRole getResourceProvidedRole_ResourceProvidedRoleAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Provided Role Resource Provided Role Allocation Connector</em>' reference.
	 * @see #getResourceProvidedRole_ResourceProvidedRoleAllocationConnector()
	 * @generated
	 */
	void setResourceProvidedRole_ResourceProvidedRoleAllocationConnector(ResourceProvidedRole value);

	/**
	 * Returns the value of the '<em><b>From Controller Instance Controller Allocation Connector</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getLowerControllerAllocationConnectors_ControllerInstance <em>Lower Controller Allocation Connectors Controller Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Controller Instance Controller Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Controller Instance Controller Allocation Connector</em>' reference.
	 * @see #setFromControllerInstance_ControllerAllocationConnector(ControllerInstance)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getResourceProvidedRoleConnector_FromControllerInstance_ControllerAllocationConnector()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getLowerControllerAllocationConnectors_ControllerInstance
	 * @model opposite="lowerControllerAllocationConnectors_ControllerInstance" ordered="false"
	 * @generated
	 */
	ControllerInstance getFromControllerInstance_ControllerAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector#getFromControllerInstance_ControllerAllocationConnector <em>From Controller Instance Controller Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Controller Instance Controller Allocation Connector</em>' reference.
	 * @see #getFromControllerInstance_ControllerAllocationConnector()
	 * @generated
	 */
	void setFromControllerInstance_ControllerAllocationConnector(ControllerInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.resourceRequiredRole_AllocationConnector.requiredResourceInterface_ResourceRequiredRole = self.resourceProvidedRole_ResourceProvidedRoleAllocationConnector.providedResourceInterface_ResourceProvidedRole
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ReferencedResourceRequiredRoleAndResourceProvidedRoleMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceProvidedRoleConnector
