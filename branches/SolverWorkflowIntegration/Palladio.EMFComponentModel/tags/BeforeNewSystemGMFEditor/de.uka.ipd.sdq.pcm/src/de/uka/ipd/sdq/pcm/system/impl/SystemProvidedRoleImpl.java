
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedRoleImpl#getSystem_SystemProvidedRole <em>System System Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemProvidedRoleImpl extends ProvidedRoleImpl implements SystemProvidedRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemProvidedRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM_PROVIDED_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uka.ipd.sdq.pcm.system.System getSystem_SystemProvidedRole() {
		if (eContainerFeatureID != SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE) return null;
		return (de.uka.ipd.sdq.pcm.system.System)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem_SystemProvidedRole(de.uka.ipd.sdq.pcm.system.System newSystem_SystemProvidedRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSystem_SystemProvidedRole, SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem_SystemProvidedRole(de.uka.ipd.sdq.pcm.system.System newSystem_SystemProvidedRole) {
		if (newSystem_SystemProvidedRole != eInternalContainer() || (eContainerFeatureID != SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE && newSystem_SystemProvidedRole != null)) {
			if (EcoreUtil.isAncestor(this, newSystem_SystemProvidedRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSystem_SystemProvidedRole != null)
				msgs = ((InternalEObject)newSystem_SystemProvidedRole).eInverseAdd(this, SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM, de.uka.ipd.sdq.pcm.system.System.class, msgs);
			msgs = basicSetSystem_SystemProvidedRole(newSystem_SystemProvidedRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE, newSystem_SystemProvidedRole, newSystem_SystemProvidedRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSystem_SystemProvidedRole((de.uka.ipd.sdq.pcm.system.System)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE:
				return basicSetSystem_SystemProvidedRole(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE:
				return eInternalContainer().eInverseRemove(this, SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM, de.uka.ipd.sdq.pcm.system.System.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE:
				return getSystem_SystemProvidedRole();
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE:
				setSystem_SystemProvidedRole((de.uka.ipd.sdq.pcm.system.System)newValue);
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE:
				setSystem_SystemProvidedRole((de.uka.ipd.sdq.pcm.system.System)null);
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE:
				return getSystem_SystemProvidedRole() != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemProvidedRoleImpl