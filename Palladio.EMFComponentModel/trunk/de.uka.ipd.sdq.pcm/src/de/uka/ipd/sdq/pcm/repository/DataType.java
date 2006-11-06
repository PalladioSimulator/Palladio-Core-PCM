
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.DataType#getParentDataType__DataType <em>Parent Data Type Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.DataType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Parent Data Type Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Data Type Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Data Type Data Type</em>' reference.
	 * @see #setParentDataType__DataType(DataType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType_ParentDataType__DataType()
	 * @model ordered="false"
	 * @generated
	 */
	DataType getParentDataType__DataType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.DataType#getParentDataType__DataType <em>Parent Data Type Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Data Type Data Type</em>' reference.
	 * @see #getParentDataType__DataType()
	 * @generated
	 */
	void setParentDataType__DataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.DataType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // DataType