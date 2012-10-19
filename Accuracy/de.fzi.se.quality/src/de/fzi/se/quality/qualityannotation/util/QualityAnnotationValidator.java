/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.util;

import de.fzi.se.quality.qualityannotation.*;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage
 * @generated
 */
public class QualityAnnotationValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QualityAnnotationValidator INSTANCE = new QualityAnnotationValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.fzi.se.quality.qualityannotation";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stipulated Precision Must Be Set In Stipulation Context' of 'Required Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUIRED_ELEMENT__STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Is Interface' of 'PCMRE Category'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is Highest Hierarchy Level' of 'PCMRE Category'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_CATEGORY__THIS_IS_HIGHEST_HIERARCHY_LEVEL = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Sublevels For Category Resource Demand' of 'PCMRE Category'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_CATEGORY__NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Existing RE Precision Call Parameter Must Be No Precision Due To The Non Existence Of Parameters For Category Resource Demand' of 'PCMRE Category'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_CATEGORY__EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierachy Level Is Role' of 'PCMRE Interface'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_INTERFACE__NEXT_LOWER_HIERACHY_LEVEL_IS_ROLE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Upper Hierarchy Level Is Category' of 'PCMRE Interface'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_INTERFACE__NEXT_UPPER_HIERARCHY_LEVEL_IS_CATEGORY = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Is Signature' of 'PCMRE Role'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_ROLE__NEXT_LOWER_HIERARCHY_LEVEL_IS_SIGNATURE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Upper Hierarchy Level Is Interface' of 'PCMRE Role'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_ROLE__NEXT_UPPER_HIERARCHY_LEVEL_IS_INTERFACE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The Lowest Hierarchy Level' of 'PCMRE Signature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_SIGNATURE__THIS_IS_THE_LOWEST_HIERARCHY_LEVEL = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Upper Hierarchy Level Is Role' of 'PCMRE Signature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PCMRE_SIGNATURE__NEXT_UPPER_HIERARCHY_LEVEL_IS_ROLE = 11;

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
	public QualityAnnotationValidator() {
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
	  return QualityAnnotationPackage.eINSTANCE;
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
			case QualityAnnotationPackage.CALL_PARAMETER_DEVIATION:
				return validateCallParameterDeviation((CallParameterDeviation)value, diagnostics, context);
			case QualityAnnotationPackage.QUALITY_ANNOTATION:
				return validateQualityAnnotation((QualityAnnotation)value, diagnostics, context);
			case QualityAnnotationPackage.SERVICE_SPECIFICATION:
				return validateServiceSpecification((ServiceSpecification)value, diagnostics, context);
			case QualityAnnotationPackage.REQUIRED_ELEMENT:
				return validateRequiredElement((RequiredElement)value, diagnostics, context);
			case QualityAnnotationPackage.NUMBER_OF_CALLS_DEVIATION:
				return validateNumberOfCallsDeviation((NumberOfCallsDeviation)value, diagnostics, context);
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
				return validateInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)value, diagnostics, context);
			case QualityAnnotationPackage.RE_PRECISION:
				return validateREPrecision((REPrecision)value, diagnostics, context);
			case QualityAnnotationPackage.PRECISION:
				return validatePrecision((Precision)value, diagnostics, context);
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION:
				return validatePCMParameterPartition((PCMParameterPartition)value, diagnostics, context);
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION:
				return validateCharacterisedPCMParameterPartition((CharacterisedPCMParameterPartition)value, diagnostics, context);
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL:
				return validateCharacterisedPCMParameterPartitionInterval((CharacterisedPCMParameterPartitionInterval)value, diagnostics, context);
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE:
				return validateCharacterisedPCMParameterPartitionRange((CharacterisedPCMParameterPartitionRange)value, diagnostics, context);
			case QualityAnnotationPackage.EXACTLY_AS_SPECIFIED_PRECISION:
				return validateExactlyAsSpecifiedPrecision((ExactlyAsSpecifiedPrecision)value, diagnostics, context);
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION:
				return validateLimitedDeviationPrecision((LimitedDeviationPrecision)value, diagnostics, context);
			case QualityAnnotationPackage.NO_PRECISION:
				return validateNoPrecision((NoPrecision)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE_CATEGORY:
				return validatePCMRECategory((PCMRECategory)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE:
				return validatePCMRE((PCMRE)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE_INTERFACE:
				return validatePCMREInterface((PCMREInterface)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE_ROLE:
				return validatePCMRERole((PCMRERole)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE_SIGNATURE:
				return validatePCMRESignature((PCMRESignature)value, diagnostics, context);
			case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION:
				return validatePCMServiceSpecification((PCMServiceSpecification)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE:
				return validatePCMREResourceInterface((PCMREResourceInterface)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE:
				return validatePCMREResourceSignature((PCMREResourceSignature)value, diagnostics, context);
			case QualityAnnotationPackage.PCMRE_REQUEST_CATEGORY:
				return validatePCMRERequestCategory((PCMRERequestCategory)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallParameterDeviation(CallParameterDeviation callParameterDeviation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(callParameterDeviation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualityAnnotation(QualityAnnotation qualityAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(qualityAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(qualityAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(qualityAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(qualityAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(qualityAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(qualityAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(qualityAnnotation, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(qualityAnnotation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceSpecification(ServiceSpecification serviceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(serviceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(serviceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(serviceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(serviceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(serviceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(serviceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(serviceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(serviceSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredElement(RequiredElement requiredElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(requiredElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the StipulatedPrecisionMustBeSetInStipulationContext constraint of '<em>Required Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(RequiredElement requiredElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return requiredElement.StipulatedPrecisionMustBeSetInStipulationContext(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberOfCallsDeviation(NumberOfCallsDeviation numberOfCallsDeviation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numberOfCallsDeviation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation internalStateInfluenceAnalysisAggregation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(internalStateInfluenceAnalysisAggregation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateREPrecision(REPrecision rePrecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rePrecision, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrecision(Precision precision, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(precision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(precision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(precision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(precision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(precision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(precision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(precision, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(precision, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMParameterPartition(PCMParameterPartition pcmParameterPartition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmParameterPartition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterisedPCMParameterPartition(CharacterisedPCMParameterPartition characterisedPCMParameterPartition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(characterisedPCMParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterisedPCMParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterisedPCMParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterisedPCMParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterisedPCMParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterisedPCMParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterisedPCMParameterPartition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(characterisedPCMParameterPartition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterisedPCMParameterPartitionInterval(CharacterisedPCMParameterPartitionInterval characterisedPCMParameterPartitionInterval, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(characterisedPCMParameterPartitionInterval, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterisedPCMParameterPartitionInterval, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterisedPCMParameterPartitionInterval, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterisedPCMParameterPartitionInterval, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterisedPCMParameterPartitionInterval, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterisedPCMParameterPartitionInterval, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterisedPCMParameterPartitionInterval, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(characterisedPCMParameterPartitionInterval, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterisedPCMParameterPartitionRange(CharacterisedPCMParameterPartitionRange characterisedPCMParameterPartitionRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(characterisedPCMParameterPartitionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterisedPCMParameterPartitionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterisedPCMParameterPartitionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterisedPCMParameterPartitionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterisedPCMParameterPartitionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterisedPCMParameterPartitionRange, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterisedPCMParameterPartitionRange, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(characterisedPCMParameterPartitionRange, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExactlyAsSpecifiedPrecision(ExactlyAsSpecifiedPrecision exactlyAsSpecifiedPrecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(exactlyAsSpecifiedPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(exactlyAsSpecifiedPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(exactlyAsSpecifiedPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(exactlyAsSpecifiedPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(exactlyAsSpecifiedPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(exactlyAsSpecifiedPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(exactlyAsSpecifiedPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(exactlyAsSpecifiedPrecision, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLimitedDeviationPrecision(LimitedDeviationPrecision limitedDeviationPrecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(limitedDeviationPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(limitedDeviationPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(limitedDeviationPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(limitedDeviationPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(limitedDeviationPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(limitedDeviationPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(limitedDeviationPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(limitedDeviationPrecision, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNoPrecision(NoPrecision noPrecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(noPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(noPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(noPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(noPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(noPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(noPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(noPrecision, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(noPrecision, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRECategory(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRECategory_NextLowerHierarchyLevelIsInterface(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRECategory_ThisIsHighestHierarchyLevel(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRECategory_NoSublevelsForCategoryResourceDemand(pcmreCategory, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRECategory_ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(pcmreCategory, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NextLowerHierarchyLevelIsInterface constraint of '<em>PCMRE Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRECategory_NextLowerHierarchyLevelIsInterface(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreCategory.NextLowerHierarchyLevelIsInterface(diagnostics, context);
	}

	/**
	 * Validates the ThisIsHighestHierarchyLevel constraint of '<em>PCMRE Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRECategory_ThisIsHighestHierarchyLevel(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreCategory.ThisIsHighestHierarchyLevel(diagnostics, context);
	}

	/**
	 * Validates the NoSublevelsForCategoryResourceDemand constraint of '<em>PCMRE Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRECategory_NoSublevelsForCategoryResourceDemand(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreCategory.NoSublevelsForCategoryResourceDemand(diagnostics, context);
	}

	/**
	 * Validates the ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand constraint of '<em>PCMRE Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRECategory_ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreCategory.ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRE(PCMRE pcmre, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmre, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmre, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMREInterface(PCMREInterface pcmreInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMREInterface_NextLowerHierachyLevelIsRole(pcmreInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMREInterface_NextUpperHierarchyLevelIsCategory(pcmreInterface, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NextLowerHierachyLevelIsRole constraint of '<em>PCMRE Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMREInterface_NextLowerHierachyLevelIsRole(PCMREInterface pcmreInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreInterface.NextLowerHierachyLevelIsRole(diagnostics, context);
	}

	/**
	 * Validates the NextUpperHierarchyLevelIsCategory constraint of '<em>PCMRE Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMREInterface_NextUpperHierarchyLevelIsCategory(PCMREInterface pcmreInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreInterface.NextUpperHierarchyLevelIsCategory(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRERole(PCMRERole pcmreRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRERole_NextLowerHierarchyLevelIsSignature(pcmreRole, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRERole_NextUpperHierarchyLevelIsInterface(pcmreRole, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NextLowerHierarchyLevelIsSignature constraint of '<em>PCMRE Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRERole_NextLowerHierarchyLevelIsSignature(PCMRERole pcmreRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreRole.NextLowerHierarchyLevelIsSignature(diagnostics, context);
	}

	/**
	 * Validates the NextUpperHierarchyLevelIsInterface constraint of '<em>PCMRE Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRERole_NextUpperHierarchyLevelIsInterface(PCMRERole pcmreRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreRole.NextUpperHierarchyLevelIsInterface(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRESignature(PCMRESignature pcmreSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRESignature_ThisIsTheLowestHierarchyLevel(pcmreSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validatePCMRESignature_NextUpperHierarchyLevelIsRole(pcmreSignature, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ThisIsTheLowestHierarchyLevel constraint of '<em>PCMRE Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRESignature_ThisIsTheLowestHierarchyLevel(PCMRESignature pcmreSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreSignature.ThisIsTheLowestHierarchyLevel(diagnostics, context);
	}

	/**
	 * Validates the NextUpperHierarchyLevelIsRole constraint of '<em>PCMRE Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRESignature_NextUpperHierarchyLevelIsRole(PCMRESignature pcmreSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return pcmreSignature.NextUpperHierarchyLevelIsRole(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMServiceSpecification(PCMServiceSpecification pcmServiceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmServiceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmServiceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmServiceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmServiceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmServiceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmServiceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmServiceSpecification, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmServiceSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMREResourceInterface(PCMREResourceInterface pcmreResourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmreResourceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResourceInterface, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMREResourceSignature(PCMREResourceSignature pcmreResourceSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(pcmreResourceSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResourceSignature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCMRERequestCategory(PCMRERequestCategory pcmreRequestCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

} //QualityAnnotationValidator
