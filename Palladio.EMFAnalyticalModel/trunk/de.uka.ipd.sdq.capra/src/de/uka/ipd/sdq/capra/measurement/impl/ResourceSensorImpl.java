/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.ResourceSensor;

import de.uka.ipd.sdq.capra.resources.ActiveResource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Sensor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.ResourceSensorImpl#getObservedResource <em>Observed Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceSensorImpl extends SensorImpl implements ResourceSensor {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceSensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.RESOURCE_SENSOR;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE, oldObservedResource, observedResource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE, oldObservedResource, observedResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE:
				if (resolve) return getObservedResource();
				return basicGetObservedResource();
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
			case MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE:
				setObservedResource((ActiveResource)newValue);
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
			case MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE:
				setObservedResource((ActiveResource)null);
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
			case MeasurementPackage.RESOURCE_SENSOR__OBSERVED_RESOURCE:
				return observedResource != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceSensorImpl
