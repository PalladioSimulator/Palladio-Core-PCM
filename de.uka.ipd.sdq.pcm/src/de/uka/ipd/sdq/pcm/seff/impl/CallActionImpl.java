/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.CallActionImpl#getVariableSetterInputs__CallAction <em>Variable Setter Inputs Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CallActionImpl extends EObjectImpl implements CallAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getVariableSetterInputs__CallAction() <em>Variable Setter Inputs Call Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableSetterInputs__CallAction()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableSetter> variableSetterInputs__CallAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.CALL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableSetter> getVariableSetterInputs__CallAction() {
		if (variableSetterInputs__CallAction == null) {
			variableSetterInputs__CallAction = new EObjectContainmentWithInverseEList<VariableSetter>(VariableSetter.class, this, SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION, ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER);
		}
		return variableSetterInputs__CallAction;
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
			case SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariableSetterInputs__CallAction()).basicAdd(otherEnd, msgs);
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
			case SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION:
				return ((InternalEList<?>)getVariableSetterInputs__CallAction()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION:
				return getVariableSetterInputs__CallAction();
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
			case SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION:
				getVariableSetterInputs__CallAction().clear();
				getVariableSetterInputs__CallAction().addAll((Collection<? extends VariableSetter>)newValue);
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
			case SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION:
				getVariableSetterInputs__CallAction().clear();
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
			case SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION:
				return variableSetterInputs__CallAction != null && !variableSetterInputs__CallAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CallActionImpl
