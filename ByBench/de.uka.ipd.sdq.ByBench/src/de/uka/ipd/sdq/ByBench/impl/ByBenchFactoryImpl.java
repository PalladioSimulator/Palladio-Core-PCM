/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.impl;

import de.uka.ipd.sdq.ByBench.*;

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
public class ByBenchFactoryImpl extends EFactoryImpl implements ByBenchFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ByBenchFactory init() {
		try {
			ByBenchFactory theByBenchFactory = (ByBenchFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ByBench/1.0"); 
			if (theByBenchFactory != null) {
				return theByBenchFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ByBenchFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByBenchFactoryImpl() {
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
			case ByBenchPackage.SCENARIO: return createScenario();
			case ByBenchPackage.SCENARIO_PRECONDITION: return createScenarioPrecondition();
			case ByBenchPackage.INSTRUCTION_SEQUENCE: return createInstructionSequence();
			case ByBenchPackage.SEQUENCE_ELEMENT: return createSequenceElement();
			case ByBenchPackage.MEASUREMENT_START: return createMeasurementStart();
			case ByBenchPackage.SCENARIO_CORE: return createScenarioCore();
			case ByBenchPackage.MEASUREMENT_END: return createMeasurementEnd();
			case ByBenchPackage.SCENARIO_POSTCONDITION: return createScenarioPostcondition();
			case ByBenchPackage.NAMED_CARDINALITY: return createNamedCardinality();
			case ByBenchPackage.INSTRUCTION_CHAINING: return createInstructionChaining();
			case ByBenchPackage.INSTRUCTION_LOOPING: return createInstructionLooping();
			case ByBenchPackage.ATOMIC_INSTRUCTION: return createAtomicInstruction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioPrecondition createScenarioPrecondition() {
		ScenarioPreconditionImpl scenarioPrecondition = new ScenarioPreconditionImpl();
		return scenarioPrecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionSequence createInstructionSequence() {
		InstructionSequenceImpl instructionSequence = new InstructionSequenceImpl();
		return instructionSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceElement createSequenceElement() {
		SequenceElementImpl sequenceElement = new SequenceElementImpl();
		return sequenceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementStart createMeasurementStart() {
		MeasurementStartImpl measurementStart = new MeasurementStartImpl();
		return measurementStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioCore createScenarioCore() {
		ScenarioCoreImpl scenarioCore = new ScenarioCoreImpl();
		return scenarioCore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementEnd createMeasurementEnd() {
		MeasurementEndImpl measurementEnd = new MeasurementEndImpl();
		return measurementEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioPostcondition createScenarioPostcondition() {
		ScenarioPostconditionImpl scenarioPostcondition = new ScenarioPostconditionImpl();
		return scenarioPostcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedCardinality createNamedCardinality() {
		NamedCardinalityImpl namedCardinality = new NamedCardinalityImpl();
		return namedCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionChaining createInstructionChaining() {
		InstructionChainingImpl instructionChaining = new InstructionChainingImpl();
		return instructionChaining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionLooping createInstructionLooping() {
		InstructionLoopingImpl instructionLooping = new InstructionLoopingImpl();
		return instructionLooping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicInstruction createAtomicInstruction() {
		AtomicInstructionImpl atomicInstruction = new AtomicInstructionImpl();
		return atomicInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByBenchPackage getByBenchPackage() {
		return (ByBenchPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ByBenchPackage getPackage() {
		return ByBenchPackage.eINSTANCE;
	}

} //ByBenchFactoryImpl
