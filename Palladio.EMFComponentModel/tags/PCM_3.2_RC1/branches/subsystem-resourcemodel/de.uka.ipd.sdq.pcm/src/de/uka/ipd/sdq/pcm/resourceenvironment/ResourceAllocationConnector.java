/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ResourceAllocationConnector is a special AllocationConnector which connects a component ("fromAssemblyContext_AllocationConnector") or controller ("fromControllerInstance_ControllerAllocationConnector") with a processing resource ("toProcessingResourceSpecification_ResourceAllocationConnector").
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceAllocationConnector#getToProcessingResourceSpecification_ResourceAllocationConnector <em>To Processing Resource Specification Resource Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceAllocationConnector()
 * @model
 * @generated
 */
public interface ResourceAllocationConnector extends ResourceProvidedRoleConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>To Processing Resource Specification Resource Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Processing Resource Specification Resource Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Processing Resource Specification Resource Allocation Connector</em>' reference.
	 * @see #setToProcessingResourceSpecification_ResourceAllocationConnector(ProcessingResourceSpecification)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceAllocationConnector_ToProcessingResourceSpecification_ResourceAllocationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getToProcessingResourceSpecification_ResourceAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceAllocationConnector#getToProcessingResourceSpecification_ResourceAllocationConnector <em>To Processing Resource Specification Resource Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Processing Resource Specification Resource Allocation Connector</em>' reference.
	 * @see #getToProcessingResourceSpecification_ResourceAllocationConnector()
	 * @generated
	 */
	void setToProcessingResourceSpecification_ResourceAllocationConnector(ProcessingResourceSpecification value);

} // ResourceAllocationConnector
