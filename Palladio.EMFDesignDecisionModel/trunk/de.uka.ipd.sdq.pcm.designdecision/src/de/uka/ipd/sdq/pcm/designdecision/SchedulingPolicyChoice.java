/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Policy Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice#getChosenValue <em>Chosen Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getSchedulingPolicyChoice()
 * @model
 * @generated
 */
public interface SchedulingPolicyChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Chosen Value</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Value</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy
	 * @see #setChosenValue(SchedulingPolicy)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getSchedulingPolicyChoice_ChosenValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SchedulingPolicy getChosenValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice#getChosenValue <em>Chosen Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Value</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy
	 * @see #getChosenValue()
	 * @generated
	 */
	void setChosenValue(SchedulingPolicy value);

} // SchedulingPolicyChoice
