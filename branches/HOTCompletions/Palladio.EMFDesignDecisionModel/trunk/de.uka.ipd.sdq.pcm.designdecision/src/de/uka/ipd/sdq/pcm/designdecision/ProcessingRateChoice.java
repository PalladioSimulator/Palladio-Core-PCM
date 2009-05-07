/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Rate Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: constraint: works only for ProcessingRateDecisions. chosenRate must be within the defined range. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice#getChosenRate <em>Chosen Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingRateChoice()
 * @model
 * @generated
 */
public interface ProcessingRateChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Chosen Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Rate</em>' attribute.
	 * @see #setChosenRate(double)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProcessingRateChoice_ChosenRate()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getChosenRate();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice#getChosenRate <em>Chosen Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Rate</em>' attribute.
	 * @see #getChosenRate()
	 * @generated
	 */
	void setChosenRate(double value);

} // ProcessingRateChoice
