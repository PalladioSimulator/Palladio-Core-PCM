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
import scheduler.configuration.StaticPriorityBoost;
import scheduler.configuration.StaticPriorityBoostConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Priority Boost Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.StaticPriorityBoostConfigurationImpl#getStarvationBoost <em>Starvation Boost</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StaticPriorityBoostConfigurationImpl extends PriorityBoostConfigurationImpl implements StaticPriorityBoostConfiguration {
	/**
	 * The cached value of the '{@link #getStarvationBoost() <em>Starvation Boost</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarvationBoost()
	 * @generated
	 * @ordered
	 */
	protected StaticPriorityBoost starvationBoost;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticPriorityBoostConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.STATIC_PRIORITY_BOOST_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticPriorityBoost getStarvationBoost() {
		return starvationBoost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStarvationBoost(StaticPriorityBoost newStarvationBoost, NotificationChain msgs) {
		StaticPriorityBoost oldStarvationBoost = starvationBoost;
		starvationBoost = newStarvationBoost;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST, oldStarvationBoost, newStarvationBoost);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarvationBoost(StaticPriorityBoost newStarvationBoost) {
		if (newStarvationBoost != starvationBoost) {
			NotificationChain msgs = null;
			if (starvationBoost != null)
				msgs = ((InternalEObject)starvationBoost).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST, null, msgs);
			if (newStarvationBoost != null)
				msgs = ((InternalEObject)newStarvationBoost).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST, null, msgs);
			msgs = basicSetStarvationBoost(newStarvationBoost, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST, newStarvationBoost, newStarvationBoost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST:
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
			case ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST:
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
			case ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST:
				setStarvationBoost((StaticPriorityBoost)newValue);
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
			case ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST:
				setStarvationBoost((StaticPriorityBoost)null);
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
			case ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION__STARVATION_BOOST:
				return starvationBoost != null;
		}
		return super.eIsSet(featureID);
	}

} //StaticPriorityBoostConfigurationImpl
