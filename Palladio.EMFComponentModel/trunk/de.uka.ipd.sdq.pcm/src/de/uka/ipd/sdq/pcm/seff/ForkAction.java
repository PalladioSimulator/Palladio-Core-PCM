
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fork Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ForkAction#getForkedBehaviours_Fork <em>Forked Behaviours Fork</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkAction()
 * @model
 * @generated
 */
public interface ForkAction extends AbstractResourceDemandingAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Forked Behaviours Fork</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forked Behaviours Fork</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forked Behaviours Fork</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkAction_ForkedBehaviours_Fork()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceDemandingBehaviour> getForkedBehaviours_Fork();

} // ForkAction
