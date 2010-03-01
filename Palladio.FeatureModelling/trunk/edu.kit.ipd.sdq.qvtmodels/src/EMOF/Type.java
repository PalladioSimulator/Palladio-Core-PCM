/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EMOF.Type#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see EMOF.EMOFPackage#getType()
 * @model abstract="true"
 * @generated
 */
public interface Type extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EMOF.Package#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(EMOF.Package)
	 * @see EMOF.EMOFPackage#getType_Package()
	 * @see EMOF.Package#getOwnedType
	 * @model opposite="ownedType" resolveProxies="false"
	 * @generated
	 */
	EMOF.Package getPackage();

	/**
	 * Sets the value of the '{@link EMOF.Type#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(EMOF.Package value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="EMOF.Boolean"
	 * @generated
	 */
	Boolean isInstance(EMOF.Object object);

} // Type
