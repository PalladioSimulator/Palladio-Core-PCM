/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Interface Providing Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * All Entities that provide a ResourceInterface are represented by this class. Inheriting classes are Controllers which manage resource access and ProcessingResourceTypes.
 * 
 * See also:
 * ResourceInterface, InterfaceProvidingEntity, ResourceProvidedRole
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity#getResourceProvidedRole_ResourceInterfaceProvidingEntity <em>Resource Provided Role Resource Interface Providing Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getResourceInterfaceProvidingEntity()
 * @model abstract="true"
 * @generated
 */
public interface ResourceInterfaceProvidingEntity extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Provided Role Resource Interface Providing Entity</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getResourceInterfaceProvidingEntity_ResourceProvidedRole <em>Resource Interface Providing Entity Resource Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Provided Role Resource Interface Providing Entity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Provided Role Resource Interface Providing Entity</em>' containment reference.
	 * @see #setResourceProvidedRole_ResourceInterfaceProvidingEntity(ResourceProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getResourceInterfaceProvidingEntity_ResourceProvidedRole_ResourceInterfaceProvidingEntity()
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getResourceInterfaceProvidingEntity_ResourceProvidedRole
	 * @model opposite="resourceInterfaceProvidingEntity_ResourceProvidedRole" containment="true" required="true" ordered="false"
	 * @generated
	 */
	ResourceProvidedRole getResourceProvidedRole_ResourceInterfaceProvidingEntity();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity#getResourceProvidedRole_ResourceInterfaceProvidingEntity <em>Resource Provided Role Resource Interface Providing Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Provided Role Resource Interface Providing Entity</em>' containment reference.
	 * @see #getResourceProvidedRole_ResourceInterfaceProvidingEntity()
	 * @generated
	 */
	void setResourceProvidedRole_ResourceInterfaceProvidingEntity(ResourceProvidedRole value);

} // ResourceInterfaceProvidingEntity
