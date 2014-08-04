/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc -->
 * <p>
 * This package allows for the specification of a sensitivity analysis for PCM models.
 * </p>
 * <!-- end-model-doc -->
 * 
 * @see de.uka.ipd.sdq.sensitivity.SensitivityFactory
 * @model kind="package"
 * @generated
 */
public interface SensitivityPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "sensitivity";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://sdq.ipd.uka.de/Sensitivity/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "sensitivity";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    SensitivityPackage eINSTANCE = de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl.init();

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.SensitivityConfigurationImpl <em>Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityConfigurationImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityConfiguration()
     * @generated
     */
    int SENSITIVITY_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_CONFIGURATION__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_CONFIGURATION__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Sensitivity Parameters Sensitivity Configuration</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION = EntityPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Result Specifications Sensitivity Configuration</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION = EntityPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Configuration</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_CONFIGURATION_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterImpl
     * <em>Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityParameter()
     * @generated
     */
    int SENSITIVITY_PARAMETER = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_PARAMETER__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_PARAMETER__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = EntityPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = EntityPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Parameter</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_PARAMETER_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.CombinedSensitivityParameterImpl
     * <em>Combined Sensitivity Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.CombinedSensitivityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getCombinedSensitivityParameter()
     * @generated
     */
    int COMBINED_SENSITIVITY_PARAMETER = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMBINED_SENSITIVITY_PARAMETER__ID = SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMBINED_SENSITIVITY_PARAMETER__ENTITY_NAME = SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMBINED_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMBINED_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Is Combinatory</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMBINED_SENSITIVITY_PARAMETER__IS_COMBINATORY = SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Child Parameters Combined Sensitivity Parameter</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER = SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Combined Sensitivity Parameter</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMBINED_SENSITIVITY_PARAMETER_FEATURE_COUNT = SENSITIVITY_PARAMETER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.SensitivityResultSpecificationImpl
     * <em>Result Specification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityResultSpecificationImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityResultSpecification()
     * @generated
     */
    int SENSITIVITY_RESULT_SPECIFICATION = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_RESULT_SPECIFICATION__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_RESULT_SPECIFICATION__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The number of structural features of the '<em>Result Specification</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_RESULT_SPECIFICATION_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.SingleSensitivityParameterImpl
     * <em>Single Sensitivity Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.SingleSensitivityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSingleSensitivityParameter()
     * @generated
     */
    int SINGLE_SENSITIVITY_PARAMETER = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_SENSITIVITY_PARAMETER__ID = SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME = SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Single Sensitivity Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT = SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterVariationImpl
     * <em>Parameter Variation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterVariationImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityParameterVariation()
     * @generated
     */
    int SENSITIVITY_PARAMETER_VARIATION = 5;

    /**
     * The feature id for the '
     * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = 0;

    /**
     * The number of structural features of the '<em>Parameter Variation</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SENSITIVITY_PARAMETER_VARIATION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.ComponentReliabilityParameterImpl
     * <em>Component Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.ComponentReliabilityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getComponentReliabilityParameter()
     * @generated
     */
    int COMPONENT_RELIABILITY_PARAMETER = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_RELIABILITY_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_RELIABILITY_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_RELIABILITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_RELIABILITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_RELIABILITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Basic Component Component Reliability Parameter</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Component Reliability Parameter</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPONENT_RELIABILITY_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterVariationImpl
     * <em>Double Parameter Variation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterVariationImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterVariation()
     * @generated
     */
    int DOUBLE_PARAMETER_VARIATION = 7;

    /**
     * The feature id for the '
     * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION;

    /**
     * The number of structural features of the '<em>Double Parameter Variation</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT = SENSITIVITY_PARAMETER_VARIATION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.StringParameterSequenceImpl
     * <em>String Parameter Sequence</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.StringParameterSequenceImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getStringParameterSequence()
     * @generated
     */
    int STRING_PARAMETER_SEQUENCE = 8;

    /**
     * The feature id for the '
     * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_PARAMETER_SEQUENCE__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION;

    /**
     * The feature id for the '<em><b>String Values</b></em>' attribute list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_PARAMETER_SEQUENCE__STRING_VALUES = SENSITIVITY_PARAMETER_VARIATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>String Parameter Sequence</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_PARAMETER_SEQUENCE_FEATURE_COUNT = SENSITIVITY_PARAMETER_VARIATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl
     * <em>Double Parameter Range</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterRange()
     * @generated
     */
    int DOUBLE_PARAMETER_RANGE = 9;

    /**
     * The feature id for the '
     * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_RANGE__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = DOUBLE_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION;

    /**
     * The feature id for the '<em><b>Consider Step Size</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>First Value</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_RANGE__FIRST_VALUE = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Last Value</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_RANGE__LAST_VALUE = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Step Size</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_RANGE__STEP_SIZE = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Step Count</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_RANGE__STEP_COUNT = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Double Parameter Range</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_RANGE_FEATURE_COUNT = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterSequenceImpl
     * <em>Double Parameter Sequence</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterSequenceImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterSequence()
     * @generated
     */
    int DOUBLE_PARAMETER_SEQUENCE = 10;

    /**
     * The feature id for the '
     * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_SEQUENCE__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = DOUBLE_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION;

    /**
     * The feature id for the '<em><b>Double Values</b></em>' attribute list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Double Parameter Sequence</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_SEQUENCE_FEATURE_COUNT = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterFunctionImpl
     * <em>Double Parameter Function</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterFunctionImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterFunction()
     * @generated
     */
    int DOUBLE_PARAMETER_FUNCTION = 11;

    /**
     * The feature id for the '
     * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_FUNCTION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = DOUBLE_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION;

    /**
     * The number of structural features of the '<em>Double Parameter Function</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_PARAMETER_FUNCTION_FEATURE_COUNT = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.InternalActionReliabilityParameterImpl
     * <em>Internal Action Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.InternalActionReliabilityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getInternalActionReliabilityParameter()
     * @generated
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER = 12;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Software Induced Failure Type Internal Action Reliability Parameter</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Internal Action Internal Action Reliability Parameter</b></em>
     * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Internal Action Reliability Parameter</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERNAL_ACTION_RELIABILITY_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.ProbabilisticBranchParameterImpl
     * <em>Probabilistic Branch Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.ProbabilisticBranchParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getProbabilisticBranchParameter()
     * @generated
     */
    int PROBABILISTIC_BRANCH_PARAMETER = 13;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROBABILISTIC_BRANCH_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROBABILISTIC_BRANCH_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROBABILISTIC_BRANCH_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROBABILISTIC_BRANCH_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROBABILISTIC_BRANCH_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Probabilistic Branch Transition Probabilistic Branch Parameter</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Probabilistic Branch Parameter</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROBABILISTIC_BRANCH_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.HardwareMTTFParameterImpl
     * <em>Hardware MTTF Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.HardwareMTTFParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getHardwareMTTFParameter()
     * @generated
     */
    int HARDWARE_MTTF_PARAMETER = 14;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTF_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTF_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTF_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTF_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTF_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The number of structural features of the '<em>Hardware MTTF Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTF_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.HardwareMTTRParameterImpl
     * <em>Hardware MTTR Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.HardwareMTTRParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getHardwareMTTRParameter()
     * @generated
     */
    int HARDWARE_MTTR_PARAMETER = 15;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTR_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTR_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTR_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTR_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTR_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The number of structural features of the '<em>Hardware MTTR Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_MTTR_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTFParameterImpl
     * <em>Resource MTTF Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.ResourceMTTFParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getResourceMTTFParameter()
     * @generated
     */
    int RESOURCE_MTTF_PARAMETER = 16;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Processing Resource Type Resource MTTF Parameter</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Resource Container Resource MTTF Parameter</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Resource MTTF Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTF_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTRParameterImpl
     * <em>Resource MTTR Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.ResourceMTTRParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getResourceMTTRParameter()
     * @generated
     */
    int RESOURCE_MTTR_PARAMETER = 17;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Resource Container Resource MTTR Parameter</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Processing Resource Type Resource MTTR Parameter</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Resource MTTR Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_MTTR_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.NetworkReliabilityParameterImpl
     * <em>Network Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.NetworkReliabilityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getNetworkReliabilityParameter()
     * @generated
     */
    int NETWORK_RELIABILITY_PARAMETER = 18;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_RELIABILITY_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_RELIABILITY_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_RELIABILITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_RELIABILITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_RELIABILITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The number of structural features of the '<em>Network Reliability Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_RELIABILITY_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.CommunicationLinkReliabilityParameterImpl
     * <em>Communication Link Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.CommunicationLinkReliabilityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getCommunicationLinkReliabilityParameter()
     * @generated
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER = 19;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Communication Link Resource Specification Communication Link Reliability Parameter</b></em>
     * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Communication Link Reliability Parameter</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMMUNICATION_LINK_RELIABILITY_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.SoftwareReliabilityParameterImpl
     * <em>Software Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.SoftwareReliabilityParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSoftwareReliabilityParameter()
     * @generated
     */
    int SOFTWARE_RELIABILITY_PARAMETER = 20;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_RELIABILITY_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_RELIABILITY_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_RELIABILITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_RELIABILITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_RELIABILITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The number of structural features of the '<em>Software Reliability Parameter</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_RELIABILITY_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl
     * <em>Variable Usage Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getVariableUsageParameter()
     * @generated
     */
    int VARIABLE_USAGE_PARAMETER = 21;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Variable Name</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__VARIABLE_NAME = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Entry Level System Call Variable Usage Parameter</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '
     * <em><b>Variable Characterisation Type Variable Usage Parameter</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Variable Usage Type Variable Usage Parameter</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Basic Component Variable Usage Parameter</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Variable Usage Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_USAGE_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.UsageBranchParameterImpl
     * <em>Usage Branch Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.UsageBranchParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getUsageBranchParameter()
     * @generated
     */
    int USAGE_BRANCH_PARAMETER = 22;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Branch Usage Branch Parameter</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Scenario Behaviour Usage Branch Parameter</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Usage Branch Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int USAGE_BRANCH_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.impl.DoubleOffsetSequenceImpl
     * <em>Double Offset Sequence</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.DoubleOffsetSequenceImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleOffsetSequence()
     * @generated
     */
    int DOUBLE_OFFSET_SEQUENCE = 23;

    /**
     * The feature id for the '
     * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_OFFSET_SEQUENCE__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = DOUBLE_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION;

    /**
     * The feature id for the '<em><b>Offset Values</b></em>' attribute list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Double Offset Type Double Offset Sequence</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Double Offset Sequence</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOUBLE_OFFSET_SEQUENCE_FEATURE_COUNT = DOUBLE_PARAMETER_VARIATION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.SoftwareFailureTypesParameterImpl
     * <em>Software Failure Types Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.SoftwareFailureTypesParameterImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSoftwareFailureTypesParameter()
     * @generated
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER = 24;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER__ID = SINGLE_SENSITIVITY_PARAMETER__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER__ENTITY_NAME = SINGLE_SENSITIVITY_PARAMETER__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER;

    /**
     * The feature id for the '
     * <em><b>Software Induced Failure Types Software Failure Type Reliability Parameter</b></em>'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPES_SOFTWARE_FAILURE_TYPE_RELIABILITY_PARAMETER = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Software Failure Types Parameter</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOFTWARE_FAILURE_TYPES_PARAMETER_FEATURE_COUNT = SINGLE_SENSITIVITY_PARAMETER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.FailureTypeResultSpecificationImpl
     * <em>Failure Type Result Specification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.FailureTypeResultSpecificationImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getFailureTypeResultSpecification()
     * @generated
     */
    int FAILURE_TYPE_RESULT_SPECIFICATION = 25;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_TYPE_RESULT_SPECIFICATION__ID = SENSITIVITY_RESULT_SPECIFICATION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_TYPE_RESULT_SPECIFICATION__ENTITY_NAME = SENSITIVITY_RESULT_SPECIFICATION__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Failure Types Failure Type Result Specification</b></em>'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION = SENSITIVITY_RESULT_SPECIFICATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Failure Type Result Specification</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_TYPE_RESULT_SPECIFICATION_FEATURE_COUNT = SENSITIVITY_RESULT_SPECIFICATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.sensitivity.impl.FailureDimensionResultSpecificationImpl
     * <em>Failure Dimension Result Specification</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.impl.FailureDimensionResultSpecificationImpl
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getFailureDimensionResultSpecification()
     * @generated
     */
    int FAILURE_DIMENSION_RESULT_SPECIFICATION = 26;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_DIMENSION_RESULT_SPECIFICATION__ID = SENSITIVITY_RESULT_SPECIFICATION__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_DIMENSION_RESULT_SPECIFICATION__ENTITY_NAME = SENSITIVITY_RESULT_SPECIFICATION__ENTITY_NAME;

    /**
     * The feature id for the '
     * <em><b>Failure Dimension Failure Dimension Result Specification</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION = SENSITIVITY_RESULT_SPECIFICATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Failure Dimension Result Specification</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FAILURE_DIMENSION_RESULT_SPECIFICATION_FEATURE_COUNT = SENSITIVITY_RESULT_SPECIFICATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.VariableUsageType
     * <em>Variable Usage Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageType
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getVariableUsageType()
     * @generated
     */
    int VARIABLE_USAGE_TYPE = 27;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetType
     * <em>Double Offset Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetType
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleOffsetType()
     * @generated
     */
    int DOUBLE_OFFSET_TYPE = 28;

    /**
     * The meta object id for the '{@link de.uka.ipd.sdq.sensitivity.FailureDimension
     * <em>Failure Dimension</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.sensitivity.FailureDimension
     * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getFailureDimension()
     * @generated
     */
    int FAILURE_DIMENSION = 29;

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityConfiguration <em>Configuration</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Configuration</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityConfiguration
     * @generated
     */
    EClass getSensitivityConfiguration();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityConfiguration#getSensitivityParameters__SensitivityConfiguration
     * <em>Sensitivity Parameters Sensitivity Configuration</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Sensitivity Parameters Sensitivity Configuration</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityConfiguration#getSensitivityParameters__SensitivityConfiguration()
     * @see #getSensitivityConfiguration()
     * @generated
     */
    EReference getSensitivityConfiguration_SensitivityParameters__SensitivityConfiguration();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityConfiguration#getSensitivityResultSpecifications__SensitivityConfiguration
     * <em>Sensitivity Result Specifications Sensitivity Configuration</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Sensitivity Result Specifications Sensitivity Configuration</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityConfiguration#getSensitivityResultSpecifications__SensitivityConfiguration()
     * @see #getSensitivityConfiguration()
     * @generated
     */
    EReference getSensitivityConfiguration_SensitivityResultSpecifications__SensitivityConfiguration();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.SensitivityParameter
     * <em>Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityParameter
     * @generated
     */
    EClass getSensitivityParameter();

    /**
     * Returns the meta object for the container reference '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityParameter#getParentParameter__SensitivityParameter
     * <em>Parent Parameter Sensitivity Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the container reference '
     *         <em>Parent Parameter Sensitivity Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityParameter#getParentParameter__SensitivityParameter()
     * @see #getSensitivityParameter()
     * @generated
     */
    EReference getSensitivityParameter_ParentParameter__SensitivityParameter();

    /**
     * Returns the meta object for the container reference '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityParameter#getSensitivityConfiguration__SensitivityParameter
     * <em>Sensitivity Configuration Sensitivity Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the container reference '
     *         <em>Sensitivity Configuration Sensitivity Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityParameter#getSensitivityConfiguration__SensitivityParameter()
     * @see #getSensitivityParameter()
     * @generated
     */
    EReference getSensitivityParameter_SensitivityConfiguration__SensitivityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter
     * <em>Combined Sensitivity Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Combined Sensitivity Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter
     * @generated
     */
    EClass getCombinedSensitivityParameter();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#isCombinatory
     * <em>Is Combinatory</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Is Combinatory</em>'.
     * @see de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#isCombinatory()
     * @see #getCombinedSensitivityParameter()
     * @generated
     */
    EAttribute getCombinedSensitivityParameter_IsCombinatory();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#getChildParameters__CombinedSensitivityParameter
     * <em>Child Parameters Combined Sensitivity Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Child Parameters Combined Sensitivity Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#getChildParameters__CombinedSensitivityParameter()
     * @see #getCombinedSensitivityParameter()
     * @generated
     */
    EReference getCombinedSensitivityParameter_ChildParameters__CombinedSensitivityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification
     * <em>Result Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Result Specification</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification
     * @generated
     */
    EClass getSensitivityResultSpecification();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter
     * <em>Single Sensitivity Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Single Sensitivity Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter
     * @generated
     */
    EClass getSingleSensitivityParameter();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter#getSensitivityParameterVariation__SingleSensitivityParameter
     * <em>Sensitivity Parameter Variation Single Sensitivity Parameter</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Sensitivity Parameter Variation Single Sensitivity Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter#getSensitivityParameterVariation__SingleSensitivityParameter()
     * @see #getSingleSensitivityParameter()
     * @generated
     */
    EReference getSingleSensitivityParameter_SensitivityParameterVariation__SingleSensitivityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation <em>Parameter Variation</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Parameter Variation</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation
     * @generated
     */
    EClass getSensitivityParameterVariation();

    /**
     * Returns the meta object for the container reference '
     * {@link de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation#getSingleSensitivityParameter__SensitivityParameterVariation
     * <em>Single Sensitivity Parameter Sensitivity Parameter Variation</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '
     *         <em>Single Sensitivity Parameter Sensitivity Parameter Variation</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation#getSingleSensitivityParameter__SensitivityParameterVariation()
     * @see #getSensitivityParameterVariation()
     * @generated
     */
    EReference getSensitivityParameterVariation_SingleSensitivityParameter__SensitivityParameterVariation();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter
     * <em>Component Reliability Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Component Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter
     * @generated
     */
    EClass getComponentReliabilityParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter#getBasicComponent__ComponentReliabilityParameter
     * <em>Basic Component Component Reliability Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Basic Component Component Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter#getBasicComponent__ComponentReliabilityParameter()
     * @see #getComponentReliabilityParameter()
     * @generated
     */
    EReference getComponentReliabilityParameter_BasicComponent__ComponentReliabilityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterVariation
     * <em>Double Parameter Variation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Double Parameter Variation</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterVariation
     * @generated
     */
    EClass getDoubleParameterVariation();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.StringParameterSequence
     * <em>String Parameter Sequence</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>String Parameter Sequence</em>'.
     * @see de.uka.ipd.sdq.sensitivity.StringParameterSequence
     * @generated
     */
    EClass getStringParameterSequence();

    /**
     * Returns the meta object for the attribute list '
     * {@link de.uka.ipd.sdq.sensitivity.StringParameterSequence#getStringValues
     * <em>String Values</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>String Values</em>'.
     * @see de.uka.ipd.sdq.sensitivity.StringParameterSequence#getStringValues()
     * @see #getStringParameterSequence()
     * @generated
     */
    EAttribute getStringParameterSequence_StringValues();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange
     * <em>Double Parameter Range</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Double Parameter Range</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterRange
     * @generated
     */
    EClass getDoubleParameterRange();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#isConsiderStepSize
     * <em>Consider Step Size</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Consider Step Size</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterRange#isConsiderStepSize()
     * @see #getDoubleParameterRange()
     * @generated
     */
    EAttribute getDoubleParameterRange_ConsiderStepSize();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getFirstValue <em>First Value</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>First Value</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getFirstValue()
     * @see #getDoubleParameterRange()
     * @generated
     */
    EAttribute getDoubleParameterRange_FirstValue();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getLastValue <em>Last Value</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Last Value</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getLastValue()
     * @see #getDoubleParameterRange()
     * @generated
     */
    EAttribute getDoubleParameterRange_LastValue();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepSize <em>Step Size</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Step Size</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepSize()
     * @see #getDoubleParameterRange()
     * @generated
     */
    EAttribute getDoubleParameterRange_StepSize();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepCount <em>Step Count</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Step Count</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterRange#getStepCount()
     * @see #getDoubleParameterRange()
     * @generated
     */
    EAttribute getDoubleParameterRange_StepCount();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterSequence
     * <em>Double Parameter Sequence</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Double Parameter Sequence</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterSequence
     * @generated
     */
    EClass getDoubleParameterSequence();

    /**
     * Returns the meta object for the attribute list '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleParameterSequence#getDoubleValues
     * <em>Double Values</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Double Values</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterSequence#getDoubleValues()
     * @see #getDoubleParameterSequence()
     * @generated
     */
    EAttribute getDoubleParameterSequence_DoubleValues();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.DoubleParameterFunction
     * <em>Double Parameter Function</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Double Parameter Function</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleParameterFunction
     * @generated
     */
    EClass getDoubleParameterFunction();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter
     * <em>Internal Action Reliability Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Internal Action Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter
     * @generated
     */
    EClass getInternalActionReliabilityParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getSoftwareInducedFailureType__InternalActionReliabilityParameter
     * <em>Software Induced Failure Type Internal Action Reliability Parameter</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Software Induced Failure Type Internal Action Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getSoftwareInducedFailureType__InternalActionReliabilityParameter()
     * @see #getInternalActionReliabilityParameter()
     * @generated
     */
    EReference getInternalActionReliabilityParameter_SoftwareInducedFailureType__InternalActionReliabilityParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getInternalAction__InternalActionReliabilityParameter
     * <em>Internal Action Internal Action Reliability Parameter</em>}'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Internal Action Internal Action Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getInternalAction__InternalActionReliabilityParameter()
     * @see #getInternalActionReliabilityParameter()
     * @generated
     */
    EReference getInternalActionReliabilityParameter_InternalAction__InternalActionReliabilityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter
     * <em>Probabilistic Branch Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Probabilistic Branch Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter
     * @generated
     */
    EClass getProbabilisticBranchParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter#getProbabilisticBranchTransition__ProbabilisticBranchParameter
     * <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter#getProbabilisticBranchTransition__ProbabilisticBranchParameter()
     * @see #getProbabilisticBranchParameter()
     * @generated
     */
    EReference getProbabilisticBranchParameter_ProbabilisticBranchTransition__ProbabilisticBranchParameter();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.HardwareMTTFParameter
     * <em>Hardware MTTF Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Hardware MTTF Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.HardwareMTTFParameter
     * @generated
     */
    EClass getHardwareMTTFParameter();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.HardwareMTTRParameter
     * <em>Hardware MTTR Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Hardware MTTR Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.HardwareMTTRParameter
     * @generated
     */
    EClass getHardwareMTTRParameter();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter
     * <em>Resource MTTF Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Resource MTTF Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter
     * @generated
     */
    EClass getResourceMTTFParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getProcessingResourceType__ResourceMTTFParameter
     * <em>Processing Resource Type Resource MTTF Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Processing Resource Type Resource MTTF Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getProcessingResourceType__ResourceMTTFParameter()
     * @see #getResourceMTTFParameter()
     * @generated
     */
    EReference getResourceMTTFParameter_ProcessingResourceType__ResourceMTTFParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getResourceContainer__ResourceMTTFParameter
     * <em>Resource Container Resource MTTF Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Resource Container Resource MTTF Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getResourceContainer__ResourceMTTFParameter()
     * @see #getResourceMTTFParameter()
     * @generated
     */
    EReference getResourceMTTFParameter_ResourceContainer__ResourceMTTFParameter();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter
     * <em>Resource MTTR Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Resource MTTR Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter
     * @generated
     */
    EClass getResourceMTTRParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getResourceContainer__ResourceMTTRParameter
     * <em>Resource Container Resource MTTR Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Resource Container Resource MTTR Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getResourceContainer__ResourceMTTRParameter()
     * @see #getResourceMTTRParameter()
     * @generated
     */
    EReference getResourceMTTRParameter_ResourceContainer__ResourceMTTRParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getProcessingResourceType__ResourceMTTRParameter
     * <em>Processing Resource Type Resource MTTR Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Processing Resource Type Resource MTTR Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getProcessingResourceType__ResourceMTTRParameter()
     * @see #getResourceMTTRParameter()
     * @generated
     */
    EReference getResourceMTTRParameter_ProcessingResourceType__ResourceMTTRParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.NetworkReliabilityParameter
     * <em>Network Reliability Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Network Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.NetworkReliabilityParameter
     * @generated
     */
    EClass getNetworkReliabilityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter
     * <em>Communication Link Reliability Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Communication Link Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter
     * @generated
     */
    EClass getCommunicationLinkReliabilityParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter#getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter
     * <em>Communication Link Resource Specification Communication Link Reliability Parameter</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Communication Link Resource Specification Communication Link Reliability Parameter</em>
     *         '.
     * @see de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter#getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter()
     * @see #getCommunicationLinkReliabilityParameter()
     * @generated
     */
    EReference getCommunicationLinkReliabilityParameter_CommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter
     * <em>Software Reliability Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Software Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter
     * @generated
     */
    EClass getSoftwareReliabilityParameter();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter
     * <em>Variable Usage Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Variable Usage Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageParameter
     * @generated
     */
    EClass getVariableUsageParameter();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableName
     * <em>Variable Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Variable Name</em>'.
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableName()
     * @see #getVariableUsageParameter()
     * @generated
     */
    EAttribute getVariableUsageParameter_VariableName();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getEntryLevelSystemCall__VariableUsageParameter
     * <em>Entry Level System Call Variable Usage Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Entry Level System Call Variable Usage Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getEntryLevelSystemCall__VariableUsageParameter()
     * @see #getVariableUsageParameter()
     * @generated
     */
    EReference getVariableUsageParameter_EntryLevelSystemCall__VariableUsageParameter();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableCharacterisationType__VariableUsageParameter
     * <em>Variable Characterisation Type Variable Usage Parameter</em>}'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '
     *         <em>Variable Characterisation Type Variable Usage Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableCharacterisationType__VariableUsageParameter()
     * @see #getVariableUsageParameter()
     * @generated
     */
    EAttribute getVariableUsageParameter_VariableCharacterisationType__VariableUsageParameter();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableUsageType__VariableUsageParameter
     * <em>Variable Usage Type Variable Usage Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '
     *         <em>Variable Usage Type Variable Usage Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getVariableUsageType__VariableUsageParameter()
     * @see #getVariableUsageParameter()
     * @generated
     */
    EAttribute getVariableUsageParameter_VariableUsageType__VariableUsageParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getBasicComponent__VariableUsageParameter
     * <em>Basic Component Variable Usage Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Basic Component Variable Usage Parameter</em>
     *         '.
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageParameter#getBasicComponent__VariableUsageParameter()
     * @see #getVariableUsageParameter()
     * @generated
     */
    EReference getVariableUsageParameter_BasicComponent__VariableUsageParameter();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter
     * <em>Usage Branch Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Usage Branch Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.UsageBranchParameter
     * @generated
     */
    EClass getUsageBranchParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getBranch__UsageBranchParameter
     * <em>Branch Usage Branch Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Branch Usage Branch Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getBranch__UsageBranchParameter()
     * @see #getUsageBranchParameter()
     * @generated
     */
    EReference getUsageBranchParameter_Branch__UsageBranchParameter();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getScenarioBehaviour__UsageBranchParameter
     * <em>Scenario Behaviour Usage Branch Parameter</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Scenario Behaviour Usage Branch Parameter</em>
     *         '.
     * @see de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getScenarioBehaviour__UsageBranchParameter()
     * @see #getUsageBranchParameter()
     * @generated
     */
    EReference getUsageBranchParameter_ScenarioBehaviour__UsageBranchParameter();

    /**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence
     * <em>Double Offset Sequence</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Double Offset Sequence</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence
     * @generated
     */
    EClass getDoubleOffsetSequence();

    /**
     * Returns the meta object for the attribute list '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence#getOffsetValues
     * <em>Offset Values</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Offset Values</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence#getOffsetValues()
     * @see #getDoubleOffsetSequence()
     * @generated
     */
    EAttribute getDoubleOffsetSequence_OffsetValues();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence#getDoubleOffsetType__DoubleOffsetSequence
     * <em>Double Offset Type Double Offset Sequence</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Double Offset Type Double Offset Sequence</em>
     *         '.
     * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence#getDoubleOffsetType__DoubleOffsetSequence()
     * @see #getDoubleOffsetSequence()
     * @generated
     */
    EAttribute getDoubleOffsetSequence_DoubleOffsetType__DoubleOffsetSequence();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter
     * <em>Software Failure Types Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Software Failure Types Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter
     * @generated
     */
    EClass getSoftwareFailureTypesParameter();

    /**
     * Returns the meta object for the reference list '
     * {@link de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter#getSoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter
     * <em>Software Induced Failure Types Software Failure Type Reliability Parameter</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '
     *         <em>Software Induced Failure Types Software Failure Type Reliability Parameter</em>'.
     * @see de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter#getSoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter()
     * @see #getSoftwareFailureTypesParameter()
     * @generated
     */
    EReference getSoftwareFailureTypesParameter_SoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification
     * <em>Failure Type Result Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Failure Type Result Specification</em>'.
     * @see de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification
     * @generated
     */
    EClass getFailureTypeResultSpecification();

    /**
     * Returns the meta object for the reference list '
     * {@link de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification#getFailureTypes__FailureTypeResultSpecification
     * <em>Failure Types Failure Type Result Specification</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference list '
     *         <em>Failure Types Failure Type Result Specification</em>'.
     * @see de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification#getFailureTypes__FailureTypeResultSpecification()
     * @see #getFailureTypeResultSpecification()
     * @generated
     */
    EReference getFailureTypeResultSpecification_FailureTypes__FailureTypeResultSpecification();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification
     * <em>Failure Dimension Result Specification</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Failure Dimension Result Specification</em>'.
     * @see de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification
     * @generated
     */
    EClass getFailureDimensionResultSpecification();

    /**
     * Returns the meta object for the attribute '
     * {@link de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification#getFailureDimension__FailureDimensionResultSpecification
     * <em>Failure Dimension Failure Dimension Result Specification</em>}'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '
     *         <em>Failure Dimension Failure Dimension Result Specification</em>'.
     * @see de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification#getFailureDimension__FailureDimensionResultSpecification()
     * @see #getFailureDimensionResultSpecification()
     * @generated
     */
    EAttribute getFailureDimensionResultSpecification_FailureDimension__FailureDimensionResultSpecification();

    /**
     * Returns the meta object for enum '{@link de.uka.ipd.sdq.sensitivity.VariableUsageType
     * <em>Variable Usage Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Variable Usage Type</em>'.
     * @see de.uka.ipd.sdq.sensitivity.VariableUsageType
     * @generated
     */
    EEnum getVariableUsageType();

    /**
     * Returns the meta object for enum '{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetType
     * <em>Double Offset Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Double Offset Type</em>'.
     * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetType
     * @generated
     */
    EEnum getDoubleOffsetType();

    /**
     * Returns the meta object for enum '{@link de.uka.ipd.sdq.sensitivity.FailureDimension
     * <em>Failure Dimension</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Failure Dimension</em>'.
     * @see de.uka.ipd.sdq.sensitivity.FailureDimension
     * @generated
     */
    EEnum getFailureDimension();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SensitivityFactory getSensitivityFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.SensitivityConfigurationImpl
         * <em>Configuration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityConfigurationImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityConfiguration()
         * @generated
         */
        EClass SENSITIVITY_CONFIGURATION = eINSTANCE.getSensitivityConfiguration();

        /**
         * The meta object literal for the '
         * <em><b>Sensitivity Parameters Sensitivity Configuration</b></em>' containment reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION = eINSTANCE
                .getSensitivityConfiguration_SensitivityParameters__SensitivityConfiguration();

        /**
         * The meta object literal for the '
         * <em><b>Sensitivity Result Specifications Sensitivity Configuration</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION = eINSTANCE
                .getSensitivityConfiguration_SensitivityResultSpecifications__SensitivityConfiguration();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterImpl <em>Parameter</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityParameter()
         * @generated
         */
        EClass SENSITIVITY_PARAMETER = eINSTANCE.getSensitivityParameter();

        /**
         * The meta object literal for the '<em><b>Parent Parameter Sensitivity Parameter</b></em>'
         * container reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER = eINSTANCE
                .getSensitivityParameter_ParentParameter__SensitivityParameter();

        /**
         * The meta object literal for the '
         * <em><b>Sensitivity Configuration Sensitivity Parameter</b></em>' container reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER = eINSTANCE
                .getSensitivityParameter_SensitivityConfiguration__SensitivityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.CombinedSensitivityParameterImpl
         * <em>Combined Sensitivity Parameter</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.CombinedSensitivityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getCombinedSensitivityParameter()
         * @generated
         */
        EClass COMBINED_SENSITIVITY_PARAMETER = eINSTANCE.getCombinedSensitivityParameter();

        /**
         * The meta object literal for the '<em><b>Is Combinatory</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute COMBINED_SENSITIVITY_PARAMETER__IS_COMBINATORY = eINSTANCE
                .getCombinedSensitivityParameter_IsCombinatory();

        /**
         * The meta object literal for the '
         * <em><b>Child Parameters Combined Sensitivity Parameter</b></em>' containment reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER = eINSTANCE
                .getCombinedSensitivityParameter_ChildParameters__CombinedSensitivityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.SensitivityResultSpecificationImpl
         * <em>Result Specification</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityResultSpecificationImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityResultSpecification()
         * @generated
         */
        EClass SENSITIVITY_RESULT_SPECIFICATION = eINSTANCE.getSensitivityResultSpecification();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.SingleSensitivityParameterImpl
         * <em>Single Sensitivity Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.SingleSensitivityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSingleSensitivityParameter()
         * @generated
         */
        EClass SINGLE_SENSITIVITY_PARAMETER = eINSTANCE.getSingleSensitivityParameter();

        /**
         * The meta object literal for the '
         * <em><b>Sensitivity Parameter Variation Single Sensitivity Parameter</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER = eINSTANCE
                .getSingleSensitivityParameter_SensitivityParameterVariation__SingleSensitivityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterVariationImpl
         * <em>Parameter Variation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterVariationImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSensitivityParameterVariation()
         * @generated
         */
        EClass SENSITIVITY_PARAMETER_VARIATION = eINSTANCE.getSensitivityParameterVariation();

        /**
         * The meta object literal for the '
         * <em><b>Single Sensitivity Parameter Sensitivity Parameter Variation</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION = eINSTANCE
                .getSensitivityParameterVariation_SingleSensitivityParameter__SensitivityParameterVariation();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.ComponentReliabilityParameterImpl
         * <em>Component Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.ComponentReliabilityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getComponentReliabilityParameter()
         * @generated
         */
        EClass COMPONENT_RELIABILITY_PARAMETER = eINSTANCE.getComponentReliabilityParameter();

        /**
         * The meta object literal for the '
         * <em><b>Basic Component Component Reliability Parameter</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER = eINSTANCE
                .getComponentReliabilityParameter_BasicComponent__ComponentReliabilityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterVariationImpl
         * <em>Double Parameter Variation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterVariationImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterVariation()
         * @generated
         */
        EClass DOUBLE_PARAMETER_VARIATION = eINSTANCE.getDoubleParameterVariation();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.StringParameterSequenceImpl
         * <em>String Parameter Sequence</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.StringParameterSequenceImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getStringParameterSequence()
         * @generated
         */
        EClass STRING_PARAMETER_SEQUENCE = eINSTANCE.getStringParameterSequence();

        /**
         * The meta object literal for the '<em><b>String Values</b></em>' attribute list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute STRING_PARAMETER_SEQUENCE__STRING_VALUES = eINSTANCE.getStringParameterSequence_StringValues();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl
         * <em>Double Parameter Range</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterRange()
         * @generated
         */
        EClass DOUBLE_PARAMETER_RANGE = eINSTANCE.getDoubleParameterRange();

        /**
         * The meta object literal for the '<em><b>Consider Step Size</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE = eINSTANCE.getDoubleParameterRange_ConsiderStepSize();

        /**
         * The meta object literal for the '<em><b>First Value</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_PARAMETER_RANGE__FIRST_VALUE = eINSTANCE.getDoubleParameterRange_FirstValue();

        /**
         * The meta object literal for the '<em><b>Last Value</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_PARAMETER_RANGE__LAST_VALUE = eINSTANCE.getDoubleParameterRange_LastValue();

        /**
         * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_PARAMETER_RANGE__STEP_SIZE = eINSTANCE.getDoubleParameterRange_StepSize();

        /**
         * The meta object literal for the '<em><b>Step Count</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_PARAMETER_RANGE__STEP_COUNT = eINSTANCE.getDoubleParameterRange_StepCount();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterSequenceImpl
         * <em>Double Parameter Sequence</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterSequenceImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterSequence()
         * @generated
         */
        EClass DOUBLE_PARAMETER_SEQUENCE = eINSTANCE.getDoubleParameterSequence();

        /**
         * The meta object literal for the '<em><b>Double Values</b></em>' attribute list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES = eINSTANCE.getDoubleParameterSequence_DoubleValues();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterFunctionImpl
         * <em>Double Parameter Function</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.DoubleParameterFunctionImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleParameterFunction()
         * @generated
         */
        EClass DOUBLE_PARAMETER_FUNCTION = eINSTANCE.getDoubleParameterFunction();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.InternalActionReliabilityParameterImpl
         * <em>Internal Action Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.InternalActionReliabilityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getInternalActionReliabilityParameter()
         * @generated
         */
        EClass INTERNAL_ACTION_RELIABILITY_PARAMETER = eINSTANCE.getInternalActionReliabilityParameter();

        /**
         * The meta object literal for the '
         * <em><b>Software Induced Failure Type Internal Action Reliability Parameter</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER = eINSTANCE
                .getInternalActionReliabilityParameter_SoftwareInducedFailureType__InternalActionReliabilityParameter();

        /**
         * The meta object literal for the '
         * <em><b>Internal Action Internal Action Reliability Parameter</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER = eINSTANCE
                .getInternalActionReliabilityParameter_InternalAction__InternalActionReliabilityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.ProbabilisticBranchParameterImpl
         * <em>Probabilistic Branch Parameter</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.ProbabilisticBranchParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getProbabilisticBranchParameter()
         * @generated
         */
        EClass PROBABILISTIC_BRANCH_PARAMETER = eINSTANCE.getProbabilisticBranchParameter();

        /**
         * The meta object literal for the '
         * <em><b>Probabilistic Branch Transition Probabilistic Branch Parameter</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER = eINSTANCE
                .getProbabilisticBranchParameter_ProbabilisticBranchTransition__ProbabilisticBranchParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.HardwareMTTFParameterImpl
         * <em>Hardware MTTF Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.HardwareMTTFParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getHardwareMTTFParameter()
         * @generated
         */
        EClass HARDWARE_MTTF_PARAMETER = eINSTANCE.getHardwareMTTFParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.HardwareMTTRParameterImpl
         * <em>Hardware MTTR Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.HardwareMTTRParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getHardwareMTTRParameter()
         * @generated
         */
        EClass HARDWARE_MTTR_PARAMETER = eINSTANCE.getHardwareMTTRParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTFParameterImpl
         * <em>Resource MTTF Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.ResourceMTTFParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getResourceMTTFParameter()
         * @generated
         */
        EClass RESOURCE_MTTF_PARAMETER = eINSTANCE.getResourceMTTFParameter();

        /**
         * The meta object literal for the '
         * <em><b>Processing Resource Type Resource MTTF Parameter</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER = eINSTANCE
                .getResourceMTTFParameter_ProcessingResourceType__ResourceMTTFParameter();

        /**
         * The meta object literal for the '
         * <em><b>Resource Container Resource MTTF Parameter</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER = eINSTANCE
                .getResourceMTTFParameter_ResourceContainer__ResourceMTTFParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTRParameterImpl
         * <em>Resource MTTR Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.ResourceMTTRParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getResourceMTTRParameter()
         * @generated
         */
        EClass RESOURCE_MTTR_PARAMETER = eINSTANCE.getResourceMTTRParameter();

        /**
         * The meta object literal for the '
         * <em><b>Resource Container Resource MTTR Parameter</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER = eINSTANCE
                .getResourceMTTRParameter_ResourceContainer__ResourceMTTRParameter();

        /**
         * The meta object literal for the '
         * <em><b>Processing Resource Type Resource MTTR Parameter</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER = eINSTANCE
                .getResourceMTTRParameter_ProcessingResourceType__ResourceMTTRParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.NetworkReliabilityParameterImpl
         * <em>Network Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.NetworkReliabilityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getNetworkReliabilityParameter()
         * @generated
         */
        EClass NETWORK_RELIABILITY_PARAMETER = eINSTANCE.getNetworkReliabilityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.CommunicationLinkReliabilityParameterImpl
         * <em>Communication Link Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.CommunicationLinkReliabilityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getCommunicationLinkReliabilityParameter()
         * @generated
         */
        EClass COMMUNICATION_LINK_RELIABILITY_PARAMETER = eINSTANCE.getCommunicationLinkReliabilityParameter();

        /**
         * The meta object literal for the '
         * <em><b>Communication Link Resource Specification Communication Link Reliability Parameter</b></em>
         * ' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER = eINSTANCE
                .getCommunicationLinkReliabilityParameter_CommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.SoftwareReliabilityParameterImpl
         * <em>Software Reliability Parameter</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.SoftwareReliabilityParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSoftwareReliabilityParameter()
         * @generated
         */
        EClass SOFTWARE_RELIABILITY_PARAMETER = eINSTANCE.getSoftwareReliabilityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl
         * <em>Variable Usage Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getVariableUsageParameter()
         * @generated
         */
        EClass VARIABLE_USAGE_PARAMETER = eINSTANCE.getVariableUsageParameter();

        /**
         * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute VARIABLE_USAGE_PARAMETER__VARIABLE_NAME = eINSTANCE.getVariableUsageParameter_VariableName();

        /**
         * The meta object literal for the '
         * <em><b>Entry Level System Call Variable Usage Parameter</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER = eINSTANCE
                .getVariableUsageParameter_EntryLevelSystemCall__VariableUsageParameter();

        /**
         * The meta object literal for the '
         * <em><b>Variable Characterisation Type Variable Usage Parameter</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER = eINSTANCE
                .getVariableUsageParameter_VariableCharacterisationType__VariableUsageParameter();

        /**
         * The meta object literal for the '
         * <em><b>Variable Usage Type Variable Usage Parameter</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER = eINSTANCE
                .getVariableUsageParameter_VariableUsageType__VariableUsageParameter();

        /**
         * The meta object literal for the '<em><b>Basic Component Variable Usage Parameter</b></em>
         * ' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER = eINSTANCE
                .getVariableUsageParameter_BasicComponent__VariableUsageParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.UsageBranchParameterImpl
         * <em>Usage Branch Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.UsageBranchParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getUsageBranchParameter()
         * @generated
         */
        EClass USAGE_BRANCH_PARAMETER = eINSTANCE.getUsageBranchParameter();

        /**
         * The meta object literal for the '<em><b>Branch Usage Branch Parameter</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER = eINSTANCE
                .getUsageBranchParameter_Branch__UsageBranchParameter();

        /**
         * The meta object literal for the '
         * <em><b>Scenario Behaviour Usage Branch Parameter</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER = eINSTANCE
                .getUsageBranchParameter_ScenarioBehaviour__UsageBranchParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.DoubleOffsetSequenceImpl
         * <em>Double Offset Sequence</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.DoubleOffsetSequenceImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleOffsetSequence()
         * @generated
         */
        EClass DOUBLE_OFFSET_SEQUENCE = eINSTANCE.getDoubleOffsetSequence();

        /**
         * The meta object literal for the '<em><b>Offset Values</b></em>' attribute list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES = eINSTANCE.getDoubleOffsetSequence_OffsetValues();

        /**
         * The meta object literal for the '
         * <em><b>Double Offset Type Double Offset Sequence</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE = eINSTANCE
                .getDoubleOffsetSequence_DoubleOffsetType__DoubleOffsetSequence();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.SoftwareFailureTypesParameterImpl
         * <em>Software Failure Types Parameter</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.SoftwareFailureTypesParameterImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getSoftwareFailureTypesParameter()
         * @generated
         */
        EClass SOFTWARE_FAILURE_TYPES_PARAMETER = eINSTANCE.getSoftwareFailureTypesParameter();

        /**
         * The meta object literal for the '
         * <em><b>Software Induced Failure Types Software Failure Type Reliability Parameter</b></em>
         * ' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOFTWARE_FAILURE_TYPES_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPES_SOFTWARE_FAILURE_TYPE_RELIABILITY_PARAMETER = eINSTANCE
                .getSoftwareFailureTypesParameter_SoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.FailureTypeResultSpecificationImpl
         * <em>Failure Type Result Specification</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.FailureTypeResultSpecificationImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getFailureTypeResultSpecification()
         * @generated
         */
        EClass FAILURE_TYPE_RESULT_SPECIFICATION = eINSTANCE.getFailureTypeResultSpecification();

        /**
         * The meta object literal for the '
         * <em><b>Failure Types Failure Type Result Specification</b></em>' reference list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION = eINSTANCE
                .getFailureTypeResultSpecification_FailureTypes__FailureTypeResultSpecification();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.sensitivity.impl.FailureDimensionResultSpecificationImpl
         * <em>Failure Dimension Result Specification</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.impl.FailureDimensionResultSpecificationImpl
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getFailureDimensionResultSpecification()
         * @generated
         */
        EClass FAILURE_DIMENSION_RESULT_SPECIFICATION = eINSTANCE.getFailureDimensionResultSpecification();

        /**
         * The meta object literal for the '
         * <em><b>Failure Dimension Failure Dimension Result Specification</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION = eINSTANCE
                .getFailureDimensionResultSpecification_FailureDimension__FailureDimensionResultSpecification();

        /**
         * The meta object literal for the '{@link de.uka.ipd.sdq.sensitivity.VariableUsageType
         * <em>Variable Usage Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.VariableUsageType
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getVariableUsageType()
         * @generated
         */
        EEnum VARIABLE_USAGE_TYPE = eINSTANCE.getVariableUsageType();

        /**
         * The meta object literal for the '{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetType
         * <em>Double Offset Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetType
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getDoubleOffsetType()
         * @generated
         */
        EEnum DOUBLE_OFFSET_TYPE = eINSTANCE.getDoubleOffsetType();

        /**
         * The meta object literal for the '{@link de.uka.ipd.sdq.sensitivity.FailureDimension
         * <em>Failure Dimension</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.sensitivity.FailureDimension
         * @see de.uka.ipd.sdq.sensitivity.impl.SensitivityPackageImpl#getFailureDimension()
         * @generated
         */
        EEnum FAILURE_DIMENSION = eINSTANCE.getFailureDimension();

    }

} // SensitivityPackage
