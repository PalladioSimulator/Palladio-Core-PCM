/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.experiment;

import de.uka.ipd.sdq.capra.core.ResourceUsage;
import de.uka.ipd.sdq.capra.core.VariableResourceUsage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Usage Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getResourceUsageSpecification <em>Resource Usage Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage#getResourceUsageSpecification()
 * @model
 * @generated
 */
public interface ResourceUsageSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(VariableResourceUsage)
	 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage#getResourceUsageSpecification_Variable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableResourceUsage getVariable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableResourceUsage value);

	/**
	 * Returns the value of the '<em><b>Resource Usage Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Usage Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Usage Specification</em>' containment reference.
	 * @see #setResourceUsageSpecification(ResourceUsage)
	 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage#getResourceUsageSpecification_ResourceUsageSpecification()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ResourceUsage getResourceUsageSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification#getResourceUsageSpecification <em>Resource Usage Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Usage Specification</em>' containment reference.
	 * @see #getResourceUsageSpecification()
	 * @generated
	 */
	void setResourceUsageSpecification(ResourceUsage value);

} // ResourceUsageSpecification
