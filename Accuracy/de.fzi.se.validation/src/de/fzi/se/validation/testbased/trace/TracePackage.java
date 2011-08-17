/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

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
 * @see de.fzi.se.validation.testbased.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fzi.de/PalladioComponentModel/Validation/TestBased/Trace/0.2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = de.fzi.se.validation.testbased.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.trace.impl.ExecutionTraceImpl <em>Execution Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.trace.impl.ExecutionTraceImpl
	 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getExecutionTrace()
	 * @generated
	 */
	int EXECUTION_TRACE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Trace Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE__TRACE_ACTIONS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Run Protocol</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE__RUN_PROTOCOL = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Execution Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.trace.impl.TraceActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.trace.impl.TraceActionImpl
	 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getTraceAction()
	 * @generated
	 */
	int TRACE_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ACTION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Execution Trace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ACTION__EXECUTION_TRACE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ACTION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.trace.impl.ComponentParameterAssignmentImpl <em>Component Parameter Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.trace.impl.ComponentParameterAssignmentImpl
	 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getComponentParameterAssignment()
	 * @generated
	 */
	int COMPONENT_PARAMETER_ASSIGNMENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PARAMETER_ASSIGNMENT__ID = TRACE_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Execution Trace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PARAMETER_ASSIGNMENT__EXECUTION_TRACE = TRACE_ACTION__EXECUTION_TRACE;

	/**
	 * The feature id for the '<em><b>Component Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PARAMETER_ASSIGNMENT__COMPONENT_INSTANCE = TRACE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Parameter Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PARAMETER_ASSIGNMENT_FEATURE_COUNT = TRACE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.trace.impl.InternalCallImpl <em>Internal Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.trace.impl.InternalCallImpl
	 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getInternalCall()
	 * @generated
	 */
	int INTERNAL_CALL = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CALL__ID = TRACE_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Execution Trace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CALL__EXECUTION_TRACE = TRACE_ACTION__EXECUTION_TRACE;

	/**
	 * The feature id for the '<em><b>Call Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CALL__CALL_INSTANCE = TRACE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Internal Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_CALL_FEATURE_COUNT = TRACE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.trace.impl.OutgoingBusinessCallImpl <em>Outgoing Business Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.trace.impl.OutgoingBusinessCallImpl
	 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getOutgoingBusinessCall()
	 * @generated
	 */
	int OUTGOING_BUSINESS_CALL = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_BUSINESS_CALL__ID = TRACE_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Execution Trace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_BUSINESS_CALL__EXECUTION_TRACE = TRACE_ACTION__EXECUTION_TRACE;

	/**
	 * The feature id for the '<em><b>Call Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_BUSINESS_CALL__CALL_INSTANCE = TRACE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Outgoing Business Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_BUSINESS_CALL_FEATURE_COUNT = TRACE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.trace.impl.OutgoingInfrastructureCallsImpl <em>Outgoing Infrastructure Calls</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.trace.impl.OutgoingInfrastructureCallsImpl
	 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getOutgoingInfrastructureCalls()
	 * @generated
	 */
	int OUTGOING_INFRASTRUCTURE_CALLS = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_INFRASTRUCTURE_CALLS__ID = TRACE_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Execution Trace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_INFRASTRUCTURE_CALLS__EXECUTION_TRACE = TRACE_ACTION__EXECUTION_TRACE;

	/**
	 * The feature id for the '<em><b>Call Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES = TRACE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Outgoing Infrastructure Calls</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_INFRASTRUCTURE_CALLS_FEATURE_COUNT = TRACE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.trace.impl.OperationCallImpl <em>Operation Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.trace.impl.OperationCallImpl
	 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getOperationCall()
	 * @generated
	 */
	int OPERATION_CALL = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL__ID = TRACE_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Execution Trace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL__EXECUTION_TRACE = TRACE_ACTION__EXECUTION_TRACE;

	/**
	 * The feature id for the '<em><b>Call Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL__CALL_INSTANCE = TRACE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_FEATURE_COUNT = TRACE_ACTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.trace.ExecutionTrace <em>Execution Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Trace</em>'.
	 * @see de.fzi.se.validation.testbased.trace.ExecutionTrace
	 * @generated
	 */
	EClass getExecutionTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.validation.testbased.trace.ExecutionTrace#getTraceActions <em>Trace Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trace Actions</em>'.
	 * @see de.fzi.se.validation.testbased.trace.ExecutionTrace#getTraceActions()
	 * @see #getExecutionTrace()
	 * @generated
	 */
	EReference getExecutionTrace_TraceActions();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.validation.testbased.trace.ExecutionTrace#getRunProtocol <em>Run Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Run Protocol</em>'.
	 * @see de.fzi.se.validation.testbased.trace.ExecutionTrace#getRunProtocol()
	 * @see #getExecutionTrace()
	 * @generated
	 */
	EReference getExecutionTrace_RunProtocol();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.trace.TraceAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see de.fzi.se.validation.testbased.trace.TraceAction
	 * @generated
	 */
	EClass getTraceAction();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.validation.testbased.trace.TraceAction#getExecutionTrace <em>Execution Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Execution Trace</em>'.
	 * @see de.fzi.se.validation.testbased.trace.TraceAction#getExecutionTrace()
	 * @see #getTraceAction()
	 * @generated
	 */
	EReference getTraceAction_ExecutionTrace();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.trace.ComponentParameterAssignment <em>Component Parameter Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Parameter Assignment</em>'.
	 * @see de.fzi.se.validation.testbased.trace.ComponentParameterAssignment
	 * @generated
	 */
	EClass getComponentParameterAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.trace.ComponentParameterAssignment#getComponentInstance <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Instance</em>'.
	 * @see de.fzi.se.validation.testbased.trace.ComponentParameterAssignment#getComponentInstance()
	 * @see #getComponentParameterAssignment()
	 * @generated
	 */
	EReference getComponentParameterAssignment_ComponentInstance();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.trace.InternalCall <em>Internal Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Call</em>'.
	 * @see de.fzi.se.validation.testbased.trace.InternalCall
	 * @generated
	 */
	EClass getInternalCall();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.trace.InternalCall#getCallInstance <em>Call Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Instance</em>'.
	 * @see de.fzi.se.validation.testbased.trace.InternalCall#getCallInstance()
	 * @see #getInternalCall()
	 * @generated
	 */
	EReference getInternalCall_CallInstance();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.trace.OutgoingBusinessCall <em>Outgoing Business Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outgoing Business Call</em>'.
	 * @see de.fzi.se.validation.testbased.trace.OutgoingBusinessCall
	 * @generated
	 */
	EClass getOutgoingBusinessCall();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.trace.OutgoingBusinessCall#getCallInstance <em>Call Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Instance</em>'.
	 * @see de.fzi.se.validation.testbased.trace.OutgoingBusinessCall#getCallInstance()
	 * @see #getOutgoingBusinessCall()
	 * @generated
	 */
	EReference getOutgoingBusinessCall_CallInstance();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls <em>Outgoing Infrastructure Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outgoing Infrastructure Calls</em>'.
	 * @see de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls
	 * @generated
	 */
	EClass getOutgoingInfrastructureCalls();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls#getCallInstances <em>Call Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Call Instances</em>'.
	 * @see de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls#getCallInstances()
	 * @see #getOutgoingInfrastructureCalls()
	 * @generated
	 */
	EReference getOutgoingInfrastructureCalls_CallInstances();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.trace.OperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call</em>'.
	 * @see de.fzi.se.validation.testbased.trace.OperationCall
	 * @generated
	 */
	EClass getOperationCall();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.trace.OperationCall#getCallInstance <em>Call Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Instance</em>'.
	 * @see de.fzi.se.validation.testbased.trace.OperationCall#getCallInstance()
	 * @see #getOperationCall()
	 * @generated
	 */
	EReference getOperationCall_CallInstance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.trace.impl.ExecutionTraceImpl <em>Execution Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.trace.impl.ExecutionTraceImpl
		 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getExecutionTrace()
		 * @generated
		 */
		EClass EXECUTION_TRACE = eINSTANCE.getExecutionTrace();

		/**
		 * The meta object literal for the '<em><b>Trace Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_TRACE__TRACE_ACTIONS = eINSTANCE.getExecutionTrace_TraceActions();

		/**
		 * The meta object literal for the '<em><b>Run Protocol</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_TRACE__RUN_PROTOCOL = eINSTANCE.getExecutionTrace_RunProtocol();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.trace.impl.TraceActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.trace.impl.TraceActionImpl
		 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getTraceAction()
		 * @generated
		 */
		EClass TRACE_ACTION = eINSTANCE.getTraceAction();

		/**
		 * The meta object literal for the '<em><b>Execution Trace</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ACTION__EXECUTION_TRACE = eINSTANCE.getTraceAction_ExecutionTrace();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.trace.impl.ComponentParameterAssignmentImpl <em>Component Parameter Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.trace.impl.ComponentParameterAssignmentImpl
		 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getComponentParameterAssignment()
		 * @generated
		 */
		EClass COMPONENT_PARAMETER_ASSIGNMENT = eINSTANCE.getComponentParameterAssignment();

		/**
		 * The meta object literal for the '<em><b>Component Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_PARAMETER_ASSIGNMENT__COMPONENT_INSTANCE = eINSTANCE.getComponentParameterAssignment_ComponentInstance();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.trace.impl.InternalCallImpl <em>Internal Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.trace.impl.InternalCallImpl
		 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getInternalCall()
		 * @generated
		 */
		EClass INTERNAL_CALL = eINSTANCE.getInternalCall();

		/**
		 * The meta object literal for the '<em><b>Call Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_CALL__CALL_INSTANCE = eINSTANCE.getInternalCall_CallInstance();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.trace.impl.OutgoingBusinessCallImpl <em>Outgoing Business Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.trace.impl.OutgoingBusinessCallImpl
		 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getOutgoingBusinessCall()
		 * @generated
		 */
		EClass OUTGOING_BUSINESS_CALL = eINSTANCE.getOutgoingBusinessCall();

		/**
		 * The meta object literal for the '<em><b>Call Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTGOING_BUSINESS_CALL__CALL_INSTANCE = eINSTANCE.getOutgoingBusinessCall_CallInstance();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.trace.impl.OutgoingInfrastructureCallsImpl <em>Outgoing Infrastructure Calls</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.trace.impl.OutgoingInfrastructureCallsImpl
		 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getOutgoingInfrastructureCalls()
		 * @generated
		 */
		EClass OUTGOING_INFRASTRUCTURE_CALLS = eINSTANCE.getOutgoingInfrastructureCalls();

		/**
		 * The meta object literal for the '<em><b>Call Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES = eINSTANCE.getOutgoingInfrastructureCalls_CallInstances();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.trace.impl.OperationCallImpl <em>Operation Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.trace.impl.OperationCallImpl
		 * @see de.fzi.se.validation.testbased.trace.impl.TracePackageImpl#getOperationCall()
		 * @generated
		 */
		EClass OPERATION_CALL = eINSTANCE.getOperationCall();

		/**
		 * The meta object literal for the '<em><b>Call Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL__CALL_INSTANCE = eINSTANCE.getOperationCall_CallInstance();

	}

} //TracePackage
