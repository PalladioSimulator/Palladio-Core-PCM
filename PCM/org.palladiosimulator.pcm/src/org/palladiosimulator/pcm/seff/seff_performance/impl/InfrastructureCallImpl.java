/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.seff_performance.impl;

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
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.impl.CallActionImpl;
import org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall;
import org.palladiosimulator.pcm.seff.seff_performance.SeffPerformancePackage;
import org.palladiosimulator.pcm.seff.seff_performance.util.SeffPerformanceValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Infrastructure Call</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getSignature__InfrastructureCall
 * <em>Signature Infrastructure Call</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getNumberOfCalls__InfrastructureCall
 * <em>Number Of Calls Infrastructure Call</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getAction__InfrastructureCall
 * <em>Action Infrastructure Call</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getRequiredRole__InfrastructureCall
 * <em>Required Role Infrastructure Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InfrastructureCallImpl extends CallActionImpl implements InfrastructureCall {

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
    protected InfrastructureCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureSignature getSignature__InfrastructureCall() {
        return (InfrastructureSignature) this.eDynamicGet(
                SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureSignature basicGetSignature__InfrastructureCall() {
        return (InfrastructureSignature) this.eDynamicGet(
                SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSignature__InfrastructureCall(final InfrastructureSignature newSignature__InfrastructureCall) {
        this.eDynamicSet(SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL,
                newSignature__InfrastructureCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getNumberOfCalls__InfrastructureCall() {
        return (PCMRandomVariable) this.eDynamicGet(
                SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetNumberOfCalls__InfrastructureCall(
            final PCMRandomVariable newNumberOfCalls__InfrastructureCall, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newNumberOfCalls__InfrastructureCall,
                SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNumberOfCalls__InfrastructureCall(final PCMRandomVariable newNumberOfCalls__InfrastructureCall) {
        this.eDynamicSet(SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL,
                newNumberOfCalls__InfrastructureCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractInternalControlFlowAction getAction__InfrastructureCall() {
        return (AbstractInternalControlFlowAction) this.eDynamicGet(
                SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetAction__InfrastructureCall(
            final AbstractInternalControlFlowAction newAction__InfrastructureCall, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newAction__InfrastructureCall,
                SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAction__InfrastructureCall(final AbstractInternalControlFlowAction newAction__InfrastructureCall) {
        this.eDynamicSet(SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL,
                newAction__InfrastructureCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureRequiredRole getRequiredRole__InfrastructureCall() {
        return (InfrastructureRequiredRole) this.eDynamicGet(
                SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureRequiredRole basicGetRequiredRole__InfrastructureCall() {
        return (InfrastructureRequiredRole) this.eDynamicGet(
                SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredRole__InfrastructureCall(
            final InfrastructureRequiredRole newRequiredRole__InfrastructureCall) {
        this.eDynamicSet(SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL,
                SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL,
                newRequiredRole__InfrastructureCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean SignatureMustBelongToUsedRequiredRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                                SeffPerformanceValidator.INFRASTRUCTURE_CALL__SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "SignatureMustBelongToUsedRequiredRole",
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
    public boolean ReferencedRequiredRoleMustBeRequiredByComponent(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                                SeffPerformanceValidator.INFRASTRUCTURE_CALL__REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "ReferencedRequiredRoleMustBeRequiredByComponent",
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
    public boolean SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                        SeffPerformanceValidator.INFRASTRUCTURE_CALL__SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction",
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
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            final PCMRandomVariable numberOfCalls__InfrastructureCall = this.getNumberOfCalls__InfrastructureCall();
            if (numberOfCalls__InfrastructureCall != null) {
                msgs = ((InternalEObject) numberOfCalls__InfrastructureCall).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL,
                        null, msgs);
            }
            return this.basicSetNumberOfCalls__InfrastructureCall((PCMRandomVariable) otherEnd, msgs);
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetAction__InfrastructureCall((AbstractInternalControlFlowAction) otherEnd, msgs);
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
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            return this.basicSetNumberOfCalls__InfrastructureCall(null, msgs);
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            return this.basicSetAction__InfrastructureCall(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            return this.eInternalContainer().eInverseRemove(this,
                    SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION,
                    AbstractInternalControlFlowAction.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL:
            if (resolve) {
                return this.getSignature__InfrastructureCall();
            }
            return this.basicGetSignature__InfrastructureCall();
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            return this.getNumberOfCalls__InfrastructureCall();
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            return this.getAction__InfrastructureCall();
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL:
            if (resolve) {
                return this.getRequiredRole__InfrastructureCall();
            }
            return this.basicGetRequiredRole__InfrastructureCall();
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
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL:
            this.setSignature__InfrastructureCall((InfrastructureSignature) newValue);
            return;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            this.setNumberOfCalls__InfrastructureCall((PCMRandomVariable) newValue);
            return;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            this.setAction__InfrastructureCall((AbstractInternalControlFlowAction) newValue);
            return;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL:
            this.setRequiredRole__InfrastructureCall((InfrastructureRequiredRole) newValue);
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
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL:
            this.setSignature__InfrastructureCall((InfrastructureSignature) null);
            return;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            this.setNumberOfCalls__InfrastructureCall((PCMRandomVariable) null);
            return;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            this.setAction__InfrastructureCall((AbstractInternalControlFlowAction) null);
            return;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL:
            this.setRequiredRole__InfrastructureCall((InfrastructureRequiredRole) null);
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
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL:
            return this.basicGetSignature__InfrastructureCall() != null;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            return this.getNumberOfCalls__InfrastructureCall() != null;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            return this.getAction__InfrastructureCall() != null;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL:
            return this.basicGetRequiredRole__InfrastructureCall() != null;
        }
        return super.eIsSet(featureID);
    }

} // InfrastructureCallImpl
