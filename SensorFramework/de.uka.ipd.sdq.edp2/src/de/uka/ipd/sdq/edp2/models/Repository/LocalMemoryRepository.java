/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Memory Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Repository&nbsp;which&nbsp;provides&nbsp;access&nbsp;to&nbsp;data&nbsp;stored&nbsp;in&nbsp;local&nbsp;memory (RAM).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository#getDomain <em>Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getLocalMemoryRepository()
 * @model
 * @generated
 */
public interface LocalMemoryRepository extends Repository {
	/**
     * Returns the value of the '<em><b>Domain</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Domain</em>' attribute.
     * @see #setDomain(String)
     * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getLocalMemoryRepository_Domain()
     * @model required="true" ordered="false"
     * @generated
     */
	String getDomain();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository#getDomain <em>Domain</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Domain</em>' attribute.
     * @see #getDomain()
     * @generated
     */
	void setDomain(String value);

} // LocalMemoryRepository
