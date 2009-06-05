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
 * A representation of the model object '<em><b>Result Conf95 Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.ResultConf95Type#getJoinVariance <em>Join Variance</em>}</li>
 *   <li>{@link LqnCore.ResultConf95Type#getJoinWaiting <em>Join Waiting</em>}</li>
 *   <li>{@link LqnCore.ResultConf95Type#getWaiting <em>Waiting</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getResultConf95Type()
 * @model extendedMetaData="name='result-conf-95_._type' kind='empty'"
 * @generated
 */
public interface ResultConf95Type extends EObject {
	/**
	 * Returns the value of the '<em><b>Join Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Variance</em>' attribute.
	 * @see #setJoinVariance(Object)
	 * @see LqnCore.LqnCorePackage#getResultConf95Type_JoinVariance()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='join-variance' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getJoinVariance();

	/**
	 * Sets the value of the '{@link LqnCore.ResultConf95Type#getJoinVariance <em>Join Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Variance</em>' attribute.
	 * @see #getJoinVariance()
	 * @generated
	 */
	void setJoinVariance(Object value);

	/**
	 * Returns the value of the '<em><b>Join Waiting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Waiting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Waiting</em>' attribute.
	 * @see #setJoinWaiting(Object)
	 * @see LqnCore.LqnCorePackage#getResultConf95Type_JoinWaiting()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='join-waiting' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getJoinWaiting();

	/**
	 * Sets the value of the '{@link LqnCore.ResultConf95Type#getJoinWaiting <em>Join Waiting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Waiting</em>' attribute.
	 * @see #getJoinWaiting()
	 * @generated
	 */
	void setJoinWaiting(Object value);

	/**
	 * Returns the value of the '<em><b>Waiting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting</em>' attribute.
	 * @see #setWaiting(Object)
	 * @see LqnCore.LqnCorePackage#getResultConf95Type_Waiting()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='waiting' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getWaiting();

	/**
	 * Sets the value of the '{@link LqnCore.ResultConf95Type#getWaiting <em>Waiting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Waiting</em>' attribute.
	 * @see #getWaiting()
	 * @generated
	 */
	void setWaiting(Object value);

} // ResultConf95Type
