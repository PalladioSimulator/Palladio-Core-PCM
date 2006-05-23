/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parallel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link RegEx.Parallel#getTaskOne <em>Task One</em>}</li>
 *   <li>{@link RegEx.Parallel#getTaskTwo <em>Task Two</em>}</li>
 * </ul>
 * </p>
 *
 * @see RegEx.RegExPackage#getParallel()
 * @model
 * @generated
 */
public interface Parallel extends Expression {
	/**
	 * Returns the value of the '<em><b>Task One</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task One</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task One</em>' containment reference.
	 * @see #setTaskOne(Expression)
	 * @see RegEx.RegExPackage#getParallel_TaskOne()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTaskOne();

	/**
	 * Sets the value of the '{@link RegEx.Parallel#getTaskOne <em>Task One</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task One</em>' containment reference.
	 * @see #getTaskOne()
	 * @generated
	 */
	void setTaskOne(Expression value);

	/**
	 * Returns the value of the '<em><b>Task Two</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Two</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Two</em>' containment reference.
	 * @see #setTaskTwo(Expression)
	 * @see RegEx.RegExPackage#getParallel_TaskTwo()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTaskTwo();

	/**
	 * Sets the value of the '{@link RegEx.Parallel#getTaskTwo <em>Task Two</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Two</em>' containment reference.
	 * @see #getTaskTwo()
	 * @generated
	 */
	void setTaskTwo(Expression value);

} // Parallel