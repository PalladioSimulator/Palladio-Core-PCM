/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Sensor Framework Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalSensorFrameworkRepositoryImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalSensorFrameworkRepositoryImpl#getImportSettings <em>Import Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalSensorFrameworkRepositoryImpl extends RepositoryImpl implements LocalSensorFrameworkRepository {
	/**
     * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
	protected static final String URI_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
	protected String uri = URI_EDEFAULT;

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
	protected LocalSensorFrameworkRepositoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return RepositoryPackage.Literals.LOCAL_SENSOR_FRAMEWORK_REPOSITORY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getUri() {
        return uri;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUri(String newUri) {
        String oldUri = uri;
        uri = newUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI, oldUri, uri));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS, oldImportSettings, importSettings));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI:
                return getUri();
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS:
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
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI:
                setUri((String)newValue);
                return;
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS:
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
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI:
                setUri(URI_EDEFAULT);
                return;
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS:
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
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI:
                return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS:
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
        result.append(" (uri: ");
        result.append(uri);
        result.append(", importSettings: ");
        result.append(importSettings);
        result.append(')');
        return result.toString();
    }

} //LocalSensorFrameworkRepositoryImpl
