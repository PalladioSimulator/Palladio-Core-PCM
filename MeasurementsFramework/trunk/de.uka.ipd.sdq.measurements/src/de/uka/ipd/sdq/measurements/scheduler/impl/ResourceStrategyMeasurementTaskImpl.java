/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler.impl;

import de.uka.ipd.sdq.measurements.impl.MachineTaskImpl;

import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask;
import de.uka.ipd.sdq.measurements.scheduler.schedulerPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Strategy Measurement Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementTaskImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementTaskImpl#getDemand <em>Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceStrategyMeasurementTaskImpl extends MachineTaskImpl implements ResourceStrategyMeasurementTask {
	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected int duration = DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDemand() <em>Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemand()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceStrategyDemand DEMAND_EDEFAULT = ResourceStrategyDemand.WAIT_DEMAND;

	/**
	 * The cached value of the '{@link #getDemand() <em>Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemand()
	 * @generated
	 * @ordered
	 */
	protected ResourceStrategyDemand demand = DEMAND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceStrategyMeasurementTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return schedulerPackage.Literals.RESOURCE_STRATEGY_MEASUREMENT_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(int newDuration) {
		int oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceStrategyDemand getDemand() {
		return demand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDemand(ResourceStrategyDemand newDemand) {
		ResourceStrategyDemand oldDemand = demand;
		demand = newDemand == null ? DEMAND_EDEFAULT : newDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND, oldDemand, demand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION:
				return getDuration();
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND:
				return getDemand();
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
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION:
				setDuration((Integer)newValue);
				return;
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND:
				setDemand((ResourceStrategyDemand)newValue);
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
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND:
				setDemand(DEMAND_EDEFAULT);
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
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION:
				return duration != DURATION_EDEFAULT;
			case schedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND:
				return demand != DEMAND_EDEFAULT;
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
		result.append(" (duration: ");
		result.append(duration);
		result.append(", demand: ");
		result.append(demand);
		result.append(')');
		return result.toString();
	}

} //ResourceStrategyMeasurementTaskImpl
