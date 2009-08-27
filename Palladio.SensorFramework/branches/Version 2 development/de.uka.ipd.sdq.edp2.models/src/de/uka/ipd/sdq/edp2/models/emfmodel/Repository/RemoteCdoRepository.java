/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Cdo Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RemoteCdoRepository#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRemoteCdoRepository()
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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRemoteCdoRepository_Url()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RemoteCdoRepository#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

} // RemoteCdoRepository
