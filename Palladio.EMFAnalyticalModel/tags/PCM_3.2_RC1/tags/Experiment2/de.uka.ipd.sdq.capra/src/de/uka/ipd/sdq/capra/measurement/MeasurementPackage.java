/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import de.uka.ipd.sdq.capra.core.CorePackage;

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
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementFactory
 * @model kind="package"
 * @generated
 */
public interface MeasurementPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "measurement";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Capra/Measurements/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "capra.measurement";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasurementPackage eINSTANCE = de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ProbeActionImpl <em>Probe Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.ProbeActionImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getProbeAction()
	 * @generated
	 */
	int PROBE_ACTION = 1;

	/**
	 * The number of structural features of the '<em>Probe Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBE_ACTION_FEATURE_COUNT = CorePackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.TimeProbeImpl <em>Time Probe</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.TimeProbeImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getTimeProbe()
	 * @generated
	 */
	int TIME_PROBE = 0;

	/**
	 * The feature id for the '<em><b>Sensors To Start</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_PROBE__SENSORS_TO_START = PROBE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sensors To Stop</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_PROBE__SENSORS_TO_STOP = PROBE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Time Probe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_PROBE_FEATURE_COUNT = PROBE_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.SensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__NAME = 0;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanSensorImpl <em>Time Span Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.TimeSpanSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getTimeSpanSensor()
	 * @generated
	 */
	int TIME_SPAN_SENSOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_SENSOR__NAME = SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Time Span Recorders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_SENSOR__START_MEASUREMENT = SENSOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stop Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_SENSOR__STOP_MEASUREMENT = SENSOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Time Span Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_SENSOR_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl <em>Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getRecorder()
	 * @generated
	 */
	int RECORDER = 5;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORDER__START_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORDER__STOP_CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORDER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanRecorderImpl <em>Time Span Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.TimeSpanRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getTimeSpanRecorder()
	 * @generated
	 */
	int TIME_SPAN_RECORDER = 4;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_RECORDER__START_CONDITION = RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_RECORDER__STOP_CONDITION = RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Time Span Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_RECORDER__TIME_SPAN_SENSOR = RECORDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Time Span Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SPAN_RECORDER_FEATURE_COUNT = RECORDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.ConditionImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 6;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.VisitProbeImpl <em>Visit Probe</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.VisitProbeImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getVisitProbe()
	 * @generated
	 */
	int VISIT_PROBE = 7;

	/**
	 * The number of structural features of the '<em>Visit Probe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_PROBE_FEATURE_COUNT = PROBE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.StateSensorImpl <em>State Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.StateSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getStateSensor()
	 * @generated
	 */
	int STATE_SENSOR = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SENSOR__NAME = SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>State Recorders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SENSOR__STATE_RECORDERS = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SENSOR_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.StateRecorderImpl <em>State Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.StateRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getStateRecorder()
	 * @generated
	 */
	int STATE_RECORDER = 9;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RECORDER__START_CONDITION = RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RECORDER__STOP_CONDITION = RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>State Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RECORDER__STATE_SENSOR = RECORDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RECORDER_FEATURE_COUNT = RECORDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl <em>Counting Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCountingSensor()
	 * @generated
	 */
	int COUNTING_SENSOR = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_SENSOR__NAME = SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Counting Recorders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_SENSOR__COUNTING_RECORDERS = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Count Visits</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_SENSOR__COUNT_VISITS = SENSOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Counting Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_SENSOR_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.CountingRecorderImpl <em>Counting Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.CountingRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCountingRecorder()
	 * @generated
	 */
	int COUNTING_RECORDER = 11;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_RECORDER__START_CONDITION = RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_RECORDER__STOP_CONDITION = RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Counting Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_RECORDER__COUNTING_SENSOR = RECORDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Counting Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_RECORDER_FEATURE_COUNT = RECORDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.HistogramRecorderImpl <em>Histogram Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.HistogramRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getHistogramRecorder()
	 * @generated
	 */
	int HISTOGRAM_RECORDER = 12;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTOGRAM_RECORDER__START_CONDITION = TIME_SPAN_RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTOGRAM_RECORDER__STOP_CONDITION = TIME_SPAN_RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Time Span Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTOGRAM_RECORDER__TIME_SPAN_SENSOR = TIME_SPAN_RECORDER__TIME_SPAN_SENSOR;

	/**
	 * The feature id for the '<em><b>Step Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTOGRAM_RECORDER__STEP_WIDTH = TIME_SPAN_RECORDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Histogram Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTOGRAM_RECORDER_FEATURE_COUNT = TIME_SPAN_RECORDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.FullTimeSpanRecorderImpl <em>Full Time Span Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.FullTimeSpanRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getFullTimeSpanRecorder()
	 * @generated
	 */
	int FULL_TIME_SPAN_RECORDER = 13;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_TIME_SPAN_RECORDER__START_CONDITION = TIME_SPAN_RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_TIME_SPAN_RECORDER__STOP_CONDITION = TIME_SPAN_RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Time Span Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_TIME_SPAN_RECORDER__TIME_SPAN_SENSOR = TIME_SPAN_RECORDER__TIME_SPAN_SENSOR;

	/**
	 * The number of structural features of the '<em>Full Time Span Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_TIME_SPAN_RECORDER_FEATURE_COUNT = TIME_SPAN_RECORDER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.SteadyStateRecorderImpl <em>Steady State Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.SteadyStateRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getSteadyStateRecorder()
	 * @generated
	 */
	int STEADY_STATE_RECORDER = 14;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEADY_STATE_RECORDER__START_CONDITION = STATE_RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEADY_STATE_RECORDER__STOP_CONDITION = STATE_RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>State Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEADY_STATE_RECORDER__STATE_SENSOR = STATE_RECORDER__STATE_SENSOR;

	/**
	 * The number of structural features of the '<em>Steady State Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEADY_STATE_RECORDER_FEATURE_COUNT = STATE_RECORDER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.FullStateRecorderImpl <em>Full State Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.FullStateRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getFullStateRecorder()
	 * @generated
	 */
	int FULL_STATE_RECORDER = 15;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_STATE_RECORDER__START_CONDITION = STATE_RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_STATE_RECORDER__STOP_CONDITION = STATE_RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>State Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_STATE_RECORDER__STATE_SENSOR = STATE_RECORDER__STATE_SENSOR;

	/**
	 * The number of structural features of the '<em>Full State Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_STATE_RECORDER_FEATURE_COUNT = STATE_RECORDER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.FinalValueRecorderImpl <em>Final Value Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.FinalValueRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getFinalValueRecorder()
	 * @generated
	 */
	int FINAL_VALUE_RECORDER = 16;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_VALUE_RECORDER__START_CONDITION = COUNTING_RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_VALUE_RECORDER__STOP_CONDITION = COUNTING_RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Counting Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_VALUE_RECORDER__COUNTING_SENSOR = COUNTING_RECORDER__COUNTING_SENSOR;

	/**
	 * The number of structural features of the '<em>Final Value Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_VALUE_RECORDER_FEATURE_COUNT = COUNTING_RECORDER_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.TimeProbe <em>Time Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Probe</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeProbe
	 * @generated
	 */
	EClass getTimeProbe();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStart <em>Sensors To Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sensors To Start</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStart()
	 * @see #getTimeProbe()
	 * @generated
	 */
	EReference getTimeProbe_SensorsToStart();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStop <em>Sensors To Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sensors To Stop</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStop()
	 * @see #getTimeProbe()
	 * @generated
	 */
	EReference getTimeProbe_SensorsToStop();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.ProbeAction <em>Probe Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probe Action</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.ProbeAction
	 * @generated
	 */
	EClass getProbeAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor <em>Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Span Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanSensor
	 * @generated
	 */
	EClass getTimeSpanSensor();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getTimeSpanRecorders <em>Time Span Recorders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Time Span Recorders</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getTimeSpanRecorders()
	 * @see #getTimeSpanSensor()
	 * @generated
	 */
	EReference getTimeSpanSensor_TimeSpanRecorders();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStartMeasurement <em>Start Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Measurement</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStartMeasurement()
	 * @see #getTimeSpanSensor()
	 * @generated
	 */
	EReference getTimeSpanSensor_StartMeasurement();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStopMeasurement <em>Stop Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stop Measurement</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStopMeasurement()
	 * @see #getTimeSpanSensor()
	 * @generated
	 */
	EReference getTimeSpanSensor_StopMeasurement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.measurement.Sensor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.Sensor#getName()
	 * @see #getSensor()
	 * @generated
	 */
	EAttribute getSensor_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder <em>Time Span Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Span Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder
	 * @generated
	 */
	EClass getTimeSpanRecorder();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder#getTimeSpanSensor <em>Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Time Span Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder#getTimeSpanSensor()
	 * @see #getTimeSpanRecorder()
	 * @generated
	 */
	EReference getTimeSpanRecorder_TimeSpanSensor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.Recorder <em>Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.Recorder
	 * @generated
	 */
	EClass getRecorder();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.measurement.Recorder#getStartCondition <em>Start Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Condition</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.Recorder#getStartCondition()
	 * @see #getRecorder()
	 * @generated
	 */
	EReference getRecorder_StartCondition();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.measurement.Recorder#getStopCondition <em>Stop Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stop Condition</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.Recorder#getStopCondition()
	 * @see #getRecorder()
	 * @generated
	 */
	EReference getRecorder_StopCondition();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.VisitProbe <em>Visit Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visit Probe</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.VisitProbe
	 * @generated
	 */
	EClass getVisitProbe();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.StateSensor <em>State Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.StateSensor
	 * @generated
	 */
	EClass getStateSensor();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorders <em>State Recorders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Recorders</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorders()
	 * @see #getStateSensor()
	 * @generated
	 */
	EReference getStateSensor_StateRecorders();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.StateRecorder <em>State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.StateRecorder
	 * @generated
	 */
	EClass getStateRecorder();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor <em>State Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.StateRecorder#getStateSensor()
	 * @see #getStateRecorder()
	 * @generated
	 */
	EReference getStateRecorder_StateSensor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.CountingSensor <em>Counting Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counting Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.CountingSensor
	 * @generated
	 */
	EClass getCountingSensor();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountingRecorders <em>Counting Recorders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Counting Recorders</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountingRecorders()
	 * @see #getCountingSensor()
	 * @generated
	 */
	EReference getCountingSensor_CountingRecorders();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountVisits <em>Count Visits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Count Visits</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.CountingSensor#getCountVisits()
	 * @see #getCountingSensor()
	 * @generated
	 */
	EReference getCountingSensor_CountVisits();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.CountingRecorder <em>Counting Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counting Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.CountingRecorder
	 * @generated
	 */
	EClass getCountingRecorder();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.capra.measurement.CountingRecorder#getCountingSensor <em>Counting Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Counting Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.CountingRecorder#getCountingSensor()
	 * @see #getCountingRecorder()
	 * @generated
	 */
	EReference getCountingRecorder_CountingSensor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.HistogramRecorder <em>Histogram Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Histogram Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.HistogramRecorder
	 * @generated
	 */
	EClass getHistogramRecorder();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.measurement.HistogramRecorder#getStepWidth <em>Step Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Width</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.HistogramRecorder#getStepWidth()
	 * @see #getHistogramRecorder()
	 * @generated
	 */
	EAttribute getHistogramRecorder_StepWidth();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder <em>Full Time Span Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Full Time Span Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder
	 * @generated
	 */
	EClass getFullTimeSpanRecorder();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder <em>Steady State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Steady State Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder
	 * @generated
	 */
	EClass getSteadyStateRecorder();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.FullStateRecorder <em>Full State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Full State Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.FullStateRecorder
	 * @generated
	 */
	EClass getFullStateRecorder();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.FinalValueRecorder <em>Final Value Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final Value Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.FinalValueRecorder
	 * @generated
	 */
	EClass getFinalValueRecorder();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MeasurementFactory getMeasurementFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.TimeProbeImpl <em>Time Probe</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.TimeProbeImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getTimeProbe()
		 * @generated
		 */
		EClass TIME_PROBE = eINSTANCE.getTimeProbe();

		/**
		 * The meta object literal for the '<em><b>Sensors To Start</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_PROBE__SENSORS_TO_START = eINSTANCE.getTimeProbe_SensorsToStart();

		/**
		 * The meta object literal for the '<em><b>Sensors To Stop</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_PROBE__SENSORS_TO_STOP = eINSTANCE.getTimeProbe_SensorsToStop();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ProbeActionImpl <em>Probe Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.ProbeActionImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getProbeAction()
		 * @generated
		 */
		EClass PROBE_ACTION = eINSTANCE.getProbeAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanSensorImpl <em>Time Span Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.TimeSpanSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getTimeSpanSensor()
		 * @generated
		 */
		EClass TIME_SPAN_SENSOR = eINSTANCE.getTimeSpanSensor();

		/**
		 * The meta object literal for the '<em><b>Time Span Recorders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS = eINSTANCE.getTimeSpanSensor_TimeSpanRecorders();

		/**
		 * The meta object literal for the '<em><b>Start Measurement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_SPAN_SENSOR__START_MEASUREMENT = eINSTANCE.getTimeSpanSensor_StartMeasurement();

		/**
		 * The meta object literal for the '<em><b>Stop Measurement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_SPAN_SENSOR__STOP_MEASUREMENT = eINSTANCE.getTimeSpanSensor_StopMeasurement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.SensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__NAME = eINSTANCE.getSensor_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.TimeSpanRecorderImpl <em>Time Span Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.TimeSpanRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getTimeSpanRecorder()
		 * @generated
		 */
		EClass TIME_SPAN_RECORDER = eINSTANCE.getTimeSpanRecorder();

		/**
		 * The meta object literal for the '<em><b>Time Span Sensor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_SPAN_RECORDER__TIME_SPAN_SENSOR = eINSTANCE.getTimeSpanRecorder_TimeSpanSensor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl <em>Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getRecorder()
		 * @generated
		 */
		EClass RECORDER = eINSTANCE.getRecorder();

		/**
		 * The meta object literal for the '<em><b>Start Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORDER__START_CONDITION = eINSTANCE.getRecorder_StartCondition();

		/**
		 * The meta object literal for the '<em><b>Stop Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORDER__STOP_CONDITION = eINSTANCE.getRecorder_StopCondition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.ConditionImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.VisitProbeImpl <em>Visit Probe</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.VisitProbeImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getVisitProbe()
		 * @generated
		 */
		EClass VISIT_PROBE = eINSTANCE.getVisitProbe();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.StateSensorImpl <em>State Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.StateSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getStateSensor()
		 * @generated
		 */
		EClass STATE_SENSOR = eINSTANCE.getStateSensor();

		/**
		 * The meta object literal for the '<em><b>State Recorders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_SENSOR__STATE_RECORDERS = eINSTANCE.getStateSensor_StateRecorders();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.StateRecorderImpl <em>State Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.StateRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getStateRecorder()
		 * @generated
		 */
		EClass STATE_RECORDER = eINSTANCE.getStateRecorder();

		/**
		 * The meta object literal for the '<em><b>State Sensor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_RECORDER__STATE_SENSOR = eINSTANCE.getStateRecorder_StateSensor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl <em>Counting Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCountingSensor()
		 * @generated
		 */
		EClass COUNTING_SENSOR = eINSTANCE.getCountingSensor();

		/**
		 * The meta object literal for the '<em><b>Counting Recorders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTING_SENSOR__COUNTING_RECORDERS = eINSTANCE.getCountingSensor_CountingRecorders();

		/**
		 * The meta object literal for the '<em><b>Count Visits</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTING_SENSOR__COUNT_VISITS = eINSTANCE.getCountingSensor_CountVisits();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.CountingRecorderImpl <em>Counting Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.CountingRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCountingRecorder()
		 * @generated
		 */
		EClass COUNTING_RECORDER = eINSTANCE.getCountingRecorder();

		/**
		 * The meta object literal for the '<em><b>Counting Sensor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTING_RECORDER__COUNTING_SENSOR = eINSTANCE.getCountingRecorder_CountingSensor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.HistogramRecorderImpl <em>Histogram Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.HistogramRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getHistogramRecorder()
		 * @generated
		 */
		EClass HISTOGRAM_RECORDER = eINSTANCE.getHistogramRecorder();

		/**
		 * The meta object literal for the '<em><b>Step Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HISTOGRAM_RECORDER__STEP_WIDTH = eINSTANCE.getHistogramRecorder_StepWidth();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.FullTimeSpanRecorderImpl <em>Full Time Span Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.FullTimeSpanRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getFullTimeSpanRecorder()
		 * @generated
		 */
		EClass FULL_TIME_SPAN_RECORDER = eINSTANCE.getFullTimeSpanRecorder();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.SteadyStateRecorderImpl <em>Steady State Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.SteadyStateRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getSteadyStateRecorder()
		 * @generated
		 */
		EClass STEADY_STATE_RECORDER = eINSTANCE.getSteadyStateRecorder();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.FullStateRecorderImpl <em>Full State Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.FullStateRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getFullStateRecorder()
		 * @generated
		 */
		EClass FULL_STATE_RECORDER = eINSTANCE.getFullStateRecorder();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.FinalValueRecorderImpl <em>Final Value Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.FinalValueRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getFinalValueRecorder()
		 * @generated
		 */
		EClass FINAL_VALUE_RECORDER = eINSTANCE.getFinalValueRecorder();

	}

} //MeasurementPackage
