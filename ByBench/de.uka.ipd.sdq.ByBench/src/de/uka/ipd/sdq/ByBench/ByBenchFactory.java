/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage
 * @generated
 */
public interface ByBenchFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ByBenchFactory eINSTANCE = de.uka.ipd.sdq.ByBench.impl.ByBenchFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario</em>'.
	 * @generated
	 */
	Scenario createScenario();

	/**
	 * Returns a new object of class '<em>Scenario Precondition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario Precondition</em>'.
	 * @generated
	 */
	ScenarioPrecondition createScenarioPrecondition();

	/**
	 * Returns a new object of class '<em>Instruction Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instruction Sequence</em>'.
	 * @generated
	 */
	InstructionSequence createInstructionSequence();

	/**
	 * Returns a new object of class '<em>Sequence Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Element</em>'.
	 * @generated
	 */
	SequenceElement createSequenceElement();

	/**
	 * Returns a new object of class '<em>Measurement Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement Start</em>'.
	 * @generated
	 */
	MeasurementStart createMeasurementStart();

	/**
	 * Returns a new object of class '<em>Scenario Core</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario Core</em>'.
	 * @generated
	 */
	ScenarioCore createScenarioCore();

	/**
	 * Returns a new object of class '<em>Measurement End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement End</em>'.
	 * @generated
	 */
	MeasurementEnd createMeasurementEnd();

	/**
	 * Returns a new object of class '<em>Scenario Postcondition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario Postcondition</em>'.
	 * @generated
	 */
	ScenarioPostcondition createScenarioPostcondition();

	/**
	 * Returns a new object of class '<em>Named Cardinality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Cardinality</em>'.
	 * @generated
	 */
	NamedCardinality createNamedCardinality();

	/**
	 * Returns a new object of class '<em>Instruction Chaining</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instruction Chaining</em>'.
	 * @generated
	 */
	InstructionChaining createInstructionChaining();

	/**
	 * Returns a new object of class '<em>Instruction Looping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instruction Looping</em>'.
	 * @generated
	 */
	InstructionLooping createInstructionLooping();

	/**
	 * Returns a new object of class '<em>Atomic Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Instruction</em>'.
	 * @generated
	 */
	AtomicInstruction createAtomicInstruction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ByBenchPackage getByBenchPackage();

} //ByBenchFactory
