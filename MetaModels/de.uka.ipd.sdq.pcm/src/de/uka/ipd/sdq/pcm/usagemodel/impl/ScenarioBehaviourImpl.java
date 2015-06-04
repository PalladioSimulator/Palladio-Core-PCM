/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Scenario Behaviour</b></em> '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl#getUsageScenario_SenarioBehaviour
 * <em>Usage Scenario Senario Behaviour</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl#getBranchTransition_ScenarioBehaviour
 * <em>Branch Transition Scenario Behaviour</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl#getLoop_ScenarioBehaviour
 * <em>Loop Scenario Behaviour</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl#getActions_ScenarioBehaviour
 * <em>Actions Scenario Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScenarioBehaviourImpl extends EntityImpl implements ScenarioBehaviour {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getActions_ScenarioBehaviour()
     * <em>Actions Scenario Behaviour</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getActions_ScenarioBehaviour()
     * @generated
     * @ordered
     */
    protected EList<AbstractUserAction> actions_ScenarioBehaviour;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ScenarioBehaviourImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<AbstractUserAction> getActions_ScenarioBehaviour() {
        if (this.actions_ScenarioBehaviour == null) {
            this.actions_ScenarioBehaviour = new EObjectContainmentWithInverseEList<AbstractUserAction>(
                    AbstractUserAction.class, this, UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR,
                    UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION);
        }
        return this.actions_ScenarioBehaviour;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactlyonestart</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.actions_ScenarioBehaviour->select(s|s.oclIsTypeOf(Start))->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactlyonestart</em>}' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean Exactlyonestart(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR);
            try {
                EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                        UsagemodelValidator.SCENARIO_BEHAVIOUR__EXACTLYONESTART, EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "Exactlyonestart", EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactlyonestop</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.actions_ScenarioBehaviour->select(s|s.oclIsTypeOf(Stop))->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactlyonestop</em>}' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean Exactlyonestop(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR);
            try {
                EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                        UsagemodelValidator.SCENARIO_BEHAVIOUR__EXACTLYONESTOP, EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "Exactlyonestop", EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Eachuseractionexcept Startand Stopmusthaveapredecessorandsuccessor</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.actions_ScenarioBehaviour->select(s|not s.oclIsTypeOf(Start) and not s.oclIsTypeOf(Stop))->exists(a|a.oclAsType(AbstractUserAction).predecessor.oclIsUndefined()) and not self.actions_ScenarioBehaviour->select(s|not s.oclIsTypeOf(Start) and not s.oclIsTypeOf(Stop))->exists(a|a.oclAsType(AbstractUserAction).successor.oclIsUndefined())";

    /**
     * The cached OCL invariant for the '
     * {@link #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Eachuseractionexcept Startand Stopmusthaveapredecessorandsuccessor</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR);
            try {
                EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        UsagemodelValidator.DIAGNOSTIC_SOURCE,
                        UsagemodelValidator.SCENARIO_BEHAVIOUR__EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor",
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
    public BranchTransition getBranchTransition_ScenarioBehaviour() {
        if (this.eContainerFeatureID() != UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR) {
            return null;
        }
        return (BranchTransition) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBranchTransition_ScenarioBehaviour(
            final BranchTransition newBranchTransition_ScenarioBehaviour, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newBranchTransition_ScenarioBehaviour,
                UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBranchTransition_ScenarioBehaviour(final BranchTransition newBranchTransition_ScenarioBehaviour) {
        if (newBranchTransition_ScenarioBehaviour != this.eInternalContainer()
                || (this.eContainerFeatureID() != UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR && newBranchTransition_ScenarioBehaviour != null)) {
            if (EcoreUtil.isAncestor(this, newBranchTransition_ScenarioBehaviour)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newBranchTransition_ScenarioBehaviour != null) {
                msgs = ((InternalEObject) newBranchTransition_ScenarioBehaviour).eInverseAdd(this,
                        UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION,
                        BranchTransition.class, msgs);
            }
            msgs = this.basicSetBranchTransition_ScenarioBehaviour(newBranchTransition_ScenarioBehaviour, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR,
                    newBranchTransition_ScenarioBehaviour, newBranchTransition_ScenarioBehaviour));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Loop getLoop_ScenarioBehaviour() {
        if (this.eContainerFeatureID() != UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR) {
            return null;
        }
        return (Loop) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetLoop_ScenarioBehaviour(final Loop newLoop_ScenarioBehaviour, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newLoop_ScenarioBehaviour,
                UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLoop_ScenarioBehaviour(final Loop newLoop_ScenarioBehaviour) {
        if (newLoop_ScenarioBehaviour != this.eInternalContainer()
                || (this.eContainerFeatureID() != UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR && newLoop_ScenarioBehaviour != null)) {
            if (EcoreUtil.isAncestor(this, newLoop_ScenarioBehaviour)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newLoop_ScenarioBehaviour != null) {
                msgs = ((InternalEObject) newLoop_ScenarioBehaviour).eInverseAdd(this,
                        UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, Loop.class, msgs);
            }
            msgs = this.basicSetLoop_ScenarioBehaviour(newLoop_ScenarioBehaviour, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR, newLoop_ScenarioBehaviour,
                    newLoop_ScenarioBehaviour));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UsageScenario getUsageScenario_SenarioBehaviour() {
        if (this.eContainerFeatureID() != UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR) {
            return null;
        }
        return (UsageScenario) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetUsageScenario_SenarioBehaviour(
            final UsageScenario newUsageScenario_SenarioBehaviour, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newUsageScenario_SenarioBehaviour,
                UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUsageScenario_SenarioBehaviour(final UsageScenario newUsageScenario_SenarioBehaviour) {
        if (newUsageScenario_SenarioBehaviour != this.eInternalContainer()
                || (this.eContainerFeatureID() != UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR && newUsageScenario_SenarioBehaviour != null)) {
            if (EcoreUtil.isAncestor(this, newUsageScenario_SenarioBehaviour)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newUsageScenario_SenarioBehaviour != null) {
                msgs = ((InternalEObject) newUsageScenario_SenarioBehaviour).eInverseAdd(this,
                        UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, UsageScenario.class, msgs);
            }
            msgs = this.basicSetUsageScenario_SenarioBehaviour(newUsageScenario_SenarioBehaviour, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR,
                    newUsageScenario_SenarioBehaviour, newUsageScenario_SenarioBehaviour));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetUsageScenario_SenarioBehaviour((UsageScenario) otherEnd, msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetBranchTransition_ScenarioBehaviour((BranchTransition) otherEnd, msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetLoop_ScenarioBehaviour((Loop) otherEnd, msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getActions_ScenarioBehaviour()).basicAdd(
                    otherEnd, msgs);
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
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR:
            return this.basicSetUsageScenario_SenarioBehaviour(null, msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR:
            return this.basicSetBranchTransition_ScenarioBehaviour(null, msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR:
            return this.basicSetLoop_ScenarioBehaviour(null, msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
            return ((InternalEList<?>) this.getActions_ScenarioBehaviour()).basicRemove(otherEnd, msgs);
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
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR:
            return this.eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, UsageScenario.class, msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR:
            return this.eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, BranchTransition.class,
                    msgs);
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR:
            return this.eInternalContainer().eInverseRemove(this, UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP,
                    Loop.class, msgs);
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
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR:
            return this.getUsageScenario_SenarioBehaviour();
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR:
            return this.getBranchTransition_ScenarioBehaviour();
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR:
            return this.getLoop_ScenarioBehaviour();
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
            return this.getActions_ScenarioBehaviour();
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
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR:
            this.setUsageScenario_SenarioBehaviour((UsageScenario) newValue);
            return;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR:
            this.setBranchTransition_ScenarioBehaviour((BranchTransition) newValue);
            return;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR:
            this.setLoop_ScenarioBehaviour((Loop) newValue);
            return;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
            this.getActions_ScenarioBehaviour().clear();
            this.getActions_ScenarioBehaviour().addAll((Collection<? extends AbstractUserAction>) newValue);
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
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR:
            this.setUsageScenario_SenarioBehaviour((UsageScenario) null);
            return;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR:
            this.setBranchTransition_ScenarioBehaviour((BranchTransition) null);
            return;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR:
            this.setLoop_ScenarioBehaviour((Loop) null);
            return;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
            this.getActions_ScenarioBehaviour().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR:
            return this.getUsageScenario_SenarioBehaviour() != null;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR:
            return this.getBranchTransition_ScenarioBehaviour() != null;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR:
            return this.getLoop_ScenarioBehaviour() != null;
        case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
            return this.actions_ScenarioBehaviour != null && !this.actions_ScenarioBehaviour.isEmpty();
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

} // ScenarioBehaviourImpl
