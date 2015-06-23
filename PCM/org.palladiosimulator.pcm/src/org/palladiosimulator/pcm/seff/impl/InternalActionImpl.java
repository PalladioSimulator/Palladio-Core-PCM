/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.impl;

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
import org.palladiosimulator.pcm.reliability.InternalFailureOccurrenceDescription;
import org.palladiosimulator.pcm.seff.InternalAction;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Internal Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.seff.impl.InternalActionImpl#getInternalFailureOccurrenceDescriptions__InternalAction
 * <em>Internal Failure Occurrence Descriptions Internal Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalActionImpl extends AbstractInternalControlFlowActionImpl implements InternalAction {

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
    protected InternalActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.INTERNAL_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<InternalFailureOccurrenceDescription> getInternalFailureOccurrenceDescriptions__InternalAction() {
        return (EList<InternalFailureOccurrenceDescription>) this.eDynamicGet(
                SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION,
                SeffPackage.Literals.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean MultipleInternalOccurrenceDescriptionsPerFailureTypeNotAllowed(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
                                SeffValidator.INTERNAL_ACTION__MULTIPLE_INTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "MultipleInternalOccurrenceDescriptionsPerFailureTypeNotAllowed",
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
    public boolean SumOfInternalActionFailureProbabilitiesMustNotExceed1(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
                                SeffValidator.INTERNAL_ACTION__SUM_OF_INTERNAL_ACTION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "SumOfInternalActionFailureProbabilitiesMustNotExceed1",
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
        case SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getInternalFailureOccurrenceDescriptions__InternalAction()).basicAdd(otherEnd, msgs);
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
        case SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION:
            return ((InternalEList<?>) this.getInternalFailureOccurrenceDescriptions__InternalAction())
                    .basicRemove(otherEnd, msgs);
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
        case SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION:
            return this.getInternalFailureOccurrenceDescriptions__InternalAction();
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
        case SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION:
            this.getInternalFailureOccurrenceDescriptions__InternalAction().clear();
            this.getInternalFailureOccurrenceDescriptions__InternalAction()
                    .addAll((Collection<? extends InternalFailureOccurrenceDescription>) newValue);
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
        case SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION:
            this.getInternalFailureOccurrenceDescriptions__InternalAction().clear();
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
        case SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION:
            return !this.getInternalFailureOccurrenceDescriptions__InternalAction().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // InternalActionImpl
