/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Long Binary Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.LongBinaryMeasurementsImpl#getStorageUnit <em>Storage Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LongBinaryMeasurementsImpl extends DataSeriesImpl implements LongBinaryMeasurements {
	/**
	 * The default value of the '{@link #getStorageUnit() <em>Storage Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageUnit()
	 * @generated
	 * @ordered
	 */
	protected static final Unit STORAGE_UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStorageUnit() <em>Storage Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageUnit()
	 * @generated
	 * @ordered
	 */
	protected Unit storageUnit = STORAGE_UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongBinaryMeasurementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.LONG_BINARY_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getStorageUnit() {
		return storageUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageUnit(Unit newStorageUnit) {
		Unit oldStorageUnit = storageUnit;
		storageUnit = newStorageUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.LONG_BINARY_MEASUREMENTS__STORAGE_UNIT, oldStorageUnit, storageUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS__STORAGE_UNIT:
				return getStorageUnit();
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
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS__STORAGE_UNIT:
				setStorageUnit((Unit)newValue);
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
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS__STORAGE_UNIT:
				setStorageUnit(STORAGE_UNIT_EDEFAULT);
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
			case EmfmodelPackage.LONG_BINARY_MEASUREMENTS__STORAGE_UNIT:
				return STORAGE_UNIT_EDEFAULT == null ? storageUnit != null : !STORAGE_UNIT_EDEFAULT.equals(storageUnit);
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
		result.append(" (storageUnit: ");
		result.append(storageUnit);
		result.append(')');
		return result.toString();
	}

} //LongBinaryMeasurementsImpl
