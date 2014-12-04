/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Timeout Failure Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.reliability.impl.ResourceTimeoutFailureTypeImpl#getPassiveResource__ResourceTimeoutFailureType
 * <em>Passive Resource Resource Timeout Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceTimeoutFailureTypeImpl extends SoftwareInducedFailureTypeImpl implements
ResourceTimeoutFailureType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getPassiveResource__ResourceTimeoutFailureType()
     * <em>Passive Resource Resource Timeout Failure Type</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getPassiveResource__ResourceTimeoutFailureType()
     * @generated
     * @ordered
     */
    protected PassiveResource passiveResource__ResourceTimeoutFailureType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceTimeoutFailureTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ReliabilityPackage.Literals.RESOURCE_TIMEOUT_FAILURE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PassiveResource getPassiveResource__ResourceTimeoutFailureType() {
        if (this.passiveResource__ResourceTimeoutFailureType != null
                && ((EObject) this.passiveResource__ResourceTimeoutFailureType).eIsProxy()) {
            final InternalEObject oldPassiveResource__ResourceTimeoutFailureType = (InternalEObject) this.passiveResource__ResourceTimeoutFailureType;
            this.passiveResource__ResourceTimeoutFailureType = (PassiveResource) this
                    .eResolveProxy(oldPassiveResource__ResourceTimeoutFailureType);
            if (this.passiveResource__ResourceTimeoutFailureType != oldPassiveResource__ResourceTimeoutFailureType) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE,
                            oldPassiveResource__ResourceTimeoutFailureType,
                            this.passiveResource__ResourceTimeoutFailureType));
                }
            }
        }
        return this.passiveResource__ResourceTimeoutFailureType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveResource__ResourceTimeoutFailureType() {
        return this.passiveResource__ResourceTimeoutFailureType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetPassiveResource__ResourceTimeoutFailureType(
            final PassiveResource newPassiveResource__ResourceTimeoutFailureType, NotificationChain msgs) {
        final PassiveResource oldPassiveResource__ResourceTimeoutFailureType = this.passiveResource__ResourceTimeoutFailureType;
        this.passiveResource__ResourceTimeoutFailureType = newPassiveResource__ResourceTimeoutFailureType;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE,
                    oldPassiveResource__ResourceTimeoutFailureType, newPassiveResource__ResourceTimeoutFailureType);
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
    public void setPassiveResource__ResourceTimeoutFailureType(
            final PassiveResource newPassiveResource__ResourceTimeoutFailureType) {
        if (newPassiveResource__ResourceTimeoutFailureType != this.passiveResource__ResourceTimeoutFailureType) {
            NotificationChain msgs = null;
            if (this.passiveResource__ResourceTimeoutFailureType != null) {
                msgs = ((InternalEObject) this.passiveResource__ResourceTimeoutFailureType).eInverseRemove(this,
                        RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                        PassiveResource.class, msgs);
            }
            if (newPassiveResource__ResourceTimeoutFailureType != null) {
                msgs = ((InternalEObject) newPassiveResource__ResourceTimeoutFailureType).eInverseAdd(this,
                        RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                        PassiveResource.class, msgs);
            }
            msgs = this.basicSetPassiveResource__ResourceTimeoutFailureType(
                    newPassiveResource__ResourceTimeoutFailureType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE,
                    newPassiveResource__ResourceTimeoutFailureType, newPassiveResource__ResourceTimeoutFailureType));
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
        case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE:
            if (this.passiveResource__ResourceTimeoutFailureType != null) {
                msgs = ((InternalEObject) this.passiveResource__ResourceTimeoutFailureType).eInverseRemove(this,
                        RepositoryPackage.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE,
                        PassiveResource.class, msgs);
            }
            return this.basicSetPassiveResource__ResourceTimeoutFailureType((PassiveResource) otherEnd, msgs);
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
        case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE:
            return this.basicSetPassiveResource__ResourceTimeoutFailureType(null, msgs);
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
        case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE:
            if (resolve) {
                return this.getPassiveResource__ResourceTimeoutFailureType();
            }
            return this.basicGetPassiveResource__ResourceTimeoutFailureType();
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
        case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE:
            this.setPassiveResource__ResourceTimeoutFailureType((PassiveResource) newValue);
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
        case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE:
            this.setPassiveResource__ResourceTimeoutFailureType((PassiveResource) null);
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
        case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE__PASSIVE_RESOURCE_RESOURCE_TIMEOUT_FAILURE_TYPE:
            return this.passiveResource__ResourceTimeoutFailureType != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceTimeoutFailureTypeImpl
