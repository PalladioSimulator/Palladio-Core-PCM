/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.SchedulerPackage;
import scheduler.SystemConfiguration;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.PassiveResourceConfiguration;
import scheduler.configuration.ProcessConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.impl.SystemConfigurationImpl#getProcessConfiguration <em>Process Configuration</em>}</li>
 *   <li>{@link scheduler.impl.SystemConfigurationImpl#getActiveResourceConfiguration <em>Active Resource Configuration</em>}</li>
 *   <li>{@link scheduler.impl.SystemConfigurationImpl#getPassiveResourceConfiguration <em>Passive Resource Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemConfigurationImpl extends EObjectImpl implements SystemConfiguration {
	/**
	 * The cached value of the '{@link #getProcessConfiguration() <em>Process Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessConfiguration> processConfiguration;

	/**
	 * The cached value of the '{@link #getActiveResourceConfiguration() <em>Active Resource Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveResourceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<ActiveResourceConfiguration> activeResourceConfiguration;

	/**
	 * The cached value of the '{@link #getPassiveResourceConfiguration() <em>Passive Resource Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassiveResourceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<PassiveResourceConfiguration> passiveResourceConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SYSTEM_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessConfiguration> getProcessConfiguration() {
		if (processConfiguration == null) {
			processConfiguration = new EObjectContainmentEList<ProcessConfiguration>(ProcessConfiguration.class, this, SchedulerPackage.SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION);
		}
		return processConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActiveResourceConfiguration> getActiveResourceConfiguration() {
		if (activeResourceConfiguration == null) {
			activeResourceConfiguration = new EObjectContainmentEList<ActiveResourceConfiguration>(ActiveResourceConfiguration.class, this, SchedulerPackage.SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION);
		}
		return activeResourceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PassiveResourceConfiguration> getPassiveResourceConfiguration() {
		if (passiveResourceConfiguration == null) {
			passiveResourceConfiguration = new EObjectContainmentEList<PassiveResourceConfiguration>(PassiveResourceConfiguration.class, this, SchedulerPackage.SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION);
		}
		return passiveResourceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION:
				return ((InternalEList<?>)getProcessConfiguration()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION:
				return ((InternalEList<?>)getActiveResourceConfiguration()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION:
				return ((InternalEList<?>)getPassiveResourceConfiguration()).basicRemove(otherEnd, msgs);
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
			case SchedulerPackage.SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION:
				return getProcessConfiguration();
			case SchedulerPackage.SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION:
				return getActiveResourceConfiguration();
			case SchedulerPackage.SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION:
				return getPassiveResourceConfiguration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION:
				getProcessConfiguration().clear();
				getProcessConfiguration().addAll((Collection<? extends ProcessConfiguration>)newValue);
				return;
			case SchedulerPackage.SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION:
				getActiveResourceConfiguration().clear();
				getActiveResourceConfiguration().addAll((Collection<? extends ActiveResourceConfiguration>)newValue);
				return;
			case SchedulerPackage.SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION:
				getPassiveResourceConfiguration().clear();
				getPassiveResourceConfiguration().addAll((Collection<? extends PassiveResourceConfiguration>)newValue);
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
			case SchedulerPackage.SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION:
				getProcessConfiguration().clear();
				return;
			case SchedulerPackage.SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION:
				getActiveResourceConfiguration().clear();
				return;
			case SchedulerPackage.SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION:
				getPassiveResourceConfiguration().clear();
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
			case SchedulerPackage.SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION:
				return processConfiguration != null && !processConfiguration.isEmpty();
			case SchedulerPackage.SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION:
				return activeResourceConfiguration != null && !activeResourceConfiguration.isEmpty();
			case SchedulerPackage.SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION:
				return passiveResourceConfiguration != null && !passiveResourceConfiguration.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemConfigurationImpl
