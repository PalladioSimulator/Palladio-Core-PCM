/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.PriorityDependentTimeSliceConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority Dependent Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.PriorityDependentTimeSliceConfigurationImpl#getMinTimeslice <em>Min Timeslice</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PriorityDependentTimeSliceConfigurationImpl#getMinTimeToBeScheduled <em>Min Time To Be Scheduled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriorityDependentTimeSliceConfigurationImpl extends TimeSliceConfigurationImpl implements PriorityDependentTimeSliceConfiguration {
	/**
	 * The default value of the '{@link #getMinTimeslice() <em>Min Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinTimeslice()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_TIMESLICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinTimeslice() <em>Min Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinTimeslice()
	 * @generated
	 * @ordered
	 */
	protected double minTimeslice = MIN_TIMESLICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinTimeToBeScheduled() <em>Min Time To Be Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinTimeToBeScheduled()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_TIME_TO_BE_SCHEDULED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinTimeToBeScheduled() <em>Min Time To Be Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinTimeToBeScheduled()
	 * @generated
	 * @ordered
	 */
	protected double minTimeToBeScheduled = MIN_TIME_TO_BE_SCHEDULED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PriorityDependentTimeSliceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinTimeslice() {
		return minTimeslice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinTimeslice(double newMinTimeslice) {
		double oldMinTimeslice = minTimeslice;
		minTimeslice = newMinTimeslice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE, oldMinTimeslice, minTimeslice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinTimeToBeScheduled() {
		return minTimeToBeScheduled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinTimeToBeScheduled(double newMinTimeToBeScheduled) {
		double oldMinTimeToBeScheduled = minTimeToBeScheduled;
		minTimeToBeScheduled = newMinTimeToBeScheduled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED, oldMinTimeToBeScheduled, minTimeToBeScheduled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE:
				return getMinTimeslice();
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED:
				return getMinTimeToBeScheduled();
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
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE:
				setMinTimeslice((Double)newValue);
				return;
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED:
				setMinTimeToBeScheduled((Double)newValue);
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
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE:
				setMinTimeslice(MIN_TIMESLICE_EDEFAULT);
				return;
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED:
				setMinTimeToBeScheduled(MIN_TIME_TO_BE_SCHEDULED_EDEFAULT);
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
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE:
				return minTimeslice != MIN_TIMESLICE_EDEFAULT;
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIME_TO_BE_SCHEDULED:
				return minTimeToBeScheduled != MIN_TIME_TO_BE_SCHEDULED_EDEFAULT;
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
		result.append(" (minTimeslice: ");
		result.append(minTimeslice);
		result.append(", minTimeToBeScheduled: ");
		result.append(minTimeToBeScheduled);
		result.append(')');
		return result.toString();
	}

} //PriorityDependentTimeSliceConfigurationImpl
