/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.ecore.EClass;

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
        return (OperationRequiredRole) this.eDynamicGet(
                PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE,
                PCMPackage.Literals.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationRequiredRole basicGetRequiredRole() {
        return (OperationRequiredRole) this.eDynamicGet(
                PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE,
                PCMPackage.Literals.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE, false,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredRole(final OperationRequiredRole newRequiredRole) {
        this.eDynamicSet(PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE,
                PCMPackage.Literals.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__REQUIRED_ROLE,
                newRequiredRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationSignature getSignature() {
        return (OperationSignature) this.eDynamicGet(
                PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationSignature basicGetSignature() {
        return (OperationSignature) this.eDynamicGet(
                PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSignature(final OperationSignature newSignature) {
        this.eDynamicSet(PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE, newSignature);
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
            return this.basicGetRequiredRole() != null;
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE__SIGNATURE:
            return this.basicGetSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMRequiredBusinessOperationReturnParameterReferenceImpl
