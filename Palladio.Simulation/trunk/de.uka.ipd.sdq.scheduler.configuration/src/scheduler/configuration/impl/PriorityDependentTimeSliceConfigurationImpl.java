/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.PriorityDependentTimeSliceConfiguration;
import scheduler.configuration.TimeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority Dependent Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.PriorityDependentTimeSliceConfigurationImpl#getMinTimeslice <em>Min Timeslice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriorityDependentTimeSliceConfigurationImpl extends TimeSliceConfigurationImpl implements PriorityDependentTimeSliceConfiguration {
	/**
	 * The cached value of the '{@link #getMinTimeslice() <em>Min Timeslice</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinTimeslice()
	 * @generated
	 * @ordered
	 */
	protected TimeValue minTimeslice;

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
	public TimeValue getMinTimeslice() {
		return minTimeslice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinTimeslice(TimeValue newMinTimeslice, NotificationChain msgs) {
		TimeValue oldMinTimeslice = minTimeslice;
		minTimeslice = newMinTimeslice;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE, oldMinTimeslice, newMinTimeslice);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinTimeslice(TimeValue newMinTimeslice) {
		if (newMinTimeslice != minTimeslice) {
			NotificationChain msgs = null;
			if (minTimeslice != null)
				msgs = ((InternalEObject)minTimeslice).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE, null, msgs);
			if (newMinTimeslice != null)
				msgs = ((InternalEObject)newMinTimeslice).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE, null, msgs);
			msgs = basicSetMinTimeslice(newMinTimeslice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE, newMinTimeslice, newMinTimeslice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE:
				return basicSetMinTimeslice(null, msgs);
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
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION__MIN_TIMESLICE:
				return getMinTimeslice();
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
				setMinTimeslice((TimeValue)newValue);
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
				setMinTimeslice((TimeValue)null);
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
				return minTimeslice != null;
		}
		return super.eIsSet(featureID);
	}

} //PriorityDependentTimeSliceConfigurationImpl
