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
 * A representation of the model object '<em><b>Fork Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.ForkAction#getForkedBehaviours_Fork <em>Forked Behaviours Fork</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getForkAction()
 * @model
 * @generated
 */
public interface ForkAction extends AbstractResourceDemandingAction {
	/**
	 * Returns the value of the '<em><b>Forked Behaviours Fork</b></em>' containment reference list.
	 * The list contents are of type {@link de.ipd.uka.sdq.pcm.seff.ResourceDemandingBehaviour}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forked Behaviours Fork</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forked Behaviours Fork</em>' containment reference list.
	 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getForkAction_ForkedBehaviours_Fork()
	 * @model type="de.ipd.uka.sdq.pcm.seff.ResourceDemandingBehaviour" containment="true" ordered="false"
	 * @generated
	 */
	EList getForkedBehaviours_Fork();

} // ForkAction