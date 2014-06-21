/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Scheduling Policy</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourcetype.impl.SchedulingPolicyImpl#getResourceRepository__SchedulingPolicy
 * <em>Resource Repository Scheduling Policy</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SchedulingPolicyImpl extends EntityImpl implements SchedulingPolicy {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SchedulingPolicyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.SCHEDULING_POLICY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceRepository getResourceRepository__SchedulingPolicy() {
        if (this.eContainerFeatureID() != ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY) {
            return null;
        }
        return (ResourceRepository) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceRepository__SchedulingPolicy(
            final ResourceRepository newResourceRepository__SchedulingPolicy, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newResourceRepository__SchedulingPolicy,
                ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceRepository__SchedulingPolicy(final ResourceRepository newResourceRepository__SchedulingPolicy) {
        if (newResourceRepository__SchedulingPolicy != this.eInternalContainer()
                || (this.eContainerFeatureID() != ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY && newResourceRepository__SchedulingPolicy != null)) {
            if (EcoreUtil.isAncestor(this, newResourceRepository__SchedulingPolicy)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newResourceRepository__SchedulingPolicy != null) {
                msgs = ((InternalEObject) newResourceRepository__SchedulingPolicy).eInverseAdd(this,
                        ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY,
                        ResourceRepository.class, msgs);
            }
            msgs = this.basicSetResourceRepository__SchedulingPolicy(newResourceRepository__SchedulingPolicy, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY,
                    newResourceRepository__SchedulingPolicy, newResourceRepository__SchedulingPolicy));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceRepository__SchedulingPolicy((ResourceRepository) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return this.basicSetResourceRepository__SchedulingPolicy(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return this.eInternalContainer().eInverseRemove(this,
                    ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY,
                    ResourceRepository.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return this.getResourceRepository__SchedulingPolicy();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            this.setResourceRepository__SchedulingPolicy((ResourceRepository) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            this.setResourceRepository__SchedulingPolicy((ResourceRepository) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY:
            return this.getResourceRepository__SchedulingPolicy() != null;
        }
        return super.eIsSet(featureID);
    }

} // SchedulingPolicyImpl
