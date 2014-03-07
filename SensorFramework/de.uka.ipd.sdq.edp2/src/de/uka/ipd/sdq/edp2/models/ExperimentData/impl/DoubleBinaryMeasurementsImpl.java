/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import javax.measure.quantity.Quantity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Binary Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DoubleBinaryMeasurementsImpl#getStorageUnit <em>Storage Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleBinaryMeasurementsImpl<Q extends Quantity> extends DataSeriesImpl implements DoubleBinaryMeasurements<Q> {
	/**
     * The cached value of the '{@link #getStorageUnit() <em>Storage Unit</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStorageUnit()
     * @generated
     * @ordered
     */
	protected Unit<Q> storageUnit;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DoubleBinaryMeasurementsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.DOUBLE_BINARY_MEASUREMENTS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Unit<Q> getStorageUnit() {
        return storageUnit;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStorageUnit(Unit<Q> newStorageUnit) {
        Unit<Q> oldStorageUnit = storageUnit;
        storageUnit = newStorageUnit;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT, oldStorageUnit, storageUnit));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT:
                return getStorageUnit();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
    @Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT:
                setStorageUnit((Unit<Q>)newValue);
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
            case ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT:
                setStorageUnit((Unit<Q>)null);
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
            case ExperimentDataPackage.DOUBLE_BINARY_MEASUREMENTS__STORAGE_UNIT:
                return storageUnit != null;
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

} //DoubleBinaryMeasurementsImpl
