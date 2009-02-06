/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sensor Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO
 * 
 * The abstract SensorDeclaration class needs to be subclassed to create concrete Sensors that can handle specific data. Visualisations can later use the specific subtype to know the best way how to visualise the data. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration#getExperimentSetting <em>Experiment Setting</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration#getMeasureCharacterization <em>Measure Characterization</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration#getPersistencyKind <em>Persistency Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getSensorDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface SensorDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Experiment Setting</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentSetting#getSensors <em>Sensors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Setting</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Setting</em>' container reference.
	 * @see #setExperimentSetting(ExperimentSetting)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getSensorDeclaration_ExperimentSetting()
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentSetting#getSensors
	 * @model opposite="sensors" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ExperimentSetting getExperimentSetting();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration#getExperimentSetting <em>Experiment Setting</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Experiment Setting</em>' container reference.
	 * @see #getExperimentSetting()
	 * @generated
	 */
	void setExperimentSetting(ExperimentSetting value);

	/**
	 * Returns the value of the '<em><b>Measure Characterization</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasureCharacterization#getSensorDeclaration <em>Sensor Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure Characterization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure Characterization</em>' containment reference.
	 * @see #setMeasureCharacterization(MeasureCharacterization)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getSensorDeclaration_MeasureCharacterization()
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasureCharacterization#getSensorDeclaration
	 * @model opposite="sensorDeclaration" containment="true" required="true" ordered="false"
	 * @generated
	 */
	MeasureCharacterization getMeasureCharacterization();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration#getMeasureCharacterization <em>Measure Characterization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure Characterization</em>' containment reference.
	 * @see #getMeasureCharacterization()
	 * @generated
	 */
	void setMeasureCharacterization(MeasureCharacterization value);

	/**
	 * Returns the value of the '<em><b>Persistency Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.sensorframework.models.emfmodel.PersistenceKindOptions}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistency Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistency Kind</em>' attribute.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.PersistenceKindOptions
	 * @see #setPersistencyKind(PersistenceKindOptions)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getSensorDeclaration_PersistencyKind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PersistenceKindOptions getPersistencyKind();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration#getPersistencyKind <em>Persistency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistency Kind</em>' attribute.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.PersistenceKindOptions
	 * @see #getPersistencyKind()
	 * @generated
	 */
	void setPersistencyKind(PersistenceKindOptions value);

} // SensorDeclaration
