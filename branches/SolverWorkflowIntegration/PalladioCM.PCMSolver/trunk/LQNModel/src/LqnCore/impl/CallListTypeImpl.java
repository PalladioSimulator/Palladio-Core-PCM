/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.impl;

import LqnCore.AsynchCallType;
import LqnCore.CallListType;
import LqnCore.LqnCorePackage;
import LqnCore.SynchCallType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call List Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LqnCore.impl.CallListTypeImpl#getSynchCall <em>Synch Call</em>}</li>
 *   <li>{@link LqnCore.impl.CallListTypeImpl#getAsynchCall <em>Asynch Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallListTypeImpl extends EObjectImpl implements CallListType {
	/**
	 * The cached value of the '{@link #getSynchCall() <em>Synch Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchCall()
	 * @generated
	 * @ordered
	 */
	protected EList<SynchCallType> synchCall;

	/**
	 * The cached value of the '{@link #getAsynchCall() <em>Asynch Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsynchCall()
	 * @generated
	 * @ordered
	 */
	protected EList<AsynchCallType> asynchCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallListTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LqnCorePackage.Literals.CALL_LIST_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SynchCallType> getSynchCall() {
		if (synchCall == null) {
			synchCall = new EObjectContainmentEList<SynchCallType>(SynchCallType.class, this, LqnCorePackage.CALL_LIST_TYPE__SYNCH_CALL);
		}
		return synchCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AsynchCallType> getAsynchCall() {
		if (asynchCall == null) {
			asynchCall = new EObjectContainmentEList<AsynchCallType>(AsynchCallType.class, this, LqnCorePackage.CALL_LIST_TYPE__ASYNCH_CALL);
		}
		return asynchCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LqnCorePackage.CALL_LIST_TYPE__SYNCH_CALL:
				return ((InternalEList<?>)getSynchCall()).basicRemove(otherEnd, msgs);
			case LqnCorePackage.CALL_LIST_TYPE__ASYNCH_CALL:
				return ((InternalEList<?>)getAsynchCall()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LqnCorePackage.CALL_LIST_TYPE__SYNCH_CALL:
				return getSynchCall();
			case LqnCorePackage.CALL_LIST_TYPE__ASYNCH_CALL:
				return getAsynchCall();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LqnCorePackage.CALL_LIST_TYPE__SYNCH_CALL:
				getSynchCall().clear();
				getSynchCall().addAll((Collection<? extends SynchCallType>)newValue);
				return;
			case LqnCorePackage.CALL_LIST_TYPE__ASYNCH_CALL:
				getAsynchCall().clear();
				getAsynchCall().addAll((Collection<? extends AsynchCallType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LqnCorePackage.CALL_LIST_TYPE__SYNCH_CALL:
				getSynchCall().clear();
				return;
			case LqnCorePackage.CALL_LIST_TYPE__ASYNCH_CALL:
				getAsynchCall().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LqnCorePackage.CALL_LIST_TYPE__SYNCH_CALL:
				return synchCall != null && !synchCall.isEmpty();
			case LqnCorePackage.CALL_LIST_TYPE__ASYNCH_CALL:
				return asynchCall != null && !asynchCall.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CallListTypeImpl
