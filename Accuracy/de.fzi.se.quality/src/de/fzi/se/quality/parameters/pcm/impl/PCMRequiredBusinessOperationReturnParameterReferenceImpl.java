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

import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Required Business Operation Return Parameter Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMRequiredBusinessOperationReturnParameterReferenceImpl#getRequiredRole
 * <em>Required Role</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMRequiredBusinessOperationReturnParameterReferenceImpl#getSignature
 * <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMRequiredBusinessOperationReturnParameterReferenceImpl extends PCMParameterReferenceImpl implements
PCMRequiredBusinessOperationReturnParameterReference {

    /**
     * The cached value of the '{@link #getRequiredRole() <em>Required Role</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRequiredRole()
     * @generated
     * @ordered
     */
    protected OperationRequiredRole requiredRole;

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
    protected PCMRequiredBusinessOperationReturnParameterReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationRequiredRole getRequiredRole() {
        if (this.requiredRole != null && this.requiredRole.eIsProxy()) {
            final InternalEObject oldRequiredRole = (InternalEObject) this.requiredRole;
            this.requiredRole = (OperationRequiredRole) this.eResolveProxy(oldRequiredRole);
            if (this.requiredRole != oldRequiredRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE,
                            oldRequiredRole, this.requiredRole));
                }
            }
        }
        return this.requiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationRequiredRole basicGetRequiredRole() {
        return this.requiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRequiredRole(final OperationRequiredRole newRequiredRole) {
        final OperationRequiredRole oldRequiredRole = this.requiredRole;
        this.requiredRole = newRequiredRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE,
                    oldRequiredRole, this.requiredRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getSignature() {
        if (this.signature != null && this.signature.eIsProxy()) {
            final InternalEObject oldSignature = (InternalEObject) this.signature;
            this.signature = (OperationSignature) this.eResolveProxy(oldSignature);
            if (this.signature != oldSignature) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE,
                            oldSignature, this.signature));
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
                    PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE, oldSignature,
                    this.signature));
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
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE:
            if (resolve) {
                return this.getRequiredRole();
            }
            return this.basicGetRequiredRole();
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE:
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
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE:
            this.setRequiredRole((OperationRequiredRole) newValue);
            return;
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE:
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
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE:
            this.setRequiredRole((OperationRequiredRole) null);
            return;
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE:
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
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE:
            return this.requiredRole != null;
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE:
            return this.signature != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMRequiredBusinessOperationReturnParameterReferenceImpl
