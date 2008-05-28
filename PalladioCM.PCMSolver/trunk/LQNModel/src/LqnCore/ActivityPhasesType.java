/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Phases Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.ActivityPhasesType#getCallList <em>Call List</em>}</li>
 *   <li>{@link LqnCore.ActivityPhasesType#getGroup <em>Group</em>}</li>
 *   <li>{@link LqnCore.ActivityPhasesType#getSynchCall <em>Synch Call</em>}</li>
 *   <li>{@link LqnCore.ActivityPhasesType#getAsynchCall <em>Asynch Call</em>}</li>
 *   <li>{@link LqnCore.ActivityPhasesType#getPhase <em>Phase</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getActivityPhasesType()
 * @model extendedMetaData="name='ActivityPhasesType' kind='elementOnly'"
 * @generated
 */
public interface ActivityPhasesType extends ActivityDefBase {
	/**
	 * Returns the value of the '<em><b>Call List</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.CallListType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call List</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getActivityPhasesType_CallList()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='call-list' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CallListType> getCallList();

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see LqnCore.LqnCorePackage#getActivityPhasesType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:11'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Synch Call</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ActivityMakingCallType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synch Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synch Call</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getActivityPhasesType_SynchCall()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='synch-call' namespace='##targetNamespace' group='group:11'"
	 * @generated
	 */
	EList<ActivityMakingCallType> getSynchCall();

	/**
	 * Returns the value of the '<em><b>Asynch Call</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ActivityMakingCallType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asynch Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asynch Call</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getActivityPhasesType_AsynchCall()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='asynch-call' namespace='##targetNamespace' group='group:11'"
	 * @generated
	 */
	EList<ActivityMakingCallType> getAsynchCall();

	/**
	 * Returns the value of the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phase</em>' attribute.
	 * @see #setPhase(BigInteger)
	 * @see LqnCore.LqnCorePackage#getActivityPhasesType_Phase()
	 * @model dataType="LqnCore.PhaseType" required="true"
	 *        extendedMetaData="kind='attribute' name='phase' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getPhase();

	/**
	 * Sets the value of the '{@link LqnCore.ActivityPhasesType#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase</em>' attribute.
	 * @see #getPhase()
	 * @generated
	 */
	void setPhase(BigInteger value);

} // ActivityPhasesType
