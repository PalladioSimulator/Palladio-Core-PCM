/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

import org.palladiosimulator.pcm.usagemodel.UsageScenario;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Usage Scenario Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioReferenceImpl#getUsageScenario
 * <em>Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UsageScenarioReferenceImpl extends CDOObjectImpl implements UsageScenarioReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected UsageScenarioReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public UsageScenario getUsageScenario() {
        return (UsageScenario) this.eDynamicGet(PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO,
                PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public UsageScenario basicGetUsageScenario() {
        return (UsageScenario) this.eDynamicGet(PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO,
                PcmmeasuringpointPackage.Literals.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setUsageScenario(final UsageScenario newUsageScenario) {
        this.eDynamicSet(PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO,
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
        case PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO:
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
        case PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO:
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
        case PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO:
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
        case PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO:
            return this.basicGetUsageScenario() != null;
        }
        return super.eIsSet(featureID);
    }

} // UsageScenarioReferenceImpl
