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
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Choice represents the choice of one value from the domain of a DegreeOfFreedom. The Choice links the DegreeOfFreedom for which it makes the choice. Additionally, it links one element of the domain of the DegreeOfFreedom. This linking is realised in subclasses of Choice, as it may be either PCM Entities or numbers. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.Choice#getDegreeOfFreedom <em>Degree Of Freedom</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getChoice()
 * @model abstract="true"
 * @generated
 */
public interface Choice extends EObject {
	/**
	 * Returns the value of the '<em><b>Degree Of Freedom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degree Of Freedom</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degree Of Freedom</em>' reference.
	 * @see #setDegreeOfFreedom(DegreeOfFreedom)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getChoice_DegreeOfFreedom()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DegreeOfFreedom getDegreeOfFreedom();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.Choice#getDegreeOfFreedom <em>Degree Of Freedom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degree Of Freedom</em>' reference.
	 * @see #getDegreeOfFreedom()
	 * @generated
	 */
	void setDegreeOfFreedom(DegreeOfFreedom value);

} // Choice
