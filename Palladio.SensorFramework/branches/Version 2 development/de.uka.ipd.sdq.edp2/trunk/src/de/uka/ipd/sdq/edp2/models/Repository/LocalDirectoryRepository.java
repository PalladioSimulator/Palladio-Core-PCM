/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Directory Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getLocalDirectoryRepository()
 * @model
 * @generated
 */
public interface LocalDirectoryRepository extends Repository {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getLocalDirectoryRepository_Uri()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // LocalDirectoryRepository
