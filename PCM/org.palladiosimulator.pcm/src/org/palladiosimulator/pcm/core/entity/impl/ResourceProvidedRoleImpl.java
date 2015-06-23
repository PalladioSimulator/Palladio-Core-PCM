/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.entity.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.palladiosimulator.pcm.core.entity.ResourceInterfaceProvidingEntity;
import org.palladiosimulator.pcm.core.entity.ResourceProvidedRole;

import org.palladiosimulator.pcm.repository.impl.RoleImpl;

import org.palladiosimulator.pcm.resourcetype.ResourceInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Provided Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.core.entity.impl.ResourceProvidedRoleImpl#getResourceInterfaceProvidingEntity__ResourceProvidedRole <em>Resource Interface Providing Entity Resource Provided Role</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.core.entity.impl.ResourceProvidedRoleImpl#getProvidedResourceInterface__ResourceProvidedRole <em>Provided Resource Interface Resource Provided Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceProvidedRoleImpl extends RoleImpl implements ResourceProvidedRole {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResourceProvidedRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EntityPackage.Literals.RESOURCE_PROVIDED_ROLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceInterfaceProvidingEntity getResourceInterfaceProvidingEntity__ResourceProvidedRole() {
        return (ResourceInterfaceProvidingEntity) eDynamicGet(
                EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE,
                EntityPackage.Literals.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceInterfaceProvidingEntity__ResourceProvidedRole(
            ResourceInterfaceProvidingEntity newResourceInterfaceProvidingEntity__ResourceProvidedRole,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceInterfaceProvidingEntity__ResourceProvidedRole,
                EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceInterfaceProvidingEntity__ResourceProvidedRole(
            ResourceInterfaceProvidingEntity newResourceInterfaceProvidingEntity__ResourceProvidedRole) {
        eDynamicSet(EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE,
                EntityPackage.Literals.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE,
                newResourceInterfaceProvidingEntity__ResourceProvidedRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceInterface getProvidedResourceInterface__ResourceProvidedRole() {
        return (ResourceInterface) eDynamicGet(
                EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE,
                EntityPackage.Literals.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceInterface basicGetProvidedResourceInterface__ResourceProvidedRole() {
        return (ResourceInterface) eDynamicGet(
                EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE,
                EntityPackage.Literals.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE,
                false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProvidedResourceInterface__ResourceProvidedRole(
            ResourceInterface newProvidedResourceInterface__ResourceProvidedRole) {
        eDynamicSet(EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE,
                EntityPackage.Literals.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE,
                newProvidedResourceInterface__ResourceProvidedRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceInterfaceProvidingEntity__ResourceProvidedRole(
                    (ResourceInterfaceProvidingEntity) otherEnd, msgs);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return basicSetResourceInterfaceProvidingEntity__ResourceProvidedRole(null, msgs);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return eInternalContainer().eInverseRemove(this,
                    EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY,
                    ResourceInterfaceProvidingEntity.class, msgs);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return getResourceInterfaceProvidingEntity__ResourceProvidedRole();
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            if (resolve)
                return getProvidedResourceInterface__ResourceProvidedRole();
            return basicGetProvidedResourceInterface__ResourceProvidedRole();
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            setResourceInterfaceProvidingEntity__ResourceProvidedRole((ResourceInterfaceProvidingEntity) newValue);
            return;
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            setProvidedResourceInterface__ResourceProvidedRole((ResourceInterface) newValue);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            setResourceInterfaceProvidingEntity__ResourceProvidedRole((ResourceInterfaceProvidingEntity) null);
            return;
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            setProvidedResourceInterface__ResourceProvidedRole((ResourceInterface) null);
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
        case EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE:
            return getResourceInterfaceProvidingEntity__ResourceProvidedRole() != null;
        case EntityPackage.RESOURCE_PROVIDED_ROLE__PROVIDED_RESOURCE_INTERFACE_RESOURCE_PROVIDED_ROLE:
            return basicGetProvidedResourceInterface__ResourceProvidedRole() != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourceProvidedRoleImpl
