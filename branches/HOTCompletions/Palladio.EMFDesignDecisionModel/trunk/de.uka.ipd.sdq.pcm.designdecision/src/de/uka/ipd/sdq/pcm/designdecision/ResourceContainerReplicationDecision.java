/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container Replication Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision#getResourcecontainer <em>Resourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getResourceContainerReplicationDecision()
 * @model
 * @generated
 */
public interface ResourceContainerReplicationDecision extends DesignDecision {
	/**
	 * Returns the value of the '<em><b>Resourcecontainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resourcecontainer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resourcecontainer</em>' reference.
	 * @see #setResourcecontainer(ResourceContainer)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getResourceContainerReplicationDecision_Resourcecontainer()
	 * @model ordered="false"
	 * @generated
	 */
	ResourceContainer getResourcecontainer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision#getResourcecontainer <em>Resourcecontainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resourcecontainer</em>' reference.
	 * @see #getResourcecontainer()
	 * @generated
	 */
	void setResourcecontainer(ResourceContainer value);

} // ResourceContainerReplicationDecision
