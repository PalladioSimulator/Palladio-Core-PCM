/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.pcm.allocation.AllocationConnector;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Provided Role Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceProvidedRoleConnector#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceProvidedRoleConnector#getRequiringControllerInstance_ControllerAllocationConnector <em>Requiring Controller Instance Controller Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceProvidedRoleConnector()
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
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceProvidedRoleConnector_ResourceProvidedRole_ResourceProvidedRoleAllocationConnector()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ResourceProvidedRole getResourceProvidedRole_ResourceProvidedRoleAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceProvidedRoleConnector#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Provided Role Resource Provided Role Allocation Connector</em>' reference.
	 * @see #getResourceProvidedRole_ResourceProvidedRoleAllocationConnector()
	 * @generated
	 */
	void setResourceProvidedRole_ResourceProvidedRoleAllocationConnector(ResourceProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Requiring Controller Instance Controller Allocation Connector</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getLowerControllerAllocationConnectors_ControllerInstance <em>Lower Controller Allocation Connectors Controller Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Controller Instance Controller Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Controller Instance Controller Allocation Connector</em>' reference.
	 * @see #setRequiringControllerInstance_ControllerAllocationConnector(ControllerInstance)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceProvidedRoleConnector_RequiringControllerInstance_ControllerAllocationConnector()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance#getLowerControllerAllocationConnectors_ControllerInstance
	 * @model opposite="lowerControllerAllocationConnectors_ControllerInstance" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ControllerInstance getRequiringControllerInstance_ControllerAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceProvidedRoleConnector#getRequiringControllerInstance_ControllerAllocationConnector <em>Requiring Controller Instance Controller Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Controller Instance Controller Allocation Connector</em>' reference.
	 * @see #getRequiringControllerInstance_ControllerAllocationConnector()
	 * @generated
	 */
	void setRequiringControllerInstance_ControllerAllocationConnector(ControllerInstance value);

} // ResourceProvidedRoleConnector
