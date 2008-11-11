/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;

import de.uka.ipd.sdq.pcm.repository.impl.RoleImpl;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Required Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl#getRequiredResourceInterface_ResourceRequiredRole <em>Required Resource Interface Resource Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRequiredRoleImpl#getResourceRequiringEntity_ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}</li>
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
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getRequiredResourceInterface_ResourceRequiredRole() <em>Required Resource Interface Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredResourceInterface_ResourceRequiredRole()
	 * @generated
	 * @ordered
	 */
	protected ResourceInterface requiredResourceInterface_ResourceRequiredRole;

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
		return ResourcetypePackage.Literals.RESOURCE_REQUIRED_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface getRequiredResourceInterface_ResourceRequiredRole() {
		if (requiredResourceInterface_ResourceRequiredRole != null && requiredResourceInterface_ResourceRequiredRole.eIsProxy()) {
			InternalEObject oldRequiredResourceInterface_ResourceRequiredRole = (InternalEObject)requiredResourceInterface_ResourceRequiredRole;
			requiredResourceInterface_ResourceRequiredRole = (ResourceInterface)eResolveProxy(oldRequiredResourceInterface_ResourceRequiredRole);
			if (requiredResourceInterface_ResourceRequiredRole != oldRequiredResourceInterface_ResourceRequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE, oldRequiredResourceInterface_ResourceRequiredRole, requiredResourceInterface_ResourceRequiredRole));
			}
		}
		return requiredResourceInterface_ResourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface basicGetRequiredResourceInterface_ResourceRequiredRole() {
		return requiredResourceInterface_ResourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredResourceInterface_ResourceRequiredRole(ResourceInterface newRequiredResourceInterface_ResourceRequiredRole) {
		ResourceInterface oldRequiredResourceInterface_ResourceRequiredRole = requiredResourceInterface_ResourceRequiredRole;
		requiredResourceInterface_ResourceRequiredRole = newRequiredResourceInterface_ResourceRequiredRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE, oldRequiredResourceInterface_ResourceRequiredRole, requiredResourceInterface_ResourceRequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterfaceRequiringEntity getResourceRequiringEntity_ResourceRequiredRole() {
		if (eContainerFeatureID != ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE) return null;
		return (ResourceInterfaceRequiringEntity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceRequiringEntity_ResourceRequiredRole(ResourceInterfaceRequiringEntity newResourceRequiringEntity_ResourceRequiredRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceRequiringEntity_ResourceRequiredRole, ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiringEntity_ResourceRequiredRole(ResourceInterfaceRequiringEntity newResourceRequiringEntity_ResourceRequiredRole) {
		if (newResourceRequiringEntity_ResourceRequiredRole != eInternalContainer() || (eContainerFeatureID != ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE && newResourceRequiringEntity_ResourceRequiredRole != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE, newResourceRequiringEntity_ResourceRequiredRole, newResourceRequiringEntity_ResourceRequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
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
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
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
		switch (eContainerFeatureID) {
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
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
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
				if (resolve) return getRequiredResourceInterface_ResourceRequiredRole();
				return basicGetRequiredResourceInterface_ResourceRequiredRole();
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
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
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
				setRequiredResourceInterface_ResourceRequiredRole((ResourceInterface)newValue);
				return;
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
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
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
				setRequiredResourceInterface_ResourceRequiredRole((ResourceInterface)null);
				return;
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
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
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__REQUIRED_RESOURCE_INTERFACE_RESOURCE_REQUIRED_ROLE:
				return requiredResourceInterface_ResourceRequiredRole != null;
			case ResourcetypePackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE:
				return getResourceRequiringEntity_ResourceRequiredRole() != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceRequiredRoleImpl
