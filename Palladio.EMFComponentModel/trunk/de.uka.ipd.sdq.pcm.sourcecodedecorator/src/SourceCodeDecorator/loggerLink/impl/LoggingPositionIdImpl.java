/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.loggerLink.impl;

import SourceCodeDecorator.loggerLink.LoggerLinkPackage;
import SourceCodeDecorator.loggerLink.LoggingPositionId;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logging Position Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SourceCodeDecorator.loggerLink.impl.LoggingPositionIdImpl#getLoggingPositionId <em>Logging Position Id</em>}</li>
 *   <li>{@link SourceCodeDecorator.loggerLink.impl.LoggingPositionIdImpl#getServiceEffectSpecification <em>Service Effect Specification</em>}</li>
 *   <li>{@link SourceCodeDecorator.loggerLink.impl.LoggingPositionIdImpl#getAbstractAction <em>Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoggingPositionIdImpl extends EObjectImpl implements LoggingPositionId {
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
	 * The cached value of the '{@link #getServiceEffectSpecification() <em>Service Effect Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceEffectSpecification()
	 * @generated
	 * @ordered
	 */
	protected ServiceEffectSpecification serviceEffectSpecification;

	/**
	 * The cached value of the '{@link #getAbstractAction() <em>Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractAction()
	 * @generated
	 * @ordered
	 */
	protected AbstractAction abstractAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoggingPositionIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerLinkPackage.Literals.LOGGING_POSITION_ID;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerLinkPackage.LOGGING_POSITION_ID__LOGGING_POSITION_ID, oldLoggingPositionId, loggingPositionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification getServiceEffectSpecification() {
		if (serviceEffectSpecification != null && serviceEffectSpecification.eIsProxy()) {
			InternalEObject oldServiceEffectSpecification = (InternalEObject)serviceEffectSpecification;
			serviceEffectSpecification = (ServiceEffectSpecification)eResolveProxy(oldServiceEffectSpecification);
			if (serviceEffectSpecification != oldServiceEffectSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerLinkPackage.LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION, oldServiceEffectSpecification, serviceEffectSpecification));
			}
		}
		return serviceEffectSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification basicGetServiceEffectSpecification() {
		return serviceEffectSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceEffectSpecification(ServiceEffectSpecification newServiceEffectSpecification) {
		ServiceEffectSpecification oldServiceEffectSpecification = serviceEffectSpecification;
		serviceEffectSpecification = newServiceEffectSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerLinkPackage.LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION, oldServiceEffectSpecification, serviceEffectSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getAbstractAction() {
		if (abstractAction != null && abstractAction.eIsProxy()) {
			InternalEObject oldAbstractAction = (InternalEObject)abstractAction;
			abstractAction = (AbstractAction)eResolveProxy(oldAbstractAction);
			if (abstractAction != oldAbstractAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerLinkPackage.LOGGING_POSITION_ID__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
			}
		}
		return abstractAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction basicGetAbstractAction() {
		return abstractAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractAction(AbstractAction newAbstractAction) {
		AbstractAction oldAbstractAction = abstractAction;
		abstractAction = newAbstractAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerLinkPackage.LOGGING_POSITION_ID__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerLinkPackage.LOGGING_POSITION_ID__LOGGING_POSITION_ID:
				return getLoggingPositionId();
			case LoggerLinkPackage.LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION:
				if (resolve) return getServiceEffectSpecification();
				return basicGetServiceEffectSpecification();
			case LoggerLinkPackage.LOGGING_POSITION_ID__ABSTRACT_ACTION:
				if (resolve) return getAbstractAction();
				return basicGetAbstractAction();
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
			case LoggerLinkPackage.LOGGING_POSITION_ID__LOGGING_POSITION_ID:
				setLoggingPositionId((String)newValue);
				return;
			case LoggerLinkPackage.LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION:
				setServiceEffectSpecification((ServiceEffectSpecification)newValue);
				return;
			case LoggerLinkPackage.LOGGING_POSITION_ID__ABSTRACT_ACTION:
				setAbstractAction((AbstractAction)newValue);
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
			case LoggerLinkPackage.LOGGING_POSITION_ID__LOGGING_POSITION_ID:
				setLoggingPositionId(LOGGING_POSITION_ID_EDEFAULT);
				return;
			case LoggerLinkPackage.LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION:
				setServiceEffectSpecification((ServiceEffectSpecification)null);
				return;
			case LoggerLinkPackage.LOGGING_POSITION_ID__ABSTRACT_ACTION:
				setAbstractAction((AbstractAction)null);
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
			case LoggerLinkPackage.LOGGING_POSITION_ID__LOGGING_POSITION_ID:
				return LOGGING_POSITION_ID_EDEFAULT == null ? loggingPositionId != null : !LOGGING_POSITION_ID_EDEFAULT.equals(loggingPositionId);
			case LoggerLinkPackage.LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION:
				return serviceEffectSpecification != null;
			case LoggerLinkPackage.LOGGING_POSITION_ID__ABSTRACT_ACTION:
				return abstractAction != null;
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

} //LoggingPositionIdImpl
