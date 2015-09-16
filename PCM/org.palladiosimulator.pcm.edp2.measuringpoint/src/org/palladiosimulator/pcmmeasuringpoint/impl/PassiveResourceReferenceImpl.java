/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Passive Resource Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.PassiveResourceReferenceImpl#getPassiveResource
 * <em>Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PassiveResourceReferenceImpl extends CDOObjectImpl implements PassiveResourceReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PassiveResourceReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE;
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
    public PassiveResource getPassiveResource() {
        return (PassiveResource) this.eDynamicGet(
                PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveResource() {
        return (PassiveResource) this.eDynamicGet(
                PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassiveResource(final PassiveResource newPassiveResource) {
        this.eDynamicSet(PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, newPassiveResource);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
            if (resolve) {
                return this.getPassiveResource();
            }
            return this.basicGetPassiveResource();
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
        case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
            this.setPassiveResource((PassiveResource) newValue);
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
        case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
            this.setPassiveResource((PassiveResource) null);
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
        case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
            return this.basicGetPassiveResource() != null;
        }
        return super.eIsSet(featureID);
    }

} // PassiveResourceReferenceImpl
