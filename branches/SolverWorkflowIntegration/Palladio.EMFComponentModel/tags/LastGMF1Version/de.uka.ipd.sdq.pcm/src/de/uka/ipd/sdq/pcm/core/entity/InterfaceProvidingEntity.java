
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
 * A representation of the model object '<em><b>Interface Providing Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity#getProvidedRoles_InterfaceProvidingEntity <em>Provided Roles Interface Providing Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getInterfaceProvidingEntity()
 * @model abstract="true"
 * @generated
 */
public interface InterfaceProvidingEntity extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ProvidedRole}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity_ProvidedRole <em>Providing Entity Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Roles Interface Providing Entity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Roles Interface Providing Entity</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity()
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity_ProvidedRole
	 * @model type="de.uka.ipd.sdq.pcm.repository.ProvidedRole" opposite="providingEntity_ProvidedRole" containment="true" ordered="false"
	 * @generated
	 */
	EList getProvidedRoles_InterfaceProvidingEntity();

} // InterfaceProvidingEntity