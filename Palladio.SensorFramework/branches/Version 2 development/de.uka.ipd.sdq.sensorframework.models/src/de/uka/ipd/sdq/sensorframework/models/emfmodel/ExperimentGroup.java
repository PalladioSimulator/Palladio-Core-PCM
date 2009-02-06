/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An experiment group contains all experiments which belong to a single analysis. An example for an experiment group is a scalability analysis or architectural alternative comparison including the corresponding set of experiments.
 * 
 * Experiment groups can be either a manual or automatic analysis
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup#getExperimentSettings <em>Experiment Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getExperimentGroup()
 * @model
 * @generated
 */
public interface ExperimentGroup extends Identifiable, Propertyable {
	/**
	 * Returns the value of the '<em><b>Experiment Settings</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentSetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Settings</em>' containment reference list.
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getExperimentGroup_ExperimentSettings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ExperimentSetting> getExperimentSettings();

} // ExperimentGroup
