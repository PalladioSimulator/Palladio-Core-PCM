/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EMOF;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EMOF.Class#getIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link EMOF.Class#getOwnedAttribute <em>Owned Attribute</em>}</li>
 *   <li>{@link EMOF.Class#getOwnedOperation <em>Owned Operation</em>}</li>
 *   <li>{@link EMOF.Class#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see EMOF.EMOFPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Type {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(Boolean)
	 * @see EMOF.EMOFPackage#getClass_IsAbstract()
	 * @model default="false" dataType="EMOF.Boolean"
	 * @generated
	 */
	Boolean getIsAbstract();

	/**
	 * Sets the value of the '{@link EMOF.Class#getIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #getIsAbstract()
	 * @generated
	 */
	void setIsAbstract(Boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link EMOF.Property}.
	 * It is bidirectional and its opposite is '{@link EMOF.Property#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attribute</em>' containment reference list.
	 * @see EMOF.EMOFPackage#getClass_OwnedAttribute()
	 * @see EMOF.Property#getClass_
	 * @model opposite="class" containment="true"
	 * @generated
	 */
	EList<Property> getOwnedAttribute();

	/**
	 * Returns the value of the '<em><b>Owned Operation</b></em>' containment reference list.
	 * The list contents are of type {@link EMOF.Operation}.
	 * It is bidirectional and its opposite is '{@link EMOF.Operation#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operation</em>' containment reference list.
	 * @see EMOF.EMOFPackage#getClass_OwnedOperation()
	 * @see EMOF.Operation#getClass_
	 * @model opposite="class" containment="true"
	 * @generated
	 */
	EList<Operation> getOwnedOperation();

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference list.
	 * The list contents are of type {@link EMOF.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference list.
	 * @see EMOF.EMOFPackage#getClass_SuperClass()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Class> getSuperClass();

} // Class
