/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.ProcessingResourceUsage#getProcessingResource <em>Processing Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getProcessingResourceUsage()
 * @model
 * @generated
 */
public interface ProcessingResourceUsage extends ResourceUsage {
	/**
	 * Returns the value of the '<em><b>Processing Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Resource</em>' reference.
	 * @see #setProcessingResource(ProcessingResource)
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getProcessingResourceUsage_ProcessingResource()
	 * @model required="true"
	 * @generated
	 */
	ProcessingResource getProcessingResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.resourcemodel.ProcessingResourceUsage#getProcessingResource <em>Processing Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Resource</em>' reference.
	 * @see #getProcessingResource()
	 * @generated
	 */
	void setProcessingResource(ProcessingResource value);

} // ProcessingResourceUsage