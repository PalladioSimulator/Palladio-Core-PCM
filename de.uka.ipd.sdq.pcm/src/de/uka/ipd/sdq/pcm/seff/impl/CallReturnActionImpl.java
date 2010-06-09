/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.SetVariable;

import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Return Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.CallReturnActionImpl#getSetVariableReturns__CallReturnAction <em>Set Variable Returns Call Return Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CallReturnActionImpl extends CallActionImpl implements CallReturnAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSetVariableReturns__CallReturnAction() <em>Set Variable Returns Call Return Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetVariableReturns__CallReturnAction()
	 * @generated
	 * @ordered
	 */
	protected EList<SetVariable> setVariableReturns__CallReturnAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallReturnActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.CALL_RETURN_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SetVariable> getSetVariableReturns__CallReturnAction() {
		if (setVariableReturns__CallReturnAction == null) {
			setVariableReturns__CallReturnAction = new EObjectContainmentWithInverseEList<SetVariable>(SetVariable.class, this, SeffPackage.CALL_RETURN_ACTION__SET_VARIABLE_RETURNS_CALL_RETURN_ACTION, ParameterPackage.SET_VARIABLE__CALL_RETURN_ACTION_SET_VARIABLE);
		}
		return setVariableReturns__CallReturnAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.CALL_RETURN_ACTION__SET_VARIABLE_RETURNS_CALL_RETURN_ACTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSetVariableReturns__CallReturnAction()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.CALL_RETURN_ACTION__SET_VARIABLE_RETURNS_CALL_RETURN_ACTION:
				return ((InternalEList<?>)getSetVariableReturns__CallReturnAction()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.CALL_RETURN_ACTION__SET_VARIABLE_RETURNS_CALL_RETURN_ACTION:
				return getSetVariableReturns__CallReturnAction();
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
			case SeffPackage.CALL_RETURN_ACTION__SET_VARIABLE_RETURNS_CALL_RETURN_ACTION:
				getSetVariableReturns__CallReturnAction().clear();
				getSetVariableReturns__CallReturnAction().addAll((Collection<? extends SetVariable>)newValue);
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
			case SeffPackage.CALL_RETURN_ACTION__SET_VARIABLE_RETURNS_CALL_RETURN_ACTION:
				getSetVariableReturns__CallReturnAction().clear();
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
			case SeffPackage.CALL_RETURN_ACTION__SET_VARIABLE_RETURNS_CALL_RETURN_ACTION:
				return setVariableReturns__CallReturnAction != null && !setVariableReturns__CallReturnAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CallReturnActionImpl
