
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.Entity#getEntityName <em>Entity Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getEntity()
 * @model abstract="true"
 * @generated
 */
public interface Entity extends Identifier {
	/**
	 * Returns the value of the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity Name</em>' attribute.
	 * @see #setEntityName(String)
	 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getEntity_EntityName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getEntityName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.entity.Entity#getEntityName <em>Entity Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity Name</em>' attribute.
	 * @see #getEntityName()
	 * @generated
	 */
	void setEntityName(String value);

} // Entity