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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Interface Providing Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceProvidingEntityImpl#getResourceProvidedRole_ResourceInterfaceProvidingEntity <em>Resource Provided Role Resource Interface Providing Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceInterfaceProvidingEntityImpl extends EntityImpl implements ResourceInterfaceProvidingEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceProvidedRole_ResourceInterfaceProvidingEntity() <em>Resource Provided Role Resource Interface Providing Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceProvidedRole_ResourceInterfaceProvidingEntity()
	 * @generated
	 * @ordered
	 */
	protected ResourceProvidedRole resourceProvidedRole_ResourceInterfaceProvidingEntity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceInterfaceProvidingEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.RESOURCE_INTERFACE_PROVIDING_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceProvidedRole getResourceProvidedRole_ResourceInterfaceProvidingEntity() {
		return resourceProvidedRole_ResourceInterfaceProvidingEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceProvidedRole_ResourceInterfaceProvidingEntity(ResourceProvidedRole newResourceProvidedRole_ResourceInterfaceProvidingEntity, NotificationChain msgs) {
		ResourceProvidedRole oldResourceProvidedRole_ResourceInterfaceProvidingEntity = resourceProvidedRole_ResourceInterfaceProvidingEntity;
		resourceProvidedRole_ResourceInterfaceProvidingEntity = newResourceProvidedRole_ResourceInterfaceProvidingEntity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY, oldResourceProvidedRole_ResourceInterfaceProvidingEntity, newResourceProvidedRole_ResourceInterfaceProvidingEntity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceProvidedRole_ResourceInterfaceProvidingEntity(ResourceProvidedRole newResourceProvidedRole_ResourceInterfaceProvidingEntity) {
		if (newResourceProvidedRole_ResourceInterfaceProvidingEntity != resourceProvidedRole_ResourceInterfaceProvidingEntity) {
			NotificationChain msgs = null;
			if (resourceProvidedRole_ResourceInterfaceProvidingEntity != null)
				msgs = ((InternalEObject)resourceProvidedRole_ResourceInterfaceProvidingEntity).eInverseRemove(this, ResourcetypePackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE, ResourceProvidedRole.class, msgs);
			if (newResourceProvidedRole_ResourceInterfaceProvidingEntity != null)
				msgs = ((InternalEObject)newResourceProvidedRole_ResourceInterfaceProvidingEntity).eInverseAdd(this, ResourcetypePackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE, ResourceProvidedRole.class, msgs);
			msgs = basicSetResourceProvidedRole_ResourceInterfaceProvidingEntity(newResourceProvidedRole_ResourceInterfaceProvidingEntity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY, newResourceProvidedRole_ResourceInterfaceProvidingEntity, newResourceProvidedRole_ResourceInterfaceProvidingEntity));
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
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				if (resourceProvidedRole_ResourceInterfaceProvidingEntity != null)
					msgs = ((InternalEObject)resourceProvidedRole_ResourceInterfaceProvidingEntity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY, null, msgs);
				return basicSetResourceProvidedRole_ResourceInterfaceProvidingEntity((ResourceProvidedRole)otherEnd, msgs);
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
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				return basicSetResourceProvidedRole_ResourceInterfaceProvidingEntity(null, msgs);
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
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				return getResourceProvidedRole_ResourceInterfaceProvidingEntity();
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
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				setResourceProvidedRole_ResourceInterfaceProvidingEntity((ResourceProvidedRole)newValue);
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
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				setResourceProvidedRole_ResourceInterfaceProvidingEntity((ResourceProvidedRole)null);
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
			case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLE_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				return resourceProvidedRole_ResourceInterfaceProvidingEntity != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceInterfaceProvidingEntityImpl
