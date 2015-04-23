/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.protocol.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.protocol.Protocol;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Protocol</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.protocol.impl.ProtocolImpl#getProtocolTypeID <em>Protocol Type ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProtocolImpl extends EStereotypableObjectImpl implements
		Protocol {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getProtocolTypeID() <em>Protocol Type ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProtocolTypeID()
	 * @generated
	 * @ordered
	 */
	protected static final String PROTOCOL_TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProtocolTypeID() <em>Protocol Type ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProtocolTypeID()
	 * @generated
	 * @ordered
	 */
	protected String protocolTypeID = PROTOCOL_TYPE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProtocolTypeID() {
		return protocolTypeID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProtocolTypeID(String newProtocolTypeID) {
		String oldProtocolTypeID = protocolTypeID;
		protocolTypeID = newProtocolTypeID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID,
					oldProtocolTypeID, protocolTypeID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
			return getProtocolTypeID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
			setProtocolTypeID((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
			setProtocolTypeID(PROTOCOL_TYPE_ID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ProtocolPackage.PROTOCOL__PROTOCOL_TYPE_ID:
			return PROTOCOL_TYPE_ID_EDEFAULT == null ? protocolTypeID != null
					: !PROTOCOL_TYPE_ID_EDEFAULT.equals(protocolTypeID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (protocolTypeID: ");
		result.append(protocolTypeID);
		result.append(')');
		return result.toString();
	}

} // ProtocolImpl
