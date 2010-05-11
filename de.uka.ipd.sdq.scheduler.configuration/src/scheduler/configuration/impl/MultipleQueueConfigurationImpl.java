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
 *   <li>{@link scheduler.configuration.impl.MultipleQueueConfigurationImpl#isInFrontWhenBalancing <em>In Front When Balancing</em>}</li>
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
	 * The default value of the '{@link #isInFrontWhenBalancing() <em>In Front When Balancing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInFrontWhenBalancing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_FRONT_WHEN_BALANCING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isInFrontWhenBalancing() <em>In Front When Balancing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInFrontWhenBalancing()
	 * @generated
	 * @ordered
	 */
	protected boolean inFrontWhenBalancing = IN_FRONT_WHEN_BALANCING_EDEFAULT;

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
	public boolean isInFrontWhenBalancing() {
		return inFrontWhenBalancing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInFrontWhenBalancing(boolean newInFrontWhenBalancing) {
		boolean oldInFrontWhenBalancing = inFrontWhenBalancing;
		inFrontWhenBalancing = newInFrontWhenBalancing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING, oldInFrontWhenBalancing, inFrontWhenBalancing));
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING:
				return isInFrontWhenBalancing();
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING:
				setInFrontWhenBalancing((Boolean)newValue);
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING:
				setInFrontWhenBalancing(IN_FRONT_WHEN_BALANCING_EDEFAULT);
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
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION__IN_FRONT_WHEN_BALANCING:
				return inFrontWhenBalancing != IN_FRONT_WHEN_BALANCING_EDEFAULT;
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
		result.append(" (InFrontWhenBalancing: ");
		result.append(inFrontWhenBalancing);
		result.append(')');
		return result.toString();
	}

} //MultipleQueueConfigurationImpl
