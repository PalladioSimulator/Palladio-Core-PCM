/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.impl;

import de.fzi.se.quality.parameters.CallInstance;

import de.fzi.se.validation.testbased.trace.OperationCall;
import de.fzi.se.validation.testbased.trace.TracePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.impl.OperationCallImpl#getCallInstance <em>Call Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallImpl extends TraceActionImpl implements OperationCall {
	/**
	 * The cached value of the '{@link #getCallInstance() <em>Call Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallInstance()
	 * @generated
	 * @ordered
	 */
	protected CallInstance callInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.OPERATION_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallInstance getCallInstance() {
		return callInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallInstance(CallInstance newCallInstance, NotificationChain msgs) {
		CallInstance oldCallInstance = callInstance;
		callInstance = newCallInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.OPERATION_CALL__CALL_INSTANCE, oldCallInstance, newCallInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallInstance(CallInstance newCallInstance) {
		if (newCallInstance != callInstance) {
			NotificationChain msgs = null;
			if (callInstance != null)
				msgs = ((InternalEObject)callInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TracePackage.OPERATION_CALL__CALL_INSTANCE, null, msgs);
			if (newCallInstance != null)
				msgs = ((InternalEObject)newCallInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TracePackage.OPERATION_CALL__CALL_INSTANCE, null, msgs);
			msgs = basicSetCallInstance(newCallInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.OPERATION_CALL__CALL_INSTANCE, newCallInstance, newCallInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.OPERATION_CALL__CALL_INSTANCE:
				return basicSetCallInstance(null, msgs);
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
			case TracePackage.OPERATION_CALL__CALL_INSTANCE:
				return getCallInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.OPERATION_CALL__CALL_INSTANCE:
				setCallInstance((CallInstance)newValue);
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
			case TracePackage.OPERATION_CALL__CALL_INSTANCE:
				setCallInstance((CallInstance)null);
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
			case TracePackage.OPERATION_CALL__CALL_INSTANCE:
				return callInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //OperationCallImpl
