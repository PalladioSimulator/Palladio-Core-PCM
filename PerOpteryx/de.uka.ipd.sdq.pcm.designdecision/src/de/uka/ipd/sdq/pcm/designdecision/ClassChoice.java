/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The EnumerationChoice represents a choice for a DegreeOfFreedom that has a domain of PCM Entities (i.e. a EnumerationDegree). 
 * 
 * TODO constraint:  The degreeOfFreedom of this Choice must be an EnumerationDegree
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ClassChoice#getChosenValue <em>Chosen Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getClassChoice()
 * @model
 * @generated
 */
public interface ClassChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Chosen Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO: constraint: Chosen entity must be in the domain of the EnumerationDegree;
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Chosen Value</em>' reference.
	 * @see #setChosenValue(EObject)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getClassChoice_ChosenValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getChosenValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ClassChoice#getChosenValue <em>Chosen Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Value</em>' reference.
	 * @see #getChosenValue()
	 * @generated
	 */
	void setChosenValue(EObject value);

} // ClassChoice
