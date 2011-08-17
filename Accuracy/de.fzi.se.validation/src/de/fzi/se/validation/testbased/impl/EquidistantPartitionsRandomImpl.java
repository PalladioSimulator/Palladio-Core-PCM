/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.impl;

import de.fzi.se.validation.testbased.EquidistantPartitionsRandom;
import de.fzi.se.validation.testbased.TestbasedPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equidistant Partitions Random</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.impl.EquidistantPartitionsRandomImpl#getNumberPartitions <em>Number Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquidistantPartitionsRandomImpl extends TestcaseGenerationStrategyImpl implements EquidistantPartitionsRandom {
	/**
	 * The default value of the '{@link #getNumberPartitions() <em>Number Partitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberPartitions()
	 * @generated
	 * @ordered
	 */
	protected static final long NUMBER_PARTITIONS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getNumberPartitions() <em>Number Partitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberPartitions()
	 * @generated
	 * @ordered
	 */
	protected long numberPartitions = NUMBER_PARTITIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquidistantPartitionsRandomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbasedPackage.Literals.EQUIDISTANT_PARTITIONS_RANDOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getNumberPartitions() {
		return numberPartitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberPartitions(long newNumberPartitions) {
		long oldNumberPartitions = numberPartitions;
		numberPartitions = newNumberPartitions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbasedPackage.EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS, oldNumberPartitions, numberPartitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbasedPackage.EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS:
				return getNumberPartitions();
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
			case TestbasedPackage.EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS:
				setNumberPartitions((Long)newValue);
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
			case TestbasedPackage.EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS:
				setNumberPartitions(NUMBER_PARTITIONS_EDEFAULT);
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
			case TestbasedPackage.EQUIDISTANT_PARTITIONS_RANDOM__NUMBER_PARTITIONS:
				return numberPartitions != NUMBER_PARTITIONS_EDEFAULT;
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
		result.append(" (numberPartitions: ");
		result.append(numberPartitions);
		result.append(')');
		return result.toString();
	}

} //EquidistantPartitionsRandomImpl
