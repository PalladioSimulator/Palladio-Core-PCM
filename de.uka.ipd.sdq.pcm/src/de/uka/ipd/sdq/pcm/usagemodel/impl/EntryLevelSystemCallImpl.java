/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Level System Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getProvidedRole_EntryLevelSystemCall <em>Provided Role Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getOperationSignature__EntryLevelSystemCall <em>Operation Signature Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getOutputVariableSetters__EntryLevelSystemCall <em>Output Variable Setters Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getInputVariableSetters__EntryLevelSystemCall <em>Input Variable Setters Entry Level System Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryLevelSystemCallImpl extends AbstractUserActionImpl implements EntryLevelSystemCall {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getProvidedRole_EntryLevelSystemCall() <em>Provided Role Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRole_EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected OperationProvidedRole providedRole_EntryLevelSystemCall;

	/**
	 * The cached value of the '{@link #getOperationSignature__EntryLevelSystemCall() <em>Operation Signature Entry Level System Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationSignature__EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected OperationSignature operationSignature__EntryLevelSystemCall;

	/**
	 * The cached value of the '{@link #getOutputVariableSetters__EntryLevelSystemCall() <em>Output Variable Setters Entry Level System Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariableSetters__EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableSetter> outputVariableSetters__EntryLevelSystemCall;

	/**
	 * The cached value of the '{@link #getInputVariableSetters__EntryLevelSystemCall() <em>Input Variable Setters Entry Level System Call</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariableSetters__EntryLevelSystemCall()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableSetter> inputVariableSetters__EntryLevelSystemCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryLevelSystemCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationProvidedRole getProvidedRole_EntryLevelSystemCall() {
		if (providedRole_EntryLevelSystemCall != null && providedRole_EntryLevelSystemCall.eIsProxy()) {
			InternalEObject oldProvidedRole_EntryLevelSystemCall = (InternalEObject)providedRole_EntryLevelSystemCall;
			providedRole_EntryLevelSystemCall = (OperationProvidedRole)eResolveProxy(oldProvidedRole_EntryLevelSystemCall);
			if (providedRole_EntryLevelSystemCall != oldProvidedRole_EntryLevelSystemCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, oldProvidedRole_EntryLevelSystemCall, providedRole_EntryLevelSystemCall));
			}
		}
		return providedRole_EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationProvidedRole basicGetProvidedRole_EntryLevelSystemCall() {
		return providedRole_EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedRole_EntryLevelSystemCall(OperationProvidedRole newProvidedRole_EntryLevelSystemCall) {
		OperationProvidedRole oldProvidedRole_EntryLevelSystemCall = providedRole_EntryLevelSystemCall;
		providedRole_EntryLevelSystemCall = newProvidedRole_EntryLevelSystemCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, oldProvidedRole_EntryLevelSystemCall, providedRole_EntryLevelSystemCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature getOperationSignature__EntryLevelSystemCall() {
		if (operationSignature__EntryLevelSystemCall != null && operationSignature__EntryLevelSystemCall.eIsProxy()) {
			InternalEObject oldOperationSignature__EntryLevelSystemCall = (InternalEObject)operationSignature__EntryLevelSystemCall;
			operationSignature__EntryLevelSystemCall = (OperationSignature)eResolveProxy(oldOperationSignature__EntryLevelSystemCall);
			if (operationSignature__EntryLevelSystemCall != oldOperationSignature__EntryLevelSystemCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, oldOperationSignature__EntryLevelSystemCall, operationSignature__EntryLevelSystemCall));
			}
		}
		return operationSignature__EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature basicGetOperationSignature__EntryLevelSystemCall() {
		return operationSignature__EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationSignature__EntryLevelSystemCall(OperationSignature newOperationSignature__EntryLevelSystemCall) {
		OperationSignature oldOperationSignature__EntryLevelSystemCall = operationSignature__EntryLevelSystemCall;
		operationSignature__EntryLevelSystemCall = newOperationSignature__EntryLevelSystemCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, oldOperationSignature__EntryLevelSystemCall, operationSignature__EntryLevelSystemCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableSetter> getOutputVariableSetters__EntryLevelSystemCall() {
		if (outputVariableSetters__EntryLevelSystemCall == null) {
			outputVariableSetters__EntryLevelSystemCall = new EObjectContainmentWithInverseEList<VariableSetter>(VariableSetter.class, this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL, ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER);
		}
		return outputVariableSetters__EntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableSetter> getInputVariableSetters__EntryLevelSystemCall() {
		if (inputVariableSetters__EntryLevelSystemCall == null) {
			inputVariableSetters__EntryLevelSystemCall = new EObjectContainmentWithInverseEList<VariableSetter>(VariableSetter.class, this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL, ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER);
		}
		return inputVariableSetters__EntryLevelSystemCall;
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputVariableSetters__EntryLevelSystemCall()).basicAdd(otherEnd, msgs);
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputVariableSetters__EntryLevelSystemCall()).basicAdd(otherEnd, msgs);
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return ((InternalEList<?>)getOutputVariableSetters__EntryLevelSystemCall()).basicRemove(otherEnd, msgs);
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return ((InternalEList<?>)getInputVariableSetters__EntryLevelSystemCall()).basicRemove(otherEnd, msgs);
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				if (resolve) return getProvidedRole_EntryLevelSystemCall();
				return basicGetProvidedRole_EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				if (resolve) return getOperationSignature__EntryLevelSystemCall();
				return basicGetOperationSignature__EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return getOutputVariableSetters__EntryLevelSystemCall();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return getInputVariableSetters__EntryLevelSystemCall();
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				setProvidedRole_EntryLevelSystemCall((OperationProvidedRole)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				setOperationSignature__EntryLevelSystemCall((OperationSignature)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				getOutputVariableSetters__EntryLevelSystemCall().clear();
				getOutputVariableSetters__EntryLevelSystemCall().addAll((Collection<? extends VariableSetter>)newValue);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				getInputVariableSetters__EntryLevelSystemCall().clear();
				getInputVariableSetters__EntryLevelSystemCall().addAll((Collection<? extends VariableSetter>)newValue);
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				setProvidedRole_EntryLevelSystemCall((OperationProvidedRole)null);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				setOperationSignature__EntryLevelSystemCall((OperationSignature)null);
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				getOutputVariableSetters__EntryLevelSystemCall().clear();
				return;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				getInputVariableSetters__EntryLevelSystemCall().clear();
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
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
				return providedRole_EntryLevelSystemCall != null;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
				return operationSignature__EntryLevelSystemCall != null;
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return outputVariableSetters__EntryLevelSystemCall != null && !outputVariableSetters__EntryLevelSystemCall.isEmpty();
			case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL:
				return inputVariableSetters__EntryLevelSystemCall != null && !inputVariableSetters__EntryLevelSystemCall.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EntryLevelSystemCallImpl
