/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.CapraExpression;
import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.ExternalSelector;
import de.uka.ipd.sdq.capra.core.InputEventAction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ExternalSelectorImpl#getInput <em>Input</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ExternalSelectorImpl#getTargetProcess <em>Target Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalSelectorImpl extends EObjectImpl implements ExternalSelector {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected InputEventAction input;

	/**
	 * The cached value of the '{@link #getTargetProcess() <em>Target Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProcess()
	 * @generated
	 * @ordered
	 */
	protected CapraExpression targetProcess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.EXTERNAL_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEventAction getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(InputEventAction newInput, NotificationChain msgs) {
		InputEventAction oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.EXTERNAL_SELECTOR__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(InputEventAction newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.EXTERNAL_SELECTOR__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.EXTERNAL_SELECTOR__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EXTERNAL_SELECTOR__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapraExpression getTargetProcess() {
		return targetProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetProcess(CapraExpression newTargetProcess, NotificationChain msgs) {
		CapraExpression oldTargetProcess = targetProcess;
		targetProcess = newTargetProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS, oldTargetProcess, newTargetProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProcess(CapraExpression newTargetProcess) {
		if (newTargetProcess != targetProcess) {
			NotificationChain msgs = null;
			if (targetProcess != null)
				msgs = ((InternalEObject)targetProcess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS, null, msgs);
			if (newTargetProcess != null)
				msgs = ((InternalEObject)newTargetProcess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS, null, msgs);
			msgs = basicSetTargetProcess(newTargetProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS, newTargetProcess, newTargetProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.EXTERNAL_SELECTOR__INPUT:
				return basicSetInput(null, msgs);
			case CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS:
				return basicSetTargetProcess(null, msgs);
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
			case CorePackage.EXTERNAL_SELECTOR__INPUT:
				return getInput();
			case CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS:
				return getTargetProcess();
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
			case CorePackage.EXTERNAL_SELECTOR__INPUT:
				setInput((InputEventAction)newValue);
				return;
			case CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS:
				setTargetProcess((CapraExpression)newValue);
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
			case CorePackage.EXTERNAL_SELECTOR__INPUT:
				setInput((InputEventAction)null);
				return;
			case CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS:
				setTargetProcess((CapraExpression)null);
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
			case CorePackage.EXTERNAL_SELECTOR__INPUT:
				return input != null;
			case CorePackage.EXTERNAL_SELECTOR__TARGET_PROCESS:
				return targetProcess != null;
		}
		return super.eIsSet(featureID);
	}

} //ExternalSelectorImpl
