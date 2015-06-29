/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Role;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyReference;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Assembly Operation Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl#getRole
 * <em>Role</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl#getOperationSignature
 * <em>Operation Signature</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl#getAssembly
 * <em>Assembly</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyOperationMeasuringPointImpl extends MeasuringPointImpl implements AssemblyOperationMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AssemblyOperationMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ASSEMBLY_OPERATION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Role getRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Role basicGetRole() {
        return (Role) this.eDynamicGet(PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final Role newRole) {
        this.eDynamicSet(PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE,
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
                PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationSignature basicGetOperationSignature() {
        return (OperationSignature) this.eDynamicGet(
                PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature(final OperationSignature newOperationSignature) {
        this.eDynamicSet(PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE,
                PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE__OPERATION_SIGNATURE, newOperationSignature);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssembly() {
        return (AssemblyContext) this.eDynamicGet(
                PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY,
                PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE__ASSEMBLY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssembly() {
        return (AssemblyContext) this.eDynamicGet(
                PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY,
                PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE__ASSEMBLY, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssembly(final AssemblyContext newAssembly) {
        this.eDynamicSet(PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY,
                PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE__ASSEMBLY, newAssembly);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.getAssembly() == null || this.getRole() == null || this.getOperationSignature() == null) {
            return "";
        }

        if (this.getAssembly().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);
        final StringBuilder result = new StringBuilder();

        result.append("Operation: ");
        result.append(this.getAssembly().getEntityName());
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
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE:
            if (resolve) {
                return this.getRole();
            }
            return this.basicGetRole();
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            if (resolve) {
                return this.getOperationSignature();
            }
            return this.basicGetOperationSignature();
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            if (resolve) {
                return this.getAssembly();
            }
            return this.basicGetAssembly();
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
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE:
            this.setRole((Role) newValue);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) newValue);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            this.setAssembly((AssemblyContext) newValue);
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
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE:
            this.setRole((Role) null);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) null);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            this.setAssembly((AssemblyContext) null);
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
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE:
            return this.basicGetRole() != null;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
            return this.basicGetOperationSignature() != null;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            return this.basicGetAssembly() != null;
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
        if (baseClass == OperationReference.class)
        {
            switch (derivedFeatureID)
            {
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE:
                return PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE;
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE:
                return PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE;
            default:
                return -1;
            }
        }
        if (baseClass == AssemblyReference.class)
        {
            switch (derivedFeatureID)
            {
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
                return PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY;
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
        if (baseClass == OperationReference.class)
        {
            switch (baseFeatureID)
            {
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
                return PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ROLE;
            case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
                return PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__OPERATION_SIGNATURE;
            default:
                return -1;
            }
        }
        if (baseClass == AssemblyReference.class)
        {
            switch (baseFeatureID)
            {
            case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
                return PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // AssemblyOperationMeasuringPointImpl
