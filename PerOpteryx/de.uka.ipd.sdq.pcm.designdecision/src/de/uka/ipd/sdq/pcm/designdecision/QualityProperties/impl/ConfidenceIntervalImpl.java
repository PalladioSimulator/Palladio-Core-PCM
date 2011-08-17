/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl;

import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.ConfidenceInterval;
import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Confidence Interval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.ConfidenceIntervalImpl#getConfidenceLevel <em>Confidence Level</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.ConfidenceIntervalImpl#getMean <em>Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.ConfidenceIntervalImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.ConfidenceIntervalImpl#getLowerBound <em>Lower Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfidenceIntervalImpl extends EObjectImpl implements ConfidenceInterval {
	/**
	 * The default value of the '{@link #getConfidenceLevel() <em>Confidence Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidenceLevel()
	 * @generated
	 * @ordered
	 */
	protected static final double CONFIDENCE_LEVEL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getConfidenceLevel() <em>Confidence Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidenceLevel()
	 * @generated
	 * @ordered
	 */
	protected double confidenceLevel = CONFIDENCE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getMean() <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMean()
	 * @generated
	 * @ordered
	 */
	protected static final double MEAN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMean() <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMean()
	 * @generated
	 * @ordered
	 */
	protected double mean = MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final double UPPER_BOUND_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected double upperBound = UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final double LOWER_BOUND_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected double lowerBound = LOWER_BOUND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfidenceIntervalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityPropertiesPackage.Literals.CONFIDENCE_INTERVAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConfidenceLevel() {
		return confidenceLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidenceLevel(double newConfidenceLevel) {
		double oldConfidenceLevel = confidenceLevel;
		confidenceLevel = newConfidenceLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityPropertiesPackage.CONFIDENCE_INTERVAL__CONFIDENCE_LEVEL, oldConfidenceLevel, confidenceLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMean() {
		return mean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMean(double newMean) {
		double oldMean = mean;
		mean = newMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityPropertiesPackage.CONFIDENCE_INTERVAL__MEAN, oldMean, mean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(double newUpperBound) {
		double oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityPropertiesPackage.CONFIDENCE_INTERVAL__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(double newLowerBound) {
		double oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityPropertiesPackage.CONFIDENCE_INTERVAL__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__CONFIDENCE_LEVEL:
				return getConfidenceLevel();
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__MEAN:
				return getMean();
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__UPPER_BOUND:
				return getUpperBound();
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__LOWER_BOUND:
				return getLowerBound();
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
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__CONFIDENCE_LEVEL:
				setConfidenceLevel((Double)newValue);
				return;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__MEAN:
				setMean((Double)newValue);
				return;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__UPPER_BOUND:
				setUpperBound((Double)newValue);
				return;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__LOWER_BOUND:
				setLowerBound((Double)newValue);
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
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__CONFIDENCE_LEVEL:
				setConfidenceLevel(CONFIDENCE_LEVEL_EDEFAULT);
				return;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__MEAN:
				setMean(MEAN_EDEFAULT);
				return;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
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
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__CONFIDENCE_LEVEL:
				return confidenceLevel != CONFIDENCE_LEVEL_EDEFAULT;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__MEAN:
				return mean != MEAN_EDEFAULT;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
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
		result.append(" (confidenceLevel: ");
		result.append(confidenceLevel);
		result.append(", mean: ");
		result.append(mean);
		result.append(", upperBound: ");
		result.append(upperBound);
		result.append(", lowerBound: ");
		result.append(lowerBound);
		result.append(')');
		return result.toString();
	}

} //ConfidenceIntervalImpl
