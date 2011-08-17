/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import de.uka.ipd.sdq.pcm.allocation.Allocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Cost Per Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ComponentCostPerInstance are also costs for components; however, they occur per instance of the referenced components. The
 * referenced Allocation is used to determine the number of instances of the component, which is multiplied by the costs per
 * instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance#getAllocation <em>Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCostPerInstance()
 * @model
 * @generated
 */
public interface ComponentCostPerInstance extends ComponentCost {
	/**
	 * Returns the value of the '<em><b>Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation</em>' reference.
	 * @see #setAllocation(Allocation)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getComponentCostPerInstance_Allocation()
	 * @model ordered="false"
	 * @generated
	 */
	Allocation getAllocation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance#getAllocation <em>Allocation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation</em>' reference.
	 * @see #getAllocation()
	 * @generated
	 */
	void setAllocation(Allocation value);

} // ComponentCostPerInstance
