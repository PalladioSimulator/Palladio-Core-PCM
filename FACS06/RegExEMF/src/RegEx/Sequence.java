/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link RegEx.Sequence#getPre <em>Pre</em>}</li>
 *   <li>{@link RegEx.Sequence#getPost <em>Post</em>}</li>
 * </ul>
 * </p>
 *
 * @see RegEx.RegExPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends Expression {
	/**
	 * Returns the value of the '<em><b>Pre</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre</em>' containment reference.
	 * @see #setPre(Expression)
	 * @see RegEx.RegExPackage#getSequence_Pre()
	 * @model containment="true"
	 * @generated
	 */
	Expression getPre();

	/**
	 * Sets the value of the '{@link RegEx.Sequence#getPre <em>Pre</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre</em>' containment reference.
	 * @see #getPre()
	 * @generated
	 */
	void setPre(Expression value);

	/**
	 * Returns the value of the '<em><b>Post</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post</em>' containment reference.
	 * @see #setPost(Expression)
	 * @see RegEx.RegExPackage#getSequence_Post()
	 * @model containment="true"
	 * @generated
	 */
	Expression getPost();

	/**
	 * Sets the value of the '{@link RegEx.Sequence#getPost <em>Post</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post</em>' containment reference.
	 * @see #getPost()
	 * @generated
	 */
	void setPost(Expression value);

} // Sequence