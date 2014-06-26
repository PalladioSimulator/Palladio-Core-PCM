/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JMX Measurement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement#getPollingPeriod <em>Polling Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getJMXMeasurement()
 * @model
 * @generated
 */
public interface JMXMeasurement extends ResponseMeasurement {
	/**
	 * Returns the value of the '<em><b>Polling Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Polling Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Polling Period</em>' attribute.
	 * @see #setPollingPeriod(Integer)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getJMXMeasurement_PollingPeriod()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Integer getPollingPeriod();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement#getPollingPeriod <em>Polling Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Polling Period</em>' attribute.
	 * @see #getPollingPeriod()
	 * @generated
	 */
	void setPollingPeriod(Integer value);

} // JMXMeasurement
