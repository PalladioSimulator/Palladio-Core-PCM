/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measurement Count Stop Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.MeasurementCountStopConditionImpl#getMeasurementCount <em>Measurement Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurementCountStopConditionImpl extends StopConditionImpl implements MeasurementCountStopCondition {
	/**
	 * The default value of the '{@link #getMeasurementCount() <em>Measurement Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MEASUREMENT_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMeasurementCount() <em>Measurement Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementCount()
	 * @generated
	 * @ordered
	 */
	protected int measurementCount = MEASUREMENT_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurementCountStopConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractSimulationPackage.Literals.MEASUREMENT_COUNT_STOP_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMeasurementCount() {
		return measurementCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementCount(int newMeasurementCount) {
		int oldMeasurementCount = measurementCount;
		measurementCount = newMeasurementCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT, oldMeasurementCount, measurementCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AbstractSimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT:
				return getMeasurementCount();
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
			case AbstractSimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT:
				setMeasurementCount((Integer)newValue);
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
			case AbstractSimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT:
				setMeasurementCount(MEASUREMENT_COUNT_EDEFAULT);
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
			case AbstractSimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION__MEASUREMENT_COUNT:
				return measurementCount != MEASUREMENT_COUNT_EDEFAULT;
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
		result.append(" (measurementCount: ");
		result.append(measurementCount);
		result.append(')');
		return result.toString();
	}

} //MeasurementCountStopConditionImpl
