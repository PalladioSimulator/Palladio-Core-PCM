/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.util;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.*;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage
 * @generated
 */
public class PresentationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PresentationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PresentationPackage.eINSTANCE;
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
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationSwitch<Adapter> modelSwitch =
		new PresentationSwitch<Adapter>() {
			@Override
			public Adapter caseJFreeChartView(JFreeChartView object) {
				return createJFreeChartViewAdapter();
			}
			@Override
			public Adapter caseRView(RView object) {
				return createRViewAdapter();
			}
			@Override
			public Adapter caseHistogram(Histogram object) {
				return createHistogramAdapter();
			}
			@Override
			public Adapter caseBar(Bar object) {
				return createBarAdapter();
			}
			@Override
			public Adapter caseCumulativeDistributionFunction(CumulativeDistributionFunction object) {
				return createCumulativeDistributionFunctionAdapter();
			}
			@Override
			public Adapter casePie(Pie object) {
				return createPieAdapter();
			}
			@Override
			public Adapter caseLine(Line object) {
				return createLineAdapter();
			}
			@Override
			public Adapter casePoint(Point object) {
				return createPointAdapter();
			}
			@Override
			public Adapter caseBoxplot(Boxplot object) {
				return createBoxplotAdapter();
			}
			@Override
			public Adapter caseIEditorInput(IEditorInput object) {
				return createIEditorInputAdapter();
			}
			@Override
			public Adapter caseIDataSourceDescription(IDataSourceDescription object) {
				return createIDataSourceDescriptionAdapter();
			}
			@Override
			public Adapter caseEDP2DataSourceDescription(EDP2DataSourceDescription object) {
				return createEDP2DataSourceDescriptionAdapter();
			}
			@Override
			public Adapter caseSensorFrameworkDataSourceDescription(SensorFrameworkDataSourceDescription object) {
				return createSensorFrameworkDataSourceDescriptionAdapter();
			}
			@Override
			public Adapter caseDataReader(DataReader object) {
				return createDataReaderAdapter();
			}
			@Override
			public Adapter caseDataReaderConfiguration(DataReaderConfiguration object) {
				return createDataReaderConfigurationAdapter();
			}
			@Override
			public Adapter caseDataSource(DataSource object) {
				return createDataSourceAdapter();
			}
			@Override
			public Adapter caseJFreeChartHistogramView(JFreeChartHistogramView object) {
				return createJFreeChartHistogramViewAdapter();
			}
			@Override
			public Adapter caseHistogramView(HistogramView object) {
				return createHistogramViewAdapter();
			}
			@Override
			public Adapter caseJFreeChartCumulativeDistributionView(JFreeChartCumulativeDistributionView object) {
				return createJFreeChartCumulativeDistributionViewAdapter();
			}
			@Override
			public Adapter caseJFreeChartLineView(JFreeChartLineView object) {
				return createJFreeChartLineViewAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseEnhancedHistogram(EnhancedHistogram object) {
				return createEnhancedHistogramAdapter();
			}
			@Override
			public Adapter caseDataReaderEDP2(DataReaderEDP2 object) {
				return createDataReaderEDP2Adapter();
			}
			@Override
			public Adapter caseDataReaderSensorFramework(DataReaderSensorFramework object) {
				return createDataReaderSensorFrameworkAdapter();
			}
			@Override
			public Adapter caseDataReaderEDP2Histogram(DataReaderEDP2Histogram object) {
				return createDataReaderEDP2HistogramAdapter();
			}
			@Override
			public Adapter caseDataSourceEDP2(DataSourceEDP2 object) {
				return createDataSourceEDP2Adapter();
			}
			@Override
			public Adapter caseDataSourceSensorFramework(DataSourceSensorFramework object) {
				return createDataSourceSensorFrameworkAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseOrdinalMeasurementsType(OrdinalMeasurementsType object) {
				return createOrdinalMeasurementsTypeAdapter();
			}
			@Override
			public Adapter caseNominalMeasurementsType(NominalMeasurementsType object) {
				return createNominalMeasurementsTypeAdapter();
			}
			@Override
			public Adapter caseOrdinalIntervalsType(OrdinalIntervalsType object) {
				return createOrdinalIntervalsTypeAdapter();
			}
			@Override
			public Adapter caseValueCorrelatedSeries(ValueCorrelatedSeries object) {
				return createValueCorrelatedSeriesAdapter();
			}
			@Override
			public Adapter caseIntervalCorrelatedSeries(IntervalCorrelatedSeries object) {
				return createIntervalCorrelatedSeriesAdapter();
			}
			@Override
			public Adapter caseJFreeChartPresentationViewFactory(JFreeChartPresentationViewFactory object) {
				return createJFreeChartPresentationViewFactoryAdapter();
			}
			@Override
			public Adapter casePresentationView(PresentationView object) {
				return createPresentationViewAdapter();
			}
			@Override
			public Adapter casePresentationType(PresentationType object) {
				return createPresentationTypeAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartView <em>JFree Chart View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartView
	 * @generated
	 */
	public Adapter createJFreeChartViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader <em>Data Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReader
	 * @generated
	 */
	public Adapter createDataReaderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderConfiguration <em>Data Reader Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderConfiguration
	 * @generated
	 */
	public Adapter createDataReaderConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource
	 * @generated
	 */
	public Adapter createDataSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription <em>IData Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IDataSourceDescription
	 * @generated
	 */
	public Adapter createIDataSourceDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.RView <em>RView</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.RView
	 * @generated
	 */
	public Adapter createRViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Histogram <em>Histogram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Histogram
	 * @generated
	 */
	public Adapter createHistogramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Bar <em>Bar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Bar
	 * @generated
	 */
	public Adapter createBarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.CumulativeDistributionFunction <em>Cumulative Distribution Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.CumulativeDistributionFunction
	 * @generated
	 */
	public Adapter createCumulativeDistributionFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Pie <em>Pie</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Pie
	 * @generated
	 */
	public Adapter createPieAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Line
	 * @generated
	 */
	public Adapter createLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Point
	 * @generated
	 */
	public Adapter createPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Boxplot <em>Boxplot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.Boxplot
	 * @generated
	 */
	public Adapter createBoxplotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput <em>IEditor Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IEditorInput
	 * @generated
	 */
	public Adapter createIEditorInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription <em>EDP2 Data Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription
	 * @generated
	 */
	public Adapter createEDP2DataSourceDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.SensorFrameworkDataSourceDescription <em>Sensor Framework Data Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.SensorFrameworkDataSourceDescription
	 * @generated
	 */
	public Adapter createSensorFrameworkDataSourceDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartHistogramView <em>JFree Chart Histogram View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartHistogramView
	 * @generated
	 */
	public Adapter createJFreeChartHistogramViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.HistogramView <em>Histogram View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.HistogramView
	 * @generated
	 */
	public Adapter createHistogramViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartCumulativeDistributionView <em>JFree Chart Cumulative Distribution View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartCumulativeDistributionView
	 * @generated
	 */
	public Adapter createJFreeChartCumulativeDistributionViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartLineView <em>JFree Chart Line View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartLineView
	 * @generated
	 */
	public Adapter createJFreeChartLineViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EnhancedHistogram <em>Enhanced Histogram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EnhancedHistogram
	 * @generated
	 */
	public Adapter createEnhancedHistogramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2 <em>Data Reader EDP2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2
	 * @generated
	 */
	public Adapter createDataReaderEDP2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderSensorFramework <em>Data Reader Sensor Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderSensorFramework
	 * @generated
	 */
	public Adapter createDataReaderSensorFrameworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2Histogram <em>Data Reader EDP2 Histogram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataReaderEDP2Histogram
	 * @generated
	 */
	public Adapter createDataReaderEDP2HistogramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceEDP2 <em>Data Source EDP2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceEDP2
	 * @generated
	 */
	public Adapter createDataSourceEDP2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceSensorFramework <em>Data Source Sensor Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSourceSensorFramework
	 * @generated
	 */
	public Adapter createDataSourceSensorFrameworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalMeasurementsType <em>Ordinal Measurements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalMeasurementsType
	 * @generated
	 */
	public Adapter createOrdinalMeasurementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.NominalMeasurementsType <em>Nominal Measurements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.NominalMeasurementsType
	 * @generated
	 */
	public Adapter createNominalMeasurementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType <em>Ordinal Intervals Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType
	 * @generated
	 */
	public Adapter createOrdinalIntervalsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.ValueCorrelatedSeries <em>Value Correlated Series</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.ValueCorrelatedSeries
	 * @generated
	 */
	public Adapter createValueCorrelatedSeriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IntervalCorrelatedSeries <em>Interval Correlated Series</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.IntervalCorrelatedSeries
	 * @generated
	 */
	public Adapter createIntervalCorrelatedSeriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory <em>JFree Chart Presentation View Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory
	 * @generated
	 */
	public Adapter createJFreeChartPresentationViewFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView <em>Presentation View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView
	 * @generated
	 */
	public Adapter createPresentationViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType <em>Presentation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType
	 * @generated
	 */
	public Adapter createPresentationTypeAdapter() {
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

} //PresentationAdapterFactory
