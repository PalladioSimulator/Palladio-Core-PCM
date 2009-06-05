
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl#getProvidedInterface__ProvidedRole <em>Provided Interface Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl#getProvidingComponent__ProvidedRole <em>Providing Component Provided Role</em>}</li>
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
	public ProvidesComponentType getProvidingComponent__ProvidedRole() {
		if (eContainerFeatureID != RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE) return null;
		return (ProvidesComponentType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidingComponent__ProvidedRole(ProvidesComponentType newProvidingComponent__ProvidedRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newProvidingComponent__ProvidedRole, RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingComponent__ProvidedRole(ProvidesComponentType newProvidingComponent__ProvidedRole) {
		if (newProvidingComponent__ProvidedRole != eInternalContainer() || (eContainerFeatureID != RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE && newProvidingComponent__ProvidedRole != null)) {
			if (EcoreUtil.isAncestor(this, newProvidingComponent__ProvidedRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProvidingComponent__ProvidedRole != null)
				msgs = ((InternalEObject)newProvidingComponent__ProvidedRole).eInverseAdd(this, RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE, ProvidesComponentType.class, msgs);
			msgs = basicSetProvidingComponent__ProvidedRole(newProvidingComponent__ProvidedRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE, newProvidingComponent__ProvidedRole, newProvidingComponent__ProvidedRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProvidingComponent__ProvidedRole((ProvidesComponentType)otherEnd, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE:
				return basicSetProvidingComponent__ProvidedRole(null, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE, ProvidesComponentType.class, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE:
				if (resolve) return getProvidedInterface__ProvidedRole();
				return basicGetProvidedInterface__ProvidedRole();
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE:
				return getProvidingComponent__ProvidedRole();
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE:
				setProvidingComponent__ProvidedRole((ProvidesComponentType)newValue);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE:
				setProvidingComponent__ProvidedRole((ProvidesComponentType)null);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE:
				return getProvidingComponent__ProvidedRole() != null;
		}
		return super.eIsSet(featureID);
	}

} //ProvidedRoleImpl