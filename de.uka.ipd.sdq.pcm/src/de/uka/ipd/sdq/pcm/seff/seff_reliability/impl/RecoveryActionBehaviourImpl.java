/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.util.SeffReliabilityValidator;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Recovery Action Behaviour</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryActionBehaviourImpl#getAbstractLoopAction_ResourceDemandingBehaviour <em>Abstract Loop Action Resource Demanding Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryActionBehaviourImpl#getAbstractBranchTransition_ResourceDemandingBehaviour <em>Abstract Branch Transition Resource Demanding Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryActionBehaviourImpl#getSteps_Behaviour <em>Steps Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryActionBehaviourImpl#getFailureHandlingAlternatives__RecoveryActionBehaviour <em>Failure Handling Alternatives Recovery Action Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryActionBehaviourImpl#getRecoveryAction__RecoveryActionBehaviour <em>Recovery Action Recovery Action Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecoveryActionBehaviourImpl extends FailureHandlingEntityImpl
		implements RecoveryActionBehaviour {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSteps_Behaviour() <em>Steps Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSteps_Behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> steps_Behaviour;

	/**
	 * The cached value of the ' {@link #getFailureHandlingAlternatives__RecoveryActionBehaviour()
	 * <em>Failure Handling Alternatives Recovery Action Behaviour</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getFailureHandlingAlternatives__RecoveryActionBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList<RecoveryActionBehaviour> failureHandlingAlternatives__RecoveryActionBehaviour;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RecoveryActionBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffReliabilityPackage.Literals.RECOVERY_ACTION_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractLoopAction getAbstractLoopAction_ResourceDemandingBehaviour() {
		if (eContainerFeatureID() != SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR)
			return null;
		return (AbstractLoopAction) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractLoopAction_ResourceDemandingBehaviour(
			AbstractLoopAction newAbstractLoopAction_ResourceDemandingBehaviour,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newAbstractLoopAction_ResourceDemandingBehaviour,
				SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstractLoopAction_ResourceDemandingBehaviour(
			AbstractLoopAction newAbstractLoopAction_ResourceDemandingBehaviour) {
		if (newAbstractLoopAction_ResourceDemandingBehaviour != eInternalContainer()
				|| (eContainerFeatureID() != SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR && newAbstractLoopAction_ResourceDemandingBehaviour != null)) {
			if (EcoreUtil.isAncestor(this,
					(EObject) newAbstractLoopAction_ResourceDemandingBehaviour))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAbstractLoopAction_ResourceDemandingBehaviour != null)
				msgs = ((InternalEObject) newAbstractLoopAction_ResourceDemandingBehaviour)
						.eInverseAdd(
								this,
								SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP,
								AbstractLoopAction.class, msgs);
			msgs = basicSetAbstractLoopAction_ResourceDemandingBehaviour(
					newAbstractLoopAction_ResourceDemandingBehaviour, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR,
					newAbstractLoopAction_ResourceDemandingBehaviour,
					newAbstractLoopAction_ResourceDemandingBehaviour));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractBranchTransition getAbstractBranchTransition_ResourceDemandingBehaviour() {
		if (eContainerFeatureID() != SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR)
			return null;
		return (AbstractBranchTransition) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractBranchTransition_ResourceDemandingBehaviour(
			AbstractBranchTransition newAbstractBranchTransition_ResourceDemandingBehaviour,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newAbstractBranchTransition_ResourceDemandingBehaviour,
				SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstractBranchTransition_ResourceDemandingBehaviour(
			AbstractBranchTransition newAbstractBranchTransition_ResourceDemandingBehaviour) {
		if (newAbstractBranchTransition_ResourceDemandingBehaviour != eInternalContainer()
				|| (eContainerFeatureID() != SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR && newAbstractBranchTransition_ResourceDemandingBehaviour != null)) {
			if (EcoreUtil
					.isAncestor(
							this,
							(EObject) newAbstractBranchTransition_ResourceDemandingBehaviour))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAbstractBranchTransition_ResourceDemandingBehaviour != null)
				msgs = ((InternalEObject) newAbstractBranchTransition_ResourceDemandingBehaviour)
						.eInverseAdd(
								this,
								SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION,
								AbstractBranchTransition.class, msgs);
			msgs = basicSetAbstractBranchTransition_ResourceDemandingBehaviour(
					newAbstractBranchTransition_ResourceDemandingBehaviour,
					msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR,
					newAbstractBranchTransition_ResourceDemandingBehaviour,
					newAbstractBranchTransition_ResourceDemandingBehaviour));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractAction> getSteps_Behaviour() {
		if (steps_Behaviour == null) {
			steps_Behaviour = new EObjectContainmentWithInverseEList<AbstractAction>(
					AbstractAction.class,
					this,
					SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR,
					SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION);
		}
		return steps_Behaviour;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RecoveryActionBehaviour> getFailureHandlingAlternatives__RecoveryActionBehaviour() {
		if (failureHandlingAlternatives__RecoveryActionBehaviour == null) {
			failureHandlingAlternatives__RecoveryActionBehaviour = new EObjectResolvingEList<RecoveryActionBehaviour>(
					RecoveryActionBehaviour.class,
					this,
					SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__FAILURE_HANDLING_ALTERNATIVES_RECOVERY_ACTION_BEHAVIOUR);
		}
		return failureHandlingAlternatives__RecoveryActionBehaviour;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecoveryAction getRecoveryAction__RecoveryActionBehaviour() {
		if (eContainerFeatureID() != SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR)
			return null;
		return (RecoveryAction) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecoveryAction__RecoveryActionBehaviour(
			RecoveryAction newRecoveryAction__RecoveryActionBehaviour,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newRecoveryAction__RecoveryActionBehaviour,
				SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecoveryAction__RecoveryActionBehaviour(
			RecoveryAction newRecoveryAction__RecoveryActionBehaviour) {
		if (newRecoveryAction__RecoveryActionBehaviour != eInternalContainer()
				|| (eContainerFeatureID() != SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR && newRecoveryAction__RecoveryActionBehaviour != null)) {
			if (EcoreUtil.isAncestor(this,
					(EObject) newRecoveryAction__RecoveryActionBehaviour))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRecoveryAction__RecoveryActionBehaviour != null)
				msgs = ((InternalEObject) newRecoveryAction__RecoveryActionBehaviour)
						.eInverseAdd(
								this,
								SeffReliabilityPackage.RECOVERY_ACTION__RECOVERY_ACTION_BEHAVIOURS_RECOVERY_ACTION,
								RecoveryAction.class, msgs);
			msgs = basicSetRecoveryAction__RecoveryActionBehaviour(
					newRecoveryAction__RecoveryActionBehaviour, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR,
					newRecoveryAction__RecoveryActionBehaviour,
					newRecoveryAction__RecoveryActionBehaviour));
	}

	/**
	 * The cached OCL expression body for the '{@link #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Stop Action</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.steps_Behaviour->select(s|s.oclIsTypeOf(StopAction))->size() = 1";

	/**
	 * The cached OCL invariant for the '{@link #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Stop Action</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean ExactlyOneStopAction(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
			try {
				EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(
				EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
				this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								SeffValidator.DIAGNOSTIC_SOURCE,
								SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_STOP_ACTION,
								EcorePlugin.INSTANCE.getString(
										"_UI_GenericInvariant_diagnostic",
										new Object[] {
												"ExactlyOneStopAction",
												EObjectValidator
														.getObjectLabel(this,
																context) }),
								new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Start Action</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.steps_Behaviour->select(s|s.oclIsTypeOf(StartAction))->size() = 1";

	/**
	 * The cached OCL invariant for the '{@link #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Start Action</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean ExactlyOneStartAction(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
			try {
				EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(
				EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								SeffValidator.DIAGNOSTIC_SOURCE,
								SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_START_ACTION,
								EcorePlugin.INSTANCE.getString(
										"_UI_GenericInvariant_diagnostic",
										new Object[] {
												"ExactlyOneStartAction",
												EObjectValidator
														.getObjectLabel(this,
																context) }),
								new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each Action Except Start Actionand Stop Action Must Hhave APredecessor And Successor</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).predecessor_AbstractAction.oclIsUndefined()) and not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).successor_AbstractAction.oclIsUndefined())";

	/**
	 * The cached OCL invariant for the '{@link #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each Action Except Start Actionand Stop Action Must Hhave APredecessor And Successor</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
			try {
				EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV
				.createQuery(
						EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								SeffValidator.DIAGNOSTIC_SOURCE,
								SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR,
								EcorePlugin.INSTANCE
										.getString(
												"_UI_GenericInvariant_diagnostic",
												new Object[] {
														"EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor",
														EObjectValidator
																.getObjectLabel(
																		this,
																		context) }),
								new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #RecoveryActionBehaviourHasOnlyOnePredecessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Recovery Action Behaviour Has Only One Predecessor</em>}' operation.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #RecoveryActionBehaviourHasOnlyOnePredecessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String RECOVERY_ACTION_BEHAVIOUR_HAS_ONLY_ONE_PREDECESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.recoveryAction__RecoveryActionBehaviour.recoveryActionBehaviours__RecoveryAction->\n"
			+ "	exists(x,y:RecoveryActionBehaviour | x<>y\n"
			+ "		and x.failureHandlingAlternatives__RecoveryActionBehaviour->includes(self)\n"
			+ "		and y.failureHandlingAlternatives__RecoveryActionBehaviour->includes(self))";

	/**
	 * The cached OCL invariant for the '
	 * {@link #RecoveryActionBehaviourHasOnlyOnePredecessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Recovery Action Behaviour Has Only One Predecessor</em>}' invariant operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #RecoveryActionBehaviourHasOnlyOnePredecessor(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint RECOVERY_ACTION_BEHAVIOUR_HAS_ONLY_ONE_PREDECESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean RecoveryActionBehaviourHasOnlyOnePredecessor(
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (RECOVERY_ACTION_BEHAVIOUR_HAS_ONLY_ONE_PREDECESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffReliabilityPackage.Literals.RECOVERY_ACTION_BEHAVIOUR);
			try {
				RECOVERY_ACTION_BEHAVIOUR_HAS_ONLY_ONE_PREDECESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(RECOVERY_ACTION_BEHAVIOUR_HAS_ONLY_ONE_PREDECESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV
				.createQuery(
						RECOVERY_ACTION_BEHAVIOUR_HAS_ONLY_ONE_PREDECESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								SeffReliabilityValidator.DIAGNOSTIC_SOURCE,
								SeffReliabilityValidator.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_BEHAVIOUR_HAS_ONLY_ONE_PREDECESSOR,
								EcorePlugin.INSTANCE
										.getString(
												"_UI_GenericInvariant_diagnostic",
												new Object[] {
														"RecoveryActionBehaviourHasOnlyOnePredecessor",
														EObjectValidator
																.getObjectLabel(
																		this,
																		context) }),
								new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '
	 * {@link #RecoveryActionBehaviourIsNotSuccessorOfItself(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Recovery Action Behaviour Is Not Successor Of Itself</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #RecoveryActionBehaviourIsNotSuccessorOfItself(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String RECOVERY_ACTION_BEHAVIOUR_IS_NOT_SUCCESSOR_OF_ITSELF__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.failureHandlingAlternatives__RecoveryActionBehaviour->includes(self)";

	/**
	 * The cached OCL invariant for the '
	 * {@link #RecoveryActionBehaviourIsNotSuccessorOfItself(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Recovery Action Behaviour Is Not Successor Of Itself</em>}' invariant operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #RecoveryActionBehaviourIsNotSuccessorOfItself(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint RECOVERY_ACTION_BEHAVIOUR_IS_NOT_SUCCESSOR_OF_ITSELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean RecoveryActionBehaviourIsNotSuccessorOfItself(
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (RECOVERY_ACTION_BEHAVIOUR_IS_NOT_SUCCESSOR_OF_ITSELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffReliabilityPackage.Literals.RECOVERY_ACTION_BEHAVIOUR);
			try {
				RECOVERY_ACTION_BEHAVIOUR_IS_NOT_SUCCESSOR_OF_ITSELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(RECOVERY_ACTION_BEHAVIOUR_IS_NOT_SUCCESSOR_OF_ITSELF__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV
				.createQuery(
						RECOVERY_ACTION_BEHAVIOUR_IS_NOT_SUCCESSOR_OF_ITSELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								SeffReliabilityValidator.DIAGNOSTIC_SOURCE,
								SeffReliabilityValidator.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_BEHAVIOUR_IS_NOT_SUCCESSOR_OF_ITSELF,
								EcorePlugin.INSTANCE
										.getString(
												"_UI_GenericInvariant_diagnostic",
												new Object[] {
														"RecoveryActionBehaviourIsNotSuccessorOfItself",
														EObjectValidator
																.getObjectLabel(
																		this,
																		context) }),
								new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #SuccessorsOfRecoveryActionBehaviourHandleDisjointFailureTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Successors Of Recovery Action Behaviour Handle Disjoint Failure Types</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SuccessorsOfRecoveryActionBehaviourHandleDisjointFailureTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SUCCESSORS_OF_RECOVERY_ACTION_BEHAVIOUR_HANDLE_DISJOINT_FAILURE_TYPES__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.failureHandlingAlternatives__RecoveryActionBehaviour->\n"
			+ "	exists(x,y:RecoveryActionBehaviour | x<>y and\n"
			+ "	x.failureTypes_FailureHandlingEntity->\n"
			+ "		exists(f:pcm::reliability::FailureType |\n"
			+ "		y.failureTypes_FailureHandlingEntity->includes(f)))";

	/**
	 * The cached OCL invariant for the '{@link #SuccessorsOfRecoveryActionBehaviourHandleDisjointFailureTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Successors Of Recovery Action Behaviour Handle Disjoint Failure Types</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SuccessorsOfRecoveryActionBehaviourHandleDisjointFailureTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint SUCCESSORS_OF_RECOVERY_ACTION_BEHAVIOUR_HANDLE_DISJOINT_FAILURE_TYPES__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean SuccessorsOfRecoveryActionBehaviourHandleDisjointFailureTypes(
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (SUCCESSORS_OF_RECOVERY_ACTION_BEHAVIOUR_HANDLE_DISJOINT_FAILURE_TYPES__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffReliabilityPackage.Literals.RECOVERY_ACTION_BEHAVIOUR);
			try {
				SUCCESSORS_OF_RECOVERY_ACTION_BEHAVIOUR_HANDLE_DISJOINT_FAILURE_TYPES__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(SUCCESSORS_OF_RECOVERY_ACTION_BEHAVIOUR_HANDLE_DISJOINT_FAILURE_TYPES__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV
				.createQuery(
						SUCCESSORS_OF_RECOVERY_ACTION_BEHAVIOUR_HANDLE_DISJOINT_FAILURE_TYPES__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								SeffReliabilityValidator.DIAGNOSTIC_SOURCE,
								SeffReliabilityValidator.RECOVERY_ACTION_BEHAVIOUR__SUCCESSORS_OF_RECOVERY_ACTION_BEHAVIOUR_HANDLE_DISJOINT_FAILURE_TYPES,
								EcorePlugin.INSTANCE
										.getString(
												"_UI_GenericInvariant_diagnostic",
												new Object[] {
														"SuccessorsOfRecoveryActionBehaviourHandleDisjointFailureTypes",
														EObjectValidator
																.getObjectLabel(
																		this,
																		context) }),
								new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetAbstractLoopAction_ResourceDemandingBehaviour(
					(AbstractLoopAction) otherEnd, msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetAbstractBranchTransition_ResourceDemandingBehaviour(
					(AbstractBranchTransition) otherEnd, msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSteps_Behaviour())
					.basicAdd(otherEnd, msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRecoveryAction__RecoveryActionBehaviour(
					(RecoveryAction) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
			return basicSetAbstractLoopAction_ResourceDemandingBehaviour(null,
					msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
			return basicSetAbstractBranchTransition_ResourceDemandingBehaviour(
					null, msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR:
			return ((InternalEList<?>) getSteps_Behaviour()).basicRemove(
					otherEnd, msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR:
			return basicSetRecoveryAction__RecoveryActionBehaviour(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
			return eInternalContainer().eInverseRemove(this,
					SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP,
					AbstractLoopAction.class, msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
			return eInternalContainer()
					.eInverseRemove(
							this,
							SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION,
							AbstractBranchTransition.class, msgs);
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR:
			return eInternalContainer()
					.eInverseRemove(
							this,
							SeffReliabilityPackage.RECOVERY_ACTION__RECOVERY_ACTION_BEHAVIOURS_RECOVERY_ACTION,
							RecoveryAction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
			return getAbstractLoopAction_ResourceDemandingBehaviour();
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
			return getAbstractBranchTransition_ResourceDemandingBehaviour();
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR:
			return getSteps_Behaviour();
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__FAILURE_HANDLING_ALTERNATIVES_RECOVERY_ACTION_BEHAVIOUR:
			return getFailureHandlingAlternatives__RecoveryActionBehaviour();
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR:
			return getRecoveryAction__RecoveryActionBehaviour();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
			setAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction) newValue);
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
			setAbstractBranchTransition_ResourceDemandingBehaviour((AbstractBranchTransition) newValue);
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR:
			getSteps_Behaviour().clear();
			getSteps_Behaviour().addAll(
					(Collection<? extends AbstractAction>) newValue);
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__FAILURE_HANDLING_ALTERNATIVES_RECOVERY_ACTION_BEHAVIOUR:
			getFailureHandlingAlternatives__RecoveryActionBehaviour().clear();
			getFailureHandlingAlternatives__RecoveryActionBehaviour().addAll(
					(Collection<? extends RecoveryActionBehaviour>) newValue);
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR:
			setRecoveryAction__RecoveryActionBehaviour((RecoveryAction) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
			setAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction) null);
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
			setAbstractBranchTransition_ResourceDemandingBehaviour((AbstractBranchTransition) null);
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR:
			getSteps_Behaviour().clear();
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__FAILURE_HANDLING_ALTERNATIVES_RECOVERY_ACTION_BEHAVIOUR:
			getFailureHandlingAlternatives__RecoveryActionBehaviour().clear();
			return;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR:
			setRecoveryAction__RecoveryActionBehaviour((RecoveryAction) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
			return getAbstractLoopAction_ResourceDemandingBehaviour() != null;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
			return getAbstractBranchTransition_ResourceDemandingBehaviour() != null;
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR:
			return steps_Behaviour != null && !steps_Behaviour.isEmpty();
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__FAILURE_HANDLING_ALTERNATIVES_RECOVERY_ACTION_BEHAVIOUR:
			return failureHandlingAlternatives__RecoveryActionBehaviour != null
					&& !failureHandlingAlternatives__RecoveryActionBehaviour
							.isEmpty();
		case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__RECOVERY_ACTION_RECOVERY_ACTION_BEHAVIOUR:
			return getRecoveryAction__RecoveryActionBehaviour() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceDemandingBehaviour.class) {
			switch (derivedFeatureID) {
			case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR;
			case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR;
			case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR:
				return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceDemandingBehaviour.class) {
			switch (baseFeatureID) {
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
				return SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR;
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
				return SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR;
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
				return SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR__STEPS_BEHAVIOUR;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} // RecoveryActionBehaviourImpl
