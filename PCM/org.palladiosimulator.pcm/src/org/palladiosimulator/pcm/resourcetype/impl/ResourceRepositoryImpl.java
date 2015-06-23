/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourcetype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.resourcetype.ResourceInterface;
import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.resourcetype.ResourceType;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;
import org.palladiosimulator.pcm.resourcetype.SchedulingPolicy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceRepositoryImpl#getResourceInterfaces__ResourceRepository <em>Resource Interfaces Resource Repository</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceRepositoryImpl#getSchedulingPolicies__ResourceRepository <em>Scheduling Policies Resource Repository</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.ResourceRepositoryImpl#getAvailableResourceTypes_ResourceRepository <em>Available Resource Types Resource Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceRepositoryImpl extends CDOObjectImpl implements ResourceRepository {

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
    protected ResourceRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.RESOURCE_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ResourceInterface> getResourceInterfaces__ResourceRepository() {
        return (EList<ResourceInterface>) eDynamicGet(
                ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY,
                ResourcetypePackage.Literals.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<SchedulingPolicy> getSchedulingPolicies__ResourceRepository() {
        return (EList<SchedulingPolicy>) eDynamicGet(
                ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY,
                ResourcetypePackage.Literals.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ResourceType> getAvailableResourceTypes_ResourceRepository() {
        return (EList<ResourceType>) eDynamicGet(
                ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY,
                ResourcetypePackage.Literals.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY, true,
                true);
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getResourceInterfaces__ResourceRepository())
                    .basicAdd(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getSchedulingPolicies__ResourceRepository())
                    .basicAdd(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getAvailableResourceTypes_ResourceRepository())
                    .basicAdd(otherEnd, msgs);
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return ((InternalEList<?>) getResourceInterfaces__ResourceRepository()).basicRemove(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return ((InternalEList<?>) getSchedulingPolicies__ResourceRepository()).basicRemove(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return ((InternalEList<?>) getAvailableResourceTypes_ResourceRepository()).basicRemove(otherEnd, msgs);
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return getResourceInterfaces__ResourceRepository();
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return getSchedulingPolicies__ResourceRepository();
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return getAvailableResourceTypes_ResourceRepository();
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            getResourceInterfaces__ResourceRepository().clear();
            getResourceInterfaces__ResourceRepository().addAll((Collection<? extends ResourceInterface>) newValue);
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            getSchedulingPolicies__ResourceRepository().clear();
            getSchedulingPolicies__ResourceRepository().addAll((Collection<? extends SchedulingPolicy>) newValue);
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            getAvailableResourceTypes_ResourceRepository().clear();
            getAvailableResourceTypes_ResourceRepository().addAll((Collection<? extends ResourceType>) newValue);
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            getResourceInterfaces__ResourceRepository().clear();
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            getSchedulingPolicies__ResourceRepository().clear();
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            getAvailableResourceTypes_ResourceRepository().clear();
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return !getResourceInterfaces__ResourceRepository().isEmpty();
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return !getSchedulingPolicies__ResourceRepository().isEmpty();
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return !getAvailableResourceTypes_ResourceRepository().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ResourceRepositoryImpl
