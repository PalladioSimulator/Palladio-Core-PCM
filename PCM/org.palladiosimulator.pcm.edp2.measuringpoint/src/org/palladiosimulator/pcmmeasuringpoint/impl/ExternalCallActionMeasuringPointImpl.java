/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>External Call Action Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionMeasuringPointImpl#getExternalCall
 * <em>External Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalCallActionMeasuringPointImpl extends MeasuringPointImpl implements
        ExternalCallActionMeasuringPoint {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ExternalCallActionMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ExternalCallAction getExternalCall() {
        return (ExternalCallAction) this.eDynamicGet(
                PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL,
                PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ExternalCallAction basicGetExternalCall() {
        return (ExternalCallAction) this.eDynamicGet(
                PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL,
                PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setExternalCall(final ExternalCallAction newExternalCall) {
        this.eDynamicSet(PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL,
                PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL, newExternalCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL:
            if (resolve) {
                return this.getExternalCall();
            }
            return this.basicGetExternalCall();
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL:
            this.setExternalCall((ExternalCallAction) newValue);
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL:
            this.setExternalCall((ExternalCallAction) null);
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL:
            return this.basicGetExternalCall() != null;
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
        if (baseClass == ExternalCallActionReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL:
                return PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL;
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
        if (baseClass == ExternalCallActionReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
                return PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT__EXTERNAL_CALL;
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
        if (this.getExternalCall() == null) {
            return "";
        }

        if (this.getExternalCall().getEntityName() == null) {
            return super.getStringRepresentation();
        }

        EcoreUtil.resolveAll(this);

        final StringBuilder result = new StringBuilder();

        result.append("ExternalCall ");
        result.append(this.getExternalCall().getEntityName());
        result.append(" from ");
        result.append(this.getExternalCall().getRole_ExternalService().getRequiringEntity_RequiredRole()
                .getEntityName());
        result.append(" to ");
        result.append(this.getExternalCall().getRole_ExternalService().getEntityName());
        result.append("->");
        result.append(this.getExternalCall().getCalledService_ExternalService().getEntityName());
        result.append(" [");
        result.append(this.getExternalCall().getId());
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
        if (this.getExternalCall() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getExternalCall());
    }

} // ExternalCallActionMeasuringPointImpl
