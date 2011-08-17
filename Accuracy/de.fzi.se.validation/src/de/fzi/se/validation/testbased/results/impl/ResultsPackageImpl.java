/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.impl;

import de.fzi.se.quality.QualityPackage;

import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.validation.testbased.TestbasedPackage;

import de.fzi.se.validation.testbased.impl.TestbasedPackageImpl;

import de.fzi.se.validation.testbased.results.ExecutionTraceVFN;
import de.fzi.se.validation.testbased.results.ExternalCallVFN;
import de.fzi.se.validation.testbased.results.InfrastructureCallVFN;
import de.fzi.se.validation.testbased.results.ParameterVFN;
import de.fzi.se.validation.testbased.results.ResultsFactory;
import de.fzi.se.validation.testbased.results.ResultsPackage;
import de.fzi.se.validation.testbased.results.RunProtocol;
import de.fzi.se.validation.testbased.results.ValidationFailureNotice;

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
public class ResultsPackageImpl extends EPackageImpl implements ResultsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationFailureNoticeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterVFNEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infrastructureCallVFNEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalCallVFNEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionTraceVFNEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runProtocolEClass = null;

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
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResultsPackageImpl() {
		super(eNS_URI, ResultsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ResultsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResultsPackage init() {
		if (isInited) return (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);

		// Obtain or create and register package
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ResultsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ResultsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		OutputPackage.eINSTANCE.eClass();
		InputPackage.eINSTANCE.eClass();
		QualityPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TestbasedPackageImpl theTestbasedPackage = (TestbasedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestbasedPackage.eNS_URI) instanceof TestbasedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestbasedPackage.eNS_URI) : TestbasedPackage.eINSTANCE);
		TracePackageImpl theTracePackage = (TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) instanceof TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) : TracePackage.eINSTANCE);

		// Create package meta-data objects
		theResultsPackage.createPackageContents();
		theTestbasedPackage.createPackageContents();
		theTracePackage.createPackageContents();

		// Initialize created meta-data
		theResultsPackage.initializePackageContents();
		theTestbasedPackage.initializePackageContents();
		theTracePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResultsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResultsPackage.eNS_URI, theResultsPackage);
		return theResultsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidationFailureNotice() {
		return validationFailureNoticeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationFailureNotice_Description() {
		return (EAttribute)validationFailureNoticeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationFailureNotice_RunProtocol() {
		return (EReference)validationFailureNoticeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationFailureNotice_Expected() {
		return (EReference)validationFailureNoticeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterVFN() {
		return parameterVFNEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterVFN_ObservedValue() {
		return (EReference)parameterVFNEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterVFN_ExpectedValue() {
		return (EReference)parameterVFNEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfrastructureCallVFN() {
		return infrastructureCallVFNEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfrastructureCallVFN_Observed() {
		return (EReference)infrastructureCallVFNEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalCallVFN() {
		return externalCallVFNEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCallVFN_Observed() {
		return (EReference)externalCallVFNEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionTraceVFN() {
		return executionTraceVFNEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionTraceVFN_ExecutionTrace() {
		return (EReference)executionTraceVFNEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRunProtocol() {
		return runProtocolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunProtocol_ValidationFailureNotices() {
		return (EReference)runProtocolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunProtocol_CreationTime() {
		return (EAttribute)runProtocolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunProtocol_RandomSeed() {
		return (EAttribute)runProtocolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunProtocol_ValidationSuccessful() {
		return (EAttribute)runProtocolEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunProtocol_InvalidMeasurementResults() {
		return (EReference)runProtocolEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRunProtocol_InvalidTraces() {
		return (EReference)runProtocolEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultsFactory getResultsFactory() {
		return (ResultsFactory)getEFactoryInstance();
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
		validationFailureNoticeEClass = createEClass(VALIDATION_FAILURE_NOTICE);
		createEAttribute(validationFailureNoticeEClass, VALIDATION_FAILURE_NOTICE__DESCRIPTION);
		createEReference(validationFailureNoticeEClass, VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL);
		createEReference(validationFailureNoticeEClass, VALIDATION_FAILURE_NOTICE__EXPECTED);

		parameterVFNEClass = createEClass(PARAMETER_VFN);
		createEReference(parameterVFNEClass, PARAMETER_VFN__OBSERVED_VALUE);
		createEReference(parameterVFNEClass, PARAMETER_VFN__EXPECTED_VALUE);

		infrastructureCallVFNEClass = createEClass(INFRASTRUCTURE_CALL_VFN);
		createEReference(infrastructureCallVFNEClass, INFRASTRUCTURE_CALL_VFN__OBSERVED);

		externalCallVFNEClass = createEClass(EXTERNAL_CALL_VFN);
		createEReference(externalCallVFNEClass, EXTERNAL_CALL_VFN__OBSERVED);

		executionTraceVFNEClass = createEClass(EXECUTION_TRACE_VFN);
		createEReference(executionTraceVFNEClass, EXECUTION_TRACE_VFN__EXECUTION_TRACE);

		runProtocolEClass = createEClass(RUN_PROTOCOL);
		createEReference(runProtocolEClass, RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES);
		createEAttribute(runProtocolEClass, RUN_PROTOCOL__CREATION_TIME);
		createEAttribute(runProtocolEClass, RUN_PROTOCOL__RANDOM_SEED);
		createEAttribute(runProtocolEClass, RUN_PROTOCOL__VALIDATION_SUCCESSFUL);
		createEReference(runProtocolEClass, RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS);
		createEReference(runProtocolEClass, RUN_PROTOCOL__INVALID_TRACES);
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
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		ParametersPackage theParametersPackage = (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);
		OutputPackage theOutputPackage = (OutputPackage)EPackage.Registry.INSTANCE.getEPackage(OutputPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		validationFailureNoticeEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		parameterVFNEClass.getESuperTypes().add(this.getValidationFailureNotice());
		infrastructureCallVFNEClass.getESuperTypes().add(this.getValidationFailureNotice());
		externalCallVFNEClass.getESuperTypes().add(this.getValidationFailureNotice());
		executionTraceVFNEClass.getESuperTypes().add(this.getValidationFailureNotice());
		runProtocolEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(validationFailureNoticeEClass, ValidationFailureNotice.class, "ValidationFailureNotice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidationFailureNotice_Description(), ecorePackage.getEString(), "description", null, 1, 1, ValidationFailureNotice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getValidationFailureNotice_RunProtocol(), this.getRunProtocol(), this.getRunProtocol_ValidationFailureNotices(), "runProtocol", null, 0, 1, ValidationFailureNotice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getValidationFailureNotice_Expected(), theTracePackage.getTraceAction(), null, "expected", null, 0, 1, ValidationFailureNotice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterVFNEClass, ParameterVFN.class, "ParameterVFN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterVFN_ObservedValue(), theParametersPackage.getParameterValue(), null, "observedValue", null, 0, 1, ParameterVFN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterVFN_ExpectedValue(), theParametersPackage.getParameterValue(), null, "expectedValue", null, 0, 1, ParameterVFN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(infrastructureCallVFNEClass, InfrastructureCallVFN.class, "InfrastructureCallVFN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInfrastructureCallVFN_Observed(), theOutputPackage.getObservedEntityExecution(), null, "observed", null, 1, 1, InfrastructureCallVFN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(externalCallVFNEClass, ExternalCallVFN.class, "ExternalCallVFN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalCallVFN_Observed(), theOutputPackage.getObservedEntityExecution(), null, "observed", null, 1, 1, ExternalCallVFN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(executionTraceVFNEClass, ExecutionTraceVFN.class, "ExecutionTraceVFN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionTraceVFN_ExecutionTrace(), theTracePackage.getExecutionTrace(), null, "executionTrace", null, 1, 1, ExecutionTraceVFN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(runProtocolEClass, RunProtocol.class, "RunProtocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRunProtocol_ValidationFailureNotices(), this.getValidationFailureNotice(), this.getValidationFailureNotice_RunProtocol(), "validationFailureNotices", null, 0, -1, RunProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRunProtocol_CreationTime(), ecorePackage.getEDate(), "creationTime", null, 1, 1, RunProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRunProtocol_RandomSeed(), ecorePackage.getELong(), "randomSeed", null, 1, 1, RunProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRunProtocol_ValidationSuccessful(), ecorePackage.getEBoolean(), "validationSuccessful", "false", 1, 1, RunProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRunProtocol_InvalidMeasurementResults(), theOutputPackage.getMeasurementRun(), null, "invalidMeasurementResults", null, 0, -1, RunProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRunProtocol_InvalidTraces(), theTracePackage.getExecutionTrace(), theTracePackage.getExecutionTrace_RunProtocol(), "invalidTraces", null, 0, -1, RunProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ResultsPackageImpl
