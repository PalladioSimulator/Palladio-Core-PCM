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
import scheduler.configuration.PriorityRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.PriorityRangeImpl#getHighest <em>Highest</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PriorityRangeImpl#getHigh <em>High</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PriorityRangeImpl#getAverage <em>Average</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PriorityRangeImpl#getLow <em>Low</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PriorityRangeImpl#getLowest <em>Lowest</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PriorityRangeImpl#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriorityRangeImpl extends EObjectImpl implements PriorityRange {
	/**
	 * The default value of the '{@link #getHighest() <em>Highest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighest()
	 * @generated
	 * @ordered
	 */
	protected static final int HIGHEST_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHighest() <em>Highest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighest()
	 * @generated
	 * @ordered
	 */
	protected int highest = HIGHEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getHigh() <em>High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected static final int HIGH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHigh() <em>High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected int high = HIGH_EDEFAULT;

	/**
	 * The default value of the '{@link #getAverage() <em>Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverage()
	 * @generated
	 * @ordered
	 */
	protected static final int AVERAGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAverage() <em>Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverage()
	 * @generated
	 * @ordered
	 */
	protected int average = AVERAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLow() <em>Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected static final int LOW_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLow() <em>Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected int low = LOW_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowest() <em>Lowest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowest()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWEST_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLowest() <em>Lowest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowest()
	 * @generated
	 * @ordered
	 */
	protected int lowest = LOWEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected int default_ = DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PriorityRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PRIORITY_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHighest() {
		return highest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighest(int newHighest) {
		int oldHighest = highest;
		highest = newHighest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_RANGE__HIGHEST, oldHighest, highest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHigh() {
		return high;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigh(int newHigh) {
		int oldHigh = high;
		high = newHigh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_RANGE__HIGH, oldHigh, high));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAverage() {
		return average;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverage(int newAverage) {
		int oldAverage = average;
		average = newAverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_RANGE__AVERAGE, oldAverage, average));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLow() {
		return low;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLow(int newLow) {
		int oldLow = low;
		low = newLow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_RANGE__LOW, oldLow, low));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowest() {
		return lowest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowest(int newLowest) {
		int oldLowest = lowest;
		lowest = newLowest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_RANGE__LOWEST, oldLowest, lowest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(int newDefault) {
		int oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_RANGE__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.PRIORITY_RANGE__HIGHEST:
				return getHighest();
			case ConfigurationPackage.PRIORITY_RANGE__HIGH:
				return getHigh();
			case ConfigurationPackage.PRIORITY_RANGE__AVERAGE:
				return getAverage();
			case ConfigurationPackage.PRIORITY_RANGE__LOW:
				return getLow();
			case ConfigurationPackage.PRIORITY_RANGE__LOWEST:
				return getLowest();
			case ConfigurationPackage.PRIORITY_RANGE__DEFAULT:
				return getDefault();
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
			case ConfigurationPackage.PRIORITY_RANGE__HIGHEST:
				setHighest((Integer)newValue);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__HIGH:
				setHigh((Integer)newValue);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__AVERAGE:
				setAverage((Integer)newValue);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__LOW:
				setLow((Integer)newValue);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__LOWEST:
				setLowest((Integer)newValue);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__DEFAULT:
				setDefault((Integer)newValue);
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
			case ConfigurationPackage.PRIORITY_RANGE__HIGHEST:
				setHighest(HIGHEST_EDEFAULT);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__HIGH:
				setHigh(HIGH_EDEFAULT);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__AVERAGE:
				setAverage(AVERAGE_EDEFAULT);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__LOW:
				setLow(LOW_EDEFAULT);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__LOWEST:
				setLowest(LOWEST_EDEFAULT);
				return;
			case ConfigurationPackage.PRIORITY_RANGE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
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
			case ConfigurationPackage.PRIORITY_RANGE__HIGHEST:
				return highest != HIGHEST_EDEFAULT;
			case ConfigurationPackage.PRIORITY_RANGE__HIGH:
				return high != HIGH_EDEFAULT;
			case ConfigurationPackage.PRIORITY_RANGE__AVERAGE:
				return average != AVERAGE_EDEFAULT;
			case ConfigurationPackage.PRIORITY_RANGE__LOW:
				return low != LOW_EDEFAULT;
			case ConfigurationPackage.PRIORITY_RANGE__LOWEST:
				return lowest != LOWEST_EDEFAULT;
			case ConfigurationPackage.PRIORITY_RANGE__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
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
		result.append(" (highest: ");
		result.append(highest);
		result.append(", high: ");
		result.append(high);
		result.append(", average: ");
		result.append(average);
		result.append(", low: ");
		result.append(low);
		result.append(", lowest: ");
		result.append(lowest);
		result.append(", default: ");
		result.append(default_);
		result.append(')');
		return result.toString();
	}

} //PriorityRangeImpl
