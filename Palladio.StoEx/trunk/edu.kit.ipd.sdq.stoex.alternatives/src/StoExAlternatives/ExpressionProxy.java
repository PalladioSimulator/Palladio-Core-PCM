/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives;

import de.uka.ipd.sdq.stoex.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * StoEx variation point
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link StoExAlternatives.ExpressionProxy#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link StoExAlternatives.ExpressionProxy#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see StoExAlternatives.StoExAlternativesPackage#getExpressionProxy()
 * @model
 * @generated
 */
public interface ExpressionProxy extends Expression {
	/**
	 * Returns the value of the '<em><b>Alternatives</b></em>' reference list.
	 * The list contents are of type {@link StoExAlternatives.StoExPart}.
	 * It is bidirectional and its opposite is '{@link StoExAlternatives.StoExPart#getExpressionProxy <em>Expression Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternatives</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternatives</em>' reference list.
	 * @see StoExAlternatives.StoExAlternativesPackage#getExpressionProxy_Alternatives()
	 * @see StoExAlternatives.StoExPart#getExpressionProxy
	 * @model opposite="expressionProxy" ordered="false"
	 * @generated
	 */
	EList<StoExPart> getAlternatives();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see StoExAlternatives.StoExAlternativesPackage#getExpressionProxy_Expression()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link StoExAlternatives.ExpressionProxy#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // ExpressionProxy
