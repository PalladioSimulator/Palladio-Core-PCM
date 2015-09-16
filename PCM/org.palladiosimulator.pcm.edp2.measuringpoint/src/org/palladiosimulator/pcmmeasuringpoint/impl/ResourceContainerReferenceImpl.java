/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Container Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceContainerReferenceImpl#getResourceContainer
 * <em>Resource Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ResourceContainerReferenceImpl extends CDOObjectImpl implements ResourceContainerReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceContainerReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.RESOURCE_CONTAINER_REFERENCE;
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
    public ResourceContainer getResourceContainer() {
        return (ResourceContainer) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER,
                PcmmeasuringpointPackage.Literals.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceContainer basicGetResourceContainer() {
        return (ResourceContainer) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER,
                PcmmeasuringpointPackage.Literals.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceContainer(final ResourceContainer newResourceContainer) {
        this.eDynamicSet(PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER,
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
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER:
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
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER:
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
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER:
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
        case PcmmeasuringpointPackage.RESOURCE_CONTAINER_REFERENCE__RESOURCE_CONTAINER:
            return this.basicGetResourceContainer() != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceContainerReferenceImpl
