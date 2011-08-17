/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost#getProcessingresourcespecification <em>Processingresourcespecification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getProcessingResourceCost()
 * @model abstract="true"
 * @generated
 */
public interface ProcessingResourceCost extends Cost {
	/**
	 * Returns the value of the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processingresourcespecification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processingresourcespecification</em>' reference.
	 * @see #setProcessingresourcespecification(ProcessingResourceSpecification)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getProcessingResourceCost_Processingresourcespecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getProcessingresourcespecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost#getProcessingresourcespecification <em>Processingresourcespecification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processingresourcespecification</em>' reference.
	 * @see #getProcessingresourcespecification()
	 * @generated
	 */
	void setProcessingresourcespecification(ProcessingResourceSpecification value);

} // ProcessingResourceCost
