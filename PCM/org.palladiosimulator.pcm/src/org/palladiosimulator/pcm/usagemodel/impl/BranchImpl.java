/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Branch</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcm.usagemodel.impl.BranchImpl#getBranchTransitions_Branch
 * <em>Branch Transitions Branch</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BranchImpl extends AbstractUserActionImpl implements Branch {

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
    protected BranchImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.BRANCH;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<BranchTransition> getBranchTransitions_Branch() {
        return (EList<BranchTransition>) this.eDynamicGet(UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH,
                UsagemodelPackage.Literals.BRANCH__BRANCH_TRANSITIONS_BRANCH, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean AllBranchProbabilitiesMustSumUpTo1(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                                UsagemodelValidator.BRANCH__ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "AllBranchProbabilitiesMustSumUpTo1",
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getBranchTransitions_Branch())
                    .basicAdd(otherEnd, msgs);
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
        case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
            return ((InternalEList<?>) this.getBranchTransitions_Branch()).basicRemove(otherEnd, msgs);
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
        case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
            return this.getBranchTransitions_Branch();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
            this.getBranchTransitions_Branch().clear();
            this.getBranchTransitions_Branch().addAll((Collection<? extends BranchTransition>) newValue);
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
        case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
            this.getBranchTransitions_Branch().clear();
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
        case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
            return !this.getBranchTransitions_Branch().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // BranchImpl
