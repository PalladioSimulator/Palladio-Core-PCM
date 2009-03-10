/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exception</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ExceptionImpl#getExceptionMessage <em>Exception Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExceptionImpl extends NamedEntityImpl implements eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception {
	/**
	 * The default value of the '{@link #getExceptionMessage() <em>Exception Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptionMessage() <em>Exception Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionMessage()
	 * @generated
	 * @ordered
	 */
	protected String exceptionMessage = EXCEPTION_MESSAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExceptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.EXCEPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionMessage(String newExceptionMessage) {
		String oldExceptionMessage = exceptionMessage;
		exceptionMessage = newExceptionMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticStructurePackage.EXCEPTION__EXCEPTION_MESSAGE, oldExceptionMessage, exceptionMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StaticStructurePackage.EXCEPTION__EXCEPTION_MESSAGE:
				return getExceptionMessage();
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
			case StaticStructurePackage.EXCEPTION__EXCEPTION_MESSAGE:
				setExceptionMessage((String)newValue);
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
			case StaticStructurePackage.EXCEPTION__EXCEPTION_MESSAGE:
				setExceptionMessage(EXCEPTION_MESSAGE_EDEFAULT);
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
			case StaticStructurePackage.EXCEPTION__EXCEPTION_MESSAGE:
				return EXCEPTION_MESSAGE_EDEFAULT == null ? exceptionMessage != null : !EXCEPTION_MESSAGE_EDEFAULT.equals(exceptionMessage);
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
		result.append(" (ExceptionMessage: ");
		result.append(exceptionMessage);
		result.append(')');
		return result.toString();
	}

} //ExceptionImpl
