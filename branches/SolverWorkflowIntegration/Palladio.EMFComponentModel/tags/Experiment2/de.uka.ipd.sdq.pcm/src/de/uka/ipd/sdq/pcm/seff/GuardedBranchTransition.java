
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guarded Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_BranchTransition <em>Branch Condition Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getGuardedBranchTransition()
 * @model
 * @generated
 */
public interface GuardedBranchTransition extends AbstractBranchTransition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Branch Condition Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Condition Branch Transition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Condition Branch Transition</em>' containment reference.
	 * @see #setBranchCondition_BranchTransition(BranchCondition)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getGuardedBranchTransition_BranchCondition_BranchTransition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	BranchCondition getBranchCondition_BranchTransition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_BranchTransition <em>Branch Condition Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Condition Branch Transition</em>' containment reference.
	 * @see #getBranchCondition_BranchTransition()
	 * @generated
	 */
	void setBranchCondition_BranchTransition(BranchCondition value);

} // GuardedBranchTransition
