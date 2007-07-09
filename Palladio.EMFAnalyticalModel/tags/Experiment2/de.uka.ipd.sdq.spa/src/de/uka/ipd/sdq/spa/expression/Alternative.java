/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Alternative#getLeftOption <em>Left Option</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Alternative#getRightOption <em>Right Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getAlternative()
 * @model
 * @generated
 */
public interface Alternative extends Operation {
	/**
	 * Returns the value of the '<em><b>Left Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Option</em>' containment reference.
	 * @see #setLeftOption(Option)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getAlternative_LeftOption()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Option getLeftOption();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Alternative#getLeftOption <em>Left Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Option</em>' containment reference.
	 * @see #getLeftOption()
	 * @generated
	 */
	void setLeftOption(Option value);

	/**
	 * Returns the value of the '<em><b>Right Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Option</em>' containment reference.
	 * @see #setRightOption(Option)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getAlternative_RightOption()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Option getRightOption();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Alternative#getRightOption <em>Right Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Option</em>' containment reference.
	 * @see #getRightOption()
	 * @generated
	 */
	void setRightOption(Option value);

} // Alternative
