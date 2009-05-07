/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.util;

import de.uka.ipd.sdq.ByBench.*;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage
 * @generated
 */
public class ByBenchSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ByBenchPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByBenchSwitch() {
		if (modelPackage == null) {
			modelPackage = ByBenchPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ByBenchPackage.SCENARIO: {
				Scenario scenario = (Scenario)theEObject;
				T result = caseScenario(scenario);
				if (result == null) result = caseIdentifier(scenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.SCENARIO_PRECONDITION: {
				ScenarioPrecondition scenarioPrecondition = (ScenarioPrecondition)theEObject;
				T result = caseScenarioPrecondition(scenarioPrecondition);
				if (result == null) result = caseInstructionSequence(scenarioPrecondition);
				if (result == null) result = caseIdentifier(scenarioPrecondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.INSTRUCTION_SEQUENCE: {
				InstructionSequence instructionSequence = (InstructionSequence)theEObject;
				T result = caseInstructionSequence(instructionSequence);
				if (result == null) result = caseIdentifier(instructionSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.SEQUENCE_ELEMENT: {
				SequenceElement sequenceElement = (SequenceElement)theEObject;
				T result = caseSequenceElement(sequenceElement);
				if (result == null) result = caseIdentifier(sequenceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.MEASUREMENT_START: {
				MeasurementStart measurementStart = (MeasurementStart)theEObject;
				T result = caseMeasurementStart(measurementStart);
				if (result == null) result = caseIdentifier(measurementStart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.SCENARIO_CORE: {
				ScenarioCore scenarioCore = (ScenarioCore)theEObject;
				T result = caseScenarioCore(scenarioCore);
				if (result == null) result = caseInstructionSequence(scenarioCore);
				if (result == null) result = caseIdentifier(scenarioCore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.MEASUREMENT_END: {
				MeasurementEnd measurementEnd = (MeasurementEnd)theEObject;
				T result = caseMeasurementEnd(measurementEnd);
				if (result == null) result = caseIdentifier(measurementEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.SCENARIO_POSTCONDITION: {
				ScenarioPostcondition scenarioPostcondition = (ScenarioPostcondition)theEObject;
				T result = caseScenarioPostcondition(scenarioPostcondition);
				if (result == null) result = caseInstructionSequence(scenarioPostcondition);
				if (result == null) result = caseIdentifier(scenarioPostcondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.NAMED_CARDINALITY: {
				NamedCardinality namedCardinality = (NamedCardinality)theEObject;
				T result = caseNamedCardinality(namedCardinality);
				if (result == null) result = caseIdentifier(namedCardinality);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.INSTRUCTION_CHAINING: {
				InstructionChaining instructionChaining = (InstructionChaining)theEObject;
				T result = caseInstructionChaining(instructionChaining);
				if (result == null) result = caseSequenceElement(instructionChaining);
				if (result == null) result = caseIdentifier(instructionChaining);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.INSTRUCTION_LOOPING: {
				InstructionLooping instructionLooping = (InstructionLooping)theEObject;
				T result = caseInstructionLooping(instructionLooping);
				if (result == null) result = caseSequenceElement(instructionLooping);
				if (result == null) result = caseIdentifier(instructionLooping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ByBenchPackage.ATOMIC_INSTRUCTION: {
				AtomicInstruction atomicInstruction = (AtomicInstruction)theEObject;
				T result = caseAtomicInstruction(atomicInstruction);
				if (result == null) result = caseSequenceElement(atomicInstruction);
				if (result == null) result = caseIdentifier(atomicInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenario(Scenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario Precondition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario Precondition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenarioPrecondition(ScenarioPrecondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstructionSequence(InstructionSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceElement(SequenceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementStart(MeasurementStart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario Core</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario Core</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenarioCore(ScenarioCore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementEnd(MeasurementEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario Postcondition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario Postcondition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenarioPostcondition(ScenarioPostcondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Cardinality</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Cardinality</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedCardinality(NamedCardinality object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction Chaining</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction Chaining</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstructionChaining(InstructionChaining object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction Looping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction Looping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstructionLooping(InstructionLooping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicInstruction(AtomicInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ByBenchSwitch
