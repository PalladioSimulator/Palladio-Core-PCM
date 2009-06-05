
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specified Time Consumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSpecifiedTimeConsumption()
 * @model
 * @generated
 */
public interface SpecifiedTimeConsumption extends RandomVariable {
	/**
	 * Returns the value of the '<em><b>Signature Specified Time Consumption</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Specified Time Consumption</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Specified Time Consumption</em>' reference.
	 * @see #setSignature_SpecifiedTimeConsumption(Signature)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSpecifiedTimeConsumption_Signature_SpecifiedTimeConsumption()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getSignature_SpecifiedTimeConsumption();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature Specified Time Consumption</em>' reference.
	 * @see #getSignature_SpecifiedTimeConsumption()
	 * @generated
	 */
	void setSignature_SpecifiedTimeConsumption(Signature value);

} // SpecifiedTimeConsumption