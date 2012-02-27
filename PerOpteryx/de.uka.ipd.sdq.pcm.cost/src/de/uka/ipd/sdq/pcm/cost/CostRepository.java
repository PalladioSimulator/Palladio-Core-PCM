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
 * The cost repository is the root element of the cost model. It contains all costs for a PCM instance and for the different design alternatives. 
 * 
 * If we have FixedProcessingResourceCost for certain types of, for example, CPUs, we have to check the model first which annotated elements are actually used. Same with alternative components. Only used elements lead to overall cost of the system. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getCost <em>Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getTimePeriodYears <em>Time Period Years</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getInterest <em>Interest</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Time Period Years</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time period in which the operating costs are expected.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Time Period Years</em>' attribute.
	 * @see #setTimePeriodYears(int)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getCostRepository_TimePeriodYears()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getTimePeriodYears();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getTimePeriodYears <em>Time Period Years</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Period Years</em>' attribute.
	 * @see #getTimePeriodYears()
	 * @generated
	 */
	void setTimePeriodYears(int value);

	/**
	 * Returns the value of the '<em><b>Interest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interest</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     Assumed&nbsp;interest&nbsp;rate&nbsp;per&nbsp;year for calculating the present value based on the operating costs and
	 *     the considered time frame in years given by timePeriodYears.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interest</em>' attribute.
	 * @see #setInterest(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getCostRepository_Interest()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getInterest();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getInterest <em>Interest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interest</em>' attribute.
	 * @see #getInterest()
	 * @generated
	 */
	void setInterest(double value);

} // CostRepository
