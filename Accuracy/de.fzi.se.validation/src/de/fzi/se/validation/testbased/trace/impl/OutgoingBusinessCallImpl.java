/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.impl;

import de.fzi.se.quality.parameters.CallInstance;

import de.fzi.se.validation.testbased.trace.OutgoingBusinessCall;
import de.fzi.se.validation.testbased.trace.TracePackage;

import de.fzi.se.validation.testbased.trace.util.TraceValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outgoing Business Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.impl.OutgoingBusinessCallImpl#getCallInstance <em>Call Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutgoingBusinessCallImpl extends TraceActionImpl implements OutgoingBusinessCall {
	/**
	 * The cached value of the '{@link #getCallInstance() <em>Call Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallInstance()
	 * @generated
	 * @ordered
	 */
	protected CallInstance callInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutgoingBusinessCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.OUTGOING_BUSINESS_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallInstance getCallInstance() {
		return callInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallInstance(CallInstance newCallInstance, NotificationChain msgs) {
		CallInstance oldCallInstance = callInstance;
		callInstance = newCallInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE, oldCallInstance, newCallInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallInstance(CallInstance newCallInstance) {
		if (newCallInstance != callInstance) {
			NotificationChain msgs = null;
			if (callInstance != null)
				msgs = ((InternalEObject)callInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE, null, msgs);
			if (newCallInstance != null)
				msgs = ((InternalEObject)newCallInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE, null, msgs);
			msgs = basicSetCallInstance(newCallInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE, newCallInstance, newCallInstance));
	}

	/**
	 * The cached OCL expression body for the '{@link #CallInstancemustreferenceBusinessoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Call Instancemustreference Businessoperation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CallInstancemustreferenceBusinessoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.callInstances->forAll(call | call.parameterReference.oclIsTypeOf(Validation::Parameters::BusinessOperationReference))";

	/**
	 * The cached OCL invariant for the '{@link #CallInstancemustreferenceBusinessoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Call Instancemustreference Businessoperation</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CallInstancemustreferenceBusinessoperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean CallInstancemustreferenceBusinessoperation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(TracePackage.Literals.OUTGOING_BUSINESS_CALL);
			try {
				CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 TraceValidator.DIAGNOSTIC_SOURCE,
						 TraceValidator.OUTGOING_BUSINESS_CALL__CALL_INSTANCEMUSTREFERENCE_BUSINESSOPERATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "CallInstancemustreferenceBusinessoperation", EObjectValidator.getObjectLabel(this, context) }),
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
			case TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE:
				return basicSetCallInstance(null, msgs);
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
			case TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE:
				return getCallInstance();
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
			case TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE:
				setCallInstance((CallInstance)newValue);
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
			case TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE:
				setCallInstance((CallInstance)null);
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
			case TracePackage.OUTGOING_BUSINESS_CALL__CALL_INSTANCE:
				return callInstance != null;
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

} //OutgoingBusinessCallImpl
