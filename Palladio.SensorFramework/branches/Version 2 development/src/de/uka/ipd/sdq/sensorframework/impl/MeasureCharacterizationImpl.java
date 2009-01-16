/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.MeasureCharacterization;
import de.uka.ipd.sdq.sensorframework.SensorDeclaration;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measure Characterization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasureCharacterizationImpl#getMeasuredObject <em>Measured Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasureCharacterizationImpl#getMetric <em>Metric</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.MeasureCharacterizationImpl#getSensorDeclaration <em>Sensor Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasureCharacterizationImpl extends PropertyableImpl implements MeasureCharacterization {
	/**
	 * The default value of the '{@link #getMeasuredObject() <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredObject()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURED_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasuredObject() <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredObject()
	 * @generated
	 * @ordered
	 */
	protected String measuredObject = MEASURED_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetric() <em>Metric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
	protected static final String METRIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetric() <em>Metric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
	protected String metric = METRIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasureCharacterizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return sensorframeworkPackage.Literals.MEASURE_CHARACTERIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasuredObject() {
		return measuredObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasuredObject(String newMeasuredObject) {
		String oldMeasuredObject = measuredObject;
		measuredObject = newMeasuredObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.MEASURE_CHARACTERIZATION__MEASURED_OBJECT, oldMeasuredObject, measuredObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetric() {
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetric(String newMetric) {
		String oldMetric = metric;
		metric = newMetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.MEASURE_CHARACTERIZATION__METRIC, oldMetric, metric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorDeclaration getSensorDeclaration() {
		if (eContainerFeatureID != sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION) return null;
		return (SensorDeclaration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSensorDeclaration(SensorDeclaration newSensorDeclaration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSensorDeclaration, sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSensorDeclaration(SensorDeclaration newSensorDeclaration) {
		if (newSensorDeclaration != eInternalContainer() || (eContainerFeatureID != sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION && newSensorDeclaration != null)) {
			if (EcoreUtil.isAncestor(this, newSensorDeclaration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSensorDeclaration != null)
				msgs = ((InternalEObject)newSensorDeclaration).eInverseAdd(this, sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, SensorDeclaration.class, msgs);
			msgs = basicSetSensorDeclaration(newSensorDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION, newSensorDeclaration, newSensorDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSensorDeclaration((SensorDeclaration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION:
				return basicSetSensorDeclaration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION:
				return eInternalContainer().eInverseRemove(this, sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, SensorDeclaration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__MEASURED_OBJECT:
				return getMeasuredObject();
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__METRIC:
				return getMetric();
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION:
				return getSensorDeclaration();
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
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__MEASURED_OBJECT:
				setMeasuredObject((String)newValue);
				return;
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__METRIC:
				setMetric((String)newValue);
				return;
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION:
				setSensorDeclaration((SensorDeclaration)newValue);
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
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__MEASURED_OBJECT:
				setMeasuredObject(MEASURED_OBJECT_EDEFAULT);
				return;
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__METRIC:
				setMetric(METRIC_EDEFAULT);
				return;
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION:
				setSensorDeclaration((SensorDeclaration)null);
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
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__MEASURED_OBJECT:
				return MEASURED_OBJECT_EDEFAULT == null ? measuredObject != null : !MEASURED_OBJECT_EDEFAULT.equals(measuredObject);
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__METRIC:
				return METRIC_EDEFAULT == null ? metric != null : !METRIC_EDEFAULT.equals(metric);
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION:
				return getSensorDeclaration() != null;
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
		result.append(" (measuredObject: ");
		result.append(measuredObject);
		result.append(", metric: ");
		result.append(metric);
		result.append(')');
		return result.toString();
	}

} //MeasureCharacterizationImpl
