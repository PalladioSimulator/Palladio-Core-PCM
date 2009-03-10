/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The entity PrimitiveDataType specifies the basic data types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getPrimitiveDataType()
 * @model
 * @generated
 */
public interface PrimitiveDataType extends Type {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes
	 * @see #setType(XSDPrimitiveDataTypes)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getPrimitiveDataType_Type()
	 * @model ordered="false"
	 * @generated
	 */
	XSDPrimitiveDataTypes getType();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(XSDPrimitiveDataTypes value);

} // PrimitiveDataType
