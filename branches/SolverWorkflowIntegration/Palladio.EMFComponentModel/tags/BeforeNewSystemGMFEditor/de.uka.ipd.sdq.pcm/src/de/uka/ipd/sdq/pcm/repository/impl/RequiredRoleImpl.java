
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl#getRequiredInterface__RequiredRole <em>Required Interface Required Role</em>}</li>
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE:
				if (resolve) return getRequiredInterface__RequiredRole();
				return basicGetRequiredInterface__RequiredRole();
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
		}
		return super.eIsSet(featureID);
	}

} //RequiredRoleImpl