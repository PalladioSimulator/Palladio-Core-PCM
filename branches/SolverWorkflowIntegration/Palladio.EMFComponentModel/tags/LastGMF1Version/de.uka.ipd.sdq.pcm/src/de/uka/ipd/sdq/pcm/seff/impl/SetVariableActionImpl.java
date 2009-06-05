
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Variable Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.SetVariableActionImpl#getVariableUsage_SetVariableAction <em>Variable Usage Set Variable Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetVariableActionImpl extends AbstractResourceDemandingActionImpl implements SetVariableAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getVariableUsage_SetVariableAction() <em>Variable Usage Set Variable Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableUsage_SetVariableAction()
	 * @generated
	 * @ordered
	 */
	protected VariableUsage variableUsage_SetVariableAction = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetVariableActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.SET_VARIABLE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableUsage getVariableUsage_SetVariableAction() {
		return variableUsage_SetVariableAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableUsage_SetVariableAction(VariableUsage newVariableUsage_SetVariableAction, NotificationChain msgs) {
		VariableUsage oldVariableUsage_SetVariableAction = variableUsage_SetVariableAction;
		variableUsage_SetVariableAction = newVariableUsage_SetVariableAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION, oldVariableUsage_SetVariableAction, newVariableUsage_SetVariableAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableUsage_SetVariableAction(VariableUsage newVariableUsage_SetVariableAction) {
		if (newVariableUsage_SetVariableAction != variableUsage_SetVariableAction) {
			NotificationChain msgs = null;
			if (variableUsage_SetVariableAction != null)
				msgs = ((InternalEObject)variableUsage_SetVariableAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION, null, msgs);
			if (newVariableUsage_SetVariableAction != null)
				msgs = ((InternalEObject)newVariableUsage_SetVariableAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION, null, msgs);
			msgs = basicSetVariableUsage_SetVariableAction(newVariableUsage_SetVariableAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION, newVariableUsage_SetVariableAction, newVariableUsage_SetVariableAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION:
				return basicSetVariableUsage_SetVariableAction(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION:
				return getVariableUsage_SetVariableAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION:
				setVariableUsage_SetVariableAction((VariableUsage)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION:
				setVariableUsage_SetVariableAction((VariableUsage)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION:
				return variableUsage_SetVariableAction != null;
		}
		return super.eIsSet(featureID);
	}

} //SetVariableActionImpl