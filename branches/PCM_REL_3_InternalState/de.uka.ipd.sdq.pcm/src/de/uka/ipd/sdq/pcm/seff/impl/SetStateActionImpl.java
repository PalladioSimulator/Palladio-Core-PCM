/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SetStateAction;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set State Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.SetStateActionImpl#getLocalVariableUsages_SetVariableAction <em>Local Variable Usages Set Variable Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetStateActionImpl extends AbstractResourceDemandingActionImpl implements SetStateAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getLocalVariableUsages_SetVariableAction() <em>Local Variable Usages Set Variable Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalVariableUsages_SetVariableAction()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> localVariableUsages_SetVariableAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetStateActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.SET_STATE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getLocalVariableUsages_SetVariableAction() {
		if (localVariableUsages_SetVariableAction == null) {
			localVariableUsages_SetVariableAction = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, SeffPackage.SET_STATE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION);
		}
		return localVariableUsages_SetVariableAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.SET_STATE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION:
				return ((InternalEList<?>)getLocalVariableUsages_SetVariableAction()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.SET_STATE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION:
				return getLocalVariableUsages_SetVariableAction();
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
			case SeffPackage.SET_STATE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION:
				getLocalVariableUsages_SetVariableAction().clear();
				getLocalVariableUsages_SetVariableAction().addAll((Collection<? extends VariableUsage>)newValue);
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
			case SeffPackage.SET_STATE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION:
				getLocalVariableUsages_SetVariableAction().clear();
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
			case SeffPackage.SET_STATE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION:
				return localVariableUsages_SetVariableAction != null && !localVariableUsages_SetVariableAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SetStateActionImpl