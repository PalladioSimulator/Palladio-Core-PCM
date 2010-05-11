/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.SchedulerConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Resource Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.ActiveResourceConfigurationImpl#getSchedulerConfiguration <em>Scheduler Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.impl.ActiveResourceConfigurationImpl#getReplicas <em>Replicas</em>}</li>
 *   <li>{@link scheduler.configuration.impl.ActiveResourceConfigurationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActiveResourceConfigurationImpl extends IdentifierImpl implements ActiveResourceConfiguration {
	/**
	 * The cached value of the '{@link #getSchedulerConfiguration() <em>Scheduler Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerConfiguration()
	 * @generated
	 * @ordered
	 */
	protected SchedulerConfiguration schedulerConfiguration;

	/**
	 * The default value of the '{@link #getReplicas() <em>Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplicas()
	 * @generated
	 * @ordered
	 */
	protected static final int REPLICAS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getReplicas() <em>Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplicas()
	 * @generated
	 * @ordered
	 */
	protected int replicas = REPLICAS_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActiveResourceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.ACTIVE_RESOURCE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerConfiguration getSchedulerConfiguration() {
		if (schedulerConfiguration != null && schedulerConfiguration.eIsProxy()) {
			InternalEObject oldSchedulerConfiguration = (InternalEObject)schedulerConfiguration;
			schedulerConfiguration = (SchedulerConfiguration)eResolveProxy(oldSchedulerConfiguration);
			if (schedulerConfiguration != oldSchedulerConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION, oldSchedulerConfiguration, schedulerConfiguration));
			}
		}
		return schedulerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerConfiguration basicGetSchedulerConfiguration() {
		return schedulerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulerConfiguration(SchedulerConfiguration newSchedulerConfiguration) {
		SchedulerConfiguration oldSchedulerConfiguration = schedulerConfiguration;
		schedulerConfiguration = newSchedulerConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION, oldSchedulerConfiguration, schedulerConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getReplicas() {
		return replicas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplicas(int newReplicas) {
		int oldReplicas = replicas;
		replicas = newReplicas;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__REPLICAS, oldReplicas, replicas));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION:
				if (resolve) return getSchedulerConfiguration();
				return basicGetSchedulerConfiguration();
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__REPLICAS:
				return getReplicas();
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__NAME:
				return getName();
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
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION:
				setSchedulerConfiguration((SchedulerConfiguration)newValue);
				return;
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__REPLICAS:
				setReplicas((Integer)newValue);
				return;
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__NAME:
				setName((String)newValue);
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
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION:
				setSchedulerConfiguration((SchedulerConfiguration)null);
				return;
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__REPLICAS:
				setReplicas(REPLICAS_EDEFAULT);
				return;
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
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
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__SCHEDULER_CONFIGURATION:
				return schedulerConfiguration != null;
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__REPLICAS:
				return replicas != REPLICAS_EDEFAULT;
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (replicas: ");
		result.append(replicas);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ActiveResourceConfigurationImpl
