/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Linking Resource</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl#getConnectedResourceContainers_LinkingResource
 * <em>Connected Resource Containers Linking Resource</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl#getCommunicationLinkResourceSpecifications_LinkingResource
 * <em>Communication Link Resource Specifications Linking Resource</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.LinkingResourceImpl#getResourceEnvironment_LinkingResource
 * <em>Resource Environment Linking Resource</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class LinkingResourceImpl extends EntityImpl implements LinkingResource {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the ' {@link #getConnectedResourceContainers_LinkingResource()
     * <em>Connected Resource Containers Linking Resource</em>}' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getConnectedResourceContainers_LinkingResource()
     * @generated
     * @ordered
     */
    protected EList<ResourceContainer> connectedResourceContainers_LinkingResource;

    /**
     * The cached value of the '
     * {@link #getCommunicationLinkResourceSpecifications_LinkingResource()
     * <em>Communication Link Resource Specifications Linking Resource</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCommunicationLinkResourceSpecifications_LinkingResource()
     * @generated
     * @ordered
     */
    protected CommunicationLinkResourceSpecification communicationLinkResourceSpecifications_LinkingResource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LinkingResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentPackage.Literals.LINKING_RESOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ResourceContainer> getConnectedResourceContainers_LinkingResource() {
        if (this.connectedResourceContainers_LinkingResource == null) {
            this.connectedResourceContainers_LinkingResource = new EObjectResolvingEList<ResourceContainer>(
                    ResourceContainer.class, this,
                    ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE);
        }
        return this.connectedResourceContainers_LinkingResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CommunicationLinkResourceSpecification getCommunicationLinkResourceSpecifications_LinkingResource() {
        return this.communicationLinkResourceSpecifications_LinkingResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCommunicationLinkResourceSpecifications_LinkingResource(
            final CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifications_LinkingResource,
            NotificationChain msgs) {
        final CommunicationLinkResourceSpecification oldCommunicationLinkResourceSpecifications_LinkingResource = this.communicationLinkResourceSpecifications_LinkingResource;
        this.communicationLinkResourceSpecifications_LinkingResource = newCommunicationLinkResourceSpecifications_LinkingResource;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
                    oldCommunicationLinkResourceSpecifications_LinkingResource,
                    newCommunicationLinkResourceSpecifications_LinkingResource);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCommunicationLinkResourceSpecifications_LinkingResource(
            final CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecifications_LinkingResource) {
        if (newCommunicationLinkResourceSpecifications_LinkingResource != this.communicationLinkResourceSpecifications_LinkingResource) {
            NotificationChain msgs = null;
            if (this.communicationLinkResourceSpecifications_LinkingResource != null) {
                msgs = ((InternalEObject) this.communicationLinkResourceSpecifications_LinkingResource)
                        .eInverseRemove(
                                this,
                                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                                CommunicationLinkResourceSpecification.class, msgs);
            }
            if (newCommunicationLinkResourceSpecifications_LinkingResource != null) {
                msgs = ((InternalEObject) newCommunicationLinkResourceSpecifications_LinkingResource)
                        .eInverseAdd(
                                this,
                                ResourceenvironmentPackage.COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION,
                                CommunicationLinkResourceSpecification.class, msgs);
            }
            msgs = this.basicSetCommunicationLinkResourceSpecifications_LinkingResource(
                    newCommunicationLinkResourceSpecifications_LinkingResource, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
                    newCommunicationLinkResourceSpecifications_LinkingResource,
                    newCommunicationLinkResourceSpecifications_LinkingResource));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceEnvironment getResourceEnvironment_LinkingResource() {
        if (this.eContainerFeatureID() != ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE) {
            return null;
        }
        return (ResourceEnvironment) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceEnvironment_LinkingResource(
            final ResourceEnvironment newResourceEnvironment_LinkingResource, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newResourceEnvironment_LinkingResource,
                ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceEnvironment_LinkingResource(final ResourceEnvironment newResourceEnvironment_LinkingResource) {
        if (newResourceEnvironment_LinkingResource != this.eInternalContainer()
                || (this.eContainerFeatureID() != ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE && newResourceEnvironment_LinkingResource != null)) {
            if (EcoreUtil.isAncestor(this, newResourceEnvironment_LinkingResource)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newResourceEnvironment_LinkingResource != null) {
                msgs = ((InternalEObject) newResourceEnvironment_LinkingResource).eInverseAdd(this,
                        ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT,
                        ResourceEnvironment.class, msgs);
            }
            msgs = this.basicSetResourceEnvironment_LinkingResource(newResourceEnvironment_LinkingResource, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE,
                    newResourceEnvironment_LinkingResource, newResourceEnvironment_LinkingResource));
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
        case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
            if (this.communicationLinkResourceSpecifications_LinkingResource != null) {
                msgs = ((InternalEObject) this.communicationLinkResourceSpecifications_LinkingResource)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE,
                                null, msgs);
            }
            return this.basicSetCommunicationLinkResourceSpecifications_LinkingResource(
                    (CommunicationLinkResourceSpecification) otherEnd, msgs);
        case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceEnvironment_LinkingResource((ResourceEnvironment) otherEnd, msgs);
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
        case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
            return this.basicSetCommunicationLinkResourceSpecifications_LinkingResource(null, msgs);
        case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
            return this.basicSetResourceEnvironment_LinkingResource(null, msgs);
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
        case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
            return this.eInternalContainer().eInverseRemove(this,
                    ResourceenvironmentPackage.RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT,
                    ResourceEnvironment.class, msgs);
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
        case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
            return this.getConnectedResourceContainers_LinkingResource();
        case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
            return this.getCommunicationLinkResourceSpecifications_LinkingResource();
        case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
            return this.getResourceEnvironment_LinkingResource();
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
        case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
            this.getConnectedResourceContainers_LinkingResource().clear();
            this.getConnectedResourceContainers_LinkingResource().addAll(
                    (Collection<? extends ResourceContainer>) newValue);
            return;
        case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
            this.setCommunicationLinkResourceSpecifications_LinkingResource((CommunicationLinkResourceSpecification) newValue);
            return;
        case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
            this.setResourceEnvironment_LinkingResource((ResourceEnvironment) newValue);
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
        case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
            this.getConnectedResourceContainers_LinkingResource().clear();
            return;
        case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
            this.setCommunicationLinkResourceSpecifications_LinkingResource((CommunicationLinkResourceSpecification) null);
            return;
        case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
            this.setResourceEnvironment_LinkingResource((ResourceEnvironment) null);
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
        case ResourceenvironmentPackage.LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE:
            return this.connectedResourceContainers_LinkingResource != null
                    && !this.connectedResourceContainers_LinkingResource.isEmpty();
        case ResourceenvironmentPackage.LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE:
            return this.communicationLinkResourceSpecifications_LinkingResource != null;
        case ResourceenvironmentPackage.LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE:
            return this.getResourceEnvironment_LinkingResource() != null;
        }
        return super.eIsSet(featureID);
    }

} // LinkingResourceImpl
