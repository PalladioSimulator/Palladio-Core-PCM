/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.stoex.Variable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Characterised Variable</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A characterised variable is a special variable which contains a performance abstraction of a data type. It can be transformed in a named reference and a variable characterisation. It has to end always with a variable characterisation type. Examples are "a.NUMBER_OF_ELEMENTS" or "array.STRUCTURE".
 * <!-- end-model-doc -->
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Characterisation Type</b></em>' attribute. The literals are
     * from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType}. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The type of the
     * characterisation of the characterised variable. The type can be any of the varibale
     * characterisation types, i.e., STRUCTURE, NUMBER_OF_ELEMENTS, TYPE, VALUE, or BYTESIZE. <!--
     * end-model-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Characterisation Type</em>' attribute.
     * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
     * @see #getCharacterisationType()
     * @generated
     */
    void setCharacterisationType(VariableCharacterisationType value);

} // CharacterisedVariable
