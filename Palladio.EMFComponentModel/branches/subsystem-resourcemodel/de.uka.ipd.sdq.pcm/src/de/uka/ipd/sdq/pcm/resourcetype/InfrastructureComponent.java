/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.InfrastructureComponent#getAvailableInfrastructureComponents_ResourceRepository <em>Available Infrastructure Components Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getInfrastructureComponent()
 * @model
 * @generated
 */
public interface InfrastructureComponent extends ComposedProvidingRequiringEntity, ResourceInterfaceProvidingEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Available Infrastructure Components Resource Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Infrastructure Components Resource Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Infrastructure Components Resource Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getInfrastructureComponent_AvailableInfrastructureComponents_ResourceRepository()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceRepository> getAvailableInfrastructureComponents_ResourceRepository();

} // InfrastructureComponent
