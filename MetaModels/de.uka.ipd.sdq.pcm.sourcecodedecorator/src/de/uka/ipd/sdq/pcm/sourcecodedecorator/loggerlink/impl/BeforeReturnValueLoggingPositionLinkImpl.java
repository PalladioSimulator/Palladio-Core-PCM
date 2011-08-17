/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.fzi.gast.functions.Function;

import de.uka.ipd.sdq.pcm.seff.SetVariableAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink;
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
 * An implementation of the model object '<em><b>Before Return Value Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl#getLinkedSetVariableAction <em>Linked Set Variable Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl#getProvidedFunctionOfSurroundingSeff <em>Provided Function Of Surrounding Seff</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl#getParameterLink <em>Parameter Link</em>}</li>
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
	 * The cached value of the '{@link #getProvidedFunctionOfSurroundingSeff() <em>Provided Function Of Surrounding Seff</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedFunctionOfSurroundingSeff()
	 * @generated
	 * @ordered
	 */
	protected Function providedFunctionOfSurroundingSeff;

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
	public Function getProvidedFunctionOfSurroundingSeff() {
		if (providedFunctionOfSurroundingSeff != null && providedFunctionOfSurroundingSeff.eIsProxy()) {
			InternalEObject oldProvidedFunctionOfSurroundingSeff = (InternalEObject)providedFunctionOfSurroundingSeff;
			providedFunctionOfSurroundingSeff = (Function)eResolveProxy(oldProvidedFunctionOfSurroundingSeff);
			if (providedFunctionOfSurroundingSeff != oldProvidedFunctionOfSurroundingSeff) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF, oldProvidedFunctionOfSurroundingSeff, providedFunctionOfSurroundingSeff));
			}
		}
		return providedFunctionOfSurroundingSeff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetProvidedFunctionOfSurroundingSeff() {
		return providedFunctionOfSurroundingSeff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedFunctionOfSurroundingSeff(Function newProvidedFunctionOfSurroundingSeff) {
		Function oldProvidedFunctionOfSurroundingSeff = providedFunctionOfSurroundingSeff;
		providedFunctionOfSurroundingSeff = newProvidedFunctionOfSurroundingSeff;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF, oldProvidedFunctionOfSurroundingSeff, providedFunctionOfSurroundingSeff));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterLink> getParameterLink() {
		if (parameterLink == null) {
			parameterLink = new EObjectContainmentEList<ParameterLink>(ParameterLink.class, this, LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK);
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK:
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				if (resolve) return getLinkedSetVariableAction();
				return basicGetLinkedSetVariableAction();
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF:
				if (resolve) return getProvidedFunctionOfSurroundingSeff();
				return basicGetProvidedFunctionOfSurroundingSeff();
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK:
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				setLinkedSetVariableAction((SetVariableAction)newValue);
				return;
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF:
				setProvidedFunctionOfSurroundingSeff((Function)newValue);
				return;
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK:
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				setLinkedSetVariableAction((SetVariableAction)null);
				return;
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF:
				setProvidedFunctionOfSurroundingSeff((Function)null);
				return;
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK:
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION:
				return linkedSetVariableAction != null;
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF:
				return providedFunctionOfSurroundingSeff != null;
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK:
				return parameterLink != null && !parameterLink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BeforeReturnValueLoggingPositionLinkImpl
