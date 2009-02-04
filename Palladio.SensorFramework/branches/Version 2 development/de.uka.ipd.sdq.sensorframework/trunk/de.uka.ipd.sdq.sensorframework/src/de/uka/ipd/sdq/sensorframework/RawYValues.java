/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raw YValues</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawYValues#getStatistics <em>Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawYValues#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawYValues#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getRawYValues()
 * @model abstract="true"
 * @generated
 */
public interface RawYValues extends EObject {
	/**
	 * Returns the value of the '<em><b>Statistics</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.Statistics#getRawYValues <em>Raw YValues</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statistics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistics</em>' containment reference.
	 * @see #setStatistics(Statistics)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getRawYValues_Statistics()
	 * @see de.uka.ipd.sdq.sensorframework.Statistics#getRawYValues
	 * @model opposite="rawYValues" containment="true" ordered="false"
	 * @generated
	 */
	Statistics getStatistics();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawYValues#getStatistics <em>Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics</em>' containment reference.
	 * @see #getStatistics()
	 * @generated
	 */
	void setStatistics(Statistics value);

	/**
	 * Returns the value of the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.FixedWidthAggregation#getRawYValues <em>Raw YValues</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #setAggregatedMeasurements(FixedWidthAggregation)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getRawYValues_AggregatedMeasurements()
	 * @see de.uka.ipd.sdq.sensorframework.FixedWidthAggregation#getRawYValues
	 * @model opposite="rawYValues" required="true" transient="false" ordered="false"
	 * @generated
	 */
	FixedWidthAggregation getAggregatedMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawYValues#getAggregatedMeasurements <em>Aggregated Measurements</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	void setAggregatedMeasurements(FixedWidthAggregation value);

	/**
	 * Returns the value of the '<em><b>Raw Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawYValues <em>Raw YValues</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Measurements</em>' container reference.
	 * @see #setRawMeasurements(RawMeasurements)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getRawYValues_RawMeasurements()
	 * @see de.uka.ipd.sdq.sensorframework.RawMeasurements#getRawYValues
	 * @model opposite="rawYValues" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RawMeasurements getRawMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawYValues#getRawMeasurements <em>Raw Measurements</em>}' container reference.
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

} // RawYValues
