/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logging Position Id Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl#getLoggingPositionId <em>Logging Position Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LoggingPositionIdLinkImpl extends IdentifierImpl implements LoggingPositionIdLink {
	/**
	 * The default value of the '{@link #getLoggingPositionId() <em>Logging Position Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoggingPositionId()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGGING_POSITION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoggingPositionId() <em>Logging Position Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoggingPositionId()
	 * @generated
	 * @ordered
	 */
	protected String loggingPositionId = LOGGING_POSITION_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoggingPositionIdLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.LOGGING_POSITION_ID_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLoggingPositionId() {
		return loggingPositionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoggingPositionId(String newLoggingPositionId) {
		String oldLoggingPositionId = loggingPositionId;
		loggingPositionId = newLoggingPositionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID, oldLoggingPositionId, loggingPositionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID:
				return getLoggingPositionId();
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
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID:
				setLoggingPositionId((String)newValue);
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
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID:
				setLoggingPositionId(LOGGING_POSITION_ID_EDEFAULT);
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
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID:
				return LOGGING_POSITION_ID_EDEFAULT == null ? loggingPositionId != null : !LOGGING_POSITION_ID_EDEFAULT.equals(loggingPositionId);
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
		result.append(" (loggingPositionId: ");
		result.append(loggingPositionId);
		result.append(')');
		return result.toString();
	}

} //LoggingPositionIdLinkImpl
