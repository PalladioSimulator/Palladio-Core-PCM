/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.impl;

import de.fzi.se.quality.QualityPackage;

import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.validation.testbased.EquidistantPartitionsRandom;
import de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy;
import de.fzi.se.validation.testbased.NoISIA;
import de.fzi.se.validation.testbased.NumberGenerationRuns;
import de.fzi.se.validation.testbased.NumberTestcases;
import de.fzi.se.validation.testbased.ReuseInstanceISIA;
import de.fzi.se.validation.testbased.TBValidationQuality;
import de.fzi.se.validation.testbased.TestbasedFactory;
import de.fzi.se.validation.testbased.TestbasedPackage;
import de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy;
import de.fzi.se.validation.testbased.TestcaseGenerationStrategy;

import de.fzi.se.validation.testbased.results.ResultsPackage;

import de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl;

import de.fzi.se.validation.testbased.trace.TracePackage;

import de.fzi.se.validation.testbased.trace.impl.TracePackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import edu.kit.ipd.sdq.bycounter.input.InputPackage;

import edu.kit.ipd.sdq.bycounter.output.OutputPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestbasedPackageImpl extends EPackageImpl implements TestbasedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tbValidationQualityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testcaseExecutionStopStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testcaseGenerationStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalStateInfluenceAnalysisStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equidistantPartitionsRandomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberTestcasesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberGenerationRunsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noISIAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reuseInstanceISIAEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestbasedPackageImpl() {
		super(eNS_URI, TestbasedFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TestbasedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestbasedPackage init() {
		if (isInited) return (TestbasedPackage)EPackage.Registry.INSTANCE.getEPackage(TestbasedPackage.eNS_URI);

		// Obtain or create and register package
		TestbasedPackageImpl theTestbasedPackage = (TestbasedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestbasedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestbasedPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		OutputPackage.eINSTANCE.eClass();
		InputPackage.eINSTANCE.eClass();
		QualityPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TracePackageImpl theTracePackage = (TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) instanceof TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) : TracePackage.eINSTANCE);
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI) instanceof ResultsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI) : ResultsPackage.eINSTANCE);

		// Create package meta-data objects
		theTestbasedPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theResultsPackage.createPackageContents();

		// Initialize created meta-data
		theTestbasedPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theResultsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestbasedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestbasedPackage.eNS_URI, theTestbasedPackage);
		return theTestbasedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBValidationQuality() {
		return tbValidationQualityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBValidationQuality_StopStrategy() {
		return (EReference)tbValidationQualityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBValidationQuality_GenerationStrategy() {
		return (EReference)tbValidationQualityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBValidationQuality_InternalStateInfluenceAnalysisStrategy() {
		return (EReference)tbValidationQualityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBValidationQuality_QualityAnnotations() {
		return (EReference)tbValidationQualityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBValidationQuality_InternalStateInfluenceAnalysisAggregationResults() {
		return (EReference)tbValidationQualityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestcaseExecutionStopStrategy() {
		return testcaseExecutionStopStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestcaseExecutionStopStrategy_ValidationQuality() {
		return (EReference)testcaseExecutionStopStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestcaseGenerationStrategy() {
		return testcaseGenerationStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestcaseGenerationStrategy_ValidationQuality() {
		return (EReference)testcaseGenerationStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalStateInfluenceAnalysisStrategy() {
		return internalStateInfluenceAnalysisStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalStateInfluenceAnalysisStrategy_TbValidationQuality() {
		return (EReference)internalStateInfluenceAnalysisStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquidistantPartitionsRandom() {
		return equidistantPartitionsRandomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquidistantPartitionsRandom_NumberPartitions() {
		return (EAttribute)equidistantPartitionsRandomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberTestcases() {
		return numberTestcasesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberTestcases_Minimum() {
		return (EAttribute)numberTestcasesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberGenerationRuns() {
		return numberGenerationRunsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberGenerationRuns_Number() {
		return (EAttribute)numberGenerationRunsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoISIA() {
		return noISIAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReuseInstanceISIA() {
		return reuseInstanceISIAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbasedFactory getTestbasedFactory() {
		return (TestbasedFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tbValidationQualityEClass = createEClass(TB_VALIDATION_QUALITY);
		createEReference(tbValidationQualityEClass, TB_VALIDATION_QUALITY__STOP_STRATEGY);
		createEReference(tbValidationQualityEClass, TB_VALIDATION_QUALITY__GENERATION_STRATEGY);
		createEReference(tbValidationQualityEClass, TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY);
		createEReference(tbValidationQualityEClass, TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS);
		createEReference(tbValidationQualityEClass, TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS);

		testcaseExecutionStopStrategyEClass = createEClass(TESTCASE_EXECUTION_STOP_STRATEGY);
		createEReference(testcaseExecutionStopStrategyEClass, TESTCASE_EXECUTION_STOP_STRATEGY__VALIDATION_QUALITY);

		testcaseGenerationStrategyEClass = createEClass(TESTCASE_GENERATION_STRATEGY);
		createEReference(testcaseGenerationStrategyEClass, TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY);

		internalStateInfluenceAnalysisStrategyEClass = createEClass(INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY);
		createEReference(internalStateInfluenceAnalysisStrategyEClass, INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY);

		equidistantPartitionsRandomEClass = createEClass(EQUIDISTANT_PARTITIONS_RANDOM);
		createEAttribute(equidistantPartitionsRandomEClass, EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS);

		numberTestcasesEClass = createEClass(NUMBER_TESTCASES);
		createEAttribute(numberTestcasesEClass, NUMBER_TESTCASES__MINIMUM);

		numberGenerationRunsEClass = createEClass(NUMBER_GENERATION_RUNS);
		createEAttribute(numberGenerationRunsEClass, NUMBER_GENERATION_RUNS__NUMBER);

		noISIAEClass = createEClass(NO_ISIA);

		reuseInstanceISIAEClass = createEClass(REUSE_INSTANCE_ISIA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		ResultsPackage theResultsPackage = (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		QualityPackage theQualityPackage = (QualityPackage)EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		QualityAnnotationPackage theQualityAnnotationPackage = (QualityAnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theTracePackage);
		getESubpackages().add(theResultsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tbValidationQualityEClass.getESuperTypes().add(theQualityPackage.getQualityStatement());
		tbValidationQualityEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		testcaseExecutionStopStrategyEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		testcaseGenerationStrategyEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		equidistantPartitionsRandomEClass.getESuperTypes().add(this.getTestcaseGenerationStrategy());
		numberTestcasesEClass.getESuperTypes().add(this.getTestcaseExecutionStopStrategy());
		numberGenerationRunsEClass.getESuperTypes().add(this.getTestcaseExecutionStopStrategy());
		noISIAEClass.getESuperTypes().add(this.getInternalStateInfluenceAnalysisStrategy());
		reuseInstanceISIAEClass.getESuperTypes().add(this.getInternalStateInfluenceAnalysisStrategy());

		// Initialize classes and features; add operations and parameters
		initEClass(tbValidationQualityEClass, TBValidationQuality.class, "TBValidationQuality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTBValidationQuality_StopStrategy(), this.getTestcaseExecutionStopStrategy(), this.getTestcaseExecutionStopStrategy_ValidationQuality(), "stopStrategy", null, 1, 1, TBValidationQuality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTBValidationQuality_GenerationStrategy(), this.getTestcaseGenerationStrategy(), this.getTestcaseGenerationStrategy_ValidationQuality(), "generationStrategy", null, 1, 1, TBValidationQuality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTBValidationQuality_InternalStateInfluenceAnalysisStrategy(), this.getInternalStateInfluenceAnalysisStrategy(), this.getInternalStateInfluenceAnalysisStrategy_TbValidationQuality(), "internalStateInfluenceAnalysisStrategy", null, 1, 1, TBValidationQuality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTBValidationQuality_QualityAnnotations(), theQualityAnnotationPackage.getQualityAnnotation(), null, "qualityAnnotations", null, 0, -1, TBValidationQuality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTBValidationQuality_InternalStateInfluenceAnalysisAggregationResults(), theQualityAnnotationPackage.getInternalStateInfluenceAnalysisAggregation(), null, "internalStateInfluenceAnalysisAggregationResults", null, 0, -1, TBValidationQuality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(testcaseExecutionStopStrategyEClass, TestcaseExecutionStopStrategy.class, "TestcaseExecutionStopStrategy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestcaseExecutionStopStrategy_ValidationQuality(), this.getTBValidationQuality(), this.getTBValidationQuality_StopStrategy(), "validationQuality", null, 1, 1, TestcaseExecutionStopStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(testcaseGenerationStrategyEClass, TestcaseGenerationStrategy.class, "TestcaseGenerationStrategy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestcaseGenerationStrategy_ValidationQuality(), this.getTBValidationQuality(), this.getTBValidationQuality_GenerationStrategy(), "validationQuality", null, 1, 1, TestcaseGenerationStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(internalStateInfluenceAnalysisStrategyEClass, InternalStateInfluenceAnalysisStrategy.class, "InternalStateInfluenceAnalysisStrategy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalStateInfluenceAnalysisStrategy_TbValidationQuality(), this.getTBValidationQuality(), this.getTBValidationQuality_InternalStateInfluenceAnalysisStrategy(), "tbValidationQuality", null, 1, 1, InternalStateInfluenceAnalysisStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(equidistantPartitionsRandomEClass, EquidistantPartitionsRandom.class, "EquidistantPartitionsRandom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquidistantPartitionsRandom_NumberPartitions(), ecorePackage.getELong(), "numberPartitions", null, 1, 1, EquidistantPartitionsRandom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(numberTestcasesEClass, NumberTestcases.class, "NumberTestcases", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumberTestcases_Minimum(), ecorePackage.getELong(), "minimum", null, 1, 1, NumberTestcases.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(numberGenerationRunsEClass, NumberGenerationRuns.class, "NumberGenerationRuns", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumberGenerationRuns_Number(), ecorePackage.getELong(), "number", null, 1, 1, NumberGenerationRuns.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(noISIAEClass, NoISIA.class, "NoISIA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reuseInstanceISIAEClass, ReuseInstanceISIA.class, "ReuseInstanceISIA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TestbasedPackageImpl
