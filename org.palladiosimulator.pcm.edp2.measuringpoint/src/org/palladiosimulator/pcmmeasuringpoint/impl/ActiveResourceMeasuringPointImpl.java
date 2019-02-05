/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Active Resource Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl#getActiveResource
 * <em>Active Resource</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl#getReplicaID
 * <em>Replica ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActiveResourceMeasuringPointImpl extends MeasuringPointImpl implements ActiveResourceMeasuringPoint {

    /**
     * The default value of the '{@link #getReplicaID() <em>Replica ID</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getReplicaID()
     * @generated
     * @ordered
     */
    protected static final int REPLICA_ID_EDEFAULT = 0;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ActiveResourceMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ACTIVE_RESOURCE_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProcessingResourceSpecification getActiveResource() {
        return (ProcessingResourceSpecification) this.eDynamicGet(
                PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ProcessingResourceSpecification basicGetActiveResource() {
        return (ProcessingResourceSpecification) this.eDynamicGet(
                PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setActiveResource(final ProcessingResourceSpecification newActiveResource) {
        this.eDynamicSet(PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE, newActiveResource);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getReplicaID() {
        return (Integer) this.eDynamicGet(PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID,
                PcmmeasuringpointPackage.Literals.ACTIVE_RESOURCE_REFERENCE__REPLICA_ID, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setReplicaID(final int newReplicaID) {
        this.eDynamicSet(PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID,
                PcmmeasuringpointPackage.Literals.ACTIVE_RESOURCE_REFERENCE__REPLICA_ID, newReplicaID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
            if (resolve) {
                return this.getActiveResource();
            }
            return this.basicGetActiveResource();
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
            return this.getReplicaID();
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
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
            this.setActiveResource((ProcessingResourceSpecification) newValue);
            return;
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
            this.setReplicaID((Integer) newValue);
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
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
            this.setActiveResource((ProcessingResourceSpecification) null);
            return;
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
            this.setReplicaID(REPLICA_ID_EDEFAULT);
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
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
            return this.basicGetActiveResource() != null;
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
            return this.getReplicaID() != REPLICA_ID_EDEFAULT;
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
        if (baseClass == ActiveResourceReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
                return PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE;
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
                return PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__REPLICA_ID;
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
        if (baseClass == ActiveResourceReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE:
                return PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE;
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__REPLICA_ID:
                return PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID;
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
        if (this.getActiveResource() == null) {
            return "";
        }

        if (this.getActiveResource().getActiveResourceType_ActiveResourceSpecification() == null) {
            return super.getStringRepresentation();
        }

        final StringBuilder result = new StringBuilder();
        result.append(this.getActiveResource().getActiveResourceType_ActiveResourceSpecification().getEntityName());
        result.append(" [");
        result.append(String.valueOf(this.getReplicaID()));
        result.append("] in ");
        result.append(this.getActiveResource().getResourceContainer_ProcessingResourceSpecification().getEntityName());
        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getActiveResource() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getActiveResource());
    }

} // ActiveResourceMeasuringPointImpl
