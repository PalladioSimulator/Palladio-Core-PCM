/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourcetype.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;
import org.palladiosimulator.pcm.resourcetype.SchedulingPolicy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourcetype.impl.SchedulingPolicyImpl#getResourceRepository__SchedulingPolicy <em>Resource Repository Scheduling Policy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulingPolicyImpl extends EntityImpl implements SchedulingPolicy {

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
    protected SchedulingPolicyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.SCHEDULING_POLICY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceRepository getResourceRepository__SchedulingPolicy() {
        return (ResourceRepository) eDynamicGet(
                ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY,
                ResourcetypePackage.Literals.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceRepository__SchedulingPolicy(
            ResourceRepository newResourceRepository__SchedulingPolicy, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceRepository__SchedulingPolicy,
                ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceRepository__SchedulingPolicy(ResourceRepository newResourceRepository__SchedulingPolicy) {
        eDynamicSet(ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY,
                ResourcetypePackage.Literals.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY,
                newResourceRepository__SchedulingPolicy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceRepository__SchedulingPolicy((ResourceRepository) otherEnd, msgs);
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
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return basicSetResourceRepository__SchedulingPolicy(null, msgs);
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
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return eInternalContainer().eInverseRemove(this,
                    ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY,
                    ResourceRepository.class, msgs);
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
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return getResourceRepository__SchedulingPolicy();
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
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            setResourceRepository__SchedulingPolicy((ResourceRepository) newValue);
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
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            setResourceRepository__SchedulingPolicy((ResourceRepository) null);
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
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return getResourceRepository__SchedulingPolicy() != null;
        }
        return super.eIsSet(featureID);
    }

} //SchedulingPolicyImpl
