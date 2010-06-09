/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterisation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines a characterisation. An exemplary characterisation is:&nbsp;name BYTESIZE, description 'Size of the data type in
 * memory in bytes', and value type LONG.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition#getValueType <em>Value Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition#getRepository_ChracterisationDefinition <em>Repository Chracterisation Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCharacterisationDefinition()
 * @model
 * @generated
 */
public interface CharacterisationDefinition extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCharacterisationDefinition_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
	 * @see #setValueType(PrimitiveTypeEnum)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCharacterisationDefinition_ValueType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PrimitiveTypeEnum getValueType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(PrimitiveTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Repository Chracterisation Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getCharacterisationDefinitions <em>Characterisation Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Chracterisation Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Chracterisation Definition</em>' container reference.
	 * @see #setRepository_ChracterisationDefinition(Repository)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCharacterisationDefinition_Repository_ChracterisationDefinition()
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getCharacterisationDefinitions
	 * @model opposite="characterisationDefinitions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Repository getRepository_ChracterisationDefinition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition#getRepository_ChracterisationDefinition <em>Repository Chracterisation Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Chracterisation Definition</em>' container reference.
	 * @see #getRepository_ChracterisationDefinition()
	 * @generated
	 */
	void setRepository_ChracterisationDefinition(Repository value);

} // CharacterisationDefinition
