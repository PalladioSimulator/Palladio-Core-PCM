/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.subsystem.SubSystem;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sub System Operation Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl#getSubsystem
 * <em>Subsystem</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl#getRole
 * <em>Role</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemOperationMeasuringPointImpl#getOperationSignature
 * <em>Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemOperationMeasuringPointImpl extends MeasuringPointImpl implements
SubSystemOperationMeasuringPoint {
    /**
     * The cached value of the '{@link #getSubsystem() <em>Subsystem</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSubsystem()
     * @generated
     * @ordered
     */
    protected SubSystem subsystem;

    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected Role role;

    /**
     * The cached value of the '{@link #getOperationSignature() <em>Operation Signature</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOperationSignature()
     * @generated
     * @ordered
     */
    protected OperationSignature operationSignature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SubSystemOperationMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.SUB_SYSTEM_OPERATION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SubSystem getSubsystem() {
        if (this.subsystem != null && ((EObject) this.subsystem).eIsProxy()) {
            final InternalEObject oldSubsystem = (InternalEObject) this.subsystem;
            this.subsystem = (SubSystem) this.eResolveProxy(oldSubsystem);
            if (this.subsystem != oldSubsystem) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM, oldSubsystem,
                            this.subsystem));
                }
            }
        }
        return this.subsystem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SubSystem basicGetSubsystem() {
        return this.subsystem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSubsystem(final SubSystem newSubsystem) {
        final SubSystem oldSubsystem = this.subsystem;
        this.subsystem = newSubsystem;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM, oldSubsystem,
                    this.subsystem));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Role getRole() {
        if (this.role != null && ((EObject) this.role).eIsProxy()) {
            final InternalEObject oldRole = (InternalEObject) this.role;
            this.role = (Role) this.eResolveProxy(oldRole);
            if (this.role != oldRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE, oldRole, this.role));
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
    public Role basicGetRole() {
        return this.role;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final Role newRole) {
        final Role oldRole = this.role;
        this.role = newRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE, oldRole, this.role));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getOperationSignature() {
        if (this.operationSignature != null && ((EObject) this.operationSignature).eIsProxy()) {
            final InternalEObject oldOperationSignature = (InternalEObject) this.operationSignature;
            this.operationSignature = (OperationSignature) this.eResolveProxy(oldOperationSignature);
            if (this.operationSignature != oldOperationSignature) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                            oldOperationSignature, this.operationSignature));
                }
            }
        }
        return this.operationSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationSignature basicGetOperationSignature() {
        return this.operationSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature(final OperationSignature newOperationSignature) {
        final OperationSignature oldOperationSignature = this.operationSignature;
        this.operationSignature = newOperationSignature;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                    oldOperationSignature, this.operationSignature));
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
            if (resolve) {
                return this.getSubsystem();
            }
            return this.basicGetSubsystem();
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            if (resolve) {
                return this.getRole();
            }
            return this.basicGetRole();
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
            this.setSubsystem((SubSystem) newValue);
            return;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            this.setRole((Role) newValue);
            return;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
            this.setSubsystem((SubSystem) null);
            return;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            this.setRole((Role) null);
            return;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
            return this.subsystem != null;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            return this.role != null;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            return this.operationSignature != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == SubSystemReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM:
                return PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM;
            default:
                return -1;
            }
        }
        if (baseClass == OperationReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
                return PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE;
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
                return PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == SubSystemReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
                return PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM;
            default:
                return -1;
            }
        }
        if (baseClass == OperationReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
                return PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE;
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
                return PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // SubSystemOperationMeasuringPointImpl
