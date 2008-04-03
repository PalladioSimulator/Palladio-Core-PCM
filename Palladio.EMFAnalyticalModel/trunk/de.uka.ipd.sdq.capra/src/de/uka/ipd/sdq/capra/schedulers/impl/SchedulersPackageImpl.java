/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.impl;

import de.uka.ipd.sdq.capra.CapraPackage;

import de.uka.ipd.sdq.capra.core.CorePackage;

import de.uka.ipd.sdq.capra.core.impl.CorePackageImpl;

import de.uka.ipd.sdq.capra.experiment.ExperimentPackage;

import de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl;

import de.uka.ipd.sdq.capra.extension.ExtensionPackage;

import de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl;

import de.uka.ipd.sdq.capra.impl.CapraPackageImpl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;

import de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl;

import de.uka.ipd.sdq.capra.resources.ResourcesPackage;

import de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl;

import de.uka.ipd.sdq.capra.schedulers.Assignment;
import de.uka.ipd.sdq.capra.schedulers.BigOClass;
import de.uka.ipd.sdq.capra.schedulers.LoadBalancing;
import de.uka.ipd.sdq.capra.schedulers.NonPreemptive;
import de.uka.ipd.sdq.capra.schedulers.Preemptive;
import de.uka.ipd.sdq.capra.schedulers.Preference;
import de.uka.ipd.sdq.capra.schedulers.Priority;
import de.uka.ipd.sdq.capra.schedulers.PriorityType;
import de.uka.ipd.sdq.capra.schedulers.PriortyQuantums;
import de.uka.ipd.sdq.capra.schedulers.Quantum;
import de.uka.ipd.sdq.capra.schedulers.Scheduler;
import de.uka.ipd.sdq.capra.schedulers.SchedulersFactory;
import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;
import de.uka.ipd.sdq.capra.schedulers.SelectionPolicy;
import de.uka.ipd.sdq.capra.schedulers.TimeConsumption;
import de.uka.ipd.sdq.capra.schedulers.WaitingTime;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulersPackageImpl extends EPackageImpl implements SchedulersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeConsumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonPreemptiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preemptiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quantumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitingTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priortyQuantumsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum loadBalancingEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bigOClassEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum preferenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum priorityTypeEEnum = null;

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
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulersPackageImpl() {
		super(eNS_URI, SchedulersFactory.eINSTANCE);
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
	public static SchedulersPackage init() {
		if (isInited) return (SchedulersPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI);

		// Obtain or create and register package
		SchedulersPackageImpl theSchedulersPackage = (SchedulersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SchedulersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SchedulersPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		SchedulerPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CapraPackageImpl theCapraPackage = (CapraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) instanceof CapraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) : CapraPackage.eINSTANCE);
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ResourcesPackageImpl theResourcesPackage = (ResourcesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) instanceof ResourcesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) : ResourcesPackage.eINSTANCE);
		MeasurementPackageImpl theMeasurementPackage = (MeasurementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) instanceof MeasurementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) : MeasurementPackage.eINSTANCE);
		ExtensionPackageImpl theExtensionPackage = (ExtensionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) instanceof ExtensionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) : ExtensionPackage.eINSTANCE);

		// Create package meta-data objects
		theSchedulersPackage.createPackageContents();
		theCapraPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theResourcesPackage.createPackageContents();
		theMeasurementPackage.createPackageContents();
		theExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theSchedulersPackage.initializePackageContents();
		theCapraPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theResourcesPackage.initializePackageContents();
		theMeasurementPackage.initializePackageContents();
		theExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulersPackage.freeze();

		return theSchedulersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionPolicy() {
		return selectionPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeConsumption() {
		return timeConsumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConsumption_Time() {
		return (EAttribute)timeConsumptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConsumption_Scaling() {
		return (EAttribute)timeConsumptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonPreemptive() {
		return nonPreemptiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreemptive() {
		return preemptiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreemptive_Immediate() {
		return (EAttribute)preemptiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreemptive_Quantum() {
		return (EReference)preemptiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuantum() {
		return quantumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuantum_TimeSlice() {
		return (EAttribute)quantumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWaitingTime() {
		return waitingTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriority() {
		return priorityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriority_HasDynamicPriority() {
		return (EAttribute)priorityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriority_Preference() {
		return (EAttribute)priorityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriortyQuantums() {
		return priortyQuantumsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriortyQuantums_Priority() {
		return (EAttribute)priortyQuantumsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriortyQuantums_NumberOfQuantums() {
		return (EAttribute)priortyQuantumsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduler() {
		return schedulerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduler_Assignment() {
		return (EReference)schedulerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduler_Selectionpolicy() {
		return (EReference)schedulerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduler_Timeconsumption() {
		return (EReference)schedulerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduler_Name() {
		return (EAttribute)schedulerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduler_LoadBalancing() {
		return (EAttribute)schedulerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLoadBalancing() {
		return loadBalancingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBigOClass() {
		return bigOClassEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPreference() {
		return preferenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPriorityType() {
		return priorityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulersFactory getSchedulersFactory() {
		return (SchedulersFactory)getEFactoryInstance();
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
		assignmentEClass = createEClass(ASSIGNMENT);

		selectionPolicyEClass = createEClass(SELECTION_POLICY);

		timeConsumptionEClass = createEClass(TIME_CONSUMPTION);
		createEAttribute(timeConsumptionEClass, TIME_CONSUMPTION__TIME);
		createEAttribute(timeConsumptionEClass, TIME_CONSUMPTION__SCALING);

		nonPreemptiveEClass = createEClass(NON_PREEMPTIVE);

		preemptiveEClass = createEClass(PREEMPTIVE);
		createEAttribute(preemptiveEClass, PREEMPTIVE__IMMEDIATE);
		createEReference(preemptiveEClass, PREEMPTIVE__QUANTUM);

		quantumEClass = createEClass(QUANTUM);
		createEAttribute(quantumEClass, QUANTUM__TIME_SLICE);

		waitingTimeEClass = createEClass(WAITING_TIME);

		priorityEClass = createEClass(PRIORITY);
		createEAttribute(priorityEClass, PRIORITY__HAS_DYNAMIC_PRIORITY);
		createEAttribute(priorityEClass, PRIORITY__PREFERENCE);

		priortyQuantumsEClass = createEClass(PRIORTY_QUANTUMS);
		createEAttribute(priortyQuantumsEClass, PRIORTY_QUANTUMS__PRIORITY);
		createEAttribute(priortyQuantumsEClass, PRIORTY_QUANTUMS__NUMBER_OF_QUANTUMS);

		schedulerEClass = createEClass(SCHEDULER);
		createEReference(schedulerEClass, SCHEDULER__ASSIGNMENT);
		createEReference(schedulerEClass, SCHEDULER__SELECTIONPOLICY);
		createEReference(schedulerEClass, SCHEDULER__TIMECONSUMPTION);
		createEAttribute(schedulerEClass, SCHEDULER__NAME);
		createEAttribute(schedulerEClass, SCHEDULER__LOAD_BALANCING);

		// Create enums
		loadBalancingEEnum = createEEnum(LOAD_BALANCING);
		bigOClassEEnum = createEEnum(BIG_OCLASS);
		preferenceEEnum = createEEnum(PREFERENCE);
		priorityTypeEEnum = createEEnum(PRIORITY_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nonPreemptiveEClass.getESuperTypes().add(this.getAssignment());
		preemptiveEClass.getESuperTypes().add(this.getAssignment());
		waitingTimeEClass.getESuperTypes().add(this.getSelectionPolicy());
		priorityEClass.getESuperTypes().add(this.getSelectionPolicy());

		// Initialize classes and features; add operations and parameters
		initEClass(assignmentEClass, Assignment.class, "Assignment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(selectionPolicyEClass, SelectionPolicy.class, "SelectionPolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeConsumptionEClass, TimeConsumption.class, "TimeConsumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeConsumption_Time(), ecorePackage.getEDouble(), "time", null, 1, 1, TimeConsumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTimeConsumption_Scaling(), this.getBigOClass(), "scaling", "Constant", 1, 1, TimeConsumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nonPreemptiveEClass, NonPreemptive.class, "NonPreemptive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(preemptiveEClass, Preemptive.class, "Preemptive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreemptive_Immediate(), ecorePackage.getEBoolean(), "immediate", null, 1, 1, Preemptive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPreemptive_Quantum(), this.getQuantum(), null, "quantum", null, 1, 1, Preemptive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quantumEClass, Quantum.class, "Quantum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuantum_TimeSlice(), ecorePackage.getEDouble(), "timeSlice", "0", 1, 1, Quantum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(waitingTimeEClass, WaitingTime.class, "WaitingTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(priorityEClass, Priority.class, "Priority", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPriority_HasDynamicPriority(), ecorePackage.getEBoolean(), "hasDynamicPriority", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriority_Preference(), this.getPreference(), "preference", "Hard", 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(priortyQuantumsEClass, PriortyQuantums.class, "PriortyQuantums", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPriortyQuantums_Priority(), ecorePackage.getEInt(), "priority", null, 1, 1, PriortyQuantums.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriortyQuantums_NumberOfQuantums(), ecorePackage.getEInt(), "numberOfQuantums", null, 1, 1, PriortyQuantums.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(schedulerEClass, Scheduler.class, "Scheduler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduler_Assignment(), this.getAssignment(), null, "assignment", null, 1, 1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduler_Selectionpolicy(), this.getSelectionPolicy(), null, "selectionpolicy", null, 1, 1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduler_Timeconsumption(), this.getTimeConsumption(), null, "timeconsumption", null, 1, 1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getScheduler_Name(), ecorePackage.getEString(), "name", null, 1, 1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getScheduler_LoadBalancing(), this.getLoadBalancing(), "loadBalancing", "OnIdle", 1, 1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(loadBalancingEEnum, LoadBalancing.class, "LoadBalancing");
		addEEnumLiteral(loadBalancingEEnum, LoadBalancing.ON_IDLE);
		addEEnumLiteral(loadBalancingEEnum, LoadBalancing.ON_THRESHOLD);

		initEEnum(bigOClassEEnum, BigOClass.class, "BigOClass");
		addEEnumLiteral(bigOClassEEnum, BigOClass.CONSTANT);
		addEEnumLiteral(bigOClassEEnum, BigOClass.LINEAR);
		addEEnumLiteral(bigOClassEEnum, BigOClass.SQUARE);

		initEEnum(preferenceEEnum, Preference.class, "Preference");
		addEEnumLiteral(preferenceEEnum, Preference.HARD);
		addEEnumLiteral(preferenceEEnum, Preference.SOFT);

		initEEnum(priorityTypeEEnum, PriorityType.class, "PriorityType");
		addEEnumLiteral(priorityTypeEEnum, PriorityType.STATIC);
	}

} //SchedulersPackageImpl
