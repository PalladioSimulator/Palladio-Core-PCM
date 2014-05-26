/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linking Resource Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.LinkingResourceReferenceImpl#getLinkingResource <em>Linking Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LinkingResourceReferenceImpl extends MinimalEObjectImpl.Container implements LinkingResourceReference {
    /**
     * The cached value of the '{@link #getLinkingResource() <em>Linking Resource</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLinkingResource()
     * @generated
     * @ordered
     */
    protected LinkingResource linkingResource;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LinkingResourceReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.LINKING_RESOURCE_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkingResource getLinkingResource() {
        if (linkingResource != null && linkingResource.eIsProxy()) {
            InternalEObject oldLinkingResource = (InternalEObject)linkingResource;
            linkingResource = (LinkingResource)eResolveProxy(oldLinkingResource);
            if (linkingResource != oldLinkingResource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, oldLinkingResource, linkingResource));
            }
        }
        return linkingResource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkingResource basicGetLinkingResource() {
        return linkingResource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLinkingResource(LinkingResource newLinkingResource) {
        LinkingResource oldLinkingResource = linkingResource;
        linkingResource = newLinkingResource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE, oldLinkingResource, linkingResource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
                if (resolve) return getLinkingResource();
                return basicGetLinkingResource();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
                setLinkingResource((LinkingResource)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
                setLinkingResource((LinkingResource)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE:
                return linkingResource != null;
        }
        return super.eIsSet(featureID);
    }

} //LinkingResourceReferenceImpl
