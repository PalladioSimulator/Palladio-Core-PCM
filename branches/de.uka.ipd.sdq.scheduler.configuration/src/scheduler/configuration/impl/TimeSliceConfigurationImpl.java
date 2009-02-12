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
import scheduler.configuration.TimeSliceConfiguration;
import scheduler.configuration.TimeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.TimeSliceConfigurationImpl#getGranularity <em>Granularity</em>}</li>
 *   <li>{@link scheduler.configuration.impl.TimeSliceConfigurationImpl#getTimeslice <em>Timeslice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TimeSliceConfigurationImpl extends EObjectImpl implements TimeSliceConfiguration {
	/**
	 * The default value of the '{@link #getGranularity() <em>Granularity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGranularity()
	 * @generated
	 * @ordered
	 */
	protected static final int GRANULARITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getGranularity() <em>Granularity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGranularity()
	 * @generated
	 * @ordered
	 */
	protected int granularity = GRANULARITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimeslice() <em>Timeslice</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeslice()
	 * @generated
	 * @ordered
	 */
	protected TimeValue timeslice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeSliceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.TIME_SLICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGranularity() {
		return granularity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGranularity(int newGranularity) {
		int oldGranularity = granularity;
		granularity = newGranularity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TIME_SLICE_CONFIGURATION__GRANULARITY, oldGranularity, granularity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeValue getTimeslice() {
		return timeslice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeslice(TimeValue newTimeslice, NotificationChain msgs) {
		TimeValue oldTimeslice = timeslice;
		timeslice = newTimeslice;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE, oldTimeslice, newTimeslice);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeslice(TimeValue newTimeslice) {
		if (newTimeslice != timeslice) {
			NotificationChain msgs = null;
			if (timeslice != null)
				msgs = ((InternalEObject)timeslice).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE, null, msgs);
			if (newTimeslice != null)
				msgs = ((InternalEObject)newTimeslice).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE, null, msgs);
			msgs = basicSetTimeslice(newTimeslice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE, newTimeslice, newTimeslice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				return basicSetTimeslice(null, msgs);
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
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__GRANULARITY:
				return new Integer(getGranularity());
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				return getTimeslice();
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
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__GRANULARITY:
				setGranularity(((Integer)newValue).intValue());
				return;
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				setTimeslice((TimeValue)newValue);
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
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__GRANULARITY:
				setGranularity(GRANULARITY_EDEFAULT);
				return;
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				setTimeslice((TimeValue)null);
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
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__GRANULARITY:
				return granularity != GRANULARITY_EDEFAULT;
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION__TIMESLICE:
				return timeslice != null;
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
		result.append(" (granularity: ");
		result.append(granularity);
		result.append(')');
		return result.toString();
	}

} //TimeSliceConfigurationImpl
