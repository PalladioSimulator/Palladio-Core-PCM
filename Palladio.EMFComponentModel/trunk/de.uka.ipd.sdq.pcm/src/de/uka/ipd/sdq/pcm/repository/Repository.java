
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryDescription <em>Repository Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryName <em>Repository Name</em>}</li>
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
public interface Repository extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Repository Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Description</em>' attribute.
	 * @see #setRepositoryDescription(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_RepositoryDescription()
	 * @model unique="false" required="true" ordered="false"
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
	 * Returns the value of the '<em><b>Repository Name</b></em>' attribute.
	 * The default value is <code>"New Component Model"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Name</em>' attribute.
	 * @see #setRepositoryName(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_RepositoryName()
	 * @model default="New Component Model" unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getRepositoryName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryName <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Name</em>' attribute.
	 * @see #getRepositoryName()
	 * @generated
	 */
	void setRepositoryName(String value);

	/**
	 * Returns the value of the '<em><b>Components Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Components__Repository()
	 * @model type="de.uka.ipd.sdq.pcm.repository.ProvidesComponentType" containment="true" ordered="false"
	 * @generated
	 */
	EList getComponents__Repository();

	/**
	 * Returns the value of the '<em><b>Interfaces Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaces Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Interfaces__Repository()
	 * @model type="de.uka.ipd.sdq.pcm.repository.Interface" containment="true" ordered="false"
	 * @generated
	 */
	EList getInterfaces__Repository();

	/**
	 * Returns the value of the '<em><b>Datatypes Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatypes Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatypes Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Datatypes_Repository()
	 * @model type="de.uka.ipd.sdq.pcm.repository.DataType" containment="true" ordered="false"
	 * @generated
	 */
	EList getDatatypes_Repository();

} // Repository