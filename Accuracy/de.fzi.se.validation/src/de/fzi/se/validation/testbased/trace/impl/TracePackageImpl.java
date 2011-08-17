/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.impl;

import de.fzi.se.quality.QualityPackage;

import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.validation.testbased.TestbasedPackage;

import de.fzi.se.validation.testbased.impl.TestbasedPackageImpl;

import de.fzi.se.validation.testbased.results.ResultsPackage;

import de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl;

import de.fzi.se.validation.testbased.trace.ComponentParameterAssignment;
import de.fzi.se.validation.testbased.trace.ExecutionTrace;
import de.fzi.se.validation.testbased.trace.InternalCall;
import de.fzi.se.validation.testbased.trace.OperationCall;
import de.fzi.se.validation.testbased.trace.OutgoingBusinessCall;
import de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls;
import de.fzi.se.validation.testbased.trace.TraceAction;
import de.fzi.se.validation.testbased.trace.TraceFactory;
import de.fzi.se.validation.testbased.trace.TracePackage;

import de.fzi.se.validation.testbased.trace.util.TraceValidator;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import edu.kit.ipd.sdq.bycounter.input.InputPackage;

import edu.kit.ipd.sdq.bycounter.output.OutputPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TracePackageImpl extends EPackageImpl implements TracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionTraceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentParameterAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outgoingBusinessCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outgoingInfrastructureCallsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallEClass = null;

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
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TracePackageImpl() {
		super(eNS_URI, TraceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TracePackage init() {
		if (isInited) return (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);

		// Obtain or create and register package
		TracePackageImpl theTracePackage = (TracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TracePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		OutputPackage.eINSTANCE.eClass();
		InputPackage.eINSTANCE.eClass();
		QualityPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TestbasedPackageImpl theTestbasedPackage = (TestbasedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestbasedPackage.eNS_URI) instanceof TestbasedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestbasedPackage.eNS_URI) : TestbasedPackage.eINSTANCE);
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI) instanceof ResultsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI) : ResultsPackage.eINSTANCE);

		// Create package meta-data objects
		theTracePackage.createPackageContents();
		theTestbasedPackage.createPackageContents();
		theResultsPackage.createPackageContents();

		// Initialize created meta-data
		theTracePackage.initializePackageContents();
		theTestbasedPackage.initializePackageContents();
		theResultsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTracePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return TraceValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTracePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TracePackage.eNS_URI, theTracePackage);
		return theTracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionTrace() {
		return executionTraceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionTrace_TraceActions() {
		return (EReference)executionTraceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionTrace_RunProtocol() {
		return (EReference)executionTraceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceAction() {
		return traceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceAction_ExecutionTrace() {
		return (EReference)traceActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentParameterAssignment() {
		return componentParameterAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentParameterAssignment_ComponentInstance() {
		return (EReference)componentParameterAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalCall() {
		return internalCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalCall_CallInstance() {
		return (EReference)internalCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutgoingBusinessCall() {
		return outgoingBusinessCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutgoingBusinessCall_CallInstance() {
		return (EReference)outgoingBusinessCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutgoingInfrastructureCalls() {
		return outgoingInfrastructureCallsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutgoingInfrastructureCalls_CallInstances() {
		return (EReference)outgoingInfrastructureCallsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCall() {
		return operationCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCall_CallInstance() {
		return (EReference)operationCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFactory getTraceFactory() {
		return (TraceFactory)getEFactoryInstance();
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
		executionTraceEClass = createEClass(EXECUTION_TRACE);
		createEReference(executionTraceEClass, EXECUTION_TRACE__TRACE_ACTIONS);
		createEReference(executionTraceEClass, EXECUTION_TRACE__RUN_PROTOCOL);

		traceActionEClass = createEClass(TRACE_ACTION);
		createEReference(traceActionEClass, TRACE_ACTION__EXECUTION_TRACE);

		componentParameterAssignmentEClass = createEClass(COMPONENT_PARAMETER_ASSIGNMENT);
		createEReference(componentParameterAssignmentEClass, COMPONENT_PARAMETER_ASSIGNMENT__COMPONENT_INSTANCE);

		internalCallEClass = createEClass(INTERNAL_CALL);
		createEReference(internalCallEClass, INTERNAL_CALL__CALL_INSTANCE);

		outgoingBusinessCallEClass = createEClass(OUTGOING_BUSINESS_CALL);
		createEReference(outgoingBusinessCallEClass, OUTGOING_BUSINESS_CALL__CALL_INSTANCE);

		outgoingInfrastructureCallsEClass = createEClass(OUTGOING_INFRASTRUCTURE_CALLS);
		createEReference(outgoingInfrastructureCallsEClass, OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES);

		operationCallEClass = createEClass(OPERATION_CALL);
		createEReference(operationCallEClass, OPERATION_CALL__CALL_INSTANCE);
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
		ResultsPackage theResultsPackage = (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		ParametersPackage theParametersPackage = (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		executionTraceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		traceActionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		componentParameterAssignmentEClass.getESuperTypes().add(this.getTraceAction());
		internalCallEClass.getESuperTypes().add(this.getTraceAction());
		outgoingBusinessCallEClass.getESuperTypes().add(this.getTraceAction());
		outgoingInfrastructureCallsEClass.getESuperTypes().add(this.getTraceAction());
		operationCallEClass.getESuperTypes().add(this.getTraceAction());

		// Initialize classes and features; add operations and parameters
		initEClass(executionTraceEClass, ExecutionTrace.class, "ExecutionTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionTrace_TraceActions(), this.getTraceAction(), this.getTraceAction_ExecutionTrace(), "traceActions", null, 0, -1, ExecutionTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionTrace_RunProtocol(), theResultsPackage.getRunProtocol(), theResultsPackage.getRunProtocol_InvalidTraces(), "runProtocol", null, 0, 1, ExecutionTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(traceActionEClass, TraceAction.class, "TraceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceAction_ExecutionTrace(), this.getExecutionTrace(), this.getExecutionTrace_TraceActions(), "executionTrace", null, 1, 1, TraceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentParameterAssignmentEClass, ComponentParameterAssignment.class, "ComponentParameterAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentParameterAssignment_ComponentInstance(), theParametersPackage.getComponentInstance(), null, "componentInstance", null, 1, 1, ComponentParameterAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(internalCallEClass, InternalCall.class, "InternalCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalCall_CallInstance(), theParametersPackage.getCallInstance(), null, "callInstance", null, 1, 1, InternalCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outgoingBusinessCallEClass, OutgoingBusinessCall.class, "OutgoingBusinessCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutgoingBusinessCall_CallInstance(), theParametersPackage.getCallInstance(), null, "callInstance", null, 1, 1, OutgoingBusinessCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(outgoingBusinessCallEClass, ecorePackage.getEBoolean(), "CallInstancemustreferenceBusinessoperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(outgoingInfrastructureCallsEClass, OutgoingInfrastructureCalls.class, "OutgoingInfrastructureCalls", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutgoingInfrastructureCalls_CallInstances(), theParametersPackage.getCallInstance(), null, "callInstances", null, 0, -1, OutgoingInfrastructureCalls.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(outgoingInfrastructureCallsEClass, ecorePackage.getEBoolean(), "CallInstancemustreferenceInfrastructureoperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(operationCallEClass, OperationCall.class, "OperationCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCall_CallInstance(), theParametersPackage.getCallInstance(), null, "callInstance", null, 1, 1, OperationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //TracePackageImpl
