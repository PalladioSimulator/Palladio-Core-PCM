
/**
 * <copyright>
 * </copyright>
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
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Datatype Inner Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatype Inner Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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