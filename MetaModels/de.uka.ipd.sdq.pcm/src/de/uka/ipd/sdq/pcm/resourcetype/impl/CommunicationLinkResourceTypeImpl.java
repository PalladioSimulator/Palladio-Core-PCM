/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Communication Link Resource Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl#getNetworkInducedFailureType__CommunicationLinkResourceType
 * <em>Network Induced Failure Type Communication Link Resource Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CommunicationLinkResourceTypeImpl extends ResourceTypeImpl implements CommunicationLinkResourceType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '
     * {@link #getNetworkInducedFailureType__CommunicationLinkResourceType()
     * <em>Network Induced Failure Type Communication Link Resource Type</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNetworkInducedFailureType__CommunicationLinkResourceType()
     * @generated
     * @ordered
     */
    protected NetworkInducedFailureType networkInducedFailureType__CommunicationLinkResourceType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CommunicationLinkResourceTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.COMMUNICATION_LINK_RESOURCE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NetworkInducedFailureType getNetworkInducedFailureType__CommunicationLinkResourceType() {
        if (this.networkInducedFailureType__CommunicationLinkResourceType != null
                && ((EObject) this.networkInducedFailureType__CommunicationLinkResourceType).eIsProxy()) {
            final InternalEObject oldNetworkInducedFailureType__CommunicationLinkResourceType = (InternalEObject) this.networkInducedFailureType__CommunicationLinkResourceType;
            this.networkInducedFailureType__CommunicationLinkResourceType = (NetworkInducedFailureType) this
                    .eResolveProxy(oldNetworkInducedFailureType__CommunicationLinkResourceType);
            if (this.networkInducedFailureType__CommunicationLinkResourceType != oldNetworkInducedFailureType__CommunicationLinkResourceType) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE,
                            oldNetworkInducedFailureType__CommunicationLinkResourceType,
                            this.networkInducedFailureType__CommunicationLinkResourceType));
                }
            }
        }
        return this.networkInducedFailureType__CommunicationLinkResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NetworkInducedFailureType basicGetNetworkInducedFailureType__CommunicationLinkResourceType() {
        return this.networkInducedFailureType__CommunicationLinkResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetNetworkInducedFailureType__CommunicationLinkResourceType(
            final NetworkInducedFailureType newNetworkInducedFailureType__CommunicationLinkResourceType,
            NotificationChain msgs) {
        final NetworkInducedFailureType oldNetworkInducedFailureType__CommunicationLinkResourceType = this.networkInducedFailureType__CommunicationLinkResourceType;
        this.networkInducedFailureType__CommunicationLinkResourceType = newNetworkInducedFailureType__CommunicationLinkResourceType;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE,
                    oldNetworkInducedFailureType__CommunicationLinkResourceType,
                    newNetworkInducedFailureType__CommunicationLinkResourceType);
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
    public void setNetworkInducedFailureType__CommunicationLinkResourceType(
            final NetworkInducedFailureType newNetworkInducedFailureType__CommunicationLinkResourceType) {
        if (newNetworkInducedFailureType__CommunicationLinkResourceType != this.networkInducedFailureType__CommunicationLinkResourceType) {
            NotificationChain msgs = null;
            if (this.networkInducedFailureType__CommunicationLinkResourceType != null) {
                msgs = ((InternalEObject) this.networkInducedFailureType__CommunicationLinkResourceType)
                        .eInverseRemove(
                                this,
                                ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE,
                                NetworkInducedFailureType.class, msgs);
            }
            if (newNetworkInducedFailureType__CommunicationLinkResourceType != null) {
                msgs = ((InternalEObject) newNetworkInducedFailureType__CommunicationLinkResourceType)
                        .eInverseAdd(
                                this,
                                ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE,
                                NetworkInducedFailureType.class, msgs);
            }
            msgs = this.basicSetNetworkInducedFailureType__CommunicationLinkResourceType(
                    newNetworkInducedFailureType__CommunicationLinkResourceType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE,
                    newNetworkInducedFailureType__CommunicationLinkResourceType,
                    newNetworkInducedFailureType__CommunicationLinkResourceType));
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
        case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE:
            if (this.networkInducedFailureType__CommunicationLinkResourceType != null) {
                msgs = ((InternalEObject) this.networkInducedFailureType__CommunicationLinkResourceType)
                        .eInverseRemove(
                                this,
                                ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE,
                                NetworkInducedFailureType.class, msgs);
            }
            return this.basicSetNetworkInducedFailureType__CommunicationLinkResourceType(
                    (NetworkInducedFailureType) otherEnd, msgs);
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
        case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE:
            return this.basicSetNetworkInducedFailureType__CommunicationLinkResourceType(null, msgs);
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
        case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE:
            if (resolve) {
                return this.getNetworkInducedFailureType__CommunicationLinkResourceType();
            }
            return this.basicGetNetworkInducedFailureType__CommunicationLinkResourceType();
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
        case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE:
            this.setNetworkInducedFailureType__CommunicationLinkResourceType((NetworkInducedFailureType) newValue);
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
        case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE:
            this.setNetworkInducedFailureType__CommunicationLinkResourceType((NetworkInducedFailureType) null);
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
        case ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE:
            return this.networkInducedFailureType__CommunicationLinkResourceType != null;
        }
        return super.eIsSet(featureID);
    }

} // CommunicationLinkResourceTypeImpl
