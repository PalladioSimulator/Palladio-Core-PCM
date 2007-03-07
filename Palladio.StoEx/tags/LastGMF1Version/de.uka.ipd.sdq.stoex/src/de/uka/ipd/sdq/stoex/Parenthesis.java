/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parenthesis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.Parenthesis#getInnerExpression <em>Inner Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getParenthesis()
 * @model
 * @generated
 */
public interface Parenthesis extends Atom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ, IPD, U Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Inner Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Expression</em>' containment reference.
	 * @see #setInnerExpression(Expression)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getParenthesis_InnerExpression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getInnerExpression();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.Parenthesis#getInnerExpression <em>Inner Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Expression</em>' containment reference.
	 * @see #getInnerExpression()
	 * @generated
	 */
	void setInnerExpression(Expression value);

} // Parenthesis