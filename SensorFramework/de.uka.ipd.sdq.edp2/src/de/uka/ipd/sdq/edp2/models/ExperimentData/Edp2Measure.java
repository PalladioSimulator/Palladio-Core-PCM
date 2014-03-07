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
 * A representation of the model object '<em><b>Edp2 Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Describes&nbsp;and&nbsp;specifies&nbsp;the&nbsp;measure&nbsp;used.&nbsp;Needs&nbsp;to&nbsp;be&nbsp;subclassed&nbsp;to&nbsp;create&nbsp;concrete&nbsp;Measures&nbsp;which&nbsp;can&nbsp;handle&nbsp;specific&nbsp;data.&nbsp;Measures&nbsp;are&nbsp;attached&nbsp;to&nbsp;ExperimentGroup&nbsp;and&nbsp;referenced&nbsp;from&nbsp;ExperimentSetting&nbsp;to&nbsp;allow&nbsp;modeling&nbsp;that&nbsp;the&nbsp;same&nbsp;Measure&nbsp;is&nbsp;used&nbsp;throughout&nbsp;several&nbsp;experiment&nbsp;settings.
 * An Edp2Measure can have one or more dimensions (see also the attribute metric).<br />
 * <br />
 * Characterizes&nbsp;the&nbsp;reading&nbsp;point&nbsp;how&nbsp;the&nbsp;measurements&nbsp;are&nbsp;collected.&nbsp;The&nbsp;Characerization&nbsp;is&nbsp;propertyable&nbsp;if&nbsp;additional&nbsp;context-specific&nbsp;information&nbsp;should&nbsp;be&nbsp;stored&nbsp;for&nbsp;the&nbsp;sensor.<br />
 * <br />
 * For&nbsp;example&nbsp;measuring&nbsp;the&nbsp;response&nbsp;time&nbsp;of&nbsp;a&nbsp;request&nbsp;to&nbsp;a&nbsp;system&nbsp;in&nbsp;milliseconds&nbsp;could&nbsp;result&nbsp;in&nbsp;the&nbsp;following&nbsp;values&nbsp;of&nbsp;the&nbsp;attributes:&nbsp;metric='Response&nbsp;Time',&nbsp;measuredObject='System&nbsp;External&nbsp;Requests',&nbsp;and&nbsp;unitOfMeasurements='ms'.&nbsp;Another&nbsp;example&nbsp;is&nbsp;the&nbsp;number&nbsp;of&nbsp;lines&nbsp;of&nbsp;code&nbsp;of&nbsp;the&nbsp;class&nbsp;java.lang.System:&nbsp;metric='LOC',&nbsp;measuredObject='Class&nbsp;java.lang.System',&nbsp;and&nbsp;unitOfMeasurement='Positive&nbsp;Integer'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getExperimentGroup <em>Experiment Group</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getMeasuredObject <em>Measured Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getEdp2Measure()
 * @model
 * @generated
 */
public interface Edp2Measure extends Identifiable {
	/**
     * Returns the value of the '<em><b>Experiment Group</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getMeasure <em>Measure</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Experiment Group</em>' container reference.
     * @see #setExperimentGroup(ExperimentGroup)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getEdp2Measure_ExperimentGroup()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getMeasure
     * @model opposite="measure" required="true" transient="false" ordered="false"
     * @generated
     */
	ExperimentGroup getExperimentGroup();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getExperimentGroup <em>Experiment Group</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Experiment Group</em>' container reference.
     * @see #getExperimentGroup()
     * @generated
     */
	void setExperimentGroup(ExperimentGroup value);

	/**
     * Returns the value of the '<em><b>Experiment Settings</b></em>' reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting#getMeasure <em>Measure</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Settings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Experiment Settings</em>' reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getEdp2Measure_ExperimentSettings()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting#getMeasure
     * @model opposite="measure" ordered="false"
     * @generated
     */
	EList<ExperimentSetting> getExperimentSettings();

	/**
     * Returns the value of the '<em><b>Measured Object</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measured Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Measured Object</em>' attribute.
     * @see #setMeasuredObject(String)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getEdp2Measure_MeasuredObject()
     * @model required="true" ordered="false"
     * @generated
     */
	String getMeasuredObject();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getMeasuredObject <em>Measured Object</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Measured Object</em>' attribute.
     * @see #getMeasuredObject()
     * @generated
     */
	void setMeasuredObject(String value);

	/**
     * Returns the value of the '<em><b>Metric</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Metric</em>' reference.
     * @see #setMetric(MetricDescription)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getEdp2Measure_Metric()
     * @model required="true" ordered="false"
     * @generated
     */
	MetricDescription getMetric();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getMetric <em>Metric</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Metric</em>' reference.
     * @see #getMetric()
     * @generated
     */
	void setMetric(MetricDescription value);

} // Edp2Measure
