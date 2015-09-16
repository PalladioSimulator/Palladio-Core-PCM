/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Entry Level System Call Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.EntryLevelSystemCallReferenceImpl#getEntryLevelSystemCall
 * <em>Entry Level System Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EntryLevelSystemCallReferenceImpl extends CDOObjectImpl implements EntryLevelSystemCallReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EntryLevelSystemCallReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE;
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
    public EntryLevelSystemCall getEntryLevelSystemCall() {
        return (EntryLevelSystemCall) this.eDynamicGet(
                PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL,
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
                PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL,
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
        this.eDynamicSet(PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL,
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
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL:
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
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL:
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
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL:
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
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL:
            return this.basicGetEntryLevelSystemCall() != null;
        }
        return super.eIsSet(featureID);
    }

} // EntryLevelSystemCallReferenceImpl
