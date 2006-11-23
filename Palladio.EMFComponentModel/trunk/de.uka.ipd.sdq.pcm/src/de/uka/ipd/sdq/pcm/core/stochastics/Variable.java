
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics;


import de.uka.ipd.sdq.pcm.parameter.AbstractNamedReference;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.Variable#getId_Variable <em>Id Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.Variable#getCharacterisationType <em>Characterisation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Atom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Id Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Variable</em>' reference.
	 * @see #setId_Variable(AbstractNamedReference)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getVariable_Id_Variable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractNamedReference getId_Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.Variable#getId_Variable <em>Id Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Variable</em>' reference.
	 * @see #getId_Variable()
	 * @generated
	 */
	void setId_Variable(AbstractNamedReference value);

	/**
	 * Returns the value of the '<em><b>Characterisation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characterisation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characterisation Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #setCharacterisationType(VariableCharacterisationType)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getVariable_CharacterisationType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableCharacterisationType getCharacterisationType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.Variable#getCharacterisationType <em>Characterisation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characterisation Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #getCharacterisationType()
	 * @generated
	 */
	void setCharacterisationType(VariableCharacterisationType value);

} // Variable