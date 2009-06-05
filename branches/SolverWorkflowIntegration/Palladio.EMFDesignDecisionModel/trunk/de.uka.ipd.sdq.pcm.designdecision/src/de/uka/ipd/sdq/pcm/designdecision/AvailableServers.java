/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Available Servers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.AvailableServers#getResourcecontainer <em>Resourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAvailableServers()
 * @model
 * @generated
 */
public interface AvailableServers extends Enumeration {
	/**
	 * Returns the value of the '<em><b>Resourcecontainer</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resourcecontainer</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resourcecontainer</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAvailableServers_Resourcecontainer()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<ResourceContainer> getResourcecontainer();

} // AvailableServers
