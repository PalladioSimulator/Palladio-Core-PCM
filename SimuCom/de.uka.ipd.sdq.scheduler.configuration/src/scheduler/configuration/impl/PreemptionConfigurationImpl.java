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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.PreemptionConfiguration;
import scheduler.configuration.TimeSliceConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preemption Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.PreemptionConfigurationImpl#getTimesliceConfiguration <em>Timeslice Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreemptionConfigurationImpl extends EObjectImpl implements PreemptionConfiguration {
	/**
	 * The cached value of the '{@link #getTimesliceConfiguration() <em>Timeslice Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimesliceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TimeSliceConfiguration timesliceConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreemptionConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PREEMPTION_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSliceConfiguration getTimesliceConfiguration() {
		return timesliceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimesliceConfiguration(TimeSliceConfiguration newTimesliceConfiguration, NotificationChain msgs) {
		TimeSliceConfiguration oldTimesliceConfiguration = timesliceConfiguration;
		timesliceConfiguration = newTimesliceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION, oldTimesliceConfiguration, newTimesliceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimesliceConfiguration(TimeSliceConfiguration newTimesliceConfiguration) {
		if (newTimesliceConfiguration != timesliceConfiguration) {
			NotificationChain msgs = null;
			if (timesliceConfiguration != null)
				msgs = ((InternalEObject)timesliceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION, null, msgs);
			if (newTimesliceConfiguration != null)
				msgs = ((InternalEObject)newTimesliceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION, null, msgs);
			msgs = basicSetTimesliceConfiguration(newTimesliceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION, newTimesliceConfiguration, newTimesliceConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION:
				return basicSetTimesliceConfiguration(null, msgs);
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
			case ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION:
				return getTimesliceConfiguration();
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
			case ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION:
				setTimesliceConfiguration((TimeSliceConfiguration)newValue);
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
			case ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION:
				setTimesliceConfiguration((TimeSliceConfiguration)null);
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
			case ConfigurationPackage.PREEMPTION_CONFIGURATION__TIMESLICE_CONFIGURATION:
				return timesliceConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //PreemptionConfigurationImpl
