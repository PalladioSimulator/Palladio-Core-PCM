/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.util;

import de.uka.ipd.sdq.pcm.seff.*;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage
 * @generated
 */
public class SeffValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final SeffValidator INSTANCE = new SeffValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.seff";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stop Action
	 * Successor Must Not Be Defined' of 'Stop Action'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public static final int STOP_ACTION__STOP_ACTION_SUCCESSOR_MUST_NOT_BE_DEFINED = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Exactly One Stop Action' of 'Resource Demanding Behaviour'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_STOP_ACTION = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Exactly One
	 * Start Action' of 'Resource Demanding Behaviour'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public static final int RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_START_ACTION = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each Action Except Start Actionand Stop Action Must Hhave APredecessor And Successor' of 'Resource Demanding Behaviour'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RESOURCE_DEMANDING_BEHAVIOUR__EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Either
	 * Guarded Branches Or Probabilisitic Branch Transitions' of 'Branch Action'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int BRANCH_ACTION__EITHER_GUARDED_BRANCHES_OR_PROBABILISITIC_BRANCH_TRANSITIONS = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'All Probabilistic Branch Probabilities Must Sum Up To1' of 'Branch Action'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BRANCH_ACTION__ALL_PROBABILISTIC_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1 = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Start Action Predecessor Must Not Be Defined' of 'Start Action'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static final int START_ACTION__START_ACTION_PREDECESSOR_MUST_NOT_BE_DEFINED = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Referenced Signature Must Belong To Interface Referenced By Provided Role' of 'Service Effect Specification'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_EFFECT_SPECIFICATION__REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Multiple
	 * Internal Occurrence Descriptions Per Failure Type Not Allowed' of 'Internal Action'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int INTERNAL_ACTION__MULTIPLE_INTERNAL_OCCURRENCE_DESCRIPTIONS_PER_FAILURE_TYPE_NOT_ALLOWED = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sum Of
	 * Internal Action Failure Probabilities Must Not Exceed1' of 'Internal Action'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int INTERNAL_ACTION__SUM_OF_INTERNAL_ACTION_FAILURE_PROBABILITIES_MUST_NOT_EXCEED1 = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signature Belongs To Role' of 'External Call Action'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_CALL_ACTION__SIGNATURE_BELONGS_TO_ROLE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Required Role Must Be Referenced By Container' of 'External Call Action'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_CALL_ACTION__OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Timeout Value Of Acquire Action Must Not Be Negative' of 'Acquire Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACQUIRE_ACTION__TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE = 11;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 13;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SeffValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return SeffPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case SeffPackage.STOP_ACTION:
			return validateStopAction((StopAction) value, diagnostics, context);
		case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION:
			return validateAbstractInternalControlFlowAction(
					(AbstractInternalControlFlowAction) value, diagnostics,
					context);
		case SeffPackage.ABSTRACT_ACTION:
			return validateAbstractAction((AbstractAction) value, diagnostics,
					context);
		case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR:
			return validateResourceDemandingBehaviour(
					(ResourceDemandingBehaviour) value, diagnostics, context);
		case SeffPackage.ABSTRACT_LOOP_ACTION:
			return validateAbstractLoopAction((AbstractLoopAction) value,
					diagnostics, context);
		case SeffPackage.ABSTRACT_BRANCH_TRANSITION:
			return validateAbstractBranchTransition(
					(AbstractBranchTransition) value, diagnostics, context);
		case SeffPackage.BRANCH_ACTION:
			return validateBranchAction((BranchAction) value, diagnostics,
					context);
		case SeffPackage.CALL_ACTION:
			return validateCallAction((CallAction) value, diagnostics, context);
		case SeffPackage.START_ACTION:
			return validateStartAction((StartAction) value, diagnostics,
					context);
		case SeffPackage.SERVICE_EFFECT_SPECIFICATION:
			return validateServiceEffectSpecification(
					(ServiceEffectSpecification) value, diagnostics, context);
		case SeffPackage.RESOURCE_DEMANDING_SEFF:
			return validateResourceDemandingSEFF((ResourceDemandingSEFF) value,
					diagnostics, context);
		case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
			return validateResourceDemandingInternalBehaviour(
					(ResourceDemandingInternalBehaviour) value, diagnostics,
					context);
		case SeffPackage.RELEASE_ACTION:
			return validateReleaseAction((ReleaseAction) value, diagnostics,
					context);
		case SeffPackage.LOOP_ACTION:
			return validateLoopAction((LoopAction) value, diagnostics, context);
		case SeffPackage.FORK_ACTION:
			return validateForkAction((ForkAction) value, diagnostics, context);
		case SeffPackage.FORKED_BEHAVIOUR:
			return validateForkedBehaviour((ForkedBehaviour) value,
					diagnostics, context);
		case SeffPackage.SYNCHRONISATION_POINT:
			return validateSynchronisationPoint((SynchronisationPoint) value,
					diagnostics, context);
		case SeffPackage.EXTERNAL_CALL_ACTION:
			return validateExternalCallAction((ExternalCallAction) value,
					diagnostics, context);
		case SeffPackage.CALL_RETURN_ACTION:
			return validateCallReturnAction((CallReturnAction) value,
					diagnostics, context);
		case SeffPackage.PROBABILISTIC_BRANCH_TRANSITION:
			return validateProbabilisticBranchTransition(
					(ProbabilisticBranchTransition) value, diagnostics, context);
		case SeffPackage.ACQUIRE_ACTION:
			return validateAcquireAction((AcquireAction) value, diagnostics,
					context);
		case SeffPackage.COLLECTION_ITERATOR_ACTION:
			return validateCollectionIteratorAction(
					(CollectionIteratorAction) value, diagnostics, context);
		case SeffPackage.GUARDED_BRANCH_TRANSITION:
			return validateGuardedBranchTransition(
					(GuardedBranchTransition) value, diagnostics, context);
		case SeffPackage.SET_VARIABLE_ACTION:
			return validateSetVariableAction((SetVariableAction) value,
					diagnostics, context);
		case SeffPackage.INTERNAL_CALL_ACTION:
			return validateInternalCallAction((InternalCallAction) value,
					diagnostics, context);
		case SeffPackage.EMIT_EVENT_ACTION:
			return validateEmitEventAction((EmitEventAction) value,
					diagnostics, context);
		case SeffPackage.INTERNAL_ACTION:
			return validateInternalAction((InternalAction) value, diagnostics,
					context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStopAction(StopAction stopAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) stopAction, diagnostics,
				context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) stopAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) stopAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) stopAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) stopAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) stopAction, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) stopAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) stopAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStopAction_StopActionSuccessorMustNotBeDefined(
					stopAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the StopActionSuccessorMustNotBeDefined constraint of ' <em>Stop Action</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateStopAction_StopActionSuccessorMustNotBeDefined(
			StopAction stopAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return stopAction.StopActionSuccessorMustNotBeDefined(diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractInternalControlFlowAction(
			AbstractInternalControlFlowAction abstractInternalControlFlowAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(
				(EObject) abstractInternalControlFlowAction, diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractAction(AbstractAction abstractAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) abstractAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingBehaviour(
			ResourceDemandingBehaviour resourceDemandingBehaviour,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(
				(EObject) resourceDemandingBehaviour, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
					(EObject) resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
					(EObject) resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) resourceDemandingBehaviour,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(
					(EObject) resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(
					(EObject) resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStopAction(
					resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStartAction(
					resourceDemandingBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
					resourceDemandingBehaviour, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ExactlyOneStopAction constraint of '<em>Resource Demanding Behaviour</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingBehaviour_ExactlyOneStopAction(
			ResourceDemandingBehaviour resourceDemandingBehaviour,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceDemandingBehaviour.ExactlyOneStopAction(diagnostics,
				context);
	}

	/**
	 * Validates the ExactlyOneStartAction constraint of '<em>Resource Demanding Behaviour</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingBehaviour_ExactlyOneStartAction(
			ResourceDemandingBehaviour resourceDemandingBehaviour,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceDemandingBehaviour.ExactlyOneStartAction(diagnostics,
				context);
	}

	/**
	 * Validates the EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor constraint of '<em>Resource Demanding Behaviour</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingBehaviour_EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
			ResourceDemandingBehaviour resourceDemandingBehaviour,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return resourceDemandingBehaviour
				.EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
						diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractLoopAction(
			AbstractLoopAction abstractLoopAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) abstractLoopAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractBranchTransition(
			AbstractBranchTransition abstractBranchTransition,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(
				(EObject) abstractBranchTransition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBranchAction(BranchAction branchAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) branchAction,
				diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) branchAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) branchAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) branchAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) branchAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) branchAction, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) branchAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) branchAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBranchAction_EitherGuardedBranchesOrProbabilisiticBranchTransitions(
					branchAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBranchAction_AllProbabilisticBranchProbabilitiesMustSumUpTo1(
					branchAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the EitherGuardedBranchesOrProbabilisiticBranchTransitions constraint of '<em>Branch Action</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBranchAction_EitherGuardedBranchesOrProbabilisiticBranchTransitions(
			BranchAction branchAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return branchAction
				.EitherGuardedBranchesOrProbabilisiticBranchTransitions(
						diagnostics, context);
	}

	/**
	 * Validates the AllProbabilisticBranchProbabilitiesMustSumUpTo1 constraint of '<em>Branch Action</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBranchAction_AllProbabilisticBranchProbabilitiesMustSumUpTo1(
			BranchAction branchAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return branchAction.AllProbabilisticBranchProbabilitiesMustSumUpTo1(
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStartAction(StartAction startAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) startAction, diagnostics,
				context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) startAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) startAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained((EObject) startAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) startAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) startAction, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) startAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) startAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStartAction_StartActionPredecessorMustNotBeDefined(
					startAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the StartActionPredecessorMustNotBeDefined constraint of '<em>Start Action</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStartAction_StartActionPredecessorMustNotBeDefined(
			StartAction startAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return startAction.StartActionPredecessorMustNotBeDefined(diagnostics,
				context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingSEFF(
			ResourceDemandingSEFF resourceDemandingSEFF,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) resourceDemandingSEFF,
				diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
					(EObject) resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
					(EObject) resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) resourceDemandingSEFF,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) resourceDemandingSEFF,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(
					(EObject) resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateServiceEffectSpecification_ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(
					resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStopAction(
					resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStartAction(
					resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
					resourceDemandingSEFF, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingInternalBehaviour(
			ResourceDemandingInternalBehaviour resourceDemandingInternalBehaviour,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(
				(EObject) resourceDemandingInternalBehaviour, diagnostics,
				context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) resourceDemandingInternalBehaviour, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
					(EObject) resourceDemandingInternalBehaviour, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) resourceDemandingInternalBehaviour, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
					(EObject) resourceDemandingInternalBehaviour, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(
					(EObject) resourceDemandingInternalBehaviour, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(
					(EObject) resourceDemandingInternalBehaviour, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(
					(EObject) resourceDemandingInternalBehaviour, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStopAction(
					resourceDemandingInternalBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStartAction(
					resourceDemandingInternalBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
					resourceDemandingInternalBehaviour, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReleaseAction(ReleaseAction releaseAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) releaseAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopAction(LoopAction loopAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) loopAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalAction(InternalAction internalAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) internalAction,
				diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) internalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) internalAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) internalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) internalAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) internalAction, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) internalAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) internalAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInternalAction_MultipleInternalOccurrenceDescriptionsPerFailureTypeNotAllowed(
					internalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInternalAction_SumOfInternalActionFailureProbabilitiesMustNotExceed1(
					internalAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MultipleInternalOccurrenceDescriptionsPerFailureTypeNotAllowed constraint of '<em>Internal Action</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalAction_MultipleInternalOccurrenceDescriptionsPerFailureTypeNotAllowed(
			InternalAction internalAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return internalAction
				.MultipleInternalOccurrenceDescriptionsPerFailureTypeNotAllowed(
						diagnostics, context);
	}

	/**
	 * Validates the SumOfInternalActionFailureProbabilitiesMustNotExceed1 constraint of '<em>Internal Action</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalAction_SumOfInternalActionFailureProbabilitiesMustNotExceed1(
			InternalAction internalAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return internalAction
				.SumOfInternalActionFailureProbabilitiesMustNotExceed1(
						diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkAction(ForkAction forkAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) forkAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkedBehaviour(ForkedBehaviour forkedBehaviour,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) forkedBehaviour,
				diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) forkedBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
					(EObject) forkedBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) forkedBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) forkedBehaviour,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) forkedBehaviour, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) forkedBehaviour,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) forkedBehaviour,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStopAction(
					forkedBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_ExactlyOneStartAction(
					forkedBehaviour, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateResourceDemandingBehaviour_EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
					forkedBehaviour, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSynchronisationPoint(
			SynchronisationPoint synchronisationPoint,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) synchronisationPoint,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalCallAction(
			ExternalCallAction externalCallAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) externalCallAction,
				diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) externalCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
					(EObject) externalCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) externalCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) externalCallAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) externalCallAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) externalCallAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(
					(EObject) externalCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExternalCallAction_SignatureBelongsToRole(
					externalCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExternalCallAction_OperationRequiredRoleMustBeReferencedByContainer(
					externalCallAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the SignatureBelongsToRole constraint of ' <em>External Call Action</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateExternalCallAction_SignatureBelongsToRole(
			ExternalCallAction externalCallAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return externalCallAction.SignatureBelongsToRole(diagnostics, context);
	}

	/**
	 * Validates the OperationRequiredRoleMustBeReferencedByContainer constraint of '<em>External Call Action</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalCallAction_OperationRequiredRoleMustBeReferencedByContainer(
			ExternalCallAction externalCallAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return externalCallAction
				.OperationRequiredRoleMustBeReferencedByContainer(diagnostics,
						context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallReturnAction(CallReturnAction callReturnAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) callReturnAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallAction(CallAction callAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) callAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbabilisticBranchTransition(
			ProbabilisticBranchTransition probabilisticBranchTransition,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(
				(EObject) probabilisticBranchTransition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcquireAction(AcquireAction acquireAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject) acquireAction,
				diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) acquireAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms((EObject) acquireAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) acquireAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves((EObject) acquireAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) acquireAction, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique((EObject) acquireAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique((EObject) acquireAction,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcquireAction_TimeoutValueOfAcquireActionMustNotBeNegative(
					acquireAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the TimeoutValueOfAcquireActionMustNotBeNegative constraint of '<em>Acquire Action</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcquireAction_TimeoutValueOfAcquireActionMustNotBeNegative(
			AcquireAction acquireAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return acquireAction.TimeoutValueOfAcquireActionMustNotBeNegative(
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionIteratorAction(
			CollectionIteratorAction collectionIteratorAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(
				(EObject) collectionIteratorAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardedBranchTransition(
			GuardedBranchTransition guardedBranchTransition,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(
				(EObject) guardedBranchTransition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetVariableAction(
			SetVariableAction setVariableAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) setVariableAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalCallAction(
			InternalCallAction internalCallAction, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) internalCallAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmitEventAction(EmitEventAction emitEventAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) emitEventAction,
				diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceEffectSpecification(
			ServiceEffectSpecification serviceEffectSpecification,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(
				(EObject) serviceEffectSpecification, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
				(EObject) serviceEffectSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
					(EObject) serviceEffectSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
					(EObject) serviceEffectSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
					(EObject) serviceEffectSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID((EObject) serviceEffectSpecification,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(
					(EObject) serviceEffectSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(
					(EObject) serviceEffectSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateServiceEffectSpecification_ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(
					serviceEffectSpecification, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole constraint of '<em>Service Effect Specification</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceEffectSpecification_ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(
			ServiceEffectSpecification serviceEffectSpecification,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceEffectSpecification
				.ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(
						diagnostics, context);
	}

} // SeffValidator
