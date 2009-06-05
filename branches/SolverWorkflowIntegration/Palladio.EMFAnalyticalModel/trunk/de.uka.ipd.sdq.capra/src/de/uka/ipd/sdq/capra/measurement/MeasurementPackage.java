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
	int SENSOR = 23;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.AbstractTimeSpanSensorImpl <em>Abstract Time Span Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.AbstractTimeSpanSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getAbstractTimeSpanSensor()
	 * @generated
	 */
	int ABSTRACT_TIME_SPAN_SENSOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TIME_SPAN_SENSOR__NAME = SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Time Span Recorders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stop Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TIME_SPAN_SENSOR__STOP_MEASUREMENT = SENSOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TIME_SPAN_SENSOR__START_MEASUREMENT = SENSOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Time Span Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TIME_SPAN_SENSOR_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl <em>Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getRecorder()
	 * @generated
	 */
	int RECORDER = 4;

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
	int TIME_SPAN_RECORDER = 3;

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
	int CONDITION = 5;

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
	int VISIT_PROBE = 6;

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
	int STATE_SENSOR = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SENSOR__NAME = SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>State Recorder</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SENSOR__STATE_RECORDER = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SENSOR_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl <em>Counting Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCountingSensor()
	 * @generated
	 */
	int COUNTING_SENSOR = 9;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.CountingRecorderImpl <em>Counting Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.CountingRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getCountingRecorder()
	 * @generated
	 */
	int COUNTING_RECORDER = 10;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.StateRecorderImpl <em>State Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.StateRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getStateRecorder()
	 * @generated
	 */
	int STATE_RECORDER = 8;

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
	int HISTOGRAM_RECORDER = 11;

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
	int FULL_TIME_SPAN_RECORDER = 12;

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
	int STEADY_STATE_RECORDER = 13;

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
	int FULL_STATE_RECORDER = 14;

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
	int FINAL_VALUE_RECORDER = 15;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.GlobalTimeSpanSensorImpl <em>Global Time Span Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.GlobalTimeSpanSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getGlobalTimeSpanSensor()
	 * @generated
	 */
	int GLOBAL_TIME_SPAN_SENSOR = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TIME_SPAN_SENSOR__NAME = ABSTRACT_TIME_SPAN_SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Time Span Recorders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS = ABSTRACT_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS;

	/**
	 * The feature id for the '<em><b>Stop Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TIME_SPAN_SENSOR__STOP_MEASUREMENT = ABSTRACT_TIME_SPAN_SENSOR__STOP_MEASUREMENT;

	/**
	 * The feature id for the '<em><b>Start Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TIME_SPAN_SENSOR__START_MEASUREMENT = ABSTRACT_TIME_SPAN_SENSOR__START_MEASUREMENT;

	/**
	 * The number of structural features of the '<em>Global Time Span Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TIME_SPAN_SENSOR_FEATURE_COUNT = ABSTRACT_TIME_SPAN_SENSOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.LocalTimeSpanSensorImpl <em>Local Time Span Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.LocalTimeSpanSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getLocalTimeSpanSensor()
	 * @generated
	 */
	int LOCAL_TIME_SPAN_SENSOR = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TIME_SPAN_SENSOR__NAME = ABSTRACT_TIME_SPAN_SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Time Span Recorders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS = ABSTRACT_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS;

	/**
	 * The feature id for the '<em><b>Stop Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TIME_SPAN_SENSOR__STOP_MEASUREMENT = ABSTRACT_TIME_SPAN_SENSOR__STOP_MEASUREMENT;

	/**
	 * The feature id for the '<em><b>Start Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TIME_SPAN_SENSOR__START_MEASUREMENT = ABSTRACT_TIME_SPAN_SENSOR__START_MEASUREMENT;

	/**
	 * The number of structural features of the '<em>Local Time Span Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TIME_SPAN_SENSOR_FEATURE_COUNT = ABSTRACT_TIME_SPAN_SENSOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.InterruptionTimeSpanSensorImpl <em>Interruption Time Span Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.InterruptionTimeSpanSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getInterruptionTimeSpanSensor()
	 * @generated
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR__NAME = LOCAL_TIME_SPAN_SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Time Span Recorders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS = LOCAL_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS;

	/**
	 * The feature id for the '<em><b>Stop Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR__STOP_MEASUREMENT = LOCAL_TIME_SPAN_SENSOR__STOP_MEASUREMENT;

	/**
	 * The feature id for the '<em><b>Start Measurement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR__START_MEASUREMENT = LOCAL_TIME_SPAN_SENSOR__START_MEASUREMENT;

	/**
	 * The feature id for the '<em><b>Observed Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE = LOCAL_TIME_SPAN_SENSOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD = LOCAL_TIME_SPAN_SENSOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interruption Time Span Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPTION_TIME_SPAN_SENSOR_FEATURE_COUNT = LOCAL_TIME_SPAN_SENSOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ResourceSensorImpl <em>Resource Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.ResourceSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getResourceSensor()
	 * @generated
	 */
	int RESOURCE_SENSOR = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SENSOR__NAME = SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Observed Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SENSOR__OBSERVED_RESOURCE = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SENSOR_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ProcessorShareSensorImpl <em>Processor Share Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.ProcessorShareSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getProcessorShareSensor()
	 * @generated
	 */
	int PROCESSOR_SHARE_SENSOR = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_SHARE_SENSOR__NAME = RESOURCE_SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Observed Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_SHARE_SENSOR__OBSERVED_RESOURCE = RESOURCE_SENSOR__OBSERVED_RESOURCE;

	/**
	 * The feature id for the '<em><b>State Recorder</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_SHARE_SENSOR__STATE_RECORDER = RESOURCE_SENSOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Observed Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS = RESOURCE_SENSOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Processor Share Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_SHARE_SENSOR_FEATURE_COUNT = RESOURCE_SENSOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ResourceUtilisationSensorImpl <em>Resource Utilisation Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.ResourceUtilisationSensorImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getResourceUtilisationSensor()
	 * @generated
	 */
	int RESOURCE_UTILISATION_SENSOR = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UTILISATION_SENSOR__NAME = RESOURCE_SENSOR__NAME;

	/**
	 * The feature id for the '<em><b>Observed Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UTILISATION_SENSOR__OBSERVED_RESOURCE = RESOURCE_SENSOR__OBSERVED_RESOURCE;

	/**
	 * The feature id for the '<em><b>State Recorder</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UTILISATION_SENSOR__STATE_RECORDER = RESOURCE_SENSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Utilisation Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_UTILISATION_SENSOR_FEATURE_COUNT = RESOURCE_SENSOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.measurement.impl.IntervalStateRecorderImpl <em>Interval State Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.measurement.impl.IntervalStateRecorderImpl
	 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getIntervalStateRecorder()
	 * @generated
	 */
	int INTERVAL_STATE_RECORDER = 22;

	/**
	 * The feature id for the '<em><b>Start Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATE_RECORDER__START_CONDITION = STATE_RECORDER__START_CONDITION;

	/**
	 * The feature id for the '<em><b>Stop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATE_RECORDER__STOP_CONDITION = STATE_RECORDER__STOP_CONDITION;

	/**
	 * The feature id for the '<em><b>State Sensor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATE_RECORDER__STATE_SENSOR = STATE_RECORDER__STATE_SENSOR;

	/**
	 * The feature id for the '<em><b>Time Interval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATE_RECORDER__TIME_INTERVAL = STATE_RECORDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATE_RECORDER__PERCENT = STATE_RECORDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interval State Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATE_RECORDER_FEATURE_COUNT = STATE_RECORDER_FEATURE_COUNT + 2;


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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor <em>Abstract Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Time Span Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor
	 * @generated
	 */
	EClass getAbstractTimeSpanSensor();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor#getTimeSpanRecorders <em>Time Span Recorders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Time Span Recorders</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor#getTimeSpanRecorders()
	 * @see #getAbstractTimeSpanSensor()
	 * @generated
	 */
	EReference getAbstractTimeSpanSensor_TimeSpanRecorders();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor#getStopMeasurement <em>Stop Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stop Measurement</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor#getStopMeasurement()
	 * @see #getAbstractTimeSpanSensor()
	 * @generated
	 */
	EReference getAbstractTimeSpanSensor_StopMeasurement();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor#getStartMeasurement <em>Start Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Measurement</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor#getStartMeasurement()
	 * @see #getAbstractTimeSpanSensor()
	 * @generated
	 */
	EReference getAbstractTimeSpanSensor_StartMeasurement();

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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorder <em>State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.StateSensor#getStateRecorder()
	 * @see #getStateSensor()
	 * @generated
	 */
	EReference getStateSensor_StateRecorder();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.GlobalTimeSpanSensor <em>Global Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Time Span Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.GlobalTimeSpanSensor
	 * @generated
	 */
	EClass getGlobalTimeSpanSensor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.LocalTimeSpanSensor <em>Local Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Time Span Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.LocalTimeSpanSensor
	 * @generated
	 */
	EClass getLocalTimeSpanSensor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor <em>Interruption Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interruption Time Span Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor
	 * @generated
	 */
	EClass getInterruptionTimeSpanSensor();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Threshold</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor#getThreshold()
	 * @see #getInterruptionTimeSpanSensor()
	 * @generated
	 */
	EReference getInterruptionTimeSpanSensor_Threshold();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.ResourceSensor <em>Resource Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.ResourceSensor
	 * @generated
	 */
	EClass getResourceSensor();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.measurement.ResourceSensor#getObservedResource <em>Observed Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Observed Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.ResourceSensor#getObservedResource()
	 * @see #getResourceSensor()
	 * @generated
	 */
	EReference getResourceSensor_ObservedResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor <em>Processor Share Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor Share Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor
	 * @generated
	 */
	EClass getProcessorShareSensor();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor#getObservedProcess <em>Observed Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Observed Process</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor#getObservedProcess()
	 * @see #getProcessorShareSensor()
	 * @generated
	 */
	EReference getProcessorShareSensor_ObservedProcess();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.ResourceUtilisationSensor <em>Resource Utilisation Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Utilisation Sensor</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.ResourceUtilisationSensor
	 * @generated
	 */
	EClass getResourceUtilisationSensor();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder <em>Interval State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval State Recorder</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder
	 * @generated
	 */
	EClass getIntervalStateRecorder();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#getTimeInterval <em>Time Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Interval</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#getTimeInterval()
	 * @see #getIntervalStateRecorder()
	 * @generated
	 */
	EReference getIntervalStateRecorder_TimeInterval();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#isPercent <em>Percent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percent</em>'.
	 * @see de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder#isPercent()
	 * @see #getIntervalStateRecorder()
	 * @generated
	 */
	EAttribute getIntervalStateRecorder_Percent();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.AbstractTimeSpanSensorImpl <em>Abstract Time Span Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.AbstractTimeSpanSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getAbstractTimeSpanSensor()
		 * @generated
		 */
		EClass ABSTRACT_TIME_SPAN_SENSOR = eINSTANCE.getAbstractTimeSpanSensor();

		/**
		 * The meta object literal for the '<em><b>Time Span Recorders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TIME_SPAN_SENSOR__TIME_SPAN_RECORDERS = eINSTANCE.getAbstractTimeSpanSensor_TimeSpanRecorders();

		/**
		 * The meta object literal for the '<em><b>Stop Measurement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TIME_SPAN_SENSOR__STOP_MEASUREMENT = eINSTANCE.getAbstractTimeSpanSensor_StopMeasurement();

		/**
		 * The meta object literal for the '<em><b>Start Measurement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TIME_SPAN_SENSOR__START_MEASUREMENT = eINSTANCE.getAbstractTimeSpanSensor_StartMeasurement();

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
		 * The meta object literal for the '<em><b>State Recorder</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_SENSOR__STATE_RECORDER = eINSTANCE.getStateSensor_StateRecorder();

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

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.GlobalTimeSpanSensorImpl <em>Global Time Span Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.GlobalTimeSpanSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getGlobalTimeSpanSensor()
		 * @generated
		 */
		EClass GLOBAL_TIME_SPAN_SENSOR = eINSTANCE.getGlobalTimeSpanSensor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.LocalTimeSpanSensorImpl <em>Local Time Span Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.LocalTimeSpanSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getLocalTimeSpanSensor()
		 * @generated
		 */
		EClass LOCAL_TIME_SPAN_SENSOR = eINSTANCE.getLocalTimeSpanSensor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.InterruptionTimeSpanSensorImpl <em>Interruption Time Span Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.InterruptionTimeSpanSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getInterruptionTimeSpanSensor()
		 * @generated
		 */
		EClass INTERRUPTION_TIME_SPAN_SENSOR = eINSTANCE.getInterruptionTimeSpanSensor();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD = eINSTANCE.getInterruptionTimeSpanSensor_Threshold();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ResourceSensorImpl <em>Resource Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.ResourceSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getResourceSensor()
		 * @generated
		 */
		EClass RESOURCE_SENSOR = eINSTANCE.getResourceSensor();

		/**
		 * The meta object literal for the '<em><b>Observed Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_SENSOR__OBSERVED_RESOURCE = eINSTANCE.getResourceSensor_ObservedResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ProcessorShareSensorImpl <em>Processor Share Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.ProcessorShareSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getProcessorShareSensor()
		 * @generated
		 */
		EClass PROCESSOR_SHARE_SENSOR = eINSTANCE.getProcessorShareSensor();

		/**
		 * The meta object literal for the '<em><b>Observed Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS = eINSTANCE.getProcessorShareSensor_ObservedProcess();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.ResourceUtilisationSensorImpl <em>Resource Utilisation Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.ResourceUtilisationSensorImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getResourceUtilisationSensor()
		 * @generated
		 */
		EClass RESOURCE_UTILISATION_SENSOR = eINSTANCE.getResourceUtilisationSensor();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.measurement.impl.IntervalStateRecorderImpl <em>Interval State Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.measurement.impl.IntervalStateRecorderImpl
		 * @see de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl#getIntervalStateRecorder()
		 * @generated
		 */
		EClass INTERVAL_STATE_RECORDER = eINSTANCE.getIntervalStateRecorder();

		/**
		 * The meta object literal for the '<em><b>Time Interval</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL_STATE_RECORDER__TIME_INTERVAL = eINSTANCE.getIntervalStateRecorder_TimeInterval();

		/**
		 * The meta object literal for the '<em><b>Percent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_STATE_RECORDER__PERCENT = eINSTANCE.getIntervalStateRecorder_Percent();

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

	}

} //MeasurementPackage
