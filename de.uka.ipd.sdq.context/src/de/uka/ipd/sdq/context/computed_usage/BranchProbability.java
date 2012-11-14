/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Probability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.BranchProbability#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.BranchProbability#getBranchtransition_BranchProbability <em>Branchtransition Branch Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getBranchProbability()
 * @model
 * @generated
 */
public interface BranchProbability extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getBranchProbability_Probability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.BranchProbability#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

	/**
	 * Returns the value of the '<em><b>Branchtransition Branch Probability</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branchtransition Branch Probability</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branchtransition Branch Probability</em>' reference.
	 * @see #setBranchtransition_BranchProbability(AbstractBranchTransition)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getBranchProbability_Branchtransition_BranchProbability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractBranchTransition getBranchtransition_BranchProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.BranchProbability#getBranchtransition_BranchProbability <em>Branchtransition Branch Probability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branchtransition Branch Probability</em>' reference.
	 * @see #getBranchtransition_BranchProbability()
	 * @generated
	 */
	void setBranchtransition_BranchProbability(AbstractBranchTransition value);

} // BranchProbability
