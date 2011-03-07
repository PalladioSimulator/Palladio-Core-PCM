/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.InfrastructureSignature#getParameters__InfrastructureSignature <em>Parameters Infrastructure Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInfrastructureSignature()
 * @model
 * @generated
 */
public interface InfrastructureSignature extends Signature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Parameters Infrastructure Signature</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Parameter}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getInfrastructureSignature__Parameter <em>Infrastructure Signature Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters Infrastructure Signature</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters Infrastructure Signature</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInfrastructureSignature_Parameters__InfrastructureSignature()
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter#getInfrastructureSignature__Parameter
	 * @model opposite="infrastructureSignature__Parameter" containment="true" ordered="false"
	 * @generated
	 */
	EList<Parameter> getParameters__InfrastructureSignature();

} // InfrastructureSignature
