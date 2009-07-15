/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passive Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl#getWaitingProcesses <em>Waiting Processes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl#getInitialResourceCount <em>Initial Resource Count</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl#getResourcesAvailable <em>Resources Available</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.PassiveResourceImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PassiveResourceImpl extends EObjectImpl implements PassiveResource {
	/**
	 * The cached value of the '{@link #getWaitingProcesses() <em>Waiting Processes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<WaitForAcquire> waitingProcesses;

	/**
	 * The default value of the '{@link #getInitialResourceCount() <em>Initial Resource Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialResourceCount()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIAL_RESOURCE_COUNT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInitialResourceCount() <em>Initial Resource Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialResourceCount()
	 * @generated
	 * @ordered
	 */
	protected double initialResourceCount = INITIAL_RESOURCE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourcesAvailable() <em>Resources Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcesAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final double RESOURCES_AVAILABLE_EDEFAULT = 0.0;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassiveResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimucomstatusPackage.Literals.PASSIVE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WaitForAcquire> getWaitingProcesses() {
		if (waitingProcesses == null) {
			waitingProcesses = new EObjectWithInverseResolvingEList<WaitForAcquire>(WaitForAcquire.class, this, SimucomstatusPackage.PASSIVE_RESOURCE__WAITING_PROCESSES, SimucomstatusPackage.WAIT_FOR_ACQUIRE__RESOURCE);
		}
		return waitingProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialResourceCount() {
		return initialResourceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialResourceCount(double newInitialResourceCount) {
		double oldInitialResourceCount = initialResourceCount;
		initialResourceCount = newInitialResourceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT, oldInitialResourceCount, initialResourceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getResourcesAvailable() {
		// TODO: implement this method to return the 'Resources Available' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourcesAvailable(double newResourcesAvailable) {
		// TODO: implement this method to set the 'Resources Available' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.PASSIVE_RESOURCE__ID, oldId, id));
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
			case SimucomstatusPackage.PASSIVE_RESOURCE__WAITING_PROCESSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWaitingProcesses()).basicAdd(otherEnd, msgs);
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
			case SimucomstatusPackage.PASSIVE_RESOURCE__WAITING_PROCESSES:
				return ((InternalEList<?>)getWaitingProcesses()).basicRemove(otherEnd, msgs);
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
			case SimucomstatusPackage.PASSIVE_RESOURCE__WAITING_PROCESSES:
				return getWaitingProcesses();
			case SimucomstatusPackage.PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT:
				return new Double(getInitialResourceCount());
			case SimucomstatusPackage.PASSIVE_RESOURCE__RESOURCES_AVAILABLE:
				return new Double(getResourcesAvailable());
			case SimucomstatusPackage.PASSIVE_RESOURCE__ID:
				return getId();
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
			case SimucomstatusPackage.PASSIVE_RESOURCE__WAITING_PROCESSES:
				getWaitingProcesses().clear();
				getWaitingProcesses().addAll((Collection<? extends WaitForAcquire>)newValue);
				return;
			case SimucomstatusPackage.PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT:
				setInitialResourceCount(((Double)newValue).doubleValue());
				return;
			case SimucomstatusPackage.PASSIVE_RESOURCE__RESOURCES_AVAILABLE:
				setResourcesAvailable(((Double)newValue).doubleValue());
				return;
			case SimucomstatusPackage.PASSIVE_RESOURCE__ID:
				setId((String)newValue);
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
			case SimucomstatusPackage.PASSIVE_RESOURCE__WAITING_PROCESSES:
				getWaitingProcesses().clear();
				return;
			case SimucomstatusPackage.PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT:
				setInitialResourceCount(INITIAL_RESOURCE_COUNT_EDEFAULT);
				return;
			case SimucomstatusPackage.PASSIVE_RESOURCE__RESOURCES_AVAILABLE:
				setResourcesAvailable(RESOURCES_AVAILABLE_EDEFAULT);
				return;
			case SimucomstatusPackage.PASSIVE_RESOURCE__ID:
				setId(ID_EDEFAULT);
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
			case SimucomstatusPackage.PASSIVE_RESOURCE__WAITING_PROCESSES:
				return waitingProcesses != null && !waitingProcesses.isEmpty();
			case SimucomstatusPackage.PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT:
				return initialResourceCount != INITIAL_RESOURCE_COUNT_EDEFAULT;
			case SimucomstatusPackage.PASSIVE_RESOURCE__RESOURCES_AVAILABLE:
				return getResourcesAvailable() != RESOURCES_AVAILABLE_EDEFAULT;
			case SimucomstatusPackage.PASSIVE_RESOURCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (initialResourceCount: ");
		result.append(initialResourceCount);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //PassiveResourceImpl
