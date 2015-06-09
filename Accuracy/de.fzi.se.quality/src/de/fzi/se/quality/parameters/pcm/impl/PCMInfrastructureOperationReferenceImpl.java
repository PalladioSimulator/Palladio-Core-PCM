/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.ecore.EClass;

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
        return (InfrastructureRequiredRole) this.eDynamicGet(PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE,
                PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureRequiredRole basicGetRole() {
        return (InfrastructureRequiredRole) this.eDynamicGet(PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE,
                PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRole(final InfrastructureRequiredRole newRole) {
        this.eDynamicSet(PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE,
                PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__ROLE, newRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureSignature getSignature() {
        return (InfrastructureSignature) this.eDynamicGet(PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureSignature basicGetSignature() {
        return (InfrastructureSignature) this.eDynamicGet(PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSignature(final InfrastructureSignature newSignature) {
        this.eDynamicSet(PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE,
                PCMPackage.Literals.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE, newSignature);
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
            return this.basicGetRole() != null;
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE__SIGNATURE:
            return this.basicGetSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMInfrastructureOperationReferenceImpl
