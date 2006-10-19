/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Loop#getRegExp <em>Reg Exp</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Loop#getIterations <em>Iterations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends Operation {
	/**
	 * Returns the value of the '<em><b>Reg Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reg Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reg Exp</em>' containment reference.
	 * @see #setRegExp(Expression)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getLoop_RegExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRegExp();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Loop#getRegExp <em>Reg Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reg Exp</em>' containment reference.
	 * @see #getRegExp()
	 * @generated
	 */
	void setRegExp(Expression value);

	/**
	 * Returns the value of the '<em><b>Iterations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations</em>' containment reference.
	 * @see #setIterations(ProbabilityMassFunction)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getLoop_Iterations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ProbabilityMassFunction getIterations();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Loop#getIterations <em>Iterations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations</em>' containment reference.
	 * @see #getIterations()
	 * @generated
	 */
	void setIterations(ProbabilityMassFunction value);

} // Loop