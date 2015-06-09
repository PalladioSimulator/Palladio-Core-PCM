/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>External Call Action Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.ExternalCallActionReferenceImpl#getExternalCall
 * <em>External Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExternalCallActionReferenceImpl extends CDOObjectImpl implements ExternalCallActionReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ExternalCallActionReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_REFERENCE;
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
    public ExternalCallAction getExternalCall() {
        return (ExternalCallAction) this.eDynamicGet(
                PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL,
                PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ExternalCallAction basicGetExternalCall() {
        return (ExternalCallAction) this.eDynamicGet(
                PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL,
                PcmmeasuringpointPackage.Literals.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setExternalCall(final ExternalCallAction newExternalCall) {
        this.eDynamicSet(PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL,
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
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
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL:
            return this.basicGetExternalCall() != null;
        }
        return super.eIsSet(featureID);
    }

} // ExternalCallActionReferenceImpl
