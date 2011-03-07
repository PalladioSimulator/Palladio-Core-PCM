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
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EMOF.Operation#getClass_ <em>Class</em>}</li>
 *   <li>{@link EMOF.Operation#getOwnedParameter <em>Owned Parameter</em>}</li>
 *   <li>{@link EMOF.Operation#getRaisedException <em>Raised Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @see EMOF.EMOFPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends TypedElement, MultiplicityElement {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EMOF.Class#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(EMOF.Class)
	 * @see EMOF.EMOFPackage#getOperation_Class()
	 * @see EMOF.Class#getOwnedOperation
	 * @model opposite="ownedOperation" resolveProxies="false"
	 * @generated
	 */
	EMOF.Class getClass_();

	/**
	 * Sets the value of the '{@link EMOF.Operation#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(EMOF.Class value);

	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link EMOF.Parameter}.
	 * It is bidirectional and its opposite is '{@link EMOF.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see EMOF.EMOFPackage#getOperation_OwnedParameter()
	 * @see EMOF.Parameter#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<Parameter> getOwnedParameter();

	/**
	 * Returns the value of the '<em><b>Raised Exception</b></em>' reference list.
	 * The list contents are of type {@link EMOF.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raised Exception</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raised Exception</em>' reference list.
	 * @see EMOF.EMOFPackage#getOperation_RaisedException()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Type> getRaisedException();

} // Operation
