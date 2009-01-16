/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measure Characterization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Characterizes the meaning of the sensor's data. The Characerization is propertyable if additional context-specific information should be stored for the sensor.
 * 
 * For example measuring the response time of a request to a system in milliseconds could result in the following values of the attributes: metric='Response Time', measuredObject='System External Requests', and unitOfMeasurements='ms'. Another example is the number of lines of code of the class java.lang.System: metric='LOC', measuredObject='Class java.lang.System', and unitOfMeasurement='Positive Integer'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.MeasureCharacterization#getMeasuredObject <em>Measured Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.MeasureCharacterization#getMetric <em>Metric</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.MeasureCharacterization#getSensorDeclaration <em>Sensor Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getMeasureCharacterization()
 * @model
 * @generated
 */
public interface MeasureCharacterization extends Propertyable {
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
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getMeasureCharacterization_MeasuredObject()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMeasuredObject();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.MeasureCharacterization#getMeasuredObject <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measured Object</em>' attribute.
	 * @see #getMeasuredObject()
	 * @generated
	 */
	void setMeasuredObject(String value);

	/**
	 * Returns the value of the '<em><b>Metric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric</em>' attribute.
	 * @see #setMetric(String)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getMeasureCharacterization_Metric()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMetric();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.MeasureCharacterization#getMetric <em>Metric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' attribute.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(String value);

	/**
	 * Returns the value of the '<em><b>Sensor Declaration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.SensorDeclaration#getMeasureCharacterization <em>Measure Characterization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sensor Declaration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensor Declaration</em>' container reference.
	 * @see #setSensorDeclaration(SensorDeclaration)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getMeasureCharacterization_SensorDeclaration()
	 * @see de.uka.ipd.sdq.sensorframework.SensorDeclaration#getMeasureCharacterization
	 * @model opposite="measureCharacterization" required="true" transient="false" ordered="false"
	 * @generated
	 */
	SensorDeclaration getSensorDeclaration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.MeasureCharacterization#getSensorDeclaration <em>Sensor Declaration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sensor Declaration</em>' container reference.
	 * @see #getSensorDeclaration()
	 * @generated
	 */
	void setSensorDeclaration(SensorDeclaration value);

} // MeasureCharacterization
