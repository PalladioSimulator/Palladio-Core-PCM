/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.repository.AbstractInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ResourceInterface represents an interface which is used for resource access. It is similar to the traditional Interface, but it contains 
 * special ResourceServices instead of Signatures.
 * A ResourceInterface is referenced by ResourceRequiredRoles and ResourceProvidedRoles. Any entity can either claim to implement the functionality specified in an ResourceInterface or to request that functionality.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getResourceServices_ResourceInterface <em>Resource Services Resource Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getAncestorResourceInterfaces_ResourceInterface <em>Ancestor Resource Interfaces Resource Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getParentResourceInterface__ResourceInterface <em>Parent Resource Interface Resource Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceInterface()
 * @model
 * @generated
 */
public interface ResourceInterface extends AbstractInterface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Services Resource Interface</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceService}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getResourceInterface_ResourceService <em>Resource Interface Resource Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Services Resource Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Services Resource Interface</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceInterface_ResourceServices_ResourceInterface()
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getResourceInterface_ResourceService
	 * @model opposite="resourceInterface_ResourceService" containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceService> getResourceServices_ResourceInterface();

	/**
	 * Returns the value of the '<em><b>Ancestor Resource Interfaces Resource Interface</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ancestor Resource Interfaces Resource Interface</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ancestor Resource Interfaces Resource Interface</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceInterface_AncestorResourceInterfaces_ResourceInterface()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ResourceInterface> getAncestorResourceInterfaces_ResourceInterface();

	/**
	 * Returns the value of the '<em><b>Parent Resource Interface Resource Interface</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Resource Interface Resource Interface</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Resource Interface Resource Interface</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceInterface_ParentResourceInterface__ResourceInterface()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ResourceInterface> getParentResourceInterface__ResourceInterface();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.resourceServices_ResourceInterface->isUnique(r : ResourceService |
	 * 	r.serviceName)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ResourceServiceNamesHaveToBeUniqueForAResourceInterface(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceInterface
