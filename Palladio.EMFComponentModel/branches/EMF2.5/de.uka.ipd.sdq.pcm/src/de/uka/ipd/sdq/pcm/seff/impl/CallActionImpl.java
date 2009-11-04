/**
 * Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.CallActionImpl#getOutputVariableUsages_ExternalCallAction <em>Output Variable Usages External Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.CallActionImpl#getInputParameterUsages_ExternalCallAction <em>Input Parameter Usages External Call Action</em>}</li>
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
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getOutputVariableUsages_ExternalCallAction() <em>Output Variable Usages External Call Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariableUsages_ExternalCallAction()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> outputVariableUsages_ExternalCallAction;

	/**
	 * The cached value of the '{@link #getInputParameterUsages_ExternalCallAction() <em>Input Parameter Usages External Call Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterUsages_ExternalCallAction()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> inputParameterUsages_ExternalCallAction;

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
	public EList<VariableUsage> getOutputVariableUsages_ExternalCallAction() {
		if (outputVariableUsages_ExternalCallAction == null) {
			outputVariableUsages_ExternalCallAction = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION);
		}
		return outputVariableUsages_ExternalCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getInputParameterUsages_ExternalCallAction() {
		if (inputParameterUsages_ExternalCallAction == null) {
			inputParameterUsages_ExternalCallAction = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION);
		}
		return inputParameterUsages_ExternalCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION:
				return ((InternalEList<?>)getOutputVariableUsages_ExternalCallAction()).basicRemove(otherEnd, msgs);
			case SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION:
				return ((InternalEList<?>)getInputParameterUsages_ExternalCallAction()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION:
				return getOutputVariableUsages_ExternalCallAction();
			case SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION:
				return getInputParameterUsages_ExternalCallAction();
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
			case SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION:
				getOutputVariableUsages_ExternalCallAction().clear();
				getOutputVariableUsages_ExternalCallAction().addAll((Collection<? extends VariableUsage>)newValue);
				return;
			case SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION:
				getInputParameterUsages_ExternalCallAction().clear();
				getInputParameterUsages_ExternalCallAction().addAll((Collection<? extends VariableUsage>)newValue);
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
			case SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION:
				getOutputVariableUsages_ExternalCallAction().clear();
				return;
			case SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION:
				getInputParameterUsages_ExternalCallAction().clear();
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
			case SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION:
				return outputVariableUsages_ExternalCallAction != null && !outputVariableUsages_ExternalCallAction.isEmpty();
			case SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION:
				return inputParameterUsages_ExternalCallAction != null && !inputParameterUsages_ExternalCallAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CallActionImpl
