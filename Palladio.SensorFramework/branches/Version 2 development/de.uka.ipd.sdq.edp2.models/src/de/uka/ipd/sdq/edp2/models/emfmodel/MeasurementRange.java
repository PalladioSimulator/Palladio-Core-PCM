/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import javax.measure.Measure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurement Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The collected data can be split into several measurement ranges. A range is specified as time interval and all measurements falling into a range's interval belong to that range. And only these measurements. The intervals of different ranges are not allowed to overlap. They have to be disjunct. There might be time betweenthe end of one interval and the beginning of the next.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getRawMeasurements <em>Raw Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getEndTime <em>End Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getCollectedData <em>Collected Data</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurementRange()
 * @model
 * @generated
 */
public interface MeasurementRange extends EObject {
	/**
	 * Returns the value of the '<em><b>Raw Measurements</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getMeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Measurements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Measurements</em>' containment reference.
	 * @see #setRawMeasurements(RawMeasurements)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurementRange_RawMeasurements()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements#getMeasurementRange
	 * @model opposite="measurementRange" containment="true" ordered="false"
	 * @generated
	 */
	RawMeasurements getRawMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getRawMeasurements <em>Raw Measurements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Measurements</em>' containment reference.
	 * @see #getRawMeasurements()
	 * @generated
	 */
	void setRawMeasurements(RawMeasurements value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time passed since the start of the measuring. It refers to the right end of the time interval for which the measurements are captured in this range.
	 * 
	 * For example, in a simulation environment this would mean simulation time passed since the start of the simulation. In a real world environment this would be the real time passed after the measurement has been started.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(Measure)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurementRange_EndTime()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSDurationMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getEndTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(Measure value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time passed since the start of the measuring. It refers to the left end of the time interval for which the measurements are captured in this range.
	 * 
	 * For example, in a simulation environment this would mean simulation time passed since the start of the simulation. In a real world environment this would be the real time passed after the measurement has been started.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(Measure)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurementRange_StartTime()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSDurationMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getStartTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(Measure value);

	/**
	 * Returns the value of the '<em><b>Collected Data</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collected Data</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collected Data</em>' container reference.
	 * @see #setCollectedData(Measurement)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurementRange_CollectedData()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasurementRange
	 * @model opposite="measurementRange" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Measurement getCollectedData();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getCollectedData <em>Collected Data</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collected Data</em>' container reference.
	 * @see #getCollectedData()
	 * @generated
	 */
	void setCollectedData(Measurement value);

	/**
	 * Returns the value of the '<em><b>Aggregated Measurements</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMeasurementRange <em>Measurement Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Measurements</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurementRange_AggregatedMeasurements()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements#getMeasurementRange
	 * @model opposite="measurementRange" containment="true" ordered="false"
	 * @generated
	 */
	EList<AggregatedMeasurements> getAggregatedMeasurements();

} // MeasurementRange
