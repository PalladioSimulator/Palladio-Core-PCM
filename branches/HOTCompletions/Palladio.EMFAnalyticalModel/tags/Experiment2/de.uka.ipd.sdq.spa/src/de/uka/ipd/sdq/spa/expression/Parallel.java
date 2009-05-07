/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parallel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Parallel#getLeftTask <em>Left Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Parallel#getRightTask <em>Right Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getParallel()
 * @model
 * @generated
 */
public interface Parallel extends Operation {
	/**
	 * Returns the value of the '<em><b>Left Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Task</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Task</em>' containment reference.
	 * @see #setLeftTask(Expression)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getParallel_LeftTask()
	 * @model containment="true"
	 * @generated
	 */
	Expression getLeftTask();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Parallel#getLeftTask <em>Left Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Task</em>' containment reference.
	 * @see #getLeftTask()
	 * @generated
	 */
	void setLeftTask(Expression value);

	/**
	 * Returns the value of the '<em><b>Right Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Task</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Task</em>' containment reference.
	 * @see #setRightTask(Expression)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getParallel_RightTask()
	 * @model containment="true"
	 * @generated
	 */
	Expression getRightTask();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Parallel#getRightTask <em>Right Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Task</em>' containment reference.
	 * @see #getRightTask()
	 * @generated
	 */
	void setRightTask(Expression value);

} // Parallel
