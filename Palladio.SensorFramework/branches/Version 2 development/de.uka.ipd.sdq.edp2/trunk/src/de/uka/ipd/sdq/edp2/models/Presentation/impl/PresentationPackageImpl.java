/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentDataPackageImpl;
import de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.EmfmodelPackageImpl;
import de.uka.ipd.sdq.edp2.models.Presentation.Bar;
import de.uka.ipd.sdq.edp2.models.Presentation.Boxplot;
import de.uka.ipd.sdq.edp2.models.Presentation.CumulativeDistributionFunction;
import de.uka.ipd.sdq.edp2.models.Presentation.DataReader;
import de.uka.ipd.sdq.edp2.models.Presentation.DataReaderConfiguration;
import de.uka.ipd.sdq.edp2.models.Presentation.DataReaderEDP2;
import de.uka.ipd.sdq.edp2.models.Presentation.DataReaderEDP2Histogram;
import de.uka.ipd.sdq.edp2.models.Presentation.DataReaderSensorFramework;
import de.uka.ipd.sdq.edp2.models.Presentation.DataSource;
import de.uka.ipd.sdq.edp2.models.Presentation.DataSourceEDP2;
import de.uka.ipd.sdq.edp2.models.Presentation.DataSourceSensorFramework;
import de.uka.ipd.sdq.edp2.models.Presentation.DataType;
import de.uka.ipd.sdq.edp2.models.Presentation.EDP2DataSourceDescription;
import de.uka.ipd.sdq.edp2.models.Presentation.EnhancedHistogram;
import de.uka.ipd.sdq.edp2.models.Presentation.Histogram;
import de.uka.ipd.sdq.edp2.models.Presentation.HistogramView;
import de.uka.ipd.sdq.edp2.models.Presentation.IDataSourceDescription;
import de.uka.ipd.sdq.edp2.models.Presentation.IEditorInput;
import de.uka.ipd.sdq.edp2.models.Presentation.IntervalCorrelatedSeries;
import de.uka.ipd.sdq.edp2.models.Presentation.JFreeChartCumulativeDistributionView;
import de.uka.ipd.sdq.edp2.models.Presentation.JFreeChartHistogramView;
import de.uka.ipd.sdq.edp2.models.Presentation.JFreeChartLineView;
import de.uka.ipd.sdq.edp2.models.Presentation.JFreeChartPresentationViewFactory;
import de.uka.ipd.sdq.edp2.models.Presentation.JFreeChartView;
import de.uka.ipd.sdq.edp2.models.Presentation.Line;
import de.uka.ipd.sdq.edp2.models.Presentation.NominalMeasurementsType;
import de.uka.ipd.sdq.edp2.models.Presentation.OrdinalIntervalsType;
import de.uka.ipd.sdq.edp2.models.Presentation.OrdinalMeasurementsType;
import de.uka.ipd.sdq.edp2.models.Presentation.Pie;
import de.uka.ipd.sdq.edp2.models.Presentation.Point;
import de.uka.ipd.sdq.edp2.models.Presentation.PresentationFactory;
import de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage;
import de.uka.ipd.sdq.edp2.models.Presentation.RView;
import de.uka.ipd.sdq.edp2.models.Presentation.SensorFrameworkDataSourceDescription;
import de.uka.ipd.sdq.edp2.models.Presentation.State;
import de.uka.ipd.sdq.edp2.models.Presentation.ValueCorrelatedSeries;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.UIPackageImpl;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl;








import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PresentationPackageImpl extends EPackageImpl implements PresentationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jFreeChartViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReaderConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDataSourceDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass histogramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass barEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cumulativeDistributionFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boxplotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEditorInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edp2DataSourceDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorFrameworkDataSourceDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jFreeChartHistogramViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass histogramViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jFreeChartCumulativeDistributionViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jFreeChartLineViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enhancedHistogramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReaderEDP2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReaderSensorFrameworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReaderEDP2HistogramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSourceEDP2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSourceSensorFrameworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordinalMeasurementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nominalMeasurementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordinalIntervalsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueCorrelatedSeriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalCorrelatedSeriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jFreeChartPresentationViewFactoryEClass = null;

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
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PresentationPackageImpl() {
		super(eNS_URI, PresentationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PresentationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PresentationPackage init() {
		if (isInited) return (PresentationPackage)EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);

		// Obtain or create and register package
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PresentationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PresentationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UIPackageImpl theUIPackage = (UIPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UIPackage.eNS_URI) instanceof UIPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UIPackage.eNS_URI) : UIPackage.eINSTANCE);
		ExperimentDataPackageImpl theExperimentDataPackage = (ExperimentDataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI) instanceof ExperimentDataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI) : ExperimentDataPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		thePresentationPackage.createPackageContents();
		theUIPackage.createPackageContents();
		theExperimentDataPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		thePresentationPackage.initializePackageContents();
		theUIPackage.initializePackageContents();
		theExperimentDataPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePresentationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PresentationPackage.eNS_URI, thePresentationPackage);
		return thePresentationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJFreeChartView() {
		return jFreeChartViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataReader() {
		return dataReaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataReader_Configuration() {
		return (EReference)dataReaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataReader_DataSource() {
		return (EReference)dataReaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataReaderConfiguration() {
		return dataReaderConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSource() {
		return dataSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataSource_Data() {
		return (EAttribute)dataSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSource_Description() {
		return (EReference)dataSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSource_MetricDescription() {
		return (EReference)dataSourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDataSourceDescription() {
		return iDataSourceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDataSourceDescription_Registry() {
		return (EAttribute)iDataSourceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRView() {
		return rViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistogram() {
		return histogramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBar() {
		return barEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCumulativeDistributionFunction() {
		return cumulativeDistributionFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPie() {
		return pieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLine() {
		return lineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoint() {
		return pointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoxplot() {
		return boxplotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEditorInput() {
		return iEditorInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDP2DataSourceDescription() {
		return edp2DataSourceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDP2DataSourceDescription_DataSeries() {
		return (EReference)edp2DataSourceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensorFrameworkDataSourceDescription() {
		return sensorFrameworkDataSourceDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSensorFrameworkDataSourceDescription_Sam() {
		return (EAttribute)sensorFrameworkDataSourceDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJFreeChartHistogramView() {
		return jFreeChartHistogramViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistogramView() {
		return histogramViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJFreeChartCumulativeDistributionView() {
		return jFreeChartCumulativeDistributionViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJFreeChartLineView() {
		return jFreeChartLineViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnhancedHistogram() {
		return enhancedHistogramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataReaderEDP2() {
		return dataReaderEDP2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataReaderSensorFramework() {
		return dataReaderSensorFrameworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataReaderEDP2Histogram() {
		return dataReaderEDP2HistogramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSourceEDP2() {
		return dataSourceEDP2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataSourceEDP2_Registry() {
		return (EAttribute)dataSourceEDP2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSourceSensorFramework() {
		return dataSourceSensorFrameworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrdinalMeasurementsType() {
		return ordinalMeasurementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNominalMeasurementsType() {
		return nominalMeasurementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrdinalIntervalsType() {
		return ordinalIntervalsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrdinalIntervalsType_AllIntervalWidthsEqual() {
		return (EAttribute)ordinalIntervalsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueCorrelatedSeries() {
		return valueCorrelatedSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntervalCorrelatedSeries() {
		return intervalCorrelatedSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJFreeChartPresentationViewFactory() {
		return jFreeChartPresentationViewFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJFreeChartPresentationViewFactory_Generates() {
		return (EReference)jFreeChartPresentationViewFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationFactory getPresentationFactory() {
		return (PresentationFactory)getEFactoryInstance();
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
		jFreeChartViewEClass = createEClass(JFREE_CHART_VIEW);

		dataReaderEClass = createEClass(DATA_READER);
		createEReference(dataReaderEClass, DATA_READER__CONFIGURATION);
		createEReference(dataReaderEClass, DATA_READER__DATA_SOURCE);

		dataReaderConfigurationEClass = createEClass(DATA_READER_CONFIGURATION);

		dataSourceEClass = createEClass(DATA_SOURCE);
		createEAttribute(dataSourceEClass, DATA_SOURCE__DATA);
		createEReference(dataSourceEClass, DATA_SOURCE__DESCRIPTION);
		createEReference(dataSourceEClass, DATA_SOURCE__METRIC_DESCRIPTION);

		iDataSourceDescriptionEClass = createEClass(IDATA_SOURCE_DESCRIPTION);
		createEAttribute(iDataSourceDescriptionEClass, IDATA_SOURCE_DESCRIPTION__REGISTRY);

		rViewEClass = createEClass(RVIEW);

		histogramEClass = createEClass(HISTOGRAM);

		barEClass = createEClass(BAR);

		cumulativeDistributionFunctionEClass = createEClass(CUMULATIVE_DISTRIBUTION_FUNCTION);

		pieEClass = createEClass(PIE);

		lineEClass = createEClass(LINE);

		pointEClass = createEClass(POINT);

		boxplotEClass = createEClass(BOXPLOT);

		iEditorInputEClass = createEClass(IEDITOR_INPUT);

		edp2DataSourceDescriptionEClass = createEClass(EDP2_DATA_SOURCE_DESCRIPTION);
		createEReference(edp2DataSourceDescriptionEClass, EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES);

		sensorFrameworkDataSourceDescriptionEClass = createEClass(SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION);
		createEAttribute(sensorFrameworkDataSourceDescriptionEClass, SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM);

		jFreeChartHistogramViewEClass = createEClass(JFREE_CHART_HISTOGRAM_VIEW);

		histogramViewEClass = createEClass(HISTOGRAM_VIEW);

		jFreeChartCumulativeDistributionViewEClass = createEClass(JFREE_CHART_CUMULATIVE_DISTRIBUTION_VIEW);

		jFreeChartLineViewEClass = createEClass(JFREE_CHART_LINE_VIEW);

		stateEClass = createEClass(STATE);

		enhancedHistogramEClass = createEClass(ENHANCED_HISTOGRAM);

		dataReaderEDP2EClass = createEClass(DATA_READER_EDP2);

		dataReaderSensorFrameworkEClass = createEClass(DATA_READER_SENSOR_FRAMEWORK);

		dataReaderEDP2HistogramEClass = createEClass(DATA_READER_EDP2_HISTOGRAM);

		dataSourceEDP2EClass = createEClass(DATA_SOURCE_EDP2);
		createEAttribute(dataSourceEDP2EClass, DATA_SOURCE_EDP2__REGISTRY);

		dataSourceSensorFrameworkEClass = createEClass(DATA_SOURCE_SENSOR_FRAMEWORK);

		dataTypeEClass = createEClass(DATA_TYPE);

		ordinalMeasurementsTypeEClass = createEClass(ORDINAL_MEASUREMENTS_TYPE);

		nominalMeasurementsTypeEClass = createEClass(NOMINAL_MEASUREMENTS_TYPE);

		ordinalIntervalsTypeEClass = createEClass(ORDINAL_INTERVALS_TYPE);
		createEAttribute(ordinalIntervalsTypeEClass, ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL);

		valueCorrelatedSeriesEClass = createEClass(VALUE_CORRELATED_SERIES);

		intervalCorrelatedSeriesEClass = createEClass(INTERVAL_CORRELATED_SERIES);

		jFreeChartPresentationViewFactoryEClass = createEClass(JFREE_CHART_PRESENTATION_VIEW_FACTORY);
		createEReference(jFreeChartPresentationViewFactoryEClass, JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES);
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
		UIPackage theUIPackage = (UIPackage)EPackage.Registry.INSTANCE.getEPackage(UIPackage.eNS_URI);
		ExperimentDataPackage theExperimentDataPackage = (ExperimentDataPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theUIPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		jFreeChartViewEClass.getESuperTypes().add(theUIPackage.getPresentationView());
		rViewEClass.getESuperTypes().add(theUIPackage.getPresentationView());
		histogramEClass.getESuperTypes().add(theUIPackage.getPresentationType());
		barEClass.getESuperTypes().add(theUIPackage.getPresentationType());
		cumulativeDistributionFunctionEClass.getESuperTypes().add(theUIPackage.getPresentationType());
		pieEClass.getESuperTypes().add(theUIPackage.getPresentationType());
		lineEClass.getESuperTypes().add(theUIPackage.getPresentationType());
		pointEClass.getESuperTypes().add(theUIPackage.getPresentationType());
		boxplotEClass.getESuperTypes().add(theUIPackage.getPresentationType());
		jFreeChartHistogramViewEClass.getESuperTypes().add(this.getHistogramView());
		enhancedHistogramEClass.getESuperTypes().add(this.getHistogram());
		dataReaderEDP2EClass.getESuperTypes().add(this.getDataReader());
		dataReaderSensorFrameworkEClass.getESuperTypes().add(this.getDataReader());
		dataReaderEDP2HistogramEClass.getESuperTypes().add(this.getDataReaderEDP2());
		dataSourceEDP2EClass.getESuperTypes().add(this.getDataSource());
		dataSourceSensorFrameworkEClass.getESuperTypes().add(this.getDataSource());
		ordinalMeasurementsTypeEClass.getESuperTypes().add(this.getDataType());
		nominalMeasurementsTypeEClass.getESuperTypes().add(this.getDataType());
		ordinalIntervalsTypeEClass.getESuperTypes().add(this.getDataType());

		// Initialize classes and features; add operations and parameters
		initEClass(jFreeChartViewEClass, JFreeChartView.class, "JFreeChartView", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataReaderEClass, DataReader.class, "DataReader", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataReader_Configuration(), this.getDataReaderConfiguration(), null, "configuration", null, 0, -1, DataReader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataReader_DataSource(), this.getDataSource(), null, "dataSource", null, 1, 1, DataReader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataReaderConfigurationEClass, DataReaderConfiguration.class, "DataReaderConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataSourceEClass, DataSource.class, "DataSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataSource_Data(), theExperimentDataPackage.getDataType(), "data", null, 1, 1, DataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataSource_Description(), this.getIDataSourceDescription(), null, "description", null, 1, 1, DataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataSource_MetricDescription(), theExperimentDataPackage.getBaseMetricDescription(), null, "metricDescription", null, 1, 1, DataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(iDataSourceDescriptionEClass, IDataSourceDescription.class, "IDataSourceDescription", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIDataSourceDescription_Registry(), ecorePackage.getEString(), "registry", null, 1, 1, IDataSourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rViewEClass, RView.class, "RView", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(histogramEClass, Histogram.class, "Histogram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(barEClass, Bar.class, "Bar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cumulativeDistributionFunctionEClass, CumulativeDistributionFunction.class, "CumulativeDistributionFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pieEClass, Pie.class, "Pie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pointEClass, Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boxplotEClass, Boxplot.class, "Boxplot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iEditorInputEClass, IEditorInput.class, "IEditorInput", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(edp2DataSourceDescriptionEClass, EDP2DataSourceDescription.class, "EDP2DataSourceDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDP2DataSourceDescription_DataSeries(), theExperimentDataPackage.getDataSeries(), null, "dataSeries", null, 1, 1, EDP2DataSourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorFrameworkDataSourceDescriptionEClass, SensorFrameworkDataSourceDescription.class, "SensorFrameworkDataSourceDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSensorFrameworkDataSourceDescription_Sam(), ecorePackage.getEString(), "sam", null, 1, 1, SensorFrameworkDataSourceDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jFreeChartHistogramViewEClass, JFreeChartHistogramView.class, "JFreeChartHistogramView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(histogramViewEClass, HistogramView.class, "HistogramView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jFreeChartCumulativeDistributionViewEClass, JFreeChartCumulativeDistributionView.class, "JFreeChartCumulativeDistributionView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jFreeChartLineViewEClass, JFreeChartLineView.class, "JFreeChartLineView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enhancedHistogramEClass, EnhancedHistogram.class, "EnhancedHistogram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataReaderEDP2EClass, DataReaderEDP2.class, "DataReaderEDP2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataReaderSensorFrameworkEClass, DataReaderSensorFramework.class, "DataReaderSensorFramework", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataReaderEDP2HistogramEClass, DataReaderEDP2Histogram.class, "DataReaderEDP2Histogram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataSourceEDP2EClass, DataSourceEDP2.class, "DataSourceEDP2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataSourceEDP2_Registry(), ecorePackage.getEString(), "registry", null, 1, 1, DataSourceEDP2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataSourceSensorFrameworkEClass, DataSourceSensorFramework.class, "DataSourceSensorFramework", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ordinalMeasurementsTypeEClass, OrdinalMeasurementsType.class, "OrdinalMeasurementsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nominalMeasurementsTypeEClass, NominalMeasurementsType.class, "NominalMeasurementsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ordinalIntervalsTypeEClass, OrdinalIntervalsType.class, "OrdinalIntervalsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrdinalIntervalsType_AllIntervalWidthsEqual(), ecorePackage.getEBoolean(), "allIntervalWidthsEqual", null, 1, 1, OrdinalIntervalsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(ordinalIntervalsTypeEClass, null, "getBeginOfInterval", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(ordinalIntervalsTypeEClass, null, "getWidthOfInterval", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "I", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(ordinalIntervalsTypeEClass, null, "getNumberOfIntervals", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(valueCorrelatedSeriesEClass, ValueCorrelatedSeries.class, "ValueCorrelatedSeries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intervalCorrelatedSeriesEClass, IntervalCorrelatedSeries.class, "IntervalCorrelatedSeries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jFreeChartPresentationViewFactoryEClass, JFreeChartPresentationViewFactory.class, "JFreeChartPresentationViewFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJFreeChartPresentationViewFactory_Generates(), this.getJFreeChartHistogramView(), null, "generates", null, 0, 1, JFreeChartPresentationViewFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";		
		addAnnotation
		  (dataReaderConfigurationEClass, 
		   source, 
		   new String[] {
			 "persistable", null
		   });			
		addAnnotation
		  (iDataSourceDescriptionEClass, 
		   source, 
		   new String[] {
			 "interface", null,
			 "persistable", null
		   });			
		addAnnotation
		  (iEditorInputEClass, 
		   source, 
		   new String[] {
			 "interface", null,
			 "persistable", null
		   });	
	}

} //PresentationPackageImpl
