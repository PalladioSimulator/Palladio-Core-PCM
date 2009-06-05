/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.CapraPackage;

import de.uka.ipd.sdq.capra.core.CorePackage;

import de.uka.ipd.sdq.capra.core.impl.CorePackageImpl;

import de.uka.ipd.sdq.capra.experiment.ExperimentPackage;

import de.uka.ipd.sdq.capra.experiment.impl.ExperimentPackageImpl;

import de.uka.ipd.sdq.capra.extension.ExtensionPackage;

import de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl;

import de.uka.ipd.sdq.capra.impl.CapraPackageImpl;

import de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.Condition;
import de.uka.ipd.sdq.capra.measurement.CountingRecorder;
import de.uka.ipd.sdq.capra.measurement.CountingSensor;
import de.uka.ipd.sdq.capra.measurement.FinalValueRecorder;
import de.uka.ipd.sdq.capra.measurement.FullStateRecorder;
import de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.measurement.GlobalTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.HistogramRecorder;
import de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder;
import de.uka.ipd.sdq.capra.measurement.LocalTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.MeasurementFactory;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.ProbeAction;
import de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor;
import de.uka.ipd.sdq.capra.measurement.Recorder;
import de.uka.ipd.sdq.capra.measurement.ResourceSensor;
import de.uka.ipd.sdq.capra.measurement.ResourceUtilisationSensor;
import de.uka.ipd.sdq.capra.measurement.Sensor;
import de.uka.ipd.sdq.capra.measurement.StateRecorder;
import de.uka.ipd.sdq.capra.measurement.StateSensor;
import de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder;
import de.uka.ipd.sdq.capra.measurement.TimeProbe;
import de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder;
import de.uka.ipd.sdq.capra.measurement.VisitProbe;

import de.uka.ipd.sdq.capra.resources.ResourcesPackage;

import de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl;

import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;

import de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import scheduler.SchedulerPackage;

