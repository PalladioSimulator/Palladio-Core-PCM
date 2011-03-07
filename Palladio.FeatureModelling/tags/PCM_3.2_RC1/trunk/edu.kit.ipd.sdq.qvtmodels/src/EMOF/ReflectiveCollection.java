/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reflective Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see EMOF.EMOFPackage#getReflectiveCollection()
 * @model
 * @generated
 */
public interface ReflectiveCollection extends EMOF.Object {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="EMOF.Boolean"
	 * @generated
	 */
	Boolean add(EMOF.Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="EMOF.Boolean"
	 * @generated
	 */
	Boolean addAll(ReflectiveSequence objects);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clear();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="EMOF.Boolean"
	 * @generated
	 */
	Boolean remove(EMOF.Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="EMOF.Integer"
	 * @generated
	 */
	Integer size();

} // ReflectiveCollection
