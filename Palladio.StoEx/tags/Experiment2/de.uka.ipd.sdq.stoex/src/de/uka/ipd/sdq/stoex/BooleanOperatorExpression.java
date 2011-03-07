/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Operator Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.BooleanOperatorExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.BooleanOperatorExpression#getRight <em>Right</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.BooleanOperatorExpression#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getBooleanOperatorExpression()
 * @model
 * @generated
 */
public interface BooleanOperatorExpression extends BooleanExpression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(BooleanExpression)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getBooleanOperatorExpression_Left()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	BooleanExpression getLeft();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.BooleanOperatorExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(BooleanExpression value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(BooleanExpression)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getBooleanOperatorExpression_Right()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	BooleanExpression getRight();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.BooleanOperatorExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(BooleanExpression value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.stoex.BooleanOperations}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see de.uka.ipd.sdq.stoex.BooleanOperations
	 * @see #setOperation(BooleanOperations)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getBooleanOperatorExpression_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BooleanOperations getOperation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.BooleanOperatorExpression#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see de.uka.ipd.sdq.stoex.BooleanOperations
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(BooleanOperations value);

} // BooleanOperatorExpression
