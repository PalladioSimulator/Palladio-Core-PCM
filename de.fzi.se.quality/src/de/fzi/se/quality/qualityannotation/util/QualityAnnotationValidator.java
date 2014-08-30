/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange;
import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.PCMPE;
import de.fzi.se.quality.qualityannotation.PCMPEAllDecisions;
import de.fzi.se.quality.qualityannotation.PCMPEDecision;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMRE;
import de.fzi.se.quality.qualityannotation.PCMRECIBehavior;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature;
import de.fzi.se.quality.qualityannotation.PCMREInterface;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.PCMREResource;
import de.fzi.se.quality.qualityannotation.PCMREResourceInterface;
import de.fzi.se.quality.qualityannotation.PCMREResourceRole;
import de.fzi.se.quality.qualityannotation.PCMREResourceSignature;
import de.fzi.se.quality.qualityannotation.PCMRERole;
import de.fzi.se.quality.qualityannotation.PCMRESignature;
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;

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
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'APCM Parameter Partition Must Reference APCM Parameter Reference' of 'PCM Parameter Partition'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCM_PARAMETER_PARTITION__APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE = 2;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Is PCMRE Infrastructure Interface For Category Infrastructure' of 'PCMRE Category'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE = 3;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Existing RE Precision Call Parameter Must Be No Precision Due To The Non Existence Of Parameters For Category Resource Demand' of 'PCMRE Category'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_CATEGORY__EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND = 4;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Is PCMRE Resource Interface For Category Resource' of 'PCMRE Category'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE = 5;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Is PCMRE Interface For Category Component' of 'PCMRE Category'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT = 6;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Is PCMRE Resource For Category Resource Demand' of 'PCMRE Category'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND = 7;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Is PCMRECI Behavior For Category Component Internal' of 'PCMRE Category'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL = 8;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each Category Exactly Once If Specified' of 'PCMRE Category'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_CATEGORY__EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED = 9;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Topmost Level For PCM Must Be PCMRE Category' of 'PCMRE'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE__TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY = 10;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Level Must Consist Of Type PCMRE Role' of 'PCMRE Interface'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE = 11;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Interface'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 12;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Level Must Consist Of Type PCMRE Signature' of 'PCMRE Role'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_SIGNATURE = 13;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Role'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 14;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The Lowest Component Hierarchy Level' of 'PCMRE Signature'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_SIGNATURE__THIS_IS_THE_LOWEST_COMPONENT_HIERARCHY_LEVEL = 15;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Signature'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_SIGNATURE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 16;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Level Must Consist Of Type PCMRE Resource Role' of 'PCMRE Resource Interface'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE = 17;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Resource Interface'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 18;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The Lowest Resource Hierarchy Level' of 'PCMRE Resource Signature'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE_SIGNATURE__THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL = 19;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Resource Signature'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE_SIGNATURE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 20;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The Lowest Resource Demand Hierarchy Level' of 'PCMRE Resource'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE__THIS_IS_THE_LOWEST_RESOURCE_DEMAND_HIERARCHY_LEVEL = 21;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Resource'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 22;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Level Must Consist Of Type PCMRE Resource Signature' of 'PCMRE Resource Role'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE = 23;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Resource Role'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_RESOURCE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 24;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The Lowest Component Internal Hierarchy Level' of 'PCMRECI Behavior'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRECI_BEHAVIOR__THIS_IS_THE_LOWEST_COMPONENT_INTERNAL_HIERARCHY_LEVEL = 25;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRECI Behavior'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRECI_BEHAVIOR__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 26;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Level Must Consist Of Type PCMRE Infrastructure Role' of 'PCMRE Infrastructure Interface'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INFRASTRUCTURE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE = 27;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Infrastructure Interface'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INFRASTRUCTURE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 28;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Level Must Consist Of Type PCMRE Infrastructure Signature' of 'PCMRE Infrastructure Role'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INFRASTRUCTURE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE = 29;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Infrastructure Role'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INFRASTRUCTURE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 30;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The Lowest Infrastructure Hierarchy Level' of 'PCMRE Infrastructure Signature'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INFRASTRUCTURE_SIGNATURE__THIS_IS_THE_LOWEST_INFRASTRUCTURE_HIERARCHY_LEVEL = 31;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE Target Must Be Referenced Only From One RE' of 'PCMRE Infrastructure Signature'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMRE_INFRASTRUCTURE_SIGNATURE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 32;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Topmost Level Must Be PCMPE All Decisions' of 'PCMPE'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMPE__TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS = 33;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower Hierarchy Level Must Be Decision' of 'PCMPE All Decisions'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMPE_ALL_DECISIONS__NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION = 34;

	/**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The Lowest Decision Hierarchy Level' of 'PCMPE Decision'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final int PCMPE_DECISION__THIS_IS_THE_LOWEST_DECISION_HIERARCHY_LEVEL = 35;

	/**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 35;

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
	public QualityAnnotationValidator() {
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
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION:
                return validateParameterValueDeviation((ParameterValueDeviation)value, diagnostics, context);
            case QualityAnnotationPackage.QUALITY_ANNOTATION:
                return validateQualityAnnotation((QualityAnnotation)value, diagnostics, context);
            case QualityAnnotationPackage.SERVICE_SPECIFICATION:
                return validateServiceSpecification((ServiceSpecification)value, diagnostics, context);
            case QualityAnnotationPackage.REQUIRED_ELEMENT:
                return validateRequiredElement((RequiredElement)value, diagnostics, context);
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION:
                return validateRequiredElementDeviation((RequiredElementDeviation)value, diagnostics, context);
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
                return validateInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation)value, diagnostics, context);
            case QualityAnnotationPackage.PRECISION:
                return validatePrecision((Precision)value, diagnostics, context);
            case QualityAnnotationPackage.RE_PRECISION:
                return validateREPrecision((REPrecision)value, diagnostics, context);
            case QualityAnnotationPackage.PROBABILISTIC_ELEMENT:
                return validateProbabilisticElement((ProbabilisticElement)value, diagnostics, context);
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION:
                return validateCharacterisedPCMParameterPartition((CharacterisedPCMParameterPartition)value, diagnostics, context);
            case QualityAnnotationPackage.PCM_PARAMETER_PARTITION:
                return validatePCMParameterPartition((PCMParameterPartition)value, diagnostics, context);
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
            case QualityAnnotationPackage.PCMRE_RESOURCE:
                return validatePCMREResource((PCMREResource)value, diagnostics, context);
            case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE:
                return validatePCMREResourceRole((PCMREResourceRole)value, diagnostics, context);
            case QualityAnnotationPackage.PCMRECI_BEHAVIOR:
                return validatePCMRECIBehavior((PCMRECIBehavior)value, diagnostics, context);
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE:
                return validatePCMREInfrastructureInterface((PCMREInfrastructureInterface)value, diagnostics, context);
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE:
                return validatePCMREInfrastructureRole((PCMREInfrastructureRole)value, diagnostics, context);
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_SIGNATURE:
                return validatePCMREInfrastructureSignature((PCMREInfrastructureSignature)value, diagnostics, context);
            case QualityAnnotationPackage.PCMPE:
                return validatePCMPE((PCMPE)value, diagnostics, context);
            case QualityAnnotationPackage.PCMPE_ALL_DECISIONS:
                return validatePCMPEAllDecisions((PCMPEAllDecisions)value, diagnostics, context);
            case QualityAnnotationPackage.PCMPE_DECISION:
                return validatePCMPEDecision((PCMPEDecision)value, diagnostics, context);
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
	public boolean validateParameterValueDeviation(ParameterValueDeviation parameterValueDeviation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(parameterValueDeviation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateQualityAnnotation(QualityAnnotation qualityAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(qualityAnnotation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateServiceSpecification(ServiceSpecification serviceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(serviceSpecification, diagnostics, context);
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
	public boolean validateRequiredElementDeviation(RequiredElementDeviation requiredElementDeviation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(requiredElementDeviation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation internalStateInfluenceAnalysisAggregation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(internalStateInfluenceAnalysisAggregation, diagnostics, context);
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
	public boolean validateProbabilisticElement(ProbabilisticElement probabilisticElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(probabilisticElement, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePrecision(Precision precision, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(precision, diagnostics, context);
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
        if (result || diagnostics != null) result &= validatePCMParameterPartition_APCMParameterPartitionMustReferenceAPCMParameterReference(pcmParameterPartition, diagnostics, context);
        return result;
    }

	/**
     * Validates the APCMParameterPartitionMustReferenceAPCMParameterReference constraint of '<em>PCM Parameter Partition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMParameterPartition_APCMParameterPartitionMustReferenceAPCMParameterReference(PCMParameterPartition pcmParameterPartition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmParameterPartition.APCMParameterPartitionMustReferenceAPCMParameterReference(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCharacterisedPCMParameterPartition(CharacterisedPCMParameterPartition characterisedPCMParameterPartition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(characterisedPCMParameterPartition, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCharacterisedPCMParameterPartitionInterval(CharacterisedPCMParameterPartitionInterval characterisedPCMParameterPartitionInterval, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(characterisedPCMParameterPartitionInterval, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCharacterisedPCMParameterPartitionRange(CharacterisedPCMParameterPartitionRange characterisedPCMParameterPartitionRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(characterisedPCMParameterPartitionRange, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExactlyAsSpecifiedPrecision(ExactlyAsSpecifiedPrecision exactlyAsSpecifiedPrecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(exactlyAsSpecifiedPrecision, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLimitedDeviationPrecision(LimitedDeviationPrecision limitedDeviationPrecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(limitedDeviationPrecision, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNoPrecision(NoPrecision noPrecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(noPrecision, diagnostics, context);
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
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECategory_ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECategory_NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECategory_EachCategoryExactlyOnceIfSpecified(pcmreCategory, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure constraint of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(diagnostics, context);
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
     * Validates the NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource constraint of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(diagnostics, context);
    }

	/**
     * Validates the NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent constraint of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(diagnostics, context);
    }

	/**
     * Validates the NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand constraint of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(diagnostics, context);
    }

	/**
     * Validates the NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal constraint of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(diagnostics, context);
    }

	/**
     * Validates the EachCategoryExactlyOnceIfSpecified constraint of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECategory_EachCategoryExactlyOnceIfSpecified(PCMRECategory pcmreCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreCategory.EachCategoryExactlyOnceIfSpecified(diagnostics, context);
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
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmre, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmre, diagnostics, context);
        return result;
    }

	/**
     * Validates the TopmostLevelForPCMMustBePCMRECategory constraint of '<em>PCMRE</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(PCMRE pcmre, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmre.TopmostLevelForPCMMustBePCMRECategory(diagnostics, context);
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
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInterface_NextLowerLevelMustConsistOfTypePCMRERole(pcmreInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInterface_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreInterface, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerLevelMustConsistOfTypePCMRERole constraint of '<em>PCMRE Interface</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInterface_NextLowerLevelMustConsistOfTypePCMRERole(PCMREInterface pcmreInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInterface.NextLowerLevelMustConsistOfTypePCMRERole(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Interface</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInterface_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREInterface pcmreInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInterface.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
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
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRERole_NextLowerLevelMustConsistOfTypePCMRESignature(pcmreRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRERole_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreRole, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerLevelMustConsistOfTypePCMRESignature constraint of '<em>PCMRE Role</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRERole_NextLowerLevelMustConsistOfTypePCMRESignature(PCMRERole pcmreRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreRole.NextLowerLevelMustConsistOfTypePCMRESignature(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Role</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRERole_EachRETargetMustBeReferencedOnlyFromOneRE(PCMRERole pcmreRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreRole.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
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
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRESignature_ThisIsTheLowestComponentHierarchyLevel(pcmreSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRESignature_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreSignature, diagnostics, context);
        return result;
    }

	/**
     * Validates the ThisIsTheLowestComponentHierarchyLevel constraint of '<em>PCMRE Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRESignature_ThisIsTheLowestComponentHierarchyLevel(PCMRESignature pcmreSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreSignature.ThisIsTheLowestComponentHierarchyLevel(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRESignature_EachRETargetMustBeReferencedOnlyFromOneRE(PCMRESignature pcmreSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreSignature.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMServiceSpecification(PCMServiceSpecification pcmServiceSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(pcmServiceSpecification, diagnostics, context);
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
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResourceInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResourceInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResourceInterface_NextLowerLevelMustConsistOfTypePCMREResourceRole(pcmreResourceInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResourceInterface_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreResourceInterface, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerLevelMustConsistOfTypePCMREResourceRole constraint of '<em>PCMRE Resource Interface</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResourceInterface_NextLowerLevelMustConsistOfTypePCMREResourceRole(PCMREResourceInterface pcmreResourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResourceInterface.NextLowerLevelMustConsistOfTypePCMREResourceRole(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Resource Interface</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResourceInterface_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREResourceInterface pcmreResourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResourceInterface.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
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
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResourceSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResourceSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResourceSignature_ThisIsTheLowestResourceHierarchyLevel(pcmreResourceSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResourceSignature_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreResourceSignature, diagnostics, context);
        return result;
    }

	/**
     * Validates the ThisIsTheLowestResourceHierarchyLevel constraint of '<em>PCMRE Resource Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResourceSignature_ThisIsTheLowestResourceHierarchyLevel(PCMREResourceSignature pcmreResourceSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResourceSignature.ThisIsTheLowestResourceHierarchyLevel(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Resource Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResourceSignature_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREResourceSignature pcmreResourceSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResourceSignature.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResource(PCMREResource pcmreResource, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResource_ThisIsTheLowestResourceDemandHierarchyLevel(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResource_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreResource, diagnostics, context);
        return result;
    }

	/**
     * Validates the ThisIsTheLowestResourceDemandHierarchyLevel constraint of '<em>PCMRE Resource</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResource_ThisIsTheLowestResourceDemandHierarchyLevel(PCMREResource pcmreResource, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResource.ThisIsTheLowestResourceDemandHierarchyLevel(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Resource</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResource_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREResource pcmreResource, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResource.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResourceRole(PCMREResourceRole pcmreResourceRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResourceRole_NextLowerLevelMustConsistOfTypePCMREResourceSignature(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREResourceRole_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreResourceRole, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerLevelMustConsistOfTypePCMREResourceSignature constraint of '<em>PCMRE Resource Role</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResourceRole_NextLowerLevelMustConsistOfTypePCMREResourceSignature(PCMREResourceRole pcmreResourceRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResourceRole.NextLowerLevelMustConsistOfTypePCMREResourceSignature(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Resource Role</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREResourceRole_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREResourceRole pcmreResourceRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreResourceRole.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECIBehavior(PCMRECIBehavior pcmreciBehavior, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECIBehavior_ThisIsTheLowestComponentInternalHierarchyLevel(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRECIBehavior_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreciBehavior, diagnostics, context);
        return result;
    }

	/**
     * Validates the ThisIsTheLowestComponentInternalHierarchyLevel constraint of '<em>PCMRECI Behavior</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECIBehavior_ThisIsTheLowestComponentInternalHierarchyLevel(PCMRECIBehavior pcmreciBehavior, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreciBehavior.ThisIsTheLowestComponentInternalHierarchyLevel(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRECI Behavior</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMRECIBehavior_EachRETargetMustBeReferencedOnlyFromOneRE(PCMRECIBehavior pcmreciBehavior, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreciBehavior.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureInterface(PCMREInfrastructureInterface pcmreInfrastructureInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInfrastructureInterface_NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInfrastructureInterface_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreInfrastructureInterface, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerLevelMustConsistOfTypePCMREInfrastructureRole constraint of '<em>PCMRE Infrastructure Interface</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureInterface_NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(PCMREInfrastructureInterface pcmreInfrastructureInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInfrastructureInterface.NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Infrastructure Interface</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureInterface_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREInfrastructureInterface pcmreInfrastructureInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInfrastructureInterface.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureRole(PCMREInfrastructureRole pcmreInfrastructureRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInfrastructureRole_NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInfrastructureRole_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreInfrastructureRole, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature constraint of '<em>PCMRE Infrastructure Role</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureRole_NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(PCMREInfrastructureRole pcmreInfrastructureRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInfrastructureRole.NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Infrastructure Role</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureRole_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREInfrastructureRole pcmreInfrastructureRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInfrastructureRole.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureSignature(PCMREInfrastructureSignature pcmreInfrastructureSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInfrastructureSignature_ThisIsTheLowestInfrastructureHierarchyLevel(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMREInfrastructureSignature_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreInfrastructureSignature, diagnostics, context);
        return result;
    }

	/**
     * Validates the ThisIsTheLowestInfrastructureHierarchyLevel constraint of '<em>PCMRE Infrastructure Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureSignature_ThisIsTheLowestInfrastructureHierarchyLevel(PCMREInfrastructureSignature pcmreInfrastructureSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInfrastructureSignature.ThisIsTheLowestInfrastructureHierarchyLevel(diagnostics, context);
    }

	/**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Infrastructure Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMREInfrastructureSignature_EachRETargetMustBeReferencedOnlyFromOneRE(PCMREInfrastructureSignature pcmreInfrastructureSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmreInfrastructureSignature.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMPE(PCMPE pcmpe, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmpe, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmpe, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmpe, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmpe, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmpe, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmpe, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmpe, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(pcmpe, diagnostics, context);
        return result;
    }

	/**
     * Validates the TopmostLevelMustBePCMPEAllDecisions constraint of '<em>PCMPE</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(PCMPE pcmpe, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmpe.TopmostLevelMustBePCMPEAllDecisions(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMPEAllDecisions(PCMPEAllDecisions pcmpeAllDecisions, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMPEAllDecisions_NextLowerHierarchyLevelMustBeDecision(pcmpeAllDecisions, diagnostics, context);
        return result;
    }

	/**
     * Validates the NextLowerHierarchyLevelMustBeDecision constraint of '<em>PCMPE All Decisions</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMPEAllDecisions_NextLowerHierarchyLevelMustBeDecision(PCMPEAllDecisions pcmpeAllDecisions, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmpeAllDecisions.NextLowerHierarchyLevelMustBeDecision(diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMPEDecision(PCMPEDecision pcmpeDecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) result &= validatePCMPEDecision_ThisIsTheLowestDecisionHierarchyLevel(pcmpeDecision, diagnostics, context);
        return result;
    }

	/**
     * Validates the ThisIsTheLowestDecisionHierarchyLevel constraint of '<em>PCMPE Decision</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePCMPEDecision_ThisIsTheLowestDecisionHierarchyLevel(PCMPEDecision pcmpeDecision, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return pcmpeDecision.ThisIsTheLowestDecisionHierarchyLevel(diagnostics, context);
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
