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
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link RegEx.Expression#getDistributionFunction <em>Distribution Function</em>}</li>
 *   <li>{@link RegEx.Expression#getDistributionFunctionFreq <em>Distribution Function Freq</em>}</li>
 * </ul>
 * </p>
 *
 * @see RegEx.RegExPackage#getExpression()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Expression extends EObject {
	/**
	 * Returns the value of the '<em><b>Distribution Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distribution Function</em>' containment reference.
	 * @see #setDistributionFunction(DistributionFunction)
	 * @see RegEx.RegExPackage#getExpression_DistributionFunction()
	 * @model containment="true"
	 * @generated
	 */
	DistributionFunction getDistributionFunction();

	/**
	 * Sets the value of the '{@link RegEx.Expression#getDistributionFunction <em>Distribution Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution Function</em>' containment reference.
	 * @see #getDistributionFunction()
	 * @generated
	 */
	void setDistributionFunction(DistributionFunction value);

	/**
	 * Returns the value of the '<em><b>Distribution Function Freq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution Function Freq</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distribution Function Freq</em>' containment reference.
	 * @see #setDistributionFunctionFreq(DistributionFunction)
	 * @see RegEx.RegExPackage#getExpression_DistributionFunctionFreq()
	 * @model containment="true"
	 * @generated
	 */
	DistributionFunction getDistributionFunctionFreq();

	/**
	 * Sets the value of the '{@link RegEx.Expression#getDistributionFunctionFreq <em>Distribution Function Freq</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution Function Freq</em>' containment reference.
	 * @see #getDistributionFunctionFreq()
	 * @generated
	 */
	void setDistributionFunctionFreq(DistributionFunction value);

} // Expression