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
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * 
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage
 * @generated
 */
public class QualityAnnotationValidator extends EObjectValidator {

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final QualityAnnotationValidator INSTANCE = new QualityAnnotationValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
     * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "de.fzi.se.quality.qualityannotation";

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stipulated
     * Precision Must Be Set In Stipulation Context' of 'Required Element'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int REQUIRED_ELEMENT__STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT = 1;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'APCM
     * Parameter Partition Must Reference APCM Parameter Reference' of 'PCM Parameter Partition'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCM_PARAMETER_PARTITION__APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE = 2;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Hierarchy Level Is PCMRE Infrastructure Interface For Category Infrastructure' of 'PCMRE
     * Category'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE = 3;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Existing RE
     * Precision Call Parameter Must Be No Precision Due To The Non Existence Of Parameters For
     * Category Resource Demand' of 'PCMRE Category'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_CATEGORY__EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND = 4;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Hierarchy Level Is PCMRE Resource Interface For Category Resource' of 'PCMRE Category'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE = 5;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Hierarchy Level Is PCMRE Interface For Category Component' of 'PCMRE Category'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT = 6;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Hierarchy Level Is PCMRE Resource For Category Resource Demand' of 'PCMRE Category'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND = 7;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Hierarchy Level Is PCMRECI Behavior For Category Component Internal' of 'PCMRE Category'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL = 8;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each
     * Category Exactly Once If Specified' of 'PCMRE Category'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_CATEGORY__EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED = 9;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Topmost
     * Level For PCM Must Be PCMRE Category' of 'PCMRE'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    public static final int PCMRE__TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY = 10;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Level Must Consist Of Type PCMRE Role' of 'PCMRE Interface'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE = 11;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Interface'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 12;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Level Must Consist Of Type PCMRE Signature' of 'PCMRE Role'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_SIGNATURE = 13;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Role'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 14;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The
     * Lowest Component Hierarchy Level' of 'PCMRE Signature'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_SIGNATURE__THIS_IS_THE_LOWEST_COMPONENT_HIERARCHY_LEVEL = 15;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Signature'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_SIGNATURE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 16;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Level Must Consist Of Type PCMRE Resource Role' of 'PCMRE Resource Interface'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_RESOURCE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE = 17;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Resource Interface'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_RESOURCE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 18;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The
     * Lowest Resource Hierarchy Level' of 'PCMRE Resource Signature'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_RESOURCE_SIGNATURE__THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL = 19;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Resource Signature'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_RESOURCE_SIGNATURE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 20;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The
     * Lowest Resource Demand Hierarchy Level' of 'PCMRE Resource'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_RESOURCE__THIS_IS_THE_LOWEST_RESOURCE_DEMAND_HIERARCHY_LEVEL = 21;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Resource'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_RESOURCE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 22;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Level Must Consist Of Type PCMRE Resource Signature' of 'PCMRE Resource Role'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_RESOURCE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE = 23;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Resource Role'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_RESOURCE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 24;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The
     * Lowest Component Internal Hierarchy Level' of 'PCMRECI Behavior'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRECI_BEHAVIOR__THIS_IS_THE_LOWEST_COMPONENT_INTERNAL_HIERARCHY_LEVEL = 25;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRECI Behavior'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRECI_BEHAVIOR__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 26;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Level Must Consist Of Type PCMRE Infrastructure Role' of 'PCMRE Infrastructure Interface'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_INFRASTRUCTURE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE = 27;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Infrastructure Interface'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_INFRASTRUCTURE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 28;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Level Must Consist Of Type PCMRE Infrastructure Signature' of 'PCMRE Infrastructure Role'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMRE_INFRASTRUCTURE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE = 29;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Infrastructure Role'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_INFRASTRUCTURE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 30;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The
     * Lowest Infrastructure Hierarchy Level' of 'PCMRE Infrastructure Signature'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_INFRASTRUCTURE_SIGNATURE__THIS_IS_THE_LOWEST_INFRASTRUCTURE_HIERARCHY_LEVEL = 31;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Each RE
     * Target Must Be Referenced Only From One RE' of 'PCMRE Infrastructure Signature'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int PCMRE_INFRASTRUCTURE_SIGNATURE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE = 32;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Topmost
     * Level Must Be PCMPE All Decisions' of 'PCMPE'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMPE__TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS = 33;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Next Lower
     * Hierarchy Level Must Be Decision' of 'PCMPE All Decisions'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMPE_ALL_DECISIONS__NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION = 34;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'This Is The
     * Lowest Decision Hierarchy Level' of 'PCMPE Decision'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final int PCMPE_DECISION__THIS_IS_THE_LOWEST_DECISION_HIERARCHY_LEVEL = 35;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written
     * constants. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 35;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written
     * constants in a derived class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public QualityAnnotationValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
        return QualityAnnotationPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected boolean validate(final int classifierID, final Object value, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        switch (classifierID) {
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION:
            return this.validateParameterValueDeviation((ParameterValueDeviation) value, diagnostics, context);
        case QualityAnnotationPackage.QUALITY_ANNOTATION:
            return this.validateQualityAnnotation((QualityAnnotation) value, diagnostics, context);
        case QualityAnnotationPackage.SERVICE_SPECIFICATION:
            return this.validateServiceSpecification((ServiceSpecification) value, diagnostics, context);
        case QualityAnnotationPackage.REQUIRED_ELEMENT:
            return this.validateRequiredElement((RequiredElement) value, diagnostics, context);
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION:
            return this.validateRequiredElementDeviation((RequiredElementDeviation) value, diagnostics, context);
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.validateInternalStateInfluenceAnalysisAggregation(
                    (InternalStateInfluenceAnalysisAggregation) value, diagnostics, context);
        case QualityAnnotationPackage.PRECISION:
            return this.validatePrecision((Precision) value, diagnostics, context);
        case QualityAnnotationPackage.RE_PRECISION:
            return this.validateREPrecision((REPrecision) value, diagnostics, context);
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT:
            return this.validateProbabilisticElement((ProbabilisticElement) value, diagnostics, context);
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION:
            return this.validateCharacterisedPCMParameterPartition((CharacterisedPCMParameterPartition) value,
                    diagnostics, context);
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION:
            return this.validatePCMParameterPartition((PCMParameterPartition) value, diagnostics, context);
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL:
            return this.validateCharacterisedPCMParameterPartitionInterval(
                    (CharacterisedPCMParameterPartitionInterval) value, diagnostics, context);
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE:
            return this.validateCharacterisedPCMParameterPartitionRange(
                    (CharacterisedPCMParameterPartitionRange) value, diagnostics, context);
        case QualityAnnotationPackage.EXACTLY_AS_SPECIFIED_PRECISION:
            return this.validateExactlyAsSpecifiedPrecision((ExactlyAsSpecifiedPrecision) value, diagnostics, context);
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION:
            return this.validateLimitedDeviationPrecision((LimitedDeviationPrecision) value, diagnostics, context);
        case QualityAnnotationPackage.NO_PRECISION:
            return this.validateNoPrecision((NoPrecision) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_CATEGORY:
            return this.validatePCMRECategory((PCMRECategory) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE:
            return this.validatePCMRE((PCMRE) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_INTERFACE:
            return this.validatePCMREInterface((PCMREInterface) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_ROLE:
            return this.validatePCMRERole((PCMRERole) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_SIGNATURE:
            return this.validatePCMRESignature((PCMRESignature) value, diagnostics, context);
        case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION:
            return this.validatePCMServiceSpecification((PCMServiceSpecification) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE:
            return this.validatePCMREResourceInterface((PCMREResourceInterface) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE:
            return this.validatePCMREResourceSignature((PCMREResourceSignature) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_RESOURCE:
            return this.validatePCMREResource((PCMREResource) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE:
            return this.validatePCMREResourceRole((PCMREResourceRole) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRECI_BEHAVIOR:
            return this.validatePCMRECIBehavior((PCMRECIBehavior) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE:
            return this
                    .validatePCMREInfrastructureInterface((PCMREInfrastructureInterface) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE:
            return this.validatePCMREInfrastructureRole((PCMREInfrastructureRole) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_SIGNATURE:
            return this
                    .validatePCMREInfrastructureSignature((PCMREInfrastructureSignature) value, diagnostics, context);
        case QualityAnnotationPackage.PCMPE:
            return this.validatePCMPE((PCMPE) value, diagnostics, context);
        case QualityAnnotationPackage.PCMPE_ALL_DECISIONS:
            return this.validatePCMPEAllDecisions((PCMPEAllDecisions) value, diagnostics, context);
        case QualityAnnotationPackage.PCMPE_DECISION:
            return this.validatePCMPEDecision((PCMPEDecision) value, diagnostics, context);
        case QualityAnnotationPackage.PCMRE_REQUEST_CATEGORY:
            return this.validatePCMRERequestCategory((PCMRERequestCategory) value, diagnostics, context);
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateParameterValueDeviation(final ParameterValueDeviation parameterValueDeviation,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(parameterValueDeviation, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateQualityAnnotation(final QualityAnnotation qualityAnnotation,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(qualityAnnotation, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateServiceSpecification(final ServiceSpecification serviceSpecification,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(serviceSpecification, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateRequiredElement(final RequiredElement requiredElement, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(requiredElement, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(requiredElement, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(requiredElement, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(requiredElement, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(requiredElement, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(requiredElement, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(requiredElement, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(requiredElement,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the StipulatedPrecisionMustBeSetInStipulationContext constraint of '
     * <em>Required Element</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(
            final RequiredElement requiredElement, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return requiredElement.StipulatedPrecisionMustBeSetInStipulationContext(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateRequiredElementDeviation(final RequiredElementDeviation requiredElementDeviation,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(requiredElementDeviation, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateInternalStateInfluenceAnalysisAggregation(
            final InternalStateInfluenceAnalysisAggregation internalStateInfluenceAnalysisAggregation,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(internalStateInfluenceAnalysisAggregation, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateREPrecision(final REPrecision rePrecision, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(rePrecision, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateProbabilisticElement(final ProbabilisticElement probabilisticElement,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(probabilisticElement, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePrecision(final Precision precision, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(precision, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMParameterPartition(final PCMParameterPartition pcmParameterPartition,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmParameterPartition, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmParameterPartition, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmParameterPartition, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmParameterPartition, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmParameterPartition, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmParameterPartition, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmParameterPartition, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMParameterPartition_APCMParameterPartitionMustReferenceAPCMParameterReference(
                    pcmParameterPartition, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the APCMParameterPartitionMustReferenceAPCMParameterReference constraint of '
     * <em>PCM Parameter Partition</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMParameterPartition_APCMParameterPartitionMustReferenceAPCMParameterReference(
            final PCMParameterPartition pcmParameterPartition, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmParameterPartition.APCMParameterPartitionMustReferenceAPCMParameterReference(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateCharacterisedPCMParameterPartition(
            final CharacterisedPCMParameterPartition characterisedPCMParameterPartition,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(characterisedPCMParameterPartition, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateCharacterisedPCMParameterPartitionInterval(
            final CharacterisedPCMParameterPartitionInterval characterisedPCMParameterPartitionInterval,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(characterisedPCMParameterPartitionInterval, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateCharacterisedPCMParameterPartitionRange(
            final CharacterisedPCMParameterPartitionRange characterisedPCMParameterPartitionRange,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(characterisedPCMParameterPartitionRange, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateExactlyAsSpecifiedPrecision(final ExactlyAsSpecifiedPrecision exactlyAsSpecifiedPrecision,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(exactlyAsSpecifiedPrecision, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateLimitedDeviationPrecision(final LimitedDeviationPrecision limitedDeviationPrecision,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(limitedDeviationPrecision, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateNoPrecision(final NoPrecision noPrecision, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(noPrecision, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory(final PCMRECategory pcmreCategory, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreCategory, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreCategory,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this
                    .validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(
                            pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this
                    .validatePCMRECategory_ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(
                            pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(
                    pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(
                    pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(
                    pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRECategory_NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(
                    pcmreCategory, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this
                    .validatePCMRECategory_EachCategoryExactlyOnceIfSpecified(pcmreCategory, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure
     * constraint of '<em>PCMRE Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(
            final PCMRECategory pcmreCategory, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(
                diagnostics, context);
    }

    /**
     * Validates the
     * ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand
     * constraint of '<em>PCMRE Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory_ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(
            final PCMRECategory pcmreCategory, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreCategory
                .ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(
                        diagnostics, context);
    }

    /**
     * Validates the NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource constraint
     * of '<em>PCMRE Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(
            final PCMRECategory pcmreCategory, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(diagnostics, context);
    }

    /**
     * Validates the NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent constraint of '
     * <em>PCMRE Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(
            final PCMRECategory pcmreCategory, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(diagnostics, context);
    }

    /**
     * Validates the NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand constraint of '
     * <em>PCMRE Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(
            final PCMRECategory pcmreCategory, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(diagnostics, context);
    }

    /**
     * Validates the NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal constraint
     * of '<em>PCMRE Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory_NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(
            final PCMRECategory pcmreCategory, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreCategory.NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(diagnostics, context);
    }

    /**
     * Validates the EachCategoryExactlyOnceIfSpecified constraint of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECategory_EachCategoryExactlyOnceIfSpecified(final PCMRECategory pcmreCategory,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreCategory.EachCategoryExactlyOnceIfSpecified(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRE(final PCMRE pcmre, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmre, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmre, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmre, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmre, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmre, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmre, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmre, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmre, diagnostics,
                    context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmre, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the TopmostLevelForPCMMustBePCMRECategory constraint of '<em>PCMRE</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(final PCMRE pcmre,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmre.TopmostLevelForPCMMustBePCMRECategory(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInterface(final PCMREInterface pcmreInterface, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreInterface, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreInterface,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInterface_NextLowerLevelMustConsistOfTypePCMRERole(pcmreInterface, diagnostics,
                    context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInterface_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreInterface,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerLevelMustConsistOfTypePCMRERole constraint of '
     * <em>PCMRE Interface</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInterface_NextLowerLevelMustConsistOfTypePCMRERole(final PCMREInterface pcmreInterface,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreInterface.NextLowerLevelMustConsistOfTypePCMRERole(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Interface</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInterface_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMREInterface pcmreInterface, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreInterface.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRERole(final PCMRERole pcmreRole, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreRole, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreRole,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRERole_NextLowerLevelMustConsistOfTypePCMRESignature(pcmreRole, diagnostics,
                    context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRERole_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreRole, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerLevelMustConsistOfTypePCMRESignature constraint of '
     * <em>PCMRE Role</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRERole_NextLowerLevelMustConsistOfTypePCMRESignature(final PCMRERole pcmreRole,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreRole.NextLowerLevelMustConsistOfTypePCMRESignature(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '<em>PCMRE Role</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRERole_EachRETargetMustBeReferencedOnlyFromOneRE(final PCMRERole pcmreRole,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreRole.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRESignature(final PCMRESignature pcmreSignature, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreSignature, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreSignature,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRESignature_ThisIsTheLowestComponentHierarchyLevel(pcmreSignature, diagnostics,
                    context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRESignature_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreSignature,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the ThisIsTheLowestComponentHierarchyLevel constraint of '<em>PCMRE Signature</em>
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRESignature_ThisIsTheLowestComponentHierarchyLevel(final PCMRESignature pcmreSignature,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreSignature.ThisIsTheLowestComponentHierarchyLevel(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Signature</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRESignature_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMRESignature pcmreSignature, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreSignature.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMServiceSpecification(final PCMServiceSpecification pcmServiceSpecification,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(pcmServiceSpecification, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceInterface(final PCMREResourceInterface pcmreResourceInterface,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreResourceInterface, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(
                    pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResourceInterface, diagnostics,
                    context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResourceInterface_NextLowerLevelMustConsistOfTypePCMREResourceRole(
                    pcmreResourceInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResourceInterface_EachRETargetMustBeReferencedOnlyFromOneRE(
                    pcmreResourceInterface, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerLevelMustConsistOfTypePCMREResourceRole constraint of '
     * <em>PCMRE Resource Interface</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceInterface_NextLowerLevelMustConsistOfTypePCMREResourceRole(
            final PCMREResourceInterface pcmreResourceInterface, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreResourceInterface.NextLowerLevelMustConsistOfTypePCMREResourceRole(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Resource Interface</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceInterface_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMREResourceInterface pcmreResourceInterface, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreResourceInterface.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceSignature(final PCMREResourceSignature pcmreResourceSignature,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreResourceSignature, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreResourceSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreResourceSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreResourceSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreResourceSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreResourceSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreResourceSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(
                    pcmreResourceSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResourceSignature, diagnostics,
                    context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResourceSignature_ThisIsTheLowestResourceHierarchyLevel(pcmreResourceSignature,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResourceSignature_EachRETargetMustBeReferencedOnlyFromOneRE(
                    pcmreResourceSignature, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the ThisIsTheLowestResourceHierarchyLevel constraint of '
     * <em>PCMRE Resource Signature</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceSignature_ThisIsTheLowestResourceHierarchyLevel(
            final PCMREResourceSignature pcmreResourceSignature, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreResourceSignature.ThisIsTheLowestResourceHierarchyLevel(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Resource Signature</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceSignature_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMREResourceSignature pcmreResourceSignature, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreResourceSignature.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResource(final PCMREResource pcmreResource, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreResource, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreResource, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreResource, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreResource, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreResource, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreResource, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreResource, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResource,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResource, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResource_ThisIsTheLowestResourceDemandHierarchyLevel(pcmreResource,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResource_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreResource, diagnostics,
                    context);
        }
        return result;
    }

    /**
     * Validates the ThisIsTheLowestResourceDemandHierarchyLevel constraint of '
     * <em>PCMRE Resource</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResource_ThisIsTheLowestResourceDemandHierarchyLevel(final PCMREResource pcmreResource,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreResource.ThisIsTheLowestResourceDemandHierarchyLevel(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Resource</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResource_EachRETargetMustBeReferencedOnlyFromOneRE(final PCMREResource pcmreResource,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreResource.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceRole(final PCMREResourceRole pcmreResourceRole,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreResourceRole, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreResourceRole,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResourceRole_NextLowerLevelMustConsistOfTypePCMREResourceSignature(
                    pcmreResourceRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREResourceRole_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreResourceRole,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerLevelMustConsistOfTypePCMREResourceSignature constraint of '
     * <em>PCMRE Resource Role</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceRole_NextLowerLevelMustConsistOfTypePCMREResourceSignature(
            final PCMREResourceRole pcmreResourceRole, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreResourceRole.NextLowerLevelMustConsistOfTypePCMREResourceSignature(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Resource Role</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREResourceRole_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMREResourceRole pcmreResourceRole, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreResourceRole.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECIBehavior(final PCMRECIBehavior pcmreciBehavior, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreciBehavior, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreciBehavior, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreciBehavior, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreciBehavior, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreciBehavior, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreciBehavior, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreciBehavior, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(pcmreciBehavior,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreciBehavior, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRECIBehavior_ThisIsTheLowestComponentInternalHierarchyLevel(pcmreciBehavior,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRECIBehavior_EachRETargetMustBeReferencedOnlyFromOneRE(pcmreciBehavior,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the ThisIsTheLowestComponentInternalHierarchyLevel constraint of '
     * <em>PCMRECI Behavior</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECIBehavior_ThisIsTheLowestComponentInternalHierarchyLevel(
            final PCMRECIBehavior pcmreciBehavior, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreciBehavior.ThisIsTheLowestComponentInternalHierarchyLevel(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRECI Behavior</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRECIBehavior_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMRECIBehavior pcmreciBehavior, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmreciBehavior.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureInterface(
            final PCMREInfrastructureInterface pcmreInfrastructureInterface, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreInfrastructureInterface, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(
                    pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInfrastructureInterface,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInfrastructureInterface_NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(
                    pcmreInfrastructureInterface, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInfrastructureInterface_EachRETargetMustBeReferencedOnlyFromOneRE(
                    pcmreInfrastructureInterface, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerLevelMustConsistOfTypePCMREInfrastructureRole constraint of '
     * <em>PCMRE Infrastructure Interface</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureInterface_NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(
            final PCMREInfrastructureInterface pcmreInfrastructureInterface, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreInfrastructureInterface
                .NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Infrastructure Interface</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureInterface_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMREInfrastructureInterface pcmreInfrastructureInterface, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreInfrastructureInterface.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureRole(final PCMREInfrastructureRole pcmreInfrastructureRole,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreInfrastructureRole, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(
                    pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInfrastructureRole, diagnostics,
                    context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInfrastructureRole_NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(
                    pcmreInfrastructureRole, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInfrastructureRole_EachRETargetMustBeReferencedOnlyFromOneRE(
                    pcmreInfrastructureRole, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature constraint of '
     * <em>PCMRE Infrastructure Role</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureRole_NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(
            final PCMREInfrastructureRole pcmreInfrastructureRole, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreInfrastructureRole
                .NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Infrastructure Role</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureRole_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMREInfrastructureRole pcmreInfrastructureRole, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreInfrastructureRole.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureSignature(
            final PCMREInfrastructureSignature pcmreInfrastructureSignature, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmreInfrastructureSignature, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateRequiredElement_StipulatedPrecisionMustBeSetInStipulationContext(
                    pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMRE_TopmostLevelForPCMMustBePCMRECategory(pcmreInfrastructureSignature,
                    diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInfrastructureSignature_ThisIsTheLowestInfrastructureHierarchyLevel(
                    pcmreInfrastructureSignature, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMREInfrastructureSignature_EachRETargetMustBeReferencedOnlyFromOneRE(
                    pcmreInfrastructureSignature, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the ThisIsTheLowestInfrastructureHierarchyLevel constraint of '
     * <em>PCMRE Infrastructure Signature</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureSignature_ThisIsTheLowestInfrastructureHierarchyLevel(
            final PCMREInfrastructureSignature pcmreInfrastructureSignature, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreInfrastructureSignature.ThisIsTheLowestInfrastructureHierarchyLevel(diagnostics, context);
    }

    /**
     * Validates the EachRETargetMustBeReferencedOnlyFromOneRE constraint of '
     * <em>PCMRE Infrastructure Signature</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMREInfrastructureSignature_EachRETargetMustBeReferencedOnlyFromOneRE(
            final PCMREInfrastructureSignature pcmreInfrastructureSignature, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmreInfrastructureSignature.EachRETargetMustBeReferencedOnlyFromOneRE(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMPE(final PCMPE pcmpe, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmpe, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmpe, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmpe, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmpe, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmpe, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmpe, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmpe, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(pcmpe, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the TopmostLevelMustBePCMPEAllDecisions constraint of '<em>PCMPE</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(final PCMPE pcmpe,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmpe.TopmostLevelMustBePCMPEAllDecisions(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMPEAllDecisions(final PCMPEAllDecisions pcmpeAllDecisions,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmpeAllDecisions, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmpeAllDecisions, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmpeAllDecisions, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmpeAllDecisions, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmpeAllDecisions, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmpeAllDecisions, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmpeAllDecisions, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(pcmpeAllDecisions, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMPEAllDecisions_NextLowerHierarchyLevelMustBeDecision(pcmpeAllDecisions,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the NextLowerHierarchyLevelMustBeDecision constraint of '
     * <em>PCMPE All Decisions</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMPEAllDecisions_NextLowerHierarchyLevelMustBeDecision(
            final PCMPEAllDecisions pcmpeAllDecisions, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return pcmpeAllDecisions.NextLowerHierarchyLevelMustBeDecision(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMPEDecision(final PCMPEDecision pcmpeDecision, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = this.validate_EveryMultiplicityConforms(pcmpeDecision, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(pcmpeDecision, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(pcmpeDecision, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(pcmpeDecision, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(pcmpeDecision, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(pcmpeDecision, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(pcmpeDecision, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMPE_TopmostLevelMustBePCMPEAllDecisions(pcmpeDecision, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validatePCMPEDecision_ThisIsTheLowestDecisionHierarchyLevel(pcmpeDecision, diagnostics,
                    context);
        }
        return result;
    }

    /**
     * Validates the ThisIsTheLowestDecisionHierarchyLevel constraint of '<em>PCMPE Decision</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMPEDecision_ThisIsTheLowestDecisionHierarchyLevel(final PCMPEDecision pcmpeDecision,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return pcmpeDecision.ThisIsTheLowestDecisionHierarchyLevel(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePCMRERequestCategory(final PCMRERequestCategory pcmreRequestCategory,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return true;
    }

} // QualityAnnotationValidator
