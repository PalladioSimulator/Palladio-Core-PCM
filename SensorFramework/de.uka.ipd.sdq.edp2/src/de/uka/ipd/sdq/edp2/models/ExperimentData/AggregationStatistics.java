/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregationStatistics()
 * @model
 * @generated
 */
public interface AggregationStatistics extends Identifiable {
	/**
     * Returns the value of the '<em><b>Distinct Values Before Aggregation</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The number of distinct data values before aggregation.
     * 
     * <!-- end-model-doc -->
     * @return the value of the '<em>Distinct Values Before Aggregation</em>' attribute.
     * @see #setDistinctValuesBeforeAggregation(long)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregationStatistics_DistinctValuesBeforeAggregation()
     * @model required="true" ordered="false"
     * @generated
     */
	long getDistinctValuesBeforeAggregation();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Distinct Values Before Aggregation</em>' attribute.
     * @see #getDistinctValuesBeforeAggregation()
     * @generated
     */
	void setDistinctValuesBeforeAggregation(long value);

	/**
     * Returns the value of the '<em><b>Distinct Values After Aggregation</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The number of distinct data values after aggregation.
     * 
     * For example if measurements were aggregated to three different groups the number is three.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Distinct Values After Aggregation</em>' attribute.
     * @see #setDistinctValuesAfterAggregation(long)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregationStatistics_DistinctValuesAfterAggregation()
     * @model required="true" ordered="false"
     * @generated
     */
	long getDistinctValuesAfterAggregation();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Distinct Values After Aggregation</em>' attribute.
     * @see #getDistinctValuesAfterAggregation()
     * @generated
     */
	void setDistinctValuesAfterAggregation(long value);

	/**
     * Returns the value of the '<em><b>Aggregated Measurements</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationStatistics <em>Aggregation Statistics</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Aggregated Measurements</em>' container reference.
     * @see #setAggregatedMeasurements(AggregatedMeasurements)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getAggregationStatistics_AggregatedMeasurements()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationStatistics
     * @model opposite="aggregationStatistics" required="true" transient="false" ordered="false"
     * @generated
     */
	AggregatedMeasurements getAggregatedMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics#getAggregatedMeasurements <em>Aggregated Measurements</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Aggregated Measurements</em>' container reference.
     * @see #getAggregatedMeasurements()
     * @generated
     */
	void setAggregatedMeasurements(AggregatedMeasurements value);

} // AggregationStatistics
