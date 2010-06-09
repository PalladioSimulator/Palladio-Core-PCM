/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.stoex.StoExVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Characteristic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A characterised variable is a special variable which contains a performance abstraction of a data type. It can be transformed in a named reference and a variable characterisation. It has to end always with a variable characterisation type. Examples are "a.NUMBER_OF_ELEMENTS" or "array.STRUCTURE".
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getCharacterisationDefinition__VariableCharacteristic <em>Characterisation Definition Variable Characteristic</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getVariable__VariableCharacteristic <em>Variable Variable Characteristic</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacteristic()
 * @model
 * @generated
 */
public interface VariableCharacteristic extends StoExVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Characterisation Definition Variable Characteristic</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characterisation Definition Variable Characteristic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characterisation Definition Variable Characteristic</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #setCharacterisationDefinition__VariableCharacteristic(VariableCharacterisationType)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacteristic_CharacterisationDefinition__VariableCharacteristic()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableCharacterisationType getCharacterisationDefinition__VariableCharacteristic();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getCharacterisationDefinition__VariableCharacteristic <em>Characterisation Definition Variable Characteristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characterisation Definition Variable Characteristic</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #getCharacterisationDefinition__VariableCharacteristic()
	 * @generated
	 */
	void setCharacterisationDefinition__VariableCharacteristic(VariableCharacterisationType value);

	/**
	 * Returns the value of the '<em><b>Variable Variable Characteristic</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getVariableCharacteristics__Variable <em>Variable Characteristics Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Variable Characteristic</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Variable Characteristic</em>' container reference.
	 * @see #setVariable__VariableCharacteristic(Variable)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacteristic_Variable__VariableCharacteristic()
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getVariableCharacteristics__Variable
	 * @model opposite="variableCharacteristics__Variable" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Variable getVariable__VariableCharacteristic();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic#getVariable__VariableCharacteristic <em>Variable Variable Characteristic</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Variable Characteristic</em>' container reference.
	 * @see #getVariable__VariableCharacteristic()
	 * @generated
	 */
	void setVariable__VariableCharacteristic(Variable value);

} // VariableCharacteristic
