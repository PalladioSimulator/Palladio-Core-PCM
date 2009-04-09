/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationCharacterization;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType;
import de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.emfmodel.DataType;
import de.uka.ipd.sdq.edp2.models.emfmodel.Description;
import de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions;
import de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryEventTimes;
import de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Enumeration1;
import de.uka.ipd.sdq.edp2.models.emfmodel.EventTimeAggregation;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation;
import de.uka.ipd.sdq.edp2.models.emfmodel.Identifiable;
import de.uka.ipd.sdq.edp2.models.emfmodel.IntervalStatistics;
import de.uka.ipd.sdq.edp2.models.emfmodel.Intervals;
import de.uka.ipd.sdq.edp2.models.emfmodel.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measurement;
import de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange;
import de.uka.ipd.sdq.edp2.models.emfmodel.MetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure;
import de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics;
import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedCategory;
import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalScalarMeasure;
import de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics;
import de.uka.ipd.sdq.edp2.models.emfmodel.Percentile;
import de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions;
import de.uka.ipd.sdq.edp2.models.emfmodel.Propertyable;
import de.uka.ipd.sdq.edp2.models.emfmodel.RatioStatistics;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawXSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.Scale;
import de.uka.ipd.sdq.edp2.models.emfmodel.StrongMonotonicScalarMeasure;
import de.uka.ipd.sdq.edp2.models.emfmodel.ValueAggregation;

import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelValidator;

