/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Result Forwarding AND Join Delay</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.OutputResultForwardingANDJoinDelay#getResultConf95 <em>Result Conf95</em>}</li>
 *   <li>{@link LqnCore.OutputResultForwardingANDJoinDelay#getResultConf99 <em>Result Conf99</em>}</li>
 *   <li>{@link LqnCore.OutputResultForwardingANDJoinDelay#getDest <em>Dest</em>}</li>
 *   <li>{@link LqnCore.OutputResultForwardingANDJoinDelay#getJoinVariance <em>Join Variance</em>}</li>
 *   <li>{@link LqnCore.OutputResultForwardingANDJoinDelay#getJoinWaiting <em>Join Waiting</em>}</li>
 *   <li>{@link LqnCore.OutputResultForwardingANDJoinDelay#getWaiting <em>Waiting</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getOutputResultForwardingANDJoinDelay()
 * @model extendedMetaData="name='OutputResultForwardingANDJoinDelay' kind='elementOnly'"
 * @generated
 */
public interface OutputResultForwardingANDJoinDelay extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Conf95</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ResultConf95Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Conf95</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Conf95</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getOutputResultForwardingANDJoinDelay_ResultConf95()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='result-conf-95' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ResultConf95Type> getResultConf95();

	/**
	 * Returns the value of the '<em><b>Result Conf99</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ResultConf99Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Conf99</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Conf99</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getOutputResultForwardingANDJoinDelay_ResultConf99()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='result-conf-99' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ResultConf99Type> getResultConf99();

	/**
	 * Returns the value of the '<em><b>Dest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dest</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dest</em>' attribute.
	 * @see #setDest(String)
	 * @see LqnCore.LqnCorePackage#getOutputResultForwardingANDJoinDelay_Dest()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='dest' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDest();

	/**
	 * Sets the value of the '{@link LqnCore.OutputResultForwardingANDJoinDelay#getDest <em>Dest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dest</em>' attribute.
	 * @see #getDest()
	 * @generated
	 */
	void setDest(String value);

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
	 * @see LqnCore.LqnCorePackage#getOutputResultForwardingANDJoinDelay_JoinVariance()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='join-variance' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getJoinVariance();

	/**
	 * Sets the value of the '{@link LqnCore.OutputResultForwardingANDJoinDelay#getJoinVariance <em>Join Variance</em>}' attribute.
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
	 * @see LqnCore.LqnCorePackage#getOutputResultForwardingANDJoinDelay_JoinWaiting()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='join-waiting' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getJoinWaiting();

	/**
	 * Sets the value of the '{@link LqnCore.OutputResultForwardingANDJoinDelay#getJoinWaiting <em>Join Waiting</em>}' attribute.
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
	 * @see LqnCore.LqnCorePackage#getOutputResultForwardingANDJoinDelay_Waiting()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='waiting' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getWaiting();

	/**
	 * Sets the value of the '{@link LqnCore.OutputResultForwardingANDJoinDelay#getWaiting <em>Waiting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Waiting</em>' attribute.
	 * @see #getWaiting()
	 * @generated
	 */
	void setWaiting(Object value);

} // OutputResultForwardingANDJoinDelay
