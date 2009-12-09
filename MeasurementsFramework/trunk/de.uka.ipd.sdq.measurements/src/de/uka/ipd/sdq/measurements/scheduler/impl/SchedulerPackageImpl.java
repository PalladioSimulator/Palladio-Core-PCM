/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl;
import de.uka.ipd.sdq.measurements.scheduler.ParallelProcessTask;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementAfterIoTask;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerFactory;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage;
import de.uka.ipd.sdq.measurements.tasks.TasksPackage;
import de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl;
import de.uka.ipd.sdq.probespec.probespecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerPackageImpl extends EPackageImpl implements SchedulerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceStrategyMeasurementTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelProcessTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceStrategyMeasurementAfterIoTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resourceStrategyDemandEEnum = null;

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
	 * @see de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulerPackageImpl() {
		super(eNS_URI, SchedulerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SchedulerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchedulerPackage init() {
		if (isInited) return (SchedulerPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI);

		// Obtain or create and register package
		SchedulerPackageImpl theSchedulerPackage = (SchedulerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchedulerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchedulerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		probespecPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		MeasurementsPackageImpl theMeasurementsPackage = (MeasurementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasurementsPackage.eNS_URI) instanceof MeasurementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasurementsPackage.eNS_URI) : MeasurementsPackage.eINSTANCE);
		TasksPackageImpl theTasksPackage = (TasksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TasksPackage.eNS_URI) instanceof TasksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TasksPackage.eNS_URI) : TasksPackage.eINSTANCE);

		// Create package meta-data objects
		theSchedulerPackage.createPackageContents();
		theMeasurementsPackage.createPackageContents();
		theTasksPackage.createPackageContents();

		// Initialize created meta-data
		theSchedulerPackage.initializePackageContents();
		theMeasurementsPackage.initializePackageContents();
		theTasksPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchedulerPackage.eNS_URI, theSchedulerPackage);
		return theSchedulerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceStrategyMeasurementTask() {
		return resourceStrategyMeasurementTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceStrategyMeasurementTask_Duration() {
		return (EAttribute)resourceStrategyMeasurementTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceStrategyMeasurementTask_Demand() {
		return (EAttribute)resourceStrategyMeasurementTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelProcessTask() {
		return parallelProcessTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceStrategyMeasurementAfterIoTask() {
		return resourceStrategyMeasurementAfterIoTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResourceStrategyDemand() {
		return resourceStrategyDemandEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerFactory getSchedulerFactory() {
		return (SchedulerFactory)getEFactoryInstance();
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
		resourceStrategyMeasurementTaskEClass = createEClass(RESOURCE_STRATEGY_MEASUREMENT_TASK);
		createEAttribute(resourceStrategyMeasurementTaskEClass, RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION);
		createEAttribute(resourceStrategyMeasurementTaskEClass, RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND);

		parallelProcessTaskEClass = createEClass(PARALLEL_PROCESS_TASK);

		resourceStrategyMeasurementAfterIoTaskEClass = createEClass(RESOURCE_STRATEGY_MEASUREMENT_AFTER_IO_TASK);

		// Create enums
		resourceStrategyDemandEEnum = createEEnum(RESOURCE_STRATEGY_DEMAND);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		resourceStrategyMeasurementTaskEClass.getESuperTypes().add(theTasksPackage.getMachineTask());
		parallelProcessTaskEClass.getESuperTypes().add(theTasksPackage.getParallelTask());
		resourceStrategyMeasurementAfterIoTaskEClass.getESuperTypes().add(this.getResourceStrategyMeasurementTask());

		// Initialize classes and features; add operations and parameters
		initEClass(resourceStrategyMeasurementTaskEClass, ResourceStrategyMeasurementTask.class, "ResourceStrategyMeasurementTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceStrategyMeasurementTask_Duration(), ecorePackage.getEInt(), "duration", null, 1, 1, ResourceStrategyMeasurementTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getResourceStrategyMeasurementTask_Demand(), this.getResourceStrategyDemand(), "demand", null, 1, 1, ResourceStrategyMeasurementTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parallelProcessTaskEClass, ParallelProcessTask.class, "ParallelProcessTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceStrategyMeasurementAfterIoTaskEClass, ResourceStrategyMeasurementAfterIoTask.class, "ResourceStrategyMeasurementAfterIoTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(resourceStrategyDemandEEnum, ResourceStrategyDemand.class, "ResourceStrategyDemand");
		addEEnumLiteral(resourceStrategyDemandEEnum, ResourceStrategyDemand.MANDELBROT_DEMAND);
		addEEnumLiteral(resourceStrategyDemandEEnum, ResourceStrategyDemand.FIBONACCI_DEMAND);
		addEEnumLiteral(resourceStrategyDemandEEnum, ResourceStrategyDemand.WAIT_DEMAND);
		addEEnumLiteral(resourceStrategyDemandEEnum, ResourceStrategyDemand.READ_FROM_HDD_DEMAND);
	}

} //SchedulerPackageImpl
