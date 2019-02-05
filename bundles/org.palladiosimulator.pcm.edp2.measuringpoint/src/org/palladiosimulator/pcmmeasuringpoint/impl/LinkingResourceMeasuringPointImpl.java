/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Linking Resource Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceMeasuringPointImpl#getLinkingResource
 * <em>Linking Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkingResourceMeasuringPointImpl extends MeasuringPointImpl implements LinkingResourceMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected LinkingResourceMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LinkingResource getLinkingResource() {
        return (LinkingResource) this.eDynamicGet(
                PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE,
                PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public LinkingResource basicGetLinkingResource() {
        return (LinkingResource) this.eDynamicGet(
                PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE,
                PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLinkingResource(final LinkingResource newLinkingResource) {
        this.eDynamicSet(PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE,
                PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, newLinkingResource);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE:
            if (resolve) {
                return this.getLinkingResource();
            }
            return this.basicGetLinkingResource();
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
        case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE:
            this.setLinkingResource((LinkingResource) newValue);
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
        case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE:
            this.setLinkingResource((LinkingResource) null);
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
        case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE:
            return this.basicGetLinkingResource() != null;
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
        if (baseClass == LinkingResourceReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE:
                return PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE;
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
        if (baseClass == LinkingResourceReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
                return PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT__LINKING_RESOURCE;
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
        if (this.getLinkingResource() == null) {
            return "";
        }

        if (this.getLinkingResource().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);
        final StringBuilder result = new StringBuilder();

        result.append("Linking Resource: ");
        result.append(this.getLinkingResource().getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getLinkingResource() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getLinkingResource());
    }

} // LinkingResourceMeasuringPointImpl
