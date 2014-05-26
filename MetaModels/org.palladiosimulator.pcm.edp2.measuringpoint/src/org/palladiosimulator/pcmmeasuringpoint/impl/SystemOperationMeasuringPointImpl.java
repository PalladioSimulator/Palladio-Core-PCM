/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;

import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Operation Measuring Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getSystem <em>System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemOperationMeasuringPointImpl extends OperationReferenceImpl implements SystemOperationMeasuringPoint {
    /**
     * The cached value of the '{@link #getSystem() <em>System</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSystem()
     * @generated
     * @ordered
     */
    protected de.uka.ipd.sdq.pcm.system.System system;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemOperationMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.SYSTEM_OPERATION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public de.uka.ipd.sdq.pcm.system.System getSystem() {
        if (system != null && system.eIsProxy()) {
            InternalEObject oldSystem = (InternalEObject)system;
            system = (de.uka.ipd.sdq.pcm.system.System)eResolveProxy(oldSystem);
            if (system != oldSystem) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM, oldSystem, system));
            }
        }
        return system;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public de.uka.ipd.sdq.pcm.system.System basicGetSystem() {
        return system;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSystem(de.uka.ipd.sdq.pcm.system.System newSystem) {
        de.uka.ipd.sdq.pcm.system.System oldSystem = system;
        system = newSystem;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM, oldSystem, system));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
                if (resolve) return getSystem();
                return basicGetSystem();
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
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
                setSystem((de.uka.ipd.sdq.pcm.system.System)newValue);
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
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
                setSystem((de.uka.ipd.sdq.pcm.system.System)null);
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
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
                return system != null;
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
        if (baseClass == MeasuringPoint.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == SystemReference.class) {
            switch (derivedFeatureID) {
                case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM: return PcmmeasuringpointPackage.SYSTEM_REFERENCE__SYSTEM;
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
        if (baseClass == MeasuringPoint.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == SystemReference.class) {
            switch (baseFeatureID) {
                case PcmmeasuringpointPackage.SYSTEM_REFERENCE__SYSTEM: return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //SystemOperationMeasuringPointImpl
