/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;

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
     * The cached value of the '{@link #getPassiveResource() <em>Passive Resource</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPassiveResource()
     * @generated
     * @ordered
     */
    protected PassiveResource passiveResource;

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
    public PassiveResource getPassiveResource() {
        if (this.passiveResource != null && ((EObject) this.passiveResource).eIsProxy()) {
            final InternalEObject oldPassiveResource = (InternalEObject) this.passiveResource;
            this.passiveResource = (PassiveResource) this.eResolveProxy(oldPassiveResource);
            if (this.passiveResource != oldPassiveResource) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, oldPassiveResource,
                            this.passiveResource));
                }
            }
        }
        return this.passiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveResource() {
        return this.passiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassiveResource(final PassiveResource newPassiveResource) {
        final PassiveResource oldPassiveResource = this.passiveResource;
        this.passiveResource = newPassiveResource;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, oldPassiveResource,
                    this.passiveResource));
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
            return this.passiveResource != null;
        }
        return super.eIsSet(featureID);
    }

} // PassiveResourceReferenceImpl
