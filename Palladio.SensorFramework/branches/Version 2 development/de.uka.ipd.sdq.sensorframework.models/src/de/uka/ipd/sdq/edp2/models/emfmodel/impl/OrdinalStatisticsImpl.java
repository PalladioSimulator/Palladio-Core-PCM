/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalStatistics;
import de.uka.ipd.sdq.edp2.models.emfmodel.Percentile;

import java.util.Collection;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordinal Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl#getMedian <em>Median</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.OrdinalStatisticsImpl#getPercentiles <em>Percentiles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrdinalStatisticsImpl extends NominalStatisticsImpl implements OrdinalStatistics {
	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final Measure MINIMUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected Measure minimum = MINIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final Measure MAXIMUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected Measure maximum = MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMedian() <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedian()
	 * @generated
	 * @ordered
	 */
	protected static final Measure MEDIAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMedian() <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedian()
	 * @generated
	 * @ordered
	 */
	protected Measure median = MEDIAN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPercentiles() <em>Percentiles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentiles()
	 * @generated
	 * @ordered
	 */
	protected EList<Percentile> percentiles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrdinalStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.ORDINAL_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(Measure newMinimum) {
		Measure oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.ORDINAL_STATISTICS__MINIMUM, oldMinimum, minimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(Measure newMaximum) {
		Measure oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.ORDINAL_STATISTICS__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMedian() {
		return median;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMedian(Measure newMedian) {
		Measure oldMedian = median;
		median = newMedian;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.ORDINAL_STATISTICS__MEDIAN, oldMedian, median));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Percentile> getPercentiles() {
		if (percentiles == null) {
			percentiles = new EObjectContainmentEList<Percentile>(Percentile.class, this, EmfmodelPackage.ORDINAL_STATISTICS__PERCENTILES);
		}
		return percentiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.ORDINAL_STATISTICS__PERCENTILES:
				return ((InternalEList<?>)getPercentiles()).basicRemove(otherEnd, msgs);
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
			case EmfmodelPackage.ORDINAL_STATISTICS__MINIMUM:
				return getMinimum();
			case EmfmodelPackage.ORDINAL_STATISTICS__MAXIMUM:
				return getMaximum();
			case EmfmodelPackage.ORDINAL_STATISTICS__MEDIAN:
				return getMedian();
			case EmfmodelPackage.ORDINAL_STATISTICS__PERCENTILES:
				return getPercentiles();
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
			case EmfmodelPackage.ORDINAL_STATISTICS__MINIMUM:
				setMinimum((Measure)newValue);
				return;
			case EmfmodelPackage.ORDINAL_STATISTICS__MAXIMUM:
				setMaximum((Measure)newValue);
				return;
			case EmfmodelPackage.ORDINAL_STATISTICS__MEDIAN:
				setMedian((Measure)newValue);
				return;
			case EmfmodelPackage.ORDINAL_STATISTICS__PERCENTILES:
				getPercentiles().clear();
				getPercentiles().addAll((Collection<? extends Percentile>)newValue);
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
			case EmfmodelPackage.ORDINAL_STATISTICS__MINIMUM:
				setMinimum(MINIMUM_EDEFAULT);
				return;
			case EmfmodelPackage.ORDINAL_STATISTICS__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case EmfmodelPackage.ORDINAL_STATISTICS__MEDIAN:
				setMedian(MEDIAN_EDEFAULT);
				return;
			case EmfmodelPackage.ORDINAL_STATISTICS__PERCENTILES:
				getPercentiles().clear();
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
			case EmfmodelPackage.ORDINAL_STATISTICS__MINIMUM:
				return MINIMUM_EDEFAULT == null ? minimum != null : !MINIMUM_EDEFAULT.equals(minimum);
			case EmfmodelPackage.ORDINAL_STATISTICS__MAXIMUM:
				return MAXIMUM_EDEFAULT == null ? maximum != null : !MAXIMUM_EDEFAULT.equals(maximum);
			case EmfmodelPackage.ORDINAL_STATISTICS__MEDIAN:
				return MEDIAN_EDEFAULT == null ? median != null : !MEDIAN_EDEFAULT.equals(median);
			case EmfmodelPackage.ORDINAL_STATISTICS__PERCENTILES:
				return percentiles != null && !percentiles.isEmpty();
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
		result.append(" (minimum: ");
		result.append(minimum);
		result.append(", maximum: ");
		result.append(maximum);
		result.append(", median: ");
		result.append(median);
		result.append(')');
		return result.toString();
	}

} //OrdinalStatisticsImpl
