/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.util;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.*;

import java.util.Map;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage
 * @generated
 */
public class emfmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static emfmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public emfmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = emfmodelPackage.eINSTANCE;
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
	protected emfmodelSwitch<Adapter> modelSwitch =
		new emfmodelSwitch<Adapter>() {
			@Override
			public Adapter caseAggregatedMeasurements(AggregatedMeasurements object) {
				return createAggregatedMeasurementsAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseMeasurementRange(MeasurementRange object) {
				return createMeasurementRangeAdapter();
			}
			@Override
			public Adapter caseRawMeasurements(RawMeasurements object) {
				return createRawMeasurementsAdapter();
			}
			@Override
			public Adapter caseRawXValues(RawXValues object) {
				return createRawXValuesAdapter();
			}
			@Override
			public Adapter caseRawYValues(RawYValues object) {
				return createRawYValuesAdapter();
			}
			@Override
			public Adapter caseStatistics(Statistics object) {
				return createStatisticsAdapter();
			}
			@Override
			public Adapter caseFixedWidthAggregation(FixedWidthAggregation object) {
				return createFixedWidthAggregationAdapter();
			}
			@Override
			public Adapter caseIntervals(Intervals object) {
				return createIntervalsAdapter();
			}
			@Override
			public Adapter caseCollectedData(CollectedData object) {
				return createCollectedDataAdapter();
			}
			@Override
			public Adapter casePropertyable(Propertyable object) {
				return createPropertyableAdapter();
			}
			@Override
			public Adapter caseEStringtoEObjectMapEntry(Map.Entry<String, Object> object) {
				return createEStringtoEObjectMapEntryAdapter();
			}
			@Override
			public Adapter caseSensorDeclaration(SensorDeclaration object) {
				return createSensorDeclarationAdapter();
			}
			@Override
			public Adapter caseExperimentSetting(ExperimentSetting object) {
				return createExperimentSettingAdapter();
			}
			@Override
			public Adapter caseExperimentRun(ExperimentRun object) {
				return createExperimentRunAdapter();
			}
			@Override
			public Adapter caseMeasureCharacterization(MeasureCharacterization object) {
				return createMeasureCharacterizationAdapter();
			}
			@Override
			public Adapter caseAggregationCharacterization(AggregationCharacterization object) {
				return createAggregationCharacterizationAdapter();
			}
			@Override
			public Adapter caseLongBinaryMeasurements(LongBinaryMeasurements object) {
				return createLongBinaryMeasurementsAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseStateMeasurements(StateMeasurements object) {
				return createStateMeasurementsAdapter();
			}
			@Override
			public Adapter caseStateSensor(StateSensor object) {
				return createStateSensorAdapter();
			}
			@Override
			public Adapter caseDoubleBinaryMeasurements(DoubleBinaryMeasurements object) {
				return createDoubleBinaryMeasurementsAdapter();
			}
			@Override
			public Adapter caseExperimentGroup(ExperimentGroup object) {
				return createExperimentGroupAdapter();
			}
			@Override
			public Adapter caseMeasurableSensor(MeasurableSensor object) {
				return createMeasurableSensorAdapter();
			}
			@Override
			public Adapter caseJSXmlMeasurements(JSXmlMeasurements object) {
				return createJSXmlMeasurementsAdapter();
			}
			@Override
			public Adapter caseEventTimeAggregation(EventTimeAggregation object) {
				return createEventTimeAggregationAdapter();
			}
			@Override
			public Adapter caseValueAggregation(ValueAggregation object) {
				return createValueAggregationAdapter();
			}
			@Override
			public Adapter caseIncreasingMeasurableSensor(IncreasingMeasurableSensor object) {
				return createIncreasingMeasurableSensorAdapter();
			}
			@Override
			public Adapter caseAdvancedStatistics(AdvancedStatistics object) {
				return createAdvancedStatisticsAdapter();
			}
			@Override
			public Adapter caseDoubleBinaryEventTimes(DoubleBinaryEventTimes object) {
				return createDoubleBinaryEventTimesAdapter();
			}
			@Override
			public Adapter caseIJSDuration(Duration object) {
				return createIJSDurationAdapter();
			}
			@Override
			public Adapter caseIJSQuantity(Quantity object) {
				return createIJSQuantityAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregatedMeasurements
	 * @generated
	 */
	public Adapter createAggregatedMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurementRange
	 * @generated
	 */
	public Adapter createMeasurementRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.RawMeasurements <em>Raw Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.RawMeasurements
	 * @generated
	 */
	public Adapter createRawMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.RawXValues <em>Raw XValues</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.RawXValues
	 * @generated
	 */
	public Adapter createRawXValuesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.RawYValues <em>Raw YValues</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.RawYValues
	 * @generated
	 */
	public Adapter createRawYValuesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics <em>Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics
	 * @generated
	 */
	public Adapter createStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.FixedWidthAggregation <em>Fixed Width Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.FixedWidthAggregation
	 * @generated
	 */
	public Adapter createFixedWidthAggregationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Intervals <em>Intervals</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.Intervals
	 * @generated
	 */
	public Adapter createIntervalsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.CollectedData <em>Collected Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.CollectedData
	 * @generated
	 */
	public Adapter createCollectedDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Propertyable <em>Propertyable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.Propertyable
	 * @generated
	 */
	public Adapter createPropertyableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EStringto EObject Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringtoEObjectMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration <em>Sensor Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration
	 * @generated
	 */
	public Adapter createSensorDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentSetting <em>Experiment Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentSetting
	 * @generated
	 */
	public Adapter createExperimentSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentRun <em>Experiment Run</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentRun
	 * @generated
	 */
	public Adapter createExperimentRunAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasureCharacterization <em>Measure Characterization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasureCharacterization
	 * @generated
	 */
	public Adapter createMeasureCharacterizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregationCharacterization <em>Aggregation Characterization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregationCharacterization
	 * @generated
	 */
	public Adapter createAggregationCharacterizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.LongBinaryMeasurements <em>Long Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.LongBinaryMeasurements
	 * @generated
	 */
	public Adapter createLongBinaryMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.StateMeasurements <em>State Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.StateMeasurements
	 * @generated
	 */
	public Adapter createStateMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.StateSensor <em>State Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.StateSensor
	 * @generated
	 */
	public Adapter createStateSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.DoubleBinaryMeasurements <em>Double Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.DoubleBinaryMeasurements
	 * @generated
	 */
	public Adapter createDoubleBinaryMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup <em>Experiment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup
	 * @generated
	 */
	public Adapter createExperimentGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurableSensor <em>Measurable Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurableSensor
	 * @generated
	 */
	public Adapter createMeasurableSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.JSXmlMeasurements <em>JS Xml Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.JSXmlMeasurements
	 * @generated
	 */
	public Adapter createJSXmlMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.EventTimeAggregation <em>Event Time Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.EventTimeAggregation
	 * @generated
	 */
	public Adapter createEventTimeAggregationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.ValueAggregation <em>Value Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.ValueAggregation
	 * @generated
	 */
	public Adapter createValueAggregationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.IncreasingMeasurableSensor <em>Increasing Measurable Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.IncreasingMeasurableSensor
	 * @generated
	 */
	public Adapter createIncreasingMeasurableSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics <em>Advanced Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics
	 * @generated
	 */
	public Adapter createAdvancedStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.DoubleBinaryEventTimes <em>Double Binary Event Times</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.DoubleBinaryEventTimes
	 * @generated
	 */
	public Adapter createDoubleBinaryEventTimesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.measure.quantity.Duration <em>IJS Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.measure.quantity.Duration
	 * @generated
	 */
	public Adapter createIJSDurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.measure.quantity.Quantity <em>IJS Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.measure.quantity.Quantity
	 * @generated
	 */
	public Adapter createIJSQuantityAdapter() {
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

} //emfmodelAdapterFactory
