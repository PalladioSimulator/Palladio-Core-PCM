
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.stoex.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterised Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationType <em>Characterisation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCharacterisedVariable()
 * @model
 * @generated
 */
public interface CharacterisedVariable extends Variable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCharacterisedVariable_CharacterisationType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableCharacterisationType getCharacterisationType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationType <em>Characterisation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characterisation Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #getCharacterisationType()
	 * @generated
	 */
	void setCharacterisationType(VariableCharacterisationType value);

} // CharacterisedVariable