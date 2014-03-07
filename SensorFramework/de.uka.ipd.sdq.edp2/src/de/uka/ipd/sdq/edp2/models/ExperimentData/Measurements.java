/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * There&nbsp;is&nbsp;exactly&nbsp;one&nbsp;instance&nbsp;of&nbsp;this&nbsp;class&nbsp;for&nbsp;each&nbsp;combination&nbsp;of&nbsp;experiment&nbsp;run&nbsp;and&nbsp;corresponding&nbsp;measure&nbsp;declaration.
 * It indicates that the experiment run contains measurements for the linked Edp2Measure.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements#getMeasure <em>Measure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements#getMeasurementsRanges <em>Measurements Ranges</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements#getExperimentRun <em>Experiment Run</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurements()
 * @model
 * @generated
 */
public interface Measurements extends Identifiable, Propertyable {
	/**
     * Returns the value of the '<em><b>Measure</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Measure</em>' reference.
     * @see #setMeasure(Edp2Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurements_Measure()
     * @model required="true" ordered="false"
     * @generated
     */
	Edp2Measure getMeasure();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements#getMeasure <em>Measure</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Measure</em>' reference.
     * @see #getMeasure()
     * @generated
     */
	void setMeasure(Edp2Measure value);

	/**
     * Returns the value of the '<em><b>Experiment Run</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun#getMeasurements <em>Measurements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Run</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Experiment Run</em>' container reference.
     * @see #setExperimentRun(ExperimentRun)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurements_ExperimentRun()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun#getMeasurements
     * @model opposite="measurements" required="true" transient="false" ordered="false"
     * @generated
     */
	ExperimentRun getExperimentRun();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements#getExperimentRun <em>Experiment Run</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Experiment Run</em>' container reference.
     * @see #getExperimentRun()
     * @generated
     */
	void setExperimentRun(ExperimentRun value);

	/**
     * Returns the value of the '<em><b>Measurements Ranges</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getMeasurements <em>Measurements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurements Ranges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Measurements Ranges</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMeasurements_MeasurementsRanges()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange#getMeasurements
     * @model opposite="measurements" containment="true" ordered="false"
     * @generated
     */
	EList<MeasurementsRange> getMeasurementsRanges();

} // Measurements
