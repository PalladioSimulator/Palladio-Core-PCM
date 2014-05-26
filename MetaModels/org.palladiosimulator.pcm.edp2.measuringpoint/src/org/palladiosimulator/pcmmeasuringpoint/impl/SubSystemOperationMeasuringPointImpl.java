/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Role;

import de.uka.ipd.sdq.pcm.subsystem.SubSystem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;

import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System Operation Measuring Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl#getSubsystem <em>Subsystem</em>}</li>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl#getOperationSignature <em>Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemOperationMeasuringPointImpl extends MeasuringPointImpl implements SubSystemOperationMeasuringPoint {
    /**
     * The cached value of the '{@link #getSubsystem() <em>Subsystem</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubsystem()
     * @generated
     * @ordered
     */
    protected SubSystem subsystem;

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
    protected SubSystemOperationMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.SUB_SYSTEM_OPERATION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SubSystem getSubsystem() {
        if (subsystem != null && subsystem.eIsProxy()) {
            InternalEObject oldSubsystem = (InternalEObject)subsystem;
            subsystem = (SubSystem)eResolveProxy(oldSubsystem);
            if (subsystem != oldSubsystem) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM, oldSubsystem, subsystem));
            }
        }
        return subsystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SubSystem basicGetSubsystem() {
        return subsystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSubsystem(SubSystem newSubsystem) {
        SubSystem oldSubsystem = subsystem;
        subsystem = newSubsystem;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM, oldSubsystem, subsystem));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE, oldRole, role));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE, oldRole, role));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE, oldOperationSignature, operationSignature));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE, oldOperationSignature, operationSignature));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
                if (resolve) return getSubsystem();
                return basicGetSubsystem();
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
                if (resolve) return getRole();
                return basicGetRole();
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
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
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
                setSubsystem((SubSystem)newValue);
                return;
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
                setRole((Role)newValue);
                return;
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
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
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
                setSubsystem((SubSystem)null);
                return;
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
                setRole((Role)null);
                return;
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
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
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
                return subsystem != null;
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
                return role != null;
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
                return operationSignature != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == SubSystemReference.class) {
            switch (derivedFeatureID) {
                case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM: return PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM;
                default: return -1;
            }
        }
        if (baseClass == OperationReference.class) {
            switch (derivedFeatureID) {
                case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE: return PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE;
                case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE: return PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == SubSystemReference.class) {
            switch (baseFeatureID) {
                case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM: return PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM;
                default: return -1;
            }
        }
        if (baseClass == OperationReference.class) {
            switch (baseFeatureID) {
                case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE: return PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE;
                case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE: return PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //SubSystemOperationMeasuringPointImpl
