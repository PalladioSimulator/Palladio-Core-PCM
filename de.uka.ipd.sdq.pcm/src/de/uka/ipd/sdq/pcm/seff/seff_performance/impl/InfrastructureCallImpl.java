/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.CallActionImpl;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.util.SeffPerformanceValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Infrastructure Call</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getSignature__InfrastructureCall
 * <em>Signature Infrastructure Call</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getNumberOfCalls__InfrastructureCall
 * <em>Number Of Calls Infrastructure Call</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getAction__InfrastructureCall
 * <em>Action Infrastructure Call</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.InfrastructureCallImpl#getRequiredRole__InfrastructureCall
 * <em>Required Role Infrastructure Call</em>}</li>
 * </ul>
 * </p>
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
     * The cached value of the '{@link #getSignature__InfrastructureCall()
     * <em>Signature Infrastructure Call</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getSignature__InfrastructureCall()
     * @generated
     * @ordered
     */
    protected InfrastructureSignature signature__InfrastructureCall;

    /**
     * The cached value of the '{@link #getNumberOfCalls__InfrastructureCall()
     * <em>Number Of Calls Infrastructure Call</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getNumberOfCalls__InfrastructureCall()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable numberOfCalls__InfrastructureCall;

    /**
     * The cached value of the '{@link #getRequiredRole__InfrastructureCall()
     * <em>Required Role Infrastructure Call</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getRequiredRole__InfrastructureCall()
     * @generated
     * @ordered
     */
    protected InfrastructureRequiredRole requiredRole__InfrastructureCall;

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
        if (this.signature__InfrastructureCall != null && ((EObject) this.signature__InfrastructureCall).eIsProxy()) {
            final InternalEObject oldSignature__InfrastructureCall = (InternalEObject) this.signature__InfrastructureCall;
            this.signature__InfrastructureCall = (InfrastructureSignature) this
                    .eResolveProxy(oldSignature__InfrastructureCall);
            if (this.signature__InfrastructureCall != oldSignature__InfrastructureCall) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL,
                            oldSignature__InfrastructureCall, this.signature__InfrastructureCall));
                }
            }
        }
        return this.signature__InfrastructureCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureSignature basicGetSignature__InfrastructureCall() {
        return this.signature__InfrastructureCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSignature__InfrastructureCall(final InfrastructureSignature newSignature__InfrastructureCall) {
        final InfrastructureSignature oldSignature__InfrastructureCall = this.signature__InfrastructureCall;
        this.signature__InfrastructureCall = newSignature__InfrastructureCall;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.INFRASTRUCTURE_CALL__SIGNATURE_INFRASTRUCTURE_CALL,
                    oldSignature__InfrastructureCall, this.signature__InfrastructureCall));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getNumberOfCalls__InfrastructureCall() {
        return this.numberOfCalls__InfrastructureCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetNumberOfCalls__InfrastructureCall(
            final PCMRandomVariable newNumberOfCalls__InfrastructureCall, NotificationChain msgs) {
        final PCMRandomVariable oldNumberOfCalls__InfrastructureCall = this.numberOfCalls__InfrastructureCall;
        this.numberOfCalls__InfrastructureCall = newNumberOfCalls__InfrastructureCall;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL,
                    oldNumberOfCalls__InfrastructureCall, newNumberOfCalls__InfrastructureCall);
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
    public void setNumberOfCalls__InfrastructureCall(final PCMRandomVariable newNumberOfCalls__InfrastructureCall) {
        if (newNumberOfCalls__InfrastructureCall != this.numberOfCalls__InfrastructureCall) {
            NotificationChain msgs = null;
            if (this.numberOfCalls__InfrastructureCall != null) {
                msgs = ((InternalEObject) this.numberOfCalls__InfrastructureCall).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            if (newNumberOfCalls__InfrastructureCall != null) {
                msgs = ((InternalEObject) newNumberOfCalls__InfrastructureCall).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__INFRASTRUCTURE_CALL_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetNumberOfCalls__InfrastructureCall(newNumberOfCalls__InfrastructureCall, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL,
                    newNumberOfCalls__InfrastructureCall, newNumberOfCalls__InfrastructureCall));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractInternalControlFlowAction getAction__InfrastructureCall() {
        if (this.eContainerFeatureID() != SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL) {
            return null;
        }
        return (AbstractInternalControlFlowAction) this.eInternalContainer();
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
        if (newAction__InfrastructureCall != this.eInternalContainer()
                || (this.eContainerFeatureID() != SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL && newAction__InfrastructureCall != null)) {
            if (EcoreUtil.isAncestor(this, newAction__InfrastructureCall)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newAction__InfrastructureCall != null) {
                msgs = ((InternalEObject) newAction__InfrastructureCall).eInverseAdd(this,
                        SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION,
                        AbstractInternalControlFlowAction.class, msgs);
            }
            msgs = this.basicSetAction__InfrastructureCall(newAction__InfrastructureCall, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL,
                    newAction__InfrastructureCall, newAction__InfrastructureCall));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureRequiredRole getRequiredRole__InfrastructureCall() {
        if (this.requiredRole__InfrastructureCall != null
                && ((EObject) this.requiredRole__InfrastructureCall).eIsProxy()) {
            final InternalEObject oldRequiredRole__InfrastructureCall = (InternalEObject) this.requiredRole__InfrastructureCall;
            this.requiredRole__InfrastructureCall = (InfrastructureRequiredRole) this
                    .eResolveProxy(oldRequiredRole__InfrastructureCall);
            if (this.requiredRole__InfrastructureCall != oldRequiredRole__InfrastructureCall) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL,
                            oldRequiredRole__InfrastructureCall, this.requiredRole__InfrastructureCall));
                }
            }
        }
        return this.requiredRole__InfrastructureCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureRequiredRole basicGetRequiredRole__InfrastructureCall() {
        return this.requiredRole__InfrastructureCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRequiredRole__InfrastructureCall(final InfrastructureRequiredRole newRequiredRole__InfrastructureCall) {
        final InfrastructureRequiredRole oldRequiredRole__InfrastructureCall = this.requiredRole__InfrastructureCall;
        this.requiredRole__InfrastructureCall = newRequiredRole__InfrastructureCall;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL,
                    oldRequiredRole__InfrastructureCall, this.requiredRole__InfrastructureCall));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #SignatureMustBelongToUsedRequiredRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Signature Must Belong To Used Required Role</em>}' operation. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #SignatureMustBelongToUsedRequiredRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "signature__InfrastructureCall.infrastructureInterface__InfrastructureSignature = requiredRole__InfrastructureCall.requiredInterface__InfrastructureRequiredRole";

    /**
     * The cached OCL invariant for the '
     * {@link #SignatureMustBelongToUsedRequiredRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Signature Must Belong To Used Required Role</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #SignatureMustBelongToUsedRequiredRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean SignatureMustBelongToUsedRequiredRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL);
            try {
                SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                        SeffPerformanceValidator.INFRASTRUCTURE_CALL__SIGNATURE_MUST_BELONG_TO_USED_REQUIRED_ROLE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "SignatureMustBelongToUsedRequiredRole", EObjectValidator.getObjectLabel(this, context)
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
     * {@link #ReferencedRequiredRoleMustBeRequiredByComponent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Referenced Required Role Must Be Required By Component</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ReferencedRequiredRoleMustBeRequiredByComponent(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.oclAsType(ecore::EObject)->closure(eContainer())->select( entity | entity.oclIsKindOf(pcm::core::entity::InterfaceRequiringEntity)).oclAsType(pcm::core::entity::InterfaceRequiringEntity).requiredRoles_InterfaceRequiringEntity->includes(self.requiredRole__InfrastructureCall)";

    /**
     * The cached OCL invariant for the '
     * {@link #ReferencedRequiredRoleMustBeRequiredByComponent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Referenced Required Role Must Be Required By Component</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ReferencedRequiredRoleMustBeRequiredByComponent(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ReferencedRequiredRoleMustBeRequiredByComponent(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL);
            try {
                REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                        SeffPerformanceValidator.INFRASTRUCTURE_CALL__REFERENCED_REQUIRED_ROLE_MUST_BE_REQUIRED_BY_COMPONENT,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "ReferencedRequiredRoleMustBeRequiredByComponent",
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
     * {@link #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Signature Role Combination Must Be Unique Within Abstract Internal Control Flow Action</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.action__InfrastructureCall.infrastructureCall__Action->select(call | call.requiredRole__InfrastructureCall = self.requiredRole__InfrastructureCall and call.signature__InfrastructureCall=self.signature__InfrastructureCall)->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Signature Role Combination Must Be Unique Within Abstract Internal Control Flow Action</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPerformancePackage.Literals.INFRASTRUCTURE_CALL);
            try {
                SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                        SeffPerformanceValidator.INFRASTRUCTURE_CALL__SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction",
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
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            if (this.numberOfCalls__InfrastructureCall != null) {
                msgs = ((InternalEObject) this.numberOfCalls__InfrastructureCall).eInverseRemove(this,
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
            return this.signature__InfrastructureCall != null;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__NUMBER_OF_CALLS_INFRASTRUCTURE_CALL:
            return this.numberOfCalls__InfrastructureCall != null;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL:
            return this.getAction__InfrastructureCall() != null;
        case SeffPerformancePackage.INFRASTRUCTURE_CALL__REQUIRED_ROLE_INFRASTRUCTURE_CALL:
            return this.requiredRole__InfrastructureCall != null;
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

} // InfrastructureCallImpl
