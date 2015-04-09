/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Usage Scenario Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.UsageScenarioMeasuringPointImpl#getUsageScenario
 * <em>Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageScenarioMeasuringPointImpl extends MeasuringPointImpl implements UsageScenarioMeasuringPoint {
    /**
     * The cached value of the '{@link #getUsageScenario() <em>Usage Scenario</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getUsageScenario()
     * @generated
     * @ordered
     */
    protected UsageScenario usageScenario;

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
        if (this.usageScenario != null && ((EObject) this.usageScenario).eIsProxy()) {
            final InternalEObject oldUsageScenario = (InternalEObject) this.usageScenario;
            this.usageScenario = (UsageScenario) this.eResolveProxy(oldUsageScenario);
            if (this.usageScenario != oldUsageScenario) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO, oldUsageScenario,
                            this.usageScenario));
                }
            }
        }
        return this.usageScenario;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public UsageScenario basicGetUsageScenario() {
        return this.usageScenario;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setUsageScenario(final UsageScenario newUsageScenario) {
        final UsageScenario oldUsageScenario = this.usageScenario;
        this.usageScenario = newUsageScenario;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT__USAGE_SCENARIO, oldUsageScenario,
                    this.usageScenario));
        }
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
            return this.usageScenario != null;
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
        if (this.usageScenario == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        final StringBuilder result = new StringBuilder();

        result.append("Usage Scenario: ");
        result.append(this.usageScenario.getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.usageScenario == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.usageScenario);
    }

} // UsageScenarioMeasuringPointImpl
