/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.usagemodel.impl;

import de.ipd.uka.sdq.pcm.parameter.ParameterUsage;

import de.ipd.uka.sdq.pcm.repository.Signature;

import de.ipd.uka.sdq.pcm.system.SystemProvidedRole;

import de.ipd.uka.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.ipd.uka.sdq.pcm.usagemodel.UsagemodelPackage;

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
 *   <li>{@link de.ipd.uka.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getActualParamterUsage_EntryLevelSystemCall <em>Actual Paramter Usage Entry Level System Call</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getSystemProvidedRole_EntryLevelSystemCall <em>System Provided Role Entry Level System Call</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getSignature_EntryLevelSystemCall <em>Signature Entry Level System Call</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getActualparameterusage <em>Actualparameterusage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryLevelSystemCallImpl extends AbstractUserActionImpl implements EntryLevelSystemCall {
	/**
	 * The cached value of the '{@link #getActualParamterUsage_EntryLevelSystemCall() <em>Actual Paramter Usage Entry Level System Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualParamterUsage_EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected EList actualParamterUsage_EntryLevelSystemCall = null;

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
	 * The cached value of the '{@link #getActualparameterusage() <em>Actualparameterusage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualparameterusage()
	 * @generated
	 * @ordered
	 */
	protected EList actualparameterusage = null;

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
	public EList getActualParamterUsage_EntryLevelSystemCall() {
		if (actualParamterUsage_EntryLevelSystemCall == null) {
			actualParamterUsage_EntryLevelSystemCall = new EObjectContainmentEList(ParameterUsage.class, this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMTER_USAGE_ENTRY_LEVEL_SYSTEM_CALL);
		}
		return actualParamterUsage_EntryLevelSystemCall;
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
	public EList getActualparameterusage() {
		if (actualparameterusage == null) {
			actualparameterusage = new EObjectContainmentEList(ParameterUsage.class, this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUALPARAMETERUSAGE);
		}
		return actualparameterusage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMTER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				return ((InternalEList)getActualParamterUsage_EntryLevelSystemCall()).basicRemove(otherEnd, msgs);
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUALPARAMETERUSAGE:
				return ((InternalEList)getActualparameterusage()).basicRemove(otherEnd, msgs);
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMTER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				return getActualParamterUsage_EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				if (resolve) return getSystemProvidedRole_EntryLevelSystemCall();
				return basicGetSystemProvidedRole_EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				if (resolve) return getSignature_EntryLevelSystemCall();
				return basicGetSignature_EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUALPARAMETERUSAGE:
				return getActualparameterusage();
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMTER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				getActualParamterUsage_EntryLevelSystemCall().clear();
				getActualParamterUsage_EntryLevelSystemCall().addAll((Collection)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				setSystemProvidedRole_EntryLevelSystemCall((SystemProvidedRole)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				setSignature_EntryLevelSystemCall((Signature)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUALPARAMETERUSAGE:
				getActualparameterusage().clear();
				getActualparameterusage().addAll((Collection)newValue);
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMTER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				getActualParamterUsage_EntryLevelSystemCall().clear();
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				setSystemProvidedRole_EntryLevelSystemCall((SystemProvidedRole)null);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				setSignature_EntryLevelSystemCall((Signature)null);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUALPARAMETERUSAGE:
				getActualparameterusage().clear();
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUAL_PARAMTER_USAGE_ENTRY_LEVEL_SYSTEM_CALL:
				return actualParamterUsage_EntryLevelSystemCall != null && !actualParamterUsage_EntryLevelSystemCall.isEmpty();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SYSTEM_PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				return systemProvidedRole_EntryLevelSystemCall != null;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				return signature_EntryLevelSystemCall != null;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__ACTUALPARAMETERUSAGE:
				return actualparameterusage != null && !actualparameterusage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EntryLevelSystemCallImpl