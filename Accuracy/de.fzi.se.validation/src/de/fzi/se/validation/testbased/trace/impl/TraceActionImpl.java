/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.impl;

import de.fzi.se.validation.testbased.trace.ExecutionTrace;
import de.fzi.se.validation.testbased.trace.TraceAction;
import de.fzi.se.validation.testbased.trace.TracePackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.impl.TraceActionImpl#getExecutionTrace <em>Execution Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceActionImpl extends IdentifierImpl implements TraceAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTrace getExecutionTrace() {
		if (eContainerFeatureID() != TracePackage.TRACE_ACTION__EXECUTION_TRACE) return null;
		return (ExecutionTrace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExecutionTrace(ExecutionTrace newExecutionTrace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExecutionTrace, TracePackage.TRACE_ACTION__EXECUTION_TRACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionTrace(ExecutionTrace newExecutionTrace) {
		if (newExecutionTrace != eInternalContainer() || (eContainerFeatureID() != TracePackage.TRACE_ACTION__EXECUTION_TRACE && newExecutionTrace != null)) {
			if (EcoreUtil.isAncestor(this, newExecutionTrace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExecutionTrace != null)
				msgs = ((InternalEObject)newExecutionTrace).eInverseAdd(this, TracePackage.EXECUTION_TRACE__TRACE_ACTIONS, ExecutionTrace.class, msgs);
			msgs = basicSetExecutionTrace(newExecutionTrace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_ACTION__EXECUTION_TRACE, newExecutionTrace, newExecutionTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRACE_ACTION__EXECUTION_TRACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExecutionTrace((ExecutionTrace)otherEnd, msgs);
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
			case TracePackage.TRACE_ACTION__EXECUTION_TRACE:
				return basicSetExecutionTrace(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TracePackage.TRACE_ACTION__EXECUTION_TRACE:
				return eInternalContainer().eInverseRemove(this, TracePackage.EXECUTION_TRACE__TRACE_ACTIONS, ExecutionTrace.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.TRACE_ACTION__EXECUTION_TRACE:
				return getExecutionTrace();
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
			case TracePackage.TRACE_ACTION__EXECUTION_TRACE:
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
			case TracePackage.TRACE_ACTION__EXECUTION_TRACE:
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
			case TracePackage.TRACE_ACTION__EXECUTION_TRACE:
				return getExecutionTrace() != null;
		}
		return super.eIsSet(featureID);
	}

} //TraceActionImpl
