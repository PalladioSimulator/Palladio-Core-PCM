/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity is an abstract entity from which Interface and ResourceInterface inherit from. Since a Component may provide services of Interfaces or ResourceServices, its ProvidedRole may reference either an
 * Interface or an ResourceInterface and thus only references an AbstractInterface.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.AbstractInterface#getRepository_AbstractInterface <em>Repository Abstract Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getAbstractInterface()
 * @model abstract="true"
 * @generated
 */
public interface AbstractInterface extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Repository Abstract Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository <em>Interfaces Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the repository where this interface is stored.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Repository Abstract Interface</em>' container reference.
	 * @see #setRepository_AbstractInterface(Repository)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getAbstractInterface_Repository_AbstractInterface()
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository
	 * @model opposite="interfaces__Repository" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Repository getRepository_AbstractInterface();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.AbstractInterface#getRepository_AbstractInterface <em>Repository Abstract Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Abstract Interface</em>' container reference.
	 * @see #getRepository_AbstractInterface()
	 * @generated
	 */
	void setRepository_AbstractInterface(Repository value);

} // AbstractInterface
