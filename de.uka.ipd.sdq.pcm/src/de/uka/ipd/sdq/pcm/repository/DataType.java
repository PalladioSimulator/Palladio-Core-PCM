/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This&nbsp;entity&nbsp;represents&nbsp;a&nbsp;data&nbsp;type&nbsp;that&nbsp;can&nbsp;be&nbsp;stored&nbsp;in&nbsp;a&nbsp;repository&nbsp;and&nbsp;used&nbsp;for&nbsp;specification&nbsp;and&nbsp;modeling&nbsp;of&nbsp;interface&nbsp;signatures
 * or component parameters. All valid characterisations of a data type a referenced.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.DataType#getRepository_DataType <em>Repository Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.DataType#getCharacterisationDefinitions_Datatype <em>Characterisation Definitions Datatype</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType()
 * @model abstract="true"
 * @generated
 */
public interface DataType extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Repository Data Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getDatatypes_Repository <em>Datatypes Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property specifies the repository to which this data type belongs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Repository Data Type</em>' container reference.
	 * @see #setRepository_DataType(Repository)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType_Repository_DataType()
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getDatatypes_Repository
	 * @model opposite="datatypes_Repository" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Repository getRepository_DataType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.DataType#getRepository_DataType <em>Repository Data Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Data Type</em>' container reference.
	 * @see #getRepository_DataType()
	 * @generated
	 */
	void setRepository_DataType(Repository value);

	/**
	 * Returns the value of the '<em><b>Characterisation Definitions Datatype</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characterisation Definitions Datatype</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characterisation Definitions Datatype</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType_CharacterisationDefinitions_Datatype()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CharacterisationDefinition> getCharacterisationDefinitions_Datatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.characterisationDefinitions_Datatype.entityName->asSet()->size() = self.characterisationDefinitions_Datatype->size()
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.characterisationDefinitions_Datatype.entityName->asSet()->size() = self.characterisationDefinitions_Datatype->size()'"
	 * @generated
	 */
	boolean DataTypeMustNotHaveAvailableCharacterisationsWithIdenticalNameToBeParsableAsCode(DiagnosticChain diagnostics, Map<Object, Object> context);

} // DataType
