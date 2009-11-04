/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inner Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity represent a declaration of a data type inside of a composite data type. It enriches the data type it declares with a name to allow multiple declarations of the same type within a composite data type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration#getDatatype_InnerDeclaration <em>Datatype Inner Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInnerDeclaration()
 * @model
 * @generated
 */
public interface InnerDeclaration extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Datatype Inner Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatype Inner Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the data type that the inner declaration declares.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Datatype Inner Declaration</em>' reference.
	 * @see #setDatatype_InnerDeclaration(DataType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInnerDeclaration_Datatype_InnerDeclaration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getDatatype_InnerDeclaration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration#getDatatype_InnerDeclaration <em>Datatype Inner Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datatype Inner Declaration</em>' reference.
	 * @see #getDatatype_InnerDeclaration()
	 * @generated
	 */
	void setDatatype_InnerDeclaration(DataType value);

} // InnerDeclaration
