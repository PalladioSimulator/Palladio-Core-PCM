/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.util;

import de.fzi.se.validation.testbased.trace.*;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.validation.testbased.trace.TracePackage
 * @generated
 */
public class TraceValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TraceValidator INSTANCE = new TraceValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.fzi.se.validation.testbased.trace";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Call Instancemustreference Businessoperation' of 'Outgoing Business Call'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OUTGOING_BUSINESS_CALL__CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Call Instancemustreference Infrastructureoperation' of 'Outgoing Infrastructure Calls'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierValidator identifierValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return TracePackage.eINSTANCE;
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
			case TracePackage.EXECUTION_TRACE:
				return validateExecutionTrace((ExecutionTrace)value, diagnostics, context);
			case TracePackage.TRACE_ACTION:
				return validateTraceAction((TraceAction)value, diagnostics, context);
			case TracePackage.COMPONENT_PARAMETER_ASSIGNMENT:
				return validateComponentParameterAssignment((ComponentParameterAssignment)value, diagnostics, context);
			case TracePackage.INTERNAL_CALL:
				return validateInternalCall((InternalCall)value, diagnostics, context);
			case TracePackage.OUTGOING_BUSINESS_CALL:
				return validateOutgoingBusinessCall((OutgoingBusinessCall)value, diagnostics, context);
			case TracePackage.OUTGOING_INFRASTRUCTURE_CALLS:
				return validateOutgoingInfrastructureCalls((OutgoingInfrastructureCalls)value, diagnostics, context);
			case TracePackage.OPERATION_CALL:
				return validateOperationCall((OperationCall)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecutionTrace(ExecutionTrace executionTrace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(executionTrace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(executionTrace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(executionTrace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(executionTrace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(executionTrace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(executionTrace, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(executionTrace, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(executionTrace, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTraceAction(TraceAction traceAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(traceAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(traceAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(traceAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(traceAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(traceAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(traceAction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(traceAction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(traceAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentParameterAssignment(ComponentParameterAssignment componentParameterAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(componentParameterAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(componentParameterAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(componentParameterAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(componentParameterAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(componentParameterAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(componentParameterAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(componentParameterAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(componentParameterAssignment, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInternalCall(InternalCall internalCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(internalCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(internalCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(internalCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(internalCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(internalCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(internalCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(internalCall, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(internalCall, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutgoingBusinessCall(OutgoingBusinessCall outgoingBusinessCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(outgoingBusinessCall, diagnostics, context);
		if (result || diagnostics != null) result &= validateOutgoingBusinessCall_CallInstancemustreferenceBusinessoperation(outgoingBusinessCall, diagnostics, context);
		return result;
	}

	/**
	 * Validates the CallInstancemustreferenceBusinessoperation constraint of '<em>Outgoing Business Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutgoingBusinessCall_CallInstancemustreferenceBusinessoperation(OutgoingBusinessCall outgoingBusinessCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return outgoingBusinessCall.CallInstancemustreferenceBusinessoperation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutgoingInfrastructureCalls(OutgoingInfrastructureCalls outgoingInfrastructureCalls, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(outgoingInfrastructureCalls, diagnostics, context);
		if (result || diagnostics != null) result &= validateOutgoingInfrastructureCalls_CallInstancemustreferenceInfrastructureoperation(outgoingInfrastructureCalls, diagnostics, context);
		return result;
	}

	/**
	 * Validates the CallInstancemustreferenceInfrastructureoperation constraint of '<em>Outgoing Infrastructure Calls</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutgoingInfrastructureCalls_CallInstancemustreferenceInfrastructureoperation(OutgoingInfrastructureCalls outgoingInfrastructureCalls, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return outgoingInfrastructureCalls.CallInstancemustreferenceInfrastructureoperation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCall(OperationCall operationCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(operationCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationCall, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(operationCall, diagnostics, context);
		return result;
	}

} //TraceValidator
