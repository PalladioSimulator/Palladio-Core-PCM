/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Continous Range Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The ContinuousRange represents a choice for a DegreeOfFreedom with a continuous domain.
 * 
 * 
 * TODO constraint:  The degreeOfFreedom of this Choice must be an ContinuousRangeDegree
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice#getChosenValue <em>Chosen Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getContinousRangeChoice()
 * @model
 * @generated
 */
public interface ContinousRangeChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Chosen Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The double value chosen from the range of the DegreeOfFreedom. 
	 * 
	 * TODO: constraint: chosenValue must be within the defined range. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Chosen Value</em>' attribute.
	 * @see #setChosenValue(double)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getContinousRangeChoice_ChosenValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getChosenValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice#getChosenValue <em>Chosen Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Value</em>' attribute.
	 * @see #getChosenValue()
	 * @generated
	 */
	void setChosenValue(double value);

} // ContinousRangeChoice
