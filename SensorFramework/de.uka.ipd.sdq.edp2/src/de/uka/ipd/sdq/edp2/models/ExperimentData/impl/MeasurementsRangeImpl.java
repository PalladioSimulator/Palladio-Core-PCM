/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measurements Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsRangeImpl#getRawMeasurements <em>Raw Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsRangeImpl#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsRangeImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsRangeImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsRangeImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurementsRangeImpl extends PropertyableImpl implements MeasurementsRange {
	/**
     * The cached value of the '{@link #getRawMeasurements() <em>Raw Measurements</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRawMeasurements()
     * @generated
     * @ordered
     */
	protected RawMeasurements rawMeasurements;

	/**
     * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndTime()
     * @generated
     * @ordered
     */
	protected static final Measure END_TIME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndTime()
     * @generated
     * @ordered
     */
	protected Measure endTime = END_TIME_EDEFAULT;

	/**
     * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartTime()
     * @generated
     * @ordered
     */
	protected static final Measure START_TIME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartTime()
     * @generated
     * @ordered
     */
	protected Measure startTime = START_TIME_EDEFAULT;

	/**
     * The cached value of the '{@link #getAggregatedMeasurements() <em>Aggregated Measurements</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAggregatedMeasurements()
     * @generated
     * @ordered
     */
	protected EList<AggregatedMeasurements> aggregatedMeasurements;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MeasurementsRangeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.MEASUREMENTS_RANGE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RawMeasurements getRawMeasurements() {
        return rawMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRawMeasurements(RawMeasurements newRawMeasurements, NotificationChain msgs) {
        RawMeasurements oldRawMeasurements = rawMeasurements;
        rawMeasurements = newRawMeasurements;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS, oldRawMeasurements, newRawMeasurements);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRawMeasurements(RawMeasurements newRawMeasurements) {
        if (newRawMeasurements != rawMeasurements) {
            NotificationChain msgs = null;
            if (rawMeasurements != null)
                msgs = ((InternalEObject)rawMeasurements).eInverseRemove(this, ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE, RawMeasurements.class, msgs);
            if (newRawMeasurements != null)
                msgs = ((InternalEObject)newRawMeasurements).eInverseAdd(this, ExperimentDataPackage.RAW_MEASUREMENTS__MEASUREMENTS_RANGE, RawMeasurements.class, msgs);
            msgs = basicSetRawMeasurements(newRawMeasurements, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS, newRawMeasurements, newRawMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getEndTime() {
        return endTime;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEndTime(Measure newEndTime) {
        Measure oldEndTime = endTime;
        endTime = newEndTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.MEASUREMENTS_RANGE__END_TIME, oldEndTime, endTime));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getStartTime() {
        return startTime;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setStartTime(Measure newStartTime) {
        Measure oldStartTime = startTime;
        startTime = newStartTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.MEASUREMENTS_RANGE__START_TIME, oldStartTime, startTime));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measurements getMeasurements() {
        if (eContainerFeatureID() != ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS) return null;
        return (Measurements)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetMeasurements(Measurements newMeasurements, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMeasurements, ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMeasurements(Measurements newMeasurements) {
        if (newMeasurements != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS && newMeasurements != null)) {
            if (EcoreUtil.isAncestor(this, newMeasurements))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMeasurements != null)
                msgs = ((InternalEObject)newMeasurements).eInverseAdd(this, ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES, Measurements.class, msgs);
            msgs = basicSetMeasurements(newMeasurements, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS, newMeasurements, newMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AggregatedMeasurements> getAggregatedMeasurements() {
        if (aggregatedMeasurements == null) {
            aggregatedMeasurements = new EObjectContainmentWithInverseEList<AggregatedMeasurements>(AggregatedMeasurements.class, this, ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS, ExperimentDataPackage.AGGREGATED_MEASUREMENTS__MEASUREMENTS_RANGE);
        }
        return aggregatedMeasurements;
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS:
                if (rawMeasurements != null)
                    msgs = ((InternalEObject)rawMeasurements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS, null, msgs);
                return basicSetRawMeasurements((RawMeasurements)otherEnd, msgs);
            case ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMeasurements((Measurements)otherEnd, msgs);
            case ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAggregatedMeasurements()).basicAdd(otherEnd, msgs);
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS:
                return basicSetRawMeasurements(null, msgs);
            case ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS:
                return basicSetMeasurements(null, msgs);
            case ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS:
                return ((InternalEList<?>)getAggregatedMeasurements()).basicRemove(otherEnd, msgs);
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES, Measurements.class, msgs);
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS:
                return getRawMeasurements();
            case ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS:
                return getMeasurements();
            case ExperimentDataPackage.MEASUREMENTS_RANGE__END_TIME:
                return getEndTime();
            case ExperimentDataPackage.MEASUREMENTS_RANGE__START_TIME:
                return getStartTime();
            case ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS:
                return getAggregatedMeasurements();
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS:
                setRawMeasurements((RawMeasurements)newValue);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS:
                setMeasurements((Measurements)newValue);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__END_TIME:
                setEndTime((Measure)newValue);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__START_TIME:
                setStartTime((Measure)newValue);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS:
                getAggregatedMeasurements().clear();
                getAggregatedMeasurements().addAll((Collection<? extends AggregatedMeasurements>)newValue);
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS:
                setRawMeasurements((RawMeasurements)null);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS:
                setMeasurements((Measurements)null);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__END_TIME:
                setEndTime(END_TIME_EDEFAULT);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__START_TIME:
                setStartTime(START_TIME_EDEFAULT);
                return;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS:
                getAggregatedMeasurements().clear();
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
            case ExperimentDataPackage.MEASUREMENTS_RANGE__RAW_MEASUREMENTS:
                return rawMeasurements != null;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS:
                return getMeasurements() != null;
            case ExperimentDataPackage.MEASUREMENTS_RANGE__END_TIME:
                return END_TIME_EDEFAULT == null ? endTime != null : !END_TIME_EDEFAULT.equals(endTime);
            case ExperimentDataPackage.MEASUREMENTS_RANGE__START_TIME:
                return START_TIME_EDEFAULT == null ? startTime != null : !START_TIME_EDEFAULT.equals(startTime);
            case ExperimentDataPackage.MEASUREMENTS_RANGE__AGGREGATED_MEASUREMENTS:
                return aggregatedMeasurements != null && !aggregatedMeasurements.isEmpty();
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
        result.append(" (endTime: ");
        result.append(endTime);
        result.append(", startTime: ");
        result.append(startTime);
        result.append(')');
        return result.toString();
    }

} //MeasurementsRangeImpl
