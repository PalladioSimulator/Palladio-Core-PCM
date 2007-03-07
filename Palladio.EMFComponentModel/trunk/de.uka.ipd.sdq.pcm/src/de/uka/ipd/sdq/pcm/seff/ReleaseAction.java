
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.resourcetype.PassiveResourceType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction#getResourceType_Release <em>Resource Type Release</em>}</li>
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
	 * Returns the value of the '<em><b>Resource Type Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type Release</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type Release</em>' reference.
	 * @see #setResourceType_Release(PassiveResourceType)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getReleaseAction_ResourceType_Release()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PassiveResourceType getResourceType_Release();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction#getResourceType_Release <em>Resource Type Release</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type Release</em>' reference.
	 * @see #getResourceType_Release()
	 * @generated
	 */
	void setResourceType_Release(PassiveResourceType value);

} // ReleaseAction
