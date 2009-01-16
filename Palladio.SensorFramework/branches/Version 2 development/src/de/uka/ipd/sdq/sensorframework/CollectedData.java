/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collected Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * There is exactly one instance of this class for each combination of experiment run and corresponding sensor declaration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.CollectedData#getSensor <em>Sensor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.CollectedData#getExperimentRun <em>Experiment Run</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.CollectedData#getMeasurementRange <em>Measurement Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getCollectedData()
 * @model
 * @generated
 */
public interface CollectedData extends Propertyable {
	/**
	 * Returns the value of the '<em><b>Sensor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sensor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensor</em>' reference.
	 * @see #setSensor(SensorDeclaration)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getCollectedData_Sensor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SensorDeclaration getSensor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.CollectedData#getSensor <em>Sensor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sensor</em>' reference.
	 * @see #getSensor()
	 * @generated
	 */
	void setSensor(SensorDeclaration value);

	/**
	 * Returns the value of the '<em><b>Experiment Run</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getCollectedData <em>Collected Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Run</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Run</em>' container reference.
	 * @see #setExperimentRun(ExperimentRun)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getCollectedData_ExperimentRun()
	 * @see de.uka.ipd.sdq.sensorframework.ExperimentRun#getCollectedData
	 * @model opposite="collectedData" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ExperimentRun getExperimentRun();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.CollectedData#getExperimentRun <em>Experiment Run</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Experiment Run</em>' container reference.
	 * @see #getExperimentRun()
	 * @generated
	 */
	void setExperimentRun(ExperimentRun value);

	/**
	 * Returns the value of the '<em><b>Measurement Range</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.sensorframework.MeasurementRange}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.MeasurementRange#getCollectedData <em>Collected Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement Range</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement Range</em>' containment reference list.
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getCollectedData_MeasurementRange()
	 * @see de.uka.ipd.sdq.sensorframework.MeasurementRange#getCollectedData
	 * @model opposite="collectedData" containment="true" ordered="false"
	 * @generated
	 */
	EList<MeasurementRange> getMeasurementRange();

} // CollectedData
