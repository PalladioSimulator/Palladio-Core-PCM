/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.ResourceContainerMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Container Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerMeasuringPointImpl#getResourceContainer
 * <em>Resource Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceContainerMeasuringPointImpl extends MeasuringPointImpl implements ResourceContainerMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceContainerMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.RESOURCE_CONTAINER_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceContainer getResourceContainer() {
        return (ResourceContainer) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER,
                PcmmeasuringpointPackage.Literals.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceContainer basicGetResourceContainer() {
        return (ResourceContainer) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER,
                PcmmeasuringpointPackage.Literals.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceContainer(final ResourceContainer newResourceContainer) {
        this.eDynamicSet(PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER,
                PcmmeasuringpointPackage.Literals.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER,
                newResourceContainer);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER:
            if (resolve) {
                return this.getResourceContainer();
            }
            return this.basicGetResourceContainer();
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
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER:
            this.setResourceContainer((ResourceContainer) newValue);
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
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER:
            this.setResourceContainer((ResourceContainer) null);
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
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER:
            return this.basicGetResourceContainer() != null;
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
        if (baseClass == ResourceContainerReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER:
                return PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER;
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
        if (baseClass == ResourceContainerReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER:
                return PcmmeasuringpointPackage.RESOURCE_CONTAINER_MEASURING_POINT__RESOURCE_CONTAINER;
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
        if (this.getResourceContainer() == null) {
            return "";
        }

        if (this.getResourceContainer().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);

        final StringBuilder result = new StringBuilder();

        result.append("Resource Container ");
        result.append(this.getResourceContainer().getEntityName());
        result.append(" [");
        result.append(this.getResourceContainer().getId());
        result.append("]");

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getResourceContainer() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getResourceContainer());
    }

} // ResourceContainerMeasuringPointImpl
