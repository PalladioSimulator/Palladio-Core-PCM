/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.impl.OperationReferenceImpl;
import de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Infrastructure Operation Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl#getRole
 * <em>Role</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMInfrastructureOperationReferenceImpl#getSignature
 * <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMInfrastructureOperationReferenceImpl extends OperationReferenceImpl implements
PCMInfrastructureOperationReference {

    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected InfrastructureRequiredRole role;

    /**
     * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSignature()
     * @generated
     * @ordered
     */
    protected InfrastructureSignature signature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMInfrastructureOperationReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureRequiredRole getRole() {
        if (this.role != null && this.role.eIsProxy()) {
            final InternalEObject oldRole = (InternalEObject) this.role;
            this.role = (InfrastructureRequiredRole) this.eResolveProxy(oldRole);
            if (this.role != oldRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE, oldRole, this.role));
                }
            }
        }
        return this.role;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureRequiredRole basicGetRole() {
        return this.role;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final InfrastructureRequiredRole newRole) {
        final InfrastructureRequiredRole oldRole = this.role;
        this.role = newRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE, oldRole, this.role));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureSignature getSignature() {
        if (this.signature != null && this.signature.eIsProxy()) {
            final InternalEObject oldSignature = (InternalEObject) this.signature;
            this.signature = (InfrastructureSignature) this.eResolveProxy(oldSignature);
            if (this.signature != oldSignature) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE, oldSignature, this.signature));
                }
            }
        }
        return this.signature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureSignature basicGetSignature() {
        return this.signature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSignature(final InfrastructureSignature newSignature) {
        final InfrastructureSignature oldSignature = this.signature;
        this.signature = newSignature;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE, oldSignature, this.signature));
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
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
            if (resolve) {
                return this.getRole();
            }
            return this.basicGetRole();
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
            if (resolve) {
                return this.getSignature();
            }
            return this.basicGetSignature();
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
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
            this.setRole((InfrastructureRequiredRole) newValue);
            return;
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
            this.setSignature((InfrastructureSignature) newValue);
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
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
            this.setRole((InfrastructureRequiredRole) null);
            return;
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
            this.setSignature((InfrastructureSignature) null);
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
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE:
            return this.role != null;
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
            return this.signature != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMInfrastructureOperationReferenceImpl
