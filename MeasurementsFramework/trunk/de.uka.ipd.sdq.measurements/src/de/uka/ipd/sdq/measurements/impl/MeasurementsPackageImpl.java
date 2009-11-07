/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.MachineMapping;
import de.uka.ipd.sdq.measurements.MachineReference;
import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.MeasurementsFactory;
import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.PlainMachineReference;
import de.uka.ipd.sdq.measurements.VirtualMachineReference;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage;
import de.uka.ipd.sdq.measurements.scheduler.impl.SchedulerPackageImpl;
import de.uka.ipd.sdq.measurements.tasks.TasksPackage;
import de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl;
import de.uka.ipd.sdq.probespec.probespecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasurementsPackageImpl extends EPackageImpl implements MeasurementsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualMachineReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass machineReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plainMachineReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementScriptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass machineDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass machineMappingEClass = null;

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
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MeasurementsPackageImpl() {
		super(eNS_URI, MeasurementsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MeasurementsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MeasurementsPackage init() {
		if (isInited) return (MeasurementsPackage)EPackage.Registry.INSTANCE.getEPackage(MeasurementsPackage.eNS_URI);

		// Obtain or create and register package
		MeasurementsPackageImpl theMeasurementsPackage = (MeasurementsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MeasurementsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MeasurementsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		probespecPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TasksPackageImpl theTasksPackage = (TasksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TasksPackage.eNS_URI) instanceof TasksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TasksPackage.eNS_URI) : TasksPackage.eINSTANCE);
		SchedulerPackageImpl theSchedulerPackage = (SchedulerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI) instanceof SchedulerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI) : SchedulerPackage.eINSTANCE);

		// Create package meta-data objects
		theMeasurementsPackage.createPackageContents();
		theTasksPackage.createPackageContents();
		theSchedulerPackage.createPackageContents();

		// Initialize created meta-data
		theMeasurementsPackage.initializePackageContents();
		theTasksPackage.initializePackageContents();
		theSchedulerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMeasurementsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MeasurementsPackage.eNS_URI, theMeasurementsPackage);
		return theMeasurementsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualMachineReference() {
		return virtualMachineReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualMachineReference_HostMachine() {
		return (EReference)virtualMachineReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMachineReference() {
		return machineReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMachineReference_Name() {
		return (EAttribute)machineReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlainMachineReference() {
		return plainMachineReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementScript() {
		return measurementScriptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementScript_TaskSets() {
		return (EReference)measurementScriptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementScript_MachineDescriptions() {
		return (EReference)measurementScriptEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMachineDescription() {
		return machineDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMachineDescription_Name() {
		return (EAttribute)machineDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMachineDescription_Ip() {
		return (EAttribute)machineDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMachineDescription_MachineMappings() {
		return (EReference)machineDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMachineMapping() {
		return machineMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMachineMapping_MachineReference() {
		return (EReference)machineMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementsFactory getMeasurementsFactory() {
		return (MeasurementsFactory)getEFactoryInstance();
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
		virtualMachineReferenceEClass = createEClass(VIRTUAL_MACHINE_REFERENCE);
		createEReference(virtualMachineReferenceEClass, VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE);

		machineReferenceEClass = createEClass(MACHINE_REFERENCE);
		createEAttribute(machineReferenceEClass, MACHINE_REFERENCE__NAME);

		plainMachineReferenceEClass = createEClass(PLAIN_MACHINE_REFERENCE);

		measurementScriptEClass = createEClass(MEASUREMENT_SCRIPT);
		createEReference(measurementScriptEClass, MEASUREMENT_SCRIPT__TASK_SETS);
		createEReference(measurementScriptEClass, MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS);

		machineDescriptionEClass = createEClass(MACHINE_DESCRIPTION);
		createEAttribute(machineDescriptionEClass, MACHINE_DESCRIPTION__NAME);
		createEAttribute(machineDescriptionEClass, MACHINE_DESCRIPTION__IP);
		createEReference(machineDescriptionEClass, MACHINE_DESCRIPTION__MACHINE_MAPPINGS);

		machineMappingEClass = createEClass(MACHINE_MAPPING);
		createEReference(machineMappingEClass, MACHINE_MAPPING__MACHINE_REFERENCE);
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
		TasksPackage theTasksPackage = (TasksPackage)EPackage.Registry.INSTANCE.getEPackage(TasksPackage.eNS_URI);
		SchedulerPackage theSchedulerPackage = (SchedulerPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theTasksPackage);
		getESubpackages().add(theSchedulerPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		virtualMachineReferenceEClass.getESuperTypes().add(this.getMachineReference());
		machineReferenceEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		plainMachineReferenceEClass.getESuperTypes().add(this.getMachineReference());
		machineDescriptionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		machineMappingEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(virtualMachineReferenceEClass, VirtualMachineReference.class, "VirtualMachineReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVirtualMachineReference_HostMachine(), this.getPlainMachineReference(), null, "hostMachine", null, 1, 1, VirtualMachineReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(machineReferenceEClass, MachineReference.class, "MachineReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMachineReference_Name(), ecorePackage.getEString(), "name", null, 1, 1, MachineReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(plainMachineReferenceEClass, PlainMachineReference.class, "PlainMachineReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measurementScriptEClass, MeasurementScript.class, "MeasurementScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurementScript_TaskSets(), theTasksPackage.getTaskSet(), null, "taskSets", null, 1, -1, MeasurementScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementScript_MachineDescriptions(), this.getMachineDescription(), null, "machineDescriptions", null, 0, -1, MeasurementScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(machineDescriptionEClass, MachineDescription.class, "MachineDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMachineDescription_Name(), ecorePackage.getEString(), "name", null, 1, 1, MachineDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMachineDescription_Ip(), ecorePackage.getEString(), "ip", null, 1, 1, MachineDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMachineDescription_MachineMappings(), this.getMachineMapping(), null, "machineMappings", null, 0, -1, MachineDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(machineMappingEClass, MachineMapping.class, "MachineMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMachineMapping_MachineReference(), this.getMachineReference(), null, "machineReference", null, 1, 1, MachineMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MeasurementsPackageImpl
