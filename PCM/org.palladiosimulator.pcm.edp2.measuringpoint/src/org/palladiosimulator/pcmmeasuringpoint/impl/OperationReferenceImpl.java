/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Role;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operation Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl#getRole <em>Role
 * </em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl#getOperationSignature
 * <em>Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OperationReferenceImpl extends CDOObjectImpl implements OperationReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected OperationReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Role getRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Role basicGetRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final Role newRole) {
        this.eDynamicSet(PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, newRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getOperationSignature() {
        return (OperationSignature) this.eDynamicGet(PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationSignature basicGetOperationSignature() {
        return (OperationSignature) this.eDynamicGet(PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature(final OperationSignature newOperationSignature) {
        this.eDynamicSet(PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, newOperationSignature);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            if (resolve) {
                return this.getRole();
            }
            return this.basicGetRole();
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            if (resolve) {
                return this.getOperationSignature();
            }
            return this.basicGetOperationSignature();
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
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            this.setRole((Role) newValue);
            return;
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) newValue);
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
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            this.setRole((Role) null);
            return;
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) null);
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
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            return this.basicGetRole() != null;
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            return this.basicGetOperationSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} // OperationReferenceImpl
