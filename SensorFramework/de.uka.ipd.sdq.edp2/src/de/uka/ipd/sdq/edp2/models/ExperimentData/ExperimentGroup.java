/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.edp2.models.Repository.Repository;

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
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getMeasure <em>Measure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getRepository <em>Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getExperimentGroup()
 * @model
 * @generated
 */
public interface ExperimentGroup extends Identifiable, Propertyable {
	/**
     * Returns the value of the '<em><b>Experiment Settings</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting#getExperimentGroup <em>Experiment Group</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Experiment Settings</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getExperimentGroup_ExperimentSettings()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting#getExperimentGroup
     * @model opposite="experimentGroup" containment="true" ordered="false"
     * @generated
     */
	EList<ExperimentSetting> getExperimentSettings();

	/**
     * Returns the value of the '<em><b>Repository</b></em>' reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository#getExperimentGroups <em>Experiment Groups</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Repository in which this experiment group is stored.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Repository</em>' reference.
     * @see #setRepository(Repository)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getExperimentGroup_Repository()
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository#getExperimentGroups
     * @model opposite="experimentGroups" transient="true" ordered="false"
     * @generated
     */
	Repository getRepository();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getRepository <em>Repository</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Repository</em>' reference.
     * @see #getRepository()
     * @generated
     */
	void setRepository(Repository value);

	/**
     * Returns the value of the '<em><b>Purpose</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Purpose</em>' attribute.
     * @see #setPurpose(String)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getExperimentGroup_Purpose()
     * @model required="true" ordered="false"
     * @generated
     */
	String getPurpose();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup#getPurpose <em>Purpose</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Purpose</em>' attribute.
     * @see #getPurpose()
     * @generated
     */
	void setPurpose(String value);

	/**
     * Returns the value of the '<em><b>Measure</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getExperimentGroup <em>Experiment Group</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Measure</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getExperimentGroup_Measure()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure#getExperimentGroup
     * @model opposite="experimentGroup" containment="true" ordered="false"
     * @generated
     */
	EList<Edp2Measure> getMeasure();

} // ExperimentGroup
