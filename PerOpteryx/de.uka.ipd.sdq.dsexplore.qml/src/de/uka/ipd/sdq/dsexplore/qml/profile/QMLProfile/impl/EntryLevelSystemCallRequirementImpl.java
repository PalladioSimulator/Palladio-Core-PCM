/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.EntryLevelSystemCallRequirement;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Level System Call Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl.EntryLevelSystemCallRequirementImpl#getEntryLevelSystemCall <em>Entry Level System Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryLevelSystemCallRequirementImpl extends RequirementImpl implements EntryLevelSystemCallRequirement {
	/**
	 * The cached value of the '{@link #getEntryLevelSystemCall() <em>Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected EntryLevelSystemCall entryLevelSystemCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryLevelSystemCallRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLProfilePackage.Literals.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall getEntryLevelSystemCall() {
		if (entryLevelSystemCall != null && entryLevelSystemCall.eIsProxy()) {
			InternalEObject oldEntryLevelSystemCall = (InternalEObject)entryLevelSystemCall;
			entryLevelSystemCall = (EntryLevelSystemCall)eResolveProxy(oldEntryLevelSystemCall);
			if (entryLevelSystemCall != oldEntryLevelSystemCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL, oldEntryLevelSystemCall, entryLevelSystemCall));
			}
		}
		return entryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall basicGetEntryLevelSystemCall() {
		return entryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryLevelSystemCall(EntryLevelSystemCall newEntryLevelSystemCall) {
		EntryLevelSystemCall oldEntryLevelSystemCall = entryLevelSystemCall;
		entryLevelSystemCall = newEntryLevelSystemCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL, oldEntryLevelSystemCall, entryLevelSystemCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL:
				if (resolve) return getEntryLevelSystemCall();
				return basicGetEntryLevelSystemCall();
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
			case QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL:
				setEntryLevelSystemCall((EntryLevelSystemCall)newValue);
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
			case QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL:
				setEntryLevelSystemCall((EntryLevelSystemCall)null);
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
			case QMLProfilePackage.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL:
				return entryLevelSystemCall != null;
		}
		return super.eIsSet(featureID);
	}

} //EntryLevelSystemCallRequirementImpl
