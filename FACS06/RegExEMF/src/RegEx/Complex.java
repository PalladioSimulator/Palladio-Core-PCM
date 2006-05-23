/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link RegEx.Complex#getRe <em>Re</em>}</li>
 *   <li>{@link RegEx.Complex#getIm <em>Im</em>}</li>
 * </ul>
 * </p>
 *
 * @see RegEx.RegExPackage#getComplex()
 * @model
 * @generated
 */
public interface Complex extends EObject {
	/**
	 * Returns the value of the '<em><b>Re</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Re</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Re</em>' attribute.
	 * @see #setRe(double)
	 * @see RegEx.RegExPackage#getComplex_Re()
	 * @model
	 * @generated
	 */
	double getRe();

	/**
	 * Sets the value of the '{@link RegEx.Complex#getRe <em>Re</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Re</em>' attribute.
	 * @see #getRe()
	 * @generated
	 */
	void setRe(double value);

	/**
	 * Returns the value of the '<em><b>Im</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Im</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Im</em>' attribute.
	 * @see #setIm(double)
	 * @see RegEx.RegExPackage#getComplex_Im()
	 * @model
	 * @generated
	 */
	double getIm();

	/**
	 * Sets the value of the '{@link RegEx.Complex#getIm <em>Im</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Im</em>' attribute.
	 * @see #getIm()
	 * @generated
	 */
	void setIm(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double abs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double phase();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Complex plus(Complex b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Complex minus(Complex b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Complex times(Complex b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Complex conjugate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Complex reciprocal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Complex divides(Complex b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Complex plus(Complex a, Complex b);

} // Complex