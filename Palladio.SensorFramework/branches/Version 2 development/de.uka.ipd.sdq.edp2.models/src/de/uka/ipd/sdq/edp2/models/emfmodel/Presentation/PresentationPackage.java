/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationFactory
 * @model kind="package"
 * @generated
 */
public interface PresentationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Presentation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///EDP2/Presentation.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EDP2.Presentation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PresentationPackage eINSTANCE = de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartViewImpl <em>JFree Chart View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartView()
	 * @generated
	 */
	int JFREE_CHART_VIEW = 0;

	/**
	 * The number of structural features of the '<em>JFree Chart View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFREE_CHART_VIEW_FEATURE_COUNT = UIPackage.PRESENTATION_VIEW_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderImpl <em>Data Reader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReader()
	 * @generated
	 */
	int DATA_READER = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderConfigurationImpl <em>Data Reader Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderConfigurationImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderConfiguration()
	 * @generated
	 */
	int DATA_READER_CONFIGURATION = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceImpl <em>Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataSource()
	 * @generated
	 */
	int DATA_SOURCE = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription <em>IData Source Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getIDataSourceDescription()
	 * @generated
	 */
	int IDATA_SOURCE_DESCRIPTION = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.RViewImpl <em>RView</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.RViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getRView()
	 * @generated
	 */
	int RVIEW = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramImpl <em>Histogram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getHistogram()
	 * @generated
	 */
	int HISTOGRAM = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BarImpl <em>Bar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BarImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getBar()
	 * @generated
	 */
	int BAR = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.CumulativeDistributionFunctionImpl <em>Cumulative Distribution Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.CumulativeDistributionFunctionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getCumulativeDistributionFunction()
	 * @generated
	 */
	int CUMULATIVE_DISTRIBUTION_FUNCTION = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PieImpl <em>Pie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PieImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getPie()
	 * @generated
	 */
	int PIE = 9;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.LineImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getLine()
	 * @generated
	 */
	int LINE = 10;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PointImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 11;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BoxplotImpl <em>Boxplot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BoxplotImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getBoxplot()
	 * @generated
	 */
	int BOXPLOT = 12;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput <em>IEditor Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getIEditorInput()
	 * @generated
	 */
	int IEDITOR_INPUT = 13;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EDP2DataSourceDescriptionImpl <em>EDP2 Data Source Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EDP2DataSourceDescriptionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getEDP2DataSourceDescription()
	 * @generated
	 */
	int EDP2_DATA_SOURCE_DESCRIPTION = 14;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.SensorFrameworkDataSourceDescriptionImpl <em>Sensor Framework Data Source Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.SensorFrameworkDataSourceDescriptionImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getSensorFrameworkDataSourceDescription()
	 * @generated
	 */
	int SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION = 15;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER__DATA_SOURCE = 1;

	/**
	 * The number of structural features of the '<em>Data Reader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_FEATURE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Data Reader Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__DATA = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Metric Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__METRIC_DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Registry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDATA_SOURCE_DESCRIPTION__REGISTRY = 0;

	/**
	 * The number of structural features of the '<em>IData Source Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDATA_SOURCE_DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The number of structural features of the '<em>RView</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RVIEW_FEATURE_COUNT = UIPackage.PRESENTATION_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Histogram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTOGRAM_FEATURE_COUNT = UIPackage.PRESENTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAR_FEATURE_COUNT = UIPackage.PRESENTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cumulative Distribution Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUMULATIVE_DISTRIBUTION_FUNCTION_FEATURE_COUNT = UIPackage.PRESENTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIE_FEATURE_COUNT = UIPackage.PRESENTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_FEATURE_COUNT = UIPackage.PRESENTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = UIPackage.PRESENTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boxplot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXPLOT_FEATURE_COUNT = UIPackage.PRESENTATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IEditor Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEDITOR_INPUT_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Data Series</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES = 0;

	/**
	 * The number of structural features of the '<em>EDP2 Data Source Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_DATA_SOURCE_DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Sam</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM = 0;

	/**
	 * The number of structural features of the '<em>Sensor Framework Data Source Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramViewImpl <em>Histogram View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getHistogramView()
	 * @generated
	 */
	int HISTOGRAM_VIEW = 17;

	/**
	 * The number of structural features of the '<em>Histogram View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTOGRAM_VIEW_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartHistogramViewImpl <em>JFree Chart Histogram View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartHistogramViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartHistogramView()
	 * @generated
	 */
	int JFREE_CHART_HISTOGRAM_VIEW = 16;

	/**
	 * The number of structural features of the '<em>JFree Chart Histogram View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFREE_CHART_HISTOGRAM_VIEW_FEATURE_COUNT = HISTOGRAM_VIEW_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartCumulativeDistributionViewImpl <em>JFree Chart Cumulative Distribution View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartCumulativeDistributionViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartCumulativeDistributionView()
	 * @generated
	 */
	int JFREE_CHART_CUMULATIVE_DISTRIBUTION_VIEW = 18;

	/**
	 * The number of structural features of the '<em>JFree Chart Cumulative Distribution View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFREE_CHART_CUMULATIVE_DISTRIBUTION_VIEW_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartLineViewImpl <em>JFree Chart Line View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartLineViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartLineView()
	 * @generated
	 */
	int JFREE_CHART_LINE_VIEW = 19;

	/**
	 * The number of structural features of the '<em>JFree Chart Line View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFREE_CHART_LINE_VIEW_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.StateImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getState()
	 * @generated
	 */
	int STATE = 20;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EnhancedHistogramImpl <em>Enhanced Histogram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EnhancedHistogramImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getEnhancedHistogram()
	 * @generated
	 */
	int ENHANCED_HISTOGRAM = 21;

	/**
	 * The number of structural features of the '<em>Enhanced Histogram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENHANCED_HISTOGRAM_FEATURE_COUNT = HISTOGRAM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2Impl <em>Data Reader EDP2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2Impl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderEDP2()
	 * @generated
	 */
	int DATA_READER_EDP2 = 22;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_EDP2__CONFIGURATION = DATA_READER__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_EDP2__DATA_SOURCE = DATA_READER__DATA_SOURCE;

	/**
	 * The number of structural features of the '<em>Data Reader EDP2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_EDP2_FEATURE_COUNT = DATA_READER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderSensorFrameworkImpl <em>Data Reader Sensor Framework</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderSensorFrameworkImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderSensorFramework()
	 * @generated
	 */
	int DATA_READER_SENSOR_FRAMEWORK = 23;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_SENSOR_FRAMEWORK__CONFIGURATION = DATA_READER__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_SENSOR_FRAMEWORK__DATA_SOURCE = DATA_READER__DATA_SOURCE;

	/**
	 * The number of structural features of the '<em>Data Reader Sensor Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_SENSOR_FRAMEWORK_FEATURE_COUNT = DATA_READER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2HistogramImpl <em>Data Reader EDP2 Histogram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2HistogramImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderEDP2Histogram()
	 * @generated
	 */
	int DATA_READER_EDP2_HISTOGRAM = 24;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_EDP2_HISTOGRAM__CONFIGURATION = DATA_READER_EDP2__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_EDP2_HISTOGRAM__DATA_SOURCE = DATA_READER_EDP2__DATA_SOURCE;

	/**
	 * The number of structural features of the '<em>Data Reader EDP2 Histogram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_EDP2_HISTOGRAM_FEATURE_COUNT = DATA_READER_EDP2_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceEDP2Impl <em>Data Source EDP2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceEDP2Impl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataSourceEDP2()
	 * @generated
	 */
	int DATA_SOURCE_EDP2 = 25;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_EDP2__DATA = DATA_SOURCE__DATA;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_EDP2__DESCRIPTION = DATA_SOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Metric Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_EDP2__METRIC_DESCRIPTION = DATA_SOURCE__METRIC_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Registry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_EDP2__REGISTRY = DATA_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Source EDP2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_EDP2_FEATURE_COUNT = DATA_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceSensorFrameworkImpl <em>Data Source Sensor Framework</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceSensorFrameworkImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataSourceSensorFramework()
	 * @generated
	 */
	int DATA_SOURCE_SENSOR_FRAMEWORK = 26;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SENSOR_FRAMEWORK__DATA = DATA_SOURCE__DATA;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SENSOR_FRAMEWORK__DESCRIPTION = DATA_SOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Metric Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SENSOR_FRAMEWORK__METRIC_DESCRIPTION = DATA_SOURCE__METRIC_DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Data Source Sensor Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_SENSOR_FRAMEWORK_FEATURE_COUNT = DATA_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataTypeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 27;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalMeasurementsTypeImpl <em>Ordinal Measurements Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalMeasurementsTypeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getOrdinalMeasurementsType()
	 * @generated
	 */
	int ORDINAL_MEASUREMENTS_TYPE = 28;

	/**
	 * The number of structural features of the '<em>Ordinal Measurements Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_MEASUREMENTS_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.NominalMeasurementsTypeImpl <em>Nominal Measurements Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.NominalMeasurementsTypeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getNominalMeasurementsType()
	 * @generated
	 */
	int NOMINAL_MEASUREMENTS_TYPE = 29;

	/**
	 * The number of structural features of the '<em>Nominal Measurements Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_MEASUREMENTS_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalIntervalsTypeImpl <em>Ordinal Intervals Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalIntervalsTypeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getOrdinalIntervalsType()
	 * @generated
	 */
	int ORDINAL_INTERVALS_TYPE = 30;

	/**
	 * The feature id for the '<em><b>All Interval Widths Equal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordinal Intervals Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_INTERVALS_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.ValueCorrelatedSeriesImpl <em>Value Correlated Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.ValueCorrelatedSeriesImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getValueCorrelatedSeries()
	 * @generated
	 */
	int VALUE_CORRELATED_SERIES = 31;

	/**
	 * The number of structural features of the '<em>Value Correlated Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CORRELATED_SERIES_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.IntervalCorrelatedSeriesImpl <em>Interval Correlated Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.IntervalCorrelatedSeriesImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getIntervalCorrelatedSeries()
	 * @generated
	 */
	int INTERVAL_CORRELATED_SERIES = 32;

	/**
	 * The number of structural features of the '<em>Interval Correlated Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_CORRELATED_SERIES_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartPresentationViewFactoryImpl <em>JFree Chart Presentation View Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartPresentationViewFactoryImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartPresentationViewFactory()
	 * @generated
	 */
	int JFREE_CHART_PRESENTATION_VIEW_FACTORY = 33;

	/**
	 * The feature id for the '<em><b>Generates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES = 0;

	/**
	 * The number of structural features of the '<em>JFree Chart Presentation View Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFREE_CHART_PRESENTATION_VIEW_FACTORY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartView <em>JFree Chart View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JFree Chart View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartView
	 * @generated
	 */
	EClass getJFreeChartView();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader <em>Data Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reader</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader
	 * @generated
	 */
	EClass getDataReader();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configuration</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader#getConfiguration()
	 * @see #getDataReader()
	 * @generated
	 */
	EReference getDataReader_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Source</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader#getDataSource()
	 * @see #getDataReader()
	 * @generated
	 */
	EReference getDataReader_DataSource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderConfiguration <em>Data Reader Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reader Configuration</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderConfiguration
	 * @generated
	 */
	EClass getDataReaderConfiguration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource
	 * @generated
	 */
	EClass getDataSource();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getData()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_Data();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getDescription()
	 * @see #getDataSource()
	 * @generated
	 */
	EReference getDataSource_Description();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getMetricDescription <em>Metric Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getMetricDescription()
	 * @see #getDataSource()
	 * @generated
	 */
	EReference getDataSource_MetricDescription();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription <em>IData Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IData Source Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription
	 * @generated
	 */
	EClass getIDataSourceDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription#getRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registry</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription#getRegistry()
	 * @see #getIDataSourceDescription()
	 * @generated
	 */
	EAttribute getIDataSourceDescription_Registry();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.RView <em>RView</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RView</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.RView
	 * @generated
	 */
	EClass getRView();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Histogram <em>Histogram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Histogram</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Histogram
	 * @generated
	 */
	EClass getHistogram();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Bar <em>Bar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bar</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Bar
	 * @generated
	 */
	EClass getBar();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.CumulativeDistributionFunction <em>Cumulative Distribution Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cumulative Distribution Function</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.CumulativeDistributionFunction
	 * @generated
	 */
	EClass getCumulativeDistributionFunction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Pie <em>Pie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pie</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Pie
	 * @generated
	 */
	EClass getPie();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Line
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Boxplot <em>Boxplot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boxplot</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Boxplot
	 * @generated
	 */
	EClass getBoxplot();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput <em>IEditor Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEditor Input</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput
	 * @generated
	 */
	EClass getIEditorInput();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription <em>EDP2 Data Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDP2 Data Source Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription
	 * @generated
	 */
	EClass getEDP2DataSourceDescription();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription#getDataSeries <em>Data Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Series</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription#getDataSeries()
	 * @see #getEDP2DataSourceDescription()
	 * @generated
	 */
	EReference getEDP2DataSourceDescription_DataSeries();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.SensorFrameworkDataSourceDescription <em>Sensor Framework Data Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Framework Data Source Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.SensorFrameworkDataSourceDescription
	 * @generated
	 */
	EClass getSensorFrameworkDataSourceDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.SensorFrameworkDataSourceDescription#getSam <em>Sam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sam</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.SensorFrameworkDataSourceDescription#getSam()
	 * @see #getSensorFrameworkDataSourceDescription()
	 * @generated
	 */
	EAttribute getSensorFrameworkDataSourceDescription_Sam();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartHistogramView <em>JFree Chart Histogram View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JFree Chart Histogram View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartHistogramView
	 * @generated
	 */
	EClass getJFreeChartHistogramView();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.HistogramView <em>Histogram View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Histogram View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.HistogramView
	 * @generated
	 */
	EClass getHistogramView();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartCumulativeDistributionView <em>JFree Chart Cumulative Distribution View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JFree Chart Cumulative Distribution View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartCumulativeDistributionView
	 * @generated
	 */
	EClass getJFreeChartCumulativeDistributionView();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartLineView <em>JFree Chart Line View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JFree Chart Line View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartLineView
	 * @generated
	 */
	EClass getJFreeChartLineView();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EnhancedHistogram <em>Enhanced Histogram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enhanced Histogram</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EnhancedHistogram
	 * @generated
	 */
	EClass getEnhancedHistogram();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2 <em>Data Reader EDP2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reader EDP2</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2
	 * @generated
	 */
	EClass getDataReaderEDP2();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderSensorFramework <em>Data Reader Sensor Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reader Sensor Framework</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderSensorFramework
	 * @generated
	 */
	EClass getDataReaderSensorFramework();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2Histogram <em>Data Reader EDP2 Histogram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reader EDP2 Histogram</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2Histogram
	 * @generated
	 */
	EClass getDataReaderEDP2Histogram();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceEDP2 <em>Data Source EDP2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source EDP2</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceEDP2
	 * @generated
	 */
	EClass getDataSourceEDP2();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceEDP2#getRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registry</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceEDP2#getRegistry()
	 * @see #getDataSourceEDP2()
	 * @generated
	 */
	EAttribute getDataSourceEDP2_Registry();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceSensorFramework <em>Data Source Sensor Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source Sensor Framework</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceSensorFramework
	 * @generated
	 */
	EClass getDataSourceSensorFramework();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalMeasurementsType <em>Ordinal Measurements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordinal Measurements Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalMeasurementsType
	 * @generated
	 */
	EClass getOrdinalMeasurementsType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.NominalMeasurementsType <em>Nominal Measurements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nominal Measurements Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.NominalMeasurementsType
	 * @generated
	 */
	EClass getNominalMeasurementsType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType <em>Ordinal Intervals Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordinal Intervals Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType
	 * @generated
	 */
	EClass getOrdinalIntervalsType();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType#isAllIntervalWidthsEqual <em>All Interval Widths Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All Interval Widths Equal</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType#isAllIntervalWidthsEqual()
	 * @see #getOrdinalIntervalsType()
	 * @generated
	 */
	EAttribute getOrdinalIntervalsType_AllIntervalWidthsEqual();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.ValueCorrelatedSeries <em>Value Correlated Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Correlated Series</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.ValueCorrelatedSeries
	 * @generated
	 */
	EClass getValueCorrelatedSeries();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IntervalCorrelatedSeries <em>Interval Correlated Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval Correlated Series</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IntervalCorrelatedSeries
	 * @generated
	 */
	EClass getIntervalCorrelatedSeries();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory <em>JFree Chart Presentation View Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JFree Chart Presentation View Factory</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory
	 * @generated
	 */
	EClass getJFreeChartPresentationViewFactory();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory#getGenerates <em>Generates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generates</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory#getGenerates()
	 * @see #getJFreeChartPresentationViewFactory()
	 * @generated
	 */
	EReference getJFreeChartPresentationViewFactory_Generates();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PresentationFactory getPresentationFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartViewImpl <em>JFree Chart View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartView()
		 * @generated
		 */
		EClass JFREE_CHART_VIEW = eINSTANCE.getJFreeChartView();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderImpl <em>Data Reader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReader()
		 * @generated
		 */
		EClass DATA_READER = eINSTANCE.getDataReader();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_READER__CONFIGURATION = eINSTANCE.getDataReader_Configuration();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_READER__DATA_SOURCE = eINSTANCE.getDataReader_DataSource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderConfigurationImpl <em>Data Reader Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderConfigurationImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderConfiguration()
		 * @generated
		 */
		EClass DATA_READER_CONFIGURATION = eINSTANCE.getDataReaderConfiguration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceImpl <em>Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataSource()
		 * @generated
		 */
		EClass DATA_SOURCE = eINSTANCE.getDataSource();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__DATA = eINSTANCE.getDataSource_Data();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE__DESCRIPTION = eINSTANCE.getDataSource_Description();

		/**
		 * The meta object literal for the '<em><b>Metric Description</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE__METRIC_DESCRIPTION = eINSTANCE.getDataSource_MetricDescription();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription <em>IData Source Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getIDataSourceDescription()
		 * @generated
		 */
		EClass IDATA_SOURCE_DESCRIPTION = eINSTANCE.getIDataSourceDescription();

		/**
		 * The meta object literal for the '<em><b>Registry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDATA_SOURCE_DESCRIPTION__REGISTRY = eINSTANCE.getIDataSourceDescription_Registry();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.RViewImpl <em>RView</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.RViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getRView()
		 * @generated
		 */
		EClass RVIEW = eINSTANCE.getRView();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramImpl <em>Histogram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getHistogram()
		 * @generated
		 */
		EClass HISTOGRAM = eINSTANCE.getHistogram();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BarImpl <em>Bar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BarImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getBar()
		 * @generated
		 */
		EClass BAR = eINSTANCE.getBar();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.CumulativeDistributionFunctionImpl <em>Cumulative Distribution Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.CumulativeDistributionFunctionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getCumulativeDistributionFunction()
		 * @generated
		 */
		EClass CUMULATIVE_DISTRIBUTION_FUNCTION = eINSTANCE.getCumulativeDistributionFunction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PieImpl <em>Pie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PieImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getPie()
		 * @generated
		 */
		EClass PIE = eINSTANCE.getPie();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.LineImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getLine()
		 * @generated
		 */
		EClass LINE = eINSTANCE.getLine();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PointImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BoxplotImpl <em>Boxplot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.BoxplotImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getBoxplot()
		 * @generated
		 */
		EClass BOXPLOT = eINSTANCE.getBoxplot();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput <em>IEditor Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getIEditorInput()
		 * @generated
		 */
		EClass IEDITOR_INPUT = eINSTANCE.getIEditorInput();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EDP2DataSourceDescriptionImpl <em>EDP2 Data Source Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EDP2DataSourceDescriptionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getEDP2DataSourceDescription()
		 * @generated
		 */
		EClass EDP2_DATA_SOURCE_DESCRIPTION = eINSTANCE.getEDP2DataSourceDescription();

		/**
		 * The meta object literal for the '<em><b>Data Series</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES = eINSTANCE.getEDP2DataSourceDescription_DataSeries();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.SensorFrameworkDataSourceDescriptionImpl <em>Sensor Framework Data Source Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.SensorFrameworkDataSourceDescriptionImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getSensorFrameworkDataSourceDescription()
		 * @generated
		 */
		EClass SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION = eINSTANCE.getSensorFrameworkDataSourceDescription();

		/**
		 * The meta object literal for the '<em><b>Sam</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM = eINSTANCE.getSensorFrameworkDataSourceDescription_Sam();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartHistogramViewImpl <em>JFree Chart Histogram View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartHistogramViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartHistogramView()
		 * @generated
		 */
		EClass JFREE_CHART_HISTOGRAM_VIEW = eINSTANCE.getJFreeChartHistogramView();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramViewImpl <em>Histogram View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.HistogramViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getHistogramView()
		 * @generated
		 */
		EClass HISTOGRAM_VIEW = eINSTANCE.getHistogramView();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartCumulativeDistributionViewImpl <em>JFree Chart Cumulative Distribution View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartCumulativeDistributionViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartCumulativeDistributionView()
		 * @generated
		 */
		EClass JFREE_CHART_CUMULATIVE_DISTRIBUTION_VIEW = eINSTANCE.getJFreeChartCumulativeDistributionView();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartLineViewImpl <em>JFree Chart Line View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartLineViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartLineView()
		 * @generated
		 */
		EClass JFREE_CHART_LINE_VIEW = eINSTANCE.getJFreeChartLineView();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.StateImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EnhancedHistogramImpl <em>Enhanced Histogram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.EnhancedHistogramImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getEnhancedHistogram()
		 * @generated
		 */
		EClass ENHANCED_HISTOGRAM = eINSTANCE.getEnhancedHistogram();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2Impl <em>Data Reader EDP2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2Impl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderEDP2()
		 * @generated
		 */
		EClass DATA_READER_EDP2 = eINSTANCE.getDataReaderEDP2();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderSensorFrameworkImpl <em>Data Reader Sensor Framework</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderSensorFrameworkImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderSensorFramework()
		 * @generated
		 */
		EClass DATA_READER_SENSOR_FRAMEWORK = eINSTANCE.getDataReaderSensorFramework();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2HistogramImpl <em>Data Reader EDP2 Histogram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataReaderEDP2HistogramImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataReaderEDP2Histogram()
		 * @generated
		 */
		EClass DATA_READER_EDP2_HISTOGRAM = eINSTANCE.getDataReaderEDP2Histogram();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceEDP2Impl <em>Data Source EDP2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceEDP2Impl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataSourceEDP2()
		 * @generated
		 */
		EClass DATA_SOURCE_EDP2 = eINSTANCE.getDataSourceEDP2();

		/**
		 * The meta object literal for the '<em><b>Registry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE_EDP2__REGISTRY = eINSTANCE.getDataSourceEDP2_Registry();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceSensorFrameworkImpl <em>Data Source Sensor Framework</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataSourceSensorFrameworkImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataSourceSensorFramework()
		 * @generated
		 */
		EClass DATA_SOURCE_SENSOR_FRAMEWORK = eINSTANCE.getDataSourceSensorFramework();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.DataTypeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalMeasurementsTypeImpl <em>Ordinal Measurements Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalMeasurementsTypeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getOrdinalMeasurementsType()
		 * @generated
		 */
		EClass ORDINAL_MEASUREMENTS_TYPE = eINSTANCE.getOrdinalMeasurementsType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.NominalMeasurementsTypeImpl <em>Nominal Measurements Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.NominalMeasurementsTypeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getNominalMeasurementsType()
		 * @generated
		 */
		EClass NOMINAL_MEASUREMENTS_TYPE = eINSTANCE.getNominalMeasurementsType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalIntervalsTypeImpl <em>Ordinal Intervals Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalIntervalsTypeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getOrdinalIntervalsType()
		 * @generated
		 */
		EClass ORDINAL_INTERVALS_TYPE = eINSTANCE.getOrdinalIntervalsType();

		/**
		 * The meta object literal for the '<em><b>All Interval Widths Equal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL = eINSTANCE.getOrdinalIntervalsType_AllIntervalWidthsEqual();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.ValueCorrelatedSeriesImpl <em>Value Correlated Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.ValueCorrelatedSeriesImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getValueCorrelatedSeries()
		 * @generated
		 */
		EClass VALUE_CORRELATED_SERIES = eINSTANCE.getValueCorrelatedSeries();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.IntervalCorrelatedSeriesImpl <em>Interval Correlated Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.IntervalCorrelatedSeriesImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getIntervalCorrelatedSeries()
		 * @generated
		 */
		EClass INTERVAL_CORRELATED_SERIES = eINSTANCE.getIntervalCorrelatedSeries();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartPresentationViewFactoryImpl <em>JFree Chart Presentation View Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.JFreeChartPresentationViewFactoryImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl#getJFreeChartPresentationViewFactory()
		 * @generated
		 */
		EClass JFREE_CHART_PRESENTATION_VIEW_FACTORY = eINSTANCE.getJFreeChartPresentationViewFactory();

		/**
		 * The meta object literal for the '<em><b>Generates</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES = eINSTANCE.getJFreeChartPresentationViewFactory_Generates();

	}

} //PresentationPackage
