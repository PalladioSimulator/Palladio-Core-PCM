/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Linking Resource Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceReferenceImpl#getLinkingResource
 * <em>Linking Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LinkingResourceReferenceImpl extends CDOObjectImpl implements LinkingResourceReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LinkingResourceReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_REFERENCE;
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
    public LinkingResource getLinkingResource() {
        return (LinkingResource) this.eDynamicGet(
                PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE,
                PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public LinkingResource basicGetLinkingResource() {
        return (LinkingResource) this.eDynamicGet(
                PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE,
                PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLinkingResource(final LinkingResource newLinkingResource) {
        this.eDynamicSet(PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE,
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
        case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
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
        case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
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
        case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
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
        case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
            return this.basicGetLinkingResource() != null;
        }
        return super.eIsSet(featureID);
    }

} // LinkingResourceReferenceImpl
