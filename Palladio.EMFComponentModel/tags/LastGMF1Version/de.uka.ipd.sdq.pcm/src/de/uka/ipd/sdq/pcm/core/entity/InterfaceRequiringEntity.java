
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Requiring Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity#getRequiredRoles_InterfaceRequiringEntity <em>Required Roles Interface Requiring Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getInterfaceRequiringEntity()
 * @model abstract="true"
 * @generated
 */
public interface InterfaceRequiringEntity extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.RequiredRole}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiringEntity_RequiredRole <em>Requiring Entity Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Roles Interface Requiring Entity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Roles Interface Requiring Entity</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity()
	 * @see de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiringEntity_RequiredRole
	 * @model type="de.uka.ipd.sdq.pcm.repository.RequiredRole" opposite="requiringEntity_RequiredRole" containment="true" ordered="false"
	 * @generated
	 */
	EList getRequiredRoles_InterfaceRequiringEntity();

} // InterfaceRequiringEntity