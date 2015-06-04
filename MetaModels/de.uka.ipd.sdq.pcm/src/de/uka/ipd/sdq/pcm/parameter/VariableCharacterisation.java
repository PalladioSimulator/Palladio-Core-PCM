/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Variable Characterisation</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Variable characterisations store performance critical meta-information
 * on a variable. For example, if a variable's value is used in a long running loop, the value of
 * the variable is performance critical. Or as an other example, for Q-Sort it is performancewise
 * important to know how much elements are in a given array and whether the array is sorted or not.
 * Variable characterisations contain a type which tells what kind of meta-information is stored
 * (STRUCTURE, NUMBER_OF_ELEMENTS, ...) and a PCMRandomVariable for storing the value of the
 * characterisation.
 *
 * For example, in "a.NUMBER_OF_ELEMENTS=10" the a is the name of the variable, NUMBER_OF_ELEMENTS
 * is the characterisation type and "10" would be the specification (as PCMRandomVariable) of the
 * characterisation's value. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType <em>Type</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation
 * <em>Specification Variable Characterisation</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation
 * <em>Variable Usage Variable Characterisation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation()
 * @model
 * @generated
 */
public interface VariableCharacterisation extends EObject {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals are from the
     * enumeration {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType}. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The type specifies the kind
     * of the variable characterisation. There are 5 types available: STRUCTURE, NUMBER_OF_ELEMENTS,
     * VALUE, BYTESIZE, and TYPE. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
     * @see #setType(VariableCharacterisationType)
     * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation_Type()
     * @model required="true" ordered="false"
     * @generated
     */
    VariableCharacterisationType getType();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType
     * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
     * @see #getType()
     * @generated
     */
    void setType(VariableCharacterisationType value);

    /**
     * Returns the value of the ' <em><b>Specification Variable Characterisation</b></em>'
     * containment reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getVariableCharacterisation_Specification
     * <em>Variable Characterisation Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * --> <!-- begin-model-doc --> The specification contains the value of a variable
     * characterisation. It is a stoachastic expression which may also contain references to other
     * variable characterisations (that is the reason why it is a PCMRandomVariable). <!--
     * end-model-doc -->
     *
     * @return the value of the ' <em>Specification Variable Characterisation</em>' containment
     *         reference.
     * @see #setSpecification_VariableCharacterisation(PCMRandomVariable)
     * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation_Specification_VariableCharacterisation()
     * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getVariableCharacterisation_Specification
     * @model opposite="variableCharacterisation_Specification" containment="true" required="true"
     *        ordered="false"
     * @generated
     */
    PCMRandomVariable getSpecification_VariableCharacterisation();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation
     * <em>Specification Variable Characterisation</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Specification Variable Characterisation</em>'
     *            containment reference.
     * @see #getSpecification_VariableCharacterisation()
     * @generated
     */
    void setSpecification_VariableCharacterisation(PCMRandomVariable value);

    /**
     * Returns the value of the '<em><b>Variable Usage Variable Characterisation</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getVariableCharacterisation_VariableUsage
     * <em>Variable Characterisation Variable Usage</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Variable Usage Variable Characterisation</em>' container reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Variable Usage Variable Characterisation</em>' container
     *         reference.
     * @see #setVariableUsage_VariableCharacterisation(VariableUsage)
     * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation_VariableUsage_VariableCharacterisation()
     * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getVariableCharacterisation_VariableUsage
     * @model opposite="variableCharacterisation_VariableUsage" transient="false" ordered="false"
     * @generated
     */
    VariableUsage getVariableUsage_VariableCharacterisation();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation
     * <em>Variable Usage Variable Characterisation</em>}' container reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Variable Usage Variable Characterisation</em>' container
     *            reference.
     * @see #getVariableUsage_VariableCharacterisation()
     * @generated
     */
    void setVariableUsage_VariableCharacterisation(VariableUsage value);

} // VariableCharacterisation
