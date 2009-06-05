
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;

import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Level System Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getActualParameterUsage_EntryLevelSystemCall <em>Actual Parameter Usage Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getSystemProvidedRole_EntryLevelSystemCall <em>System Provided Role Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getSignature_EntryLevelSystemCall <em>Signature Entry Level System Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryLevelSystemCallImpl extends AbstractUserActionImpl implements EntryLevelSystemCall {
	/**
	 * The cached value of the '{@link #getActualParameterUsage_EntryLevelSystemCall() <em>Actual Parameter Usage Entry Level System Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualParameterUsage_EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected EList actualParameterUsage_EntryLevelSystemCall = null;

	/**
	 * The cached value of the '{@link #getSystemProvidedRole_EntryLevelSystemCall() <em>System Provided Role Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemProvidedRole_EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected SystemProvidedRole systemProvidedRole_EntryLevelSystemCall = null;

	/**
	 * The cached value of the '{@link #getSignature_EntryLevelSystemCall() <em>Signature Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature_EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected Signature signature_EntryLevelSystemCall = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryLevelSystemCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getActualParameterUsage_EntryLevelSystemCall() {
		if (actualParameterUsage_EntryLevelSystemCall == null) {
			actualParameterUsage_EntryLevelSystemCall = new EObjectContainmentEList(ParameterUsage.class, this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL);
		}
		return actualParameterUsage_EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProvidedRole getSystemProvidedRole_EntryLevelSystemCall() {
		if (systemProvidedRole_EntryLevelSystemCall != null && systemProvidedRole_EntryLevelSystemCall.eIsProxy()) {
			InternalEObject oldSystemProvidedRole_EntryLevelSystemCall = (InternalEObject)systemProvidedRole_EntryLevelSystemCall;
			systemProvidedRole_EntryLevelSystemCall = (SystemProvidedRole)eResolveProxy(oldSystemProvidedRole_EntryLevelSystemCall);
			if (systemProvidedRole_EntryLevelSystemCall != oldSystemProvidedRole_EntryLevelSystemCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, oldSystemProvidedRole_EntryLevelSystemCall, systemProvidedRole_EntryLevelSystemCall));
			}
		}
		return systemProvidedRole_EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProvidedRole basicGetSystemProvidedRole_EntryLevelSystemCall() {
		return systemProvidedRole_EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemProvidedRole_EntryLevelSystemCall(SystemProvidedRole newSystemProvidedRole_EntryLevelSystemCall) {
		SystemProvidedRole oldSystemProvidedRole_EntryLevelSystemCall = systemProvidedRole_EntryLevelSystemCall;
		systemProvidedRole_EntryLevelSystemCall = newSystemProvidedRole_EntryLevelSystemCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, oldSystemProvidedRole_EntryLevelSystemCall, systemProvidedRole_EntryLevelSystemCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getSignature_EntryLevelSystemCall() {
		if (signature_EntryLevelSystemCall != null && signature_EntryLevelSystemCall.eIsProxy()) {
			InternalEObject oldSignature_EntryLevelSystemCall = (InternalEObject)signature_EntryLevelSystemCall;
			signature_EntryLevelSystemCall = (Signature)eResolveProxy(oldSignature_EntryLevelSystemCall);
			if (signature_EntryLevelSystemCall != oldSignature_EntryLevelSystemCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, oldSignature_EntryLevelSystemCall, signature_EntryLevelSystemCall));
			}
		}
		return signature_EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetSignature_EntryLevelSystemCall() {
		return signature_EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature_EntryLevelSystemCall(Signature newSignature_EntryLevelSystemCall) {
		Signature oldSignature_EntryLevelSystemCall = signature_EntryLevelSystemCall;
		signature_EntryLevelSystemCall = newSignature_EntryLevelSystemCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, oldSignature_EntryLevelSystemCall, signature_EntryLevelSystemCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				return ((InternalEList)getActualParameterUsage_EntryLevelSystemCall()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				return getActualParameterUsage_EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				if (resolve) return getSystemProvidedRole_EntryLevelSystemCall();
				return basicGetSystemProvidedRole_EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				if (resolve) return getSignature_EntryLevelSystemCall();
				return basicGetSignature_EntryLevelSystemCall();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				getActualParameterUsage_EntryLevelSystemCall().clear();
				getActualParameterUsage_EntryLevelSystemCall().addAll((Collection)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				setSystemProvidedRole_EntryLevelSystemCall((SystemProvidedRole)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				setSignature_EntryLevelSystemCall((Signature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				getActualParameterUsage_EntryLevelSystemCall().clear();
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				setSystemProvidedRole_EntryLevelSystemCall((SystemProvidedRole)null);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				setSignature_EntryLevelSystemCall((Signature)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMETER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				return actualParameterUsage_EntryLevelSystemCall != null && !actualParameterUsage_EntryLevelSystemCall.isEmpty();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				return systemProvidedRole_EntryLevelSystemCall != null;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				return signature_EntryLevelSystemCall != null;
		}
		return super.eIsSet(featureID);
	}

} //EntryLevelSystemCallImpl