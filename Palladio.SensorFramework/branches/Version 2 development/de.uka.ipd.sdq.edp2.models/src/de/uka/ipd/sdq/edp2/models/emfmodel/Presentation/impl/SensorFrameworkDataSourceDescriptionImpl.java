/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.SensorFrameworkDataSourceDescription;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sensor Framework Data Source Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.SensorFrameworkDataSourceDescriptionImpl#getSam <em>Sam</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SensorFrameworkDataSourceDescriptionImpl extends EObjectImpl implements SensorFrameworkDataSourceDescription {
	/**
	 * The default value of the '{@link #getSam() <em>Sam</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSam()
	 * @generated
	 * @ordered
	 */
	protected static final String SAM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSam() <em>Sam</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSam()
	 * @generated
	 * @ordered
	 */
	protected String sam = SAM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensorFrameworkDataSourceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PresentationPackage.Literals.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSam() {
		return sam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSam(String newSam) {
		String oldSam = sam;
		sam = newSam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM, oldSam, sam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PresentationPackage.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM:
				return getSam();
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
			case PresentationPackage.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM:
				setSam((String)newValue);
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
			case PresentationPackage.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM:
				setSam(SAM_EDEFAULT);
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
			case PresentationPackage.SENSOR_FRAMEWORK_DATA_SOURCE_DESCRIPTION__SAM:
				return SAM_EDEFAULT == null ? sam != null : !SAM_EDEFAULT.equals(sam);
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
		result.append(" (sam: ");
		result.append(sam);
		result.append(')');
		return result.toString();
	}

} //SensorFrameworkDataSourceDescriptionImpl
