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
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#isValid <em>Valid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getFunction <em>Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationStatistics <em>Aggregation Statistics</em>}</li>
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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements_Function()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AggregationFunctionDescription getFunction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(AggregationFunctionDescription value);

	/**
	 * Returns the value of the '<em><b>Aggregation Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Statistics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Statistics</em>' containment reference.
	 * @see #setAggregationStatistics(AggregationStatistics)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregatedMeasurements_AggregationStatistics()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	AggregationStatistics getAggregationStatistics();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getAggregationStatistics <em>Aggregation Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Statistics</em>' containment reference.
	 * @see #getAggregationStatistics()
	 * @generated
	 */
	void setAggregationStatistics(AggregationStatistics value);

} // AggregatedMeasurements
