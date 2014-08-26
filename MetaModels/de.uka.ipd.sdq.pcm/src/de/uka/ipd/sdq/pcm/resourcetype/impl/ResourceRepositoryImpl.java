/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl#getResourceInterfaces__ResourceRepository
 * <em>Resource Interfaces Resource Repository</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl#getSchedulingPolicies__ResourceRepository
 * <em>Scheduling Policies Resource Repository</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl#getAvailableResourceTypes_ResourceRepository
 * <em>Available Resource Types Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceRepositoryImpl extends EStereotypableObjectImpl implements ResourceRepository {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the ' {@link #getResourceInterfaces__ResourceRepository()
     * <em>Resource Interfaces Resource Repository</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceInterfaces__ResourceRepository()
     * @generated
     * @ordered
     */
    protected EList<ResourceInterface> resourceInterfaces__ResourceRepository;

    /**
     * The cached value of the ' {@link #getSchedulingPolicies__ResourceRepository()
     * <em>Scheduling Policies Resource Repository</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSchedulingPolicies__ResourceRepository()
     * @generated
     * @ordered
     */
    protected EList<SchedulingPolicy> schedulingPolicies__ResourceRepository;

    /**
     * The cached value of the ' {@link #getAvailableResourceTypes_ResourceRepository()
     * <em>Available Resource Types Resource Repository</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAvailableResourceTypes_ResourceRepository()
     * @generated
     * @ordered
     */
    protected EList<ResourceType> availableResourceTypes_ResourceRepository;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.RESOURCE_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ResourceInterface> getResourceInterfaces__ResourceRepository() {
        if (this.resourceInterfaces__ResourceRepository == null) {
            this.resourceInterfaces__ResourceRepository = new EObjectContainmentWithInverseEList<ResourceInterface>(
                    ResourceInterface.class, this,
                    ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY,
                    ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_REPOSITORY_RESOURCE_INTERFACE);
        }
        return this.resourceInterfaces__ResourceRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<SchedulingPolicy> getSchedulingPolicies__ResourceRepository() {
        if (this.schedulingPolicies__ResourceRepository == null) {
            this.schedulingPolicies__ResourceRepository = new EObjectContainmentWithInverseEList<SchedulingPolicy>(
                    SchedulingPolicy.class, this,
                    ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY,
                    ResourcetypePackage.SCHEDULING_POLICY__RESOURCE_REPOSITORY_SCHEDULING_POLICY);
        }
        return this.schedulingPolicies__ResourceRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ResourceType> getAvailableResourceTypes_ResourceRepository() {
        if (this.availableResourceTypes_ResourceRepository == null) {
            this.availableResourceTypes_ResourceRepository = new EObjectContainmentWithInverseEList<ResourceType>(
                    ResourceType.class, this,
                    ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY,
                    ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE);
        }
        return this.availableResourceTypes_ResourceRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getResourceInterfaces__ResourceRepository()).basicAdd(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getSchedulingPolicies__ResourceRepository()).basicAdd(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getAvailableResourceTypes_ResourceRepository()).basicAdd(otherEnd, msgs);
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return ((InternalEList<?>) this.getResourceInterfaces__ResourceRepository()).basicRemove(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return ((InternalEList<?>) this.getSchedulingPolicies__ResourceRepository()).basicRemove(otherEnd, msgs);
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return ((InternalEList<?>) this.getAvailableResourceTypes_ResourceRepository()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return this.getResourceInterfaces__ResourceRepository();
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return this.getSchedulingPolicies__ResourceRepository();
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return this.getAvailableResourceTypes_ResourceRepository();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            this.getResourceInterfaces__ResourceRepository().clear();
            this.getResourceInterfaces__ResourceRepository().addAll((Collection<? extends ResourceInterface>) newValue);
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            this.getSchedulingPolicies__ResourceRepository().clear();
            this.getSchedulingPolicies__ResourceRepository().addAll((Collection<? extends SchedulingPolicy>) newValue);
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            this.getAvailableResourceTypes_ResourceRepository().clear();
            this.getAvailableResourceTypes_ResourceRepository().addAll((Collection<? extends ResourceType>) newValue);
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            this.getResourceInterfaces__ResourceRepository().clear();
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            this.getSchedulingPolicies__ResourceRepository().clear();
            return;
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            this.getAvailableResourceTypes_ResourceRepository().clear();
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
        case ResourcetypePackage.RESOURCE_REPOSITORY__RESOURCE_INTERFACES_RESOURCE_REPOSITORY:
            return this.resourceInterfaces__ResourceRepository != null
                    && !this.resourceInterfaces__ResourceRepository.isEmpty();
        case ResourcetypePackage.RESOURCE_REPOSITORY__SCHEDULING_POLICIES_RESOURCE_REPOSITORY:
            return this.schedulingPolicies__ResourceRepository != null
                    && !this.schedulingPolicies__ResourceRepository.isEmpty();
        case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
            return this.availableResourceTypes_ResourceRepository != null
            && !this.availableResourceTypes_ResourceRepository.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ResourceRepositoryImpl
