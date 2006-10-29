
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts <em>Allocation Contexts</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation()
 * @model
 * @generated
 */
public interface Allocation extends Entity {
	/**
	 * Returns the value of the '<em><b>Allocation Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.allocation.AllocationContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Contexts</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_AllocationContexts()
	 * @model type="de.uka.ipd.sdq.pcm.allocation.AllocationContext" containment="true" ordered="false"
	 * @generated
	 */
	EList getAllocationContexts();

	/**
	 * Returns the value of the '<em><b>Target Resource Environment Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Resource Environment Allocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Resource Environment Allocation</em>' reference.
	 * @see #setTargetResourceEnvironment_Allocation(ResourceEnvironment)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_TargetResourceEnvironment_Allocation()
	 * @model ordered="false"
	 * @generated
	 */
	ResourceEnvironment getTargetResourceEnvironment_Allocation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>Target Resource Environment Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Resource Environment Allocation</em>' reference.
	 * @see #getTargetResourceEnvironment_Allocation()
	 * @generated
	 */
	void setTargetResourceEnvironment_Allocation(ResourceEnvironment value);

} // Allocation