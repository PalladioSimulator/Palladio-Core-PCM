/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition;
import de.uka.ipd.sdq.stoex.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterised Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A characterised variable is a special variable which contains a performance abstraction of a data type. It can be transformed in a named reference and a variable characterisation. It has to end always with a variable characterisation type. Examples are "a.NUMBER_OF_ELEMENTS" or "array.STRUCTURE".
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationDefinition <em>Characterisation Definition</em>}</li>
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
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(de.uka.ipd.sdq.pcm.parameter.Variable)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCharacterisedVariable_Variable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	de.uka.ipd.sdq.pcm.parameter.Variable getVariable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(de.uka.ipd.sdq.pcm.parameter.Variable value);

	/**
	 * Returns the value of the '<em><b>Characterisation Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characterisation Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characterisation Definition</em>' reference.
	 * @see #setCharacterisationDefinition(CharacterisationDefinition)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCharacterisedVariable_CharacterisationDefinition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CharacterisationDefinition getCharacterisationDefinition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationDefinition <em>Characterisation Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characterisation Definition</em>' reference.
	 * @see #getCharacterisationDefinition()
	 * @generated
	 */
	void setCharacterisationDefinition(CharacterisationDefinition value);

} // CharacterisedVariable