import java.util.Map;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmfmodelPackageImpl extends EPackageImpl implements EmfmodelPackage {
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
	private EClass rawXSeriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawYSeriesEClass = null;

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
	private EClass fixedWidthAggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalsEClass = null;

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
	private EClass measureEClass = null;

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
	private EClass aggregationCharacterizationEClass = null;

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
	private EClass ordinalScalarMeasureEClass = null;

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
	private EClass eventTimeAggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueAggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strongMonotonicScalarMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleBinaryEventTimesEClass = null;

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
	private EEnum enumeration1EEnum = null;

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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmfmodelPackageImpl() {
		super(eNS_URI, EmfmodelFactory.eINSTANCE);
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
	public static EmfmodelPackage init() {
		if (isInited) return (EmfmodelPackage)EPackage.Registry.INSTANCE.getEPackage(EmfmodelPackage.eNS_URI);

		// Obtain or create and register package
		EmfmodelPackageImpl theEmfmodelPackage = (EmfmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EmfmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EmfmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEmfmodelPackage.createPackageContents();

		// Initialize created meta-data
		theEmfmodelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theEmfmodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return EmfmodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theEmfmodelPackage.freeze();

		return theEmfmodelPackage;
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
	public EAttribute getAggregatedMeasurements_DistinctValuesBeforeAggregation() {
		return (EAttribute)aggregatedMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedMeasurements_DistinctValuesAfterAggregation() {
		return (EAttribute)aggregatedMeasurementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMeasurements_AggregationCharacterization() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedMeasurements_Valid() {
		return (EAttribute)aggregatedMeasurementsEClass.getEStructuralFeatures().get(4);
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
	public EReference getMeasurementRange_CollectedData() {
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
	public EReference getRawMeasurements_RawXSeries() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawMeasurements_RawYSeries() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawMeasurements_MeasurementRange() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawXSeries() {
		return rawXSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawXSeries_RawMeasurements() {
		return (EReference)rawXSeriesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawYSeries() {
		return rawYSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawYSeries_Statistics() {
		return (EReference)rawYSeriesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawYSeries_AggregatedMeasurements() {
		return (EReference)rawYSeriesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawYSeries_ValuesUuid() {
		return (EAttribute)rawYSeriesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawYSeries_RawMeasurements() {
		return (EReference)rawYSeriesEClass.getEStructuralFeatures().get(3);
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
	public EClass getFixedWidthAggregation() {
		return fixedWidthAggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedWidthAggregation_RawXSeries() {
		return (EReference)fixedWidthAggregationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedWidthAggregation_RawYSeries() {
		return (EReference)fixedWidthAggregationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntervals() {
		return intervalsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervals_LowerBound() {
		return (EAttribute)intervalsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervals_Width() {
		return (EAttribute)intervalsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervals_NumberOfIntervals() {
		return (EAttribute)intervalsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntervals_AggregatedMeasurements() {
		return (EReference)intervalsEClass.getEStructuralFeatures().get(3);
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
	public EClass getMeasure() {
		return measureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_ExperimentSetting() {
		return (EReference)measureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_ExperimentSettings() {
		return (EReference)measureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_PersistencyKind() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_MeasuredObject() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_Metric() {
		return (EReference)measureEClass.getEStructuralFeatures().get(4);
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
	public EReference getExperimentGroup_Measure() {
		return (EReference)experimentGroupEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getExperimentSetting_ExperimentName() {
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
	public EReference getExperimentRun_CollectedData() {
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
	public EAttribute getDescription_Uuid() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_Name() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_TextualDescription() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregationCharacterization() {
		return aggregationCharacterizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregationCharacterization_Function() {
		return (EReference)aggregationCharacterizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregationCharacterization_AggregatedMeasurements() {
		return (EReference)aggregationCharacterizationEClass.getEStructuralFeatures().get(1);
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
	public EClass getOrdinalScalarMeasure() {
		return ordinalScalarMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdinalScalarMeasure_DefaultUnitOfMeasurements() {
		return (EAttribute)ordinalScalarMeasureEClass.getEStructuralFeatures().get(0);
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
	public EClass getEventTimeAggregation() {
		return eventTimeAggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueAggregation() {
		return valueAggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrongMonotonicScalarMeasure() {
		return strongMonotonicScalarMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleBinaryEventTimes() {
		return doubleBinaryEventTimesEClass;
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
	public EEnum getEnumeration1() {
		return enumeration1EEnum;
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
	public EmfmodelFactory getEmfmodelFactory() {
		return (EmfmodelFactory)getEFactoryInstance();
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
		createEAttribute(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_BEFORE_AGGREGATION);
		createEAttribute(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_AFTER_AGGREGATION);
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__AGGREGATION_CHARACTERIZATION);
		createEAttribute(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__VALID);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__UUID);

		measurementRangeEClass = createEClass(MEASUREMENT_RANGE);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__RAW_MEASUREMENTS);
		createEAttribute(measurementRangeEClass, MEASUREMENT_RANGE__END_TIME);
		createEAttribute(measurementRangeEClass, MEASUREMENT_RANGE__START_TIME);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__COLLECTED_DATA);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS);

		rawMeasurementsEClass = createEClass(RAW_MEASUREMENTS);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__RAW_XSERIES);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__RAW_YSERIES);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__MEASUREMENT_RANGE);

		rawXSeriesEClass = createEClass(RAW_XSERIES);
		createEReference(rawXSeriesEClass, RAW_XSERIES__RAW_MEASUREMENTS);

		rawYSeriesEClass = createEClass(RAW_YSERIES);
		createEReference(rawYSeriesEClass, RAW_YSERIES__STATISTICS);
		createEReference(rawYSeriesEClass, RAW_YSERIES__AGGREGATED_MEASUREMENTS);
		createEAttribute(rawYSeriesEClass, RAW_YSERIES__VALUES_UUID);
		createEReference(rawYSeriesEClass, RAW_YSERIES__RAW_MEASUREMENTS);

		nominalStatisticsEClass = createEClass(NOMINAL_STATISTICS);
		createEAttribute(nominalStatisticsEClass, NOMINAL_STATISTICS__COUNT);
		createEReference(nominalStatisticsEClass, NOMINAL_STATISTICS__RAW_YSERIES);

		fixedWidthAggregationEClass = createEClass(FIXED_WIDTH_AGGREGATION);
		createEReference(fixedWidthAggregationEClass, FIXED_WIDTH_AGGREGATION__RAW_XSERIES);
		createEReference(fixedWidthAggregationEClass, FIXED_WIDTH_AGGREGATION__RAW_YSERIES);

		intervalsEClass = createEClass(INTERVALS);
		createEAttribute(intervalsEClass, INTERVALS__LOWER_BOUND);
		createEAttribute(intervalsEClass, INTERVALS__WIDTH);
		createEAttribute(intervalsEClass, INTERVALS__NUMBER_OF_INTERVALS);
		createEReference(intervalsEClass, INTERVALS__AGGREGATED_MEASUREMENTS);

		measurementEClass = createEClass(MEASUREMENT);
		createEReference(measurementEClass, MEASUREMENT__MEASURE);
		createEReference(measurementEClass, MEASUREMENT__EXPERIMENT_RUN);
		createEReference(measurementEClass, MEASUREMENT__MEASUREMENT_RANGE);

		propertyableEClass = createEClass(PROPERTYABLE);
		createEReference(propertyableEClass, PROPERTYABLE__ADDITIONAL_INFORMATION);

		eStringtoEObjectMapEntryEClass = createEClass(ESTRINGTO_EOBJECT_MAP_ENTRY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__KEY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__VALUE);

		measureEClass = createEClass(MEASURE);
		createEReference(measureEClass, MEASURE__EXPERIMENT_SETTING);
		createEReference(measureEClass, MEASURE__EXPERIMENT_SETTINGS);
		createEAttribute(measureEClass, MEASURE__PERSISTENCY_KIND);
		createEAttribute(measureEClass, MEASURE__MEASURED_OBJECT);
		createEReference(measureEClass, MEASURE__METRIC);

		experimentGroupEClass = createEClass(EXPERIMENT_GROUP);
		createEReference(experimentGroupEClass, EXPERIMENT_GROUP__EXPERIMENT_SETTINGS);
		createEReference(experimentGroupEClass, EXPERIMENT_GROUP__MEASURE);

		experimentSettingEClass = createEClass(EXPERIMENT_SETTING);
		createEAttribute(experimentSettingEClass, EXPERIMENT_SETTING__EXPERIMENT_NAME);
		createEReference(experimentSettingEClass, EXPERIMENT_SETTING__EXPERIMENT_RUNS);
		createEReference(experimentSettingEClass, EXPERIMENT_SETTING__MEASURE);

		experimentRunEClass = createEClass(EXPERIMENT_RUN);
		createEReference(experimentRunEClass, EXPERIMENT_RUN__COLLECTED_DATA);
		createEAttribute(experimentRunEClass, EXPERIMENT_RUN__START_TIME);
		createEAttribute(experimentRunEClass, EXPERIMENT_RUN__DURATION);
		createEReference(experimentRunEClass, EXPERIMENT_RUN__EXPERIMENT_SETTING);

		baseMetricDescriptionEClass = createEClass(BASE_METRIC_DESCRIPTION);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__CAPTURE_TYPE);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__DATA_TYPE);
		createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__SCALE);

		metricDescriptionEClass = createEClass(METRIC_DESCRIPTION);

		descriptionEClass = createEClass(DESCRIPTION);
		createEAttribute(descriptionEClass, DESCRIPTION__UUID);
		createEAttribute(descriptionEClass, DESCRIPTION__NAME);
		createEAttribute(descriptionEClass, DESCRIPTION__TEXTUAL_DESCRIPTION);

		aggregationCharacterizationEClass = createEClass(AGGREGATION_CHARACTERIZATION);
		createEReference(aggregationCharacterizationEClass, AGGREGATION_CHARACTERIZATION__FUNCTION);
		createEReference(aggregationCharacterizationEClass, AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS);

		aggregationFunctionDescriptionEClass = createEClass(AGGREGATION_FUNCTION_DESCRIPTION);

		longBinaryMeasurementsEClass = createEClass(LONG_BINARY_MEASUREMENTS);
		createEAttribute(longBinaryMeasurementsEClass, LONG_BINARY_MEASUREMENTS__STORAGE_UNIT);

		categoryIdentifierEClass = createEClass(CATEGORY_IDENTIFIER);
		createEAttribute(categoryIdentifierEClass, CATEGORY_IDENTIFIER__STATE_LITERAL);

		nominalMeasurementsEClass = createEClass(NOMINAL_MEASUREMENTS);

		nominalMeasureEClass = createEClass(NOMINAL_MEASURE);
		createEReference(nominalMeasureEClass, NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS);
		createEReference(nominalMeasureEClass, NOMINAL_MEASURE__INITIAL_STATE);

		doubleBinaryMeasurementsEClass = createEClass(DOUBLE_BINARY_MEASUREMENTS);
		createEAttribute(doubleBinaryMeasurementsEClass, DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT);

		ordinalScalarMeasureEClass = createEClass(ORDINAL_SCALAR_MEASURE);
		createEAttribute(ordinalScalarMeasureEClass, ORDINAL_SCALAR_MEASURE__DEFAULT_UNIT_OF_MEASUREMENTS);

		jsXmlMeasurementsEClass = createEClass(JS_XML_MEASUREMENTS);

		eventTimeAggregationEClass = createEClass(EVENT_TIME_AGGREGATION);

		valueAggregationEClass = createEClass(VALUE_AGGREGATION);

		strongMonotonicScalarMeasureEClass = createEClass(STRONG_MONOTONIC_SCALAR_MEASURE);

		doubleBinaryEventTimesEClass = createEClass(DOUBLE_BINARY_EVENT_TIMES);

		ijsDurationEClass = createEClass(IJS_DURATION);

		ijsQuantityEClass = createEClass(IJS_QUANTITY);

		descriptionsEClass = createEClass(DESCRIPTIONS);
		createEReference(descriptionsEClass, DESCRIPTIONS__DESCRIPTION);

		metricSetDescriptionEClass = createEClass(METRIC_SET_DESCRIPTION);
		createEReference(metricSetDescriptionEClass, METRIC_SET_DESCRIPTION__SUBSUMED_METRICS);

		ordinalStatisticsEClass = createEClass(ORDINAL_STATISTICS);
		createEAttribute(ordinalStatisticsEClass, ORDINAL_STATISTICS__MINIMUM);
		createEAttribute(ordinalStatisticsEClass, ORDINAL_STATISTICS__MAXIMUM);
		createEAttribute(ordinalStatisticsEClass, ORDINAL_STATISTICS__MEDIAN);
		createEReference(ordinalStatisticsEClass, ORDINAL_STATISTICS__PERCENTILES);

		percentileEClass = createEClass(PERCENTILE);
		createEAttribute(percentileEClass, PERCENTILE__PERCENTILE);
		createEAttribute(percentileEClass, PERCENTILE__VALUE);

		intervalStatisticsEClass = createEClass(INTERVAL_STATISTICS);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__ARITHMETHIC_MEAN);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__VARIANCE);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__STANDARD_DEVIATION);
		createEAttribute(intervalStatisticsEClass, INTERVAL_STATISTICS__SUM);

		ratioStatisticsEClass = createEClass(RATIO_STATISTICS);
		createEAttribute(ratioStatisticsEClass, RATIO_STATISTICS__COEFFICIENT_OF_VARIATION);
		createEAttribute(ratioStatisticsEClass, RATIO_STATISTICS__GEOMETRIC_MEAN);
		createEAttribute(ratioStatisticsEClass, RATIO_STATISTICS__HARMONIC_MEAN);

		observedNominalMeasurementsEClass = createEClass(OBSERVED_NOMINAL_MEASUREMENTS);
		createEReference(observedNominalMeasurementsEClass, OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES);
		createEAttribute(observedNominalMeasurementsEClass, OBSERVED_NOMINAL_MEASUREMENTS__UUID);

		observedCategoryEClass = createEClass(OBSERVED_CATEGORY);
		createEReference(observedCategoryEClass, OBSERVED_CATEGORY__CATEGORY_IDENTIFIER);

		// Create enums
		persistenceKindOptionsEEnum = createEEnum(PERSISTENCE_KIND_OPTIONS);
		captureTypeEEnum = createEEnum(CAPTURE_TYPE);
		dataTypeEEnum = createEEnum(DATA_TYPE);
		scaleEEnum = createEEnum(SCALE);
		enumeration1EEnum = createEEnum(ENUMERATION1);

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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		aggregatedMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
		rawMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
		fixedWidthAggregationEClass.getESuperTypes().add(this.getAggregatedMeasurements());
		intervalsEClass.getESuperTypes().add(this.getRawXSeries());
		measurementEClass.getESuperTypes().add(this.getPropertyable());
		experimentGroupEClass.getESuperTypes().add(this.getIdentifiable());
		experimentGroupEClass.getESuperTypes().add(this.getPropertyable());
		experimentSettingEClass.getESuperTypes().add(this.getPropertyable());
		experimentRunEClass.getESuperTypes().add(this.getIdentifiable());
		experimentRunEClass.getESuperTypes().add(this.getPropertyable());
		baseMetricDescriptionEClass.getESuperTypes().add(this.getMetricDescription());
		metricDescriptionEClass.getESuperTypes().add(this.getDescription());
		aggregationFunctionDescriptionEClass.getESuperTypes().add(this.getDescription());
		longBinaryMeasurementsEClass.getESuperTypes().add(this.getRawYSeries());
		categoryIdentifierEClass.getESuperTypes().add(this.getIdentifiable());
		nominalMeasurementsEClass.getESuperTypes().add(this.getRawYSeries());
		nominalMeasureEClass.getESuperTypes().add(this.getMeasure());
		nominalMeasureEClass.getESuperTypes().add(this.getIdentifiable());
		doubleBinaryMeasurementsEClass.getESuperTypes().add(this.getRawYSeries());
		ordinalScalarMeasureEClass.getESuperTypes().add(this.getMeasure());
		jsXmlMeasurementsEClass.getESuperTypes().add(this.getRawYSeries());
		eventTimeAggregationEClass.getESuperTypes().add(this.getFixedWidthAggregation());
		valueAggregationEClass.getESuperTypes().add(this.getFixedWidthAggregation());
		strongMonotonicScalarMeasureEClass.getESuperTypes().add(this.getOrdinalScalarMeasure());
		doubleBinaryEventTimesEClass.getESuperTypes().add(this.getRawXSeries());
		metricSetDescriptionEClass.getESuperTypes().add(this.getMetricDescription());
		ordinalStatisticsEClass.getESuperTypes().add(this.getNominalStatistics());
		intervalStatisticsEClass.getESuperTypes().add(this.getOrdinalStatistics());
		ratioStatisticsEClass.getESuperTypes().add(this.getIntervalStatistics());

		// Initialize classes and features; add operations and parameters
		initEClass(aggregatedMeasurementsEClass, AggregatedMeasurements.class, "AggregatedMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregatedMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_AggregatedMeasurements(), "measurementRange", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_DistinctValuesBeforeAggregation(), ecorePackage.getELong(), "distinctValuesBeforeAggregation", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_DistinctValuesAfterAggregation(), ecorePackage.getELong(), "distinctValuesAfterAggregation", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregatedMeasurements_AggregationCharacterization(), this.getAggregationCharacterization(), this.getAggregationCharacterization_AggregatedMeasurements(), "aggregationCharacterization", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_Valid(), ecorePackage.getEBoolean(), "valid", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_Uuid(), ecorePackage.getEString(), "uuid", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementRangeEClass, MeasurementRange.class, "MeasurementRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurementRange_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_MeasurementRange(), "rawMeasurements", null, 0, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_EndTime(), this.getEJSDurationMeasure(), "endTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_StartTime(), this.getEJSDurationMeasure(), "startTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_CollectedData(), this.getMeasurement(), this.getMeasurement_MeasurementRange(), "collectedData", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_MeasurementRange(), "aggregatedMeasurements", null, 0, -1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawMeasurementsEClass, RawMeasurements.class, "RawMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawMeasurements_RawXSeries(), this.getRawXSeries(), this.getRawXSeries_RawMeasurements(), "rawXSeries", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawMeasurements_RawYSeries(), this.getRawYSeries(), this.getRawYSeries_RawMeasurements(), "rawYSeries", null, 1, -1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_RawMeasurements(), "measurementRange", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawXSeriesEClass, RawXSeries.class, "RawXSeries", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawXSeries_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_RawXSeries(), "rawMeasurements", null, 1, 1, RawXSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawYSeriesEClass, RawYSeries.class, "RawYSeries", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawYSeries_Statistics(), this.getNominalStatistics(), this.getNominalStatistics_RawYSeries(), "statistics", null, 0, 1, RawYSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawYSeries_AggregatedMeasurements(), this.getFixedWidthAggregation(), this.getFixedWidthAggregation_RawYSeries(), "aggregatedMeasurements", null, 1, 1, RawYSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRawYSeries_ValuesUuid(), ecorePackage.getEString(), "valuesUuid", null, 1, 1, RawYSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawYSeries_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_RawYSeries(), "rawMeasurements", null, 1, 1, RawYSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(rawYSeriesEClass, ecorePackage.getEBoolean(), "Statisticsonlyformeasurablevalues", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nominalStatisticsEClass, NominalStatistics.class, "NominalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNominalStatistics_Count(), ecorePackage.getELong(), "count", null, 1, 1, NominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNominalStatistics_RawYSeries(), this.getRawYSeries(), this.getRawYSeries_Statistics(), "rawYSeries", null, 1, 1, NominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedWidthAggregationEClass, FixedWidthAggregation.class, "FixedWidthAggregation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFixedWidthAggregation_RawXSeries(), this.getIntervals(), this.getIntervals_AggregatedMeasurements(), "rawXSeries", null, 1, 1, FixedWidthAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFixedWidthAggregation_RawYSeries(), this.getRawYSeries(), this.getRawYSeries_AggregatedMeasurements(), "rawYSeries", null, 1, 1, FixedWidthAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intervalsEClass, Intervals.class, "Intervals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntervals_LowerBound(), this.getEJSMeasure(), "lowerBound", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervals_Width(), this.getEJSMeasure(), "width", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervals_NumberOfIntervals(), ecorePackage.getELong(), "numberOfIntervals", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIntervals_AggregatedMeasurements(), this.getFixedWidthAggregation(), this.getFixedWidthAggregation_RawXSeries(), "aggregatedMeasurements", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementEClass, Measurement.class, "Measurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurement_Measure(), this.getMeasure(), null, "measure", null, 1, 1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurement_ExperimentRun(), this.getExperimentRun(), this.getExperimentRun_CollectedData(), "experimentRun", null, 1, 1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurement_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_CollectedData(), "measurementRange", null, 0, -1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyableEClass, Propertyable.class, "Propertyable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyable_AdditionalInformation(), this.getEStringtoEObjectMapEntry(), null, "additionalInformation", null, 0, -1, Propertyable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eStringtoEObjectMapEntryEClass, Map.Entry.class, "EStringtoEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringtoEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEStringtoEObjectMapEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measureEClass, Measure.class, "Measure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasure_ExperimentSetting(), this.getExperimentGroup(), this.getExperimentGroup_Measure(), "experimentSetting", null, 1, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasure_ExperimentSettings(), this.getExperimentSetting(), this.getExperimentSetting_Measure(), "experimentSettings", null, 0, -1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasure_PersistencyKind(), this.getPersistenceKindOptions(), "persistencyKind", null, 1, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasure_MeasuredObject(), ecorePackage.getEString(), "measuredObject", null, 1, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasure_Metric(), this.getBaseMetricDescription(), null, "metric", null, 1, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentGroupEClass, ExperimentGroup.class, "ExperimentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperimentGroup_ExperimentSettings(), this.getExperimentSetting(), null, "experimentSettings", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentGroup_Measure(), this.getMeasure(), this.getMeasure_ExperimentSetting(), "measure", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentSettingEClass, ExperimentSetting.class, "ExperimentSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExperimentSetting_ExperimentName(), ecorePackage.getEString(), "experimentName", null, 1, 1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_ExperimentRuns(), this.getExperimentRun(), this.getExperimentRun_ExperimentSetting(), "experimentRuns", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_Measure(), this.getMeasure(), this.getMeasure_ExperimentSettings(), "measure", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentRunEClass, ExperimentRun.class, "ExperimentRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperimentRun_CollectedData(), this.getMeasurement(), this.getMeasurement_ExperimentRun(), "collectedData", null, 0, -1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperimentRun_StartTime(), ecorePackage.getEDate(), "startTime", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperimentRun_Duration(), this.getEJSDurationMeasure(), "duration", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentRun_ExperimentSetting(), this.getExperimentSetting(), this.getExperimentSetting_ExperimentRuns(), "experimentSetting", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(experimentRunEClass, ecorePackage.getEBoolean(), "ExactlyOneDataCollectionPerSensor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(baseMetricDescriptionEClass, BaseMetricDescription.class, "BaseMetricDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseMetricDescription_CaptureType(), this.getCaptureType(), "captureType", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseMetricDescription_DataType(), this.getDataType(), "dataType", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseMetricDescription_Scale(), this.getScale(), "scale", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(metricDescriptionEClass, MetricDescription.class, "MetricDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionEClass, Description.class, "Description", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescription_Uuid(), ecorePackage.getEString(), "uuid", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDescription_Name(), ecorePackage.getEString(), "name", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDescription_TextualDescription(), ecorePackage.getEString(), "textualDescription", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(aggregationCharacterizationEClass, AggregationCharacterization.class, "AggregationCharacterization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregationCharacterization_Function(), this.getAggregationFunctionDescription(), null, "function", null, 1, 1, AggregationCharacterization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregationCharacterization_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_AggregationCharacterization(), "aggregatedMeasurements", null, 1, 1, AggregationCharacterization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(aggregationFunctionDescriptionEClass, AggregationFunctionDescription.class, "AggregationFunctionDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(longBinaryMeasurementsEClass, LongBinaryMeasurements.class, "LongBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongBinaryMeasurements_StorageUnit(), this.getEJSUnit(), "storageUnit", null, 1, 1, LongBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(categoryIdentifierEClass, CategoryIdentifier.class, "CategoryIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategoryIdentifier_StateLiteral(), ecorePackage.getEString(), "stateLiteral", null, 1, 1, CategoryIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nominalMeasurementsEClass, NominalMeasurements.class, "NominalMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nominalMeasureEClass, NominalMeasure.class, "NominalMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNominalMeasure_DefinedCategoryIdentifiers(), this.getCategoryIdentifier(), null, "definedCategoryIdentifiers", null, 1, -1, NominalMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNominalMeasure_InitialState(), this.getCategoryIdentifier(), null, "initialState", null, 1, 1, NominalMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(nominalMeasureEClass, ecorePackage.getEBoolean(), "PersistenceKindOnlyEmfAllowed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(doubleBinaryMeasurementsEClass, DoubleBinaryMeasurements.class, "DoubleBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleBinaryMeasurements_StorageUnit(), this.getEJSUnit(), "storageUnit", null, 1, 1, DoubleBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ordinalScalarMeasureEClass, OrdinalScalarMeasure.class, "OrdinalScalarMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrdinalScalarMeasure_DefaultUnitOfMeasurements(), this.getEJSUnit(), "defaultUnitOfMeasurements", null, 1, 1, OrdinalScalarMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(ordinalScalarMeasureEClass, ecorePackage.getEBoolean(), "PersistencyKindNotEmf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jsXmlMeasurementsEClass, JSXmlMeasurements.class, "JSXmlMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventTimeAggregationEClass, EventTimeAggregation.class, "EventTimeAggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueAggregationEClass, ValueAggregation.class, "ValueAggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strongMonotonicScalarMeasureEClass, StrongMonotonicScalarMeasure.class, "StrongMonotonicScalarMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(doubleBinaryEventTimesEClass, DoubleBinaryEventTimes.class, "DoubleBinaryEventTimes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ijsDurationEClass, Duration.class, "IJSDuration", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(ijsQuantityEClass, Quantity.class, "IJSQuantity", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionsEClass, Descriptions.class, "Descriptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptions_Description(), this.getDescription(), null, "description", null, 0, -1, Descriptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(metricSetDescriptionEClass, MetricSetDescription.class, "MetricSetDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricSetDescription_SubsumedMetrics(), this.getMetricDescription(), null, "subsumedMetrics", null, 1, -1, MetricSetDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ordinalStatisticsEClass, OrdinalStatistics.class, "OrdinalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrdinalStatistics_Minimum(), this.getEJSMeasure(), "minimum", null, 1, 1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOrdinalStatistics_Maximum(), this.getEJSMeasure(), "maximum", null, 1, 1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOrdinalStatistics_Median(), this.getEJSMeasure(), "median", null, 0, 1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOrdinalStatistics_Percentiles(), this.getPercentile(), null, "percentiles", null, 1, -1, OrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(percentileEClass, Percentile.class, "Percentile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPercentile_Percentile(), ecorePackage.getEDouble(), "percentile", null, 1, 1, Percentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPercentile_Value(), this.getEJSMeasure(), "value", null, 1, 1, Percentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intervalStatisticsEClass, IntervalStatistics.class, "IntervalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntervalStatistics_ArithmethicMean(), this.getEJSMeasure(), "arithmethicMean", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalStatistics_Variance(), ecorePackage.getEDouble(), "variance", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalStatistics_StandardDeviation(), ecorePackage.getEDouble(), "standardDeviation", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalStatistics_Sum(), this.getEJSMeasure(), "sum", null, 1, 1, IntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ratioStatisticsEClass, RatioStatistics.class, "RatioStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRatioStatistics_CoefficientOfVariation(), ecorePackage.getEDouble(), "coefficientOfVariation", null, 1, 1, RatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRatioStatistics_GeometricMean(), this.getEJSMeasure(), "geometricMean", null, 1, 1, RatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRatioStatistics_HarmonicMean(), this.getEJSMeasure(), "harmonicMean", null, 1, 1, RatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(observedNominalMeasurementsEClass, ObservedNominalMeasurements.class, "ObservedNominalMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservedNominalMeasurements_ObservedCategories(), this.getObservedCategory(), null, "observedCategories", null, 0, -1, ObservedNominalMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObservedNominalMeasurements_Uuid(), ecorePackage.getEString(), "uuid", null, 1, 1, ObservedNominalMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(observedCategoryEClass, ObservedCategory.class, "ObservedCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservedCategory_CategoryIdentifier(), this.getCategoryIdentifier(), null, "categoryIdentifier", null, 1, 1, ObservedCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(persistenceKindOptionsEEnum, PersistenceKindOptions.class, "PersistenceKindOptions");
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.BINARY_LONG);
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.BINARY_DOUBLE);
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.XML_JSCIENCE);
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.EMF);

		initEEnum(captureTypeEEnum, CaptureType.class, "CaptureType");
		addEEnumLiteral(captureTypeEEnum, CaptureType.IDENTIFIER);
		addEEnumLiteral(captureTypeEEnum, CaptureType.NATURAL_NUMBER);
		addEEnumLiteral(captureTypeEEnum, CaptureType.REAL_NUMBER);

		initEEnum(dataTypeEEnum, DataType.class, "DataType");
		addEEnumLiteral(dataTypeEEnum, DataType.QUANTITATIVE);
		addEEnumLiteral(dataTypeEEnum, DataType.QUALITATIVE);

		initEEnum(scaleEEnum, Scale.class, "Scale");
		addEEnumLiteral(scaleEEnum, Scale.NOMINAL);
		addEEnumLiteral(scaleEEnum, Scale.ORDINAL);
		addEEnumLiteral(scaleEEnum, Scale.INTERVAL);
		addEEnumLiteral(scaleEEnum, Scale.RATIO);

		initEEnum(enumeration1EEnum, Enumeration1.class, "Enumeration1");

		// Initialize data types
		initEDataType(ejsMeasureEDataType, javax.measure.Measure.class, "EJSMeasure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ejsDurationMeasureEDataType, javax.measure.Measure.class, "EJSDurationMeasure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ejsUnitEDataType, Unit.class, "EJSUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EmfmodelPackageImpl
