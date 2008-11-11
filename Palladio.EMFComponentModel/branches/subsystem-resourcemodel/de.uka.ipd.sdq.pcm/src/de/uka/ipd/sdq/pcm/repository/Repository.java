/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The repository entity allows storing components, data types, and interfaces to be fetched and reused for construction of component instances as well as new component types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryDescription <em>Repository Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository <em>Components Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository <em>Interfaces Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getDatatypes_Repository <em>Datatypes Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Repository Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents a description of the repository.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Repository Description</em>' attribute.
	 * @see #setRepositoryDescription(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_RepositoryDescription()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getRepositoryDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryDescription <em>Repository Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Description</em>' attribute.
	 * @see #getRepositoryDescription()
	 * @generated
	 */
	void setRepositoryDescription(String value);

	/**
	 * Returns the value of the '<em><b>Components Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.RepositoryComponent}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.RepositoryComponent#getRepository_RepositoryComponent <em>Repository Repository Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the provides component types stored in the repository.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Components Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Components__Repository()
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryComponent#getRepository_RepositoryComponent
	 * @model opposite="repository_RepositoryComponent" containment="true" ordered="false"
	 * @generated
	 */
	EList<RepositoryComponent> getComponents__Repository();

	/**
	 * Returns the value of the '<em><b>Interfaces Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.AbstractInterface}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.AbstractInterface#getRepository_AbstractInterface <em>Repository Abstract Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaces Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the interfaces stored in the repository.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interfaces Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Interfaces__Repository()
	 * @see de.uka.ipd.sdq.pcm.repository.AbstractInterface#getRepository_AbstractInterface
	 * @model opposite="repository_AbstractInterface" containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractInterface> getInterfaces__Repository();

	/**
	 * Returns the value of the '<em><b>Datatypes Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.DataType}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.DataType#getRepository_DataType <em>Repository Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatypes Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the data types stored in the repository.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Datatypes Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Datatypes_Repository()
	 * @see de.uka.ipd.sdq.pcm.repository.DataType#getRepository_DataType
	 * @model opposite="repository_DataType" containment="true" ordered="false"
	 * @generated
	 */
	EList<DataType> getDatatypes_Repository();

} // Repository
