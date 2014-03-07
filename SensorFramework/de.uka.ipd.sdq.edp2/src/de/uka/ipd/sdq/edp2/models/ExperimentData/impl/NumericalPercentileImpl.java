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
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Percentile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalPercentileImpl#getPercentile <em>Percentile</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalPercentileImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalPercentileImpl#getOrdinalStatistics <em>Ordinal Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalPercentileImpl extends IdentifiableImpl implements NumericalPercentile {
	/**
     * The default value of the '{@link #getPercentile() <em>Percentile</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPercentile()
     * @generated
     * @ordered
     */
	protected static final double PERCENTILE_EDEFAULT = 0.0;

	/**
     * The cached value of the '{@link #getPercentile() <em>Percentile</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPercentile()
     * @generated
     * @ordered
     */
	protected double percentile = PERCENTILE_EDEFAULT;

	/**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected Measure value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NumericalPercentileImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.NUMERICAL_PERCENTILE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public double getPercentile() {
        return percentile;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPercentile(double newPercentile) {
        double oldPercentile = percentile;
        percentile = newPercentile;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_PERCENTILE__PERCENTILE, oldPercentile, percentile));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getValue() {
        return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValue(Measure newValue) {
        Measure oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_PERCENTILE__VALUE, oldValue, value));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalOrdinalStatistics getOrdinalStatistics() {
        if (eContainerFeatureID() != ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS) return null;
        return (NumericalOrdinalStatistics)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOrdinalStatistics(NumericalOrdinalStatistics newOrdinalStatistics, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOrdinalStatistics, ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOrdinalStatistics(NumericalOrdinalStatistics newOrdinalStatistics) {
        if (newOrdinalStatistics != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS && newOrdinalStatistics != null)) {
            if (EcoreUtil.isAncestor(this, newOrdinalStatistics))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOrdinalStatistics != null)
                msgs = ((InternalEObject)newOrdinalStatistics).eInverseAdd(this, ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES, NumericalOrdinalStatistics.class, msgs);
            msgs = basicSetOrdinalStatistics(newOrdinalStatistics, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS, newOrdinalStatistics, newOrdinalStatistics));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOrdinalStatistics((NumericalOrdinalStatistics)otherEnd, msgs);
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
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS:
                return basicSetOrdinalStatistics(null, msgs);
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
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.NUMERICAL_ORDINAL_STATISTICS__PERCENTILES, NumericalOrdinalStatistics.class, msgs);
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
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__PERCENTILE:
                return getPercentile();
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__VALUE:
                return getValue();
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS:
                return getOrdinalStatistics();
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
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__PERCENTILE:
                setPercentile((Double)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__VALUE:
                setValue((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS:
                setOrdinalStatistics((NumericalOrdinalStatistics)newValue);
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
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__PERCENTILE:
                setPercentile(PERCENTILE_EDEFAULT);
                return;
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__VALUE:
                setValue((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS:
                setOrdinalStatistics((NumericalOrdinalStatistics)null);
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
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__PERCENTILE:
                return percentile != PERCENTILE_EDEFAULT;
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__VALUE:
                return value != null;
            case ExperimentDataPackage.NUMERICAL_PERCENTILE__ORDINAL_STATISTICS:
                return getOrdinalStatistics() != null;
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
        result.append(" (percentile: ");
        result.append(percentile);
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //NumericalPercentileImpl
