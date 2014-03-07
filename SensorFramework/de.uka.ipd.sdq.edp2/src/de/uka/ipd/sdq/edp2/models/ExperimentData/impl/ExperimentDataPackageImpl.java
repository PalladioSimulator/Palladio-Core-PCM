/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
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
import de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Scale;
import de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1IdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics;
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
	private EClass measurementsRangeEClass = null;

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
	private EClass numericalNominalStatisticsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass numericalMassDistributionEClass = null;

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
	private EClass textualNominalStatisticsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass textualMassDistributionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass measurementsEClass = null;

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
	private EClass rawMeasurementsEClass = null;

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
	private EClass identifierEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass textualBaseMetricDescriptionEClass = null;

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
	private EClass doubleBinaryMeasurementsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass numericalIntervalStatisticsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass numericalOrdinalStatisticsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass numericalPercentileEClass = null;

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
	private EClass eComparableEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass numericalBaseMetricDescriptionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass textualOrdinalStatisticsEClass = null;

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
	private EClass identifierBasedMeasurementsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass observedIdentifierEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass observedIdentifierBasedMeasurementsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass numericalRatioStatisticsEClass = null;

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
	private EClass sensorFrameworkV1IdentifierBasedMeasurementsEClass = null;

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
        RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);

        // Create package meta-data objects
        theExperimentDataPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();

        // Initialize created meta-data
        theExperimentDataPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();

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
	public EReference getAggregatedMeasurements_MeasurementsRange() {
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
	public EClass getMeasurementsRange() {
        return measurementsRangeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMeasurementsRange_RawMeasurements() {
        return (EReference)measurementsRangeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMeasurementsRange_EndTime() {
        return (EAttribute)measurementsRangeEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMeasurementsRange_StartTime() {
        return (EAttribute)measurementsRangeEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMeasurementsRange_Measurements() {
        return (EReference)measurementsRangeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMeasurementsRange_AggregatedMeasurements() {
        return (EReference)measurementsRangeEClass.getEStructuralFeatures().get(4);
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
	public EReference getDataSeries_NumericalStatistics() {
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
	public EReference getDataSeries_TextualStatistics() {
        return (EReference)dataSeriesEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataSeries_RawMeasurements() {
        return (EReference)dataSeriesEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNumericalNominalStatistics() {
        return numericalNominalStatisticsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalNominalStatistics_NumberMeasurements() {
        return (EAttribute)numericalNominalStatisticsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNumericalNominalStatistics_NumericalMassDistribution() {
        return (EReference)numericalNominalStatisticsEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNumericalNominalStatistics_DataSeries() {
        return (EReference)numericalNominalStatisticsEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNumericalMassDistribution() {
        return numericalMassDistributionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalMassDistribution_Frequency() {
        return (EAttribute)numericalMassDistributionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalMassDistribution_Value() {
        return (EAttribute)numericalMassDistributionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNumericalMassDistribution_NumericalNominalStatistics() {
        return (EReference)numericalMassDistributionEClass.getEStructuralFeatures().get(2);
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
	public EClass getTextualNominalStatistics() {
        return textualNominalStatisticsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTextualNominalStatistics_NumberMeasurements() {
        return (EAttribute)textualNominalStatisticsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualNominalStatistics_MassDistribution() {
        return (EReference)textualNominalStatisticsEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualNominalStatistics_DataSeries() {
        return (EReference)textualNominalStatisticsEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTextualMassDistribution() {
        return textualMassDistributionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTextualMassDistribution_Frequency() {
        return (EAttribute)textualMassDistributionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualMassDistribution_Identifier() {
        return (EReference)textualMassDistributionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualMassDistribution_TextualNominalStatistics() {
        return (EReference)textualMassDistributionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMeasurements() {
        return measurementsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMeasurements_Measure() {
        return (EReference)measurementsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMeasurements_ExperimentRun() {
        return (EReference)measurementsEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMeasurements_MeasurementsRanges() {
        return (EReference)measurementsEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getEdp2Measure_MeasuredObject() {
        return (EAttribute)edp2MeasureEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEdp2Measure_Metric() {
        return (EReference)edp2MeasureEClass.getEStructuralFeatures().get(3);
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
	public EReference getRawMeasurements_MeasurementsRange() {
        return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(1);
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
        return (EReference)experimentGroupEClass.getEStructuralFeatures().get(3);
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
	public EReference getExperimentSetting_ExperimentGroup() {
        return (EReference)experimentSettingEClass.getEStructuralFeatures().get(3);
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
	public EReference getExperimentRun_Measurements() {
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
	public EClass getIdentifier() {
        return identifierEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getIdentifier_Literal() {
        return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIdentifier_TextualBaseMetricDescription() {
        return (EReference)identifierEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTextualBaseMetricDescription() {
        return textualBaseMetricDescriptionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualBaseMetricDescription_Identifiers() {
        return (EReference)textualBaseMetricDescriptionEClass.getEStructuralFeatures().get(0);
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
	public EReference getDescription_Descriptions() {
        return (EReference)descriptionEClass.getEStructuralFeatures().get(3);
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
	public EReference getAggregationStatistics_AggregatedMeasurements() {
        return (EReference)aggregationStatisticsEClass.getEStructuralFeatures().get(2);
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
	public EClass getNumericalIntervalStatistics() {
        return numericalIntervalStatisticsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalIntervalStatistics_ArithmethicMean() {
        return (EAttribute)numericalIntervalStatisticsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalIntervalStatistics_Variance() {
        return (EAttribute)numericalIntervalStatisticsEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalIntervalStatistics_StandardDeviation() {
        return (EAttribute)numericalIntervalStatisticsEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalIntervalStatistics_Sum() {
        return (EAttribute)numericalIntervalStatisticsEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNumericalOrdinalStatistics() {
        return numericalOrdinalStatisticsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalOrdinalStatistics_Minimum() {
        return (EAttribute)numericalOrdinalStatisticsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalOrdinalStatistics_Maximum() {
        return (EAttribute)numericalOrdinalStatisticsEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalOrdinalStatistics_Median() {
        return (EAttribute)numericalOrdinalStatisticsEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNumericalOrdinalStatistics_Percentiles() {
        return (EReference)numericalOrdinalStatisticsEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNumericalPercentile() {
        return numericalPercentileEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalPercentile_Percentile() {
        return (EAttribute)numericalPercentileEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalPercentile_Value() {
        return (EAttribute)numericalPercentileEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNumericalPercentile_OrdinalStatistics() {
        return (EReference)numericalPercentileEClass.getEStructuralFeatures().get(2);
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
	public EClass getEComparable() {
        return eComparableEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNumericalBaseMetricDescription() {
        return numericalBaseMetricDescriptionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalBaseMetricDescription_DefaultUnit() {
        return (EAttribute)numericalBaseMetricDescriptionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalBaseMetricDescription_PersistenceKind() {
        return (EAttribute)numericalBaseMetricDescriptionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTextualOrdinalStatistics() {
        return textualOrdinalStatisticsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualOrdinalStatistics_Minimum() {
        return (EReference)textualOrdinalStatisticsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualOrdinalStatistics_Maximum() {
        return (EReference)textualOrdinalStatisticsEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTextualOrdinalStatistics_Median() {
        return (EReference)textualOrdinalStatisticsEClass.getEStructuralFeatures().get(2);
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
	public EClass getIdentifierBasedMeasurements() {
        return identifierBasedMeasurementsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getObservedIdentifier() {
        return observedIdentifierEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getObservedIdentifier_Identifier() {
        return (EReference)observedIdentifierEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getObservedIdentifier_ObservedIdentifierBasedMeasurements() {
        return (EReference)observedIdentifierEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getObservedIdentifierBasedMeasurements() {
        return observedIdentifierBasedMeasurementsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getObservedIdentifierBasedMeasurements_ObservedIdentifiers() {
        return (EReference)observedIdentifierBasedMeasurementsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNumericalRatioStatistics() {
        return numericalRatioStatisticsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalRatioStatistics_CoefficientOfVariation() {
        return (EAttribute)numericalRatioStatisticsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalRatioStatistics_GeometricMean() {
        return (EAttribute)numericalRatioStatisticsEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNumericalRatioStatistics_HarmonicMean() {
        return (EAttribute)numericalRatioStatisticsEClass.getEStructuralFeatures().get(2);
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
	public EClass getSensorFrameworkV1IdentifierBasedMeasurements() {
        return sensorFrameworkV1IdentifierBasedMeasurementsEClass;
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
        createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE);
        createEAttribute(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__VALID);
        createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__FUNCTION);
        createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__AGGREGATION_STATISTICS);
        createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__AGGREGATION_ON);
        createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__METRIC);

        identifiableEClass = createEClass(IDENTIFIABLE);
        createEAttribute(identifiableEClass, IDENTIFIABLE__UUID);

        measurementsRangeEClass = createEClass(MEASUREMENTS_RANGE);
        createEReference(measurementsRangeEClass, MEASUREMENTS_RANGE__RAW_MEASUREMENTS);
        createEReference(measurementsRangeEClass, MEASUREMENTS_RANGE__MEASUREMENTS);
        createEAttribute(measurementsRangeEClass, MEASUREMENTS_RANGE__END_TIME);
        createEAttribute(measurementsRangeEClass, MEASUREMENTS_RANGE__START_TIME);
        createEReference(measurementsRangeEClass, MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS);

        propertyableEClass = createEClass(PROPERTYABLE);
        createEReference(propertyableEClass, PROPERTYABLE__ADDITIONAL_INFORMATION);

        eStringtoEObjectMapEntryEClass = createEClass(ESTRINGTO_EOBJECT_MAP_ENTRY);
        createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__KEY);
        createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__VALUE);

        rawMeasurementsEClass = createEClass(RAW_MEASUREMENTS);
        createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__DATA_SERIES);
        createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__MEASUREMENTS_RANGE);

        dataSeriesEClass = createEClass(DATA_SERIES);
        createEReference(dataSeriesEClass, DATA_SERIES__NUMERICAL_STATISTICS);
        createEReference(dataSeriesEClass, DATA_SERIES__AGGREGATED_MEASUREMENTS);
        createEAttribute(dataSeriesEClass, DATA_SERIES__VALUES_UUID);
        createEReference(dataSeriesEClass, DATA_SERIES__TEXTUAL_STATISTICS);
        createEReference(dataSeriesEClass, DATA_SERIES__RAW_MEASUREMENTS);

        numericalNominalStatisticsEClass = createEClass(NUMERICAL_NOMINAL_STATISTICS);
        createEAttribute(numericalNominalStatisticsEClass, NUMERICAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS);
        createEReference(numericalNominalStatisticsEClass, NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION);
        createEReference(numericalNominalStatisticsEClass, NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES);

        numericalMassDistributionEClass = createEClass(NUMERICAL_MASS_DISTRIBUTION);
        createEAttribute(numericalMassDistributionEClass, NUMERICAL_MASS_DISTRIBUTION__FREQUENCY);
        createEAttribute(numericalMassDistributionEClass, NUMERICAL_MASS_DISTRIBUTION__VALUE);
        createEReference(numericalMassDistributionEClass, NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS);

        fixedWidthAggregatedMeasurementsEClass = createEClass(FIXED_WIDTH_AGGREGATED_MEASUREMENTS);
        createEReference(fixedWidthAggregatedMeasurementsEClass, FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS);
        createEReference(fixedWidthAggregatedMeasurementsEClass, FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES);

        fixedIntervalsEClass = createEClass(FIXED_INTERVALS);
        createEAttribute(fixedIntervalsEClass, FIXED_INTERVALS__LOWER_BOUND);
        createEAttribute(fixedIntervalsEClass, FIXED_INTERVALS__WIDTH);
        createEAttribute(fixedIntervalsEClass, FIXED_INTERVALS__NUMBER_OF_INTERVALS);
        createEReference(fixedIntervalsEClass, FIXED_INTERVALS__AGGREGATED_MEASUREMENTS);

        textualNominalStatisticsEClass = createEClass(TEXTUAL_NOMINAL_STATISTICS);
        createEAttribute(textualNominalStatisticsEClass, TEXTUAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS);
        createEReference(textualNominalStatisticsEClass, TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION);
        createEReference(textualNominalStatisticsEClass, TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES);

        textualMassDistributionEClass = createEClass(TEXTUAL_MASS_DISTRIBUTION);
        createEAttribute(textualMassDistributionEClass, TEXTUAL_MASS_DISTRIBUTION__FREQUENCY);
        createEReference(textualMassDistributionEClass, TEXTUAL_MASS_DISTRIBUTION__IDENTIFIER);
        createEReference(textualMassDistributionEClass, TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS);

        identifierEClass = createEClass(IDENTIFIER);
        createEAttribute(identifierEClass, IDENTIFIER__LITERAL);
        createEReference(identifierEClass, IDENTIFIER__TEXTUAL_BASE_METRIC_DESCRIPTION);

        textualBaseMetricDescriptionEClass = createEClass(TEXTUAL_BASE_METRIC_DESCRIPTION);
        createEReference(textualBaseMetricDescriptionEClass, TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS);

        baseMetricDescriptionEClass = createEClass(BASE_METRIC_DESCRIPTION);
        createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__CAPTURE_TYPE);
        createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__DATA_TYPE);
        createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__SCALE);
        createEAttribute(baseMetricDescriptionEClass, BASE_METRIC_DESCRIPTION__MONOTONIC);

        metricDescriptionEClass = createEClass(METRIC_DESCRIPTION);

        descriptionEClass = createEClass(DESCRIPTION);
        createEAttribute(descriptionEClass, DESCRIPTION__NAME);
        createEAttribute(descriptionEClass, DESCRIPTION__TEXTUAL_DESCRIPTION);
        createEReference(descriptionEClass, DESCRIPTION__REPOSITORY);
        createEReference(descriptionEClass, DESCRIPTION__DESCRIPTIONS);

        experimentGroupEClass = createEClass(EXPERIMENT_GROUP);
        createEReference(experimentGroupEClass, EXPERIMENT_GROUP__EXPERIMENT_SETTINGS);
        createEReference(experimentGroupEClass, EXPERIMENT_GROUP__MEASURE);
        createEAttribute(experimentGroupEClass, EXPERIMENT_GROUP__PURPOSE);
        createEReference(experimentGroupEClass, EXPERIMENT_GROUP__REPOSITORY);

        experimentSettingEClass = createEClass(EXPERIMENT_SETTING);
        createEAttribute(experimentSettingEClass, EXPERIMENT_SETTING__DESCRIPTION);
        createEReference(experimentSettingEClass, EXPERIMENT_SETTING__EXPERIMENT_RUNS);
        createEReference(experimentSettingEClass, EXPERIMENT_SETTING__MEASURE);
        createEReference(experimentSettingEClass, EXPERIMENT_SETTING__EXPERIMENT_GROUP);

        experimentRunEClass = createEClass(EXPERIMENT_RUN);
        createEReference(experimentRunEClass, EXPERIMENT_RUN__MEASUREMENTS);
        createEAttribute(experimentRunEClass, EXPERIMENT_RUN__START_TIME);
        createEAttribute(experimentRunEClass, EXPERIMENT_RUN__DURATION);
        createEReference(experimentRunEClass, EXPERIMENT_RUN__EXPERIMENT_SETTING);

        measurementsEClass = createEClass(MEASUREMENTS);
        createEReference(measurementsEClass, MEASUREMENTS__MEASURE);
        createEReference(measurementsEClass, MEASUREMENTS__MEASUREMENTS_RANGES);
        createEReference(measurementsEClass, MEASUREMENTS__EXPERIMENT_RUN);

        edp2MeasureEClass = createEClass(EDP2_MEASURE);
        createEReference(edp2MeasureEClass, EDP2_MEASURE__EXPERIMENT_GROUP);
        createEReference(edp2MeasureEClass, EDP2_MEASURE__EXPERIMENT_SETTINGS);
        createEAttribute(edp2MeasureEClass, EDP2_MEASURE__MEASURED_OBJECT);
        createEReference(edp2MeasureEClass, EDP2_MEASURE__METRIC);

        descriptionsEClass = createEClass(DESCRIPTIONS);
        createEReference(descriptionsEClass, DESCRIPTIONS__DESCRIPTION);

        aggregationFunctionDescriptionEClass = createEClass(AGGREGATION_FUNCTION_DESCRIPTION);

        aggregationStatisticsEClass = createEClass(AGGREGATION_STATISTICS);
        createEAttribute(aggregationStatisticsEClass, AGGREGATION_STATISTICS__DISTINCT_VALUES_BEFORE_AGGREGATION);
        createEAttribute(aggregationStatisticsEClass, AGGREGATION_STATISTICS__DISTINCT_VALUES_AFTER_AGGREGATION);
        createEReference(aggregationStatisticsEClass, AGGREGATION_STATISTICS__AGGREGATED_MEASUREMENTS);

        doubleBinaryMeasurementsEClass = createEClass(DOUBLE_BINARY_MEASUREMENTS);
        createEAttribute(doubleBinaryMeasurementsEClass, DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT);

        numericalIntervalStatisticsEClass = createEClass(NUMERICAL_INTERVAL_STATISTICS);
        createEAttribute(numericalIntervalStatisticsEClass, NUMERICAL_INTERVAL_STATISTICS__ARITHMETHIC_MEAN);
        createEAttribute(numericalIntervalStatisticsEClass, NUMERICAL_INTERVAL_STATISTICS__VARIANCE);
        createEAttribute(numericalIntervalStatisticsEClass, NUMERICAL_INTERVAL_STATISTICS__STANDARD_DEVIATION);
        createEAttribute(numericalIntervalStatisticsEClass, NUMERICAL_INTERVAL_STATISTICS__SUM);

        numericalOrdinalStatisticsEClass = createEClass(NUMERICAL_ORDINAL_STATISTICS);
        createEAttribute(numericalOrdinalStatisticsEClass, NUMERICAL_ORDINAL_STATISTICS__MINIMUM);
        createEAttribute(numericalOrdinalStatisticsEClass, NUMERICAL_ORDINAL_STATISTICS__MAXIMUM);
        createEAttribute(numericalOrdinalStatisticsEClass, NUMERICAL_ORDINAL_STATISTICS__MEDIAN);
        createEReference(numericalOrdinalStatisticsEClass, NUMERICAL_ORDINAL_STATISTICS__PERCENTILES);

        numericalPercentileEClass = createEClass(NUMERICAL_PERCENTILE);
        createEAttribute(numericalPercentileEClass, NUMERICAL_PERCENTILE__PERCENTILE);
        createEAttribute(numericalPercentileEClass, NUMERICAL_PERCENTILE__VALUE);
        createEReference(numericalPercentileEClass, NUMERICAL_PERCENTILE__ORDINAL_STATISTICS);

        jsXmlMeasurementsEClass = createEClass(JS_XML_MEASUREMENTS);

        longBinaryMeasurementsEClass = createEClass(LONG_BINARY_MEASUREMENTS);
        createEAttribute(longBinaryMeasurementsEClass, LONG_BINARY_MEASUREMENTS__STORAGE_UNIT);

        metricSetDescriptionEClass = createEClass(METRIC_SET_DESCRIPTION);
        createEReference(metricSetDescriptionEClass, METRIC_SET_DESCRIPTION__SUBSUMED_METRICS);

        identifierBasedMeasurementsEClass = createEClass(IDENTIFIER_BASED_MEASUREMENTS);

        observedIdentifierEClass = createEClass(OBSERVED_IDENTIFIER);
        createEReference(observedIdentifierEClass, OBSERVED_IDENTIFIER__IDENTIFIER);
        createEReference(observedIdentifierEClass, OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS);

        observedIdentifierBasedMeasurementsEClass = createEClass(OBSERVED_IDENTIFIER_BASED_MEASUREMENTS);
        createEReference(observedIdentifierBasedMeasurementsEClass, OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS);

        numericalRatioStatisticsEClass = createEClass(NUMERICAL_RATIO_STATISTICS);
        createEAttribute(numericalRatioStatisticsEClass, NUMERICAL_RATIO_STATISTICS__COEFFICIENT_OF_VARIATION);
        createEAttribute(numericalRatioStatisticsEClass, NUMERICAL_RATIO_STATISTICS__GEOMETRIC_MEAN);
        createEAttribute(numericalRatioStatisticsEClass, NUMERICAL_RATIO_STATISTICS__HARMONIC_MEAN);

        sensorFrameworkV1DoubleBinaryMeasurementsEClass = createEClass(SENSOR_FRAMEWORK_V1_DOUBLE_BINARY_MEASUREMENTS);

        sensorFrameworkV1IdentifierBasedMeasurementsEClass = createEClass(SENSOR_FRAMEWORK_V1_IDENTIFIER_BASED_MEASUREMENTS);

        ijsDurationEClass = createEClass(IJS_DURATION);

        ijsQuantityEClass = createEClass(IJS_QUANTITY);

        eComparableEClass = createEClass(ECOMPARABLE);

        numericalBaseMetricDescriptionEClass = createEClass(NUMERICAL_BASE_METRIC_DESCRIPTION);
        createEAttribute(numericalBaseMetricDescriptionEClass, NUMERICAL_BASE_METRIC_DESCRIPTION__DEFAULT_UNIT);
        createEAttribute(numericalBaseMetricDescriptionEClass, NUMERICAL_BASE_METRIC_DESCRIPTION__PERSISTENCE_KIND);

        textualOrdinalStatisticsEClass = createEClass(TEXTUAL_ORDINAL_STATISTICS);
        createEReference(textualOrdinalStatisticsEClass, TEXTUAL_ORDINAL_STATISTICS__MINIMUM);
        createEReference(textualOrdinalStatisticsEClass, TEXTUAL_ORDINAL_STATISTICS__MAXIMUM);
        createEReference(textualOrdinalStatisticsEClass, TEXTUAL_ORDINAL_STATISTICS__MEDIAN);

        // Create enums
        captureTypeEEnum = createEEnum(CAPTURE_TYPE);
        scaleEEnum = createEEnum(SCALE);
        monotonicEEnum = createEEnum(MONOTONIC);
        persistenceKindOptionsEEnum = createEEnum(PERSISTENCE_KIND_OPTIONS);
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
        ETypeParameter doubleBinaryMeasurementsEClass_Q = addETypeParameter(doubleBinaryMeasurementsEClass, "Q");
        addETypeParameter(ejsMeasureEDataType, "V");
        ETypeParameter ejsMeasureEDataType_Q = addETypeParameter(ejsMeasureEDataType, "Q");
        ETypeParameter ejsUnitEDataType_Q = addETypeParameter(ejsUnitEDataType, "Q");

        // Set bounds for type parameters
        EGenericType g1 = createEGenericType(this.getIJSQuantity());
        doubleBinaryMeasurementsEClass_Q.getEBounds().add(g1);
        g1 = createEGenericType(this.getIJSQuantity());
        ejsMeasureEDataType_Q.getEBounds().add(g1);
        g1 = createEGenericType(this.getIJSQuantity());
        ejsUnitEDataType_Q.getEBounds().add(g1);

        // Add supertypes to classes
        aggregatedMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
        measurementsRangeEClass.getESuperTypes().add(this.getPropertyable());
        rawMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
        numericalNominalStatisticsEClass.getESuperTypes().add(this.getIdentifiable());
        fixedWidthAggregatedMeasurementsEClass.getESuperTypes().add(this.getAggregatedMeasurements());
        fixedIntervalsEClass.getESuperTypes().add(this.getIdentifiable());
        identifierEClass.getESuperTypes().add(this.getIdentifiable());
        textualBaseMetricDescriptionEClass.getESuperTypes().add(this.getBaseMetricDescription());
        baseMetricDescriptionEClass.getESuperTypes().add(this.getMetricDescription());
        metricDescriptionEClass.getESuperTypes().add(this.getDescription());
        descriptionEClass.getESuperTypes().add(this.getIdentifiable());
        experimentGroupEClass.getESuperTypes().add(this.getIdentifiable());
        experimentGroupEClass.getESuperTypes().add(this.getPropertyable());
        experimentSettingEClass.getESuperTypes().add(this.getIdentifiable());
        experimentSettingEClass.getESuperTypes().add(this.getPropertyable());
        experimentRunEClass.getESuperTypes().add(this.getIdentifiable());
        experimentRunEClass.getESuperTypes().add(this.getPropertyable());
        measurementsEClass.getESuperTypes().add(this.getIdentifiable());
        measurementsEClass.getESuperTypes().add(this.getPropertyable());
        edp2MeasureEClass.getESuperTypes().add(this.getIdentifiable());
        descriptionsEClass.getESuperTypes().add(this.getIdentifiable());
        aggregationFunctionDescriptionEClass.getESuperTypes().add(this.getDescription());
        aggregationStatisticsEClass.getESuperTypes().add(this.getIdentifiable());
        doubleBinaryMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
        numericalIntervalStatisticsEClass.getESuperTypes().add(this.getNumericalOrdinalStatistics());
        numericalOrdinalStatisticsEClass.getESuperTypes().add(this.getNumericalNominalStatistics());
        numericalPercentileEClass.getESuperTypes().add(this.getIdentifiable());
        jsXmlMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
        longBinaryMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
        metricSetDescriptionEClass.getESuperTypes().add(this.getMetricDescription());
        identifierBasedMeasurementsEClass.getESuperTypes().add(this.getDataSeries());
        observedIdentifierEClass.getESuperTypes().add(this.getIdentifiable());
        observedIdentifierBasedMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
        numericalRatioStatisticsEClass.getESuperTypes().add(this.getNumericalIntervalStatistics());
        sensorFrameworkV1DoubleBinaryMeasurementsEClass.getESuperTypes().add(this.getDoubleBinaryMeasurements());
        sensorFrameworkV1IdentifierBasedMeasurementsEClass.getESuperTypes().add(this.getIdentifierBasedMeasurements());
        numericalBaseMetricDescriptionEClass.getESuperTypes().add(this.getBaseMetricDescription());
        textualOrdinalStatisticsEClass.getESuperTypes().add(this.getTextualNominalStatistics());

        // Initialize classes and features; add operations and parameters
        initEClass(aggregatedMeasurementsEClass, AggregatedMeasurements.class, "AggregatedMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAggregatedMeasurements_MeasurementsRange(), this.getMeasurementsRange(), this.getMeasurementsRange_AggregatedMeasurements(), "measurementsRange", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getAggregatedMeasurements_Valid(), ecorePackage.getEBoolean(), "valid", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAggregatedMeasurements_Function(), this.getAggregationFunctionDescription(), null, "function", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAggregatedMeasurements_AggregationStatistics(), this.getAggregationStatistics(), this.getAggregationStatistics_AggregatedMeasurements(), "aggregationStatistics", null, 0, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAggregatedMeasurements_AggregationOn(), this.getBaseMetricDescription(), null, "aggregationOn", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAggregatedMeasurements_Metric(), this.getMetricDescription(), null, "metric", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIdentifiable_Uuid(), ecorePackage.getEString(), "uuid", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(measurementsRangeEClass, MeasurementsRange.class, "MeasurementsRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMeasurementsRange_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_MeasurementsRange(), "rawMeasurements", null, 0, 1, MeasurementsRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getMeasurementsRange_Measurements(), this.getMeasurements(), this.getMeasurements_MeasurementsRanges(), "measurements", null, 1, 1, MeasurementsRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getMeasurementsRange_EndTime(), this.getEJSDurationMeasure(), "endTime", null, 1, 1, MeasurementsRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getMeasurementsRange_StartTime(), this.getEJSDurationMeasure(), "startTime", null, 1, 1, MeasurementsRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getMeasurementsRange_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_MeasurementsRange(), "aggregatedMeasurements", null, 0, -1, MeasurementsRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(propertyableEClass, Propertyable.class, "Propertyable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPropertyable_AdditionalInformation(), this.getEStringtoEObjectMapEntry(), null, "additionalInformation", null, 0, -1, Propertyable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eStringtoEObjectMapEntryEClass, Map.Entry.class, "EStringtoEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEStringtoEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getEStringtoEObjectMapEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(rawMeasurementsEClass, RawMeasurements.class, "RawMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRawMeasurements_DataSeries(), this.getDataSeries(), this.getDataSeries_RawMeasurements(), "dataSeries", null, 1, -1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getRawMeasurements_MeasurementsRange(), this.getMeasurementsRange(), this.getMeasurementsRange_RawMeasurements(), "measurementsRange", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(dataSeriesEClass, DataSeries.class, "DataSeries", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataSeries_NumericalStatistics(), this.getNumericalNominalStatistics(), this.getNumericalNominalStatistics_DataSeries(), "numericalStatistics", null, 0, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDataSeries_AggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements_DataSeries(), "aggregatedMeasurements", null, 0, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getDataSeries_ValuesUuid(), ecorePackage.getEString(), "valuesUuid", null, 1, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDataSeries_TextualStatistics(), this.getTextualNominalStatistics(), this.getTextualNominalStatistics_DataSeries(), "textualStatistics", null, 0, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDataSeries_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_DataSeries(), "rawMeasurements", null, 0, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(numericalNominalStatisticsEClass, NumericalNominalStatistics.class, "NumericalNominalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNumericalNominalStatistics_NumberMeasurements(), this.getEJSMeasure(), "numberMeasurements", null, 1, 1, NumericalNominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getNumericalNominalStatistics_NumericalMassDistribution(), this.getNumericalMassDistribution(), this.getNumericalMassDistribution_NumericalNominalStatistics(), "numericalMassDistribution", null, 0, -1, NumericalNominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getNumericalNominalStatistics_DataSeries(), this.getDataSeries(), this.getDataSeries_NumericalStatistics(), "dataSeries", null, 1, 1, NumericalNominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(numericalMassDistributionEClass, NumericalMassDistribution.class, "NumericalMassDistribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNumericalMassDistribution_Frequency(), ecorePackage.getELong(), "frequency", null, 1, 1, NumericalMassDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalMassDistribution_Value(), this.getEJSMeasure(), "value", null, 1, 1, NumericalMassDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getNumericalMassDistribution_NumericalNominalStatistics(), this.getNumericalNominalStatistics(), this.getNumericalNominalStatistics_NumericalMassDistribution(), "numericalNominalStatistics", null, 1, 1, NumericalMassDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(fixedWidthAggregatedMeasurementsEClass, FixedWidthAggregatedMeasurements.class, "FixedWidthAggregatedMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFixedWidthAggregatedMeasurements_Intervals(), this.getFixedIntervals(), this.getFixedIntervals_AggregatedMeasurements(), "intervals", null, 1, 1, FixedWidthAggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getFixedWidthAggregatedMeasurements_DataSeries(), this.getDataSeries(), this.getDataSeries_AggregatedMeasurements(), "dataSeries", null, 1, -1, FixedWidthAggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(fixedIntervalsEClass, FixedIntervals.class, "FixedIntervals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFixedIntervals_LowerBound(), this.getEJSMeasure(), "lowerBound", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getFixedIntervals_Width(), this.getEJSMeasure(), "width", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getFixedIntervals_NumberOfIntervals(), ecorePackage.getELong(), "numberOfIntervals", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getFixedIntervals_AggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements(), this.getFixedWidthAggregatedMeasurements_Intervals(), "aggregatedMeasurements", null, 1, 1, FixedIntervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(textualNominalStatisticsEClass, TextualNominalStatistics.class, "TextualNominalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTextualNominalStatistics_NumberMeasurements(), ecorePackage.getELong(), "numberMeasurements", null, 1, 1, TextualNominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getTextualNominalStatistics_MassDistribution(), this.getTextualMassDistribution(), this.getTextualMassDistribution_TextualNominalStatistics(), "massDistribution", null, 0, -1, TextualNominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getTextualNominalStatistics_DataSeries(), this.getDataSeries(), this.getDataSeries_TextualStatistics(), "dataSeries", null, 1, 1, TextualNominalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(textualMassDistributionEClass, TextualMassDistribution.class, "TextualMassDistribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTextualMassDistribution_Frequency(), ecorePackage.getELong(), "frequency", null, 1, 1, TextualMassDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getTextualMassDistribution_Identifier(), this.getIdentifier(), null, "identifier", null, 1, 1, TextualMassDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getTextualMassDistribution_TextualNominalStatistics(), this.getTextualNominalStatistics(), this.getTextualNominalStatistics_MassDistribution(), "textualNominalStatistics", null, 1, 1, TextualMassDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIdentifier_Literal(), ecorePackage.getEString(), "literal", null, 1, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getIdentifier_TextualBaseMetricDescription(), this.getTextualBaseMetricDescription(), this.getTextualBaseMetricDescription_Identifiers(), "textualBaseMetricDescription", null, 1, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(textualBaseMetricDescriptionEClass, TextualBaseMetricDescription.class, "TextualBaseMetricDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTextualBaseMetricDescription_Identifiers(), this.getIdentifier(), this.getIdentifier_TextualBaseMetricDescription(), "identifiers", null, 1, -1, TextualBaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(baseMetricDescriptionEClass, BaseMetricDescription.class, "BaseMetricDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getBaseMetricDescription_CaptureType(), this.getCaptureType(), "captureType", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getBaseMetricDescription_DataType(), this.getDataType(), "dataType", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getBaseMetricDescription_Scale(), this.getScale(), "scale", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getBaseMetricDescription_Monotonic(), this.getMonotonic(), "monotonic", null, 1, 1, BaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(metricDescriptionEClass, MetricDescription.class, "MetricDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(descriptionEClass, Description.class, "Description", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDescription_Name(), ecorePackage.getEString(), "name", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getDescription_TextualDescription(), ecorePackage.getEString(), "textualDescription", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDescription_Repository(), theRepositoryPackage.getRepository(), theRepositoryPackage.getRepository_Descriptions(), "repository", null, 0, 1, Description.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDescription_Descriptions(), this.getDescriptions(), this.getDescriptions_Description(), "descriptions", null, 1, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(experimentGroupEClass, ExperimentGroup.class, "ExperimentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getExperimentGroup_ExperimentSettings(), this.getExperimentSetting(), this.getExperimentSetting_ExperimentGroup(), "experimentSettings", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperimentGroup_Measure(), this.getEdp2Measure(), this.getEdp2Measure_ExperimentGroup(), "measure", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExperimentGroup_Purpose(), ecorePackage.getEString(), "purpose", null, 1, 1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperimentGroup_Repository(), theRepositoryPackage.getRepository(), theRepositoryPackage.getRepository_ExperimentGroups(), "repository", null, 0, 1, ExperimentGroup.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(experimentSettingEClass, ExperimentSetting.class, "ExperimentSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExperimentSetting_Description(), ecorePackage.getEString(), "description", null, 1, 1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperimentSetting_ExperimentRuns(), this.getExperimentRun(), this.getExperimentRun_ExperimentSetting(), "experimentRuns", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperimentSetting_Measure(), this.getEdp2Measure(), this.getEdp2Measure_ExperimentSettings(), "measure", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperimentSetting_ExperimentGroup(), this.getExperimentGroup(), this.getExperimentGroup_ExperimentSettings(), "experimentGroup", null, 1, 1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(experimentRunEClass, ExperimentRun.class, "ExperimentRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getExperimentRun_Measurements(), this.getMeasurements(), this.getMeasurements_ExperimentRun(), "measurements", null, 0, -1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExperimentRun_StartTime(), ecorePackage.getEDate(), "startTime", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExperimentRun_Duration(), this.getEJSDurationMeasure(), "duration", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExperimentRun_ExperimentSetting(), this.getExperimentSetting(), this.getExperimentSetting_ExperimentRuns(), "experimentSetting", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(measurementsEClass, Measurements.class, "Measurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMeasurements_Measure(), this.getEdp2Measure(), null, "measure", null, 1, 1, Measurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getMeasurements_MeasurementsRanges(), this.getMeasurementsRange(), this.getMeasurementsRange_Measurements(), "measurementsRanges", null, 0, -1, Measurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getMeasurements_ExperimentRun(), this.getExperimentRun(), this.getExperimentRun_Measurements(), "experimentRun", null, 1, 1, Measurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(edp2MeasureEClass, Edp2Measure.class, "Edp2Measure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEdp2Measure_ExperimentGroup(), this.getExperimentGroup(), this.getExperimentGroup_Measure(), "experimentGroup", null, 1, 1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getEdp2Measure_ExperimentSettings(), this.getExperimentSetting(), this.getExperimentSetting_Measure(), "experimentSettings", null, 0, -1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getEdp2Measure_MeasuredObject(), ecorePackage.getEString(), "measuredObject", null, 1, 1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getEdp2Measure_Metric(), this.getMetricDescription(), null, "metric", null, 1, 1, Edp2Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(descriptionsEClass, Descriptions.class, "Descriptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDescriptions_Description(), this.getDescription(), this.getDescription_Descriptions(), "description", null, 0, -1, Descriptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(aggregationFunctionDescriptionEClass, AggregationFunctionDescription.class, "AggregationFunctionDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(aggregationStatisticsEClass, AggregationStatistics.class, "AggregationStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAggregationStatistics_DistinctValuesBeforeAggregation(), ecorePackage.getELong(), "distinctValuesBeforeAggregation", null, 1, 1, AggregationStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getAggregationStatistics_DistinctValuesAfterAggregation(), ecorePackage.getELong(), "distinctValuesAfterAggregation", null, 1, 1, AggregationStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAggregationStatistics_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_AggregationStatistics(), "aggregatedMeasurements", null, 1, 1, AggregationStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(doubleBinaryMeasurementsEClass, DoubleBinaryMeasurements.class, "DoubleBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        g1 = createEGenericType(this.getEJSUnit());
        EGenericType g2 = createEGenericType(doubleBinaryMeasurementsEClass_Q);
        g1.getETypeArguments().add(g2);
        initEAttribute(getDoubleBinaryMeasurements_StorageUnit(), g1, "storageUnit", null, 1, 1, DoubleBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(numericalIntervalStatisticsEClass, NumericalIntervalStatistics.class, "NumericalIntervalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNumericalIntervalStatistics_ArithmethicMean(), this.getEJSMeasure(), "arithmethicMean", null, 1, 1, NumericalIntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalIntervalStatistics_Variance(), this.getEJSMeasure(), "variance", null, 1, 1, NumericalIntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalIntervalStatistics_StandardDeviation(), this.getEJSMeasure(), "standardDeviation", null, 1, 1, NumericalIntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalIntervalStatistics_Sum(), this.getEJSMeasure(), "sum", null, 1, 1, NumericalIntervalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(numericalOrdinalStatisticsEClass, NumericalOrdinalStatistics.class, "NumericalOrdinalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNumericalOrdinalStatistics_Minimum(), this.getEJSMeasure(), "minimum", null, 1, 1, NumericalOrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalOrdinalStatistics_Maximum(), this.getEJSMeasure(), "maximum", null, 1, 1, NumericalOrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalOrdinalStatistics_Median(), this.getEJSMeasure(), "median", null, 0, 1, NumericalOrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getNumericalOrdinalStatistics_Percentiles(), this.getNumericalPercentile(), this.getNumericalPercentile_OrdinalStatistics(), "percentiles", null, 0, -1, NumericalOrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(numericalPercentileEClass, NumericalPercentile.class, "NumericalPercentile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNumericalPercentile_Percentile(), ecorePackage.getEDouble(), "percentile", null, 1, 1, NumericalPercentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalPercentile_Value(), this.getEJSMeasure(), "value", null, 1, 1, NumericalPercentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getNumericalPercentile_OrdinalStatistics(), this.getNumericalOrdinalStatistics(), this.getNumericalOrdinalStatistics_Percentiles(), "ordinalStatistics", null, 1, 1, NumericalPercentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(jsXmlMeasurementsEClass, JSXmlMeasurements.class, "JSXmlMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(longBinaryMeasurementsEClass, LongBinaryMeasurements.class, "LongBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLongBinaryMeasurements_StorageUnit(), this.getEJSUnit(), "storageUnit", null, 1, 1, LongBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(metricSetDescriptionEClass, MetricSetDescription.class, "MetricSetDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMetricSetDescription_SubsumedMetrics(), this.getMetricDescription(), null, "subsumedMetrics", null, 1, -1, MetricSetDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(identifierBasedMeasurementsEClass, IdentifierBasedMeasurements.class, "IdentifierBasedMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(observedIdentifierEClass, ObservedIdentifier.class, "ObservedIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getObservedIdentifier_Identifier(), this.getIdentifier(), null, "identifier", null, 1, 1, ObservedIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getObservedIdentifier_ObservedIdentifierBasedMeasurements(), this.getObservedIdentifierBasedMeasurements(), this.getObservedIdentifierBasedMeasurements_ObservedIdentifiers(), "observedIdentifierBasedMeasurements", null, 1, 1, ObservedIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(observedIdentifierBasedMeasurementsEClass, ObservedIdentifierBasedMeasurements.class, "ObservedIdentifierBasedMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getObservedIdentifierBasedMeasurements_ObservedIdentifiers(), this.getObservedIdentifier(), this.getObservedIdentifier_ObservedIdentifierBasedMeasurements(), "observedIdentifiers", null, 0, -1, ObservedIdentifierBasedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(numericalRatioStatisticsEClass, NumericalRatioStatistics.class, "NumericalRatioStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNumericalRatioStatistics_CoefficientOfVariation(), this.getEJSMeasure(), "coefficientOfVariation", null, 1, 1, NumericalRatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalRatioStatistics_GeometricMean(), this.getEJSMeasure(), "geometricMean", null, 1, 1, NumericalRatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalRatioStatistics_HarmonicMean(), this.getEJSMeasure(), "harmonicMean", null, 1, 1, NumericalRatioStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(sensorFrameworkV1DoubleBinaryMeasurementsEClass, SensorFrameworkV1DoubleBinaryMeasurements.class, "SensorFrameworkV1DoubleBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(sensorFrameworkV1IdentifierBasedMeasurementsEClass, SensorFrameworkV1IdentifierBasedMeasurements.class, "SensorFrameworkV1IdentifierBasedMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(ijsDurationEClass, Duration.class, "IJSDuration", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(ijsQuantityEClass, Quantity.class, "IJSQuantity", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(eComparableEClass, Comparable.class, "EComparable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(numericalBaseMetricDescriptionEClass, NumericalBaseMetricDescription.class, "NumericalBaseMetricDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNumericalBaseMetricDescription_DefaultUnit(), this.getEJSUnit(), "defaultUnit", null, 0, 1, NumericalBaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getNumericalBaseMetricDescription_PersistenceKind(), this.getPersistenceKindOptions(), "persistenceKind", null, 1, 1, NumericalBaseMetricDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(textualOrdinalStatisticsEClass, TextualOrdinalStatistics.class, "TextualOrdinalStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTextualOrdinalStatistics_Minimum(), this.getIdentifier(), null, "minimum", null, 1, 1, TextualOrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getTextualOrdinalStatistics_Maximum(), this.getIdentifier(), null, "maximum", null, 1, 1, TextualOrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getTextualOrdinalStatistics_Median(), this.getIdentifier(), null, "median", null, 1, 1, TextualOrdinalStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(captureTypeEEnum, CaptureType.class, "CaptureType");
        addEEnumLiteral(captureTypeEEnum, CaptureType.IDENTIFIER);
        addEEnumLiteral(captureTypeEEnum, CaptureType.INTEGER_NUMBER);
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

        initEEnum(persistenceKindOptionsEEnum, PersistenceKindOptions.class, "PersistenceKindOptions");
        addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.BINARY_PREFERRED);
        addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.JS_XML_PREFERRED);

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
