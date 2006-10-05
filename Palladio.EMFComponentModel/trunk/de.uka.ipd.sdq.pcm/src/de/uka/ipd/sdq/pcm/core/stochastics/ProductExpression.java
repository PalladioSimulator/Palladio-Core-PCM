
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getRight <em>Right</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getProductExpression()
 * @model
 * @generated
 */
public interface ProductExpression extends Product {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Product)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getProductExpression_Left()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Product getLeft();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Product value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Power)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getProductExpression_Right()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Power getRight();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Power value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations
	 * @see #setOperation(ProductOperations)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getProductExpression_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProductOperations getOperation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(ProductOperations value);

} // ProductExpression