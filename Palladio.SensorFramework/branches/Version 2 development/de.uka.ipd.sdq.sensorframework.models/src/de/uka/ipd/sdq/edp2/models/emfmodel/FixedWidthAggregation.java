/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Width Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawXSeries <em>Raw XSeries</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawYSeries <em>Raw YSeries</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getFixedWidthAggregation()
 * @model abstract="true"
 * @generated
 */
public interface FixedWidthAggregation extends AggregatedMeasurements {
	/**
	 * Returns the value of the '<em><b>Raw XSeries</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw XSeries</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw XSeries</em>' containment reference.
	 * @see #setRawXSeries(Intervals)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getFixedWidthAggregation_RawXSeries()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getAggregatedMeasurements
	 * @model opposite="aggregatedMeasurements" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Intervals getRawXSeries();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawXSeries <em>Raw XSeries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw XSeries</em>' containment reference.
	 * @see #getRawXSeries()
	 * @generated
	 */
	void setRawXSeries(Intervals value);

	/**
	 * Returns the value of the '<em><b>Raw YSeries</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw YSeries</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw YSeries</em>' containment reference.
	 * @see #setRawYSeries(RawYSeries)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getFixedWidthAggregation_RawYSeries()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getAggregatedMeasurements
	 * @model opposite="aggregatedMeasurements" containment="true" required="true" ordered="false"
	 * @generated
	 */
	RawYSeries getRawYSeries();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawYSeries <em>Raw YSeries</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw YSeries</em>' containment reference.
	 * @see #getRawYSeries()
	 * @generated
	 */
	void setRawYSeries(RawYSeries value);

} // FixedWidthAggregation
