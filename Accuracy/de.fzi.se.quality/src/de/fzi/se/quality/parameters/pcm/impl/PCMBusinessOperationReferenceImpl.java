/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.ecore.EClass;

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
        return (OperationRequiredRole) this.eDynamicGet(PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE,
                PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE__ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationRequiredRole basicGetRole() {
        return (OperationRequiredRole) this.eDynamicGet(PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE,
                PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE__ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRole(final OperationRequiredRole newRole) {
        this.eDynamicSet(PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__ROLE,
                PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE__ROLE, newRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationSignature getSignature() {
        return (OperationSignature) this.eDynamicGet(PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationSignature basicGetSignature() {
        return (OperationSignature) this.eDynamicGet(PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSignature(final OperationSignature newSignature) {
        this.eDynamicSet(PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE, newSignature);
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
            return this.basicGetRole() != null;
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE__SIGNATURE:
            return this.basicGetSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMBusinessOperationReferenceImpl
