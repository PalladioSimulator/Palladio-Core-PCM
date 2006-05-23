/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link RegEx.Loop#getInner <em>Inner</em>}</li>
 *   <li>{@link RegEx.Loop#getReiterationDistribution <em>Reiteration Distribution</em>}</li>
 * </ul>
 * </p>
 *
 * @see RegEx.RegExPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends Expression {
	/**
	 * Returns the value of the '<em><b>Inner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner</em>' containment reference.
	 * @see #setInner(Expression)
	 * @see RegEx.RegExPackage#getLoop_Inner()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInner();

	/**
	 * Sets the value of the '{@link RegEx.Loop#getInner <em>Inner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner</em>' containment reference.
	 * @see #getInner()
	 * @generated
	 */
	void setInner(Expression value);

	/**
	 * Returns the value of the '<em><b>Reiteration Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reiteration Distribution</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reiteration Distribution</em>' containment reference.
	 * @see #setReiterationDistribution(DistributionFunction)
	 * @see RegEx.RegExPackage#getLoop_ReiterationDistribution()
	 * @model containment="true"
	 * @generated
	 */
	DistributionFunction getReiterationDistribution();

	/**
	 * Sets the value of the '{@link RegEx.Loop#getReiterationDistribution <em>Reiteration Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reiteration Distribution</em>' containment reference.
	 * @see #getReiterationDistribution()
	 * @generated
	 */
	void setReiterationDistribution(DistributionFunction value);

} // Loop