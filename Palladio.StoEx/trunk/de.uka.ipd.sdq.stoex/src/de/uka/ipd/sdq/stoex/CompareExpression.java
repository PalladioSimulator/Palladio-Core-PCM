/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compare Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.CompareExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.CompareExpression#getRight <em>Right</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.CompareExpression#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getCompareExpression()
 * @model
 * @generated
 */
public interface CompareExpression extends Comparison {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Term)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getCompareExpression_Left()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Term getLeft();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.CompareExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Term value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Term)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getCompareExpression_Right()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Term getRight();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.CompareExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Term value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.stoex.CompareOperations}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see de.uka.ipd.sdq.stoex.CompareOperations
	 * @see #setOperation(CompareOperations)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getCompareExpression_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CompareOperations getOperation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.CompareExpression#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see de.uka.ipd.sdq.stoex.CompareOperations
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(CompareOperations value);

} // CompareExpression
