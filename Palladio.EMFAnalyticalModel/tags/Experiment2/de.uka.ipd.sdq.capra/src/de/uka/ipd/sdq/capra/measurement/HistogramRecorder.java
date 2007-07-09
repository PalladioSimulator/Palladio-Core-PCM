/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Histogram Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.HistogramRecorder#getStepWidth <em>Step Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getHistogramRecorder()
 * @model
 * @generated
 */
public interface HistogramRecorder extends TimeSpanRecorder {
	/**
	 * Returns the value of the '<em><b>Step Width</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Width</em>' attribute.
	 * @see #setStepWidth(double)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getHistogramRecorder_StepWidth()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	double getStepWidth();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.HistogramRecorder#getStepWidth <em>Step Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Width</em>' attribute.
	 * @see #getStepWidth()
	 * @generated
	 */
	void setStepWidth(double value);

} // HistogramRecorder
