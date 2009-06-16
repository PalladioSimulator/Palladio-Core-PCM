/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An experiment setting belongs to an experiment group and consists of a fixed experimental setting, meaning all independent variables are fixed. This includes variables influencing the generation of the test data, for example the duration of a simulation run leading to the generation of the collected data (later stored in an experiment run). Such a set of collected data is stored as an experiment run. For example, an experiment setting allows repeating a single setting to study statistical significance and variance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getExperimentName <em>Experiment Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getExperimentRuns <em>Experiment Runs</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getMeasure <em>Measure</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getExperimentSetting()
 * @model
 * @generated
 */
public interface ExperimentSetting extends Propertyable {
	/**
	 * Returns the value of the '<em><b>Experiment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Name</em>' attribute.
	 * @see #setExperimentName(String)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getExperimentSetting_ExperimentName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getExperimentName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getExperimentName <em>Experiment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Experiment Name</em>' attribute.
	 * @see #getExperimentName()
	 * @generated
	 */
	void setExperimentName(String value);

	/**
	 * Returns the value of the '<em><b>Experiment Runs</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getExperimentSetting <em>Experiment Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Runs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Runs</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getExperimentSetting_ExperimentRuns()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getExperimentSetting
	 * @model opposite="experimentSetting" containment="true" ordered="false"
	 * @generated
	 */
	EList<ExperimentRun> getExperimentRuns();

	/**
	 * Returns the value of the '<em><b>Measure</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentSettings <em>Experiment Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getExperimentSetting_Measure()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentSettings
	 * @model opposite="experimentSettings" ordered="false"
	 * @generated
	 */
	EList<Edp2Measure> getMeasure();

} // ExperimentSetting
