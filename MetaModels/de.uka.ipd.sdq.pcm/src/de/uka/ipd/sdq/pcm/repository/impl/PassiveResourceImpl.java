/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Passive Resource</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl#getCapacity_PassiveResource
 * <em>Capacity Passive Resource</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl#getBasicComponent_PassiveResource
 * <em>Basic Component Passive Resource</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl#getResourceTimeoutFailureType__PassiveResource
 * <em>Resource Timeout Failure Type Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PassiveResourceImpl extends EntityImpl implements PassiveResource {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getCapacity_PassiveResource()
     * <em>Capacity Passive Resource</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getCapacity_PassiveResource()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable capacity_PassiveResource;
    /**
     * The cached value of the '{@link #getResourceTimeoutFailureType__PassiveResource()
     * <em>Resource Timeout Failure Type Passive Resource</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getResourceTimeoutFailureType__PassiveResource()
     * @generated
     * @ordered
     */
    protected ResourceTimeoutFailureType resourceTimeoutFailureType__PassiveResource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PassiveResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.PASSIVE_RESOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getCapacity_PassiveResource() {
        return this.capacity_PassiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCapacity_PassiveResource(final PCMRandomVariable newCapacity_PassiveResource,
            NotificationChain msgs) {
        final PCMRandomVariable oldCapacity_PassiveResource = this.capacity_PassiveResource;
        this.capacity_PassiveResource = newCapacity_PassiveResource;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, oldCapacity_PassiveResource,
                    newCapacity_PassiveResource);
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
    public void setCapacity_PassiveResource(final PCMRandomVariable newCapacity_PassiveResource) {
        if (newCapacity_PassiveResource != this.capacity_PassiveResource) {
            NotificationChain msgs = null;
            if (this.capacity_PassiveResource != null) {
                msgs = ((InternalEObject) this.capacity_PassiveResource).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            if (newCapacity_PassiveResource != null) {
                msgs = ((InternalEObject) newCapacity_PassiveResource).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetCapacity_PassiveResource(newCapacity_PassiveResource, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, newCapacity_PassiveResource,
                    newCapacity_PassiveResource));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BasicComponent getBasicComponent_PassiveResource() {
        if (this.eContainerFeatureID() != RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE) {
            return null;
        }
        return (BasicComponent) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBasicComponent_PassiveResource(
            final BasicComponent newBasicComponent_PassiveResource, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newBasicComponent_PassiveResource,
                RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBasicComponent_PassiveResource(final BasicComponent newBasicComponent_PassiveResource) {
        if (newBasicComponent_PassiveResource != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE && newBasicComponent_PassiveResource != null)) {
            if (EcoreUtil.isAncestor(this, newBasicComponent_PassiveResource)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newBasicComponent_PassiveResource != null) {
                msgs = ((InternalEObject) newBasicComponent_PassiveResource)
                        .eInverseAdd(this, RepositoryPackage.BASIC_COMPONENT__PASSIVE_RESOURCE_BASIC_COMPONENT,
                                BasicComponent.class, msgs);
            }
            msgs = this.basicSetBasicComponent_PassiveResource(newBasicComponent_PassiveResource, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE,
                    newBasicComponent_PassiveResource, newBasicComponent_PassiveResource));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceTimeoutFailureType getResourceTimeoutFailureType__PassiveResource() {
        if (this.resourceTimeoutFailureType__PassiveResource != null
                && this.resourceTimeoutFailureType__PassiveResource.eIsProxy()) {
            final InternalEObject oldResourceTimeoutFailureType__PassiveResource = (InternalEObject) this.resourceTimeoutFailureType__PassiveResource;
            this.resourceTimeoutFailureType__PassiveResource = (ResourceTimeoutFailureType) this
                    .eResolveProxy(oldResourceTimeoutFailureType__PassiveResource);
            if (this.resourceTimeoutFailureType__PassiveResource != oldResourceTimeoutFailureType__PassiveResource) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                            oldResourceTimeoutFailureType__PassiveResource,
                            this.resourceTimeoutFailureType__PassiveResource));
                }
            }
        }
        return this.resourceTimeoutFailureType__PassiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceTimeoutFailureType basicGetResourceTimeoutFailureType__PassiveResource() {
        return this.resourceTimeoutFailureType__PassiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceTimeoutFailureType__PassiveResource(
            final ResourceTimeoutFailureType newResourceTimeoutFailureType__PassiveResource, NotificationChain msgs) {
        final ResourceTimeoutFailureType oldResourceTimeoutFailureType__PassiveResource = this.resourceTimeoutFailureType__PassiveResource;
        this.resourceTimeoutFailureType__PassiveResource = newResourceTimeoutFailureType__PassiveResource;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                    oldResourceTimeoutFailureType__PassiveResource, newResourceTimeoutFailureType__PassiveResource);
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
    public void setResourceTimeoutFailureType__PassiveResource(
            final ResourceTimeoutFailureType newResourceTimeoutFailureType__PassiveResource) {
        if (newResourceTimeoutFailureType__PassiveResource != this.resourceTimeoutFailureType__PassiveResource) {
            NotificationChain msgs = null;
            if (this.resourceTimeoutFailureType__PassiveResource != null) {
                msgs = ((InternalEObject) this.resourceTimeoutFailureType__PassiveResource)
                        .eInverseRemove(
                                this,
                                ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE,
                                ResourceTimeoutFailureType.class, msgs);
            }
            if (newResourceTimeoutFailureType__PassiveResource != null) {
                msgs = ((InternalEObject) newResourceTimeoutFailureType__PassiveResource)
                        .eInverseAdd(
                                this,
                                ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE,
                                ResourceTimeoutFailureType.class, msgs);
            }
            msgs = this.basicSetResourceTimeoutFailureType__PassiveResource(
                    newResourceTimeoutFailureType__PassiveResource, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                    newResourceTimeoutFailureType__PassiveResource, newResourceTimeoutFailureType__PassiveResource));
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            if (this.capacity_PassiveResource != null) {
                msgs = ((InternalEObject) this.capacity_PassiveResource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, null, msgs);
            }
            return this.basicSetCapacity_PassiveResource((PCMRandomVariable) otherEnd, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetBasicComponent_PassiveResource((BasicComponent) otherEnd, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            if (this.resourceTimeoutFailureType__PassiveResource != null) {
                msgs = ((InternalEObject) this.resourceTimeoutFailureType__PassiveResource)
                        .eInverseRemove(
                                this,
                                ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE,
                                ResourceTimeoutFailureType.class, msgs);
            }
            return this
                    .basicSetResourceTimeoutFailureType__PassiveResource((ResourceTimeoutFailureType) otherEnd, msgs);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            return this.basicSetCapacity_PassiveResource(null, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return this.basicSetBasicComponent_PassiveResource(null, msgs);
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            return this.basicSetResourceTimeoutFailureType__PassiveResource(null, msgs);
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
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.BASIC_COMPONENT__PASSIVE_RESOURCE_BASIC_COMPONENT, BasicComponent.class, msgs);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            return this.getCapacity_PassiveResource();
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return this.getBasicComponent_PassiveResource();
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            if (resolve) {
                return this.getResourceTimeoutFailureType__PassiveResource();
            }
            return this.basicGetResourceTimeoutFailureType__PassiveResource();
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            this.setCapacity_PassiveResource((PCMRandomVariable) newValue);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            this.setBasicComponent_PassiveResource((BasicComponent) newValue);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            this.setResourceTimeoutFailureType__PassiveResource((ResourceTimeoutFailureType) newValue);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            this.setCapacity_PassiveResource((PCMRandomVariable) null);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            this.setBasicComponent_PassiveResource((BasicComponent) null);
            return;
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            this.setResourceTimeoutFailureType__PassiveResource((ResourceTimeoutFailureType) null);
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
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            return this.capacity_PassiveResource != null;
        case RepositoryPackage.PASSIVE_RESOURCE__BASIC_COMPONENT_PASSIVE_RESOURCE:
            return this.getBasicComponent_PassiveResource() != null;
        case RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE:
            return this.resourceTimeoutFailureType__PassiveResource != null;
        }
        return super.eIsSet(featureID);
    }

} // PassiveResourceImpl
