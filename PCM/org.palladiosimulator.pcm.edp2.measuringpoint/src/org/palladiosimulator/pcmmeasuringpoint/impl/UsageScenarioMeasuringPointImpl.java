/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Usage Scenario Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioMeasuringPointImpl#getUsageScenario
 * <em>Usage Scenario</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsageScenarioMeasuringPointImpl extends MeasuringPointImpl implements UsageScenarioMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected UsageScenarioMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public UsageScenario getUsageScenario() {
        return (UsageScenario) this.eDynamicGet(PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO,
                PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public UsageScenario basicGetUsageScenario() {
        return (UsageScenario) this.eDynamicGet(PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO,
                PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setUsageScenario(final UsageScenario newUsageScenario) {
        this.eDynamicSet(PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO,
                PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO, newUsageScenario);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
            if (resolve) {
                return this.getUsageScenario();
            }
            return this.basicGetUsageScenario();
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
        case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
            this.setUsageScenario((UsageScenario) newValue);
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
        case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
            this.setUsageScenario((UsageScenario) null);
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
        case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
            return this.basicGetUsageScenario() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == UsageScenarioReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO:
                return PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == UsageScenarioReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO:
                return PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.getUsageScenario() == null) {
            return "";
        }

        if (this.getUsageScenario().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);
        final StringBuilder result = new StringBuilder();

        result.append("Usage Scenario: ");
        result.append(this.getUsageScenario().getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getUsageScenario() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getUsageScenario());
    }

} // UsageScenarioMeasuringPointImpl
