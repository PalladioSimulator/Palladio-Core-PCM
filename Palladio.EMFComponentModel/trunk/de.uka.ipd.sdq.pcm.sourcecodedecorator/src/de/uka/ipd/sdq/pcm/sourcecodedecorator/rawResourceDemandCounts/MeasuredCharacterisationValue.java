/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measured Characterisation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * these measurement values will finally be mapped to EDP2
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue#getRequiredCharacterisation <em>Required Characterisation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getMeasuredCharacterisationValue()
 * @model abstract="true"
 * @generated
 */
public interface MeasuredCharacterisationValue extends Identifier {
	/**
	 * Returns the value of the '<em><b>Required Characterisation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Characterisation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Characterisation</em>' reference.
	 * @see #setRequiredCharacterisation(RequiredCharacterisation)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getMeasuredCharacterisationValue_RequiredCharacterisation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredCharacterisation getRequiredCharacterisation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue#getRequiredCharacterisation <em>Required Characterisation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Characterisation</em>' reference.
	 * @see #getRequiredCharacterisation()
	 * @generated
	 */
	void setRequiredCharacterisation(RequiredCharacterisation value);

} // MeasuredCharacterisationValue
