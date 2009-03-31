/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregated Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMeasurementRange <em>Measurement Range</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationCharacterization <em>Aggregation Characterization</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#isValid <em>Valid</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements()
 * @model abstract="true"
 * @generated
 */
public interface AggregatedMeasurements extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Measurement Range</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement Range</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement Range</em>' container reference.
	 * @see #setMeasurementRange(MeasurementRange)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements_MeasurementRange()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getAggregatedMeasurements
	 * @model opposite="aggregatedMeasurements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MeasurementRange getMeasurementRange();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMeasurementRange <em>Measurement Range</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement Range</em>' container reference.
	 * @see #getMeasurementRange()
	 * @generated
	 */
	void setMeasurementRange(MeasurementRange value);

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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements_DistinctValuesBeforeAggregation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getDistinctValuesBeforeAggregation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}' attribute.
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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements_DistinctValuesAfterAggregation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getDistinctValuesAfterAggregation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distinct Values After Aggregation</em>' attribute.
	 * @see #getDistinctValuesAfterAggregation()
	 * @generated
	 */
	void setDistinctValuesAfterAggregation(long value);

	/**
	 * Returns the value of the '<em><b>Aggregation Characterization</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationCharacterization#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Characterization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Characterization</em>' containment reference.
	 * @see #setAggregationCharacterization(AggregationCharacterization)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements_AggregationCharacterization()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregationCharacterization#getAggregatedMeasurements
	 * @model opposite="aggregatedMeasurements" containment="true" required="true" ordered="false"
	 * @generated
	 */
	AggregationCharacterization getAggregationCharacterization();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationCharacterization <em>Aggregation Characterization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Characterization</em>' containment reference.
	 * @see #getAggregationCharacterization()
	 * @generated
	 */
	void setAggregationCharacterization(AggregationCharacterization value);

	/**
	 * Returns the value of the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Marker if the aggregated values are valid or if they are not consistent with the raw measurements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Valid</em>' attribute.
	 * @see #setValid(boolean)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements_Valid()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isValid();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#isValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #isValid()
	 * @generated
	 */
	void setValid(boolean value);

} // AggregatedMeasurements
