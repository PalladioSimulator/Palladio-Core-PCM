/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.edp2.internal.DataSeriesFromRawMeasurementsSwitch;
import de.uka.ipd.sdq.edp2.internal.SerializationUtil;
import de.uka.ipd.sdq.edp2.models.ExperimentData.*;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.IdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalRatioStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Scale;
import de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1IdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentDataFactoryImpl extends EFactoryImpl implements ExperimentDataFactory {
	/** Logger for this class. 
	 * @generated NOT
	 */
	private static final Logger logger = Logger
			.getLogger(ExperimentDataFactoryImpl.class.getCanonicalName());

	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ExperimentDataFactory init() {
        try {
            ExperimentDataFactory theExperimentDataFactory = (ExperimentDataFactory)EPackage.Registry.INSTANCE.getEFactory(ExperimentDataPackage.eNS_URI);
            if (theExperimentDataFactory != null) {
                return theExperimentDataFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ExperimentDataFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentDataFactoryImpl() {
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE: return createMeasurementsRange();
            case ExperimentDataPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: return (EObject)createEStringtoEObjectMapEntry();
            case ExperimentDataPackage.RAW_MEASUREMENTS: return createRawMeasurements();
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS: return createNumericalNominalStatistics();
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION: return createNumericalMassDistribution();
            case ExperimentDataPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS: return createFixedWidthAggregatedMeasurements();
            case ExperimentDataPackage.FIXED_INTERVALS: return createFixedIntervals();
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS: return createTextualNominalStatistics();
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION: return createTextualMassDistribution();
            case ExperimentDataPackage.IDENTIFIER: return createIdentifier();
            case ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION: return createTextualBaseMetricDescription();
            case ExperimentDataPackage.EXPERIMENT_GROUP: return createExperimentGroup();
            case ExperimentDataPackage.EXPERIMENT_SETTING: return createExperimentSetting();
            case ExperimentDataPackage.EXPERIMENT_RUN: return createExperimentRun();
            case ExperimentDataPackage.MEASUREMENTS: return createMeasurements();
            case ExperimentDataPackage.EDP2_MEASURE: return createEdp2Measure();
            case ExperimentDataPackage.DESCRIPTIONS: return createDescriptions();
            case ExperimentDataPackage.AGGREGATION_FUNCTION_DESCRIPTION: return createAggregationFunctionDescription();
            case ExperimentDataPackage.AGGREGATION_STATISTICS: return createAggregationStatistics();
            case ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS: return createDoubleBinaryMeasurements();
            case ExperimentDataPackage.NUMERICAL_INTERVAL_STATISTICS: return createNumericalIntervalStatistics();
            case ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS: return createNumericalOrdinalStatistics();
            case ExperimentDataPackage.NUMERICAL_PERCENTILE: return createNumericalPercentile();
            case ExperimentDataPackage.JS_XML_MEASUREMENTS: return createJSXmlMeasurements();
            case ExperimentDataPackage.LONG_BINARY_MEASUREMENTS: return createLongBinaryMeasurements();
            case ExperimentDataPackage.METRIC_SET_DESCRIPTION: return createMetricSetDescription();
            case ExperimentDataPackage.IDENTIFIER_BASED_MEASUREMENTS: return createIdentifierBasedMeasurements();
            case ExperimentDataPackage.OBSERVED_IDENTIFIER: return createObservedIdentifier();
            case ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS: return createObservedIdentifierBasedMeasurements();
            case ExperimentDataPackage.NUMERICAL_RATIO_STATISTICS: return createNumericalRatioStatistics();
            case ExperimentDataPackage.SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS: return createSensorFrameworkV1DoubleBinaryMeasurements();
            case ExperimentDataPackage.SENSOR_FRAMEWORK_V1_IDENTIFIER_BASED_MEASUREMENTS: return createSensorFrameworkV1IdentifierBasedMeasurements();
            case ExperimentDataPackage.NUMERICAL_BASE_METRIC_DESCRIPTION: return createNumericalBaseMetricDescription();
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS: return createTextualOrdinalStatistics();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case ExperimentDataPackage.CAPTURE_TYPE:
                return createCaptureTypeFromString(eDataType, initialValue);
            case ExperimentDataPackage.SCALE:
                return createScaleFromString(eDataType, initialValue);
            case ExperimentDataPackage.MONOTONIC:
                return createMonotonicFromString(eDataType, initialValue);
            case ExperimentDataPackage.PERSISTENCE_KIND_OPTIONS:
                return createPersistenceKindOptionsFromString(eDataType, initialValue);
            case ExperimentDataPackage.DATA_TYPE:
                return createDataTypeFromString(eDataType, initialValue);
            case ExperimentDataPackage.EJS_MEASURE:
                return createEJSMeasureFromString(eDataType, initialValue);
            case ExperimentDataPackage.EJS_DURATION_MEASURE:
                return createEJSDurationMeasureFromString(eDataType, initialValue);
            case ExperimentDataPackage.EJS_UNIT:
                return createEJSUnitFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case ExperimentDataPackage.CAPTURE_TYPE:
                return convertCaptureTypeToString(eDataType, instanceValue);
            case ExperimentDataPackage.SCALE:
                return convertScaleToString(eDataType, instanceValue);
            case ExperimentDataPackage.MONOTONIC:
                return convertMonotonicToString(eDataType, instanceValue);
            case ExperimentDataPackage.PERSISTENCE_KIND_OPTIONS:
                return convertPersistenceKindOptionsToString(eDataType, instanceValue);
            case ExperimentDataPackage.DATA_TYPE:
                return convertDataTypeToString(eDataType, instanceValue);
            case ExperimentDataPackage.EJS_MEASURE:
                return convertEJSMeasureToString(eDataType, instanceValue);
            case ExperimentDataPackage.EJS_DURATION_MEASURE:
                return convertEJSDurationMeasureToString(eDataType, instanceValue);
            case ExperimentDataPackage.EJS_UNIT:
                return convertEJSUnitToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MeasurementsRange createMeasurementsRange() {
        MeasurementsRangeImpl measurementsRange = new MeasurementsRangeImpl();
        return measurementsRange;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FixedWidthAggregatedMeasurements createFixedWidthAggregatedMeasurements() {
        FixedWidthAggregatedMeasurementsImpl fixedWidthAggregatedMeasurements = new FixedWidthAggregatedMeasurementsImpl();
        return fixedWidthAggregatedMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FixedIntervals createFixedIntervals() {
        FixedIntervalsImpl fixedIntervals = new FixedIntervalsImpl();
        return fixedIntervals;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TextualNominalStatistics createTextualNominalStatistics() {
        TextualNominalStatisticsImpl textualNominalStatistics = new TextualNominalStatisticsImpl();
        return textualNominalStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TextualMassDistribution createTextualMassDistribution() {
        TextualMassDistributionImpl textualMassDistribution = new TextualMassDistributionImpl();
        return textualMassDistribution;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measurements createMeasurements() {
        MeasurementsImpl measurements = new MeasurementsImpl();
        return measurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Edp2Measure createEdp2Measure() {
        Edp2MeasureImpl edp2Measure = new Edp2MeasureImpl();
        return edp2Measure;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<String, Object> createEStringtoEObjectMapEntry() {
        EStringtoEObjectMapEntryImpl eStringtoEObjectMapEntry = new EStringtoEObjectMapEntryImpl();
        return eStringtoEObjectMapEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RawMeasurements createRawMeasurements() {
        RawMeasurementsImpl rawMeasurements = new RawMeasurementsImpl();
        return rawMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalNominalStatistics createNumericalNominalStatistics() {
        NumericalNominalStatisticsImpl numericalNominalStatistics = new NumericalNominalStatisticsImpl();
        return numericalNominalStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalMassDistribution createNumericalMassDistribution() {
        NumericalMassDistributionImpl numericalMassDistribution = new NumericalMassDistributionImpl();
        return numericalMassDistribution;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentGroup createExperimentGroup() {
        ExperimentGroupImpl experimentGroup = new ExperimentGroupImpl();
        return experimentGroup;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentSetting createExperimentSetting() {
        ExperimentSettingImpl experimentSetting = new ExperimentSettingImpl();
        return experimentSetting;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentRun createExperimentRun() {
        ExperimentRunImpl experimentRun = new ExperimentRunImpl();
        return experimentRun;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier createIdentifier() {
        IdentifierImpl identifier = new IdentifierImpl();
        return identifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TextualBaseMetricDescription createTextualBaseMetricDescription() {
        TextualBaseMetricDescriptionImpl textualBaseMetricDescription = new TextualBaseMetricDescriptionImpl();
        return textualBaseMetricDescription;
    }
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public TextualBaseMetricDescription createTextualBaseMetricDescription(
			String name, String textualDescription, Scale scale,
			DataType dataType, Monotonic monotonic) {
		TextualBaseMetricDescription tbmd = createTextualBaseMetricDescription();
		tbmd.setName(name);
		tbmd.setTextualDescription(textualDescription);
		tbmd.setScale(scale);
		tbmd.setDataType(dataType);
		tbmd.setMonotonic(monotonic);
		tbmd.setCaptureType(CaptureType.IDENTIFIER);
		return tbmd;
	}

	/** 
	 * {@inheritDoc}
	 */
	public Identifier createIdentifier(String literal) {
		IdentifierImpl identifier = new IdentifierImpl();
		identifier.setLiteral(literal);
		return identifier;
	}

	/** 
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NumericalBaseMetricDescription createNumericalBaseMetricDescription(
			String name, String textualDescription,
			CaptureType captureType, Scale scale, DataType dataType,
			Unit defaultUnit, Monotonic monotonic,
			PersistenceKindOptions persistenceKind) {
		NumericalBaseMetricDescription bmd = ExperimentDataFactory.eINSTANCE.createNumericalBaseMetricDescription();
		bmd.setName(name);
		bmd.setTextualDescription(textualDescription);
		bmd.setCaptureType(captureType);
		bmd.setScale(scale);
		bmd.setDefaultUnit(defaultUnit);
		bmd.setMonotonic(monotonic);
		return bmd;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MetricSetDescription createMetricSetDescription(String name,
			String textualDescription) {
		MetricSetDescription msd = ExperimentDataFactory.eINSTANCE
				.createMetricSetDescription();
		msd.setName(name);
		msd.setTextualDescription(textualDescription);
		return msd;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public Edp2Measure createEdp2Measure(String measuredObject,
			MetricDescription metricDescription) {
		Edp2Measure measure = createEdp2Measure();
		measure.setMeasuredObject(measuredObject);
		measure.setMetric(metricDescription);
		return measure;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public ExperimentSetting createExperimentSetting(
			ExperimentGroup experimentGroup, String description) {
		ExperimentSetting es = createExperimentSetting();
		experimentGroup.getExperimentSettings().add(es);
		es.setDescription(description);
		return es;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public ExperimentGroup createExperimentGroup(String purpose) {
		ExperimentGroup eg = createExperimentGroup();
		eg.setPurpose(purpose);
		return eg;
	}

	/** 
	 * {@inheritDoc}
	 */
	public Measurements createMeasurements(Edp2Measure forMeasure) {
		Measurements mms = createMeasurements();
		mms.setMeasure(forMeasure);
		return mms;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public ExperimentRun createExperimentRun(
			ExperimentSetting forExperimentSetting) {
		ExperimentRun er = createExperimentRun();
		forExperimentSetting.getExperimentRuns().add(er);
		return er;
	}

	/** 
	 * {@inheritDoc}
	 */
	public ObservedIdentifier createObservedIdentifier(
			ObservedIdentifierBasedMeasurements forOIBM, Identifier identifier) {
		ObservedIdentifier oi = createObservedIdentifier();
		oi.setIdentifier(identifier);
		forOIBM.getObservedIdentifiers().add(oi);
		return oi;
	}

	/** 
	 * {@inheritDoc}
	 */
	public RawMeasurements createRawMeasurements(
			MeasurementsRange forMeasurementsRange) {
		RawMeasurements rm = createRawMeasurements();
		forMeasurementsRange.setRawMeasurements(rm);

		// create necessary data series from measure (after input model validation)
		// input validation
		String errorMsg = "Cannot create data series for raw measurements. ";
		if (forMeasurementsRange == null) {
			errorMsg += "Measurement range must not be null in order to create "
					+ "data series for raw measurements.";
		} else if (forMeasurementsRange.getMeasurements() == null) {
			errorMsg = "Measurements must not be null in order to create data "
					+ "series for raw measurements.";
		} else if (rm.getMeasurementsRange().getMeasurements().getMeasure() == null) {
			errorMsg = "Measure (definition) must not be null in order to create "
					+ "data series for raw measurements.";
		} else {
			errorMsg = null;
		}
		if (errorMsg != null) {
			logger.log(Level.SEVERE, errorMsg);
			throw new IllegalStateException(errorMsg);
		}
		// create necessary data series instances themselves
		new DataSeriesFromRawMeasurementsSwitch().doSwitch(rm);
		return rm;
	}

	/** 
	 * {@inheritDoc}
	 */
	public JSXmlMeasurements createJSXmlMeasurements(
			RawMeasurements forRawMeasurements, String valuesUuid) {
		JSXmlMeasurements jsxm = createJSXmlMeasurements();
		jsxm.setValuesUuid(valuesUuid);
		forRawMeasurements.getDataSeries().add(jsxm);
		return jsxm;
	}

	/** 
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public LongBinaryMeasurements createLongBinaryMeasurements(
			RawMeasurements forRawMeasurements, String valuesUuid,
			Unit defaultUnit) {
		LongBinaryMeasurements lbm = createLongBinaryMeasurements();
		lbm.setValuesUuid(valuesUuid);
		lbm.setStorageUnit(defaultUnit);
		forRawMeasurements.getDataSeries().add(lbm);
		return lbm;
	}

	/** 
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public DoubleBinaryMeasurements createDoubleBinaryMeasurements(
			RawMeasurements forRawMeasurements, String valuesUuid,
			Unit defaultUnit) {
		DoubleBinaryMeasurements dbm = createDoubleBinaryMeasurements();
		dbm.setValuesUuid(valuesUuid);
		dbm.setStorageUnit(defaultUnit);
		forRawMeasurements.getDataSeries().add(dbm);
		return dbm;
	}

	/** 
	 * {@inheritDoc}
	 */
	public IdentifierBasedMeasurements createIdentifierBasedMeasurements(
			RawMeasurements forRawMeasurements, String valuesUuid) {
		IdentifierBasedMeasurements ibm = createIdentifierBasedMeasurements();
		ibm.setValuesUuid(valuesUuid);
		forRawMeasurements.getDataSeries().add(ibm);
		return ibm;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public MeasurementsRange createMeasurementsRange(Measurements forMeasurements) {
		MeasurementsRange mr = createMeasurementsRange();
		mr.setMeasurements(forMeasurements);
		return mr;
	}
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AggregationFunctionDescription createAggregationFunctionDescription() {
        AggregationFunctionDescriptionImpl aggregationFunctionDescription = new AggregationFunctionDescriptionImpl();
        return aggregationFunctionDescription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AggregationStatistics createAggregationStatistics() {
        AggregationStatisticsImpl aggregationStatistics = new AggregationStatisticsImpl();
        return aggregationStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LongBinaryMeasurements createLongBinaryMeasurements() {
        LongBinaryMeasurementsImpl longBinaryMeasurements = new LongBinaryMeasurementsImpl();
        return longBinaryMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <Q extends Quantity> DoubleBinaryMeasurements<Q> createDoubleBinaryMeasurements() {
        DoubleBinaryMeasurementsImpl<Q> doubleBinaryMeasurements = new DoubleBinaryMeasurementsImpl<Q>();
        return doubleBinaryMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalIntervalStatistics createNumericalIntervalStatistics() {
        NumericalIntervalStatisticsImpl numericalIntervalStatistics = new NumericalIntervalStatisticsImpl();
        return numericalIntervalStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalOrdinalStatistics createNumericalOrdinalStatistics() {
        NumericalOrdinalStatisticsImpl numericalOrdinalStatistics = new NumericalOrdinalStatisticsImpl();
        return numericalOrdinalStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalPercentile createNumericalPercentile() {
        NumericalPercentileImpl numericalPercentile = new NumericalPercentileImpl();
        return numericalPercentile;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public JSXmlMeasurements createJSXmlMeasurements() {
        JSXmlMeasurementsImpl jsXmlMeasurements = new JSXmlMeasurementsImpl();
        return jsXmlMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Descriptions createDescriptions() {
        DescriptionsImpl descriptions = new DescriptionsImpl();
        return descriptions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MetricSetDescription createMetricSetDescription() {
        MetricSetDescriptionImpl metricSetDescription = new MetricSetDescriptionImpl();
        return metricSetDescription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IdentifierBasedMeasurements createIdentifierBasedMeasurements() {
        IdentifierBasedMeasurementsImpl identifierBasedMeasurements = new IdentifierBasedMeasurementsImpl();
        return identifierBasedMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObservedIdentifier createObservedIdentifier() {
        ObservedIdentifierImpl observedIdentifier = new ObservedIdentifierImpl();
        return observedIdentifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObservedIdentifierBasedMeasurements createObservedIdentifierBasedMeasurements() {
        ObservedIdentifierBasedMeasurementsImpl observedIdentifierBasedMeasurements = new ObservedIdentifierBasedMeasurementsImpl();
        return observedIdentifierBasedMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalRatioStatistics createNumericalRatioStatistics() {
        NumericalRatioStatisticsImpl numericalRatioStatistics = new NumericalRatioStatisticsImpl();
        return numericalRatioStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SensorFrameworkV1DoubleBinaryMeasurements createSensorFrameworkV1DoubleBinaryMeasurements() {
        SensorFrameworkV1DoubleBinaryMeasurementsImpl sensorFrameworkV1DoubleBinaryMeasurements = new SensorFrameworkV1DoubleBinaryMeasurementsImpl();
        return sensorFrameworkV1DoubleBinaryMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SensorFrameworkV1IdentifierBasedMeasurements createSensorFrameworkV1IdentifierBasedMeasurements() {
        SensorFrameworkV1IdentifierBasedMeasurementsImpl sensorFrameworkV1IdentifierBasedMeasurements = new SensorFrameworkV1IdentifierBasedMeasurementsImpl();
        return sensorFrameworkV1IdentifierBasedMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalBaseMetricDescription createNumericalBaseMetricDescription() {
        NumericalBaseMetricDescriptionImpl numericalBaseMetricDescription = new NumericalBaseMetricDescriptionImpl();
        return numericalBaseMetricDescription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TextualOrdinalStatistics createTextualOrdinalStatistics() {
        TextualOrdinalStatisticsImpl textualOrdinalStatistics = new TextualOrdinalStatisticsImpl();
        return textualOrdinalStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PersistenceKindOptions createPersistenceKindOptionsFromString(EDataType eDataType, String initialValue) {
        PersistenceKindOptions result = PersistenceKindOptions.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertPersistenceKindOptionsToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CaptureType createCaptureTypeFromString(EDataType eDataType, String initialValue) {
        CaptureType result = CaptureType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertCaptureTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
        DataType result = DataType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Scale createScaleFromString(EDataType eDataType, String initialValue) {
        Scale result = Scale.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertScaleToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Monotonic createMonotonicFromString(EDataType eDataType, String initialValue) {
        Monotonic result = Monotonic.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertMonotonicToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Measure createEJSMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure) SerializationUtil.readObject(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEJSMeasureToString(EDataType eDataType, Object instanceValue) {
		return SerializationUtil.writeObject(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Measure createEJSDurationMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure) SerializationUtil.readObject(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEJSDurationMeasureToString(EDataType eDataType, Object instanceValue) {
		return SerializationUtil.writeObject(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Unit createEJSUnitFromString(EDataType eDataType, String initialValue) {
		return (Unit) SerializationUtil.readObject(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEJSUnitToString(EDataType eDataType, Object instanceValue) {
		return SerializationUtil.writeObject(instanceValue);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentDataPackage getExperimentDataPackage() {
        return (ExperimentDataPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ExperimentDataPackage getPackage() {
        return ExperimentDataPackage.eINSTANCE;
    }

} //EmfmodelFactoryImpl
