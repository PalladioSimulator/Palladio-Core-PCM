/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.PreemptionConfiguration;
import scheduler.configuration.PriorityConfiguration;
import scheduler.configuration.QueueingConfiguration;
import scheduler.configuration.SchedulerConfiguration;
import scheduler.configuration.StarvationBoost;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#getPriorityConfiguration <em>Priority Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#getPreemptionConfiguration <em>Preemption Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#getQueueingConfiguration <em>Queueing Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#isInFrontAfterWaiting <em>In Front After Waiting</em>}</li>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#isWindows <em>Windows</em>}</li>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link scheduler.configuration.impl.SchedulerConfigurationImpl#getStarvationBoost <em>Starvation Boost</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulerConfigurationImpl extends IdentifierImpl implements SchedulerConfiguration {
	/**
	 * The cached value of the '{@link #getPriorityConfiguration() <em>Priority Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityConfiguration()
	 * @generated
	 * @ordered
	 */
	protected PriorityConfiguration priorityConfiguration;

	/**
	 * The cached value of the '{@link #getPreemptionConfiguration() <em>Preemption Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreemptionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected PreemptionConfiguration preemptionConfiguration;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQueueingConfiguration() <em>Queueing Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueingConfiguration()
	 * @generated
	 * @ordered
	 */
	protected QueueingConfiguration queueingConfiguration;

	/**
	 * The default value of the '{@link #isInFrontAfterWaiting() <em>In Front After Waiting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInFrontAfterWaiting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_FRONT_AFTER_WAITING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInFrontAfterWaiting() <em>In Front After Waiting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInFrontAfterWaiting()
	 * @generated
	 * @ordered
	 */
	protected boolean inFrontAfterWaiting = IN_FRONT_AFTER_WAITING_EDEFAULT;

	/**
	 * The default value of the '{@link #isWindows() <em>Windows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWindows()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WINDOWS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isWindows() <em>Windows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWindows()
	 * @generated
	 * @ordered
	 */
	protected boolean windows = WINDOWS_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected static final double INTERVAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterval() <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterval()
	 * @generated
	 * @ordered
	 */
	protected double interval = INTERVAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStarvationBoost() <em>Starvation Boost</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarvationBoost()
	 * @generated
	 * @ordered
	 */
	protected StarvationBoost starvationBoost;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.SCHEDULER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityConfiguration getPriorityConfiguration() {
		return priorityConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPriorityConfiguration(PriorityConfiguration newPriorityConfiguration, NotificationChain msgs) {
		PriorityConfiguration oldPriorityConfiguration = priorityConfiguration;
		priorityConfiguration = newPriorityConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION, oldPriorityConfiguration, newPriorityConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriorityConfiguration(PriorityConfiguration newPriorityConfiguration) {
		if (newPriorityConfiguration != priorityConfiguration) {
			NotificationChain msgs = null;
			if (priorityConfiguration != null)
				msgs = ((InternalEObject)priorityConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION, null, msgs);
			if (newPriorityConfiguration != null)
				msgs = ((InternalEObject)newPriorityConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION, null, msgs);
			msgs = basicSetPriorityConfiguration(newPriorityConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION, newPriorityConfiguration, newPriorityConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreemptionConfiguration getPreemptionConfiguration() {
		return preemptionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreemptionConfiguration(PreemptionConfiguration newPreemptionConfiguration, NotificationChain msgs) {
		PreemptionConfiguration oldPreemptionConfiguration = preemptionConfiguration;
		preemptionConfiguration = newPreemptionConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION, oldPreemptionConfiguration, newPreemptionConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreemptionConfiguration(PreemptionConfiguration newPreemptionConfiguration) {
		if (newPreemptionConfiguration != preemptionConfiguration) {
			NotificationChain msgs = null;
			if (preemptionConfiguration != null)
				msgs = ((InternalEObject)preemptionConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION, null, msgs);
			if (newPreemptionConfiguration != null)
				msgs = ((InternalEObject)newPreemptionConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION, null, msgs);
			msgs = basicSetPreemptionConfiguration(newPreemptionConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION, newPreemptionConfiguration, newPreemptionConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueueingConfiguration getQueueingConfiguration() {
		return queueingConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQueueingConfiguration(QueueingConfiguration newQueueingConfiguration, NotificationChain msgs) {
		QueueingConfiguration oldQueueingConfiguration = queueingConfiguration;
		queueingConfiguration = newQueueingConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION, oldQueueingConfiguration, newQueueingConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueingConfiguration(QueueingConfiguration newQueueingConfiguration) {
		if (newQueueingConfiguration != queueingConfiguration) {
			NotificationChain msgs = null;
			if (queueingConfiguration != null)
				msgs = ((InternalEObject)queueingConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION, null, msgs);
			if (newQueueingConfiguration != null)
				msgs = ((InternalEObject)newQueueingConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION, null, msgs);
			msgs = basicSetQueueingConfiguration(newQueueingConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION, newQueueingConfiguration, newQueueingConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInFrontAfterWaiting() {
		return inFrontAfterWaiting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInFrontAfterWaiting(boolean newInFrontAfterWaiting) {
		boolean oldInFrontAfterWaiting = inFrontAfterWaiting;
		inFrontAfterWaiting = newInFrontAfterWaiting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING, oldInFrontAfterWaiting, inFrontAfterWaiting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWindows() {
		return windows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWindows(boolean newWindows) {
		boolean oldWindows = windows;
		windows = newWindows;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__WINDOWS, oldWindows, windows));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInterval() {
		return interval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterval(double newInterval) {
		double oldInterval = interval;
		interval = newInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__INTERVAL, oldInterval, interval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StarvationBoost getStarvationBoost() {
		return starvationBoost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStarvationBoost(StarvationBoost newStarvationBoost, NotificationChain msgs) {
		StarvationBoost oldStarvationBoost = starvationBoost;
		starvationBoost = newStarvationBoost;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST, oldStarvationBoost, newStarvationBoost);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarvationBoost(StarvationBoost newStarvationBoost) {
		if (newStarvationBoost != starvationBoost) {
			NotificationChain msgs = null;
			if (starvationBoost != null)
				msgs = ((InternalEObject)starvationBoost).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST, null, msgs);
			if (newStarvationBoost != null)
				msgs = ((InternalEObject)newStarvationBoost).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST, null, msgs);
			msgs = basicSetStarvationBoost(newStarvationBoost, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST, newStarvationBoost, newStarvationBoost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION:
				return basicSetPriorityConfiguration(null, msgs);
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION:
				return basicSetPreemptionConfiguration(null, msgs);
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION:
				return basicSetQueueingConfiguration(null, msgs);
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST:
				return basicSetStarvationBoost(null, msgs);
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
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION:
				return getPriorityConfiguration();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION:
				return getPreemptionConfiguration();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__NAME:
				return getName();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION:
				return getQueueingConfiguration();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING:
				return isInFrontAfterWaiting();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__WINDOWS:
				return isWindows();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__INTERVAL:
				return getInterval();
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST:
				return getStarvationBoost();
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
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION:
				setPriorityConfiguration((PriorityConfiguration)newValue);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION:
				setPreemptionConfiguration((PreemptionConfiguration)newValue);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION:
				setQueueingConfiguration((QueueingConfiguration)newValue);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING:
				setInFrontAfterWaiting((Boolean)newValue);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__WINDOWS:
				setWindows((Boolean)newValue);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__INTERVAL:
				setInterval((Double)newValue);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST:
				setStarvationBoost((StarvationBoost)newValue);
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
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION:
				setPriorityConfiguration((PriorityConfiguration)null);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION:
				setPreemptionConfiguration((PreemptionConfiguration)null);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION:
				setQueueingConfiguration((QueueingConfiguration)null);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING:
				setInFrontAfterWaiting(IN_FRONT_AFTER_WAITING_EDEFAULT);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__WINDOWS:
				setWindows(WINDOWS_EDEFAULT);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__INTERVAL:
				setInterval(INTERVAL_EDEFAULT);
				return;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST:
				setStarvationBoost((StarvationBoost)null);
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
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PRIORITY_CONFIGURATION:
				return priorityConfiguration != null;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__PREEMPTION_CONFIGURATION:
				return preemptionConfiguration != null;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__QUEUEING_CONFIGURATION:
				return queueingConfiguration != null;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__IN_FRONT_AFTER_WAITING:
				return inFrontAfterWaiting != IN_FRONT_AFTER_WAITING_EDEFAULT;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__WINDOWS:
				return windows != WINDOWS_EDEFAULT;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__INTERVAL:
				return interval != INTERVAL_EDEFAULT;
			case ConfigurationPackage.SCHEDULER_CONFIGURATION__STARVATION_BOOST:
				return starvationBoost != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", inFrontAfterWaiting: ");
		result.append(inFrontAfterWaiting);
		result.append(", Windows: ");
		result.append(windows);
		result.append(", interval: ");
		result.append(interval);
		result.append(')');
		return result.toString();
	}

} //SchedulerConfigurationImpl
