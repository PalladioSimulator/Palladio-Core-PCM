/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.Cost#getOperatingCost <em>Operating Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.Cost#getInitialCost <em>Initial Cost</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getCost()
 * @model abstract="true"
 * @generated
 */
public interface Cost extends EObject {
	/**
	 * Returns the value of the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operating Cost</em>' attribute.
	 * @see #setOperatingCost(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getCost_OperatingCost()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	double getOperatingCost();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.Cost#getOperatingCost <em>Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating Cost</em>' attribute.
	 * @see #getOperatingCost()
	 * @generated
	 */
	void setOperatingCost(double value);

	/**
	 * Returns the value of the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Cost</em>' attribute.
	 * @see #setInitialCost(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getCost_InitialCost()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	double getInitialCost();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.Cost#getInitialCost <em>Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Cost</em>' attribute.
	 * @see #getInitialCost()
	 * @generated
	 */
	void setInitialCost(double value);

} // Cost
