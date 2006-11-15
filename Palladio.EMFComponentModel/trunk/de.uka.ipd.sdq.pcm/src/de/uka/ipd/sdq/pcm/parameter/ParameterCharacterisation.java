
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterisation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.ParameterCharacterisation#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getParameterCharacterisation()
 * @model
 * @generated
 */
public interface ParameterCharacterisation extends RandomVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.ParameterCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterCharacterisationType
	 * @see #setType(ParameterCharacterisationType)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getParameterCharacterisation_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ParameterCharacterisationType getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.ParameterCharacterisation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterCharacterisationType
	 * @see #getType()
	 * @generated
	 */
	void setType(ParameterCharacterisationType value);

} // ParameterCharacterisation