/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Interface Requiring Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceRequiringEntityImpl#getResourceRequiredRoles_ResourceInterfaceRequiringEntity <em>Resource Required Roles Resource Interface Requiring Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceInterfaceRequiringEntityImpl extends EntityImpl implements ResourceInterfaceRequiringEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";
	/**
	 * The cached value of the '{@link #getResourceRequiredRoles_ResourceInterfaceRequiringEntity() <em>Resource Required Roles Resource Interface Requiring Entity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequiredRoles_ResourceInterfaceRequiringEntity()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRequiredRole> resourceRequiredRoles_ResourceInterfaceRequiringEntity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceInterfaceRequiringEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.RESOURCE_INTERFACE_REQUIRING_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRequiredRole> getResourceRequiredRoles_ResourceInterfaceRequiringEntity() {
		if (resourceRequiredRoles_ResourceInterfaceRequiringEntity == null) {
			resourceRequiredRoles_ResourceInterfaceRequiringEntity = new EObjectContainmentWithInverseEList<ResourceRequiredRole>(ResourceRequiredRole.class, this, EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY, RepositoryPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE);
		}
		return resourceRequiredRoles_ResourceInterfaceRequiringEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceRequiredRoles_ResourceInterfaceRequiringEntity()).basicAdd(otherEnd, msgs);
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
			case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
				return ((InternalEList<?>)getResourceRequiredRoles_ResourceInterfaceRequiringEntity()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
				return getResourceRequiredRoles_ResourceInterfaceRequiringEntity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
				getResourceRequiredRoles_ResourceInterfaceRequiringEntity().clear();
				getResourceRequiredRoles_ResourceInterfaceRequiringEntity().addAll((Collection<? extends ResourceRequiredRole>)newValue);
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
			case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
				getResourceRequiredRoles_ResourceInterfaceRequiringEntity().clear();
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
			case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
				return resourceRequiredRoles_ResourceInterfaceRequiringEntity != null && !resourceRequiredRoles_ResourceInterfaceRequiringEntity.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceInterfaceRequiringEntityImpl
