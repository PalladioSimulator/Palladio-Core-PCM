/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.impl;

import de.uka.ipd.sdq.edp2.models.Presentation.*;

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
public class PresentationFactoryImpl extends EFactoryImpl implements PresentationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PresentationFactory init() {
		try {
			PresentationFactory thePresentationFactory = (PresentationFactory)EPackage.Registry.INSTANCE.getEFactory("http:///EDP2/Presentation.ecore"); 
			if (thePresentationFactory != null) {
				return thePresentationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PresentationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationFactoryImpl() {
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
			case PresentationPackage.DATA_READER_CONFIGURATION: return createDataReaderConfiguration();
			case PresentationPackage.DATA_SOURCE: return createDataSource();
			case PresentationPackage.HISTOGRAM: return createHistogram();
			case PresentationPackage.BAR: return createBar();
			case PresentationPackage.CUMULATIVE_DISTRIBUTION_FUNCTION: return createCumulativeDistributionFunction();
			case PresentationPackage.PIE: return createPie();
			case PresentationPackage.LINE: return createLine();
			case PresentationPackage.POINT: return createPoint();
			case PresentationPackage.BOXPLOT: return createBoxplot();
			case PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION: return createEDP2DataSourceDescription();
			case PresentationPackage.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION: return createSensorFrameworkDataSourceDescription();
			case PresentationPackage.JFREE_CHART_HISTOGRAM_VIEW: return createJFreeChartHistogramView();
			case PresentationPackage.HISTOGRAM_VIEW: return createHistogramView();
			case PresentationPackage.JFREE_CHART_CUMULATIVE_DISTRIBUTION_VIEW: return createJFreeChartCumulativeDistributionView();
			case PresentationPackage.JFREE_CHART_LINE_VIEW: return createJFreeChartLineView();
			case PresentationPackage.STATE: return createState();
			case PresentationPackage.ENHANCED_HISTOGRAM: return createEnhancedHistogram();
			case PresentationPackage.DATA_READER_EDP2: return createDataReaderEDP2();
			case PresentationPackage.DATA_READER_SENSOR_FRAMEWORK: return createDataReaderSensorFramework();
			case PresentationPackage.DATA_READER_EDP2_HISTOGRAM: return createDataReaderEDP2Histogram();
			case PresentationPackage.DATA_SOURCE_EDP2: return createDataSourceEDP2();
			case PresentationPackage.DATA_SOURCE_SENSOR_FRAMEWORK: return createDataSourceSensorFramework();
			case PresentationPackage.ORDINAL_MEASUREMENTS_TYPE: return createOrdinalMeasurementsType();
			case PresentationPackage.NOMINAL_MEASUREMENTS_TYPE: return createNominalMeasurementsType();
			case PresentationPackage.ORDINAL_INTERVALS_TYPE: return createOrdinalIntervalsType();
			case PresentationPackage.VALUE_CORRELATED_SERIES: return createValueCorrelatedSeries();
			case PresentationPackage.INTERVAL_CORRELATED_SERIES: return createIntervalCorrelatedSeries();
			case PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY: return createJFreeChartPresentationViewFactory();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataReaderConfiguration createDataReaderConfiguration() {
		DataReaderConfigurationImpl dataReaderConfiguration = new DataReaderConfigurationImpl();
		return dataReaderConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSource createDataSource() {
		DataSourceImpl dataSource = new DataSourceImpl();
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Histogram createHistogram() {
		HistogramImpl histogram = new HistogramImpl();
		return histogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bar createBar() {
		BarImpl bar = new BarImpl();
		return bar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CumulativeDistributionFunction createCumulativeDistributionFunction() {
		CumulativeDistributionFunctionImpl cumulativeDistributionFunction = new CumulativeDistributionFunctionImpl();
		return cumulativeDistributionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pie createPie() {
		PieImpl pie = new PieImpl();
		return pie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Line createLine() {
		LineImpl line = new LineImpl();
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boxplot createBoxplot() {
		BoxplotImpl boxplot = new BoxplotImpl();
		return boxplot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDP2DataSourceDescription createEDP2DataSourceDescription() {
		EDP2DataSourceDescriptionImpl edp2DataSourceDescription = new EDP2DataSourceDescriptionImpl();
		return edp2DataSourceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorFrameworkDataSourceDescription createSensorFrameworkDataSourceDescription() {
		SensorFrameworkDataSourceDescriptionImpl sensorFrameworkDataSourceDescription = new SensorFrameworkDataSourceDescriptionImpl();
		return sensorFrameworkDataSourceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFreeChartHistogramView createJFreeChartHistogramView() {
		JFreeChartHistogramViewImpl jFreeChartHistogramView = new JFreeChartHistogramViewImpl();
		return jFreeChartHistogramView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HistogramView createHistogramView() {
		HistogramViewImpl histogramView = new HistogramViewImpl();
		return histogramView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFreeChartCumulativeDistributionView createJFreeChartCumulativeDistributionView() {
		JFreeChartCumulativeDistributionViewImpl jFreeChartCumulativeDistributionView = new JFreeChartCumulativeDistributionViewImpl();
		return jFreeChartCumulativeDistributionView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFreeChartLineView createJFreeChartLineView() {
		JFreeChartLineViewImpl jFreeChartLineView = new JFreeChartLineViewImpl();
		return jFreeChartLineView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnhancedHistogram createEnhancedHistogram() {
		EnhancedHistogramImpl enhancedHistogram = new EnhancedHistogramImpl();
		return enhancedHistogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataReaderEDP2 createDataReaderEDP2() {
		DataReaderEDP2Impl dataReaderEDP2 = new DataReaderEDP2Impl();
		return dataReaderEDP2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataReaderSensorFramework createDataReaderSensorFramework() {
		DataReaderSensorFrameworkImpl dataReaderSensorFramework = new DataReaderSensorFrameworkImpl();
		return dataReaderSensorFramework;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataReaderEDP2Histogram createDataReaderEDP2Histogram() {
		DataReaderEDP2HistogramImpl dataReaderEDP2Histogram = new DataReaderEDP2HistogramImpl();
		return dataReaderEDP2Histogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceEDP2 createDataSourceEDP2() {
		DataSourceEDP2Impl dataSourceEDP2 = new DataSourceEDP2Impl();
		return dataSourceEDP2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceSensorFramework createDataSourceSensorFramework() {
		DataSourceSensorFrameworkImpl dataSourceSensorFramework = new DataSourceSensorFrameworkImpl();
		return dataSourceSensorFramework;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdinalMeasurementsType createOrdinalMeasurementsType() {
		OrdinalMeasurementsTypeImpl ordinalMeasurementsType = new OrdinalMeasurementsTypeImpl();
		return ordinalMeasurementsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalMeasurementsType createNominalMeasurementsType() {
		NominalMeasurementsTypeImpl nominalMeasurementsType = new NominalMeasurementsTypeImpl();
		return nominalMeasurementsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdinalIntervalsType createOrdinalIntervalsType() {
		OrdinalIntervalsTypeImpl ordinalIntervalsType = new OrdinalIntervalsTypeImpl();
		return ordinalIntervalsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueCorrelatedSeries createValueCorrelatedSeries() {
		ValueCorrelatedSeriesImpl valueCorrelatedSeries = new ValueCorrelatedSeriesImpl();
		return valueCorrelatedSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntervalCorrelatedSeries createIntervalCorrelatedSeries() {
		IntervalCorrelatedSeriesImpl intervalCorrelatedSeries = new IntervalCorrelatedSeriesImpl();
		return intervalCorrelatedSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFreeChartPresentationViewFactory createJFreeChartPresentationViewFactory() {
		JFreeChartPresentationViewFactoryImpl jFreeChartPresentationViewFactory = new JFreeChartPresentationViewFactoryImpl();
		return jFreeChartPresentationViewFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationPackage getPresentationPackage() {
		return (PresentationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PresentationPackage getPackage() {
		return PresentationPackage.eINSTANCE;
	}

} //PresentationFactoryImpl
