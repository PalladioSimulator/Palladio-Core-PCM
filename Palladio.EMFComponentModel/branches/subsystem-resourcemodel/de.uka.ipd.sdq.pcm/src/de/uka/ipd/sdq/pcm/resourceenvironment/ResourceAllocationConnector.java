/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceAllocationConnector#getProcessingResourceSpecification_ResourceAllocationConnector <em>Processing Resource Specification Resource Allocation Connector</em>}</li>
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
	 * Returns the value of the '<em><b>Processing Resource Specification Resource Allocation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Resource Specification Resource Allocation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Resource Specification Resource Allocation Connector</em>' reference.
	 * @see #setProcessingResourceSpecification_ResourceAllocationConnector(ProcessingResourceSpecification)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceAllocationConnector_ProcessingResourceSpecification_ResourceAllocationConnector()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getProcessingResourceSpecification_ResourceAllocationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceAllocationConnector#getProcessingResourceSpecification_ResourceAllocationConnector <em>Processing Resource Specification Resource Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Resource Specification Resource Allocation Connector</em>' reference.
	 * @see #getProcessingResourceSpecification_ResourceAllocationConnector()
	 * @generated
	 */
	void setProcessingResourceSpecification_ResourceAllocationConnector(ProcessingResourceSpecification value);

} // ResourceAllocationConnector
