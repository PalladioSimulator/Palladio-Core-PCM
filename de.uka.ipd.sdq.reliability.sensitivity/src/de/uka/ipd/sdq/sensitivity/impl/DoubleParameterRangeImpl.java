/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.sensitivity.DoubleParameterRange;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Parameter Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl#isConsiderStepSize <em>Consider Step Size</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl#getFirstValue <em>First Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl#getLastValue <em>Last Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterRangeImpl#getStepCount <em>Step Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleParameterRangeImpl extends DoubleParameterVariationImpl implements DoubleParameterRange {
	/**
	 * The default value of the '{@link #isConsiderStepSize() <em>Consider Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConsiderStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSIDER_STEP_SIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConsiderStepSize() <em>Consider Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConsiderStepSize()
	 * @generated
	 * @ordered
	 */
	protected boolean considerStepSize = CONSIDER_STEP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstValue() <em>First Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstValue()
	 * @generated
	 * @ordered
	 */
	protected static final double FIRST_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFirstValue() <em>First Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstValue()
	 * @generated
	 * @ordered
	 */
	protected double firstValue = FIRST_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastValue() <em>Last Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastValue()
	 * @generated
	 * @ordered
	 */
	protected static final double LAST_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLastValue() <em>Last Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastValue()
	 * @generated
	 * @ordered
	 */
	protected double lastValue = LAST_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double STEP_SIZE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected double stepSize = STEP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepCount() <em>Step Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepCount()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepCount() <em>Step Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepCount()
	 * @generated
	 * @ordered
	 */
	protected int stepCount = STEP_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleParameterRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensitivityPackage.Literals.DOUBLE_PARAMETER_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConsiderStepSize() {
		return considerStepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsiderStepSize(boolean newConsiderStepSize) {
		boolean oldConsiderStepSize = considerStepSize;
		considerStepSize = newConsiderStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE, oldConsiderStepSize, considerStepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFirstValue() {
		return firstValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstValue(double newFirstValue) {
		double oldFirstValue = firstValue;
		firstValue = newFirstValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.DOUBLE_PARAMETER_RANGE__FIRST_VALUE, oldFirstValue, firstValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLastValue() {
		return lastValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastValue(double newLastValue) {
		double oldLastValue = lastValue;
		lastValue = newLastValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.DOUBLE_PARAMETER_RANGE__LAST_VALUE, oldLastValue, lastValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStepSize() {
		return stepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepSize(double newStepSize) {
		double oldStepSize = stepSize;
		stepSize = newStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_SIZE, oldStepSize, stepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepCount() {
		return stepCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepCount(int newStepCount) {
		int oldStepCount = stepCount;
		stepCount = newStepCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_COUNT, oldStepCount, stepCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE:
				return isConsiderStepSize();
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__FIRST_VALUE:
				return getFirstValue();
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__LAST_VALUE:
				return getLastValue();
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_SIZE:
				return getStepSize();
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_COUNT:
				return getStepCount();
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
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE:
				setConsiderStepSize((Boolean)newValue);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__FIRST_VALUE:
				setFirstValue((Double)newValue);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__LAST_VALUE:
				setLastValue((Double)newValue);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_SIZE:
				setStepSize((Double)newValue);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_COUNT:
				setStepCount((Integer)newValue);
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
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE:
				setConsiderStepSize(CONSIDER_STEP_SIZE_EDEFAULT);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__FIRST_VALUE:
				setFirstValue(FIRST_VALUE_EDEFAULT);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__LAST_VALUE:
				setLastValue(LAST_VALUE_EDEFAULT);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_SIZE:
				setStepSize(STEP_SIZE_EDEFAULT);
				return;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_COUNT:
				setStepCount(STEP_COUNT_EDEFAULT);
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
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE:
				return considerStepSize != CONSIDER_STEP_SIZE_EDEFAULT;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__FIRST_VALUE:
				return firstValue != FIRST_VALUE_EDEFAULT;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__LAST_VALUE:
				return lastValue != LAST_VALUE_EDEFAULT;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_SIZE:
				return stepSize != STEP_SIZE_EDEFAULT;
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE__STEP_COUNT:
				return stepCount != STEP_COUNT_EDEFAULT;
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
		result.append(" (considerStepSize: ");
		result.append(considerStepSize);
		result.append(", firstValue: ");
		result.append(firstValue);
		result.append(", lastValue: ");
		result.append(lastValue);
		result.append(", stepSize: ");
		result.append(stepSize);
		result.append(", stepCount: ");
		result.append(stepCount);
		result.append(')');
		return result.toString();
	}

} //DoubleParameterRangeImpl
