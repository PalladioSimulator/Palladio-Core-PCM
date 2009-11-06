/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
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
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl#getRequiredInterface_ResourceRequiredRole <em>Required Interface Resource Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceRequiredRoleImpl#getResourceRequiringEntity_ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}</li>
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
	 * The cached value of the '{@link #getRequiredInterface_ResourceRequiredRole() <em>Required Interface Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterface_ResourceRequiredRole()
	 * @generated
	 * @ordered
	 */
	protected Interface requiredInterface_ResourceRequiredRole;

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
	public Interface getRequiredInterface_ResourceRequiredRole() {
		if (requiredInterface_ResourceRequiredRole != null && requiredInterface_ResourceRequiredRole.eIsProxy()) {
			InternalEObject oldRequiredInterface_ResourceRequiredRole = (InternalEObject)requiredInterface_ResourceRequiredRole;
			requiredInterface_ResourceRequiredRole = (Interface)eResolveProxy(oldRequiredInterface_ResourceRequiredRole);
			if (requiredInterface_ResourceRequiredRole != oldRequiredInterface_ResourceRequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE, oldRequiredInterface_ResourceRequiredRole, requiredInterface_ResourceRequiredRole));
			}
		}
		return requiredInterface_ResourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetRequiredInterface_ResourceRequiredRole() {
		return requiredInterface_ResourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredInterface_ResourceRequiredRole(Interface newRequiredInterface_ResourceRequiredRole) {
		Interface oldRequiredInterface_ResourceRequiredRole = requiredInterface_ResourceRequiredRole;
		requiredInterface_ResourceRequiredRole = newRequiredInterface_ResourceRequiredRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_REQUIRED_ROLE__REQUIRED_INTERFACE_RESOURCE_REQUIRED_ROLE, oldRequiredInterface_ResourceRequiredRole, requiredInterface_ResourceRequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterfaceRequiringEntity getResourceRequiringEntity_ResourceRequiredRole() {
		if (eContainerFeatureID() != RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE) return null;
		return (ResourceInterfaceRequiringEntity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceRequiringEntity_ResourceRequiredRole(ResourceInterfaceRequiringEntity newResourceRequiringEntity_ResourceRequiredRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceRequiringEntity_ResourceRequiredRole, RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiringEntity_ResourceRequiredRole(ResourceInterfaceRequiringEntity newResourceRequiringEntity_ResourceRequiredRole) {
		if (newResourceRequiringEntity_ResourceRequiredRole != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE && newResourceRequiringEntity_ResourceRequiredRole != null)) {
			if (EcoreUtil.isAncestor(this, newResourceRequiringEntity_ResourceRequiredRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceRequiringEntity_ResourceRequiredRole != null)
				msgs = ((InternalEObject)newResourceRequiringEntity_ResourceRequiredRole).eInverseAdd(this, EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY, ResourceInterfaceRequiringEntity.class, msgs);
			msgs = basicSetResourceRequiringEntity_ResourceRequiredRole(newResourceRequiringEntity_ResourceRequiredRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE, newResourceRequiringEntity_ResourceRequiredRole, newResourceRequiringEntity_ResourceRequiredRole));
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
				return basicSetResourceRequiringEntity_ResourceRequiredRole((ResourceInterfaceRequiringEntity)otherEnd, msgs);
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
				return basicSetResourceRequiringEntity_ResourceRequiredRole(null, msgs);
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
				if (resolve) return getRequiredInterface_ResourceRequiredRole();
				return basicGetRequiredInterface_ResourceRequiredRole();
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				return getResourceRequiringEntity_ResourceRequiredRole();
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
				setRequiredInterface_ResourceRequiredRole((Interface)newValue);
				return;
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				setResourceRequiringEntity_ResourceRequiredRole((ResourceInterfaceRequiringEntity)newValue);
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
				setRequiredInterface_ResourceRequiredRole((Interface)null);
				return;
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				setResourceRequiringEntity_ResourceRequiredRole((ResourceInterfaceRequiringEntity)null);
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
				return requiredInterface_ResourceRequiredRole != null;
			case RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				return getResourceRequiringEntity_ResourceRequiredRole() != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceRequiredRoleImpl
