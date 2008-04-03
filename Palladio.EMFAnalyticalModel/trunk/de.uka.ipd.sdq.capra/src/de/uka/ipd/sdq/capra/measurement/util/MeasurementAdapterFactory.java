/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.util;

import de.uka.ipd.sdq.capra.core.Action;

import de.uka.ipd.sdq.capra.measurement.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage
 * @generated
 */
public class MeasurementAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MeasurementPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MeasurementPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurementSwitch<Adapter> modelSwitch =
		new MeasurementSwitch<Adapter>() {
			@Override
			public Adapter caseTimeProbe(TimeProbe object) {
				return createTimeProbeAdapter();
			}
			@Override
			public Adapter caseProbeAction(ProbeAction object) {
				return createProbeActionAdapter();
			}
			@Override
			public Adapter caseAbstractTimeSpanSensor(AbstractTimeSpanSensor object) {
				return createAbstractTimeSpanSensorAdapter();
			}
			@Override
			public Adapter caseTimeSpanRecorder(TimeSpanRecorder object) {
				return createTimeSpanRecorderAdapter();
			}
			@Override
			public Adapter caseRecorder(Recorder object) {
				return createRecorderAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseVisitProbe(VisitProbe object) {
				return createVisitProbeAdapter();
			}
			@Override
			public Adapter caseStateSensor(StateSensor object) {
				return createStateSensorAdapter();
			}
			@Override
			public Adapter caseStateRecorder(StateRecorder object) {
				return createStateRecorderAdapter();
			}
			@Override
			public Adapter caseCountingSensor(CountingSensor object) {
				return createCountingSensorAdapter();
			}
			@Override
			public Adapter caseCountingRecorder(CountingRecorder object) {
				return createCountingRecorderAdapter();
			}
			@Override
			public Adapter caseHistogramRecorder(HistogramRecorder object) {
				return createHistogramRecorderAdapter();
			}
			@Override
			public Adapter caseFullTimeSpanRecorder(FullTimeSpanRecorder object) {
				return createFullTimeSpanRecorderAdapter();
			}
			@Override
			public Adapter caseSteadyStateRecorder(SteadyStateRecorder object) {
				return createSteadyStateRecorderAdapter();
			}
			@Override
			public Adapter caseFullStateRecorder(FullStateRecorder object) {
				return createFullStateRecorderAdapter();
			}
			@Override
			public Adapter caseFinalValueRecorder(FinalValueRecorder object) {
				return createFinalValueRecorderAdapter();
			}
			@Override
			public Adapter caseGlobalTimeSpanSensor(GlobalTimeSpanSensor object) {
				return createGlobalTimeSpanSensorAdapter();
			}
			@Override
			public Adapter caseLocalTimeSpanSensor(LocalTimeSpanSensor object) {
				return createLocalTimeSpanSensorAdapter();
			}
			@Override
			public Adapter caseInterruptionTimeSpanSensor(InterruptionTimeSpanSensor object) {
				return createInterruptionTimeSpanSensorAdapter();
			}
			@Override
			public Adapter caseResourceSensor(ResourceSensor object) {
				return createResourceSensorAdapter();
			}
			@Override
			public Adapter caseProcessorShareSensor(ProcessorShareSensor object) {
				return createProcessorShareSensorAdapter();
			}
			@Override
			public Adapter caseResourceUtilisationSensor(ResourceUtilisationSensor object) {
				return createResourceUtilisationSensorAdapter();
			}
			@Override
			public Adapter caseIntervalStateRecorder(IntervalStateRecorder object) {
				return createIntervalStateRecorderAdapter();
			}
			@Override
			public Adapter caseSensor(Sensor object) {
				return createSensorAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.TimeProbe <em>Time Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeProbe
	 * @generated
	 */
	public Adapter createTimeProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.ProbeAction <em>Probe Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.ProbeAction
	 * @generated
	 */
	public Adapter createProbeActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor <em>Abstract Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor
	 * @generated
	 */
	public Adapter createAbstractTimeSpanSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder <em>Time Span Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder
	 * @generated
	 */
	public Adapter createTimeSpanRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.Recorder <em>Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.Recorder
	 * @generated
	 */
	public Adapter createRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.VisitProbe <em>Visit Probe</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.VisitProbe
	 * @generated
	 */
	public Adapter createVisitProbeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.StateSensor <em>State Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.StateSensor
	 * @generated
	 */
	public Adapter createStateSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.CountingSensor <em>Counting Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.CountingSensor
	 * @generated
	 */
	public Adapter createCountingSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.CountingRecorder <em>Counting Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.CountingRecorder
	 * @generated
	 */
	public Adapter createCountingRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.StateRecorder <em>State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.StateRecorder
	 * @generated
	 */
	public Adapter createStateRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.HistogramRecorder <em>Histogram Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.HistogramRecorder
	 * @generated
	 */
	public Adapter createHistogramRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder <em>Full Time Span Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder
	 * @generated
	 */
	public Adapter createFullTimeSpanRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder <em>Steady State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder
	 * @generated
	 */
	public Adapter createSteadyStateRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.FullStateRecorder <em>Full State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.FullStateRecorder
	 * @generated
	 */
	public Adapter createFullStateRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.FinalValueRecorder <em>Final Value Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.FinalValueRecorder
	 * @generated
	 */
	public Adapter createFinalValueRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.GlobalTimeSpanSensor <em>Global Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.GlobalTimeSpanSensor
	 * @generated
	 */
	public Adapter createGlobalTimeSpanSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.LocalTimeSpanSensor <em>Local Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.LocalTimeSpanSensor
	 * @generated
	 */
	public Adapter createLocalTimeSpanSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor <em>Interruption Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor
	 * @generated
	 */
	public Adapter createInterruptionTimeSpanSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.ResourceSensor <em>Resource Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.ResourceSensor
	 * @generated
	 */
	public Adapter createResourceSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor <em>Processor Share Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor
	 * @generated
	 */
	public Adapter createProcessorShareSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.ResourceUtilisationSensor <em>Resource Utilisation Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.ResourceUtilisationSensor
	 * @generated
	 */
	public Adapter createResourceUtilisationSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder <em>Interval State Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder
	 * @generated
	 */
	public Adapter createIntervalStateRecorderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.measurement.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.measurement.Sensor
	 * @generated
	 */
	public Adapter createSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.capra.core.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.capra.core.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MeasurementAdapterFactory
