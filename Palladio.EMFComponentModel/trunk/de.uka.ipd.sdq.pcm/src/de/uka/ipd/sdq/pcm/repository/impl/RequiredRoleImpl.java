
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl#getRequiredInterface__RequiredRole <em>Required Interface Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl#getRequiringEntity_RequiredRole <em>Requiring Entity Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredRoleImpl extends RoleImpl implements RequiredRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getRequiredInterface__RequiredRole() <em>Required Interface Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterface__RequiredRole()
	 * @generated
	 * @ordered
	 */
	protected Interface requiredInterface__RequiredRole = null;


	/**
	 * The cached value of the '{@link #getRequiringEntity_RequiredRole() <em>Requiring Entity Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiringEntity_RequiredRole()
	 * @generated
	 * @ordered
	 */
	protected InterfaceRequiringEntity requiringEntity_RequiredRole = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.REQUIRED_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getRequiredInterface__RequiredRole() {
		if (requiredInterface__RequiredRole != null && requiredInterface__RequiredRole.eIsProxy()) {
			InternalEObject oldRequiredInterface__RequiredRole = (InternalEObject)requiredInterface__RequiredRole;
			requiredInterface__RequiredRole = (Interface)eResolveProxy(oldRequiredInterface__RequiredRole);
			if (requiredInterface__RequiredRole != oldRequiredInterface__RequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE, oldRequiredInterface__RequiredRole, requiredInterface__RequiredRole));
			}
		}
		return requiredInterface__RequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetRequiredInterface__RequiredRole() {
		return requiredInterface__RequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredInterface__RequiredRole(Interface newRequiredInterface__RequiredRole) {
		Interface oldRequiredInterface__RequiredRole = requiredInterface__RequiredRole;
		requiredInterface__RequiredRole = newRequiredInterface__RequiredRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE, oldRequiredInterface__RequiredRole, requiredInterface__RequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceRequiringEntity getRequiringEntity_RequiredRole() {
		if (requiringEntity_RequiredRole != null && requiringEntity_RequiredRole.eIsProxy()) {
			InternalEObject oldRequiringEntity_RequiredRole = (InternalEObject)requiringEntity_RequiredRole;
			requiringEntity_RequiredRole = (InterfaceRequiringEntity)eResolveProxy(oldRequiringEntity_RequiredRole);
			if (requiringEntity_RequiredRole != oldRequiringEntity_RequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE, oldRequiringEntity_RequiredRole, requiringEntity_RequiredRole));
			}
		}
		return requiringEntity_RequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceRequiringEntity basicGetRequiringEntity_RequiredRole() {
		return requiringEntity_RequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiringEntity_RequiredRole(InterfaceRequiringEntity newRequiringEntity_RequiredRole, NotificationChain msgs) {
		InterfaceRequiringEntity oldRequiringEntity_RequiredRole = requiringEntity_RequiredRole;
		requiringEntity_RequiredRole = newRequiringEntity_RequiredRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE, oldRequiringEntity_RequiredRole, newRequiringEntity_RequiredRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiringEntity_RequiredRole(InterfaceRequiringEntity newRequiringEntity_RequiredRole) {
		if (newRequiringEntity_RequiredRole != requiringEntity_RequiredRole) {
			NotificationChain msgs = null;
			if (requiringEntity_RequiredRole != null)
				msgs = ((InternalEObject)requiringEntity_RequiredRole).eInverseRemove(this, EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY, InterfaceRequiringEntity.class, msgs);
			if (newRequiringEntity_RequiredRole != null)
				msgs = ((InternalEObject)newRequiringEntity_RequiredRole).eInverseAdd(this, EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY, InterfaceRequiringEntity.class, msgs);
			msgs = basicSetRequiringEntity_RequiredRole(newRequiringEntity_RequiredRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE, newRequiringEntity_RequiredRole, newRequiringEntity_RequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
				if (requiringEntity_RequiredRole != null)
					msgs = ((InternalEObject)requiringEntity_RequiredRole).eInverseRemove(this, EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY, InterfaceRequiringEntity.class, msgs);
				return basicSetRequiringEntity_RequiredRole((InterfaceRequiringEntity)otherEnd, msgs);
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
			case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
				return basicSetRequiringEntity_RequiredRole(null, msgs);
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
			case RepositoryPackage.REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE:
				if (resolve) return getRequiredInterface__RequiredRole();
				return basicGetRequiredInterface__RequiredRole();
			case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
				if (resolve) return getRequiringEntity_RequiredRole();
				return basicGetRequiringEntity_RequiredRole();
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
			case RepositoryPackage.REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE:
				setRequiredInterface__RequiredRole((Interface)newValue);
				return;
			case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
				setRequiringEntity_RequiredRole((InterfaceRequiringEntity)newValue);
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
			case RepositoryPackage.REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE:
				setRequiredInterface__RequiredRole((Interface)null);
				return;
			case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
				setRequiringEntity_RequiredRole((InterfaceRequiringEntity)null);
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
			case RepositoryPackage.REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE:
				return requiredInterface__RequiredRole != null;
			case RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE:
				return requiringEntity_RequiredRole != null;
		}
		return super.eIsSet(featureID);
	}

} //RequiredRoleImpl