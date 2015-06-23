/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.usagemodel.OpenWorkload;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Open Workload</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.usagemodel.impl.OpenWorkloadImpl#getInterArrivalTime_OpenWorkload
 * <em>Inter Arrival Time Open Workload</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OpenWorkloadImpl extends WorkloadImpl implements OpenWorkload {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected OpenWorkloadImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.OPEN_WORKLOAD;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getInterArrivalTime_OpenWorkload() {
        return (PCMRandomVariable) this.eDynamicGet(UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD,
                UsagemodelPackage.Literals.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetInterArrivalTime_OpenWorkload(
            final PCMRandomVariable newInterArrivalTime_OpenWorkload, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newInterArrivalTime_OpenWorkload,
                UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInterArrivalTime_OpenWorkload(final PCMRandomVariable newInterArrivalTime_OpenWorkload) {
        this.eDynamicSet(UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD,
                UsagemodelPackage.Literals.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD,
                newInterArrivalTime_OpenWorkload);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                                UsagemodelValidator.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "InterArrivalTimeInOpenWorkloadNeedsToBeSpecified",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
            final PCMRandomVariable interArrivalTime_OpenWorkload = this.getInterArrivalTime_OpenWorkload();
            if (interArrivalTime_OpenWorkload != null) {
                msgs = ((InternalEObject) interArrivalTime_OpenWorkload).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD,
                        null, msgs);
            }
            return this.basicSetInterArrivalTime_OpenWorkload((PCMRandomVariable) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
            return this.basicSetInterArrivalTime_OpenWorkload(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
            return this.getInterArrivalTime_OpenWorkload();
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
        case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
            this.setInterArrivalTime_OpenWorkload((PCMRandomVariable) newValue);
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
        case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
            this.setInterArrivalTime_OpenWorkload((PCMRandomVariable) null);
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
        case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
            return this.getInterArrivalTime_OpenWorkload() != null;
        }
        return super.eIsSet(featureID);
    }

} // OpenWorkloadImpl
