/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl#isIsInputPosition <em>Is Input Position</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl#getServiceEffectSpecification <em>Service Effect Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl#getAbstractAction <em>Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoggingPositionIdLinkImpl extends EObjectImpl implements LoggingPositionIdLink {
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
	 * The default value of the '{@link #isIsInputPosition() <em>Is Input Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInputPosition()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INPUT_POSITION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInputPosition() <em>Is Input Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInputPosition()
	 * @generated
	 * @ordered
	 */
	protected boolean isInputPosition = IS_INPUT_POSITION_EDEFAULT;

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
	public boolean isIsInputPosition() {
		return isInputPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInputPosition(boolean newIsInputPosition) {
		boolean oldIsInputPosition = isInputPosition;
		isInputPosition = newIsInputPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.LOGGING_POSITION_ID_LINK__IS_INPUT_POSITION, oldIsInputPosition, isInputPosition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION, oldServiceEffectSpecification, serviceEffectSpecification));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION, oldServiceEffectSpecification, serviceEffectSpecification));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
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
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__IS_INPUT_POSITION:
				return isIsInputPosition();
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION:
				if (resolve) return getServiceEffectSpecification();
				return basicGetServiceEffectSpecification();
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION:
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
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID:
				setLoggingPositionId((String)newValue);
				return;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__IS_INPUT_POSITION:
				setIsInputPosition((Boolean)newValue);
				return;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION:
				setServiceEffectSpecification((ServiceEffectSpecification)newValue);
				return;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION:
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
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID:
				setLoggingPositionId(LOGGING_POSITION_ID_EDEFAULT);
				return;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__IS_INPUT_POSITION:
				setIsInputPosition(IS_INPUT_POSITION_EDEFAULT);
				return;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION:
				setServiceEffectSpecification((ServiceEffectSpecification)null);
				return;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION:
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
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID:
				return LOGGING_POSITION_ID_EDEFAULT == null ? loggingPositionId != null : !LOGGING_POSITION_ID_EDEFAULT.equals(loggingPositionId);
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__IS_INPUT_POSITION:
				return isInputPosition != IS_INPUT_POSITION_EDEFAULT;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION:
				return serviceEffectSpecification != null;
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION:
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
		result.append(", isInputPosition: ");
		result.append(isInputPosition);
		result.append(')');
		return result.toString();
	}

} //LoggingPositionIdLinkImpl
