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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage
 * @generated
 */
public class PresentationSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PresentationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationSwitch() {
		if (modelPackage == null) {
			modelPackage = PresentationPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PresentationPackage.JFREE_CHART_VIEW: {
				JFreeChartView jFreeChartView = (JFreeChartView)theEObject;
				T result = caseJFreeChartView(jFreeChartView);
				if (result == null) result = casePresentationView(jFreeChartView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_READER: {
				DataReader dataReader = (DataReader)theEObject;
				T result = caseDataReader(dataReader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_READER_CONFIGURATION: {
				DataReaderConfiguration dataReaderConfiguration = (DataReaderConfiguration)theEObject;
				T result = caseDataReaderConfiguration(dataReaderConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_SOURCE: {
				DataSource dataSource = (DataSource)theEObject;
				T result = caseDataSource(dataSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.IDATA_SOURCE_DESCRIPTION: {
				IDataSourceDescription iDataSourceDescription = (IDataSourceDescription)theEObject;
				T result = caseIDataSourceDescription(iDataSourceDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.RVIEW: {
				RView rView = (RView)theEObject;
				T result = caseRView(rView);
				if (result == null) result = casePresentationView(rView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.HISTOGRAM: {
				Histogram histogram = (Histogram)theEObject;
				T result = caseHistogram(histogram);
				if (result == null) result = casePresentationType(histogram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.BAR: {
				Bar bar = (Bar)theEObject;
				T result = caseBar(bar);
				if (result == null) result = casePresentationType(bar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.CUMULATIVE_DISTRIBUTION_FUNCTION: {
				CumulativeDistributionFunction cumulativeDistributionFunction = (CumulativeDistributionFunction)theEObject;
				T result = caseCumulativeDistributionFunction(cumulativeDistributionFunction);
				if (result == null) result = casePresentationType(cumulativeDistributionFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.PIE: {
				Pie pie = (Pie)theEObject;
				T result = casePie(pie);
				if (result == null) result = casePresentationType(pie);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.LINE: {
				Line line = (Line)theEObject;
				T result = caseLine(line);
				if (result == null) result = casePresentationType(line);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.POINT: {
				Point point = (Point)theEObject;
				T result = casePoint(point);
				if (result == null) result = casePresentationType(point);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.BOXPLOT: {
				Boxplot boxplot = (Boxplot)theEObject;
				T result = caseBoxplot(boxplot);
				if (result == null) result = casePresentationType(boxplot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.IEDITOR_INPUT: {
				IEditorInput iEditorInput = (IEditorInput)theEObject;
				T result = caseIEditorInput(iEditorInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION: {
				EDP2DataSourceDescription edp2DataSourceDescription = (EDP2DataSourceDescription)theEObject;
				T result = caseEDP2DataSourceDescription(edp2DataSourceDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION: {
				SensorFrameworkDataSourceDescription sensorFrameworkDataSourceDescription = (SensorFrameworkDataSourceDescription)theEObject;
				T result = caseSensorFrameworkDataSourceDescription(sensorFrameworkDataSourceDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.JFREE_CHART_HISTOGRAM_VIEW: {
				JFreeChartHistogramView jFreeChartHistogramView = (JFreeChartHistogramView)theEObject;
				T result = caseJFreeChartHistogramView(jFreeChartHistogramView);
				if (result == null) result = caseHistogramView(jFreeChartHistogramView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.HISTOGRAM_VIEW: {
				HistogramView histogramView = (HistogramView)theEObject;
				T result = caseHistogramView(histogramView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.JFREE_CHART_CUMULATIVE_DISTRIBUTION_VIEW: {
				JFreeChartCumulativeDistributionView jFreeChartCumulativeDistributionView = (JFreeChartCumulativeDistributionView)theEObject;
				T result = caseJFreeChartCumulativeDistributionView(jFreeChartCumulativeDistributionView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.JFREE_CHART_LINE_VIEW: {
				JFreeChartLineView jFreeChartLineView = (JFreeChartLineView)theEObject;
				T result = caseJFreeChartLineView(jFreeChartLineView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.ENHANCED_HISTOGRAM: {
				EnhancedHistogram enhancedHistogram = (EnhancedHistogram)theEObject;
				T result = caseEnhancedHistogram(enhancedHistogram);
				if (result == null) result = caseHistogram(enhancedHistogram);
				if (result == null) result = casePresentationType(enhancedHistogram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_READER_EDP2: {
				DataReaderEDP2 dataReaderEDP2 = (DataReaderEDP2)theEObject;
				T result = caseDataReaderEDP2(dataReaderEDP2);
				if (result == null) result = caseDataReader(dataReaderEDP2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_READER_SENSOR_FRAMEWORK: {
				DataReaderSensorFramework dataReaderSensorFramework = (DataReaderSensorFramework)theEObject;
				T result = caseDataReaderSensorFramework(dataReaderSensorFramework);
				if (result == null) result = caseDataReader(dataReaderSensorFramework);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_READER_EDP2_HISTOGRAM: {
				DataReaderEDP2Histogram dataReaderEDP2Histogram = (DataReaderEDP2Histogram)theEObject;
				T result = caseDataReaderEDP2Histogram(dataReaderEDP2Histogram);
				if (result == null) result = caseDataReaderEDP2(dataReaderEDP2Histogram);
				if (result == null) result = caseDataReader(dataReaderEDP2Histogram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_SOURCE_EDP2: {
				DataSourceEDP2 dataSourceEDP2 = (DataSourceEDP2)theEObject;
				T result = caseDataSourceEDP2(dataSourceEDP2);
				if (result == null) result = caseDataSource(dataSourceEDP2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_SOURCE_SENSOR_FRAMEWORK: {
				DataSourceSensorFramework dataSourceSensorFramework = (DataSourceSensorFramework)theEObject;
				T result = caseDataSourceSensorFramework(dataSourceSensorFramework);
				if (result == null) result = caseDataSource(dataSourceSensorFramework);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.ORDINAL_MEASUREMENTS_TYPE: {
				OrdinalMeasurementsType ordinalMeasurementsType = (OrdinalMeasurementsType)theEObject;
				T result = caseOrdinalMeasurementsType(ordinalMeasurementsType);
				if (result == null) result = caseDataType(ordinalMeasurementsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.NOMINAL_MEASUREMENTS_TYPE: {
				NominalMeasurementsType nominalMeasurementsType = (NominalMeasurementsType)theEObject;
				T result = caseNominalMeasurementsType(nominalMeasurementsType);
				if (result == null) result = caseDataType(nominalMeasurementsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.ORDINAL_INTERVALS_TYPE: {
				OrdinalIntervalsType ordinalIntervalsType = (OrdinalIntervalsType)theEObject;
				T result = caseOrdinalIntervalsType(ordinalIntervalsType);
				if (result == null) result = caseDataType(ordinalIntervalsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.VALUE_CORRELATED_SERIES: {
				ValueCorrelatedSeries valueCorrelatedSeries = (ValueCorrelatedSeries)theEObject;
				T result = caseValueCorrelatedSeries(valueCorrelatedSeries);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.INTERVAL_CORRELATED_SERIES: {
				IntervalCorrelatedSeries intervalCorrelatedSeries = (IntervalCorrelatedSeries)theEObject;
				T result = caseIntervalCorrelatedSeries(intervalCorrelatedSeries);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY: {
				JFreeChartPresentationViewFactory jFreeChartPresentationViewFactory = (JFreeChartPresentationViewFactory)theEObject;
				T result = caseJFreeChartPresentationViewFactory(jFreeChartPresentationViewFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JFree Chart View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JFree Chart View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJFreeChartView(JFreeChartView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Reader</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reader</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReader(DataReader object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Reader Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reader Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReaderConfiguration(DataReaderConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSource(DataSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IData Source Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IData Source Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDataSourceDescription(IDataSourceDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RView</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RView</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRView(RView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Histogram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Histogram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHistogram(Histogram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBar(Bar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cumulative Distribution Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cumulative Distribution Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCumulativeDistributionFunction(CumulativeDistributionFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pie</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pie</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePie(Pie object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLine(Line object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoint(Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boxplot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boxplot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoxplot(Boxplot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEditor Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEditor Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEditorInput(IEditorInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDP2 Data Source Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDP2 Data Source Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDP2DataSourceDescription(EDP2DataSourceDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Framework Data Source Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Framework Data Source Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorFrameworkDataSourceDescription(SensorFrameworkDataSourceDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JFree Chart Histogram View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JFree Chart Histogram View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJFreeChartHistogramView(JFreeChartHistogramView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Histogram View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Histogram View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHistogramView(HistogramView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JFree Chart Cumulative Distribution View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JFree Chart Cumulative Distribution View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJFreeChartCumulativeDistributionView(JFreeChartCumulativeDistributionView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JFree Chart Line View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JFree Chart Line View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJFreeChartLineView(JFreeChartLineView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enhanced Histogram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enhanced Histogram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnhancedHistogram(EnhancedHistogram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Reader EDP2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reader EDP2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReaderEDP2(DataReaderEDP2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Reader Sensor Framework</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reader Sensor Framework</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReaderSensorFramework(DataReaderSensorFramework object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Reader EDP2 Histogram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reader EDP2 Histogram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReaderEDP2Histogram(DataReaderEDP2Histogram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Source EDP2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Source EDP2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSourceEDP2(DataSourceEDP2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Source Sensor Framework</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Source Sensor Framework</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSourceSensorFramework(DataSourceSensorFramework object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordinal Measurements Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordinal Measurements Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrdinalMeasurementsType(OrdinalMeasurementsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nominal Measurements Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nominal Measurements Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNominalMeasurementsType(NominalMeasurementsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordinal Intervals Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordinal Intervals Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrdinalIntervalsType(OrdinalIntervalsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Correlated Series</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Correlated Series</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueCorrelatedSeries(ValueCorrelatedSeries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interval Correlated Series</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interval Correlated Series</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntervalCorrelatedSeries(IntervalCorrelatedSeries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JFree Chart Presentation View Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JFree Chart Presentation View Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJFreeChartPresentationViewFactory(JFreeChartPresentationViewFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationView(PresentationView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationType(PresentationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //PresentationSwitch
