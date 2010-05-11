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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.TimeSliceConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.TimeSliceConfigurationImpl#getTimeslice <em>Timeslice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TimeSliceConfigurationImpl extends EObjectImpl implements TimeSliceConfiguration {
	/**
	 * The default value of the '{@link #getTimeslice() <em>Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeslice()
	 * @generated
	 * @ordered
	 */
	protected static final double TIMESLICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTimeslice() <em>Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeslice()
	 * @generated
	 * @ordered
	 */
	protected double timeslice = TIMESLICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeSliceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.TIME_SLICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTimeslice() {
		return timeslice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeslice(double newTimeslice) {
		double oldTimeslice = timeslice;
		timeslice = newTimeslice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE, oldTimeslice, timeslice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				return getTimeslice();
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
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				setTimeslice((Double)newValue);
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
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				setTimeslice(TIMESLICE_EDEFAULT);
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
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				return timeslice != TIMESLICE_EDEFAULT;
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
		result.append(" (timeslice: ");
		result.append(timeslice);
		result.append(')');
		return result.toString();
	}

} //TimeSliceConfigurationImpl
