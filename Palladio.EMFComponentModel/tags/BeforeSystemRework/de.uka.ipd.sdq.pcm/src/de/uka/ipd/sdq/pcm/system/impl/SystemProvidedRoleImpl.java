
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.repository.Interface;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedRoleImpl#getProvidedDelegationConnector_SystemProvidedRole <em>Provided Delegation Connector System Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedRoleImpl#getInterface_SystemProvidedRole <em>Interface System Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemProvidedRoleImpl extends EntityImpl implements SystemProvidedRole {
	/**
	 * The cached value of the '{@link #getProvidedDelegationConnector_SystemProvidedRole() <em>Provided Delegation Connector System Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedDelegationConnector_SystemProvidedRole()
	 * @generated
	 * @ordered
	 */
	protected SystemProvidedDelegationConnector providedDelegationConnector_SystemProvidedRole = null;

	/**
	 * The cached value of the '{@link #getInterface_SystemProvidedRole() <em>Interface System Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface_SystemProvidedRole()
	 * @generated
	 * @ordered
	 */
	protected Interface interface_SystemProvidedRole = null;


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
	public SystemProvidedDelegationConnector getProvidedDelegationConnector_SystemProvidedRole() {
		if (providedDelegationConnector_SystemProvidedRole != null && providedDelegationConnector_SystemProvidedRole.eIsProxy()) {
			InternalEObject oldProvidedDelegationConnector_SystemProvidedRole = (InternalEObject)providedDelegationConnector_SystemProvidedRole;
			providedDelegationConnector_SystemProvidedRole = (SystemProvidedDelegationConnector)eResolveProxy(oldProvidedDelegationConnector_SystemProvidedRole);
			if (providedDelegationConnector_SystemProvidedRole != oldProvidedDelegationConnector_SystemProvidedRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE, oldProvidedDelegationConnector_SystemProvidedRole, providedDelegationConnector_SystemProvidedRole));
			}
		}
		return providedDelegationConnector_SystemProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProvidedDelegationConnector basicGetProvidedDelegationConnector_SystemProvidedRole() {
		return providedDelegationConnector_SystemProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidedDelegationConnector_SystemProvidedRole(SystemProvidedDelegationConnector newProvidedDelegationConnector_SystemProvidedRole, NotificationChain msgs) {
		SystemProvidedDelegationConnector oldProvidedDelegationConnector_SystemProvidedRole = providedDelegationConnector_SystemProvidedRole;
		providedDelegationConnector_SystemProvidedRole = newProvidedDelegationConnector_SystemProvidedRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE, oldProvidedDelegationConnector_SystemProvidedRole, newProvidedDelegationConnector_SystemProvidedRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedDelegationConnector_SystemProvidedRole(SystemProvidedDelegationConnector newProvidedDelegationConnector_SystemProvidedRole) {
		if (newProvidedDelegationConnector_SystemProvidedRole != providedDelegationConnector_SystemProvidedRole) {
			NotificationChain msgs = null;
			if (providedDelegationConnector_SystemProvidedRole != null)
				msgs = ((InternalEObject)providedDelegationConnector_SystemProvidedRole).eInverseRemove(this, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, SystemProvidedDelegationConnector.class, msgs);
			if (newProvidedDelegationConnector_SystemProvidedRole != null)
				msgs = ((InternalEObject)newProvidedDelegationConnector_SystemProvidedRole).eInverseAdd(this, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, SystemProvidedDelegationConnector.class, msgs);
			msgs = basicSetProvidedDelegationConnector_SystemProvidedRole(newProvidedDelegationConnector_SystemProvidedRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE, newProvidedDelegationConnector_SystemProvidedRole, newProvidedDelegationConnector_SystemProvidedRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getInterface_SystemProvidedRole() {
		if (interface_SystemProvidedRole != null && interface_SystemProvidedRole.eIsProxy()) {
			InternalEObject oldInterface_SystemProvidedRole = (InternalEObject)interface_SystemProvidedRole;
			interface_SystemProvidedRole = (Interface)eResolveProxy(oldInterface_SystemProvidedRole);
			if (interface_SystemProvidedRole != oldInterface_SystemProvidedRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE, oldInterface_SystemProvidedRole, interface_SystemProvidedRole));
			}
		}
		return interface_SystemProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetInterface_SystemProvidedRole() {
		return interface_SystemProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface_SystemProvidedRole(Interface newInterface_SystemProvidedRole) {
		Interface oldInterface_SystemProvidedRole = interface_SystemProvidedRole;
		interface_SystemProvidedRole = newInterface_SystemProvidedRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE, oldInterface_SystemProvidedRole, interface_SystemProvidedRole));
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE:
				if (providedDelegationConnector_SystemProvidedRole != null)
					msgs = ((InternalEObject)providedDelegationConnector_SystemProvidedRole).eInverseRemove(this, SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR, SystemProvidedDelegationConnector.class, msgs);
				return basicSetProvidedDelegationConnector_SystemProvidedRole((SystemProvidedDelegationConnector)otherEnd, msgs);
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE:
				return basicSetProvidedDelegationConnector_SystemProvidedRole(null, msgs);
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE:
				if (resolve) return getProvidedDelegationConnector_SystemProvidedRole();
				return basicGetProvidedDelegationConnector_SystemProvidedRole();
			case SystemPackage.SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE:
				if (resolve) return getInterface_SystemProvidedRole();
				return basicGetInterface_SystemProvidedRole();
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE:
				setProvidedDelegationConnector_SystemProvidedRole((SystemProvidedDelegationConnector)newValue);
				return;
			case SystemPackage.SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE:
				setInterface_SystemProvidedRole((Interface)newValue);
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE:
				setProvidedDelegationConnector_SystemProvidedRole((SystemProvidedDelegationConnector)null);
				return;
			case SystemPackage.SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE:
				setInterface_SystemProvidedRole((Interface)null);
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
			case SystemPackage.SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE:
				return providedDelegationConnector_SystemProvidedRole != null;
			case SystemPackage.SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE:
				return interface_SystemProvidedRole != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemProvidedRoleImpl