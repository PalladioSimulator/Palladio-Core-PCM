/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container Replication Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice#getMultiplicityOfResourceContainer <em>Multiplicity Of Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getResourceContainerReplicationChoice()
 * @model
 * @generated
 */
public interface ResourceContainerReplicationChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Multiplicity Of Resource Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity Of Resource Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity Of Resource Container</em>' attribute.
	 * @see #setMultiplicityOfResourceContainer(int)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getResourceContainerReplicationChoice_MultiplicityOfResourceContainer()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getMultiplicityOfResourceContainer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice#getMultiplicityOfResourceContainer <em>Multiplicity Of Resource Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity Of Resource Container</em>' attribute.
	 * @see #getMultiplicityOfResourceContainer()
	 * @generated
	 */
	void setMultiplicityOfResourceContainer(int value);

} // ResourceContainerReplicationChoice
