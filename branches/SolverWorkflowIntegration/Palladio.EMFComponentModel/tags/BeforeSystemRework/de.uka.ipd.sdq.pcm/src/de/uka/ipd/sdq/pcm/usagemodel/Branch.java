
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.Branch#getBranchedBehaviour_Branch <em>Branched Behaviour Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getBranch()
 * @model
 * @generated
 */
public interface Branch extends AbstractUserAction {
	/**
	 * Returns the value of the '<em><b>Branched Behaviour Branch</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branched Behaviour Branch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branched Behaviour Branch</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getBranch_BranchedBehaviour_Branch()
	 * @model type="de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour" containment="true" ordered="false"
	 * @generated
	 */
	EList getBranchedBehaviour_Branch();

} // Branch