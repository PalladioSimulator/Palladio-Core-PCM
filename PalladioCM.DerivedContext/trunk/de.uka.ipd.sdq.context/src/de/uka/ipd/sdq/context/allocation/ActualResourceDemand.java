/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.allocation;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getParametricResourceDemand_ActualResourceDemand <em>Parametric Resource Demand Actual Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getRandomVariable_ActualResourceDemand <em>Random Variable Actual Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.allocation.AllocationPackage#getActualResourceDemand()
 * @model
 * @generated
 */
public interface ActualResourceDemand extends EObject {
	/**
	 * Returns the value of the '<em><b>Parametric Resource Demand Actual Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parametric Resource Demand Actual Resource Demand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parametric Resource Demand Actual Resource Demand</em>' reference.
	 * @see #setParametricResourceDemand_ActualResourceDemand(ParametricResourceDemand)
	 * @see de.uka.ipd.sdq.context.allocation.AllocationPackage#getActualResourceDemand_ParametricResourceDemand_ActualResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ParametricResourceDemand getParametricResourceDemand_ActualResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getParametricResourceDemand_ActualResourceDemand <em>Parametric Resource Demand Actual Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parametric Resource Demand Actual Resource Demand</em>' reference.
	 * @see #getParametricResourceDemand_ActualResourceDemand()
	 * @generated
	 */
	void setParametricResourceDemand_ActualResourceDemand(ParametricResourceDemand value);

	/**
	 * Returns the value of the '<em><b>Random Variable Actual Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Random Variable Actual Resource Demand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Random Variable Actual Resource Demand</em>' reference.
	 * @see #setRandomVariable_ActualResourceDemand(RandomVariable)
	 * @see de.uka.ipd.sdq.context.allocation.AllocationPackage#getActualResourceDemand_RandomVariable_ActualResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RandomVariable getRandomVariable_ActualResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getRandomVariable_ActualResourceDemand <em>Random Variable Actual Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Random Variable Actual Resource Demand</em>' reference.
	 * @see #getRandomVariable_ActualResourceDemand()
	 * @generated
	 */
	void setRandomVariable_ActualResourceDemand(RandomVariable value);

} // ActualResourceDemand