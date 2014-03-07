/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Intervals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.FixedIntervalsImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.FixedIntervalsImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.FixedIntervalsImpl#getNumberOfIntervals <em>Number Of Intervals</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.FixedIntervalsImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedIntervalsImpl extends IdentifiableImpl implements FixedIntervals {
	/**
     * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
	protected Measure lowerBound;

	/**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
	protected Measure width;

	/**
     * The default value of the '{@link #getNumberOfIntervals() <em>Number Of Intervals</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumberOfIntervals()
     * @generated
     * @ordered
     */
	protected static final long NUMBER_OF_INTERVALS_EDEFAULT = 0L;

	/**
     * The cached value of the '{@link #getNumberOfIntervals() <em>Number Of Intervals</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumberOfIntervals()
     * @generated
     * @ordered
     */
	protected long numberOfIntervals = NUMBER_OF_INTERVALS_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FixedIntervalsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.FIXED_INTERVALS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getLowerBound() {
        return lowerBound;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLowerBound(Measure newLowerBound) {
        Measure oldLowerBound = lowerBound;
        lowerBound = newLowerBound;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.FIXED_INTERVALS__LOWER_BOUND, oldLowerBound, lowerBound));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getWidth() {
        return width;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setWidth(Measure newWidth) {
        Measure oldWidth = width;
        width = newWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.FIXED_INTERVALS__WIDTH, oldWidth, width));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getNumberOfIntervals() {
        return numberOfIntervals;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNumberOfIntervals(long newNumberOfIntervals) {
        long oldNumberOfIntervals = numberOfIntervals;
        numberOfIntervals = newNumberOfIntervals;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.FIXED_INTERVALS__NUMBER_OF_INTERVALS, oldNumberOfIntervals, numberOfIntervals));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FixedWidthAggregatedMeasurements getAggregatedMeasurements() {
        if (eContainerFeatureID() != ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS) return null;
        return (FixedWidthAggregatedMeasurements)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAggregatedMeasurements(FixedWidthAggregatedMeasurements newAggregatedMeasurements, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAggregatedMeasurements, ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAggregatedMeasurements(FixedWidthAggregatedMeasurements newAggregatedMeasurements) {
        if (newAggregatedMeasurements != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS && newAggregatedMeasurements != null)) {
            if (EcoreUtil.isAncestor(this, newAggregatedMeasurements))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAggregatedMeasurements != null)
                msgs = ((InternalEObject)newAggregatedMeasurements).eInverseAdd(this, ExperimentDataPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS, FixedWidthAggregatedMeasurements.class, msgs);
            msgs = basicSetAggregatedMeasurements(newAggregatedMeasurements, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS, newAggregatedMeasurements, newAggregatedMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAggregatedMeasurements((FixedWidthAggregatedMeasurements)otherEnd, msgs);
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
            case ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS:
                return basicSetAggregatedMeasurements(null, msgs);
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
            case ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__INTERVALS, FixedWidthAggregatedMeasurements.class, msgs);
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
            case ExperimentDataPackage.FIXED_INTERVALS__LOWER_BOUND:
                return getLowerBound();
            case ExperimentDataPackage.FIXED_INTERVALS__WIDTH:
                return getWidth();
            case ExperimentDataPackage.FIXED_INTERVALS__NUMBER_OF_INTERVALS:
                return getNumberOfIntervals();
            case ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS:
                return getAggregatedMeasurements();
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
            case ExperimentDataPackage.FIXED_INTERVALS__LOWER_BOUND:
                setLowerBound((Measure)newValue);
                return;
            case ExperimentDataPackage.FIXED_INTERVALS__WIDTH:
                setWidth((Measure)newValue);
                return;
            case ExperimentDataPackage.FIXED_INTERVALS__NUMBER_OF_INTERVALS:
                setNumberOfIntervals((Long)newValue);
                return;
            case ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS:
                setAggregatedMeasurements((FixedWidthAggregatedMeasurements)newValue);
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
            case ExperimentDataPackage.FIXED_INTERVALS__LOWER_BOUND:
                setLowerBound((Measure)null);
                return;
            case ExperimentDataPackage.FIXED_INTERVALS__WIDTH:
                setWidth((Measure)null);
                return;
            case ExperimentDataPackage.FIXED_INTERVALS__NUMBER_OF_INTERVALS:
                setNumberOfIntervals(NUMBER_OF_INTERVALS_EDEFAULT);
                return;
            case ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS:
                setAggregatedMeasurements((FixedWidthAggregatedMeasurements)null);
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
            case ExperimentDataPackage.FIXED_INTERVALS__LOWER_BOUND:
                return lowerBound != null;
            case ExperimentDataPackage.FIXED_INTERVALS__WIDTH:
                return width != null;
            case ExperimentDataPackage.FIXED_INTERVALS__NUMBER_OF_INTERVALS:
                return numberOfIntervals != NUMBER_OF_INTERVALS_EDEFAULT;
            case ExperimentDataPackage.FIXED_INTERVALS__AGGREGATED_MEASUREMENTS:
                return getAggregatedMeasurements() != null;
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
        result.append(" (lowerBound: ");
        result.append(lowerBound);
        result.append(", width: ");
        result.append(width);
        result.append(", numberOfIntervals: ");
        result.append(numberOfIntervals);
        result.append(')');
        return result.toString();
    }

} //FixedIntervalsImpl
