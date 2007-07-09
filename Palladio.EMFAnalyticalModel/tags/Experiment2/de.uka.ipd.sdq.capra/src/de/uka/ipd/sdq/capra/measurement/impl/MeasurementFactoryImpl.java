/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.*;

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
public class MeasurementFactoryImpl extends EFactoryImpl implements MeasurementFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeasurementFactory init() {
		try {
			MeasurementFactory theMeasurementFactory = (MeasurementFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Capra/Measurements/1.0"); 
			if (theMeasurementFactory != null) {
				return theMeasurementFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MeasurementFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementFactoryImpl() {
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
			case MeasurementPackage.TIME_PROBE: return createTimeProbe();
			case MeasurementPackage.TIME_SPAN_SENSOR: return createTimeSpanSensor();
			case MeasurementPackage.CONDITION: return createCondition();
			case MeasurementPackage.VISIT_PROBE: return createVisitProbe();
			case MeasurementPackage.STATE_SENSOR: return createStateSensor();
			case MeasurementPackage.COUNTING_SENSOR: return createCountingSensor();
			case MeasurementPackage.HISTOGRAM_RECORDER: return createHistogramRecorder();
			case MeasurementPackage.FULL_TIME_SPAN_RECORDER: return createFullTimeSpanRecorder();
			case MeasurementPackage.STEADY_STATE_RECORDER: return createSteadyStateRecorder();
			case MeasurementPackage.FULL_STATE_RECORDER: return createFullStateRecorder();
			case MeasurementPackage.FINAL_VALUE_RECORDER: return createFinalValueRecorder();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeProbe createTimeProbe() {
		TimeProbeImpl timeProbe = new TimeProbeImpl();
		return timeProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSpanSensor createTimeSpanSensor() {
		TimeSpanSensorImpl timeSpanSensor = new TimeSpanSensorImpl();
		return timeSpanSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitProbe createVisitProbe() {
		VisitProbeImpl visitProbe = new VisitProbeImpl();
		return visitProbe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateSensor createStateSensor() {
		StateSensorImpl stateSensor = new StateSensorImpl();
		return stateSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountingSensor createCountingSensor() {
		CountingSensorImpl countingSensor = new CountingSensorImpl();
		return countingSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HistogramRecorder createHistogramRecorder() {
		HistogramRecorderImpl histogramRecorder = new HistogramRecorderImpl();
		return histogramRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FullTimeSpanRecorder createFullTimeSpanRecorder() {
		FullTimeSpanRecorderImpl fullTimeSpanRecorder = new FullTimeSpanRecorderImpl();
		return fullTimeSpanRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteadyStateRecorder createSteadyStateRecorder() {
		SteadyStateRecorderImpl steadyStateRecorder = new SteadyStateRecorderImpl();
		return steadyStateRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FullStateRecorder createFullStateRecorder() {
		FullStateRecorderImpl fullStateRecorder = new FullStateRecorderImpl();
		return fullStateRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalValueRecorder createFinalValueRecorder() {
		FinalValueRecorderImpl finalValueRecorder = new FinalValueRecorderImpl();
		return finalValueRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementPackage getMeasurementPackage() {
		return (MeasurementPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MeasurementPackage getPackage() {
		return MeasurementPackage.eINSTANCE;
	}

} //MeasurementFactoryImpl
