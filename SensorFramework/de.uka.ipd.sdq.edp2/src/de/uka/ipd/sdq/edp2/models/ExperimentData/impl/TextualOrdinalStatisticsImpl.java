/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Textual Ordinal Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualOrdinalStatisticsImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualOrdinalStatisticsImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualOrdinalStatisticsImpl#getMedian <em>Median</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextualOrdinalStatisticsImpl extends TextualNominalStatisticsImpl implements TextualOrdinalStatistics {
	/**
     * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMinimum()
     * @generated
     * @ordered
     */
	protected Identifier minimum;

	/**
     * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMaximum()
     * @generated
     * @ordered
     */
	protected Identifier maximum;

	/**
     * The cached value of the '{@link #getMedian() <em>Median</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMedian()
     * @generated
     * @ordered
     */
	protected Identifier median;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TextualOrdinalStatisticsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.TEXTUAL_ORDINAL_STATISTICS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier getMinimum() {
        if (minimum != null && minimum.eIsProxy()) {
            InternalEObject oldMinimum = (InternalEObject)minimum;
            minimum = (Identifier)eResolveProxy(oldMinimum);
            if (minimum != oldMinimum) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MINIMUM, oldMinimum, minimum));
            }
        }
        return minimum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier basicGetMinimum() {
        return minimum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMinimum(Identifier newMinimum) {
        Identifier oldMinimum = minimum;
        minimum = newMinimum;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MINIMUM, oldMinimum, minimum));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier getMaximum() {
        if (maximum != null && maximum.eIsProxy()) {
            InternalEObject oldMaximum = (InternalEObject)maximum;
            maximum = (Identifier)eResolveProxy(oldMaximum);
            if (maximum != oldMaximum) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MAXIMUM, oldMaximum, maximum));
            }
        }
        return maximum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier basicGetMaximum() {
        return maximum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMaximum(Identifier newMaximum) {
        Identifier oldMaximum = maximum;
        maximum = newMaximum;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MAXIMUM, oldMaximum, maximum));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier getMedian() {
        if (median != null && median.eIsProxy()) {
            InternalEObject oldMedian = (InternalEObject)median;
            median = (Identifier)eResolveProxy(oldMedian);
            if (median != oldMedian) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MEDIAN, oldMedian, median));
            }
        }
        return median;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier basicGetMedian() {
        return median;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMedian(Identifier newMedian) {
        Identifier oldMedian = median;
        median = newMedian;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MEDIAN, oldMedian, median));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MINIMUM:
                if (resolve) return getMinimum();
                return basicGetMinimum();
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MAXIMUM:
                if (resolve) return getMaximum();
                return basicGetMaximum();
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MEDIAN:
                if (resolve) return getMedian();
                return basicGetMedian();
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
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MINIMUM:
                setMinimum((Identifier)newValue);
                return;
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MAXIMUM:
                setMaximum((Identifier)newValue);
                return;
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MEDIAN:
                setMedian((Identifier)newValue);
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
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MINIMUM:
                setMinimum((Identifier)null);
                return;
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MAXIMUM:
                setMaximum((Identifier)null);
                return;
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MEDIAN:
                setMedian((Identifier)null);
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
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MINIMUM:
                return minimum != null;
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MAXIMUM:
                return maximum != null;
            case ExperimentDataPackage.TEXTUAL_ORDINAL_STATISTICS__MEDIAN:
                return median != null;
        }
        return super.eIsSet(featureID);
    }

} //TextualOrdinalStatisticsImpl
