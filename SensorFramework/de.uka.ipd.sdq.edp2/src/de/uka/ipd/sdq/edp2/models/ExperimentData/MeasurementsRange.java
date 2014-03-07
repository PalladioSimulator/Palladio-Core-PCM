/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.Measure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurements Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The&nbsp;collected&nbsp;data&nbsp;can&nbsp;be&nbsp;split&nbsp;into&nbsp;several&nbsp;measurement&nbsp;ranges.&nbsp;A&nbsp;range&nbsp;is&nbsp;specified&nbsp;as&nbsp;time&nbsp;interval&nbsp;and&nbsp;all&nbsp;measurements&nbsp;falling&nbsp;into&nbsp;a&nbsp;range's&nbsp;interval&nbsp;belong&nbsp;to&nbsp;that&nbsp;range.&nbsp;And&nbsp;only&nbsp;these&nbsp;measurements.&nbsp;The&nbsp;intervals&nbsp;of&nbsp;different&nbsp;ranges&nbsp;are&nbsp;not&nbsp;allowed&nbsp;to&nbsp;overlap.&nbsp;They&nbsp;have&nbsp;to&nbsp;be&nbsp;disjunct.&nbsp;There&nbsp;might&nbsp;be&nbsp;time&nbsp;between
 * the&nbsp;end&nbsp;of&nbsp;one&nbsp;interval&nbsp;and&nbsp;the&nbsp;beginning&nbsp;of&nbsp;the&nbsp;next. It is not allowed
 * to change ranges or shift measurements between subsequent ranges to readjust the range after measurements have been taken.
 * Ranges can be used to differentiate the warm-up-phase from the measurement phase as well as to&nbsp;implement sliding
 * means.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getRawMeasurements <em>Raw Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getEndTime <em>End Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurementsRange()
 * @model
 * @generated
 */
public interface MeasurementsRange extends Propertyable {
	/**
     * Returns the value of the '<em><b>Raw Measurements</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements#getMeasurementsRange <em>Measurements Range</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Measurements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Raw Measurements</em>' containment reference.
     * @see #setRawMeasurements(RawMeasurements)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurementsRange_RawMeasurements()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements#getMeasurementsRange
     * @model opposite="measurementsRange" containment="true" ordered="false"
     * @generated
     */
	RawMeasurements getRawMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getRawMeasurements <em>Raw Measurements</em>}' containment reference.
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
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurementsRange_EndTime()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSDurationMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getEndTime();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getEndTime <em>End Time</em>}' attribute.
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
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurementsRange_StartTime()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSDurationMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getStartTime();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getStartTime <em>Start Time</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Time</em>' attribute.
     * @see #getStartTime()
     * @generated
     */
	void setStartTime(Measure value);

	/**
     * Returns the value of the '<em><b>Measurements</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements#getMeasurementsRanges <em>Measurements Ranges</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Measurements</em>' container reference.
     * @see #setMeasurements(Measurements)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurementsRange_Measurements()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements#getMeasurementsRanges
     * @model opposite="measurementsRanges" required="true" transient="false" ordered="false"
     * @generated
     */
	Measurements getMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getMeasurements <em>Measurements</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Measurements</em>' container reference.
     * @see #getMeasurements()
     * @generated
     */
	void setMeasurements(Measurements value);

	/**
     * Returns the value of the '<em><b>Aggregated Measurements</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getMeasurementsRange <em>Measurements Range</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Aggregated Measurements</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurementsRange_AggregatedMeasurements()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getMeasurementsRange
     * @model opposite="measurementsRange" containment="true" ordered="false"
     * @generated
     */
	EList<AggregatedMeasurements> getAggregatedMeasurements();

} // MeasurementsRange
