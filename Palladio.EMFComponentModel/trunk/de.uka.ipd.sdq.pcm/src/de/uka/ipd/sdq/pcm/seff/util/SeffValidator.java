/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.seff.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage
 * @generated
 */
public class SeffValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SeffValidator INSTANCE = new SeffValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.seff";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Either Guarded Branches Or Probabilisitic Branch Transitions' of 'Branch Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BRANCH_ACTION__EITHER_GUARDED_BRANCHES_OR_PROBABILISITIC_BRANCH_TRANSITIONS = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierValidator identifierValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeffValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return SeffPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case SeffPackage.STOP_ACTION:
				return validateStopAction((StopAction)value, diagnostics, context);
			case SeffPackage.ABSTRACT_RESOURCE_DEMANDING_ACTION:
				return validateAbstractResourceDemandingAction((AbstractResourceDemandingAction)value, diagnostics, context);
			case SeffPackage.ABSTRACT_ACTION:
				return validateAbstractAction((AbstractAction)value, diagnostics, context);
			case SeffPackage.PARAMETRIC_RESOURCE_DEMAND:
				return validateParametricResourceDemand((ParametricResourceDemand)value, diagnostics, context);
			case SeffPackage.START_ACTION:
				return validateStartAction((StartAction)value, diagnostics, context);
			case SeffPackage.RESOURCE_DEMANDING_SEFF:
				return validateResourceDemandingSEFF((ResourceDemandingSEFF)value, diagnostics, context);
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR:
				return validateResourceDemandingBehaviour((ResourceDemandingBehaviour)value, diagnostics, context);
			case SeffPackage.RELEASE_ACTION:
				return validateReleaseAction((ReleaseAction)value, diagnostics, context);
			case SeffPackage.LOOP_ACTION:
				return validateLoopAction((LoopAction)value, diagnostics, context);
			case SeffPackage.ABSTRACT_LOOP_ACTION:
				return validateAbstractLoopAction((AbstractLoopAction)value, diagnostics, context);
			case SeffPackage.ITERATION_COUNT:
				return validateIterationCount((IterationCount)value, diagnostics, context);
			case SeffPackage.INTERNAL_ACTION:
				return validateInternalAction((InternalAction)value, diagnostics, context);
			case SeffPackage.FORK_ACTION:
				return validateForkAction((ForkAction)value, diagnostics, context);
			case SeffPackage.EXTERNAL_CALL_ACTION:
				return validateExternalCallAction((ExternalCallAction)value, diagnostics, context);
			case SeffPackage.PROBABILISTIC_BRANCH_TRANSITION:
				return validateProbabilisticBranchTransition((ProbabilisticBranchTransition)value, diagnostics, context);
			case SeffPackage.ABSTRACT_BRANCH_TRANSITION:
				return validateAbstractBranchTransition((AbstractBranchTransition)value, diagnostics, context);
			case SeffPackage.BRANCH_ACTION:
				return validateBranchAction((BranchAction)value, diagnostics, context);
			case SeffPackage.AQUIRE_ACTION:
				return validateAquireAction((AquireAction)value, diagnostics, context);
			case SeffPackage.BRANCH_CONDITION:
				return validateBranchCondition((BranchCondition)value, diagnostics, context);
			case SeffPackage.COLLECTION_ITERATOR_ACTION:
				return validateCollectionIteratorAction((CollectionIteratorAction)value, diagnostics, context);
			case SeffPackage.GUARDED_BRANCH_TRANSITION:
				return validateGuardedBranchTransition((GuardedBranchTransition)value, diagnostics, context);
			case SeffPackage.SET_VARIABLE_ACTION:
				return validateSetVariableAction((SetVariableAction)value, diagnostics, context);
			case SeffPackage.SERVICE_EFFECT_SPECIFICATION:
				return validateServiceEffectSpecification((ServiceEffectSpecification)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStopAction(StopAction stopAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(stopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stopAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(stopAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractResourceDemandingAction(AbstractResourceDemandingAction abstractResourceDemandingAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(abstractResourceDemandingAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractResourceDemandingAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractResourceDemandingAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractResourceDemandingAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractResourceDemandingAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractResourceDemandingAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractResourceDemandingAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(abstractResourceDemandingAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractAction(AbstractAction abstractAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(abstractAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(abstractAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParametricResourceDemand(ParametricResourceDemand parametricResourceDemand, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parametricResourceDemand, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStartAction(StartAction startAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(startAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(startAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(startAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(startAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(startAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(startAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(startAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(startAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingSEFF(ResourceDemandingSEFF resourceDemandingSEFF, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resourceDemandingSEFF, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(resourceDemandingSEFF, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceDemandingBehaviour(ResourceDemandingBehaviour resourceDemandingBehaviour, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceDemandingBehaviour, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReleaseAction(ReleaseAction releaseAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(releaseAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(releaseAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(releaseAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(releaseAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(releaseAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(releaseAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(releaseAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(releaseAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopAction(LoopAction loopAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(loopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(loopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(loopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(loopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(loopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(loopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(loopAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(loopAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractLoopAction(AbstractLoopAction abstractLoopAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(abstractLoopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractLoopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractLoopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractLoopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractLoopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractLoopAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractLoopAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(abstractLoopAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterationCount(IterationCount iterationCount, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iterationCount, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalAction(InternalAction internalAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(internalAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(internalAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(internalAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(internalAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(internalAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(internalAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(internalAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(internalAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkAction(ForkAction forkAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(forkAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(forkAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(forkAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(forkAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(forkAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(forkAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(forkAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(forkAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalCallAction(ExternalCallAction externalCallAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(externalCallAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalCallAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalCallAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalCallAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalCallAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalCallAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalCallAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(externalCallAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbabilisticBranchTransition(ProbabilisticBranchTransition probabilisticBranchTransition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(probabilisticBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(probabilisticBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(probabilisticBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(probabilisticBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(probabilisticBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(probabilisticBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(probabilisticBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(probabilisticBranchTransition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractBranchTransition(AbstractBranchTransition abstractBranchTransition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(abstractBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(abstractBranchTransition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBranchAction(BranchAction branchAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(branchAction, diagnostics, context);
		if (result || diagnostics != null) result &= validateBranchAction_EitherGuardedBranchesOrProbabilisiticBranchTransitions(branchAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the EitherGuardedBranchesOrProbabilisiticBranchTransitions constraint of '<em>Branch Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBranchAction_EitherGuardedBranchesOrProbabilisiticBranchTransitions(BranchAction branchAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return branchAction.EitherGuardedBranchesOrProbabilisiticBranchTransitions(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAquireAction(AquireAction aquireAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(aquireAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(aquireAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(aquireAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(aquireAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(aquireAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(aquireAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(aquireAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(aquireAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBranchCondition(BranchCondition branchCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(branchCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionIteratorAction(CollectionIteratorAction collectionIteratorAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(collectionIteratorAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionIteratorAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionIteratorAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionIteratorAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionIteratorAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionIteratorAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionIteratorAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(collectionIteratorAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardedBranchTransition(GuardedBranchTransition guardedBranchTransition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(guardedBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(guardedBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(guardedBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(guardedBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(guardedBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(guardedBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(guardedBranchTransition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(guardedBranchTransition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetVariableAction(SetVariableAction setVariableAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(setVariableAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(setVariableAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(setVariableAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(setVariableAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(setVariableAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(setVariableAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(setVariableAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(setVariableAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceEffectSpecification(ServiceEffectSpecification serviceEffectSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(serviceEffectSpecification, diagnostics, context);
	}

} //SeffValidator
