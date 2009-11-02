/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>After External Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl#getAbstractAction <em>Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AfterExternalCallLoggingPositionLinkImpl extends InputLoggingPositionLinkImpl implements AfterExternalCallLoggingPositionLink {
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
	protected AfterExternalCallLoggingPositionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__ABSTRACT_ACTION, oldAbstractAction, abstractAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__ABSTRACT_ACTION:
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__ABSTRACT_ACTION:
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__ABSTRACT_ACTION:
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__ABSTRACT_ACTION:
				return abstractAction != null;
		}
		return super.eIsSet(featureID);
	}

} //AfterExternalCallLoggingPositionLinkImpl
