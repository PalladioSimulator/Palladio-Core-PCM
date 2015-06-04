/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Processing Resource Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl#getHardwareInducedFailureType__ProcessingResourceType
 * <em>Hardware Induced Failure Type Processing Resource Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingResourceTypeImpl extends ResourceTypeImpl implements ProcessingResourceType {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getHardwareInducedFailureType__ProcessingResourceType()
     * <em>Hardware Induced Failure Type Processing Resource Type</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getHardwareInducedFailureType__ProcessingResourceType()
     * @generated
     * @ordered
     */
    protected HardwareInducedFailureType hardwareInducedFailureType__ProcessingResourceType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProcessingResourceTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.PROCESSING_RESOURCE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HardwareInducedFailureType getHardwareInducedFailureType__ProcessingResourceType() {
        if (this.hardwareInducedFailureType__ProcessingResourceType != null
                && this.hardwareInducedFailureType__ProcessingResourceType.eIsProxy()) {
            final InternalEObject oldHardwareInducedFailureType__ProcessingResourceType = (InternalEObject) this.hardwareInducedFailureType__ProcessingResourceType;
            this.hardwareInducedFailureType__ProcessingResourceType = (HardwareInducedFailureType) this
                    .eResolveProxy(oldHardwareInducedFailureType__ProcessingResourceType);
            if (this.hardwareInducedFailureType__ProcessingResourceType != oldHardwareInducedFailureType__ProcessingResourceType) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE,
                            oldHardwareInducedFailureType__ProcessingResourceType,
                            this.hardwareInducedFailureType__ProcessingResourceType));
                }
            }
        }
        return this.hardwareInducedFailureType__ProcessingResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public HardwareInducedFailureType basicGetHardwareInducedFailureType__ProcessingResourceType() {
        return this.hardwareInducedFailureType__ProcessingResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetHardwareInducedFailureType__ProcessingResourceType(
            final HardwareInducedFailureType newHardwareInducedFailureType__ProcessingResourceType,
            NotificationChain msgs) {
        final HardwareInducedFailureType oldHardwareInducedFailureType__ProcessingResourceType = this.hardwareInducedFailureType__ProcessingResourceType;
        this.hardwareInducedFailureType__ProcessingResourceType = newHardwareInducedFailureType__ProcessingResourceType;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE,
                    oldHardwareInducedFailureType__ProcessingResourceType,
                    newHardwareInducedFailureType__ProcessingResourceType);
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
    public void setHardwareInducedFailureType__ProcessingResourceType(
            final HardwareInducedFailureType newHardwareInducedFailureType__ProcessingResourceType) {
        if (newHardwareInducedFailureType__ProcessingResourceType != this.hardwareInducedFailureType__ProcessingResourceType) {
            NotificationChain msgs = null;
            if (this.hardwareInducedFailureType__ProcessingResourceType != null) {
                msgs = ((InternalEObject) this.hardwareInducedFailureType__ProcessingResourceType)
                        .eInverseRemove(
                                this,
                                ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE,
                                HardwareInducedFailureType.class, msgs);
            }
            if (newHardwareInducedFailureType__ProcessingResourceType != null) {
                msgs = ((InternalEObject) newHardwareInducedFailureType__ProcessingResourceType)
                        .eInverseAdd(
                                this,
                                ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE,
                                HardwareInducedFailureType.class, msgs);
            }
            msgs = this.basicSetHardwareInducedFailureType__ProcessingResourceType(
                    newHardwareInducedFailureType__ProcessingResourceType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE,
                    newHardwareInducedFailureType__ProcessingResourceType,
                    newHardwareInducedFailureType__ProcessingResourceType));
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
        case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
            if (this.hardwareInducedFailureType__ProcessingResourceType != null) {
                msgs = ((InternalEObject) this.hardwareInducedFailureType__ProcessingResourceType)
                        .eInverseRemove(
                                this,
                                ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE,
                                HardwareInducedFailureType.class, msgs);
            }
            return this.basicSetHardwareInducedFailureType__ProcessingResourceType(
                    (HardwareInducedFailureType) otherEnd, msgs);
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
        case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
            return this.basicSetHardwareInducedFailureType__ProcessingResourceType(null, msgs);
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
        case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
            if (resolve) {
                return this.getHardwareInducedFailureType__ProcessingResourceType();
            }
            return this.basicGetHardwareInducedFailureType__ProcessingResourceType();
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
        case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
            this.setHardwareInducedFailureType__ProcessingResourceType((HardwareInducedFailureType) newValue);
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
        case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
            this.setHardwareInducedFailureType__ProcessingResourceType((HardwareInducedFailureType) null);
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
        case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
            return this.hardwareInducedFailureType__ProcessingResourceType != null;
        }
        return super.eIsSet(featureID);
    }

} // ProcessingResourceTypeImpl
