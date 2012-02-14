/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container Replication Degree With Component Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Resource Replication, but for each replication level the i-th referenced RepositoryComponent is put into the referenced
 * allocation context, if fitting.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegreeWithComponentChange#getExchangeComponentRule <em>Exchange Component Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getResourceContainerReplicationDegreeWithComponentChange()
 * @model
 * @generated
 */
public interface ResourceContainerReplicationDegreeWithComponentChange extends ResourceContainerReplicationDegree {
	/**
	 * Returns the value of the '<em><b>Exchange Component Rule</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.ExchangeComponentRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exchange Component Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exchange Component Rule</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getResourceContainerReplicationDegreeWithComponentChange_ExchangeComponentRule()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ExchangeComponentRule> getExchangeComponentRule();

} // ResourceContainerReplicationDegreeWithComponentChange
