/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Environment Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ResourceEnvironmentReferenceImpl#getResourceEnvironment
 * <em>Resource Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceEnvironmentReferenceImpl extends CDOObjectImpl implements ResourceEnvironmentReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceEnvironmentReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_REFERENCE;
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
    public ResourceEnvironment getResourceEnvironment() {
        return (ResourceEnvironment) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT,
                PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceEnvironment basicGetResourceEnvironment() {
        return (ResourceEnvironment) this.eDynamicGet(
                PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT,
                PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceEnvironment(final ResourceEnvironment newResourceEnvironment) {
        this.eDynamicSet(PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT,
                PcmmeasuringpointPackage.Literals.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT,
                newResourceEnvironment);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT:
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
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT:
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
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT:
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
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT:
            return this.basicGetResourceEnvironment() != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceEnvironmentReferenceImpl
