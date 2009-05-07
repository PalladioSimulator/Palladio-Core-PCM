/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.impl;

import de.uka.ipd.sdq.ByBench.AtomicInstruction;
import de.uka.ipd.sdq.ByBench.ByBenchFactory;
import de.uka.ipd.sdq.ByBench.ByBenchPackage;
import de.uka.ipd.sdq.ByBench.InstructionChaining;
import de.uka.ipd.sdq.ByBench.InstructionLooping;
import de.uka.ipd.sdq.ByBench.InstructionSequence;
import de.uka.ipd.sdq.ByBench.MeasurementEnd;
import de.uka.ipd.sdq.ByBench.MeasurementStart;
import de.uka.ipd.sdq.ByBench.NamedCardinality;
import de.uka.ipd.sdq.ByBench.Scenario;
import de.uka.ipd.sdq.ByBench.ScenarioCore;
import de.uka.ipd.sdq.ByBench.ScenarioPostcondition;
import de.uka.ipd.sdq.ByBench.ScenarioPrecondition;
import de.uka.ipd.sdq.ByBench.SequenceElement;

import de.uka.ipd.sdq.ByBench.util.ByBenchValidator;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class ByBenchPackageImpl extends EPackageImpl implements ByBenchPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioPreconditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instructionSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioCoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioPostconditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedCardinalityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instructionChainingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instructionLoopingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicInstructionEClass = null;

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
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ByBenchPackageImpl() {
		super(eNS_URI, ByBenchFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ByBenchPackage init() {
		if (isInited) return (ByBenchPackage)EPackage.Registry.INSTANCE.getEPackage(ByBenchPackage.eNS_URI);

		// Obtain or create and register package
		ByBenchPackageImpl theByBenchPackage = (ByBenchPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ByBenchPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ByBenchPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theByBenchPackage.createPackageContents();

		// Initialize created meta-data
		theByBenchPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theByBenchPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ByBenchValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theByBenchPackage.freeze();

		return theByBenchPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Scenarioprecondition() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Measurementstart() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Scenariocore() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Measurementend() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Scenariopostcondition() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Namedcardinality() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_BenchmarkedInstruction() {
		return (EReference)scenarioEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenarioPrecondition() {
		return scenarioPreconditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstructionSequence() {
		return instructionSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstructionSequence_Sequenceelement() {
		return (EReference)instructionSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceElement() {
		return sequenceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceElement_Successor() {
		return (EReference)sequenceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementStart() {
		return measurementStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenarioCore() {
		return scenarioCoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementEnd() {
		return measurementEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenarioPostcondition() {
		return scenarioPostconditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedCardinality() {
		return namedCardinalityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedCardinality_CardinalityValue() {
		return (EAttribute)namedCardinalityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedCardinality_CardinalityName() {
		return (EAttribute)namedCardinalityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedCardinality_Instructionchaining() {
		return (EReference)namedCardinalityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedCardinality_Instructionlooping() {
		return (EReference)namedCardinalityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstructionChaining() {
		return instructionChainingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstructionChaining_Instructionsequence() {
		return (EReference)instructionChainingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstructionChaining_Namedcardinality() {
		return (EReference)instructionChainingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstructionLooping() {
		return instructionLoopingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstructionLooping_Instructionsequence() {
		return (EReference)instructionLoopingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstructionLooping_Namedcardinality() {
		return (EReference)instructionLoopingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicInstruction() {
		return atomicInstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomicInstruction_ParameterValue() {
		return (EAttribute)atomicInstructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomicInstruction_ParameterConversion() {
		return (EAttribute)atomicInstructionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomicInstruction_Opcode() {
		return (EAttribute)atomicInstructionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByBenchFactory getByBenchFactory() {
		return (ByBenchFactory)getEFactoryInstance();
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
		scenarioEClass = createEClass(SCENARIO);
		createEReference(scenarioEClass, SCENARIO__SCENARIOPRECONDITION);
		createEReference(scenarioEClass, SCENARIO__MEASUREMENTSTART);
		createEReference(scenarioEClass, SCENARIO__SCENARIOCORE);
		createEReference(scenarioEClass, SCENARIO__MEASUREMENTEND);
		createEReference(scenarioEClass, SCENARIO__SCENARIOPOSTCONDITION);
		createEReference(scenarioEClass, SCENARIO__NAMEDCARDINALITY);
		createEReference(scenarioEClass, SCENARIO__BENCHMARKED_INSTRUCTION);

		scenarioPreconditionEClass = createEClass(SCENARIO_PRECONDITION);

		instructionSequenceEClass = createEClass(INSTRUCTION_SEQUENCE);
		createEReference(instructionSequenceEClass, INSTRUCTION_SEQUENCE__SEQUENCEELEMENT);

		sequenceElementEClass = createEClass(SEQUENCE_ELEMENT);
		createEReference(sequenceElementEClass, SEQUENCE_ELEMENT__SUCCESSOR);

		measurementStartEClass = createEClass(MEASUREMENT_START);

		scenarioCoreEClass = createEClass(SCENARIO_CORE);

		measurementEndEClass = createEClass(MEASUREMENT_END);

		scenarioPostconditionEClass = createEClass(SCENARIO_POSTCONDITION);

		namedCardinalityEClass = createEClass(NAMED_CARDINALITY);
		createEAttribute(namedCardinalityEClass, NAMED_CARDINALITY__CARDINALITY_VALUE);
		createEAttribute(namedCardinalityEClass, NAMED_CARDINALITY__CARDINALITY_NAME);
		createEReference(namedCardinalityEClass, NAMED_CARDINALITY__INSTRUCTIONCHAINING);
		createEReference(namedCardinalityEClass, NAMED_CARDINALITY__INSTRUCTIONLOOPING);

		instructionChainingEClass = createEClass(INSTRUCTION_CHAINING);
		createEReference(instructionChainingEClass, INSTRUCTION_CHAINING__INSTRUCTIONSEQUENCE);
		createEReference(instructionChainingEClass, INSTRUCTION_CHAINING__NAMEDCARDINALITY);

		instructionLoopingEClass = createEClass(INSTRUCTION_LOOPING);
		createEReference(instructionLoopingEClass, INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE);
		createEReference(instructionLoopingEClass, INSTRUCTION_LOOPING__NAMEDCARDINALITY);

		atomicInstructionEClass = createEClass(ATOMIC_INSTRUCTION);
		createEAttribute(atomicInstructionEClass, ATOMIC_INSTRUCTION__PARAMETER_VALUE);
		createEAttribute(atomicInstructionEClass, ATOMIC_INSTRUCTION__PARAMETER_CONVERSION);
		createEAttribute(atomicInstructionEClass, ATOMIC_INSTRUCTION__OPCODE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		scenarioEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		scenarioPreconditionEClass.getESuperTypes().add(this.getInstructionSequence());
		scenarioPreconditionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		instructionSequenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		sequenceElementEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		measurementStartEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		scenarioCoreEClass.getESuperTypes().add(this.getInstructionSequence());
		scenarioCoreEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		measurementEndEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		scenarioPostconditionEClass.getESuperTypes().add(this.getInstructionSequence());
		scenarioPostconditionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		namedCardinalityEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		instructionChainingEClass.getESuperTypes().add(this.getSequenceElement());
		instructionChainingEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		instructionLoopingEClass.getESuperTypes().add(this.getSequenceElement());
		instructionLoopingEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		atomicInstructionEClass.getESuperTypes().add(this.getSequenceElement());
		atomicInstructionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_Scenarioprecondition(), this.getScenarioPrecondition(), null, "scenarioprecondition", null, 1, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScenario_Measurementstart(), this.getMeasurementStart(), null, "measurementstart", null, 1, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScenario_Scenariocore(), this.getScenarioCore(), null, "scenariocore", null, 1, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScenario_Measurementend(), this.getMeasurementEnd(), null, "measurementend", null, 1, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScenario_Scenariopostcondition(), this.getScenarioPostcondition(), null, "scenariopostcondition", null, 1, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScenario_Namedcardinality(), this.getNamedCardinality(), null, "namedcardinality", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScenario_BenchmarkedInstruction(), this.getAtomicInstruction(), null, "benchmarkedInstruction", null, 1, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(scenarioPreconditionEClass, ScenarioPrecondition.class, "ScenarioPrecondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instructionSequenceEClass, InstructionSequence.class, "InstructionSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstructionSequence_Sequenceelement(), this.getSequenceElement(), null, "sequenceelement", null, 0, -1, InstructionSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sequenceElementEClass, SequenceElement.class, "SequenceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceElement_Successor(), this.getSequenceElement(), null, "successor", null, 0, 1, SequenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementStartEClass, MeasurementStart.class, "MeasurementStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scenarioCoreEClass, ScenarioCore.class, "ScenarioCore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measurementEndEClass, MeasurementEnd.class, "MeasurementEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scenarioPostconditionEClass, ScenarioPostcondition.class, "ScenarioPostcondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedCardinalityEClass, NamedCardinality.class, "NamedCardinality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedCardinality_CardinalityValue(), ecorePackage.getEInt(), "cardinalityValue", null, 1, 1, NamedCardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNamedCardinality_CardinalityName(), ecorePackage.getEString(), "cardinalityName", null, 1, 1, NamedCardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNamedCardinality_Instructionchaining(), this.getInstructionChaining(), this.getInstructionChaining_Namedcardinality(), "instructionchaining", null, 1, -1, NamedCardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNamedCardinality_Instructionlooping(), this.getInstructionLooping(), this.getInstructionLooping_Namedcardinality(), "instructionlooping", null, 1, -1, NamedCardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(instructionChainingEClass, InstructionChaining.class, "InstructionChaining", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstructionChaining_Instructionsequence(), this.getInstructionSequence(), null, "instructionsequence", null, 1, 1, InstructionChaining.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInstructionChaining_Namedcardinality(), this.getNamedCardinality(), this.getNamedCardinality_Instructionchaining(), "namedcardinality", null, 1, 1, InstructionChaining.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(instructionLoopingEClass, InstructionLooping.class, "InstructionLooping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstructionLooping_Instructionsequence(), this.getInstructionSequence(), null, "instructionsequence", null, 0, -1, InstructionLooping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInstructionLooping_Namedcardinality(), this.getNamedCardinality(), this.getNamedCardinality_Instructionlooping(), "namedcardinality", null, 1, 1, InstructionLooping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(atomicInstructionEClass, AtomicInstruction.class, "AtomicInstruction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtomicInstruction_ParameterValue(), ecorePackage.getEJavaObject(), "ParameterValue", null, 1, 1, AtomicInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAtomicInstruction_ParameterConversion(), ecorePackage.getEInt(), "ParameterConversion", null, 1, 1, AtomicInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAtomicInstruction_Opcode(), ecorePackage.getEInt(), "opcode", null, 1, 1, AtomicInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(atomicInstructionEClass, ecorePackage.getEBoolean(), "ensureValidOpcode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ByBenchPackageImpl
