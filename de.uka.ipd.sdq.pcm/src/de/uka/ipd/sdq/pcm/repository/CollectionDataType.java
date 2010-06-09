/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This&nbsp;entity&nbsp;represents&nbsp;a&nbsp;collection&nbsp;data&nbsp;type,&nbsp;e.g.,.&nbsp;a&nbsp;list,&nbsp;array,&nbsp;set,&nbsp;of&nbsp;items&nbsp;of&nbsp;the&nbsp;referenced&nbsp;type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CollectionDataType#getDataType_InnerCollectionDataType <em>Data Type Inner Collection Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCollectionDataType()
 * @model
 * @generated
 */
public interface CollectionDataType extends DataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Data Type Inner Collection Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type Inner Collection Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type Inner Collection Data Type</em>' reference.
	 * @see #setDataType_InnerCollectionDataType(DataType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCollectionDataType_DataType_InnerCollectionDataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getDataType_InnerCollectionDataType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CollectionDataType#getDataType_InnerCollectionDataType <em>Data Type Inner Collection Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type Inner Collection Data Type</em>' reference.
	 * @see #getDataType_InnerCollectionDataType()
	 * @generated
	 */
	void setDataType_InnerCollectionDataType(DataType value);

} // CollectionDataType
