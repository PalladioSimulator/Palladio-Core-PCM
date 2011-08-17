/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.util;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.*;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage
 * @generated
 */
public class QMLContractValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QMLContractValidator INSTANCE = new QMLContractValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'All DIMENSIO Ns must be from same CONTRACTTYPE' of 'Simple QML Contract'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIMPLE_QML_CONTRACT__ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Only CONSTRAINTS have RESTRICTIONS' of 'Criterion'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CRITERION__ONLY_CONSTRAINTS_HAVE_RESTRICTIONS = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'FREQUENCY only possible if DIMENSION is ordered' of 'Criterion'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CRITERION__FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'POINTESTIMATOR only for numeric dimensions' of 'Criterion'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CRITERION__POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Only OBJECTIVES have GOALS' of 'Criterion'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CRITERION__ONLY_OBJECTIVES_HAVE_GOALS = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'FREQUENCY LIMIT must be NUMERIC' of 'Evaluation Aspect'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EVALUATION_ASPECT__FREQUENCY_LIMIT_MUST_BE_NUMERIC = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'FREQUENCY LIMIT must be between 0and 100' of 'Evaluation Aspect'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EVALUATION_ASPECT__FREQUENCY_LIMIT_MUST_BE_BETWEEN_0AND_100 = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'PERCENTILE between 0and 100' of 'Percentile'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PERCENTILE__PERCENTILE_BETWEEN_0AND_100 = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Range of FREQUENCY must have UPPERLIMIT or LOWERLIMIT' of 'Frequency'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FREQUENCY__RANGE_OF_FREQUENCY_MUST_HAVE_UPPERLIMIT_OR_LOWERLIMIT = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Contract cannot refine itself' of 'Refined QML Contract'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REFINED_QML_CONTRACT__CONTRACT_CANNOT_REFINE_ITSELF = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'All ASPECTS of CONSTRAINTS have RESTRICTIONS' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS = 11;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 11;

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
	public QMLContractValidator() {
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
	  return QMLContractPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case QMLContractPackage.SIMPLE_QML_CONTRACT:
				return validateSimpleQMLContract((SimpleQMLContract)value, diagnostics, context);
			case QMLContractPackage.CRITERION:
				return validateCriterion((Criterion)value, diagnostics, context);
			case QMLContractPackage.EVALUATION_ASPECT:
				return validateEvaluationAspect((EvaluationAspect)value, diagnostics, context);
			case QMLContractPackage.ASPECT_REQUIREMENT:
				return validateAspectRequirement((AspectRequirement)value, diagnostics, context);
			case QMLContractPackage.VALUE_LITERAL:
				return validateValueLiteral((ValueLiteral)value, diagnostics, context);
			case QMLContractPackage.PERCENTILE:
				return validatePercentile((Percentile)value, diagnostics, context);
			case QMLContractPackage.POINT_ESTIMATOR:
				return validatePointEstimator((PointEstimator)value, diagnostics, context);
			case QMLContractPackage.STOCHASTIC_EVALUATION_ASPECT:
				return validateStochasticEvaluationAspect((StochasticEvaluationAspect)value, diagnostics, context);
			case QMLContractPackage.FREQUENCY:
				return validateFrequency((Frequency)value, diagnostics, context);
			case QMLContractPackage.RANGE_VALUE:
				return validateRangeValue((RangeValue)value, diagnostics, context);
			case QMLContractPackage.MEAN:
				return validateMean((Mean)value, diagnostics, context);
			case QMLContractPackage.VARIANCE:
				return validateVariance((Variance)value, diagnostics, context);
			case QMLContractPackage.NUMERIC_LITERAL:
				return validateNumericLiteral((NumericLiteral)value, diagnostics, context);
			case QMLContractPackage.ENUM_LITERAL:
				return validateEnumLiteral((EnumLiteral)value, diagnostics, context);
			case QMLContractPackage.SET_LITERAL:
				return validateSetLiteral((SetLiteral)value, diagnostics, context);
			case QMLContractPackage.REFINED_QML_CONTRACT:
				return validateRefinedQMLContract((RefinedQMLContract)value, diagnostics, context);
			case QMLContractPackage.VALUE:
				return validateValue((Value)value, diagnostics, context);
			case QMLContractPackage.DETERMINISTIC_EVALUATION_ASPECT:
				return validateDeterministicEvaluationAspect((DeterministicEvaluationAspect)value, diagnostics, context);
			case QMLContractPackage.OBJECTIVE:
				return validateObjective((Objective)value, diagnostics, context);
			case QMLContractPackage.CONSTRAINT:
				return validateConstraint((Constraint)value, diagnostics, context);
			case QMLContractPackage.RESTRICTION:
				return validateRestriction((Restriction)value, diagnostics, context);
			case QMLContractPackage.GOAL:
				return validateGoal((Goal)value, diagnostics, context);
			case QMLContractPackage.GENERIC_QML_CONTRACT:
				return validateGenericQMLContract((GenericQMLContract)value, diagnostics, context);
			case QMLContractPackage.ENUM_OPERATOR:
				return validateEnumOperator((EnumOperator)value, diagnostics, context);
			case QMLContractPackage.ENUM_RANGE_VALUE_TYPE:
				return validateEnumRangeValueType((EnumRangeValueType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleQMLContract(SimpleQMLContract simpleQMLContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(simpleQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validateSimpleQMLContract_all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(simpleQMLContract, diagnostics, context);
		return result;
	}

	/**
	 * Validates the all_DIMENSIONs_must_be_from_same_CONTRACTTYPE constraint of '<em>Simple QML Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleQMLContract_all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(SimpleQMLContract simpleQMLContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return simpleQMLContract.all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCriterion(Criterion criterion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_Only_CONSTRAINTS_have_RESTRICTIONS(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_FREQUENCY_only_possible_if_DIMENSION_is_ordered(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_POINTESTIMATOR_only_for_numeric_dimensions(criterion, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_Only_OBJECTIVES_have_GOALS(criterion, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Only_CONSTRAINTS_have_RESTRICTIONS constraint of '<em>Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCriterion_Only_CONSTRAINTS_have_RESTRICTIONS(Criterion criterion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return criterion.Only_CONSTRAINTS_have_RESTRICTIONS(diagnostics, context);
	}

	/**
	 * Validates the FREQUENCY_only_possible_if_DIMENSION_is_ordered constraint of '<em>Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCriterion_FREQUENCY_only_possible_if_DIMENSION_is_ordered(Criterion criterion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return criterion.FREQUENCY_only_possible_if_DIMENSION_is_ordered(diagnostics, context);
	}

	/**
	 * Validates the POINTESTIMATOR_only_for_numeric_dimensions constraint of '<em>Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCriterion_POINTESTIMATOR_only_for_numeric_dimensions(Criterion criterion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return criterion.POINTESTIMATOR_only_for_numeric_dimensions(diagnostics, context);
	}

	/**
	 * Validates the Only_OBJECTIVES_have_GOALS constraint of '<em>Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCriterion_Only_OBJECTIVES_have_GOALS(Criterion criterion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return criterion.Only_OBJECTIVES_have_GOALS(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvaluationAspect(EvaluationAspect evaluationAspect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(evaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(evaluationAspect, diagnostics, context);
		return result;
	}

	/**
	 * Validates the FREQUENCY_LIMIT_must_be_NUMERIC constraint of '<em>Evaluation Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(EvaluationAspect evaluationAspect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return evaluationAspect.FREQUENCY_LIMIT_must_be_NUMERIC(diagnostics, context);
	}

	/**
	 * Validates the FREQUENCY_LIMIT_must_be_between_0_and_100 constraint of '<em>Evaluation Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(EvaluationAspect evaluationAspect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return evaluationAspect.FREQUENCY_LIMIT_must_be_between_0_and_100(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAspectRequirement(AspectRequirement aspectRequirement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(aspectRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(aspectRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(aspectRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(aspectRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(aspectRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(aspectRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(aspectRequirement, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(aspectRequirement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueLiteral(ValueLiteral valueLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(valueLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(valueLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(valueLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(valueLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(valueLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(valueLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(valueLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(valueLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePercentile(Percentile percentile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(percentile, diagnostics, context);
		if (result || diagnostics != null) result &= validatePercentile_PERCENTILE_between_0_and_100(percentile, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PERCENTILE_between_0_and_100 constraint of '<em>Percentile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePercentile_PERCENTILE_between_0_and_100(Percentile percentile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return percentile.PERCENTILE_between_0_and_100(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePointEstimator(PointEstimator pointEstimator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(pointEstimator, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(pointEstimator, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStochasticEvaluationAspect(StochasticEvaluationAspect stochasticEvaluationAspect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(stochasticEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(stochasticEvaluationAspect, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFrequency(Frequency frequency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(frequency, diagnostics, context);
		if (result || diagnostics != null) result &= validateFrequency_range_of_FREQUENCY_must_have_UPPERLIMIT_or_LOWERLIMIT(frequency, diagnostics, context);
		return result;
	}

	/**
	 * Validates the range_of_FREQUENCY_must_have_UPPERLIMIT_or_LOWERLIMIT constraint of '<em>Frequency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFrequency_range_of_FREQUENCY_must_have_UPPERLIMIT_or_LOWERLIMIT(Frequency frequency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return frequency.range_of_FREQUENCY_must_have_UPPERLIMIT_or_LOWERLIMIT(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeValue(RangeValue rangeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(rangeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rangeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rangeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rangeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rangeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rangeValue, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rangeValue, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(rangeValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMean(Mean mean, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mean, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(mean, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(mean, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariance(Variance variance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variance, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(variance, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(variance, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericLiteral(NumericLiteral numericLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(numericLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(numericLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(numericLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(numericLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(numericLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(numericLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(numericLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(numericLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteral(EnumLiteral enumLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(enumLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(enumLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetLiteral(SetLiteral setLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(setLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(setLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(setLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(setLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(setLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(setLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(setLiteral, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(setLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinedQMLContract(RefinedQMLContract refinedQMLContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(refinedQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validateRefinedQMLContract_contract_cannot_refine_itself(refinedQMLContract, diagnostics, context);
		return result;
	}

	/**
	 * Validates the contract_cannot_refine_itself constraint of '<em>Refined QML Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefinedQMLContract_contract_cannot_refine_itself(RefinedQMLContract refinedQMLContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return refinedQMLContract.contract_cannot_refine_itself(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValue(Value value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(value, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(value, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(value, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(value, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(value, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(value, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(value, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(value, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(value, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(value, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeterministicEvaluationAspect(DeterministicEvaluationAspect deterministicEvaluationAspect, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_NUMERIC(deterministicEvaluationAspect, diagnostics, context);
		if (result || diagnostics != null) result &= validateEvaluationAspect_FREQUENCY_LIMIT_must_be_between_0_and_100(deterministicEvaluationAspect, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjective(Objective objective, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objective, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_Only_CONSTRAINTS_have_RESTRICTIONS(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_FREQUENCY_only_possible_if_DIMENSION_is_ordered(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_POINTESTIMATOR_only_for_numeric_dimensions(objective, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_Only_OBJECTIVES_have_GOALS(objective, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_Only_CONSTRAINTS_have_RESTRICTIONS(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_FREQUENCY_only_possible_if_DIMENSION_is_ordered(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_POINTESTIMATOR_only_for_numeric_dimensions(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateCriterion_Only_OBJECTIVES_have_GOALS(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(constraint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return constraint.All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRestriction(Restriction restriction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(restriction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(restriction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(restriction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(restriction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(restriction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(restriction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(restriction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(restriction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(goal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(goal, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(goal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGenericQMLContract(GenericQMLContract genericQMLContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(genericQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(genericQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(genericQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(genericQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(genericQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(genericQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(genericQMLContract, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(genericQMLContract, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumOperator(EnumOperator enumOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumRangeValueType(EnumRangeValueType enumRangeValueType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //QMLContractValidator
