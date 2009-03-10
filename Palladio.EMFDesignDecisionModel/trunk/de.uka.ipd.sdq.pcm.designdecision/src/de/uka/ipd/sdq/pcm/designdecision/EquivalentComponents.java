/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equivalent Components</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents#getRepositorycomponent <em>Repositorycomponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEquivalentComponents()
 * @model
 * @generated
 */
public interface EquivalentComponents extends Enumeration {
	/**
	 * Returns the value of the '<em><b>Repositorycomponent</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.RepositoryComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repositorycomponent</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositorycomponent</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEquivalentComponents_Repositorycomponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<RepositoryComponent> getRepositorycomponent();

} // EquivalentComponents
