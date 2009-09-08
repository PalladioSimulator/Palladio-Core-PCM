/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;
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
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable;
import de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurement;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NominalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedNominalMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.OrdinalMeasure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.OrdinalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Percentile;
import de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Scale;
import de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1NominalMeasurements;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataValidator;
import de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.UIPackageImpl;
import de.uka.ipd.sdq.edp2.models.Presentation.impl.PresentationPackageImpl;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentDataPackageImpl extends EPackageImpl implements ExperimentDataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatedMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSeriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nominalStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedWidthAggregatedMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedIntervalsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edp2MeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringtoEObjectMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass experimentGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass experimentSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass experimentRunEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseMetricDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationFunctionDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longBinaryMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nominalMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nominalMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleBinaryMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordinalMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jsXmlMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ijsDurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ijsQuantityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricSetDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordinalStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass percentileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ratioStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observedNominalMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observedCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorFrameworkV1NominalMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorFrameworkV1DoubleBinaryMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum persistenceKindOptionsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum captureTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scaleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum monotonicEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ejsMeasureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ejsDurationMeasureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ejsUnitEDataType = null;

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
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExperimentDataPackageImpl() {
		super(eNS_URI, ExperimentDataFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExperimentDataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExperimentDataPackage init() {
		if (isInited) return (ExperimentDataPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI);

		// Obtain or create and register package
		ExperimentDataPackageImpl theExperimentDataPackage = (ExperimentDataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExperimentDataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExperimentDataPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI) instanceof PresentationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI) : PresentationPackage.eINSTANCE);
		UIPackageImpl theUIPackage = (UIPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UIPackage.eNS_URI) instanceof UIPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UIPackage.eNS_URI) : UIPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		theExperimentDataPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theUIPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theExperimentDataPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theUIPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theExperimentDataPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ExperimentDataValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theExperimentDataPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExperimentDataPackage.eNS_URI, theExperimentDataPackage);
		return theExperimentDataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatedMeasurements() {
		return aggregatedMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMeasurements_MeasurementRange() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedMeasurements_Valid() {
		return (EAttribute)aggregatedMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMeasurements_Function() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMeasurements_AggregationStatistics() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMeasurements_AggregationOn() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMeasurements_Metric() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_Uuid() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementRange() {
		return measurementRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementRange_RawMeasurements() {
		return (EReference)measurementRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementRange_EndTime() {
		return (EAttribute)measurementRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementRange_StartTime() {
		return (EAttribute)measurementRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementRange_Measurement() {
		return (EReference)measurementRangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementRange_AggregatedMeasurements() {
		return (EReference)measurementRangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawMeasurements() {
		return rawMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawMeasurements_DataSeries() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawMeasurements_MeasurementRange() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSeries() {
		return dataSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSeries_Statistics() {
		return (EReference)dataSeriesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSeries_AggregatedMeasurements() {
		return (EReference)dataSeriesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataSeries_ValuesUuid() {
		return (EAttribute)dataSeriesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSeries_RawMeasurements() {
		return (EReference)dataSeriesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNominalStatistics() {
		return nominalStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNominalStatistics_Count() {
		return (EAttribute)nominalStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNominalStatistics_RawYSeries() {
		return (EReference)nominalStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedWidthAggregatedMeasurements() {
		return fixedWidthAggregatedMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedWidthAggregatedMeasurements_Intervals() {
		return (EReference)fixedWidthAggregatedMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedWidthAggregatedMeasurements_DataSeries() {
		return (EReference)fixedWidthAggregatedMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedIntervals() {
		return fixedIntervalsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedIntervals_LowerBound() {
		return (EAttribute)fixedIntervalsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedIntervals_Width() {
		return (EAttribute)fixedIntervalsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedIntervals_NumberOfIntervals() {
		return (EAttribute)fixedIntervalsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedIntervals_AggregatedMeasurements() {
		return (EReference)fixedIntervalsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurement() {
		return measurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurement_Measure() {
		return (EReference)measurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurement_ExperimentRun() {
		return (EReference)measurementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurement_MeasurementRange() {
		return (EReference)measurementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdp2Measure() {
		return edp2MeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdp2Measure_ExperimentGroup() {
		return (EReference)edp2MeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdp2Measure_ExperimentSettings() {
		return (EReference)edp2MeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdp2Measure_PersistencyKind() {
		return (EAttribute)edp2MeasureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdp2Measure_MeasuredObject() {
		return (EAttribute)edp2MeasureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdp2Measure_Metric() {
		return (EReference)edp2MeasureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyable() {
		return propertyableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyable_AdditionalInformation() {
		return (EReference)propertyableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringtoEObjectMapEntry() {
		return eStringtoEObjectMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringtoEObjectMapEntry_Key() {
		return (EAttribute)eStringtoEObjectMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringtoEObjectMapEntry_Value() {
		return (EAttribute)eStringtoEObjectMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExperimentGroup() {
		return experimentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentGroup_ExperimentSettings() {
		return (EReference)experimentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentGroup_Repository() {
		return (EReference)experimentGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperimentGroup_Purpose() {
		return (EAttribute)experimentGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentGroup_Measure() {
		return (EReference)experimentGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExperimentSetting() {
		return experimentSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperimentSetting_Description() {
		return (EAttribute)experimentSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentSetting_ExperimentRuns() {
		return (EReference)experimentSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentSetting_Measure() {
		return (EReference)experimentSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExperimentRun() {
		return experimentRunEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentRun_Measurement() {
		return (EReference)experimentRunEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperimentRun_StartTime() {
		return (EAttribute)experimentRunEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperimentRun_Duration() {
		return (EAttribute)experimentRunEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentRun_ExperimentSetting() {
		return (EReference)experimentRunEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseMetricDescription() {
		return baseMetricDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseMetricDescription_CaptureType() {
		return (EAttribute)baseMetricDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseMetricDescription_DataType() {
		return (EAttribute)baseMetricDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseMetricDescription_Scale() {
		return (EAttribute)baseMetricDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseMetricDescription_Monotonic() {
		return (EAttribute)baseMetricDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseMetricDescription_DefaultUnit() {
		return (EAttribute)baseMetricDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricDescription() {
		return metricDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescription() {
		return descriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_Name() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_TextualDescription() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescription_Repository() {
		return (EReference)descriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregationFunctionDescription() {
		return aggregationFunctionDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregationStatistics() {
		return aggregationStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregationStatistics_DistinctValuesBeforeAggregation() {
		return (EAttribute)aggregationStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregationStatistics_DistinctValuesAfterAggregation() {
		return (EAttribute)aggregationStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongBinaryMeasurements() {
		return longBinaryMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongBinaryMeasurements_StorageUnit() {
		return (EAttribute)longBinaryMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategoryIdentifier() {
		return categoryIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategoryIdentifier_StateLiteral() {
		return (EAttribute)categoryIdentifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNominalMeasurements() {
		return nominalMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNominalMeasure() {
		return nominalMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNominalMeasure_DefinedCategoryIdentifiers() {
		return (EReference)nominalMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNominalMeasure_InitialState() {
		return (EReference)nominalMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleBinaryMeasurements() {
		return doubleBinaryMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleBinaryMeasurements_StorageUnit() {
		return (EAttribute)doubleBinaryMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrdinalMeasure() {
		return ordinalMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJSXmlMeasurements() {
		return jsXmlMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIJSDuration() {
		return ijsDurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIJSQuantity() {
		return ijsQuantityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptions() {
		return descriptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptions_Description() {
		return (EReference)descriptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricSetDescription() {
		return metricSetDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricSetDescription_SubsumedMetrics() {
		return (EReference)metricSetDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrdinalStatistics() {
		return ordinalStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdinalStatistics_Minimum() {
		return (EAttribute)ordinalStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdinalStatistics_Maximum() {
		return (EAttribute)ordinalStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdinalStatistics_Median() {
		return (EAttribute)ordinalStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrdinalStatistics_Percentiles() {
		return (EReference)ordinalStatisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPercentile() {
		return percentileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPercentile_Percentile() {
		return (EAttribute)percentileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPercentile_Value() {
		return (EAttribute)percentileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntervalStatistics() {
		return intervalStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervalStatistics_ArithmethicMean() {
		return (EAttribute)intervalStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervalStatistics_Variance() {
		return (EAttribute)intervalStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervalStatistics_StandardDeviation() {
		return (EAttribute)intervalStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervalStatistics_Sum() {
		return (EAttribute)intervalStatisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRatioStatistics() {
		return ratioStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRatioStatistics_CoefficientOfVariation() {
		return (EAttribute)ratioStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRatioStatistics_GeometricMean() {
		return (EAttribute)ratioStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRatioStatistics_HarmonicMean() {
		return (EAttribute)ratioStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObservedNominalMeasurements() {
		return observedNominalMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservedNominalMeasurements_ObservedCategories() {
		return (EReference)observedNominalMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObservedNominalMeasurements_Uuid() {
		return (EAttribute)observedNominalMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObservedCategory() {
		return observedCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservedCategory_CategoryIdentifier() {
		return (EReference)observedCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensorFrameworkV1NominalMeasurements() {
		return sensorFrameworkV1NominalMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensorFrameworkV1DoubleBinaryMeasurements() {
		return sensorFrameworkV1DoubleBinaryMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPersistenceKindOptions() {
		return persistenceKindOptionsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCaptureType() {
		return captureTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataType() {
		return dataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScale() {
		return scaleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMonotonic() {
		return monotonicEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJSMeasure() {
		return ejsMeasureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJSDurationMeasure() {
		return ejsDurationMeasureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJSUnit() {
		return ejsUnitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentDataFactory getExperimentDataFactory() {
		return (ExperimentDataFactory)getEFactoryInstance();
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
		aggregatedMeasurementsEClass = createEClass(AGGREGATED_MEASUREMENTS);
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE);
		createEAttribute(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__VALID);
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__FUNCTION);
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS);
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__AGGREGATION_ON);
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__METRIC);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__UUID);

		measurementRangeEClass = createEClass(MEASUREMENT_RANGE);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__RAW_MEASUREMENTS);
		createEAttribute(measurementRangeEClass, MEASUREMENT_RANGE__END_TIME);
		createEAttribute(measurementRangeEClass, MEASUREMENT_RANGE__START_TIME);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__MEASUREMENT);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS);

		propertyableEClass = createEClass(PROPERTYABLE);
		createEReference(propertyableEClass, PROPERTYABLE__ADDITIONAL_INFORMATION);

		eStringtoEObjectMapEntryEClass = createEClass(ESTRINGTO_EOBJECT_MAP_ENTRY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__KEY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__VALUE);

		rawMeasurementsEClass = createEClass(RAW_MEASUREMENTS);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__DATA_SERIES);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__MEASUREMENT_RANGE);

		dataSeriesEClass = createEClass(DATA_SERIES);
		createEReference(dataSeriesEClass, DATA_SERIES__STATISTICS);
		createEReference(dataSeriesEClass, DATA_SERIES__AGGREGATED_MEASUREMENTS);
		createEAttribute(dataSeriesEClass, DATA_SERIES__VALUES_UUID);
		createEReference(dataSeriesEClass, DATA_SERIES__RAW_MEASUREMENTS);

		nominalStatisticsEClass = createEClass(NOMINAL_STATISTICS);
		createEAttribute(nominalStatisticsEClass, NOMINAL_STATISTICS__COUNT);
		createEReference(nominalStatisticsEClass, NOMINAL_STATISTICS__RAW_YSERIES);

		fixedWidthAggregatedMeasurementsEClass = createEClass(FIXED_WIDTH_AGGREGATED_MEASUREMENTS);
		createEReference(fixedWidthAggregatedMeasurementsEClass, FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS);
		createEReference(fixedWidthAggregatedMeasurementsEClass, FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES);

		fixedIntervalsEClass = createEClass(FIXED_INTERVALS);
		createEAttribute(fixedIntervalsEClass, FIXED_INTERVALS__LOWER_BOUND);
		createEAttribute(fixedIntervalsEClass, FIXED_INTERVALS__WIDTH);
		createEAttribute(fixedIntervalsEClass, FIXED_INTERVALS__NUMBER_OF_INTERVALS);
		createEReference(fixedIntervalsEClass, FIXED_INTERVALS__AGGREGATED_MEASUREMENTS);

		measurementEClass = createEClass(MEASUREMENT);
		createEReference(measurementEClass, MEASUREMENT__MEASURE);
		createEReference(measurementEClass, MEASUREMENT__EXPERIMENT_RUN);
		createEReference(measurementEClass, MEASUREMENT__MEASUREMENT_RANGE);

		edp2MeasureEClass = createEClass(EDP2_MEASURE);
		createEReference(edp2MeasureEClass, EDP2_MEASURE__EXPERIMENT_GROUP);
		createEReference(edp2MeasureEClass, EDP2_MEASURE__EXPERIMENT_SETTINGS);
		createEAttribute(edp2MeasureEClass, EDP2_MEASURE__PERSISTENCY_KIND);
		createEAttribute(edp2MeasureEClass, EDP2_MEASURE__MEASURED_OBJECT);
		createEReference(edp2MeasureEClass, EDP2_MEASURE__METRIC);

		experimentGroupEClass = createEClass(EXPERIMENT_GROUP);
		createEReference(experimentGroupEClass, EXPERIMENT_GROUP__EXPERIMENT_SETTINGS);
		createEReference(experimentGroupEClass, EXPERIMENT_GROUP__REPOSITORY);
		createEAttribute(experimentGroupEClass, EXPERIMENT_GROUP__PURPOSE);
		createEReference(experimentGroupEClass, EXPERIMENT_GROUP__MEASURE);

		experimentSettingEClass = createEClass(EXPERIMENT_SETTING);
		createEAttribute(experimentSettingEClass, EXPERIMENT_SETTING__DESCRIPTION);
		createEReference(experimentSettingEClass, EXPERIMENT_SETTING__EXPERIMENT_RUNS);
		createEReference(experimentSettingEClass, EXPERIMENT_SETTING__MEASURE);

		experimentRunEClass = createEClass(EXPERIMENT_RUN);
		createEReference(experimentRunEClass, EXPERIMENT_RUN__MEASUREMENT);
		createEAttribute(experimentRunEClass, EXPERIMENT_RUN__START_TIME);
		createEAttribute(experimentRunEClass, EXPERIMENT_RUN__DURATION);
		createEReference(experimentRunEClass, EXPERIMENT_RUN__EXPERIMENT_SETTING);

		descriptionEClass = createEClass(DESCRIPTION);
		createEAttribute(descriptionEClass, DESCRIPTION__NAME);
		createEAttribute(descriptionEClass, DESCRIPTION__TEXTUAL_DESCRIPTION);
		createEReference(descriptionEClass, DESCRIPTION__REPOSITORY);

		metricDescriptionEClass = createEClass(METRIC_DESCRIPTION);

		aggregationFunctionDescriptionEClass = createEClass(AGGREGATION_FUNCTION_DESCRIPTION);

		aggregationStatisticsEClass = createEClass(AGGREGATION_STATISTICS);
		createEAttribute(aggregationStatisticsEClass, AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION);
		createEAttribute(aggregationStatisticsEClass, AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION);

		baseMetricDescriptionEClass = createEClass(BASE_METRIC_DESCRIPTION);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__CAPTURE_TYPE);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__DATA_TYPE);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__SCALE);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__MONOTONIC);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__DEFAULT_UNIT);

		categoryIdentifierEClass = createEClass(CATEGORY_IDENTIFIER);
		createEAttribute(categoryIdentifierEClass, CATEGORY_IDENTIFIER__STATE_LITERAL);

		descriptionsEClass = createEClass(DESCRIPTIONS);
		createEReference(descriptionsEClass, DESCRIPTIONS__DESCRIPTION);

		doubleBinaryMeasurementsEClass = createEClass(DOUBLE_BINARY_MEASUREMENTS);
		createEAttribute(doubleBinaryMeasurementsEClass, DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT);

		intervalStatisticsEClass = createEClass(INTERVAL_STATISTICS);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__ARITHMETHIC_MEAN);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__VARIANCE);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__STANDARD_DEVIATION);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__SUM);

		ordinalStatisticsEClass = createEClass(ORDINAL_STATISTICS);
		createEAttribute(ordinalStatisticsEClass, ORDINAL_STATISTICS__MINIMUM);
		createEAttribute(ordinalStatisticsEClass, ORDINAL_STATISTICS__MAXIMUM);
		createEAttribute(ordinalStatisticsEClass, ORDINAL_STATISTICS__MEDIAN);
		createEReference(ordinalStatisticsEClass, ORDINAL_STATISTICS__PERCENTILES);

		percentileEClass = createEClass(PERCENTILE);
		createEAttribute(percentileEClass, PERCENTILE__PERCENTILE);
		createEAttribute(percentileEClass, PERCENTILE__VALUE);

		jsXmlMeasurementsEClass = createEClass(JS_XML_MEASUREMENTS);

		longBinaryMeasurementsEClass = createEClass(LONG_BINARY_MEASUREMENTS);
		createEAttribute(longBinaryMeasurementsEClass, LONG_BINARY_MEASUREMENTS__STORAGE_UNIT);

		metricSetDescriptionEClass = createEClass(METRIC_SET_DESCRIPTION);
		createEReference(metricSetDescriptionEClass, METRIC_SET_DESCRIPTION__SUBSUMED_METRICS);

		nominalMeasureEClass = createEClass(NOMINAL_MEASURE);
		createEReference(nominalMeasureEClass, NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS);
		createEReference(nominalMeasureEClass, NOMINAL_MEASURE__INITIAL_STATE);

		nominalMeasurementsEClass = createEClass(NOMINAL_MEASUREMENTS);

		observedCategoryEClass = createEClass(OBSERVED_CATEGORY);
		createEReference(observedCategoryEClass, OBSERVED_CATEGORY__CATEGORY_IDENTIFIER);

		observedNominalMeasurementsEClass = createEClass(OBSERVED_NOMINAL_MEASUREMENTS);
		createEReference(observedNominalMeasurementsEClass, OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES);
		createEAttribute(observedNominalMeasurementsEClass, OBSERVED_NOMINAL_MEASUREMENTS__UUID);

		ordinalMeasureEClass = createEClass(ORDINAL_MEASURE);

		ratioStatisticsEClass = createEClass(RATIO_STATISTICS);
		createEAttribute(ratioStatisticsEClass, RATIO_STATISTICS__COEFFICIENT_OF_VARIATION);
		createEAttribute(ratioStatisticsEClass, RATIO_STATISTICS__GEOMETRIC_MEAN);
		createEAttribute(ratioStatisticsEClass, RATIO_STATISTICS__HARMONIC_MEAN);

		sensorFrameworkV1DoubleBinaryMeasurementsEClass = createEClass(SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS);

		sensorFrameworkV1NominalMeasurementsEClass = createEClass(SENSOR_FRAMEWORK_V1_NOMINAL_MEASUREMENTS);

		ijsDurationEClass = createEClass(IJS_DURATION);

		ijsQuantityEClass = createEClass(IJS_QUANTITY);

		// Create enums
		persistenceKindOptionsEEnum = createEEnum(PERSISTENCE_KIND_OPTIONS);
		captureTypeEEnum = createEEnum(CAPTURE_TYPE);
		scaleEEnum = createEEnum(SCALE);
		monotonicEEnum = createEEnum(MONOTONIC);
		dataTypeEEnum = createEEnum(DATA_TYPE);

		// Create data types
		ejsMeasureEDataType = createEDataType(EJS_MEASURE);
		ejsDurationMeasureEDataType = createEDataType(EJS_DURATION_MEASURE);
		ejsUnitEDataType = createEDataType(EJS_UNIT);
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
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		aggregatedMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
		measurementRangeEClass.getESuperTypes().add(this.getPropertyable());
		rawMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
		fixedWidthAggregatedMeasurementsEClass.getESuperTypes().add(this.getAggregatedMeasurements());
		measurementEClass.getESuperTypes().add(this.getPropertyable());
		experimentGroupEClass.getESuperTypes().add(this.getIdentifiable());
		experimentGroupEClass.getESuperTypes().add(this.getPropertyable());
		experimentSettingEClass.getESuperTypes().add(this.getPropertyable());
		experimentRunEClass.getESuperTypes().add(this.getIdentifiable());
		experimentRunEClass.getESuperTypes().add(this.getPropertyable());
		descriptionEClass.getESuperTypes().add(this.getIdentifiable());
		metricDescriptionEClass.getESuperTypes().add(this.getDescription());
		aggregationFunctionDescriptionEClass.getESuperTypes().add(this.getDescription());
		baseMetricDescriptionEClass.getESuperTypes().add(this.getMetricDescription());
		categoryIdentifierEClass.getESuperTypes().add(this.getIdentifiable());
		doubleBinaryMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
		intervalStatisticsEClass.getESuperTypes().add(this.getOrdinalStatistics());
		ordinalStatisticsEClass.getESuperTypes().add(this.getNominalStatistics());
		jsXmlMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
		longBinaryMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
		metricSetDescriptionEClass.getESuperTypes().add(this.getMetricDescription());
		nominalMeasureEClass.getESuperTypes().add(this.getEdp2Measure());
		nominalMeasureEClass.getESuperTypes().add(this.getIdentifiable());
		nominalMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
		ordinalMeasureEClass.getESuperTypes().add(this.getEdp2Measure());
		ratioStatisticsEClass.getESuperTypes().add(this.getIntervalStatistics());
		sensorFrameworkV1DoubleBinaryMeasurementsEClass.getESuperTypes().add(this.getDoubleBinaryMeasurements());
		sensorFrameworkV1NominalMeasurementsEClass.getESuperTypes().add(this.getNominalMeasurements());

		// Initialize classes and features; add operations and parameters
		initEClass(aggregatedMeasurementsEClass, AggregatedMeasurements.class, "AggregatedMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregatedMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_AggregatedMeasurements(), "measurementRange", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_Valid(), ecorePackage.getEBoolean(), "valid", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregatedMeasurements_Function(), this.getAggregationFunctionDescription(), null, "function", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregatedMeasurements_AggregationStatistics(), this.getAggregationStatistics(), null, "aggregationStatistics", null, 0, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregatedMeasurements_AggregationOn(), this.getBaseMetricDescription(), null, "aggregationOn", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregatedMeasurements_Metric(), this.getMetricDescription(), null, "metric", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_Uuid(), ecorePackage.getEString(), "uuid", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementRangeEClass, MeasurementRange.class, "MeasurementRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurementRange_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_MeasurementRange(), "rawMeasurements", null, 0, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_EndTime(), this.getEJSDurationMeasure(), "endTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_StartTime(), this.getEJSDurationMeasure(), "startTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_Measurement(), this.getMeasurement(), this.getMeasurement_MeasurementRange(), "measurement", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_MeasurementRange(), "aggregatedMeasurements", null, 0, -1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyableEClass, Propertyable.class, "Propertyable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyable_AdditionalInformation(), this.getEStringtoEObjectMapEntry(), null, "additionalInformation", null, 0, -1, Propertyable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringtoEObjectMapEntryEClass, Map.Entry.class, "EStringtoEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringtoEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEStringtoEObjectMapEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawMeasurementsEClass, RawMeasurements.class, "RawMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawMeasurements_DataSeries(), this.getDataSeries(), this.getDataSeries_RawMeasurements(), "dataSeries", null, 1, -1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_RawMeasurements(), "measurementRange", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataSeriesEClass, DataSeries.class, "DataSeries", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSeries_Statistics(), this.getNominalStatistics(), this.getNominalStatistics_RawYSeries(), "statistics", null, 0, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataSeries_AggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements_DataSeries(), "aggregatedMeasurements", null, 1, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataSeries_ValuesUuid(), ecorePackage.getEString(), "valuesUuid", null, 1, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataSeries_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_DataSeries(), "rawMeasurements", null, 1, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(dataSeriesEClass, ecorePackage.getEBoolean(), "Statisticsonlyformeasurablevalues", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nominalStatisticsEClass, NominalStatistics.class, "NominalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNominalStatistics_Count(), ecorePackage.getELong(), "count", null, 1, 1, NominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNominalStatistics_RawYSeries(), this.getDataSeries(), this.getDataSeries_Statistics(), "rawYSeries", null, 1, 1, NominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedWidthAggregatedMeasurementsEClass, FixedWidthAggregatedMeasurements.class, "FixedWidthAggregatedMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFixedWidthAggregatedMeasurements_Intervals(), this.getFixedIntervals(), this.getFixedIntervals_AggregatedMeasurements(), "intervals", null, 1, 1, FixedWidthAggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFixedWidthAggregatedMeasurements_DataSeries(), this.getDataSeries(), this.getDataSeries_AggregatedMeasurements(), "dataSeries", null, 1, -1, FixedWidthAggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedIntervalsEClass, FixedIntervals.class, "FixedIntervals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedIntervals_LowerBound(), this.getEJSMeasure(), "lowerBound", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedIntervals_Width(), this.getEJSMeasure(), "width", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedIntervals_NumberOfIntervals(), ecorePackage.getELong(), "numberOfIntervals", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFixedIntervals_AggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements_Intervals(), "aggregatedMeasurements", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementEClass, Measurement.class, "Measurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurement_Measure(), this.getEdp2Measure(), null, "measure", null, 1, 1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurement_ExperimentRun(), this.getExperimentRun(), this.getExperimentRun_Measurement(), "experimentRun", null, 1, 1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurement_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_Measurement(), "measurementRange", null, 0, -1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(edp2MeasureEClass, Edp2Measure.class, "Edp2Measure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdp2Measure_ExperimentGroup(), this.getExperimentGroup(), this.getExperimentGroup_Measure(), "experimentGroup", null, 1, 1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEdp2Measure_ExperimentSettings(), this.getExperimentSetting(), this.getExperimentSetting_Measure(), "experimentSettings", null, 0, -1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEdp2Measure_PersistencyKind(), this.getPersistenceKindOptions(), "persistencyKind", null, 1, 1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEdp2Measure_MeasuredObject(), ecorePackage.getEString(), "measuredObject", null, 1, 1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEdp2Measure_Metric(), this.getMetricDescription(), null, "metric", null, 1, 1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentGroupEClass, ExperimentGroup.class, "ExperimentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperimentGroup_ExperimentSettings(), this.getExperimentSetting(), null, "experimentSettings", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentGroup_Repository(), theRepositoryPackage.getRepository(), theRepositoryPackage.getRepository_ExperimentGroups(), "repository", null, 0, 1, ExperimentGroup.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperimentGroup_Purpose(), ecorePackage.getEString(), "purpose", null, 1, 1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentGroup_Measure(), this.getEdp2Measure(), this.getEdp2Measure_ExperimentGroup(), "measure", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentSettingEClass, ExperimentSetting.class, "ExperimentSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExperimentSetting_Description(), ecorePackage.getEString(), "description", null, 1, 1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_ExperimentRuns(), this.getExperimentRun(), this.getExperimentRun_ExperimentSetting(), "experimentRuns", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_Measure(), this.getEdp2Measure(), this.getEdp2Measure_ExperimentSettings(), "measure", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentRunEClass, ExperimentRun.class, "ExperimentRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperimentRun_Measurement(), this.getMeasurement(), this.getMeasurement_ExperimentRun(), "measurement", null, 0, -1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperimentRun_StartTime(), ecorePackage.getEDate(), "startTime", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperimentRun_Duration(), this.getEJSDurationMeasure(), "duration", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentRun_ExperimentSetting(), this.getExperimentSetting(), this.getExperimentSetting_ExperimentRuns(), "experimentSetting", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(experimentRunEClass, ecorePackage.getEBoolean(), "ExactlyOneDataCollectionPerSensor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(descriptionEClass, Description.class, "Description", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescription_Name(), ecorePackage.getEString(), "name", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDescription_TextualDescription(), ecorePackage.getEString(), "textualDescription", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDescription_Repository(), theRepositoryPackage.getRepository(), theRepositoryPackage.getRepository_Descriptions(), "repository", null, 0, 1, Description.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(metricDescriptionEClass, MetricDescription.class, "MetricDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aggregationFunctionDescriptionEClass, AggregationFunctionDescription.class, "AggregationFunctionDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aggregationStatisticsEClass, AggregationStatistics.class, "AggregationStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregationStatistics_DistinctValuesBeforeAggregation(), ecorePackage.getELong(), "distinctValuesBeforeAggregation", null, 1, 1, AggregationStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregationStatistics_DistinctValuesAfterAggregation(), ecorePackage.getELong(), "distinctValuesAfterAggregation", null, 1, 1, AggregationStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(baseMetricDescriptionEClass, BaseMetricDescription.class, "BaseMetricDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseMetricDescription_CaptureType(), this.getCaptureType(), "captureType", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseMetricDescription_DataType(), this.getDataType(), "dataType", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseMetricDescription_Scale(), this.getScale(), "scale", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseMetricDescription_Monotonic(), this.getMonotonic(), "monotonic", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseMetricDescription_DefaultUnit(), this.getEJSUnit(), "defaultUnit", null, 0, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(categoryIdentifierEClass, CategoryIdentifier.class, "CategoryIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategoryIdentifier_StateLiteral(), ecorePackage.getEString(), "stateLiteral", null, 1, 1, CategoryIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(descriptionsEClass, Descriptions.class, "Descriptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptions_Description(), this.getDescription(), null, "description", null, 0, -1, Descriptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleBinaryMeasurementsEClass, DoubleBinaryMeasurements.class, "DoubleBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleBinaryMeasurements_StorageUnit(), this.getEJSUnit(), "storageUnit", null, 1, 1, DoubleBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intervalStatisticsEClass, IntervalStatistics.class, "IntervalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntervalStatistics_ArithmethicMean(), this.getEJSMeasure(), "arithmethicMean", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalStatistics_Variance(), ecorePackage.getEDouble(), "variance", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalStatistics_StandardDeviation(), ecorePackage.getEDouble(), "standardDeviation", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalStatistics_Sum(), this.getEJSMeasure(), "sum", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ordinalStatisticsEClass, OrdinalStatistics.class, "OrdinalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrdinalStatistics_Minimum(), this.getEJSMeasure(), "minimum", null, 1, 1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOrdinalStatistics_Maximum(), this.getEJSMeasure(), "maximum", null, 1, 1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOrdinalStatistics_Median(), this.getEJSMeasure(), "median", null, 0, 1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOrdinalStatistics_Percentiles(), this.getPercentile(), null, "percentiles", null, 0, -1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(percentileEClass, Percentile.class, "Percentile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPercentile_Percentile(), ecorePackage.getEDouble(), "percentile", null, 1, 1, Percentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPercentile_Value(), this.getEJSMeasure(), "value", null, 1, 1, Percentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jsXmlMeasurementsEClass, JSXmlMeasurements.class, "JSXmlMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(longBinaryMeasurementsEClass, LongBinaryMeasurements.class, "LongBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongBinaryMeasurements_StorageUnit(), this.getEJSUnit(), "storageUnit", null, 1, 1, LongBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(metricSetDescriptionEClass, MetricSetDescription.class, "MetricSetDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricSetDescription_SubsumedMetrics(), this.getMetricDescription(), null, "subsumedMetrics", null, 1, -1, MetricSetDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nominalMeasureEClass, NominalMeasure.class, "NominalMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNominalMeasure_DefinedCategoryIdentifiers(), this.getCategoryIdentifier(), null, "definedCategoryIdentifiers", null, 1, -1, NominalMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNominalMeasure_InitialState(), this.getCategoryIdentifier(), null, "initialState", null, 1, 1, NominalMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(nominalMeasureEClass, ecorePackage.getEBoolean(), "PersistenceKindOnlyEmfAllowed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nominalMeasurementsEClass, NominalMeasurements.class, "NominalMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(observedCategoryEClass, ObservedCategory.class, "ObservedCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservedCategory_CategoryIdentifier(), this.getCategoryIdentifier(), null, "categoryIdentifier", null, 1, 1, ObservedCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(observedNominalMeasurementsEClass, ObservedNominalMeasurements.class, "ObservedNominalMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservedNominalMeasurements_ObservedCategories(), this.getObservedCategory(), null, "observedCategories", null, 0, -1, ObservedNominalMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObservedNominalMeasurements_Uuid(), ecorePackage.getEString(), "uuid", null, 1, 1, ObservedNominalMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ordinalMeasureEClass, OrdinalMeasure.class, "OrdinalMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(ordinalMeasureEClass, ecorePackage.getEBoolean(), "PersistencyKindNotEmf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(ratioStatisticsEClass, RatioStatistics.class, "RatioStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRatioStatistics_CoefficientOfVariation(), ecorePackage.getEDouble(), "coefficientOfVariation", null, 1, 1, RatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRatioStatistics_GeometricMean(), this.getEJSMeasure(), "geometricMean", null, 1, 1, RatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRatioStatistics_HarmonicMean(), this.getEJSMeasure(), "harmonicMean", null, 1, 1, RatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorFrameworkV1DoubleBinaryMeasurementsEClass, SensorFrameworkV1DoubleBinaryMeasurements.class, "SensorFrameworkV1DoubleBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sensorFrameworkV1NominalMeasurementsEClass, SensorFrameworkV1NominalMeasurements.class, "SensorFrameworkV1NominalMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ijsDurationEClass, Duration.class, "IJSDuration", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(ijsQuantityEClass, Quantity.class, "IJSQuantity", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(persistenceKindOptionsEEnum, PersistenceKindOptions.class, "PersistenceKindOptions");
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.BINARY_PREFERRED);
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.JS_XML_PREFERRED);

		initEEnum(captureTypeEEnum, CaptureType.class, "CaptureType");
		addEEnumLiteral(captureTypeEEnum, CaptureType.IDENTIFIER);
		addEEnumLiteral(captureTypeEEnum, CaptureType.NATURAL_NUMBER);
		addEEnumLiteral(captureTypeEEnum, CaptureType.REAL_NUMBER);

		initEEnum(scaleEEnum, Scale.class, "Scale");
		addEEnumLiteral(scaleEEnum, Scale.NOMINAL);
		addEEnumLiteral(scaleEEnum, Scale.ORDINAL);
		addEEnumLiteral(scaleEEnum, Scale.INTERVAL);
		addEEnumLiteral(scaleEEnum, Scale.RATIO);

		initEEnum(monotonicEEnum, Monotonic.class, "Monotonic");
		addEEnumLiteral(monotonicEEnum, Monotonic.NO);
		addEEnumLiteral(monotonicEEnum, Monotonic.YES);
		addEEnumLiteral(monotonicEEnum, Monotonic.STRONG);

		initEEnum(dataTypeEEnum, DataType.class, "DataType");
		addEEnumLiteral(dataTypeEEnum, DataType.QUANTITATIVE);
		addEEnumLiteral(dataTypeEEnum, DataType.QUALITATIVE);

		// Initialize data types
		initEDataType(ejsMeasureEDataType, Measure.class, "EJSMeasure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ejsDurationMeasureEDataType, Measure.class, "EJSDurationMeasure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ejsUnitEDataType, Unit.class, "EJSUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EmfmodelPackageImpl
