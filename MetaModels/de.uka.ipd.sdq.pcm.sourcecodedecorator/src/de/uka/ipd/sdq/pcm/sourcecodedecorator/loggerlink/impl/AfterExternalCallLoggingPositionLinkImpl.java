/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.fzi.gast.functions.Function;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>After External Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl#getLinkedExternalCallAction <em>Linked External Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl#getCalledFunction <em>Called Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl#getParameterLink <em>Parameter Link</em>}</li>
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
	 * The cached value of the '{@link #getCalledFunction() <em>Called Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledFunction()
	 * @generated
	 * @ordered
	 */
	protected Function calledFunction;

	/**
	 * The cached value of the '{@link #getParameterLink() <em>Parameter Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterLink()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterLink> parameterLink;

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
	public Function getCalledFunction() {
		if (calledFunction != null && calledFunction.eIsProxy()) {
			InternalEObject oldCalledFunction = (InternalEObject)calledFunction;
			calledFunction = (Function)eResolveProxy(oldCalledFunction);
			if (calledFunction != oldCalledFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION, oldCalledFunction, calledFunction));
			}
		}
		return calledFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetCalledFunction() {
		return calledFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledFunction(Function newCalledFunction) {
		Function oldCalledFunction = calledFunction;
		calledFunction = newCalledFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION, oldCalledFunction, calledFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterLink> getParameterLink() {
		if (parameterLink == null) {
			parameterLink = new EObjectContainmentEList<ParameterLink>(ParameterLink.class, this, LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK);
		}
		return parameterLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK:
				return ((InternalEList<?>)getParameterLink()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION:
				if (resolve) return getCalledFunction();
				return basicGetCalledFunction();
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK:
				return getParameterLink();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION:
				setLinkedExternalCallAction((ExternalCallAction)newValue);
				return;
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION:
				setCalledFunction((Function)newValue);
				return;
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK:
				getParameterLink().clear();
				getParameterLink().addAll((Collection<? extends ParameterLink>)newValue);
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION:
				setCalledFunction((Function)null);
				return;
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK:
				getParameterLink().clear();
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
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION:
				return calledFunction != null;
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK:
				return parameterLink != null && !parameterLink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AfterExternalCallLoggingPositionLinkImpl
