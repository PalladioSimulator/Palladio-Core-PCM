
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl#getProvidedInterface__ProvidedRole <em>Provided Interface Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl#getProvidingEntity_ProvidedRole <em>Providing Entity Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProvidedRoleImpl extends RoleImpl implements ProvidedRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getProvidedInterface__ProvidedRole() <em>Provided Interface Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterface__ProvidedRole()
	 * @generated
	 * @ordered
	 */
	protected Interface providedInterface__ProvidedRole = null;


	/**
	 * The cached value of the '{@link #getProvidingEntity_ProvidedRole() <em>Providing Entity Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidingEntity_ProvidedRole()
	 * @generated
	 * @ordered
	 */
	protected InterfaceProvidingEntity providingEntity_ProvidedRole = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidedRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.PROVIDED_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getProvidedInterface__ProvidedRole() {
		if (providedInterface__ProvidedRole != null && providedInterface__ProvidedRole.eIsProxy()) {
			InternalEObject oldProvidedInterface__ProvidedRole = (InternalEObject)providedInterface__ProvidedRole;
			providedInterface__ProvidedRole = (Interface)eResolveProxy(oldProvidedInterface__ProvidedRole);
			if (providedInterface__ProvidedRole != oldProvidedInterface__ProvidedRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE, oldProvidedInterface__ProvidedRole, providedInterface__ProvidedRole));
			}
		}
		return providedInterface__ProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetProvidedInterface__ProvidedRole() {
		return providedInterface__ProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedInterface__ProvidedRole(Interface newProvidedInterface__ProvidedRole) {
		Interface oldProvidedInterface__ProvidedRole = providedInterface__ProvidedRole;
		providedInterface__ProvidedRole = newProvidedInterface__ProvidedRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE, oldProvidedInterface__ProvidedRole, providedInterface__ProvidedRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingEntity getProvidingEntity_ProvidedRole() {
		if (providingEntity_ProvidedRole != null && providingEntity_ProvidedRole.eIsProxy()) {
			InternalEObject oldProvidingEntity_ProvidedRole = (InternalEObject)providingEntity_ProvidedRole;
			providingEntity_ProvidedRole = (InterfaceProvidingEntity)eResolveProxy(oldProvidingEntity_ProvidedRole);
			if (providingEntity_ProvidedRole != oldProvidingEntity_ProvidedRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE, oldProvidingEntity_ProvidedRole, providingEntity_ProvidedRole));
			}
		}
		return providingEntity_ProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingEntity basicGetProvidingEntity_ProvidedRole() {
		return providingEntity_ProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidingEntity_ProvidedRole(InterfaceProvidingEntity newProvidingEntity_ProvidedRole, NotificationChain msgs) {
		InterfaceProvidingEntity oldProvidingEntity_ProvidedRole = providingEntity_ProvidedRole;
		providingEntity_ProvidedRole = newProvidingEntity_ProvidedRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE, oldProvidingEntity_ProvidedRole, newProvidingEntity_ProvidedRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingEntity_ProvidedRole(InterfaceProvidingEntity newProvidingEntity_ProvidedRole) {
		if (newProvidingEntity_ProvidedRole != providingEntity_ProvidedRole) {
			NotificationChain msgs = null;
			if (providingEntity_ProvidedRole != null)
				msgs = ((InternalEObject)providingEntity_ProvidedRole).eInverseRemove(this, EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, InterfaceProvidingEntity.class, msgs);
			if (newProvidingEntity_ProvidedRole != null)
				msgs = ((InternalEObject)newProvidingEntity_ProvidedRole).eInverseAdd(this, EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, InterfaceProvidingEntity.class, msgs);
			msgs = basicSetProvidingEntity_ProvidedRole(newProvidingEntity_ProvidedRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE, newProvidingEntity_ProvidedRole, newProvidingEntity_ProvidedRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				if (providingEntity_ProvidedRole != null)
					msgs = ((InternalEObject)providingEntity_ProvidedRole).eInverseRemove(this, EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, InterfaceProvidingEntity.class, msgs);
				return basicSetProvidingEntity_ProvidedRole((InterfaceProvidingEntity)otherEnd, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				return basicSetProvidingEntity_ProvidedRole(null, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE:
				if (resolve) return getProvidedInterface__ProvidedRole();
				return basicGetProvidedInterface__ProvidedRole();
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				if (resolve) return getProvidingEntity_ProvidedRole();
				return basicGetProvidingEntity_ProvidedRole();
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE:
				setProvidedInterface__ProvidedRole((Interface)newValue);
				return;
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				setProvidingEntity_ProvidedRole((InterfaceProvidingEntity)newValue);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE:
				setProvidedInterface__ProvidedRole((Interface)null);
				return;
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				setProvidingEntity_ProvidedRole((InterfaceProvidingEntity)null);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE:
				return providedInterface__ProvidedRole != null;
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				return providingEntity_ProvidedRole != null;
		}
		return super.eIsSet(featureID);
	}

} //ProvidedRoleImpl