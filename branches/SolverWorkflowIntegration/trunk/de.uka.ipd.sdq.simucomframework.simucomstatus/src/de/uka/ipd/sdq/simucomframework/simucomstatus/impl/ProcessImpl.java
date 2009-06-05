/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.Action;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ProcessImpl#getCurrentAction <em>Current Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ProcessImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.ProcessImpl#getProcessStartTime <em>Process Start Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessImpl extends EObjectImpl implements de.uka.ipd.sdq.simucomframework.simucomstatus.Process {
	/**
	 * The cached value of the '{@link #getCurrentAction() <em>Current Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentAction()
	 * @generated
	 * @ordered
	 */
	protected Action currentAction;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessStartTime() <em>Process Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final double PROCESS_START_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProcessStartTime() <em>Process Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessStartTime()
	 * @generated
	 * @ordered
	 */
	protected double processStartTime = PROCESS_START_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimucomstatusPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getCurrentAction() {
		return currentAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentAction(Action newCurrentAction, NotificationChain msgs) {
		Action oldCurrentAction = currentAction;
		currentAction = newCurrentAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.PROCESS__CURRENT_ACTION, oldCurrentAction, newCurrentAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentAction(Action newCurrentAction) {
		if (newCurrentAction != currentAction) {
			NotificationChain msgs = null;
			if (currentAction != null)
				msgs = ((InternalEObject)currentAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimucomstatusPackage.PROCESS__CURRENT_ACTION, null, msgs);
			if (newCurrentAction != null)
				msgs = ((InternalEObject)newCurrentAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimucomstatusPackage.PROCESS__CURRENT_ACTION, null, msgs);
			msgs = basicSetCurrentAction(newCurrentAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.PROCESS__CURRENT_ACTION, newCurrentAction, newCurrentAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.PROCESS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProcessStartTime() {
		return processStartTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessStartTime(double newProcessStartTime) {
		double oldProcessStartTime = processStartTime;
		processStartTime = newProcessStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.PROCESS__PROCESS_START_TIME, oldProcessStartTime, processStartTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimucomstatusPackage.PROCESS__CURRENT_ACTION:
				return basicSetCurrentAction(null, msgs);
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
			case SimucomstatusPackage.PROCESS__CURRENT_ACTION:
				return getCurrentAction();
			case SimucomstatusPackage.PROCESS__ID:
				return getId();
			case SimucomstatusPackage.PROCESS__PROCESS_START_TIME:
				return new Double(getProcessStartTime());
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
			case SimucomstatusPackage.PROCESS__CURRENT_ACTION:
				setCurrentAction((Action)newValue);
				return;
			case SimucomstatusPackage.PROCESS__ID:
				setId((String)newValue);
				return;
			case SimucomstatusPackage.PROCESS__PROCESS_START_TIME:
				setProcessStartTime(((Double)newValue).doubleValue());
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
			case SimucomstatusPackage.PROCESS__CURRENT_ACTION:
				setCurrentAction((Action)null);
				return;
			case SimucomstatusPackage.PROCESS__ID:
				setId(ID_EDEFAULT);
				return;
			case SimucomstatusPackage.PROCESS__PROCESS_START_TIME:
				setProcessStartTime(PROCESS_START_TIME_EDEFAULT);
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
			case SimucomstatusPackage.PROCESS__CURRENT_ACTION:
				return currentAction != null;
			case SimucomstatusPackage.PROCESS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SimucomstatusPackage.PROCESS__PROCESS_START_TIME:
				return processStartTime != PROCESS_START_TIME_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", processStartTime: ");
		result.append(processStartTime);
		result.append(')');
		return result.toString();
	}

} //ProcessImpl
