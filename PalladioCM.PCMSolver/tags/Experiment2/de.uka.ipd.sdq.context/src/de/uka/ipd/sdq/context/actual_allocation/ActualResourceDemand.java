/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation;

import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;

import de.uka.ipd.sdq.stoex.RandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand#getParametricResourceDemand_ActualResourceDemand <em>Parametric Resource Demand Actual Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage#getActualResourceDemand()
 * @model
 * @generated
 */
public interface ActualResourceDemand extends RandomVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

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
	 * @see de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage#getActualResourceDemand_ParametricResourceDemand_ActualResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ParametricResourceDemand getParametricResourceDemand_ActualResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand#getParametricResourceDemand_ActualResourceDemand <em>Parametric Resource Demand Actual Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parametric Resource Demand Actual Resource Demand</em>' reference.
	 * @see #getParametricResourceDemand_ActualResourceDemand()
	 * @generated
	 */
	void setParametricResourceDemand_ActualResourceDemand(ParametricResourceDemand value);

} // ActualResourceDemand
