/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: constraint: works only for AssembledComponentDecisions
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ComponentChoice#getChosenrepositorycomponent <em>Chosenrepositorycomponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getComponentChoice()
 * @model
 * @generated
 */
public interface ComponentChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Chosenrepositorycomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosenrepositorycomponent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosenrepositorycomponent</em>' reference.
	 * @see #setChosenrepositorycomponent(RepositoryComponent)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getComponentChoice_Chosenrepositorycomponent()
	 * @model ordered="false"
	 * @generated
	 */
	RepositoryComponent getChosenrepositorycomponent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ComponentChoice#getChosenrepositorycomponent <em>Chosenrepositorycomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosenrepositorycomponent</em>' reference.
	 * @see #getChosenrepositorycomponent()
	 * @generated
	 */
	void setChosenrepositorycomponent(RepositoryComponent value);

} // ComponentChoice
