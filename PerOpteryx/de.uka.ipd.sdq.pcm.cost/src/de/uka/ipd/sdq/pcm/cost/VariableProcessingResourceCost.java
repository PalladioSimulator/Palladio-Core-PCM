/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Term;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Processing Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * VariableProcessingResourceCost are attached to ProcessingResourceSpecification. They derive the operating cost and inital cost based on the processingRate of the resource, as defined in the processing rate (operating or initial) cost function. Use the variable procRate.VALUE to refer to the processing rate in the expression. Additionally, the fixed initial costs as specified in VariableCost are added to the respective cost.
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFunction <em>Processing Rate Initial Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFunction <em>Processing Rate Operating Function</em>}</li>
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
	 * Returns the value of the '<em><b>Processing Rate Initial Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Rate Initial Function</em>' containment reference.
	 * @see #setProcessingRateInitialFunction(ScalarFunction)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableProcessingResourceCost_ProcessingRateInitialFunction()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScalarFunction getProcessingRateInitialFunction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFunction <em>Processing Rate Initial Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Rate Initial Function</em>' containment reference.
	 * @see #getProcessingRateInitialFunction()
	 * @generated
	 */
	void setProcessingRateInitialFunction(ScalarFunction value);

	/**
	 * Returns the value of the '<em><b>Processing Rate Operating Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Rate Operating Function</em>' containment reference.
	 * @see #setProcessingRateOperatingFunction(ScalarFunction)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableProcessingResourceCost_ProcessingRateOperatingFunction()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScalarFunction getProcessingRateOperatingFunction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFunction <em>Processing Rate Operating Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Rate Operating Function</em>' containment reference.
	 * @see #getProcessingRateOperatingFunction()
	 * @generated
	 */
	void setProcessingRateOperatingFunction(ScalarFunction value);

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
