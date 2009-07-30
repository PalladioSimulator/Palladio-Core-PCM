/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sensor Framework Version1 Storage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getFileSystemPath <em>File System Path</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getImportSettings <em>Import Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getSensorFrameworkVersion1Storage()
 * @model
 * @generated
 */
public interface SensorFrameworkVersion1Storage extends StorageNode {
	/**
	 * Returns the value of the '<em><b>File System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File System Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File System Path</em>' attribute.
	 * @see #setFileSystemPath(String)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getSensorFrameworkVersion1Storage_FileSystemPath()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFileSystemPath();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getFileSystemPath <em>File System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File System Path</em>' attribute.
	 * @see #getFileSystemPath()
	 * @generated
	 */
	void setFileSystemPath(String value);

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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getSensorFrameworkVersion1Storage_ImportSettings()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getImportSettings();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getImportSettings <em>Import Settings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Settings</em>' attribute.
	 * @see #getImportSettings()
	 * @generated
	 */
	void setImportSettings(String value);

} // SensorFrameworkVersion1Storage
