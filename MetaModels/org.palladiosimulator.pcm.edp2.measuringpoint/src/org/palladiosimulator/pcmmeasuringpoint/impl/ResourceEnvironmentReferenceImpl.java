/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
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
public abstract class ResourceEnvironmentReferenceImpl extends MinimalEObjectImpl.Container implements
        ResourceEnvironmentReference {
    /**
     * The cached value of the '{@link #getResourceEnvironment() <em>Resource Environment</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceEnvironment()
     * @generated
     * @ordered
     */
    protected ResourceEnvironment resourceEnvironment;

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
    public ResourceEnvironment getResourceEnvironment() {
        if (this.resourceEnvironment != null && ((EObject) this.resourceEnvironment).eIsProxy()) {
            final InternalEObject oldResourceEnvironment = (InternalEObject) this.resourceEnvironment;
            this.resourceEnvironment = (ResourceEnvironment) this.eResolveProxy(oldResourceEnvironment);
            if (this.resourceEnvironment != oldResourceEnvironment) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT,
                            oldResourceEnvironment, this.resourceEnvironment));
                }
            }
        }
        return this.resourceEnvironment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceEnvironment basicGetResourceEnvironment() {
        return this.resourceEnvironment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceEnvironment(final ResourceEnvironment newResourceEnvironment) {
        final ResourceEnvironment oldResourceEnvironment = this.resourceEnvironment;
        this.resourceEnvironment = newResourceEnvironment;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT,
                    oldResourceEnvironment, this.resourceEnvironment));
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
            return this.resourceEnvironment != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceEnvironmentReferenceImpl
