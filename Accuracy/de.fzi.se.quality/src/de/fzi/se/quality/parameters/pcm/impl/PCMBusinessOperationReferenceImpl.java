/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.impl.OperationReferenceImpl;
import de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Business Operation Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl#getRole <em>
 * Role</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMBusinessOperationReferenceImpl#getSignature
 * <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMBusinessOperationReferenceImpl extends OperationReferenceImpl implements PCMBusinessOperationReference {

    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected OperationRequiredRole role;

    /**
     * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSignature()
     * @generated
     * @ordered
     */
    protected OperationSignature signature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMBusinessOperationReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationRequiredRole getRole() {
        if (this.role != null && ((EObject) this.role).eIsProxy()) {
            final InternalEObject oldRole = (InternalEObject) this.role;
            this.role = (OperationRequiredRole) this.eResolveProxy(oldRole);
            if (this.role != oldRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE, oldRole, this.role));
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
    public OperationRequiredRole basicGetRole() {
        return this.role;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final OperationRequiredRole newRole) {
        final OperationRequiredRole oldRole = this.role;
        this.role = newRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE, oldRole, this.role));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getSignature() {
        if (this.signature != null && ((EObject) this.signature).eIsProxy()) {
            final InternalEObject oldSignature = (InternalEObject) this.signature;
            this.signature = (OperationSignature) this.eResolveProxy(oldSignature);
            if (this.signature != oldSignature) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE, oldSignature, this.signature));
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
    public OperationSignature basicGetSignature() {
        return this.signature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSignature(final OperationSignature newSignature) {
        final OperationSignature oldSignature = this.signature;
        this.signature = newSignature;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE, oldSignature, this.signature));
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
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
            if (resolve) {
                return this.getRole();
            }
            return this.basicGetRole();
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
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
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
            this.setRole((OperationRequiredRole) newValue);
            return;
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
            this.setSignature((OperationSignature) newValue);
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
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
            this.setRole((OperationRequiredRole) null);
            return;
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
            this.setSignature((OperationSignature) null);
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
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE:
            return this.role != null;
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
            return this.signature != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMBusinessOperationReferenceImpl
