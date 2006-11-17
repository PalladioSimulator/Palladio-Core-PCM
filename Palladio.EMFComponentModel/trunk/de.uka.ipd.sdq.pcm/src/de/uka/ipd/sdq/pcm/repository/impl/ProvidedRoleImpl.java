
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE:
				if (resolve) return getProvidedInterface__ProvidedRole();
				return basicGetProvidedInterface__ProvidedRole();
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
		}
		return super.eIsSet(featureID);
	}

} //ProvidedRoleImpl