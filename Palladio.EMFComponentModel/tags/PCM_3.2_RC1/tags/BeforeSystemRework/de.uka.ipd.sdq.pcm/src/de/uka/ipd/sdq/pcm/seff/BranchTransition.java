
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.BranchTransition#getBranchCondition <em>Branch Condition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.BranchTransition#getBranchBehaviour_BranchTransition <em>Branch Behaviour Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getBranchTransition()
 * @model
 * @generated
 */
public interface BranchTransition extends EObject {
	/**
	 * Returns the value of the '<em><b>Branch Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Condition</em>' attribute.
	 * @see #setBranchCondition(String)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getBranchTransition_BranchCondition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getBranchCondition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.BranchTransition#getBranchCondition <em>Branch Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Condition</em>' attribute.
	 * @see #getBranchCondition()
	 * @generated
	 */
	void setBranchCondition(String value);

	/**
	 * Returns the value of the '<em><b>Branch Behaviour Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Behaviour Branch Transition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Behaviour Branch Transition</em>' containment reference.
	 * @see #setBranchBehaviour_BranchTransition(ResourceDemandingBehaviour)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getBranchTransition_BranchBehaviour_BranchTransition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ResourceDemandingBehaviour getBranchBehaviour_BranchTransition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.BranchTransition#getBranchBehaviour_BranchTransition <em>Branch Behaviour Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Behaviour Branch Transition</em>' containment reference.
	 * @see #getBranchBehaviour_BranchTransition()
	 * @generated
	 */
	void setBranchBehaviour_BranchTransition(ResourceDemandingBehaviour value);

} // BranchTransition