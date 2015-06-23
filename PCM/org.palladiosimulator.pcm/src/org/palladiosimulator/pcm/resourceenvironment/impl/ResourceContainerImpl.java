/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourceenvironment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ResourceContainerImpl#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ResourceContainerImpl#getResourceEnvironment_ResourceContainer <em>Resource Environment Resource Container</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ResourceContainerImpl#getNestedResourceContainers__ResourceContainer <em>Nested Resource Containers Resource Container</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.ResourceContainerImpl#getParentResourceContainer__ResourceContainer <em>Parent Resource Container Resource Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceContainerImpl extends EntityImpl implements ResourceContainer {

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
    protected ResourceContainerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ProcessingResourceSpecification> getActiveResourceSpecifications_ResourceContainer() {
        return (EList<ProcessingResourceSpecification>) eDynamicGet(
                ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceEnvironment getResourceEnvironment_ResourceContainer() {
        return (ResourceEnvironment) eDynamicGet(
                ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceEnvironment_ResourceContainer(
            ResourceEnvironment newResourceEnvironment_ResourceContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceEnvironment_ResourceContainer,
                ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceEnvironment_ResourceContainer(ResourceEnvironment newResourceEnvironment_ResourceContainer) {
        eDynamicSet(ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER,
                newResourceEnvironment_ResourceContainer);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ResourceContainer> getNestedResourceContainers__ResourceContainer() {
        return (EList<ResourceContainer>) eDynamicGet(
                ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceContainer getParentResourceContainer__ResourceContainer() {
        return (ResourceContainer) eDynamicGet(
                ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParentResourceContainer__ResourceContainer(
            ResourceContainer newParentResourceContainer__ResourceContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newParentResourceContainer__ResourceContainer,
                ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentResourceContainer__ResourceContainer(
            ResourceContainer newParentResourceContainer__ResourceContainer) {
        eDynamicSet(ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER,
                ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER,
                newParentResourceContainer__ResourceContainer);
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
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getActiveResourceSpecifications_ResourceContainer())
                    .basicAdd(otherEnd, msgs);
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceEnvironment_ResourceContainer((ResourceEnvironment) otherEnd, msgs);
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getNestedResourceContainers__ResourceContainer())
                    .basicAdd(otherEnd, msgs);
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParentResourceContainer__ResourceContainer((ResourceContainer) otherEnd, msgs);
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
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
            return ((InternalEList<?>) getActiveResourceSpecifications_ResourceContainer()).basicRemove(otherEnd, msgs);
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER:
            return basicSetResourceEnvironment_ResourceContainer(null, msgs);
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER:
            return ((InternalEList<?>) getNestedResourceContainers__ResourceContainer()).basicRemove(otherEnd, msgs);
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER:
            return basicSetParentResourceContainer__ResourceContainer(null, msgs);
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
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER:
            return eInternalContainer().eInverseRemove(this,
                    ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT,
                    ResourceEnvironment.class, msgs);
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER:
            return eInternalContainer().eInverseRemove(this,
                    ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER,
                    ResourceContainer.class, msgs);
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
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
            return getActiveResourceSpecifications_ResourceContainer();
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER:
            return getResourceEnvironment_ResourceContainer();
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER:
            return getNestedResourceContainers__ResourceContainer();
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER:
            return getParentResourceContainer__ResourceContainer();
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
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
            getActiveResourceSpecifications_ResourceContainer().clear();
            getActiveResourceSpecifications_ResourceContainer()
                    .addAll((Collection<? extends ProcessingResourceSpecification>) newValue);
            return;
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER:
            setResourceEnvironment_ResourceContainer((ResourceEnvironment) newValue);
            return;
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER:
            getNestedResourceContainers__ResourceContainer().clear();
            getNestedResourceContainers__ResourceContainer().addAll((Collection<? extends ResourceContainer>) newValue);
            return;
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER:
            setParentResourceContainer__ResourceContainer((ResourceContainer) newValue);
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
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
            getActiveResourceSpecifications_ResourceContainer().clear();
            return;
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER:
            setResourceEnvironment_ResourceContainer((ResourceEnvironment) null);
            return;
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER:
            getNestedResourceContainers__ResourceContainer().clear();
            return;
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER:
            setParentResourceContainer__ResourceContainer((ResourceContainer) null);
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
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
            return !getActiveResourceSpecifications_ResourceContainer().isEmpty();
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER:
            return getResourceEnvironment_ResourceContainer() != null;
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER:
            return !getNestedResourceContainers__ResourceContainer().isEmpty();
        case ResourceenvironmentPackage.RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER:
            return getParentResourceContainer__ResourceContainer() != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourceContainerImpl
