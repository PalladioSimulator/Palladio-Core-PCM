
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.BranchTransition#getBranchProbability <em>Branch Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.BranchTransition#getBranchedBehaviour_BranchTransition <em>Branched Behaviour Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getBranchTransition()
 * @model
 * @generated
 */
public interface BranchTransition extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Branch Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Probability</em>' attribute.
	 * @see #setBranchProbability(double)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getBranchTransition_BranchProbability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getBranchProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.BranchTransition#getBranchProbability <em>Branch Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Probability</em>' attribute.
	 * @see #getBranchProbability()
	 * @generated
	 */
	void setBranchProbability(double value);

	/**
	 * Returns the value of the '<em><b>Branched Behaviour Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branched Behaviour Branch Transition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branched Behaviour Branch Transition</em>' containment reference.
	 * @see #setBranchedBehaviour_BranchTransition(ScenarioBehaviour)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getBranchTransition_BranchedBehaviour_BranchTransition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScenarioBehaviour getBranchedBehaviour_BranchTransition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.BranchTransition#getBranchedBehaviour_BranchTransition <em>Branched Behaviour Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branched Behaviour Branch Transition</em>' containment reference.
	 * @see #getBranchedBehaviour_BranchTransition()
	 * @generated
	 */
	void setBranchedBehaviour_BranchTransition(ScenarioBehaviour value);

} // BranchTransition