import scheduler.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasurementPackageImpl extends EPackageImpl implements MeasurementPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTimeSpanSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeSpanRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countingSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countingRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass histogramRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fullTimeSpanRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass steadyStateRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fullStateRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finalValueRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalTimeSpanSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localTimeSpanSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interruptionTimeSpanSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorShareSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceUtilisationSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalStateRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorEClass = null;

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
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MeasurementPackageImpl() {
		super(eNS_URI, MeasurementFactory.eINSTANCE);
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
	public static MeasurementPackage init() {
		if (isInited) return (MeasurementPackage)EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI);

		// Obtain or create and register package
		MeasurementPackageImpl theMeasurementPackage = (MeasurementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MeasurementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MeasurementPackageImpl());

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
		SchedulersPackageImpl theSchedulersPackage = (SchedulersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) instanceof SchedulersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) : SchedulersPackage.eINSTANCE);
		ExtensionPackageImpl theExtensionPackage = (ExtensionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) instanceof ExtensionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) : ExtensionPackage.eINSTANCE);

		// Create package meta-data objects
		theMeasurementPackage.createPackageContents();
		theCapraPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theResourcesPackage.createPackageContents();
		theSchedulersPackage.createPackageContents();
		theExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theMeasurementPackage.initializePackageContents();
		theCapraPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theResourcesPackage.initializePackageContents();
		theSchedulersPackage.initializePackageContents();
		theExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMeasurementPackage.freeze();

		return theMeasurementPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeProbe() {
		return timeProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeProbe_SensorsToStart() {
		return (EReference)timeProbeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeProbe_SensorsToStop() {
		return (EReference)timeProbeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbeAction() {
		return probeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTimeSpanSensor() {
		return abstractTimeSpanSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTimeSpanSensor_TimeSpanRecorders() {
		return (EReference)abstractTimeSpanSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTimeSpanSensor_StopMeasurement() {
		return (EReference)abstractTimeSpanSensorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTimeSpanSensor_StartMeasurement() {
		return (EReference)abstractTimeSpanSensorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeSpanRecorder() {
		return timeSpanRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeSpanRecorder_TimeSpanSensor() {
		return (EReference)timeSpanRecorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecorder() {
		return recorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecorder_StartCondition() {
		return (EReference)recorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecorder_StopCondition() {
		return (EReference)recorderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitProbe() {
		return visitProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateSensor() {
		return stateSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateSensor_StateRecorder() {
		return (EReference)stateSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountingSensor() {
		return countingSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountingSensor_CountingRecorders() {
		return (EReference)countingSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountingSensor_CountVisits() {
		return (EReference)countingSensorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountingRecorder() {
		return countingRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountingRecorder_CountingSensor() {
		return (EReference)countingRecorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateRecorder() {
		return stateRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateRecorder_StateSensor() {
		return (EReference)stateRecorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistogramRecorder() {
		return histogramRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHistogramRecorder_StepWidth() {
		return (EAttribute)histogramRecorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFullTimeSpanRecorder() {
		return fullTimeSpanRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSteadyStateRecorder() {
		return steadyStateRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFullStateRecorder() {
		return fullStateRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinalValueRecorder() {
		return finalValueRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalTimeSpanSensor() {
		return globalTimeSpanSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalTimeSpanSensor() {
		return localTimeSpanSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterruptionTimeSpanSensor() {
		return interruptionTimeSpanSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterruptionTimeSpanSensor_Threshold() {
		return (EReference)interruptionTimeSpanSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceSensor() {
		return resourceSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceSensor_ObservedResource() {
		return (EReference)resourceSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorShareSensor() {
		return processorShareSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorShareSensor_ObservedProcess() {
		return (EReference)processorShareSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceUtilisationSensor() {
		return resourceUtilisationSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntervalStateRecorder() {
		return intervalStateRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntervalStateRecorder_TimeInterval() {
		return (EReference)intervalStateRecorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervalStateRecorder_Percent() {
		return (EAttribute)intervalStateRecorderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensor() {
		return sensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSensor_Name() {
		return (EAttribute)sensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementFactory getMeasurementFactory() {
		return (MeasurementFactory)getEFactoryInstance();
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
		timeProbeEClass = createEClass(TIME_PROBE);
		createEReference(timeProbeEClass, TIME_PROBE__SENSORS_TO_START);
		createEReference(timeProbeEClass, TIME_PROBE__SENSORS_TO_STOP);

		probeActionEClass = createEClass(PROBE_ACTION);

		abstractTimeSpanSensorEClass = createEClass(ABSTRACT_TIME_SPAN_SENSOR);
		createEReference(abstractTimeSpanSensorEClass, ABSTRACT_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS);
		createEReference(abstractTimeSpanSensorEClass, ABSTRACT_TIME_SPAN_SENSOR__STOP_MEASUREMENT);
		createEReference(abstractTimeSpanSensorEClass, ABSTRACT_TIME_SPAN_SENSOR__START_MEASUREMENT);

		timeSpanRecorderEClass = createEClass(TIME_SPAN_RECORDER);
		createEReference(timeSpanRecorderEClass, TIME_SPAN_RECORDER__TIME_SPAN_SENSOR);

		recorderEClass = createEClass(RECORDER);
		createEReference(recorderEClass, RECORDER__START_CONDITION);
		createEReference(recorderEClass, RECORDER__STOP_CONDITION);

		conditionEClass = createEClass(CONDITION);

		visitProbeEClass = createEClass(VISIT_PROBE);

		stateSensorEClass = createEClass(STATE_SENSOR);
		createEReference(stateSensorEClass, STATE_SENSOR__STATE_RECORDER);

		stateRecorderEClass = createEClass(STATE_RECORDER);
		createEReference(stateRecorderEClass, STATE_RECORDER__STATE_SENSOR);

		countingSensorEClass = createEClass(COUNTING_SENSOR);
		createEReference(countingSensorEClass, COUNTING_SENSOR__COUNTING_RECORDERS);
		createEReference(countingSensorEClass, COUNTING_SENSOR__COUNT_VISITS);

		countingRecorderEClass = createEClass(COUNTING_RECORDER);
		createEReference(countingRecorderEClass, COUNTING_RECORDER__COUNTING_SENSOR);

		histogramRecorderEClass = createEClass(HISTOGRAM_RECORDER);
		createEAttribute(histogramRecorderEClass, HISTOGRAM_RECORDER__STEP_WIDTH);

		fullTimeSpanRecorderEClass = createEClass(FULL_TIME_SPAN_RECORDER);

		steadyStateRecorderEClass = createEClass(STEADY_STATE_RECORDER);

		fullStateRecorderEClass = createEClass(FULL_STATE_RECORDER);

		finalValueRecorderEClass = createEClass(FINAL_VALUE_RECORDER);

		globalTimeSpanSensorEClass = createEClass(GLOBAL_TIME_SPAN_SENSOR);

		localTimeSpanSensorEClass = createEClass(LOCAL_TIME_SPAN_SENSOR);

		interruptionTimeSpanSensorEClass = createEClass(INTERRUPTION_TIME_SPAN_SENSOR);
		createEReference(interruptionTimeSpanSensorEClass, INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD);

		resourceSensorEClass = createEClass(RESOURCE_SENSOR);
		createEReference(resourceSensorEClass, RESOURCE_SENSOR__OBSERVED_RESOURCE);

		processorShareSensorEClass = createEClass(PROCESSOR_SHARE_SENSOR);
		createEReference(processorShareSensorEClass, PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS);

		resourceUtilisationSensorEClass = createEClass(RESOURCE_UTILISATION_SENSOR);

		intervalStateRecorderEClass = createEClass(INTERVAL_STATE_RECORDER);
		createEReference(intervalStateRecorderEClass, INTERVAL_STATE_RECORDER__TIME_INTERVAL);
		createEAttribute(intervalStateRecorderEClass, INTERVAL_STATE_RECORDER__PERCENT);

		sensorEClass = createEClass(SENSOR);
		createEAttribute(sensorEClass, SENSOR__NAME);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);
		ResourcesPackage theResourcesPackage = (ResourcesPackage)EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		timeProbeEClass.getESuperTypes().add(this.getProbeAction());
		probeActionEClass.getESuperTypes().add(theCorePackage.getAction());
		abstractTimeSpanSensorEClass.getESuperTypes().add(this.getSensor());
		timeSpanRecorderEClass.getESuperTypes().add(this.getRecorder());
		visitProbeEClass.getESuperTypes().add(this.getProbeAction());
		stateSensorEClass.getESuperTypes().add(this.getSensor());
		stateRecorderEClass.getESuperTypes().add(this.getRecorder());
		countingSensorEClass.getESuperTypes().add(this.getSensor());
		countingRecorderEClass.getESuperTypes().add(this.getRecorder());
		histogramRecorderEClass.getESuperTypes().add(this.getTimeSpanRecorder());
		fullTimeSpanRecorderEClass.getESuperTypes().add(this.getTimeSpanRecorder());
		steadyStateRecorderEClass.getESuperTypes().add(this.getStateRecorder());
		fullStateRecorderEClass.getESuperTypes().add(this.getStateRecorder());
		finalValueRecorderEClass.getESuperTypes().add(this.getCountingRecorder());
		globalTimeSpanSensorEClass.getESuperTypes().add(this.getAbstractTimeSpanSensor());
		localTimeSpanSensorEClass.getESuperTypes().add(this.getAbstractTimeSpanSensor());
		interruptionTimeSpanSensorEClass.getESuperTypes().add(this.getLocalTimeSpanSensor());
		interruptionTimeSpanSensorEClass.getESuperTypes().add(this.getResourceSensor());
		resourceSensorEClass.getESuperTypes().add(this.getSensor());
		processorShareSensorEClass.getESuperTypes().add(this.getResourceSensor());
		processorShareSensorEClass.getESuperTypes().add(this.getStateSensor());
		resourceUtilisationSensorEClass.getESuperTypes().add(this.getResourceSensor());
		resourceUtilisationSensorEClass.getESuperTypes().add(this.getStateSensor());
		intervalStateRecorderEClass.getESuperTypes().add(this.getStateRecorder());

		// Initialize classes and features; add operations and parameters
		initEClass(timeProbeEClass, TimeProbe.class, "TimeProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeProbe_SensorsToStart(), this.getAbstractTimeSpanSensor(), this.getAbstractTimeSpanSensor_StartMeasurement(), "sensorsToStart", null, 0, -1, TimeProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTimeProbe_SensorsToStop(), this.getAbstractTimeSpanSensor(), this.getAbstractTimeSpanSensor_StopMeasurement(), "sensorsToStop", null, 0, -1, TimeProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(probeActionEClass, ProbeAction.class, "ProbeAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractTimeSpanSensorEClass, AbstractTimeSpanSensor.class, "AbstractTimeSpanSensor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractTimeSpanSensor_TimeSpanRecorders(), this.getTimeSpanRecorder(), this.getTimeSpanRecorder_TimeSpanSensor(), "timeSpanRecorders", null, 0, -1, AbstractTimeSpanSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractTimeSpanSensor_StopMeasurement(), this.getTimeProbe(), this.getTimeProbe_SensorsToStop(), "stopMeasurement", null, 1, 1, AbstractTimeSpanSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractTimeSpanSensor_StartMeasurement(), this.getTimeProbe(), this.getTimeProbe_SensorsToStart(), "startMeasurement", null, 1, 1, AbstractTimeSpanSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(timeSpanRecorderEClass, TimeSpanRecorder.class, "TimeSpanRecorder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeSpanRecorder_TimeSpanSensor(), this.getAbstractTimeSpanSensor(), this.getAbstractTimeSpanSensor_TimeSpanRecorders(), "timeSpanSensor", null, 1, 1, TimeSpanRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(recorderEClass, Recorder.class, "Recorder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecorder_StartCondition(), this.getCondition(), null, "startCondition", null, 1, 1, Recorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRecorder_StopCondition(), this.getCondition(), null, "stopCondition", null, 1, 1, Recorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(conditionEClass, Condition.class, "Condition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(visitProbeEClass, VisitProbe.class, "VisitProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateSensorEClass, StateSensor.class, "StateSensor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateSensor_StateRecorder(), this.getStateRecorder(), this.getStateRecorder_StateSensor(), "stateRecorder", null, 0, -1, StateSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stateRecorderEClass, StateRecorder.class, "StateRecorder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateRecorder_StateSensor(), this.getStateSensor(), this.getStateSensor_StateRecorder(), "stateSensor", null, 1, 1, StateRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(countingSensorEClass, CountingSensor.class, "CountingSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCountingSensor_CountingRecorders(), this.getCountingRecorder(), this.getCountingRecorder_CountingSensor(), "countingRecorders", null, 0, -1, CountingSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCountingSensor_CountVisits(), this.getVisitProbe(), null, "countVisits", null, 1, 1, CountingSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(countingRecorderEClass, CountingRecorder.class, "CountingRecorder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCountingRecorder_CountingSensor(), this.getCountingSensor(), this.getCountingSensor_CountingRecorders(), "countingSensor", null, 1, 1, CountingRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(histogramRecorderEClass, HistogramRecorder.class, "HistogramRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHistogramRecorder_StepWidth(), ecorePackage.getEDouble(), "stepWidth", "1.0", 1, 1, HistogramRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fullTimeSpanRecorderEClass, FullTimeSpanRecorder.class, "FullTimeSpanRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(steadyStateRecorderEClass, SteadyStateRecorder.class, "SteadyStateRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fullStateRecorderEClass, FullStateRecorder.class, "FullStateRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(finalValueRecorderEClass, FinalValueRecorder.class, "FinalValueRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globalTimeSpanSensorEClass, GlobalTimeSpanSensor.class, "GlobalTimeSpanSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localTimeSpanSensorEClass, LocalTimeSpanSensor.class, "LocalTimeSpanSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(interruptionTimeSpanSensorEClass, InterruptionTimeSpanSensor.class, "InterruptionTimeSpanSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterruptionTimeSpanSensor_Threshold(), theConfigurationPackage.getTimeValue(), null, "threshold", null, 1, 1, InterruptionTimeSpanSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceSensorEClass, ResourceSensor.class, "ResourceSensor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceSensor_ObservedResource(), theResourcesPackage.getActiveResource(), null, "observedResource", null, 1, 1, ResourceSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processorShareSensorEClass, ProcessorShareSensor.class, "ProcessorShareSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessorShareSensor_ObservedProcess(), theCorePackage.getProcessVariable(), null, "observedProcess", null, 1, 1, ProcessorShareSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceUtilisationSensorEClass, ResourceUtilisationSensor.class, "ResourceUtilisationSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intervalStateRecorderEClass, IntervalStateRecorder.class, "IntervalStateRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntervalStateRecorder_TimeInterval(), theConfigurationPackage.getTimeValue(), null, "timeInterval", null, 1, 1, IntervalStateRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalStateRecorder_Percent(), ecorePackage.getEBoolean(), "percent", null, 1, 1, IntervalStateRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorEClass, Sensor.class, "Sensor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSensor_Name(), ecorePackage.getEString(), "name", null, 1, 1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //MeasurementPackageImpl
