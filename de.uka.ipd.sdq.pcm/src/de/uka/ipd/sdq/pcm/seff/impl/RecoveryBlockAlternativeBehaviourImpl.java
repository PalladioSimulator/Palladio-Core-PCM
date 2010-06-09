/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

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

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recovery Block Alternative Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockAlternativeBehaviourImpl#getAbstractLoopAction_ResourceDemandingBehaviour <em>Abstract Loop Action Resource Demanding Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockAlternativeBehaviourImpl#getAbstractBranchTransition_ResourceDemandingBehaviour <em>Abstract Branch Transition Resource Demanding Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockAlternativeBehaviourImpl#getSteps_Behaviour <em>Steps Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockAlternativeBehaviourImpl#getNextAlternative <em>Next Alternative</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockAlternativeBehaviourImpl#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour <em>Recovery Block Action Recovery Block Alternative Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecoveryBlockAlternativeBehaviourImpl extends FailureHandlingEntityImpl implements RecoveryBlockAlternativeBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSteps_Behaviour() <em>Steps Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteps_Behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> steps_Behaviour;

	/**
	 * The cached value of the '{@link #getNextAlternative() <em>Next Alternative</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextAlternative()
	 * @generated
	 * @ordered
	 */
	protected RecoveryBlockAlternativeBehaviour nextAlternative;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecoveryBlockAlternativeBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractLoopAction getAbstractLoopAction_ResourceDemandingBehaviour() {
		if (eContainerFeatureID() != SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR) return null;
		return (AbstractLoopAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractLoopAction_ResourceDemandingBehaviour(AbstractLoopAction newAbstractLoopAction_ResourceDemandingBehaviour, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAbstractLoopAction_ResourceDemandingBehaviour, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractLoopAction_ResourceDemandingBehaviour(AbstractLoopAction newAbstractLoopAction_ResourceDemandingBehaviour) {
		if (newAbstractLoopAction_ResourceDemandingBehaviour != eInternalContainer() || (eContainerFeatureID() != SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR && newAbstractLoopAction_ResourceDemandingBehaviour != null)) {
			if (EcoreUtil.isAncestor(this, newAbstractLoopAction_ResourceDemandingBehaviour))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAbstractLoopAction_ResourceDemandingBehaviour != null)
				msgs = ((InternalEObject)newAbstractLoopAction_ResourceDemandingBehaviour).eInverseAdd(this, SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, AbstractLoopAction.class, msgs);
			msgs = basicSetAbstractLoopAction_ResourceDemandingBehaviour(newAbstractLoopAction_ResourceDemandingBehaviour, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR, newAbstractLoopAction_ResourceDemandingBehaviour, newAbstractLoopAction_ResourceDemandingBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractBranchTransition getAbstractBranchTransition_ResourceDemandingBehaviour() {
		if (eContainerFeatureID() != SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR) return null;
		return (AbstractBranchTransition)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractBranchTransition_ResourceDemandingBehaviour(AbstractBranchTransition newAbstractBranchTransition_ResourceDemandingBehaviour, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAbstractBranchTransition_ResourceDemandingBehaviour, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractBranchTransition_ResourceDemandingBehaviour(AbstractBranchTransition newAbstractBranchTransition_ResourceDemandingBehaviour) {
		if (newAbstractBranchTransition_ResourceDemandingBehaviour != eInternalContainer() || (eContainerFeatureID() != SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR && newAbstractBranchTransition_ResourceDemandingBehaviour != null)) {
			if (EcoreUtil.isAncestor(this, newAbstractBranchTransition_ResourceDemandingBehaviour))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAbstractBranchTransition_ResourceDemandingBehaviour != null)
				msgs = ((InternalEObject)newAbstractBranchTransition_ResourceDemandingBehaviour).eInverseAdd(this, SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION, AbstractBranchTransition.class, msgs);
			msgs = basicSetAbstractBranchTransition_ResourceDemandingBehaviour(newAbstractBranchTransition_ResourceDemandingBehaviour, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR, newAbstractBranchTransition_ResourceDemandingBehaviour, newAbstractBranchTransition_ResourceDemandingBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getSteps_Behaviour() {
		if (steps_Behaviour == null) {
			steps_Behaviour = new EObjectContainmentWithInverseEList<AbstractAction>(AbstractAction.class, this, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR, SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION);
		}
		return steps_Behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryBlockAlternativeBehaviour getNextAlternative() {
		if (nextAlternative != null && nextAlternative.eIsProxy()) {
			InternalEObject oldNextAlternative = (InternalEObject)nextAlternative;
			nextAlternative = (RecoveryBlockAlternativeBehaviour)eResolveProxy(oldNextAlternative);
			if (nextAlternative != oldNextAlternative) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE, oldNextAlternative, nextAlternative));
			}
		}
		return nextAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryBlockAlternativeBehaviour basicGetNextAlternative() {
		return nextAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextAlternative(RecoveryBlockAlternativeBehaviour newNextAlternative) {
		RecoveryBlockAlternativeBehaviour oldNextAlternative = nextAlternative;
		nextAlternative = newNextAlternative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE, oldNextAlternative, nextAlternative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryBlockAction getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour() {
		if (eContainerFeatureID() != SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR) return null;
		return (RecoveryBlockAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecoveryBlockAction_RecoveryBlockAlternativeBehaviour(RecoveryBlockAction newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecoveryBlockAction_RecoveryBlockAlternativeBehaviour(RecoveryBlockAction newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour) {
		if (newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour != eInternalContainer() || (eContainerFeatureID() != SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR && newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour != null)) {
			if (EcoreUtil.isAncestor(this, newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour != null)
				msgs = ((InternalEObject)newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour).eInverseAdd(this, SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS, RecoveryBlockAction.class, msgs);
			msgs = basicSetRecoveryBlockAction_RecoveryBlockAlternativeBehaviour(newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR, newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour, newRecoveryBlockAction_RecoveryBlockAlternativeBehaviour));
	}

	/**
	 * The cached OCL expression body for the '{@link #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Stop Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.steps_Behaviour->select(s|s.oclIsTypeOf(StopAction))->size() = 1";

	/**
	 * The cached OCL invariant for the '{@link #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Stop Action</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ExactlyOneStopAction(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
			try {
				EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_STOP_ACTION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ExactlyOneStopAction", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Start Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.steps_Behaviour->select(s|s.oclIsTypeOf(StartAction))->size() = 1";

	/**
	 * The cached OCL invariant for the '{@link #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Start Action</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ExactlyOneStartAction(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
			try {
				EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_START_ACTION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ExactlyOneStartAction", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each Action Except Start Actionand Stop Action Must Hhave APredecessor And Successor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).predecessor_AbstractAction.oclIsUndefined()) and not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).successor_AbstractAction.oclIsUndefined())";

	/**
	 * The cached OCL invariant for the '{@link #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each Action Except Start Actionand Stop Action Must Hhave APredecessor And Successor</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
			try {
				EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction)otherEnd, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAbstractBranchTransition_ResourceDemandingBehaviour((AbstractBranchTransition)otherEnd, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSteps_Behaviour()).basicAdd(otherEnd, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRecoveryBlockAction_RecoveryBlockAlternativeBehaviour((RecoveryBlockAction)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				return basicSetAbstractLoopAction_ResourceDemandingBehaviour(null, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				return basicSetAbstractBranchTransition_ResourceDemandingBehaviour(null, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR:
				return ((InternalEList<?>)getSteps_Behaviour()).basicRemove(otherEnd, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				return basicSetRecoveryBlockAction_RecoveryBlockAlternativeBehaviour(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				return eInternalContainer().eInverseRemove(this, SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, AbstractLoopAction.class, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				return eInternalContainer().eInverseRemove(this, SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION, AbstractBranchTransition.class, msgs);
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				return eInternalContainer().eInverseRemove(this, SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS, RecoveryBlockAction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				return getAbstractLoopAction_ResourceDemandingBehaviour();
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				return getAbstractBranchTransition_ResourceDemandingBehaviour();
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR:
				return getSteps_Behaviour();
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				if (resolve) return getNextAlternative();
				return basicGetNextAlternative();
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				return getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				setAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction)newValue);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				setAbstractBranchTransition_ResourceDemandingBehaviour((AbstractBranchTransition)newValue);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR:
				getSteps_Behaviour().clear();
				getSteps_Behaviour().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				setNextAlternative((RecoveryBlockAlternativeBehaviour)newValue);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				setRecoveryBlockAction_RecoveryBlockAlternativeBehaviour((RecoveryBlockAction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				setAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction)null);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				setAbstractBranchTransition_ResourceDemandingBehaviour((AbstractBranchTransition)null);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR:
				getSteps_Behaviour().clear();
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				setNextAlternative((RecoveryBlockAlternativeBehaviour)null);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				setRecoveryBlockAction_RecoveryBlockAlternativeBehaviour((RecoveryBlockAction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				return getAbstractLoopAction_ResourceDemandingBehaviour() != null;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				return getAbstractBranchTransition_ResourceDemandingBehaviour() != null;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR:
				return steps_Behaviour != null && !steps_Behaviour.isEmpty();
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				return nextAlternative != null;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR:
				return getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceDemandingBehaviour.class) {
			switch (derivedFeatureID) {
				case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR: return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR;
				case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR: return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR;
				case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR: return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceDemandingBehaviour.class) {
			switch (baseFeatureID) {
				case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR: return SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR;
				case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR: return SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR;
				case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR: return SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__STEPS_BEHAVIOUR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //RecoveryBlockAlternativeBehaviourImpl
