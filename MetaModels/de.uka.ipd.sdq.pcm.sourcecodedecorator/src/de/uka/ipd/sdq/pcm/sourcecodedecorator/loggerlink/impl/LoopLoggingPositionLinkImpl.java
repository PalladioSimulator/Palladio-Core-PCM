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

import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoopLoggingPositionLinkImpl#getLinkedLoopAction <em>Linked Loop Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopLoggingPositionLinkImpl extends OutputLoggingPositionLinkImpl implements LoopLoggingPositionLink {
	/**
	 * The cached value of the '{@link #getLinkedLoopAction() <em>Linked Loop Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedLoopAction()
	 * @generated
	 * @ordered
	 */
	protected LoopAction linkedLoopAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopLoggingPositionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.LOOP_LOGGING_POSITION_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopAction getLinkedLoopAction() {
		if (linkedLoopAction != null && linkedLoopAction.eIsProxy()) {
			InternalEObject oldLinkedLoopAction = (InternalEObject)linkedLoopAction;
			linkedLoopAction = (LoopAction)eResolveProxy(oldLinkedLoopAction);
			if (linkedLoopAction != oldLinkedLoopAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION, oldLinkedLoopAction, linkedLoopAction));
			}
		}
		return linkedLoopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopAction basicGetLinkedLoopAction() {
		return linkedLoopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedLoopAction(LoopAction newLinkedLoopAction) {
		LoopAction oldLinkedLoopAction = linkedLoopAction;
		linkedLoopAction = newLinkedLoopAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION, oldLinkedLoopAction, linkedLoopAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				if (resolve) return getLinkedLoopAction();
				return basicGetLinkedLoopAction();
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
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				setLinkedLoopAction((LoopAction)newValue);
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
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				setLinkedLoopAction((LoopAction)null);
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
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				return linkedLoopAction != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopLoggingPositionLinkImpl
