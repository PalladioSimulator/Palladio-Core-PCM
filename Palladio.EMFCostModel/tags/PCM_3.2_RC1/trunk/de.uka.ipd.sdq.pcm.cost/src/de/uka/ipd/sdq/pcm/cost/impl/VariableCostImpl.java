/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.VariableCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl#getFixedInitialCost <em>Fixed Initial Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl#getFixedOperatingCost <em>Fixed Operating Cost</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VariableCostImpl extends CostImpl implements VariableCost {
	/**
	 * The default value of the '{@link #getFixedInitialCost() <em>Fixed Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedInitialCost()
	 * @generated
	 * @ordered
	 */
	protected static final double FIXED_INITIAL_COST_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFixedInitialCost() <em>Fixed Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedInitialCost()
	 * @generated
	 * @ordered
	 */
	protected double fixedInitialCost = FIXED_INITIAL_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixedOperatingCost() <em>Fixed Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedOperatingCost()
	 * @generated
	 * @ordered
	 */
	protected static final double FIXED_OPERATING_COST_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFixedOperatingCost() <em>Fixed Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedOperatingCost()
	 * @generated
	 * @ordered
	 */
	protected double fixedOperatingCost = FIXED_OPERATING_COST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableCostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.VARIABLE_COST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFixedInitialCost() {
		return fixedInitialCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedInitialCost(double newFixedInitialCost) {
		double oldFixedInitialCost = fixedInitialCost;
		fixedInitialCost = newFixedInitialCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_COST__FIXED_INITIAL_COST, oldFixedInitialCost, fixedInitialCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFixedOperatingCost() {
		return fixedOperatingCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedOperatingCost(double newFixedOperatingCost) {
		double oldFixedOperatingCost = fixedOperatingCost;
		fixedOperatingCost = newFixedOperatingCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_COST__FIXED_OPERATING_COST, oldFixedOperatingCost, fixedOperatingCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.VARIABLE_COST__FIXED_INITIAL_COST:
				return getFixedInitialCost();
			case costPackage.VARIABLE_COST__FIXED_OPERATING_COST:
				return getFixedOperatingCost();
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
			case costPackage.VARIABLE_COST__FIXED_INITIAL_COST:
				setFixedInitialCost((Double)newValue);
				return;
			case costPackage.VARIABLE_COST__FIXED_OPERATING_COST:
				setFixedOperatingCost((Double)newValue);
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
			case costPackage.VARIABLE_COST__FIXED_INITIAL_COST:
				setFixedInitialCost(FIXED_INITIAL_COST_EDEFAULT);
				return;
			case costPackage.VARIABLE_COST__FIXED_OPERATING_COST:
				setFixedOperatingCost(FIXED_OPERATING_COST_EDEFAULT);
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
			case costPackage.VARIABLE_COST__FIXED_INITIAL_COST:
				return fixedInitialCost != FIXED_INITIAL_COST_EDEFAULT;
			case costPackage.VARIABLE_COST__FIXED_OPERATING_COST:
				return fixedOperatingCost != FIXED_OPERATING_COST_EDEFAULT;
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
		result.append(" (fixedInitialCost: ");
		result.append(fixedInitialCost);
		result.append(", fixedOperatingCost: ");
		result.append(fixedOperatingCost);
		result.append(')');
		return result.toString();
	}

} //VariableCostImpl
