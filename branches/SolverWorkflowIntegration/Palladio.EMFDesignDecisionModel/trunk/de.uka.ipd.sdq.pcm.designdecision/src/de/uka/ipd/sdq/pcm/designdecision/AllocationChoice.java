/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: constraint: works only for AllocationDecisions
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.AllocationChoice#getChosenresourcecontainer <em>Chosenresourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAllocationChoice()
 * @model
 * @generated
 */
public interface AllocationChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Chosenresourcecontainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosenresourcecontainer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosenresourcecontainer</em>' reference.
	 * @see #setChosenresourcecontainer(ResourceContainer)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAllocationChoice_Chosenresourcecontainer()
	 * @model ordered="false"
	 * @generated
	 */
	ResourceContainer getChosenresourcecontainer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationChoice#getChosenresourcecontainer <em>Chosenresourcecontainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosenresourcecontainer</em>' reference.
	 * @see #getChosenresourcecontainer()
	 * @generated
	 */
	void setChosenresourcecontainer(ResourceContainer value);

} // AllocationChoice
