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
import scheduler.configuration.StarvationBoost;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Starvation Boost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.StarvationBoostImpl#getStarvationLimit <em>Starvation Limit</em>}</li>
 *   <li>{@link scheduler.configuration.impl.StarvationBoostImpl#getBoost <em>Boost</em>}</li>
 *   <li>{@link scheduler.configuration.impl.StarvationBoostImpl#getDurationInTimeslices <em>Duration In Timeslices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StarvationBoostImpl extends EObjectImpl implements StarvationBoost {
	/**
	 * The default value of the '{@link #getStarvationLimit() <em>Starvation Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarvationLimit()
	 * @generated
	 * @ordered
	 */
	protected static final double STARVATION_LIMIT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStarvationLimit() <em>Starvation Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarvationLimit()
	 * @generated
	 * @ordered
	 */
	protected double starvationLimit = STARVATION_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBoost() <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoost()
	 * @generated
	 * @ordered
	 */
	protected static final int BOOST_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBoost() <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoost()
	 * @generated
	 * @ordered
	 */
	protected int boost = BOOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getDurationInTimeslices() <em>Duration In Timeslices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDurationInTimeslices()
	 * @generated
	 * @ordered
	 */
	protected static final int DURATION_IN_TIMESLICES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDurationInTimeslices() <em>Duration In Timeslices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDurationInTimeslices()
	 * @generated
	 * @ordered
	 */
	protected int durationInTimeslices = DURATION_IN_TIMESLICES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StarvationBoostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.STARVATION_BOOST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStarvationLimit() {
		return starvationLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarvationLimit(double newStarvationLimit) {
		double oldStarvationLimit = starvationLimit;
		starvationLimit = newStarvationLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STARVATION_BOOST__STARVATION_LIMIT, oldStarvationLimit, starvationLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBoost() {
		return boost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoost(int newBoost) {
		int oldBoost = boost;
		boost = newBoost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STARVATION_BOOST__BOOST, oldBoost, boost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDurationInTimeslices() {
		return durationInTimeslices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDurationInTimeslices(int newDurationInTimeslices) {
		int oldDurationInTimeslices = durationInTimeslices;
		durationInTimeslices = newDurationInTimeslices;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STARVATION_BOOST__DURATION_IN_TIMESLICES, oldDurationInTimeslices, durationInTimeslices));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.STARVATION_BOOST__STARVATION_LIMIT:
				return getStarvationLimit();
			case ConfigurationPackage.STARVATION_BOOST__BOOST:
				return getBoost();
			case ConfigurationPackage.STARVATION_BOOST__DURATION_IN_TIMESLICES:
				return getDurationInTimeslices();
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
			case ConfigurationPackage.STARVATION_BOOST__STARVATION_LIMIT:
				setStarvationLimit((Double)newValue);
				return;
			case ConfigurationPackage.STARVATION_BOOST__BOOST:
				setBoost((Integer)newValue);
				return;
			case ConfigurationPackage.STARVATION_BOOST__DURATION_IN_TIMESLICES:
				setDurationInTimeslices((Integer)newValue);
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
			case ConfigurationPackage.STARVATION_BOOST__STARVATION_LIMIT:
				setStarvationLimit(STARVATION_LIMIT_EDEFAULT);
				return;
			case ConfigurationPackage.STARVATION_BOOST__BOOST:
				setBoost(BOOST_EDEFAULT);
				return;
			case ConfigurationPackage.STARVATION_BOOST__DURATION_IN_TIMESLICES:
				setDurationInTimeslices(DURATION_IN_TIMESLICES_EDEFAULT);
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
			case ConfigurationPackage.STARVATION_BOOST__STARVATION_LIMIT:
				return starvationLimit != STARVATION_LIMIT_EDEFAULT;
			case ConfigurationPackage.STARVATION_BOOST__BOOST:
				return boost != BOOST_EDEFAULT;
			case ConfigurationPackage.STARVATION_BOOST__DURATION_IN_TIMESLICES:
				return durationInTimeslices != DURATION_IN_TIMESLICES_EDEFAULT;
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
		result.append(" (starvationLimit: ");
		result.append(starvationLimit);
		result.append(", boost: ");
		result.append(boost);
		result.append(", durationInTimeslices: ");
		result.append(durationInTimeslices);
		result.append(')');
		return result.toString();
	}

} //StarvationBoostImpl
