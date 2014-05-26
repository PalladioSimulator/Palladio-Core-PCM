/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;

import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Passive Resource Measuring Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl#getPassiveResource <em>Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyPassiveResourceMeasuringPointImpl extends AssemblyReferenceImpl implements AssemblyPassiveResourceMeasuringPoint {
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
    protected AssemblyPassiveResourceMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE, oldPassiveResource, passiveResource));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE, oldPassiveResource, passiveResource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
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
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
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
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
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
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
                return passiveResource != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == PassiveResourceReference.class) {
            switch (derivedFeatureID) {
                case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE: return PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE;
                default: return -1;
            }
        }
        if (baseClass == MeasuringPoint.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == PassiveResourceReference.class) {
            switch (baseFeatureID) {
                case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE: return PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE;
                default: return -1;
            }
        }
        if (baseClass == MeasuringPoint.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //AssemblyPassiveResourceMeasuringPointImpl
