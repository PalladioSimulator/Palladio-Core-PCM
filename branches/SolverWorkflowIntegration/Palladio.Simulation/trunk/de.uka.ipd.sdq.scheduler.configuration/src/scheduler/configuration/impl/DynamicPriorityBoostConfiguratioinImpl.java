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
import scheduler.configuration.DynamicPriorityBoostConfiguratioin;
import scheduler.configuration.TimeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Priority Boost Configuratioin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.DynamicPriorityBoostConfiguratioinImpl#getMaxBonus <em>Max Bonus</em>}</li>
 *   <li>{@link scheduler.configuration.impl.DynamicPriorityBoostConfiguratioinImpl#getMaxSleepAverage <em>Max Sleep Average</em>}</li>
 *   <li>{@link scheduler.configuration.impl.DynamicPriorityBoostConfiguratioinImpl#getThreshold <em>Threshold</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicPriorityBoostConfiguratioinImpl extends PriorityBoostConfigurationImpl implements DynamicPriorityBoostConfiguratioin {
	/**
	 * The default value of the '{@link #getMaxBonus() <em>Max Bonus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBonus()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_BONUS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxBonus() <em>Max Bonus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBonus()
	 * @generated
	 * @ordered
	 */
	protected int maxBonus = MAX_BONUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMaxSleepAverage() <em>Max Sleep Average</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSleepAverage()
	 * @generated
	 * @ordered
	 */
	protected TimeValue maxSleepAverage;

	/**
	 * The default value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final int THRESHOLD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected int threshold = THRESHOLD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicPriorityBoostConfiguratioinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxBonus() {
		return maxBonus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBonus(int newMaxBonus) {
		int oldMaxBonus = maxBonus;
		maxBonus = newMaxBonus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS, oldMaxBonus, maxBonus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeValue getMaxSleepAverage() {
		return maxSleepAverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxSleepAverage(TimeValue newMaxSleepAverage, NotificationChain msgs) {
		TimeValue oldMaxSleepAverage = maxSleepAverage;
		maxSleepAverage = newMaxSleepAverage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE, oldMaxSleepAverage, newMaxSleepAverage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSleepAverage(TimeValue newMaxSleepAverage) {
		if (newMaxSleepAverage != maxSleepAverage) {
			NotificationChain msgs = null;
			if (maxSleepAverage != null)
				msgs = ((InternalEObject)maxSleepAverage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE, null, msgs);
			if (newMaxSleepAverage != null)
				msgs = ((InternalEObject)newMaxSleepAverage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE, null, msgs);
			msgs = basicSetMaxSleepAverage(newMaxSleepAverage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE, newMaxSleepAverage, newMaxSleepAverage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getThreshold() {
		return threshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreshold(int newThreshold) {
		int oldThreshold = threshold;
		threshold = newThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD, oldThreshold, threshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE:
				return basicSetMaxSleepAverage(null, msgs);
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
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS:
				return new Integer(getMaxBonus());
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE:
				return getMaxSleepAverage();
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD:
				return new Integer(getThreshold());
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
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS:
				setMaxBonus(((Integer)newValue).intValue());
				return;
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE:
				setMaxSleepAverage((TimeValue)newValue);
				return;
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD:
				setThreshold(((Integer)newValue).intValue());
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
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS:
				setMaxBonus(MAX_BONUS_EDEFAULT);
				return;
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE:
				setMaxSleepAverage((TimeValue)null);
				return;
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD:
				setThreshold(THRESHOLD_EDEFAULT);
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
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_BONUS:
				return maxBonus != MAX_BONUS_EDEFAULT;
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__MAX_SLEEP_AVERAGE:
				return maxSleepAverage != null;
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN__THRESHOLD:
				return threshold != THRESHOLD_EDEFAULT;
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
		result.append(" (maxBonus: ");
		result.append(maxBonus);
		result.append(", threshold: ");
		result.append(threshold);
		result.append(')');
		return result.toString();
	}

} //DynamicPriorityBoostConfiguratioinImpl
