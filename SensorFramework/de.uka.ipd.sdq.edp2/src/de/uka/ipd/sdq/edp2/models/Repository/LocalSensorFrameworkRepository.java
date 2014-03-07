/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Sensor Framework Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Provides&nbsp;access&nbsp;to&nbsp;data&nbsp;stored&nbsp;in&nbsp;the&nbsp;SensorFramework&nbsp;format&nbsp;in&nbsp;a&nbsp;local&nbsp;directory.
 * Also contains the import settings which provide the necessary additional information to process the information from the
 * SensorFramework.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getUri <em>Uri</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getImportSettings <em>Import Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getLocalSensorFrameworkRepository()
 * @model
 * @generated
 */
public interface LocalSensorFrameworkRepository extends Repository {
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
     * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getLocalSensorFrameworkRepository_Uri()
     * @model required="true" ordered="false"
     * @generated
     */
	String getUri();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getUri <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
	void setUri(String value);

	/**
     * Returns the value of the '<em><b>Import Settings</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Settings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Import Settings</em>' attribute.
     * @see #setImportSettings(String)
     * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getLocalSensorFrameworkRepository_ImportSettings()
     * @model required="true" ordered="false"
     * @generated
     */
	String getImportSettings();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getImportSettings <em>Import Settings</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import Settings</em>' attribute.
     * @see #getImportSettings()
     * @generated
     */
	void setImportSettings(String value);

} // LocalSensorFrameworkRepository
