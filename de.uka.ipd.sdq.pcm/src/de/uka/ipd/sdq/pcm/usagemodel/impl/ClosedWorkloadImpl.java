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
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Closed Workload</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ClosedWorkloadImpl#getPopulation <em>Population
 * </em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ClosedWorkloadImpl#getThinkTime_ClosedWorkload <em>
 * Think Time Closed Workload</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClosedWorkloadImpl extends WorkloadImpl implements ClosedWorkload {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getPopulation() <em>Population</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPopulation()
     * @generated
     * @ordered
     */
    protected static final int POPULATION_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPopulation() <em>Population</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPopulation()
     * @generated
     * @ordered
     */
    protected int population = POPULATION_EDEFAULT;

    /**
     * The cached value of the '{@link #getThinkTime_ClosedWorkload()
     * <em>Think Time Closed Workload</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getThinkTime_ClosedWorkload()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable thinkTime_ClosedWorkload;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ClosedWorkloadImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.CLOSED_WORKLOAD;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getPopulation() {
        return this.population;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPopulation(final int newPopulation) {
        final int oldPopulation = this.population;
        this.population = newPopulation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.CLOSED_WORKLOAD__POPULATION,
                    oldPopulation, this.population));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getThinkTime_ClosedWorkload() {
        return this.thinkTime_ClosedWorkload;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetThinkTime_ClosedWorkload(final PCMRandomVariable newThinkTime_ClosedWorkload,
            NotificationChain msgs) {
        final PCMRandomVariable oldThinkTime_ClosedWorkload = this.thinkTime_ClosedWorkload;
        this.thinkTime_ClosedWorkload = newThinkTime_ClosedWorkload;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD, oldThinkTime_ClosedWorkload,
                    newThinkTime_ClosedWorkload);
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
    public void setThinkTime_ClosedWorkload(final PCMRandomVariable newThinkTime_ClosedWorkload) {
        if (newThinkTime_ClosedWorkload != this.thinkTime_ClosedWorkload) {
            NotificationChain msgs = null;
            if (this.thinkTime_ClosedWorkload != null) {
                msgs = ((InternalEObject) this.thinkTime_ClosedWorkload).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE, PCMRandomVariable.class,
                        msgs);
            }
            if (newThinkTime_ClosedWorkload != null) {
                msgs = ((InternalEObject) newThinkTime_ClosedWorkload).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE, PCMRandomVariable.class,
                        msgs);
            }
            msgs = this.basicSetThinkTime_ClosedWorkload(newThinkTime_ClosedWorkload, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD, newThinkTime_ClosedWorkload,
                    newThinkTime_ClosedWorkload));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #PopulationInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Population In Closed Workload Needs To Be Specified</em>}' operation. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #PopulationInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.population.oclIsUndefined() and self.population <> ''";

    /**
     * The cached OCL invariant for the '
     * {@link #PopulationInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Population In Closed Workload Needs To Be Specified</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #PopulationInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean PopulationInClosedWorkloadNeedsToBeSpecified(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.CLOSED_WORKLOAD);
            try {
                POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                        UsagemodelValidator.CLOSED_WORKLOAD__POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "PopulationInClosedWorkloadNeedsToBeSpecified",
                                        EObjectValidator.getObjectLabel(this, context)
                                }), new Object[] {
                    this
                }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ThinkTimeInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Think Time In Closed Workload Needs To Be Specified</em>}' operation. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #ThinkTimeInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.thinkTime_ClosedWorkload.oclIsUndefined() and self.thinkTime_ClosedWorkload.specification <> ''";

    /**
     * The cached OCL invariant for the '
     * {@link #ThinkTimeInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Think Time In Closed Workload Needs To Be Specified</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ThinkTimeInClosedWorkloadNeedsToBeSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ThinkTimeInClosedWorkloadNeedsToBeSpecified(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.CLOSED_WORKLOAD);
            try {
                THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                        UsagemodelValidator.CLOSED_WORKLOAD__THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "ThinkTimeInClosedWorkloadNeedsToBeSpecified",
                                        EObjectValidator.getObjectLabel(this, context)
                                }), new Object[] {
                    this
                }));
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
        case UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD:
            if (this.thinkTime_ClosedWorkload != null) {
                msgs = ((InternalEObject) this.thinkTime_ClosedWorkload).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD, null, msgs);
            }
            return this.basicSetThinkTime_ClosedWorkload((PCMRandomVariable) otherEnd, msgs);
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
        case UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD:
            return this.basicSetThinkTime_ClosedWorkload(null, msgs);
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
        case UsagemodelPackage.CLOSED_WORKLOAD__POPULATION:
            return this.getPopulation();
        case UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD:
            return this.getThinkTime_ClosedWorkload();
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
        case UsagemodelPackage.CLOSED_WORKLOAD__POPULATION:
            this.setPopulation((Integer) newValue);
            return;
        case UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD:
            this.setThinkTime_ClosedWorkload((PCMRandomVariable) newValue);
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
        case UsagemodelPackage.CLOSED_WORKLOAD__POPULATION:
            this.setPopulation(POPULATION_EDEFAULT);
            return;
        case UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD:
            this.setThinkTime_ClosedWorkload((PCMRandomVariable) null);
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
        case UsagemodelPackage.CLOSED_WORKLOAD__POPULATION:
            return this.population != POPULATION_EDEFAULT;
        case UsagemodelPackage.CLOSED_WORKLOAD__THINK_TIME_CLOSED_WORKLOAD:
            return this.thinkTime_ClosedWorkload != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (population: ");
        result.append(this.population);
        result.append(')');
        return result.toString();
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // ClosedWorkloadImpl
