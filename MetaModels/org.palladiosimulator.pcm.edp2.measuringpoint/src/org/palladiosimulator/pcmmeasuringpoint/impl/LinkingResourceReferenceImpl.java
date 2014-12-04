/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
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
public abstract class LinkingResourceReferenceImpl extends MinimalEObjectImpl.Container implements
LinkingResourceReference {
    /**
     * The cached value of the '{@link #getLinkingResource() <em>Linking Resource</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLinkingResource()
     * @generated
     * @ordered
     */
    protected LinkingResource linkingResource;

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
    public LinkingResource getLinkingResource() {
        if (this.linkingResource != null && ((EObject) this.linkingResource).eIsProxy()) {
            final InternalEObject oldLinkingResource = (InternalEObject) this.linkingResource;
            this.linkingResource = (LinkingResource) this.eResolveProxy(oldLinkingResource);
            if (this.linkingResource != oldLinkingResource) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, oldLinkingResource,
                            this.linkingResource));
                }
            }
        }
        return this.linkingResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public LinkingResource basicGetLinkingResource() {
        return this.linkingResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLinkingResource(final LinkingResource newLinkingResource) {
        final LinkingResource oldLinkingResource = this.linkingResource;
        this.linkingResource = newLinkingResource;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, oldLinkingResource,
                    this.linkingResource));
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
            return this.linkingResource != null;
        }
        return super.eIsSet(featureID);
    }

} // LinkingResourceReferenceImpl
