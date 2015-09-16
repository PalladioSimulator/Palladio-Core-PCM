/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Environment Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentMeasuringPointImpl#getResourceEnvironment
 * <em>Resource Environment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceEnvironmentMeasuringPointImpl extends MeasuringPointImpl
        implements ResourceEnvironmentMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceEnvironmentMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceEnvironment getResourceEnvironment() {
        return (ResourceEnvironment) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT,
                PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceEnvironment basicGetResourceEnvironment() {
        return (ResourceEnvironment) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT,
                PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceEnvironment(final ResourceEnvironment newResourceEnvironment) {
        this.eDynamicSet(PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT,
                PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT,
                newResourceEnvironment);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.getResourceEnvironment() == null) {
            return "";
        }

        if (this.getResourceEnvironment().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);

        final StringBuilder result = new StringBuilder();

        result.append("Resource Environment: ");
        result.append(this.getResourceEnvironment().getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getResourceEnvironment() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getResourceEnvironment());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT:
            if (resolve) {
                return this.getResourceEnvironment();
            }
            return this.basicGetResourceEnvironment();
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
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT:
            this.setResourceEnvironment((ResourceEnvironment) newValue);
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
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT:
            this.setResourceEnvironment((ResourceEnvironment) null);
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
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT:
            return this.basicGetResourceEnvironment() != null;
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
        if (baseClass == ResourceEnvironmentReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT:
                return PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT;
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
        if (baseClass == ResourceEnvironmentReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT:
                return PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT__RESOURCE_ENVIRONMENT;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // ResourceEnvironmentMeasuringPointImpl
