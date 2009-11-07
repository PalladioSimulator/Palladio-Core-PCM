/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage;
import de.uka.ipd.sdq.measurements.scheduler.impl.SchedulerPackageImpl;
import de.uka.ipd.sdq.measurements.tasks.AbstractTask;
import de.uka.ipd.sdq.measurements.tasks.LoopTask;
import de.uka.ipd.sdq.measurements.tasks.MachineTask;
import de.uka.ipd.sdq.measurements.tasks.ParallelTask;
import de.uka.ipd.sdq.measurements.tasks.SequenceTask;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;
import de.uka.ipd.sdq.measurements.tasks.TasksFactory;
import de.uka.ipd.sdq.measurements.tasks.TasksPackage;
import de.uka.ipd.sdq.probespec.probespecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TasksPackageImpl extends EPackageImpl implements TasksPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass machineTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskSetEClass = null;

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
	 * @see de.uka.ipd.sdq.measurements.tasks.TasksPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TasksPackageImpl() {
		super(eNS_URI, TasksFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TasksPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TasksPackage init() {
		if (isInited) return (TasksPackage)EPackage.Registry.INSTANCE.getEPackage(TasksPackage.eNS_URI);

		// Obtain or create and register package
		TasksPackageImpl theTasksPackage = (TasksPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TasksPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TasksPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		probespecPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		MeasurementsPackageImpl theMeasurementsPackage = (MeasurementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasurementsPackage.eNS_URI) instanceof MeasurementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasurementsPackage.eNS_URI) : MeasurementsPackage.eINSTANCE);
		SchedulerPackageImpl theSchedulerPackage = (SchedulerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI) instanceof SchedulerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI) : SchedulerPackage.eINSTANCE);

		// Create package meta-data objects
		theTasksPackage.createPackageContents();
		theMeasurementsPackage.createPackageContents();
		theSchedulerPackage.createPackageContents();

		// Initialize created meta-data
		theTasksPackage.initializePackageContents();
		theMeasurementsPackage.initializePackageContents();
		theSchedulerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTasksPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TasksPackage.eNS_URI, theTasksPackage);
		return theTasksPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTask() {
		return abstractTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTask_Description() {
		return (EAttribute)abstractTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTask_Name() {
		return (EAttribute)abstractTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopTask() {
		return loopTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopTask_NumberOfIterations() {
		return (EAttribute)loopTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopTask_Task() {
		return (EReference)loopTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMachineTask() {
		return machineTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMachineTask_Machine() {
		return (EReference)machineTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelTask() {
		return parallelTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParallelTask_Tasks() {
		return (EReference)parallelTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceTask() {
		return sequenceTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceTask_Tasks() {
		return (EReference)sequenceTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskSet() {
		return taskSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSet_Name() {
		return (EAttribute)taskSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskSet_RootTask() {
		return (EReference)taskSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskSet_ProbeSpecRepository() {
		return (EReference)taskSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskSet_MachineReferences() {
		return (EReference)taskSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasksFactory getTasksFactory() {
		return (TasksFactory)getEFactoryInstance();
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
		abstractTaskEClass = createEClass(ABSTRACT_TASK);
		createEAttribute(abstractTaskEClass, ABSTRACT_TASK__DESCRIPTION);
		createEAttribute(abstractTaskEClass, ABSTRACT_TASK__NAME);

		loopTaskEClass = createEClass(LOOP_TASK);
		createEAttribute(loopTaskEClass, LOOP_TASK__NUMBER_OF_ITERATIONS);
		createEReference(loopTaskEClass, LOOP_TASK__TASK);

		machineTaskEClass = createEClass(MACHINE_TASK);
		createEReference(machineTaskEClass, MACHINE_TASK__MACHINE);

		parallelTaskEClass = createEClass(PARALLEL_TASK);
		createEReference(parallelTaskEClass, PARALLEL_TASK__TASKS);

		sequenceTaskEClass = createEClass(SEQUENCE_TASK);
		createEReference(sequenceTaskEClass, SEQUENCE_TASK__TASKS);

		taskSetEClass = createEClass(TASK_SET);
		createEAttribute(taskSetEClass, TASK_SET__NAME);
		createEReference(taskSetEClass, TASK_SET__ROOT_TASK);
		createEReference(taskSetEClass, TASK_SET__PROBE_SPEC_REPOSITORY);
		createEReference(taskSetEClass, TASK_SET__MACHINE_REFERENCES);
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
		MeasurementsPackage theMeasurementsPackage = (MeasurementsPackage)EPackage.Registry.INSTANCE.getEPackage(MeasurementsPackage.eNS_URI);
		probespecPackage theprobespecPackage = (probespecPackage)EPackage.Registry.INSTANCE.getEPackage(probespecPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractTaskEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		loopTaskEClass.getESuperTypes().add(this.getAbstractTask());
		machineTaskEClass.getESuperTypes().add(this.getAbstractTask());
		parallelTaskEClass.getESuperTypes().add(this.getAbstractTask());
		sequenceTaskEClass.getESuperTypes().add(this.getAbstractTask());
		taskSetEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractTaskEClass, AbstractTask.class, "AbstractTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractTask_Description(), ecorePackage.getEString(), "description", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractTask_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(loopTaskEClass, LoopTask.class, "LoopTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopTask_NumberOfIterations(), ecorePackage.getEInt(), "numberOfIterations", "1", 1, 1, LoopTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLoopTask_Task(), this.getAbstractTask(), null, "task", null, 1, 1, LoopTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(machineTaskEClass, MachineTask.class, "MachineTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMachineTask_Machine(), theMeasurementsPackage.getMachineReference(), null, "machine", null, 1, 1, MachineTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parallelTaskEClass, ParallelTask.class, "ParallelTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParallelTask_Tasks(), this.getAbstractTask(), null, "tasks", null, 1, -1, ParallelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sequenceTaskEClass, SequenceTask.class, "SequenceTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceTask_Tasks(), this.getAbstractTask(), null, "tasks", null, 1, -1, SequenceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(taskSetEClass, TaskSet.class, "TaskSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaskSet_Name(), ecorePackage.getEString(), "name", null, 1, 1, TaskSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTaskSet_RootTask(), this.getAbstractTask(), null, "rootTask", null, 1, 1, TaskSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTaskSet_ProbeSpecRepository(), theprobespecPackage.getProbeSpecRepository(), null, "probeSpecRepository", null, 0, 1, TaskSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTaskSet_MachineReferences(), theMeasurementsPackage.getMachineReference(), null, "machineReferences", null, 0, -1, TaskSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //TasksPackageImpl
