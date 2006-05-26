/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx.impl;

import RegEx.DistributionFunction;
import RegEx.RegExPackage;
import RegEx.TimeConsumption;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Consumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.TimeConsumptionImpl#getFreqency <em>Freqency</em>}</li>
 *   <li>{@link RegEx.impl.TimeConsumptionImpl#getNormal <em>Normal</em>}</li>
 *   <li>{@link RegEx.impl.TimeConsumptionImpl#isHasFrequency <em>Has Frequency</em>}</li>
 *   <li>{@link RegEx.impl.TimeConsumptionImpl#isHasNormal <em>Has Normal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConsumptionImpl extends EObjectImpl implements TimeConsumption {
	/**
	 * The cached value of the '{@link #getFreqency() <em>Freqency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreqency()
	 * @generated
	 * @ordered
	 */
	protected DistributionFunction freqency = null;

	/**
	 * The cached value of the '{@link #getNormal() <em>Normal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormal()
	 * @generated
	 * @ordered
	 */
	protected DistributionFunction normal = null;

	/**
	 * The default value of the '{@link #isHasFrequency() <em>Has Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_FREQUENCY_EDEFAULT= false;

	/**
	 * The cached value of the '{@link #isHasFrequency() <em>Has Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasFrequency()
	 * @generated
	 * @ordered
	 */
	protected boolean hasFrequency = HAS_FREQUENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasNormal() <em>Has Normal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasNormal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_NORMAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasNormal() <em>Has Normal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasNormal()
	 * @generated
	 * @ordered
	 */
	protected boolean hasNormal = HAS_NORMAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConsumptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RegExPackage.Literals.TIME_CONSUMPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionFunction getFreqency() {
		return freqency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFreqency(DistributionFunction newFreqency, NotificationChain msgs) {
		DistributionFunction oldFreqency = freqency;
		freqency = newFreqency;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.TIME_CONSUMPTION__FREQENCY, oldFreqency, newFreqency);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreqency(DistributionFunction newFreqency) {
		if (newFreqency != freqency) {
			NotificationChain msgs = null;
			if (freqency != null)
				msgs = ((InternalEObject)freqency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.TIME_CONSUMPTION__FREQENCY, null, msgs);
			if (newFreqency != null)
				msgs = ((InternalEObject)newFreqency).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.TIME_CONSUMPTION__FREQENCY, null, msgs);
			msgs = basicSetFreqency(newFreqency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.TIME_CONSUMPTION__FREQENCY, newFreqency, newFreqency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionFunction getNormal() {
		return normal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNormal(DistributionFunction newNormal, NotificationChain msgs) {
		DistributionFunction oldNormal = normal;
		normal = newNormal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.TIME_CONSUMPTION__NORMAL, oldNormal, newNormal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormal(DistributionFunction newNormal) {
		if (newNormal != normal) {
			NotificationChain msgs = null;
			if (normal != null)
				msgs = ((InternalEObject)normal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.TIME_CONSUMPTION__NORMAL, null, msgs);
			if (newNormal != null)
				msgs = ((InternalEObject)newNormal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.TIME_CONSUMPTION__NORMAL, null, msgs);
			msgs = basicSetNormal(newNormal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.TIME_CONSUMPTION__NORMAL, newNormal, newNormal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasFrequency() {
		return hasFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasFrequency(boolean newHasFrequency) {
		boolean oldHasFrequency = hasFrequency;
		hasFrequency = newHasFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.TIME_CONSUMPTION__HAS_FREQUENCY, oldHasFrequency, hasFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasNormal() {
		return hasNormal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasNormal(boolean newHasNormal) {
		boolean oldHasNormal = hasNormal;
		hasNormal = newHasNormal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.TIME_CONSUMPTION__HAS_NORMAL, oldHasNormal, hasNormal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DistributionFunction getFreqDF() {
		if (!hasFrequency){
			if (hasNormal){
				setFreqency(normal.getFFT());
				hasFrequency = true;
			}
		}
		return getFreqency();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DistributionFunction getNormDF() {
		if (!hasNormal){
			if (hasFrequency){
				setNormal(freqency.getIFFT());
				hasNormal = true;
			}
		}
		return getNormal();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setNormDF(DistributionFunction normDf) {
		hasFrequency = false;
		hasNormal = true;
		setNormal(normDf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setFreqDF(DistributionFunction freqDf) {
		hasFrequency = true;
		hasNormal = false;
		setFreqency(freqDf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegExPackage.TIME_CONSUMPTION__FREQENCY:
				return basicSetFreqency(null, msgs);
			case RegExPackage.TIME_CONSUMPTION__NORMAL:
				return basicSetNormal(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RegExPackage.TIME_CONSUMPTION__FREQENCY:
				return getFreqency();
			case RegExPackage.TIME_CONSUMPTION__NORMAL:
				return getNormal();
			case RegExPackage.TIME_CONSUMPTION__HAS_FREQUENCY:
				return isHasFrequency() ? Boolean.TRUE : Boolean.FALSE;
			case RegExPackage.TIME_CONSUMPTION__HAS_NORMAL:
				return isHasNormal() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RegExPackage.TIME_CONSUMPTION__FREQENCY:
				setFreqency((DistributionFunction)newValue);
				return;
			case RegExPackage.TIME_CONSUMPTION__NORMAL:
				setNormal((DistributionFunction)newValue);
				return;
			case RegExPackage.TIME_CONSUMPTION__HAS_FREQUENCY:
				setHasFrequency(((Boolean)newValue).booleanValue());
				return;
			case RegExPackage.TIME_CONSUMPTION__HAS_NORMAL:
				setHasNormal(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case RegExPackage.TIME_CONSUMPTION__FREQENCY:
				setFreqency((DistributionFunction)null);
				return;
			case RegExPackage.TIME_CONSUMPTION__NORMAL:
				setNormal((DistributionFunction)null);
				return;
			case RegExPackage.TIME_CONSUMPTION__HAS_FREQUENCY:
				setHasFrequency(HAS_FREQUENCY_EDEFAULT);
				return;
			case RegExPackage.TIME_CONSUMPTION__HAS_NORMAL:
				setHasNormal(HAS_NORMAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RegExPackage.TIME_CONSUMPTION__FREQENCY:
				return freqency != null;
			case RegExPackage.TIME_CONSUMPTION__NORMAL:
				return normal != null;
			case RegExPackage.TIME_CONSUMPTION__HAS_FREQUENCY:
				return hasFrequency != HAS_FREQUENCY_EDEFAULT;
			case RegExPackage.TIME_CONSUMPTION__HAS_NORMAL:
				return hasNormal != HAS_NORMAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hasFrequency: ");
		result.append(hasFrequency);
		result.append(", hasNormal: ");
		result.append(hasNormal);
		result.append(')');
		return result.toString();
	}

} //TimeConsumptionImpl