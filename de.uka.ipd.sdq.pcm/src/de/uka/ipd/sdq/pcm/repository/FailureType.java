/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents failures that can occur in a software system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.FailureType#getRepository_FailureType <em>Repository Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getFailureType()
 * @model abstract="true"
 * @generated
 */
public interface FailureType extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Repository Failure Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getFailureTypes <em>Failure Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Failure Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Failure Type</em>' container reference.
	 * @see #setRepository_FailureType(Repository)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getFailureType_Repository_FailureType()
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getFailureTypes
	 * @model opposite="failureTypes" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Repository getRepository_FailureType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.FailureType#getRepository_FailureType <em>Repository Failure Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Failure Type</em>' container reference.
	 * @see #getRepository_FailureType()
	 * @generated
	 */
	void setRepository_FailureType(Repository value);

} // FailureType
