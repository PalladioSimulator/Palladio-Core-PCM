/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Role;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>System Operation Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getRole
 * <em>Role</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getOperationSignature
 * <em>Operation Signature</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getSystem
 * <em>System</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemOperationMeasuringPointImpl extends MeasuringPointImpl implements SystemOperationMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SystemOperationMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.SYSTEM_OPERATION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Role getRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Role basicGetRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final Role newRole) {
        this.eDynamicSet(PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE,
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
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationSignature basicGetOperationSignature() {
        return (OperationSignature) this.eDynamicGet(
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature(final OperationSignature newOperationSignature) {
        this.eDynamicSet(PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, newOperationSignature);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.getSystem() == null || this.getRole() == null || this.getOperationSignature() == null) {
            return "";
        }

        if (this.getSystem().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);

        final StringBuilder result = new StringBuilder();

        result.append(this.getSystem().getEntityName());
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

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public org.palladiosimulator.pcm.system.System getSystem() {
        return (org.palladiosimulator.pcm.system.System) this.eDynamicGet(
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM,
                PcmmeasuringpointPackage.Literals.SYSTEM_REFERENCE__SYSTEM, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public org.palladiosimulator.pcm.system.System basicGetSystem() {
        return (org.palladiosimulator.pcm.system.System) this.eDynamicGet(
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM,
                PcmmeasuringpointPackage.Literals.SYSTEM_REFERENCE__SYSTEM, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSystem(final org.palladiosimulator.pcm.system.System newSystem) {
        this.eDynamicSet(PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM,
                PcmmeasuringpointPackage.Literals.SYSTEM_REFERENCE__SYSTEM, newSystem);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            if (resolve) {
                return this.getRole();
            }
            return this.basicGetRole();
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            if (resolve) {
                return this.getOperationSignature();
            }
            return this.basicGetOperationSignature();
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            if (resolve) {
                return this.getSystem();
            }
            return this.basicGetSystem();
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            this.setRole((Role) newValue);
            return;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) newValue);
            return;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            this.setSystem((org.palladiosimulator.pcm.system.System) newValue);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            this.setRole((Role) null);
            return;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) null);
            return;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            this.setSystem((org.palladiosimulator.pcm.system.System) null);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE:
            return this.basicGetRole() != null;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            return this.basicGetOperationSignature() != null;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            return this.basicGetSystem() != null;
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
        if (baseClass == OperationReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE:
                return PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE;
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
                return PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE;
            default:
                return -1;
            }
        }
        if (baseClass == SystemReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
                return PcmmeasuringpointPackage.SYSTEM_REFERENCE__SYSTEM;
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
        if (baseClass == OperationReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
                return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__ROLE;
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
                return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE;
            default:
                return -1;
            }
        }
        if (baseClass == SystemReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.SYSTEM_REFERENCE__SYSTEM:
                return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // SystemOperationMeasuringPointImpl
