/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raw YSeries</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getStatistics <em>Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getValuesUuid <em>Values Uuid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getRawYSeries()
 * @model abstract="true"
 * @generated
 */
public interface RawYSeries extends EObject {
	/**
	 * Returns the value of the '<em><b>Statistics</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getRawYSeries <em>Raw YSeries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statistics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistics</em>' containment reference.
	 * @see #setStatistics(NominalStatistics)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getRawYSeries_Statistics()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getRawYSeries
	 * @model opposite="rawYSeries" containment="true" ordered="false"
	 * @generated
	 */
	NominalStatistics getStatistics();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getStatistics <em>Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics</em>' containment reference.
	 * @see #getStatistics()
	 * @generated
	 */
	void setStatistics(NominalStatistics value);

	/**
	 * Returns the value of the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawYSeries <em>Raw YSeries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #setAggregatedMeasurements(FixedWidthAggregation)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getRawYSeries_AggregatedMeasurements()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawYSeries
	 * @model opposite="rawYSeries" required="true" transient="false" ordered="false"
	 * @generated
	 */
	FixedWidthAggregation getAggregatedMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getAggregatedMeasurements <em>Aggregated Measurements</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	void setAggregatedMeasurements(FixedWidthAggregation value);

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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getRawYSeries_ValuesUuid()
	 * @model id="true" required="true" ordered="false"
	 * @generated
	 */
	String getValuesUuid();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getValuesUuid <em>Values Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Values Uuid</em>' attribute.
	 * @see #getValuesUuid()
	 * @generated
	 */
	void setValuesUuid(String value);

	/**
	 * Returns the value of the '<em><b>Raw Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getRawYSeries <em>Raw YSeries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Measurements</em>' container reference.
	 * @see #setRawMeasurements(RawMeasurements)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getRawYSeries_RawMeasurements()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getRawYSeries
	 * @model opposite="rawYSeries" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RawMeasurements getRawMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getRawMeasurements <em>Raw Measurements</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Measurements</em>' container reference.
	 * @see #getRawMeasurements()
	 * @generated
	 */
	void setRawMeasurements(RawMeasurements value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.statistics->size()=1 implies not self.oclIsKindOf(StateMeasurements)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean Statisticsonlyformeasurablevalues(DiagnosticChain diagnostics, Map context);

} // RawYSeries
