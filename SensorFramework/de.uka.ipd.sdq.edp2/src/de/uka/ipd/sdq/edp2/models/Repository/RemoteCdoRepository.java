/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Cdo Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Provides access to data stored in a remote location on a CDO server.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getRemoteCdoRepository()
 * @model
 * @generated
 */
public interface RemoteCdoRepository extends Repository {
	/**
     * Returns the value of the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getRemoteCdoRepository_Url()
     * @model required="true" ordered="false"
     * @generated
     */
	String getUrl();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository#getUrl <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */
	void setUrl(String value);

} // RemoteCdoRepository
