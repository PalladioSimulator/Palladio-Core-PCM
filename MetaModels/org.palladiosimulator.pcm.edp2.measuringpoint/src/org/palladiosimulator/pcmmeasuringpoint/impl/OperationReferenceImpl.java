/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Role;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl#getOperationSignature <em>Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OperationReferenceImpl extends MinimalEObjectImpl.Container implements OperationReference {
    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected Role role;

    /**
     * The cached value of the '{@link #getOperationSignature() <em>Operation Signature</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationSignature()
     * @generated
     * @ordered
     */
    protected OperationSignature operationSignature;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Role getRole() {
        if (role != null && role.eIsProxy()) {
            InternalEObject oldRole = (InternalEObject)role;
            role = (Role)eResolveProxy(oldRole);
            if (role != oldRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE, oldRole, role));
            }
        }
        return role;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Role basicGetRole() {
        return role;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRole(Role newRole) {
        Role oldRole = role;
        role = newRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE, oldRole, role));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationSignature getOperationSignature() {
        if (operationSignature != null && operationSignature.eIsProxy()) {
            InternalEObject oldOperationSignature = (InternalEObject)operationSignature;
            operationSignature = (OperationSignature)eResolveProxy(oldOperationSignature);
            if (operationSignature != oldOperationSignature) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE, oldOperationSignature, operationSignature));
            }
        }
        return operationSignature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationSignature basicGetOperationSignature() {
        return operationSignature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationSignature(OperationSignature newOperationSignature) {
        OperationSignature oldOperationSignature = operationSignature;
        operationSignature = newOperationSignature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE, oldOperationSignature, operationSignature));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
                if (resolve) return getRole();
                return basicGetRole();
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
                if (resolve) return getOperationSignature();
                return basicGetOperationSignature();
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
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
                setRole((Role)newValue);
                return;
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
                setOperationSignature((OperationSignature)newValue);
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
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
                setRole((Role)null);
                return;
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
                setOperationSignature((OperationSignature)null);
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
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
                return role != null;
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
                return operationSignature != null;
        }
        return super.eIsSet(featureID);
    }

} //OperationReferenceImpl
