/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.impl;

import de.fzi.se.validation.testbased.results.ResultsPackage;
import de.fzi.se.validation.testbased.results.RunProtocol;

import de.fzi.se.validation.testbased.trace.ExecutionTrace;
import de.fzi.se.validation.testbased.trace.TraceAction;
import de.fzi.se.validation.testbased.trace.TracePackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.impl.ExecutionTraceImpl#getTraceActions <em>Trace Actions</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.trace.impl.ExecutionTraceImpl#getRunProtocol <em>Run Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTraceImpl extends IdentifierImpl implements ExecutionTrace {
	/**
	 * The cached value of the '{@link #getTraceActions() <em>Trace Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceActions()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceAction> traceActions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.EXECUTION_TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceAction> getTraceActions() {
		if (traceActions == null) {
			traceActions = new EObjectContainmentWithInverseEList<TraceAction>(TraceAction.class, this, TracePackage.EXECUTION_TRACE__TRACE_ACTIONS, TracePackage.TRACE_ACTION__EXECUTION_TRACE);
		}
		return traceActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunProtocol getRunProtocol() {
		if (eContainerFeatureID() != TracePackage.EXECUTION_TRACE__RUN_PROTOCOL) return null;
		return (RunProtocol)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRunProtocol(RunProtocol newRunProtocol, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRunProtocol, TracePackage.EXECUTION_TRACE__RUN_PROTOCOL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunProtocol(RunProtocol newRunProtocol) {
		if (newRunProtocol != eInternalContainer() || (eContainerFeatureID() != TracePackage.EXECUTION_TRACE__RUN_PROTOCOL && newRunProtocol != null)) {
			if (EcoreUtil.isAncestor(this, newRunProtocol))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRunProtocol != null)
				msgs = ((InternalEObject)newRunProtocol).eInverseAdd(this, ResultsPackage.RUN_PROTOCOL__INVALID_TRACES, RunProtocol.class, msgs);
			msgs = basicSetRunProtocol(newRunProtocol, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.EXECUTION_TRACE__RUN_PROTOCOL, newRunProtocol, newRunProtocol));
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
			case TracePackage.EXECUTION_TRACE__TRACE_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTraceActions()).basicAdd(otherEnd, msgs);
			case TracePackage.EXECUTION_TRACE__RUN_PROTOCOL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRunProtocol((RunProtocol)otherEnd, msgs);
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
			case TracePackage.EXECUTION_TRACE__TRACE_ACTIONS:
				return ((InternalEList<?>)getTraceActions()).basicRemove(otherEnd, msgs);
			case TracePackage.EXECUTION_TRACE__RUN_PROTOCOL:
				return basicSetRunProtocol(null, msgs);
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
			case TracePackage.EXECUTION_TRACE__RUN_PROTOCOL:
				return eInternalContainer().eInverseRemove(this, ResultsPackage.RUN_PROTOCOL__INVALID_TRACES, RunProtocol.class, msgs);
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
			case TracePackage.EXECUTION_TRACE__TRACE_ACTIONS:
				return getTraceActions();
			case TracePackage.EXECUTION_TRACE__RUN_PROTOCOL:
				return getRunProtocol();
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
			case TracePackage.EXECUTION_TRACE__TRACE_ACTIONS:
				getTraceActions().clear();
				getTraceActions().addAll((Collection<? extends TraceAction>)newValue);
				return;
			case TracePackage.EXECUTION_TRACE__RUN_PROTOCOL:
				setRunProtocol((RunProtocol)newValue);
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
			case TracePackage.EXECUTION_TRACE__TRACE_ACTIONS:
				getTraceActions().clear();
				return;
			case TracePackage.EXECUTION_TRACE__RUN_PROTOCOL:
				setRunProtocol((RunProtocol)null);
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
			case TracePackage.EXECUTION_TRACE__TRACE_ACTIONS:
				return traceActions != null && !traceActions.isEmpty();
			case TracePackage.EXECUTION_TRACE__RUN_PROTOCOL:
				return getRunProtocol() != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionTraceImpl
