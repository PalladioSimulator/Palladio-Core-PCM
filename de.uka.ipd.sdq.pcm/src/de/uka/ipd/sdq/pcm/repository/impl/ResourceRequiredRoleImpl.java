/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Required Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl#getRequiredInterface__ResourceRequiredRole <em>Required Interface Resource Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl#getResourceRequiringEntity__ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceRequiredRoleImpl extends RoleImpl implements ResourceRequiredRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getRequiredInterface__ResourceRequiredRole() <em>Required Interface Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterface__ResourceRequiredRole()
	 * @generated
	 * @ordered
	 */
	protected Interface requiredInterface__ResourceRequiredRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceRequiredRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.RESOURCE_REQUIRED_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getRequiredInterface__ResourceRequiredRole() {
		if (requiredInterface__ResourceRequiredRole != null && requiredInterface__ResourceRequiredRole.eIsProxy()) {
			InternalEObject oldRequiredInterface__ResourceRequiredRole = (InternalEObject)requiredInterface__ResourceRequiredRole;
			requiredInterface__ResourceRequiredRole = (Interface)eResolveProxy(oldRequiredInterface__ResourceRequiredRole);
			if (requiredInterface__ResourceRequiredRole != oldRequiredInterface__ResourceRequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE, oldRequiredInterface__ResourceRequiredRole, requiredInterface__ResourceRequiredRole));
			}
		}
		return requiredInterface__ResourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetRequiredInterface__ResourceRequiredRole() {
		return requiredInterface__ResourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredInterface__ResourceRequiredRole(Interface newRequiredInterface__ResourceRequiredRole) {
		Interface oldRequiredInterface__ResourceRequiredRole = requiredInterface__ResourceRequiredRole;
		requiredInterface__ResourceRequiredRole = newRequiredInterface__ResourceRequiredRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE, oldRequiredInterface__ResourceRequiredRole, requiredInterface__ResourceRequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterfaceRequiringEntity getResourceRequiringEntity__ResourceRequiredRole() {
		if (eContainerFeatureID() != RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE) return null;
		return (ResourceInterfaceRequiringEntity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceRequiringEntity__ResourceRequiredRole(ResourceInterfaceRequiringEntity newResourceRequiringEntity__ResourceRequiredRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceRequiringEntity__ResourceRequiredRole, RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiringEntity__ResourceRequiredRole(ResourceInterfaceRequiringEntity newResourceRequiringEntity__ResourceRequiredRole) {
		if (newResourceRequiringEntity__ResourceRequiredRole != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE && newResourceRequiringEntity__ResourceRequiredRole != null)) {
			if (EcoreUtil.isAncestor(this, newResourceRequiringEntity__ResourceRequiredRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceRequiringEntity__ResourceRequiredRole != null)
				msgs = ((InternalEObject)newResourceRequiringEntity__ResourceRequiredRole).eInverseAdd(this, EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY, ResourceInterfaceRequiringEntity.class, msgs);
			msgs = basicSetResourceRequiringEntity__ResourceRequiredRole(newResourceRequiringEntity__ResourceRequiredRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE, newResourceRequiringEntity__ResourceRequiredRole, newResourceRequiringEntity__ResourceRequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceRequiringEntity__ResourceRequiredRole((ResourceInterfaceRequiringEntity)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				return basicSetResourceRequiringEntity__ResourceRequiredRole(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				return eInternalContainer().eInverseRemove(this, EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY, ResourceInterfaceRequiringEntity.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE:
				if (resolve) return getRequiredInterface__ResourceRequiredRole();
				return basicGetRequiredInterface__ResourceRequiredRole();
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				return getResourceRequiringEntity__ResourceRequiredRole();
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
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE:
				setRequiredInterface__ResourceRequiredRole((Interface)newValue);
				return;
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				setResourceRequiringEntity__ResourceRequiredRole((ResourceInterfaceRequiringEntity)newValue);
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
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE:
				setRequiredInterface__ResourceRequiredRole((Interface)null);
				return;
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				setResourceRequiringEntity__ResourceRequiredRole((ResourceInterfaceRequiringEntity)null);
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
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE:
				return requiredInterface__ResourceRequiredRole != null;
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				return getResourceRequiringEntity__ResourceRequiredRole() != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceRequiredRoleImpl
