/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passive Resource Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.PassiveResourceReferenceImpl#getPassiveResource <em>Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PassiveResourceReferenceImpl extends MinimalEObjectImpl.Container implements PassiveResourceReference {
    /**
     * The cached value of the '{@link #getPassiveResource() <em>Passive Resource</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassiveResource()
     * @generated
     * @ordered
     */
    protected PassiveResource passiveResource;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PassiveResourceReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PassiveResource getPassiveResource() {
        if (passiveResource != null && passiveResource.eIsProxy()) {
            InternalEObject oldPassiveResource = (InternalEObject)passiveResource;
            passiveResource = (PassiveResource)eResolveProxy(oldPassiveResource);
            if (passiveResource != oldPassiveResource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, oldPassiveResource, passiveResource));
            }
        }
        return passiveResource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PassiveResource basicGetPassiveResource() {
        return passiveResource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassiveResource(PassiveResource newPassiveResource) {
        PassiveResource oldPassiveResource = passiveResource;
        passiveResource = newPassiveResource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, oldPassiveResource, passiveResource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
                if (resolve) return getPassiveResource();
                return basicGetPassiveResource();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
                setPassiveResource((PassiveResource)newValue);
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
            case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
                setPassiveResource((PassiveResource)null);
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
            case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
                return passiveResource != null;
        }
        return super.eIsSet(featureID);
    }

} //PassiveResourceReferenceImpl
