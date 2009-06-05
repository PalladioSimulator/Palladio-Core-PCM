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
 * A representation of the model object '<em><b>Call List Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.CallListType#getSynchCall <em>Synch Call</em>}</li>
 *   <li>{@link LqnCore.CallListType#getAsynchCall <em>Asynch Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getCallListType()
 * @model extendedMetaData="name='call-list_._type' kind='elementOnly'"
 * @generated
 */
public interface CallListType extends EObject {
	/**
	 * Returns the value of the '<em><b>Synch Call</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.SynchCallType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synch Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synch Call</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getCallListType_SynchCall()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='synch-call' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SynchCallType> getSynchCall();

	/**
	 * Returns the value of the '<em><b>Asynch Call</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.AsynchCallType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asynch Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asynch Call</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getCallListType_AsynchCall()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='asynch-call' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AsynchCallType> getAsynchCall();

} // CallListType
