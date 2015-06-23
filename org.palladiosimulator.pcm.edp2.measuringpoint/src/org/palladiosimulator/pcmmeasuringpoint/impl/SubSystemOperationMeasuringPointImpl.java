/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
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
        return (SubSystem) this.eDynamicGet(PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM,
                PcmmeasuringpointPackage.Literals.SUB_SYSTEM_REFERENCE__SUBSYSTEM, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SubSystem basicGetSubsystem() {
        return (SubSystem) this.eDynamicGet(PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM,
                PcmmeasuringpointPackage.Literals.SUB_SYSTEM_REFERENCE__SUBSYSTEM, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSubsystem(final SubSystem newSubsystem) {
        this.eDynamicSet(PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__SUBSYSTEM,
                PcmmeasuringpointPackage.Literals.SUB_SYSTEM_REFERENCE__SUBSYSTEM, newSubsystem);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Role getRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Role basicGetRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final Role newRole) {
        this.eDynamicSet(PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, newRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getOperationSignature() {
        return (OperationSignature) this.eDynamicGet(
                PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationSignature basicGetOperationSignature() {
        return (OperationSignature) this.eDynamicGet(
                PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature(final OperationSignature newOperationSignature) {
        this.eDynamicSet(PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
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
            return this.basicGetSubsystem() != null;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            return this.basicGetRole() != null;
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            return this.basicGetOperationSignature() != null;
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

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.getSubsystem() == null || this.getRole() == null || this.getOperationSignature() == null) {
            throw new RuntimeException("PCM Measuring Point was not setup correctly");
        }

        if (this.getSubsystem().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);

        final StringBuilder result = new StringBuilder();

        result.append("Sub System Operation: ");
        result.append(this.getSubsystem().getEntityName());
        result.append(".");
        result.append(this.getRole().getEntityName());
        result.append(".");
        result.append(this.getOperationSignature().getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getOperationSignature() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getOperationSignature());
    }

} // SubSystemOperationMeasuringPointImpl
