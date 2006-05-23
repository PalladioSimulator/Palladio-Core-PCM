/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link RegEx.Alternative#getAltOne <em>Alt One</em>}</li>
 *   <li>{@link RegEx.Alternative#getAltTwo <em>Alt Two</em>}</li>
 *   <li>{@link RegEx.Alternative#getProbOne <em>Prob One</em>}</li>
 *   <li>{@link RegEx.Alternative#getProbTwo <em>Prob Two</em>}</li>
 * </ul>
 * </p>
 *
 * @see RegEx.RegExPackage#getAlternative()
 * @model
 * @generated
 */
public interface Alternative extends Expression {
	/**
	 * Returns the value of the '<em><b>Alt One</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alt One</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alt One</em>' containment reference.
	 * @see #setAltOne(Expression)
	 * @see RegEx.RegExPackage#getAlternative_AltOne()
	 * @model containment="true"
	 * @generated
	 */
	Expression getAltOne();

	/**
	 * Sets the value of the '{@link RegEx.Alternative#getAltOne <em>Alt One</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alt One</em>' containment reference.
	 * @see #getAltOne()
	 * @generated
	 */
	void setAltOne(Expression value);

	/**
	 * Returns the value of the '<em><b>Alt Two</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alt Two</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alt Two</em>' containment reference.
	 * @see #setAltTwo(Expression)
	 * @see RegEx.RegExPackage#getAlternative_AltTwo()
	 * @model containment="true"
	 * @generated
	 */
	Expression getAltTwo();

	/**
	 * Sets the value of the '{@link RegEx.Alternative#getAltTwo <em>Alt Two</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alt Two</em>' containment reference.
	 * @see #getAltTwo()
	 * @generated
	 */
	void setAltTwo(Expression value);

	/**
	 * Returns the value of the '<em><b>Prob One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prob One</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prob One</em>' attribute.
	 * @see #setProbOne(double)
	 * @see RegEx.RegExPackage#getAlternative_ProbOne()
	 * @model
	 * @generated
	 */
	double getProbOne();

	/**
	 * Sets the value of the '{@link RegEx.Alternative#getProbOne <em>Prob One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prob One</em>' attribute.
	 * @see #getProbOne()
	 * @generated
	 */
	void setProbOne(double value);

	/**
	 * Returns the value of the '<em><b>Prob Two</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prob Two</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prob Two</em>' attribute.
	 * @see #setProbTwo(double)
	 * @see RegEx.RegExPackage#getAlternative_ProbTwo()
	 * @model
	 * @generated
	 */
	double getProbTwo();

	/**
	 * Sets the value of the '{@link RegEx.Alternative#getProbTwo <em>Prob Two</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prob Two</em>' attribute.
	 * @see #getProbTwo()
	 * @generated
	 */
	void setProbTwo(double value);

} // Alternative