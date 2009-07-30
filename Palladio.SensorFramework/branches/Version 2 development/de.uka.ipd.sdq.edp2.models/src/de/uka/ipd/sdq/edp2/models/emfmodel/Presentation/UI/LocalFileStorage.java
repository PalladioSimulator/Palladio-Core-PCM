/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local File Storage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage#getFileSystemPath <em>File System Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getLocalFileStorage()
 * @model
 * @generated
 */
public interface LocalFileStorage extends StorageNode {
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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getLocalFileStorage_FileSystemPath()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFileSystemPath();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage#getFileSystemPath <em>File System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File System Path</em>' attribute.
	 * @see #getFileSystemPath()
	 * @generated
	 */
	void setFileSystemPath(String value);

} // LocalFileStorage
