/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.impl;

import de.fzi.se.quality.parameters.CallInstance;

import de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls;
import de.fzi.se.validation.testbased.trace.TracePackage;

import de.fzi.se.validation.testbased.trace.util.TraceValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outgoing Infrastructure Calls</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.impl.OutgoingInfrastructureCallsImpl#getCallInstances <em>Call Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutgoingInfrastructureCallsImpl extends TraceActionImpl implements OutgoingInfrastructureCalls {
	/**
	 * The cached value of the '{@link #getCallInstances() <em>Call Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<CallInstance> callInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutgoingInfrastructureCallsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.OUTGOING_INFRASTRUCTURE_CALLS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CallInstance> getCallInstances() {
		if (callInstances == null) {
			callInstances = new EObjectContainmentEList<CallInstance>(CallInstance.class, this, TracePackage.OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES);
		}
		return callInstances;
	}

	/**
	 * The cached OCL expression body for the '{@link #CallInstancemustreferenceInfrastructureoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Call Instancemustreference Infrastructureoperation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CallInstancemustreferenceInfrastructureoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.callInstances->forAll(call | call.parameterReference.oclIsTypeOf(Validation::Parameters::InfrastructureOperationReference))\n"+"\n"+"\n"+"";

	/**
	 * The cached OCL invariant for the '{@link #CallInstancemustreferenceInfrastructureoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Call Instancemustreference Infrastructureoperation</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CallInstancemustreferenceInfrastructureoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean CallInstancemustreferenceInfrastructureoperation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(TracePackage.Literals.OUTGOING_INFRASTRUCTURE_CALLS);
			try {
				CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 TraceValidator.DIAGNOSTIC_SOURCE,
						 TraceValidator.OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCEMUSTREFERENCE_INFRASTRUCTUREOPERATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "CallInstancemustreferenceInfrastructureoperation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES:
				return ((InternalEList<?>)getCallInstances()).basicRemove(otherEnd, msgs);
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
			case TracePackage.OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES:
				return getCallInstances();
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
			case TracePackage.OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES:
				getCallInstances().clear();
				getCallInstances().addAll((Collection<? extends CallInstance>)newValue);
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
			case TracePackage.OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES:
				getCallInstances().clear();
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
			case TracePackage.OUTGOING_INFRASTRUCTURE_CALLS__CALL_INSTANCES:
				return callInstances != null && !callInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //OutgoingInfrastructureCallsImpl
