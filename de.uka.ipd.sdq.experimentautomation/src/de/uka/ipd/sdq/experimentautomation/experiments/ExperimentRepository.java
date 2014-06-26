/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getExperiments <em>Experiments</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getToolConfiguration <em>Tool Configuration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getRepetitions <em>Repetitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getExperimentRepository()
 * @model
 * @generated
 */
public interface ExperimentRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Experiments</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.experimentautomation.experiments.Experiment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiments</em>' containment reference list.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getExperimentRepository_Experiments()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Experiment> getExperiments();

	/**
	 * Returns the value of the '<em><b>Tool Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Configuration</em>' containment reference list.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getExperimentRepository_ToolConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ToolConfiguration> getToolConfiguration();

	/**
	 * Returns the value of the '<em><b>Repetitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repetitions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repetitions</em>' attribute.
	 * @see #setRepetitions(int)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getExperimentRepository_Repetitions()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getRepetitions();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository#getRepetitions <em>Repetitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repetitions</em>' attribute.
	 * @see #getRepetitions()
	 * @generated
	 */
	void setRepetitions(int value);

} // ExperimentRepository
