/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Used to store measurements for one dimension.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getNumericalStatistics <em>Numerical Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getValuesUuid <em>Values Uuid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getTextualStatistics <em>Textual Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDataSeries()
 * @model abstract="true"
 * @generated
 */
public interface DataSeries extends EObject {
	/**
     * Returns the value of the '<em><b>Numerical Statistics</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getDataSeries <em>Data Series</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerical Statistics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Numerical Statistics</em>' containment reference.
     * @see #setNumericalStatistics(NumericalNominalStatistics)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDataSeries_NumericalStatistics()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getDataSeries
     * @model opposite="dataSeries" containment="true" ordered="false"
     * @generated
     */
	NumericalNominalStatistics getNumericalStatistics();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getNumericalStatistics <em>Numerical Statistics</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Numerical Statistics</em>' containment reference.
     * @see #getNumericalStatistics()
     * @generated
     */
	void setNumericalStatistics(NumericalNominalStatistics value);

	/**
     * Returns the value of the '<em><b>Aggregated Measurements</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements#getDataSeries <em>Data Series</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Aggregated Measurements</em>' container reference.
     * @see #setAggregatedMeasurements(FixedWidthAggregatedMeasurements)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDataSeries_AggregatedMeasurements()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements#getDataSeries
     * @model opposite="dataSeries" transient="false" ordered="false"
     * @generated
     */
	FixedWidthAggregatedMeasurements getAggregatedMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getAggregatedMeasurements <em>Aggregated Measurements</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Aggregated Measurements</em>' container reference.
     * @see #getAggregatedMeasurements()
     * @generated
     */
	void setAggregatedMeasurements(FixedWidthAggregatedMeasurements value);

	/**
     * Returns the value of the '<em><b>Values Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Values Uuid</em>' attribute.
     * @see #setValuesUuid(String)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDataSeries_ValuesUuid()
     * @model id="true" required="true" ordered="false"
     * @generated
     */
	String getValuesUuid();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getValuesUuid <em>Values Uuid</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Values Uuid</em>' attribute.
     * @see #getValuesUuid()
     * @generated
     */
	void setValuesUuid(String value);

	/**
     * Returns the value of the '<em><b>Textual Statistics</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getDataSeries <em>Data Series</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textual Statistics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Textual Statistics</em>' containment reference.
     * @see #setTextualStatistics(TextualNominalStatistics)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDataSeries_TextualStatistics()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getDataSeries
     * @model opposite="dataSeries" containment="true" ordered="false"
     * @generated
     */
	TextualNominalStatistics getTextualStatistics();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getTextualStatistics <em>Textual Statistics</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Textual Statistics</em>' containment reference.
     * @see #getTextualStatistics()
     * @generated
     */
	void setTextualStatistics(TextualNominalStatistics value);

	/**
     * Returns the value of the '<em><b>Raw Measurements</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements#getDataSeries <em>Data Series</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Raw Measurements</em>' container reference.
     * @see #setRawMeasurements(RawMeasurements)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDataSeries_RawMeasurements()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements#getDataSeries
     * @model opposite="dataSeries" transient="false" ordered="false"
     * @generated
     */
	RawMeasurements getRawMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getRawMeasurements <em>Raw Measurements</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Raw Measurements</em>' container reference.
     * @see #getRawMeasurements()
     * @generated
     */
	void setRawMeasurements(RawMeasurements value);

} // DataSeries
