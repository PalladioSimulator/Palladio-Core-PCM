/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.protocol.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.ServiceCall;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.protocol.impl.ServiceCallImpl#getSignature__ServiceCall <em>Signature Service Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ServiceCallImpl extends EObjectImpl implements ServiceCall {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";
	/**
	 * The cached value of the '{@link #getSignature__ServiceCall() <em>Signature Service Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature__ServiceCall()
	 * @generated
	 * @ordered
	 */
	protected Signature signature__ServiceCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.SERVICE_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getSignature__ServiceCall() {
		if (signature__ServiceCall != null && signature__ServiceCall.eIsProxy()) {
			InternalEObject oldSignature__ServiceCall = (InternalEObject)signature__ServiceCall;
			signature__ServiceCall = (Signature)eResolveProxy(oldSignature__ServiceCall);
			if (signature__ServiceCall != oldSignature__ServiceCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProtocolPackage.SERVICE_CALL__SIGNATURE_SERVICE_CALL, oldSignature__ServiceCall, signature__ServiceCall));
			}
		}
		return signature__ServiceCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetSignature__ServiceCall() {
		return signature__ServiceCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature__ServiceCall(Signature newSignature__ServiceCall) {
		Signature oldSignature__ServiceCall = signature__ServiceCall;
		signature__ServiceCall = newSignature__ServiceCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SERVICE_CALL__SIGNATURE_SERVICE_CALL, oldSignature__ServiceCall, signature__ServiceCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProtocolPackage.SERVICE_CALL__SIGNATURE_SERVICE_CALL:
				if (resolve) return getSignature__ServiceCall();
				return basicGetSignature__ServiceCall();
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
			case ProtocolPackage.SERVICE_CALL__SIGNATURE_SERVICE_CALL:
				setSignature__ServiceCall((Signature)newValue);
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
			case ProtocolPackage.SERVICE_CALL__SIGNATURE_SERVICE_CALL:
				setSignature__ServiceCall((Signature)null);
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
			case ProtocolPackage.SERVICE_CALL__SIGNATURE_SERVICE_CALL:
				return signature__ServiceCall != null;
		}
		return super.eIsSet(featureID);
	}

} //ServiceCallImpl
