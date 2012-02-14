/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Resource Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree#getProcessingresourcetype <em>Processingresourcetype</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingResourceDegree()
 * @model abstract="true"
 * @generated
 */
public interface ProcessingResourceDegree extends DegreeOfFreedomInstance {
	/**
	 * Returns the value of the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processingresourcetype</em>' reference.
	 * @see #setProcessingresourcetype(ProcessingResourceType)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingResourceDegree_Processingresourcetype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceType getProcessingresourcetype();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree#getProcessingresourcetype <em>Processingresourcetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processingresourcetype</em>' reference.
	 * @see #getProcessingresourcetype()
	 * @generated
	 */
	void setProcessingresourcetype(ProcessingResourceType value);

} // ProcessingResourceDegree
