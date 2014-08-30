/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precedence Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.PrecedenceType#getPre <em>Pre</em>}</li>
 *   <li>{@link LqnCore.PrecedenceType#getPreOR <em>Pre OR</em>}</li>
 *   <li>{@link LqnCore.PrecedenceType#getPreAND <em>Pre AND</em>}</li>
 *   <li>{@link LqnCore.PrecedenceType#getPost <em>Post</em>}</li>
 *   <li>{@link LqnCore.PrecedenceType#getPostOR <em>Post OR</em>}</li>
 *   <li>{@link LqnCore.PrecedenceType#getPostAND <em>Post AND</em>}</li>
 *   <li>{@link LqnCore.PrecedenceType#getPostLOOP <em>Post LOOP</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getPrecedenceType()
 * @model extendedMetaData="name='PrecedenceType' kind='elementOnly'"
 * @generated
 */
public interface PrecedenceType extends EObject {
	/**
	 * Returns the value of the '<em><b>Pre</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre</em>' containment reference.
	 * @see #setPre(SingleActivityListType)
	 * @see LqnCore.LqnCorePackage#getPrecedenceType_Pre()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='pre' namespace='##targetNamespace'"
	 * @generated
	 */
	SingleActivityListType getPre();

	/**
	 * Sets the value of the '{@link LqnCore.PrecedenceType#getPre <em>Pre</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre</em>' containment reference.
	 * @see #getPre()
	 * @generated
	 */
	void setPre(SingleActivityListType value);

	/**
	 * Returns the value of the '<em><b>Pre OR</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre OR</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre OR</em>' containment reference.
	 * @see #setPreOR(ActivityListType)
	 * @see LqnCore.LqnCorePackage#getPrecedenceType_PreOR()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='pre-OR' namespace='##targetNamespace'"
	 * @generated
	 */
	ActivityListType getPreOR();

	/**
	 * Sets the value of the '{@link LqnCore.PrecedenceType#getPreOR <em>Pre OR</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre OR</em>' containment reference.
	 * @see #getPreOR()
	 * @generated
	 */
	void setPreOR(ActivityListType value);

	/**
	 * Returns the value of the '<em><b>Pre AND</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre AND</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre AND</em>' containment reference.
	 * @see #setPreAND(AndJoinListType)
	 * @see LqnCore.LqnCorePackage#getPrecedenceType_PreAND()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='pre-AND' namespace='##targetNamespace'"
	 * @generated
	 */
	AndJoinListType getPreAND();

	/**
	 * Sets the value of the '{@link LqnCore.PrecedenceType#getPreAND <em>Pre AND</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre AND</em>' containment reference.
	 * @see #getPreAND()
	 * @generated
	 */
	void setPreAND(AndJoinListType value);

	/**
	 * Returns the value of the '<em><b>Post</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post</em>' containment reference.
	 * @see #setPost(SingleActivityListType)
	 * @see LqnCore.LqnCorePackage#getPrecedenceType_Post()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='post' namespace='##targetNamespace'"
	 * @generated
	 */
	SingleActivityListType getPost();

	/**
	 * Sets the value of the '{@link LqnCore.PrecedenceType#getPost <em>Post</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post</em>' containment reference.
	 * @see #getPost()
	 * @generated
	 */
	void setPost(SingleActivityListType value);

	/**
	 * Returns the value of the '<em><b>Post OR</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post OR</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post OR</em>' containment reference.
	 * @see #setPostOR(OrListType)
	 * @see LqnCore.LqnCorePackage#getPrecedenceType_PostOR()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='post-OR' namespace='##targetNamespace'"
	 * @generated
	 */
	OrListType getPostOR();

	/**
	 * Sets the value of the '{@link LqnCore.PrecedenceType#getPostOR <em>Post OR</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post OR</em>' containment reference.
	 * @see #getPostOR()
	 * @generated
	 */
	void setPostOR(OrListType value);

	/**
	 * Returns the value of the '<em><b>Post AND</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post AND</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post AND</em>' containment reference.
	 * @see #setPostAND(ActivityListType)
	 * @see LqnCore.LqnCorePackage#getPrecedenceType_PostAND()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='post-AND' namespace='##targetNamespace'"
	 * @generated
	 */
	ActivityListType getPostAND();

	/**
	 * Sets the value of the '{@link LqnCore.PrecedenceType#getPostAND <em>Post AND</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post AND</em>' containment reference.
	 * @see #getPostAND()
	 * @generated
	 */
	void setPostAND(ActivityListType value);

	/**
	 * Returns the value of the '<em><b>Post LOOP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post LOOP</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post LOOP</em>' containment reference.
	 * @see #setPostLOOP(ActivityLoopListType)
	 * @see LqnCore.LqnCorePackage#getPrecedenceType_PostLOOP()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='post-LOOP' namespace='##targetNamespace'"
	 * @generated
	 */
	ActivityLoopListType getPostLOOP();

	/**
	 * Sets the value of the '{@link LqnCore.PrecedenceType#getPostLOOP <em>Post LOOP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post LOOP</em>' containment reference.
	 * @see #getPostLOOP()
	 * @generated
	 */
	void setPostLOOP(ActivityLoopListType value);

} // PrecedenceType
