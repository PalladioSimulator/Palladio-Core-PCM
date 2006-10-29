
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Component Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ChildComponentContext#getEncapsulatedComponent_ChildComponentContext <em>Encapsulated Component Child Component Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getChildComponentContext()
 * @model
 * @generated
 */
public interface ChildComponentContext extends Entity {
	/**
	 * Returns the value of the '<em><b>Encapsulated Component Child Component Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encapsulated Component Child Component Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encapsulated Component Child Component Context</em>' reference.
	 * @see #setEncapsulatedComponent_ChildComponentContext(ProvidesComponentType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getChildComponentContext_EncapsulatedComponent_ChildComponentContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidesComponentType getEncapsulatedComponent_ChildComponentContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ChildComponentContext#getEncapsulatedComponent_ChildComponentContext <em>Encapsulated Component Child Component Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encapsulated Component Child Component Context</em>' reference.
	 * @see #getEncapsulatedComponent_ChildComponentContext()
	 * @generated
	 */
	void setEncapsulatedComponent_ChildComponentContext(ProvidesComponentType value);

} // ChildComponentContext