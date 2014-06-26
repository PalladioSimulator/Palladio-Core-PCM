/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.BlackboardType;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.FileDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MemoryDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.PersistenceFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.ProbeSpecConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;

import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventsimPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventsimPackageImpl;

import de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentsPackageImpl;

import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.SimcompPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.impl.SimcompPackageImpl;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimucomPackage;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimucomPackageImpl;

import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;

import de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractSimulationPackageImpl extends EPackageImpl implements AbstractSimulationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSimulationConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass persistenceFrameworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomNumberGeneratorSeedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probeSpecConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorFrameworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorFrameworkDatasourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryDatasourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileDatasourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementCountStopConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simTimeStopConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stopConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum blackboardTypeEEnum = null;

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
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AbstractSimulationPackageImpl() {
		super(eNS_URI, AbstractSimulationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AbstractSimulationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AbstractSimulationPackage init() {
		if (isInited) return (AbstractSimulationPackage)EPackage.Registry.INSTANCE.getEPackage(AbstractSimulationPackage.eNS_URI);

		// Obtain or create and register package
		AbstractSimulationPackageImpl theAbstractSimulationPackage = (AbstractSimulationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AbstractSimulationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AbstractSimulationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		VariationPackageImpl theVariationPackage = (VariationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VariationPackage.eNS_URI) instanceof VariationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VariationPackage.eNS_URI) : VariationPackage.eINSTANCE);
		ExperimentsPackageImpl theExperimentsPackage = (ExperimentsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentsPackage.eNS_URI) instanceof ExperimentsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentsPackage.eNS_URI) : ExperimentsPackage.eINSTANCE);
		SimucomPackageImpl theSimucomPackage = (SimucomPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimucomPackage.eNS_URI) instanceof SimucomPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimucomPackage.eNS_URI) : SimucomPackage.eINSTANCE);
		EventsimPackageImpl theEventsimPackage = (EventsimPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventsimPackage.eNS_URI) instanceof EventsimPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsimPackage.eNS_URI) : EventsimPackage.eINSTANCE);
		SimcompPackageImpl theSimcompPackage = (SimcompPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimcompPackage.eNS_URI) instanceof SimcompPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimcompPackage.eNS_URI) : SimcompPackage.eINSTANCE);

		// Create package meta-data objects
		theAbstractSimulationPackage.createPackageContents();
		theVariationPackage.createPackageContents();
		theExperimentsPackage.createPackageContents();
		theSimucomPackage.createPackageContents();
		theEventsimPackage.createPackageContents();
		theSimcompPackage.createPackageContents();

		// Initialize created meta-data
		theAbstractSimulationPackage.initializePackageContents();
		theVariationPackage.initializePackageContents();
		theExperimentsPackage.initializePackageContents();
		theSimucomPackage.initializePackageContents();
		theEventsimPackage.initializePackageContents();
		theSimcompPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAbstractSimulationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AbstractSimulationPackage.eNS_URI, theAbstractSimulationPackage);
		return theAbstractSimulationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSimulationConfiguration() {
		return abstractSimulationConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSimulationConfiguration_PersistenceFramework() {
		return (EReference)abstractSimulationConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSimulationConfiguration_StopConditions() {
		return (EReference)abstractSimulationConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSimulationConfiguration_RandomNumberGeneratorSeed() {
		return (EReference)abstractSimulationConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSimulationConfiguration_SimulateLinkingResources() {
		return (EAttribute)abstractSimulationConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSimulationConfiguration_SimulateFailures() {
		return (EAttribute)abstractSimulationConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSimulationConfiguration_ProbeSpecConfiguration() {
		return (EReference)abstractSimulationConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersistenceFramework() {
		return persistenceFrameworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomNumberGeneratorSeed() {
		return randomNumberGeneratorSeedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberGeneratorSeed_Seed0() {
		return (EAttribute)randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberGeneratorSeed_Seed1() {
		return (EAttribute)randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberGeneratorSeed_Seed2() {
		return (EAttribute)randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberGeneratorSeed_Seed3() {
		return (EAttribute)randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberGeneratorSeed_Seed4() {
		return (EAttribute)randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberGeneratorSeed_Seed5() {
		return (EAttribute)randomNumberGeneratorSeedEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbeSpecConfiguration() {
		return probeSpecConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProbeSpecConfiguration_BlackboardType() {
		return (EAttribute)probeSpecConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensorFramework() {
		return sensorFrameworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensorFramework_Datasource() {
		return (EReference)sensorFrameworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensorFrameworkDatasource() {
		return sensorFrameworkDatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryDatasource() {
		return memoryDatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileDatasource() {
		return fileDatasourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileDatasource_Location() {
		return (EAttribute)fileDatasourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementCountStopCondition() {
		return measurementCountStopConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementCountStopCondition_MeasurementCount() {
		return (EAttribute)measurementCountStopConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimTimeStopCondition() {
		return simTimeStopConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimTimeStopCondition_SimulationTime() {
		return (EAttribute)simTimeStopConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStopCondition() {
		return stopConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBlackboardType() {
		return blackboardTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSimulationFactory getAbstractSimulationFactory() {
		return (AbstractSimulationFactory)getEFactoryInstance();
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
		abstractSimulationConfigurationEClass = createEClass(ABSTRACT_SIMULATION_CONFIGURATION);
		createEReference(abstractSimulationConfigurationEClass, ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK);
		createEReference(abstractSimulationConfigurationEClass, ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS);
		createEReference(abstractSimulationConfigurationEClass, ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED);
		createEAttribute(abstractSimulationConfigurationEClass, ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES);
		createEAttribute(abstractSimulationConfigurationEClass, ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES);
		createEReference(abstractSimulationConfigurationEClass, ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION);

		persistenceFrameworkEClass = createEClass(PERSISTENCE_FRAMEWORK);

		randomNumberGeneratorSeedEClass = createEClass(RANDOM_NUMBER_GENERATOR_SEED);
		createEAttribute(randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED0);
		createEAttribute(randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED1);
		createEAttribute(randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED2);
		createEAttribute(randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED3);
		createEAttribute(randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED4);
		createEAttribute(randomNumberGeneratorSeedEClass, RANDOM_NUMBER_GENERATOR_SEED__SEED5);

		probeSpecConfigurationEClass = createEClass(PROBE_SPEC_CONFIGURATION);
		createEAttribute(probeSpecConfigurationEClass, PROBE_SPEC_CONFIGURATION__BLACKBOARD_TYPE);

		sensorFrameworkEClass = createEClass(SENSOR_FRAMEWORK);
		createEReference(sensorFrameworkEClass, SENSOR_FRAMEWORK__DATASOURCE);

		sensorFrameworkDatasourceEClass = createEClass(SENSOR_FRAMEWORK_DATASOURCE);

		memoryDatasourceEClass = createEClass(MEMORY_DATASOURCE);

		fileDatasourceEClass = createEClass(FILE_DATASOURCE);
		createEAttribute(fileDatasourceEClass, FILE_DATASOURCE__LOCATION);

		measurementCountStopConditionEClass = createEClass(MEASUREMENT_COUNT_STOP_CONDITION);
		createEAttribute(measurementCountStopConditionEClass, MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT);

		simTimeStopConditionEClass = createEClass(SIM_TIME_STOP_CONDITION);
		createEAttribute(simTimeStopConditionEClass, SIM_TIME_STOP_CONDITION__SIMULATION_TIME);

		stopConditionEClass = createEClass(STOP_CONDITION);

		// Create enums
		blackboardTypeEEnum = createEEnum(BLACKBOARD_TYPE);
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
		ExperimentsPackage theExperimentsPackage = (ExperimentsPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractSimulationConfigurationEClass.getESuperTypes().add(theExperimentsPackage.getToolConfiguration());
		sensorFrameworkEClass.getESuperTypes().add(this.getPersistenceFramework());
		memoryDatasourceEClass.getESuperTypes().add(this.getSensorFrameworkDatasource());
		fileDatasourceEClass.getESuperTypes().add(this.getSensorFrameworkDatasource());
		measurementCountStopConditionEClass.getESuperTypes().add(this.getStopCondition());
		simTimeStopConditionEClass.getESuperTypes().add(this.getStopCondition());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractSimulationConfigurationEClass, AbstractSimulationConfiguration.class, "AbstractSimulationConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractSimulationConfiguration_PersistenceFramework(), this.getPersistenceFramework(), null, "persistenceFramework", null, 1, 1, AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractSimulationConfiguration_StopConditions(), this.getStopCondition(), null, "stopConditions", null, 1, -1, AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractSimulationConfiguration_RandomNumberGeneratorSeed(), this.getRandomNumberGeneratorSeed(), null, "randomNumberGeneratorSeed", null, 0, 1, AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractSimulationConfiguration_SimulateLinkingResources(), ecorePackage.getEBoolean(), "simulateLinkingResources", null, 1, 1, AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractSimulationConfiguration_SimulateFailures(), ecorePackage.getEBoolean(), "simulateFailures", null, 1, 1, AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractSimulationConfiguration_ProbeSpecConfiguration(), this.getProbeSpecConfiguration(), null, "probeSpecConfiguration", null, 1, 1, AbstractSimulationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(persistenceFrameworkEClass, PersistenceFramework.class, "PersistenceFramework", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomNumberGeneratorSeedEClass, RandomNumberGeneratorSeed.class, "RandomNumberGeneratorSeed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomNumberGeneratorSeed_Seed0(), ecorePackage.getEInt(), "seed0", null, 1, 1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRandomNumberGeneratorSeed_Seed1(), ecorePackage.getEInt(), "seed1", null, 1, 1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRandomNumberGeneratorSeed_Seed2(), ecorePackage.getEInt(), "seed2", null, 1, 1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRandomNumberGeneratorSeed_Seed3(), ecorePackage.getEInt(), "seed3", null, 1, 1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRandomNumberGeneratorSeed_Seed4(), ecorePackage.getEInt(), "seed4", null, 1, 1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRandomNumberGeneratorSeed_Seed5(), ecorePackage.getEInt(), "seed5", null, 1, 1, RandomNumberGeneratorSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(probeSpecConfigurationEClass, ProbeSpecConfiguration.class, "ProbeSpecConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProbeSpecConfiguration_BlackboardType(), this.getBlackboardType(), "blackboardType", null, 1, 1, ProbeSpecConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorFrameworkEClass, SensorFramework.class, "SensorFramework", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSensorFramework_Datasource(), this.getSensorFrameworkDatasource(), null, "datasource", null, 1, 1, SensorFramework.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorFrameworkDatasourceEClass, SensorFrameworkDatasource.class, "SensorFrameworkDatasource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryDatasourceEClass, MemoryDatasource.class, "MemoryDatasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileDatasourceEClass, FileDatasource.class, "FileDatasource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileDatasource_Location(), ecorePackage.getEString(), "location", null, 1, 1, FileDatasource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementCountStopConditionEClass, MeasurementCountStopCondition.class, "MeasurementCountStopCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasurementCountStopCondition_MeasurementCount(), ecorePackage.getEInt(), "measurementCount", null, 1, 1, MeasurementCountStopCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(simTimeStopConditionEClass, SimTimeStopCondition.class, "SimTimeStopCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimTimeStopCondition_SimulationTime(), ecorePackage.getEInt(), "simulationTime", null, 1, 1, SimTimeStopCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stopConditionEClass, StopCondition.class, "StopCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(blackboardTypeEEnum, BlackboardType.class, "BlackboardType");
		addEEnumLiteral(blackboardTypeEEnum, BlackboardType.SIMPLE);
		addEEnumLiteral(blackboardTypeEEnum, BlackboardType.CONCURRENT);
		addEEnumLiteral(blackboardTypeEEnum, BlackboardType.NONE);
	}

} //AbstractSimulationPackageImpl
