/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Characterisation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Variable&nbsp;characterisations&nbsp;store&nbsp;performance&nbsp;critical&nbsp;meta-information&nbsp;on&nbsp;a&nbsp;variable.
 *     The value of a characterisation is stored in the reference&nbsp;to the PCMRandomVariable.
 * </p>
 * <p>
 *     For&nbsp;example,&nbsp;if&nbsp;a&nbsp;variable's&nbsp;value&nbsp;is&nbsp;used&nbsp;in&nbsp;a&nbsp;long&nbsp;running&nbsp;loop,&nbsp;the&nbsp;value&nbsp;of&nbsp;the&nbsp;variable&nbsp;is&nbsp;performance&nbsp;critical.&nbsp;<br />
 *     For&nbsp;example,&nbsp;in&nbsp;"a.NUMBER_OF_ELEMENTS=10"&nbsp;the&nbsp;a&nbsp;is&nbsp;the&nbsp;name&nbsp;of&nbsp;the&nbsp;variable,&nbsp;NUMBER_OF_ELEMENTS&nbsp;is&nbsp;the&nbsp;name
 *     of the
 *     characterisation&nbsp;type&nbsp;and&nbsp;"10"&nbsp;would&nbsp;be&nbsp;the&nbsp;specification&nbsp;(as&nbsp;PCMRandomVariable)&nbsp;of&nbsp;the&nbsp;characterisation's&nbsp;value.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation <em>Specification Variable Characterisation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation <em>Variable Usage Variable Characterisation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation()
 * @model
 * @generated
 */
public interface VariableCharacterisation extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type specifies the kind of the variable characterisation. There are 5 types available: STRUCTURE, NUMBER_OF_ELEMENTS, VALUE, BYTESIZE, and TYPE.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(CharacterisationDefinition)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CharacterisationDefinition getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(CharacterisationDefinition value);

	/**
	 * Returns the value of the '<em><b>Specification Variable Characterisation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getVariableCharacterisation_Specification <em>Variable Characterisation Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Variable Characterisation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specification contains the value of a variable characterisation. It is a stoachastic expression which may also contain references to other variable characterisations (that is the reason why it is a PCMRandomVariable). 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specification Variable Characterisation</em>' containment reference.
	 * @see #setSpecification_VariableCharacterisation(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation_Specification_VariableCharacterisation()
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getVariableCharacterisation_Specification
	 * @model opposite="variableCharacterisation_Specification" containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getSpecification_VariableCharacterisation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation <em>Specification Variable Characterisation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Variable Characterisation</em>' containment reference.
	 * @see #getSpecification_VariableCharacterisation()
	 * @generated
	 */
	void setSpecification_VariableCharacterisation(PCMRandomVariable value);

	/**
	 * Returns the value of the '<em><b>Variable Usage Variable Characterisation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Usage Variable Characterisation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Usage Variable Characterisation</em>' container reference.
	 * @see #setVariableUsage_VariableCharacterisation(SetVariable)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisation_VariableUsage_VariableCharacterisation()
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getVariableCharacterisation_VariableUsage
	 * @model opposite="variableCharacterisation_VariableUsage" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SetVariable getVariableUsage_VariableCharacterisation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getVariableUsage_VariableCharacterisation <em>Variable Usage Variable Characterisation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Usage Variable Characterisation</em>' container reference.
	 * @see #getVariableUsage_VariableCharacterisation()
	 * @generated
	 */
	void setVariableUsage_VariableCharacterisation(SetVariable value);

} // VariableCharacterisation
