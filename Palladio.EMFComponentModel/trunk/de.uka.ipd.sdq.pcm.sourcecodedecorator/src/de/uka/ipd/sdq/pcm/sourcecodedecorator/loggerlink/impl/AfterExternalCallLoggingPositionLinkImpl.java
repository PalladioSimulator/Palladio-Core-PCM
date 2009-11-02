/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl#getLinkedExternalCallAction <em>Linked External Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AfterExternalCallLoggingPositionLinkImpl extends InputLoggingPositionLinkImpl implements AfterExternalCallLoggingPositionLink {
	/**
	 * The cached value of the '{@link #getLinkedExternalCallAction() <em>Linked External Call Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedExternalCallAction()
	 * @generated
	 * @ordered
	 */
	protected ExternalCallAction linkedExternalCallAction;
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
	public ExternalCallAction getLinkedExternalCallAction() {
		if (linkedExternalCallAction != null && linkedExternalCallAction.eIsProxy()) {
			InternalEObject oldLinkedExternalCallAction = (InternalEObject)linkedExternalCallAction;
			linkedExternalCallAction = (ExternalCallAction)eResolveProxy(oldLinkedExternalCallAction);
			if (linkedExternalCallAction != oldLinkedExternalCallAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION, oldLinkedExternalCallAction, linkedExternalCallAction));
			}
		}
		return linkedExternalCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallAction basicGetLinkedExternalCallAction() {
		return linkedExternalCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedExternalCallAction(ExternalCallAction newLinkedExternalCallAction) {
		ExternalCallAction oldLinkedExternalCallAction = linkedExternalCallAction;
		linkedExternalCallAction = newLinkedExternalCallAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION, oldLinkedExternalCallAction, linkedExternalCallAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION:
				if (resolve) return getLinkedExternalCallAction();
				return basicGetLinkedExternalCallAction();
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION:
				setLinkedExternalCallAction((ExternalCallAction)newValue);
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION:
				setLinkedExternalCallAction((ExternalCallAction)null);
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION:
				return linkedExternalCallAction != null;
		}
		return super.eIsSet(featureID);
	}

} //AfterExternalCallLoggingPositionLinkImpl
