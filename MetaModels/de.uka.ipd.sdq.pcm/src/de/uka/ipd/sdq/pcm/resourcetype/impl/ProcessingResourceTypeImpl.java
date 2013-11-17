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
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl#getHardwareInducedFailureType__ProcessingResourceType <em>Hardware Induced Failure Type Processing Resource Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingResourceTypeImpl extends ResourceTypeImpl implements ProcessingResourceType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * @generated
     */
    protected ProcessingResourceTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.PROCESSING_RESOURCE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public HardwareInducedFailureType getHardwareInducedFailureType__ProcessingResourceType() {
        if (hardwareInducedFailureType__ProcessingResourceType != null && hardwareInducedFailureType__ProcessingResourceType.eIsProxy()) {
            InternalEObject oldHardwareInducedFailureType__ProcessingResourceType = (InternalEObject)hardwareInducedFailureType__ProcessingResourceType;
            hardwareInducedFailureType__ProcessingResourceType = (HardwareInducedFailureType)eResolveProxy(oldHardwareInducedFailureType__ProcessingResourceType);
            if (hardwareInducedFailureType__ProcessingResourceType != oldHardwareInducedFailureType__ProcessingResourceType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE, oldHardwareInducedFailureType__ProcessingResourceType, hardwareInducedFailureType__ProcessingResourceType));
            }
        }
        return hardwareInducedFailureType__ProcessingResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public HardwareInducedFailureType basicGetHardwareInducedFailureType__ProcessingResourceType() {
        return hardwareInducedFailureType__ProcessingResourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetHardwareInducedFailureType__ProcessingResourceType(
            HardwareInducedFailureType newHardwareInducedFailureType__ProcessingResourceType, NotificationChain msgs) {
        HardwareInducedFailureType oldHardwareInducedFailureType__ProcessingResourceType = hardwareInducedFailureType__ProcessingResourceType;
        hardwareInducedFailureType__ProcessingResourceType = newHardwareInducedFailureType__ProcessingResourceType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE, oldHardwareInducedFailureType__ProcessingResourceType, newHardwareInducedFailureType__ProcessingResourceType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setHardwareInducedFailureType__ProcessingResourceType(
            HardwareInducedFailureType newHardwareInducedFailureType__ProcessingResourceType) {
        if (newHardwareInducedFailureType__ProcessingResourceType != hardwareInducedFailureType__ProcessingResourceType) {
            NotificationChain msgs = null;
            if (hardwareInducedFailureType__ProcessingResourceType != null)
                msgs = ((InternalEObject)hardwareInducedFailureType__ProcessingResourceType).eInverseRemove(this, ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE, HardwareInducedFailureType.class, msgs);
            if (newHardwareInducedFailureType__ProcessingResourceType != null)
                msgs = ((InternalEObject)newHardwareInducedFailureType__ProcessingResourceType).eInverseAdd(this, ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE, HardwareInducedFailureType.class, msgs);
            msgs = basicSetHardwareInducedFailureType__ProcessingResourceType(newHardwareInducedFailureType__ProcessingResourceType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE, newHardwareInducedFailureType__ProcessingResourceType, newHardwareInducedFailureType__ProcessingResourceType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
                if (hardwareInducedFailureType__ProcessingResourceType != null)
                    msgs = ((InternalEObject)hardwareInducedFailureType__ProcessingResourceType).eInverseRemove(this, ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE, HardwareInducedFailureType.class, msgs);
                return basicSetHardwareInducedFailureType__ProcessingResourceType((HardwareInducedFailureType)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
                return basicSetHardwareInducedFailureType__ProcessingResourceType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
                if (resolve) return getHardwareInducedFailureType__ProcessingResourceType();
                return basicGetHardwareInducedFailureType__ProcessingResourceType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
                setHardwareInducedFailureType__ProcessingResourceType((HardwareInducedFailureType)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
                setHardwareInducedFailureType__ProcessingResourceType((HardwareInducedFailureType)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE:
                return hardwareInducedFailureType__ProcessingResourceType != null;
        }
        return super.eIsSet(featureID);
    }

} // ProcessingResourceTypeImpl
