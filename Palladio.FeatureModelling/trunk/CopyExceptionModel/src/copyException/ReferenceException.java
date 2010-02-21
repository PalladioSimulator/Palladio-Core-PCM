/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package copyException;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Exception</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link copyException.ReferenceException#getO <em>O</em>}</li>
 * </ul>
 * </p>
 *
 * @see copyException.CopyExceptionPackage#getReferenceException()
 * @model
 * @generated
 */
public interface ReferenceException extends copyException.Exception {
	/**
	 * Returns the value of the '<em><b>O</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>O</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>O</em>' reference.
	 * @see #setO(EPackage)
	 * @see copyException.CopyExceptionPackage#getReferenceException_O()
	 * @model
	 * @generated
	 */
	EPackage getO();

	/**
	 * Sets the value of the '{@link copyException.ReferenceException#getO <em>O</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>O</em>' reference.
	 * @see #getO()
	 * @generated
	 */
	void setO(EPackage value);

} // ReferenceException
