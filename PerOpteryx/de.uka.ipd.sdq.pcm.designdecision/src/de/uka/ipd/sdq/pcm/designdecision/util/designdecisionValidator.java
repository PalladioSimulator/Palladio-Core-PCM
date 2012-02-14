/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.util;

import de.uka.ipd.sdq.pcm.designdecision.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage
 * @generated
 */
public class designdecisionValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final designdecisionValidator INSTANCE = new designdecisionValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.designdecision";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Number Of Choices Must Equal Number Of Decisions' of 'Candidates'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CANDIDATES__NUMBER_OF_CHOICES_MUST_EQUAL_NUMBER_OF_DECISIONS = 1;

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
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return designdecisionPackage.eINSTANCE;
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
			case designdecisionPackage.DEGREE_OF_FREEDOM_INSTANCE:
				return validateDegreeOfFreedomInstance((DegreeOfFreedomInstance)value, diagnostics, context);
			case designdecisionPackage.CHOICE:
				return validateChoice((Choice)value, diagnostics, context);
			case designdecisionPackage.RANGE_DEGREE:
				return validateRangeDegree((RangeDegree)value, diagnostics, context);
			case designdecisionPackage.DATA_TYPE_DEGREE:
				return validateDataTypeDegree((DataTypeDegree)value, diagnostics, context);
			case designdecisionPackage.CLASS_DEGREE:
				return validateClassDegree((ClassDegree)value, diagnostics, context);
			case designdecisionPackage.CLASS_CHOICE:
				return validateClassChoice((ClassChoice)value, diagnostics, context);
			case designdecisionPackage.CONTINOUS_RANGE_CHOICE:
				return validateContinousRangeChoice((ContinousRangeChoice)value, diagnostics, context);
			case designdecisionPackage.CONTINUOUS_PROCESSING_RATE_DEGREE:
				return validateContinuousProcessingRateDegree((ContinuousProcessingRateDegree)value, diagnostics, context);
			case designdecisionPackage.CONTINUOUS_RANGE_DEGREE:
				return validateContinuousRangeDegree((ContinuousRangeDegree)value, diagnostics, context);
			case designdecisionPackage.PROCESSING_RATE_DEGREE:
				return validateProcessingRateDegree((ProcessingRateDegree)value, diagnostics, context);
			case designdecisionPackage.PROCESSING_RESOURCE_DEGREE:
				return validateProcessingResourceDegree((ProcessingResourceDegree)value, diagnostics, context);
			case designdecisionPackage.ALLOCATION_DEGREE:
				return validateAllocationDegree((AllocationDegree)value, diagnostics, context);
			case designdecisionPackage.CLASS_AS_REFERENCE_DEGREE:
				return validateClassAsReferenceDegree((ClassAsReferenceDegree)value, diagnostics, context);
			case designdecisionPackage.ASSEMBLED_COMPONENT_DEGREE:
				return validateAssembledComponentDegree((AssembledComponentDegree)value, diagnostics, context);
			case designdecisionPackage.DISCRETE_RANGE_DEGREE:
				return validateDiscreteRangeDegree((DiscreteRangeDegree)value, diagnostics, context);
			case designdecisionPackage.DISCRETE_DEGREE:
				return validateDiscreteDegree((DiscreteDegree)value, diagnostics, context);
			case designdecisionPackage.DISCRETE_RANGE_CHOICE:
				return validateDiscreteRangeChoice((DiscreteRangeChoice)value, diagnostics, context);
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DEGREE:
				return validateResourceContainerReplicationDegree((ResourceContainerReplicationDegree)value, diagnostics, context);
			case designdecisionPackage.DECISION_SPACE:
				return validateDecisionSpace((DecisionSpace)value, diagnostics, context);
			case designdecisionPackage.CANDIDATE:
				return validateCandidate((Candidate)value, diagnostics, context);
			case designdecisionPackage.CANDIDATES:
				return validateCandidates((Candidates)value, diagnostics, context);
			case designdecisionPackage.FEATURE_CONFIG_DEGREE:
				return validateFeatureConfigDegree((FeatureConfigDegree)value, diagnostics, context);
			case designdecisionPackage.FEATURE_GROUP_DEGREE:
				return validateFeatureGroupDegree((FeatureGroupDegree)value, diagnostics, context);
			case designdecisionPackage.FEATURE_SUBSET:
				return validateFeatureSubset((FeatureSubset)value, diagnostics, context);
			case designdecisionPackage.OPTIONAL_FEATURE_DEGREE:
				return validateOptionalFeatureDegree((OptionalFeatureDegree)value, diagnostics, context);
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE:
				return validateDiscreteProcessingRateDegree((DiscreteProcessingRateDegree)value, diagnostics, context);
			case designdecisionPackage.CAPACITY_DEGREE:
				return validateCapacityDegree((CapacityDegree)value, diagnostics, context);
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE:
				return validateSchedulingPolicyDegree((SchedulingPolicyDegree)value, diagnostics, context);
			case designdecisionPackage.ENUM_DEGREE:
				return validateEnumDegree((EnumDegree)value, diagnostics, context);
			case designdecisionPackage.UNORDERED_DEGREE:
				return validateUnorderedDegree((UnorderedDegree)value, diagnostics, context);
			case designdecisionPackage.CLASS_WITH_COPY_DEGREE:
				return validateClassWithCopyDegree((ClassWithCopyDegree)value, diagnostics, context);
			case designdecisionPackage.RESOURCE_SELECTION_DEGREE:
				return validateResourceSelectionDegree((ResourceSelectionDegree)value, diagnostics, context);
			case designdecisionPackage.STRING_SET_DEGREE:
				return validateStringSetDegree((StringSetDegree)value, diagnostics, context);
			case designdecisionPackage.DISCRETE_COMPONENT_PARAM_DEGREE:
				return validateDiscreteComponentParamDegree((DiscreteComponentParamDegree)value, diagnostics, context);
			case designdecisionPackage.CONTINUOUS_COMPONENT_PARAM_DEGREE:
				return validateContinuousComponentParamDegree((ContinuousComponentParamDegree)value, diagnostics, context);
			case designdecisionPackage.STRING_COMPONENT_PARAM_DEGREE:
				return validateStringComponentParamDegree((StringComponentParamDegree)value, diagnostics, context);
			case designdecisionPackage.UNORDERED_PRIMITIVE_DEGREE:
				return validateUnorderedPrimitiveDegree((UnorderedPrimitiveDegree)value, diagnostics, context);
			case designdecisionPackage.NUMBER_OF_CORES_AS_RANGE_DEGREE:
				return validateNumberOfCoresAsRangeDegree((NumberOfCoresAsRangeDegree)value, diagnostics, context);
			case designdecisionPackage.NUMBER_OF_CORES_DEGREE:
				return validateNumberOfCoresDegree((NumberOfCoresDegree)value, diagnostics, context);
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DEGREE_WITH_COMPONENT_CHANGE:
				return validateResourceContainerReplicationDegreeWithComponentChange((ResourceContainerReplicationDegreeWithComponentChange)value, diagnostics, context);
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE:
				return validateExchangeComponentRule((ExchangeComponentRule)value, diagnostics, context);
			case designdecisionPackage.ORDERED_DATA_TYPE_DEGREE:
				return validateOrderedDataTypeDegree((OrderedDataTypeDegree)value, diagnostics, context);
			case designdecisionPackage.ORDERED_INTEGER_DEGREE:
				return validateOrderedIntegerDegree((OrderedIntegerDegree)value, diagnostics, context);
			case designdecisionPackage.NUMBER_OF_CORES_AS_LIST_DEGREE:
				return validateNumberOfCoresAsListDegree((NumberOfCoresAsListDegree)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDegreeOfFreedomInstance(DegreeOfFreedomInstance degreeOfFreedomInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(degreeOfFreedomInstance, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChoice(Choice choice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(choice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeDegree(RangeDegree rangeDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rangeDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeDegree(DataTypeDegree dataTypeDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataTypeDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassDegree(ClassDegree classDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassChoice(ClassChoice classChoice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classChoice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinousRangeChoice(ContinousRangeChoice continousRangeChoice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(continousRangeChoice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuousProcessingRateDegree(ContinuousProcessingRateDegree continuousProcessingRateDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(continuousProcessingRateDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuousRangeDegree(ContinuousRangeDegree continuousRangeDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(continuousRangeDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessingRateDegree(ProcessingRateDegree processingRateDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processingRateDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessingResourceDegree(ProcessingResourceDegree processingResourceDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processingResourceDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocationDegree(AllocationDegree allocationDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(allocationDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassAsReferenceDegree(ClassAsReferenceDegree classAsReferenceDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classAsReferenceDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssembledComponentDegree(AssembledComponentDegree assembledComponentDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assembledComponentDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiscreteRangeDegree(DiscreteRangeDegree discreteRangeDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(discreteRangeDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiscreteDegree(DiscreteDegree discreteDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(discreteDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiscreteRangeChoice(DiscreteRangeChoice discreteRangeChoice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(discreteRangeChoice, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceContainerReplicationDegree(ResourceContainerReplicationDegree resourceContainerReplicationDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceContainerReplicationDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecisionSpace(DecisionSpace decisionSpace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(decisionSpace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCandidate(Candidate candidate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(candidate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCandidates(Candidates candidates, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(candidates, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(candidates, diagnostics, context);
		if (result || diagnostics != null) result &= validateCandidates_numberOfChoicesMustEqualNumberOfDecisions(candidates, diagnostics, context);
		return result;
	}

	/**
	 * Validates the numberOfChoicesMustEqualNumberOfDecisions constraint of '<em>Candidates</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCandidates_numberOfChoicesMustEqualNumberOfDecisions(Candidates candidates, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return candidates.numberOfChoicesMustEqualNumberOfDecisions(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureConfigDegree(FeatureConfigDegree featureConfigDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureConfigDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureGroupDegree(FeatureGroupDegree featureGroupDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureGroupDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureSubset(FeatureSubset featureSubset, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureSubset, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOptionalFeatureDegree(OptionalFeatureDegree optionalFeatureDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(optionalFeatureDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiscreteProcessingRateDegree(DiscreteProcessingRateDegree discreteProcessingRateDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(discreteProcessingRateDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCapacityDegree(CapacityDegree capacityDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(capacityDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchedulingPolicyDegree(SchedulingPolicyDegree schedulingPolicyDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(schedulingPolicyDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumDegree(EnumDegree enumDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnorderedDegree(UnorderedDegree unorderedDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unorderedDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassWithCopyDegree(ClassWithCopyDegree classWithCopyDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classWithCopyDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceSelectionDegree(ResourceSelectionDegree resourceSelectionDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceSelectionDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringSetDegree(StringSetDegree stringSetDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringSetDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiscreteComponentParamDegree(DiscreteComponentParamDegree discreteComponentParamDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(discreteComponentParamDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuousComponentParamDegree(ContinuousComponentParamDegree continuousComponentParamDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(continuousComponentParamDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringComponentParamDegree(StringComponentParamDegree stringComponentParamDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringComponentParamDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnorderedPrimitiveDegree(UnorderedPrimitiveDegree unorderedPrimitiveDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unorderedPrimitiveDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberOfCoresAsRangeDegree(NumberOfCoresAsRangeDegree numberOfCoresAsRangeDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numberOfCoresAsRangeDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberOfCoresDegree(NumberOfCoresDegree numberOfCoresDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numberOfCoresDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceContainerReplicationDegreeWithComponentChange(ResourceContainerReplicationDegreeWithComponentChange resourceContainerReplicationDegreeWithComponentChange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceContainerReplicationDegreeWithComponentChange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExchangeComponentRule(ExchangeComponentRule exchangeComponentRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exchangeComponentRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedDataTypeDegree(OrderedDataTypeDegree orderedDataTypeDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(orderedDataTypeDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedIntegerDegree(OrderedIntegerDegree orderedIntegerDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(orderedIntegerDegree, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumberOfCoresAsListDegree(NumberOfCoresAsListDegree numberOfCoresAsListDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(numberOfCoresAsListDegree, diagnostics, context);
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

} //designdecisionValidator
