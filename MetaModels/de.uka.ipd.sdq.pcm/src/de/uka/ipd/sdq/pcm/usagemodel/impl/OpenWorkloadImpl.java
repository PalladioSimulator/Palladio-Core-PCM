/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Open Workload</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.OpenWorkloadImpl#getInterArrivalTime_OpenWorkload
 * <em>Inter Arrival Time Open Workload</em>}</li>
 * </ul>
 * </p>
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
     * The cached value of the '{@link #getInterArrivalTime_OpenWorkload()
     * <em>Inter Arrival Time Open Workload</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getInterArrivalTime_OpenWorkload()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable interArrivalTime_OpenWorkload;

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
        return this.interArrivalTime_OpenWorkload;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetInterArrivalTime_OpenWorkload(
            final PCMRandomVariable newInterArrivalTime_OpenWorkload, NotificationChain msgs) {
        final PCMRandomVariable oldInterArrivalTime_OpenWorkload = this.interArrivalTime_OpenWorkload;
        this.interArrivalTime_OpenWorkload = newInterArrivalTime_OpenWorkload;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD,
                    oldInterArrivalTime_OpenWorkload, newInterArrivalTime_OpenWorkload);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInterArrivalTime_OpenWorkload(final PCMRandomVariable newInterArrivalTime_OpenWorkload) {
        if (newInterArrivalTime_OpenWorkload != this.interArrivalTime_OpenWorkload) {
            NotificationChain msgs = null;
            if (this.interArrivalTime_OpenWorkload != null) {
                msgs = ((InternalEObject) this.interArrivalTime_OpenWorkload).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE, PCMRandomVariable.class,
                        msgs);
            }
            if (newInterArrivalTime_OpenWorkload != null) {
                msgs = ((InternalEObject) newInterArrivalTime_OpenWorkload).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE, PCMRandomVariable.class,
                        msgs);
            }
            msgs = this.basicSetInterArrivalTime_OpenWorkload(newInterArrivalTime_OpenWorkload, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD,
                    newInterArrivalTime_OpenWorkload, newInterArrivalTime_OpenWorkload));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Inter Arrival Time In Open Workload Needs To Be Specified</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.interArrivalTime_OpenWorkload.oclIsUndefined() and self.interArrivalTime_OpenWorkload.specification <> ''";

    /**
     * The cached OCL invariant for the '
     * {@link #InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Inter Arrival Time In Open Workload Needs To Be Specified</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.OPEN_WORKLOAD);
            try {
                INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                        UsagemodelValidator.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "InterArrivalTimeInOpenWorkloadNeedsToBeSpecified",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
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
            if (this.interArrivalTime_OpenWorkload != null) {
                msgs = ((InternalEObject) this.interArrivalTime_OpenWorkload).eInverseRemove(this,
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
            return this.interArrivalTime_OpenWorkload != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // OpenWorkloadImpl
