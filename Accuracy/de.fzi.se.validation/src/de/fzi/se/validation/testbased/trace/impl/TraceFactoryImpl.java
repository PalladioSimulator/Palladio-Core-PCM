/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.impl;

import de.fzi.se.validation.testbased.trace.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceFactoryImpl extends EFactoryImpl implements TraceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceFactory init() {
		try {
			TraceFactory theTraceFactory = (TraceFactory)EPackage.Registry.INSTANCE.getEFactory("http://fzi.de/PalladioComponentModel/Validation/TestBased/Trace/0.2"); 
			if (theTraceFactory != null) {
				return theTraceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TraceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TracePackage.EXECUTION_TRACE: return createExecutionTrace();
			case TracePackage.TRACE_ACTION: return createTraceAction();
			case TracePackage.COMPONENT_PARAMETER_ASSIGNMENT: return createComponentParameterAssignment();
			case TracePackage.INTERNAL_CALL: return createInternalCall();
			case TracePackage.OUTGOING_BUSINESS_CALL: return createOutgoingBusinessCall();
			case TracePackage.OUTGOING_INFRASTRUCTURE_CALLS: return createOutgoingInfrastructureCalls();
			case TracePackage.OPERATION_CALL: return createOperationCall();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTrace createExecutionTrace() {
		ExecutionTraceImpl executionTrace = new ExecutionTraceImpl();
		return executionTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceAction createTraceAction() {
		TraceActionImpl traceAction = new TraceActionImpl();
		return traceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentParameterAssignment createComponentParameterAssignment() {
		ComponentParameterAssignmentImpl componentParameterAssignment = new ComponentParameterAssignmentImpl();
		return componentParameterAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalCall createInternalCall() {
		InternalCallImpl internalCall = new InternalCallImpl();
		return internalCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutgoingBusinessCall createOutgoingBusinessCall() {
		OutgoingBusinessCallImpl outgoingBusinessCall = new OutgoingBusinessCallImpl();
		return outgoingBusinessCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutgoingInfrastructureCalls createOutgoingInfrastructureCalls() {
		OutgoingInfrastructureCallsImpl outgoingInfrastructureCalls = new OutgoingInfrastructureCallsImpl();
		return outgoingInfrastructureCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCall createOperationCall() {
		OperationCallImpl operationCall = new OperationCallImpl();
		return operationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracePackage getTracePackage() {
		return (TracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TracePackage getPackage() {
		return TracePackage.eINSTANCE;
	}

} //TraceFactoryImpl
