/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench;

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
 * @see de.uka.ipd.sdq.ByBench.ByBenchFactory
 * @model kind="package"
 * @generated
 */
public interface ByBenchPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ByBench";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ByBench/1.0/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ByBench";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ByBenchPackage eINSTANCE = de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Scenarioprecondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SCENARIOPRECONDITION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measurementstart</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__MEASUREMENTSTART = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenariocore</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SCENARIOCORE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Measurementend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__MEASUREMENTEND = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Scenariopostcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SCENARIOPOSTCONDITION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Namedcardinality</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAMEDCARDINALITY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Benchmarked Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__BENCHMARKED_INSTRUCTION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.InstructionSequenceImpl <em>Instruction Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.InstructionSequenceImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getInstructionSequence()
	 * @generated
	 */
	int INSTRUCTION_SEQUENCE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_SEQUENCE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Sequenceelement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_SEQUENCE__SEQUENCEELEMENT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instruction Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_SEQUENCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioPreconditionImpl <em>Scenario Precondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioPreconditionImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenarioPrecondition()
	 * @generated
	 */
	int SCENARIO_PRECONDITION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_PRECONDITION__ID = INSTRUCTION_SEQUENCE__ID;

	/**
	 * The feature id for the '<em><b>Sequenceelement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_PRECONDITION__SEQUENCEELEMENT = INSTRUCTION_SEQUENCE__SEQUENCEELEMENT;

	/**
	 * The number of structural features of the '<em>Scenario Precondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_PRECONDITION_FEATURE_COUNT = INSTRUCTION_SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.SequenceElementImpl <em>Sequence Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.SequenceElementImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getSequenceElement()
	 * @generated
	 */
	int SEQUENCE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_ELEMENT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_ELEMENT__SUCCESSOR = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_ELEMENT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.MeasurementStartImpl <em>Measurement Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.MeasurementStartImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getMeasurementStart()
	 * @generated
	 */
	int MEASUREMENT_START = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_START__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Measurement Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_START_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioCoreImpl <em>Scenario Core</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioCoreImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenarioCore()
	 * @generated
	 */
	int SCENARIO_CORE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CORE__ID = INSTRUCTION_SEQUENCE__ID;

	/**
	 * The feature id for the '<em><b>Sequenceelement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CORE__SEQUENCEELEMENT = INSTRUCTION_SEQUENCE__SEQUENCEELEMENT;

	/**
	 * The number of structural features of the '<em>Scenario Core</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_CORE_FEATURE_COUNT = INSTRUCTION_SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.MeasurementEndImpl <em>Measurement End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.MeasurementEndImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getMeasurementEnd()
	 * @generated
	 */
	int MEASUREMENT_END = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_END__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Measurement End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_END_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioPostconditionImpl <em>Scenario Postcondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioPostconditionImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenarioPostcondition()
	 * @generated
	 */
	int SCENARIO_POSTCONDITION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_POSTCONDITION__ID = INSTRUCTION_SEQUENCE__ID;

	/**
	 * The feature id for the '<em><b>Sequenceelement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_POSTCONDITION__SEQUENCEELEMENT = INSTRUCTION_SEQUENCE__SEQUENCEELEMENT;

	/**
	 * The number of structural features of the '<em>Scenario Postcondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_POSTCONDITION_FEATURE_COUNT = INSTRUCTION_SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl <em>Named Cardinality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getNamedCardinality()
	 * @generated
	 */
	int NAMED_CARDINALITY = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CARDINALITY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Cardinality Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CARDINALITY__CARDINALITY_VALUE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cardinality Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CARDINALITY__CARDINALITY_NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instructionchaining</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CARDINALITY__INSTRUCTIONCHAINING = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instructionlooping</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CARDINALITY__INSTRUCTIONLOOPING = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Named Cardinality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CARDINALITY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.InstructionChainingImpl <em>Instruction Chaining</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.InstructionChainingImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getInstructionChaining()
	 * @generated
	 */
	int INSTRUCTION_CHAINING = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_CHAINING__ID = SEQUENCE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_CHAINING__SUCCESSOR = SEQUENCE_ELEMENT__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Instructionsequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_CHAINING__INSTRUCTIONSEQUENCE = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namedcardinality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_CHAINING__NAMEDCARDINALITY = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instruction Chaining</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_CHAINING_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.InstructionLoopingImpl <em>Instruction Looping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.InstructionLoopingImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getInstructionLooping()
	 * @generated
	 */
	int INSTRUCTION_LOOPING = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_LOOPING__ID = SEQUENCE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_LOOPING__SUCCESSOR = SEQUENCE_ELEMENT__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Instructionsequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namedcardinality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_LOOPING__NAMEDCARDINALITY = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instruction Looping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_LOOPING_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.ByBench.impl.AtomicInstructionImpl <em>Atomic Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.ByBench.impl.AtomicInstructionImpl
	 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getAtomicInstruction()
	 * @generated
	 */
	int ATOMIC_INSTRUCTION = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_INSTRUCTION__ID = SEQUENCE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_INSTRUCTION__SUCCESSOR = SEQUENCE_ELEMENT__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Parameter Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_INSTRUCTION__PARAMETER_VALUE = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_INSTRUCTION__PARAMETER_CONVERSION = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_INSTRUCTION__OPCODE = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Atomic Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_INSTRUCTION_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.ByBench.Scenario#getScenarioprecondition <em>Scenarioprecondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scenarioprecondition</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario#getScenarioprecondition()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Scenarioprecondition();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.ByBench.Scenario#getMeasurementstart <em>Measurementstart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Measurementstart</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario#getMeasurementstart()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Measurementstart();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.ByBench.Scenario#getScenariocore <em>Scenariocore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scenariocore</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario#getScenariocore()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Scenariocore();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.ByBench.Scenario#getMeasurementend <em>Measurementend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Measurementend</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario#getMeasurementend()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Measurementend();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.ByBench.Scenario#getScenariopostcondition <em>Scenariopostcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scenariopostcondition</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario#getScenariopostcondition()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Scenariopostcondition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.ByBench.Scenario#getNamedcardinality <em>Namedcardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Namedcardinality</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario#getNamedcardinality()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Namedcardinality();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.ByBench.Scenario#getBenchmarkedInstruction <em>Benchmarked Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Benchmarked Instruction</em>'.
	 * @see de.uka.ipd.sdq.ByBench.Scenario#getBenchmarkedInstruction()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_BenchmarkedInstruction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.ScenarioPrecondition <em>Scenario Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario Precondition</em>'.
	 * @see de.uka.ipd.sdq.ByBench.ScenarioPrecondition
	 * @generated
	 */
	EClass getScenarioPrecondition();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.InstructionSequence <em>Instruction Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction Sequence</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionSequence
	 * @generated
	 */
	EClass getInstructionSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.ByBench.InstructionSequence#getSequenceelement <em>Sequenceelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequenceelement</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionSequence#getSequenceelement()
	 * @see #getInstructionSequence()
	 * @generated
	 */
	EReference getInstructionSequence_Sequenceelement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.SequenceElement <em>Sequence Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Element</em>'.
	 * @see de.uka.ipd.sdq.ByBench.SequenceElement
	 * @generated
	 */
	EClass getSequenceElement();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.ByBench.SequenceElement#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see de.uka.ipd.sdq.ByBench.SequenceElement#getSuccessor()
	 * @see #getSequenceElement()
	 * @generated
	 */
	EReference getSequenceElement_Successor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.MeasurementStart <em>Measurement Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Start</em>'.
	 * @see de.uka.ipd.sdq.ByBench.MeasurementStart
	 * @generated
	 */
	EClass getMeasurementStart();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.ScenarioCore <em>Scenario Core</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario Core</em>'.
	 * @see de.uka.ipd.sdq.ByBench.ScenarioCore
	 * @generated
	 */
	EClass getScenarioCore();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.MeasurementEnd <em>Measurement End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement End</em>'.
	 * @see de.uka.ipd.sdq.ByBench.MeasurementEnd
	 * @generated
	 */
	EClass getMeasurementEnd();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.ScenarioPostcondition <em>Scenario Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario Postcondition</em>'.
	 * @see de.uka.ipd.sdq.ByBench.ScenarioPostcondition
	 * @generated
	 */
	EClass getScenarioPostcondition();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.NamedCardinality <em>Named Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Cardinality</em>'.
	 * @see de.uka.ipd.sdq.ByBench.NamedCardinality
	 * @generated
	 */
	EClass getNamedCardinality();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityValue <em>Cardinality Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality Value</em>'.
	 * @see de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityValue()
	 * @see #getNamedCardinality()
	 * @generated
	 */
	EAttribute getNamedCardinality_CardinalityValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityName <em>Cardinality Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality Name</em>'.
	 * @see de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityName()
	 * @see #getNamedCardinality()
	 * @generated
	 */
	EAttribute getNamedCardinality_CardinalityName();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionchaining <em>Instructionchaining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instructionchaining</em>'.
	 * @see de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionchaining()
	 * @see #getNamedCardinality()
	 * @generated
	 */
	EReference getNamedCardinality_Instructionchaining();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionlooping <em>Instructionlooping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instructionlooping</em>'.
	 * @see de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionlooping()
	 * @see #getNamedCardinality()
	 * @generated
	 */
	EReference getNamedCardinality_Instructionlooping();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.InstructionChaining <em>Instruction Chaining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction Chaining</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionChaining
	 * @generated
	 */
	EClass getInstructionChaining();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.ByBench.InstructionChaining#getInstructionsequence <em>Instructionsequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instructionsequence</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionChaining#getInstructionsequence()
	 * @see #getInstructionChaining()
	 * @generated
	 */
	EReference getInstructionChaining_Instructionsequence();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.ByBench.InstructionChaining#getNamedcardinality <em>Namedcardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namedcardinality</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionChaining#getNamedcardinality()
	 * @see #getInstructionChaining()
	 * @generated
	 */
	EReference getInstructionChaining_Namedcardinality();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.InstructionLooping <em>Instruction Looping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction Looping</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionLooping
	 * @generated
	 */
	EClass getInstructionLooping();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.ByBench.InstructionLooping#getInstructionsequence <em>Instructionsequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructionsequence</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionLooping#getInstructionsequence()
	 * @see #getInstructionLooping()
	 * @generated
	 */
	EReference getInstructionLooping_Instructionsequence();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.ByBench.InstructionLooping#getNamedcardinality <em>Namedcardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namedcardinality</em>'.
	 * @see de.uka.ipd.sdq.ByBench.InstructionLooping#getNamedcardinality()
	 * @see #getInstructionLooping()
	 * @generated
	 */
	EReference getInstructionLooping_Namedcardinality();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.ByBench.AtomicInstruction <em>Atomic Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Instruction</em>'.
	 * @see de.uka.ipd.sdq.ByBench.AtomicInstruction
	 * @generated
	 */
	EClass getAtomicInstruction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Value</em>'.
	 * @see de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterValue()
	 * @see #getAtomicInstruction()
	 * @generated
	 */
	EAttribute getAtomicInstruction_ParameterValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterConversion <em>Parameter Conversion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Conversion</em>'.
	 * @see de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterConversion()
	 * @see #getAtomicInstruction()
	 * @generated
	 */
	EAttribute getAtomicInstruction_ParameterConversion();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getOpcode <em>Opcode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opcode</em>'.
	 * @see de.uka.ipd.sdq.ByBench.AtomicInstruction#getOpcode()
	 * @see #getAtomicInstruction()
	 * @generated
	 */
	EAttribute getAtomicInstruction_Opcode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ByBenchFactory getByBenchFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Scenarioprecondition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__SCENARIOPRECONDITION = eINSTANCE.getScenario_Scenarioprecondition();

		/**
		 * The meta object literal for the '<em><b>Measurementstart</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__MEASUREMENTSTART = eINSTANCE.getScenario_Measurementstart();

		/**
		 * The meta object literal for the '<em><b>Scenariocore</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__SCENARIOCORE = eINSTANCE.getScenario_Scenariocore();

		/**
		 * The meta object literal for the '<em><b>Measurementend</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__MEASUREMENTEND = eINSTANCE.getScenario_Measurementend();

		/**
		 * The meta object literal for the '<em><b>Scenariopostcondition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__SCENARIOPOSTCONDITION = eINSTANCE.getScenario_Scenariopostcondition();

		/**
		 * The meta object literal for the '<em><b>Namedcardinality</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__NAMEDCARDINALITY = eINSTANCE.getScenario_Namedcardinality();

		/**
		 * The meta object literal for the '<em><b>Benchmarked Instruction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__BENCHMARKED_INSTRUCTION = eINSTANCE.getScenario_BenchmarkedInstruction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioPreconditionImpl <em>Scenario Precondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioPreconditionImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenarioPrecondition()
		 * @generated
		 */
		EClass SCENARIO_PRECONDITION = eINSTANCE.getScenarioPrecondition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.InstructionSequenceImpl <em>Instruction Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.InstructionSequenceImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getInstructionSequence()
		 * @generated
		 */
		EClass INSTRUCTION_SEQUENCE = eINSTANCE.getInstructionSequence();

		/**
		 * The meta object literal for the '<em><b>Sequenceelement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION_SEQUENCE__SEQUENCEELEMENT = eINSTANCE.getInstructionSequence_Sequenceelement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.SequenceElementImpl <em>Sequence Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.SequenceElementImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getSequenceElement()
		 * @generated
		 */
		EClass SEQUENCE_ELEMENT = eINSTANCE.getSequenceElement();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_ELEMENT__SUCCESSOR = eINSTANCE.getSequenceElement_Successor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.MeasurementStartImpl <em>Measurement Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.MeasurementStartImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getMeasurementStart()
		 * @generated
		 */
		EClass MEASUREMENT_START = eINSTANCE.getMeasurementStart();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioCoreImpl <em>Scenario Core</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioCoreImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenarioCore()
		 * @generated
		 */
		EClass SCENARIO_CORE = eINSTANCE.getScenarioCore();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.MeasurementEndImpl <em>Measurement End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.MeasurementEndImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getMeasurementEnd()
		 * @generated
		 */
		EClass MEASUREMENT_END = eINSTANCE.getMeasurementEnd();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.ScenarioPostconditionImpl <em>Scenario Postcondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.ScenarioPostconditionImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getScenarioPostcondition()
		 * @generated
		 */
		EClass SCENARIO_POSTCONDITION = eINSTANCE.getScenarioPostcondition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl <em>Named Cardinality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getNamedCardinality()
		 * @generated
		 */
		EClass NAMED_CARDINALITY = eINSTANCE.getNamedCardinality();

		/**
		 * The meta object literal for the '<em><b>Cardinality Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_CARDINALITY__CARDINALITY_VALUE = eINSTANCE.getNamedCardinality_CardinalityValue();

		/**
		 * The meta object literal for the '<em><b>Cardinality Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_CARDINALITY__CARDINALITY_NAME = eINSTANCE.getNamedCardinality_CardinalityName();

		/**
		 * The meta object literal for the '<em><b>Instructionchaining</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_CARDINALITY__INSTRUCTIONCHAINING = eINSTANCE.getNamedCardinality_Instructionchaining();

		/**
		 * The meta object literal for the '<em><b>Instructionlooping</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_CARDINALITY__INSTRUCTIONLOOPING = eINSTANCE.getNamedCardinality_Instructionlooping();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.InstructionChainingImpl <em>Instruction Chaining</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.InstructionChainingImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getInstructionChaining()
		 * @generated
		 */
		EClass INSTRUCTION_CHAINING = eINSTANCE.getInstructionChaining();

		/**
		 * The meta object literal for the '<em><b>Instructionsequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION_CHAINING__INSTRUCTIONSEQUENCE = eINSTANCE.getInstructionChaining_Instructionsequence();

		/**
		 * The meta object literal for the '<em><b>Namedcardinality</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION_CHAINING__NAMEDCARDINALITY = eINSTANCE.getInstructionChaining_Namedcardinality();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.InstructionLoopingImpl <em>Instruction Looping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.InstructionLoopingImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getInstructionLooping()
		 * @generated
		 */
		EClass INSTRUCTION_LOOPING = eINSTANCE.getInstructionLooping();

		/**
		 * The meta object literal for the '<em><b>Instructionsequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE = eINSTANCE.getInstructionLooping_Instructionsequence();

		/**
		 * The meta object literal for the '<em><b>Namedcardinality</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION_LOOPING__NAMEDCARDINALITY = eINSTANCE.getInstructionLooping_Namedcardinality();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.ByBench.impl.AtomicInstructionImpl <em>Atomic Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.ByBench.impl.AtomicInstructionImpl
		 * @see de.uka.ipd.sdq.ByBench.impl.ByBenchPackageImpl#getAtomicInstruction()
		 * @generated
		 */
		EClass ATOMIC_INSTRUCTION = eINSTANCE.getAtomicInstruction();

		/**
		 * The meta object literal for the '<em><b>Parameter Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_INSTRUCTION__PARAMETER_VALUE = eINSTANCE.getAtomicInstruction_ParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parameter Conversion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_INSTRUCTION__PARAMETER_CONVERSION = eINSTANCE.getAtomicInstruction_ParameterConversion();

		/**
		 * The meta object literal for the '<em><b>Opcode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_INSTRUCTION__OPCODE = eINSTANCE.getAtomicInstruction_Opcode();

	}

} //ByBenchPackage
