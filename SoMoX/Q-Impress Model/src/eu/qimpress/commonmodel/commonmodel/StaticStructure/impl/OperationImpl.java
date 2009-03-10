/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Message;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.OperationImpl#getInput <em>Input</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.OperationImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.OperationImpl#getThrowsExceptions <em>Throws Exceptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends NamedEntityImpl implements Operation {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Message input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Message output;

	/**
	 * The cached value of the '{@link #getThrowsExceptions() <em>Throws Exceptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrowsExceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception> throwsExceptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(Message newInput, NotificationChain msgs) {
		Message oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StaticStructurePackage.OPERATION__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(Message newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StaticStructurePackage.OPERATION__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StaticStructurePackage.OPERATION__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticStructurePackage.OPERATION__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(Message newOutput, NotificationChain msgs) {
		Message oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StaticStructurePackage.OPERATION__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Message newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StaticStructurePackage.OPERATION__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StaticStructurePackage.OPERATION__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticStructurePackage.OPERATION__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception> getThrowsExceptions() {
		if (throwsExceptions == null) {
			throwsExceptions = new EObjectContainmentEList<eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception>(eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception.class, this, StaticStructurePackage.OPERATION__THROWS_EXCEPTIONS);
		}
		return throwsExceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StaticStructurePackage.OPERATION__INPUT:
				return basicSetInput(null, msgs);
			case StaticStructurePackage.OPERATION__OUTPUT:
				return basicSetOutput(null, msgs);
			case StaticStructurePackage.OPERATION__THROWS_EXCEPTIONS:
				return ((InternalEList<?>)getThrowsExceptions()).basicRemove(otherEnd, msgs);
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
			case StaticStructurePackage.OPERATION__INPUT:
				return getInput();
			case StaticStructurePackage.OPERATION__OUTPUT:
				return getOutput();
			case StaticStructurePackage.OPERATION__THROWS_EXCEPTIONS:
				return getThrowsExceptions();
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
			case StaticStructurePackage.OPERATION__INPUT:
				setInput((Message)newValue);
				return;
			case StaticStructurePackage.OPERATION__OUTPUT:
				setOutput((Message)newValue);
				return;
			case StaticStructurePackage.OPERATION__THROWS_EXCEPTIONS:
				getThrowsExceptions().clear();
				getThrowsExceptions().addAll((Collection<? extends eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception>)newValue);
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
			case StaticStructurePackage.OPERATION__INPUT:
				setInput((Message)null);
				return;
			case StaticStructurePackage.OPERATION__OUTPUT:
				setOutput((Message)null);
				return;
			case StaticStructurePackage.OPERATION__THROWS_EXCEPTIONS:
				getThrowsExceptions().clear();
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
			case StaticStructurePackage.OPERATION__INPUT:
				return input != null;
			case StaticStructurePackage.OPERATION__OUTPUT:
				return output != null;
			case StaticStructurePackage.OPERATION__THROWS_EXCEPTIONS:
				return throwsExceptions != null && !throwsExceptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationImpl
