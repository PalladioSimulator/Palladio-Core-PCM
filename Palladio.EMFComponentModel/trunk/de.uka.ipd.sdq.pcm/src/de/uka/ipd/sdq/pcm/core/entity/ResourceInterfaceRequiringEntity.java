/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Interface Requiring Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity#getResourceRequiredRoles_ResourceInterfaceRequiringEntity <em>Resource Required Roles Resource Interface Requiring Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getResourceInterfaceRequiringEntity()
 * @model abstract="true"
 * @generated
 */
public interface ResourceInterfaceRequiringEntity extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Required Roles Resource Interface Requiring Entity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Required Roles Resource Interface Requiring Entity</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getResourceInterfaceRequiringEntity_ResourceRequiredRoles_ResourceInterfaceRequiringEntity()
	 * @see de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole
	 * @model opposite="resourceRequiringEntity_ResourceRequiredRole" containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceRequiredRole> getResourceRequiredRoles_ResourceInterfaceRequiringEntity();

} // ResourceInterfaceRequiringEntity
