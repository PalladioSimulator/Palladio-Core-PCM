/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reflective Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see EMOF.EMOFPackage#getReflectiveSequence()
 * @model
 * @generated
 */
public interface ReflectiveSequence extends ReflectiveCollection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="EMOF.Integer"
	 * @generated
	 */
	void add(Integer index, EMOF.Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="EMOF.Integer"
	 * @generated
	 */
	EMOF.Object get(Integer index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="EMOF.Integer"
	 * @generated
	 */
	EMOF.Object remove(Integer index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexDataType="EMOF.Integer"
	 * @generated
	 */
	EMOF.Object set(Integer index, EMOF.Object object);

} // ReflectiveSequence
