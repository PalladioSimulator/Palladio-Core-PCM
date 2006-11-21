/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.DeviceDemand#getDeviceServer <em>Device Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.DeviceDemand#getServiceTime <em>Service Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.QnmPackage#getDeviceDemand()
 * @model
 * @generated
 */
public interface DeviceDemand extends ResourceUsage {
	/**
	 * Returns the value of the '<em><b>Device Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device Server</em>' reference.
	 * @see #setDeviceServer(DeviceServer)
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getDeviceDemand_DeviceServer()
	 * @model required="true"
	 * @generated
	 */
	DeviceServer getDeviceServer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.DeviceDemand#getDeviceServer <em>Device Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Server</em>' reference.
	 * @see #getDeviceServer()
	 * @generated
	 */
	void setDeviceServer(DeviceServer value);

	/**
	 * Returns the value of the '<em><b>Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Time</em>' attribute.
	 * @see #setServiceTime(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getDeviceDemand_ServiceTime()
	 * @model unique="false" dataType="de.uka.ipd.sdq.qnm.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getServiceTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.DeviceDemand#getServiceTime <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Time</em>' attribute.
	 * @see #getServiceTime()
	 * @generated
	 */
	void setServiceTime(ManagedPDF value);

} // DeviceDemand