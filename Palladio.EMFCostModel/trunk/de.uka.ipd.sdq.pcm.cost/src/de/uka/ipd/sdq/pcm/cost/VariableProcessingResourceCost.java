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
 * A representation of the model object '<em><b>Variable Processing Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: make cost depend on processing rate!
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFactor <em>Processing Rate Initial Factor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFactor <em>Processing Rate Operating Factor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingresourcespecification <em>Processingresourcespecification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableProcessingResourceCost()
 * @model
 * @generated
 */
public interface VariableProcessingResourceCost extends VariableCost {
	/**
	 * Returns the value of the '<em><b>Processing Rate Initial Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Rate Initial Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Rate Initial Factor</em>' attribute.
	 * @see #setProcessingRateInitialFactor(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableProcessingResourceCost_ProcessingRateInitialFactor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getProcessingRateInitialFactor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFactor <em>Processing Rate Initial Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Rate Initial Factor</em>' attribute.
	 * @see #getProcessingRateInitialFactor()
	 * @generated
	 */
	void setProcessingRateInitialFactor(double value);

	/**
	 * Returns the value of the '<em><b>Processing Rate Operating Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Rate Operating Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Rate Operating Factor</em>' attribute.
	 * @see #setProcessingRateOperatingFactor(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableProcessingResourceCost_ProcessingRateOperatingFactor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getProcessingRateOperatingFactor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFactor <em>Processing Rate Operating Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Rate Operating Factor</em>' attribute.
	 * @see #getProcessingRateOperatingFactor()
	 * @generated
	 */
	void setProcessingRateOperatingFactor(double value);

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
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableProcessingResourceCost_Processingresourcespecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getProcessingresourcespecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingresourcespecification <em>Processingresourcespecification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processingresourcespecification</em>' reference.
	 * @see #getProcessingresourcespecification()
	 * @generated
	 */
	void setProcessingresourcespecification(ProcessingResourceSpecification value);

} // VariableProcessingResourceCost
