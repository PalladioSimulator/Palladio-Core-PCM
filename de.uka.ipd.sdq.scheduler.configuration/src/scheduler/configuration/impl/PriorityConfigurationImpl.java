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
import scheduler.configuration.PriorityBoostConfiguration;
import scheduler.configuration.PriorityConfiguration;
import scheduler.configuration.PriorityRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.PriorityConfigurationImpl#getRange <em>Range</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PriorityConfigurationImpl#getBoostConfiguration <em>Boost Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriorityConfigurationImpl extends EObjectImpl implements PriorityConfiguration {
	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected PriorityRange range;

	/**
	 * The cached value of the '{@link #getBoostConfiguration() <em>Boost Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoostConfiguration()
	 * @generated
	 * @ordered
	 */
	protected PriorityBoostConfiguration boostConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PriorityConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PRIORITY_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityRange getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRange(PriorityRange newRange, NotificationChain msgs) {
		PriorityRange oldRange = range;
		range = newRange;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE, oldRange, newRange);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(PriorityRange newRange) {
		if (newRange != range) {
			NotificationChain msgs = null;
			if (range != null)
				msgs = ((InternalEObject)range).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE, null, msgs);
			if (newRange != null)
				msgs = ((InternalEObject)newRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE, null, msgs);
			msgs = basicSetRange(newRange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE, newRange, newRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityBoostConfiguration getBoostConfiguration() {
		return boostConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBoostConfiguration(PriorityBoostConfiguration newBoostConfiguration, NotificationChain msgs) {
		PriorityBoostConfiguration oldBoostConfiguration = boostConfiguration;
		boostConfiguration = newBoostConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION, oldBoostConfiguration, newBoostConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoostConfiguration(PriorityBoostConfiguration newBoostConfiguration) {
		if (newBoostConfiguration != boostConfiguration) {
			NotificationChain msgs = null;
			if (boostConfiguration != null)
				msgs = ((InternalEObject)boostConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION, null, msgs);
			if (newBoostConfiguration != null)
				msgs = ((InternalEObject)newBoostConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION, null, msgs);
			msgs = basicSetBoostConfiguration(newBoostConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION, newBoostConfiguration, newBoostConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE:
				return basicSetRange(null, msgs);
			case ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION:
				return basicSetBoostConfiguration(null, msgs);
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
			case ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE:
				return getRange();
			case ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION:
				return getBoostConfiguration();
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
			case ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE:
				setRange((PriorityRange)newValue);
				return;
			case ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION:
				setBoostConfiguration((PriorityBoostConfiguration)newValue);
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
			case ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE:
				setRange((PriorityRange)null);
				return;
			case ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION:
				setBoostConfiguration((PriorityBoostConfiguration)null);
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
			case ConfigurationPackage.PRIORITY_CONFIGURATION__RANGE:
				return range != null;
			case ConfigurationPackage.PRIORITY_CONFIGURATION__BOOST_CONFIGURATION:
				return boostConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //PriorityConfigurationImpl
