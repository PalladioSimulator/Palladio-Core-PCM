/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EMOF.Factory#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see EMOF.EMOFPackage#getFactory()
 * @model
 * @generated
 */
public interface Factory extends Element {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see #setPackage(EMOF.Package)
	 * @see EMOF.EMOFPackage#getFactory_Package()
	 * @model required="true"
	 * @generated
	 */
	EMOF.Package getPackage();

	/**
	 * Sets the value of the '{@link EMOF.Factory#getPackage <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(EMOF.Package value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="EMOF.String"
	 * @generated
	 */
	String convertToString(DataType dataType, EMOF.Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Element create(EMOF.Class metaClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model stringDataType="EMOF.String"
	 * @generated
	 */
	EMOF.Object createFromString(DataType dataType, String string);

} // Factory
