/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Two types of branch transitions exist which correspond to the two types of branches. The types cannot be mixed. Either all branch transitions of one BranchAction are probabilistic or guarded.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition#getBranchBehaviour_BranchTransition <em>Branch Behaviour Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractBranchTransition()
 * @model abstract="true"
 * @generated
 */
public interface AbstractBranchTransition extends Identifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractBranchTransition_BranchBehaviour_BranchTransition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ResourceDemandingBehaviour getBranchBehaviour_BranchTransition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition#getBranchBehaviour_BranchTransition <em>Branch Behaviour Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Behaviour Branch Transition</em>' containment reference.
	 * @see #getBranchBehaviour_BranchTransition()
	 * @generated
	 */
	void setBranchBehaviour_BranchTransition(ResourceDemandingBehaviour value);

} // AbstractBranchTransition
