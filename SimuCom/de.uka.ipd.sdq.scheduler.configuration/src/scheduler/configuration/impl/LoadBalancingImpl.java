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
import scheduler.configuration.InstanceToBalance;
import scheduler.configuration.LoadBalancing;
import scheduler.configuration.LoadBalancingType;
import scheduler.configuration.PreferredPriority;
import scheduler.configuration.PreferredWaitingTime;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Balancing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.LoadBalancingImpl#getBalancingType <em>Balancing Type</em>}</li>
 *   <li>{@link scheduler.configuration.impl.LoadBalancingImpl#getPreferredWaitingTime <em>Preferred Waiting Time</em>}</li>
 *   <li>{@link scheduler.configuration.impl.LoadBalancingImpl#getPreferredPriority <em>Preferred Priority</em>}</li>
 *   <li>{@link scheduler.configuration.impl.LoadBalancingImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link scheduler.configuration.impl.LoadBalancingImpl#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link scheduler.configuration.impl.LoadBalancingImpl#getMaxIterations <em>Max Iterations</em>}</li>
 *   <li>{@link scheduler.configuration.impl.LoadBalancingImpl#getBalancingInterval <em>Balancing Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadBalancingImpl extends EObjectImpl implements LoadBalancing {
	/**
	 * The default value of the '{@link #getBalancingType() <em>Balancing Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalancingType()
	 * @generated
	 * @ordered
	 */
	protected static final LoadBalancingType BALANCING_TYPE_EDEFAULT = LoadBalancingType.IDLE_TO_ONE;

	/**
	 * The cached value of the '{@link #getBalancingType() <em>Balancing Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalancingType()
	 * @generated
	 * @ordered
	 */
	protected LoadBalancingType balancingType = BALANCING_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreferredWaitingTime() <em>Preferred Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected static final PreferredWaitingTime PREFERRED_WAITING_TIME_EDEFAULT = PreferredWaitingTime.LONG;

	/**
	 * The cached value of the '{@link #getPreferredWaitingTime() <em>Preferred Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected PreferredWaitingTime preferredWaitingTime = PREFERRED_WAITING_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreferredPriority() <em>Preferred Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredPriority()
	 * @generated
	 * @ordered
	 */
	protected static final PreferredPriority PREFERRED_PRIORITY_EDEFAULT = PreferredPriority.HIGHER;

	/**
	 * The cached value of the '{@link #getPreferredPriority() <em>Preferred Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredPriority()
	 * @generated
	 * @ordered
	 */
	protected PreferredPriority preferredPriority = PREFERRED_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstances() <em>Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected static final InstanceToBalance INSTANCES_EDEFAULT = InstanceToBalance.CURRENT;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected InstanceToBalance instances = INSTANCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final double THRESHOLD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected double threshold = THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxIterations() <em>Max Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIterations()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_ITERATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxIterations() <em>Max Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIterations()
	 * @generated
	 * @ordered
	 */
	protected int maxIterations = MAX_ITERATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBalancingInterval() <em>Balancing Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalancingInterval()
	 * @generated
	 * @ordered
	 */
	protected static final double BALANCING_INTERVAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBalancingInterval() <em>Balancing Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalancingInterval()
	 * @generated
	 * @ordered
	 */
	protected double balancingInterval = BALANCING_INTERVAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadBalancingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.LOAD_BALANCING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalancingType getBalancingType() {
		return balancingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBalancingType(LoadBalancingType newBalancingType) {
		LoadBalancingType oldBalancingType = balancingType;
		balancingType = newBalancingType == null ? BALANCING_TYPE_EDEFAULT : newBalancingType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.LOAD_BALANCING__BALANCING_TYPE, oldBalancingType, balancingType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferredWaitingTime getPreferredWaitingTime() {
		return preferredWaitingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferredWaitingTime(PreferredWaitingTime newPreferredWaitingTime) {
		PreferredWaitingTime oldPreferredWaitingTime = preferredWaitingTime;
		preferredWaitingTime = newPreferredWaitingTime == null ? PREFERRED_WAITING_TIME_EDEFAULT : newPreferredWaitingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.LOAD_BALANCING__PREFERRED_WAITING_TIME, oldPreferredWaitingTime, preferredWaitingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferredPriority getPreferredPriority() {
		return preferredPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferredPriority(PreferredPriority newPreferredPriority) {
		PreferredPriority oldPreferredPriority = preferredPriority;
		preferredPriority = newPreferredPriority == null ? PREFERRED_PRIORITY_EDEFAULT : newPreferredPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.LOAD_BALANCING__PREFERRED_PRIORITY, oldPreferredPriority, preferredPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceToBalance getInstances() {
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstances(InstanceToBalance newInstances) {
		InstanceToBalance oldInstances = instances;
		instances = newInstances == null ? INSTANCES_EDEFAULT : newInstances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.LOAD_BALANCING__INSTANCES, oldInstances, instances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThreshold() {
		return threshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreshold(double newThreshold) {
		double oldThreshold = threshold;
		threshold = newThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.LOAD_BALANCING__THRESHOLD, oldThreshold, threshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxIterations() {
		return maxIterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxIterations(int newMaxIterations) {
		int oldMaxIterations = maxIterations;
		maxIterations = newMaxIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.LOAD_BALANCING__MAX_ITERATIONS, oldMaxIterations, maxIterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBalancingInterval() {
		return balancingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBalancingInterval(double newBalancingInterval) {
		double oldBalancingInterval = balancingInterval;
		balancingInterval = newBalancingInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.LOAD_BALANCING__BALANCING_INTERVAL, oldBalancingInterval, balancingInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_TYPE:
				return getBalancingType();
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_WAITING_TIME:
				return getPreferredWaitingTime();
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_PRIORITY:
				return getPreferredPriority();
			case ConfigurationPackage.LOAD_BALANCING__INSTANCES:
				return getInstances();
			case ConfigurationPackage.LOAD_BALANCING__THRESHOLD:
				return getThreshold();
			case ConfigurationPackage.LOAD_BALANCING__MAX_ITERATIONS:
				return getMaxIterations();
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_INTERVAL:
				return getBalancingInterval();
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
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_TYPE:
				setBalancingType((LoadBalancingType)newValue);
				return;
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_WAITING_TIME:
				setPreferredWaitingTime((PreferredWaitingTime)newValue);
				return;
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_PRIORITY:
				setPreferredPriority((PreferredPriority)newValue);
				return;
			case ConfigurationPackage.LOAD_BALANCING__INSTANCES:
				setInstances((InstanceToBalance)newValue);
				return;
			case ConfigurationPackage.LOAD_BALANCING__THRESHOLD:
				setThreshold((Double)newValue);
				return;
			case ConfigurationPackage.LOAD_BALANCING__MAX_ITERATIONS:
				setMaxIterations((Integer)newValue);
				return;
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_INTERVAL:
				setBalancingInterval((Double)newValue);
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
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_TYPE:
				setBalancingType(BALANCING_TYPE_EDEFAULT);
				return;
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_WAITING_TIME:
				setPreferredWaitingTime(PREFERRED_WAITING_TIME_EDEFAULT);
				return;
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_PRIORITY:
				setPreferredPriority(PREFERRED_PRIORITY_EDEFAULT);
				return;
			case ConfigurationPackage.LOAD_BALANCING__INSTANCES:
				setInstances(INSTANCES_EDEFAULT);
				return;
			case ConfigurationPackage.LOAD_BALANCING__THRESHOLD:
				setThreshold(THRESHOLD_EDEFAULT);
				return;
			case ConfigurationPackage.LOAD_BALANCING__MAX_ITERATIONS:
				setMaxIterations(MAX_ITERATIONS_EDEFAULT);
				return;
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_INTERVAL:
				setBalancingInterval(BALANCING_INTERVAL_EDEFAULT);
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
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_TYPE:
				return balancingType != BALANCING_TYPE_EDEFAULT;
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_WAITING_TIME:
				return preferredWaitingTime != PREFERRED_WAITING_TIME_EDEFAULT;
			case ConfigurationPackage.LOAD_BALANCING__PREFERRED_PRIORITY:
				return preferredPriority != PREFERRED_PRIORITY_EDEFAULT;
			case ConfigurationPackage.LOAD_BALANCING__INSTANCES:
				return instances != INSTANCES_EDEFAULT;
			case ConfigurationPackage.LOAD_BALANCING__THRESHOLD:
				return threshold != THRESHOLD_EDEFAULT;
			case ConfigurationPackage.LOAD_BALANCING__MAX_ITERATIONS:
				return maxIterations != MAX_ITERATIONS_EDEFAULT;
			case ConfigurationPackage.LOAD_BALANCING__BALANCING_INTERVAL:
				return balancingInterval != BALANCING_INTERVAL_EDEFAULT;
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
		result.append(" (balancingType: ");
		result.append(balancingType);
		result.append(", preferredWaitingTime: ");
		result.append(preferredWaitingTime);
		result.append(", preferredPriority: ");
		result.append(preferredPriority);
		result.append(", instances: ");
		result.append(instances);
		result.append(", threshold: ");
		result.append(threshold);
		result.append(", maxIterations: ");
		result.append(maxIterations);
		result.append(", balancingInterval: ");
		result.append(balancingInterval);
		result.append(')');
		return result.toString();
	}

} //LoadBalancingImpl
