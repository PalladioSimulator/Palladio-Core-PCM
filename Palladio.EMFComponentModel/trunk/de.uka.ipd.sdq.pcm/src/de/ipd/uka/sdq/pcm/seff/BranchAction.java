/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.BranchAction#getBranches_Branch <em>Branches Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getBranchAction()
 * @model
 * @generated
 */
public interface BranchAction extends AbstractResourceDemandingAction {
	/**
	 * Returns the value of the '<em><b>Branches Branch</b></em>' containment reference list.
	 * The list contents are of type {@link de.ipd.uka.sdq.pcm.seff.BranchTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches Branch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches Branch</em>' containment reference list.
	 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getBranchAction_Branches_Branch()
	 * @model type="de.ipd.uka.sdq.pcm.seff.BranchTransition" containment="true" ordered="false"
	 * @generated
	 */
	EList getBranches_Branch();

} // BranchAction