/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.RawMeasurementsImpl#getDataSeries <em>Data Series</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.RawMeasurementsImpl#getMeasurementsRange <em>Measurements Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RawMeasurementsImpl extends IdentifiableImpl implements RawMeasurements {
	/**
     * The cached value of the '{@link #getDataSeries() <em>Data Series</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDataSeries()
     * @generated
     * @ordered
     */
	protected EList<DataSeries> dataSeries;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RawMeasurementsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.RAW_MEASUREMENTS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<DataSeries> getDataSeries() {
        if (dataSeries == null) {
            dataSeries = new EObjectContainmentWithInverseEList<DataSeries>(DataSeries.class, this, ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES, ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS);
        }
        return dataSeries;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MeasurementsRange getMeasurementsRange() {
        if (eContainerFeatureID() != ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE) return null;
        return (MeasurementsRange)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetMeasurementsRange(MeasurementsRange newMeasurementsRange, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMeasurementsRange, ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMeasurementsRange(MeasurementsRange newMeasurementsRange) {
        if (newMeasurementsRange != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE && newMeasurementsRange != null)) {
            if (EcoreUtil.isAncestor(this, newMeasurementsRange))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMeasurementsRange != null)
                msgs = ((InternalEObject)newMeasurementsRange).eInverseAdd(this, ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS, MeasurementsRange.class, msgs);
            msgs = basicSetMeasurementsRange(newMeasurementsRange, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE, newMeasurementsRange, newMeasurementsRange));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataSeries()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMeasurementsRange((MeasurementsRange)otherEnd, msgs);
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
            case ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES:
                return ((InternalEList<?>)getDataSeries()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE:
                return basicSetMeasurementsRange(null, msgs);
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
        switch (eContainerFeatureID()) {
            case ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS, MeasurementsRange.class, msgs);
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
            case ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES:
                return getDataSeries();
            case ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE:
                return getMeasurementsRange();
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
            case ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES:
                getDataSeries().clear();
                getDataSeries().addAll((Collection<? extends DataSeries>)newValue);
                return;
            case ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE:
                setMeasurementsRange((MeasurementsRange)newValue);
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
            case ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES:
                getDataSeries().clear();
                return;
            case ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE:
                setMeasurementsRange((MeasurementsRange)null);
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
            case ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES:
                return dataSeries != null && !dataSeries.isEmpty();
            case ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE:
                return getMeasurementsRange() != null;
        }
        return super.eIsSet(featureID);
    }

} //RawMeasurementsImpl
