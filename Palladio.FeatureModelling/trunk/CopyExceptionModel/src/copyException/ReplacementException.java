/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package copyException;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replacement Exception</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link copyException.ReplacementException#getObj <em>Obj</em>}</li>
 * </ul>
 * </p>
 *
 * @see copyException.CopyExceptionPackage#getReplacementException()
 * @model
 * @generated
 */
public interface ReplacementException extends copyException.Exception {
	/**
	 * Returns the value of the '<em><b>Obj</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj</em>' reference.
	 * @see #setObj(EClassifier)
	 * @see copyException.CopyExceptionPackage#getReplacementException_Obj()
	 * @model
	 * @generated
	 */
	EClassifier getObj();

	/**
	 * Sets the value of the '{@link copyException.ReplacementException#getObj <em>Obj</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj</em>' reference.
	 * @see #getObj()
	 * @generated
	 */
	void setObj(EClassifier value);

} // ReplacementException
