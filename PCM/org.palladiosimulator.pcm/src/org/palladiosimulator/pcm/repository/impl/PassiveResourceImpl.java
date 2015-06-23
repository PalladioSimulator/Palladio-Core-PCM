/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.reliability.ReliabilityPackage;
import org.palladiosimulator.pcm.reliability.ResourceTimeoutFailureType;

import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passive Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.PassiveResourceImpl#getCapacity_PassiveResource <em>Capacity Passive Resource</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.PassiveResourceImpl#getBasicComponent_PassiveResource <em>Basic Component Passive Resource</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.PassiveResourceImpl#getResourceTimeoutFailureType__PassiveResource <em>Resource Timeout Failure Type Passive Resource</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PassiveResourceImpl extends EntityImpl implements PassiveResource {

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
    protected PassiveResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.PASSIVE_RESOURCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getCapacity_PassiveResource() {
        return (PCMRandomVariable) eDynamicGet(RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE,
                RepositoryPackage.Literals.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCapacity_PassiveResource(PCMRandomVariable newCapacity_PassiveResource,
            NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newCapacity_PassiveResource,
                RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCapacity_PassiveResource(PCMRandomVariable newCapacity_PassiveResource) {
        eDynamicSet(RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE,
                RepositoryPackage.Literals.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, newCapacity_PassiveResource);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BasicComponent getBasicComponent_PassiveResource() {
        return (BasicComponent) eDynamicGet(RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE,
                RepositoryPackage.Literals.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBasicComponent_PassiveResource(BasicComponent newBasicComponent_PassiveResource,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newBasicComponent_PassiveResource,
                RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBasicComponent_PassiveResource(BasicComponent newBasicComponent_PassiveResource) {
        eDynamicSet(RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE,
                RepositoryPackage.Literals.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE,
                newBasicComponent_PassiveResource);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceTimeoutFailureType getResourceTimeoutFailureType__PassiveResource() {
        return (ResourceTimeoutFailureType) eDynamicGet(
                RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                RepositoryPackage.Literals.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceTimeoutFailureType basicGetResourceTimeoutFailureType__PassiveResource() {
        return (ResourceTimeoutFailureType) eDynamicGet(
                RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                RepositoryPackage.Literals.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE, false,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceTimeoutFailureType__PassiveResource(
            ResourceTimeoutFailureType newResourceTimeoutFailureType__PassiveResource, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newResourceTimeoutFailureType__PassiveResource,
                RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceTimeoutFailureType__PassiveResource(
            ResourceTimeoutFailureType newResourceTimeoutFailureType__PassiveResource) {
        eDynamicSet(RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                RepositoryPackage.Literals.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                newResourceTimeoutFailureType__PassiveResource);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            PCMRandomVariable capacity_PassiveResource = getCapacity_PassiveResource();
            if (capacity_PassiveResource != null)
                msgs = ((InternalEObject) capacity_PassiveResource).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, null,
                        msgs);
            return basicSetCapacity_PassiveResource((PCMRandomVariable) otherEnd, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetBasicComponent_PassiveResource((BasicComponent) otherEnd, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            ResourceTimeoutFailureType resourceTimeoutFailureType__PassiveResource = basicGetResourceTimeoutFailureType__PassiveResource();
            if (resourceTimeoutFailureType__PassiveResource != null)
                msgs = ((InternalEObject) resourceTimeoutFailureType__PassiveResource).eInverseRemove(this,
                        ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE,
                        ResourceTimeoutFailureType.class, msgs);
            return basicSetResourceTimeoutFailureType__PassiveResource((ResourceTimeoutFailureType) otherEnd, msgs);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            return basicSetCapacity_PassiveResource(null, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return basicSetBasicComponent_PassiveResource(null, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            return basicSetResourceTimeoutFailureType__PassiveResource(null, msgs);
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
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.BASIC_COMPONENT__PASSIVE_RESOURCE_BASIC_COMPONENT, BasicComponent.class, msgs);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            return getCapacity_PassiveResource();
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return getBasicComponent_PassiveResource();
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            if (resolve)
                return getResourceTimeoutFailureType__PassiveResource();
            return basicGetResourceTimeoutFailureType__PassiveResource();
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            setCapacity_PassiveResource((PCMRandomVariable) newValue);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            setBasicComponent_PassiveResource((BasicComponent) newValue);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            setResourceTimeoutFailureType__PassiveResource((ResourceTimeoutFailureType) newValue);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            setCapacity_PassiveResource((PCMRandomVariable) null);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            setBasicComponent_PassiveResource((BasicComponent) null);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            setResourceTimeoutFailureType__PassiveResource((ResourceTimeoutFailureType) null);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            return getCapacity_PassiveResource() != null;
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return getBasicComponent_PassiveResource() != null;
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            return basicGetResourceTimeoutFailureType__PassiveResource() != null;
        }
        return super.eIsSet(featureID);
    }

} //PassiveResourceImpl
