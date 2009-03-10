/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The CollectionDataType defines Collections of elements with the same data type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType#getInnertype <em>Innertype</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getCollectionDataType()
 * @model
 * @generated
 */
public interface CollectionDataType extends Type {
	/**
	 * Returns the value of the '<em><b>Innertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property InnerType defines type of members of collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Innertype</em>' reference.
	 * @see #setInnertype(Type)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getCollectionDataType_Innertype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Type getInnertype();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType#getInnertype <em>Innertype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Innertype</em>' reference.
	 * @see #getInnertype()
	 * @generated
	 */
	void setInnertype(Type value);

} // CollectionDataType
