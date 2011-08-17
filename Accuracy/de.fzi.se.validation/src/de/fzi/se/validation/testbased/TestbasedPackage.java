/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;

import de.fzi.se.quality.QualityPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.fzi.se.validation.testbased.TestbasedFactory
 * @model kind="package"
 * @generated
 */
public interface TestbasedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testbased";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fzi.de/PalladioComponentModel/Validation/TestBased/0.2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testbased";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestbasedPackage eINSTANCE = de.fzi.se.validation.testbased.impl.TestbasedPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.TBValidationQualityImpl <em>TB Validation Quality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.TBValidationQualityImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getTBValidationQuality()
	 * @generated
	 */
	int TB_VALIDATION_QUALITY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY__ID = QualityPackage.QUALITY_STATEMENT__ID;

	/**
	 * The feature id for the '<em><b>Quality Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY__QUALITY_REPOSITORY = QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY;

	/**
	 * The feature id for the '<em><b>Stop Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY__STOP_STRATEGY = QualityPackage.QUALITY_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generation Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY__GENERATION_STRATEGY = QualityPackage.QUALITY_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Internal State Influence Analysis Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY = QualityPackage.QUALITY_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Quality Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS = QualityPackage.QUALITY_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Internal State Influence Analysis Aggregation Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS = QualityPackage.QUALITY_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>TB Validation Quality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TB_VALIDATION_QUALITY_FEATURE_COUNT = QualityPackage.QUALITY_STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.TestcaseExecutionStopStrategyImpl <em>Testcase Execution Stop Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.TestcaseExecutionStopStrategyImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getTestcaseExecutionStopStrategy()
	 * @generated
	 */
	int TESTCASE_EXECUTION_STOP_STRATEGY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_EXECUTION_STOP_STRATEGY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_EXECUTION_STOP_STRATEGY__VALIDATION_QUALITY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Testcase Execution Stop Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_EXECUTION_STOP_STRATEGY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.TestcaseGenerationStrategyImpl <em>Testcase Generation Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.TestcaseGenerationStrategyImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getTestcaseGenerationStrategy()
	 * @generated
	 */
	int TESTCASE_GENERATION_STRATEGY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_GENERATION_STRATEGY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Testcase Generation Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_GENERATION_STRATEGY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.InternalStateInfluenceAnalysisStrategyImpl <em>Internal State Influence Analysis Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.InternalStateInfluenceAnalysisStrategyImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getInternalStateInfluenceAnalysisStrategy()
	 * @generated
	 */
	int INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY = 3;

	/**
	 * The feature id for the '<em><b>Tb Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY = 0;

	/**
	 * The number of structural features of the '<em>Internal State Influence Analysis Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.EquidistantPartitionsRandomImpl <em>Equidistant Partitions Random</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.EquidistantPartitionsRandomImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getEquidistantPartitionsRandom()
	 * @generated
	 */
	int EQUIDISTANT_PARTITIONS_RANDOM = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIDISTANT_PARTITIONS_RANDOM__ID = TESTCASE_GENERATION_STRATEGY__ID;

	/**
	 * The feature id for the '<em><b>Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIDISTANT_PARTITIONS_RANDOM__VALIDATION_QUALITY = TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY;

	/**
	 * The feature id for the '<em><b>Number Partitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS = TESTCASE_GENERATION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Equidistant Partitions Random</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIDISTANT_PARTITIONS_RANDOM_FEATURE_COUNT = TESTCASE_GENERATION_STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.NumberTestcasesImpl <em>Number Testcases</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.NumberTestcasesImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getNumberTestcases()
	 * @generated
	 */
	int NUMBER_TESTCASES = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_TESTCASES__ID = TESTCASE_EXECUTION_STOP_STRATEGY__ID;

	/**
	 * The feature id for the '<em><b>Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_TESTCASES__VALIDATION_QUALITY = TESTCASE_EXECUTION_STOP_STRATEGY__VALIDATION_QUALITY;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_TESTCASES__MINIMUM = TESTCASE_EXECUTION_STOP_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Testcases</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_TESTCASES_FEATURE_COUNT = TESTCASE_EXECUTION_STOP_STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.NumberGenerationRunsImpl <em>Number Generation Runs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.NumberGenerationRunsImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getNumberGenerationRuns()
	 * @generated
	 */
	int NUMBER_GENERATION_RUNS = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_GENERATION_RUNS__ID = TESTCASE_EXECUTION_STOP_STRATEGY__ID;

	/**
	 * The feature id for the '<em><b>Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_GENERATION_RUNS__VALIDATION_QUALITY = TESTCASE_EXECUTION_STOP_STRATEGY__VALIDATION_QUALITY;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_GENERATION_RUNS__NUMBER = TESTCASE_EXECUTION_STOP_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Generation Runs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_GENERATION_RUNS_FEATURE_COUNT = TESTCASE_EXECUTION_STOP_STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.NoISIAImpl <em>No ISIA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.NoISIAImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getNoISIA()
	 * @generated
	 */
	int NO_ISIA = 7;

	/**
	 * The feature id for the '<em><b>Tb Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ISIA__TB_VALIDATION_QUALITY = INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY;

	/**
	 * The number of structural features of the '<em>No ISIA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ISIA_FEATURE_COUNT = INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.impl.ReuseInstanceISIAImpl <em>Reuse Instance ISIA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.impl.ReuseInstanceISIAImpl
	 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getReuseInstanceISIA()
	 * @generated
	 */
	int REUSE_INSTANCE_ISIA = 8;

	/**
	 * The feature id for the '<em><b>Tb Validation Quality</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REUSE_INSTANCE_ISIA__TB_VALIDATION_QUALITY = INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY;

	/**
	 * The number of structural features of the '<em>Reuse Instance ISIA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REUSE_INSTANCE_ISIA_FEATURE_COUNT = INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.TBValidationQuality <em>TB Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TB Validation Quality</em>'.
	 * @see de.fzi.se.validation.testbased.TBValidationQuality
	 * @generated
	 */
	EClass getTBValidationQuality();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.TBValidationQuality#getStopStrategy <em>Stop Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stop Strategy</em>'.
	 * @see de.fzi.se.validation.testbased.TBValidationQuality#getStopStrategy()
	 * @see #getTBValidationQuality()
	 * @generated
	 */
	EReference getTBValidationQuality_StopStrategy();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.TBValidationQuality#getGenerationStrategy <em>Generation Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Generation Strategy</em>'.
	 * @see de.fzi.se.validation.testbased.TBValidationQuality#getGenerationStrategy()
	 * @see #getTBValidationQuality()
	 * @generated
	 */
	EReference getTBValidationQuality_GenerationStrategy();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisStrategy <em>Internal State Influence Analysis Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Internal State Influence Analysis Strategy</em>'.
	 * @see de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisStrategy()
	 * @see #getTBValidationQuality()
	 * @generated
	 */
	EReference getTBValidationQuality_InternalStateInfluenceAnalysisStrategy();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.se.validation.testbased.TBValidationQuality#getQualityAnnotations <em>Quality Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Quality Annotations</em>'.
	 * @see de.fzi.se.validation.testbased.TBValidationQuality#getQualityAnnotations()
	 * @see #getTBValidationQuality()
	 * @generated
	 */
	EReference getTBValidationQuality_QualityAnnotations();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisAggregationResults <em>Internal State Influence Analysis Aggregation Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Internal State Influence Analysis Aggregation Results</em>'.
	 * @see de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisAggregationResults()
	 * @see #getTBValidationQuality()
	 * @generated
	 */
	EReference getTBValidationQuality_InternalStateInfluenceAnalysisAggregationResults();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy <em>Testcase Execution Stop Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Testcase Execution Stop Strategy</em>'.
	 * @see de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy
	 * @generated
	 */
	EClass getTestcaseExecutionStopStrategy();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy#getValidationQuality <em>Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Validation Quality</em>'.
	 * @see de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy#getValidationQuality()
	 * @see #getTestcaseExecutionStopStrategy()
	 * @generated
	 */
	EReference getTestcaseExecutionStopStrategy_ValidationQuality();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.TestcaseGenerationStrategy <em>Testcase Generation Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Testcase Generation Strategy</em>'.
	 * @see de.fzi.se.validation.testbased.TestcaseGenerationStrategy
	 * @generated
	 */
	EClass getTestcaseGenerationStrategy();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.validation.testbased.TestcaseGenerationStrategy#getValidationQuality <em>Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Validation Quality</em>'.
	 * @see de.fzi.se.validation.testbased.TestcaseGenerationStrategy#getValidationQuality()
	 * @see #getTestcaseGenerationStrategy()
	 * @generated
	 */
	EReference getTestcaseGenerationStrategy_ValidationQuality();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy <em>Internal State Influence Analysis Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal State Influence Analysis Strategy</em>'.
	 * @see de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy
	 * @generated
	 */
	EClass getInternalStateInfluenceAnalysisStrategy();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy#getTbValidationQuality <em>Tb Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tb Validation Quality</em>'.
	 * @see de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy#getTbValidationQuality()
	 * @see #getInternalStateInfluenceAnalysisStrategy()
	 * @generated
	 */
	EReference getInternalStateInfluenceAnalysisStrategy_TbValidationQuality();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.EquidistantPartitionsRandom <em>Equidistant Partitions Random</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equidistant Partitions Random</em>'.
	 * @see de.fzi.se.validation.testbased.EquidistantPartitionsRandom
	 * @generated
	 */
	EClass getEquidistantPartitionsRandom();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.testbased.EquidistantPartitionsRandom#getNumberPartitions <em>Number Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Partitions</em>'.
	 * @see de.fzi.se.validation.testbased.EquidistantPartitionsRandom#getNumberPartitions()
	 * @see #getEquidistantPartitionsRandom()
	 * @generated
	 */
	EAttribute getEquidistantPartitionsRandom_NumberPartitions();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.NumberTestcases <em>Number Testcases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Testcases</em>'.
	 * @see de.fzi.se.validation.testbased.NumberTestcases
	 * @generated
	 */
	EClass getNumberTestcases();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.testbased.NumberTestcases#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see de.fzi.se.validation.testbased.NumberTestcases#getMinimum()
	 * @see #getNumberTestcases()
	 * @generated
	 */
	EAttribute getNumberTestcases_Minimum();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.NumberGenerationRuns <em>Number Generation Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Generation Runs</em>'.
	 * @see de.fzi.se.validation.testbased.NumberGenerationRuns
	 * @generated
	 */
	EClass getNumberGenerationRuns();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.testbased.NumberGenerationRuns#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.fzi.se.validation.testbased.NumberGenerationRuns#getNumber()
	 * @see #getNumberGenerationRuns()
	 * @generated
	 */
	EAttribute getNumberGenerationRuns_Number();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.NoISIA <em>No ISIA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No ISIA</em>'.
	 * @see de.fzi.se.validation.testbased.NoISIA
	 * @generated
	 */
	EClass getNoISIA();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.ReuseInstanceISIA <em>Reuse Instance ISIA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reuse Instance ISIA</em>'.
	 * @see de.fzi.se.validation.testbased.ReuseInstanceISIA
	 * @generated
	 */
	EClass getReuseInstanceISIA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestbasedFactory getTestbasedFactory();

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
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.TBValidationQualityImpl <em>TB Validation Quality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.TBValidationQualityImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getTBValidationQuality()
		 * @generated
		 */
		EClass TB_VALIDATION_QUALITY = eINSTANCE.getTBValidationQuality();

		/**
		 * The meta object literal for the '<em><b>Stop Strategy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TB_VALIDATION_QUALITY__STOP_STRATEGY = eINSTANCE.getTBValidationQuality_StopStrategy();

		/**
		 * The meta object literal for the '<em><b>Generation Strategy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TB_VALIDATION_QUALITY__GENERATION_STRATEGY = eINSTANCE.getTBValidationQuality_GenerationStrategy();

		/**
		 * The meta object literal for the '<em><b>Internal State Influence Analysis Strategy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY = eINSTANCE.getTBValidationQuality_InternalStateInfluenceAnalysisStrategy();

		/**
		 * The meta object literal for the '<em><b>Quality Annotations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS = eINSTANCE.getTBValidationQuality_QualityAnnotations();

		/**
		 * The meta object literal for the '<em><b>Internal State Influence Analysis Aggregation Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS = eINSTANCE.getTBValidationQuality_InternalStateInfluenceAnalysisAggregationResults();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.TestcaseExecutionStopStrategyImpl <em>Testcase Execution Stop Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.TestcaseExecutionStopStrategyImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getTestcaseExecutionStopStrategy()
		 * @generated
		 */
		EClass TESTCASE_EXECUTION_STOP_STRATEGY = eINSTANCE.getTestcaseExecutionStopStrategy();

		/**
		 * The meta object literal for the '<em><b>Validation Quality</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTCASE_EXECUTION_STOP_STRATEGY__VALIDATION_QUALITY = eINSTANCE.getTestcaseExecutionStopStrategy_ValidationQuality();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.TestcaseGenerationStrategyImpl <em>Testcase Generation Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.TestcaseGenerationStrategyImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getTestcaseGenerationStrategy()
		 * @generated
		 */
		EClass TESTCASE_GENERATION_STRATEGY = eINSTANCE.getTestcaseGenerationStrategy();

		/**
		 * The meta object literal for the '<em><b>Validation Quality</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY = eINSTANCE.getTestcaseGenerationStrategy_ValidationQuality();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.InternalStateInfluenceAnalysisStrategyImpl <em>Internal State Influence Analysis Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.InternalStateInfluenceAnalysisStrategyImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getInternalStateInfluenceAnalysisStrategy()
		 * @generated
		 */
		EClass INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY = eINSTANCE.getInternalStateInfluenceAnalysisStrategy();

		/**
		 * The meta object literal for the '<em><b>Tb Validation Quality</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY = eINSTANCE.getInternalStateInfluenceAnalysisStrategy_TbValidationQuality();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.EquidistantPartitionsRandomImpl <em>Equidistant Partitions Random</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.EquidistantPartitionsRandomImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getEquidistantPartitionsRandom()
		 * @generated
		 */
		EClass EQUIDISTANT_PARTITIONS_RANDOM = eINSTANCE.getEquidistantPartitionsRandom();

		/**
		 * The meta object literal for the '<em><b>Number Partitions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS = eINSTANCE.getEquidistantPartitionsRandom_NumberPartitions();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.NumberTestcasesImpl <em>Number Testcases</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.NumberTestcasesImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getNumberTestcases()
		 * @generated
		 */
		EClass NUMBER_TESTCASES = eINSTANCE.getNumberTestcases();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_TESTCASES__MINIMUM = eINSTANCE.getNumberTestcases_Minimum();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.NumberGenerationRunsImpl <em>Number Generation Runs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.NumberGenerationRunsImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getNumberGenerationRuns()
		 * @generated
		 */
		EClass NUMBER_GENERATION_RUNS = eINSTANCE.getNumberGenerationRuns();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_GENERATION_RUNS__NUMBER = eINSTANCE.getNumberGenerationRuns_Number();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.NoISIAImpl <em>No ISIA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.NoISIAImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getNoISIA()
		 * @generated
		 */
		EClass NO_ISIA = eINSTANCE.getNoISIA();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.impl.ReuseInstanceISIAImpl <em>Reuse Instance ISIA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.impl.ReuseInstanceISIAImpl
		 * @see de.fzi.se.validation.testbased.impl.TestbasedPackageImpl#getReuseInstanceISIA()
		 * @generated
		 */
		EClass REUSE_INSTANCE_ISIA = eINSTANCE.getReuseInstanceISIA();

	}

} //TestbasedPackage
