/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Symbol#getInputValue <em>Input Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Symbol#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getSymbol()
 * @model
 * @generated
 */
public interface Symbol extends Terminal {
	/**
	 * Returns the value of the '<em><b>Input Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Value</em>' containment reference.
	 * @see #setInputValue(ProbabilityDensityFunction)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getSymbol_InputValue()
	 * @model containment="true"
	 * @generated
	 */
	ProbabilityDensityFunction getInputValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Symbol#getInputValue <em>Input Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Value</em>' containment reference.
	 * @see #getInputValue()
	 * @generated
	 */
	void setInputValue(ProbabilityDensityFunction value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getSymbol_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Symbol#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Symbol