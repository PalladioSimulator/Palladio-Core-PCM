/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Rate Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: Constraint that only works for design decisions that have the domain equivalentComponents of which the assembled component is an element. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision#getProcessingresourcespecification <em>Processingresourcespecification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingRateDecision()
 * @model
 * @generated
 */
public interface ProcessingRateDecision extends DesignDecision {
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
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingRateDecision_Processingresourcespecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getProcessingresourcespecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision#getProcessingresourcespecification <em>Processingresourcespecification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processingresourcespecification</em>' reference.
	 * @see #getProcessingresourcespecification()
	 * @generated
	 */
	void setProcessingresourcespecification(ProcessingResourceSpecification value);

} // ProcessingRateDecision
