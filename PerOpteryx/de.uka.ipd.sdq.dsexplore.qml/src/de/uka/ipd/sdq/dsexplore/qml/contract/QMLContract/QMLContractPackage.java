/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractFactory
 * @model kind="package"
 * @generated
 */
public interface QMLContractPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "QMLContract";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///QMLContract.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "QMLContract";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QMLContractPackage eINSTANCE = de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GenericQMLContractImpl <em>Generic QML Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GenericQMLContractImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getGenericQMLContract()
	 * @generated
	 */
	int GENERIC_QML_CONTRACT = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_QML_CONTRACT__ID = QMLDeclarationsPackage.QML_DECLARATION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_QML_CONTRACT__ENTITY_NAME = QMLDeclarationsPackage.QML_DECLARATION__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>Generic QML Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_QML_CONTRACT_FEATURE_COUNT = QMLDeclarationsPackage.QML_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SimpleQMLContractImpl <em>Simple QML Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SimpleQMLContractImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getSimpleQMLContract()
	 * @generated
	 */
	int SIMPLE_QML_CONTRACT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QML_CONTRACT__ID = GENERIC_QML_CONTRACT__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QML_CONTRACT__ENTITY_NAME = GENERIC_QML_CONTRACT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QML_CONTRACT__CRITERIA = GENERIC_QML_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contract Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QML_CONTRACT__CONTRACT_TYPE = GENERIC_QML_CONTRACT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple QML Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_QML_CONTRACT_FEATURE_COUNT = GENERIC_QML_CONTRACT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.CriterionImpl <em>Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.CriterionImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getCriterion()
	 * @generated
	 */
	int CRITERION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__DIMENSION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__ASPECTS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EvaluationAspectImpl <em>Evaluation Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EvaluationAspectImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEvaluationAspect()
	 * @generated
	 */
	int EVALUATION_ASPECT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_ASPECT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_ASPECT__ASPECT_REQUIREMENT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Evaluation Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_ASPECT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.AspectRequirementImpl <em>Aspect Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.AspectRequirementImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getAspectRequirement()
	 * @generated
	 */
	int ASPECT_REQUIREMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_REQUIREMENT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aspect Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_REQUIREMENT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueLiteralImpl <em>Value Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueLiteralImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getValueLiteral()
	 * @generated
	 */
	int VALUE_LITERAL = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_LITERAL__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Value Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_LITERAL_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.StochasticEvaluationAspectImpl <em>Stochastic Evaluation Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.StochasticEvaluationAspectImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getStochasticEvaluationAspect()
	 * @generated
	 */
	int STOCHASTIC_EVALUATION_ASPECT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_EVALUATION_ASPECT__ID = EVALUATION_ASPECT__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_EVALUATION_ASPECT__ASPECT_REQUIREMENT = EVALUATION_ASPECT__ASPECT_REQUIREMENT;

	/**
	 * The number of structural features of the '<em>Stochastic Evaluation Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_EVALUATION_ASPECT_FEATURE_COUNT = EVALUATION_ASPECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PointEstimatorImpl <em>Point Estimator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PointEstimatorImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getPointEstimator()
	 * @generated
	 */
	int POINT_ESTIMATOR = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_ESTIMATOR__ID = STOCHASTIC_EVALUATION_ASPECT__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_ESTIMATOR__ASPECT_REQUIREMENT = STOCHASTIC_EVALUATION_ASPECT__ASPECT_REQUIREMENT;

	/**
	 * The number of structural features of the '<em>Point Estimator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_ESTIMATOR_FEATURE_COUNT = STOCHASTIC_EVALUATION_ASPECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PercentileImpl <em>Percentile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PercentileImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getPercentile()
	 * @generated
	 */
	int PERCENTILE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTILE__ID = POINT_ESTIMATOR__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTILE__ASPECT_REQUIREMENT = POINT_ESTIMATOR__ASPECT_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Percentile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTILE__PERCENTILE = POINT_ESTIMATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Percentile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTILE_FEATURE_COUNT = POINT_ESTIMATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.FrequencyImpl <em>Frequency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.FrequencyImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getFrequency()
	 * @generated
	 */
	int FREQUENCY = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY__ID = STOCHASTIC_EVALUATION_ASPECT__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY__ASPECT_REQUIREMENT = STOCHASTIC_EVALUATION_ASPECT__ASPECT_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Upper Limit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY__UPPER_LIMIT = STOCHASTIC_EVALUATION_ASPECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Limit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY__LOWER_LIMIT = STOCHASTIC_EVALUATION_ASPECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Frequency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_FEATURE_COUNT = STOCHASTIC_EVALUATION_ASPECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RangeValueImpl <em>Range Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RangeValueImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getRangeValue()
	 * @generated
	 */
	int RANGE_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Range Limit Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__RANGE_LIMIT_LITERAL = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__TYPE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.MeanImpl <em>Mean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.MeanImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getMean()
	 * @generated
	 */
	int MEAN = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEAN__ID = POINT_ESTIMATOR__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEAN__ASPECT_REQUIREMENT = POINT_ESTIMATOR__ASPECT_REQUIREMENT;

	/**
	 * The number of structural features of the '<em>Mean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEAN_FEATURE_COUNT = POINT_ESTIMATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.VarianceImpl <em>Variance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.VarianceImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getVariance()
	 * @generated
	 */
	int VARIANCE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANCE__ID = POINT_ESTIMATOR__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANCE__ASPECT_REQUIREMENT = POINT_ESTIMATOR__ASPECT_REQUIREMENT;

	/**
	 * The number of structural features of the '<em>Variance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANCE_FEATURE_COUNT = POINT_ESTIMATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.NumericLiteralImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getNumericLiteral()
	 * @generated
	 */
	int NUMERIC_LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__ID = VALUE_LITERAL__ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__VALUE = VALUE_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_FEATURE_COUNT = VALUE_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EnumLiteralImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__ID = VALUE_LITERAL__ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__VALUE = VALUE_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_FEATURE_COUNT = VALUE_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SetLiteralImpl <em>Set Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SetLiteralImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getSetLiteral()
	 * @generated
	 */
	int SET_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_LITERAL__ID = VALUE_LITERAL__ID;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_LITERAL__VALUES = VALUE_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_LITERAL_FEATURE_COUNT = VALUE_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RefinedQMLContractImpl <em>Refined QML Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RefinedQMLContractImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getRefinedQMLContract()
	 * @generated
	 */
	int REFINED_QML_CONTRACT = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINED_QML_CONTRACT__ID = GENERIC_QML_CONTRACT__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINED_QML_CONTRACT__ENTITY_NAME = GENERIC_QML_CONTRACT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINED_QML_CONTRACT__REFINED_BY = GENERIC_QML_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Contract</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINED_QML_CONTRACT__BASE_CONTRACT = GENERIC_QML_CONTRACT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Refined QML Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINED_QML_CONTRACT_FEATURE_COUNT = GENERIC_QML_CONTRACT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.DeterministicEvaluationAspectImpl <em>Deterministic Evaluation Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.DeterministicEvaluationAspectImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getDeterministicEvaluationAspect()
	 * @generated
	 */
	int DETERMINISTIC_EVALUATION_ASPECT = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_EVALUATION_ASPECT__ID = EVALUATION_ASPECT__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_EVALUATION_ASPECT__ASPECT_REQUIREMENT = EVALUATION_ASPECT__ASPECT_REQUIREMENT;

	/**
	 * The number of structural features of the '<em>Deterministic Evaluation Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_EVALUATION_ASPECT_FEATURE_COUNT = EVALUATION_ASPECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__ID = DETERMINISTIC_EVALUATION_ASPECT__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__ASPECT_REQUIREMENT = DETERMINISTIC_EVALUATION_ASPECT__ASPECT_REQUIREMENT;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = DETERMINISTIC_EVALUATION_ASPECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ObjectiveImpl <em>Objective</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ObjectiveImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getObjective()
	 * @generated
	 */
	int OBJECTIVE = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__ID = CRITERION__ID;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__DIMENSION = CRITERION__DIMENSION;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__ASPECTS = CRITERION__ASPECTS;

	/**
	 * The number of structural features of the '<em>Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_FEATURE_COUNT = CRITERION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ConstraintImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ID = CRITERION__ID;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DIMENSION = CRITERION__DIMENSION;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ASPECTS = CRITERION__ASPECTS;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = CRITERION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RestrictionImpl <em>Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RestrictionImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getRestriction()
	 * @generated
	 */
	int RESTRICTION = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTION__ID = ASPECT_REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTION__ASPECT_REQUIREMENT_LITERAL = ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTION__OPERATOR = ASPECT_REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTION_FEATURE_COUNT = ASPECT_REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GoalImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ID = ASPECT_REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Aspect Requirement Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ASPECT_REQUIREMENT_LITERAL = ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = ASPECT_REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumOperator <em>Enum Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumOperator
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEnumOperator()
	 * @generated
	 */
	int ENUM_OPERATOR = 23;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType <em>Enum Range Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEnumRangeValueType()
	 * @generated
	 */
	int ENUM_RANGE_VALUE_TYPE = 24;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract <em>Simple QML Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple QML Contract</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract
	 * @generated
	 */
	EClass getSimpleQMLContract();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract#getCriteria <em>Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Criteria</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract#getCriteria()
	 * @see #getSimpleQMLContract()
	 * @generated
	 */
	EReference getSimpleQMLContract_Criteria();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract#getContractType <em>Contract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contract Type</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract#getContractType()
	 * @see #getSimpleQMLContract()
	 * @generated
	 */
	EReference getSimpleQMLContract_ContractType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion <em>Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criterion</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion
	 * @generated
	 */
	EClass getCriterion();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dimension</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion#getDimension()
	 * @see #getCriterion()
	 * @generated
	 */
	EReference getCriterion_Dimension();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion#getAspects()
	 * @see #getCriterion()
	 * @generated
	 */
	EReference getCriterion_Aspects();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect <em>Evaluation Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Aspect</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect
	 * @generated
	 */
	EClass getEvaluationAspect();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect#getAspectRequirement <em>Aspect Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aspect Requirement</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect#getAspectRequirement()
	 * @see #getEvaluationAspect()
	 * @generated
	 */
	EReference getEvaluationAspect_AspectRequirement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.AspectRequirement <em>Aspect Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect Requirement</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.AspectRequirement
	 * @generated
	 */
	EClass getAspectRequirement();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.AspectRequirement#getAspectRequirementLiteral <em>Aspect Requirement Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aspect Requirement Literal</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.AspectRequirement#getAspectRequirementLiteral()
	 * @see #getAspectRequirement()
	 * @generated
	 */
	EReference getAspectRequirement_AspectRequirementLiteral();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.ValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Literal</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.ValueLiteral
	 * @generated
	 */
	EClass getValueLiteral();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile <em>Percentile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Percentile</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile
	 * @generated
	 */
	EClass getPercentile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile#getPercentile <em>Percentile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentile</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile#getPercentile()
	 * @see #getPercentile()
	 * @generated
	 */
	EAttribute getPercentile_Percentile();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.PointEstimator <em>Point Estimator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Estimator</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.PointEstimator
	 * @generated
	 */
	EClass getPointEstimator();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.StochasticEvaluationAspect <em>Stochastic Evaluation Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Evaluation Aspect</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.StochasticEvaluationAspect
	 * @generated
	 */
	EClass getStochasticEvaluationAspect();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Frequency</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency
	 * @generated
	 */
	EClass getFrequency();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getUpperLimit <em>Upper Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Upper Limit</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getUpperLimit()
	 * @see #getFrequency()
	 * @generated
	 */
	EReference getFrequency_UpperLimit();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getLowerLimit <em>Lower Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lower Limit</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getLowerLimit()
	 * @see #getFrequency()
	 * @generated
	 */
	EReference getFrequency_LowerLimit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue <em>Range Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Value</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue
	 * @generated
	 */
	EClass getRangeValue();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getRangeLimitLiteral <em>Range Limit Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Range Limit Literal</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getRangeLimitLiteral()
	 * @see #getRangeValue()
	 * @generated
	 */
	EReference getRangeValue_RangeLimitLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue#getType()
	 * @see #getRangeValue()
	 * @generated
	 */
	EAttribute getRangeValue_Type();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Mean <em>Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mean</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Mean
	 * @generated
	 */
	EClass getMean();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Variance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variance</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Variance
	 * @generated
	 */
	EClass getVariance();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral
	 * @generated
	 */
	EClass getNumericLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral#getValue()
	 * @see #getNumericLiteral()
	 * @generated
	 */
	EAttribute getNumericLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumLiteral
	 * @generated
	 */
	EClass getEnumLiteral();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumLiteral#getValue()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EReference getEnumLiteral_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral <em>Set Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Literal</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral
	 * @generated
	 */
	EClass getSetLiteral();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral#getValues()
	 * @see #getSetLiteral()
	 * @generated
	 */
	EReference getSetLiteral_Values();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract <em>Refined QML Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refined QML Contract</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract
	 * @generated
	 */
	EClass getRefinedQMLContract();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract#getRefinedBy <em>Refined By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refined By</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract#getRefinedBy()
	 * @see #getRefinedQMLContract()
	 * @generated
	 */
	EReference getRefinedQMLContract_RefinedBy();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract#getBaseContract <em>Base Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Contract</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract#getBaseContract()
	 * @see #getRefinedQMLContract()
	 * @generated
	 */
	EReference getRefinedQMLContract_BaseContract();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.DeterministicEvaluationAspect <em>Deterministic Evaluation Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deterministic Evaluation Aspect</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.DeterministicEvaluationAspect
	 * @generated
	 */
	EClass getDeterministicEvaluationAspect();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objective</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Objective
	 * @generated
	 */
	EClass getObjective();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Restriction <em>Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restriction</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Restriction
	 * @generated
	 */
	EClass getRestriction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Restriction#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Restriction#getOperator()
	 * @see #getRestriction()
	 * @generated
	 */
	EAttribute getRestriction_Operator();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.GenericQMLContract <em>Generic QML Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic QML Contract</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.GenericQMLContract
	 * @generated
	 */
	EClass getGenericQMLContract();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumOperator <em>Enum Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum Operator</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumOperator
	 * @generated
	 */
	EEnum getEnumOperator();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType <em>Enum Range Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum Range Value Type</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType
	 * @generated
	 */
	EEnum getEnumRangeValueType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QMLContractFactory getQMLContractFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SimpleQMLContractImpl <em>Simple QML Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SimpleQMLContractImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getSimpleQMLContract()
		 * @generated
		 */
		EClass SIMPLE_QML_CONTRACT = eINSTANCE.getSimpleQMLContract();

		/**
		 * The meta object literal for the '<em><b>Criteria</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_QML_CONTRACT__CRITERIA = eINSTANCE.getSimpleQMLContract_Criteria();

		/**
		 * The meta object literal for the '<em><b>Contract Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_QML_CONTRACT__CONTRACT_TYPE = eINSTANCE.getSimpleQMLContract_ContractType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.CriterionImpl <em>Criterion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.CriterionImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getCriterion()
		 * @generated
		 */
		EClass CRITERION = eINSTANCE.getCriterion();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERION__DIMENSION = eINSTANCE.getCriterion_Dimension();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERION__ASPECTS = eINSTANCE.getCriterion_Aspects();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EvaluationAspectImpl <em>Evaluation Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EvaluationAspectImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEvaluationAspect()
		 * @generated
		 */
		EClass EVALUATION_ASPECT = eINSTANCE.getEvaluationAspect();

		/**
		 * The meta object literal for the '<em><b>Aspect Requirement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVALUATION_ASPECT__ASPECT_REQUIREMENT = eINSTANCE.getEvaluationAspect_AspectRequirement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.AspectRequirementImpl <em>Aspect Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.AspectRequirementImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getAspectRequirement()
		 * @generated
		 */
		EClass ASPECT_REQUIREMENT = eINSTANCE.getAspectRequirement();

		/**
		 * The meta object literal for the '<em><b>Aspect Requirement Literal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT_REQUIREMENT__ASPECT_REQUIREMENT_LITERAL = eINSTANCE.getAspectRequirement_AspectRequirementLiteral();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueLiteralImpl <em>Value Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueLiteralImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getValueLiteral()
		 * @generated
		 */
		EClass VALUE_LITERAL = eINSTANCE.getValueLiteral();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PercentileImpl <em>Percentile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PercentileImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getPercentile()
		 * @generated
		 */
		EClass PERCENTILE = eINSTANCE.getPercentile();

		/**
		 * The meta object literal for the '<em><b>Percentile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERCENTILE__PERCENTILE = eINSTANCE.getPercentile_Percentile();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PointEstimatorImpl <em>Point Estimator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.PointEstimatorImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getPointEstimator()
		 * @generated
		 */
		EClass POINT_ESTIMATOR = eINSTANCE.getPointEstimator();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.StochasticEvaluationAspectImpl <em>Stochastic Evaluation Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.StochasticEvaluationAspectImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getStochasticEvaluationAspect()
		 * @generated
		 */
		EClass STOCHASTIC_EVALUATION_ASPECT = eINSTANCE.getStochasticEvaluationAspect();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.FrequencyImpl <em>Frequency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.FrequencyImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getFrequency()
		 * @generated
		 */
		EClass FREQUENCY = eINSTANCE.getFrequency();

		/**
		 * The meta object literal for the '<em><b>Upper Limit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREQUENCY__UPPER_LIMIT = eINSTANCE.getFrequency_UpperLimit();

		/**
		 * The meta object literal for the '<em><b>Lower Limit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREQUENCY__LOWER_LIMIT = eINSTANCE.getFrequency_LowerLimit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RangeValueImpl <em>Range Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RangeValueImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getRangeValue()
		 * @generated
		 */
		EClass RANGE_VALUE = eINSTANCE.getRangeValue();

		/**
		 * The meta object literal for the '<em><b>Range Limit Literal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_VALUE__RANGE_LIMIT_LITERAL = eINSTANCE.getRangeValue_RangeLimitLiteral();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_VALUE__TYPE = eINSTANCE.getRangeValue_Type();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.MeanImpl <em>Mean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.MeanImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getMean()
		 * @generated
		 */
		EClass MEAN = eINSTANCE.getMean();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.VarianceImpl <em>Variance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.VarianceImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getVariance()
		 * @generated
		 */
		EClass VARIANCE = eINSTANCE.getVariance();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.NumericLiteralImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getNumericLiteral()
		 * @generated
		 */
		EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_LITERAL__VALUE = eINSTANCE.getNumericLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.EnumLiteralImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEnumLiteral()
		 * @generated
		 */
		EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL__VALUE = eINSTANCE.getEnumLiteral_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SetLiteralImpl <em>Set Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SetLiteralImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getSetLiteral()
		 * @generated
		 */
		EClass SET_LITERAL = eINSTANCE.getSetLiteral();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_LITERAL__VALUES = eINSTANCE.getSetLiteral_Values();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RefinedQMLContractImpl <em>Refined QML Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RefinedQMLContractImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getRefinedQMLContract()
		 * @generated
		 */
		EClass REFINED_QML_CONTRACT = eINSTANCE.getRefinedQMLContract();

		/**
		 * The meta object literal for the '<em><b>Refined By</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFINED_QML_CONTRACT__REFINED_BY = eINSTANCE.getRefinedQMLContract_RefinedBy();

		/**
		 * The meta object literal for the '<em><b>Base Contract</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFINED_QML_CONTRACT__BASE_CONTRACT = eINSTANCE.getRefinedQMLContract_BaseContract();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ValueImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.DeterministicEvaluationAspectImpl <em>Deterministic Evaluation Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.DeterministicEvaluationAspectImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getDeterministicEvaluationAspect()
		 * @generated
		 */
		EClass DETERMINISTIC_EVALUATION_ASPECT = eINSTANCE.getDeterministicEvaluationAspect();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ObjectiveImpl <em>Objective</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ObjectiveImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getObjective()
		 * @generated
		 */
		EClass OBJECTIVE = eINSTANCE.getObjective();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.ConstraintImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RestrictionImpl <em>Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.RestrictionImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getRestriction()
		 * @generated
		 */
		EClass RESTRICTION = eINSTANCE.getRestriction();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESTRICTION__OPERATOR = eINSTANCE.getRestriction_Operator();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GoalImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GenericQMLContractImpl <em>Generic QML Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.GenericQMLContractImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getGenericQMLContract()
		 * @generated
		 */
		EClass GENERIC_QML_CONTRACT = eINSTANCE.getGenericQMLContract();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumOperator <em>Enum Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumOperator
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEnumOperator()
		 * @generated
		 */
		EEnum ENUM_OPERATOR = eINSTANCE.getEnumOperator();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType <em>Enum Range Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumRangeValueType
		 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl#getEnumRangeValueType()
		 * @generated
		 */
		EEnum ENUM_RANGE_VALUE_TYPE = eINSTANCE.getEnumRangeValueType();

	}

} //QMLContractPackage
