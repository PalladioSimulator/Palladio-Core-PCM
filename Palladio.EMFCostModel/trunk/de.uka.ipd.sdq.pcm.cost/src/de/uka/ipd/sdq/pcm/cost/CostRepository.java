/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cost Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The cost repository is the root element of the cost model. It contains all costs for a PCM instance. 
 * 
 * At first, we assume that all costs in this repository are actually costs in the system. Later, if we have FixedProcessingResourceCost for certain types of, for example, CPUs, we have to check the model first which annotated elements are actually used. Same with alternative components. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getCost <em>Cost</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getCostRepository()
 * @model
 * @generated
 */
public interface CostRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Cost</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.cost.Cost}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cost</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getCostRepository_Cost()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Cost> getCost();

} // CostRepository
