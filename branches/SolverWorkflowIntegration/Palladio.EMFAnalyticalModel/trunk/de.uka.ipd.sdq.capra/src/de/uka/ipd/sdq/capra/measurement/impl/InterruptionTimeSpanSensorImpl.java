/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.ResourceSensor;

import de.uka.ipd.sdq.capra.resources.ActiveResource;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.TimeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interruption Time Span Sensor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.InterruptionTimeSpanSensorImpl#getObservedResource <em>Observed Resource</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.InterruptionTimeSpanSensorImpl#getThreshold <em>Threshold</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterruptionTimeSpanSensorImpl extends LocalTimeSpanSensorImpl implements InterruptionTimeSpanSensor {
	/**
	 * The cached value of the '{@link #getObservedResource() <em>Observed Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedResource()
	 * @generated
	 * @ordered
	 */
	protected ActiveResource observedResource;

	/**
	 * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected TimeValue threshold;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterruptionTimeSpanSensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.INTERRUPTION_TIME_SPAN_SENSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveResource getObservedResource() {
		if (observedResource != null && observedResource.eIsProxy()) {
			InternalEObject oldObservedResource = (InternalEObject)observedResource;
			observedResource = (ActiveResource)eResolveProxy(oldObservedResource);
			if (observedResource != oldObservedResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE, oldObservedResource, observedResource));
			}
		}
		return observedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveResource basicGetObservedResource() {
		return observedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObservedResource(ActiveResource newObservedResource) {
		ActiveResource oldObservedResource = observedResource;
		observedResource = newObservedResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE, oldObservedResource, observedResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeValue getThreshold() {
		return threshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThreshold(TimeValue newThreshold, NotificationChain msgs) {
		TimeValue oldThreshold = threshold;
		threshold = newThreshold;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD, oldThreshold, newThreshold);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreshold(TimeValue newThreshold) {
		if (newThreshold != threshold) {
			NotificationChain msgs = null;
			if (threshold != null)
				msgs = ((InternalEObject)threshold).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD, null, msgs);
			if (newThreshold != null)
				msgs = ((InternalEObject)newThreshold).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD, null, msgs);
			msgs = basicSetThreshold(newThreshold, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD, newThreshold, newThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD:
				return basicSetThreshold(null, msgs);
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
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE:
				if (resolve) return getObservedResource();
				return basicGetObservedResource();
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD:
				return getThreshold();
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
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE:
				setObservedResource((ActiveResource)newValue);
				return;
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD:
				setThreshold((TimeValue)newValue);
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
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE:
				setObservedResource((ActiveResource)null);
				return;
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD:
				setThreshold((TimeValue)null);
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
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE:
				return observedResource != null;
			case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__THRESHOLD:
				return threshold != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceSensor.class) {
			switch (derivedFeatureID) {
				case MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE: return MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceSensor.class) {
			switch (baseFeatureID) {
				case MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE: return MeasurementPackage.INTERRUPTION_TIME_SPAN_SENSOR__OBSERVED_RESOURCE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InterruptionTimeSpanSensorImpl
