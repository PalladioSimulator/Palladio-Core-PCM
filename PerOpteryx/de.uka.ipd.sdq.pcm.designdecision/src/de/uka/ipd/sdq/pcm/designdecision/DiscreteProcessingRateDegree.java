/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Discrete Processing Rate Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree#getNumberOfSteps <em>Number Of Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDiscreteProcessingRateDegree()
 * @model
 * @generated
 */
public interface DiscreteProcessingRateDegree extends DiscreteRangeDegree, ProcessingRateDegree {
	/**
	 * Returns the value of the '<em><b>Number Of Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Steps</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Steps</em>' attribute.
	 * @see #setNumberOfSteps(int)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDiscreteProcessingRateDegree_NumberOfSteps()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNumberOfSteps();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree#getNumberOfSteps <em>Number Of Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Steps</em>' attribute.
	 * @see #getNumberOfSteps()
	 * @generated
	 */
	void setNumberOfSteps(int value);

} // DiscreteProcessingRateDegree
