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
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Loop#getIterationsPMF <em>Iterations PMF</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Loop#getIterationsString <em>Iterations String</em>}</li>
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
	 * Returns the value of the '<em><b>Iterations PMF</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations PMF</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations PMF</em>' containment reference.
	 * @see #setIterationsPMF(ProbabilityMassFunction)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getLoop_IterationsPMF()
	 * @model containment="true" transient="true" volatile="true"
	 * @generated
	 */
	ProbabilityMassFunction getIterationsPMF();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Loop#getIterationsPMF <em>Iterations PMF</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations PMF</em>' containment reference.
	 * @see #getIterationsPMF()
	 * @generated
	 */
	void setIterationsPMF(ProbabilityMassFunction value);

	/**
	 * Returns the value of the '<em><b>Iterations String</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations String</em>' attribute.
	 * @see #setIterationsString(String)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getLoop_IterationsString()
	 * @model default="" unique="false"
	 * @generated
	 */
	String getIterationsString();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Loop#getIterationsString <em>Iterations String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations String</em>' attribute.
	 * @see #getIterationsString()
	 * @generated
	 */
	void setIterationsString(String value);

} // Loop
