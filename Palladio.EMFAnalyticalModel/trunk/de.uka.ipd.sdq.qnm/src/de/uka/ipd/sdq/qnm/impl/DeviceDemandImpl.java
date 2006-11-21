/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.qnm.DeviceDemand;
import de.uka.ipd.sdq.qnm.DeviceServer;
import de.uka.ipd.sdq.qnm.QnmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.DeviceDemandImpl#getDeviceServer <em>Device Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.DeviceDemandImpl#getServiceTime <em>Service Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeviceDemandImpl extends DemandImpl implements DeviceDemand {
	/**
	 * The cached value of the '{@link #getDeviceServer() <em>Device Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceServer()
	 * @generated
	 * @ordered
	 */
	protected DeviceServer deviceServer = null;

	/**
	 * The default value of the '{@link #getServiceTime() <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTime()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF SERVICE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceTime() <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTime()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF serviceTime = SERVICE_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceDemandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QnmPackage.Literals.DEVICE_DEMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceServer getDeviceServer() {
		if (deviceServer != null && deviceServer.eIsProxy()) {
			InternalEObject oldDeviceServer = (InternalEObject)deviceServer;
			deviceServer = (DeviceServer)eResolveProxy(oldDeviceServer);
			if (deviceServer != oldDeviceServer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QnmPackage.DEVICE_DEMAND__DEVICE_SERVER, oldDeviceServer, deviceServer));
			}
		}
		return deviceServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceServer basicGetDeviceServer() {
		return deviceServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeviceServer(DeviceServer newDeviceServer) {
		DeviceServer oldDeviceServer = deviceServer;
		deviceServer = newDeviceServer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QnmPackage.DEVICE_DEMAND__DEVICE_SERVER, oldDeviceServer, deviceServer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getServiceTime() {
		return serviceTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceTime(ManagedPDF newServiceTime) {
		ManagedPDF oldServiceTime = serviceTime;
		serviceTime = newServiceTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QnmPackage.DEVICE_DEMAND__SERVICE_TIME, oldServiceTime, serviceTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QnmPackage.DEVICE_DEMAND__DEVICE_SERVER:
				if (resolve) return getDeviceServer();
				return basicGetDeviceServer();
			case QnmPackage.DEVICE_DEMAND__SERVICE_TIME:
				return getServiceTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QnmPackage.DEVICE_DEMAND__DEVICE_SERVER:
				setDeviceServer((DeviceServer)newValue);
				return;
			case QnmPackage.DEVICE_DEMAND__SERVICE_TIME:
				setServiceTime((ManagedPDF)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case QnmPackage.DEVICE_DEMAND__DEVICE_SERVER:
				setDeviceServer((DeviceServer)null);
				return;
			case QnmPackage.DEVICE_DEMAND__SERVICE_TIME:
				setServiceTime(SERVICE_TIME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QnmPackage.DEVICE_DEMAND__DEVICE_SERVER:
				return deviceServer != null;
			case QnmPackage.DEVICE_DEMAND__SERVICE_TIME:
				return SERVICE_TIME_EDEFAULT == null ? serviceTime != null : !SERVICE_TIME_EDEFAULT.equals(serviceTime);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (serviceTime: ");
		result.append(serviceTime);
		result.append(')');
		return result.toString();
	}

} //DeviceDemandImpl