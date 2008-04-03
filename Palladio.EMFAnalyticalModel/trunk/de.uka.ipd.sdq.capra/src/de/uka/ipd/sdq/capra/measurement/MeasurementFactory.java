/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage
 * @generated
 */
public interface MeasurementFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasurementFactory eINSTANCE = de.uka.ipd.sdq.capra.measurement.impl.MeasurementFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Time Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Probe</em>'.
	 * @generated
	 */
	TimeProbe createTimeProbe();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>Visit Probe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visit Probe</em>'.
	 * @generated
	 */
	VisitProbe createVisitProbe();

	/**
	 * Returns a new object of class '<em>Counting Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Counting Sensor</em>'.
	 * @generated
	 */
	CountingSensor createCountingSensor();

	/**
	 * Returns a new object of class '<em>Histogram Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Histogram Recorder</em>'.
	 * @generated
	 */
	HistogramRecorder createHistogramRecorder();

	/**
	 * Returns a new object of class '<em>Full Time Span Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Full Time Span Recorder</em>'.
	 * @generated
	 */
	FullTimeSpanRecorder createFullTimeSpanRecorder();

	/**
	 * Returns a new object of class '<em>Steady State Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Steady State Recorder</em>'.
	 * @generated
	 */
	SteadyStateRecorder createSteadyStateRecorder();

	/**
	 * Returns a new object of class '<em>Full State Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Full State Recorder</em>'.
	 * @generated
	 */
	FullStateRecorder createFullStateRecorder();

	/**
	 * Returns a new object of class '<em>Final Value Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Final Value Recorder</em>'.
	 * @generated
	 */
	FinalValueRecorder createFinalValueRecorder();

	/**
	 * Returns a new object of class '<em>Global Time Span Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Time Span Sensor</em>'.
	 * @generated
	 */
	GlobalTimeSpanSensor createGlobalTimeSpanSensor();

	/**
	 * Returns a new object of class '<em>Local Time Span Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Time Span Sensor</em>'.
	 * @generated
	 */
	LocalTimeSpanSensor createLocalTimeSpanSensor();

	/**
	 * Returns a new object of class '<em>Interruption Time Span Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interruption Time Span Sensor</em>'.
	 * @generated
	 */
	InterruptionTimeSpanSensor createInterruptionTimeSpanSensor();

	/**
	 * Returns a new object of class '<em>Processor Share Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor Share Sensor</em>'.
	 * @generated
	 */
	ProcessorShareSensor createProcessorShareSensor();

	/**
	 * Returns a new object of class '<em>Resource Utilisation Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Utilisation Sensor</em>'.
	 * @generated
	 */
	ResourceUtilisationSensor createResourceUtilisationSensor();

	/**
	 * Returns a new object of class '<em>Interval State Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interval State Recorder</em>'.
	 * @generated
	 */
	IntervalStateRecorder createIntervalStateRecorder();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MeasurementPackage getMeasurementPackage();

} //MeasurementFactory
