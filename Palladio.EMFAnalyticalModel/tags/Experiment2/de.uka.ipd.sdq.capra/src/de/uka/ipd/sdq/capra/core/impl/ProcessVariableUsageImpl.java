/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.ProcessVariable;
import de.uka.ipd.sdq.capra.core.ProcessVariableUsage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Variable Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ProcessVariableUsageImpl#getProcessVariable <em>Process Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessVariableUsageImpl extends CapraExpressionImpl implements ProcessVariableUsage {
	/**
	 * The cached value of the '{@link #getProcessVariable() <em>Process Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessVariable()
	 * @generated
	 * @ordered
	 */
	protected ProcessVariable processVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessVariableUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.PROCESS_VARIABLE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessVariable getProcessVariable() {
		if (processVariable != null && processVariable.eIsProxy()) {
			InternalEObject oldProcessVariable = (InternalEObject)processVariable;
			processVariable = (ProcessVariable)eResolveProxy(oldProcessVariable);
			if (processVariable != oldProcessVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE, oldProcessVariable, processVariable));
			}
		}
		return processVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessVariable basicGetProcessVariable() {
		return processVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessVariable(ProcessVariable newProcessVariable) {
		ProcessVariable oldProcessVariable = processVariable;
		processVariable = newProcessVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE, oldProcessVariable, processVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE:
				if (resolve) return getProcessVariable();
				return basicGetProcessVariable();
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
			case CorePackage.PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE:
				setProcessVariable((ProcessVariable)newValue);
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
			case CorePackage.PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE:
				setProcessVariable((ProcessVariable)null);
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
			case CorePackage.PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE:
				return processVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessVariableUsageImpl
