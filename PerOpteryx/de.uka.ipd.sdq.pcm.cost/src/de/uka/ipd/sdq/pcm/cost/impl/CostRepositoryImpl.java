/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cost Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl#getCost <em>Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl#getTimePeriodYears <em>Time Period Years</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl#getInterest <em>Interest</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CostRepositoryImpl extends EObjectImpl implements CostRepository {
	/**
	 * The cached value of the '{@link #getCost() <em>Cost</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected EList<Cost> cost;

	/**
	 * The default value of the '{@link #getTimePeriodYears() <em>Time Period Years</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePeriodYears()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_PERIOD_YEARS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimePeriodYears() <em>Time Period Years</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePeriodYears()
	 * @generated
	 * @ordered
	 */
	protected int timePeriodYears = TIME_PERIOD_YEARS_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterest() <em>Interest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterest()
	 * @generated
	 * @ordered
	 */
	protected static final double INTEREST_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getInterest() <em>Interest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterest()
	 * @generated
	 * @ordered
	 */
	protected double interest = INTEREST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CostRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.COST_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cost> getCost() {
		if (cost == null) {
			cost = new EObjectContainmentEList<Cost>(Cost.class, this, costPackage.COST_REPOSITORY__COST);
		}
		return cost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimePeriodYears() {
		return timePeriodYears;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimePeriodYears(int newTimePeriodYears) {
		int oldTimePeriodYears = timePeriodYears;
		timePeriodYears = newTimePeriodYears;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.COST_REPOSITORY__TIME_PERIOD_YEARS, oldTimePeriodYears, timePeriodYears));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterest(double newInterest) {
		double oldInterest = interest;
		interest = newInterest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.COST_REPOSITORY__INTEREST, oldInterest, interest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case costPackage.COST_REPOSITORY__COST:
				return ((InternalEList<?>)getCost()).basicRemove(otherEnd, msgs);
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
			case costPackage.COST_REPOSITORY__COST:
				return getCost();
			case costPackage.COST_REPOSITORY__TIME_PERIOD_YEARS:
				return getTimePeriodYears();
			case costPackage.COST_REPOSITORY__INTEREST:
				return getInterest();
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
			case costPackage.COST_REPOSITORY__COST:
				getCost().clear();
				getCost().addAll((Collection<? extends Cost>)newValue);
				return;
			case costPackage.COST_REPOSITORY__TIME_PERIOD_YEARS:
				setTimePeriodYears((Integer)newValue);
				return;
			case costPackage.COST_REPOSITORY__INTEREST:
				setInterest((Double)newValue);
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
			case costPackage.COST_REPOSITORY__COST:
				getCost().clear();
				return;
			case costPackage.COST_REPOSITORY__TIME_PERIOD_YEARS:
				setTimePeriodYears(TIME_PERIOD_YEARS_EDEFAULT);
				return;
			case costPackage.COST_REPOSITORY__INTEREST:
				setInterest(INTEREST_EDEFAULT);
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
			case costPackage.COST_REPOSITORY__COST:
				return cost != null && !cost.isEmpty();
			case costPackage.COST_REPOSITORY__TIME_PERIOD_YEARS:
				return timePeriodYears != TIME_PERIOD_YEARS_EDEFAULT;
			case costPackage.COST_REPOSITORY__INTEREST:
				return interest != INTEREST_EDEFAULT;
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
		result.append(" (timePeriodYears: ");
		result.append(timePeriodYears);
		result.append(", interest: ");
		result.append(interest);
		result.append(')');
		return result.toString();
	}

} //CostRepositoryImpl
