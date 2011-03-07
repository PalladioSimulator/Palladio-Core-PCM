/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.QuantumTimeSliceConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quantum Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.QuantumTimeSliceConfigurationImpl#getQuanta <em>Quanta</em>}</li>
 *   <li>{@link scheduler.configuration.impl.QuantumTimeSliceConfigurationImpl#getMinQuanta <em>Min Quanta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuantumTimeSliceConfigurationImpl extends TimeSliceConfigurationImpl implements QuantumTimeSliceConfiguration {
	/**
	 * The default value of the '{@link #getQuanta() <em>Quanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuanta()
	 * @generated
	 * @ordered
	 */
	protected static final int QUANTA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getQuanta() <em>Quanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuanta()
	 * @generated
	 * @ordered
	 */
	protected int quanta = QUANTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinQuanta() <em>Min Quanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinQuanta()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_QUANTA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinQuanta() <em>Min Quanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinQuanta()
	 * @generated
	 * @ordered
	 */
	protected int minQuanta = MIN_QUANTA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuantumTimeSliceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.QUANTUM_TIME_SLICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getQuanta() {
		return quanta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuanta(int newQuanta) {
		int oldQuanta = quanta;
		quanta = newQuanta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA, oldQuanta, quanta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinQuanta() {
		return minQuanta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinQuanta(int newMinQuanta) {
		int oldMinQuanta = minQuanta;
		minQuanta = newMinQuanta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA, oldMinQuanta, minQuanta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA:
				return getQuanta();
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA:
				return getMinQuanta();
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
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA:
				setQuanta((Integer)newValue);
				return;
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA:
				setMinQuanta((Integer)newValue);
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
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA:
				setQuanta(QUANTA_EDEFAULT);
				return;
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA:
				setMinQuanta(MIN_QUANTA_EDEFAULT);
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
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__QUANTA:
				return quanta != QUANTA_EDEFAULT;
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION__MIN_QUANTA:
				return minQuanta != MIN_QUANTA_EDEFAULT;
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
		result.append(" (quanta: ");
		result.append(quanta);
		result.append(", minQuanta: ");
		result.append(minQuanta);
		result.append(')');
		return result.toString();
	}

} //QuantumTimeSliceConfigurationImpl
