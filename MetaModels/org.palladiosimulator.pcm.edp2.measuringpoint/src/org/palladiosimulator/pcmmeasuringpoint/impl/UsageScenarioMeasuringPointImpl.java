/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;

import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage Scenario Measuring Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioMeasuringPointImpl#getUsageScenario <em>Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageScenarioMeasuringPointImpl extends MeasuringPointImpl implements UsageScenarioMeasuringPoint {
    /**
     * The cached value of the '{@link #getUsageScenario() <em>Usage Scenario</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsageScenario()
     * @generated
     * @ordered
     */
    protected UsageScenario usageScenario;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UsageScenarioMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsageScenario getUsageScenario() {
        if (usageScenario != null && usageScenario.eIsProxy()) {
            InternalEObject oldUsageScenario = (InternalEObject)usageScenario;
            usageScenario = (UsageScenario)eResolveProxy(oldUsageScenario);
            if (usageScenario != oldUsageScenario) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO, oldUsageScenario, usageScenario));
            }
        }
        return usageScenario;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsageScenario basicGetUsageScenario() {
        return usageScenario;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsageScenario(UsageScenario newUsageScenario) {
        UsageScenario oldUsageScenario = usageScenario;
        usageScenario = newUsageScenario;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO, oldUsageScenario, usageScenario));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
                if (resolve) return getUsageScenario();
                return basicGetUsageScenario();
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
            case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
                setUsageScenario((UsageScenario)newValue);
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
            case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
                setUsageScenario((UsageScenario)null);
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
            case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
                return usageScenario != null;
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
        if (baseClass == UsageScenarioReference.class) {
            switch (derivedFeatureID) {
                case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO: return PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO;
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
        if (baseClass == UsageScenarioReference.class) {
            switch (baseFeatureID) {
                case PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO: return PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //UsageScenarioMeasuringPointImpl
