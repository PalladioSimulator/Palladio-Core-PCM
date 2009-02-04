/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import java.util.Date;
import java.util.Map;

import javax.measure.Measure;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment Run</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Experiment runs contain the collected data (results) for each replication of an experiment. The data is collected for each sensor declared in the experiment setting. There is one instance of collected data for each declared sensor.
 * 
 * The time when the experiment was started and how long it took are stored as attributes. The end of the experiment run can be calculated by: endTime = startTime + duration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getCollectedData <em>Collected Data</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getExperimentSetting <em>Experiment Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getExperimentRun()
 * @model
 * @generated
 */
public interface ExperimentRun extends Identifiable, Propertyable {
	/**
	 * Returns the value of the '<em><b>Collected Data</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.sensorframework.CollectedData}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.CollectedData#getExperimentRun <em>Experiment Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collected Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collected Data</em>' containment reference list.
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getExperimentRun_CollectedData()
	 * @see de.uka.ipd.sdq.sensorframework.CollectedData#getExperimentRun
	 * @model opposite="experimentRun" containment="true" ordered="false"
	 * @generated
	 */
	EList<CollectedData> getCollectedData();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Instant at which the experiment run is started.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(Date)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getExperimentRun_StartTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Date getStartTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(Date value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Length of the duration in milli-seconds.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(Measure)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getExperimentRun_Duration()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSDurationMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getDuration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Measure value);

	/**
	 * Returns the value of the '<em><b>Experiment Setting</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.ExperimentSetting#getExperimentRuns <em>Experiment Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Setting</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Setting</em>' container reference.
	 * @see #setExperimentSetting(ExperimentSetting)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getExperimentRun_ExperimentSetting()
	 * @see de.uka.ipd.sdq.sensorframework.ExperimentSetting#getExperimentRuns
	 * @model opposite="experimentRuns" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ExperimentSetting getExperimentSetting();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.ExperimentRun#getExperimentSetting <em>Experiment Setting</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Experiment Setting</em>' container reference.
	 * @see #getExperimentSetting()
	 * @generated
	 */
	void setExperimentSetting(ExperimentSetting value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.experimentSetting.sensors->size()=collectedData->size() and 
	 * self.experimentSetting.sensors->forAll(s|self.collectedData->collect(sensor)->select(s2|s=s2)->size()=1)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ExactlyOneDataCollectionPerSensor(DiagnosticChain diagnostics, Map context);

} // ExperimentRun
