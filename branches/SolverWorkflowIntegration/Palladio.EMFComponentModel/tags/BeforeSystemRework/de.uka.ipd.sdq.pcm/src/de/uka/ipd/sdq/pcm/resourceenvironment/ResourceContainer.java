
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getPassiveResourceSpecifications_ResourceContainer <em>Passive Resource Specifications Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer()
 * @model
 * @generated
 */
public interface ResourceContainer extends Entity {
	/**
	 * Returns the value of the '<em><b>Active Resource Specifications Resource Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Resource Specifications Resource Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Resource Specifications Resource Container</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_ActiveResourceSpecifications_ResourceContainer()
	 * @model type="de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification" containment="true" ordered="false"
	 * @generated
	 */
	EList getActiveResourceSpecifications_ResourceContainer();

	/**
	 * Returns the value of the '<em><b>Passive Resource Specifications Resource Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passive Resource Specifications Resource Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passive Resource Specifications Resource Container</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_PassiveResourceSpecifications_ResourceContainer()
	 * @model type="de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification" containment="true" ordered="false"
	 * @generated
	 */
	EList getPassiveResourceSpecifications_ResourceContainer();

} // ResourceContainer