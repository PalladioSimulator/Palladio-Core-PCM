/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Entry Level System Call Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallMeasuringPointImpl#getEntryLevelSystemCall
 * <em>Entry Level System Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryLevelSystemCallMeasuringPointImpl extends MeasuringPointImpl
        implements EntryLevelSystemCallMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EntryLevelSystemCallMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EntryLevelSystemCall getEntryLevelSystemCall() {
        return (EntryLevelSystemCall) this.eDynamicGet(
                PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL,
                PcmmeasuringpointPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public EntryLevelSystemCall basicGetEntryLevelSystemCall() {
        return (EntryLevelSystemCall) this.eDynamicGet(
                PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL,
                PcmmeasuringpointPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL, false,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEntryLevelSystemCall(final EntryLevelSystemCall newEntryLevelSystemCall) {
        this.eDynamicSet(PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL,
                PcmmeasuringpointPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL,
                newEntryLevelSystemCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL:
            if (resolve) {
                return this.getEntryLevelSystemCall();
            }
            return this.basicGetEntryLevelSystemCall();
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
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL:
            this.setEntryLevelSystemCall((EntryLevelSystemCall) newValue);
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
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL:
            this.setEntryLevelSystemCall((EntryLevelSystemCall) null);
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
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL:
            return this.basicGetEntryLevelSystemCall() != null;
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
        if (baseClass == EntryLevelSystemCallReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL:
                return PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL;
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
        if (baseClass == EntryLevelSystemCallReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL:
                return PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT__ENTRY_LEVEL_SYSTEM_CALL;
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
        if (this.getEntryLevelSystemCall() == null) {
            return "";
        }

        if (this.getEntryLevelSystemCall().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);

        final StringBuilder result = new StringBuilder();

        result.append("SystemCall ");
        result.append(this.getEntryLevelSystemCall().getEntityName());
        result.append(" to ");
        result.append(this.getEntryLevelSystemCall().getProvidedRole_EntryLevelSystemCall()
                .getProvidingEntity_ProvidedRole().getEntityName());
        result.append("->");
        result.append(this.getEntryLevelSystemCall().getProvidedRole_EntryLevelSystemCall().getEntityName());
        result.append("->");
        result.append(this.getEntryLevelSystemCall().getOperationSignature__EntryLevelSystemCall().getEntityName());
        result.append(" [");
        result.append(this.getEntryLevelSystemCall().getId());
        result.append("]");

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getEntryLevelSystemCall() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getEntryLevelSystemCall());
    }

} // EntryLevelSystemCallMeasuringPointImpl
