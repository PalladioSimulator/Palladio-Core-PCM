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

import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Before Return Value Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl#getLinkedSetVariableAction <em>Linked Set Variable Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BeforeReturnValueLoggingPositionLinkImpl extends OutputLoggingPositionLinkImpl implements BeforeReturnValueLoggingPositionLink {
	/**
	 * The cached value of the '{@link #getLinkedSetVariableAction() <em>Linked Set Variable Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedSetVariableAction()
	 * @generated
	 * @ordered
	 */
	protected SetVariableAction linkedSetVariableAction;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BeforeReturnValueLoggingPositionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetVariableAction getLinkedSetVariableAction() {
		if (linkedSetVariableAction != null && linkedSetVariableAction.eIsProxy()) {
			InternalEObject oldLinkedSetVariableAction = (InternalEObject)linkedSetVariableAction;
			linkedSetVariableAction = (SetVariableAction)eResolveProxy(oldLinkedSetVariableAction);
			if (linkedSetVariableAction != oldLinkedSetVariableAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION, oldLinkedSetVariableAction, linkedSetVariableAction));
			}
		}
		return linkedSetVariableAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetVariableAction basicGetLinkedSetVariableAction() {
		return linkedSetVariableAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedSetVariableAction(SetVariableAction newLinkedSetVariableAction) {
		SetVariableAction oldLinkedSetVariableAction = linkedSetVariableAction;
		linkedSetVariableAction = newLinkedSetVariableAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION, oldLinkedSetVariableAction, linkedSetVariableAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				if (resolve) return getLinkedSetVariableAction();
				return basicGetLinkedSetVariableAction();
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				setLinkedSetVariableAction((SetVariableAction)newValue);
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				setLinkedSetVariableAction((SetVariableAction)null);
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				return linkedSetVariableAction != null;
		}
		return super.eIsSet(featureID);
	}

} //BeforeReturnValueLoggingPositionLinkImpl
