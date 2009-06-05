/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.experiment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.experiment.Experiment#getResourceUsageSpecification <em>Resource Usage Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.experiment.Experiment#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage#getExperiment()
 * @model
 * @generated
 */
public interface Experiment extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Usage Specification</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Usage Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Usage Specification</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage#getExperiment_ResourceUsageSpecification()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceUsageSpecification> getResourceUsageSpecification();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage#getExperiment_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.experiment.Experiment#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Experiment
