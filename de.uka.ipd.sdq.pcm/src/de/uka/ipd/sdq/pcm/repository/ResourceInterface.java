/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ResourceInterface#getResourceSignatures__ResourceInterface <em>Resource Signatures Resource Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceInterface()
 * @model
 * @generated
 */
public interface ResourceInterface extends Interface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Signatures Resource Interface</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ResourceSignature}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ResourceSignature#getResourceInterface__ResourceSignature <em>Resource Interface Resource Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Signatures Resource Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Signatures Resource Interface</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceInterface_ResourceSignatures__ResourceInterface()
	 * @see de.uka.ipd.sdq.pcm.repository.ResourceSignature#getResourceInterface__ResourceSignature
	 * @model opposite="resourceInterface__ResourceSignature" containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceSignature> getResourceSignatures__ResourceInterface();

} // ResourceInterface
