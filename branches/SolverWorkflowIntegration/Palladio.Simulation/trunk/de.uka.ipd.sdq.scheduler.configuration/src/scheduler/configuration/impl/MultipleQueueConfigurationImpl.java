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
import scheduler.configuration.LoadBalancing;
import scheduler.configuration.MultipleQueueConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Queue Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.MultipleQueueConfigurationImpl#getLoadBalancing <em>Load Balancing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultipleQueueConfigurationImpl extends QueueingConfigurationImpl implements MultipleQueueConfiguration {
	/**
	 * The cached value of the '{@link #getLoadBalancing() <em>Load Balancing</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadBalancing()
	 * @generated
	 * @ordered
	 */
	protected LoadBalancing loadBalancing;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultipleQueueConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.MULTIPLE_QUEUE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalancing getLoadBalancing() {
		return loadBalancing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoadBalancing(LoadBalancing newLoadBalancing, NotificationChain msgs) {
		LoadBalancing oldLoadBalancing = loadBalancing;
		loadBalancing = newLoadBalancing;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING, oldLoadBalancing, newLoadBalancing);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadBalancing(LoadBalancing newLoadBalancing) {
		if (newLoadBalancing != loadBalancing) {
			NotificationChain msgs = null;
			if (loadBalancing != null)
				msgs = ((InternalEObject)loadBalancing).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING, null, msgs);
			if (newLoadBalancing != null)
				msgs = ((InternalEObject)newLoadBalancing).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING, null, msgs);
			msgs = basicSetLoadBalancing(newLoadBalancing, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING, newLoadBalancing, newLoadBalancing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING:
				return basicSetLoadBalancing(null, msgs);
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING:
				return getLoadBalancing();
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING:
				setLoadBalancing((LoadBalancing)newValue);
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING:
				setLoadBalancing((LoadBalancing)null);
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__LOAD_BALANCING:
				return loadBalancing != null;
		}
		return super.eIsSet(featureID);
	}

} //MultipleQueueConfigurationImpl
