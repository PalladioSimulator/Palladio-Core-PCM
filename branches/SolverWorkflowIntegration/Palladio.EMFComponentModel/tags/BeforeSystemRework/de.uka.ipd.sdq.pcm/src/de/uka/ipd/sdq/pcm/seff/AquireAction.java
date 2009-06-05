
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
 * A representation of the model object '<em><b>Aquire Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AquireAction#getResourceType_Aquire <em>Resource Type Aquire</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAquireAction()
 * @model
 * @generated
 */
public interface AquireAction extends AbstractResourceDemandingAction {
	/**
	 * Returns the value of the '<em><b>Resource Type Aquire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type Aquire</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type Aquire</em>' reference.
	 * @see #setResourceType_Aquire(PassiveResourceType)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAquireAction_ResourceType_Aquire()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PassiveResourceType getResourceType_Aquire();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AquireAction#getResourceType_Aquire <em>Resource Type Aquire</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type Aquire</em>' reference.
	 * @see #getResourceType_Aquire()
	 * @generated
	 */
	void setResourceType_Aquire(PassiveResourceType value);

} // AquireAction