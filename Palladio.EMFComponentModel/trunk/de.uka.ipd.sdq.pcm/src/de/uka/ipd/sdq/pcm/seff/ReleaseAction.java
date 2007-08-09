/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction#getPassiveResource_ReleaseAction <em>Passive Resource Release Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getReleaseAction()
 * @model
 * @generated
 */
public interface ReleaseAction extends AbstractResourceDemandingAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Passive Resource Release Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passive Resource Release Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passive Resource Release Action</em>' reference.
	 * @see #setPassiveResource_ReleaseAction(PassiveResource)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getReleaseAction_PassiveResource_ReleaseAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PassiveResource getPassiveResource_ReleaseAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction#getPassiveResource_ReleaseAction <em>Passive Resource Release Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passive Resource Release Action</em>' reference.
	 * @see #getPassiveResource_ReleaseAction()
	 * @generated
	 */
	void setPassiveResource_ReleaseAction(PassiveResource value);

} // ReleaseAction
