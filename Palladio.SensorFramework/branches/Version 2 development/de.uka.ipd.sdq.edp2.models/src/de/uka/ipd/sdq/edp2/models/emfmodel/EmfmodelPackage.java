/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * <!-- begin-model-doc -->
 * Experiment Data Persistency and Presentation
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory
 * @model kind="package"
 * @generated
 */
public interface EmfmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emfmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/EDP2/0.9.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.uka.ipd.sdq.edp2.models";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmfmodelPackage eINSTANCE = de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.IdentifiableImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__UUID = 0;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl <em>Aggregated Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getAggregatedMeasurements()
	 * @generated
	 */
	int AGGREGATED_MEASUREMENTS = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS__UUID = IDENTIFIABLE__UUID;

	/**
	 * The feature id for the '<em><b>Measurement Range</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS__VALID = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS__FUNCTION = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Aggregation Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Aggregation On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS__AGGREGATION_ON = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS__METRIC = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Aggregated Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MEASUREMENTS_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementRangeImpl <em>Measurement Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementRangeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMeasurementRange()
	 * @generated
	 */
	int MEASUREMENT_RANGE = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RawMeasurementsImpl <em>Raw Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.RawMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getRawMeasurements()
	 * @generated
	 */
	int RAW_MEASUREMENTS = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl <em>Data Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDataSeries()
	 * @generated
	 */
	int DATA_SERIES = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalStatisticsImpl <em>Nominal Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalStatisticsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getNominalStatistics()
	 * @generated
	 */
	int NOMINAL_STATISTICS = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedIntervalsImpl <em>Fixed Intervals</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedIntervalsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getFixedIntervals()
	 * @generated
	 */
	int FIXED_INTERVALS = 9;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.PropertyableImpl <em>Propertyable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.PropertyableImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getPropertyable()
	 * @generated
	 */
	int PROPERTYABLE = 3;

	/**
	 * The feature id for the '<em><b>Additional Information</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTYABLE__ADDITIONAL_INFORMATION = 0;

	/**
	 * The number of structural features of the '<em>Propertyable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTYABLE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Additional Information</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RANGE__ADDITIONAL_INFORMATION = PROPERTYABLE__ADDITIONAL_INFORMATION;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RANGE__RAW_MEASUREMENTS = PROPERTYABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RANGE__END_TIME = PROPERTYABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RANGE__START_TIME = PROPERTYABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Measurement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RANGE__MEASUREMENT = PROPERTYABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS = PROPERTYABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Measurement Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RANGE_FEATURE_COUNT = PROPERTYABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementImpl <em>Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMeasurement()
	 * @generated
	 */
	int MEASUREMENT = 10;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.EStringtoEObjectMapEntryImpl <em>EStringto EObject Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EStringtoEObjectMapEntryImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEStringtoEObjectMapEntry()
	 * @generated
	 */
	int ESTRINGTO_EOBJECT_MAP_ENTRY = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRINGTO_EOBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRINGTO_EOBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EStringto EObject Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRINGTO_EOBJECT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_MEASUREMENTS__UUID = IDENTIFIABLE__UUID;

	/**
	 * The feature id for the '<em><b>Data Series</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_MEASUREMENTS__DATA_SERIES = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measurement Range</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_MEASUREMENTS__MEASUREMENT_RANGE = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Raw Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_MEASUREMENTS_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERIES__STATISTICS = 0;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERIES__AGGREGATED_MEASUREMENTS = 1;

	/**
	 * The feature id for the '<em><b>Values Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERIES__VALUES_UUID = 2;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERIES__RAW_MEASUREMENTS = 3;

	/**
	 * The number of structural features of the '<em>Data Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERIES_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_STATISTICS__COUNT = 0;

	/**
	 * The feature id for the '<em><b>Raw YSeries</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_STATISTICS__RAW_YSERIES = 1;

	/**
	 * The number of structural features of the '<em>Nominal Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_STATISTICS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregatedMeasurementsImpl <em>Fixed Width Aggregated Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregatedMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getFixedWidthAggregatedMeasurements()
	 * @generated
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS = 8;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__UUID = AGGREGATED_MEASUREMENTS__UUID;

	/**
	 * The feature id for the '<em><b>Measurement Range</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE = AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__VALID = AGGREGATED_MEASUREMENTS__VALID;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__FUNCTION = AGGREGATED_MEASUREMENTS__FUNCTION;

	/**
	 * The feature id for the '<em><b>Aggregation Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS = AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS;

	/**
	 * The feature id for the '<em><b>Aggregation On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__AGGREGATION_ON = AGGREGATED_MEASUREMENTS__AGGREGATION_ON;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__METRIC = AGGREGATED_MEASUREMENTS__METRIC;

	/**
	 * The feature id for the '<em><b>Intervals</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS = AGGREGATED_MEASUREMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Series</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES = AGGREGATED_MEASUREMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fixed Width Aggregated Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_WIDTH_AGGREGATED_MEASUREMENTS_FEATURE_COUNT = AGGREGATED_MEASUREMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_INTERVALS__LOWER_BOUND = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_INTERVALS__WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Number Of Intervals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_INTERVALS__NUMBER_OF_INTERVALS = 2;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_INTERVALS__AGGREGATED_MEASUREMENTS = 3;

	/**
	 * The number of structural features of the '<em>Fixed Intervals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_INTERVALS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl <em>Experiment Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getExperimentGroup()
	 * @generated
	 */
	int EXPERIMENT_GROUP = 12;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentSettingImpl <em>Experiment Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentSettingImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getExperimentSetting()
	 * @generated
	 */
	int EXPERIMENT_SETTING = 13;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl <em>Experiment Run</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getExperimentRun()
	 * @generated
	 */
	int EXPERIMENT_RUN = 14;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDescription()
	 * @generated
	 */
	int DESCRIPTION = 15;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricDescriptionImpl <em>Metric Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricDescriptionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMetricDescription()
	 * @generated
	 */
	int METRIC_DESCRIPTION = 16;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.BaseMetricDescriptionImpl <em>Base Metric Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.BaseMetricDescriptionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getBaseMetricDescription()
	 * @generated
	 */
	int BASE_METRIC_DESCRIPTION = 19;

	/**
	 * The feature id for the '<em><b>Additional Information</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__ADDITIONAL_INFORMATION = PROPERTYABLE__ADDITIONAL_INFORMATION;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__MEASURE = PROPERTYABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Experiment Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__EXPERIMENT_RUN = PROPERTYABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Measurement Range</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__MEASUREMENT_RANGE = PROPERTYABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_FEATURE_COUNT = PROPERTYABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl <em>Edp2 Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEdp2Measure()
	 * @generated
	 */
	int EDP2_MEASURE = 11;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_MEASURE__EXPERIMENT_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Experiment Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_MEASURE__EXPERIMENT_SETTINGS = 1;

	/**
	 * The feature id for the '<em><b>Persistency Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_MEASURE__PERSISTENCY_KIND = 2;

	/**
	 * The feature id for the '<em><b>Measured Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_MEASURE__MEASURED_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_MEASURE__METRIC = 4;

	/**
	 * The number of structural features of the '<em>Edp2 Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_MEASURE_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_GROUP__UUID = IDENTIFIABLE__UUID;

	/**
	 * The feature id for the '<em><b>Additional Information</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_GROUP__ADDITIONAL_INFORMATION = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Experiment Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_GROUP__EXPERIMENT_SETTINGS = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_GROUP__REPOSITORY = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_GROUP__PURPOSE = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_GROUP__MEASURE = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Experiment Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_GROUP_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Additional Information</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SETTING__ADDITIONAL_INFORMATION = PROPERTYABLE__ADDITIONAL_INFORMATION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SETTING__DESCRIPTION = PROPERTYABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Experiment Runs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SETTING__EXPERIMENT_RUNS = PROPERTYABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SETTING__MEASURE = PROPERTYABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Experiment Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SETTING_FEATURE_COUNT = PROPERTYABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_RUN__UUID = IDENTIFIABLE__UUID;

	/**
	 * The feature id for the '<em><b>Additional Information</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_RUN__ADDITIONAL_INFORMATION = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measurement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_RUN__MEASUREMENT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_RUN__START_TIME = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_RUN__DURATION = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Experiment Setting</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_RUN__EXPERIMENT_SETTING = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Experiment Run</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_RUN_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__UUID = IDENTIFIABLE__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Textual Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__TEXTUAL_DESCRIPTION = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__REPOSITORY = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DESCRIPTION__UUID = DESCRIPTION__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DESCRIPTION__NAME = DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Textual Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DESCRIPTION__TEXTUAL_DESCRIPTION = DESCRIPTION__TEXTUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DESCRIPTION__REPOSITORY = DESCRIPTION__REPOSITORY;

	/**
	 * The number of structural features of the '<em>Metric Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DESCRIPTION_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationFunctionDescriptionImpl <em>Aggregation Function Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationFunctionDescriptionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getAggregationFunctionDescription()
	 * @generated
	 */
	int AGGREGATION_FUNCTION_DESCRIPTION = 17;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationStatisticsImpl <em>Aggregation Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationStatisticsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getAggregationStatistics()
	 * @generated
	 */
	int AGGREGATION_STATISTICS = 18;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION_DESCRIPTION__UUID = DESCRIPTION__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION_DESCRIPTION__NAME = DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Textual Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION_DESCRIPTION__TEXTUAL_DESCRIPTION = DESCRIPTION__TEXTUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION_DESCRIPTION__REPOSITORY = DESCRIPTION__REPOSITORY;

	/**
	 * The number of structural features of the '<em>Aggregation Function Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION_DESCRIPTION_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Distinct Values Before Aggregation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION = 0;

	/**
	 * The feature id for the '<em><b>Distinct Values After Aggregation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION = 1;

	/**
	 * The number of structural features of the '<em>Aggregation Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_STATISTICS_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__UUID = METRIC_DESCRIPTION__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__NAME = METRIC_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Textual Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__TEXTUAL_DESCRIPTION = METRIC_DESCRIPTION__TEXTUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__REPOSITORY = METRIC_DESCRIPTION__REPOSITORY;

	/**
	 * The feature id for the '<em><b>Capture Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__CAPTURE_TYPE = METRIC_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__DATA_TYPE = METRIC_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__SCALE = METRIC_DESCRIPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Monotonic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__MONOTONIC = METRIC_DESCRIPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION__DEFAULT_UNIT = METRIC_DESCRIPTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Base Metric Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METRIC_DESCRIPTION_FEATURE_COUNT = METRIC_DESCRIPTION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.LongBinaryMeasurementsImpl <em>Long Binary Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.LongBinaryMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getLongBinaryMeasurements()
	 * @generated
	 */
	int LONG_BINARY_MEASUREMENTS = 20;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BINARY_MEASUREMENTS__STATISTICS = DATA_SERIES__STATISTICS;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BINARY_MEASUREMENTS__AGGREGATED_MEASUREMENTS = DATA_SERIES__AGGREGATED_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Values Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BINARY_MEASUREMENTS__VALUES_UUID = DATA_SERIES__VALUES_UUID;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BINARY_MEASUREMENTS__RAW_MEASUREMENTS = DATA_SERIES__RAW_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Storage Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BINARY_MEASUREMENTS__STORAGE_UNIT = DATA_SERIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Binary Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BINARY_MEASUREMENTS_FEATURE_COUNT = DATA_SERIES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.CategoryIdentifierImpl <em>Category Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.CategoryIdentifierImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getCategoryIdentifier()
	 * @generated
	 */
	int CATEGORY_IDENTIFIER = 21;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_IDENTIFIER__UUID = IDENTIFIABLE__UUID;

	/**
	 * The feature id for the '<em><b>State Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_IDENTIFIER__STATE_LITERAL = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Category Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_IDENTIFIER_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasurementsImpl <em>Nominal Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getNominalMeasurements()
	 * @generated
	 */
	int NOMINAL_MEASUREMENTS = 22;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASUREMENTS__STATISTICS = DATA_SERIES__STATISTICS;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASUREMENTS__AGGREGATED_MEASUREMENTS = DATA_SERIES__AGGREGATED_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Values Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASUREMENTS__VALUES_UUID = DATA_SERIES__VALUES_UUID;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASUREMENTS__RAW_MEASUREMENTS = DATA_SERIES__RAW_MEASUREMENTS;

	/**
	 * The number of structural features of the '<em>Nominal Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASUREMENTS_FEATURE_COUNT = DATA_SERIES_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasureImpl <em>Nominal Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasureImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getNominalMeasure()
	 * @generated
	 */
	int NOMINAL_MEASURE = 23;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__EXPERIMENT_GROUP = EDP2_MEASURE__EXPERIMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Experiment Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__EXPERIMENT_SETTINGS = EDP2_MEASURE__EXPERIMENT_SETTINGS;

	/**
	 * The feature id for the '<em><b>Persistency Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__PERSISTENCY_KIND = EDP2_MEASURE__PERSISTENCY_KIND;

	/**
	 * The feature id for the '<em><b>Measured Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__MEASURED_OBJECT = EDP2_MEASURE__MEASURED_OBJECT;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__METRIC = EDP2_MEASURE__METRIC;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__UUID = EDP2_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Defined Category Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS = EDP2_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE__INITIAL_STATE = EDP2_MEASURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Nominal Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASURE_FEATURE_COUNT = EDP2_MEASURE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DoubleBinaryMeasurementsImpl <em>Double Binary Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DoubleBinaryMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDoubleBinaryMeasurements()
	 * @generated
	 */
	int DOUBLE_BINARY_MEASUREMENTS = 24;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BINARY_MEASUREMENTS__STATISTICS = DATA_SERIES__STATISTICS;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BINARY_MEASUREMENTS__AGGREGATED_MEASUREMENTS = DATA_SERIES__AGGREGATED_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Values Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BINARY_MEASUREMENTS__VALUES_UUID = DATA_SERIES__VALUES_UUID;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BINARY_MEASUREMENTS__RAW_MEASUREMENTS = DATA_SERIES__RAW_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Storage Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT = DATA_SERIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Binary Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BINARY_MEASUREMENTS_FEATURE_COUNT = DATA_SERIES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalMeasureImpl <em>Ordinal Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalMeasureImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getOrdinalMeasure()
	 * @generated
	 */
	int ORDINAL_MEASURE = 25;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_MEASURE__EXPERIMENT_GROUP = EDP2_MEASURE__EXPERIMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Experiment Settings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_MEASURE__EXPERIMENT_SETTINGS = EDP2_MEASURE__EXPERIMENT_SETTINGS;

	/**
	 * The feature id for the '<em><b>Persistency Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_MEASURE__PERSISTENCY_KIND = EDP2_MEASURE__PERSISTENCY_KIND;

	/**
	 * The feature id for the '<em><b>Measured Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_MEASURE__MEASURED_OBJECT = EDP2_MEASURE__MEASURED_OBJECT;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_MEASURE__METRIC = EDP2_MEASURE__METRIC;

	/**
	 * The number of structural features of the '<em>Ordinal Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_MEASURE_FEATURE_COUNT = EDP2_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.JSXmlMeasurementsImpl <em>JS Xml Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.JSXmlMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getJSXmlMeasurements()
	 * @generated
	 */
	int JS_XML_MEASUREMENTS = 26;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JS_XML_MEASUREMENTS__STATISTICS = DATA_SERIES__STATISTICS;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JS_XML_MEASUREMENTS__AGGREGATED_MEASUREMENTS = DATA_SERIES__AGGREGATED_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Values Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JS_XML_MEASUREMENTS__VALUES_UUID = DATA_SERIES__VALUES_UUID;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JS_XML_MEASUREMENTS__RAW_MEASUREMENTS = DATA_SERIES__RAW_MEASUREMENTS;

	/**
	 * The number of structural features of the '<em>JS Xml Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JS_XML_MEASUREMENTS_FEATURE_COUNT = DATA_SERIES_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.measure.quantity.Duration <em>IJS Duration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.quantity.Duration
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIJSDuration()
	 * @generated
	 */
	int IJS_DURATION = 27;

	/**
	 * The number of structural features of the '<em>IJS Duration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IJS_DURATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.measure.quantity.Quantity <em>IJS Quantity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.quantity.Quantity
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIJSQuantity()
	 * @generated
	 */
	int IJS_QUANTITY = 28;

	/**
	 * The number of structural features of the '<em>IJS Quantity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IJS_QUANTITY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionsImpl <em>Descriptions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDescriptions()
	 * @generated
	 */
	int DESCRIPTIONS = 29;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIONS__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Descriptions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricSetDescriptionImpl <em>Metric Set Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricSetDescriptionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMetricSetDescription()
	 * @generated
	 */
	int METRIC_SET_DESCRIPTION = 30;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SET_DESCRIPTION__UUID = METRIC_DESCRIPTION__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SET_DESCRIPTION__NAME = METRIC_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Textual Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SET_DESCRIPTION__TEXTUAL_DESCRIPTION = METRIC_DESCRIPTION__TEXTUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SET_DESCRIPTION__REPOSITORY = METRIC_DESCRIPTION__REPOSITORY;

	/**
	 * The feature id for the '<em><b>Subsumed Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SET_DESCRIPTION__SUBSUMED_METRICS = METRIC_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Metric Set Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SET_DESCRIPTION_FEATURE_COUNT = METRIC_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl <em>Ordinal Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getOrdinalStatistics()
	 * @generated
	 */
	int ORDINAL_STATISTICS = 31;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_STATISTICS__COUNT = NOMINAL_STATISTICS__COUNT;

	/**
	 * The feature id for the '<em><b>Raw YSeries</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_STATISTICS__RAW_YSERIES = NOMINAL_STATISTICS__RAW_YSERIES;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_STATISTICS__MINIMUM = NOMINAL_STATISTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_STATISTICS__MAXIMUM = NOMINAL_STATISTICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Median</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_STATISTICS__MEDIAN = NOMINAL_STATISTICS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Percentiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_STATISTICS__PERCENTILES = NOMINAL_STATISTICS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ordinal Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_STATISTICS_FEATURE_COUNT = NOMINAL_STATISTICS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.PercentileImpl <em>Percentile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.PercentileImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getPercentile()
	 * @generated
	 */
	int PERCENTILE = 32;

	/**
	 * The feature id for the '<em><b>Percentile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTILE__PERCENTILE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTILE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Percentile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTILE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.IntervalStatisticsImpl <em>Interval Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.IntervalStatisticsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIntervalStatistics()
	 * @generated
	 */
	int INTERVAL_STATISTICS = 33;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__COUNT = ORDINAL_STATISTICS__COUNT;

	/**
	 * The feature id for the '<em><b>Raw YSeries</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__RAW_YSERIES = ORDINAL_STATISTICS__RAW_YSERIES;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__MINIMUM = ORDINAL_STATISTICS__MINIMUM;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__MAXIMUM = ORDINAL_STATISTICS__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Median</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__MEDIAN = ORDINAL_STATISTICS__MEDIAN;

	/**
	 * The feature id for the '<em><b>Percentiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__PERCENTILES = ORDINAL_STATISTICS__PERCENTILES;

	/**
	 * The feature id for the '<em><b>Arithmethic Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__ARITHMETHIC_MEAN = ORDINAL_STATISTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__VARIANCE = ORDINAL_STATISTICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__STANDARD_DEVIATION = ORDINAL_STATISTICS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS__SUM = ORDINAL_STATISTICS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Interval Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_STATISTICS_FEATURE_COUNT = ORDINAL_STATISTICS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RatioStatisticsImpl <em>Ratio Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.RatioStatisticsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getRatioStatistics()
	 * @generated
	 */
	int RATIO_STATISTICS = 34;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__COUNT = INTERVAL_STATISTICS__COUNT;

	/**
	 * The feature id for the '<em><b>Raw YSeries</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__RAW_YSERIES = INTERVAL_STATISTICS__RAW_YSERIES;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__MINIMUM = INTERVAL_STATISTICS__MINIMUM;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__MAXIMUM = INTERVAL_STATISTICS__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Median</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__MEDIAN = INTERVAL_STATISTICS__MEDIAN;

	/**
	 * The feature id for the '<em><b>Percentiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__PERCENTILES = INTERVAL_STATISTICS__PERCENTILES;

	/**
	 * The feature id for the '<em><b>Arithmethic Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__ARITHMETHIC_MEAN = INTERVAL_STATISTICS__ARITHMETHIC_MEAN;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__VARIANCE = INTERVAL_STATISTICS__VARIANCE;

	/**
	 * The feature id for the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__STANDARD_DEVIATION = INTERVAL_STATISTICS__STANDARD_DEVIATION;

	/**
	 * The feature id for the '<em><b>Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__SUM = INTERVAL_STATISTICS__SUM;

	/**
	 * The feature id for the '<em><b>Coefficient Of Variation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__COEFFICIENT_OF_VARIATION = INTERVAL_STATISTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Geometric Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__GEOMETRIC_MEAN = INTERVAL_STATISTICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Harmonic Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS__HARMONIC_MEAN = INTERVAL_STATISTICS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ratio Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_STATISTICS_FEATURE_COUNT = INTERVAL_STATISTICS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedNominalMeasurementsImpl <em>Observed Nominal Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedNominalMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getObservedNominalMeasurements()
	 * @generated
	 */
	int OBSERVED_NOMINAL_MEASUREMENTS = 35;

	/**
	 * The feature id for the '<em><b>Observed Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_NOMINAL_MEASUREMENTS__UUID = 1;

	/**
	 * The number of structural features of the '<em>Observed Nominal Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_NOMINAL_MEASUREMENTS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedCategoryImpl <em>Observed Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedCategoryImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getObservedCategory()
	 * @generated
	 */
	int OBSERVED_CATEGORY = 36;

	/**
	 * The feature id for the '<em><b>Category Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_CATEGORY__CATEGORY_IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Observed Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_CATEGORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1NominalMeasurementsImpl <em>Sensor Framework V1 Nominal Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1NominalMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getSensorFrameworkV1NominalMeasurements()
	 * @generated
	 */
	int SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS = 37;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS__STATISTICS = NOMINAL_MEASUREMENTS__STATISTICS;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS__AGGREGATED_MEASUREMENTS = NOMINAL_MEASUREMENTS__AGGREGATED_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Values Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS__VALUES_UUID = NOMINAL_MEASUREMENTS__VALUES_UUID;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS__RAW_MEASUREMENTS = NOMINAL_MEASUREMENTS__RAW_MEASUREMENTS;

	/**
	 * The number of structural features of the '<em>Sensor Framework V1 Nominal Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS_FEATURE_COUNT = NOMINAL_MEASUREMENTS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1DoubleBinaryMeasurementsImpl <em>Sensor Framework V1 Double Binary Measurements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1DoubleBinaryMeasurementsImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getSensorFrameworkV1DoubleBinaryMeasurements()
	 * @generated
	 */
	int SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS = 38;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS__STATISTICS = DOUBLE_BINARY_MEASUREMENTS__STATISTICS;

	/**
	 * The feature id for the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS__AGGREGATED_MEASUREMENTS = DOUBLE_BINARY_MEASUREMENTS__AGGREGATED_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Values Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS__VALUES_UUID = DOUBLE_BINARY_MEASUREMENTS__VALUES_UUID;

	/**
	 * The feature id for the '<em><b>Raw Measurements</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS__RAW_MEASUREMENTS = DOUBLE_BINARY_MEASUREMENTS__RAW_MEASUREMENTS;

	/**
	 * The feature id for the '<em><b>Storage Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT = DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT;

	/**
	 * The number of structural features of the '<em>Sensor Framework V1 Double Binary Measurements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS_FEATURE_COUNT = DOUBLE_BINARY_MEASUREMENTS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions <em>Persistence Kind Options</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getPersistenceKindOptions()
	 * @generated
	 */
	int PERSISTENCE_KIND_OPTIONS = 39;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType <em>Capture Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getCaptureType()
	 * @generated
	 */
	int CAPTURE_TYPE = 40;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataType
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 41;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Scale <em>Scale</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Scale
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getScale()
	 * @generated
	 */
	int SCALE = 42;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Monotonic <em>Monotonic</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Monotonic
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMonotonic()
	 * @generated
	 */
	int MONOTONIC = 43;

	/**
	 * The meta object id for the '<em>EJS Measure</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.Measure
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEJSMeasure()
	 * @generated
	 */
	int EJS_MEASURE = 44;

	/**
	 * The meta object id for the '<em>EJS Duration Measure</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.Measure
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEJSDurationMeasure()
	 * @generated
	 */
	int EJS_DURATION_MEASURE = 45;

	/**
	 * The meta object id for the '<em>EJS Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.unit.Unit
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEJSUnit()
	 * @generated
	 */
	int EJS_UNIT = 46;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements
	 * @generated
	 */
	EClass getAggregatedMeasurements();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Measurement Range</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMeasurementRange()
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	EReference getAggregatedMeasurements_MeasurementRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#isValid <em>Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#isValid()
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	EAttribute getAggregatedMeasurements_Valid();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getFunction()
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	EReference getAggregatedMeasurements_Function();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationStatistics <em>Aggregation Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aggregation Statistics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationStatistics()
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	EReference getAggregatedMeasurements_AggregationStatistics();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationOn <em>Aggregation On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Aggregation On</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationOn()
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	EReference getAggregatedMeasurements_AggregationOn();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMetric()
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	EReference getAggregatedMeasurements_Metric();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Identifiable#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Identifiable#getUuid()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_Uuid();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Range</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange
	 * @generated
	 */
	EClass getMeasurementRange();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getRawMeasurements <em>Raw Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Raw Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getRawMeasurements()
	 * @see #getMeasurementRange()
	 * @generated
	 */
	EReference getMeasurementRange_RawMeasurements();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getEndTime()
	 * @see #getMeasurementRange()
	 * @generated
	 */
	EAttribute getMeasurementRange_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getStartTime()
	 * @see #getMeasurementRange()
	 * @generated
	 */
	EAttribute getMeasurementRange_StartTime();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Measurement</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getMeasurement()
	 * @see #getMeasurementRange()
	 * @generated
	 */
	EReference getMeasurementRange_Measurement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aggregated Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getAggregatedMeasurements()
	 * @see #getMeasurementRange()
	 * @generated
	 */
	EReference getMeasurementRange_AggregatedMeasurements();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements <em>Raw Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raw Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements
	 * @generated
	 */
	EClass getRawMeasurements();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getDataSeries <em>Data Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Series</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getDataSeries()
	 * @see #getRawMeasurements()
	 * @generated
	 */
	EReference getRawMeasurements_DataSeries();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getMeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Measurement Range</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getMeasurementRange()
	 * @see #getRawMeasurements()
	 * @generated
	 */
	EReference getRawMeasurements_MeasurementRange();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries <em>Data Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Series</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries
	 * @generated
	 */
	EClass getDataSeries();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getStatistics <em>Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statistics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getStatistics()
	 * @see #getDataSeries()
	 * @generated
	 */
	EReference getDataSeries_Statistics();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Aggregated Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getAggregatedMeasurements()
	 * @see #getDataSeries()
	 * @generated
	 */
	EReference getDataSeries_AggregatedMeasurements();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getValuesUuid <em>Values Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Values Uuid</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getValuesUuid()
	 * @see #getDataSeries()
	 * @generated
	 */
	EAttribute getDataSeries_ValuesUuid();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getRawMeasurements <em>Raw Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Raw Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getRawMeasurements()
	 * @see #getDataSeries()
	 * @generated
	 */
	EReference getDataSeries_RawMeasurements();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics <em>Nominal Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nominal Statistics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics
	 * @generated
	 */
	EClass getNominalStatistics();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getCount()
	 * @see #getNominalStatistics()
	 * @generated
	 */
	EAttribute getNominalStatistics_Count();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getRawYSeries <em>Raw YSeries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Raw YSeries</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getRawYSeries()
	 * @see #getNominalStatistics()
	 * @generated
	 */
	EReference getNominalStatistics_RawYSeries();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements <em>Fixed Width Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Width Aggregated Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements
	 * @generated
	 */
	EClass getFixedWidthAggregatedMeasurements();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getIntervals <em>Intervals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Intervals</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getIntervals()
	 * @see #getFixedWidthAggregatedMeasurements()
	 * @generated
	 */
	EReference getFixedWidthAggregatedMeasurements_Intervals();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getDataSeries <em>Data Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Series</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getDataSeries()
	 * @see #getFixedWidthAggregatedMeasurements()
	 * @generated
	 */
	EReference getFixedWidthAggregatedMeasurements_DataSeries();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals <em>Fixed Intervals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Intervals</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals
	 * @generated
	 */
	EClass getFixedIntervals();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getLowerBound()
	 * @see #getFixedIntervals()
	 * @generated
	 */
	EAttribute getFixedIntervals_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getWidth()
	 * @see #getFixedIntervals()
	 * @generated
	 */
	EAttribute getFixedIntervals_Width();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getNumberOfIntervals <em>Number Of Intervals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Intervals</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getNumberOfIntervals()
	 * @see #getFixedIntervals()
	 * @generated
	 */
	EAttribute getFixedIntervals_NumberOfIntervals();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Aggregated Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getAggregatedMeasurements()
	 * @see #getFixedIntervals()
	 * @generated
	 */
	EReference getFixedIntervals_AggregatedMeasurements();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Measurement
	 * @generated
	 */
	EClass getMeasurement();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Measure</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasure()
	 * @see #getMeasurement()
	 * @generated
	 */
	EReference getMeasurement_Measure();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getExperimentRun <em>Experiment Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Experiment Run</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getExperimentRun()
	 * @see #getMeasurement()
	 * @generated
	 */
	EReference getMeasurement_ExperimentRun();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurement Range</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasurementRange()
	 * @see #getMeasurement()
	 * @generated
	 */
	EReference getMeasurement_MeasurementRange();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure <em>Edp2 Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edp2 Measure</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure
	 * @generated
	 */
	EClass getEdp2Measure();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentGroup <em>Experiment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Experiment Group</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentGroup()
	 * @see #getEdp2Measure()
	 * @generated
	 */
	EReference getEdp2Measure_ExperimentGroup();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentSettings <em>Experiment Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Experiment Settings</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentSettings()
	 * @see #getEdp2Measure()
	 * @generated
	 */
	EReference getEdp2Measure_ExperimentSettings();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getPersistencyKind <em>Persistency Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistency Kind</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getPersistencyKind()
	 * @see #getEdp2Measure()
	 * @generated
	 */
	EAttribute getEdp2Measure_PersistencyKind();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMeasuredObject <em>Measured Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measured Object</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMeasuredObject()
	 * @see #getEdp2Measure()
	 * @generated
	 */
	EAttribute getEdp2Measure_MeasuredObject();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMetric()
	 * @see #getEdp2Measure()
	 * @generated
	 */
	EReference getEdp2Measure_Metric();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Propertyable <em>Propertyable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propertyable</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Propertyable
	 * @generated
	 */
	EClass getPropertyable();

	/**
	 * Returns the meta object for the map '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Propertyable#getAdditionalInformation <em>Additional Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Additional Information</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Propertyable#getAdditionalInformation()
	 * @see #getPropertyable()
	 * @generated
	 */
	EReference getPropertyable_AdditionalInformation();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EStringto EObject Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EStringto EObject Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true" keyOrdered="false"
	 *        valueDataType="org.eclipse.emf.ecore.EJavaObject" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	EClass getEStringtoEObjectMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringtoEObjectMapEntry()
	 * @generated
	 */
	EAttribute getEStringtoEObjectMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringtoEObjectMapEntry()
	 * @generated
	 */
	EAttribute getEStringtoEObjectMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup <em>Experiment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment Group</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup
	 * @generated
	 */
	EClass getExperimentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getExperimentSettings <em>Experiment Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Experiment Settings</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getExperimentSettings()
	 * @see #getExperimentGroup()
	 * @generated
	 */
	EReference getExperimentGroup_ExperimentSettings();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Repository</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getRepository()
	 * @see #getExperimentGroup()
	 * @generated
	 */
	EReference getExperimentGroup_Repository();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getPurpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purpose</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getPurpose()
	 * @see #getExperimentGroup()
	 * @generated
	 */
	EAttribute getExperimentGroup_Purpose();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measure</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getMeasure()
	 * @see #getExperimentGroup()
	 * @generated
	 */
	EReference getExperimentGroup_Measure();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting <em>Experiment Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment Setting</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting
	 * @generated
	 */
	EClass getExperimentSetting();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getDescription()
	 * @see #getExperimentSetting()
	 * @generated
	 */
	EAttribute getExperimentSetting_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getExperimentRuns <em>Experiment Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Experiment Runs</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getExperimentRuns()
	 * @see #getExperimentSetting()
	 * @generated
	 */
	EReference getExperimentSetting_ExperimentRuns();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Measure</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getMeasure()
	 * @see #getExperimentSetting()
	 * @generated
	 */
	EReference getExperimentSetting_Measure();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun <em>Experiment Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment Run</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun
	 * @generated
	 */
	EClass getExperimentRun();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurement</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getMeasurement()
	 * @see #getExperimentRun()
	 * @generated
	 */
	EReference getExperimentRun_Measurement();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getStartTime()
	 * @see #getExperimentRun()
	 * @generated
	 */
	EAttribute getExperimentRun_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getDuration()
	 * @see #getExperimentRun()
	 * @generated
	 */
	EAttribute getExperimentRun_Duration();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getExperimentSetting <em>Experiment Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Experiment Setting</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getExperimentSetting()
	 * @see #getExperimentRun()
	 * @generated
	 */
	EReference getExperimentRun_ExperimentSetting();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription <em>Base Metric Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Metric Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription
	 * @generated
	 */
	EClass getBaseMetricDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getCaptureType <em>Capture Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capture Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getCaptureType()
	 * @see #getBaseMetricDescription()
	 * @generated
	 */
	EAttribute getBaseMetricDescription_CaptureType();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getDataType()
	 * @see #getBaseMetricDescription()
	 * @generated
	 */
	EAttribute getBaseMetricDescription_DataType();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getScale()
	 * @see #getBaseMetricDescription()
	 * @generated
	 */
	EAttribute getBaseMetricDescription_Scale();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getMonotonic <em>Monotonic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Monotonic</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getMonotonic()
	 * @see #getBaseMetricDescription()
	 * @generated
	 */
	EAttribute getBaseMetricDescription_Monotonic();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getDefaultUnit <em>Default Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Unit</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getDefaultUnit()
	 * @see #getBaseMetricDescription()
	 * @generated
	 */
	EAttribute getBaseMetricDescription_DefaultUnit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MetricDescription <em>Metric Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MetricDescription
	 * @generated
	 */
	EClass getMetricDescription();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Description
	 * @generated
	 */
	EClass getDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Description#getName()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getTextualDescription <em>Textual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Textual Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Description#getTextualDescription()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_TextualDescription();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Repository</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Description#getRepository()
	 * @see #getDescription()
	 * @generated
	 */
	EReference getDescription_Repository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationFunctionDescription <em>Aggregation Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation Function Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregationFunctionDescription
	 * @generated
	 */
	EClass getAggregationFunctionDescription();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics <em>Aggregation Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation Statistics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics
	 * @generated
	 */
	EClass getAggregationStatistics();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distinct Values Before Aggregation</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesBeforeAggregation()
	 * @see #getAggregationStatistics()
	 * @generated
	 */
	EAttribute getAggregationStatistics_DistinctValuesBeforeAggregation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distinct Values After Aggregation</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesAfterAggregation()
	 * @see #getAggregationStatistics()
	 * @generated
	 */
	EAttribute getAggregationStatistics_DistinctValuesAfterAggregation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements <em>Long Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Binary Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements
	 * @generated
	 */
	EClass getLongBinaryMeasurements();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements#getStorageUnit <em>Storage Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Storage Unit</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements#getStorageUnit()
	 * @see #getLongBinaryMeasurements()
	 * @generated
	 */
	EAttribute getLongBinaryMeasurements_StorageUnit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier <em>Category Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Identifier</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier
	 * @generated
	 */
	EClass getCategoryIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier#getStateLiteral <em>State Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Literal</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier#getStateLiteral()
	 * @see #getCategoryIdentifier()
	 * @generated
	 */
	EAttribute getCategoryIdentifier_StateLiteral();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasurements <em>Nominal Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nominal Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasurements
	 * @generated
	 */
	EClass getNominalMeasurements();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure <em>Nominal Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nominal Measure</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure
	 * @generated
	 */
	EClass getNominalMeasure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure#getDefinedCategoryIdentifiers <em>Defined Category Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defined Category Identifiers</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure#getDefinedCategoryIdentifiers()
	 * @see #getNominalMeasure()
	 * @generated
	 */
	EReference getNominalMeasure_DefinedCategoryIdentifiers();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure#getInitialState()
	 * @see #getNominalMeasure()
	 * @generated
	 */
	EReference getNominalMeasure_InitialState();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements <em>Double Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Binary Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements
	 * @generated
	 */
	EClass getDoubleBinaryMeasurements();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements#getStorageUnit <em>Storage Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Storage Unit</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements#getStorageUnit()
	 * @see #getDoubleBinaryMeasurements()
	 * @generated
	 */
	EAttribute getDoubleBinaryMeasurements_StorageUnit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalMeasure <em>Ordinal Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordinal Measure</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalMeasure
	 * @generated
	 */
	EClass getOrdinalMeasure();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.JSXmlMeasurements <em>JS Xml Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JS Xml Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.JSXmlMeasurements
	 * @generated
	 */
	EClass getJSXmlMeasurements();

	/**
	 * Returns the meta object for class '{@link javax.measure.quantity.Duration <em>IJS Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IJS Duration</em>'.
	 * @see javax.measure.quantity.Duration
	 * @model instanceClass="javax.measure.quantity.Duration"
	 * @generated
	 */
	EClass getIJSDuration();

	/**
	 * Returns the meta object for class '{@link javax.measure.quantity.Quantity <em>IJS Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IJS Quantity</em>'.
	 * @see javax.measure.quantity.Quantity
	 * @model instanceClass="javax.measure.quantity.Quantity"
	 * @generated
	 */
	EClass getIJSQuantity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions <em>Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptions</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions
	 * @generated
	 */
	EClass getDescriptions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions#getDescription()
	 * @see #getDescriptions()
	 * @generated
	 */
	EReference getDescriptions_Description();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription <em>Metric Set Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Set Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription
	 * @generated
	 */
	EClass getMetricSetDescription();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription#getSubsumedMetrics <em>Subsumed Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsumed Metrics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription#getSubsumedMetrics()
	 * @see #getMetricSetDescription()
	 * @generated
	 */
	EReference getMetricSetDescription_SubsumedMetrics();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics <em>Ordinal Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordinal Statistics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics
	 * @generated
	 */
	EClass getOrdinalStatistics();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getMinimum()
	 * @see #getOrdinalStatistics()
	 * @generated
	 */
	EAttribute getOrdinalStatistics_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getMaximum()
	 * @see #getOrdinalStatistics()
	 * @generated
	 */
	EAttribute getOrdinalStatistics_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getMedian <em>Median</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Median</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getMedian()
	 * @see #getOrdinalStatistics()
	 * @generated
	 */
	EAttribute getOrdinalStatistics_Median();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getPercentiles <em>Percentiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Percentiles</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics#getPercentiles()
	 * @see #getOrdinalStatistics()
	 * @generated
	 */
	EReference getOrdinalStatistics_Percentiles();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Percentile <em>Percentile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Percentile</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Percentile
	 * @generated
	 */
	EClass getPercentile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Percentile#getPercentile <em>Percentile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentile</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Percentile#getPercentile()
	 * @see #getPercentile()
	 * @generated
	 */
	EAttribute getPercentile_Percentile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Percentile#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Percentile#getValue()
	 * @see #getPercentile()
	 * @generated
	 */
	EAttribute getPercentile_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics <em>Interval Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval Statistics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics
	 * @generated
	 */
	EClass getIntervalStatistics();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getArithmethicMean <em>Arithmethic Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arithmethic Mean</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getArithmethicMean()
	 * @see #getIntervalStatistics()
	 * @generated
	 */
	EAttribute getIntervalStatistics_ArithmethicMean();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getVariance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variance</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getVariance()
	 * @see #getIntervalStatistics()
	 * @generated
	 */
	EAttribute getIntervalStatistics_Variance();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getStandardDeviation <em>Standard Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard Deviation</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getStandardDeviation()
	 * @see #getIntervalStatistics()
	 * @generated
	 */
	EAttribute getIntervalStatistics_StandardDeviation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getSum <em>Sum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sum</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics#getSum()
	 * @see #getIntervalStatistics()
	 * @generated
	 */
	EAttribute getIntervalStatistics_Sum();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics <em>Ratio Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ratio Statistics</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics
	 * @generated
	 */
	EClass getRatioStatistics();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics#getCoefficientOfVariation <em>Coefficient Of Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coefficient Of Variation</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics#getCoefficientOfVariation()
	 * @see #getRatioStatistics()
	 * @generated
	 */
	EAttribute getRatioStatistics_CoefficientOfVariation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics#getGeometricMean <em>Geometric Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geometric Mean</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics#getGeometricMean()
	 * @see #getRatioStatistics()
	 * @generated
	 */
	EAttribute getRatioStatistics_GeometricMean();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics#getHarmonicMean <em>Harmonic Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Harmonic Mean</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics#getHarmonicMean()
	 * @see #getRatioStatistics()
	 * @generated
	 */
	EAttribute getRatioStatistics_HarmonicMean();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements <em>Observed Nominal Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observed Nominal Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements
	 * @generated
	 */
	EClass getObservedNominalMeasurements();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements#getObservedCategories <em>Observed Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Observed Categories</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements#getObservedCategories()
	 * @see #getObservedNominalMeasurements()
	 * @generated
	 */
	EReference getObservedNominalMeasurements_ObservedCategories();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements#getUuid()
	 * @see #getObservedNominalMeasurements()
	 * @generated
	 */
	EAttribute getObservedNominalMeasurements_Uuid();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ObservedCategory <em>Observed Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observed Category</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ObservedCategory
	 * @generated
	 */
	EClass getObservedCategory();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ObservedCategory#getCategoryIdentifier <em>Category Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Category Identifier</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ObservedCategory#getCategoryIdentifier()
	 * @see #getObservedCategory()
	 * @generated
	 */
	EReference getObservedCategory_CategoryIdentifier();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.SensorFrameworkV1NominalMeasurements <em>Sensor Framework V1 Nominal Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Framework V1 Nominal Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.SensorFrameworkV1NominalMeasurements
	 * @generated
	 */
	EClass getSensorFrameworkV1NominalMeasurements();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.SensorFrameworkV1DoubleBinaryMeasurements <em>Sensor Framework V1 Double Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Framework V1 Double Binary Measurements</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.SensorFrameworkV1DoubleBinaryMeasurements
	 * @generated
	 */
	EClass getSensorFrameworkV1DoubleBinaryMeasurements();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions <em>Persistence Kind Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Persistence Kind Options</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions
	 * @generated
	 */
	EEnum getPersistenceKindOptions();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType <em>Capture Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Capture Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType
	 * @generated
	 */
	EEnum getCaptureType();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Scale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scale</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Scale
	 * @generated
	 */
	EEnum getScale();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Monotonic <em>Monotonic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Monotonic</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Monotonic
	 * @generated
	 */
	EEnum getMonotonic();

	/**
	 * Returns the meta object for data type '{@link javax.measure.Measure <em>EJS Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJS Measure</em>'.
	 * @see javax.measure.Measure
	 * @model instanceClass="javax.measure.Measure"
	 * @generated
	 */
	EDataType getEJSMeasure();

	/**
	 * Returns the meta object for data type '{@link javax.measure.Measure <em>EJS Duration Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJS Duration Measure</em>'.
	 * @see javax.measure.Measure
	 * @model instanceClass="javax.measure.Measure"
	 * @generated
	 */
	EDataType getEJSDurationMeasure();

	/**
	 * Returns the meta object for data type '{@link javax.measure.unit.Unit <em>EJS Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJS Unit</em>'.
	 * @see javax.measure.unit.Unit
	 * @model instanceClass="javax.measure.unit.Unit"
	 * @generated
	 */
	EDataType getEJSUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmfmodelFactory getEmfmodelFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl <em>Aggregated Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregatedMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getAggregatedMeasurements()
		 * @generated
		 */
		EClass AGGREGATED_MEASUREMENTS = eINSTANCE.getAggregatedMeasurements();

		/**
		 * The meta object literal for the '<em><b>Measurement Range</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE = eINSTANCE.getAggregatedMeasurements_MeasurementRange();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_MEASUREMENTS__VALID = eINSTANCE.getAggregatedMeasurements_Valid();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_MEASUREMENTS__FUNCTION = eINSTANCE.getAggregatedMeasurements_Function();

		/**
		 * The meta object literal for the '<em><b>Aggregation Statistics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS = eINSTANCE.getAggregatedMeasurements_AggregationStatistics();

		/**
		 * The meta object literal for the '<em><b>Aggregation On</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_MEASUREMENTS__AGGREGATION_ON = eINSTANCE.getAggregatedMeasurements_AggregationOn();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_MEASUREMENTS__METRIC = eINSTANCE.getAggregatedMeasurements_Metric();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.IdentifiableImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__UUID = eINSTANCE.getIdentifiable_Uuid();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementRangeImpl <em>Measurement Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementRangeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMeasurementRange()
		 * @generated
		 */
		EClass MEASUREMENT_RANGE = eINSTANCE.getMeasurementRange();

		/**
		 * The meta object literal for the '<em><b>Raw Measurements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_RANGE__RAW_MEASUREMENTS = eINSTANCE.getMeasurementRange_RawMeasurements();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_RANGE__END_TIME = eINSTANCE.getMeasurementRange_EndTime();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_RANGE__START_TIME = eINSTANCE.getMeasurementRange_StartTime();

		/**
		 * The meta object literal for the '<em><b>Measurement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_RANGE__MEASUREMENT = eINSTANCE.getMeasurementRange_Measurement();

		/**
		 * The meta object literal for the '<em><b>Aggregated Measurements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS = eINSTANCE.getMeasurementRange_AggregatedMeasurements();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RawMeasurementsImpl <em>Raw Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.RawMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getRawMeasurements()
		 * @generated
		 */
		EClass RAW_MEASUREMENTS = eINSTANCE.getRawMeasurements();

		/**
		 * The meta object literal for the '<em><b>Data Series</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_MEASUREMENTS__DATA_SERIES = eINSTANCE.getRawMeasurements_DataSeries();

		/**
		 * The meta object literal for the '<em><b>Measurement Range</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_MEASUREMENTS__MEASUREMENT_RANGE = eINSTANCE.getRawMeasurements_MeasurementRange();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl <em>Data Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDataSeries()
		 * @generated
		 */
		EClass DATA_SERIES = eINSTANCE.getDataSeries();

		/**
		 * The meta object literal for the '<em><b>Statistics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SERIES__STATISTICS = eINSTANCE.getDataSeries_Statistics();

		/**
		 * The meta object literal for the '<em><b>Aggregated Measurements</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SERIES__AGGREGATED_MEASUREMENTS = eINSTANCE.getDataSeries_AggregatedMeasurements();

		/**
		 * The meta object literal for the '<em><b>Values Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SERIES__VALUES_UUID = eINSTANCE.getDataSeries_ValuesUuid();

		/**
		 * The meta object literal for the '<em><b>Raw Measurements</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SERIES__RAW_MEASUREMENTS = eINSTANCE.getDataSeries_RawMeasurements();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalStatisticsImpl <em>Nominal Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalStatisticsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getNominalStatistics()
		 * @generated
		 */
		EClass NOMINAL_STATISTICS = eINSTANCE.getNominalStatistics();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOMINAL_STATISTICS__COUNT = eINSTANCE.getNominalStatistics_Count();

		/**
		 * The meta object literal for the '<em><b>Raw YSeries</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOMINAL_STATISTICS__RAW_YSERIES = eINSTANCE.getNominalStatistics_RawYSeries();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregatedMeasurementsImpl <em>Fixed Width Aggregated Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedWidthAggregatedMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getFixedWidthAggregatedMeasurements()
		 * @generated
		 */
		EClass FIXED_WIDTH_AGGREGATED_MEASUREMENTS = eINSTANCE.getFixedWidthAggregatedMeasurements();

		/**
		 * The meta object literal for the '<em><b>Intervals</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS = eINSTANCE.getFixedWidthAggregatedMeasurements_Intervals();

		/**
		 * The meta object literal for the '<em><b>Data Series</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES = eINSTANCE.getFixedWidthAggregatedMeasurements_DataSeries();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedIntervalsImpl <em>Fixed Intervals</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.FixedIntervalsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getFixedIntervals()
		 * @generated
		 */
		EClass FIXED_INTERVALS = eINSTANCE.getFixedIntervals();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_INTERVALS__LOWER_BOUND = eINSTANCE.getFixedIntervals_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_INTERVALS__WIDTH = eINSTANCE.getFixedIntervals_Width();

		/**
		 * The meta object literal for the '<em><b>Number Of Intervals</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_INTERVALS__NUMBER_OF_INTERVALS = eINSTANCE.getFixedIntervals_NumberOfIntervals();

		/**
		 * The meta object literal for the '<em><b>Aggregated Measurements</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIXED_INTERVALS__AGGREGATED_MEASUREMENTS = eINSTANCE.getFixedIntervals_AggregatedMeasurements();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementImpl <em>Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMeasurement()
		 * @generated
		 */
		EClass MEASUREMENT = eINSTANCE.getMeasurement();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT__MEASURE = eINSTANCE.getMeasurement_Measure();

		/**
		 * The meta object literal for the '<em><b>Experiment Run</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT__EXPERIMENT_RUN = eINSTANCE.getMeasurement_ExperimentRun();

		/**
		 * The meta object literal for the '<em><b>Measurement Range</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT__MEASUREMENT_RANGE = eINSTANCE.getMeasurement_MeasurementRange();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl <em>Edp2 Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEdp2Measure()
		 * @generated
		 */
		EClass EDP2_MEASURE = eINSTANCE.getEdp2Measure();

		/**
		 * The meta object literal for the '<em><b>Experiment Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDP2_MEASURE__EXPERIMENT_GROUP = eINSTANCE.getEdp2Measure_ExperimentGroup();

		/**
		 * The meta object literal for the '<em><b>Experiment Settings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDP2_MEASURE__EXPERIMENT_SETTINGS = eINSTANCE.getEdp2Measure_ExperimentSettings();

		/**
		 * The meta object literal for the '<em><b>Persistency Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDP2_MEASURE__PERSISTENCY_KIND = eINSTANCE.getEdp2Measure_PersistencyKind();

		/**
		 * The meta object literal for the '<em><b>Measured Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDP2_MEASURE__MEASURED_OBJECT = eINSTANCE.getEdp2Measure_MeasuredObject();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDP2_MEASURE__METRIC = eINSTANCE.getEdp2Measure_Metric();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.PropertyableImpl <em>Propertyable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.PropertyableImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getPropertyable()
		 * @generated
		 */
		EClass PROPERTYABLE = eINSTANCE.getPropertyable();

		/**
		 * The meta object literal for the '<em><b>Additional Information</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTYABLE__ADDITIONAL_INFORMATION = eINSTANCE.getPropertyable_AdditionalInformation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.EStringtoEObjectMapEntryImpl <em>EStringto EObject Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EStringtoEObjectMapEntryImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEStringtoEObjectMapEntry()
		 * @generated
		 */
		EClass ESTRINGTO_EOBJECT_MAP_ENTRY = eINSTANCE.getEStringtoEObjectMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRINGTO_EOBJECT_MAP_ENTRY__KEY = eINSTANCE.getEStringtoEObjectMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRINGTO_EOBJECT_MAP_ENTRY__VALUE = eINSTANCE.getEStringtoEObjectMapEntry_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl <em>Experiment Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getExperimentGroup()
		 * @generated
		 */
		EClass EXPERIMENT_GROUP = eINSTANCE.getExperimentGroup();

		/**
		 * The meta object literal for the '<em><b>Experiment Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_GROUP__EXPERIMENT_SETTINGS = eINSTANCE.getExperimentGroup_ExperimentSettings();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_GROUP__REPOSITORY = eINSTANCE.getExperimentGroup_Repository();

		/**
		 * The meta object literal for the '<em><b>Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_GROUP__PURPOSE = eINSTANCE.getExperimentGroup_Purpose();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_GROUP__MEASURE = eINSTANCE.getExperimentGroup_Measure();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentSettingImpl <em>Experiment Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentSettingImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getExperimentSetting()
		 * @generated
		 */
		EClass EXPERIMENT_SETTING = eINSTANCE.getExperimentSetting();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_SETTING__DESCRIPTION = eINSTANCE.getExperimentSetting_Description();

		/**
		 * The meta object literal for the '<em><b>Experiment Runs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_SETTING__EXPERIMENT_RUNS = eINSTANCE.getExperimentSetting_ExperimentRuns();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_SETTING__MEASURE = eINSTANCE.getExperimentSetting_Measure();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl <em>Experiment Run</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getExperimentRun()
		 * @generated
		 */
		EClass EXPERIMENT_RUN = eINSTANCE.getExperimentRun();

		/**
		 * The meta object literal for the '<em><b>Measurement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_RUN__MEASUREMENT = eINSTANCE.getExperimentRun_Measurement();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_RUN__START_TIME = eINSTANCE.getExperimentRun_StartTime();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_RUN__DURATION = eINSTANCE.getExperimentRun_Duration();

		/**
		 * The meta object literal for the '<em><b>Experiment Setting</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_RUN__EXPERIMENT_SETTING = eINSTANCE.getExperimentRun_ExperimentSetting();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.BaseMetricDescriptionImpl <em>Base Metric Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.BaseMetricDescriptionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getBaseMetricDescription()
		 * @generated
		 */
		EClass BASE_METRIC_DESCRIPTION = eINSTANCE.getBaseMetricDescription();

		/**
		 * The meta object literal for the '<em><b>Capture Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_METRIC_DESCRIPTION__CAPTURE_TYPE = eINSTANCE.getBaseMetricDescription_CaptureType();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_METRIC_DESCRIPTION__DATA_TYPE = eINSTANCE.getBaseMetricDescription_DataType();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_METRIC_DESCRIPTION__SCALE = eINSTANCE.getBaseMetricDescription_Scale();

		/**
		 * The meta object literal for the '<em><b>Monotonic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_METRIC_DESCRIPTION__MONOTONIC = eINSTANCE.getBaseMetricDescription_Monotonic();

		/**
		 * The meta object literal for the '<em><b>Default Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_METRIC_DESCRIPTION__DEFAULT_UNIT = eINSTANCE.getBaseMetricDescription_DefaultUnit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricDescriptionImpl <em>Metric Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricDescriptionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMetricDescription()
		 * @generated
		 */
		EClass METRIC_DESCRIPTION = eINSTANCE.getMetricDescription();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDescription()
		 * @generated
		 */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__NAME = eINSTANCE.getDescription_Name();

		/**
		 * The meta object literal for the '<em><b>Textual Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__TEXTUAL_DESCRIPTION = eINSTANCE.getDescription_TextualDescription();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION__REPOSITORY = eINSTANCE.getDescription_Repository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationFunctionDescriptionImpl <em>Aggregation Function Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationFunctionDescriptionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getAggregationFunctionDescription()
		 * @generated
		 */
		EClass AGGREGATION_FUNCTION_DESCRIPTION = eINSTANCE.getAggregationFunctionDescription();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationStatisticsImpl <em>Aggregation Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.AggregationStatisticsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getAggregationStatistics()
		 * @generated
		 */
		EClass AGGREGATION_STATISTICS = eINSTANCE.getAggregationStatistics();

		/**
		 * The meta object literal for the '<em><b>Distinct Values Before Aggregation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION = eINSTANCE.getAggregationStatistics_DistinctValuesBeforeAggregation();

		/**
		 * The meta object literal for the '<em><b>Distinct Values After Aggregation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION = eINSTANCE.getAggregationStatistics_DistinctValuesAfterAggregation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.LongBinaryMeasurementsImpl <em>Long Binary Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.LongBinaryMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getLongBinaryMeasurements()
		 * @generated
		 */
		EClass LONG_BINARY_MEASUREMENTS = eINSTANCE.getLongBinaryMeasurements();

		/**
		 * The meta object literal for the '<em><b>Storage Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_BINARY_MEASUREMENTS__STORAGE_UNIT = eINSTANCE.getLongBinaryMeasurements_StorageUnit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.CategoryIdentifierImpl <em>Category Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.CategoryIdentifierImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getCategoryIdentifier()
		 * @generated
		 */
		EClass CATEGORY_IDENTIFIER = eINSTANCE.getCategoryIdentifier();

		/**
		 * The meta object literal for the '<em><b>State Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_IDENTIFIER__STATE_LITERAL = eINSTANCE.getCategoryIdentifier_StateLiteral();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasurementsImpl <em>Nominal Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getNominalMeasurements()
		 * @generated
		 */
		EClass NOMINAL_MEASUREMENTS = eINSTANCE.getNominalMeasurements();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasureImpl <em>Nominal Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalMeasureImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getNominalMeasure()
		 * @generated
		 */
		EClass NOMINAL_MEASURE = eINSTANCE.getNominalMeasure();

		/**
		 * The meta object literal for the '<em><b>Defined Category Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS = eINSTANCE.getNominalMeasure_DefinedCategoryIdentifiers();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOMINAL_MEASURE__INITIAL_STATE = eINSTANCE.getNominalMeasure_InitialState();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DoubleBinaryMeasurementsImpl <em>Double Binary Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DoubleBinaryMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDoubleBinaryMeasurements()
		 * @generated
		 */
		EClass DOUBLE_BINARY_MEASUREMENTS = eINSTANCE.getDoubleBinaryMeasurements();

		/**
		 * The meta object literal for the '<em><b>Storage Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT = eINSTANCE.getDoubleBinaryMeasurements_StorageUnit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalMeasureImpl <em>Ordinal Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalMeasureImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getOrdinalMeasure()
		 * @generated
		 */
		EClass ORDINAL_MEASURE = eINSTANCE.getOrdinalMeasure();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.JSXmlMeasurementsImpl <em>JS Xml Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.JSXmlMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getJSXmlMeasurements()
		 * @generated
		 */
		EClass JS_XML_MEASUREMENTS = eINSTANCE.getJSXmlMeasurements();

		/**
		 * The meta object literal for the '{@link javax.measure.quantity.Duration <em>IJS Duration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.quantity.Duration
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIJSDuration()
		 * @generated
		 */
		EClass IJS_DURATION = eINSTANCE.getIJSDuration();

		/**
		 * The meta object literal for the '{@link javax.measure.quantity.Quantity <em>IJS Quantity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.quantity.Quantity
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIJSQuantity()
		 * @generated
		 */
		EClass IJS_QUANTITY = eINSTANCE.getIJSQuantity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionsImpl <em>Descriptions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.DescriptionsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDescriptions()
		 * @generated
		 */
		EClass DESCRIPTIONS = eINSTANCE.getDescriptions();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTIONS__DESCRIPTION = eINSTANCE.getDescriptions_Description();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricSetDescriptionImpl <em>Metric Set Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.MetricSetDescriptionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMetricSetDescription()
		 * @generated
		 */
		EClass METRIC_SET_DESCRIPTION = eINSTANCE.getMetricSetDescription();

		/**
		 * The meta object literal for the '<em><b>Subsumed Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_SET_DESCRIPTION__SUBSUMED_METRICS = eINSTANCE.getMetricSetDescription_SubsumedMetrics();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl <em>Ordinal Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getOrdinalStatistics()
		 * @generated
		 */
		EClass ORDINAL_STATISTICS = eINSTANCE.getOrdinalStatistics();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDINAL_STATISTICS__MINIMUM = eINSTANCE.getOrdinalStatistics_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDINAL_STATISTICS__MAXIMUM = eINSTANCE.getOrdinalStatistics_Maximum();

		/**
		 * The meta object literal for the '<em><b>Median</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDINAL_STATISTICS__MEDIAN = eINSTANCE.getOrdinalStatistics_Median();

		/**
		 * The meta object literal for the '<em><b>Percentiles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDINAL_STATISTICS__PERCENTILES = eINSTANCE.getOrdinalStatistics_Percentiles();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.PercentileImpl <em>Percentile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.PercentileImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getPercentile()
		 * @generated
		 */
		EClass PERCENTILE = eINSTANCE.getPercentile();

		/**
		 * The meta object literal for the '<em><b>Percentile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERCENTILE__PERCENTILE = eINSTANCE.getPercentile_Percentile();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERCENTILE__VALUE = eINSTANCE.getPercentile_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.IntervalStatisticsImpl <em>Interval Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.IntervalStatisticsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getIntervalStatistics()
		 * @generated
		 */
		EClass INTERVAL_STATISTICS = eINSTANCE.getIntervalStatistics();

		/**
		 * The meta object literal for the '<em><b>Arithmethic Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_STATISTICS__ARITHMETHIC_MEAN = eINSTANCE.getIntervalStatistics_ArithmethicMean();

		/**
		 * The meta object literal for the '<em><b>Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_STATISTICS__VARIANCE = eINSTANCE.getIntervalStatistics_Variance();

		/**
		 * The meta object literal for the '<em><b>Standard Deviation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_STATISTICS__STANDARD_DEVIATION = eINSTANCE.getIntervalStatistics_StandardDeviation();

		/**
		 * The meta object literal for the '<em><b>Sum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_STATISTICS__SUM = eINSTANCE.getIntervalStatistics_Sum();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.RatioStatisticsImpl <em>Ratio Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.RatioStatisticsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getRatioStatistics()
		 * @generated
		 */
		EClass RATIO_STATISTICS = eINSTANCE.getRatioStatistics();

		/**
		 * The meta object literal for the '<em><b>Coefficient Of Variation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RATIO_STATISTICS__COEFFICIENT_OF_VARIATION = eINSTANCE.getRatioStatistics_CoefficientOfVariation();

		/**
		 * The meta object literal for the '<em><b>Geometric Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RATIO_STATISTICS__GEOMETRIC_MEAN = eINSTANCE.getRatioStatistics_GeometricMean();

		/**
		 * The meta object literal for the '<em><b>Harmonic Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RATIO_STATISTICS__HARMONIC_MEAN = eINSTANCE.getRatioStatistics_HarmonicMean();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedNominalMeasurementsImpl <em>Observed Nominal Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedNominalMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getObservedNominalMeasurements()
		 * @generated
		 */
		EClass OBSERVED_NOMINAL_MEASUREMENTS = eINSTANCE.getObservedNominalMeasurements();

		/**
		 * The meta object literal for the '<em><b>Observed Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES = eINSTANCE.getObservedNominalMeasurements_ObservedCategories();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBSERVED_NOMINAL_MEASUREMENTS__UUID = eINSTANCE.getObservedNominalMeasurements_Uuid();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedCategoryImpl <em>Observed Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.ObservedCategoryImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getObservedCategory()
		 * @generated
		 */
		EClass OBSERVED_CATEGORY = eINSTANCE.getObservedCategory();

		/**
		 * The meta object literal for the '<em><b>Category Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVED_CATEGORY__CATEGORY_IDENTIFIER = eINSTANCE.getObservedCategory_CategoryIdentifier();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1NominalMeasurementsImpl <em>Sensor Framework V1 Nominal Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1NominalMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getSensorFrameworkV1NominalMeasurements()
		 * @generated
		 */
		EClass SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS = eINSTANCE.getSensorFrameworkV1NominalMeasurements();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1DoubleBinaryMeasurementsImpl <em>Sensor Framework V1 Double Binary Measurements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.SensorFrameworkV1DoubleBinaryMeasurementsImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getSensorFrameworkV1DoubleBinaryMeasurements()
		 * @generated
		 */
		EClass SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS = eINSTANCE.getSensorFrameworkV1DoubleBinaryMeasurements();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions <em>Persistence Kind Options</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getPersistenceKindOptions()
		 * @generated
		 */
		EEnum PERSISTENCE_KIND_OPTIONS = eINSTANCE.getPersistenceKindOptions();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType <em>Capture Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getCaptureType()
		 * @generated
		 */
		EEnum CAPTURE_TYPE = eINSTANCE.getCaptureType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataType
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Scale <em>Scale</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Scale
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getScale()
		 * @generated
		 */
		EEnum SCALE = eINSTANCE.getScale();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Monotonic <em>Monotonic</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Monotonic
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getMonotonic()
		 * @generated
		 */
		EEnum MONOTONIC = eINSTANCE.getMonotonic();

		/**
		 * The meta object literal for the '<em>EJS Measure</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.Measure
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEJSMeasure()
		 * @generated
		 */
		EDataType EJS_MEASURE = eINSTANCE.getEJSMeasure();

		/**
		 * The meta object literal for the '<em>EJS Duration Measure</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.Measure
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEJSDurationMeasure()
		 * @generated
		 */
		EDataType EJS_DURATION_MEASURE = eINSTANCE.getEJSDurationMeasure();

		/**
		 * The meta object literal for the '<em>EJS Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.unit.Unit
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl#getEJSUnit()
		 * @generated
		 */
		EDataType EJS_UNIT = eINSTANCE.getEJSUnit();

	}

} //EmfmodelPackage
