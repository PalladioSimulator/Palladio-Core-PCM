/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sensor Framework Version1 Storage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.SensorFrameworkVersion1StorageImpl#getFileSystemPath <em>File System Path</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.SensorFrameworkVersion1StorageImpl#getImportSettings <em>Import Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SensorFrameworkVersion1StorageImpl extends StorageNodeImpl implements SensorFrameworkVersion1Storage {
	/**
	 * The default value of the '{@link #getFileSystemPath() <em>File System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileSystemPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_SYSTEM_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileSystemPath() <em>File System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileSystemPath()
	 * @generated
	 * @ordered
	 */
	protected String fileSystemPath = FILE_SYSTEM_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportSettings() <em>Import Settings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportSettings()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_SETTINGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportSettings() <em>Import Settings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportSettings()
	 * @generated
	 * @ordered
	 */
	protected String importSettings = IMPORT_SETTINGS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensorFrameworkVersion1StorageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIPackage.Literals.SENSOR_FRAMEWORK_VERSION1_STORAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileSystemPath() {
		return fileSystemPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileSystemPath(String newFileSystemPath) {
		String oldFileSystemPath = fileSystemPath;
		fileSystemPath = newFileSystemPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH, oldFileSystemPath, fileSystemPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportSettings() {
		return importSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportSettings(String newImportSettings) {
		String oldImportSettings = importSettings;
		importSettings = newImportSettings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS, oldImportSettings, importSettings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH:
				return getFileSystemPath();
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS:
				return getImportSettings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH:
				setFileSystemPath((String)newValue);
				return;
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS:
				setImportSettings((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH:
				setFileSystemPath(FILE_SYSTEM_PATH_EDEFAULT);
				return;
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS:
				setImportSettings(IMPORT_SETTINGS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH:
				return FILE_SYSTEM_PATH_EDEFAULT == null ? fileSystemPath != null : !FILE_SYSTEM_PATH_EDEFAULT.equals(fileSystemPath);
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS:
				return IMPORT_SETTINGS_EDEFAULT == null ? importSettings != null : !IMPORT_SETTINGS_EDEFAULT.equals(importSettings);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileSystemPath: ");
		result.append(fileSystemPath);
		result.append(", importSettings: ");
		result.append(importSettings);
		result.append(')');
		return result.toString();
	}

} //SensorFrameworkVersion1StorageImpl
