/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package copyException;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deletion Exception</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link copyException.DeletionException#getObject <em>Object</em>}</li>
 *   <li>{@link copyException.DeletionException#getOcle <em>Ocle</em>}</li>
 * </ul>
 * </p>
 *
 * @see copyException.CopyExceptionPackage#getDeletionException()
 * @model
 * @generated
 */
public interface DeletionException extends copyException.Exception {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EClass)
	 * @see copyException.CopyExceptionPackage#getDeletionException_Object()
	 * @model
	 * @generated
	 */
	EClass getObject();

	/**
	 * Sets the value of the '{@link copyException.DeletionException#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EClass value);

	/**
	 * Returns the value of the '<em><b>Ocle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocle</em>' attribute.
	 * @see #setOcle(String)
	 * @see copyException.CopyExceptionPackage#getDeletionException_Ocle()
	 * @model
	 * @generated
	 */
	String getOcle();

	/**
	 * Sets the value of the '{@link copyException.DeletionException#getOcle <em>Ocle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocle</em>' attribute.
	 * @see #getOcle()
	 * @generated
	 */
	void setOcle(String value);

} // DeletionException
