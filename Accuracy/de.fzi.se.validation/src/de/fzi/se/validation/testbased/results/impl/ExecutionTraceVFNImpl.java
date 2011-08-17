/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.impl;

import de.fzi.se.validation.testbased.results.ExecutionTraceVFN;
import de.fzi.se.validation.testbased.results.ResultsPackage;

import de.fzi.se.validation.testbased.trace.ExecutionTrace;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Trace VFN</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.ExecutionTraceVFNImpl#getExecutionTrace <em>Execution Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTraceVFNImpl extends ValidationFailureNoticeImpl implements ExecutionTraceVFN {
	/**
	 * The cached value of the '{@link #getExecutionTrace() <em>Execution Trace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTrace()
	 * @generated
	 * @ordered
	 */
	protected ExecutionTrace executionTrace;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTraceVFNImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.EXECUTION_TRACE_VFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTrace getExecutionTrace() {
		if (executionTrace != null && executionTrace.eIsProxy()) {
			InternalEObject oldExecutionTrace = (InternalEObject)executionTrace;
			executionTrace = (ExecutionTrace)eResolveProxy(oldExecutionTrace);
			if (executionTrace != oldExecutionTrace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.EXECUTION_TRACE_VFN__EXECUTION_TRACE, oldExecutionTrace, executionTrace));
			}
		}
		return executionTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTrace basicGetExecutionTrace() {
		return executionTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionTrace(ExecutionTrace newExecutionTrace) {
		ExecutionTrace oldExecutionTrace = executionTrace;
		executionTrace = newExecutionTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.EXECUTION_TRACE_VFN__EXECUTION_TRACE, oldExecutionTrace, executionTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultsPackage.EXECUTION_TRACE_VFN__EXECUTION_TRACE:
				if (resolve) return getExecutionTrace();
				return basicGetExecutionTrace();
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
			case ResultsPackage.EXECUTION_TRACE_VFN__EXECUTION_TRACE:
				setExecutionTrace((ExecutionTrace)newValue);
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
			case ResultsPackage.EXECUTION_TRACE_VFN__EXECUTION_TRACE:
				setExecutionTrace((ExecutionTrace)null);
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
			case ResultsPackage.EXECUTION_TRACE_VFN__EXECUTION_TRACE:
				return executionTrace != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionTraceVFNImpl
