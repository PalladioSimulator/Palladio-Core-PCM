/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives;

import de.uka.ipd.sdq.stoex.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sto Ex Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link StoExAlternatives.StoExPart#getSubExpression <em>Sub Expression</em>}</li>
 *   <li>{@link StoExAlternatives.StoExPart#getExpressionProxy <em>Expression Proxy</em>}</li>
 * </ul>
 * </p>
 *
 * @see StoExAlternatives.StoExAlternativesPackage#getStoExPart()
 * @model
 * @generated
 */
public interface StoExPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expression</em>' reference.
	 * @see #setSubExpression(Expression)
	 * @see StoExAlternatives.StoExAlternativesPackage#getStoExPart_SubExpression()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Expression getSubExpression();

	/**
	 * Sets the value of the '{@link StoExAlternatives.StoExPart#getSubExpression <em>Sub Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Expression</em>' reference.
	 * @see #getSubExpression()
	 * @generated
	 */
	void setSubExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Expression Proxy</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link StoExAlternatives.ExpressionProxy#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Proxy</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Proxy</em>' reference.
	 * @see #setExpressionProxy(ExpressionProxy)
	 * @see StoExAlternatives.StoExAlternativesPackage#getStoExPart_ExpressionProxy()
	 * @see StoExAlternatives.ExpressionProxy#getAlternatives
	 * @model opposite="alternatives" required="true" ordered="false"
	 * @generated
	 */
	ExpressionProxy getExpressionProxy();

	/**
	 * Sets the value of the '{@link StoExAlternatives.StoExPart#getExpressionProxy <em>Expression Proxy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Proxy</em>' reference.
	 * @see #getExpressionProxy()
	 * @generated
	 */
	void setExpressionProxy(ExpressionProxy value);

} // StoExPart
