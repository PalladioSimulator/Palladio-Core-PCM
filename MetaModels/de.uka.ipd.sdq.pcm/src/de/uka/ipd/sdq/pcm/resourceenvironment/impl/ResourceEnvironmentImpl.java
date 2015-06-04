/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Environment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceEnvironmentImpl#getLinkingResources__ResourceEnvironment
 * <em>Linking Resources Resource Environment</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceEnvironmentImpl#getResourceContainer_ResourceEnvironment
 * <em>Resource Container Resource Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceEnvironmentImpl extends NamedElementImpl implements ResourceEnvironment {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getLinkingResources__ResourceEnvironment()
     * <em>Linking Resources Resource Environment</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLinkingResources__ResourceEnvironment()
     * @generated
     * @ordered
     */
    protected EList<LinkingResource> linkingResources__ResourceEnvironment;

    /**
     * The cached value of the '{@link #getResourceContainer_ResourceEnvironment()
     * <em>Resource Container Resource Environment</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceContainer_ResourceEnvironment()
     * @generated
     * @ordered
     */
    protected EList<ResourceContainer> resourceContainer_ResourceEnvironment;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceEnvironmentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.RESOURCE_ENVIRONMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<LinkingResource> getLinkingResources__ResourceEnvironment() {
        if (this.linkingResources__ResourceEnvironment == null) {
            this.linkingResources__ResourceEnvironment = new EObjectContainmentWithInverseEList<LinkingResource>(
                    LinkingResource.class, this,
                    ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT,
                    ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE);
        }
        return this.linkingResources__ResourceEnvironment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ResourceContainer> getResourceContainer_ResourceEnvironment() {
        if (this.resourceContainer_ResourceEnvironment == null) {
            this.resourceContainer_ResourceEnvironment = new EObjectContainmentWithInverseEList<ResourceContainer>(
                    ResourceContainer.class, this,
                    ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT,
                    ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER);
        }
        return this.resourceContainer_ResourceEnvironment;
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
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getLinkingResources__ResourceEnvironment())
                    .basicAdd(otherEnd, msgs);
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getResourceContainer_ResourceEnvironment())
                    .basicAdd(otherEnd, msgs);
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
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT:
            return ((InternalEList<?>) this.getLinkingResources__ResourceEnvironment()).basicRemove(otherEnd, msgs);
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT:
            return ((InternalEList<?>) this.getResourceContainer_ResourceEnvironment()).basicRemove(otherEnd, msgs);
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
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT:
            return this.getLinkingResources__ResourceEnvironment();
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT:
            return this.getResourceContainer_ResourceEnvironment();
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
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT:
            this.getLinkingResources__ResourceEnvironment().clear();
            this.getLinkingResources__ResourceEnvironment().addAll((Collection<? extends LinkingResource>) newValue);
            return;
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT:
            this.getResourceContainer_ResourceEnvironment().clear();
            this.getResourceContainer_ResourceEnvironment().addAll((Collection<? extends ResourceContainer>) newValue);
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
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT:
            this.getLinkingResources__ResourceEnvironment().clear();
            return;
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT:
            this.getResourceContainer_ResourceEnvironment().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT:
            return this.linkingResources__ResourceEnvironment != null
                    && !this.linkingResources__ResourceEnvironment.isEmpty();
        case ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT:
            return this.resourceContainer_ResourceEnvironment != null
                    && !this.resourceContainer_ResourceEnvironment.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ResourceEnvironmentImpl
