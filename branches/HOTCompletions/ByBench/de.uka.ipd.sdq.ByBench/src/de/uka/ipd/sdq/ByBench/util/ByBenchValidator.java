/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.util;

import de.uka.ipd.sdq.ByBench.*;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage
 * @generated
 */
public class ByBenchValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ByBenchValidator INSTANCE = new ByBenchValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.ByBench";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Ensure Valid Opcode' of 'Atomic Instruction'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ATOMIC_INSTRUCTION__ENSURE_VALID_OPCODE = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

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
	public ByBenchValidator() {
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
	  return ByBenchPackage.eINSTANCE;
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
			case ByBenchPackage.SCENARIO:
				return validateScenario((Scenario)value, diagnostics, context);
			case ByBenchPackage.SCENARIO_PRECONDITION:
				return validateScenarioPrecondition((ScenarioPrecondition)value, diagnostics, context);
			case ByBenchPackage.INSTRUCTION_SEQUENCE:
				return validateInstructionSequence((InstructionSequence)value, diagnostics, context);
			case ByBenchPackage.SEQUENCE_ELEMENT:
				return validateSequenceElement((SequenceElement)value, diagnostics, context);
			case ByBenchPackage.MEASUREMENT_START:
				return validateMeasurementStart((MeasurementStart)value, diagnostics, context);
			case ByBenchPackage.SCENARIO_CORE:
				return validateScenarioCore((ScenarioCore)value, diagnostics, context);
			case ByBenchPackage.MEASUREMENT_END:
				return validateMeasurementEnd((MeasurementEnd)value, diagnostics, context);
			case ByBenchPackage.SCENARIO_POSTCONDITION:
				return validateScenarioPostcondition((ScenarioPostcondition)value, diagnostics, context);
			case ByBenchPackage.NAMED_CARDINALITY:
				return validateNamedCardinality((NamedCardinality)value, diagnostics, context);
			case ByBenchPackage.INSTRUCTION_CHAINING:
				return validateInstructionChaining((InstructionChaining)value, diagnostics, context);
			case ByBenchPackage.INSTRUCTION_LOOPING:
				return validateInstructionLooping((InstructionLooping)value, diagnostics, context);
			case ByBenchPackage.ATOMIC_INSTRUCTION:
				return validateAtomicInstruction((AtomicInstruction)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(scenario, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenarioPrecondition(ScenarioPrecondition scenarioPrecondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(scenarioPrecondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scenarioPrecondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scenarioPrecondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scenarioPrecondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scenarioPrecondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scenarioPrecondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scenarioPrecondition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(scenarioPrecondition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstructionSequence(InstructionSequence instructionSequence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(instructionSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instructionSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instructionSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instructionSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instructionSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instructionSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instructionSequence, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(instructionSequence, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceElement(SequenceElement sequenceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(sequenceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sequenceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceElement, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(sequenceElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeasurementStart(MeasurementStart measurementStart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(measurementStart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(measurementStart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(measurementStart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(measurementStart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(measurementStart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(measurementStart, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(measurementStart, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(measurementStart, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenarioCore(ScenarioCore scenarioCore, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(scenarioCore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scenarioCore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scenarioCore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scenarioCore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scenarioCore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scenarioCore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scenarioCore, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(scenarioCore, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeasurementEnd(MeasurementEnd measurementEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(measurementEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(measurementEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(measurementEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(measurementEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(measurementEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(measurementEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(measurementEnd, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(measurementEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenarioPostcondition(ScenarioPostcondition scenarioPostcondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(scenarioPostcondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scenarioPostcondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scenarioPostcondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scenarioPostcondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scenarioPostcondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scenarioPostcondition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scenarioPostcondition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(scenarioPostcondition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedCardinality(NamedCardinality namedCardinality, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(namedCardinality, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedCardinality, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedCardinality, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedCardinality, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedCardinality, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedCardinality, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedCardinality, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(namedCardinality, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstructionChaining(InstructionChaining instructionChaining, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(instructionChaining, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instructionChaining, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instructionChaining, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instructionChaining, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instructionChaining, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instructionChaining, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instructionChaining, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(instructionChaining, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstructionLooping(InstructionLooping instructionLooping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(instructionLooping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(instructionLooping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(instructionLooping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(instructionLooping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(instructionLooping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(instructionLooping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(instructionLooping, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(instructionLooping, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAtomicInstruction(AtomicInstruction atomicInstruction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(atomicInstruction, diagnostics, context);
		if (result || diagnostics != null) result &= validateAtomicInstruction_ensureValidOpcode(atomicInstruction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ensureValidOpcode constraint of '<em>Atomic Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAtomicInstruction_ensureValidOpcode(AtomicInstruction atomicInstruction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return atomicInstruction.ensureValidOpcode(diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ByBenchValidator
