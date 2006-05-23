/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distribution Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link RegEx.DistributionFunction#getDistance <em>Distance</em>}</li>
 *   <li>{@link RegEx.DistributionFunction#getPoints <em>Points</em>}</li>
 *   <li>{@link RegEx.DistributionFunction#isIsFourierTransformed <em>Is Fourier Transformed</em>}</li>
 * </ul>
 * </p>
 *
 * @see RegEx.RegExPackage#getDistributionFunction()
 * @model
 * @generated
 */
public interface DistributionFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #setDistance(double)
	 * @see RegEx.RegExPackage#getDistributionFunction_Distance()
	 * @model
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link RegEx.DistributionFunction#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link RegEx.Complex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see RegEx.RegExPackage#getDistributionFunction_Points()
	 * @model type="RegEx.Complex" containment="true"
	 * @generated
	 */
	EList getPoints();

	/**
	 * Returns the value of the '<em><b>Is Fourier Transformed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Fourier Transformed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Fourier Transformed</em>' attribute.
	 * @see #setIsFourierTransformed(boolean)
	 * @see RegEx.RegExPackage#getDistributionFunction_IsFourierTransformed()
	 * @model
	 * @generated
	 */
	boolean isIsFourierTransformed();

	/**
	 * Sets the value of the '{@link RegEx.DistributionFunction#isIsFourierTransformed <em>Is Fourier Transformed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Fourier Transformed</em>' attribute.
	 * @see #isIsFourierTransformed()
	 * @generated
	 */
	void setIsFourierTransformed(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void makePow2Elements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void expandTo(int length);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DistributionFunction add(DistributionFunction df);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DistributionFunction scale(double factor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DistributionFunction multiply(DistributionFunction df);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addPoint(Complex point);

} // DistributionFunction