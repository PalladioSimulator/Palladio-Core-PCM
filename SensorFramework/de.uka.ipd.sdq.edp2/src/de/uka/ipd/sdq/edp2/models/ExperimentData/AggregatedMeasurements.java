/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregated Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getMeasurementsRange <em>Measurements Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#isValid <em>Valid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getFunction <em>Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationStatistics <em>Aggregation Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationOn <em>Aggregation On</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregatedMeasurements()
 * @model abstract="true"
 * @generated
 */
public interface AggregatedMeasurements extends Identifiable {
	/**
     * Returns the value of the '<em><b>Measurements Range</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurements Range</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Measurements Range</em>' container reference.
     * @see #setMeasurementsRange(MeasurementsRange)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregatedMeasurements_MeasurementsRange()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getAggregatedMeasurements
     * @model opposite="aggregatedMeasurements" required="true" transient="false" ordered="false"
     * @generated
     */
	MeasurementsRange getMeasurementsRange();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getMeasurementsRange <em>Measurements Range</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Measurements Range</em>' container reference.
     * @see #getMeasurementsRange()
     * @generated
     */
	void setMeasurementsRange(MeasurementsRange value);

	/**
     * Returns the value of the '<em><b>Valid</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Marker if the aggregated values are valid or if they are not consistent with the raw measurements.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Valid</em>' attribute.
     * @see #setValid(boolean)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregatedMeasurements_Valid()
     * @model required="true" ordered="false"
     * @generated
     */
	boolean isValid();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#isValid <em>Valid</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Valid</em>' attribute.
     * @see #isValid()
     * @generated
     */
	void setValid(boolean value);

	/**
     * Returns the value of the '<em><b>Function</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Function</em>' reference.
     * @see #setFunction(AggregationFunctionDescription)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregatedMeasurements_Function()
     * @model required="true" ordered="false"
     * @generated
     */
	AggregationFunctionDescription getFunction();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getFunction <em>Function</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Function</em>' reference.
     * @see #getFunction()
     * @generated
     */
	void setFunction(AggregationFunctionDescription value);

	/**
     * Returns the value of the '<em><b>Aggregation Statistics</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Statistics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Aggregation Statistics</em>' containment reference.
     * @see #setAggregationStatistics(AggregationStatistics)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregatedMeasurements_AggregationStatistics()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getAggregatedMeasurements
     * @model opposite="aggregatedMeasurements" containment="true" ordered="false"
     * @generated
     */
	AggregationStatistics getAggregationStatistics();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationStatistics <em>Aggregation Statistics</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Aggregation Statistics</em>' containment reference.
     * @see #getAggregationStatistics()
     * @generated
     */
	void setAggregationStatistics(AggregationStatistics value);

	/**
     * Returns the value of the '<em><b>Aggregation On</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Points to the base metric within the measure definition associated with the measurement of an AggregatedMeasurements instance. The data is aggregated on this base metric.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Aggregation On</em>' reference.
     * @see #setAggregationOn(BaseMetricDescription)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregatedMeasurements_AggregationOn()
     * @model required="true" ordered="false"
     * @generated
     */
	BaseMetricDescription getAggregationOn();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationOn <em>Aggregation On</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Aggregation On</em>' reference.
     * @see #getAggregationOn()
     * @generated
     */
	void setAggregationOn(BaseMetricDescription value);

	/**
     * Returns the value of the '<em><b>Metric</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Description of the metric used to express the aggregated data.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Metric</em>' reference.
     * @see #setMetric(MetricDescription)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregatedMeasurements_Metric()
     * @model required="true" ordered="false"
     * @generated
     */
	MetricDescription getMetric();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getMetric <em>Metric</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Metric</em>' reference.
     * @see #getMetric()
     * @generated
     */
	void setMetric(MetricDescription value);

} // AggregatedMeasurements
